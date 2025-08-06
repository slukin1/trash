package com.alibaba.android.arouter.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import c2.b;
import com.alibaba.android.arouter.facade.template.ILogger;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class ClassUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14075a = ("code_cache" + File.separator + "secondary-dexes");

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14076b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14077c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Set f14078d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f14079e;

        public a(String str, String str2, Set set, CountDownLatch countDownLatch) {
            this.f14076b = str;
            this.f14077c = str2;
            this.f14078d = set;
            this.f14079e = countDownLatch;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
            if (r0 == null) goto L_0x0059;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                java.lang.String r1 = r4.f14076b     // Catch:{ all -> 0x004c }
                java.lang.String r2 = ".zip"
                boolean r1 = r1.endsWith(r2)     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x0026
                java.lang.String r1 = r4.f14076b     // Catch:{ all -> 0x004c }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
                r2.<init>()     // Catch:{ all -> 0x004c }
                java.lang.String r3 = r4.f14076b     // Catch:{ all -> 0x004c }
                r2.append(r3)     // Catch:{ all -> 0x004c }
                java.lang.String r3 = ".tmp"
                r2.append(r3)     // Catch:{ all -> 0x004c }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x004c }
                r3 = 0
                dalvik.system.DexFile r0 = dalvik.system.DexFile.loadDex(r1, r2, r3)     // Catch:{ all -> 0x004c }
                goto L_0x002e
            L_0x0026:
                dalvik.system.DexFile r1 = new dalvik.system.DexFile     // Catch:{ all -> 0x004c }
                java.lang.String r2 = r4.f14076b     // Catch:{ all -> 0x004c }
                r1.<init>(r2)     // Catch:{ all -> 0x004c }
                r0 = r1
            L_0x002e:
                java.util.Enumeration r1 = r0.entries()     // Catch:{ all -> 0x004c }
            L_0x0032:
                boolean r2 = r1.hasMoreElements()     // Catch:{ all -> 0x004c }
                if (r2 == 0) goto L_0x0056
                java.lang.Object r2 = r1.nextElement()     // Catch:{ all -> 0x004c }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x004c }
                java.lang.String r3 = r4.f14077c     // Catch:{ all -> 0x004c }
                boolean r3 = r2.startsWith(r3)     // Catch:{ all -> 0x004c }
                if (r3 == 0) goto L_0x0032
                java.util.Set r3 = r4.f14078d     // Catch:{ all -> 0x004c }
                r3.add(r2)     // Catch:{ all -> 0x004c }
                goto L_0x0032
            L_0x004c:
                r1 = move-exception
                java.lang.String r2 = "ARouter"
                java.lang.String r3 = "Scan map file in dex files made error."
                android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x005f }
                if (r0 == 0) goto L_0x0059
            L_0x0056:
                r0.close()     // Catch:{ all -> 0x0059 }
            L_0x0059:
                java.util.concurrent.CountDownLatch r0 = r4.f14079e
                r0.countDown()
                return
            L_0x005f:
                r1 = move-exception
                if (r0 == 0) goto L_0x0065
                r0.close()     // Catch:{ all -> 0x0065 }
            L_0x0065:
                java.util.concurrent.CountDownLatch r0 = r4.f14079e
                r0.countDown()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.utils.ClassUtils.a.run():void");
        }
    }

    public static Set<String> a(Context context, String str) throws PackageManager.NameNotFoundException, IOException, InterruptedException {
        HashSet hashSet = new HashSet();
        List<String> c11 = c(context);
        CountDownLatch countDownLatch = new CountDownLatch(c11.size());
        for (String aVar : c11) {
            b.a().execute(new a(aVar, str, hashSet, countDownLatch));
        }
        countDownLatch.await();
        Log.d(ILogger.defaultTag, "Filter " + hashSet.size() + " classes by packageName <" + str + ">");
        return hashSet;
    }

    public static SharedPreferences b(Context context) {
        return context.getSharedPreferences("multidex.version", Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    public static List<String> c(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + ".classes";
        if (!d()) {
            int i11 = b(context).getInt("dex.number", 1);
            File file2 = new File(applicationInfo.dataDir, f14075a);
            int i12 = 2;
            while (i12 <= i11) {
                File file3 = new File(file2, str + i12 + ".zip");
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                    i12++;
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
        }
        if (b2.a.c()) {
            arrayList.addAll(f(applicationInfo));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r2 < 1) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (java.lang.Integer.valueOf(java.lang.System.getProperty("ro.build.version.sdk")).intValue() >= 21) goto L_0x001d;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d() {
        /*
            r0 = 0
            r1 = 0
            boolean r2 = e()     // Catch:{  }
            r3 = 1
            if (r2 == 0) goto L_0x001f
            java.lang.String r1 = "'YunOS'"
            java.lang.String r2 = "ro.build.version.sdk"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{  }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{  }
            int r2 = r2.intValue()     // Catch:{  }
            r4 = 21
            if (r2 < r4) goto L_0x0051
        L_0x001d:
            r0 = r3
            goto L_0x0051
        L_0x001f:
            java.lang.String r1 = "'Android'"
            java.lang.String r2 = "java.vm.version"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch:{  }
            if (r2 == 0) goto L_0x0051
            java.lang.String r4 = "(\\d+)\\.(\\d+)(\\.\\d+)?"
            java.util.regex.Pattern r4 = java.util.regex.Pattern.compile(r4)     // Catch:{  }
            java.util.regex.Matcher r2 = r4.matcher(r2)     // Catch:{  }
            boolean r4 = r2.matches()     // Catch:{  }
            if (r4 == 0) goto L_0x0051
            java.lang.String r4 = r2.group(r3)     // Catch:{ Exception -> 0x0051 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0051 }
            r5 = 2
            java.lang.String r2 = r2.group(r5)     // Catch:{ Exception -> 0x0051 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0051 }
            if (r4 > r5) goto L_0x001d
            if (r4 != r5) goto L_0x0051
            if (r2 < r3) goto L_0x0051
            goto L_0x001d
        L_0x0051:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "VM with name "
            r2.append(r3)
            r2.append(r1)
            if (r0 == 0) goto L_0x0063
            java.lang.String r1 = " has multidex support"
            goto L_0x0065
        L_0x0063:
            java.lang.String r1 = " does not have multidex support"
        L_0x0065:
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "ARouter::"
            android.util.Log.i(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.arouter.utils.ClassUtils.d():boolean");
    }

    public static boolean e() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if ((property2 == null || !property2.toLowerCase().contains("lemur")) && (property == null || property.trim().length() <= 0)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> f(ApplicationInfo applicationInfo) {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT < 21 || (strArr = applicationInfo.splitSourceDirs) == null) {
            try {
                File file = new File((String) Class.forName("com.android.tools.fd.runtime.Paths").getMethod("getDexFileDirectory", new Class[]{String.class}).invoke((Object) null, new Object[]{applicationInfo.packageName}));
                if (file.exists() && file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2 != null && file2.exists() && file2.isFile() && file2.getName().endsWith(".dex")) {
                            arrayList.add(file2.getAbsolutePath());
                        }
                    }
                    Log.d(ILogger.defaultTag, "Found InstantRun support");
                }
            } catch (Exception e11) {
                Log.e(ILogger.defaultTag, "InstantRun support error, " + e11.getMessage());
            }
        } else {
            arrayList.addAll(Arrays.asList(strArr));
            Log.d(ILogger.defaultTag, "Found InstantRun support");
        }
        return arrayList;
    }
}
