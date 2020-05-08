package org.coderead.cache;

/**
 * 缓存存储接口
 */
public interface ICacheStore {
    void save(Object key, Object value);

    Object get(Object key);
}
