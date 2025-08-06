package com.google.android.gms.internal.measurement;

final class zzma implements zzmu {
    private static final zzmg zza = new zzly();
    private final zzmg zzb;

    public zzma() {
        zzmg zzmg;
        zzmg[] zzmgArr = new zzmg[2];
        zzmgArr[0] = zzkw.zza();
        try {
            zzmg = (zzmg) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzmg = zza;
        }
        zzmgArr[1] = zzmg;
        zzlz zzlz = new zzlz(zzmgArr);
        byte[] bArr = zzlj.zzd;
        this.zzb = zzlz;
    }

    private static boolean zzb(zzmf zzmf) {
        return zzmf.zzc() == 1;
    }

    public final zzmt zza(Class cls) {
        Class<zzlb> cls2 = zzlb.class;
        zzmv.zzC(cls);
        zzmf zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzmm.zzc(zzmv.zzz(), zzkq.zzb(), zzb2.zza());
            }
            return zzmm.zzc(zzmv.zzy(), zzkq.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzml.zzl(cls, zzb2, zzmo.zzb(), zzlw.zzd(), zzmv.zzz(), zzkq.zzb(), zzme.zzb());
            }
            return zzml.zzl(cls, zzb2, zzmo.zzb(), zzlw.zzd(), zzmv.zzz(), (zzko) null, zzme.zzb());
        } else if (zzb(zzb2)) {
            return zzml.zzl(cls, zzb2, zzmo.zza(), zzlw.zzc(), zzmv.zzy(), zzkq.zza(), zzme.zza());
        } else {
            return zzml.zzl(cls, zzb2, zzmo.zza(), zzlw.zzc(), zzmv.zzy(), (zzko) null, zzme.zza());
        }
    }
}
