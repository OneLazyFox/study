package ibatis.dao.impl;

import ibatis.dao.BaseDao;
import ibatis.dao.SchoolDao;
import com.neco.pojo.School;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
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

@Repository
public class SchoolDaoImpl extends BaseDao implements SchoolDao {
    public List<School> selectSchools() {
        List<School> schools = new ArrayList<School>();
        try {
            schools = sqlMapClient.queryForList("selectAllSchools", School.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schools;
    }

    public List<School> selectSchoolsByName(String name) {
        List<School> schools = new ArrayList<School>();
        try {
            schools = sqlMapClient.queryForList("selectSchoolByName",name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schools;
    }

    public void insertSchool(School school) {
        try {
            sqlMapClient.insert("addSchool",school);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SchoolDaoImpl impl = new SchoolDaoImpl();
        List<School> schools = impl.selectSchoolsByName("%山东%");
        System.out.println(schools.toString());
    }
}
