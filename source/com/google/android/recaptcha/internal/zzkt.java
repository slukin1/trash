package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzkt {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzll zzc;
    private static final zzll zzd = new zzln();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzll zzll = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzll = (zzll) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzll;
    }

    public static void zzA(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzu(i11, list, z11);
        }
    }

    public static void zzB(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzy(i11, list, z11);
        }
    }

    public static void zzC(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzA(i11, list, z11);
        }
    }

    public static void zzD(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzC(i11, list, z11);
        }
    }

    public static void zzE(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzE(i11, list, z11);
        }
    }

    public static void zzF(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzJ(i11, list, z11);
        }
    }

    public static void zzG(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzL(i11, list, z11);
        }
    }

    public static boolean zzH(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int zza(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzhh.zzu(zziu.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzhh.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzb(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhh.zzy(i11 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhh.zzy(i11 << 3) + 8);
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzhh.zzu(zziu.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzhh.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzg(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzhh.zzz(zzjt.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzhh.zzz(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzh(int i11, Object obj, zzkr zzkr) {
        int i12 = i11 << 3;
        if (obj instanceof zzjk) {
            int i13 = zzhh.zzb;
            int zza2 = ((zzjk) obj).zza();
            return zzhh.zzy(i12) + zzhh.zzy(zza2) + zza2;
        }
        return zzhh.zzy(i12) + zzhh.zzw((zzke) obj, zzkr);
    }

    public static int zzi(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zziu.zze(i12);
                i11 += zzhh.zzy((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = ((Integer) list.get(i12)).intValue();
                i13 = i11 + zzhh.zzy((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzj(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            i11 = 0;
            while (i12 < size) {
                long zze = zzjt.zze(i12);
                i11 += zzhh.zzz((zze >> 63) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = ((Long) list.get(i12)).longValue();
                i13 = i11 + zzhh.zzz((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzk(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzhh.zzy(zziu.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzhh.zzy(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzl(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzhh.zzz(zzjt.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzhh.zzz(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzll zzm() {
        return zzc;
    }

    public static zzll zzn() {
        return zzd;
    }

    public static Object zzo(Object obj, int i11, List list, zzix zzix, Object obj2, zzll zzll) {
        if (zzix == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = ((Integer) list.get(i13)).intValue();
                if (zzix.zza(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    obj2 = zzp(obj, i11, intValue, obj2, zzll);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return obj2;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Integer) it2.next()).intValue();
                if (!zzix.zza(intValue2)) {
                    obj2 = zzp(obj, i11, intValue2, obj2, zzll);
                    it2.remove();
                }
            }
        }
        return obj2;
    }

    public static Object zzp(Object obj, int i11, int i12, Object obj2, zzll zzll) {
        if (obj2 == null) {
            obj2 = zzll.zzc(obj);
        }
        zzll.zzl(obj2, i11, (long) i12);
        return obj2;
    }

    public static void zzq(zzif zzif, Object obj, Object obj2) {
        zzij zzb2 = zzif.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzif.zzc(obj).zzh(zzb2);
        }
    }

    public static void zzr(zzll zzll, Object obj, Object obj2) {
        zzll.zzo(obj, zzll.zze(zzll.zzd(obj), zzll.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzit.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzt(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzc(i11, list, z11);
        }
    }

    public static void zzu(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzg(i11, list, z11);
        }
    }

    public static void zzv(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzj(i11, list, z11);
        }
    }

    public static void zzw(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzl(i11, list, z11);
        }
    }

    public static void zzx(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzn(i11, list, z11);
        }
    }

    public static void zzy(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzp(i11, list, z11);
        }
    }

    public static void zzz(int i11, List list, zzmd zzmd, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzmd.zzs(i11, list, z11);
        }
    }
}
