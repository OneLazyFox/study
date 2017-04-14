package guava.dao;

import guava.annotation.DbTest;
import guava.entity.Person;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/4/12.
 *
 * @author 张小虎
 * @version 1.0
 */
@DbTest
public interface PersonDao {
    public int insertPerson(Person person);

    public Person selectPersonForUpdate(int id);

    public int updatePersonById(Person person, int id);

    public int updatePersonByPhoneNo(Person person);
}
