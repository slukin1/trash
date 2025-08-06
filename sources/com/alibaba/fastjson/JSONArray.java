package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray extends JSON implements List<Object>, Cloneable, RandomAccess, Serializable {
    private static final long serialVersionUID = 1;
    public transient Type componentType;
    private final List<Object> list;
    public transient Object relatedArray;

    public JSONArray() {
        this.list = new ArrayList();
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    public void clear() {
        this.list.clear();
    }

    public Object clone() {
        return new JSONArray((List<Object>) new ArrayList(this.list));
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public JSONArray fluentAdd(Object obj) {
        this.list.add(obj);
        return this;
    }

    public JSONArray fluentAddAll(Collection<? extends Object> collection) {
        this.list.addAll(collection);
        return this;
    }

    public JSONArray fluentClear() {
        this.list.clear();
        return this;
    }

    public JSONArray fluentRemove(Object obj) {
        this.list.remove(obj);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection<?> collection) {
        this.list.removeAll(collection);
        return this;
    }

    public JSONArray fluentRetainAll(Collection<?> collection) {
        this.list.retainAll(collection);
        return this;
    }

    public JSONArray fluentSet(int i11, Object obj) {
        set(i11, obj);
        return this;
    }

    public Object get(int i11) {
        return this.list.get(i11);
    }

    public BigDecimal getBigDecimal(int i11) {
        return TypeUtils.g(get(i11));
    }

    public BigInteger getBigInteger(int i11) {
        return TypeUtils.h(get(i11));
    }

    public Boolean getBoolean(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return null;
        }
        return TypeUtils.i(obj);
    }

    public boolean getBooleanValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return false;
        }
        return TypeUtils.i(obj).booleanValue();
    }

    public Byte getByte(int i11) {
        return TypeUtils.j(get(i11));
    }

    public byte getByteValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.j(obj).byteValue();
    }

    public Type getComponentType() {
        return this.componentType;
    }

    public Date getDate(int i11) {
        return TypeUtils.m(get(i11));
    }

    public Double getDouble(int i11) {
        return TypeUtils.n(get(i11));
    }

    public double getDoubleValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return 0.0d;
        }
        return TypeUtils.n(obj).doubleValue();
    }

    public Float getFloat(int i11) {
        return TypeUtils.p(get(i11));
    }

    public float getFloatValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return 0.0f;
        }
        return TypeUtils.p(obj).floatValue();
    }

    public int getIntValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.q(obj).intValue();
    }

    public Integer getInteger(int i11) {
        return TypeUtils.q(get(i11));
    }

    public JSONArray getJSONArray(int i11) {
        Object obj = this.list.get(i11);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(int i11) {
        Object obj = this.list.get(i11);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(int i11) {
        return TypeUtils.t(get(i11));
    }

    public long getLongValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.t(obj).longValue();
    }

    public <T> T getObject(int i11, Class<T> cls) {
        return TypeUtils.r(this.list.get(i11), cls);
    }

    public Object getRelatedArray() {
        return this.relatedArray;
    }

    public Short getShort(int i11) {
        return TypeUtils.u(get(i11));
    }

    public short getShortValue(int i11) {
        Object obj = get(i11);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.u(obj).shortValue();
    }

    public java.sql.Date getSqlDate(int i11) {
        return TypeUtils.v(get(i11));
    }

    public String getString(int i11) {
        return TypeUtils.w(get(i11));
    }

    public Timestamp getTimestamp(int i11) {
        return TypeUtils.x(get(i11));
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public Object set(int i11, Object obj) {
        if (i11 == -1) {
            this.list.add(obj);
            return null;
        } else if (this.list.size() > i11) {
            return this.list.set(i11, obj);
        } else {
            for (int size = this.list.size(); size < i11; size++) {
                this.list.add((Object) null);
            }
            this.list.add(obj);
            return null;
        }
    }

    public void setComponentType(Type type) {
        this.componentType = type;
    }

    public void setRelatedArray(Object obj) {
        this.relatedArray = obj;
    }

    public int size() {
        return this.list.size();
    }

    public List<Object> subList(int i11, int i12) {
        return this.list.subList(i11, i12);
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> List<T> toJavaList(Class<T> cls) {
        ArrayList arrayList = new ArrayList(size());
        ParserConfig m11 = ParserConfig.m();
        Iterator<Object> it2 = iterator();
        while (it2.hasNext()) {
            arrayList.add(TypeUtils.d(it2.next(), cls, m11));
        }
        return arrayList;
    }

    public void add(int i11, Object obj) {
        this.list.add(i11, obj);
    }

    public boolean addAll(int i11, Collection<? extends Object> collection) {
        return this.list.addAll(i11, collection);
    }

    public JSONArray fluentAdd(int i11, Object obj) {
        this.list.add(i11, obj);
        return this;
    }

    public JSONArray fluentAddAll(int i11, Collection<? extends Object> collection) {
        this.list.addAll(i11, collection);
        return this;
    }

    public JSONArray fluentRemove(int i11) {
        this.list.remove(i11);
        return this;
    }

    public ListIterator<Object> listIterator(int i11) {
        return this.list.listIterator(i11);
    }

    public Object remove(int i11) {
        return this.list.remove(i11);
    }

    public <T> T[] toArray(T[] tArr) {
        return this.list.toArray(tArr);
    }

    public JSONArray(List<Object> list2) {
        this.list = list2;
    }

    public JSONArray(int i11) {
        this.list = new ArrayList(i11);
    }
}
