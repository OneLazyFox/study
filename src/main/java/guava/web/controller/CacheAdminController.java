package guava.web.controller;

import guava.action.GuavaCacheManager;
import com.neco.json.JsonResult;
import com.neco.json.PageParams;
import com.neco.json.PageResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/15.
 * 本地缓存管理接口：统计信息查询、重置数据……等
 * @author 张小虎
 * @version 1.0
 */

@RestController
@RequestMapping("/cache/admin")
public class CacheAdminController {

    /**
     * 查询Cache统计信息
     * @param cacheName 缓存名
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public JsonResult cacheStats(String cacheName) {
        JsonResult jsonResult = new JsonResult();
        switch (cacheName) {
            case "*":
                jsonResult.setData(GuavaCacheManager.getAllCacheStats());
                jsonResult.setMessage("成功获取了所有cache!");
                break;

                default:
                    break;
        }
        return jsonResult;
    }

    /**
     * 清空缓存数据、并返回清空后的统计信息
     * @param cacheName 缓存名
     */
    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public JsonResult cacheReset(String cacheName) {
        JsonResult jsonResult = new JsonResult();

        GuavaCacheManager.resetCache(cacheName);
        jsonResult.setMessage("已经成功重置了" + cacheName + "!");
        return jsonResult;
    }

    /**
     * 返回所有的本地缓存统计信息
     */
    @RequestMapping(value = "/stats/all", method = RequestMethod.POST)
    public JsonResult cacheStatsAll() {
        return cacheStats("*");
    }

    /**
     * 分页查询数据详情
     * @param params pageSize,pageNo,cacheName
     */
    @RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
    public PageResult<Object> queryDataByPage(@RequestParam Map<String,String> params) {
        int pageSize = Integer.valueOf(params.get("pageSize"));
        int pageNo = Integer.valueOf(params.get("pageNo"));
        String cacheName = params.get("cacheName");

        PageParams<Object> page = new PageParams<>();
        page.setPageSize(pageSize);
        page.setPageNo(pageNo);
        Map<String,Object> param = new HashMap<>();
        param.put("cacheName",cacheName);
        page.setParams(param);
        return GuavaCacheManager.queryDataByPage(page);
    }
}
