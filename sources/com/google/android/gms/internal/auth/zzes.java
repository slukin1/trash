package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzes;
import com.google.android.gms.internal.auth.zzeu;

public class zzes<MessageType extends zzeu<MessageType, BuilderType>, BuilderType extends zzes<MessageType, BuilderType>> extends zzdo<MessageType, BuilderType> {
    public zzeu zza;
    public boolean zzb = false;
    private final zzeu zzc;

    public zzes(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzeu) messagetype.zzi(4, (Object) null, (Object) null);
    }

    private static final void zzj(zzeu zzeu, zzeu zzeu2) {
        zzge.zza().zzb(zzeu.getClass()).zzf(zzeu, zzeu2);
    }

    public final /* synthetic */ zzdo zzb(zzdp zzdp) {
        zze((zzeu) zzdp);
        return this;
    }

    /* renamed from: zzd */
    public final zzes zza() {
        zzes zzes = (zzes) this.zzc.zzi(5, (Object) null, (Object) null);
        zzes.zze(zzg());
        return zzes;
    }

    public final zzes zze(zzeu zzeu) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzj(this.zza, zzeu);
        return this;
    }

    /* renamed from: zzf */
    public MessageType zzg() {
        if (this.zzb) {
            return this.zza;
        }
        zzeu zzeu = this.zza;
        zzge.zza().zzb(zzeu.getClass()).zze(zzeu);
        this.zzb = true;
        return this.zza;
    }

    public final /* synthetic */ zzfw zzh() {
        return this.zzc;
    }

    public void zzi() {
        zzeu zzeu = (zzeu) this.zza.zzi(4, (Object) null, (Object) null);
        zzj(zzeu, this.zza);
        this.zza = zzeu;
    }
}
