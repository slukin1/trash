package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
    public static final int VAL_BYTE = 2;
    public static final int VAL_ENTITY = 0;
    public static final int VAL_LIST = 1;
    public static final int VAL_MAP = 3;
    public static final int VAL_NULL = -1;
    public static final String VAL_TYPE = "_val_type_";

    private static String a(IMessageEntity iMessageEntity) throws IllegalAccessException, JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Class cls = iMessageEntity.getClass(); cls != null; cls = cls.getSuperclass()) {
            for (Field field : cls.getDeclaredFields()) {
                if (field.isAnnotationPresent(Packed.class)) {
                    boolean isAccessible = field.isAccessible();
                    a(field, true);
                    String name = field.getName();
                    Object obj = field.get(iMessageEntity);
                    a(field, isAccessible);
                    a(name, obj, jSONObject);
                }
            }
        }
        return jSONObject.toString();
    }

    private static Object b(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object a11 = a(field.getName(), jSONObject);
        if (a11 != null) {
            try {
                if (field.getType().getName().startsWith("com.huawei") && (field.getType().newInstance() instanceof IMessageEntity)) {
                    return jsonToEntity((String) a11, (IMessageEntity) field.getType().newInstance());
                }
                if (!(a11 instanceof JSONObject) || !((JSONObject) a11).has("_val_type_")) {
                    return a11;
                }
                int i11 = ((JSONObject) a11).getInt("_val_type_");
                if (i11 != 1) {
                    if (i11 != 0) {
                        if (i11 == 2) {
                            return a((JSONObject) a11);
                        }
                        if (i11 == 3) {
                            return b(field.getGenericType(), (JSONObject) a11);
                        }
                        HMSLog.e("JsonUtil", "cannot support type : " + i11);
                    }
                }
                return a(field.getGenericType(), (JSONObject) a11);
            } catch (InstantiationException unused) {
                HMSLog.e("JsonUtil", "InstantiationException  ");
            }
        }
        return null;
    }

    @Deprecated
    public static String createJsonString(IMessageEntity iMessageEntity) {
        if (iMessageEntity == null) {
            HMSLog.e("JsonUtil", "createJsonString error, the input IMessageEntity is null");
            return "";
        }
        try {
            return a(iMessageEntity);
        } catch (IllegalAccessException e11) {
            HMSLog.e("JsonUtil", "catch IllegalAccessException " + e11.getMessage());
            return "";
        } catch (JSONException e12) {
            HMSLog.e("JsonUtil", "catch JSONException " + e12.getMessage());
            return "";
        }
    }

    public static Object getInfoFromJsonobject(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has(str2)) {
                    return null;
                }
                Object obj = jSONObject.get(str2);
                if (obj instanceof String) {
                    return obj;
                }
            } catch (JSONException unused) {
                HMSLog.e("JsonUtil", "getInfoFromJsonobject:parser json error :" + str2);
            }
        }
        return null;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return -1;
        }
        return jSONObject.getInt(str);
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|15|16|17|27) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002f */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.core.aidl.IMessageEntity jsonToEntity(java.lang.String r8, com.huawei.hms.core.aidl.IMessageEntity r9) {
        /*
            java.lang.String r0 = "JsonUtil"
            if (r9 != 0) goto L_0x0006
            r8 = 0
            return r8
        L_0x0006:
            java.lang.Class r1 = r9.getClass()     // Catch:{ JSONException -> 0x004f }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004f }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x004f }
        L_0x000f:
            if (r1 == 0) goto L_0x0068
            java.lang.reflect.Field[] r8 = r1.getDeclaredFields()     // Catch:{ JSONException -> 0x004f }
            if (r8 != 0) goto L_0x001d
            java.lang.Class r8 = r1.getSuperclass()     // Catch:{ JSONException -> 0x004f }
        L_0x001b:
            r1 = r8
            goto L_0x000f
        L_0x001d:
            int r3 = r8.length     // Catch:{ JSONException -> 0x004f }
            r4 = 0
        L_0x001f:
            if (r4 >= r3) goto L_0x004a
            r5 = r8[r4]     // Catch:{ JSONException -> 0x004f }
            java.lang.Class<com.huawei.hms.core.aidl.annotation.Packed> r6 = com.huawei.hms.core.aidl.annotation.Packed.class
            boolean r6 = r5.isAnnotationPresent(r6)     // Catch:{ JSONException -> 0x004f }
            if (r6 == 0) goto L_0x0047
            a((com.huawei.hms.core.aidl.IMessageEntity) r9, (java.lang.reflect.Field) r5, (org.json.JSONObject) r2)     // Catch:{ IllegalAccessException -> 0x002f }
            goto L_0x0047
        L_0x002f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x004f }
            r6.<init>()     // Catch:{ JSONException -> 0x004f }
            java.lang.String r7 = "jsonToEntity, set value of the field exception, field name:"
            r6.append(r7)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r5 = r5.getName()     // Catch:{ JSONException -> 0x004f }
            r6.append(r5)     // Catch:{ JSONException -> 0x004f }
            java.lang.String r5 = r6.toString()     // Catch:{ JSONException -> 0x004f }
            com.huawei.hms.support.log.HMSLog.e(r0, r5)     // Catch:{ JSONException -> 0x004f }
        L_0x0047:
            int r4 = r4 + 1
            goto L_0x001f
        L_0x004a:
            java.lang.Class r8 = r1.getSuperclass()     // Catch:{ JSONException -> 0x004f }
            goto L_0x001b
        L_0x004f:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "catch JSONException when parse jsonString"
            r1.append(r2)
            java.lang.String r8 = r8.getMessage()
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            com.huawei.hms.support.log.HMSLog.e(r0, r8)
        L_0x0068:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.utils.JsonUtil.jsonToEntity(java.lang.String, com.huawei.hms.core.aidl.IMessageEntity):com.huawei.hms.core.aidl.IMessageEntity");
    }

    private static void a(final Field field, final boolean z11) {
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                field.setAccessible(z11);
                return null;
            }
        });
    }

    private static Map b(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        Class cls = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        JSONArray jSONArray = new JSONArray(jSONObject.getString("_map_"));
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 < jSONArray.length(); i11 += 2) {
            if (cls.newInstance() instanceof IMessageEntity) {
                hashMap.put(jSONArray.get(i11), jsonToEntity(jSONArray.getString(i11 + 1), (IMessageEntity) cls.newInstance()));
            } else {
                hashMap.put(jSONArray.get(i11), jSONArray.get(i11 + 1));
            }
        }
        return hashMap;
    }

    private static boolean a(String str, Object obj, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        if (obj instanceof String) {
            jSONObject.put(str, (String) obj);
            return true;
        } else if (obj instanceof Integer) {
            jSONObject.put(str, ((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Short) {
            jSONObject.put(str, (Short) obj);
            return true;
        } else if (obj instanceof Long) {
            jSONObject.put(str, (Long) obj);
            return true;
        } else if (obj instanceof Float) {
            jSONObject.put(str, (Float) obj);
            return true;
        } else if (obj instanceof Double) {
            jSONObject.put(str, (Double) obj);
            return true;
        } else if (obj instanceof Boolean) {
            jSONObject.put(str, (Boolean) obj);
            return true;
        } else if (obj instanceof JSONObject) {
            jSONObject.put(str, (JSONObject) obj);
            return true;
        } else if (obj instanceof byte[]) {
            a(str, (byte[]) obj, jSONObject);
            return true;
        } else if (obj instanceof List) {
            a(str, (List<?>) (List) obj, jSONObject);
            return true;
        } else if (obj instanceof Map) {
            a(str, (Map) obj, jSONObject);
            return true;
        } else {
            if (obj instanceof IMessageEntity) {
                try {
                    jSONObject.put(str, a((IMessageEntity) obj));
                    return true;
                } catch (IllegalAccessException e11) {
                    HMSLog.e("JsonUtil", "IllegalAccessException , " + e11);
                }
            }
            return false;
        }
    }

    private static void a(String str, Map map, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key instanceof IMessageEntity) {
                jSONArray.put(a((IMessageEntity) key));
            } else {
                jSONArray.put(key);
            }
            if (value instanceof IMessageEntity) {
                jSONArray.put(a((IMessageEntity) value));
            } else {
                jSONArray.put(value);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 3);
        jSONObject2.put("_map_", jSONArray.toString());
        jSONObject.put(str, jSONObject2);
    }

    private static void a(String str, byte[] bArr, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 2);
        try {
            jSONObject2.put("_byte_", Base64.encode(bArr));
        } catch (IllegalArgumentException e11) {
            HMSLog.e("JsonUtil", "writeByte failed : " + e11.getMessage());
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void a(String str, List<?> list, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("_val_type_", 1);
        jSONObject2.put("_list_size_", list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            a("_list_item_" + i11, (Object) list.get(i11), jSONObject2);
            if (list.get(i11) instanceof IMessageEntity) {
                jSONObject2.put("_val_type_", 0);
            }
        }
        jSONObject.put(str, jSONObject2);
    }

    private static void a(IMessageEntity iMessageEntity, Field field, JSONObject jSONObject) throws JSONException, IllegalAccessException {
        Object b11 = b(iMessageEntity, field, jSONObject);
        if (b11 != null) {
            boolean isAccessible = field.isAccessible();
            a(field, true);
            field.set(iMessageEntity, b11);
            a(field, isAccessible);
        }
    }

    private static Object a(String str, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.get(str);
        }
        if (jSONObject.has("header") && jSONObject.getJSONObject("header").has(str)) {
            return jSONObject.getJSONObject("header").get(str);
        }
        if (!jSONObject.has(TtmlNode.TAG_BODY) || !jSONObject.getJSONObject(TtmlNode.TAG_BODY).has(str)) {
            return null;
        }
        return jSONObject.getJSONObject(TtmlNode.TAG_BODY).get(str);
    }

    private static List<Object> a(Type type, JSONObject jSONObject) throws JSONException, IllegalAccessException, InstantiationException {
        int i11 = jSONObject.getInt("_list_size_");
        int i12 = jSONObject.getInt("_val_type_");
        ArrayList arrayList = new ArrayList(i11);
        for (int i13 = 0; i13 < i11; i13++) {
            Object obj = jSONObject.get("_list_item_" + i13);
            if (i12 == 0) {
                arrayList.add(jsonToEntity((String) obj, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else if (i12 == 1) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static byte[] a(JSONObject jSONObject) throws JSONException {
        try {
            return Base64.decode(jSONObject.getString("_byte_"));
        } catch (IllegalArgumentException e11) {
            HMSLog.e("JsonUtil", "readByte failed : " + e11.getMessage());
            return null;
        }
    }
}
