package guava.json;

import java.util.Map;

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
public class PageParams<T> {

    private int pageNo = 1;
    private int pageSize = 10;
    private Map<String,Object> params;

    public int getStartPos() {
        return (pageNo-1)*pageSize + 1;
    }

    public int getEndPos() {
        return getStartPos() + pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
