package guava.service;

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
public interface PersonService {

    /**
     * 新增一个Person
     * @return 成功或是失败
     */
    public boolean addPerson(Person person);

    public boolean updatePersonByPhoneNo(Person person);
}
