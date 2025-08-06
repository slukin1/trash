package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

public final class zzfe extends zzkx implements zzmj {
    private zzfe() {
        super(zzff.zza);
    }

    public final int zza() {
        return ((zzff) this.zza).zzb();
    }

    public final zzfd zzb(int i11) {
        return ((zzff) this.zza).zzd(i11);
    }

    public final zzfe zzc() {
        zzaH();
        ((zzff) this.zza).zzj = zzlb.zzbH();
        return this;
    }

    public final zzfe zzd(int i11, zzfc zzfc) {
        zzaH();
        zzff.zzq((zzff) this.zza, i11, (zzfd) zzfc.zzaD());
        return this;
    }

    public final String zze() {
        return ((zzff) this.zza).zzk();
    }

    public final List zzf() {
        return Collections.unmodifiableList(((zzff) this.zza).zzm());
    }

    public final List zzg() {
        return Collections.unmodifiableList(((zzff) this.zza).zzn());
    }

    public /* synthetic */ zzfe(zzez zzez) {
        super(zzff.zza);
    }
}
