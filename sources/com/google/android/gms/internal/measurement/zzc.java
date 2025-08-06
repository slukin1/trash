package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzc {
    public final zzf zza;
    public zzg zzb;
    public final zzab zzc = new zzab();
    private final zzz zzd = new zzz();

    public zzc() {
        zzf zzf = new zzf();
        this.zza = zzf;
        this.zzb = zzf.zzb.zza();
        zzf.zzd.zza("internal.registerCallback", new zza(this));
        zzf.zzd.zza("internal.eventLogger", new zzb(this));
    }

    public final zzab zza() {
        return this.zzc;
    }

    public final /* synthetic */ zzai zzb() throws Exception {
        return new zzv(this.zzd);
    }

    public final void zzc(zzgt zzgt) throws zzd {
        zzai zzai;
        try {
            this.zzb = this.zza.zzb.zza();
            if (!(this.zza.zza(this.zzb, (zzgy[]) zzgt.zzc().toArray(new zzgy[0])) instanceof zzag)) {
                for (zzgr zzgr : zzgt.zza().zzd()) {
                    List zzc2 = zzgr.zzc();
                    String zzb2 = zzgr.zzb();
                    Iterator it2 = zzc2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            zzap zza2 = this.zza.zza(this.zzb, (zzgy) it2.next());
                            if (zza2 instanceof zzam) {
                                zzg zzg = this.zzb;
                                if (!zzg.zzh(zzb2)) {
                                    zzai = null;
                                } else {
                                    zzap zzd2 = zzg.zzd(zzb2);
                                    if (zzd2 instanceof zzai) {
                                        zzai = (zzai) zzd2;
                                    } else {
                                        throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zzb2)));
                                    }
                                }
                                if (zzai != null) {
                                    zzai.zza(this.zzb, Collections.singletonList(zza2));
                                } else {
                                    throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zzb2)));
                                }
                            } else {
                                throw new IllegalArgumentException("Invalid rule definition");
                            }
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th2) {
            throw new zzd(th2);
        }
    }

    public final void zzd(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zze(zzaa zzaa) throws zzd {
        try {
            this.zzc.zzd(zzaa);
            this.zza.zzc.zzg("runtime.counter", new zzah(Double.valueOf(0.0d)));
            this.zzd.zzb(this.zzb.zza(), this.zzc);
            return zzg() || zzf();
        } catch (Throwable th2) {
            throw new zzd(th2);
        }
    }

    public final boolean zzf() {
        return !this.zzc.zzc().isEmpty();
    }

    public final boolean zzg() {
        zzab zzab = this.zzc;
        return !zzab.zzb().equals(zzab.zza());
    }
}
