package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.o;

public final class zzeg implements zzee {
    private final zzef zza;
    private final zzed zzb;

    public zzeg(zzef zzef, zzed zzed) {
        this.zza = zzef;
        this.zzb = zzed;
    }

    private final zzpf zzb(String str, List list) throws zzae {
        if (str.length() != 0) {
            try {
                zzec zzec = new zzec(this.zza.zza(CollectionsKt___CollectionsKt.J0(list)), 255, zzec.zzb);
                StringBuilder sb2 = new StringBuilder(str.length());
                for (int i11 = 0; i11 < str.length(); i11++) {
                    sb2.append((char) o.b(o.b(str.charAt(i11)) ^ o.b((int) zzec.zza())));
                }
                return zzpf.zzg(zzfy.zzh().zzj(sb2.toString()));
            } catch (Exception e11) {
                throw new zzae(3, 18, e11);
            }
        } else {
            throw new zzae(3, 17, (Throwable) null);
        }
    }

    public final zzpf zza(zzpn zzpn) throws zzae {
        zzfh zzb2 = zzfh.zzb();
        zzpf zzb3 = zzb(zzpn.zzi(), zzpn.zzj());
        zzb2.zzf();
        long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
        zzv zzv = zzv.zza;
        zzv.zza(zzx.zzm.zza(), zza2);
        return zzb3;
    }
}
