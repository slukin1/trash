package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.vulcan.model.VulcanInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ch {

    /* renamed from: a  reason: collision with root package name */
    public static Context f51493a;

    /* renamed from: a  reason: collision with other field name */
    private static a f2599a;

    /* renamed from: a  reason: collision with other field name */
    private static ch f2600a;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f2601a = false;

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, cd> f51494b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static String f51495c;

    /* renamed from: d  reason: collision with root package name */
    private static String f51496d;

    /* renamed from: a  reason: collision with other field name */
    private long f2602a;

    /* renamed from: a  reason: collision with other field name */
    private cg f2603a;

    /* renamed from: a  reason: collision with other field name */
    public b f2604a;

    /* renamed from: a  reason: collision with other field name */
    private String f2605a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, ce> f2606a;

    /* renamed from: b  reason: collision with other field name */
    private final long f2607b;

    /* renamed from: b  reason: collision with other field name */
    private String f2608b;

    /* renamed from: c  reason: collision with other field name */
    private long f2609c;

    public interface a {
        ch a(Context context, cg cgVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    public ch(Context context, cg cgVar, b bVar, String str) {
        this(context, cgVar, bVar, str, (String) null, (String) null);
    }

    public static synchronized ch a() {
        ch chVar;
        synchronized (ch.class) {
            chVar = f2600a;
            if (chVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return chVar;
    }

    private String f() {
        return "host_fallbacks";
    }

    private String g() {
        try {
            PackageInfo packageInfo = f51493a.getPackageManager().getPackageInfo(f51493a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public cd b(String str) {
        return a(str, true);
    }

    public String b() {
        return "resolver.msg.xiaomi.net";
    }

    public cd c(String str) {
        ce ceVar;
        cd a11;
        synchronized (this.f2606a) {
            a();
            ceVar = this.f2606a.get(str);
        }
        if (ceVar == null || (a11 = ceVar.a()) == null) {
            return null;
        }
        return a11;
    }

    public cd d(String str) {
        cd cdVar;
        Map<String, cd> map = f51494b;
        synchronized (map) {
            cdVar = map.get(str);
        }
        return cdVar;
    }

    public cd e(String str) {
        if (System.currentTimeMillis() - this.f2609c <= this.f2602a * 60 * 1000) {
            return null;
        }
        this.f2609c = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        cd cdVar = a((ArrayList<String>) arrayList).get(0);
        if (cdVar != null) {
            this.f2602a = 0;
            return cdVar;
        }
        long j11 = this.f2602a;
        if (j11 >= 15) {
            return null;
        }
        this.f2602a = j11 + 1;
        return null;
    }

    public ch(Context context, cg cgVar, b bVar, String str, String str2, String str3) {
        this.f2606a = new HashMap();
        this.f2605a = "0";
        this.f2602a = 0;
        this.f2607b = 15;
        this.f2609c = 0;
        this.f2608b = "isp_prov_city_country_ip";
        this.f2604a = bVar;
        if (cgVar == null) {
            this.f2603a = new cg() {
                public boolean a(String str) {
                    return true;
                }
            };
        } else {
            this.f2603a = cgVar;
        }
        this.f2605a = str;
        f51495c = str2 == null ? context.getPackageName() : str2;
        f51496d = str3 == null ? g() : str3;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2489b() {
        ArrayList arrayList;
        synchronized (this.f2606a) {
            a();
            arrayList = new ArrayList(this.f2606a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ce ceVar = this.f2606a.get(arrayList.get(size));
                if (!(ceVar == null || ceVar.a() == null)) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cd> a11 = a((ArrayList<String>) arrayList);
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (a11.get(i11) != null) {
                a((String) arrayList.get(i11), a11.get(i11));
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ch.class) {
            f2599a = aVar;
            f2600a = null;
        }
    }

    public String d() {
        InputStream inputStream;
        InputStream inputStream2;
        try {
            File file = new File(f51493a.getFilesDir(), f());
            if (file.isFile()) {
                inputStream = new FileInputStream(file);
                try {
                    inputStream2 = new BufferedInputStream(inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    inputStream2 = null;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        x.a((Closeable) inputStream2);
                        x.a((Closeable) inputStream);
                    }
                }
                try {
                    String str = new String(h.a(a(), x.a(inputStream2)), StandardCharsets.UTF_8);
                    com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = " + str);
                    x.a((Closeable) inputStream2);
                    x.a((Closeable) inputStream);
                    return str;
                } catch (Throwable th3) {
                    th = th3;
                    com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
                    return null;
                }
            } else {
                x.a((Closeable) null);
                x.a((Closeable) null);
                return null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = null;
            inputStream = inputStream2;
            com.xiaomi.channel.commonutils.logger.b.a("load host exception " + th.getMessage());
            return null;
        }
    }

    public static synchronized void a(Context context, cg cgVar, b bVar, String str, String str2, String str3) {
        synchronized (ch.class) {
            Context applicationContext = context.getApplicationContext();
            f51493a = applicationContext;
            if (applicationContext == null) {
                f51493a = context;
            }
            if (f2600a == null) {
                a aVar = f2599a;
                if (aVar == null) {
                    f2600a = new ch(context, cgVar, bVar, str, str2, str3);
                } else {
                    f2600a = aVar.a(context, cgVar, bVar, str);
                }
            }
        }
    }

    public String c() {
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.f2606a) {
            for (Map.Entry next : this.f2606a.entrySet()) {
                sb2.append((String) next.getKey());
                sb2.append(":\n");
                sb2.append(((ce) next.getValue()).toString());
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public String e() {
        if ("com.xiaomi.xmsf".equals(f51495c)) {
            return f51495c;
        }
        return f51495c + ":pushservice";
    }

    /* renamed from: e  reason: collision with other method in class */
    public void m2493e() {
        synchronized (this.f2606a) {
            for (ce a11 : this.f2606a.values()) {
                a11.a(true);
            }
            while (true) {
                for (boolean z11 = false; !z11; z11 = true) {
                    for (String next : this.f2606a.keySet()) {
                        if (this.f2606a.get(next).a().isEmpty()) {
                            this.f2606a.remove(next);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.xiaomi.push.aw] */
    /* renamed from: a  reason: collision with other method in class */
    public static String m2482a() {
        if (f51493a == null) {
            return "unknown";
        }
        try {
            ? a11 = av.a();
            if (a11 == 0) {
                return "unknown";
            }
            if (a11.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return a11.a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + a11.b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m2490b(String str) {
        synchronized (this.f2606a) {
            this.f2606a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONArray != null) {
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        ce a11 = new ce().a(optJSONArray.getJSONObject(i11));
                        this.f2606a.put(a11.a(), a11);
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
                if (optJSONArray2 != null) {
                    for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i12);
                        String optString = jSONObject2.optString(VulcanInfo.HOST);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                cd a12 = new cd(optString).a(jSONObject2);
                                f51494b.put(a12.f2596b, a12);
                                com.xiaomi.channel.commonutils.logger.b.a("load local reserved host for " + a12.f2596b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public cd m2484a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0055=Splitter:B:18:0x0055, B:27:0x0065=Splitter:B:27:0x0065} */
    /* renamed from: c  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2491c() {
        /*
            r6 = this;
            java.util.Map<java.lang.String, com.xiaomi.push.ce> r0 = r6.f2606a
            monitor-enter(r0)
            r1 = 0
            org.json.JSONObject r2 = r6.a()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r3.<init>()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r4 = "persist host fallbacks = "
            r3.append(r4)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r3.append(r2)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            com.xiaomi.channel.commonutils.logger.b.b(r3)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            if (r3 != 0) goto L_0x0054
            android.content.Context r3 = f51493a     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.lang.String r4 = r6.f()     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            r5 = 0
            java.io.FileOutputStream r3 = r3.openFileOutput(r4, r5)     // Catch:{ Exception -> 0x0061, all -> 0x005c }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            byte[] r1 = r6.a()     // Catch:{ Exception -> 0x004c }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x004c }
            byte[] r2 = r2.getBytes(r5)     // Catch:{ Exception -> 0x004c }
            byte[] r1 = com.xiaomi.push.h.b(r1, r2)     // Catch:{ Exception -> 0x004c }
            r4.write(r1)     // Catch:{ Exception -> 0x004c }
            r4.flush()     // Catch:{ Exception -> 0x004c }
            r1 = r4
            goto L_0x0055
        L_0x004c:
            r1 = move-exception
            goto L_0x0065
        L_0x004e:
            r2 = move-exception
            r4 = r1
            goto L_0x005f
        L_0x0051:
            r2 = move-exception
            r4 = r1
            goto L_0x0064
        L_0x0054:
            r3 = r1
        L_0x0055:
            com.xiaomi.push.x.a((java.io.Closeable) r1)     // Catch:{ all -> 0x008b }
        L_0x0058:
            com.xiaomi.push.x.a((java.io.Closeable) r3)     // Catch:{ all -> 0x008b }
            goto L_0x0081
        L_0x005c:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x005f:
            r1 = r2
            goto L_0x0084
        L_0x0061:
            r2 = move-exception
            r3 = r1
            r4 = r3
        L_0x0064:
            r1 = r2
        L_0x0065:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0083 }
            r2.<init>()     // Catch:{ all -> 0x0083 }
            java.lang.String r5 = "persist bucket failure: "
            r2.append(r5)     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0083 }
            r2.append(r1)     // Catch:{ all -> 0x0083 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0083 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r1)     // Catch:{ all -> 0x0083 }
            com.xiaomi.push.x.a((java.io.Closeable) r4)     // Catch:{ all -> 0x008b }
            goto L_0x0058
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            return
        L_0x0083:
            r1 = move-exception
        L_0x0084:
            com.xiaomi.push.x.a((java.io.Closeable) r4)     // Catch:{ all -> 0x008b }
            com.xiaomi.push.x.a((java.io.Closeable) r3)     // Catch:{ all -> 0x008b }
            throw r1     // Catch:{ all -> 0x008b }
        L_0x008b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ch.m2491c():void");
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m2492d() {
        String e11 = e();
        try {
            File file = new File(f51493a.getFilesDir(), e11);
            if (file.exists()) {
                boolean delete = file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Delete old host fallbacks file ");
                sb2.append(e11);
                sb2.append(delete ? " successful." : " failed.");
                com.xiaomi.channel.commonutils.logger.b.a(sb2.toString());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + e11 + " does not exist.");
        } catch (Exception e12) {
            com.xiaomi.channel.commonutils.logger.b.a("Delete old host fallbacks file " + e11 + " error: " + e12.getMessage());
        }
    }

    public cd a(String str, boolean z11) {
        cd e11;
        com.xiaomi.channel.commonutils.logger.b.b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z11));
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        } else if (!this.f2603a.a(str)) {
            return null;
        } else {
            cd c11 = c(str);
            if (c11 != null && c11.b()) {
                return c11;
            }
            if (!z11 || !av.a(f51493a) || (e11 = e(str)) == null) {
                return new cd(str, c11) {

                    /* renamed from: a  reason: collision with root package name */
                    public cd f51498a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ cd f51499b;

                    {
                        this.f51499b = r3;
                        this.f51498a = r3;
                        this.f2596b = this.f2596b;
                        if (r3 != null) {
                            this.f51486f = r3.f51486f;
                        }
                    }

                    public synchronized ArrayList<String> a(boolean z11) {
                        ArrayList<String> arrayList;
                        arrayList = new ArrayList<>();
                        cd cdVar = this.f51498a;
                        if (cdVar != null) {
                            arrayList.addAll(cdVar.a(true));
                        }
                        Map<String, cd> map = ch.f51494b;
                        synchronized (map) {
                            cd cdVar2 = map.get(this.f2596b);
                            if (cdVar2 != null) {
                                Iterator<String> it2 = cdVar2.a(true).iterator();
                                while (it2.hasNext()) {
                                    String next = it2.next();
                                    if (arrayList.indexOf(next) == -1) {
                                        arrayList.add(next);
                                    }
                                }
                                arrayList.remove(this.f2596b);
                                arrayList.add(this.f2596b);
                            }
                        }
                        return arrayList;
                    }

                    public boolean b() {
                        return false;
                    }

                    public synchronized void a(String str, cc ccVar) {
                        cd cdVar = this.f51498a;
                        if (cdVar != null) {
                            cdVar.a(str, ccVar);
                        }
                    }
                };
            }
            return e11;
        }
    }

    private ArrayList<cd> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        ArrayList<String> arrayList2 = arrayList;
        e();
        synchronized (this.f2606a) {
            a();
            for (String next : this.f2606a.keySet()) {
                if (!arrayList2.contains(next)) {
                    arrayList2.add(next);
                }
            }
        }
        Map<String, cd> map = f51494b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                cd cdVar = (cd) obj;
                if (!cdVar.b()) {
                    f51494b.remove(cdVar.f2596b);
                }
            }
        }
        if (!arrayList2.contains(b())) {
            arrayList2.add(b());
        }
        ArrayList<cd> arrayList3 = new ArrayList<>(arrayList.size());
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList3.add((Object) null);
        }
        try {
            String str = av.d(f51493a) ? "wifi" : "wap";
            String a11 = a(arrayList2, str, this.f2605a, true);
            if (!TextUtils.isEmpty(a11)) {
                JSONObject jSONObject3 = new JSONObject(a11);
                com.xiaomi.channel.commonutils.logger.b.b(a11);
                if ("OK".equalsIgnoreCase(jSONObject3.getString("S"))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString(UserDataStore.COUNTRY);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i12 = 0;
                    while (i12 < arrayList.size()) {
                        String str2 = arrayList2.get(i12);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str2);
                        if (optJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + str2);
                            jSONObject = jSONObject5;
                        } else {
                            cd cdVar2 = new cd(str2);
                            int i13 = 0;
                            while (i13 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i13);
                                if (!TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                    cdVar2.a(new ck(string6, optJSONArray.length() - i13));
                                } else {
                                    jSONObject2 = jSONObject5;
                                }
                                i13++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList3.set(i12, cdVar2);
                            cdVar2.f51487g = string5;
                            cdVar2.f51483c = string;
                            cdVar2.f51485e = string3;
                            cdVar2.f51486f = string4;
                            cdVar2.f51484d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                cdVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                cdVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                cdVar2.a(((long) jSONObject4.getInt("ttl")) * 1000);
                            }
                            a(cdVar2.a());
                        }
                        i12++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j11 = Period.WEEK_MILLS;
                        if (jSONObject4.has("reserved-ttl")) {
                            j11 = ((long) jSONObject4.getInt("reserved-ttl")) * 1000;
                        }
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next2 = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next2);
                            if (optJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.a("no bucket found for " + next2);
                            } else {
                                cd cdVar3 = new cd(next2);
                                cdVar3.a(j11);
                                for (int i14 = 0; i14 < optJSONArray2.length(); i14++) {
                                    String string7 = optJSONArray2.getString(i14);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cdVar3.a(new ck(string7, optJSONArray2.length() - i14));
                                    }
                                }
                                Map<String, cd> map2 = f51494b;
                                synchronized (map2) {
                                    if (this.f2603a.a(next2)) {
                                        map2.put(next2, cdVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.b.a("failed to get bucket " + e11.getMessage());
        }
        for (int i15 = 0; i15 < arrayList.size(); i15++) {
            cd cdVar4 = arrayList3.get(i15);
            if (cdVar4 != null) {
                a(arrayList2.get(i15), cdVar4);
            }
        }
        c();
        return arrayList3;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z11) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<au> arrayList3 = new ArrayList<>();
        arrayList3.add(new as("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new as("conpt", a(av.a(f51493a))));
        }
        if (z11) {
            arrayList3.add(new as("reserved", "1"));
        }
        arrayList3.add(new as(ZendeskIdentityStorage.UUID_KEY, str2));
        arrayList3.add(new as("list", bc.a((Collection<?>) arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new as("countrycode", com.xiaomi.push.service.b.a(f51493a).b()));
        arrayList3.add(new as("push_sdk_vc", String.valueOf(60001)));
        String b11 = b();
        cd c11 = c(b11);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", new Object[]{b11});
        if (c11 == null) {
            arrayList2.add(format);
            Map<String, cd> map = f51494b;
            synchronized (map) {
                cd cdVar = map.get(b11);
                if (cdVar != null) {
                    Iterator<String> it2 = cdVar.a(true).iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", new Object[]{it2.next()}));
                    }
                }
            }
        } else {
            arrayList2 = c11.a(format);
        }
        Iterator<String> it3 = arrayList2.iterator();
        IOException e11 = null;
        while (it3.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it3.next()).buildUpon();
            for (au auVar : arrayList3) {
                buildUpon.appendQueryParameter(auVar.a(), auVar.b());
            }
            try {
                b bVar = this.f2604a;
                if (bVar == null) {
                    return av.a(f51493a, new URL(buildUpon.toString()));
                }
                return bVar.a(buildUpon.toString());
            } catch (IOException e12) {
                e11 = e12;
            }
        }
        if (e11 == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.a("network exception: " + e11.getMessage());
        throw e11;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2486a() {
        synchronized (this.f2606a) {
            this.f2606a.clear();
        }
    }

    public void a(String str, cd cdVar) {
        if (TextUtils.isEmpty(str) || cdVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + ", " + cdVar);
        } else if (this.f2603a.a(str)) {
            synchronized (this.f2606a) {
                a();
                if (this.f2606a.containsKey(str)) {
                    this.f2606a.get(str).a(cdVar);
                } else {
                    ce ceVar = new ce(str);
                    ceVar.a(cdVar);
                    this.f2606a.put(str, ceVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2488a() {
        synchronized (this.f2606a) {
            if (f2601a) {
                return true;
            }
            f2601a = true;
            this.f2606a.clear();
            try {
                String d11 = d();
                if (!TextUtils.isEmpty(d11)) {
                    b(d11);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.a("load bucket failure: " + th2.getMessage());
            }
        }
        return false;
    }

    public static void a(String str, String str2) {
        Map<String, cd> map = f51494b;
        cd cdVar = map.get(str);
        synchronized (map) {
            if (cdVar == null) {
                cd cdVar2 = new cd(str);
                cdVar2.a((long) Period.WEEK_MILLS);
                cdVar2.a(str2);
                map.put(str, cdVar2);
            } else {
                cdVar.a(str2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private byte[] m2483a() {
        return bb.a(f51493a.getPackageName() + "_key_salt");
    }

    public static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i11 = 0; i11 < bytes.length; i11++) {
                byte b11 = bytes[i11];
                byte b12 = b11 & 240;
                if (b12 != 240) {
                    bytes[i11] = (byte) (((b11 & 15) ^ ((byte) (((b11 >> 4) + length) & 15))) | b12);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2487a(String str) {
        this.f2608b = str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m2485a() {
        JSONObject jSONObject;
        synchronized (this.f2606a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (ce a11 : this.f2606a.values()) {
                jSONArray.put(a11.a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cd a12 : f51494b.values()) {
                jSONArray2.put(a12.a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
