package guava.service.impl;

import guava.entity.Area;
import guava.cache.local.impl.LCAreaIdToArea;
import guava.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private LCAreaIdToArea localAreaCache;

    /**
     * 根据AreaId获取Area
     * @param areaId int
     * @return Area
     */
    public Area getAreaById(int areaId) {
        return localAreaCache.get(areaId);
    }
}
