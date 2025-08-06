package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8TypedArray;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class V8ObjectUtils {
    private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();
    private static final Object IGNORE = new Object();

    public static class DefaultTypeAdapter implements TypeAdapter {
        public Object adapt(int i11, Object obj) {
            return TypeAdapter.DEFAULT;
        }
    }

    public static class ListWrapper {
        private List<? extends Object> list;

        public ListWrapper(List<? extends Object> list2) {
            this.list = list2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ListWrapper) || ((ListWrapper) obj).list != this.list) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return System.identityHashCode(this.list);
        }
    }

    private V8ObjectUtils() {
    }

    public static Object getTypedArray(V8Array v8Array, int i11, Object obj) {
        int length = v8Array.length();
        if (i11 == 1) {
            int[] iArr = (int[]) obj;
            if (iArr == null || iArr.length < length) {
                iArr = new int[length];
            }
            v8Array.getIntegers(0, length, iArr);
            return iArr;
        } else if (i11 == 2) {
            double[] dArr = (double[]) obj;
            if (dArr == null || dArr.length < length) {
                dArr = new double[length];
            }
            v8Array.getDoubles(0, length, dArr);
            return dArr;
        } else if (i11 == 3) {
            boolean[] zArr = (boolean[]) obj;
            if (zArr == null || zArr.length < length) {
                zArr = new boolean[length];
            }
            v8Array.getBooleans(0, length, zArr);
            return zArr;
        } else if (i11 == 4) {
            String[] strArr = (String[]) obj;
            if (strArr == null || strArr.length < length) {
                strArr = new String[length];
            }
            v8Array.getStrings(0, length, strArr);
            return strArr;
        } else if (i11 == 9) {
            byte[] bArr = (byte[]) obj;
            if (bArr == null || bArr.length < length) {
                bArr = new byte[length];
            }
            v8Array.getBytes(0, length, bArr);
            return bArr;
        } else {
            throw new RuntimeException("Unsupported bulk load type: " + i11);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static java.lang.Object getV8Result(com.eclipsesource.v8.V8 r1, java.lang.Object r2) {
        /*
            if (r2 != 0) goto L_0x0004
            r1 = 0
            return r1
        L_0x0004:
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            java.lang.Object r1 = getV8Result(r1, r2, r0)     // Catch:{ all -> 0x0049 }
            boolean r2 = r1 instanceof com.eclipsesource.v8.V8Value     // Catch:{ all -> 0x0049 }
            if (r2 == 0) goto L_0x0030
            com.eclipsesource.v8.V8Value r1 = (com.eclipsesource.v8.V8Value) r1     // Catch:{ all -> 0x0049 }
            com.eclipsesource.v8.V8Value r1 = r1.twin()     // Catch:{ all -> 0x0049 }
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x001f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002f
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x001f
        L_0x002f:
            return r1
        L_0x0030:
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0038:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0048
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x0038
        L_0x0048:
            return r1
        L_0x0049:
            r1 = move-exception
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0052:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x0052
        L_0x0062:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getV8Result(com.eclipsesource.v8.V8, java.lang.Object):java.lang.Object");
    }

    public static Object getValue(Object obj) {
        return getValue(obj, DEFAULT_TYPE_ADAPTER);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static void pushValue(com.eclipsesource.v8.V8 r1, com.eclipsesource.v8.V8Array r2, java.lang.Object r3) {
        /*
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            pushValue(r1, r2, r3, r0)     // Catch:{ all -> 0x0021 }
            java.util.Collection r1 = r0.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x0010:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0020
            java.lang.Object r2 = r1.next()
            com.eclipsesource.v8.V8Value r2 = (com.eclipsesource.v8.V8Value) r2
            r2.close()
            goto L_0x0010
        L_0x0020:
            return
        L_0x0021:
            r1 = move-exception
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x002a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r2.next()
            com.eclipsesource.v8.V8Value r3 = (com.eclipsesource.v8.V8Value) r3
            r3.close()
            goto L_0x002a
        L_0x003a:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.pushValue(com.eclipsesource.v8.V8, com.eclipsesource.v8.V8Array, java.lang.Object):void");
    }

    private static void setValue(V8 v82, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Object.addUndefined(str);
        } else if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            v8Object.add(str, (double) ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Float) {
            v8Object.add(str, (double) ((Float) obj).floatValue());
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof TypedArray) {
            v8Object.add(str, (V8Value) toV8TypedArray(v82, (TypedArray) obj, map));
        } else if (obj instanceof ArrayBuffer) {
            v8Object.add(str, (V8Value) toV8ArrayBuffer(v82, (ArrayBuffer) obj, map));
        } else if (obj instanceof V8Value) {
            v8Object.add(str, (V8Value) obj);
        } else if (obj instanceof Map) {
            v8Object.add(str, (V8Value) toV8Object(v82, (Map) obj, map));
        } else if (obj instanceof List) {
            v8Object.add(str, (V8Value) toV8Array(v82, (List) obj, map));
        } else {
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    public static List<? super Object> toList(V8Array v8Array) {
        return toList(v8Array, DEFAULT_TYPE_ADAPTER);
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object) {
        return toMap(v8Object, DEFAULT_TYPE_ADAPTER);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static com.eclipsesource.v8.V8Array toV8Array(com.eclipsesource.v8.V8 r1, java.util.List<? extends java.lang.Object> r2) {
        /*
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            com.eclipsesource.v8.V8Array r1 = toV8Array(r1, r2, r0)     // Catch:{ all -> 0x0026 }
            com.eclipsesource.v8.V8Array r1 = r1.twin()     // Catch:{ all -> 0x0026 }
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0015:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x0015
        L_0x0025:
            return r1
        L_0x0026:
            r1 = move-exception
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x002f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x002f
        L_0x003f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.toV8Array(com.eclipsesource.v8.V8, java.util.List):com.eclipsesource.v8.V8Array");
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8 v82, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        if (map.containsKey(arrayBuffer)) {
            return (V8ArrayBuffer) map.get(arrayBuffer);
        }
        V8ArrayBuffer v8ArrayBuffer = arrayBuffer.getV8ArrayBuffer();
        map.put(arrayBuffer, v8ArrayBuffer);
        return v8ArrayBuffer;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static com.eclipsesource.v8.V8Object toV8Object(com.eclipsesource.v8.V8 r1, java.util.Map<java.lang.String, ? extends java.lang.Object> r2) {
        /*
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            com.eclipsesource.v8.V8Object r1 = toV8Object(r1, r2, r0)     // Catch:{ all -> 0x0026 }
            com.eclipsesource.v8.V8Object r1 = r1.twin()     // Catch:{ all -> 0x0026 }
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0015:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x0015
        L_0x0025:
            return r1
        L_0x0026:
            r1 = move-exception
            java.util.Collection r2 = r0.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x002f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003f
            java.lang.Object r0 = r2.next()
            com.eclipsesource.v8.V8Value r0 = (com.eclipsesource.v8.V8Value) r0
            r0.close()
            goto L_0x002f
        L_0x003f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.toV8Object(com.eclipsesource.v8.V8, java.util.Map):com.eclipsesource.v8.V8Object");
    }

    private static V8TypedArray toV8TypedArray(V8 v82, TypedArray typedArray, Map<Object, V8Value> map) {
        if (map.containsKey(typedArray)) {
            return (V8TypedArray) map.get(typedArray);
        }
        V8TypedArray v8TypedArray = typedArray.getV8TypedArray();
        map.put(typedArray, v8TypedArray);
        return v8TypedArray;
    }

    public static Object getValue(Object obj, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            if (obj instanceof V8Value) {
                return getValue(obj, ((V8Value) obj).getV8Type(), v8Map, typeAdapter);
            }
            v8Map.close();
            return obj;
        } finally {
            v8Map.close();
        }
    }

    public static List<? super Object> toList(V8Array v8Array, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            return toList(v8Array, v8Map, typeAdapter);
        } finally {
            v8Map.close();
        }
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, TypeAdapter typeAdapter) {
        V8Map v8Map = new V8Map();
        try {
            return toMap(v8Object, v8Map, typeAdapter);
        } finally {
            v8Map.close();
        }
    }

    private static List<? super Object> toList(V8Array v8Array, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        if (v8Array == null) {
            return Collections.emptyList();
        }
        if (v8Map.containsKey(v8Array)) {
            return (List) v8Map.get(v8Array);
        }
        ArrayList arrayList = new ArrayList();
        v8Map.put((V8Value) v8Array, arrayList);
        int i11 = 0;
        while (i11 < v8Array.length()) {
            Object obj = null;
            try {
                obj = v8Array.get(i11);
                Object value = getValue(obj, v8Array.getType(i11), v8Map, typeAdapter);
                if (value != IGNORE) {
                    arrayList.add(value);
                }
                i11++;
            } finally {
                if (obj instanceof Releasable) {
                    obj.release();
                }
            }
        }
        return arrayList;
    }

    private static Map<String, ? super Object> toMap(V8Object v8Object, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        if (v8Object == null) {
            return Collections.emptyMap();
        }
        if (v8Map.containsKey(v8Object)) {
            return (Map) v8Map.get(v8Object);
        }
        V8PropertyMap v8PropertyMap = new V8PropertyMap();
        v8Map.put((V8Value) v8Object, v8PropertyMap);
        String[] keys = v8Object.getKeys();
        int length = keys.length;
        int i11 = 0;
        while (i11 < length) {
            String str = keys[i11];
            Object obj = null;
            try {
                obj = v8Object.get(str);
                Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                if (value != IGNORE) {
                    v8PropertyMap.put(str, value);
                }
                i11++;
            } finally {
                if (obj instanceof Releasable) {
                    obj.release();
                }
            }
        }
        return v8PropertyMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getValue(com.eclipsesource.v8.V8Array r2, int r3) {
        /*
            com.eclipsesource.v8.utils.V8Map r0 = new com.eclipsesource.v8.utils.V8Map
            r0.<init>()
            java.lang.Object r1 = r2.get(r3)     // Catch:{ all -> 0x003b }
            int r2 = r2.getType(r3)     // Catch:{ all -> 0x0039 }
            com.eclipsesource.v8.utils.TypeAdapter r3 = DEFAULT_TYPE_ADAPTER     // Catch:{ all -> 0x0039 }
            java.lang.Object r2 = getValue(r1, r2, r0, r3)     // Catch:{ all -> 0x0039 }
            if (r2 != r1) goto L_0x002c
            boolean r3 = r2 instanceof com.eclipsesource.v8.V8Value     // Catch:{ all -> 0x0039 }
            if (r3 == 0) goto L_0x002c
            com.eclipsesource.v8.V8Value r2 = (com.eclipsesource.v8.V8Value) r2     // Catch:{ all -> 0x0039 }
            com.eclipsesource.v8.V8Value r2 = r2.twin()     // Catch:{ all -> 0x0039 }
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0028
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0028:
            r0.close()
            return r2
        L_0x002c:
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0035
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0035:
            r0.close()
            return r2
        L_0x0039:
            r2 = move-exception
            goto L_0x003d
        L_0x003b:
            r2 = move-exception
            r1 = 0
        L_0x003d:
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0046
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0046:
            r0.close()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getValue(com.eclipsesource.v8.V8Array, int):java.lang.Object");
    }

    private static void pushValue(V8 v82, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Array.pushUndefined();
        } else if (obj instanceof Integer) {
            v8Array.push(obj);
        } else if (obj instanceof Long) {
            v8Array.push((Object) new Double((double) ((Long) obj).longValue()));
        } else if (obj instanceof Double) {
            v8Array.push(obj);
        } else if (obj instanceof Float) {
            v8Array.push(obj);
        } else if (obj instanceof String) {
            v8Array.push((String) obj);
        } else if (obj instanceof Boolean) {
            v8Array.push(obj);
        } else if (obj instanceof TypedArray) {
            v8Array.push((V8Value) toV8TypedArray(v82, (TypedArray) obj, map));
        } else if (obj instanceof ArrayBuffer) {
            v8Array.push((V8Value) toV8ArrayBuffer(v82, (ArrayBuffer) obj, map));
        } else if (obj instanceof V8Value) {
            v8Array.push((V8Value) obj);
        } else if (obj instanceof Map) {
            v8Array.push((V8Value) toV8Object(v82, (Map) obj, map));
        } else if (obj instanceof List) {
            v8Array.push((V8Value) toV8Array(v82, (List) obj, map));
        } else {
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    private static V8Array toV8Array(V8 v82, List<? extends Object> list, Map<Object, V8Value> map) {
        if (map.containsKey(new ListWrapper(list))) {
            return (V8Array) map.get(new ListWrapper(list));
        }
        V8Array v8Array = new V8Array(v82);
        map.put(new ListWrapper(list), v8Array);
        int i11 = 0;
        while (i11 < list.size()) {
            try {
                pushValue(v82, v8Array, list.get(i11), map);
                i11++;
            } catch (IllegalStateException e11) {
                v8Array.close();
                throw e11;
            }
        }
        return v8Array;
    }

    private static V8Object toV8Object(V8 v82, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        if (map2.containsKey(map)) {
            return (V8Object) map2.get(map);
        }
        V8Object v8Object = new V8Object(v82);
        map2.put(map, v8Object);
        try {
            for (Map.Entry next : map.entrySet()) {
                setValue(v82, v8Object, (String) next.getKey(), next.getValue(), map2);
            }
            return v8Object;
        } catch (IllegalStateException e11) {
            v8Object.close();
            throw e11;
        }
    }

    private static Object getV8Result(V8 v82, Object obj, Map<Object, V8Value> map) {
        if (map.containsKey(obj)) {
            return map.get(obj);
        }
        if (obj instanceof Map) {
            return toV8Object(v82, (Map) obj, map);
        }
        if (obj instanceof List) {
            return toV8Array(v82, (List) obj, map);
        }
        if (obj instanceof TypedArray) {
            return toV8TypedArray(v82, (TypedArray) obj, map);
        }
        return obj instanceof ArrayBuffer ? toV8ArrayBuffer(v82, (ArrayBuffer) obj, map) : obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getValue(com.eclipsesource.v8.V8Array r2, int r3, com.eclipsesource.v8.utils.TypeAdapter r4) {
        /*
            com.eclipsesource.v8.utils.V8Map r0 = new com.eclipsesource.v8.utils.V8Map
            r0.<init>()
            java.lang.Object r1 = r2.get(r3)     // Catch:{ all -> 0x0039 }
            int r2 = r2.getType(r3)     // Catch:{ all -> 0x0037 }
            java.lang.Object r2 = getValue(r1, r2, r0, r4)     // Catch:{ all -> 0x0037 }
            if (r2 != r1) goto L_0x002a
            boolean r3 = r2 instanceof com.eclipsesource.v8.V8Value     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x002a
            com.eclipsesource.v8.V8Value r2 = (com.eclipsesource.v8.V8Value) r2     // Catch:{ all -> 0x0037 }
            com.eclipsesource.v8.V8Value r2 = r2.twin()     // Catch:{ all -> 0x0037 }
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0026
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0026:
            r0.close()
            return r2
        L_0x002a:
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0033
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0033:
            r0.close()
            return r2
        L_0x0037:
            r2 = move-exception
            goto L_0x003b
        L_0x0039:
            r2 = move-exception
            r1 = 0
        L_0x003b:
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0044
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0044:
            r0.close()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getValue(com.eclipsesource.v8.V8Array, int, com.eclipsesource.v8.utils.TypeAdapter):java.lang.Object");
    }

    public static Object getTypedArray(V8Array v8Array, int i11) {
        int length = v8Array.length();
        if (i11 == 1) {
            return v8Array.getIntegers(0, length);
        }
        if (i11 == 2) {
            return v8Array.getDoubles(0, length);
        }
        if (i11 == 3) {
            return v8Array.getBooleans(0, length);
        }
        if (i11 == 4) {
            return v8Array.getStrings(0, length);
        }
        throw new RuntimeException("Unsupported bulk load type: " + i11);
    }

    public static Object getValue(V8Object v8Object, String str) {
        return getValue(v8Object, str, DEFAULT_TYPE_ADAPTER);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object getValue(com.eclipsesource.v8.V8Object r2, java.lang.String r3, com.eclipsesource.v8.utils.TypeAdapter r4) {
        /*
            com.eclipsesource.v8.utils.V8Map r0 = new com.eclipsesource.v8.utils.V8Map
            r0.<init>()
            java.lang.Object r1 = r2.get(r3)     // Catch:{ all -> 0x0039 }
            int r2 = r2.getType(r3)     // Catch:{ all -> 0x0037 }
            java.lang.Object r2 = getValue(r1, r2, r0, r4)     // Catch:{ all -> 0x0037 }
            if (r2 != r1) goto L_0x002a
            boolean r3 = r2 instanceof com.eclipsesource.v8.V8Value     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x002a
            com.eclipsesource.v8.V8Value r2 = (com.eclipsesource.v8.V8Value) r2     // Catch:{ all -> 0x0037 }
            com.eclipsesource.v8.V8Value r2 = r2.twin()     // Catch:{ all -> 0x0037 }
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0026
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0026:
            r0.close()
            return r2
        L_0x002a:
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0033
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0033:
            r0.close()
            return r2
        L_0x0037:
            r2 = move-exception
            goto L_0x003b
        L_0x0039:
            r2 = move-exception
            r1 = 0
        L_0x003b:
            boolean r3 = r1 instanceof com.eclipsesource.v8.Releasable
            if (r3 == 0) goto L_0x0044
            com.eclipsesource.v8.Releasable r1 = (com.eclipsesource.v8.Releasable) r1
            r1.release()
        L_0x0044:
            r0.close()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eclipsesource.v8.utils.V8ObjectUtils.getValue(com.eclipsesource.v8.V8Object, java.lang.String, com.eclipsesource.v8.utils.TypeAdapter):java.lang.Object");
    }

    private static Object getValue(Object obj, int i11, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        Object adapt = typeAdapter.adapt(i11, obj);
        if (TypeAdapter.DEFAULT != adapt) {
            return adapt;
        }
        if (i11 == 10) {
            return new ArrayBuffer((V8ArrayBuffer) obj);
        }
        if (i11 == 99) {
            return V8.getUndefined();
        }
        switch (i11) {
            case 0:
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
                return obj;
            case 5:
                return toList((V8Array) obj, v8Map, typeAdapter);
            case 6:
                return toMap((V8Object) obj, v8Map, typeAdapter);
            case 7:
                return IGNORE;
            case 8:
                return new TypedArray((V8TypedArray) obj);
            default:
                throw new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(i11));
        }
    }
}
