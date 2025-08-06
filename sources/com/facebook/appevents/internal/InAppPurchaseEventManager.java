package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.FacebookSdk;
import com.huobi.framework.im.common.GenerateUserSig;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class InAppPurchaseEventManager {
    private static final String AS_INTERFACE = "asInterface";
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    private static final String DETAILS_LIST = "DETAILS_LIST";
    private static final String GET_PURCHASES = "getPurchases";
    private static final String GET_PURCHASE_HISTORY = "getPurchaseHistory";
    private static final String GET_SKU_DETAILS = "getSkuDetails";
    private static final String INAPP = "inapp";
    private static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    private static final String INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    private static final String IN_APP_BILLING_SERVICE = "com.android.vending.billing.IInAppBillingService";
    private static final String IN_APP_BILLING_SERVICE_STUB = "com.android.vending.billing.IInAppBillingService$Stub";
    private static final String IS_BILLING_SUPPORTED = "isBillingSupported";
    private static final String ITEM_ID_LIST = "ITEM_ID_LIST";
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final int MAX_QUERY_PURCHASE_NUM = 30;
    private static final String PACKAGE_NAME = FacebookSdk.getApplicationContext().getPackageName();
    private static final int PURCHASE_EXPIRE_TIME_SEC = 86400;
    private static final String PURCHASE_INAPP_STORE = "com.facebook.internal.PURCHASE";
    private static final int PURCHASE_STOP_QUERY_TIME_SEC = 1200;
    private static final String RESPONSE_CODE = "RESPONSE_CODE";
    private static final String SKU_DETAILS_STORE = "com.facebook.internal.SKU_DETAILS";
    private static final int SKU_DETAIL_EXPIRE_TIME_SEC = 43200;
    private static final String SUBSCRIPTION = "subs";
    private static final String TAG = "com.facebook.appevents.internal.InAppPurchaseEventManager";
    private static final HashMap<String, Class<?>> classMap = new HashMap<>();
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static final SharedPreferences purchaseInappSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(PURCHASE_INAPP_STORE, 0);
    private static final SharedPreferences skuDetailSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(SKU_DETAILS_STORE, 0);

    public static Object asInterface(Context context, IBinder iBinder) {
        return invokeMethod(context, IN_APP_BILLING_SERVICE_STUB, AS_INTERFACE, (Object) null, new Object[]{iBinder});
    }

    public static void clearSkuDetailsCache() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = skuDetailSharedPrefs;
        long j11 = sharedPreferences.getLong(LAST_CLEARED_TIME, 0);
        if (j11 == 0) {
            sharedPreferences.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        } else if (currentTimeMillis - j11 > GenerateUserSig.EXPIRETIME) {
            sharedPreferences.edit().clear().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
        }
    }

    private static ArrayList<String> filterPurchases(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = purchaseInappSharedPrefs.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j11 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j11 / 1000) <= 86400) {
                    if (!purchaseInappSharedPrefs.getString(string, "").equals(string2)) {
                        edit.putString(string, string2);
                        arrayList2.add(next);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        edit.apply();
        return arrayList2;
    }

    private static Class<?> getClass(Context context, String str) {
        HashMap<String, Class<?>> hashMap = classMap;
        Class<?> cls = hashMap.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            cls = context.getClassLoader().loadClass(str);
            hashMap.put(str, cls);
            return cls;
        } catch (ClassNotFoundException unused) {
            return cls;
        }
    }

    private static Method getMethod(Class<?> cls, String str) {
        Class<String> cls2 = String.class;
        HashMap<String, Method> hashMap = methodMap;
        Method method = hashMap.get(str);
        if (method != null) {
            return method;
        }
        Class[] clsArr = null;
        char c11 = 65535;
        try {
            switch (str.hashCode()) {
                case -1801122596:
                    if (str.equals(GET_PURCHASES)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1450694211:
                    if (str.equals(IS_BILLING_SUPPORTED)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1123215065:
                    if (str.equals(AS_INTERFACE)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -594356707:
                    if (str.equals(GET_PURCHASE_HISTORY)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -573310373:
                    if (str.equals(GET_SKU_DETAILS)) {
                        c11 = 1;
                        break;
                    }
                    break;
            }
            if (c11 == 0) {
                clsArr = new Class[]{IBinder.class};
            } else if (c11 == 1) {
                clsArr = new Class[]{Integer.TYPE, cls2, cls2, Bundle.class};
            } else if (c11 == 2) {
                clsArr = new Class[]{Integer.TYPE, cls2, cls2};
            } else if (c11 == 3) {
                clsArr = new Class[]{Integer.TYPE, cls2, cls2, cls2};
            } else if (c11 == 4) {
                clsArr = new Class[]{Integer.TYPE, cls2, cls2, cls2, Bundle.class};
            }
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            hashMap.put(str, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            return method;
        }
    }

    private static ArrayList<String> getPurchaseHistory(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (isBillingSupported(context, obj, str).booleanValue()) {
            int i11 = 0;
            boolean z11 = false;
            String str2 = null;
            do {
                Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_PURCHASE_HISTORY, obj, new Object[]{6, PACKAGE_NAME, str, str2, new Bundle()});
                if (invokeMethod != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) invokeMethod;
                    if (bundle.getInt(RESPONSE_CODE) == 0 && (stringArrayList = bundle.getStringArrayList(INAPP_PURCHASE_DATA_LIST)) != null) {
                        Iterator<String> it2 = stringArrayList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            String next = it2.next();
                            try {
                                if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                    z11 = true;
                                    break;
                                }
                                arrayList.add(next);
                                i11++;
                            } catch (JSONException unused) {
                            }
                        }
                        str2 = bundle.getString(INAPP_CONTINUATION_TOKEN);
                        if (i11 >= 30 || str2 == null) {
                            break;
                        }
                    }
                }
                str2 = null;
            } while (!z11);
        }
        return arrayList;
    }

    public static ArrayList<String> getPurchaseHistoryInapp(Context context, Object obj) {
        Class<?> cls;
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj == null || (cls = getClass(context, IN_APP_BILLING_SERVICE)) == null || getMethod(cls, GET_PURCHASE_HISTORY) == null) {
            return arrayList;
        }
        return filterPurchases(getPurchaseHistory(context, obj, INAPP));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[EDGE_INSN: B:19:0x005c->B:17:0x005c ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> getPurchases(android.content.Context r9, java.lang.Object r10, java.lang.String r11) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r10 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.lang.Boolean r1 = isBillingSupported(r9, r10, r11)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x005c
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L_0x0016:
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r6 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5[r1] = r7
            r7 = 1
            java.lang.String r8 = PACKAGE_NAME
            r5[r7] = r8
            r7 = 2
            r5[r7] = r11
            r5[r6] = r3
            java.lang.String r3 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r6 = "getPurchases"
            java.lang.Object r3 = invokeMethod(r9, r3, r6, r10, r5)
            if (r3 == 0) goto L_0x0055
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r5 = "RESPONSE_CODE"
            int r5 = r3.getInt(r5)
            if (r5 != 0) goto L_0x0055
            java.lang.String r5 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r5 = r3.getStringArrayList(r5)
            if (r5 == 0) goto L_0x005c
            int r6 = r5.size()
            int r4 = r4 + r6
            r0.addAll(r5)
            java.lang.String r5 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r3 = r3.getString(r5)
            goto L_0x0056
        L_0x0055:
            r3 = r2
        L_0x0056:
            r5 = 30
            if (r4 >= r5) goto L_0x005c
            if (r3 != 0) goto L_0x0016
        L_0x005c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.InAppPurchaseEventManager.getPurchases(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    public static ArrayList<String> getPurchasesInapp(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, INAPP));
    }

    public static ArrayList<String> getPurchasesSubs(Context context, Object obj) {
        return filterPurchases(getPurchases(context, obj, SUBSCRIPTION));
    }

    public static Map<String, String> getSkuDetails(Context context, ArrayList<String> arrayList, Object obj, boolean z11) {
        Map<String, String> readSkuDetailsFromCache = readSkuDetailsFromCache(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (!readSkuDetailsFromCache.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        readSkuDetailsFromCache.putAll(getSkuDetailsFromGoogle(context, arrayList2, obj, z11));
        return readSkuDetailsFromCache;
    }

    private static Map<String, String> getSkuDetailsFromGoogle(Context context, ArrayList<String> arrayList, Object obj, boolean z11) {
        HashMap hashMap = new HashMap();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList(ITEM_ID_LIST, arrayList);
            Object[] objArr = new Object[4];
            objArr[0] = 3;
            objArr[1] = PACKAGE_NAME;
            objArr[2] = z11 ? SUBSCRIPTION : INAPP;
            objArr[3] = bundle;
            Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, GET_SKU_DETAILS, obj, objArr);
            if (invokeMethod != null) {
                Bundle bundle2 = (Bundle) invokeMethod;
                if (bundle2.getInt(RESPONSE_CODE) == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList(DETAILS_LIST);
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size()) {
                        for (int i11 = 0; i11 < arrayList.size(); i11++) {
                            hashMap.put(arrayList.get(i11), stringArrayList.get(i11));
                        }
                    }
                    writeSkuDetailsToCache(hashMap);
                }
            }
        }
        return hashMap;
    }

    public static boolean hasFreeTrialPeirod(String str) {
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString == null || optString.isEmpty()) {
                return false;
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private static Object invokeMethod(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method method;
        Class<?> cls = getClass(context, str);
        if (cls == null || (method = getMethod(cls, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = cls.cast(obj);
        }
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Boolean isBillingSupported(Context context, Object obj, String str) {
        if (obj == null) {
            return Boolean.FALSE;
        }
        boolean z11 = false;
        Object invokeMethod = invokeMethod(context, IN_APP_BILLING_SERVICE, IS_BILLING_SUPPORTED, obj, new Object[]{3, PACKAGE_NAME, str});
        if (invokeMethod != null && ((Integer) invokeMethod).intValue() == 0) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }

    private static Map<String, String> readSkuDetailsFromCache(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            String string = skuDetailSharedPrefs.getString(next, (String) null);
            if (string != null) {
                String[] split = string.split(";", 2);
                if (currentTimeMillis - Long.parseLong(split[0]) < 43200) {
                    hashMap.put(next, split[1]);
                }
            }
        }
        return hashMap;
    }

    private static void writeSkuDetailsToCache(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = skuDetailSharedPrefs.edit();
        for (Map.Entry next : map.entrySet()) {
            edit.putString((String) next.getKey(), currentTimeMillis + ";" + ((String) next.getValue()));
        }
        edit.apply();
    }
}
