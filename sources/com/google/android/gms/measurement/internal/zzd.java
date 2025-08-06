package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

public final class zzd extends zze {
    private final Map zza = new ArrayMap();
    private final Map zzb = new ArrayMap();
    private long zzc;

    public zzd(zzgd zzgd) {
        super(zzgd);
    }

    public static /* synthetic */ void zza(zzd zzd, String str, long j11) {
        zzd.zzg();
        Preconditions.checkNotEmpty(str);
        if (zzd.zzb.isEmpty()) {
            zzd.zzc = j11;
        }
        Integer num = (Integer) zzd.zzb.get(str);
        if (num != null) {
            zzd.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (zzd.zzb.size() >= 100) {
            zzd.zzt.zzaA().zzk().zza("Too many ads visible");
        } else {
            zzd.zzb.put(str, 1);
            zzd.zza.put(str, Long.valueOf(j11));
        }
    }

    public static /* synthetic */ void zzb(zzd zzd, String str, long j11) {
        zzd.zzg();
        Preconditions.checkNotEmpty(str);
        Integer num = (Integer) zzd.zzb.get(str);
        if (num != null) {
            zzir zzj = zzd.zzt.zzs().zzj(false);
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                zzd.zzb.remove(str);
                Long l11 = (Long) zzd.zza.get(str);
                if (l11 == null) {
                    zzd.zzt.zzaA().zzd().zza("First ad unit exposure time was never set");
                } else {
                    zzd.zza.remove(str);
                    zzd.zzi(str, j11 - l11.longValue(), zzj);
                }
                if (zzd.zzb.isEmpty()) {
                    long j12 = zzd.zzc;
                    if (j12 == 0) {
                        zzd.zzt.zzaA().zzd().zza("First ad exposure time was never set");
                        return;
                    }
                    zzd.zzh(j11 - j12, zzj);
                    zzd.zzc = 0;
                    return;
                }
                return;
            }
            zzd.zzb.put(str, Integer.valueOf(intValue));
            return;
        }
        zzd.zzt.zzaA().zzd().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
    }

    private final void zzh(long j11, zzir zzir) {
        if (zzir == null) {
            this.zzt.zzaA().zzj().zza("Not logging ad exposure. No active activity");
        } else if (j11 < 1000) {
            this.zzt.zzaA().zzj().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j11));
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j11);
            zzlp.zzK(zzir, bundle, true);
            this.zzt.zzq().zzG("am", "_xa", bundle);
        }
    }

    private final void zzi(String str, long j11, zzir zzir) {
        if (zzir == null) {
            this.zzt.zzaA().zzj().zza("Not logging ad unit exposure. No active activity");
        } else if (j11 < 1000) {
            this.zzt.zzaA().zzj().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j11));
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j11);
            zzlp.zzK(zzir, bundle, true);
            this.zzt.zzq().zzG("am", "_xu", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void zzj(long j11) {
        for (String put : this.zza.keySet()) {
            this.zza.put(put, Long.valueOf(j11));
        }
        if (!this.zza.isEmpty()) {
            this.zzc = j11;
        }
    }

    public final void zzd(String str, long j11) {
        if (str == null || str.length() == 0) {
            this.zzt.zzaA().zzd().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzt.zzaB().zzp(new zza(this, str, j11));
        }
    }

    public final void zze(String str, long j11) {
        if (str == null || str.length() == 0) {
            this.zzt.zzaA().zzd().zza("Ad unit id must be a non-empty string");
        } else {
            this.zzt.zzaB().zzp(new zzb(this, str, j11));
        }
    }

    public final void zzf(long j11) {
        zzir zzj = this.zzt.zzs().zzj(false);
        for (String str : this.zza.keySet()) {
            zzi(str, j11 - ((Long) this.zza.get(str)).longValue(), zzj);
        }
        if (!this.zza.isEmpty()) {
            zzh(j11 - this.zzc, zzj);
        }
        zzj(j11);
    }
}
