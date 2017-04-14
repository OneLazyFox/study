package guava.dao;

import guava.annotation.SqlServerDb;
import guava.entity.SqlServerTb;
import org.apache.ibatis.annotations.Select;

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
@SqlServerDb
public interface SqlServerDao {

    @Select("cVCRID,cVTYPE,cVCRETR from _tpVSA where cVCRID=#{id}")
    public SqlServerTb selectSample(String id);
}
