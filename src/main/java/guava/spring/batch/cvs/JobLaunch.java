package guava.spring.batch.cvs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class JobLaunch {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("guava/spring/batch/csv/batch.xml");
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("csvJob");
        try {
            JobExecution result = launcher.run(job, new JobParameters());
            System.out.println(result.toString());
        } catch (JobExecutionAlreadyRunningException | JobRestartException | JobParametersInvalidException | JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext)context).close();
        }
    }
}
