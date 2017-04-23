package guava.cache.local.impl;

import guava.dao.AreaDao;
import guava.entity.Area;
import guava.cache.guava.GuavaAbstractLoadingCache;
import guava.cache.local.ILoadCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/9.
 *
 * @author 张小虎
 * @version 1.0
 */
@Component("localAreaCache")
public class LCAreaIdToArea extends GuavaAbstractLoadingCache<Integer,Area> implements ILoadCache<Integer,Area> {

    @Autowired
    private AreaDao areaDao;

    private LCAreaIdToArea() {
        setMaximumSize(3000);
    }
    public Area get(Integer key) {
        try {
            return getValue(key);
        } catch (ExecutionException e) {
            logger.error("无法根据areaId={}获取Area，可能是数据库中无该记录。", key ,e);
            return null;
        }
    }

    /**
     * 从数据库中取数据
     */
    protected Area fetchData(Integer key) {
        logger.debug("测试：正在从数据库中获取area，area id={}", key);
        //测试用，实际中使用AreaDao从DB中取数据
        /*Area a = new Area();
        a.setCode(key);
        a.setId(key);
        a.setName("地区"+key);
        a.setParentCode(Integer.valueOf(key.toString().substring(0,key.toString().length()-3)));
        a.setPinyin("pinyin" + key);*/
        return areaDao.selectAllArea();
    }
}
