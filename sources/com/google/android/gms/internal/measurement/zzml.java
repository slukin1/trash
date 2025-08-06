package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import sun.misc.Unsafe;

final class zzml<T> implements zzmt<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zznu.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzmi zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzlw zzm;
    private final zznk zzn;
    private final zzko zzo;
    private final zzmn zzp;
    private final zzmd zzq;

    private zzml(int[] iArr, Object[] objArr, int i11, int i12, zzmi zzmi, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzmn zzmn, zzlw zzlw, zznk zznk, zzko zzko, zzmd zzmd) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = z11;
        boolean z13 = false;
        if (zzko != null && zzko.zzc(zzmi)) {
            z13 = true;
        }
        this.zzh = z13;
        this.zzj = iArr2;
        this.zzk = i13;
        this.zzl = i14;
        this.zzp = zzmn;
        this.zzm = zzlw;
        this.zzn = zznk;
        this.zzo = zzko;
        this.zzg = zzmi;
        this.zzq = zzmd;
    }

    private final zzlf zzA(int i11) {
        int i12 = i11 / 3;
        return (zzlf) this.zzd[i12 + i12 + 1];
    }

    private final zzmt zzB(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzmt zzmt = (zzmt) this.zzd[i13];
        if (zzmt != null) {
            return zzmt;
        }
        zzmt zzb2 = zzmq.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzC(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzD(Object obj, int i11) {
        zzmt zzB = zzB(i11);
        int zzy = zzy(i11) & 1048575;
        if (!zzP(obj, i11)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, (long) zzy);
        if (zzS(object)) {
            return object;
        }
        Object zze2 = zzB.zze();
        if (object != null) {
            zzB.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzE(Object obj, int i11, int i12) {
        zzmt zzB = zzB(i12);
        if (!zzT(obj, i11, i12)) {
            return zzB.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzy(i12) & 1048575));
        if (zzS(object)) {
            return object;
        }
        Object zze2 = zzB.zze();
        if (object != null) {
            zzB.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzF(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzG(Object obj) {
        if (!zzS(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzH(Object obj, Object obj2, int i11) {
        if (zzP(obj2, i11)) {
            Unsafe unsafe = zzb;
            long zzy = (long) (zzy(i11) & 1048575);
            Object object = unsafe.getObject(obj2, zzy);
            if (object != null) {
                zzmt zzB = zzB(i11);
                if (!zzP(obj, i11)) {
                    if (!zzS(object)) {
                        unsafe.putObject(obj, zzy, object);
                    } else {
                        Object zze2 = zzB.zze();
                        zzB.zzg(zze2, object);
                        unsafe.putObject(obj, zzy, zze2);
                    }
                    zzJ(obj, i11);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzy);
                if (!zzS(object2)) {
                    Object zze3 = zzB.zze();
                    zzB.zzg(zze3, object2);
                    unsafe.putObject(obj, zzy, zze3);
                    object2 = zze3;
                }
                zzB.zzg(object2, object);
                return;
            }
            int i12 = this.zzc[i11];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i12 + " is present but null: " + obj3);
        }
    }

    private final void zzI(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzT(obj2, i12, i11)) {
            Unsafe unsafe = zzb;
            long zzy = (long) (zzy(i11) & 1048575);
            Object object = unsafe.getObject(obj2, zzy);
            if (object != null) {
                zzmt zzB = zzB(i11);
                if (!zzT(obj, i12, i11)) {
                    if (!zzS(object)) {
                        unsafe.putObject(obj, zzy, object);
                    } else {
                        Object zze2 = zzB.zze();
                        zzB.zzg(zze2, object);
                        unsafe.putObject(obj, zzy, zze2);
                    }
                    zzK(obj, i12, i11);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzy);
                if (!zzS(object2)) {
                    Object zze3 = zzB.zze();
                    zzB.zzg(zze3, object2);
                    unsafe.putObject(obj, zzy, zze3);
                    object2 = zze3;
                }
                zzB.zzg(object2, object);
                return;
            }
            int i13 = this.zzc[i11];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i13 + " is present but null: " + obj3);
        }
    }

    private final void zzJ(Object obj, int i11) {
        int zzv = zzv(i11);
        long j11 = (long) (1048575 & zzv);
        if (j11 != 1048575) {
            zznu.zzq(obj, j11, (1 << (zzv >>> 20)) | zznu.zzc(obj, j11));
        }
    }

    private final void zzK(Object obj, int i11, int i12) {
        zznu.zzq(obj, (long) (zzv(i12) & 1048575), i11);
    }

    private final void zzL(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, (long) (zzy(i11) & 1048575), obj2);
        zzJ(obj, i11);
    }

    private final void zzM(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, (long) (zzy(i12) & 1048575), obj2);
        zzK(obj, i11, i12);
    }

    private final void zzN(zzoc zzoc, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzmb zzmb = (zzmb) zzC(i12);
            throw null;
        }
    }

    private final boolean zzO(Object obj, Object obj2, int i11) {
        return zzP(obj, i11) == zzP(obj2, i11);
    }

    private final boolean zzP(Object obj, int i11) {
        int zzv = zzv(i11);
        long j11 = (long) (zzv & 1048575);
        if (j11 == 1048575) {
            int zzy = zzy(i11);
            long j12 = (long) (zzy & 1048575);
            switch (zzx(zzy)) {
                case 0:
                    return Double.doubleToRawLongBits(zznu.zza(obj, j12)) != 0;
                case 1:
                    return Float.floatToRawIntBits(zznu.zzb(obj, j12)) != 0;
                case 2:
                    return zznu.zzd(obj, j12) != 0;
                case 3:
                    return zznu.zzd(obj, j12) != 0;
                case 4:
                    return zznu.zzc(obj, j12) != 0;
                case 5:
                    return zznu.zzd(obj, j12) != 0;
                case 6:
                    return zznu.zzc(obj, j12) != 0;
                case 7:
                    return zznu.zzw(obj, j12);
                case 8:
                    Object zzf2 = zznu.zzf(obj, j12);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzka) {
                        return !zzka.zzb.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zznu.zzf(obj, j12) != null;
                case 10:
                    return !zzka.zzb.equals(zznu.zzf(obj, j12));
                case 11:
                    return zznu.zzc(obj, j12) != 0;
                case 12:
                    return zznu.zzc(obj, j12) != 0;
                case 13:
                    return zznu.zzc(obj, j12) != 0;
                case 14:
                    return zznu.zzd(obj, j12) != 0;
                case 15:
                    return zznu.zzc(obj, j12) != 0;
                case 16:
                    return zznu.zzd(obj, j12) != 0;
                case 17:
                    return zznu.zzf(obj, j12) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zznu.zzc(obj, j11) & (1 << (zzv >>> 20))) != 0;
        }
    }

    private final boolean zzQ(Object obj, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return zzP(obj, i11);
        }
        return (i13 & i14) != 0;
    }

    private static boolean zzR(Object obj, int i11, zzmt zzmt) {
        return zzmt.zzk(zznu.zzf(obj, (long) (i11 & 1048575)));
    }

    private static boolean zzS(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzlb) {
            return ((zzlb) obj).zzbR();
        }
        return true;
    }

    private final boolean zzT(Object obj, int i11, int i12) {
        return zznu.zzc(obj, (long) (zzv(i12) & 1048575)) == i11;
    }

    private static boolean zzU(Object obj, long j11) {
        return ((Boolean) zznu.zzf(obj, j11)).booleanValue();
    }

    private static final void zzV(int i11, Object obj, zzoc zzoc) throws IOException {
        if (obj instanceof String) {
            zzoc.zzF(i11, (String) obj);
        } else {
            zzoc.zzd(i11, (zzka) obj);
        }
    }

    public static zznl zzd(Object obj) {
        zzlb zzlb = (zzlb) obj;
        zznl zznl = zzlb.zzc;
        if (zznl != zznl.zzc()) {
            return zznl;
        }
        zznl zzf2 = zznl.zzf();
        zzlb.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0288  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0372  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzml zzl(java.lang.Class r31, com.google.android.gms.internal.measurement.zzmf r32, com.google.android.gms.internal.measurement.zzmn r33, com.google.android.gms.internal.measurement.zzlw r34, com.google.android.gms.internal.measurement.zznk r35, com.google.android.gms.internal.measurement.zzko r36, com.google.android.gms.internal.measurement.zzmd r37) {
        /*
            r0 = r32
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzms
            if (r1 == 0) goto L_0x03da
            com.google.android.gms.internal.measurement.zzms r0 = (com.google.android.gms.internal.measurement.zzms) r0
            int r1 = r0.zzc()
            java.lang.String r2 = r0.zzd()
            int r3 = r2.length()
            r4 = 0
            char r5 = r2.charAt(r4)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0029
            r5 = 1
        L_0x001f:
            int r8 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x002a
            r5 = r8
            goto L_0x001f
        L_0x0029:
            r8 = 1
        L_0x002a:
            int r5 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0049
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0036:
            int r11 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x0046
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r10
            r8 = r8 | r5
            int r10 = r10 + 13
            r5 = r11
            goto L_0x0036
        L_0x0046:
            int r5 = r5 << r10
            r8 = r8 | r5
            r5 = r11
        L_0x0049:
            if (r8 != 0) goto L_0x0059
            int[] r8 = zza
            r10 = r4
            r12 = r10
            r13 = r12
            r14 = r13
            r19 = r14
            r18 = r8
            r8 = r19
            goto L_0x016f
        L_0x0059:
            int r8 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x0078
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0065:
            int r11 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0075
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r5 = r5 | r8
            int r10 = r10 + 13
            r8 = r11
            goto L_0x0065
        L_0x0075:
            int r8 = r8 << r10
            r5 = r5 | r8
            r8 = r11
        L_0x0078:
            int r10 = r8 + 1
            char r8 = r2.charAt(r8)
            if (r8 < r6) goto L_0x0097
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x0084:
            int r12 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r6) goto L_0x0094
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r8 = r8 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x0084
        L_0x0094:
            int r10 = r10 << r11
            r8 = r8 | r10
            r10 = r12
        L_0x0097:
            int r11 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r6) goto L_0x00b6
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00a3:
            int r13 = r11 + 1
            char r11 = r2.charAt(r11)
            if (r11 < r6) goto L_0x00b3
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00a3
        L_0x00b3:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00b6:
            int r12 = r11 + 1
            char r11 = r2.charAt(r11)
            if (r11 < r6) goto L_0x00d5
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00c2:
            int r14 = r12 + 1
            char r12 = r2.charAt(r12)
            if (r12 < r6) goto L_0x00d2
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00c2
        L_0x00d2:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00d5:
            int r13 = r12 + 1
            char r12 = r2.charAt(r12)
            if (r12 < r6) goto L_0x00f4
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00e1:
            int r15 = r13 + 1
            char r13 = r2.charAt(r13)
            if (r13 < r6) goto L_0x00f1
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00e1
        L_0x00f1:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00f4:
            int r14 = r13 + 1
            char r13 = r2.charAt(r13)
            if (r13 < r6) goto L_0x0115
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0100:
            int r16 = r14 + 1
            char r14 = r2.charAt(r14)
            if (r14 < r6) goto L_0x0111
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x0100
        L_0x0111:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0115:
            int r15 = r14 + 1
            char r14 = r2.charAt(r14)
            if (r14 < r6) goto L_0x0138
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0121:
            int r17 = r15 + 1
            char r15 = r2.charAt(r15)
            if (r15 < r6) goto L_0x0133
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0121
        L_0x0133:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0138:
            int r16 = r15 + 1
            char r15 = r2.charAt(r15)
            if (r15 < r6) goto L_0x015d
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r4 = r16
            r16 = 13
        L_0x0146:
            int r17 = r4 + 1
            char r4 = r2.charAt(r4)
            if (r4 < r6) goto L_0x0158
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r16
            r15 = r15 | r4
            int r16 = r16 + 13
            r4 = r17
            goto L_0x0146
        L_0x0158:
            int r4 = r4 << r16
            r15 = r15 | r4
            r16 = r17
        L_0x015d:
            int r4 = r15 + r13
            int r4 = r4 + r14
            int r14 = r5 + r5
            int r14 = r14 + r8
            int[] r8 = new int[r4]
            r4 = r5
            r18 = r8
            r8 = r10
            r10 = r14
            r19 = r15
            r5 = r16
            r14 = r11
        L_0x016f:
            sun.misc.Unsafe r11 = zzb
            java.lang.Object[] r15 = r0.zze()
            com.google.android.gms.internal.measurement.zzmi r16 = r0.zza()
            java.lang.Class r9 = r16.getClass()
            int r20 = r19 + r13
            int r13 = r12 + r12
            int r12 = r12 * 3
            int[] r12 = new int[r12]
            java.lang.Object[] r13 = new java.lang.Object[r13]
            r21 = r19
            r22 = r20
            r16 = 0
            r17 = 0
        L_0x018f:
            r7 = 2
            if (r1 != r7) goto L_0x0194
            r7 = 1
            goto L_0x0195
        L_0x0194:
            r7 = 0
        L_0x0195:
            if (r5 >= r3) goto L_0x03b9
            int r24 = r5 + 1
            char r5 = r2.charAt(r5)
            if (r5 < r6) goto L_0x01c4
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r6 = r24
            r24 = 13
        L_0x01a5:
            int r26 = r6 + 1
            char r6 = r2.charAt(r6)
            r27 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r1) goto L_0x01be
            r1 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r5 = r5 | r1
            int r24 = r24 + 13
            r6 = r26
            r1 = r27
            goto L_0x01a5
        L_0x01be:
            int r1 = r6 << r24
            r5 = r5 | r1
            r1 = r26
            goto L_0x01c8
        L_0x01c4:
            r27 = r1
            r1 = r24
        L_0x01c8:
            int r6 = r1 + 1
            char r1 = r2.charAt(r1)
            r24 = r3
            r3 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r3) goto L_0x01f3
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x01d9:
            int r28 = r6 + 1
            char r6 = r2.charAt(r6)
            if (r6 < r3) goto L_0x01ee
            r3 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r26
            r1 = r1 | r3
            int r26 = r26 + 13
            r6 = r28
            r3 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01d9
        L_0x01ee:
            int r3 = r6 << r26
            r1 = r1 | r3
            r6 = r28
        L_0x01f3:
            r3 = r1 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x01fd
            int r3 = r16 + 1
            r18[r16] = r17
            r16 = r3
        L_0x01fd:
            r3 = r1 & 255(0xff, float:3.57E-43)
            r26 = r14
            r14 = 51
            if (r3 < r14) goto L_0x029f
            int r14 = r6 + 1
            char r6 = r2.charAt(r6)
            r28 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r14) goto L_0x0237
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r14 = r28
            r28 = 13
        L_0x0218:
            int r29 = r14 + 1
            char r14 = r2.charAt(r14)
            r30 = r8
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r8) goto L_0x0231
            r8 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r28
            r6 = r6 | r8
            int r28 = r28 + 13
            r14 = r29
            r8 = r30
            goto L_0x0218
        L_0x0231:
            int r8 = r14 << r28
            r6 = r6 | r8
            r14 = r29
            goto L_0x023b
        L_0x0237:
            r30 = r8
            r14 = r28
        L_0x023b:
            int r8 = r3 + -51
            r28 = r14
            r14 = 9
            if (r8 == r14) goto L_0x025a
            r14 = 17
            if (r8 != r14) goto L_0x0248
            goto L_0x025a
        L_0x0248:
            r14 = 12
            if (r8 != r14) goto L_0x0266
            if (r7 != 0) goto L_0x0266
            int r7 = r17 / 3
            int r7 = r7 + r7
            r8 = 1
            int r7 = r7 + r8
            int r8 = r10 + 1
            r10 = r15[r10]
            r13[r7] = r10
            goto L_0x0265
        L_0x025a:
            int r7 = r17 / 3
            int r7 = r7 + r7
            r8 = 1
            int r7 = r7 + r8
            int r8 = r10 + 1
            r10 = r15[r10]
            r13[r7] = r10
        L_0x0265:
            r10 = r8
        L_0x0266:
            int r6 = r6 + r6
            r7 = r15[r6]
            boolean r8 = r7 instanceof java.lang.reflect.Field
            if (r8 == 0) goto L_0x0270
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0278
        L_0x0270:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzF(r9, r7)
            r15[r6] = r7
        L_0x0278:
            long r7 = r11.objectFieldOffset(r7)
            int r7 = (int) r7
            int r6 = r6 + 1
            r8 = r15[r6]
            boolean r14 = r8 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0288
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0290
        L_0x0288:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzF(r9, r8)
            r15[r6] = r8
        L_0x0290:
            r14 = r7
            long r6 = r11.objectFieldOffset(r8)
            int r6 = (int) r6
            r7 = r14
            r23 = r15
            r25 = r28
            r14 = r6
            r6 = 0
            goto L_0x0384
        L_0x029f:
            r30 = r8
            int r8 = r10 + 1
            r10 = r15[r10]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = zzF(r9, r10)
            r14 = 9
            if (r3 == r14) goto L_0x030f
            r14 = 17
            if (r3 != r14) goto L_0x02b4
            goto L_0x030f
        L_0x02b4:
            r14 = 27
            if (r3 == r14) goto L_0x0301
            r14 = 49
            if (r3 != r14) goto L_0x02bd
            goto L_0x0301
        L_0x02bd:
            r14 = 12
            if (r3 == r14) goto L_0x02f1
            r14 = 30
            if (r3 == r14) goto L_0x02f1
            r14 = 44
            if (r3 != r14) goto L_0x02ca
            goto L_0x02f1
        L_0x02ca:
            r7 = 50
            if (r3 != r7) goto L_0x02ff
            int r7 = r21 + 1
            r18[r21] = r17
            int r14 = r17 / 3
            int r21 = r8 + 1
            r8 = r15[r8]
            int r14 = r14 + r14
            r13[r14] = r8
            r8 = r1 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x02ea
            int r14 = r14 + 1
            int r8 = r21 + 1
            r21 = r15[r21]
            r13[r14] = r21
            r21 = r7
            goto L_0x031a
        L_0x02ea:
            r23 = r15
            r8 = r21
            r21 = r7
            goto L_0x031c
        L_0x02f1:
            if (r7 != 0) goto L_0x02ff
            int r7 = r17 / 3
            int r7 = r7 + r7
            r14 = 1
            int r7 = r7 + r14
            int r23 = r8 + 1
            r8 = r15[r8]
            r13[r7] = r8
            goto L_0x030c
        L_0x02ff:
            r14 = 1
            goto L_0x031a
        L_0x0301:
            r14 = 1
            int r7 = r17 / 3
            int r7 = r7 + r7
            int r7 = r7 + r14
            int r23 = r8 + 1
            r8 = r15[r8]
            r13[r7] = r8
        L_0x030c:
            r8 = r23
            goto L_0x031a
        L_0x030f:
            r14 = 1
            int r7 = r17 / 3
            int r7 = r7 + r7
            int r7 = r7 + r14
            java.lang.Class r23 = r10.getType()
            r13[r7] = r23
        L_0x031a:
            r23 = r15
        L_0x031c:
            long r14 = r11.objectFieldOffset(r10)
            int r7 = (int) r14
            r10 = r1 & 4096(0x1000, float:5.74E-42)
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r15 = 4096(0x1000, float:5.74E-42)
            if (r10 != r15) goto L_0x0372
            r10 = 17
            if (r3 > r10) goto L_0x0372
            int r10 = r6 + 1
            char r6 = r2.charAt(r6)
            r15 = 55296(0xd800, float:7.7486E-41)
            if (r6 < r15) goto L_0x0351
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x033d:
            int r25 = r10 + 1
            char r10 = r2.charAt(r10)
            if (r10 < r15) goto L_0x034e
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r14
            r6 = r6 | r10
            int r14 = r14 + 13
            r10 = r25
            goto L_0x033d
        L_0x034e:
            int r10 = r10 << r14
            r6 = r6 | r10
            goto L_0x0353
        L_0x0351:
            r25 = r10
        L_0x0353:
            int r10 = r4 + r4
            int r14 = r6 / 32
            int r10 = r10 + r14
            r14 = r23[r10]
            boolean r15 = r14 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x0361
            java.lang.reflect.Field r14 = (java.lang.reflect.Field) r14
            goto L_0x0369
        L_0x0361:
            java.lang.String r14 = (java.lang.String) r14
            java.lang.reflect.Field r14 = zzF(r9, r14)
            r23[r10] = r14
        L_0x0369:
            long r14 = r11.objectFieldOffset(r14)
            int r10 = (int) r14
            int r6 = r6 % 32
            r14 = r10
            goto L_0x0375
        L_0x0372:
            r25 = r6
            r6 = 0
        L_0x0375:
            r10 = 18
            if (r3 < r10) goto L_0x0383
            r10 = 49
            if (r3 > r10) goto L_0x0383
            int r10 = r22 + 1
            r18[r22] = r7
            r22 = r10
        L_0x0383:
            r10 = r8
        L_0x0384:
            int r8 = r17 + 1
            r12[r17] = r5
            int r5 = r8 + 1
            r15 = r1 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x0391
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0392
        L_0x0391:
            r15 = 0
        L_0x0392:
            r1 = r1 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0399
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039a
        L_0x0399:
            r1 = 0
        L_0x039a:
            int r3 = r3 << 20
            r1 = r1 | r15
            r1 = r1 | r3
            r1 = r1 | r7
            r12[r8] = r1
            int r17 = r5 + 1
            int r1 = r6 << 20
            r1 = r1 | r14
            r12[r5] = r1
            r15 = r23
            r3 = r24
            r5 = r25
            r14 = r26
            r1 = r27
            r8 = r30
            r6 = 55296(0xd800, float:7.7486E-41)
            goto L_0x018f
        L_0x03b9:
            r30 = r8
            r26 = r14
            com.google.android.gms.internal.measurement.zzml r1 = new com.google.android.gms.internal.measurement.zzml
            com.google.android.gms.internal.measurement.zzmi r15 = r0.zza()
            r17 = 0
            r10 = r1
            r11 = r12
            r12 = r13
            r13 = r30
            r16 = r7
            r21 = r33
            r22 = r34
            r23 = r35
            r24 = r36
            r25 = r37
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        L_0x03da:
            com.google.android.gms.internal.measurement.zznh r0 = (com.google.android.gms.internal.measurement.zznh) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzl(java.lang.Class, com.google.android.gms.internal.measurement.zzmf, com.google.android.gms.internal.measurement.zzmn, com.google.android.gms.internal.measurement.zzlw, com.google.android.gms.internal.measurement.zznk, com.google.android.gms.internal.measurement.zzko, com.google.android.gms.internal.measurement.zzmd):com.google.android.gms.internal.measurement.zzml");
    }

    private static double zzm(Object obj, long j11) {
        return ((Double) zznu.zzf(obj, j11)).doubleValue();
    }

    private static float zzn(Object obj, long j11) {
        return ((Float) zznu.zzf(obj, j11)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x032d, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x036d, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03a1, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x04af, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0562, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0571, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0575, code lost:
        r5 = r5 + 3;
        r3 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f2, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b0, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01c0, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzo(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = zzb
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r3
            r5 = 0
            r6 = 0
            r8 = 0
        L_0x000d:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x057c
            int r9 = r0.zzy(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzx(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0036
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r3
            int r10 = r10 >>> 20
            if (r13 == r7) goto L_0x0033
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
        L_0x0033:
            int r10 = r14 << r10
            goto L_0x0037
        L_0x0036:
            r10 = 0
        L_0x0037:
            r9 = r9 & r3
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0566;
                case 1: goto L_0x0557;
                case 2: goto L_0x0541;
                case 3: goto L_0x052d;
                case 4: goto L_0x0519;
                case 5: goto L_0x050d;
                case 6: goto L_0x0501;
                case 7: goto L_0x04f3;
                case 8: goto L_0x04c5;
                case 9: goto L_0x04b2;
                case 10: goto L_0x0493;
                case 11: goto L_0x047e;
                case 12: goto L_0x0469;
                case 13: goto L_0x045c;
                case 14: goto L_0x044f;
                case 15: goto L_0x0435;
                case 16: goto L_0x041b;
                case 17: goto L_0x0407;
                case 18: goto L_0x03f9;
                case 19: goto L_0x03ed;
                case 20: goto L_0x03e1;
                case 21: goto L_0x03d5;
                case 22: goto L_0x03c9;
                case 23: goto L_0x03bd;
                case 24: goto L_0x03b1;
                case 25: goto L_0x03a5;
                case 26: goto L_0x0397;
                case 27: goto L_0x0388;
                case 28: goto L_0x037d;
                case 29: goto L_0x0371;
                case 30: goto L_0x0362;
                case 31: goto L_0x0356;
                case 32: goto L_0x034a;
                case 33: goto L_0x033e;
                case 34: goto L_0x0332;
                case 35: goto L_0x0317;
                case 36: goto L_0x0300;
                case 37: goto L_0x02e9;
                case 38: goto L_0x02d2;
                case 39: goto L_0x02bb;
                case 40: goto L_0x02a3;
                case 41: goto L_0x028b;
                case 42: goto L_0x0271;
                case 43: goto L_0x0259;
                case 44: goto L_0x0241;
                case 45: goto L_0x0229;
                case 46: goto L_0x0211;
                case 47: goto L_0x01f9;
                case 48: goto L_0x01e1;
                case 49: goto L_0x01d1;
                case 50: goto L_0x01c4;
                case 51: goto L_0x01b4;
                case 52: goto L_0x01a4;
                case 53: goto L_0x018e;
                case 54: goto L_0x0178;
                case 55: goto L_0x0162;
                case 56: goto L_0x0155;
                case 57: goto L_0x0148;
                case 58: goto L_0x0139;
                case 59: goto L_0x0109;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00d5;
                case 62: goto L_0x00bf;
                case 63: goto L_0x00a9;
                case 64: goto L_0x009b;
                case 65: goto L_0x008d;
                case 66: goto L_0x0072;
                case 67: goto L_0x0056;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x03a2
        L_0x0040:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmi r3 = (com.google.android.gms.internal.measurement.zzmi) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzki.zzt(r11, r3, r4)
            goto L_0x03a1
        L_0x0056:
            boolean r10 = r0.zzT(r1, r11, r5)
            if (r10 == 0) goto L_0x03a2
            long r3 = zzz(r1, r3)
            int r10 = r11 << 3
            long r11 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r10)
            long r3 = r3 ^ r11
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x03a2
        L_0x0072:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x032e
        L_0x008d:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01c0
        L_0x009b:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01b0
        L_0x00a9:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032e
        L_0x00bf:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032e
        L_0x00d5:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x00f2:
            int r3 = r3 + r9
            goto L_0x03a1
        L_0x00f5:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzn(r11, r3, r4)
            goto L_0x03a1
        L_0x0109:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzka
            if (r4 == 0) goto L_0x012b
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x00f2
        L_0x012b:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzw(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032e
        L_0x0139:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r3 = r3 + r14
            goto L_0x03a1
        L_0x0148:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01b0
        L_0x0155:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x01c0
        L_0x0162:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            int r3 = zzp(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032e
        L_0x0178:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            long r3 = zzz(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
            goto L_0x032e
        L_0x018e:
            boolean r9 = r0.zzT(r1, r11, r5)
            if (r9 == 0) goto L_0x03a2
            long r3 = zzz(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
            goto L_0x032e
        L_0x01a4:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x01b0:
            int r3 = r3 + 4
            goto L_0x03a1
        L_0x01b4:
            boolean r3 = r0.zzT(r1, r11, r5)
            if (r3 == 0) goto L_0x03a2
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x01c0:
            int r3 = r3 + 8
            goto L_0x03a1
        L_0x01c4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.zzC(r5)
            com.google.android.gms.internal.measurement.zzmd.zza(r11, r3, r4)
            goto L_0x03a2
        L_0x01d1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzi(r11, r3, r4)
            goto L_0x03a1
        L_0x01e1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzs(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x01f9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzq(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0211:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzh(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0229:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0241:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzd(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0259:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzv(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0271:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r4 = com.google.android.gms.internal.measurement.zzmv.zza
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x028b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x02a3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzh(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x02bb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzk(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x02d2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzx(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x02e9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzm(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0300:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzf(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x032d
        L_0x0317:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzh(r3)
            if (r3 <= 0) goto L_0x03a2
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x032d:
            int r4 = r4 + r9
        L_0x032e:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x03a2
        L_0x0332:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzr(r11, r3, r9)
            goto L_0x036d
        L_0x033e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzp(r11, r3, r9)
            goto L_0x036d
        L_0x034a:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzg(r11, r3, r9)
            goto L_0x036d
        L_0x0356:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zze(r11, r3, r9)
            goto L_0x036d
        L_0x0362:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzc(r11, r3, r9)
        L_0x036d:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x0575
        L_0x0371:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzu(r11, r3, r9)
            goto L_0x03a1
        L_0x037d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzb(r11, r3)
            goto L_0x03a1
        L_0x0388:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzo(r11, r3, r4)
            goto L_0x03a1
        L_0x0397:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzt(r11, r3)
        L_0x03a1:
            int r6 = r6 + r3
        L_0x03a2:
            r12 = 0
            goto L_0x0575
        L_0x03a5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.gms.internal.measurement.zzmv.zza(r11, r3, r12)
            goto L_0x0404
        L_0x03b1:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zze(r11, r3, r12)
            goto L_0x0404
        L_0x03bd:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzg(r11, r3, r12)
            goto L_0x0404
        L_0x03c9:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzj(r11, r3, r12)
            goto L_0x0404
        L_0x03d5:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzw(r11, r3, r12)
            goto L_0x0404
        L_0x03e1:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzl(r11, r3, r12)
            goto L_0x0404
        L_0x03ed:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zze(r11, r3, r12)
            goto L_0x0404
        L_0x03f9:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzg(r11, r3, r12)
        L_0x0404:
            int r6 = r6 + r3
            goto L_0x0575
        L_0x0407:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmi r3 = (com.google.android.gms.internal.measurement.zzmi) r3
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzki.zzt(r11, r3, r4)
            goto L_0x0404
        L_0x041b:
            r12 = 0
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0575
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            long r14 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r10)
            long r3 = r3 ^ r14
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0575
        L_0x0435:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0554
        L_0x044f:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0571
        L_0x045c:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0562
        L_0x0469:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0554
        L_0x047e:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0554
        L_0x0493:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x04af:
            int r3 = r3 + r9
            goto L_0x0404
        L_0x04b2:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.measurement.zzmt r4 = r0.zzB(r5)
            int r3 = com.google.android.gms.internal.measurement.zzmv.zzn(r11, r3, r4)
            goto L_0x0404
        L_0x04c5:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.measurement.zzka
            if (r4 == 0) goto L_0x04e6
            com.google.android.gms.internal.measurement.zzka r3 = (com.google.android.gms.internal.measurement.zzka) r3
            int r4 = r11 << 3
            int r9 = com.google.android.gms.internal.measurement.zzki.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x04af
        L_0x04e6:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzw(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0554
        L_0x04f3:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            int r3 = r3 + r14
            goto L_0x0404
        L_0x0501:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0562
        L_0x050d:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
            goto L_0x0571
        L_0x0519:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzu(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0554
        L_0x052d:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
            goto L_0x0554
        L_0x0541:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0575
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzy(r3)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r9)
        L_0x0554:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0575
        L_0x0557:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x0562:
            int r3 = r3 + 4
            goto L_0x0404
        L_0x0566:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0575
            int r3 = r11 << 3
            int r3 = com.google.android.gms.internal.measurement.zzki.zzx(r3)
        L_0x0571:
            int r3 = r3 + 8
            goto L_0x0404
        L_0x0575:
            int r5 = r5 + 3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000d
        L_0x057c:
            com.google.android.gms.internal.measurement.zznk r2 = r0.zzn
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 != 0) goto L_0x058c
            return r6
        L_0x058c:
            com.google.android.gms.internal.measurement.zzko r2 = r0.zzo
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzo(java.lang.Object):int");
    }

    private static int zzp(Object obj, long j11) {
        return ((Integer) zznu.zzf(obj, j11)).intValue();
    }

    private final int zzq(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, zzjn zzjn) throws IOException {
        Unsafe unsafe = zzb;
        Object zzC = zzC(i13);
        Object object = unsafe.getObject(obj, j11);
        if (!((zzmc) object).zze()) {
            zzmc zzb2 = zzmc.zza().zzb();
            zzmd.zzb(zzb2, object);
            unsafe.putObject(obj, j11, zzb2);
        }
        zzmb zzmb = (zzmb) zzC;
        throw null;
    }

    private final int zzr(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzjn zzjn) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i19 = i11;
        int i21 = i13;
        int i22 = i14;
        int i23 = i15;
        long j12 = j11;
        int i24 = i18;
        zzjn zzjn2 = zzjn;
        Unsafe unsafe = zzb;
        long j13 = (long) (this.zzc[i24 + 2] & 1048575);
        switch (i17) {
            case 51:
                if (i23 == 1) {
                    unsafe.putObject(obj2, j12, Double.valueOf(Double.longBitsToDouble(zzjo.zzp(bArr, i11))));
                    int i25 = i19 + 8;
                    unsafe.putInt(obj2, j13, i22);
                    return i25;
                }
                break;
            case 52:
                if (i23 == 5) {
                    unsafe.putObject(obj2, j12, Float.valueOf(Float.intBitsToFloat(zzjo.zzb(bArr, i11))));
                    int i26 = i19 + 4;
                    unsafe.putInt(obj2, j13, i22);
                    return i26;
                }
                break;
            case 53:
            case 54:
                if (i23 == 0) {
                    int zzm2 = zzjo.zzm(bArr2, i19, zzjn2);
                    unsafe.putObject(obj2, j12, Long.valueOf(zzjn2.zzb));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i23 == 0) {
                    int zzj2 = zzjo.zzj(bArr2, i19, zzjn2);
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzjn2.zza));
                    unsafe.putInt(obj2, j13, i22);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i23 == 1) {
                    unsafe.putObject(obj2, j12, Long.valueOf(zzjo.zzp(bArr, i11)));
                    int i27 = i19 + 8;
                    unsafe.putInt(obj2, j13, i22);
                    return i27;
                }
                break;
            case 57:
            case 64:
                if (i23 == 5) {
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzjo.zzb(bArr, i11)));
                    int i28 = i19 + 4;
                    unsafe.putInt(obj2, j13, i22);
                    return i28;
                }
                break;
            case 58:
                if (i23 == 0) {
                    int zzm3 = zzjo.zzm(bArr2, i19, zzjn2);
                    unsafe.putObject(obj2, j12, Boolean.valueOf(zzjn2.zzb != 0));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm3;
                }
                break;
            case 59:
                if (i23 == 2) {
                    int zzj3 = zzjo.zzj(bArr2, i19, zzjn2);
                    int i29 = zzjn2.zza;
                    if (i29 == 0) {
                        unsafe.putObject(obj2, j12, "");
                    } else if ((i16 & 536870912) == 0 || zznz.zze(bArr2, zzj3, zzj3 + i29)) {
                        unsafe.putObject(obj2, j12, new String(bArr2, zzj3, i29, zzlj.zzb));
                        zzj3 += i29;
                    } else {
                        throw zzll.zzc();
                    }
                    unsafe.putInt(obj2, j13, i22);
                    return zzj3;
                }
                break;
            case 60:
                if (i23 == 2) {
                    Object zzE = zzE(obj2, i22, i24);
                    int zzo2 = zzjo.zzo(zzE, zzB(i24), bArr, i11, i12, zzjn);
                    zzM(obj2, i22, i24, zzE);
                    return zzo2;
                }
                break;
            case 61:
                if (i23 == 2) {
                    int zza2 = zzjo.zza(bArr2, i19, zzjn2);
                    unsafe.putObject(obj2, j12, zzjn2.zzc);
                    unsafe.putInt(obj2, j13, i22);
                    return zza2;
                }
                break;
            case 63:
                if (i23 == 0) {
                    int zzj4 = zzjo.zzj(bArr2, i19, zzjn2);
                    int i30 = zzjn2.zza;
                    zzlf zzA = zzA(i24);
                    if (zzA == null || zzA.zza(i30)) {
                        unsafe.putObject(obj2, j12, Integer.valueOf(i30));
                        unsafe.putInt(obj2, j13, i22);
                    } else {
                        zzd(obj).zzj(i21, Long.valueOf((long) i30));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i23 == 0) {
                    int zzj5 = zzjo.zzj(bArr2, i19, zzjn2);
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzke.zzb(zzjn2.zza)));
                    unsafe.putInt(obj2, j13, i22);
                    return zzj5;
                }
                break;
            case 67:
                if (i23 == 0) {
                    int zzm4 = zzjo.zzm(bArr2, i19, zzjn2);
                    unsafe.putObject(obj2, j12, Long.valueOf(zzke.zzc(zzjn2.zzb)));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm4;
                }
                break;
            case 68:
                if (i23 == 3) {
                    Object zzE2 = zzE(obj2, i22, i24);
                    int zzn2 = zzjo.zzn(zzE2, zzB(i24), bArr, i11, i12, (i21 & -8) | 4, zzjn);
                    zzM(obj2, i22, i24, zzE2);
                    return zzn2;
                }
                break;
        }
        return i19;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x0496 A[SYNTHETIC] */
    private final int zzs(java.lang.Object r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzjn r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r8 = r22
            r6 = r23
            r9 = r24
            r10 = r28
            r7 = r30
            sun.misc.Unsafe r12 = zzb
            java.lang.Object r13 = r12.getObject(r1, r10)
            com.google.android.gms.internal.measurement.zzli r13 = (com.google.android.gms.internal.measurement.zzli) r13
            boolean r14 = r13.zzc()
            if (r14 != 0) goto L_0x0035
            int r14 = r13.size()
            if (r14 != 0) goto L_0x002d
            r14 = 10
            goto L_0x002e
        L_0x002d:
            int r14 = r14 + r14
        L_0x002e:
            com.google.android.gms.internal.measurement.zzli r13 = r13.zzd(r14)
            r12.putObject(r1, r10, r13)
        L_0x0035:
            r10 = 5
            r11 = 0
            r15 = 1
            r14 = 2
            switch(r27) {
                case 18: goto L_0x0427;
                case 19: goto L_0x03da;
                case 20: goto L_0x0397;
                case 21: goto L_0x0397;
                case 22: goto L_0x037e;
                case 23: goto L_0x033d;
                case 24: goto L_0x02fc;
                case 25: goto L_0x02a4;
                case 26: goto L_0x01f1;
                case 27: goto L_0x01d8;
                case 28: goto L_0x017e;
                case 29: goto L_0x037e;
                case 30: goto L_0x00fd;
                case 31: goto L_0x02fc;
                case 32: goto L_0x033d;
                case 33: goto L_0x00ae;
                case 34: goto L_0x005f;
                case 35: goto L_0x0427;
                case 36: goto L_0x03da;
                case 37: goto L_0x0397;
                case 38: goto L_0x0397;
                case 39: goto L_0x037e;
                case 40: goto L_0x033d;
                case 41: goto L_0x02fc;
                case 42: goto L_0x02a4;
                case 43: goto L_0x037e;
                case 44: goto L_0x00fd;
                case 45: goto L_0x02fc;
                case 46: goto L_0x033d;
                case 47: goto L_0x00ae;
                case 48: goto L_0x005f;
                default: goto L_0x003d;
            }
        L_0x003d:
            r1 = 3
            if (r6 != r1) goto L_0x0495
            com.google.android.gms.internal.measurement.zzmt r1 = r0.zzB(r9)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzc(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzc
            r13.add(r8)
            goto L_0x0473
        L_0x005f:
            if (r6 != r14) goto L_0x0083
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x006a:
            if (r1 >= r2) goto L_0x007a
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzke.zzc(r4)
            r13.zzg(r4)
            goto L_0x006a
        L_0x007a:
            if (r1 != r2) goto L_0x007e
            goto L_0x0496
        L_0x007e:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x0083:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzke.zzc(r8)
            r13.zzg(r8)
        L_0x0094:
            if (r1 >= r5) goto L_0x00ad
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009f
            goto L_0x00ad
        L_0x009f:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzke.zzc(r8)
            r13.zzg(r8)
            goto L_0x0094
        L_0x00ad:
            return r1
        L_0x00ae:
            if (r6 != r14) goto L_0x00d2
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b9:
            if (r1 >= r2) goto L_0x00c9
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzke.zzb(r4)
            r13.zzh(r4)
            goto L_0x00b9
        L_0x00c9:
            if (r1 != r2) goto L_0x00cd
            goto L_0x0496
        L_0x00cd:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x00d2:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzke.zzb(r4)
            r13.zzh(r4)
        L_0x00e3:
            if (r1 >= r5) goto L_0x00fc
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00ee
            goto L_0x00fc
        L_0x00ee:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzke.zzb(r4)
            r13.zzh(r4)
            goto L_0x00e3
        L_0x00fc:
            return r1
        L_0x00fd:
            if (r6 != r14) goto L_0x0104
            int r2 = com.google.android.gms.internal.measurement.zzjo.zzf(r3, r4, r13, r7)
            goto L_0x0115
        L_0x0104:
            if (r6 != 0) goto L_0x0495
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r13
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzjo.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0115:
            com.google.android.gms.internal.measurement.zzlf r3 = r0.zzA(r9)
            com.google.android.gms.internal.measurement.zznk r4 = r0.zzn
            int r5 = com.google.android.gms.internal.measurement.zzmv.zza
            if (r3 == 0) goto L_0x017b
            boolean r5 = r13 instanceof java.util.RandomAccess
            r6 = 0
            if (r5 == 0) goto L_0x0159
            int r5 = r13.size()
            r7 = 0
            r14 = 0
        L_0x012a:
            if (r14 >= r5) goto L_0x014f
            java.lang.Object r9 = r13.get(r14)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            boolean r10 = r3.zza(r9)
            if (r10 == 0) goto L_0x0148
            if (r14 == r7) goto L_0x0145
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            r13.set(r7, r9)
        L_0x0145:
            int r7 = r7 + 1
            goto L_0x014c
        L_0x0148:
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzmv.zzA(r1, r8, r9, r6, r4)
        L_0x014c:
            int r14 = r14 + 1
            goto L_0x012a
        L_0x014f:
            if (r7 == r5) goto L_0x017b
            java.util.List r1 = r13.subList(r7, r5)
            r1.clear()
            return r2
        L_0x0159:
            java.util.Iterator r5 = r13.iterator()
        L_0x015d:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x017b
            java.lang.Object r7 = r5.next()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            boolean r9 = r3.zza(r7)
            if (r9 != 0) goto L_0x015d
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzmv.zzA(r1, r8, r7, r6, r4)
            r5.remove()
            goto L_0x015d
        L_0x017b:
            r1 = r2
            goto L_0x0496
        L_0x017e:
            if (r6 != r14) goto L_0x0495
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01d3
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x01ce
            if (r4 != 0) goto L_0x0194
            com.google.android.gms.internal.measurement.zzka r4 = com.google.android.gms.internal.measurement.zzka.zzb
            r13.add(r4)
            goto L_0x019c
        L_0x0194:
            com.google.android.gms.internal.measurement.zzka r6 = com.google.android.gms.internal.measurement.zzka.zzl(r3, r1, r4)
            r13.add(r6)
        L_0x019b:
            int r1 = r1 + r4
        L_0x019c:
            if (r1 >= r5) goto L_0x01cd
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x01a7
            goto L_0x01cd
        L_0x01a7:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01c8
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x01c3
            if (r4 != 0) goto L_0x01bb
            com.google.android.gms.internal.measurement.zzka r4 = com.google.android.gms.internal.measurement.zzka.zzb
            r13.add(r4)
            goto L_0x019c
        L_0x01bb:
            com.google.android.gms.internal.measurement.zzka r6 = com.google.android.gms.internal.measurement.zzka.zzl(r3, r1, r4)
            r13.add(r6)
            goto L_0x019b
        L_0x01c3:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x01c8:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x01cd:
            return r1
        L_0x01ce:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x01d3:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x01d8:
            if (r6 != r14) goto L_0x0495
            com.google.android.gms.internal.measurement.zzmt r1 = r0.zzB(r9)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r13
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzjo.zze(r22, r23, r24, r25, r26, r27, r28)
            return r1
        L_0x01f1:
            if (r6 != r14) goto L_0x0495
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            int r1 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0244
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x023f
            if (r4 != 0) goto L_0x020c
            r13.add(r6)
            goto L_0x0217
        L_0x020c:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzlj.zzb
            r8.<init>(r3, r1, r4, r9)
            r13.add(r8)
        L_0x0216:
            int r1 = r1 + r4
        L_0x0217:
            if (r1 >= r5) goto L_0x0496
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0496
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x023a
            if (r4 != 0) goto L_0x022f
            r13.add(r6)
            goto L_0x0217
        L_0x022f:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzlj.zzb
            r8.<init>(r3, r1, r4, r9)
            r13.add(r8)
            goto L_0x0216
        L_0x023a:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x023f:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x0244:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x029f
            if (r4 != 0) goto L_0x0252
            r13.add(r6)
            goto L_0x0265
        L_0x0252:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zznz.zze(r3, r1, r8)
            if (r9 == 0) goto L_0x029a
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzlj.zzb
            r9.<init>(r3, r1, r4, r10)
            r13.add(r9)
        L_0x0264:
            r1 = r8
        L_0x0265:
            if (r1 >= r5) goto L_0x0496
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0496
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0295
            if (r4 != 0) goto L_0x027d
            r13.add(r6)
            goto L_0x0265
        L_0x027d:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.measurement.zznz.zze(r3, r1, r8)
            if (r9 == 0) goto L_0x0290
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzlj.zzb
            r9.<init>(r3, r1, r4, r10)
            r13.add(r9)
            goto L_0x0264
        L_0x0290:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzc()
            throw r1
        L_0x0295:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x029a:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzc()
            throw r1
        L_0x029f:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzd()
            throw r1
        L_0x02a4:
            if (r6 != r14) goto L_0x02cb
            com.google.android.gms.internal.measurement.zzjp r13 = (com.google.android.gms.internal.measurement.zzjp) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02af:
            if (r1 >= r2) goto L_0x02c2
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r1, r7)
            long r4 = r7.zzb
            int r4 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x02bd
            r4 = r15
            goto L_0x02be
        L_0x02bd:
            r4 = 0
        L_0x02be:
            r13.zze(r4)
            goto L_0x02af
        L_0x02c2:
            if (r1 != r2) goto L_0x02c6
            goto L_0x0496
        L_0x02c6:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x02cb:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzjp r13 = (com.google.android.gms.internal.measurement.zzjp) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x02db
            r4 = r15
            goto L_0x02dc
        L_0x02db:
            r4 = 0
        L_0x02dc:
            r13.zze(r4)
        L_0x02df:
            if (r1 >= r5) goto L_0x02fb
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ea
            goto L_0x02fb
        L_0x02ea:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x02f6
            r4 = r15
            goto L_0x02f7
        L_0x02f6:
            r4 = 0
        L_0x02f7:
            r13.zze(r4)
            goto L_0x02df
        L_0x02fb:
            return r1
        L_0x02fc:
            if (r6 != r14) goto L_0x031c
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0307:
            if (r1 >= r2) goto L_0x0313
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r1)
            r13.zzh(r4)
            int r1 = r1 + 4
            goto L_0x0307
        L_0x0313:
            if (r1 != r2) goto L_0x0317
            goto L_0x0496
        L_0x0317:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x031c:
            if (r6 != r10) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlc r13 = (com.google.android.gms.internal.measurement.zzlc) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r18, r19)
            r13.zzh(r1)
        L_0x0327:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x033c
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0334
            goto L_0x033c
        L_0x0334:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r4)
            r13.zzh(r1)
            goto L_0x0327
        L_0x033c:
            return r1
        L_0x033d:
            if (r6 != r14) goto L_0x035d
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0348:
            if (r1 >= r2) goto L_0x0354
            long r4 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r1)
            r13.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0348
        L_0x0354:
            if (r1 != r2) goto L_0x0358
            goto L_0x0496
        L_0x0358:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x035d:
            if (r6 != r15) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r18, r19)
            r13.zzg(r8)
        L_0x0368:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x037d
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0375
            goto L_0x037d
        L_0x0375:
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r4)
            r13.zzg(r8)
            goto L_0x0368
        L_0x037d:
            return r1
        L_0x037e:
            if (r6 != r14) goto L_0x0386
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzf(r3, r4, r13, r7)
            goto L_0x0496
        L_0x0386:
            if (r6 != 0) goto L_0x0495
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r13
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzl(r21, r22, r23, r24, r25, r26)
            return r1
        L_0x0397:
            if (r6 != r14) goto L_0x03b7
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03a2:
            if (r1 >= r2) goto L_0x03ae
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r13.zzg(r4)
            goto L_0x03a2
        L_0x03ae:
            if (r1 != r2) goto L_0x03b2
            goto L_0x0496
        L_0x03b2:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x03b7:
            if (r6 != 0) goto L_0x0495
            com.google.android.gms.internal.measurement.zzlx r13 = (com.google.android.gms.internal.measurement.zzlx) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r13.zzg(r8)
        L_0x03c4:
            if (r1 >= r5) goto L_0x03d9
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03cf
            goto L_0x03d9
        L_0x03cf:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r13.zzg(r8)
            goto L_0x03c4
        L_0x03d9:
            return r1
        L_0x03da:
            if (r6 != r14) goto L_0x03fe
            com.google.android.gms.internal.measurement.zzku r13 = (com.google.android.gms.internal.measurement.zzku) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03e5:
            if (r1 >= r2) goto L_0x03f5
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r13.zze(r4)
            int r1 = r1 + 4
            goto L_0x03e5
        L_0x03f5:
            if (r1 != r2) goto L_0x03f9
            goto L_0x0496
        L_0x03f9:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x03fe:
            if (r6 != r10) goto L_0x0495
            com.google.android.gms.internal.measurement.zzku r13 = (com.google.android.gms.internal.measurement.zzku) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r18, r19)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
        L_0x040d:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0426
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x041a
            goto L_0x0426
        L_0x041a:
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
            goto L_0x040d
        L_0x0426:
            return r1
        L_0x0427:
            if (r6 != r14) goto L_0x044a
            com.google.android.gms.internal.measurement.zzkk r13 = (com.google.android.gms.internal.measurement.zzkk) r13
            int r1 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0432:
            if (r1 >= r2) goto L_0x0442
            long r4 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r13.zze(r4)
            int r1 = r1 + 8
            goto L_0x0432
        L_0x0442:
            if (r1 != r2) goto L_0x0445
            goto L_0x0496
        L_0x0445:
            com.google.android.gms.internal.measurement.zzll r1 = com.google.android.gms.internal.measurement.zzll.zzf()
            throw r1
        L_0x044a:
            if (r6 != r15) goto L_0x0495
            com.google.android.gms.internal.measurement.zzkk r13 = (com.google.android.gms.internal.measurement.zzkk) r13
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r18, r19)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r13.zze(r8)
        L_0x0459:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0472
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0466
            goto L_0x0472
        L_0x0466:
            long r8 = com.google.android.gms.internal.measurement.zzjo.zzp(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r13.zze(r8)
            goto L_0x0459
        L_0x0472:
            return r1
        L_0x0473:
            if (r4 >= r5) goto L_0x0494
            int r8 = com.google.android.gms.internal.measurement.zzjo.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x047e
            goto L_0x0494
        L_0x047e:
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzjo.zzc(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzc
            r13.add(r8)
            goto L_0x0473
        L_0x0494:
            return r4
        L_0x0495:
            r1 = r4
        L_0x0496:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzs(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzjn):int");
    }

    private final int zzt(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzw(i11, 0);
    }

    private final int zzu(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzw(i11, i12);
    }

    private final int zzv(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzw(int i11, int i12) {
        int length = (this.zzc.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int i15 = this.zzc[i14];
            if (i11 == i15) {
                return i14;
            }
            if (i11 < i15) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    private static int zzx(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzy(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzz(Object obj, long j11) {
        return ((Long) zznu.zzf(obj, j11)).longValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0326, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0420, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a2, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04f4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x055f, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x056f, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0573, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzi
            if (r0 == 0) goto L_0x0583
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0009:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0577
            int r4 = r11.zzy(r2)
            int r5 = zzx(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            com.google.android.gms.internal.measurement.zzkt r7 = com.google.android.gms.internal.measurement.zzkt.DOUBLE_LIST_PACKED
            int r7 = r7.zza()
            if (r5 < r7) goto L_0x0034
            com.google.android.gms.internal.measurement.zzkt r7 = com.google.android.gms.internal.measurement.zzkt.SINT64_LIST_PACKED
            int r7 = r7.zza()
            if (r5 > r7) goto L_0x0034
            int[] r7 = r11.zzc
            int r8 = r2 + 2
            r7 = r7[r8]
        L_0x0034:
            long r7 = (long) r4
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0563;
                case 1: goto L_0x0553;
                case 2: goto L_0x053c;
                case 3: goto L_0x0527;
                case 4: goto L_0x0512;
                case 5: goto L_0x0505;
                case 6: goto L_0x04f8;
                case 7: goto L_0x04e8;
                case 8: goto L_0x04b9;
                case 9: goto L_0x04a5;
                case 10: goto L_0x0485;
                case 11: goto L_0x046f;
                case 12: goto L_0x0459;
                case 13: goto L_0x044b;
                case 14: goto L_0x043d;
                case 15: goto L_0x0422;
                case 16: goto L_0x0406;
                case 17: goto L_0x03f1;
                case 18: goto L_0x03e4;
                case 19: goto L_0x03d9;
                case 20: goto L_0x03ce;
                case 21: goto L_0x03c3;
                case 22: goto L_0x03b8;
                case 23: goto L_0x03ad;
                case 24: goto L_0x03a2;
                case 25: goto L_0x0397;
                case 26: goto L_0x038c;
                case 27: goto L_0x037d;
                case 28: goto L_0x0371;
                case 29: goto L_0x0365;
                case 30: goto L_0x0359;
                case 31: goto L_0x034d;
                case 32: goto L_0x0341;
                case 33: goto L_0x0335;
                case 34: goto L_0x0329;
                case 35: goto L_0x0310;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02e2;
                case 38: goto L_0x02cb;
                case 39: goto L_0x02b4;
                case 40: goto L_0x029c;
                case 41: goto L_0x0284;
                case 42: goto L_0x026a;
                case 43: goto L_0x0252;
                case 44: goto L_0x023a;
                case 45: goto L_0x0222;
                case 46: goto L_0x020a;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01da;
                case 49: goto L_0x01ca;
                case 50: goto L_0x01bd;
                case 51: goto L_0x01af;
                case 52: goto L_0x01a1;
                case 53: goto L_0x018b;
                case 54: goto L_0x0175;
                case 55: goto L_0x015f;
                case 56: goto L_0x0151;
                case 57: goto L_0x0143;
                case 58: goto L_0x0135;
                case 59: goto L_0x0104;
                case 60: goto L_0x00f0;
                case 61: goto L_0x00d1;
                case 62: goto L_0x00bb;
                case 63: goto L_0x00a5;
                case 64: goto L_0x0097;
                case 65: goto L_0x0089;
                case 66: goto L_0x006e;
                case 67: goto L_0x0052;
                case 68: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0573
        L_0x003c:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmi r4 = (com.google.android.gms.internal.measurement.zzmi) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzt(r6, r4, r5)
            goto L_0x03ee
        L_0x0052:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0573
            long r7 = zzz(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.measurement.zzki.zzy(r5)
            goto L_0x0420
        L_0x006e:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0550
        L_0x0089:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x0097:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x00a5:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x00bb:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x00d1:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x04a2
        L_0x00f0:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzn(r6, r4, r5)
            goto L_0x03ee
        L_0x0104:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzka
            if (r5 == 0) goto L_0x0127
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x04a2
        L_0x0127:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzw(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0135:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x04f4
        L_0x0143:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x0151:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x015f:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = zzp(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0175:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = zzz(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
            goto L_0x0550
        L_0x018b:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = zzz(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
            goto L_0x0550
        L_0x01a1:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x01af:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x01bd:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.lang.Object r5 = r11.zzC(r2)
            com.google.android.gms.internal.measurement.zzmd.zza(r6, r4, r5)
            goto L_0x0573
        L_0x01ca:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzi(r6, r4, r5)
            goto L_0x03ee
        L_0x01da:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzs(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x01f2:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzq(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x020a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0222:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x023a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzd(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0252:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzv(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x026a:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r5 = com.google.android.gms.internal.measurement.zzmv.zza
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0284:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x029c:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02b4:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzk(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02cb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzx(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02e2:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzm(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x02f9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzf(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0326
        L_0x0310:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzh(r4)
            if (r4 <= 0) goto L_0x0573
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
        L_0x0326:
            int r5 = r5 + r6
            goto L_0x0550
        L_0x0329:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzr(r6, r4, r1)
            goto L_0x03ee
        L_0x0335:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzp(r6, r4, r1)
            goto L_0x03ee
        L_0x0341:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzg(r6, r4, r1)
            goto L_0x03ee
        L_0x034d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x0359:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzc(r6, r4, r1)
            goto L_0x03ee
        L_0x0365:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzu(r6, r4, r1)
            goto L_0x03ee
        L_0x0371:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzb(r6, r4)
            goto L_0x03ee
        L_0x037d:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzo(r6, r4, r5)
            goto L_0x03ee
        L_0x038c:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzt(r6, r4)
            goto L_0x03ee
        L_0x0397:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zza(r6, r4, r1)
            goto L_0x03ee
        L_0x03a2:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x03ad:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzg(r6, r4, r1)
            goto L_0x03ee
        L_0x03b8:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzj(r6, r4, r1)
            goto L_0x03ee
        L_0x03c3:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzw(r6, r4, r1)
            goto L_0x03ee
        L_0x03ce:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzl(r6, r4, r1)
            goto L_0x03ee
        L_0x03d9:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zze(r6, r4, r1)
            goto L_0x03ee
        L_0x03e4:
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzg(r6, r4, r1)
        L_0x03ee:
            int r3 = r3 + r4
            goto L_0x0573
        L_0x03f1:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmi r4 = (com.google.android.gms.internal.measurement.zzmi) r4
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzki.zzt(r6, r4, r5)
            goto L_0x03ee
        L_0x0406:
            boolean r5 = r11.zzP(r12, r2)
            if (r5 == 0) goto L_0x0573
            long r7 = com.google.android.gms.internal.measurement.zznu.zzd(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.gms.internal.measurement.zzki.zzy(r5)
        L_0x0420:
            int r4 = r4 + r5
            goto L_0x03ee
        L_0x0422:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x0550
        L_0x043d:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x044b:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x0459:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x046f:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0485:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
        L_0x04a2:
            int r4 = r4 + r6
            goto L_0x03ee
        L_0x04a5:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            com.google.android.gms.internal.measurement.zzmt r5 = r11.zzB(r2)
            int r4 = com.google.android.gms.internal.measurement.zzmv.zzn(r6, r4, r5)
            goto L_0x03ee
        L_0x04b9:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.measurement.zzka
            if (r5 == 0) goto L_0x04db
            com.google.android.gms.internal.measurement.zzka r4 = (com.google.android.gms.internal.measurement.zzka) r4
            int r5 = r6 << 3
            int r6 = com.google.android.gms.internal.measurement.zzki.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x04a2
        L_0x04db:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzw(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x04e8:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x04f4:
            int r4 = r4 + 1
            goto L_0x03ee
        L_0x04f8:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x055f
        L_0x0505:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
            goto L_0x056f
        L_0x0512:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = com.google.android.gms.internal.measurement.zznu.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzu(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r5)
            goto L_0x0550
        L_0x0527:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = com.google.android.gms.internal.measurement.zznu.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
            goto L_0x0550
        L_0x053c:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            long r4 = com.google.android.gms.internal.measurement.zznu.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzy(r4)
            int r5 = com.google.android.gms.internal.measurement.zzki.zzx(r6)
        L_0x0550:
            int r5 = r5 + r4
            int r3 = r3 + r5
            goto L_0x0573
        L_0x0553:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x055f:
            int r4 = r4 + 4
            goto L_0x03ee
        L_0x0563:
            boolean r4 = r11.zzP(r12, r2)
            if (r4 == 0) goto L_0x0573
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.measurement.zzki.zzx(r4)
        L_0x056f:
            int r4 = r4 + 8
            goto L_0x03ee
        L_0x0573:
            int r2 = r2 + 3
            goto L_0x0009
        L_0x0577:
            com.google.android.gms.internal.measurement.zznk r0 = r11.zzn
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            goto L_0x0587
        L_0x0583:
            int r3 = r11.zzo(r12)
        L_0x0587:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b4, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0210, code lost:
        r3 = (int) (r3 ^ (r3 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0214, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0215, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x0219
            int r3 = r9.zzy(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzx(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0204;
                case 1: goto L_0x01f9;
                case 2: goto L_0x01f0;
                case 3: goto L_0x01e7;
                case 4: goto L_0x01e0;
                case 5: goto L_0x01d7;
                case 6: goto L_0x01d0;
                case 7: goto L_0x01c5;
                case 8: goto L_0x01b8;
                case 9: goto L_0x01aa;
                case 10: goto L_0x019e;
                case 11: goto L_0x0196;
                case 12: goto L_0x018e;
                case 13: goto L_0x0186;
                case 14: goto L_0x017c;
                case 15: goto L_0x0174;
                case 16: goto L_0x016a;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0215
        L_0x0021:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x0033:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0043:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x0051:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0061:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x006f:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x007d:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x008b:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x009d:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x00af:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x00c3:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            boolean r3 = zzU(r10, r5)
            int r3 = com.google.android.gms.internal.measurement.zzlj.zza(r3)
            goto L_0x0214
        L_0x00d5:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x00e3:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x00f3:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x0101:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0111:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzz(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0121:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            float r3 = zzn(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0214
        L_0x0133:
            boolean r3 = r9.zzT(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            double r3 = zzm(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x015f:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b4
            int r7 = r3.hashCode()
            goto L_0x01b4
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0214
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0214
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0214
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0214
        L_0x019e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x01aa:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b4
            int r7 = r3.hashCode()
        L_0x01b4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0215
        L_0x01b8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zznu.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x01c5:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zznu.zzw(r10, r5)
            int r3 = com.google.android.gms.internal.measurement.zzlj.zza(r3)
            goto L_0x0214
        L_0x01d0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0214
        L_0x01d7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x01e0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zznu.zzc(r10, r5)
            goto L_0x0214
        L_0x01e7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x01f0:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zznu.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
            goto L_0x0210
        L_0x01f9:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zznu.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0214
        L_0x0204:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zznu.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.measurement.zzlj.zzd
        L_0x0210:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r3 = (int) r3
        L_0x0214:
            int r2 = r2 + r3
        L_0x0215:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0219:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zznk r0 = r9.zzn
            java.lang.Object r0 = r0.zzd(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzh
            if (r0 != 0) goto L_0x022b
            return r2
        L_0x022b:
            com.google.android.gms.internal.measurement.zzko r0 = r9.zzo
            r0.zza(r10)
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v50, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v91, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x030e, code lost:
        if (r0 != r15) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x032c, code lost:
        r2 = r0;
        r7 = r21;
        r6 = r24;
        r0 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0360, code lost:
        if (r0 != r15) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0388, code lost:
        if (r0 != r15) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0154, code lost:
        r5 = r7 | r8;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0157, code lost:
        r1 = r11;
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x015b, code lost:
        r12 = r6;
        r21 = r13;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f0, code lost:
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0223, code lost:
        r6 = r24;
        r8 = -1;
        r13 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0251, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0253, code lost:
        r5 = r7 | r8;
        r13 = r32;
        r2 = r6;
        r1 = r11;
        r3 = r21;
        r6 = r24;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x025e, code lost:
        r11 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0262, code lost:
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0263, code lost:
        r0 = r33;
        r20 = r7;
        r27 = r10;
        r31 = r11;
        r22 = r12;
        r2 = r13;
        r7 = r21;
        r6 = r24;
        r19 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.measurement.zzjn r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            zzG(r29)
            sun.misc.Unsafe r10 = zzb
            r8 = -1
            r16 = 0
            r0 = r31
            r1 = r8
            r2 = r16
            r3 = r2
            r5 = r3
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            r17 = 0
            if (r0 >= r13) goto L_0x03f7
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0031
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzk(r0, r12, r3, r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x0032
        L_0x0031:
            r4 = r0
        L_0x0032:
            int r0 = r4 >>> 3
            r7 = 3
            if (r0 <= r1) goto L_0x003d
            int r2 = r2 / r7
            int r1 = r15.zzu(r0, r2)
            goto L_0x0041
        L_0x003d:
            int r1 = r15.zzt(r0)
        L_0x0041:
            r2 = r1
            if (r2 != r8) goto L_0x0053
            r31 = r0
            r2 = r3
            r7 = r4
            r20 = r5
            r19 = r8
            r27 = r10
            r0 = r11
            r22 = r16
            goto L_0x038b
        L_0x0053:
            r1 = r4 & 7
            int[] r8 = r15.zzc
            int r20 = r2 + 1
            r7 = r8[r20]
            int r11 = zzx(r7)
            r20 = r0
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r18
            r22 = r3
            r21 = r4
            long r3 = (long) r0
            r0 = 17
            if (r11 > r0) goto L_0x0276
            int r0 = r2 + 2
            r0 = r8[r0]
            int r8 = r0 >>> 20
            r13 = 1
            int r8 = r13 << r8
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r13
            r18 = r7
            if (r0 == r6) goto L_0x008f
            if (r6 == r13) goto L_0x0086
            long r6 = (long) r6
            r10.putInt(r14, r6, r5)
        L_0x0086:
            long r5 = (long) r0
            int r5 = r10.getInt(r14, r5)
            r24 = r0
            r7 = r5
            goto L_0x0092
        L_0x008f:
            r7 = r5
            r24 = r6
        L_0x0092:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x023e;
                case 1: goto L_0x0229;
                case 2: goto L_0x0204;
                case 3: goto L_0x0204;
                case 4: goto L_0x01f3;
                case 5: goto L_0x01d8;
                case 6: goto L_0x01c6;
                case 7: goto L_0x01aa;
                case 8: goto L_0x018c;
                case 9: goto L_0x0161;
                case 10: goto L_0x0141;
                case 11: goto L_0x01f3;
                case 12: goto L_0x0112;
                case 13: goto L_0x01c6;
                case 14: goto L_0x01d8;
                case 15: goto L_0x00fb;
                case 16: goto L_0x00cc;
                default: goto L_0x0096;
            }
        L_0x0096:
            r6 = r2
            r11 = r20
            r13 = r22
            r0 = 3
            if (r1 != r0) goto L_0x0262
            java.lang.Object r5 = r15.zzD(r14, r6)
            int r0 = r11 << 3
            r17 = r0 | 4
            com.google.android.gms.internal.measurement.zzmt r1 = r15.zzB(r6)
            r0 = r5
            r2 = r30
            r3 = r13
            r4 = r32
            r13 = r5
            r5 = r17
            r12 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzn(r0, r1, r2, r3, r4, r5, r6)
            r15.zzL(r14, r12, r13)
            r5 = r7 | r8
            r13 = r32
            r1 = r11
            r2 = r12
            r3 = r21
            r6 = r24
            r8 = -1
            r12 = r30
            goto L_0x025e
        L_0x00cc:
            if (r1 != 0) goto L_0x00f4
            r5 = r22
            int r6 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r5, r9)
            long r0 = r9.zzb
            long r17 = com.google.android.gms.internal.measurement.zzke.zzc(r0)
            r11 = r20
            r0 = r10
            r1 = r29
            r5 = r2
            r2 = r3
            r20 = r6
            r13 = r21
            r6 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r3 = r13
            r0 = r20
            goto L_0x0223
        L_0x00f4:
            r11 = r20
            r12 = r2
            r13 = r22
            goto L_0x0263
        L_0x00fb:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            if (r1 != 0) goto L_0x015b
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r5, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.measurement.zzke.zzb(r1)
            r10.putInt(r14, r3, r1)
            goto L_0x0154
        L_0x0112:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            if (r1 != 0) goto L_0x015b
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r5, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.measurement.zzlf r2 = r15.zzA(r6)
            if (r2 == 0) goto L_0x013d
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x012e
            goto L_0x013d
        L_0x012e:
            com.google.android.gms.internal.measurement.zznl r2 = zzd(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzj(r13, r1)
            r2 = r6
            r5 = r7
            goto L_0x0157
        L_0x013d:
            r10.putInt(r14, r3, r1)
            goto L_0x0154
        L_0x0141:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            r0 = 2
            if (r1 != r0) goto L_0x015b
            int r0 = com.google.android.gms.internal.measurement.zzjo.zza(r12, r5, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
        L_0x0154:
            r5 = r7 | r8
            r2 = r6
        L_0x0157:
            r1 = r11
            r3 = r13
            goto L_0x0223
        L_0x015b:
            r12 = r6
            r21 = r13
            r13 = r5
            goto L_0x0263
        L_0x0161:
            r6 = r2
            r11 = r20
            r13 = r21
            r5 = r22
            r0 = 2
            if (r1 != r0) goto L_0x0188
            java.lang.Object r4 = r15.zzD(r14, r6)
            com.google.android.gms.internal.measurement.zzmt r1 = r15.zzB(r6)
            r0 = r4
            r2 = r30
            r3 = r5
            r5 = r4
            r4 = r32
            r21 = r13
            r13 = r5
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzL(r14, r6, r13)
            goto L_0x0253
        L_0x0188:
            r21 = r13
            goto L_0x01f0
        L_0x018c:
            r6 = r2
            r11 = r20
            r5 = r22
            r0 = 2
            if (r1 != r0) goto L_0x01f0
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r18 & r0
            if (r0 != 0) goto L_0x019f
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzg(r12, r5, r9)
            goto L_0x01a3
        L_0x019f:
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzh(r12, r5, r9)
        L_0x01a3:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r3, r1)
            goto L_0x0253
        L_0x01aa:
            r6 = r2
            r11 = r20
            r5 = r22
            if (r1 != 0) goto L_0x01f0
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r5, r9)
            long r1 = r9.zzb
            r17 = 0
            int r1 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r1 == 0) goto L_0x01bf
            r13 = 1
            goto L_0x01c1
        L_0x01bf:
            r13 = r16
        L_0x01c1:
            com.google.android.gms.internal.measurement.zznu.zzm(r14, r3, r13)
            goto L_0x0253
        L_0x01c6:
            r6 = r2
            r11 = r20
            r5 = r22
            if (r1 != r0) goto L_0x01f0
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r5)
            r10.putInt(r14, r3, r0)
            int r0 = r5 + 4
            goto L_0x0253
        L_0x01d8:
            r6 = r2
            r11 = r20
            r5 = r22
            r0 = 1
            if (r1 != r0) goto L_0x01f0
            long r17 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r5)
            r0 = r10
            r1 = r29
            r13 = r5
            r2 = r3
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x0251
        L_0x01f0:
            r13 = r5
            goto L_0x0262
        L_0x01f3:
            r6 = r2
            r11 = r20
            r13 = r22
            if (r1 != 0) goto L_0x0262
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r3, r1)
            goto L_0x0253
        L_0x0204:
            r6 = r2
            r11 = r20
            r13 = r22
            if (r1 != 0) goto L_0x0262
            int r13 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r13, r9)
            long r1 = r9.zzb
            r0 = r10
            r17 = r1
            r1 = r29
            r2 = r3
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r7 | r8
            r2 = r6
            r1 = r11
            r0 = r13
            r3 = r21
        L_0x0223:
            r6 = r24
            r8 = -1
            r13 = r32
            goto L_0x025e
        L_0x0229:
            r6 = r2
            r11 = r20
            r13 = r22
            if (r1 != r0) goto L_0x0262
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zznu.zzp(r14, r3, r0)
            int r0 = r13 + 4
            goto L_0x0253
        L_0x023e:
            r6 = r2
            r11 = r20
            r13 = r22
            r0 = 1
            if (r1 != r0) goto L_0x0262
            long r0 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zznu.zzo(r14, r3, r0)
        L_0x0251:
            int r0 = r13 + 8
        L_0x0253:
            r5 = r7 | r8
            r13 = r32
            r2 = r6
            r1 = r11
            r3 = r21
            r6 = r24
            r8 = -1
        L_0x025e:
            r11 = r33
            goto L_0x001e
        L_0x0262:
            r12 = r6
        L_0x0263:
            r0 = r33
            r20 = r7
            r27 = r10
            r31 = r11
            r22 = r12
            r2 = r13
            r7 = r21
            r6 = r24
            r19 = -1
            goto L_0x038b
        L_0x0276:
            r12 = r2
            r18 = r7
            r8 = r20
            r13 = r22
            r0 = 27
            if (r11 != r0) goto L_0x02d8
            r0 = 2
            if (r1 != r0) goto L_0x02c9
            java.lang.Object r0 = r10.getObject(r14, r3)
            com.google.android.gms.internal.measurement.zzli r0 = (com.google.android.gms.internal.measurement.zzli) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02a1
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0299
            r1 = 10
            goto L_0x029a
        L_0x0299:
            int r1 = r1 + r1
        L_0x029a:
            com.google.android.gms.internal.measurement.zzli r0 = r0.zzd(r1)
            r10.putObject(r14, r3, r0)
        L_0x02a1:
            r7 = r0
            com.google.android.gms.internal.measurement.zzmt r0 = r15.zzB(r12)
            r1 = r21
            r2 = r30
            r3 = r13
            r4 = r32
            r20 = r5
            r5 = r7
            r24 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r32
            r11 = r33
            r1 = r8
            r2 = r12
            r5 = r20
            r3 = r21
            r6 = r24
            r8 = -1
            r12 = r30
            goto L_0x001e
        L_0x02c9:
            r20 = r5
            r24 = r6
            r31 = r8
            r27 = r10
            r22 = r12
            r15 = r13
            r19 = -1
            goto L_0x0363
        L_0x02d8:
            r20 = r5
            r24 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0335
            r7 = r18
            long r6 = (long) r7
            r0 = r28
            r5 = r1
            r1 = r29
            r2 = r30
            r25 = r3
            r3 = r13
            r4 = r32
            r18 = r5
            r5 = r21
            r22 = r6
            r6 = r8
            r7 = r18
            r31 = r8
            r19 = -1
            r8 = r12
            r27 = r10
            r9 = r22
            r15 = r33
            r22 = r12
            r15 = r13
            r12 = r25
            r14 = r34
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x032c
        L_0x0310:
            r15 = r28
            r14 = r29
            r12 = r30
            r1 = r31
            r13 = r32
            r11 = r33
            r9 = r34
            r8 = r19
            r5 = r20
            r3 = r21
            r2 = r22
            r6 = r24
        L_0x0328:
            r10 = r27
            goto L_0x001e
        L_0x032c:
            r2 = r0
            r7 = r21
            r6 = r24
            r0 = r33
            goto L_0x038b
        L_0x0335:
            r25 = r3
            r31 = r8
            r27 = r10
            r22 = r12
            r15 = r13
            r7 = r18
            r19 = -1
            r18 = r1
            r0 = 50
            if (r11 != r0) goto L_0x036b
            r8 = r18
            r0 = 2
            if (r8 != r0) goto L_0x0363
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r22
            r6 = r25
            r8 = r34
            int r0 = r0.zzq(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x032c
            goto L_0x0310
        L_0x0363:
            r0 = r33
            r2 = r15
            r7 = r21
            r6 = r24
            goto L_0x038b
        L_0x036b:
            r8 = r18
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r21
            r6 = r31
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r25
            r12 = r22
            r13 = r34
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x032c
            goto L_0x0310
        L_0x038b:
            if (r7 != r0) goto L_0x039a
            if (r0 == 0) goto L_0x039a
            r8 = r28
            r12 = r29
            r9 = r0
            r0 = r2
            r3 = r7
            r5 = r20
            goto L_0x0400
        L_0x039a:
            r8 = r28
            r9 = r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x03d0
            r10 = r34
            com.google.android.gms.internal.measurement.zzkn r0 = r10.zzd
            com.google.android.gms.internal.measurement.zzkn r1 = com.google.android.gms.internal.measurement.zzkn.zza
            if (r0 == r1) goto L_0x03cb
            com.google.android.gms.internal.measurement.zzmi r1 = r8.zzg
            r11 = r31
            com.google.android.gms.internal.measurement.zzkz r0 = r0.zzb(r1, r11)
            if (r0 != 0) goto L_0x03c5
            com.google.android.gms.internal.measurement.zznl r4 = zzd(r29)
            r0 = r7
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x03e5
        L_0x03c5:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.measurement.zzky r0 = (com.google.android.gms.internal.measurement.zzky) r0
            throw r17
        L_0x03cb:
            r12 = r29
            r11 = r31
            goto L_0x03d6
        L_0x03d0:
            r12 = r29
            r11 = r31
            r10 = r34
        L_0x03d6:
            com.google.android.gms.internal.measurement.zznl r4 = zzd(r29)
            r0 = r7
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzi(r0, r1, r2, r3, r4, r5)
        L_0x03e5:
            r13 = r32
            r3 = r7
            r15 = r8
            r1 = r11
            r14 = r12
            r8 = r19
            r5 = r20
            r2 = r22
            r12 = r30
            r11 = r9
            r9 = r10
            goto L_0x0328
        L_0x03f7:
            r20 = r5
            r24 = r6
            r27 = r10
            r9 = r11
            r12 = r14
            r8 = r15
        L_0x0400:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r1) goto L_0x040b
            long r6 = (long) r6
            r2 = r27
            r2.putInt(r12, r6, r5)
        L_0x040b:
            int r2 = r8.zzk
        L_0x040d:
            int r4 = r8.zzl
            if (r2 >= r4) goto L_0x0438
            int[] r4 = r8.zzj
            r4 = r4[r2]
            int[] r5 = r8.zzc
            r5 = r5[r4]
            int r5 = r8.zzy(r4)
            r5 = r5 & r1
            long r5 = (long) r5
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zznu.zzf(r12, r5)
            if (r5 != 0) goto L_0x0426
            goto L_0x042c
        L_0x0426:
            com.google.android.gms.internal.measurement.zzlf r6 = r8.zzA(r4)
            if (r6 != 0) goto L_0x042f
        L_0x042c:
            int r2 = r2 + 1
            goto L_0x040d
        L_0x042f:
            com.google.android.gms.internal.measurement.zzmc r5 = (com.google.android.gms.internal.measurement.zzmc) r5
            java.lang.Object r0 = r8.zzC(r4)
            com.google.android.gms.internal.measurement.zzmb r0 = (com.google.android.gms.internal.measurement.zzmb) r0
            throw r17
        L_0x0438:
            if (r9 != 0) goto L_0x0444
            r1 = r32
            if (r0 != r1) goto L_0x043f
            goto L_0x044a
        L_0x043f:
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.internal.measurement.zzll.zze()
            throw r0
        L_0x0444:
            r1 = r32
            if (r0 > r1) goto L_0x044b
            if (r3 != r9) goto L_0x044b
        L_0x044a:
            return r0
        L_0x044b:
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.internal.measurement.zzll.zze()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzjn):int");
    }

    public final Object zze() {
        return ((zzlb) this.zzg).zzbD();
    }

    public final void zzf(Object obj) {
        if (zzS(obj)) {
            if (obj instanceof zzlb) {
                zzlb zzlb = (zzlb) obj;
                zzlb.zzbP(Integer.MAX_VALUE);
                zzlb.zzb = 0;
                zzlb.zzbN();
            }
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int zzy = zzy(i11);
                int i12 = 1048575 & zzy;
                int zzx = zzx(zzy);
                long j11 = (long) i12;
                if (zzx != 9) {
                    if (zzx == 60 || zzx == 68) {
                        if (zzT(obj, this.zzc[i11], i11)) {
                            zzB(i11).zzf(zzb.getObject(obj, j11));
                        }
                    } else {
                        switch (zzx) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.zzm.zza(obj, j11);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j11);
                                if (object != null) {
                                    ((zzmc) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzP(obj, i11)) {
                    zzB(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzg(obj);
            if (this.zzh) {
                this.zzo.zzb(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzG(obj);
        Objects.requireNonNull(obj2);
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzy = zzy(i11);
            int i12 = this.zzc[i11];
            long j11 = (long) (1048575 & zzy);
            switch (zzx(zzy)) {
                case 0:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzo(obj, j11, zznu.zza(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 1:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzp(obj, j11, zznu.zzb(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 2:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzr(obj, j11, zznu.zzd(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 3:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzr(obj, j11, zznu.zzd(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 4:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzq(obj, j11, zznu.zzc(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 5:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzr(obj, j11, zznu.zzd(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 6:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzq(obj, j11, zznu.zzc(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 7:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzm(obj, j11, zznu.zzw(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 8:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzs(obj, j11, zznu.zzf(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 9:
                    zzH(obj, obj2, i11);
                    break;
                case 10:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzs(obj, j11, zznu.zzf(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 11:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzq(obj, j11, zznu.zzc(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 12:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzq(obj, j11, zznu.zzc(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 13:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzq(obj, j11, zznu.zzc(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 14:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzr(obj, j11, zznu.zzd(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 15:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzq(obj, j11, zznu.zzc(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 16:
                    if (!zzP(obj2, i11)) {
                        break;
                    } else {
                        zznu.zzr(obj, j11, zznu.zzd(obj2, j11));
                        zzJ(obj, i11);
                        break;
                    }
                case 17:
                    zzH(obj, obj2, i11);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzm.zzb(obj, obj2, j11);
                    break;
                case 50:
                    int i13 = zzmv.zza;
                    zznu.zzs(obj, j11, zzmd.zzb(zznu.zzf(obj, j11), zznu.zzf(obj2, j11)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzT(obj2, i12, i11)) {
                        break;
                    } else {
                        zznu.zzs(obj, j11, zznu.zzf(obj2, j11));
                        zzK(obj, i12, i11);
                        break;
                    }
                case 60:
                    zzI(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzT(obj2, i12, i11)) {
                        break;
                    } else {
                        zznu.zzs(obj, j11, zznu.zzf(obj2, j11));
                        zzK(obj, i12, i11);
                        break;
                    }
                case 68:
                    zzI(obj, obj2, i11);
                    break;
            }
        }
        zzmv.zzB(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02fd, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0329, code lost:
        if (r0 != r14) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x034c, code lost:
        if (r0 != r14) goto L_0x02ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0115, code lost:
        r6 = r6 | r10;
        r13 = r34;
        r9 = r7;
        r2 = r15;
        r7 = r20;
        r1 = r23;
        r8 = 1048575;
        r10 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x014c, code lost:
        r13 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x021c, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0239, code lost:
        r6 = r6 | r10;
        r9 = r7;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x023c, code lost:
        r8 = r19;
        r7 = r20;
        r1 = r23;
        r10 = -1;
        r15 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0244, code lost:
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0248, code lost:
        r2 = r4;
        r29 = r7;
        r7 = r20;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e8, code lost:
        if (r0 != r24) goto L_0x02ea;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.measurement.zzjn r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzi
            if (r0 == 0) goto L_0x0390
            zzG(r31)
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r7 = r8
            r1 = r10
            r2 = r16
            r6 = r2
        L_0x0020:
            if (r0 >= r13) goto L_0x0375
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0032
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0035
        L_0x0032:
            r17 = r0
            r4 = r3
        L_0x0035:
            int r5 = r17 >>> 3
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zzu(r5, r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzt(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r23 = r5
            r29 = r9
            r18 = r10
            r15 = r16
            goto L_0x034f
        L_0x0052:
            r3 = r17 & 7
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = zzx(r1)
            r10 = r1 & r8
            r19 = r9
            long r8 = (long) r10
            r10 = 17
            r33 = r5
            if (r13 > r10) goto L_0x0251
            int r10 = r2 + 2
            r0 = r0[r10]
            int r10 = r0 >>> 20
            r5 = 1
            int r10 = r5 << r10
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r15
            r22 = r1
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r15) goto L_0x0085
            long r1 = (long) r7
            r7 = r19
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r19
        L_0x0087:
            if (r0 == r15) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r19
        L_0x0094:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x021f;
                case 1: goto L_0x0204;
                case 2: goto L_0x01e4;
                case 3: goto L_0x01e4;
                case 4: goto L_0x01cd;
                case 5: goto L_0x01ae;
                case 6: goto L_0x0198;
                case 7: goto L_0x0177;
                case 8: goto L_0x0153;
                case 9: goto L_0x0124;
                case 10: goto L_0x0102;
                case 11: goto L_0x01cd;
                case 12: goto L_0x00ef;
                case 13: goto L_0x0198;
                case 14: goto L_0x01ae;
                case 15: goto L_0x00d8;
                case 16: goto L_0x00a5;
                default: goto L_0x0098;
            }
        L_0x0098:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            goto L_0x0248
        L_0x00a5:
            if (r3 != 0) goto L_0x00cf
            int r13 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r4 = com.google.android.gms.internal.measurement.zzke.zzc(r0)
            r0 = r2
            r1 = r31
            r15 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r23 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r10
            r9 = r7
            r0 = r13
            r2 = r15
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            r15 = r30
            goto L_0x0244
        L_0x00cf:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            goto L_0x014c
        L_0x00d8:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzke.zzb(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0115
        L_0x00ef:
            r23 = r33
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x014c
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0115
        L_0x0102:
            r23 = r33
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x014c
            int r0 = com.google.android.gms.internal.measurement.zzjo.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
        L_0x0115:
            r6 = r6 | r10
            r13 = r34
            r9 = r7
            r2 = r15
            r7 = r20
            r1 = r23
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x0371
        L_0x0124:
            r23 = r33
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x014c
            r13 = r30
            r19 = 1048575(0xfffff, float:1.469367E-39)
            java.lang.Object r8 = r13.zzD(r14, r15)
            com.google.android.gms.internal.measurement.zzmt r1 = r13.zzB(r15)
            r0 = r8
            r2 = r32
            r3 = r4
            r4 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzo(r0, r1, r2, r3, r4, r5)
            r13.zzL(r14, r15, r8)
            goto L_0x0239
        L_0x014c:
            r13 = r30
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0248
        L_0x0153:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r0 = 2
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0248
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r22 & r0
            if (r0 != 0) goto L_0x016c
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzg(r12, r4, r11)
            goto L_0x0170
        L_0x016c:
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzh(r12, r4, r11)
        L_0x0170:
            java.lang.Object r1 = r11.zzc
            r7.putObject(r14, r8, r1)
            goto L_0x0239
        L_0x0177:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0248
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0191
            goto L_0x0193
        L_0x0191:
            r5 = r16
        L_0x0193:
            com.google.android.gms.internal.measurement.zznu.zzm(r14, r8, r5)
            goto L_0x0239
        L_0x0198:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0248
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r4)
            r7.putInt(r14, r8, r0)
            goto L_0x021c
        L_0x01ae:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != r5) goto L_0x0248
            long r21 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0239
        L_0x01cd:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0248
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzj(r12, r4, r11)
            int r1 = r11.zza
            r7.putInt(r14, r8, r1)
            goto L_0x0239
        L_0x01e4:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0248
            int r17 = com.google.android.gms.internal.measurement.zzjo.zzm(r12, r4, r11)
            long r4 = r11.zzb
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r10
            r9 = r7
            r2 = r15
            r0 = r17
            goto L_0x023c
        L_0x0204:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0248
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.measurement.zznu.zzp(r14, r8, r0)
        L_0x021c:
            int r0 = r4 + 4
            goto L_0x0239
        L_0x021f:
            r13 = r30
            r23 = r33
            r19 = r15
            r15 = r20
            r20 = r7
            r7 = r2
            if (r3 != r5) goto L_0x0248
            long r0 = com.google.android.gms.internal.measurement.zzjo.zzp(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.measurement.zznu.zzo(r14, r8, r0)
            int r0 = r4 + 8
        L_0x0239:
            r6 = r6 | r10
            r9 = r7
            r2 = r15
        L_0x023c:
            r8 = r19
            r7 = r20
            r1 = r23
            r10 = -1
            r15 = r13
        L_0x0244:
            r13 = r34
            goto L_0x0020
        L_0x0248:
            r2 = r4
            r29 = r7
            r7 = r20
            r18 = -1
            goto L_0x034f
        L_0x0251:
            r23 = r33
            r22 = r1
            r20 = r7
            r10 = r15
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r2
            r0 = 27
            if (r13 != r0) goto L_0x02af
            r0 = 2
            if (r3 != r0) goto L_0x02a4
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzli r0 = (com.google.android.gms.internal.measurement.zzli) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0282
            int r1 = r0.size()
            if (r1 != 0) goto L_0x027a
            r1 = 10
            goto L_0x027b
        L_0x027a:
            int r1 = r1 + r1
        L_0x027b:
            com.google.android.gms.internal.measurement.zzli r0 = r0.zzd(r1)
            r7.putObject(r14, r8, r0)
        L_0x0282:
            r5 = r0
            com.google.android.gms.internal.measurement.zzmt r0 = r10.zzB(r15)
            r1 = r17
            r2 = r32
            r3 = r4
            r4 = r34
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzjo.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r34
            r9 = r7
            r6 = r8
            r2 = r15
            r8 = r19
            r7 = r20
            r1 = r23
            r15 = r10
            r10 = -1
            goto L_0x0020
        L_0x02a4:
            r14 = r4
            r25 = r6
            r29 = r7
            r26 = r20
            r18 = -1
            goto L_0x032c
        L_0x02af:
            r0 = 49
            if (r13 > r0) goto L_0x02ff
            r1 = r22
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r5 = r3
            r3 = r4
            r24 = r4
            r4 = r34
            r33 = r5
            r5 = r17
            r25 = r6
            r6 = r23
            r26 = r20
            r20 = r7
            r7 = r33
            r27 = r8
            r9 = r19
            r8 = r15
            r29 = r20
            r18 = -1
            r9 = r21
            r11 = r13
            r12 = r27
            r14 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r24
            if (r0 == r14) goto L_0x02fd
        L_0x02ea:
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r15
            r10 = r18
            r1 = r23
            r6 = r25
            r7 = r26
            goto L_0x036c
        L_0x02fd:
            r2 = r0
            goto L_0x032d
        L_0x02ff:
            r33 = r3
            r14 = r4
            r25 = r6
            r29 = r7
            r27 = r8
            r26 = r20
            r1 = r22
            r18 = -1
            r0 = 50
            if (r13 != r0) goto L_0x0332
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x032c
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r14
            r4 = r34
            r5 = r15
            r6 = r27
            r8 = r35
            int r0 = r0.zzq(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x02fd
            goto L_0x02ea
        L_0x032c:
            r2 = r14
        L_0x032d:
            r6 = r25
            r7 = r26
            goto L_0x034f
        L_0x0332:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r14
            r4 = r34
            r5 = r17
            r6 = r23
            r9 = r13
            r10 = r27
            r12 = r15
            r13 = r35
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02fd
            goto L_0x02ea
        L_0x034f:
            com.google.android.gms.internal.measurement.zznl r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzjo.zzi(r0, r1, r2, r3, r4, r5)
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r15
            r10 = r18
            r1 = r23
        L_0x036c:
            r9 = r29
            r8 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0371:
            r15 = r30
            goto L_0x0020
        L_0x0375:
            r25 = r6
            r1 = r8
            r29 = r9
            if (r7 == r1) goto L_0x0386
            long r1 = (long) r7
            r3 = r31
            r6 = r25
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x0386:
            r4 = r34
            if (r0 != r4) goto L_0x038b
            return
        L_0x038b:
            com.google.android.gms.internal.measurement.zzll r0 = com.google.android.gms.internal.measurement.zzll.zze()
            throw r0
        L_0x0390:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zzc(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzh(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzjn):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0499, code lost:
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x06f3, code lost:
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x08a4, code lost:
        r8 = r8 + 3;
        r6 = r14;
        r7 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(java.lang.Object r17, com.google.android.gms.internal.measurement.zzoc r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzi
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            if (r3 == 0) goto L_0x0462
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045c
            int[] r3 = r0.zzc
            int r3 = r3.length
            r4 = r6
        L_0x0018:
            if (r4 >= r3) goto L_0x0452
            int r8 = r0.zzy(r4)
            int[] r9 = r0.zzc
            r9 = r9[r4]
            int r10 = zzx(r8)
            switch(r10) {
                case 0: goto L_0x043f;
                case 1: goto L_0x042f;
                case 2: goto L_0x041f;
                case 3: goto L_0x040f;
                case 4: goto L_0x03ff;
                case 5: goto L_0x03ef;
                case 6: goto L_0x03df;
                case 7: goto L_0x03ce;
                case 8: goto L_0x03bd;
                case 9: goto L_0x03a8;
                case 10: goto L_0x0395;
                case 11: goto L_0x0384;
                case 12: goto L_0x0373;
                case 13: goto L_0x0362;
                case 14: goto L_0x0351;
                case 15: goto L_0x0340;
                case 16: goto L_0x032f;
                case 17: goto L_0x031a;
                case 18: goto L_0x030d;
                case 19: goto L_0x0300;
                case 20: goto L_0x02f3;
                case 21: goto L_0x02e6;
                case 22: goto L_0x02d9;
                case 23: goto L_0x02cc;
                case 24: goto L_0x02bf;
                case 25: goto L_0x02b2;
                case 26: goto L_0x02a5;
                case 27: goto L_0x0294;
                case 28: goto L_0x0287;
                case 29: goto L_0x027a;
                case 30: goto L_0x026d;
                case 31: goto L_0x0260;
                case 32: goto L_0x0253;
                case 33: goto L_0x0246;
                case 34: goto L_0x0239;
                case 35: goto L_0x022c;
                case 36: goto L_0x021f;
                case 37: goto L_0x0212;
                case 38: goto L_0x0205;
                case 39: goto L_0x01f8;
                case 40: goto L_0x01eb;
                case 41: goto L_0x01de;
                case 42: goto L_0x01d1;
                case 43: goto L_0x01c4;
                case 44: goto L_0x01b7;
                case 45: goto L_0x01aa;
                case 46: goto L_0x019d;
                case 47: goto L_0x0190;
                case 48: goto L_0x0183;
                case 49: goto L_0x0172;
                case 50: goto L_0x0167;
                case 51: goto L_0x0156;
                case 52: goto L_0x0145;
                case 53: goto L_0x0134;
                case 54: goto L_0x0123;
                case 55: goto L_0x0112;
                case 56: goto L_0x0101;
                case 57: goto L_0x00f0;
                case 58: goto L_0x00df;
                case 59: goto L_0x00ce;
                case 60: goto L_0x00b9;
                case 61: goto L_0x00a6;
                case 62: goto L_0x0095;
                case 63: goto L_0x0084;
                case 64: goto L_0x0073;
                case 65: goto L_0x0062;
                case 66: goto L_0x0051;
                case 67: goto L_0x0040;
                case 68: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x044e
        L_0x002b:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            com.google.android.gms.internal.measurement.zzmt r10 = r0.zzB(r4)
            r2.zzq(r9, r8, r10)
            goto L_0x044e
        L_0x0040:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = zzz(r1, r10)
            r2.zzC(r9, r10)
            goto L_0x044e
        L_0x0051:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = zzp(r1, r10)
            r2.zzA(r9, r8)
            goto L_0x044e
        L_0x0062:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = zzz(r1, r10)
            r2.zzy(r9, r10)
            goto L_0x044e
        L_0x0073:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = zzp(r1, r10)
            r2.zzw(r9, r8)
            goto L_0x044e
        L_0x0084:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = zzp(r1, r10)
            r2.zzi(r9, r8)
            goto L_0x044e
        L_0x0095:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = zzp(r1, r10)
            r2.zzH(r9, r8)
            goto L_0x044e
        L_0x00a6:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            com.google.android.gms.internal.measurement.zzka r8 = (com.google.android.gms.internal.measurement.zzka) r8
            r2.zzd(r9, r8)
            goto L_0x044e
        L_0x00b9:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            com.google.android.gms.internal.measurement.zzmt r10 = r0.zzB(r4)
            r2.zzv(r9, r8, r10)
            goto L_0x044e
        L_0x00ce:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            zzV(r9, r8, r2)
            goto L_0x044e
        L_0x00df:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            boolean r8 = zzU(r1, r10)
            r2.zzb(r9, r8)
            goto L_0x044e
        L_0x00f0:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = zzp(r1, r10)
            r2.zzk(r9, r8)
            goto L_0x044e
        L_0x0101:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = zzz(r1, r10)
            r2.zzm(r9, r10)
            goto L_0x044e
        L_0x0112:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = zzp(r1, r10)
            r2.zzr(r9, r8)
            goto L_0x044e
        L_0x0123:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = zzz(r1, r10)
            r2.zzJ(r9, r10)
            goto L_0x044e
        L_0x0134:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = zzz(r1, r10)
            r2.zzt(r9, r10)
            goto L_0x044e
        L_0x0145:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            float r8 = zzn(r1, r10)
            r2.zzo(r9, r8)
            goto L_0x044e
        L_0x0156:
            boolean r10 = r0.zzT(r1, r9, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            double r10 = zzm(r1, r10)
            r2.zzf(r9, r10)
            goto L_0x044e
        L_0x0167:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            r0.zzN(r2, r9, r8, r4)
            goto L_0x044e
        L_0x0172:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmt r10 = r0.zzB(r4)
            com.google.android.gms.internal.measurement.zzmv.zzK(r9, r8, r2, r10)
            goto L_0x044e
        L_0x0183:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzR(r9, r8, r2, r5)
            goto L_0x044e
        L_0x0190:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzQ(r9, r8, r2, r5)
            goto L_0x044e
        L_0x019d:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzP(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01aa:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzO(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01b7:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzG(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01c4:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzT(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01d1:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzD(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01de:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzH(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01eb:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzI(r9, r8, r2, r5)
            goto L_0x044e
        L_0x01f8:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzL(r9, r8, r2, r5)
            goto L_0x044e
        L_0x0205:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzU(r9, r8, r2, r5)
            goto L_0x044e
        L_0x0212:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzM(r9, r8, r2, r5)
            goto L_0x044e
        L_0x021f:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzJ(r9, r8, r2, r5)
            goto L_0x044e
        L_0x022c:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzF(r9, r8, r2, r5)
            goto L_0x044e
        L_0x0239:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzR(r9, r8, r2, r6)
            goto L_0x044e
        L_0x0246:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzQ(r9, r8, r2, r6)
            goto L_0x044e
        L_0x0253:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzP(r9, r8, r2, r6)
            goto L_0x044e
        L_0x0260:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzO(r9, r8, r2, r6)
            goto L_0x044e
        L_0x026d:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzG(r9, r8, r2, r6)
            goto L_0x044e
        L_0x027a:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzT(r9, r8, r2, r6)
            goto L_0x044e
        L_0x0287:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzE(r9, r8, r2)
            goto L_0x044e
        L_0x0294:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmt r10 = r0.zzB(r4)
            com.google.android.gms.internal.measurement.zzmv.zzN(r9, r8, r2, r10)
            goto L_0x044e
        L_0x02a5:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzS(r9, r8, r2)
            goto L_0x044e
        L_0x02b2:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzD(r9, r8, r2, r6)
            goto L_0x044e
        L_0x02bf:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzH(r9, r8, r2, r6)
            goto L_0x044e
        L_0x02cc:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzI(r9, r8, r2, r6)
            goto L_0x044e
        L_0x02d9:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzL(r9, r8, r2, r6)
            goto L_0x044e
        L_0x02e6:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzU(r9, r8, r2, r6)
            goto L_0x044e
        L_0x02f3:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzM(r9, r8, r2, r6)
            goto L_0x044e
        L_0x0300:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzJ(r9, r8, r2, r6)
            goto L_0x044e
        L_0x030d:
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzmv.zzF(r9, r8, r2, r6)
            goto L_0x044e
        L_0x031a:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            com.google.android.gms.internal.measurement.zzmt r10 = r0.zzB(r4)
            r2.zzq(r9, r8, r10)
            goto L_0x044e
        L_0x032f:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zznu.zzd(r1, r10)
            r2.zzC(r9, r10)
            goto L_0x044e
        L_0x0340:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zznu.zzc(r1, r10)
            r2.zzA(r9, r8)
            goto L_0x044e
        L_0x0351:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zznu.zzd(r1, r10)
            r2.zzy(r9, r10)
            goto L_0x044e
        L_0x0362:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zznu.zzc(r1, r10)
            r2.zzw(r9, r8)
            goto L_0x044e
        L_0x0373:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zznu.zzc(r1, r10)
            r2.zzi(r9, r8)
            goto L_0x044e
        L_0x0384:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zznu.zzc(r1, r10)
            r2.zzH(r9, r8)
            goto L_0x044e
        L_0x0395:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            com.google.android.gms.internal.measurement.zzka r8 = (com.google.android.gms.internal.measurement.zzka) r8
            r2.zzd(r9, r8)
            goto L_0x044e
        L_0x03a8:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            com.google.android.gms.internal.measurement.zzmt r10 = r0.zzB(r4)
            r2.zzv(r9, r8, r10)
            goto L_0x044e
        L_0x03bd:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zznu.zzf(r1, r10)
            zzV(r9, r8, r2)
            goto L_0x044e
        L_0x03ce:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zznu.zzw(r1, r10)
            r2.zzb(r9, r8)
            goto L_0x044e
        L_0x03df:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zznu.zzc(r1, r10)
            r2.zzk(r9, r8)
            goto L_0x044e
        L_0x03ef:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zznu.zzd(r1, r10)
            r2.zzm(r9, r10)
            goto L_0x044e
        L_0x03ff:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zznu.zzc(r1, r10)
            r2.zzr(r9, r8)
            goto L_0x044e
        L_0x040f:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zznu.zzd(r1, r10)
            r2.zzJ(r9, r10)
            goto L_0x044e
        L_0x041f:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zznu.zzd(r1, r10)
            r2.zzt(r9, r10)
            goto L_0x044e
        L_0x042f:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zznu.zzb(r1, r10)
            r2.zzo(r9, r8)
            goto L_0x044e
        L_0x043f:
            boolean r10 = r0.zzP(r1, r4)
            if (r10 == 0) goto L_0x044e
            r8 = r8 & r7
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zznu.zza(r1, r10)
            r2.zzf(r9, r10)
        L_0x044e:
            int r4 = r4 + 3
            goto L_0x0018
        L_0x0452:
            com.google.android.gms.internal.measurement.zznk r3 = r0.zzn
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzi(r1, r2)
            return
        L_0x045c:
            com.google.android.gms.internal.measurement.zzko r2 = r0.zzo
            r2.zza(r1)
            throw r4
        L_0x0462:
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x08b6
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r8 = r6
            r10 = r8
            r9 = r7
        L_0x046e:
            if (r8 >= r3) goto L_0x08ac
            int r11 = r0.zzy(r8)
            int[] r12 = r0.zzc
            r13 = r12[r8]
            int r14 = zzx(r11)
            r15 = 17
            if (r14 > r15) goto L_0x0493
            int r15 = r8 + 2
            r12 = r12[r15]
            r15 = r12 & r7
            if (r15 == r9) goto L_0x048e
            long r9 = (long) r15
            int r10 = r4.getInt(r1, r9)
            r9 = r15
        L_0x048e:
            int r12 = r12 >>> 20
            int r12 = r5 << r12
            goto L_0x0494
        L_0x0493:
            r12 = r6
        L_0x0494:
            r11 = r11 & r7
            long r6 = (long) r11
            switch(r14) {
                case 0: goto L_0x0898;
                case 1: goto L_0x088b;
                case 2: goto L_0x087e;
                case 3: goto L_0x0871;
                case 4: goto L_0x0864;
                case 5: goto L_0x0857;
                case 6: goto L_0x084a;
                case 7: goto L_0x083d;
                case 8: goto L_0x082f;
                case 9: goto L_0x081d;
                case 10: goto L_0x080d;
                case 11: goto L_0x07ff;
                case 12: goto L_0x07f1;
                case 13: goto L_0x07e3;
                case 14: goto L_0x07d5;
                case 15: goto L_0x07c7;
                case 16: goto L_0x07b9;
                case 17: goto L_0x07a7;
                case 18: goto L_0x0797;
                case 19: goto L_0x0787;
                case 20: goto L_0x0777;
                case 21: goto L_0x0767;
                case 22: goto L_0x0757;
                case 23: goto L_0x0747;
                case 24: goto L_0x0737;
                case 25: goto L_0x0727;
                case 26: goto L_0x0718;
                case 27: goto L_0x0705;
                case 28: goto L_0x06f6;
                case 29: goto L_0x06e5;
                case 30: goto L_0x06d6;
                case 31: goto L_0x06c7;
                case 32: goto L_0x06b8;
                case 33: goto L_0x06a9;
                case 34: goto L_0x069a;
                case 35: goto L_0x068b;
                case 36: goto L_0x067c;
                case 37: goto L_0x066d;
                case 38: goto L_0x065e;
                case 39: goto L_0x064f;
                case 40: goto L_0x0640;
                case 41: goto L_0x0631;
                case 42: goto L_0x0622;
                case 43: goto L_0x0613;
                case 44: goto L_0x0604;
                case 45: goto L_0x05f5;
                case 46: goto L_0x05e6;
                case 47: goto L_0x05d7;
                case 48: goto L_0x05c8;
                case 49: goto L_0x05b5;
                case 50: goto L_0x05ac;
                case 51: goto L_0x059d;
                case 52: goto L_0x058e;
                case 53: goto L_0x057f;
                case 54: goto L_0x0570;
                case 55: goto L_0x0561;
                case 56: goto L_0x0552;
                case 57: goto L_0x0543;
                case 58: goto L_0x0534;
                case 59: goto L_0x0525;
                case 60: goto L_0x0512;
                case 61: goto L_0x0502;
                case 62: goto L_0x04f4;
                case 63: goto L_0x04e6;
                case 64: goto L_0x04d8;
                case 65: goto L_0x04ca;
                case 66: goto L_0x04bc;
                case 67: goto L_0x04ae;
                case 68: goto L_0x049c;
                default: goto L_0x0499;
            }
        L_0x0499:
            r14 = 0
            goto L_0x08a4
        L_0x049c:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            java.lang.Object r6 = r4.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzmt r7 = r0.zzB(r8)
            r2.zzq(r13, r6, r7)
            goto L_0x0499
        L_0x04ae:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            long r6 = zzz(r1, r6)
            r2.zzC(r13, r6)
            goto L_0x0499
        L_0x04bc:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            int r6 = zzp(r1, r6)
            r2.zzA(r13, r6)
            goto L_0x0499
        L_0x04ca:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            long r6 = zzz(r1, r6)
            r2.zzy(r13, r6)
            goto L_0x0499
        L_0x04d8:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            int r6 = zzp(r1, r6)
            r2.zzw(r13, r6)
            goto L_0x0499
        L_0x04e6:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            int r6 = zzp(r1, r6)
            r2.zzi(r13, r6)
            goto L_0x0499
        L_0x04f4:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            int r6 = zzp(r1, r6)
            r2.zzH(r13, r6)
            goto L_0x0499
        L_0x0502:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            java.lang.Object r6 = r4.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzka r6 = (com.google.android.gms.internal.measurement.zzka) r6
            r2.zzd(r13, r6)
            goto L_0x0499
        L_0x0512:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            java.lang.Object r6 = r4.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzmt r7 = r0.zzB(r8)
            r2.zzv(r13, r6, r7)
            goto L_0x0499
        L_0x0525:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            java.lang.Object r6 = r4.getObject(r1, r6)
            zzV(r13, r6, r2)
            goto L_0x0499
        L_0x0534:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            boolean r6 = zzU(r1, r6)
            r2.zzb(r13, r6)
            goto L_0x0499
        L_0x0543:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            int r6 = zzp(r1, r6)
            r2.zzk(r13, r6)
            goto L_0x0499
        L_0x0552:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            long r6 = zzz(r1, r6)
            r2.zzm(r13, r6)
            goto L_0x0499
        L_0x0561:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            int r6 = zzp(r1, r6)
            r2.zzr(r13, r6)
            goto L_0x0499
        L_0x0570:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            long r6 = zzz(r1, r6)
            r2.zzJ(r13, r6)
            goto L_0x0499
        L_0x057f:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            long r6 = zzz(r1, r6)
            r2.zzt(r13, r6)
            goto L_0x0499
        L_0x058e:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            float r6 = zzn(r1, r6)
            r2.zzo(r13, r6)
            goto L_0x0499
        L_0x059d:
            boolean r11 = r0.zzT(r1, r13, r8)
            if (r11 == 0) goto L_0x0499
            double r6 = zzm(r1, r6)
            r2.zzf(r13, r6)
            goto L_0x0499
        L_0x05ac:
            java.lang.Object r6 = r4.getObject(r1, r6)
            r0.zzN(r2, r13, r6, r8)
            goto L_0x0499
        L_0x05b5:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmt r7 = r0.zzB(r8)
            com.google.android.gms.internal.measurement.zzmv.zzK(r11, r6, r2, r7)
            goto L_0x0499
        L_0x05c8:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzR(r11, r6, r2, r5)
            goto L_0x0499
        L_0x05d7:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzQ(r11, r6, r2, r5)
            goto L_0x0499
        L_0x05e6:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzP(r11, r6, r2, r5)
            goto L_0x0499
        L_0x05f5:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzO(r11, r6, r2, r5)
            goto L_0x0499
        L_0x0604:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzG(r11, r6, r2, r5)
            goto L_0x0499
        L_0x0613:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzT(r11, r6, r2, r5)
            goto L_0x0499
        L_0x0622:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzD(r11, r6, r2, r5)
            goto L_0x0499
        L_0x0631:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzH(r11, r6, r2, r5)
            goto L_0x0499
        L_0x0640:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzI(r11, r6, r2, r5)
            goto L_0x0499
        L_0x064f:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzL(r11, r6, r2, r5)
            goto L_0x0499
        L_0x065e:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzU(r11, r6, r2, r5)
            goto L_0x0499
        L_0x066d:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzM(r11, r6, r2, r5)
            goto L_0x0499
        L_0x067c:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzJ(r11, r6, r2, r5)
            goto L_0x0499
        L_0x068b:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzF(r11, r6, r2, r5)
            goto L_0x0499
        L_0x069a:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            r12 = 0
            com.google.android.gms.internal.measurement.zzmv.zzR(r11, r6, r2, r12)
            goto L_0x06f3
        L_0x06a9:
            r12 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzQ(r11, r6, r2, r12)
            goto L_0x06f3
        L_0x06b8:
            r12 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzP(r11, r6, r2, r12)
            goto L_0x06f3
        L_0x06c7:
            r12 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzO(r11, r6, r2, r12)
            goto L_0x06f3
        L_0x06d6:
            r12 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzG(r11, r6, r2, r12)
            goto L_0x06f3
        L_0x06e5:
            r12 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzT(r11, r6, r2, r12)
        L_0x06f3:
            r14 = r12
            goto L_0x08a4
        L_0x06f6:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzE(r11, r6, r2)
            goto L_0x0499
        L_0x0705:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmt r7 = r0.zzB(r8)
            com.google.android.gms.internal.measurement.zzmv.zzN(r11, r6, r2, r7)
            goto L_0x0499
        L_0x0718:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzS(r11, r6, r2)
            goto L_0x0499
        L_0x0727:
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            r14 = 0
            com.google.android.gms.internal.measurement.zzmv.zzD(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0737:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzH(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0747:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzI(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0757:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzL(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0767:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzU(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0777:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzM(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0787:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzJ(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x0797:
            r14 = 0
            int[] r11 = r0.zzc
            r11 = r11[r8]
            java.lang.Object r6 = r4.getObject(r1, r6)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.measurement.zzmv.zzF(r11, r6, r2, r14)
            goto L_0x08a4
        L_0x07a7:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            java.lang.Object r6 = r4.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzmt r7 = r0.zzB(r8)
            r2.zzq(r13, r6, r7)
            goto L_0x08a4
        L_0x07b9:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            long r6 = r4.getLong(r1, r6)
            r2.zzC(r13, r6)
            goto L_0x08a4
        L_0x07c7:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            int r6 = r4.getInt(r1, r6)
            r2.zzA(r13, r6)
            goto L_0x08a4
        L_0x07d5:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            long r6 = r4.getLong(r1, r6)
            r2.zzy(r13, r6)
            goto L_0x08a4
        L_0x07e3:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            int r6 = r4.getInt(r1, r6)
            r2.zzw(r13, r6)
            goto L_0x08a4
        L_0x07f1:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            int r6 = r4.getInt(r1, r6)
            r2.zzi(r13, r6)
            goto L_0x08a4
        L_0x07ff:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            int r6 = r4.getInt(r1, r6)
            r2.zzH(r13, r6)
            goto L_0x08a4
        L_0x080d:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            java.lang.Object r6 = r4.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzka r6 = (com.google.android.gms.internal.measurement.zzka) r6
            r2.zzd(r13, r6)
            goto L_0x08a4
        L_0x081d:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            java.lang.Object r6 = r4.getObject(r1, r6)
            com.google.android.gms.internal.measurement.zzmt r7 = r0.zzB(r8)
            r2.zzv(r13, r6, r7)
            goto L_0x08a4
        L_0x082f:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            java.lang.Object r6 = r4.getObject(r1, r6)
            zzV(r13, r6, r2)
            goto L_0x08a4
        L_0x083d:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            boolean r6 = com.google.android.gms.internal.measurement.zznu.zzw(r1, r6)
            r2.zzb(r13, r6)
            goto L_0x08a4
        L_0x084a:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            int r6 = r4.getInt(r1, r6)
            r2.zzk(r13, r6)
            goto L_0x08a4
        L_0x0857:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            long r6 = r4.getLong(r1, r6)
            r2.zzm(r13, r6)
            goto L_0x08a4
        L_0x0864:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            int r6 = r4.getInt(r1, r6)
            r2.zzr(r13, r6)
            goto L_0x08a4
        L_0x0871:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            long r6 = r4.getLong(r1, r6)
            r2.zzJ(r13, r6)
            goto L_0x08a4
        L_0x087e:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            long r6 = r4.getLong(r1, r6)
            r2.zzt(r13, r6)
            goto L_0x08a4
        L_0x088b:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            float r6 = com.google.android.gms.internal.measurement.zznu.zzb(r1, r6)
            r2.zzo(r13, r6)
            goto L_0x08a4
        L_0x0898:
            r14 = 0
            r11 = r10 & r12
            if (r11 == 0) goto L_0x08a4
            double r6 = com.google.android.gms.internal.measurement.zznu.zza(r1, r6)
            r2.zzf(r13, r6)
        L_0x08a4:
            int r8 = r8 + 3
            r6 = r14
            r7 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x046e
        L_0x08ac:
            com.google.android.gms.internal.measurement.zznk r3 = r0.zzn
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzi(r1, r2)
            return
        L_0x08b6:
            com.google.android.gms.internal.measurement.zzko r2 = r0.zzo
            r2.zza(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzml.zzi(java.lang.Object, com.google.android.gms.internal.measurement.zzoc):void");
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z11;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int zzy = zzy(i11);
            long j11 = (long) (zzy & 1048575);
            switch (zzx(zzy)) {
                case 0:
                    if (zzO(obj, obj2, i11) && Double.doubleToLongBits(zznu.zza(obj, j11)) == Double.doubleToLongBits(zznu.zza(obj2, j11))) {
                        continue;
                    }
                case 1:
                    if (zzO(obj, obj2, i11) && Float.floatToIntBits(zznu.zzb(obj, j11)) == Float.floatToIntBits(zznu.zzb(obj2, j11))) {
                        continue;
                    }
                case 2:
                    if (zzO(obj, obj2, i11) && zznu.zzd(obj, j11) == zznu.zzd(obj2, j11)) {
                        continue;
                    }
                case 3:
                    if (zzO(obj, obj2, i11) && zznu.zzd(obj, j11) == zznu.zzd(obj2, j11)) {
                        continue;
                    }
                case 4:
                    if (zzO(obj, obj2, i11) && zznu.zzc(obj, j11) == zznu.zzc(obj2, j11)) {
                        continue;
                    }
                case 5:
                    if (zzO(obj, obj2, i11) && zznu.zzd(obj, j11) == zznu.zzd(obj2, j11)) {
                        continue;
                    }
                case 6:
                    if (zzO(obj, obj2, i11) && zznu.zzc(obj, j11) == zznu.zzc(obj2, j11)) {
                        continue;
                    }
                case 7:
                    if (zzO(obj, obj2, i11) && zznu.zzw(obj, j11) == zznu.zzw(obj2, j11)) {
                        continue;
                    }
                case 8:
                    if (zzO(obj, obj2, i11) && zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11))) {
                        continue;
                    }
                case 9:
                    if (zzO(obj, obj2, i11) && zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11))) {
                        continue;
                    }
                case 10:
                    if (zzO(obj, obj2, i11) && zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11))) {
                        continue;
                    }
                case 11:
                    if (zzO(obj, obj2, i11) && zznu.zzc(obj, j11) == zznu.zzc(obj2, j11)) {
                        continue;
                    }
                case 12:
                    if (zzO(obj, obj2, i11) && zznu.zzc(obj, j11) == zznu.zzc(obj2, j11)) {
                        continue;
                    }
                case 13:
                    if (zzO(obj, obj2, i11) && zznu.zzc(obj, j11) == zznu.zzc(obj2, j11)) {
                        continue;
                    }
                case 14:
                    if (zzO(obj, obj2, i11) && zznu.zzd(obj, j11) == zznu.zzd(obj2, j11)) {
                        continue;
                    }
                case 15:
                    if (zzO(obj, obj2, i11) && zznu.zzc(obj, j11) == zznu.zzc(obj2, j11)) {
                        continue;
                    }
                case 16:
                    if (zzO(obj, obj2, i11) && zznu.zzd(obj, j11) == zznu.zzd(obj2, j11)) {
                        continue;
                    }
                case 17:
                    if (zzO(obj, obj2, i11) && zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z11 = zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11));
                    break;
                case 50:
                    z11 = zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzv = (long) (zzv(i11) & 1048575);
                    if (zznu.zzc(obj, zzv) == zznu.zzc(obj2, zzv) && zzmv.zzV(zznu.zzf(obj, j11), zznu.zzf(obj2, j11))) {
                        continue;
                    }
            }
            if (!z11) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i11;
        int i12;
        Object obj2 = obj;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.zzk) {
            int i16 = this.zzj[i15];
            int i17 = this.zzc[i16];
            int zzy = zzy(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i21 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = zzb.getInt(obj2, (long) i19);
                }
                i11 = i14;
                i12 = i19;
            } else {
                i12 = i13;
                i11 = i14;
            }
            if ((268435456 & zzy) != 0 && !zzQ(obj, i16, i12, i11, i21)) {
                return false;
            }
            int zzx = zzx(zzy);
            if (zzx != 9 && zzx != 17) {
                if (zzx != 27) {
                    if (zzx == 60 || zzx == 68) {
                        if (zzT(obj2, i17, i16) && !zzR(obj2, zzy, zzB(i16))) {
                            return false;
                        }
                    } else if (zzx != 49) {
                        if (zzx == 50 && !((zzmc) zznu.zzf(obj2, (long) (zzy & 1048575))).isEmpty()) {
                            zzmb zzmb = (zzmb) zzC(i16);
                            throw null;
                        }
                    }
                }
                List list = (List) zznu.zzf(obj2, (long) (zzy & 1048575));
                if (!list.isEmpty()) {
                    zzmt zzB = zzB(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zzB.zzk(list.get(i22))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzQ(obj, i16, i12, i11, i21) && !zzR(obj2, zzy, zzB(i16))) {
                return false;
            }
            i15++;
            i13 = i12;
            i14 = i11;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }
}
