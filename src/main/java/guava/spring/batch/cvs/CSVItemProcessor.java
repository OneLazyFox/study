package guava.spring.batch.cvs;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/6/3.
 *
 * @author 张小虎
 * @version 1.0
 */

@Component("csvItemProcessor")
public class CSVItemProcessor implements ItemProcessor<Student, Student> {
    @Override
    public Student process(Student student) throws Exception {
        student.setName(student.getID() + "--" + student.getName());
        student.setAge(student.getAge() + 2);
        student.setScore(student.getScore() + 10);
        return student;
    }
}
