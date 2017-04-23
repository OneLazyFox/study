package guava.dao;

import guava.annotation.DbTest;
import guava.entity.Area;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/22.
 *
 * @author 张小虎
 * @version 1.0
 */
@DbTest
public interface AreaDao {
    public Area selectAllArea();
}
