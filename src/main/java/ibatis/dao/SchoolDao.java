package ibatis.dao;

import com.neco.pojo.School;

import java.util.List;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/2.
 *
 * @author 张小虎
 * @version 1.0
 */
public interface SchoolDao {
    public List<School> selectSchools();
    public List<School> selectSchoolsByName(String name);
    public void insertSchool(School school);
}
