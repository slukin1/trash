package com.google.android.gms.internal.auth;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgj {
    private static final Class zza;
    private static final zzgy zzb = zzj(false);
    private static final zzgy zzc = zzj(true);
    private static final zzgy zzd = new zzha();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgy zza() {
        return zzb;
    }

    public static zzgy zzb() {
        return zzc;
    }

    public static zzgy zzc() {
        return zzd;
    }

    public static Object zzd(int i11, List list, zzex zzex, Object obj, zzgy zzgy) {
        if (zzex == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = ((Integer) list.get(i13)).intValue();
                if (zzex.zza()) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    obj = zze(i11, intValue, obj, zzgy);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return obj;
            }
        } else {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                int intValue2 = ((Integer) it2.next()).intValue();
                if (!zzex.zza()) {
                    obj = zze(i11, intValue2, obj, zzgy);
                    it2.remove();
                }
            }
        }
        return obj;
    }

    public static Object zze(int i11, int i12, Object obj, zzgy zzgy) {
        if (obj == null) {
            obj = zzgy.zzc();
        }
        zzgy.zzd(obj, i11, (long) i12);
        return obj;
    }

    public static void zzf(zzgy zzgy, Object obj, Object obj2) {
        zzgy.zzf(obj, zzgy.zzb(zzgy.zza(obj), zzgy.zza(obj2)));
    }

    public static void zzg(Class cls) {
        Class cls2;
        if (!zzeu.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzh(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zzi(zzfr zzfr, Object obj, Object obj2, long j11) {
        zzhi.zzp(obj, j11, zzfr.zza(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11)));
    }

    private static zzgy zzj(boolean z11) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgy) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused2) {
            return null;
        }
    }
}
