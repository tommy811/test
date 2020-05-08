package org.coderead.cache;

public interface Cache {
    void putObject(Object key, Object value);

    Object getObject(Object key);
}
