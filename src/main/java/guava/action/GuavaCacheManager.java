package guava.action;

import com.google.common.cache.CacheStats;
import guava.json.PageParams;
import guava.json.PageResult;
import guava.cache.guava.GuavaAbstractLoadingCache;
import guava.util.SpringContextUtil;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/11.
 * Guava缓存监视与管理工具
 * @author 张小虎
 * @version 1.0
 */
public class GuavaCacheManager {
    // 保存一个Map cacheName-->cacheObject 以便根据cacheName获取Guava Cache对象
    private static Map<String, ? extends GuavaAbstractLoadingCache<Object,Object>> cacheNameToObjectMap = null;

    @SuppressWarnings("unchecked")
    private static Map<String, ? extends GuavaAbstractLoadingCache<Object,Object>> getCacheMap() {
        if (cacheNameToObjectMap == null) {
            cacheNameToObjectMap = (Map<String, ? extends GuavaAbstractLoadingCache<Object, Object>>)
                    SpringContextUtil.getBeanByType(GuavaAbstractLoadingCache.class);
        }
        return cacheNameToObjectMap;
    }

    /**
     * 根据cacheName获取cache对象
     */
    private static GuavaAbstractLoadingCache<Object,Object> getCacheByName(String cacheName) {
        return getCacheMap().get(cacheName);
    }

    /**
     * 获取所有缓存的名字(即缓存实现类的名称)
     */
    public static Set<String> getCacheNames() {
        return getCacheMap().keySet();
    }

    /**
     * 返回所有缓存的统计数据
     * @return List<Map<统计指标，统计数据>>
     */
    public static ArrayList<Map<String,Object>> getAllCacheStats() {
        Map<String, ? extends Object> cacheMap = getCacheMap();
        List<String> cacheNameList = new ArrayList<String>(cacheMap.keySet());
        Collections.sort(cacheNameList); //按字母表排序

        ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for (String cacheName :
                cacheNameList) {
            list.add(getCacheStatusToMap(cacheName));
        }
        return list;
    }

    /**
     * 返回一个缓存的统计数据
     * @return Map<统计指标,统计数据>
     */
    private static Map<String, Object> getCacheStatusToMap(String cacheName) {
        Map<String,Object> map = new LinkedHashMap<String, Object>();
        GuavaAbstractLoadingCache<Object,Object> cache = getCacheByName(cacheName);
        CacheStats stats = cache.getCache().stats();
        NumberFormat percent = NumberFormat.getPercentInstance(); // 建立百分比格式化用
        percent.setMaximumFractionDigits(1); // 百分比小数点后的位数
        map.put("cacheName",cacheName);
        map.put("size",cache.getCache().size());
        map.put("maximumSize",cache.getMaximumSize());
        map.put("survivalDuration", cache.getExpireAfterWriteDuration());
        map.put("hitCount", stats.hitCount());
        map.put("hitRate", percent.format(stats.hitRate()));
        map.put("missCount", stats.missCount());
        map.put("missRate", percent.format(stats.missRate()));
        map.put("loadSuccessCount", stats.loadSuccessCount());
        map.put("loadExceptionCount", stats.loadExceptionCount());
        map.put("totalLoadTime", stats.totalLoadTime()/1000000);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (cache.getResetTime() != null) {
            map.put("resetTime",dateFormat.format(cache.getResetTime()));
        }
        map.put("highestSize", cache.getHighestSize());

        if (cache.getHighestTime() != null) {
            map.put("highestTime", dateFormat.format(cache.getHighestTime()));
        }
        return map;
    }

    /**
     * 根据cacheName清除缓存数据
     */
    public static void resetCache(String cacheName) {
        GuavaAbstractLoadingCache<Object,Object> cache = getCacheByName(cacheName);
        cache.getCache().invalidateAll();
        cache.setResetTime(new Date());
    }

    /**
     * 分页获取缓存中的数据
     */
    public static PageResult<Object> queryDataByPage(PageParams<Object> pageParams) {
        PageResult<Object> data = new PageResult<Object>(pageParams);

        GuavaAbstractLoadingCache<Object,Object> cache = getCacheByName((String) pageParams.getParams().get("cacheName"));
        ConcurrentMap<Object,Object> cacheMap = cache.getCache().asMap();
        data.setTotalRecord(cacheMap.size());
        data.setTotalPage((cacheMap.size()-1)/pageParams.getPageSize() + 1);

        //遍历
        Iterator<Map.Entry<Object,Object>> entries = cacheMap.entrySet().iterator();
        int startPos = pageParams.getStartPos() - 1;
        int endPos = pageParams.getEndPos() - 1;
        int i = 0;
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        Map<Object,Object> resultMap = new LinkedHashMap<Object,Object>();
        while (entries.hasNext()) {
            Map.Entry<Object,Object> entry = entries.next();
            if (i > endPos) {
                break;
            }
            if (i >= startPos) {
                resultMap.put(entry.getKey(),entry.getValue());
            }
            i++;
        }
        List<Object> resultList = new ArrayList<Object>();
        //noinspection CollectionAddedToSelf
        resultList.add(resultList);
        data.setResults(resultList);
        return data;
    }

}
