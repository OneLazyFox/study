package guava.web.controller;

import guava.entity.Area;
import guava.json.JsonResult;
import guava.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/15.
 *
 * @author 张小虎
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/cache/test")
public class CacheTestController {

    @Autowired
    private AreaService areaService;

    /**
     * 根据AreaId获得一个Area
     * @param areaId AreaId
     */
    @RequestMapping("/getArea")
    public JsonResult getArea(Integer areaId) {
        JsonResult result = new JsonResult();
        Area area = areaService.getAreaById(areaId);
        result.setData(area);
        return result;
    }

}
