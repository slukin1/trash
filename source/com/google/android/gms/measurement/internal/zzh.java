package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzh {
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private String zzE;
    private boolean zzF;
    private long zzG;
    private long zzH;
    private final zzgd zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private String zzq;
    private Boolean zzr;
    private long zzs;
    private List zzt;
    private String zzu;
    private boolean zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzh(zzgd zzgd, String str) {
        Preconditions.checkNotNull(zzgd);
        Preconditions.checkNotEmpty(str);
        this.zza = zzgd;
        this.zzb = str;
        zzgd.zzaB().zzg();
    }

    public final String zzA() {
        this.zza.zzaB().zzg();
        return this.zzd;
    }

    public final String zzB() {
        this.zza.zzaB().zzg();
        return this.zzE;
    }

    public final String zzC() {
        this.zza.zzaB().zzg();
        return this.zze;
    }

    public final String zzD() {
        this.zza.zzaB().zzg();
        return this.zzu;
    }

    public final List zzE() {
        this.zza.zzaB().zzg();
        return this.zzt;
    }

    public final void zzF() {
        this.zza.zzaB().zzg();
        this.zzF = false;
    }

    public final void zzG() {
        this.zza.zzaB().zzg();
        long j11 = this.zzg + 1;
        if (j11 > 2147483647L) {
            this.zza.zzaA().zzk().zzb("Bundle index overflow. appId", zzet.zzn(this.zzb));
            j11 = 0;
        }
        this.zzF = true;
        this.zzg = j11;
    }

    public final void zzH(String str) {
        this.zza.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzF |= true ^ zzg.zza(this.zzq, str);
        this.zzq = str;
    }

    public final void zzI(boolean z11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzp != z11;
        this.zzp = z11;
    }

    public final void zzJ(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzc, str);
        this.zzc = str;
    }

    public final void zzK(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzl, str);
        this.zzl = str;
    }

    public final void zzL(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzj, str);
        this.zzj = str;
    }

    public final void zzM(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzk != j11;
        this.zzk = j11;
    }

    public final void zzN(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzG != j11;
        this.zzG = j11;
    }

    public final void zzO(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzB != j11;
        this.zzB = j11;
    }

    public final void zzP(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzC != j11;
        this.zzC = j11;
    }

    public final void zzQ(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzA != j11;
        this.zzA = j11;
    }

    public final void zzR(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzz != j11;
        this.zzz = j11;
    }

    public final void zzS(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzD != j11;
        this.zzD = j11;
    }

    public final void zzT(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzy != j11;
        this.zzy = j11;
    }

    public final void zzU(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzn != j11;
        this.zzn = j11;
    }

    public final void zzV(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzs != j11;
        this.zzs = j11;
    }

    public final void zzW(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzH != j11;
        this.zzH = j11;
    }

    public final void zzX(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzf, str);
        this.zzf = str;
    }

    public final void zzY(String str) {
        this.zza.zzaB().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzF |= true ^ zzg.zza(this.zzd, str);
        this.zzd = str;
    }

    public final void zzZ(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzm != j11;
        this.zzm = j11;
    }

    public final long zza() {
        this.zza.zzaB().zzg();
        return 0;
    }

    public final void zzaa(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzE, str);
        this.zzE = str;
    }

    public final void zzab(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzi != j11;
        this.zzi = j11;
    }

    public final void zzac(long j11) {
        boolean z11 = true;
        Preconditions.checkArgument(j11 >= 0);
        this.zza.zzaB().zzg();
        boolean z12 = this.zzF;
        if (this.zzg == j11) {
            z11 = false;
        }
        this.zzF = z12 | z11;
        this.zzg = j11;
    }

    public final void zzad(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzh != j11;
        this.zzh = j11;
    }

    public final void zzae(boolean z11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzo != z11;
        this.zzo = z11;
    }

    public final void zzaf(Boolean bool) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzr, bool);
        this.zzr = bool;
    }

    public final void zzag(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zze, str);
        this.zze = str;
    }

    public final void zzah(List list) {
        this.zza.zzaB().zzg();
        if (!zzg.zza(this.zzt, list)) {
            this.zzF = true;
            this.zzt = list != null ? new ArrayList(list) : null;
        }
    }

    public final void zzai(String str) {
        this.zza.zzaB().zzg();
        this.zzF |= !zzg.zza(this.zzu, str);
        this.zzu = str;
    }

    public final void zzaj(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzx != j11;
        this.zzx = j11;
    }

    public final void zzak(boolean z11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzv != z11;
        this.zzv = z11;
    }

    public final void zzal(long j11) {
        this.zza.zzaB().zzg();
        this.zzF |= this.zzw != j11;
        this.zzw = j11;
    }

    public final boolean zzam() {
        this.zza.zzaB().zzg();
        return this.zzp;
    }

    public final boolean zzan() {
        this.zza.zzaB().zzg();
        return this.zzo;
    }

    public final boolean zzao() {
        this.zza.zzaB().zzg();
        return this.zzF;
    }

    public final boolean zzap() {
        this.zza.zzaB().zzg();
        return this.zzv;
    }

    public final long zzb() {
        this.zza.zzaB().zzg();
        return this.zzk;
    }

    public final long zzc() {
        this.zza.zzaB().zzg();
        return this.zzG;
    }

    public final long zzd() {
        this.zza.zzaB().zzg();
        return this.zzB;
    }

    public final long zze() {
        this.zza.zzaB().zzg();
        return this.zzC;
    }

    public final long zzf() {
        this.zza.zzaB().zzg();
        return this.zzA;
    }

    public final long zzg() {
        this.zza.zzaB().zzg();
        return this.zzz;
    }

    public final long zzh() {
        this.zza.zzaB().zzg();
        return this.zzD;
    }

    public final long zzi() {
        this.zza.zzaB().zzg();
        return this.zzy;
    }

    public final long zzj() {
        this.zza.zzaB().zzg();
        return this.zzn;
    }

    public final long zzk() {
        this.zza.zzaB().zzg();
        return this.zzs;
    }

    public final long zzl() {
        this.zza.zzaB().zzg();
        return this.zzH;
    }

    public final long zzm() {
        this.zza.zzaB().zzg();
        return this.zzm;
    }

    public final long zzn() {
        this.zza.zzaB().zzg();
        return this.zzi;
    }

    public final long zzo() {
        this.zza.zzaB().zzg();
        return this.zzg;
    }

    public final long zzp() {
        this.zza.zzaB().zzg();
        return this.zzh;
    }

    public final long zzq() {
        this.zza.zzaB().zzg();
        return this.zzx;
    }

    public final long zzr() {
        this.zza.zzaB().zzg();
        return this.zzw;
    }

    public final Boolean zzs() {
        this.zza.zzaB().zzg();
        return this.zzr;
    }

    public final String zzt() {
        this.zza.zzaB().zzg();
        return this.zzq;
    }

    public final String zzu() {
        this.zza.zzaB().zzg();
        String str = this.zzE;
        zzaa((String) null);
        return str;
    }

    public final String zzv() {
        this.zza.zzaB().zzg();
        return this.zzb;
    }

    public final String zzw() {
        this.zza.zzaB().zzg();
        return this.zzc;
    }

    public final String zzx() {
        this.zza.zzaB().zzg();
        return this.zzl;
    }

    public final String zzy() {
        this.zza.zzaB().zzg();
        return this.zzj;
    }

    public final String zzz() {
        this.zza.zzaB().zzg();
        return this.zzf;
    }
}
