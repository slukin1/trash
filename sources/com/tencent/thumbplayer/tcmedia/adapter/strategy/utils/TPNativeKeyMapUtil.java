package com.tencent.thumbplayer.tcmedia.adapter.strategy.utils;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.thumbplayer.tcmedia.adapter.a.b.c;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.tplayer.TPOptionalIDInternal;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TPNativeKeyMapUtil {
    private static final String REVERSE_MAP_NAME_SUFFIX = ".reverseMap";
    private static final String TAG = "TPNativeKeyMapUtil";
    private static final AtomicBoolean sHasOptionalIdMapInit = new AtomicBoolean(false);
    private static final Map<Class<?>, AtomicBoolean> sHasThisAnnotationInitMap = new ConcurrentHashMap();
    private static final Map<String, Map<Number, Number>> sNameToMap = new ConcurrentHashMap();
    private static final SparseArray<String> sOptionalIdKeyToNameMap = new SparseArray<>();
    private static final SparseArray<c.a> sToNativeOptionalIdMap = new SparseArray<>();

    private static <T extends Annotation> void buildBiDirectionMapForAnnotation(Class<T> cls) {
        AtomicBoolean atomicBoolean;
        TPLogUtil.i(TAG, "buildBiDirectionMapForAnnotation, clazz=".concat(String.valueOf(cls)));
        Map<Class<?>, AtomicBoolean> map = sHasThisAnnotationInitMap;
        synchronized (map) {
            atomicBoolean = map.get(cls);
            if (atomicBoolean == null) {
                atomicBoolean = new AtomicBoolean(false);
                map.put(cls, atomicBoolean);
            }
        }
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                TPLogUtil.i(TAG, "className=" + cls.getSimpleName() + " already init");
                return;
            }
            searchClassToFillMap(cls);
            atomicBoolean.set(true);
        }
    }

    private static void buildNativeInitConfigMap() {
        TPNativeKeyMap.MapInitConfig mapInitConfig;
        try {
            Class<?> cls = Class.forName(TPOptionalID.class.getName());
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType().toString().equals("int") && (mapInitConfig = (TPNativeKeyMap.MapInitConfig) field.getAnnotation(TPNativeKeyMap.MapInitConfig.class)) != null) {
                    int i11 = field.getInt(cls);
                    sOptionalIdKeyToNameMap.put(i11, mapInitConfig.keyName());
                    if (mapInitConfig.value() == -1) {
                        sToNativeOptionalIdMap.put(i11, new c.a());
                    } else {
                        field.setAccessible(true);
                        sToNativeOptionalIdMap.put(i11, new c.a(mapInitConfig.type(), mapInitConfig.value()));
                    }
                }
            }
        } catch (ClassNotFoundException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
        } catch (IllegalAccessException e12) {
            TPLogUtil.e(TAG, (Throwable) e12);
        }
    }

    private static void buildNativeOptionalIdToMapInternal(Class<?> cls) {
        TPNativeKeyMap.MapOptionalId mapOptionalId;
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (field.getType().toString().equals("int") && (mapOptionalId = (TPNativeKeyMap.MapOptionalId) field.getAnnotation(TPNativeKeyMap.MapOptionalId.class)) != null) {
                    int i11 = field.getInt(cls);
                    sOptionalIdKeyToNameMap.put(i11, mapOptionalId.keyName());
                    if (mapOptionalId.value() == -1) {
                        sToNativeOptionalIdMap.put(i11, new c.a());
                    } else {
                        field.setAccessible(true);
                        sToNativeOptionalIdMap.put(i11, new c.a(mapOptionalId.type(), mapOptionalId.value()));
                    }
                }
            }
        } catch (IllegalAccessException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
        }
    }

    private static void buildOptionalIdMap() {
        AtomicBoolean atomicBoolean = sHasOptionalIdMapInit;
        synchronized (atomicBoolean) {
            if (sToNativeOptionalIdMap.size() == 0) {
                if (!atomicBoolean.get()) {
                    buildNativeInitConfigMap();
                    buildPublicToNativeOptionalIdMap();
                    buildPrivateToNativeOptionalIdMap();
                    atomicBoolean.set(true);
                    return;
                }
                throw new IllegalStateException("构建Map错误，请查看【--keep class com.tencent.thumbplayer.tcmedia.api.** { *; }】是否加入反混淆");
            }
        }
    }

    private static void buildPrivateToNativeOptionalIdMap() {
        try {
            buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalIDInternal.class.getName()));
        } catch (ClassNotFoundException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
        }
    }

    private static void buildPublicToNativeOptionalIdMap() {
        try {
            buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalID.class.getName()));
        } catch (ClassNotFoundException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
        }
    }

    private static <T extends Annotation> void checkFillMapValidity(Class<T> cls, Map<Number, Number> map, Map<Number, Number> map2, Class<?> cls2, Number number, Number number2) {
        if (map.containsKey(number2)) {
            throw new IllegalStateException(cls2.getName() + " 配置了重复的成员变量，注解=" + cls.getName() + " 成员变量值=" + number2 + " 请查找一下使用这个注解@" + cls.getName() + "的哪两个成员变量值相等");
        } else if (map2.containsKey(number)) {
            throw new IllegalStateException(cls2.getName() + " 配置了重复的注解值，注解=" + cls.getName() + " 成员变量值=" + number2 + " 请查找一下@" + cls.getName() + "(这个值)在哪里重复了");
        }
    }

    public static c.a convertToNativeOptionalId(@TPCommonEnum.TPOptionalId int i11) {
        SparseArray<c.a> sparseArray = sToNativeOptionalIdMap;
        if (sparseArray.size() == 0) {
            buildOptionalIdMap();
        }
        return sparseArray.get(i11, new c.a());
    }

    public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfToNativeMap(Class<T> cls) {
        return new HashSet(getMapForAnnotation(cls, true).entrySet());
    }

    public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfToTPMap(Class<T> cls) {
        return new HashSet(getMapForAnnotation(cls, false).entrySet());
    }

    private static <T extends Annotation> Map<Number, Number> getMapForAnnotation(Class<T> cls, boolean z11) {
        String mapKey = getMapKey(cls, z11);
        Map<String, Map<Number, Number>> map = sNameToMap;
        Map<Number, Number> map2 = map.get(mapKey);
        if (map2 == null || map2.size() == 0) {
            buildBiDirectionMapForAnnotation(cls);
            map2 = map.get(mapKey);
        }
        if (((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)) == null) {
            throw new IllegalArgumentException(cls.getSimpleName() + "has not SearchConfig annotation");
        } else if (map2 != null && map2.size() != 0) {
            return map2;
        } else {
            throw new IllegalStateException(cls.getSimpleName() + " is null after buildBiDirectionMap");
        }
    }

    private static <T extends Annotation> String getMapKey(Class<T> cls, boolean z11) {
        String canonicalName = cls.getCanonicalName();
        if (z11) {
            return canonicalName;
        }
        return canonicalName + REVERSE_MAP_NAME_SUFFIX;
    }

    public static String getOptionalIdName(int i11) {
        if (!sHasOptionalIdMapInit.get()) {
            buildOptionalIdMap();
        }
        return sOptionalIdKeyToNameMap.get(i11, "");
    }

    public static void init() {
        long currentTimeMillis = System.currentTimeMillis();
        Class[] declaredClasses = TPNativeKeyMap.class.getDeclaredClasses();
        TPLogUtil.i(TAG, "init BiDirectionMap for tp&native value");
        for (Class cls : declaredClasses) {
            if (cls.isAnnotation() && Modifier.isPublic(cls.getModifiers()) && ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)) != null) {
                buildBiDirectionMapForAnnotation(cls);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        TPLogUtil.i(TAG, "init cost time=" + (currentTimeMillis2 - currentTimeMillis));
    }

    private static <T extends Annotation> void searchClassToFillMap(Class<T> cls) {
        boolean z11;
        int i11;
        T annotation;
        Number number;
        boolean z12;
        Integer num;
        Class<T> cls2 = cls;
        boolean z13 = true;
        String mapKey = getMapKey(cls2, true);
        Map<String, Map<Number, Number>> map = sNameToMap;
        Map map2 = map.get(mapKey);
        String mapKey2 = getMapKey(cls2, false);
        Map map3 = map.get(mapKey2);
        if (map2 == null || map3 == null) {
            map2 = new HashMap();
            map.put(mapKey, map2);
            map3 = new HashMap();
            map.put(mapKey2, map3);
        }
        Map map4 = map2;
        Map map5 = map3;
        try {
            TPNativeKeyMap.SearchConfig searchConfig = (TPNativeKeyMap.SearchConfig) cls2.getAnnotation(TPNativeKeyMap.SearchConfig.class);
            if (searchConfig != null) {
                Class<?> searchClass = searchConfig.searchClass();
                Field[] declaredFields = searchClass.getDeclaredFields();
                int length = declaredFields.length;
                int i12 = 0;
                while (i12 < length) {
                    Field field = declaredFields[i12];
                    String str = "";
                    Class<? extends Number> valueClass = searchConfig.valueClass();
                    Class<? extends Number> cls3 = Integer.TYPE;
                    if (valueClass == cls3) {
                        str = "int";
                    } else if (searchConfig.valueClass() == Long.TYPE) {
                        str = "long";
                    }
                    if (!TextUtils.isEmpty(str)) {
                        if (!field.getType().toString().equals(str) || (annotation = field.getAnnotation(cls2)) == null) {
                            i11 = i12;
                            z11 = false;
                        } else {
                            field.setAccessible(z13);
                            int i13 = i12;
                            Method declaredMethod = cls2.getDeclaredMethod("value", new Class[0]);
                            z13 = true;
                            declaredMethod.setAccessible(true);
                            if (searchConfig.valueClass() == cls3) {
                                number = Integer.valueOf(field.getInt(searchClass));
                                num = (Integer) declaredMethod.invoke(annotation, new Object[0]);
                                z12 = false;
                            } else if (searchConfig.valueClass() == Long.TYPE) {
                                z12 = false;
                                number = Long.valueOf(field.getLong(searchClass));
                                num = (Long) declaredMethod.invoke(annotation, new Object[0]);
                            } else {
                                throw new IllegalArgumentException("代码还没实现对" + searchConfig.valueClass().getName() + "的支持");
                            }
                            i11 = i13;
                            z11 = z12;
                            checkFillMapValidity(cls, map4, map5, searchClass, num, number);
                            Number number2 = num;
                            map4.put(number, number2);
                            map5.put(number2, number);
                        }
                        i12 = i11 + 1;
                        boolean z14 = z11;
                    } else {
                        throw new IllegalArgumentException("代码还没实现对" + searchConfig.valueClass().getName() + "的支持");
                    }
                }
                return;
            }
            throw new IllegalArgumentException(cls.getCanonicalName() + "has not SearchConfig annotation");
        } catch (IllegalAccessException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
        } catch (NoSuchMethodException e12) {
            TPLogUtil.e(TAG, (Throwable) e12);
            throw new IllegalStateException("com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap下所有元素需要加到混淆中, 并且每个MapXXX注解需要有value方法");
        } catch (InvocationTargetException e13) {
            TPLogUtil.e(TAG, (Throwable) e13);
        }
    }

    public static <T extends Annotation> int toNativeIntValue(Class<T> cls, int i11) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, true);
        if (mapForAnnotation.containsKey(Integer.valueOf(i11))) {
            return mapForAnnotation.get(Integer.valueOf(i11)).intValue();
        }
        TPLogUtil.e(TAG, "toNativeValue, tpValue=" + i11 + "return default value, clazz" + cls);
        return (int) ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }

    public static <T extends Annotation> long toNativeLongValue(Class<T> cls, long j11) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, true);
        if (mapForAnnotation.containsKey(Long.valueOf(j11))) {
            return mapForAnnotation.get(Long.valueOf(j11)).longValue();
        }
        TPLogUtil.e(TAG, "toNativeValue, tpValue=" + j11 + "return default value, clazz" + cls);
        return ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }

    public static <T extends Annotation> int toTPIntValue(Class<T> cls, int i11) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, false);
        if (mapForAnnotation.containsKey(Integer.valueOf(i11))) {
            return mapForAnnotation.get(Integer.valueOf(i11)).intValue();
        }
        TPLogUtil.i(TAG, "toTPValue, nativeValue=" + i11 + "return default value, clazz" + cls);
        return (int) ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }

    public static <T extends Annotation> long toTPLongValue(Class<T> cls, long j11) {
        Map<Number, Number> mapForAnnotation = getMapForAnnotation(cls, false);
        if (mapForAnnotation.containsKey(Long.valueOf(j11))) {
            return mapForAnnotation.get(Long.valueOf(j11)).longValue();
        }
        TPLogUtil.i(TAG, "toTPValue, nativeValue=" + j11 + "return default value, clazz" + cls);
        return ((TPNativeKeyMap.SearchConfig) cls.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }
}
