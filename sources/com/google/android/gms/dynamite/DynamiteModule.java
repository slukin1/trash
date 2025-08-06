package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import com.huawei.hms.framework.common.ExceptionCode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@KeepForSdk
public final class DynamiteModule {
    @KeepForSdk
    public static final int LOCAL = -1;
    @KeepForSdk
    public static final int NONE = 0;
    @KeepForSdk
    public static final int NO_SELECTION = 0;
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    @KeepForSdk
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzb = null;
    @GuardedBy("DynamiteModule.class")
    private static String zzc = null;
    @GuardedBy("DynamiteModule.class")
    private static boolean zzd = false;
    @GuardedBy("DynamiteModule.class")
    private static int zze = -1;
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    @GuardedBy("DynamiteModule.class")
    private static zzq zzk;
    @GuardedBy("DynamiteModule.class")
    private static zzr zzl;
    private final Context zzj;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th2, zzp zzp) {
            super(str, th2);
        }
    }

    public interface VersionPolicy {

        @KeepForSdk
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z11) throws LoadingException;
        }

        @KeepForSdk
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion = 0;
            @KeepForSdk
            public int remoteVersion = 0;
            @KeepForSdk
            public int selection = 0;
        }

        @KeepForSdk
        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    @KeepForSdk
    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e11) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e11.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        DynamiteModule zzc2;
        Boolean bool;
        DynamiteModule dynamiteModule;
        IObjectWrapper iObjectWrapper;
        zzr zzr;
        Boolean valueOf;
        IObjectWrapper iObjectWrapper2;
        Context context2 = context;
        VersionPolicy versionPolicy2 = versionPolicy;
        String str2 = str;
        Class<DynamiteModule> cls = DynamiteModule.class;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            ThreadLocal threadLocal = zzg;
            zzn zzn = (zzn) threadLocal.get();
            zzn zzn2 = new zzn((zzm) null);
            threadLocal.set(zzn2);
            ThreadLocal threadLocal2 = zzh;
            long longValue = ((Long) threadLocal2.get()).longValue();
            try {
                threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
                VersionPolicy.SelectionResult selectModule = versionPolicy2.selectModule(context2, str2, zzi);
                Log.i("DynamiteModule", "Considering local module " + str2 + ":" + selectModule.localVersion + " and remote module " + str2 + ":" + selectModule.remoteVersion);
                int i11 = selectModule.selection;
                if (i11 != 0) {
                    if (i11 == -1) {
                        if (selectModule.localVersion != 0) {
                            i11 = -1;
                        }
                    }
                    if (!(i11 == 1 && selectModule.remoteVersion == 0)) {
                        if (i11 == -1) {
                            zzc2 = zzc(applicationContext, str2);
                        } else if (i11 == 1) {
                            try {
                                int i12 = selectModule.remoteVersion;
                                try {
                                    synchronized (cls) {
                                        if (zzf(context)) {
                                            bool = zzb;
                                        } else {
                                            throw new LoadingException("Remote loading disabled", (zzp) null);
                                        }
                                    }
                                    if (bool != null) {
                                        if (bool.booleanValue()) {
                                            Log.i("DynamiteModule", "Selected remote version of " + str2 + ", version >= " + i12);
                                            synchronized (cls) {
                                                zzr = zzl;
                                            }
                                            if (zzr != null) {
                                                zzn zzn3 = (zzn) threadLocal.get();
                                                if (zzn3 == null || zzn3.zza == null) {
                                                    throw new LoadingException("No result cursor", (zzp) null);
                                                }
                                                Context applicationContext2 = context.getApplicationContext();
                                                Cursor cursor = zzn3.zza;
                                                ObjectWrapper.wrap(null);
                                                synchronized (cls) {
                                                    valueOf = Boolean.valueOf(zze >= 2);
                                                }
                                                if (valueOf.booleanValue()) {
                                                    Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                    iObjectWrapper2 = zzr.zzf(ObjectWrapper.wrap(applicationContext2), str2, i12, ObjectWrapper.wrap(cursor));
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                    iObjectWrapper2 = zzr.zze(ObjectWrapper.wrap(applicationContext2), str2, i12, ObjectWrapper.wrap(cursor));
                                                }
                                                Context context3 = (Context) ObjectWrapper.unwrap(iObjectWrapper2);
                                                if (context3 != null) {
                                                    dynamiteModule = new DynamiteModule(context3);
                                                } else {
                                                    throw new LoadingException("Failed to get module context", (zzp) null);
                                                }
                                            } else {
                                                throw new LoadingException("DynamiteLoaderV2 was not cached.", (zzp) null);
                                            }
                                        } else {
                                            Log.i("DynamiteModule", "Selected remote version of " + str2 + ", version >= " + i12);
                                            zzq zzg2 = zzg(context);
                                            if (zzg2 != null) {
                                                int zze2 = zzg2.zze();
                                                if (zze2 >= 3) {
                                                    zzn zzn4 = (zzn) threadLocal.get();
                                                    if (zzn4 != null) {
                                                        iObjectWrapper = zzg2.zzi(ObjectWrapper.wrap(context), str2, i12, ObjectWrapper.wrap(zzn4.zza));
                                                    } else {
                                                        throw new LoadingException("No cached result cursor holder", (zzp) null);
                                                    }
                                                } else if (zze2 == 2) {
                                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                    iObjectWrapper = zzg2.zzj(ObjectWrapper.wrap(context), str2, i12);
                                                } else {
                                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                    iObjectWrapper = zzg2.zzh(ObjectWrapper.wrap(context), str2, i12);
                                                }
                                                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                                                if (unwrap != null) {
                                                    dynamiteModule = new DynamiteModule((Context) unwrap);
                                                } else {
                                                    throw new LoadingException("Failed to load remote module.", (zzp) null);
                                                }
                                            } else {
                                                throw new LoadingException("Failed to create IDynamiteLoader.", (zzp) null);
                                            }
                                        }
                                        zzc2 = dynamiteModule;
                                    } else {
                                        throw new LoadingException("Failed to determine which loading route to use.", (zzp) null);
                                    }
                                } catch (RemoteException e11) {
                                    throw new LoadingException("Failed to load remote module.", e11, (zzp) null);
                                } catch (LoadingException e12) {
                                    throw e12;
                                } catch (Throwable th2) {
                                    CrashUtils.addDynamiteErrorToDropBox(context2, th2);
                                    throw new LoadingException("Failed to load remote module.", th2, (zzp) null);
                                }
                            } catch (LoadingException e13) {
                                Log.w("DynamiteModule", "Failed to load remote module: " + e13.getMessage());
                                int i13 = selectModule.localVersion;
                                if (i13 == 0 || versionPolicy2.selectModule(context2, str2, new zzo(i13, 0)).selection != -1) {
                                    throw new LoadingException("Remote load failed. No local fallback found.", e13, (zzp) null);
                                }
                                zzc2 = zzc(applicationContext, str2);
                            }
                        } else {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i11, (zzp) null);
                        }
                        if (longValue == 0) {
                            zzh.remove();
                        } else {
                            zzh.set(Long.valueOf(longValue));
                        }
                        Cursor cursor2 = zzn2.zza;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        zzg.set(zzn);
                        return zzc2;
                    }
                }
                throw new LoadingException("No acceptable module " + str2 + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + InstructionFileId.DOT, (zzp) null);
            } catch (Throwable th3) {
                if (longValue == 0) {
                    zzh.remove();
                } else {
                    zzh.set(Long.valueOf(longValue));
                }
                Cursor cursor3 = zzn2.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzg.set(zzn);
                throw th3;
            }
        } else {
            throw new LoadingException("null application Context", (zzp) null);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:50:0x009a=Splitter:B:50:0x009a, B:17:0x003b=Splitter:B:17:0x003b} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c2 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01bf }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00d8
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x00a7
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            boolean r6 = r5.equals(r2)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x0055
            goto L_0x00a7
        L_0x0055:
            r6 = 1
            int r6 = zzb(r10, r11, r12, r6)     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x009a
            boolean r7 = r7.isEmpty()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x0065
            goto L_0x009a
        L_0x0065:
            java.lang.ClassLoader r7 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009d }
            r8 = 29
            if (r7 < r8) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r7 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r7 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
        L_0x008f:
            zzd(r7)     // Catch:{ LoadingException -> 0x009d }
            r1.set(r2, r7)     // Catch:{ LoadingException -> 0x009d }
            zzb = r5     // Catch:{ LoadingException -> 0x009d }
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return r6
        L_0x009a:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return r6
        L_0x009d:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x00a7:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            goto L_0x00d6
        L_0x00b2:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
        L_0x00b5:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b7:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b9:
            r1 = move-exception
        L_0x00ba:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01bf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bf }
            r5.<init>()     // Catch:{ all -> 0x01bf }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x01bf }
            r5.append(r1)     // Catch:{ all -> 0x01bf }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01bf }
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x01bf }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01bf }
        L_0x00d6:
            zzb = r1     // Catch:{ all -> 0x01bf }
        L_0x00d8:
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c2 }
            if (r0 == 0) goto L_0x0100
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00e4 }
            return r10
        L_0x00e4:
            r11 = move-exception
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c2 }
            r0.<init>()     // Catch:{ all -> 0x01c2 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01c2 }
            r0.append(r11)     // Catch:{ all -> 0x01c2 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x01c2 }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x01c2 }
            return r3
        L_0x0100:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01c2 }
            if (r4 != 0) goto L_0x0108
            goto L_0x01b6
        L_0x0108:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x0195 }
            r1 = 3
            if (r0 < r1) goto L_0x0170
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0195 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0195 }
            if (r0 == 0) goto L_0x0123
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0195 }
            if (r0 == 0) goto L_0x0123
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0195 }
            goto L_0x01b6
        L_0x0123:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0195 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0195 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0195 }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x0195 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0195 }
            if (r11 == 0) goto L_0x015d
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r12 != 0) goto L_0x0148
            goto L_0x015d
        L_0x0148:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r12 <= 0) goto L_0x0155
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r0 == 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r2 = r11
        L_0x0156:
            if (r2 == 0) goto L_0x015b
            r2.close()     // Catch:{ all -> 0x01c2 }
        L_0x015b:
            r3 = r12
            goto L_0x01b6
        L_0x015d:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r11 == 0) goto L_0x01b6
            r11.close()     // Catch:{ all -> 0x01c2 }
            goto L_0x01b6
        L_0x016a:
            r12 = move-exception
            r2 = r11
            goto L_0x01b9
        L_0x016d:
            r12 = move-exception
            r2 = r11
            goto L_0x0197
        L_0x0170:
            r1 = 2
            if (r0 != r1) goto L_0x0183
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0195 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0195 }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x0195 }
            goto L_0x01b6
        L_0x0183:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0195 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0195 }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x0195 }
            goto L_0x01b6
        L_0x0193:
            r12 = r11
            goto L_0x01b9
        L_0x0195:
            r11 = move-exception
            r12 = r11
        L_0x0197:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b7 }
            r0.<init>()     // Catch:{ all -> 0x01b7 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01b7 }
            r0.append(r12)     // Catch:{ all -> 0x01b7 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01b7 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x01b6
            r2.close()     // Catch:{ all -> 0x01c2 }
        L_0x01b6:
            return r3
        L_0x01b7:
            r11 = move-exception
            goto L_0x0193
        L_0x01b9:
            if (r2 == 0) goto L_0x01be
            r2.close()     // Catch:{ all -> 0x01c2 }
        L_0x01be:
            throw r12     // Catch:{ all -> 0x01c2 }
        L_0x01bf:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            throw r11     // Catch:{ all -> 0x01c2 }
        L_0x01c2:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r8, java.lang.String r9, boolean r10, boolean r11) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.ThreadLocal r8 = zzh     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Object r8 = r8.get()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            long r2 = r8.longValue()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r8 = "api_force_staging"
            java.lang.String r4 = "api"
            r7 = 1
            if (r7 == r10) goto L_0x0019
            r8 = r4
        L_0x0019:
            android.net.Uri$Builder r10 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r10.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r10 = r10.scheme(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r10 = r10.authority(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r8 = r10.path(r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r8 = r8.appendPath(r9)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r9 = "requestStartTime"
            java.lang.String r10 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r8 = r8.appendQueryParameter(r9, r10)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri r2 = r8.build()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            if (r8 == 0) goto L_0x00a3
            boolean r9 = r8.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r9 == 0) goto L_0x00a3
            r9 = 0
            int r10 = r8.getInt(r9)     // Catch:{ Exception -> 0x009b }
            if (r10 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r8.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r8.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r8.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r8.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r7 = r9
        L_0x007f:
            zzd = r7     // Catch:{ all -> 0x008b }
            r9 = r7
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r8)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r8 = r0
            goto L_0x008e
        L_0x008b:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r9     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r11 == 0) goto L_0x009d
            if (r9 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r10 = "forcing fallback to container DynamiteLoader impl"
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x009b }
            throw r9     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r9 = move-exception
            goto L_0x00b8
        L_0x009d:
            if (r8 == 0) goto L_0x00a2
            r8.close()
        L_0x00a2:
            return r10
        L_0x00a3:
            java.lang.String r9 = "DynamiteModule"
            java.lang.String r10 = "Failed to retrieve remote module version."
            android.util.Log.w(r9, r10)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r9 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r10 = "Failed to connect to dynamite module ContentResolver."
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x009b }
            throw r9     // Catch:{ Exception -> 0x009b }
        L_0x00b2:
            r8 = move-exception
            r9 = r8
            goto L_0x00da
        L_0x00b5:
            r8 = move-exception
            r9 = r8
            r8 = r0
        L_0x00b8:
            boolean r10 = r9 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00d8 }
            if (r10 == 0) goto L_0x00bd
            throw r9     // Catch:{ all -> 0x00d8 }
        L_0x00bd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r10 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00d8 }
            java.lang.String r11 = r9.getMessage()     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "V2 version check failed: "
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            r1.append(r11)     // Catch:{ all -> 0x00d8 }
            java.lang.String r11 = r1.toString()     // Catch:{ all -> 0x00d8 }
            r10.<init>(r11, r9, r0)     // Catch:{ all -> 0x00d8 }
            throw r10     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r9 = move-exception
            r0 = r8
        L_0x00da:
            if (r0 == 0) goto L_0x00df
            r0.close()
        L_0x00df:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    @GuardedBy("DynamiteModule.class")
    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
            throw new LoadingException("Failed to instantiate dynamite loader", e11, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    @GuardedBy("DynamiteModule.class")
    private static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(zzf)) {
            return true;
        }
        boolean z11 = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, ExceptionCode.CRASH_EXCEPTION) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z11 = true;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            zzf = valueOf;
            z11 = valueOf.booleanValue();
            if (z11 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z11) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z11;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e11) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e11.getMessage());
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @KeepForSdk
    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e11) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e11, (zzp) null);
        }
    }
}
