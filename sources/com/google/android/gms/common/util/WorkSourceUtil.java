package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    private static Boolean zzj = null;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "add"
            int r2 = android.os.Process.myUid()
            zza = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x001a }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x001a }
            r6[r3] = r7     // Catch:{ Exception -> 0x001a }
            java.lang.reflect.Method r5 = r5.getMethod(r1, r6)     // Catch:{ Exception -> 0x001a }
            goto L_0x001b
        L_0x001a:
            r5 = r4
        L_0x001b:
            zzb = r5
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            r6 = 2
            if (r5 == 0) goto L_0x0033
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r7[r3] = r8     // Catch:{ Exception -> 0x0033 }
            r7[r2] = r0     // Catch:{ Exception -> 0x0033 }
            java.lang.reflect.Method r1 = r5.getMethod(r1, r7)     // Catch:{ Exception -> 0x0033 }
            goto L_0x0034
        L_0x0033:
            r1 = r4
        L_0x0034:
            zzc = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "size"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0042 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0043
        L_0x0042:
            r1 = r4
        L_0x0043:
            zzd = r1
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "get"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0054 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0054 }
            r7[r3] = r8     // Catch:{ Exception -> 0x0054 }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x0054 }
            goto L_0x0055
        L_0x0054:
            r1 = r4
        L_0x0055:
            zze = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r1 == 0) goto L_0x006c
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r5 = "getName"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x006c }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x006c }
            r7[r3] = r8     // Catch:{ Exception -> 0x006c }
            java.lang.reflect.Method r1 = r1.getMethod(r5, r7)     // Catch:{ Exception -> 0x006c }
            goto L_0x006d
        L_0x006c:
            r1 = r4
        L_0x006d:
            zzf = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r5 = "WorkSourceUtil"
            if (r1 == 0) goto L_0x0088
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            java.lang.String r7 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0082 }
            java.lang.reflect.Method r1 = r1.getMethod(r7, r8)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0089
        L_0x0082:
            r1 = move-exception
            java.lang.String r7 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r7, r1)
        L_0x0088:
            r1 = r4
        L_0x0089:
            zzg = r1
            boolean r1 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r1 == 0) goto L_0x00ac
            java.lang.String r1 = "android.os.WorkSource$WorkChain"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r7 = "addNode"
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ Exception -> 0x00a6 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x00a6 }
            r6[r3] = r8     // Catch:{ Exception -> 0x00a6 }
            r6[r2] = r0     // Catch:{ Exception -> 0x00a6 }
            java.lang.reflect.Method r0 = r1.getMethod(r7, r6)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x00ad
        L_0x00a6:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r5, r1, r0)
        L_0x00ac:
            r0 = r4
        L_0x00ad:
            zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00c3
            java.lang.Class<android.os.WorkSource> r0 = android.os.WorkSource.class
            java.lang.String r1 = "isEmpty"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00c3 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x00c3 }
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00c4
        L_0x00c3:
            r0 = r4
        L_0x00c4:
            zzi = r0
            zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void add(WorkSource workSource, int i11, String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i11), str});
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i11)});
                } catch (Exception e12) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e12);
                }
            }
        }
    }

    @KeepForSdk
    public static WorkSource fromPackage(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i11 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i11, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i11 = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i11 = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i11 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i11, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i12 = zza;
                if (i11 != i12) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i11), str});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i12), str2});
            } catch (Exception e11) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e11);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static int get(WorkSource workSource, int i11) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i11)});
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
        return 0;
    }

    @KeepForSdk
    public static String getName(WorkSource workSource, int i11) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i11)});
        } catch (Exception e11) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            return null;
        }
    }

    @KeepForSdk
    public static List<String> getNames(WorkSource workSource) {
        int i11;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i11 = 0;
        } else {
            i11 = size(workSource);
        }
        if (i11 != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                String name = getName(workSource, i12);
                if (!Strings.isEmptyOrWhitespace(name)) {
                    Preconditions.checkNotNull(name);
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean hasWorkSourcePermission(Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z11 = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z11 = true;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            zzj = valueOf;
            boolean booleanValue2 = valueOf.booleanValue();
            return booleanValue2;
        }
    }

    @KeepForSdk
    public static boolean isEmpty(WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e11) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e11);
            }
        }
        if (size(workSource) == 0) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static int size(WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
        return 0;
    }
}
