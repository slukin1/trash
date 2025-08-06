package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

final class zzmv {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zznk zzc;
    private static final zznk zzd = new zznm();

    static {
        Class<?> cls;
        Class<?> cls2;
        zznk zznk = null;
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
                zznk = (zznk) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zznk;
    }

    public static Object zzA(Object obj, int i11, int i12, Object obj2, zznk zznk) {
        if (obj2 == null) {
            obj2 = zznk.zzc(obj);
        }
        zznk.zzf(obj2, i11, (long) i12);
        return obj2;
    }

    public static void zzB(zznk zznk, Object obj, Object obj2) {
        zznk.zzh(obj, zznk.zze(zznk.zzd(obj), zznk.zzd(obj2)));
    }

    public static void zzC(Class cls) {
        Class cls2;
        if (!zzlb.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzD(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzc(i11, list, z11);
        }
    }

    public static void zzE(int i11, List list, zzoc zzoc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zze(i11, list);
        }
    }

    public static void zzF(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzg(i11, list, z11);
        }
    }

    public static void zzG(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzj(i11, list, z11);
        }
    }

    public static void zzH(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzl(i11, list, z11);
        }
    }

    public static void zzI(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzn(i11, list, z11);
        }
    }

    public static void zzJ(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzp(i11, list, z11);
        }
    }

    public static void zzK(int i11, List list, zzoc zzoc, zzmt zzmt) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((zzkj) zzoc).zzq(i11, list.get(i12), zzmt);
            }
        }
    }

    public static void zzL(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzs(i11, list, z11);
        }
    }

    public static void zzM(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzu(i11, list, z11);
        }
    }

    public static void zzN(int i11, List list, zzoc zzoc, zzmt zzmt) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((zzkj) zzoc).zzv(i11, list.get(i12), zzmt);
            }
        }
    }

    public static void zzO(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzx(i11, list, z11);
        }
    }

    public static void zzP(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzz(i11, list, z11);
        }
    }

    public static void zzQ(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzB(i11, list, z11);
        }
    }

    public static void zzR(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzD(i11, list, z11);
        }
    }

    public static void zzS(int i11, List list, zzoc zzoc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzG(i11, list);
        }
    }

    public static void zzT(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzI(i11, list, z11);
        }
    }

    public static void zzU(int i11, List list, zzoc zzoc, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzoc.zzK(i11, list, z11);
        }
    }

    public static boolean zzV(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int zza(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i11 << 3) + 1);
    }

    public static int zzb(int i11, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = size * zzki.zzx(i11 << 3);
        for (int i12 = 0; i12 < list.size(); i12++) {
            int zzd2 = ((zzka) list.get(i12)).zzd();
            zzx += zzki.zzx(zzd2) + zzd2;
        }
        return zzx;
    }

    public static int zzc(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzki.zzx(i11 << 3));
    }

    public static int zzd(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzki.zzu(zzlc.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzki.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zze(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i11 << 3) + 4);
    }

    public static int zzf(List list) {
        return list.size() * 4;
    }

    public static int zzg(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzki.zzx(i11 << 3) + 8);
    }

    public static int zzh(List list) {
        return list.size() * 8;
    }

    public static int zzi(int i11, List list, zzmt zzmt) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzki.zzt(i11, (zzmi) list.get(i13), zzmt);
        }
        return i12;
    }

    public static int zzj(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzki.zzx(i11 << 3));
    }

    public static int zzk(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzki.zzu(zzlc.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzki.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzl(int i11, List list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzki.zzx(i11 << 3));
    }

    public static int zzm(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzki.zzy(zzlx.zza(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzki.zzy(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzn(int i11, Object obj, zzmt zzmt) {
        if (obj instanceof zzlo) {
            int i12 = zzki.zzb;
            int zza2 = ((zzlo) obj).zza();
            return zzki.zzx(i11 << 3) + zzki.zzx(zza2) + zza2;
        }
        return zzki.zzx(i11 << 3) + zzki.zzv((zzmi) obj, zzmt);
    }

    public static int zzo(int i11, List list, zzmt zzmt) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzx = zzki.zzx(i11 << 3) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof zzlo) {
                int zza2 = ((zzlo) obj).zza();
                zzx += zzki.zzx(zza2) + zza2;
            } else {
                zzx += zzki.zzv((zzmi) obj, zzmt);
            }
        }
        return zzx;
    }

    public static int zzp(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzki.zzx(i11 << 3));
    }

    public static int zzq(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zzlc.zze(i12);
                i11 += zzki.zzx((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = ((Integer) list.get(i12)).intValue();
                i13 = i11 + zzki.zzx((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzr(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzki.zzx(i11 << 3));
    }

    public static int zzs(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            i11 = 0;
            while (i12 < size) {
                long zza2 = zzlx.zza(i12);
                i11 += zzki.zzy((zza2 >> 63) ^ (zza2 + zza2));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = ((Long) list.get(i12)).longValue();
                i13 = i11 + zzki.zzy((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzt(int i11, List list) {
        int zzw;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z11 = list instanceof zzlq;
        int zzx = zzki.zzx(i11 << 3) * size;
        if (z11) {
            zzlq zzlq = (zzlq) list;
            while (i12 < size) {
                Object zzf = zzlq.zzf(i12);
                if (zzf instanceof zzka) {
                    int zzd2 = ((zzka) zzf).zzd();
                    zzx += zzki.zzx(zzd2) + zzd2;
                } else {
                    zzx += zzki.zzw((String) zzf);
                }
                i12++;
            }
        } else {
            while (i12 < size) {
                Object obj = list.get(i12);
                if (obj instanceof zzka) {
                    int zzd3 = ((zzka) obj).zzd();
                    zzw = zzx + zzki.zzx(zzd3) + zzd3;
                } else {
                    zzw = zzx + zzki.zzw((String) obj);
                }
                i12++;
            }
        }
        return zzx;
    }

    public static int zzu(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzki.zzx(i11 << 3));
    }

    public static int zzv(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlc) {
            zzlc zzlc = (zzlc) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzki.zzx(zzlc.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzki.zzx(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzw(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzki.zzx(i11 << 3));
    }

    public static int zzx(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlx) {
            zzlx zzlx = (zzlx) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzki.zzy(zzlx.zza(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzki.zzy(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zznk zzy() {
        return zzc;
    }

    public static zznk zzz() {
        return zzd;
    }
}
