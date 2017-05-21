package guava.cache.spring;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/20.
 *
 * @author 张小虎
 * @version 1.0
 */
public class LocalCacheManager extends AbstractCacheManager {

    private Collection<? extends LocalCache> caches;

    public void setCaches(Collection<? extends LocalCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }
}
