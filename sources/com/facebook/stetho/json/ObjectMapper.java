package com.facebook.stetho.json;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.json.annotation.JsonProperty;
import com.facebook.stetho.json.annotation.JsonValue;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ObjectMapper {
    private final Map<Class<?>, Method> mJsonValueMethodCache = new IdentityHashMap();

    private <T> T _convertFromJSONObject(JSONObject jSONObject, Class<T> cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, JSONException {
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor((Class[]) null);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                Object valueForField = getValueForField(field, jSONObject.opt(field.getName()));
                try {
                    field.set(newInstance, valueForField);
                } catch (IllegalArgumentException e11) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Class: ");
                    sb2.append(cls.getSimpleName());
                    sb2.append(" Field: ");
                    sb2.append(field.getName());
                    sb2.append(" type ");
                    sb2.append(valueForField != null ? valueForField.getClass().getName() : OptionsBridge.NULL_VALUE);
                    throw new IllegalArgumentException(sb2.toString(), e11);
                }
            }
        }
        return newInstance;
    }

    private JSONObject _convertToJSONObject(Object obj) throws JSONException, InvocationTargetException, IllegalAccessException {
        JsonProperty jsonProperty;
        JSONObject jSONObject = new JSONObject();
        Field[] fields = obj.getClass().getFields();
        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers()) && (jsonProperty = (JsonProperty) field.getAnnotation(JsonProperty.class)) != null) {
                Object obj2 = field.get(obj);
                Class<?> type = field.getType();
                if (obj2 != null) {
                    type = obj2.getClass();
                }
                String name = field.getName();
                if (jsonProperty.required() && obj2 == null) {
                    obj2 = JSONObject.NULL;
                } else if (obj2 != JSONObject.NULL) {
                    obj2 = getJsonValue(obj2, type, field);
                }
                jSONObject.put(name, obj2);
            }
        }
        return jSONObject;
    }

    private static boolean canDirectlySerializeClass(Class cls) {
        return isWrapperOrPrimitiveType(cls) || cls.equals(String.class);
    }

    private List<Object> convertArrayToList(Field field, JSONArray jSONArray) throws IllegalAccessException, JSONException {
        if (List.class.isAssignableFrom(field.getType())) {
            Type[] actualTypeArguments = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
            if (actualTypeArguments.length == 1) {
                Class cls = (Class) actualTypeArguments[0];
                ArrayList arrayList = new ArrayList();
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    if (cls.isEnum()) {
                        arrayList.add(getEnumValue(jSONArray.getString(i11), cls));
                    } else if (canDirectlySerializeClass(cls)) {
                        arrayList.add(jSONArray.get(i11));
                    } else {
                        JSONObject jSONObject = jSONArray.getJSONObject(i11);
                        if (jSONObject == null) {
                            arrayList.add((Object) null);
                        } else {
                            arrayList.add(convertValue(jSONObject, cls));
                        }
                    }
                }
                return arrayList;
            }
            throw new IllegalArgumentException("Only able to handle a single type in a list " + field.getName());
        }
        throw new IllegalArgumentException("only know how to deserialize List<?> on field " + field.getName());
    }

    private JSONArray convertListToJsonArray(Object obj) throws InvocationTargetException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Object next : (List) obj) {
            Object obj2 = null;
            if (next != null) {
                obj2 = getJsonValue(next, next.getClass(), (Field) null);
            }
            jSONArray.put(obj2);
        }
        return jSONArray;
    }

    private Enum getEnumByMethod(String str, Class<? extends Enum> cls, Method method) {
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int i11 = 0;
        while (i11 < enumArr.length) {
            Enum enumR = enumArr[i11];
            try {
                Object invoke = method.invoke(enumR, new Object[0]);
                if (invoke != null && invoke.toString().equals(str)) {
                    return enumR;
                }
                i11++;
            } catch (Exception e11) {
                throw new IllegalArgumentException(e11);
            }
        }
        throw new IllegalArgumentException("No enum constant " + cls.getName() + InstructionFileId.DOT + str);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Class<? extends java.lang.Enum>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Enum getEnumValue(java.lang.String r2, java.lang.Class<? extends java.lang.Enum> r3) {
        /*
            r1 = this;
            java.lang.reflect.Method r0 = r1.getJsonValueMethod(r3)
            if (r0 == 0) goto L_0x000b
            java.lang.Enum r2 = r1.getEnumByMethod(r2, r3, r0)
            return r2
        L_0x000b:
            java.lang.Enum r2 = java.lang.Enum.valueOf(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.json.ObjectMapper.getEnumValue(java.lang.String, java.lang.Class):java.lang.Enum");
    }

    private Object getJsonValue(Object obj, Class<?> cls, Field field) throws InvocationTargetException, IllegalAccessException {
        if (obj == null) {
            return null;
        }
        if (List.class.isAssignableFrom(cls)) {
            return convertListToJsonArray(obj);
        }
        Method jsonValueMethod = getJsonValueMethod(cls);
        if (jsonValueMethod != null) {
            return jsonValueMethod.invoke(obj, new Object[0]);
        }
        if (!canDirectlySerializeClass(cls)) {
            return convertValue(obj, JSONObject.class);
        }
        if (!cls.equals(Double.class) && !cls.equals(Float.class)) {
            return obj;
        }
        double doubleValue = ((Number) obj).doubleValue();
        if (Double.isNaN(doubleValue)) {
            return "NaN";
        }
        if (doubleValue == Double.POSITIVE_INFINITY) {
            return "Infinity";
        }
        return doubleValue == Double.NEGATIVE_INFINITY ? "-Infinity" : obj;
    }

    private Method getJsonValueMethod(Class<?> cls) {
        Method method;
        synchronized (this.mJsonValueMethodCache) {
            method = this.mJsonValueMethodCache.get(cls);
            if (method == null && !this.mJsonValueMethodCache.containsKey(cls)) {
                method = getJsonValueMethodImpl(cls);
                this.mJsonValueMethodCache.put(cls, method);
            }
        }
        return method;
    }

    private static Method getJsonValueMethodImpl(Class<?> cls) {
        Method[] methods = cls.getMethods();
        for (int i11 = 0; i11 < methods.length; i11++) {
            if (methods[i11].getAnnotation(JsonValue.class) != null) {
                return methods[i11];
            }
        }
        return null;
    }

    private Object getValueForField(Field field, Object obj) throws JSONException {
        if (obj != null) {
            try {
                if (obj == JSONObject.NULL) {
                    return null;
                }
                if (obj.getClass() == field.getType()) {
                    return obj;
                }
                if (obj instanceof JSONObject) {
                    return convertValue(obj, field.getType());
                }
                if (field.getType().isEnum()) {
                    return getEnumValue((String) obj, field.getType().asSubclass(Enum.class));
                }
                if (obj instanceof JSONArray) {
                    return convertArrayToList(field, (JSONArray) obj);
                }
                if (obj instanceof Number) {
                    Number number = (Number) obj;
                    Class<?> type = field.getType();
                    if (type != Integer.class) {
                        if (type != Integer.TYPE) {
                            if (type != Long.class) {
                                if (type != Long.TYPE) {
                                    if (type != Double.class) {
                                        if (type != Double.TYPE) {
                                            if (type != Float.class) {
                                                if (type != Float.TYPE) {
                                                    if (type != Byte.class) {
                                                        if (type != Byte.TYPE) {
                                                            if (type != Short.class) {
                                                                if (type != Short.TYPE) {
                                                                    throw new IllegalArgumentException("Not setup to handle class " + type.getName());
                                                                }
                                                            }
                                                            return Short.valueOf(number.shortValue());
                                                        }
                                                    }
                                                    return Byte.valueOf(number.byteValue());
                                                }
                                            }
                                            return Float.valueOf(number.floatValue());
                                        }
                                    }
                                    return Double.valueOf(number.doubleValue());
                                }
                            }
                            return Long.valueOf(number.longValue());
                        }
                    }
                    return Integer.valueOf(number.intValue());
                }
            } catch (IllegalAccessException e11) {
                throw new IllegalArgumentException("Unable to set value for field " + field.getName(), e11);
            }
        }
        return obj;
    }

    private static boolean isWrapperOrPrimitiveType(Class<?> cls) {
        return cls.isPrimitive() || cls.equals(Boolean.class) || cls.equals(Integer.class) || cls.equals(Character.class) || cls.equals(Byte.class) || cls.equals(Short.class) || cls.equals(Double.class) || cls.equals(Long.class) || cls.equals(Float.class);
    }

    public <T> T convertValue(Object obj, Class<T> cls) throws IllegalArgumentException {
        if (obj == null) {
            return null;
        }
        if (cls != Object.class && cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        try {
            if (obj instanceof JSONObject) {
                return _convertFromJSONObject((JSONObject) obj, cls);
            }
            if (cls == JSONObject.class) {
                return _convertToJSONObject(obj);
            }
            throw new IllegalArgumentException("Expecting either fromValue or toValueType to be a JSONObject");
        } catch (NoSuchMethodException e11) {
            throw new IllegalArgumentException(e11);
        } catch (IllegalAccessException e12) {
            throw new IllegalArgumentException(e12);
        } catch (InstantiationException e13) {
            throw new IllegalArgumentException(e13);
        } catch (JSONException e14) {
            throw new IllegalArgumentException(e14);
        } catch (InvocationTargetException e15) {
            throw ExceptionUtil.propagate(e15.getCause());
        }
    }
}
