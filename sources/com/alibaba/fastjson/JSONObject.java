package com.alibaba.fastjson;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import d2.b;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class JSONObject extends JSON implements Map<String, Object>, Cloneable, Serializable, InvocationHandler {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long serialVersionUID = 1;
    private final Map<String, Object> map;

    public JSONObject() {
        this(16, false);
    }

    public void clear() {
        this.map.clear();
    }

    public Object clone() {
        return new JSONObject((Map<String, Object>) this.map instanceof LinkedHashMap ? new LinkedHashMap(this.map) : new HashMap(this.map));
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return this.map.entrySet();
    }

    public boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public JSONObject fluentClear() {
        this.map.clear();
        return this;
    }

    public JSONObject fluentPut(String str, Object obj) {
        this.map.put(str, obj);
        return this;
    }

    public JSONObject fluentPutAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
        return this;
    }

    public JSONObject fluentRemove(Object obj) {
        this.map.remove(obj);
        return this;
    }

    public Object get(Object obj) {
        return this.map.get(obj);
    }

    public BigDecimal getBigDecimal(String str) {
        return TypeUtils.g(get(str));
    }

    public BigInteger getBigInteger(String str) {
        return TypeUtils.h(get(str));
    }

    public Boolean getBoolean(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.i(obj);
    }

    public boolean getBooleanValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return false;
        }
        return TypeUtils.i(obj).booleanValue();
    }

    public Byte getByte(String str) {
        return TypeUtils.j(get(str));
    }

    public byte getByteValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.j(obj).byteValue();
    }

    public byte[] getBytes(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return TypeUtils.k(obj);
    }

    public Date getDate(String str) {
        return TypeUtils.m(get(str));
    }

    public Double getDouble(String str) {
        return TypeUtils.n(get(str));
    }

    public double getDoubleValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0d;
        }
        return TypeUtils.n(obj).doubleValue();
    }

    public Float getFloat(String str) {
        return TypeUtils.p(get(str));
    }

    public float getFloatValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0.0f;
        }
        return TypeUtils.p(obj).floatValue();
    }

    public int getIntValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.q(obj).intValue();
    }

    public Integer getInteger(String str) {
        return TypeUtils.q(get(str));
    }

    public JSONArray getJSONArray(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        if (obj instanceof String) {
            return (JSONArray) JSON.parse((String) obj);
        }
        return (JSONArray) JSON.toJSON(obj);
    }

    public JSONObject getJSONObject(String str) {
        Object obj = this.map.get(str);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        if (obj instanceof String) {
            return JSON.parseObject((String) obj);
        }
        return (JSONObject) JSON.toJSON(obj);
    }

    public Long getLong(String str) {
        return TypeUtils.t(get(str));
    }

    public long getLongValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.t(obj).longValue();
    }

    public <T> T getObject(String str, Class<T> cls) {
        return TypeUtils.r(this.map.get(str), cls);
    }

    public Short getShort(String str) {
        return TypeUtils.u(get(str));
    }

    public short getShortValue(String str) {
        Object obj = get(str);
        if (obj == null) {
            return 0;
        }
        return TypeUtils.u(obj).shortValue();
    }

    public java.sql.Date getSqlDate(String str) {
        return TypeUtils.v(get(str));
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public Timestamp getTimestamp(String str) {
        return TypeUtils.x(get(str));
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Class[] parameterTypes = method.getParameterTypes();
        String str = null;
        if (parameterTypes.length == 1) {
            if (method.getName().equals("equals")) {
                return Boolean.valueOf(equals(objArr[0]));
            }
            if (method.getReturnType() == Void.TYPE) {
                b bVar = (b) method.getAnnotation(b.class);
                String name = (bVar == null || bVar.name().length() == 0) ? null : bVar.name();
                if (name == null) {
                    String name2 = method.getName();
                    if (name2.startsWith("set")) {
                        String substring = name2.substring(3);
                        if (substring.length() != 0) {
                            name = Character.toLowerCase(substring.charAt(0)) + substring.substring(1);
                        } else {
                            throw new JSONException("illegal setter");
                        }
                    } else {
                        throw new JSONException("illegal setter");
                    }
                }
                this.map.put(name, objArr[0]);
                return null;
            }
            throw new JSONException("illegal setter");
        } else if (parameterTypes.length != 0) {
            throw new UnsupportedOperationException(method.toGenericString());
        } else if (method.getReturnType() != Void.TYPE) {
            b bVar2 = (b) method.getAnnotation(b.class);
            if (!(bVar2 == null || bVar2.name().length() == 0)) {
                str = bVar2.name();
            }
            if (str == null) {
                String name3 = method.getName();
                if (name3.startsWith("get")) {
                    String substring2 = name3.substring(3);
                    if (substring2.length() != 0) {
                        str = Character.toLowerCase(substring2.charAt(0)) + substring2.substring(1);
                    } else {
                        throw new JSONException("illegal getter");
                    }
                } else if (name3.startsWith("is")) {
                    String substring3 = name3.substring(2);
                    if (substring3.length() != 0) {
                        str = Character.toLowerCase(substring3.charAt(0)) + substring3.substring(1);
                    } else {
                        throw new JSONException("illegal getter");
                    }
                } else if (name3.startsWith("hashCode")) {
                    return Integer.valueOf(hashCode());
                } else {
                    if (name3.startsWith("toString")) {
                        return toString();
                    }
                    throw new JSONException("illegal getter");
                }
            }
            return TypeUtils.f(this.map.get(str), method.getGenericReturnType(), ParserConfig.m());
        } else {
            throw new JSONException("illegal getter");
        }
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<String> keySet() {
        return this.map.keySet();
    }

    public void putAll(Map<? extends String, ? extends Object> map2) {
        this.map.putAll(map2);
    }

    public Object remove(Object obj) {
        return this.map.remove(obj);
    }

    public int size() {
        return this.map.size();
    }

    public Collection<Object> values() {
        return this.map.values();
    }

    public JSONObject(Map<String, Object> map2) {
        this.map = map2;
    }

    public Object put(String str, Object obj) {
        return this.map.put(str, obj);
    }

    public <T> T getObject(String str, Type type) {
        return TypeUtils.f(this.map.get(str), type, ParserConfig.m());
    }

    public JSONObject(boolean z11) {
        this(16, z11);
    }

    public JSONObject(int i11) {
        this(i11, false);
    }

    public <T> T getObject(String str, e eVar) {
        T t11 = this.map.get(str);
        if (eVar == null) {
            return t11;
        }
        return TypeUtils.f(t11, eVar.a(), ParserConfig.m());
    }

    public JSONObject(int i11, boolean z11) {
        if (z11) {
            this.map = new LinkedHashMap(i11);
        } else {
            this.map = new HashMap(i11);
        }
    }
}
