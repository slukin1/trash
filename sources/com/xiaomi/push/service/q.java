package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huobi.finance.bean.VirtualAddressInfo;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.n;
import com.xiaomi.push.y;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private static p f52584a;

    /* renamed from: a  reason: collision with other field name */
    private static a f3413a;

    public interface a {
        void a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        return null;
     */
    /* renamed from: a  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.p m3038a(android.content.Context r11) {
        /*
            java.lang.Class<com.xiaomi.push.service.q> r0 = com.xiaomi.push.service.q.class
            monitor-enter(r0)
            com.xiaomi.push.service.p r1 = f52584a     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            return r1
        L_0x0009:
            java.lang.String r1 = "mipush_account"
            r2 = 0
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "uuid"
            r2 = 0
            java.lang.String r4 = r11.getString(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "token"
            java.lang.String r5 = r11.getString(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "security"
            java.lang.String r6 = r11.getString(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "app_id"
            java.lang.String r7 = r11.getString(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "app_token"
            java.lang.String r8 = r11.getString(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "package_name"
            java.lang.String r9 = r11.getString(r1, r2)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "env_type"
            r3 = 1
            int r10 = r11.getInt(r1, r3)     // Catch:{ all -> 0x005a }
            boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x005a }
            if (r11 != 0) goto L_0x0058
            boolean r11 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x005a }
            if (r11 != 0) goto L_0x0058
            boolean r11 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x005a }
            if (r11 != 0) goto L_0x0058
            com.xiaomi.push.service.p r11 = new com.xiaomi.push.service.p     // Catch:{ all -> 0x005a }
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x005a }
            f52584a = r11     // Catch:{ all -> 0x005a }
            monitor-exit(r0)
            return r11
        L_0x0058:
            monitor-exit(r0)
            return r2
        L_0x005a:
            r11 = move-exception
            monitor-exit(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.q.m3038a(android.content.Context):com.xiaomi.push.service.p");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0051 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008d A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c0 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0133 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0179 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01e0 A[Catch:{ Exception -> 0x0084 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0208 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.xiaomi.push.service.p a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r1 = r17
            java.lang.Class<com.xiaomi.push.service.q> r2 = com.xiaomi.push.service.q.class
            monitor-enter(r2)
            java.util.TreeMap r3 = new java.util.TreeMap     // Catch:{ all -> 0x032e }
            r3.<init>()     // Catch:{ all -> 0x032e }
            r4 = 0
            java.lang.String r0 = com.xiaomi.push.i.a((android.content.Context) r1, (boolean) r4)     // Catch:{ all -> 0x032e }
            java.lang.String r5 = "devid"
            r3.put(r5, r0)     // Catch:{ all -> 0x032e }
            com.xiaomi.push.service.p r0 = f52584a     // Catch:{ all -> 0x032e }
            r5 = 1
            r6 = 0
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r0.f3412a     // Catch:{ all -> 0x032e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x032e }
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = "uuid"
            com.xiaomi.push.service.p r7 = f52584a     // Catch:{ all -> 0x032e }
            java.lang.String r7 = r7.f3412a     // Catch:{ all -> 0x032e }
            r3.put(r0, r7)     // Catch:{ all -> 0x032e }
            com.xiaomi.push.service.p r0 = f52584a     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r0.f3412a     // Catch:{ all -> 0x032e }
            java.lang.String r7 = "/"
            int r0 = r0.lastIndexOf(r7)     // Catch:{ all -> 0x032e }
            r7 = -1
            if (r0 == r7) goto L_0x0043
            com.xiaomi.push.service.p r7 = f52584a     // Catch:{ all -> 0x032e }
            java.lang.String r7 = r7.f3412a     // Catch:{ all -> 0x032e }
            int r0 = r0 + r5
            java.lang.String r0 = r7.substring(r0)     // Catch:{ all -> 0x032e }
            r7 = r0
            goto L_0x0044
        L_0x0043:
            r7 = r6
        L_0x0044:
            com.xiaomi.push.ao r0 = com.xiaomi.push.ao.a((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x032e }
            boolean r0 = a((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = "1000271"
            r12 = r0
            goto L_0x0057
        L_0x0055:
            r12 = r19
        L_0x0057:
            boolean r0 = a((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            if (r0 == 0) goto L_0x0061
            java.lang.String r0 = "420100086271"
            r13 = r0
            goto L_0x0063
        L_0x0061:
            r13 = r20
        L_0x0063:
            boolean r0 = a((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = "com.xiaomi.xmsf"
            r14 = r0
            goto L_0x006f
        L_0x006d:
            r14 = r18
        L_0x006f:
            java.lang.String r0 = "appid"
            r3.put(r0, r12)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "apptoken"
            r3.put(r0, r13)     // Catch:{ all -> 0x032e }
            android.content.pm.PackageManager r0 = r17.getPackageManager()     // Catch:{ Exception -> 0x0084 }
            r8 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r14, r8)     // Catch:{ Exception -> 0x0084 }
            goto L_0x0089
        L_0x0084:
            r0 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x032e }
            r0 = r6
        L_0x0089:
            java.lang.String r8 = "appversion"
            if (r0 == 0) goto L_0x0094
            int r0 = r0.versionCode     // Catch:{ all -> 0x032e }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x032e }
            goto L_0x0096
        L_0x0094:
            java.lang.String r0 = "0"
        L_0x0096:
            r3.put(r8, r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "sdkversion"
            r8 = 60001(0xea61, float:8.408E-41)
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "packagename"
            r3.put(r0, r14)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "model"
            java.lang.String r8 = com.xiaomi.push.k.a()     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "board"
            java.lang.String r8 = android.os.Build.BOARD     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            boolean r0 = com.xiaomi.push.j.d()     // Catch:{ all -> 0x032e }
            if (r0 != 0) goto L_0x010e
            java.lang.String r0 = ""
            java.lang.String r8 = com.xiaomi.push.i.b((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x032e }
            if (r9 != 0) goto L_0x00df
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r9.<init>()     // Catch:{ all -> 0x032e }
            r9.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = com.xiaomi.push.bc.a((java.lang.String) r8)     // Catch:{ all -> 0x032e }
            r9.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x032e }
        L_0x00df:
            java.lang.String r8 = com.xiaomi.push.i.d(r17)     // Catch:{ all -> 0x032e }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x032e }
            if (r9 != 0) goto L_0x0103
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x032e }
            if (r9 != 0) goto L_0x0103
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r9.<init>()     // Catch:{ all -> 0x032e }
            r9.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = ","
            r9.append(r0)     // Catch:{ all -> 0x032e }
            r9.append(r8)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x032e }
        L_0x0103:
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x032e }
            if (r8 != 0) goto L_0x010e
            java.lang.String r8 = "imei_md5"
            r3.put(r8, r0)     // Catch:{ all -> 0x032e }
        L_0x010e:
            java.lang.String r0 = "os"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r8.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r9 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x032e }
            r8.append(r9)     // Catch:{ all -> 0x032e }
            java.lang.String r9 = "-"
            r8.append(r9)     // Catch:{ all -> 0x032e }
            java.lang.String r9 = com.xiaomi.push.j.e()     // Catch:{ all -> 0x032e }
            r8.append(r9)     // Catch:{ all -> 0x032e }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            int r0 = com.xiaomi.push.i.a()     // Catch:{ all -> 0x032e }
            if (r0 < 0) goto L_0x013c
            java.lang.String r8 = "space_id"
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ all -> 0x032e }
            r3.put(r8, r0)     // Catch:{ all -> 0x032e }
        L_0x013c:
            java.lang.String r0 = "brand"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r8.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r9 = android.os.Build.BRAND     // Catch:{ all -> 0x032e }
            r8.append(r9)     // Catch:{ all -> 0x032e }
            java.lang.String r9 = ""
            r8.append(r9)     // Catch:{ all -> 0x032e }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "ram"
            java.lang.String r8 = com.xiaomi.push.i.a()     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = "rom"
            java.lang.String r8 = com.xiaomi.push.i.b()     // Catch:{ all -> 0x032e }
            r3.put(r0, r8)     // Catch:{ all -> 0x032e }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x032e }
            r8.<init>()     // Catch:{ all -> 0x032e }
            java.util.Set r0 = r3.entrySet()     // Catch:{ all -> 0x032e }
            java.util.Iterator r9 = r0.iterator()     // Catch:{ all -> 0x032e }
        L_0x0173:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x032e }
            if (r0 == 0) goto L_0x01c0
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x032e }
            r10 = r0
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x032e }
            java.lang.Object r0 = r10.getKey()     // Catch:{ JSONException -> 0x018e }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x018e }
            java.lang.Object r11 = r10.getValue()     // Catch:{ JSONException -> 0x018e }
            r8.put(r0, r11)     // Catch:{ JSONException -> 0x018e }
            goto L_0x0173
        L_0x018e:
            r0 = move-exception
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r11.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r15 = "failed to add data in json format: k="
            r11.append(r15)     // Catch:{ all -> 0x032e }
            java.lang.Object r15 = r10.getKey()     // Catch:{ all -> 0x032e }
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x032e }
            r11.append(r15)     // Catch:{ all -> 0x032e }
            java.lang.String r15 = ",v="
            r11.append(r15)     // Catch:{ all -> 0x032e }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x032e }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x032e }
            r11.append(r10)     // Catch:{ all -> 0x032e }
            java.lang.String r10 = ". "
            r11.append(r10)     // Catch:{ all -> 0x032e }
            r11.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x032e }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x032e }
            goto L_0x0173
        L_0x01c0:
            java.lang.String r0 = r8.toString()     // Catch:{ all -> 0x032e }
            java.lang.String r0 = com.xiaomi.push.service.av.a(r0)     // Catch:{ all -> 0x032e }
            java.util.TreeMap r8 = new java.util.TreeMap     // Catch:{ all -> 0x032e }
            r8.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r9 = "requestData"
            r8.put(r9, r0)     // Catch:{ all -> 0x032e }
            java.lang.String r9 = "keyPairVer"
            java.lang.String r10 = "1"
            r8.put(r9, r10)     // Catch:{ all -> 0x032e }
            int r9 = a((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            r10 = 2
            if (r9 >= r10) goto L_0x01fd
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x032e }
            if (r9 == 0) goto L_0x01e7
            goto L_0x01fd
        L_0x01e7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r9.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r10 = "r.data = "
            r9.append(r10)     // Catch:{ all -> 0x032e }
            r9.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x032e }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ all -> 0x032e }
            r15 = r5
            goto L_0x01fe
        L_0x01fd:
            r15 = r4
        L_0x01fe:
            java.lang.String r0 = a((android.content.Context) r1, (boolean) r15)     // Catch:{ all -> 0x032e }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x032e }
            if (r9 == 0) goto L_0x020a
            monitor-exit(r2)
            return r6
        L_0x020a:
            if (r15 == 0) goto L_0x020d
            r3 = r8
        L_0x020d:
            com.xiaomi.push.at r0 = com.xiaomi.push.av.a(r1, r0, r3)     // Catch:{ IOException -> 0x0212 }
            goto L_0x0229
        L_0x0212:
            r0 = move-exception
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r0.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r8 = "device registration request failed. "
            r0.append(r8)     // Catch:{ all -> 0x032e }
            r0.append(r3)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x032e }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x032e }
            r0 = r6
        L_0x0229:
            if (r0 == 0) goto L_0x0315
            int r3 = r0.f51402a     // Catch:{ all -> 0x032e }
            r8 = 200(0xc8, float:2.8E-43)
            if (r3 != r8) goto L_0x0315
            java.lang.String r0 = r0.a()     // Catch:{ all -> 0x032e }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x032e }
            if (r3 != 0) goto L_0x0315
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r8 = "code"
            int r8 = r3.getInt(r8)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            if (r8 != 0) goto L_0x02bb
            java.lang.String r0 = "data"
            org.json.JSONObject r0 = r3.getJSONObject(r0)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r3 = "ssecurity"
            java.lang.String r11 = r0.getString(r3)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r3 = "token"
            java.lang.String r10 = r0.getString(r3)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r3 = "userId"
            java.lang.String r0 = r0.getString(r3)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            if (r3 == 0) goto L_0x027c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r3.<init>()     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r7 = "an"
            r3.append(r7)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r7 = 6
            java.lang.String r7 = com.xiaomi.push.bc.a((int) r7)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r3.append(r7)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r7 = r3.toString()     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
        L_0x027c:
            com.xiaomi.push.service.p r3 = new com.xiaomi.push.service.p     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r8.<init>()     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r8.append(r0)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r9 = "@xiaomi.com/"
            r8.append(r9)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r8.append(r7)     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            java.lang.String r9 = r8.toString()     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            int r7 = com.xiaomi.push.y.a()     // Catch:{ JSONException -> 0x02fd, all -> 0x02e5 }
            r8 = r3
            r16 = r15
            r15 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            a((android.content.Context) r1, (com.xiaomi.push.service.p) r3)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            f52584a = r3     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            a((android.content.Context) r1, (int) r4)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            r4.<init>()     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.String r7 = "device registration is successful. "
            r4.append(r7)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            r4.append(r0)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.String r0 = r4.toString()     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            monitor-exit(r2)
            return r3
        L_0x02bb:
            r16 = r15
            java.lang.String r4 = "code"
            int r4 = r3.getInt(r4)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.String r7 = "description"
            java.lang.String r3 = r3.optString(r7)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            com.xiaomi.push.service.t.a(r1, r4, r3)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            r3.<init>()     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.String r4 = "device registration resp: "
            r3.append(r4)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            r3.append(r0)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x02e3, all -> 0x02e1 }
            goto L_0x0317
        L_0x02e1:
            r0 = move-exception
            goto L_0x02e8
        L_0x02e3:
            r0 = move-exception
            goto L_0x0300
        L_0x02e5:
            r0 = move-exception
            r16 = r15
        L_0x02e8:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r3.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r4 = "unknow throwable. "
            r3.append(r4)     // Catch:{ all -> 0x032e }
            r3.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x032e }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x032e }
            goto L_0x0317
        L_0x02fd:
            r0 = move-exception
            r16 = r15
        L_0x0300:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x032e }
            r3.<init>()     // Catch:{ all -> 0x032e }
            java.lang.String r4 = "failed to parse respone json data. "
            r3.append(r4)     // Catch:{ all -> 0x032e }
            r3.append(r0)     // Catch:{ all -> 0x032e }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x032e }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x032e }
            goto L_0x0317
        L_0x0315:
            r16 = r15
        L_0x0317:
            if (r16 == 0) goto L_0x0327
            boolean r0 = com.xiaomi.push.av.b(r17)     // Catch:{ all -> 0x032e }
            if (r0 == 0) goto L_0x0327
            int r0 = a((android.content.Context) r17)     // Catch:{ all -> 0x032e }
            int r0 = r0 + r5
            a((android.content.Context) r1, (int) r0)     // Catch:{ all -> 0x032e }
        L_0x0327:
            java.lang.String r0 = "fail to register push account. meet error."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r0)     // Catch:{ all -> 0x032e }
            monitor-exit(r2)
            return r6
        L_0x032e:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.q.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.p");
    }

    private static String a(Context context, boolean z11) {
        String a11 = b.a(context).a();
        String str = z11 ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (y.b()) {
            return "http://10.38.162.35:9085" + str;
        } else if (!n.China.name().equals(a11)) {
            return null;
        } else {
            return "https://cn.register.xmpush.xiaomi.com" + str;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m3041a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i11) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i11);
        edit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString(ZendeskIdentityStorage.UUID_KEY, pVar.f3412a);
        edit.putString(VirtualAddressInfo.LEVEL_SECURITY, pVar.f52580c);
        edit.putString("token", pVar.f52579b);
        edit.putString("app_id", pVar.f52581d);
        edit.putString(Constants.PACKAGE_NAME, pVar.f52583f);
        edit.putString("app_token", pVar.f52582e);
        edit.putInt("env_type", pVar.f52578a);
        edit.commit();
        a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m3040a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f52584a = null;
        a();
    }

    public static void a(a aVar) {
        f3413a = aVar;
    }

    public static void a() {
        a aVar = f3413a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m3039a(Context context) {
        p a11 = a(context);
        if (a11 != null && !TextUtils.isEmpty(a11.f3412a)) {
            String[] split = a11.f3412a.split(TIMMentionEditText.TIM_MENTION_TAG);
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }
}
