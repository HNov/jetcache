/**
 * Created on  13-09-04
 */
package com.taobao.geek.jetcache;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:yeli.hl@taobao.com">huangli</a>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cached {
    String area() default CacheConfig.DEFAULT_AREA;
    boolean enabled() default CacheConfig.DEFAULT_ENABLED;
    int expire() default CacheConfig.DEFAULT_EXPIRE;
    CacheType cacheType() default CacheType.REMOTE;
    int localLimit() default CacheConfig.DEFAULT_LOCAL_LIMIT;
    int version() default CacheConfig.DEFAULT_VERSION;
    boolean cacheNullValue() default CacheConfig.DEFAULT_CACHE_NULL_VALUE;

    /**
     * Expression attribute used for conditioning the method caching.
     * <p>Default is "", meaning the method is always cached.
     */
    String condition() default CacheConfig.DEFAULT_CONDITION;

    /**
     * Expression attribute used to veto method caching.
     * <p>Unlike {@link #condition()}, this expression is evaluated after the method
     * has been called and can therefore refer to the {@code result}. Default is "",
     * meaning that caching is never vetoed.
     */
    String unless() default CacheConfig.DEFAULT_UNLESS;
}
