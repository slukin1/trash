package com.mob.tools.b;

import android.app.ActivityManager;
import android.app.Application;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Proxy;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Looper;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.mob.commons.CSCenter;
import com.mob.commons.MobMeta;
import com.mob.commons.MobProduct;
import com.mob.commons.a.l;
import com.mob.commons.d;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.c;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.NtFetcher;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.b;
import com.mob.tools.utils.f;
import com.mob.tools.utils.g;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f27759b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27760a;

    private b(Context context) {
        this.f27760a = context.getApplicationContext();
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f27759b == null && context != null) {
                f27759b = new b(context);
            }
            bVar = f27759b;
        }
        return bVar;
    }

    private Set<String> aA() {
        HashSet hashSet = new HashSet();
        if (d.b()) {
            for (int i11 = 10000; i11 <= 13000; i11++) {
                String[] strArr = (String[]) ReflectHelper.invokeInstanceMethod(this.f27760a.getPackageManager(), "getPackagesForUid", new Object[]{Integer.valueOf(i11)}, new Class[]{Integer.TYPE}, null);
                if (strArr != null && !TextUtils.isEmpty(strArr[0]) && !strArr[0].startsWith(l.a("035d0elegemfkelelfk%hgBemSefAedekelejedem4jDekej*di8ekeleg_ghUejggek8eNekfd"))) {
                    hashSet.add(strArr[0]);
                }
            }
        }
        return hashSet;
    }

    private boolean aB() {
        try {
            return ((Boolean) ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(l.a("016ef0edekelejedemelgjemgmQg ggehfk")), l.a("019;ejgjgm<g-ggehfkfkNg!ekfeelKffgdjg1ed"), new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private String at() {
        try {
            String l11 = c.a(this.f27760a).d().l();
            return Data.byteToHex(Data.SHA1(null + ":" + null + ":" + l11));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    private String au() {
        HashMap hashMap;
        HashMap<String, Object> av2 = av();
        if (av2 == null || (hashMap = (HashMap) av2.get(l.a("010[edIg.eeejQdgAff6f=fgel"))) == null) {
            return null;
        }
        try {
            return Data.byteToHex(Data.SHA1(null + ":" + null + ":" + ((String) hashMap.get(l.a("0050egeledBgh")))));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.HashMap<java.lang.String, java.lang.Object> av() {
        /*
            r8 = this;
            android.content.Context r0 = r8.f27760a
            java.lang.String r1 = "014dKelegeg!m(edgggjJm!emedehejed"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)
            r2 = 1
            java.io.File r0 = com.mob.tools.utils.ResHelper.getDataCacheFile(r0, r1, r2)
            boolean r1 = r0.exists()
            r3 = 0
            if (r1 == 0) goto L_0x0067
            long r4 = r0.length()
            r6 = 0
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0067
            r1 = 0
            r4 = 2
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x003c }
            r5.<init>(r0)     // Catch:{ all -> 0x003c }
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch:{ all -> 0x003a }
            r6.<init>(r5)     // Catch:{ all -> 0x003a }
            java.lang.Object r7 = r6.readObject()     // Catch:{ all -> 0x003e }
            java.util.HashMap r7 = (java.util.HashMap) r7     // Catch:{ all -> 0x003e }
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r1] = r6
            r4[r2] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            goto L_0x0048
        L_0x003a:
            r6 = r3
            goto L_0x003e
        L_0x003c:
            r5 = r3
            r6 = r5
        L_0x003e:
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r1] = r6
            r4[r2] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            r7 = r3
        L_0x0048:
            if (r7 == 0) goto L_0x0050
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L_0x0054
        L_0x0050:
            java.util.HashMap r7 = r8.a((java.io.File) r0)
        L_0x0054:
            boolean r0 = r7.isEmpty()
            if (r0 != 0) goto L_0x0067
            java.lang.String r0 = "0101edXg1eeejDdgNff6f!fgel"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object r0 = r7.get(r0)
            java.util.HashMap r0 = (java.util.HashMap) r0
            return r0
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.av():java.util.HashMap");
    }

    private String aw() {
        InputStream inputStream;
        ObjectInputStream objectInputStream;
        File cacheRootFile;
        File file = new File(t(), l.a("008,fm'ieBekGg'fmgmjd"));
        if (file.exists()) {
            File file2 = new File(file, l.a("003$emedfi"));
            if (file2.exists() && (cacheRootFile = ResHelper.getCacheRootFile(this.f27760a, l.a("003-emedfi"))) != null && file2.renameTo(cacheRootFile)) {
                file2.delete();
            }
        }
        File cacheRootFile2 = ResHelper.getCacheRootFile(this.f27760a, l.a("003%emedfi"));
        String str = null;
        if (cacheRootFile2 != null && !cacheRootFile2.exists()) {
            return null;
        }
        try {
            inputStream = new FileInputStream(cacheRootFile2);
            try {
                objectInputStream = new ObjectInputStream(inputStream);
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = null;
                try {
                    MobLog.getInstance().d(th);
                    return str;
                } finally {
                    v.a(objectInputStream, inputStream);
                }
            }
            try {
                Object readObject = objectInputStream.readObject();
                if (readObject != null && (readObject instanceof char[])) {
                    str = String.valueOf((char[]) readObject);
                }
                v.a(objectInputStream, inputStream);
            } catch (Throwable th3) {
                th = th3;
                MobLog.getInstance().d(th);
                return str;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            inputStream = objectInputStream;
            MobLog.getInstance().d(th);
            return str;
        }
        return str;
    }

    private HashMap<String, String> ax() {
        try {
            return (HashMap) ResHelper.readObjectFromFile(ResHelper.getDataCacheFile(this.f27760a, l.a("004:em=efTgj")).getAbsolutePath());
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            ResHelper.getDataCacheFile(this.f27760a, l.a("004Xem7efAgj")).delete();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c7 A[SYNTHETIC, Splitter:B:44:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<java.lang.String> ay() {
        /*
            r15 = this;
            java.lang.String r0 = "007Ged,g^gj>j-ekelfd"
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            boolean r2 = com.mob.commons.d.b()
            if (r2 == 0) goto L_0x00e9
            java.lang.String r2 = "0056egQgXejheeh"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            java.lang.String r3 = r15.c()
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 != 0) goto L_0x00e9
            boolean r2 = com.mob.tools.b.j.a()
            if (r2 == 0) goto L_0x00e9
            r2 = 2
            r3 = 1
            r4 = 3
            r5 = 0
            r6 = 0
            java.lang.String r7 = "016k5egjg^h_ejgj8j>jgFkedXfiVe<fk gZgj"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x00ad }
            java.lang.Object r7 = com.mob.commons.v.c(r7)     // Catch:{ all -> 0x00ad }
            java.lang.String r8 = "014>fkJgj?ff1fk9eh1j^fm>jAek%geBeg"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00a7 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a7 }
            java.lang.Object r8 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r8, r9)     // Catch:{ all -> 0x00a7 }
            java.io.InputStream r8 = (java.io.InputStream) r8     // Catch:{ all -> 0x00a7 }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a2 }
            java.lang.String r10 = "utf-8"
            r9.<init>(r8, r10)     // Catch:{ all -> 0x00a2 }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ all -> 0x009d }
            r10.<init>(r9)     // Catch:{ all -> 0x009d }
            java.lang.String r5 = r10.readLine()     // Catch:{ all -> 0x009b }
        L_0x0050:
            if (r5 == 0) goto L_0x0084
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x009b }
            int r11 = r5.length()     // Catch:{ all -> 0x009b }
            r12 = 8
            if (r11 <= r12) goto L_0x007f
            java.lang.String r11 = r5.substring(r6, r12)     // Catch:{ all -> 0x009b }
            java.lang.String r13 = "008kedNfiUeAfk*gl"
            java.lang.String r13 = com.mob.commons.a.l.a((java.lang.String) r13)     // Catch:{ all -> 0x009b }
            boolean r11 = r11.equalsIgnoreCase(r13)     // Catch:{ all -> 0x009b }
            if (r11 == 0) goto L_0x007f
            java.lang.String r5 = r5.substring(r12)     // Catch:{ all -> 0x009b }
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x009b }
            boolean r11 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x009b }
            if (r11 != 0) goto L_0x007f
            r1.add(r5)     // Catch:{ all -> 0x009b }
        L_0x007f:
            java.lang.String r5 = r10.readLine()     // Catch:{ all -> 0x009b }
            goto L_0x0050
        L_0x0084:
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r6] = r10
            r4[r3] = r9
            r4[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r7 == 0) goto L_0x00e9
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x00e9 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x00e9 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r2)     // Catch:{ all -> 0x00e9 }
            goto L_0x00e9
        L_0x009b:
            r5 = move-exception
            goto L_0x00b3
        L_0x009d:
            r10 = move-exception
            r14 = r10
            r10 = r5
            r5 = r14
            goto L_0x00b3
        L_0x00a2:
            r9 = move-exception
            r10 = r5
            r5 = r9
            r9 = r10
            goto L_0x00b3
        L_0x00a7:
            r8 = move-exception
            r9 = r5
            r10 = r9
            r5 = r8
            r8 = r10
            goto L_0x00b3
        L_0x00ad:
            r7 = move-exception
            r8 = r5
            r9 = r8
            r10 = r9
            r5 = r7
            r7 = r10
        L_0x00b3:
            com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00d1 }
            r11.w((java.lang.Throwable) r5)     // Catch:{ all -> 0x00d1 }
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r6] = r10
            r4[r3] = r9
            r4[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r7 == 0) goto L_0x00e9
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x00e9 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x00e9 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r2)     // Catch:{ all -> 0x00e9 }
            goto L_0x00e9
        L_0x00d1:
            r1 = move-exception
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r6] = r10
            r4[r3] = r9
            r4[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r7 == 0) goto L_0x00e8
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x00e8 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x00e8 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r2)     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            throw r1
        L_0x00e9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.ay():java.util.Set");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e3 A[SYNTHETIC, Splitter:B:43:0x00e3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Set<java.lang.String> az() {
        /*
            r15 = this;
            java.lang.String r0 = "007.ed8gTgjAj$ekelfd"
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            boolean r2 = com.mob.commons.d.b()
            if (r2 == 0) goto L_0x0105
            r2 = 2
            r3 = 1
            r4 = 3
            r5 = 0
            r6 = 0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            r7.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = "032d$egedjg9ked:fi[e'fk)gYjgefeh(g=ekfdil2edjPejeeej4j.ejPg^gjjgil1eWjg"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00c9 }
            r7.append(r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = "026efZedekelejedemejBfjgfj,emEedj1ejel!fFemidgefffh"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00c9 }
            r7.append(r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = " "
            r7.append(r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = "008>ililehgj=gHekjggi"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00c9 }
            r7.append(r8)     // Catch:{ all -> 0x00c9 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00c9 }
            java.lang.Object r7 = com.mob.commons.v.c(r7)     // Catch:{ all -> 0x00c9 }
            java.lang.String r8 = "014Rfk5gjUff^fk ehCj[fm9jQekTgeIeg"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00c3 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x00c3 }
            java.lang.Object r8 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r8, r9)     // Catch:{ all -> 0x00c3 }
            java.io.InputStream r8 = (java.io.InputStream) r8     // Catch:{ all -> 0x00c3 }
            if (r8 == 0) goto L_0x00ab
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x00a6 }
            java.lang.String r10 = "utf-8"
            r9.<init>(r8, r10)     // Catch:{ all -> 0x00a6 }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ all -> 0x00a1 }
            r10.<init>(r9)     // Catch:{ all -> 0x00a1 }
            java.lang.String r5 = r10.readLine()     // Catch:{ all -> 0x009f }
            java.lang.String r11 = "012kedRfi=eNfkXgBfh5e@eg!g4jj"
            java.lang.String r11 = com.mob.commons.a.l.a((java.lang.String) r11)     // Catch:{ all -> 0x009f }
        L_0x0065:
            if (r5 == 0) goto L_0x009d
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x009f }
            int r12 = r5.length()     // Catch:{ all -> 0x009f }
            int r13 = r11.length()     // Catch:{ all -> 0x009f }
            if (r12 <= r13) goto L_0x0098
            int r12 = r11.length()     // Catch:{ all -> 0x009f }
            java.lang.String r12 = r5.substring(r6, r12)     // Catch:{ all -> 0x009f }
            boolean r12 = r12.equalsIgnoreCase(r11)     // Catch:{ all -> 0x009f }
            if (r12 == 0) goto L_0x0098
            int r12 = r11.length()     // Catch:{ all -> 0x009f }
            java.lang.String r5 = r5.substring(r12)     // Catch:{ all -> 0x009f }
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x009f }
            boolean r12 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x009f }
            if (r12 != 0) goto L_0x0098
            r1.add(r5)     // Catch:{ all -> 0x009f }
        L_0x0098:
            java.lang.String r5 = r10.readLine()     // Catch:{ all -> 0x009f }
            goto L_0x0065
        L_0x009d:
            r5 = r10
            goto L_0x00ac
        L_0x009f:
            r5 = move-exception
            goto L_0x00cf
        L_0x00a1:
            r10 = move-exception
            r14 = r10
            r10 = r5
            r5 = r14
            goto L_0x00cf
        L_0x00a6:
            r9 = move-exception
            r10 = r5
            r5 = r9
            r9 = r10
            goto L_0x00cf
        L_0x00ab:
            r9 = r5
        L_0x00ac:
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r6] = r5
            r4[r3] = r9
            r4[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r7 == 0) goto L_0x0105
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x0105 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0105 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r2)     // Catch:{ all -> 0x0105 }
            goto L_0x0105
        L_0x00c3:
            r8 = move-exception
            r9 = r5
            r10 = r9
            r5 = r8
            r8 = r10
            goto L_0x00cf
        L_0x00c9:
            r7 = move-exception
            r8 = r5
            r9 = r8
            r10 = r9
            r5 = r7
            r7 = r10
        L_0x00cf:
            com.mob.tools.log.NLog r11 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x00ed }
            r11.w((java.lang.Throwable) r5)     // Catch:{ all -> 0x00ed }
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r6] = r10
            r4[r3] = r9
            r4[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r7 == 0) goto L_0x0105
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x0105 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0105 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r2)     // Catch:{ all -> 0x0105 }
            goto L_0x0105
        L_0x00ed:
            r1 = move-exception
            java.io.Closeable[] r4 = new java.io.Closeable[r4]
            r4[r6] = r10
            r4[r3] = r9
            r4[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r4)
            if (r7 == 0) goto L_0x0104
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x0104 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0104 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r2)     // Catch:{ all -> 0x0104 }
        L_0x0104:
            throw r1
        L_0x0105:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.az():java.util.Set");
    }

    public static Context x() {
        return v.a();
    }

    public boolean A() {
        Object systemServiceSafe;
        if (!d.d() || !CSCenter.getInstance().isWifiDataEnable() || !DH.SyncMtd.checkPermission(l.a("036efCedekelejedemGkg0ekegejgjgjejel6fGemfeglgefhjehjeihgffhdffeifmgdgegdhj")) || (systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("0041ghejfgej"))) == null) {
            return false;
        }
        return ((Boolean) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, l.a("0090gj8je[ek%jNfmDdef"), Boolean.FALSE, new Object[0])).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (r5 == null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        r3.add(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.HashMap<java.lang.String, java.lang.Object> B() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ all -> 0x0085 }
            java.lang.String r2 = "013mk$ekel6dmdkJehej fQfgel"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)     // Catch:{ all -> 0x0085 }
            r1.<init>(r2)     // Catch:{ all -> 0x0085 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0085 }
            r2.<init>(r1)     // Catch:{ all -> 0x0085 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0085 }
            r3.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = "010k$ekel@dgNgjgjelekgj"
            java.lang.String r4 = com.mob.commons.a.l.a((java.lang.String) r4)     // Catch:{ all -> 0x0085 }
            r0.put(r4, r3)     // Catch:{ all -> 0x0085 }
            r4 = 0
        L_0x0024:
            r5 = r4
        L_0x0025:
            java.lang.String r6 = r2.readLine()     // Catch:{ all -> 0x0085 }
            if (r6 == 0) goto L_0x007e
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0085 }
            if (r7 == 0) goto L_0x0037
            if (r5 == 0) goto L_0x0024
            r3.add(r5)     // Catch:{ all -> 0x0085 }
            goto L_0x0024
        L_0x0037:
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0085 }
            java.lang.String r7 = "009kAekel8dgDgjgjelek"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x0085 }
            boolean r7 = r6.startsWith(r7)     // Catch:{ all -> 0x0085 }
            if (r7 == 0) goto L_0x0051
            if (r5 == 0) goto L_0x004c
            r3.add(r5)     // Catch:{ all -> 0x0085 }
        L_0x004c:
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0085 }
            r5.<init>()     // Catch:{ all -> 0x0085 }
        L_0x0051:
            java.lang.String r7 = ":"
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ all -> 0x0085 }
            int r7 = r6.length     // Catch:{ all -> 0x0085 }
            r8 = 1
            if (r7 <= r8) goto L_0x0025
            r7 = 0
            if (r5 != 0) goto L_0x006e
            r7 = r6[r7]     // Catch:{ all -> 0x0085 }
            java.lang.String r7 = r7.trim()     // Catch:{ all -> 0x0085 }
            r6 = r6[r8]     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0085 }
            r0.put(r7, r6)     // Catch:{ all -> 0x0085 }
            goto L_0x0025
        L_0x006e:
            r7 = r6[r7]     // Catch:{ all -> 0x0085 }
            java.lang.String r7 = r7.trim()     // Catch:{ all -> 0x0085 }
            r6 = r6[r8]     // Catch:{ all -> 0x0085 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0085 }
            r5.put(r7, r6)     // Catch:{ all -> 0x0085 }
            goto L_0x0025
        L_0x007e:
            r2.close()     // Catch:{ all -> 0x0085 }
            r1.close()     // Catch:{ all -> 0x0085 }
            goto L_0x008d
        L_0x0085:
            r1 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.d(r1)
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.B():java.util.HashMap");
    }

    public ArrayList<ArrayList<String>> C() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                FileReader fileReader = new FileReader(l.a("017mk.ekel9dmjjXfd m3edekejeeSgIekgj"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (!TextUtils.isEmpty(readLine)) {
                        String[] split = readLine.trim().split(" ");
                        if (split.length > 1) {
                            ArrayList arrayList2 = new ArrayList();
                            for (String str : split) {
                                if (!TextUtils.isEmpty(str)) {
                                    arrayList2.add(str.trim());
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    public String D() {
        String a11 = e.a(this.f27760a).a(l.a("014,ekelemfiGg2ek1fgh,emefOgBegeh"), "0");
        return a11 == null ? "0" : a11;
    }

    public HashMap<String, HashMap<String, Long>> E() {
        long j11;
        long j12;
        long j13;
        long j14;
        HashMap<String, HashMap<String, Long>> hashMap = new HashMap<>();
        String[] strArr = {l.a("006EgjedCde(eked"), l.a("004Red_eje")};
        for (int i11 = 0; i11 < 2; i11++) {
            String str = strArr[i11];
            HashMap hashMap2 = new HashMap();
            hashMap2.put("available", -1L);
            hashMap2.put(l.a("004Vfgek9gg"), -1L);
            hashMap2.put(l.a("005jKel?jeh"), -1L);
            hashMap.put(str, hashMap2);
        }
        HashMap hashMap3 = new HashMap();
        String t11 = t();
        if (t11 != null) {
            hashMap3.put(l.a("006 gjed[de<eked"), new StatFs(t11));
        }
        File dataDirectory = Environment.getDataDirectory();
        if (dataDirectory != null) {
            hashMap3.put(l.a("004Ued4eje"), new StatFs(dataDirectory.getPath()));
        }
        for (Map.Entry entry : hashMap3.entrySet()) {
            StatFs statFs = (StatFs) entry.getValue();
            if (Build.VERSION.SDK_INT <= 18) {
                j14 = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                j13 = ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
                j12 = (long) statFs.getBlockCount();
                j11 = (long) statFs.getBlockSize();
            } else {
                j14 = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
                j13 = statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
                j12 = statFs.getBlockCountLong();
                j11 = statFs.getBlockSizeLong();
            }
            HashMap hashMap4 = hashMap.get(entry.getKey());
            hashMap4.put("available", Long.valueOf(j14));
            hashMap4.put(l.a("004_fgek[gg"), Long.valueOf(j13));
            hashMap4.put(l.a("005j<elTjeh"), Long.valueOf(j12 * j11));
        }
        return hashMap;
    }

    public HashMap<String, Long> F() {
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("available", -1L);
        hashMap.put(l.a("005jCel*jeh"), -1L);
        hashMap.put(l.a("005Cejgjgfelgh"), -1L);
        hashMap.put(l.a("009ji+ekKg5gj1i;elWhMed"), -1L);
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("008edj,ejeeej j%fd"));
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, l.a("013-fk gj7id]g4egelekfdff%fMfgel"), null, memoryInfo);
        hashMap.put("available", Long.valueOf(memoryInfo.availMem));
        if (Build.VERSION.SDK_INT >= 16) {
            hashMap.put(l.a("005jTelSjeh"), Long.valueOf(memoryInfo.totalMem));
        }
        hashMap.put(l.a("005;ejgjgfelgh"), Long.valueOf(memoryInfo.lowMemory ? 1 : 0));
        hashMap.put(l.a("009jiUek.gDgj]i@el?h,ed"), Long.valueOf(memoryInfo.threshold));
        return hashMap;
    }

    public String G() {
        return g.a().b();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1 = new java.io.BufferedReader(new java.io.FileReader(com.mob.commons.a.l.a("006mkLekel3dm") + android.os.Process.myPid() + com.mob.commons.a.l.a("005m6eg%ek?gj")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0100, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r2 = r1.readLine();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0105, code lost:
        if (r2 == null) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0109, code lost:
        r0 = r2.toLowerCase().contains(com.mob.commons.a.l.a("006PfjWkJelgj;gCed"));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0118, code lost:
        com.mob.commons.v.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0120, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0122, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0123, code lost:
        r7 = r1;
        r1 = null;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.mob.tools.MobLog.getInstance().d(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0134, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0135, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0136, code lost:
        com.mob.commons.v.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x013d, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[ExcHandler: all (unused java.lang.Throwable), SYNTHETIC, Splitter:B:19:0x00b0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean H() {
        /*
            r8 = this;
            r0 = 12
            java.lang.String[] r1 = new java.lang.String[r0]
            java.lang.String r2 = "020dBelegem4j6elLkWihelIif2ghehemeg9eGfkejgjfi"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "024GejelemfkejBjiMehggem+i5ehgjfifdedfkemegSe(fkejgjfi"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r4 = 1
            r1[r4] = r2
            java.lang.String r2 = "032AedJgBemekelggeeemFefJedekelejedemfjWkPelgjBg'edemej,fVgjAjehhgMek"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 2
            r1[r5] = r2
            java.lang.String r2 = "028:elekfkemeg?gAelghTdejSemKgQedfjAkAelgjXgFedemeg!efeLfk7g0ek"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 3
            r1[r5] = r2
            java.lang.String r2 = "0277egelEgSemgj3iMejheehfiehemekCg3edejek8gdj]gjKj]elekFe+fkOg"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 4
            r1[r5] = r2
            java.lang.String r2 = "018Veg6gSemghHgQejgj]i;ehemfi?gFek%fgh>gjeh"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 5
            r1[r5] = r2
            java.lang.String r2 = "027Aejelemfkej6jiLehggemeeeeggifgiiigiemeg?ei1elgjTi3elihel"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 6
            r1[r5] = r2
            java.lang.String r2 = "013'glelelfiemhfejehhgehemhh=k"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 7
            r1[r5] = r2
            r2 = 8
            java.lang.String r5 = "club.youppgd.adhook"
            r1[r2] = r5
            java.lang.String r2 = "027Fej-dAehemNf0eh;hhkjSekemWekkh=ejgjWjGed^gjgdjXelek"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 9
            r1[r5] = r2
            java.lang.String r2 = "032Eejelemfkej:ji'ehggemEi6ehgjfifdedfkemeg,g9egelekfded]gjgdjZelek"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 10
            r1[r5] = r2
            java.lang.String r2 = "034d,elegemfkej-ji[ehggemUdekfjRekej?kEgjemfiSgWekQfgh'fg$heQgj@ig%ek"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)
            r5 = 11
            r1[r5] = r2
            r2 = r3
        L_0x0071:
            if (r2 >= r0) goto L_0x0089
            r5 = r1[r2]
            android.content.Context r6 = r8.f27760a     // Catch:{ all -> 0x0086 }
            com.mob.tools.b.c r6 = com.mob.tools.b.c.a((android.content.Context) r6)     // Catch:{ all -> 0x0086 }
            com.mob.tools.b.a r6 = r6.d()     // Catch:{ all -> 0x0086 }
            android.content.pm.ApplicationInfo r5 = r6.a((java.lang.String) r5, (int) r3)     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x0086
            return r4
        L_0x0086:
            int r2 = r2 + 1
            goto L_0x0071
        L_0x0089:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0091 }
            java.lang.String r1 = "msk"
            r0.<init>(r1)     // Catch:{ all -> 0x0091 }
            throw r0     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r0 = move-exception
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            int r1 = r0.length
            r2 = r3
        L_0x0098:
            if (r2 >= r1) goto L_0x00b0
            r5 = r0[r2]
            java.lang.String r5 = r5.getClassName()
            java.lang.String r6 = "035Wed=g+emekelggeeemMefOedekelejedemfjVk)elgjMgOedemhhGkPelgjLgDedgkekejedfk6g"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x00ad
            return r4
        L_0x00ad:
            int r2 = r2 + 1
            goto L_0x0098
        L_0x00b0:
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ IllegalAccessException | InstantiationException -> 0x013e, all -> 0x00d3 }
            java.lang.String r1 = "0369ed<g3emekelggeeem_efYedekelejedemfjTkXelgj3gNedemhhWkDelgj2gOedgl(ghkg4ekgj"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x013e, all -> 0x00d3 }
            java.lang.Class r0 = r0.loadClass(r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x013e, all -> 0x00d3 }
            r0.newInstance()     // Catch:{ IllegalAccessException | InstantiationException -> 0x013e, all -> 0x00d3 }
            java.lang.ClassLoader r0 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ IllegalAccessException | InstantiationException -> 0x00d2, all -> 0x00d3 }
            java.lang.String r1 = "035Ied!g9emekelggeeem6ef9edekelejedemfj.kIelgj=g+edemhh(k5elgj2gWedgkekejedfkTg"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x00d2, all -> 0x00d3 }
            java.lang.Class r0 = r0.loadClass(r1)     // Catch:{ IllegalAccessException | InstantiationException -> 0x00d2, all -> 0x00d3 }
            r0.newInstance()     // Catch:{ IllegalAccessException | InstantiationException -> 0x00d2, all -> 0x00d3 }
        L_0x00d2:
            return r4
        L_0x00d3:
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x0122 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x0122 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
            r5.<init>()     // Catch:{ all -> 0x0122 }
            java.lang.String r6 = "006mkLekel3dm"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)     // Catch:{ all -> 0x0122 }
            r5.append(r6)     // Catch:{ all -> 0x0122 }
            int r6 = android.os.Process.myPid()     // Catch:{ all -> 0x0122 }
            r5.append(r6)     // Catch:{ all -> 0x0122 }
            java.lang.String r6 = "005m6eg%ek?gj"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)     // Catch:{ all -> 0x0122 }
            r5.append(r6)     // Catch:{ all -> 0x0122 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0122 }
            r2.<init>(r5)     // Catch:{ all -> 0x0122 }
            r1.<init>(r2)     // Catch:{ all -> 0x0122 }
            r0 = r3
        L_0x0101:
            java.lang.String r2 = r1.readLine()     // Catch:{ all -> 0x0120 }
            if (r2 == 0) goto L_0x0118
            if (r0 != 0) goto L_0x0118
            java.lang.String r0 = r2.toLowerCase()     // Catch:{ all -> 0x0120 }
            java.lang.String r2 = "006PfjWkJelgj;gCed"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)     // Catch:{ all -> 0x0120 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0120 }
            goto L_0x0101
        L_0x0118:
            java.io.Closeable[] r2 = new java.io.Closeable[r4]
            r2[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            return r0
        L_0x0120:
            r0 = move-exception
            goto L_0x0126
        L_0x0122:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
        L_0x0126:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0135 }
            r2.d(r0)     // Catch:{ all -> 0x0135 }
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            return r3
        L_0x0135:
            r0 = move-exception
            java.io.Closeable[] r2 = new java.io.Closeable[r4]
            r2[r3] = r1
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            throw r0
        L_0x013e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.H():boolean");
    }

    public boolean I() {
        return (this.f27760a.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean J() {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                if (Settings.Secure.getInt(this.f27760a.getContentResolver(), "adb_enabled", 0) <= 0) {
                    return false;
                }
            } else if (Settings.Secure.getInt(this.f27760a.getContentResolver(), "adb_enabled", 0) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean K() {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                if (Settings.Secure.getInt(this.f27760a.getContentResolver(), "development_settings_enabled", 0) <= 0) {
                    return false;
                }
            } else if (Settings.Secure.getInt(this.f27760a.getContentResolver(), "development_settings_enabled", 0) <= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean L() {
        Intent a11 = v.a((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (a11 == null || a11.getIntExtra("plugged", -1) != 2) {
            return false;
        }
        return true;
    }

    public boolean M() {
        return false;
    }

    public boolean N() {
        ApplicationInfo a11 = c.a(this.f27760a).d().a(false, DH.SyncMtd.getPackageName(), 1);
        if (a11 == null || (a11.flags & 2) == 0) {
            return false;
        }
        return true;
    }

    public boolean O() {
        int i11;
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                str = System.getProperty(l.a("014ijjk<emMkFekelfjfdglelgj(j"));
                String property = System.getProperty(l.a("014ijjkSemQk0ekelfjfdhmelek3j"));
                if (property == null) {
                    property = "-1";
                }
                try {
                    i11 = Integer.parseInt(property);
                } catch (Throwable unused) {
                    i11 = -1;
                }
            } else {
                str = Proxy.getHost(this.f27760a);
                i11 = Proxy.getPort(this.f27760a);
            }
            if (TextUtils.isEmpty(str) || i11 == -1) {
                return false;
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public boolean P() {
        boolean z11 = Build.VERSION.SDK_INT >= 29;
        boolean z12 = c.a(this.f27760a).d().ak().targetSdkVersion >= 29;
        if (!z11 || !z12) {
            return false;
        }
        return true;
    }

    public String Q() {
        try {
            String id2 = TimeZone.getDefault().getID();
            if (!TextUtils.isEmpty(id2)) {
                return id2;
            }
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(this.f27760a.getContentResolver(), configuration);
            Locale locale = configuration.locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            return Calendar.getInstance(locale).getTimeZone().getID();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String R() {
        return c.a(this.f27760a).d().a(l.a("015YekelemggehejDh'edemfg*he0eeelek"));
    }

    public String S() {
        return c.a(this.f27760a).d().a(l.a("020>fkgjegemee3g6ekgjejelEf)emgg?eTgj9gJggSefGed"));
    }

    public String T() {
        return c.a(this.f27760a).d().a(l.a("016GekelemFkYekeledeh7dj4emggel*eSeked"));
    }

    public String U() {
        return c.a(this.f27760a).d().a(l.a("017.ekelemggel6e1ekedem_khej:fgelekeg"));
    }

    public int V() {
        if (d.i()) {
            return NtFetcher.getInstance(this.f27760a).getDtNtType();
        }
        return -1;
    }

    public String W() {
        return Build.BRAND;
    }

    public boolean X() {
        return b(this.f27760a) != 0;
    }

    public String Y() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
            Method declaredMethod = Class.forName(l.a("026ef.edekelejedemMekk%emge:dj.ejeeej!jOfdgd7i?ek4geNed"), false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return "";
        } catch (Throwable th2) {
            NLog instance = MobLog.getInstance();
            instance.d("getProcessName: " + th2, new Object[0]);
            return "";
        }
    }

    public long Z() {
        Object b11 = c.a(this.f27760a).d().b(false, 0, o(), 0);
        if (b11 != null) {
            return c.e(b11, DH.SyncMtd.getPackageName());
        }
        return 0;
    }

    public String aa() {
        return Build.DEVICE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String ab() {
        /*
            r10 = this;
            java.lang.String r0 = "007!edAg2gj3jWekelfd"
            r1 = 1
            r2 = 2
            r3 = 0
            r4 = 0
            java.lang.String r5 = "021dejZjg3mkHekel+dmWgjEgh4fgHmd fkekeleh5k"
            java.lang.String r5 = com.mob.commons.a.l.a((java.lang.String) r5)     // Catch:{ all -> 0x004f }
            java.lang.Object r5 = com.mob.commons.v.c(r5)     // Catch:{ all -> 0x004f }
            java.lang.String r6 = "014OfkGgj%ffGfk'eh%j;fm^jNek=ge:eg"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)     // Catch:{ all -> 0x004c }
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ all -> 0x004c }
            java.lang.Object r6 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r6, r4, r7)     // Catch:{ all -> 0x004c }
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ all -> 0x004c }
            if (r6 == 0) goto L_0x0034
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ all -> 0x0031 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x0031 }
            r8.<init>(r6)     // Catch:{ all -> 0x0031 }
            r7.<init>(r8)     // Catch:{ all -> 0x0031 }
            java.lang.String r8 = r7.readLine()     // Catch:{ all -> 0x002f }
            goto L_0x0036
        L_0x002f:
            r8 = move-exception
            goto L_0x0053
        L_0x0031:
            r8 = move-exception
            r7 = r4
            goto L_0x0053
        L_0x0034:
            r7 = r4
            r8 = r7
        L_0x0036:
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r3] = r7
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x004a
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r4, r1)
        L_0x004a:
            r4 = r8
            goto L_0x006e
        L_0x004c:
            r8 = move-exception
            r6 = r4
            goto L_0x0052
        L_0x004f:
            r8 = move-exception
            r5 = r4
            r6 = r5
        L_0x0052:
            r7 = r6
        L_0x0053:
            com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x006f }
            r9.d(r8)     // Catch:{ all -> 0x006f }
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r3] = r7
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x006e
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r4, r1)
        L_0x006e:
            return r4
        L_0x006f:
            r8 = move-exception
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r3] = r7
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x0084
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r3]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r4, r1)
        L_0x0084:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.ab():java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.Closeable[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008e A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String ac() {
        /*
            r11 = this;
            java.lang.String r0 = "007BedDg(gj]j,ekelfd"
            r1 = 1
            r2 = 2
            r3 = 0
            r4 = 0
            java.lang.String r5 = "017dej*jgKmk9ekel]dmdk?ehej7fZfgel"
            java.lang.String r5 = com.mob.commons.a.l.a((java.lang.String) r5)     // Catch:{ all -> 0x0078 }
            java.lang.Object r5 = com.mob.commons.v.c(r5)     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = "014Zfk2gj6ff1fk;ehXj[fmKj!ekHge1eg"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)     // Catch:{ all -> 0x0075 }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x0075 }
            java.lang.Object r6 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r6, r3, r7)     // Catch:{ all -> 0x0075 }
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ all -> 0x0075 }
            if (r6 == 0) goto L_0x0060
            java.lang.StringBuffer r7 = new java.lang.StringBuffer     // Catch:{ all -> 0x005d }
            r7.<init>()     // Catch:{ all -> 0x005d }
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ all -> 0x005d }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x005d }
            java.lang.String r10 = "utf-8"
            r9.<init>(r6, r10)     // Catch:{ all -> 0x005d }
            r8.<init>(r9)     // Catch:{ all -> 0x005d }
        L_0x0031:
            java.lang.String r9 = r8.readLine()     // Catch:{ all -> 0x005b }
            if (r9 == 0) goto L_0x003b
            r7.append(r9)     // Catch:{ all -> 0x005b }
            goto L_0x0031
        L_0x003b:
            r8.close()     // Catch:{ all -> 0x005b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x005b }
            java.lang.String r7 = r7.toLowerCase()     // Catch:{ all -> 0x005b }
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r4] = r8
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x005a
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r3, r1)
        L_0x005a:
            return r7
        L_0x005b:
            r7 = move-exception
            goto L_0x007c
        L_0x005d:
            r7 = move-exception
            r8 = r3
            goto L_0x007c
        L_0x0060:
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r4] = r3
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x0097
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r3, r1)
            goto L_0x0097
        L_0x0075:
            r7 = move-exception
            r6 = r3
            goto L_0x007b
        L_0x0078:
            r7 = move-exception
            r5 = r3
            r6 = r5
        L_0x007b:
            r8 = r6
        L_0x007c:
            com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x009a }
            r9.d(r7)     // Catch:{ all -> 0x009a }
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r4] = r8
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x0097
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r3, r1)
        L_0x0097:
            java.lang.String r0 = ""
            return r0
        L_0x009a:
            r7 = move-exception
            java.io.Closeable[] r2 = new java.io.Closeable[r2]
            r2[r4] = r8
            r2[r1] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r2)
            if (r5 == 0) goto L_0x00af
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r5, r0, r3, r1)
        L_0x00af:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.ac():java.lang.String");
    }

    public String ad() {
        return com.mob.commons.b.d.b(this.f27760a);
    }

    public HashMap<String, Object> ae() {
        return com.mob.commons.b.d.a(this.f27760a);
    }

    public long af() {
        return Build.TIME;
    }

    public double ag() {
        return ResHelper.getScreenInch(this.f27760a);
    }

    public int ah() {
        return ResHelper.getScreenPpi(this.f27760a);
    }

    public boolean ai() {
        return l.a("0076glQe_ekegelZf?fd").equalsIgnoreCase((String) ReflectHelper.invokeStaticMethodNoThrow(ReflectHelper.importClassNoThrow(l.a("025d<elegem(i;ehNeKghCg ejemgjfdgj]jgCegemgkehej%hPedhjfj"), (String) null), l.a("010Ifk^gj;higjgkek+ef7ed"), null, new Object[0]));
    }

    public String aj() {
        return c.a(this.f27760a).d().a(l.a("028i=gheigjTd>emggehejNh)edem<khej=fgelekegemeeGgLekgjejel8f"));
    }

    public String ak() {
        String str = null;
        try {
            String aq2 = c.a(this.f27760a).d().aq();
            String a11 = c.a(this.f27760a).d().a("ro.build.ver.physical");
            if (!TextUtils.isEmpty(a11) && a11.contains(aq2)) {
                Matcher matcher = Pattern.compile(aq2 + "(\\.\\d+)?").matcher(a11);
                while (matcher.find()) {
                    str = matcher.group();
                }
            }
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        return str;
    }

    public int al() {
        try {
            return Settings.Secure.getInt(this.f27760a.getContentResolver(), l.a("015k[ehekWgBeiegeledRgDeigjQjejg"));
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    public int am() {
        try {
            return Settings.Secure.getInt(this.f27760a.getContentResolver(), l.a("024k=ehekFgNei8gfiefdg7edeiegeled5g;eigj=jejg"));
        } catch (Settings.SettingNotFoundException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        r0 = com.mob.tools.utils.DH.SyncMtd.getSystemServiceSafe(com.mob.commons.a.l.a("005kiWelMfg"));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object an() {
        /*
            r10 = this;
            boolean r0 = com.mob.commons.d.h()
            r1 = 0
            if (r0 == 0) goto L_0x01dc
            com.mob.commons.CSCenter r0 = com.mob.commons.CSCenter.getInstance()
            boolean r0 = r0.isCellLocationDataEnable()
            r2 = 0
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "041efLedekelejedemKkgBekegejgjgjejel7fLemgefefehjfmfmeifehigehkfmhjeigfhifegegdffhifh"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            boolean r0 = com.mob.tools.utils.DH.SyncMtd.checkPermission(r0)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "005kiWelMfg"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object r0 = com.mob.tools.utils.DH.SyncMtd.getSystemServiceSafe(r0)
            if (r0 == 0) goto L_0x0037
            java.lang.String r3 = "015(fk^gjPfeSghh:gfelQdej,ejelLf"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.Object r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r3, r1, r4)
            goto L_0x0041
        L_0x0037:
            r0 = r1
            goto L_0x0041
        L_0x0039:
            com.mob.commons.CSCenter r0 = com.mob.commons.CSCenter.getInstance()
            android.telephony.CellLocation r0 = r0.getCellLocation()
        L_0x0041:
            if (r0 == 0) goto L_0x01dc
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r3 = "016LfeedegYe%fe,ghh9gfelSdejRejelPf"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)
            java.lang.Class r4 = r0.getClass()
            java.lang.String r4 = r4.getSimpleName()
            boolean r3 = r3.equals(r4)
            r4 = -1
            if (r3 == 0) goto L_0x0107
            java.lang.String r3 = "016XfeedegQeJfeZghh7gfel*dej9ejelWf"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)
            r5 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r1.put(r3, r5)
            java.lang.String r3 = "022CfkTgjUgk eTgj6gUfmWjej!ejelJf>gf<ej*ej j%ehed)g"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Object r3 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r3, r5, r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = com.mob.tools.utils.ResHelper.forceCast(r3, r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r5 = "023Ffk:gjTgkGe9gjQg!fmSjej ejel,f$gfel!f1fkej+j;ehed5g"
            java.lang.String r5 = com.mob.commons.a.l.a((java.lang.String) r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.Object r5 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r5, r6, r7)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object r5 = com.mob.tools.utils.ResHelper.forceCast(r5, r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r6 = "016=fk1gjUgk7e$gj1gTfm9jejVejel1f3ffed"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r8 = new java.lang.Object[r2]
            java.lang.Object r6 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r6, r7, r8)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = com.mob.tools.utils.ResHelper.forceCast(r6, r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.String r7 = "0115fkHgjHfmfdgjUjg$egffed"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.Object r7 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r7, r8, r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            java.lang.Object r7 = com.mob.tools.utils.ResHelper.forceCast(r7, r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.String r8 = "012KfkBgj6fh^gjJghelekfiffed"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r8, r9, r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Object r0 = com.mob.tools.utils.ResHelper.forceCast(r0, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2 = r0
            r0 = r4
            r8 = r5
            r5 = r3
            r3 = r0
            goto L_0x0174
        L_0x0107:
            java.lang.String r3 = "016$feedeg8eSfe2ghh2gfelCdej!ejelOf"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r1.put(r3, r5)
            java.lang.String r3 = "006 fkYgj[hmgj;d"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Object r3 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r3, r5, r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r3 = com.mob.tools.utils.ResHelper.forceCast(r3, r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            java.lang.String r5 = "006$fk(gj[gfGed"
            java.lang.String r5 = com.mob.commons.a.l.a((java.lang.String) r5)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r7 = new java.lang.Object[r2]
            java.lang.Object r5 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r5, r6, r7)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object r5 = com.mob.tools.utils.ResHelper.forceCast(r5, r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r6 = "0068fkOgj'feejed"
            java.lang.String r6 = com.mob.commons.a.l.a((java.lang.String) r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Object r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r6, r7, r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.Object r0 = com.mob.tools.utils.ResHelper.forceCast(r0, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r2 = r4
            r6 = r2
            r7 = r6
            r8 = r7
            r4 = r5
            r5 = r8
        L_0x0174:
            java.lang.String r9 = "003hed"
            java.lang.String r9 = com.mob.commons.a.l.a((java.lang.String) r9)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r1.put(r9, r4)
            java.lang.String r4 = "004dghh"
            java.lang.String r4 = com.mob.commons.a.l.a((java.lang.String) r4)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.put(r4, r0)
            java.lang.String r0 = "003k[gj6d"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.put(r0, r3)
            java.lang.String r0 = "0033ggejed"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r1.put(r0, r3)
            java.lang.String r0 = "003)gjejed"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            r1.put(r0, r3)
            java.lang.String r0 = "003f<ejed"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1.put(r0, r2)
            java.lang.String r0 = "003hej"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            r1.put(r0, r2)
            java.lang.String r0 = "003hLel=f"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r1.put(r0, r2)
        L_0x01dc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.an():java.lang.Object");
    }

    public String ao() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT < 33 || (localeList = (LocaleList) ReflectHelper.invokeInstanceMethodNoThrow(DH.SyncMtd.getSystemServiceSafe("locale"), "getApplicationLocales", null, new Object[0])) == null || localeList.isEmpty() || (locale = localeList.get(0)) == null) {
            return null;
        }
        return locale.getLanguage();
    }

    public int ap() {
        if (Build.VERSION.SDK_INT < 34) {
            return 0;
        }
        try {
            return ((Integer) ReflectHelper.invokeInstanceMethod(this.f27760a.getSystemService(Class.forName("android.app.GrammaticalInflectionManager")), "getApplicationGrammaticalGender", new Object[0])).intValue();
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean aq() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "0"
            int r2 = android.os.Process.myPid()
            r3 = 1
            r4 = 0
            r5 = 0
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r7.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r8 = "006mk-ekelGdm"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x0069 }
            r7.append(r8)     // Catch:{ all -> 0x0069 }
            r7.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "007m.gj*jej%ehgj"
            java.lang.String r2 = com.mob.commons.a.l.a((java.lang.String) r2)     // Catch:{ all -> 0x0069 }
            r7.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x0069 }
            java.lang.String r7 = "r"
            r6.<init>(r2, r7)     // Catch:{ all -> 0x0069 }
            r2 = r1
        L_0x0031:
            java.lang.String r5 = r6.readLine()     // Catch:{ all -> 0x0066 }
            if (r5 == 0) goto L_0x005e
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0066 }
            java.lang.String r7 = "\t"
            java.lang.String r5 = r5.replace(r7, r0)     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0066 }
            java.lang.String r7 = " "
            java.lang.String r5 = r5.replace(r7, r0)     // Catch:{ all -> 0x0066 }
            java.lang.String r7 = "010Ogdek*edgCekhmejed4l"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x0066 }
            boolean r7 = r5.contains(r7)     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x0031
            r7 = 10
            java.lang.String r2 = r5.substring(r7)     // Catch:{ all -> 0x0066 }
            goto L_0x0031
        L_0x005e:
            java.io.Closeable[] r0 = new java.io.Closeable[r3]
            r0[r4] = r6
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            goto L_0x0079
        L_0x0066:
            r0 = move-exception
            r5 = r6
            goto L_0x006b
        L_0x0069:
            r0 = move-exception
            r2 = r1
        L_0x006b:
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x008b }
            r6.d(r0)     // Catch:{ all -> 0x008b }
            java.io.Closeable[] r0 = new java.io.Closeable[r3]
            r0[r4] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r0)
        L_0x0079:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x008a
            boolean r0 = android.text.TextUtils.equals(r1, r2)
            if (r0 != 0) goto L_0x008a
            boolean r0 = r9.g(r2)
            return r0
        L_0x008a:
            return r4
        L_0x008b:
            r0 = move-exception
            java.io.Closeable[] r1 = new java.io.Closeable[r3]
            r1[r4] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.aq():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r0 = com.mob.tools.utils.DH.SyncMtd.getSystemServiceSafe(com.mob.commons.a.l.a("005ki2el4fg"));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> ar() {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 17
            if (r0 < r2) goto L_0x00a7
            boolean r2 = com.mob.commons.d.h()
            if (r2 == 0) goto L_0x00a7
            com.mob.commons.CSCenter r2 = com.mob.commons.CSCenter.getInstance()
            boolean r2 = r2.isCellLocationDataEnable()
            r3 = 0
            if (r2 == 0) goto L_0x005a
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.String r5 = "gtci: direct"
            r2.d(r5, r4)
            r2 = 29
            if (r0 >= r2) goto L_0x0033
            java.lang.String r4 = "041efMedekelejedemIkg2ekegejgjgjejelUf!emgefefehjfmfmeifehigehkfmhjeigfhifegegdffhifh"
            java.lang.String r4 = com.mob.commons.a.l.a((java.lang.String) r4)
            boolean r4 = com.mob.tools.utils.DH.SyncMtd.checkPermission(r4)
            if (r4 != 0) goto L_0x0041
        L_0x0033:
            if (r0 < r2) goto L_0x0058
            java.lang.String r0 = "039ef0edekelejedemAkg@ekegejgjgjejelOfEemgefefehjfmfmeihdfffhhjeigfhifegegdffhifh"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            boolean r0 = com.mob.tools.utils.DH.SyncMtd.checkPermission(r0)
            if (r0 == 0) goto L_0x0058
        L_0x0041:
            java.lang.String r0 = "005ki2el4fg"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)
            java.lang.Object r0 = com.mob.tools.utils.DH.SyncMtd.getSystemServiceSafe(r0)
            if (r0 == 0) goto L_0x0058
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r4 = "getAllCellInfo"
            java.lang.Object r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethodNoThrow(r0, r4, r1, r2)
            java.util.List r0 = (java.util.List) r0
            goto L_0x006d
        L_0x0058:
            r0 = r1
            goto L_0x006d
        L_0x005a:
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.String r4 = "gtci: mcc"
            r0.d(r4, r2)
            com.mob.commons.CSCenter r0 = com.mob.commons.CSCenter.getInstance()
            java.util.List r0 = r0.getAllCellInfo()
        L_0x006d:
            if (r0 == 0) goto L_0x00a7
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x00a7
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L_0x007e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0096
            java.lang.Object r4 = r2.next()
            boolean r5 = com.mob.tools.utils.b.a.a(r4)
            if (r5 == 0) goto L_0x007e
            java.util.HashMap r4 = r6.a((java.lang.Object) r4)
            r1.add(r4)
            goto L_0x007e
        L_0x0096:
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x00a7
            java.lang.Object r0 = r0.get(r3)
            java.util.HashMap r0 = r6.a((java.lang.Object) r0)
            r1.add(r0)
        L_0x00a7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.ar():java.util.ArrayList");
    }

    public boolean as() {
        return aB() || aq();
    }

    public String b() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public String c() {
        return Build.MANUFACTURER;
    }

    public String d() {
        try {
            String str = c.a(this.f27760a).d().l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + f() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + c() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + k();
            String a11 = a(false);
            if (a11 == null) {
                a11 = "";
            } else if (a11.length() > 16) {
                a11 = a11.substring(0, 16);
            }
            return Data.Base64AES(str, a11);
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return "";
        }
    }

    public String e() {
        return c.a(this.f27760a).d().l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + f() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + c() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + l() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + k();
    }

    public int f() {
        return Build.VERSION.SDK_INT;
    }

    public String g() {
        return Build.VERSION.RELEASE;
    }

    public String h() {
        return Locale.getDefault().getLanguage();
    }

    public String i() {
        return this.f27760a.getResources().getConfiguration().locale.getLanguage();
    }

    public String j() {
        return Locale.getDefault().getCountry();
    }

    public String k() {
        int[] screenSize = ResHelper.getScreenSize(this.f27760a);
        if (this.f27760a.getResources().getConfiguration().orientation == 1) {
            return screenSize[0] + "x" + screenSize[1];
        }
        return screenSize[1] + "x" + screenSize[0];
    }

    public String l() {
        String str;
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("005kiLel=fg"));
        if (systemServiceSafe == null || !d.i()) {
            return "-1";
        }
        if (CSCenter.getInstance().isPhoneStateDataEnable()) {
            str = (String) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, l.a("014EfkNgjEfmejeghi'kgPek@ej3elek"), null, new Object[0]);
        } else {
            str = CSCenter.getInstance().getSimOperator();
        }
        if (TextUtils.isEmpty(str)) {
            return "-1";
        }
        return str;
    }

    public String m() {
        String str;
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("005kiLel6fg"));
        if (systemServiceSafe == null || !d.i()) {
            return null;
        }
        if (CSCenter.getInstance().isPhoneStateDataEnable()) {
            str = (String) ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, l.a("018@fkUgjTfmejeghi<kgCek-ejLelekfh e6egVg"), null, new Object[0]);
        } else {
            str = CSCenter.getInstance().getSimOperatorName();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public String n() {
        return NtFetcher.getInstance(this.f27760a).getNtType();
    }

    public String o() {
        return this.f27760a.getPackageName();
    }

    public String p() {
        try {
            ApplicationInfo ak2 = c.a(this.f27760a).d().ak();
            String packageName = DH.SyncMtd.getPackageName();
            String b11 = c.b(ak2, packageName);
            if (b11 != null) {
                if (Build.VERSION.SDK_INT < 25 || b11.endsWith(".*")) {
                    return b11;
                }
                ReflectHelper.importClassNoThrow(b11, (String) null);
            }
            int c11 = c.c(ak2, packageName);
            if (c11 > 0) {
                return this.f27760a.getString(c11);
            }
            return String.valueOf(c.d(ak2, packageName));
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return "";
        }
    }

    public int q() {
        try {
            int intValue = ((Integer) MobMeta.get((MobProduct) null, l.a("011-eeEgPekgjejelIfJfeeled@g"), Integer.class, 0)).intValue();
            if (intValue > 0) {
                return intValue;
            }
            Object b11 = c.a(this.f27760a).d().b(false, 0, o(), 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return (int) c.g(b11, DH.SyncMtd.getPackageName());
            }
            return c.f(b11, DH.SyncMtd.getPackageName());
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return 0;
        }
    }

    public String r() {
        try {
            String str = (String) MobMeta.get((MobProduct) null, l.a("011:ee?gEekgjejelTfBfhUeUeg.g"), String.class, null);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return c.c(c.a(this.f27760a).d().b(false, 0, o(), 0), DH.SyncMtd.getPackageName());
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return "1.0";
        }
    }

    public ArrayList<HashMap<String, String>> s() {
        if (CSCenter.getInstance().isAppListDataEnable()) {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            try {
                if (Build.VERSION.SDK_INT <= 25) {
                    return a(ay());
                }
                ArrayList arrayList2 = (ArrayList) com.mob.commons.b.a(l.a("004ehQel4h"), null);
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList2 = new ArrayList(Arrays.asList(new String[]{"1", "2"}));
                }
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    arrayList = b(Integer.parseInt(String.valueOf(arrayList2.get(i11))));
                    if (arrayList != null && !arrayList.isEmpty() && arrayList.size() > 1) {
                        return arrayList;
                    }
                }
                return arrayList;
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
                return new ArrayList<>();
            }
        } else {
            List<PackageInfo> packageInfos = CSCenter.getInstance().getPackageInfos();
            if (packageInfos == null || packageInfos.isEmpty()) {
                return new ArrayList<>();
            }
            HashMap hashMap = new HashMap();
            for (PackageInfo next : packageInfos) {
                hashMap.put(next.packageName, next);
            }
            return a((HashMap<String, Object>) hashMap);
        }
    }

    public String t() {
        if (Build.VERSION.SDK_INT < 29 || c.a(this.f27760a).d().ak().targetSdkVersion < 29 || !"mounted".equals(Environment.getExternalStorageState())) {
            return this.f27760a.getFilesDir().getAbsolutePath();
        }
        return this.f27760a.getExternalFilesDir((String) null).getAbsolutePath();
    }

    public String u() throws Throwable {
        return null;
    }

    public ArrayList<HashMap<String, Object>> v() {
        if (!d.h()) {
            return null;
        }
        try {
            if (!d(l.a("041efQedekelejedemCkgMekegejgjgjejelMf%emgefefehjfmfmeifehigehkfmhjeigfhifegegdffhifh")) || P()) {
                return null;
            }
            List arrayList = new ArrayList();
            if (CSCenter.getInstance().isCellLocationDataEnable()) {
                Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("005kiZel9fg"));
                if (systemServiceSafe != null) {
                    arrayList = (List) ReflectHelper.invokeInstanceMethod(systemServiceSafe, l.a("022;fkWgjJfhUg3ejfkAi-ggelekej,f$fkfeAghhNff_f9fgel"), new Object[0]);
                }
            } else {
                List<NeighboringCellInfo> neighboringCellInfo = CSCenter.getInstance().getNeighboringCellInfo();
                if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                    arrayList.addAll(neighboringCellInfo);
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            ArrayList<HashMap<String, Object>> arrayList2 = new ArrayList<>();
            for (Object next : arrayList) {
                int intValue = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(next, l.a("006SfkJgj%feejed"), new Object[0]), -1)).intValue();
                int intValue2 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(next, l.a("0062fkAgjNgf ed"), new Object[0]), -1)).intValue();
                int intValue3 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(next, l.a("0076fk:gj(hkgjgjej"), new Object[0]), -1)).intValue();
                int intValue4 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(next, l.a("006,fk7gjRhmgjSd"), new Object[0]), -1)).intValue();
                int intValue5 = ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(next, l.a("0142fk*gj2fh$gj'ghelekfigdfd!kg"), new Object[0]), -1)).intValue();
                if (!(intValue == -1 || intValue2 == -1)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(l.a("004dghh"), Integer.valueOf(intValue));
                    hashMap.put(l.a("003hed"), Integer.valueOf(intValue2));
                    hashMap.put(l.a("004Aekgjgjej"), Integer.valueOf(intValue3));
                    hashMap.put(l.a("003kYgj3d"), Integer.valueOf(intValue4));
                    hashMap.put(l.a("011fgjOghelekfigdfdTkg"), Integer.valueOf(intValue5));
                    arrayList2.add(hashMap);
                }
            }
            if (arrayList2.size() > 0) {
                return arrayList2;
            }
            return null;
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public String w() {
        String a11 = l.a("009^flfhgmhjhdfffhhjgm");
        UiModeManager uiModeManager = (UiModeManager) DH.SyncMtd.getSystemServiceSafe("uimode");
        if (uiModeManager == null) {
            return a11;
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                return l.a("005Vfhhieiflff");
            case 2:
                return l.a("004Zgmhjfmjd");
            case 3:
                return l.a("0037fegehk");
            case 4:
                return l.a("010]gdhjgfhjhlfffmffhifh");
            case 5:
                return l.a("009Fgehmhmgfffgefhfehj");
            case 6:
                return l.a("005=hggegdfegl");
            case 7:
                return l.a("009Bhlhkglhjgegmfmhjgd");
            default:
                return l.a("0093flfhgmhjhdfffhhjgm");
        }
    }

    public HashMap<String, Object> y() {
        Object obj;
        String str;
        if (d.c()) {
            try {
                if (d(l.a("036ef%edekelejedemPkg2ekegejgjgjejelVfTemgefefehjfmfmeihgffhdffeifmgdgegdhj"))) {
                    if (CSCenter.getInstance().isWifiDataEnable()) {
                        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(l.a("004Cghejfgej"));
                        obj = systemServiceSafe != null ? ReflectHelper.invokeInstanceMethod(systemServiceSafe, l.a("017$fk7gjKfeel-ffgdj^ejel3fKff;f1fgel"), new Object[0]) : null;
                    } else {
                        obj = CSCenter.getInstance().getConnectionInfo();
                    }
                    if (obj != null) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("bsmt", (String) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("0085fk9gjJgkfmfmffgm"), null, new Object[0]));
                        String str2 = (String) ReflectHelper.invokeInstanceMethodNoThrow(obj, l.a("007;fk6gj9fmfmffgm"), null, new Object[0]);
                        if (str2 == null) {
                            str = null;
                        } else {
                            str = str2.replace("\"", "");
                        }
                        hashMap.put("ssmt", str);
                        try {
                            hashMap.put(l.a("006i1ejededSgf"), Boolean.valueOf(((Boolean) ReflectHelper.invokeInstanceMethod(obj, l.a("013Zfk:gj3glejeded3gf%fmfmffgm"), new Object[0])).booleanValue()));
                        } catch (Throwable unused) {
                        }
                        try {
                            hashMap.put("spmt", Integer.valueOf(((Integer) ReflectHelper.invokeInstanceMethod(obj, l.a("012:fk8gjMgfej%f_fifm*kgg7ed"), new Object[0])).intValue()));
                        } catch (Throwable unused2) {
                        }
                        try {
                            hashMap.put(l.a("009fgjIghelekfiffed"), Integer.valueOf(((Integer) ReflectHelper.invokeInstanceMethod(obj, l.a("012!fkZgj]fh5gjUghelekfiffed"), new Object[0])).intValue()));
                        } catch (Throwable unused3) {
                        }
                        try {
                            hashMap.put(l.a("005hgAee]gh"), Integer.valueOf(((Integer) ReflectHelper.invokeInstanceMethod(obj, l.a("007(fk1gj$hkgjgjej"), new Object[0])).intValue()));
                        } catch (Throwable unused4) {
                        }
                        try {
                            hashMap.put(l.a("009;fgekQg*efehNgfd%fd"), Integer.valueOf(((Integer) ReflectHelper.invokeInstanceMethod(obj, l.a("012;fkDgjPhdek9g-efeh,gfdCfd"), new Object[0])).intValue()));
                        } catch (Throwable unused5) {
                        }
                        return hashMap;
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:49|(7:51|52|53|(1:55)(1:56)|57|88|58)|87|60|61|62|63|64|(3:66|(1:68)(1:69)|70)|71|72|80) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0123 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0147 */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0129 A[Catch:{ all -> 0x0147 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> z() {
        /*
            r14 = this;
            boolean r0 = com.mob.commons.d.d()
            r1 = 0
            if (r0 == 0) goto L_0x0155
            java.lang.String r0 = "036ef@edekelejedem(kg(ekegejgjgjejel.fKemgefefehjfmfmeihgffhdffeifmgdgegdhj"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x014d }
            boolean r0 = r14.d(r0)     // Catch:{ all -> 0x014d }
            if (r0 == 0) goto L_0x0155
            com.mob.commons.CSCenter r0 = com.mob.commons.CSCenter.getInstance()     // Catch:{ all -> 0x014d }
            boolean r0 = r0.isWifiDataEnable()     // Catch:{ all -> 0x014d }
            r2 = 0
            if (r0 == 0) goto L_0x003a
            java.lang.String r0 = "004Sghejfgej"
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r0)     // Catch:{ all -> 0x014d }
            java.lang.Object r0 = com.mob.tools.utils.DH.SyncMtd.getSystemServiceSafe(r0)     // Catch:{ all -> 0x014d }
            if (r0 != 0) goto L_0x002b
            return r1
        L_0x002b:
            java.lang.String r3 = "0145fkTgjIfm7def;hkEg)gjehThjBgj"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)     // Catch:{ all -> 0x014d }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x014d }
            java.lang.Object r0 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r0, r3, r4)     // Catch:{ all -> 0x014d }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x014d }
            goto L_0x004f
        L_0x003a:
            com.mob.commons.CSCenter r0 = com.mob.commons.CSCenter.getInstance()     // Catch:{ all -> 0x014d }
            java.util.List r0 = r0.getWifiScanResults()     // Catch:{ all -> 0x014d }
            if (r0 == 0) goto L_0x004e
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x014d }
            r3.<init>()     // Catch:{ all -> 0x014d }
            r3.addAll(r0)     // Catch:{ all -> 0x014d }
            r0 = r3
            goto L_0x004f
        L_0x004e:
            r0 = r1
        L_0x004f:
            if (r0 != 0) goto L_0x0052
            return r1
        L_0x0052:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x014d }
            r4 = 27
            java.lang.String r5 = ","
            if (r3 <= r4) goto L_0x006f
            java.lang.String r3 = "086*fmfmffgmkigkfmfmffgmkiWdeke^ggejHhHej%j6ejDgHgjkiThg>ee+ghRkifgek)gPefehYgfdVfdki9dieffghJhgejed-jiAki%dgfjgVekhdekSgXefgikiXdgfjg'ekhdekBg5efigkiIj^ejeg7gHgj,jeSegMk"
            java.lang.String r3 = com.mob.commons.a.l.a((java.lang.String) r3)     // Catch:{ all -> 0x014d }
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ all -> 0x014d }
            java.lang.String r4 = "031;ee0gf?eh g0fh.e;eg[g7kijgelKkgYek3ej@elekhdekej@gfBedUhUfdfhReFeg[g"
            java.lang.String r4 = com.mob.commons.a.l.a((java.lang.String) r4)     // Catch:{ all -> 0x014d }
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ all -> 0x014d }
            goto L_0x007f
        L_0x006f:
            java.lang.String r3 = "SSID,BSSID,hessid,anqpDomainId,capabilities,level,frequency,channelWidth,centerFreq0,centerFreq1,timestamp,seen,isAutoJoinCandidate,numIpConfigFailures,blackListTimestamp,untrusted,numConnection,numUsage,distanceCm,distanceSdCm,flags"
            java.lang.String[] r3 = r3.split(r5)     // Catch:{ all -> 0x014d }
            java.lang.String r4 = "0396ghejfgejfmgjejedkieeRgf eh9gTfh9e%eg_gZkielEkg?ek0ej7elekhdekej9gf;edJhOfdfh(ePegFg"
            java.lang.String r4 = com.mob.commons.a.l.a((java.lang.String) r4)     // Catch:{ all -> 0x014d }
            java.lang.String[] r4 = r4.split(r5)     // Catch:{ all -> 0x014d }
        L_0x007f:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x014d }
            r5.<init>()     // Catch:{ all -> 0x014d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x014d }
        L_0x0088:
            boolean r6 = r0.hasNext()     // Catch:{ all -> 0x014d }
            if (r6 == 0) goto L_0x014c
            java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x014d }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x014d }
            r7.<init>()     // Catch:{ all -> 0x014d }
            int r8 = r3.length     // Catch:{ all -> 0x014d }
            r10 = r1
            r9 = r2
        L_0x009a:
            if (r9 >= r8) goto L_0x00eb
            r11 = r3[r9]     // Catch:{ all -> 0x014d }
            java.lang.String r11 = r11.trim()     // Catch:{ all -> 0x014d }
            java.lang.String r12 = "004^fmfmffgm"
            java.lang.String r12 = com.mob.commons.a.l.a((java.lang.String) r12)     // Catch:{ all -> 0x014d }
            boolean r12 = r12.equals(r11)     // Catch:{ all -> 0x014d }
            if (r12 == 0) goto L_0x00bf
            java.lang.Object r10 = com.mob.tools.utils.ReflectHelper.getInstanceField(r6, r11, r1)     // Catch:{ all -> 0x014d }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x014d }
            boolean r12 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x014d }
            if (r12 == 0) goto L_0x00bb
            goto L_0x00eb
        L_0x00bb:
            r7.put(r11, r10)     // Catch:{ all -> 0x014d }
            goto L_0x00e8
        L_0x00bf:
            java.lang.String r12 = "012deke]ggejOh,ej:j1ej>g^gj"
            java.lang.String r12 = com.mob.commons.a.l.a((java.lang.String) r12)     // Catch:{ all -> 0x014d }
            boolean r12 = r12.equals(r11)     // Catch:{ all -> 0x014d }
            if (r12 == 0) goto L_0x00e1
            java.lang.Object r12 = com.mob.tools.utils.ReflectHelper.getInstanceField(r6, r11, r1)     // Catch:{ all -> 0x014d }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x014d }
            if (r12 == 0) goto L_0x00dd
            java.lang.String r13 = "[IBSS]"
            boolean r13 = r12.contains(r13)     // Catch:{ all -> 0x014d }
            if (r13 == 0) goto L_0x00dd
            r10 = r1
            goto L_0x00eb
        L_0x00dd:
            r7.put(r11, r12)     // Catch:{ all -> 0x014d }
            goto L_0x00e8
        L_0x00e1:
            java.lang.Object r12 = com.mob.tools.utils.ReflectHelper.getInstanceField(r6, r11, r1)     // Catch:{ all -> 0x014d }
            r7.put(r11, r12)     // Catch:{ all -> 0x014d }
        L_0x00e8:
            int r9 = r9 + 1
            goto L_0x009a
        L_0x00eb:
            boolean r8 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x014d }
            if (r8 == 0) goto L_0x00f2
            goto L_0x0088
        L_0x00f2:
            int r8 = r4.length     // Catch:{ all -> 0x014d }
            r9 = r2
        L_0x00f4:
            if (r9 >= r8) goto L_0x010e
            r10 = r4[r9]     // Catch:{ all -> 0x014d }
            java.lang.String r10 = r10.trim()     // Catch:{ all -> 0x010b }
            java.lang.Object r11 = com.mob.tools.utils.ReflectHelper.getInstanceField(r6, r10)     // Catch:{ all -> 0x010b }
            if (r11 != 0) goto L_0x0104
            r11 = r1
            goto L_0x0108
        L_0x0104:
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010b }
        L_0x0108:
            r7.put(r10, r11)     // Catch:{ all -> 0x010b }
        L_0x010b:
            int r9 = r9 + 1
            goto L_0x00f4
        L_0x010e:
            java.lang.String r8 = "018:ejgjiegiifigigegKd)hkJg1gj[k:el5fMed2gVek"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x0123 }
            java.lang.Object[] r9 = new java.lang.Object[r2]     // Catch:{ all -> 0x0123 }
            java.lang.Object r8 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r6, r8, r9)     // Catch:{ all -> 0x0123 }
            java.lang.String r9 = "021Qejgjiegiifigigid d]hkgdgdhkQgZgjEkRel8f^edXg3ek"
            java.lang.String r9 = com.mob.commons.a.l.a((java.lang.String) r9)     // Catch:{ all -> 0x0123 }
            r7.put(r9, r8)     // Catch:{ all -> 0x0123 }
        L_0x0123:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0147 }
            r9 = 28
            if (r8 >= r9) goto L_0x0147
            java.lang.String r8 = "009ef7ef1k<gfej6fgBgj"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x0147 }
            java.lang.Object r6 = com.mob.tools.utils.ReflectHelper.getInstanceField(r6, r8)     // Catch:{ all -> 0x0147 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0147 }
            java.lang.String r8 = "009ef=efNk<gfej<fgMgj"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x0147 }
            if (r6 != 0) goto L_0x013f
            r9 = r1
            goto L_0x0144
        L_0x013f:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0147 }
            r9.<init>(r6)     // Catch:{ all -> 0x0147 }
        L_0x0144:
            r7.put(r8, r9)     // Catch:{ all -> 0x0147 }
        L_0x0147:
            r5.add(r7)     // Catch:{ all -> 0x014d }
            goto L_0x0088
        L_0x014c:
            return r5
        L_0x014d:
            r0 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.w((java.lang.Throwable) r0)
        L_0x0155:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.z():java.util.ArrayList");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.io.ObjectOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void f(java.lang.String r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f27760a
            java.lang.String r1 = "003;emedfi"
            java.lang.String r1 = com.mob.commons.a.l.a((java.lang.String) r1)
            java.io.File r0 = com.mob.tools.utils.ResHelper.getCacheRootFile(r0, r1)
            if (r0 == 0) goto L_0x0017
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0017
            r0.delete()
        L_0x0017:
            r1 = 0
            r2 = 1
            r3 = 0
            r4 = 2
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x003e }
            r5.<init>(r0)     // Catch:{ all -> 0x003e }
            java.io.ObjectOutputStream r0 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x003c }
            r0.<init>(r5)     // Catch:{ all -> 0x003c }
            char[] r7 = r7.toCharArray()     // Catch:{ all -> 0x0039 }
            r0.writeObject(r7)     // Catch:{ all -> 0x0039 }
            r0.flush()     // Catch:{ all -> 0x0039 }
            java.io.Closeable[] r7 = new java.io.Closeable[r4]
            r7[r3] = r0
            r7[r2] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r7)
            goto L_0x0050
        L_0x0039:
            r7 = move-exception
            r1 = r0
            goto L_0x0040
        L_0x003c:
            r7 = move-exception
            goto L_0x0040
        L_0x003e:
            r7 = move-exception
            r5 = r1
        L_0x0040:
            com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x0051 }
            r0.d(r7)     // Catch:{ all -> 0x0051 }
            java.io.Closeable[] r7 = new java.io.Closeable[r4]
            r7[r3] = r1
            r7[r2] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r7)
        L_0x0050:
            return
        L_0x0051:
            r7 = move-exception
            java.io.Closeable[] r0 = new java.io.Closeable[r4]
            r0[r3] = r1
            r0[r2] = r5
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.f(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.io.Closeable[]} */
    /* JADX WARNING: type inference failed for: r9v4, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ab A[SYNTHETIC, Splitter:B:50:0x00ab] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(java.lang.String r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "007Ved+gYgj j8ekelfd"
            r2 = 2
            r3 = 3
            r4 = 1
            r5 = 0
            r6 = 0
            java.lang.String r7 = "002k8gj"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x009a }
            java.lang.Object r7 = com.mob.commons.v.c(r7)     // Catch:{ all -> 0x009a }
            java.lang.String r8 = "014Jfk^gj-ffBfk2ehJj(fm-jVek5ge^eg"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x0097 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ all -> 0x0097 }
            java.lang.Object r8 = com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r8, r9)     // Catch:{ all -> 0x0097 }
            java.io.InputStream r8 = (java.io.InputStream) r8     // Catch:{ all -> 0x0097 }
            java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ all -> 0x0094 }
            java.lang.String r10 = "utf-8"
            r9.<init>(r8, r10)     // Catch:{ all -> 0x0094 }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ all -> 0x0092 }
            r10.<init>(r9)     // Catch:{ all -> 0x0092 }
            java.lang.String r5 = "^\\s*(\\S+)\\s+(\\d+)\\s+(\\d+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+(\\d+)\\s+(\\w)\\s+(.+)$"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)     // Catch:{ all -> 0x008f }
            r11 = r4
        L_0x0034:
            java.lang.String r12 = r10.readLine()     // Catch:{ all -> 0x0090 }
            if (r12 == 0) goto L_0x0078
            java.util.regex.Matcher r12 = r5.matcher(r12)     // Catch:{ all -> 0x0090 }
            boolean r13 = r12.matches()     // Catch:{ all -> 0x0090 }
            if (r13 == 0) goto L_0x0034
            java.lang.String r13 = r12.group(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r14 = r12.group(r3)     // Catch:{ all -> 0x0090 }
            r15 = 6
            java.lang.String r12 = r12.group(r15)     // Catch:{ all -> 0x0090 }
            java.lang.String r15 = com.mob.tools.utils.DH.SyncMtd.getPackageName()     // Catch:{ all -> 0x0090 }
            boolean r16 = android.text.TextUtils.equals(r15, r12)     // Catch:{ all -> 0x0090 }
            if (r16 == 0) goto L_0x0069
            boolean r16 = android.text.TextUtils.equals(r13, r0)     // Catch:{ all -> 0x0090 }
            if (r16 != 0) goto L_0x0067
            boolean r14 = android.text.TextUtils.equals(r14, r0)     // Catch:{ all -> 0x0090 }
            if (r14 == 0) goto L_0x0069
        L_0x0067:
            r11 = r6
            goto L_0x0034
        L_0x0069:
            if (r12 == 0) goto L_0x0034
            boolean r12 = r12.contains(r15)     // Catch:{ all -> 0x0090 }
            if (r12 == 0) goto L_0x0034
            boolean r12 = android.text.TextUtils.equals(r0, r13)     // Catch:{ all -> 0x0090 }
            if (r12 == 0) goto L_0x0034
            goto L_0x0067
        L_0x0078:
            java.io.Closeable[] r0 = new java.io.Closeable[r3]
            r0[r6] = r10
            r0[r4] = r9
            r0[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            if (r7 == 0) goto L_0x00b4
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x00b4 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b4 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r1)     // Catch:{ all -> 0x00b4 }
            goto L_0x00b4
        L_0x008f:
            r11 = r4
        L_0x0090:
            r5 = r10
            goto L_0x009e
        L_0x0092:
            r11 = r4
            goto L_0x009e
        L_0x0094:
            r11 = r4
            r9 = r5
            goto L_0x009e
        L_0x0097:
            r11 = r4
            r8 = r5
            goto L_0x009d
        L_0x009a:
            r11 = r4
            r7 = r5
            r8 = r7
        L_0x009d:
            r9 = r8
        L_0x009e:
            java.io.Closeable[] r0 = new java.io.Closeable[r3]
            r0[r6] = r5
            r0[r4] = r9
            r0[r2] = r8
            com.mob.commons.v.a((java.io.Closeable[]) r0)
            if (r7 == 0) goto L_0x00b4
            java.lang.String r0 = com.mob.commons.a.l.a((java.lang.String) r1)     // Catch:{ all -> 0x00b4 }
            java.lang.Object[] r1 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b4 }
            com.mob.tools.utils.ReflectHelper.invokeInstanceMethod(r7, r0, r1)     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.g(java.lang.String):boolean");
    }

    public String c(String str) {
        ApplicationInfo a11;
        CharSequence g11;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (TextUtils.isEmpty(str) || (a11 = c.a(this.f27760a).d().a(str, 1)) == null || (g11 = c.g(a11, str)) == null) {
                return null;
            }
            return g11.toString();
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return null;
        }
    }

    public boolean e(String str) {
        return c.a(this.f27760a).d().a(true, str, 0) != null;
    }

    public synchronized boolean a() {
        String d11;
        d11 = v.d();
        return d11 != null && d11.length() == 5 && (d11.charAt(3) == '1' || d11.charAt(4) == '1');
    }

    public String b(String str) {
        Object obj;
        Signature[] b11;
        try {
            if (str.equals(DH.SyncMtd.getPackageName())) {
                obj = c.a(this.f27760a).d().b(false, 0, str, 64);
            } else {
                obj = c.a(this.f27760a).d().a(false, 0, str, 64);
            }
            if (obj == null || (b11 = c.b(obj, str)) == null || b11.length <= 0) {
                return null;
            }
            return Data.MD5(b11[0].toByteArray());
        } catch (Exception e11) {
            MobLog.getInstance().w((Throwable) e11);
            return null;
        }
    }

    public String a(String str) {
        return e.a(this.f27760a).a(str);
    }

    public String a(boolean z11) {
        String au2 = au();
        if (!z11 && (TextUtils.isEmpty(au2) || au2.length() < 40)) {
            au2 = at();
        }
        if (!TextUtils.isEmpty(au2) && au2.length() >= 40) {
            return au2.trim();
        }
        String aw2 = aw();
        if (!TextUtils.isEmpty(aw2) && aw2.length() >= 40) {
            return aw2.trim();
        }
        if (TextUtils.isEmpty(aw2) || aw2.length() < 40) {
            aw2 = a(40);
        }
        if (aw2 == null) {
            return aw2;
        }
        String trim = aw2.trim();
        f(trim);
        return trim;
    }

    public boolean d(String str) throws Throwable {
        int i11;
        if (Build.VERSION.SDK_INT >= 23) {
            ReflectHelper.importClassNoThrow(l.a("023ef=edekelejedem>d6el3fjgfj.emfeelGfjg[fj(j"), (String) null);
            i11 = -1;
            Integer num = (Integer) ReflectHelper.invokeInstanceMethodNoThrow(this.f27760a, l.a("019digdIfifm,ghEfghm5g!ekegejgjgjejel,f"), -1, str);
            if (num != null) {
                i11 = num.intValue();
            }
        } else {
            i11 = this.f27760a.getPackageManager().checkPermission(str, o());
        }
        if (i11 == 0) {
            return true;
        }
        return false;
    }

    private void b(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            ResHelper.saveObjectToFile(ResHelper.getDataCacheFile(this.f27760a, l.a("004[em@efVgj")).getAbsolutePath(), hashMap);
        }
    }

    private ArrayList<HashMap<String, String>> b(int i11) {
        Set<String> set;
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        if (i11 == 1) {
            set = j.a(this.f27760a, 1);
        } else if (i11 == 2) {
            set = az();
        } else if (i11 == 3) {
            set = ay();
        } else if (i11 == 4) {
            set = j.a(this.f27760a, 4);
        } else if (i11 != 5) {
            set = null;
        } else {
            try {
                set = aA();
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
        }
        if (set != null && !set.isEmpty()) {
            arrayList = a(set);
        }
        NLog instance = MobLog.getInstance();
        instance.d("DH PD: ap " + arrayList.size() + " tpe " + i11, new Object[0]);
        return arrayList;
    }

    public String a(int i11) {
        long currentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(currentTimeMillis);
        SecureRandom secureRandom = new SecureRandom();
        for (int i12 = 0; i12 < i11; i12++) {
            if (l.a("004diePek").equalsIgnoreCase(l.a(secureRandom.nextInt(2) % 2 == 0 ? "004die%ek" : "003fPeheg"))) {
                stringBuffer.insert(i12 + 1, (char) (secureRandom.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), secureRandom.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    private int b(Context context) {
        String Y = Y();
        if (TextUtils.isEmpty(Y)) {
            return -1;
        }
        if (Y.equals(c.f(c.a(context).d().a(o(), 0), o()))) {
            return 1;
        }
        return 0;
    }

    private HashMap<String, Object> a(File file) {
        return a(c.a(this.f27760a).d().l(), ResHelper.readFromFileNoCompress(file));
    }

    private HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return HashonHelper.fromJson(Data.AES128Decode(str, bArr));
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return new HashMap<>();
        }
    }

    public ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> arrayList, int i11) {
        try {
            NLog instance = MobLog.getInstance();
            instance.d("DH PD: fabt " + i11, new Object[0]);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            ArrayList<HashMap<String, String>> arrayList2 = new ArrayList<>();
            Iterator<HashMap<String, String>> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                HashMap next = it2.next();
                boolean equals = TextUtils.equals("1", (CharSequence) next.get(l.a("005Mejgjgjfdgj")));
                if (i11 != 1 || !equals) {
                    if (i11 != 2 || equals) {
                        HashMap hashMap = new HashMap(next);
                        hashMap.remove(l.a("0057ejgjgjfdgj"));
                        arrayList2.add(hashMap);
                    }
                }
            }
            return arrayList2;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    private ArrayList<HashMap<String, String>> a(Set<String> set) {
        if (d.b() && set != null && !set.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (String next : set) {
                hashMap.put(next, c.a(this.f27760a).d().b(true, 0, next, 0));
            }
            if (!hashMap.isEmpty()) {
                return a((HashMap<String, Object>) hashMap);
            }
        }
        return new ArrayList<>();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:29|30|(2:32|33)) */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r2 = com.mob.tools.c.c(r7, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0092, code lost:
        if (r2 > 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0098, code lost:
        r8 = r1.getText(r5, r2, r7);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.String>> a(java.util.HashMap<java.lang.String, java.lang.Object> r14) {
        /*
            r13 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = com.mob.commons.d.b()
            if (r1 == 0) goto L_0x0106
            android.content.Context r1 = r13.f27760a     // Catch:{ all -> 0x00fe }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ all -> 0x00fe }
            r2 = 0
            java.util.HashMap r3 = r13.ax()     // Catch:{ all -> 0x00fe }
            if (r14 == 0) goto L_0x0106
            boolean r4 = r14.isEmpty()     // Catch:{ all -> 0x00fe }
            if (r4 != 0) goto L_0x0106
            java.util.Set r14 = r14.entrySet()     // Catch:{ all -> 0x00fe }
            java.util.Iterator r14 = r14.iterator()     // Catch:{ all -> 0x00fe }
        L_0x0026:
            boolean r4 = r14.hasNext()     // Catch:{ all -> 0x00fe }
            if (r4 == 0) goto L_0x00f8
            java.lang.Object r4 = r14.next()     // Catch:{ all -> 0x00fe }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ all -> 0x00fe }
            java.lang.Object r5 = r4.getKey()     // Catch:{ all -> 0x00fe }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00fe }
            java.lang.Object r4 = r4.getValue()     // Catch:{ all -> 0x00fe }
            if (r4 == 0) goto L_0x0026
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x00fe }
            r6.<init>()     // Catch:{ all -> 0x00fe }
            android.content.pm.ApplicationInfo r7 = com.mob.tools.c.a((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            if (r7 == 0) goto L_0x0026
            boolean r8 = r13.a((android.content.pm.ApplicationInfo) r7)     // Catch:{ all -> 0x00fe }
            java.lang.String r9 = "1"
            java.lang.String r10 = "0"
            if (r8 == 0) goto L_0x005d
            java.lang.String r8 = "005_ejgjgjfdgj"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00fe }
            r6.put(r8, r9)     // Catch:{ all -> 0x00fe }
            goto L_0x0066
        L_0x005d:
            java.lang.String r8 = "005>ejgjgjfdgj"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00fe }
            r6.put(r8, r10)     // Catch:{ all -> 0x00fe }
        L_0x0066:
            java.lang.String r8 = "003kYfifk"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00fe }
            r6.put(r8, r5)     // Catch:{ all -> 0x00fe }
            r8 = 0
            if (r3 == 0) goto L_0x007d
            java.lang.String r11 = com.mob.tools.utils.Data.MD5((java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            java.lang.Object r11 = r3.get(r11)     // Catch:{ all -> 0x00fe }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00fe }
            goto L_0x0083
        L_0x007d:
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x00fe }
            r3.<init>()     // Catch:{ all -> 0x00fe }
            r11 = r8
        L_0x0083:
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00fe }
            if (r12 == 0) goto L_0x00aa
            java.lang.CharSequence r8 = com.mob.tools.c.g((android.content.pm.ApplicationInfo) r7, (java.lang.String) r5)     // Catch:{ all -> 0x008e }
            goto L_0x0099
        L_0x008e:
            int r2 = com.mob.tools.c.c((android.content.pm.ApplicationInfo) r7, (java.lang.String) r5)     // Catch:{ all -> 0x0099 }
            if (r2 <= 0) goto L_0x0099
            java.lang.CharSequence r2 = r1.getText(r5, r2, r7)     // Catch:{ all -> 0x0099 }
            r8 = r2
        L_0x0099:
            if (r8 != 0) goto L_0x009d
            r11 = r5
            goto L_0x00a2
        L_0x009d:
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x00fe }
            r11 = r2
        L_0x00a2:
            java.lang.String r2 = com.mob.tools.utils.Data.MD5((java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            r3.put(r2, r11)     // Catch:{ all -> 0x00fe }
            r2 = 1
        L_0x00aa:
            java.lang.String r8 = "004feWeg;g"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00fe }
            r6.put(r8, r11)     // Catch:{ all -> 0x00fe }
            java.lang.String r8 = "0074ee@g+ekgjejel-f"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00fe }
            java.lang.String r11 = com.mob.tools.c.c((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            r6.put(r8, r11)     // Catch:{ all -> 0x00fe }
            java.lang.String r8 = "006gfe9gg_hg"
            java.lang.String r8 = com.mob.commons.a.l.a((java.lang.String) r8)     // Catch:{ all -> 0x00fe }
            boolean r7 = com.mob.tools.c.e((android.content.pm.ApplicationInfo) r7, (java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            if (r7 == 0) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r9 = r10
        L_0x00ce:
            r6.put(r8, r9)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = "016(fgejekgjRjLff^f^gjZjehh_gdejeg:g"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x00fe }
            long r8 = com.mob.tools.c.d((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x00fe }
            r6.put(r7, r8)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = "014heKgj(j;flZk<ed)ejgRgdejeg_g"
            java.lang.String r7 = com.mob.commons.a.l.a((java.lang.String) r7)     // Catch:{ all -> 0x00fe }
            long r4 = com.mob.tools.c.e((java.lang.Object) r4, (java.lang.String) r5)     // Catch:{ all -> 0x00fe }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x00fe }
            r6.put(r7, r4)     // Catch:{ all -> 0x00fe }
            r0.add(r6)     // Catch:{ all -> 0x00fe }
            goto L_0x0026
        L_0x00f8:
            if (r2 == 0) goto L_0x0106
            r13.b((java.util.HashMap<java.lang.String, java.lang.String>) r3)     // Catch:{ all -> 0x00fe }
            goto L_0x0106
        L_0x00fe:
            r14 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.d(r14)
        L_0x0106:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.b.b.a(java.util.HashMap):java.util.ArrayList");
    }

    private boolean a(ApplicationInfo applicationInfo) {
        int i11 = applicationInfo.flags;
        return ((i11 & 1) == 1) || ((i11 & 128) != 0);
    }

    public List a(int i11, int i12, boolean z11, boolean z12) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return f.a().a(this.f27760a, i11, i12, z11, z12);
        }
        MobLog.getInstance().d("glctn can not be called from Main Thread", new Object[0]);
        return null;
    }

    public void a(final BlockingQueue<Boolean> blockingQueue) {
        if (d.d() && CSCenter.getInstance().isWifiDataEnable()) {
            AnonymousClass1 r02 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    try {
                        v.a((BroadcastReceiver) this);
                        if (l.a("029efBedekelejedemHfgjKemghejfgejemfmfegefheihkhjfmflgfgdfm").equals(intent.getAction())) {
                            blockingQueue.put(Boolean.TRUE);
                        }
                    } catch (Throwable th2) {
                        MobLog.getInstance().d(th2);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(l.a("029efNedekelejedem5fgjZemghejfgejemfmfegefheihkhjfmflgfgdfm"));
            v.a((BroadcastReceiver) r02, intentFilter);
        }
    }

    private HashMap<String, Object> a(Object obj) {
        long j11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        String str;
        int i19;
        int i21;
        Throwable th2;
        String str2;
        String str3;
        String str4;
        int i22;
        String str5;
        StringBuilder sb2;
        int j12;
        long k11;
        int i23;
        StringBuilder sb3;
        int i24 = Build.VERSION.SDK_INT;
        Object g11 = b.a.g(obj);
        HashMap<String, Object> hashMap = new HashMap<>();
        String str6 = null;
        int i25 = -1;
        long j13 = -1;
        if (b.a.b(obj)) {
            str6 = String.valueOf(b.a.h(g11));
            int i26 = b.a.i(g11);
            if (i26 < 10) {
                sb3.append("0");
            } else {
                sb3 = new StringBuilder();
                sb3.append("");
            }
            sb3.append(i26);
            str = sb3.toString();
            j12 = b.a.j(g11);
            k11 = (long) b.a.k(g11);
            i18 = b.a.l(g11);
            i23 = 1;
        } else {
            if (b.a.c(obj)) {
                int m11 = b.a.m(g11);
                int n11 = b.a.n(g11);
                int o11 = b.a.o(g11);
                i14 = b.a.p(g11);
                i11 = -1;
                j11 = (long) b.a.q(g11);
                i13 = 2;
                i15 = o11;
                i18 = -1;
                i12 = -1;
                i16 = n11;
                i17 = m11;
                str = null;
            } else if (b.a.d(obj)) {
                str6 = String.valueOf(b.a.h(g11));
                int i27 = b.a.i(g11);
                if (i27 < 10) {
                    sb2.append("0");
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("");
                }
                sb2.append(i27);
                str = sb2.toString();
                j12 = b.a.j(g11);
                k11 = (long) b.a.k(g11);
                i18 = b.a.l(g11);
                i23 = 3;
            } else {
                if (b.a.e(obj)) {
                    str4 = String.valueOf(b.a.h(g11));
                    int i28 = b.a.i(g11);
                    if (i28 < 10) {
                        str5 = "0" + i28;
                    } else {
                        str5 = "" + i28;
                    }
                    i21 = b.a.r(g11);
                    long s11 = (long) b.a.s(g11);
                    int t11 = b.a.t(g11);
                    i11 = i24 >= 24 ? b.a.u(g11) : -1;
                    str3 = str5;
                    i17 = -1;
                    i14 = -1;
                    j11 = s11;
                    i13 = 4;
                    i12 = t11;
                    i22 = -1;
                    i15 = -1;
                } else if (b.a.f(obj)) {
                    try {
                        String v11 = b.a.v(g11);
                        try {
                            String w11 = b.a.w(g11);
                            i21 = b.a.r(g11);
                            try {
                                j13 = b.a.x(g11);
                                i19 = b.a.t(g11);
                            } catch (Throwable th3) {
                                th2 = th3;
                                str2 = w11;
                                i19 = -1;
                                str6 = v11;
                                MobLog.getInstance().d(th2);
                                i18 = -1;
                                i17 = -1;
                                i14 = -1;
                                i11 = -1;
                                j11 = j13;
                                i25 = i21;
                                i12 = i19;
                                i16 = -1;
                                i15 = -1;
                                i13 = -1;
                                hashMap.put(l.a("003hed"), Integer.valueOf(i25));
                                hashMap.put(l.a("004dghh"), Long.valueOf(j11));
                                hashMap.put(l.a("003kOgj6d"), Integer.valueOf(i18));
                                hashMap.put(l.a("003Agjejed"), Integer.valueOf(i17));
                                hashMap.put(l.a("003f8ejed"), Integer.valueOf(i16));
                                hashMap.put(l.a("003hej"), Integer.valueOf(i15));
                                hashMap.put(l.a("003hSelFf"), Integer.valueOf(i14));
                                hashMap.put("mcc", str6);
                                hashMap.put("mnc", str);
                                hashMap.put(l.a("004j!fd>kg"), Integer.valueOf(i13));
                                hashMap.put("pci", Integer.valueOf(i12));
                                hashMap.put("xarfcn", Integer.valueOf(i11));
                                return hashMap;
                            }
                            try {
                                i11 = b.a.y(g11);
                                str3 = w11;
                                i14 = -1;
                                j11 = j13;
                                i13 = 5;
                                str4 = v11;
                                i12 = i19;
                                i22 = -1;
                                i17 = -1;
                                i15 = -1;
                            } catch (Throwable th4) {
                                th2 = th4;
                                str2 = w11;
                                str6 = v11;
                                MobLog.getInstance().d(th2);
                                i18 = -1;
                                i17 = -1;
                                i14 = -1;
                                i11 = -1;
                                j11 = j13;
                                i25 = i21;
                                i12 = i19;
                                i16 = -1;
                                i15 = -1;
                                i13 = -1;
                                hashMap.put(l.a("003hed"), Integer.valueOf(i25));
                                hashMap.put(l.a("004dghh"), Long.valueOf(j11));
                                hashMap.put(l.a("003kOgj6d"), Integer.valueOf(i18));
                                hashMap.put(l.a("003Agjejed"), Integer.valueOf(i17));
                                hashMap.put(l.a("003f8ejed"), Integer.valueOf(i16));
                                hashMap.put(l.a("003hej"), Integer.valueOf(i15));
                                hashMap.put(l.a("003hSelFf"), Integer.valueOf(i14));
                                hashMap.put("mcc", str6);
                                hashMap.put("mnc", str);
                                hashMap.put(l.a("004j!fd>kg"), Integer.valueOf(i13));
                                hashMap.put("pci", Integer.valueOf(i12));
                                hashMap.put("xarfcn", Integer.valueOf(i11));
                                return hashMap;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            str2 = null;
                            i21 = -1;
                            i19 = -1;
                            str6 = v11;
                            MobLog.getInstance().d(th2);
                            i18 = -1;
                            i17 = -1;
                            i14 = -1;
                            i11 = -1;
                            j11 = j13;
                            i25 = i21;
                            i12 = i19;
                            i16 = -1;
                            i15 = -1;
                            i13 = -1;
                            hashMap.put(l.a("003hed"), Integer.valueOf(i25));
                            hashMap.put(l.a("004dghh"), Long.valueOf(j11));
                            hashMap.put(l.a("003kOgj6d"), Integer.valueOf(i18));
                            hashMap.put(l.a("003Agjejed"), Integer.valueOf(i17));
                            hashMap.put(l.a("003f8ejed"), Integer.valueOf(i16));
                            hashMap.put(l.a("003hej"), Integer.valueOf(i15));
                            hashMap.put(l.a("003hSelFf"), Integer.valueOf(i14));
                            hashMap.put("mcc", str6);
                            hashMap.put("mnc", str);
                            hashMap.put(l.a("004j!fd>kg"), Integer.valueOf(i13));
                            hashMap.put("pci", Integer.valueOf(i12));
                            hashMap.put("xarfcn", Integer.valueOf(i11));
                            return hashMap;
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        str2 = null;
                        i21 = -1;
                        i19 = -1;
                        MobLog.getInstance().d(th2);
                        i18 = -1;
                        i17 = -1;
                        i14 = -1;
                        i11 = -1;
                        j11 = j13;
                        i25 = i21;
                        i12 = i19;
                        i16 = -1;
                        i15 = -1;
                        i13 = -1;
                        hashMap.put(l.a("003hed"), Integer.valueOf(i25));
                        hashMap.put(l.a("004dghh"), Long.valueOf(j11));
                        hashMap.put(l.a("003kOgj6d"), Integer.valueOf(i18));
                        hashMap.put(l.a("003Agjejed"), Integer.valueOf(i17));
                        hashMap.put(l.a("003f8ejed"), Integer.valueOf(i16));
                        hashMap.put(l.a("003hej"), Integer.valueOf(i15));
                        hashMap.put(l.a("003hSelFf"), Integer.valueOf(i14));
                        hashMap.put("mcc", str6);
                        hashMap.put("mnc", str);
                        hashMap.put(l.a("004j!fd>kg"), Integer.valueOf(i13));
                        hashMap.put("pci", Integer.valueOf(i12));
                        hashMap.put("xarfcn", Integer.valueOf(i11));
                        return hashMap;
                    }
                } else {
                    str = null;
                    i18 = -1;
                    i17 = -1;
                    i16 = -1;
                    i15 = -1;
                    i14 = -1;
                    i11 = -1;
                    j11 = -1;
                    i13 = -1;
                    i12 = -1;
                }
                i25 = i21;
                i16 = i15;
            }
            hashMap.put(l.a("003hed"), Integer.valueOf(i25));
            hashMap.put(l.a("004dghh"), Long.valueOf(j11));
            hashMap.put(l.a("003kOgj6d"), Integer.valueOf(i18));
            hashMap.put(l.a("003Agjejed"), Integer.valueOf(i17));
            hashMap.put(l.a("003f8ejed"), Integer.valueOf(i16));
            hashMap.put(l.a("003hej"), Integer.valueOf(i15));
            hashMap.put(l.a("003hSelFf"), Integer.valueOf(i14));
            hashMap.put("mcc", str6);
            hashMap.put("mnc", str);
            hashMap.put(l.a("004j!fd>kg"), Integer.valueOf(i13));
            hashMap.put("pci", Integer.valueOf(i12));
            hashMap.put("xarfcn", Integer.valueOf(i11));
            return hashMap;
        }
        i15 = -1;
        i14 = -1;
        i11 = -1;
        j11 = k11;
        i25 = j12;
        i13 = i23;
        i17 = -1;
        i16 = -1;
        i12 = -1;
        hashMap.put(l.a("003hed"), Integer.valueOf(i25));
        hashMap.put(l.a("004dghh"), Long.valueOf(j11));
        hashMap.put(l.a("003kOgj6d"), Integer.valueOf(i18));
        hashMap.put(l.a("003Agjejed"), Integer.valueOf(i17));
        hashMap.put(l.a("003f8ejed"), Integer.valueOf(i16));
        hashMap.put(l.a("003hej"), Integer.valueOf(i15));
        hashMap.put(l.a("003hSelFf"), Integer.valueOf(i14));
        hashMap.put("mcc", str6);
        hashMap.put("mnc", str);
        hashMap.put(l.a("004j!fd>kg"), Integer.valueOf(i13));
        hashMap.put("pci", Integer.valueOf(i12));
        hashMap.put("xarfcn", Integer.valueOf(i11));
        return hashMap;
    }
}
