package com.google.android.gms.internal.auth;

import cn.sharesdk.framework.InnerShareParams;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class zzhi {
    public static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc = zzdr.zza();
    private static final boolean zzd;
    private static final zzhh zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x012f  */
    static {
        /*
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            java.lang.Class<double[]> r1 = double[].class
            java.lang.Class<float[]> r2 = float[].class
            java.lang.Class<long[]> r3 = long[].class
            java.lang.Class<int[]> r4 = int[].class
            java.lang.Class<boolean[]> r5 = boolean[].class
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            sun.misc.Unsafe r7 = zzg()
            zzb = r7
            java.lang.Class r8 = com.google.android.gms.internal.auth.zzdr.zza()
            zzc = r8
            java.lang.Class r8 = java.lang.Long.TYPE
            boolean r9 = zzs(r8)
            zzd = r9
            java.lang.Class r10 = java.lang.Integer.TYPE
            boolean r10 = zzs(r10)
            r11 = 0
            if (r7 != 0) goto L_0x002c
            goto L_0x003b
        L_0x002c:
            if (r9 == 0) goto L_0x0034
            com.google.android.gms.internal.auth.zzhg r11 = new com.google.android.gms.internal.auth.zzhg
            r11.<init>(r7)
            goto L_0x003b
        L_0x0034:
            if (r10 == 0) goto L_0x003b
            com.google.android.gms.internal.auth.zzhf r11 = new com.google.android.gms.internal.auth.zzhf
            r11.<init>(r7)
        L_0x003b:
            zze = r11
            java.lang.String r7 = "getLong"
            java.lang.String r9 = "objectFieldOffset"
            r10 = 2
            r12 = 1
            r13 = 0
            if (r11 != 0) goto L_0x0048
        L_0x0046:
            r8 = r13
            goto L_0x006e
        L_0x0048:
            sun.misc.Unsafe r11 = r11.zza
            java.lang.Class r11 = r11.getClass()     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r14 = new java.lang.Class[r12]     // Catch:{ all -> 0x0069 }
            java.lang.Class<java.lang.reflect.Field> r15 = java.lang.reflect.Field.class
            r14[r13] = r15     // Catch:{ all -> 0x0069 }
            r11.getMethod(r9, r14)     // Catch:{ all -> 0x0069 }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x0069 }
            r14[r13] = r6     // Catch:{ all -> 0x0069 }
            r14[r12] = r8     // Catch:{ all -> 0x0069 }
            r11.getMethod(r7, r14)     // Catch:{ all -> 0x0069 }
            java.lang.reflect.Field r8 = zzy()     // Catch:{ all -> 0x0069 }
            if (r8 != 0) goto L_0x0067
            goto L_0x0046
        L_0x0067:
            r8 = r12
            goto L_0x006e
        L_0x0069:
            r8 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhi.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r8.toString()))
            goto L_0x0046
        L_0x006e:
            zzf = r8
            com.google.android.gms.internal.auth.zzhh r8 = zze
            if (r8 != 0) goto L_0x0077
        L_0x0074:
            r6 = r13
            goto L_0x00ee
        L_0x0077:
            sun.misc.Unsafe r8 = r8.zza
            java.lang.Class r8 = r8.getClass()     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r11 = new java.lang.Class[r12]     // Catch:{ all -> 0x00e9 }
            java.lang.Class<java.lang.reflect.Field> r14 = java.lang.reflect.Field.class
            r11[r13] = r14     // Catch:{ all -> 0x00e9 }
            r8.getMethod(r9, r11)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x00e9 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r9[r13] = r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = "arrayBaseOffset"
            r8.getMethod(r11, r9)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r9 = new java.lang.Class[r12]     // Catch:{ all -> 0x00e9 }
            java.lang.Class<java.lang.Class> r11 = java.lang.Class.class
            r9[r13] = r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r11 = "arrayIndexScale"
            r8.getMethod(r11, r9)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r9 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e9 }
            r9[r13] = r6     // Catch:{ all -> 0x00e9 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x00e9 }
            r9[r12] = r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r14 = "getInt"
            r8.getMethod(r14, r9)     // Catch:{ all -> 0x00e9 }
            r9 = 3
            java.lang.Class[] r14 = new java.lang.Class[r9]     // Catch:{ all -> 0x00e9 }
            r14[r13] = r6     // Catch:{ all -> 0x00e9 }
            r14[r12] = r11     // Catch:{ all -> 0x00e9 }
            java.lang.Class r15 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e9 }
            r14[r10] = r15     // Catch:{ all -> 0x00e9 }
            java.lang.String r15 = "putInt"
            r8.getMethod(r15, r14)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r14 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e9 }
            r14[r13] = r6     // Catch:{ all -> 0x00e9 }
            r14[r12] = r11     // Catch:{ all -> 0x00e9 }
            r8.getMethod(r7, r14)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00e9 }
            r7[r13] = r6     // Catch:{ all -> 0x00e9 }
            r7[r12] = r11     // Catch:{ all -> 0x00e9 }
            r7[r10] = r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r14 = "putLong"
            r8.getMethod(r14, r7)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r7 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e9 }
            r7[r13] = r6     // Catch:{ all -> 0x00e9 }
            r7[r12] = r11     // Catch:{ all -> 0x00e9 }
            java.lang.String r14 = "getObject"
            r8.getMethod(r14, r7)     // Catch:{ all -> 0x00e9 }
            java.lang.Class[] r7 = new java.lang.Class[r9]     // Catch:{ all -> 0x00e9 }
            r7[r13] = r6     // Catch:{ all -> 0x00e9 }
            r7[r12] = r11     // Catch:{ all -> 0x00e9 }
            r7[r10] = r6     // Catch:{ all -> 0x00e9 }
            java.lang.String r6 = "putObject"
            r8.getMethod(r6, r7)     // Catch:{ all -> 0x00e9 }
            r6 = r12
            goto L_0x00ee
        L_0x00e9:
            r6 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.auth.zzhi.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r6.toString()))
            goto L_0x0074
        L_0x00ee:
            zzg = r6
            java.lang.Class<byte[]> r6 = byte[].class
            zzw(r6)
            zzw(r5)
            zzx(r5)
            zzw(r4)
            zzx(r4)
            zzw(r3)
            zzx(r3)
            zzw(r2)
            zzx(r2)
            zzw(r1)
            zzx(r1)
            zzw(r0)
            zzx(r0)
            java.lang.reflect.Field r0 = zzy()
            if (r0 == 0) goto L_0x0126
            com.google.android.gms.internal.auth.zzhh r1 = zze
            if (r1 == 0) goto L_0x0126
            r1.zzk(r0)
        L_0x0126:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x012f
            goto L_0x0130
        L_0x012f:
            r12 = r13
        L_0x0130:
            zza = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhi.<clinit>():void");
    }

    private zzhi() {
    }

    public static double zza(Object obj, long j11) {
        return zze.zza(obj, j11);
    }

    public static float zzb(Object obj, long j11) {
        return zze.zzb(obj, j11);
    }

    public static int zzc(Object obj, long j11) {
        return zze.zzi(obj, j11);
    }

    public static long zzd(Object obj, long j11) {
        return zze.zzj(obj, j11);
    }

    public static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static Object zzf(Object obj, long j11) {
        return zze.zzl(obj, j11);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhe());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void zzi(Object obj, long j11, boolean z11) {
        long j12 = -4 & j11;
        zzhh zzhh = zze;
        int zzi = zzhh.zzi(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zzhh.zzm(obj, j12, ((z11 ? 1 : 0) << i11) | ((~(255 << i11)) & zzi));
    }

    public static /* synthetic */ void zzj(Object obj, long j11, boolean z11) {
        long j12 = -4 & j11;
        zzhh zzhh = zze;
        int zzi = zzhh.zzi(obj, j12);
        int i11 = (((int) j11) & 3) << 3;
        zzhh.zzm(obj, j12, ((z11 ? 1 : 0) << i11) | ((~(255 << i11)) & zzi));
    }

    public static void zzk(Object obj, long j11, boolean z11) {
        zze.zzc(obj, j11, z11);
    }

    public static void zzl(Object obj, long j11, double d11) {
        zze.zzd(obj, j11, d11);
    }

    public static void zzm(Object obj, long j11, float f11) {
        zze.zze(obj, j11, f11);
    }

    public static void zzn(Object obj, long j11, int i11) {
        zze.zzm(obj, j11, i11);
    }

    public static void zzo(Object obj, long j11, long j12) {
        zze.zzn(obj, j11, j12);
    }

    public static void zzp(Object obj, long j11, Object obj2) {
        zze.zzo(obj, j11, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j11) {
        return ((byte) ((zze.zzi(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j11) {
        return ((byte) ((zze.zzi(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzs(Class cls) {
        Class<byte[]> cls2 = byte[].class;
        int i11 = zzdr.zza;
        try {
            Class cls3 = zzc;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzt(Object obj, long j11) {
        return zze.zzf(obj, j11);
    }

    public static boolean zzu() {
        return zzg;
    }

    public static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i11 = zzdr.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz != null) {
            return zzz;
        }
        Field zzz2 = zzz(Buffer.class, InnerShareParams.ADDRESS);
        if (zzz2 == null || zzz2.getType() != Long.TYPE) {
            return null;
        }
        return zzz2;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
