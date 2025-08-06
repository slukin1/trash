package com.appsflyer.internal;

import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class m implements Runnable {
    private final bf AFKeystoreWrapper;

    public m() {
    }

    public static JSONObject AFInAppEventType(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), valueOf(next.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    private static Object valueOf(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                for (Object valueOf : (Collection) obj) {
                    jSONArray.put(valueOf(valueOf));
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < length; i11++) {
                    jSONArray2.put(valueOf(Array.get(obj, i11)));
                }
                return jSONArray2;
            } else if (obj instanceof Map) {
                return AFInAppEventType((Map<String, ?>) (Map) obj);
            } else {
                return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
            }
        } catch (Exception unused) {
            return JSONObject.NULL;
        }
    }

    public void run() {
        HttpURLConnection AFInAppEventType = AFInAppEventType();
        if (AFInAppEventType != null) {
            AFInAppEventType.disconnect();
        }
    }

    public m(bf bfVar) {
        this.AFKeystoreWrapper = bfVar;
    }

    public static Map<String, Object> AFInAppEventType(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = AFInAppEventType((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventType((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    private static List<Object> AFInAppEventType(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            Object obj = jSONArray.get(i11);
            if (obj instanceof JSONArray) {
                obj = AFInAppEventType((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventType((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v8, types: [java.net.URLConnection] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0185  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.net.HttpURLConnection AFInAppEventType() {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r2 = ""
            com.appsflyer.internal.bf r0 = r1.AFKeystoreWrapper
            java.lang.String r3 = r0.onAppOpenAttributionNative
            java.lang.String r0 = r0.AFLogger$LogLevel()
            com.appsflyer.internal.bf r4 = r1.AFKeystoreWrapper
            boolean r4 = r4.AppsFlyer2dXConversionCallback()
            com.appsflyer.internal.bf r5 = r1.AFKeystoreWrapper
            boolean r5 = r5.init()
            com.appsflyer.internal.bf r6 = r1.AFKeystoreWrapper
            boolean r6 = r6.getLevel()
            com.appsflyer.internal.bf r7 = r1.AFKeystoreWrapper
            boolean r7 = r7.values()
            byte[] r8 = r0.getBytes()
            r9 = 0
            if (r4 == 0) goto L_0x002c
            return r9
        L_0x002c:
            r4 = 0
            r10 = 1
            java.net.URL r11 = new java.net.URL     // Catch:{ all -> 0x0169 }
            r11.<init>(r3)     // Catch:{ all -> 0x0169 }
            if (r6 == 0) goto L_0x007c
            com.appsflyer.internal.aj r12 = com.appsflyer.internal.aj.valueOf()     // Catch:{ all -> 0x0169 }
            java.lang.String r13 = r11.toString()     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = "server_request"
            java.lang.String[] r15 = new java.lang.String[r10]     // Catch:{ all -> 0x0169 }
            r15[r4] = r0     // Catch:{ all -> 0x0169 }
            r12.AFInAppEventType(r14, r13, r15)     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = "UTF-8"
            byte[] r12 = r0.getBytes(r12)     // Catch:{ all -> 0x0169 }
            int r12 = r12.length     // Catch:{ all -> 0x0169 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = "call = "
            r13.<init>(r14)     // Catch:{ all -> 0x0169 }
            r13.append(r11)     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = "; size = "
            r13.append(r14)     // Catch:{ all -> 0x0169 }
            r13.append(r12)     // Catch:{ all -> 0x0169 }
            java.lang.String r14 = " byte"
            r13.append(r14)     // Catch:{ all -> 0x0169 }
            if (r12 <= r10) goto L_0x0069
            java.lang.String r12 = "s"
            goto L_0x006a
        L_0x0069:
            r12 = r2
        L_0x006a:
            r13.append(r12)     // Catch:{ all -> 0x0169 }
            java.lang.String r12 = "; body = "
            r13.append(r12)     // Catch:{ all -> 0x0169 }
            r13.append(r0)     // Catch:{ all -> 0x0169 }
            java.lang.String r0 = r13.toString()     // Catch:{ all -> 0x0169 }
            com.appsflyer.internal.am.AFKeystoreWrapper(r0)     // Catch:{ all -> 0x0169 }
        L_0x007c:
            java.lang.String r0 = "AppsFlyer"
            int r0 = r0.hashCode()     // Catch:{ all -> 0x0169 }
            android.net.TrafficStats.setThreadStatsTag(r0)     // Catch:{ all -> 0x0169 }
            java.net.URLConnection r0 = r11.openConnection()     // Catch:{ all -> 0x0169 }
            r12 = r0
            java.net.HttpURLConnection r12 = (java.net.HttpURLConnection) r12     // Catch:{ all -> 0x0169 }
            r0 = 30000(0x7530, float:4.2039E-41)
            r12.setReadTimeout(r0)     // Catch:{ all -> 0x0166 }
            r12.setConnectTimeout(r0)     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "POST"
            r12.setRequestMethod(r0)     // Catch:{ all -> 0x0166 }
            r12.setDoInput(r10)     // Catch:{ all -> 0x0166 }
            r12.setDoOutput(r10)     // Catch:{ all -> 0x0166 }
            java.lang.String r0 = "Content-Type"
            if (r7 == 0) goto L_0x00a6
            java.lang.String r13 = "application/octet-stream"
            goto L_0x00a8
        L_0x00a6:
            java.lang.String r13 = "application/json"
        L_0x00a8:
            r12.setRequestProperty(r0, r13)     // Catch:{ all -> 0x0166 }
            java.io.OutputStream r0 = r12.getOutputStream()     // Catch:{ all -> 0x0166 }
            if (r7 == 0) goto L_0x012c
            com.appsflyer.internal.bf r7 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0166 }
            java.lang.String r7 = r7.AFVersionDeclaration     // Catch:{ all -> 0x0166 }
            java.lang.Object[] r13 = new java.lang.Object[r10]     // Catch:{ all -> 0x0123 }
            r13[r4] = r7     // Catch:{ all -> 0x0123 }
            r14 = 0
            int r7 = android.widget.ExpandableListView.getPackedPositionGroup(r14)     // Catch:{ all -> 0x0123 }
            int r7 = r7 + 24
            int r16 = android.view.ViewConfiguration.getMaximumDrawingCacheSize()     // Catch:{ all -> 0x0123 }
            int r16 = r16 >> 24
            int r9 = r16 + 24
            long r17 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0123 }
            int r16 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            int r14 = r16 + -1
            char r14 = (char) r14     // Catch:{ all -> 0x0123 }
            java.lang.Object r7 = com.appsflyer.internal.a.AFKeystoreWrapper(r7, r9, r14)     // Catch:{ all -> 0x0123 }
            java.lang.Class r7 = (java.lang.Class) r7     // Catch:{ all -> 0x0123 }
            java.lang.String r9 = "AFInAppEventParameterName"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x0123 }
            java.lang.Class<java.lang.String> r15 = java.lang.String.class
            r14[r4] = r15     // Catch:{ all -> 0x0123 }
            java.lang.reflect.Method r7 = r7.getMethod(r9, r14)     // Catch:{ all -> 0x0123 }
            r9 = 0
            java.lang.Object r7 = r7.invoke(r9, r13)     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r9 = new java.lang.Object[r10]     // Catch:{ all -> 0x011a }
            r9[r4] = r8     // Catch:{ all -> 0x011a }
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r4)     // Catch:{ all -> 0x011a }
            int r8 = 24 - r8
            r13 = 0
            int r15 = android.widget.ExpandableListView.getPackedPositionGroup(r13)     // Catch:{ all -> 0x011a }
            int r15 = r15 + 24
            int r13 = android.widget.ExpandableListView.getPackedPositionGroup(r13)     // Catch:{ all -> 0x011a }
            char r13 = (char) r13     // Catch:{ all -> 0x011a }
            java.lang.Object r8 = com.appsflyer.internal.a.AFKeystoreWrapper(r8, r15, r13)     // Catch:{ all -> 0x011a }
            java.lang.Class r8 = (java.lang.Class) r8     // Catch:{ all -> 0x011a }
            java.lang.String r13 = "values"
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x011a }
            java.lang.Class<byte[]> r15 = byte[].class
            r14[r4] = r15     // Catch:{ all -> 0x011a }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r13, r14)     // Catch:{ all -> 0x011a }
            java.lang.Object r7 = r8.invoke(r7, r9)     // Catch:{ all -> 0x011a }
            r8 = r7
            byte[] r8 = (byte[]) r8     // Catch:{ all -> 0x011a }
            goto L_0x012c
        L_0x011a:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0166 }
            if (r4 == 0) goto L_0x0122
            throw r4     // Catch:{ all -> 0x0166 }
        L_0x0122:
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x0123:
            r0 = move-exception
            java.lang.Throwable r4 = r0.getCause()     // Catch:{ all -> 0x0166 }
            if (r4 == 0) goto L_0x012b
            throw r4     // Catch:{ all -> 0x0166 }
        L_0x012b:
            throw r0     // Catch:{ all -> 0x0166 }
        L_0x012c:
            r0.write(r8)     // Catch:{ all -> 0x0166 }
            r0.close()     // Catch:{ all -> 0x0166 }
            r12.connect()     // Catch:{ all -> 0x0166 }
            int r0 = r12.getResponseCode()     // Catch:{ all -> 0x0166 }
            if (r5 == 0) goto L_0x0142
            com.appsflyer.internal.ae.values()     // Catch:{ all -> 0x0166 }
            java.lang.String r2 = com.appsflyer.internal.ae.AFKeystoreWrapper((java.net.HttpURLConnection) r12)     // Catch:{ all -> 0x0166 }
        L_0x0142:
            if (r6 == 0) goto L_0x015c
            com.appsflyer.internal.aj r5 = com.appsflyer.internal.aj.valueOf()     // Catch:{ all -> 0x0166 }
            java.lang.String r6 = r11.toString()     // Catch:{ all -> 0x0166 }
            java.lang.String r7 = "server_response"
            r8 = 2
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch:{ all -> 0x0166 }
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0166 }
            r8[r4] = r9     // Catch:{ all -> 0x0166 }
            r8[r10] = r2     // Catch:{ all -> 0x0166 }
            r5.AFInAppEventType(r7, r6, r8)     // Catch:{ all -> 0x0166 }
        L_0x015c:
            r5 = 200(0xc8, float:2.8E-43)
            if (r0 != r5) goto L_0x0178
            java.lang.String r0 = "Status 200 ok"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)     // Catch:{ all -> 0x0166 }
            goto L_0x0179
        L_0x0166:
            r0 = move-exception
            r9 = r12
            goto L_0x016a
        L_0x0169:
            r0 = move-exception
        L_0x016a:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "Error while calling "
            java.lang.String r3 = r4.concat(r3)
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r3, (java.lang.Throwable) r0)
            r12 = r9
        L_0x0178:
            r4 = r10
        L_0x0179:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Connection "
            r0.<init>(r3)
            if (r4 == 0) goto L_0x0185
            java.lang.String r3 = "error"
            goto L_0x0187
        L_0x0185:
            java.lang.String r3 = "call succeeded"
        L_0x0187:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.m.AFInAppEventType():java.net.HttpURLConnection");
    }
}
