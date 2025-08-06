package com.mob.tools.utils;

import com.mob.commons.C0891r;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class HashonHelper implements PublicMemberKeeper {

    public interface a {
        Object a();
    }

    private static <T> HashMap<String, T> a(JSONObject jSONObject) throws Throwable {
        HashMap<String, T> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (JSONObject.NULL.equals(opt)) {
                opt = null;
            }
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    opt = a((JSONObject) opt);
                } else if (opt instanceof JSONArray) {
                    opt = a((JSONArray) opt);
                }
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    private static ArrayList<?> b(Object obj) {
        int i11 = 0;
        if (obj instanceof byte[]) {
            ArrayList<?> arrayList = new ArrayList<>();
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            while (i11 < length) {
                arrayList.add(Byte.valueOf(bArr[i11]));
                i11++;
            }
            return arrayList;
        } else if (obj instanceof short[]) {
            ArrayList<?> arrayList2 = new ArrayList<>();
            short[] sArr = (short[]) obj;
            int length2 = sArr.length;
            while (i11 < length2) {
                arrayList2.add(Short.valueOf(sArr[i11]));
                i11++;
            }
            return arrayList2;
        } else if (obj instanceof int[]) {
            ArrayList<?> arrayList3 = new ArrayList<>();
            int[] iArr = (int[]) obj;
            int length3 = iArr.length;
            while (i11 < length3) {
                arrayList3.add(Integer.valueOf(iArr[i11]));
                i11++;
            }
            return arrayList3;
        } else if (obj instanceof long[]) {
            ArrayList<?> arrayList4 = new ArrayList<>();
            long[] jArr = (long[]) obj;
            int length4 = jArr.length;
            while (i11 < length4) {
                arrayList4.add(Long.valueOf(jArr[i11]));
                i11++;
            }
            return arrayList4;
        } else if (obj instanceof float[]) {
            ArrayList<?> arrayList5 = new ArrayList<>();
            float[] fArr = (float[]) obj;
            int length5 = fArr.length;
            while (i11 < length5) {
                arrayList5.add(Float.valueOf(fArr[i11]));
                i11++;
            }
            return arrayList5;
        } else if (obj instanceof double[]) {
            ArrayList<?> arrayList6 = new ArrayList<>();
            double[] dArr = (double[]) obj;
            int length6 = dArr.length;
            while (i11 < length6) {
                arrayList6.add(Double.valueOf(dArr[i11]));
                i11++;
            }
            return arrayList6;
        } else if (obj instanceof char[]) {
            ArrayList<?> arrayList7 = new ArrayList<>();
            char[] cArr = (char[]) obj;
            int length7 = cArr.length;
            while (i11 < length7) {
                arrayList7.add(Character.valueOf(cArr[i11]));
                i11++;
            }
            return arrayList7;
        } else if (obj instanceof boolean[]) {
            ArrayList<?> arrayList8 = new ArrayList<>();
            boolean[] zArr = (boolean[]) obj;
            int length8 = zArr.length;
            while (i11 < length8) {
                arrayList8.add(Boolean.valueOf(zArr[i11]));
                i11++;
            }
            return arrayList8;
        } else if (obj instanceof String[]) {
            return new ArrayList<>(Arrays.asList((String[]) obj));
        } else {
            return null;
        }
    }

    private static Object c(Object obj) throws Throwable {
        if (obj == null || obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Number) || (obj instanceof Character) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof a) {
            return c(((a) obj).a());
        }
        if (obj instanceof Enum) {
            HashMap hashMap = new HashMap();
            hashMap.put(C0891r.b("004ed5cfce"), ((Enum) obj).name());
            return hashMap;
        }
        if (obj.getClass().isArray()) {
            ArrayList arrayList = new ArrayList();
            int length = Array.getLength(obj);
            for (int i11 = 0; i11 < length; i11++) {
                arrayList.add(c(Array.get(obj, i11)));
            }
            return arrayList;
        } else if (obj instanceof Collection) {
            ArrayList arrayList2 = new ArrayList();
            for (Object c11 : (Collection) obj) {
                arrayList2.add(c(c11));
            }
            return arrayList2;
        } else if (obj instanceof Map) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (key instanceof String) {
                    hashMap2.put((String) key, c(entry.getValue()));
                }
            }
            return hashMap2;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (Class cls = obj.getClass(); !cls.equals(Object.class); cls = cls.getSuperclass()) {
                arrayList3.add(0, cls);
            }
            ArrayList arrayList4 = new ArrayList();
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                for (Field field : ((Class) it2.next()).getDeclaredFields()) {
                    if (!Modifier.isStatic(field.getModifiers()) && !field.getName().contains("$")) {
                        arrayList4.add(field);
                    }
                }
            }
            HashMap hashMap3 = new HashMap();
            Iterator it3 = arrayList4.iterator();
            while (it3.hasNext()) {
                Field field2 = (Field) it3.next();
                field2.setAccessible(true);
                hashMap3.put(field2.getName(), c(field2.get(obj)));
            }
            return hashMap3;
        }
    }

    public static String format(String str) {
        try {
            return a("", (HashMap<String, Object>) fromJson(str));
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return "";
        }
    }

    public static <T> String fromHashMap(HashMap<String, T> hashMap) {
        try {
            JSONObject a11 = a(hashMap);
            if (a11 == null) {
                return "";
            }
            return a11.toString();
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return "";
        }
    }

    public static <T> HashMap<String, T> fromJson(String str) {
        if (str == null || str.isEmpty()) {
            return new HashMap<>();
        }
        try {
            if (str.startsWith("[") && str.endsWith("]")) {
                str = "{\"fakelist\":" + str + "}";
            }
            return a(new JSONObject(str));
        } catch (Throwable th2) {
            MobLog.getInstance().w(str);
            MobLog.getInstance().w(th2);
            return new HashMap<>();
        }
    }

    public static String fromObject(Object obj) {
        Object obj2;
        try {
            obj2 = c(obj);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            obj2 = null;
        }
        if (obj2 == null) {
            return "";
        }
        if (!(obj2 instanceof ArrayList)) {
            return fromHashMap((HashMap) obj2);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(C0891r.b("004fZchehDh"), obj2);
        String fromHashMap = fromHashMap(hashMap);
        return fromHashMap.substring(8, fromHashMap.length() - 1).trim();
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        HashMap fromJson = fromJson(str);
        Object obj = fromJson;
        if (str.startsWith("[")) {
            obj = fromJson;
            if (str.endsWith("]")) {
                obj = fromJson.get(C0891r.b("008%de;cVdg%efUcheh4h"));
            }
        }
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            return a(obj, cls, genericSuperclass instanceof ParameterizedType ? ((ParameterizedType) genericSuperclass).getActualTypeArguments() : null);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    private static ArrayList<Object> a(JSONArray jSONArray) throws Throwable {
        ArrayList<Object> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i11 = 0; i11 < length; i11++) {
            Object opt = jSONArray.opt(i11);
            if (opt instanceof JSONObject) {
                opt = a((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = a((JSONArray) opt);
            }
            arrayList.add(opt);
        }
        return arrayList;
    }

    private static <T> JSONObject a(HashMap<String, T> hashMap) throws Throwable {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : hashMap.entrySet()) {
            Object value = next.getValue();
            if (value instanceof HashMap) {
                value = a((HashMap) value);
            } else if (value instanceof ArrayList) {
                value = a((ArrayList<Object>) (ArrayList) value);
            } else if (a(value)) {
                value = a((ArrayList<Object>) b(value));
            }
            jSONObject.put((String) next.getKey(), value);
        }
        return jSONObject;
    }

    private static boolean a(Object obj) {
        return (obj instanceof byte[]) || (obj instanceof short[]) || (obj instanceof int[]) || (obj instanceof long[]) || (obj instanceof float[]) || (obj instanceof double[]) || (obj instanceof char[]) || (obj instanceof boolean[]) || (obj instanceof String[]);
    }

    private static JSONArray a(ArrayList<Object> arrayList) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        Iterator<Object> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next instanceof HashMap) {
                next = a((HashMap) next);
            } else if (next instanceof ArrayList) {
                next = a((ArrayList<Object>) (ArrayList) next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    private static String a(String str, HashMap<String, Object> hashMap) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{\n");
        String str2 = str + "\t";
        int i11 = 0;
        for (Map.Entry next : hashMap.entrySet()) {
            if (i11 > 0) {
                sb2.append(",\n");
            }
            sb2.append(str2);
            sb2.append('\"');
            sb2.append((String) next.getKey());
            sb2.append("\":");
            Object value = next.getValue();
            if (value instanceof HashMap) {
                sb2.append(a(str2, (HashMap<String, Object>) (HashMap) value));
            } else if (value instanceof ArrayList) {
                sb2.append(a(str2, (ArrayList<Object>) (ArrayList) value));
            } else if (value instanceof String) {
                sb2.append('\"');
                sb2.append(value);
                sb2.append('\"');
            } else {
                sb2.append(value);
            }
            i11++;
        }
        sb2.append(10);
        sb2.append(str);
        sb2.append('}');
        return sb2.toString();
    }

    private static String a(String str, ArrayList<Object> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[\n");
        String str2 = str + "\t";
        Iterator<Object> it2 = arrayList.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            if (i11 > 0) {
                sb2.append(",\n");
            }
            sb2.append(str2);
            if (next instanceof HashMap) {
                sb2.append(a(str2, (HashMap<String, Object>) (HashMap) next));
            } else if (next instanceof ArrayList) {
                sb2.append(a(str2, (ArrayList<Object>) (ArrayList) next));
            } else if (next instanceof String) {
                sb2.append('\"');
                sb2.append(next);
                sb2.append('\"');
            } else {
                sb2.append(next);
            }
            i11++;
        }
        sb2.append(10);
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }

    private static <T> T a(Object obj, Class<T> cls, Type[] typeArr) throws Throwable {
        Field field;
        Class cls2;
        Class cls3;
        Object obj2;
        Object obj3;
        Class<Character> cls4 = Character.class;
        Class<Boolean> cls5 = Boolean.class;
        Class<Object> cls6 = Object.class;
        int i11 = 0;
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls) || cls.equals(cls4)) {
            if (cls.equals(Boolean.TYPE) || cls.equals(cls5)) {
                return Boolean.valueOf(C0891r.b("004hGcicfVe").equals(String.valueOf(obj)));
            }
            if (cls.equals(Character.TYPE) || cls.equals(cls4)) {
                return Character.valueOf(String.valueOf(obj).charAt(0));
            }
            if (cls.equals(Byte.TYPE) || cls.equals(Byte.class)) {
                return Byte.valueOf(String.valueOf(obj));
            }
            if (cls.equals(Short.TYPE) || cls.equals(Short.class)) {
                return Short.valueOf(String.valueOf(obj));
            }
            if (cls.equals(Integer.TYPE) || cls.equals(Integer.class)) {
                return Integer.valueOf(String.valueOf(obj));
            }
            if (cls.equals(Long.TYPE) || cls.equals(Long.class)) {
                return Long.valueOf(String.valueOf(obj));
            }
            if (cls.equals(Float.TYPE) || cls.equals(Float.class)) {
                return Float.valueOf(String.valueOf(obj));
            }
            return Double.valueOf(String.valueOf(obj));
        } else if (a.class.isAssignableFrom(cls)) {
            try {
                return ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(cls.getName()), C0891r.b("007@ccQcfZcf e[fgde"), obj);
            } catch (Throwable unused) {
                return null;
            }
        } else if (cls.equals(String.class) || cls.equals(cls5)) {
            return obj;
        } else {
            if (cls.isEnum()) {
                return Enum.valueOf(cls, String.valueOf(((HashMap) obj).get(C0891r.b("004ed$cfce"))));
            }
            if (cls.isArray()) {
                ArrayList arrayList = (ArrayList) obj;
                Class<?> componentType = cls.getComponentType();
                T newInstance = Array.newInstance(componentType, arrayList.size());
                int size = arrayList.size();
                while (i11 < size) {
                    Array.set(newInstance, i11, a(arrayList.get(i11), componentType, (Type[]) null));
                    i11++;
                }
                return newInstance;
            } else if (Collection.class.isAssignableFrom(cls)) {
                T t11 = (Collection) cls.newInstance();
                Class cls7 = (typeArr == null || typeArr.length <= 0) ? null : typeArr[0];
                ArrayList arrayList2 = (ArrayList) obj;
                int size2 = arrayList2.size();
                while (i11 < size2) {
                    if (cls7 != null && (cls7 instanceof Class) && !cls7.equals(cls6)) {
                        t11.add(a(arrayList2.get(i11), cls7, (Type[]) null));
                    } else if (cls7 == null || !(cls7 instanceof ParameterizedType)) {
                        t11.add(arrayList2.get(i11));
                    } else {
                        ParameterizedType parameterizedType = (ParameterizedType) cls7;
                        t11.add(a(arrayList2.get(i11), (Class) parameterizedType.getRawType(), parameterizedType.getActualTypeArguments()));
                    }
                    i11++;
                }
                return t11;
            } else if (Map.class.isAssignableFrom(cls)) {
                T t12 = (Map) cls.newInstance();
                if (typeArr == null || typeArr.length <= 1) {
                    cls2 = null;
                    cls3 = null;
                } else {
                    cls3 = typeArr[0];
                    cls2 = typeArr[1];
                }
                HashMap hashMap = (HashMap) obj;
                for (Object next : hashMap.keySet()) {
                    if (cls3 != null && (cls3 instanceof Class) && !cls2.equals(cls6)) {
                        obj2 = a(next, cls3, (Type[]) null);
                    } else if (cls3 == null || !(cls3 instanceof ParameterizedType)) {
                        obj2 = next;
                    } else {
                        ParameterizedType parameterizedType2 = (ParameterizedType) cls3;
                        obj2 = a(next, (Class) parameterizedType2.getRawType(), parameterizedType2.getActualTypeArguments());
                    }
                    if (cls2 != null && (cls2 instanceof Class) && !cls2.equals(cls6)) {
                        obj3 = a(hashMap.get(next), cls2, (Type[]) null);
                    } else if (cls2 == null || !(cls2 instanceof ParameterizedType)) {
                        obj3 = hashMap.get(next);
                    } else {
                        ParameterizedType parameterizedType3 = (ParameterizedType) cls2;
                        obj3 = a(hashMap.get(next), (Class) parameterizedType3.getRawType(), parameterizedType3.getActualTypeArguments());
                    }
                    t12.put(obj2, obj3);
                }
                return t12;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Class<T> cls8 = cls; !cls8.equals(cls6); cls8 = cls8.getSuperclass()) {
                    arrayList3.add(cls8);
                }
                HashMap hashMap2 = (HashMap) obj;
                HashMap hashMap3 = new HashMap();
                for (String str : hashMap2.keySet()) {
                    if (hashMap2.get(str) != null) {
                        Iterator it2 = arrayList3.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            try {
                                field = ((Class) it2.next()).getDeclaredField(str);
                                continue;
                            } catch (Throwable unused2) {
                                field = null;
                                continue;
                            }
                            if (field != null) {
                                hashMap3.put(str, field);
                                break;
                            }
                        }
                    }
                }
                T newInstance2 = ReflectHelper.newInstance(ReflectHelper.getName(cls), new Object[0]);
                for (String str2 : hashMap3.keySet()) {
                    Object obj4 = hashMap2.get(str2);
                    Field field2 = (Field) hashMap3.get(str2);
                    Class<?> type = field2.getType();
                    Type genericType = field2.getGenericType();
                    Type[] actualTypeArguments = genericType instanceof ParameterizedType ? ((ParameterizedType) genericType).getActualTypeArguments() : null;
                    field2.setAccessible(true);
                    field2.set(newInstance2, a(obj4, type, actualTypeArguments));
                }
                return newInstance2;
            }
        }
    }
}
