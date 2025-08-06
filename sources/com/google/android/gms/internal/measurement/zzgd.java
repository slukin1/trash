package com.google.android.gms.internal.measurement;

import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import java.util.List;

public final class zzgd extends zzlb implements zzmj {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzgd zzd;
    private String zzA = "";
    private long zzB;
    private int zzC;
    private String zzD = "";
    private String zzE = "";
    private boolean zzF;
    /* access modifiers changed from: private */
    public zzli zzG = zzlb.zzbH();
    private String zzH = "";
    private int zzI;
    private int zzJ;
    private int zzK;
    private String zzL = "";
    private long zzM;
    private long zzN;
    private String zzO = "";
    private String zzP = "";
    private int zzQ;
    private String zzR = "";
    private zzgg zzS;
    private zzlg zzT = zzlb.zzbE();
    private long zzU;
    private long zzV;
    private String zzW = "";
    private String zzX = "";
    private int zzY;
    private boolean zzZ;
    private String zzaa = "";
    private boolean zzab;
    private zzfz zzac;
    private String zzad = "";
    private zzli zzae = zzlb.zzbH();
    private String zzaf = "";
    private long zzag;
    private int zze;
    private int zzf;
    private int zzg;
    /* access modifiers changed from: private */
    public zzli zzh = zzlb.zzbH();
    private zzli zzi = zzlb.zzbH();
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private int zzs;
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private long zzw;
    private long zzx;
    private String zzy = "";
    private boolean zzz;

    static {
        zzgd zzgd = new zzgd();
        zzd = zzgd;
        zzlb.zzbO(zzgd.class, zzgd);
    }

    private zzgd() {
    }

    public static /* synthetic */ void zzQ(zzgd zzgd) {
        zzgd.zze &= Integer.MAX_VALUE;
        zzgd.zzO = zzd.zzO;
    }

    public static /* synthetic */ void zzR(zzgd zzgd, int i11) {
        zzgd.zzf |= 2;
        zzgd.zzQ = i11;
    }

    public static /* synthetic */ void zzS(zzgd zzgd, int i11, zzft zzft) {
        zzft.getClass();
        zzgd.zzbS();
        zzgd.zzh.set(i11, zzft);
    }

    public static /* synthetic */ void zzT(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zzf |= 4;
        zzgd.zzR = str;
    }

    public static /* synthetic */ void zzU(zzgd zzgd, zzgg zzgg) {
        zzgg.getClass();
        zzgd.zzS = zzgg;
        zzgd.zzf |= 8;
    }

    public static /* synthetic */ void zzV(zzgd zzgd, Iterable iterable) {
        zzlg zzlg = zzgd.zzT;
        if (!zzlg.zzc()) {
            int size = zzlg.size();
            zzgd.zzT = zzlg.zzg(size == 0 ? 10 : size + size);
        }
        zzjk.zzbw(iterable, zzgd.zzT);
    }

    public static /* synthetic */ void zzW(zzgd zzgd, zzft zzft) {
        zzft.getClass();
        zzgd.zzbS();
        zzgd.zzh.add(zzft);
    }

    public static /* synthetic */ void zzX(zzgd zzgd, long j11) {
        zzgd.zzf |= 16;
        zzgd.zzU = j11;
    }

    public static /* synthetic */ void zzY(zzgd zzgd, long j11) {
        zzgd.zzf |= 32;
        zzgd.zzV = j11;
    }

    public static /* synthetic */ void zzZ(zzgd zzgd, String str) {
        zzgd.zzf |= 128;
        zzgd.zzX = str;
    }

    public static /* synthetic */ void zzaA(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 2048;
        zzgd.zzt = str;
    }

    public static /* synthetic */ void zzaB(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 4096;
        zzgd.zzu = str;
    }

    public static /* synthetic */ void zzaC(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 8192;
        zzgd.zzv = str;
    }

    public static /* synthetic */ void zzaD(zzgd zzgd, long j11) {
        zzgd.zze |= 16384;
        zzgd.zzw = j11;
    }

    public static /* synthetic */ void zzaE(zzgd zzgd, long j11) {
        zzgd.zze |= 32768;
        zzgd.zzx = 79000;
    }

    public static /* synthetic */ void zzaF(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 65536;
        zzgd.zzy = str;
    }

    public static /* synthetic */ void zzaG(zzgd zzgd) {
        zzgd.zze &= -65537;
        zzgd.zzy = zzd.zzy;
    }

    public static /* synthetic */ void zzaH(zzgd zzgd, boolean z11) {
        zzgd.zze |= 131072;
        zzgd.zzz = z11;
    }

    public static /* synthetic */ void zzaI(zzgd zzgd) {
        zzgd.zze &= -131073;
        zzgd.zzz = false;
    }

    public static /* synthetic */ void zzaJ(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 262144;
        zzgd.zzA = str;
    }

    public static /* synthetic */ void zzaK(zzgd zzgd) {
        zzgd.zze &= -262145;
        zzgd.zzA = zzd.zzA;
    }

    public static /* synthetic */ void zzaL(zzgd zzgd, long j11) {
        zzgd.zze |= 524288;
        zzgd.zzB = j11;
    }

    public static /* synthetic */ void zzaM(zzgd zzgd, int i11) {
        zzgd.zze |= 1048576;
        zzgd.zzC = i11;
    }

    public static /* synthetic */ void zzaN(zzgd zzgd, String str) {
        zzgd.zze |= 2097152;
        zzgd.zzD = str;
    }

    public static /* synthetic */ void zzaO(zzgd zzgd) {
        zzgd.zze &= -2097153;
        zzgd.zzD = zzd.zzD;
    }

    public static /* synthetic */ void zzaP(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 4194304;
        zzgd.zzE = str;
    }

    public static /* synthetic */ void zzaQ(zzgd zzgd, boolean z11) {
        zzgd.zze |= 8388608;
        zzgd.zzF = z11;
    }

    public static /* synthetic */ void zzaR(zzgd zzgd, Iterable iterable) {
        zzli zzli = zzgd.zzG;
        if (!zzli.zzc()) {
            zzgd.zzG = zzlb.zzbI(zzli);
        }
        zzjk.zzbw(iterable, zzgd.zzG);
    }

    public static /* synthetic */ void zzaT(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 16777216;
        zzgd.zzH = str;
    }

    public static /* synthetic */ void zzaU(zzgd zzgd, int i11) {
        zzgd.zze |= TPMediaCodecProfileLevel.HEVCHighTierLevel62;
        zzgd.zzI = i11;
    }

    public static /* synthetic */ void zzaV(zzgd zzgd, int i11) {
        zzgd.zze |= 1;
        zzgd.zzg = 1;
    }

    public static /* synthetic */ void zzaW(zzgd zzgd) {
        zzgd.zze &= -268435457;
        zzgd.zzL = zzd.zzL;
    }

    public static /* synthetic */ void zzaX(zzgd zzgd, long j11) {
        zzgd.zze |= 536870912;
        zzgd.zzM = j11;
    }

    public static /* synthetic */ void zzaa(zzgd zzgd, Iterable iterable) {
        zzgd.zzbS();
        zzjk.zzbw(iterable, zzgd.zzh);
    }

    public static /* synthetic */ void zzab(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zzf |= 8192;
        zzgd.zzad = str;
    }

    public static /* synthetic */ void zzac(zzgd zzgd) {
        zzgd.zzf &= -8193;
        zzgd.zzad = zzd.zzad;
    }

    public static /* synthetic */ void zzad(zzgd zzgd, Iterable iterable) {
        zzli zzli = zzgd.zzae;
        if (!zzli.zzc()) {
            zzgd.zzae = zzlb.zzbI(zzli);
        }
        zzjk.zzbw(iterable, zzgd.zzae);
    }

    public static /* synthetic */ void zzaf(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zzf |= 16384;
        zzgd.zzaf = str;
    }

    public static /* synthetic */ void zzag(zzgd zzgd, long j11) {
        zzgd.zzf |= 32768;
        zzgd.zzag = j11;
    }

    public static /* synthetic */ void zzah(zzgd zzgd, int i11) {
        zzgd.zzbS();
        zzgd.zzh.remove(i11);
    }

    public static /* synthetic */ void zzai(zzgd zzgd, int i11, zzgm zzgm) {
        zzgm.getClass();
        zzgd.zzbT();
        zzgd.zzi.set(i11, zzgm);
    }

    public static /* synthetic */ void zzaj(zzgd zzgd, zzgm zzgm) {
        zzgm.getClass();
        zzgd.zzbT();
        zzgd.zzi.add(zzgm);
    }

    public static /* synthetic */ void zzak(zzgd zzgd, Iterable iterable) {
        zzgd.zzbT();
        zzjk.zzbw(iterable, zzgd.zzi);
    }

    public static /* synthetic */ void zzal(zzgd zzgd, int i11) {
        zzgd.zzbT();
        zzgd.zzi.remove(i11);
    }

    public static /* synthetic */ void zzam(zzgd zzgd, long j11) {
        zzgd.zze |= 2;
        zzgd.zzj = j11;
    }

    public static /* synthetic */ void zzan(zzgd zzgd, long j11) {
        zzgd.zze |= 4;
        zzgd.zzk = j11;
    }

    public static /* synthetic */ void zzao(zzgd zzgd, long j11) {
        zzgd.zze |= 8;
        zzgd.zzl = j11;
    }

    public static /* synthetic */ void zzap(zzgd zzgd, long j11) {
        zzgd.zze |= 16;
        zzgd.zzm = j11;
    }

    public static /* synthetic */ void zzaq(zzgd zzgd) {
        zzgd.zze &= -17;
        zzgd.zzm = 0;
    }

    public static /* synthetic */ void zzar(zzgd zzgd, long j11) {
        zzgd.zze |= 32;
        zzgd.zzn = j11;
    }

    public static /* synthetic */ void zzas(zzgd zzgd) {
        zzgd.zze &= -33;
        zzgd.zzn = 0;
    }

    public static /* synthetic */ void zzat(zzgd zzgd, String str) {
        zzgd.zze |= 64;
        zzgd.zzo = "android";
    }

    public static /* synthetic */ void zzau(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 128;
        zzgd.zzp = str;
    }

    public static /* synthetic */ void zzav(zzgd zzgd) {
        zzgd.zze &= -129;
        zzgd.zzp = zzd.zzp;
    }

    public static /* synthetic */ void zzaw(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 256;
        zzgd.zzq = str;
    }

    public static /* synthetic */ void zzax(zzgd zzgd) {
        zzgd.zze &= -257;
        zzgd.zzq = zzd.zzq;
    }

    public static /* synthetic */ void zzay(zzgd zzgd, String str) {
        str.getClass();
        zzgd.zze |= 512;
        zzgd.zzr = str;
    }

    public static /* synthetic */ void zzaz(zzgd zzgd, int i11) {
        zzgd.zze |= 1024;
        zzgd.zzs = i11;
    }

    private final void zzbS() {
        zzli zzli = this.zzh;
        if (!zzli.zzc()) {
            this.zzh = zzlb.zzbI(zzli);
        }
    }

    private final void zzbT() {
        zzli zzli = this.zzi;
        if (!zzli.zzc()) {
            this.zzi = zzlb.zzbI(zzli);
        }
    }

    public static zzgc zzu() {
        return (zzgc) zzd.zzbA();
    }

    public final String zzA() {
        return this.zzt;
    }

    public final String zzB() {
        return this.zzv;
    }

    public final String zzC() {
        return this.zzX;
    }

    public final String zzD() {
        return this.zzq;
    }

    public final String zzE() {
        return this.zzO;
    }

    public final String zzF() {
        return this.zzH;
    }

    public final String zzG() {
        return this.zzE;
    }

    public final String zzH() {
        return this.zzD;
    }

    public final String zzI() {
        return this.zzp;
    }

    public final String zzJ() {
        return this.zzo;
    }

    public final String zzK() {
        return this.zzy;
    }

    public final String zzL() {
        return this.zzad;
    }

    public final String zzM() {
        return this.zzr;
    }

    public final List zzN() {
        return this.zzG;
    }

    public final List zzO() {
        return this.zzh;
    }

    public final List zzP() {
        return this.zzi;
    }

    public final int zza() {
        return this.zzI;
    }

    public final boolean zzaY() {
        return this.zzz;
    }

    public final boolean zzaZ() {
        return this.zzF;
    }

    public final int zzb() {
        return this.zzC;
    }

    public final boolean zzba() {
        return (this.zze & TPMediaCodecProfileLevel.HEVCHighTierLevel62) != 0;
    }

    public final boolean zzbb() {
        return (this.zze & 1048576) != 0;
    }

    public final boolean zzbc() {
        return (this.zze & 536870912) != 0;
    }

    public final boolean zzbd() {
        return (this.zzf & 128) != 0;
    }

    public final boolean zzbe() {
        return (this.zze & 524288) != 0;
    }

    public final boolean zzbf() {
        return (this.zzf & 16) != 0;
    }

    public final boolean zzbg() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzbh() {
        return (this.zze & 16384) != 0;
    }

    public final boolean zzbi() {
        return (this.zze & 131072) != 0;
    }

    public final boolean zzbj() {
        return (this.zze & 32) != 0;
    }

    public final boolean zzbk() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzbl() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzbm() {
        return (this.zzf & 2) != 0;
    }

    public final boolean zzbn() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean zzbo() {
        return (this.zzf & 8192) != 0;
    }

    public final boolean zzbp() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzbq() {
        return (this.zzf & 32768) != 0;
    }

    public final boolean zzbr() {
        return (this.zze & 1024) != 0;
    }

    public final boolean zzbs() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzbt() {
        return (this.zze & 32768) != 0;
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzQ;
    }

    public final int zzf() {
        return this.zzs;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final long zzh() {
        return this.zzM;
    }

    public final long zzi() {
        return this.zzB;
    }

    public final long zzj() {
        return this.zzU;
    }

    public final long zzk() {
        return this.zzl;
    }

    public final Object zzl(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzlb.zzbL(zzd, "\u00015\u0000\u0002\u0001C5\u0000\u0005\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/", new Object[]{"zze", "zzf", "zzg", "zzh", zzft.class, "zzi", zzgm.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzfp.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", zzfl.zza, "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag"});
        } else if (i12 == 3) {
            return new zzgd();
        } else {
            if (i12 == 4) {
                return new zzgc((zzfk) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzd;
        }
    }

    public final long zzm() {
        return this.zzw;
    }

    public final long zzn() {
        return this.zzn;
    }

    public final long zzo() {
        return this.zzm;
    }

    public final long zzp() {
        return this.zzk;
    }

    public final long zzq() {
        return this.zzag;
    }

    public final long zzr() {
        return this.zzj;
    }

    public final long zzs() {
        return this.zzx;
    }

    public final zzft zzt(int i11) {
        return (zzft) this.zzh.get(i11);
    }

    public final zzgm zzw(int i11) {
        return (zzgm) this.zzi.get(i11);
    }

    public final String zzx() {
        return this.zzR;
    }

    public final String zzy() {
        return this.zzu;
    }

    public final String zzz() {
        return this.zzA;
    }
}
