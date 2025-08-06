package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;

@GwtCompatible
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    public abstract Map.Entry<K, V> delegate();

    public boolean equals(Object obj) {
        return delegate().equals(obj);
    }

    public K getKey() {
        return delegate().getKey();
    }

    public V getValue() {
        return delegate().getValue();
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    public V setValue(V v11) {
        return delegate().setValue(v11);
    }

    public boolean standardEquals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!Objects.equal(getKey(), entry.getKey()) || !Objects.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public int standardHashCode() {
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

    @Beta
    public String standardToString() {
        return getKey() + ContainerUtils.KEY_VALUE_DELIMITER + getValue();
    }
}
