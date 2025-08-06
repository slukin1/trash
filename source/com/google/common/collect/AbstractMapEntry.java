package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;

@GwtCompatible
abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public abstract K getKey();

    public abstract V getValue();

    public int hashCode() {
        int i11;
        Object key = getKey();
        Object value = getValue();
        int i12 = 0;
        if (key == null) {
            i11 = 0;
        } else {
            i11 = key.hashCode();
        }
        if (value != null) {
            i12 = value.hashCode();
        }
        return i11 ^ i12;
    }

    public V setValue(V v11) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }
}
