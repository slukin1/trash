package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfu;
import com.google.android.gms.internal.measurement.zzfv;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzpz;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class zzgq implements Callable {
    public final /* synthetic */ zzau zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzgv zzc;

    public zzgq(zzgv zzgv, zzau zzau, String str) {
        this.zzc = zzgv;
        this.zza = zzau;
        this.zzb = str;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        byte[] bArr;
        zzlh zzlh;
        zzlm zzlm;
        zzga zzga;
        zzgc zzgc;
        Bundle bundle;
        String str;
        zzh zzh;
        long j11;
        String str2;
        zzaq zzaq;
        this.zzc.zza.zzA();
        zzip zzr = this.zzc.zza.zzr();
        zzau zzau = this.zza;
        String str3 = this.zzb;
        zzr.zzg();
        zzgd.zzO();
        Preconditions.checkNotNull(zzau);
        Preconditions.checkNotEmpty(str3);
        if (!zzr.zzt.zzf().zzs(str3, zzeg.zzU)) {
            zzr.zzt.zzaA().zzc().zzb("Generating ScionPayload disabled. packageName", str3);
            return new byte[0];
        } else if ("_iap".equals(zzau.zza) || "_iapx".equals(zzau.zza)) {
            zzga zza2 = zzgb.zza();
            zzr.zzf.zzh().zzw();
            zzh zzj = zzr.zzf.zzh().zzj(str3);
            if (zzj == null) {
                zzr.zzt.zzaA().zzc().zzb("Log and bundle not available. package_name", str3);
                bArr = new byte[0];
                zzlh = zzr.zzf;
            } else if (!zzj.zzan()) {
                zzr.zzt.zzaA().zzc().zzb("Log and bundle disabled. package_name", str3);
                bArr = new byte[0];
                zzlh = zzr.zzf;
            } else {
                zzgc zzu = zzgd.zzu();
                zzu.zzad(1);
                zzu.zzZ("android");
                if (!TextUtils.isEmpty(zzj.zzv())) {
                    zzu.zzD(zzj.zzv());
                }
                if (!TextUtils.isEmpty(zzj.zzx())) {
                    zzu.zzF((String) Preconditions.checkNotNull(zzj.zzx()));
                }
                if (!TextUtils.isEmpty(zzj.zzy())) {
                    zzu.zzG((String) Preconditions.checkNotNull(zzj.zzy()));
                }
                if (zzj.zzb() != -2147483648L) {
                    zzu.zzH((int) zzj.zzb());
                }
                zzu.zzV(zzj.zzm());
                zzu.zzP(zzj.zzk());
                String zzA = zzj.zzA();
                String zzt = zzj.zzt();
                if (!TextUtils.isEmpty(zzA)) {
                    zzu.zzU(zzA);
                } else if (!TextUtils.isEmpty(zzt)) {
                    zzu.zzC(zzt);
                }
                zzpz.zzc();
                if (zzr.zzt.zzf().zzs((String) null, zzeg.zzaE)) {
                    zzu.zzaj(zzj.zzr());
                }
                zzhb zzq = zzr.zzf.zzq(str3);
                zzu.zzM(zzj.zzj());
                if (zzr.zzt.zzJ() && zzr.zzt.zzf().zzt(zzu.zzaq()) && zzq.zzj(zzha.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzu.zzO((String) null);
                }
                zzu.zzL(zzq.zzi());
                if (zzq.zzj(zzha.AD_STORAGE) && zzj.zzam()) {
                    Pair zzd = zzr.zzf.zzs().zzd(zzj.zzv(), zzq);
                    if (zzj.zzam() && !TextUtils.isEmpty((CharSequence) zzd.first)) {
                        try {
                            zzu.zzae(zzip.zza((String) zzd.first, Long.toString(zzau.zzd)));
                            Object obj = zzd.second;
                            if (obj != null) {
                                zzu.zzX(((Boolean) obj).booleanValue());
                            }
                        } catch (SecurityException e11) {
                            zzr.zzt.zzaA().zzc().zzb("Resettable device id encryption failed", e11.getMessage());
                            bArr = new byte[0];
                            zzlh = zzr.zzf;
                        } catch (Throwable th2) {
                            zzr.zzf.zzh().zzx();
                            throw th2;
                        }
                    }
                }
                zzr.zzt.zzg().zzv();
                zzu.zzN(Build.MODEL);
                zzr.zzt.zzg().zzv();
                zzu.zzY(Build.VERSION.RELEASE);
                zzu.zzak((int) zzr.zzt.zzg().zzb());
                zzu.zzao(zzr.zzt.zzg().zzc());
                try {
                    if (zzq.zzj(zzha.ANALYTICS_STORAGE) && zzj.zzw() != null) {
                        zzu.zzE(zzip.zza((String) Preconditions.checkNotNull(zzj.zzw()), Long.toString(zzau.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzj.zzz())) {
                        zzu.zzT((String) Preconditions.checkNotNull(zzj.zzz()));
                    }
                    String zzv = zzj.zzv();
                    List zzu2 = zzr.zzf.zzh().zzu(zzv);
                    Iterator it2 = zzu2.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            zzlm = null;
                            break;
                        }
                        zzlm = (zzlm) it2.next();
                        if ("_lte".equals(zzlm.zzc)) {
                            break;
                        }
                    }
                    if (zzlm == null || zzlm.zze == null) {
                        zzlm zzlm2 = new zzlm(zzv, TtmlNode.TEXT_EMPHASIS_AUTO, "_lte", zzr.zzt.zzax().currentTimeMillis(), 0L);
                        zzu2.add(zzlm2);
                        zzr.zzf.zzh().zzL(zzlm2);
                    }
                    zzlj zzu3 = zzr.zzf.zzu();
                    zzu3.zzt.zzaA().zzj().zza("Checking account type status for ad personalization signals");
                    if (zzu3.zzt.zzg().zze()) {
                        String zzv2 = zzj.zzv();
                        Preconditions.checkNotNull(zzv2);
                        if (zzj.zzam() && zzu3.zzf.zzm().zzn(zzv2)) {
                            zzu3.zzt.zzaA().zzc().zza("Turning off ad personalization due to account type");
                            Iterator it3 = zzu2.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                } else if ("_npa".equals(((zzlm) it3.next()).zzc)) {
                                    it3.remove();
                                    break;
                                }
                            }
                            zzu2.add(new zzlm(zzv2, TtmlNode.TEXT_EMPHASIS_AUTO, "_npa", zzu3.zzt.zzax().currentTimeMillis(), 1L));
                        }
                    }
                    zzgm[] zzgmArr = new zzgm[zzu2.size()];
                    for (int i11 = 0; i11 < zzu2.size(); i11++) {
                        zzgl zzd2 = zzgm.zzd();
                        zzd2.zzf(((zzlm) zzu2.get(i11)).zzc);
                        zzd2.zzg(((zzlm) zzu2.get(i11)).zzd);
                        zzr.zzf.zzu().zzv(zzd2, ((zzlm) zzu2.get(i11)).zze);
                        zzgmArr[i11] = (zzgm) zzd2.zzaD();
                    }
                    zzu.zzj(Arrays.asList(zzgmArr));
                    zzeu zzb2 = zzeu.zzb(zzau);
                    zzr.zzt.zzv().zzL(zzb2.zzd, zzr.zzf.zzh().zzi(str3));
                    zzr.zzt.zzv().zzN(zzb2, zzr.zzt.zzf().zzd(str3));
                    Bundle bundle2 = zzb2.zzd;
                    bundle2.putLong("_c", 1);
                    zzr.zzt.zzaA().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString(CrashlyticsAnalyticsListener.EVENT_ORIGIN_KEY, zzau.zzc);
                    if (zzr.zzt.zzv().zzaf(zzu.zzaq())) {
                        zzr.zzt.zzv().zzP(bundle2, "_dbg", 1L);
                        zzr.zzt.zzv().zzP(bundle2, "_r", 1L);
                    }
                    zzaq zzn = zzr.zzf.zzh().zzn(str3, zzau.zza);
                    if (zzn == null) {
                        zzgc = zzu;
                        zzh = zzj;
                        zzga = zza2;
                        str = str3;
                        bundle = bundle2;
                        str2 = null;
                        zzaq = new zzaq(str3, zzau.zza, 0, 0, 0, zzau.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j11 = 0;
                    } else {
                        zzh = zzj;
                        zzga = zza2;
                        str = str3;
                        bundle = bundle2;
                        zzgc = zzu;
                        str2 = null;
                        long j12 = zzn.zzf;
                        zzaq = zzn.zzc(zzau.zzd);
                        j11 = j12;
                    }
                    zzr.zzf.zzh().zzE(zzaq);
                    zzap zzap = new zzap(zzr.zzt, zzau.zzc, str, zzau.zza, zzau.zzd, j11, bundle);
                    zzfs zze = zzft.zze();
                    zze.zzm(zzap.zzd);
                    zze.zzi(zzap.zzb);
                    zze.zzl(zzap.zze);
                    zzar zzar = new zzar(zzap.zzf);
                    while (zzar.hasNext()) {
                        String zza3 = zzar.next();
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(zza3);
                        Object zzf = zzap.zzf.zzf(zza3);
                        if (zzf != null) {
                            zzr.zzf.zzu().zzu(zze2, zzf);
                            zze.zze(zze2);
                        }
                    }
                    zzgc zzgc2 = zzgc;
                    zzgc2.zzk(zze);
                    zzge zza4 = zzgg.zza();
                    zzfu zza5 = zzfv.zza();
                    zza5.zza(zzaq.zzc);
                    zza5.zzb(zzau.zza);
                    zza4.zza(zza5);
                    zzgc2.zzaa(zza4);
                    zzgc2.zzf(zzr.zzf.zzf().zza(zzh.zzv(), Collections.emptyList(), zzgc2.zzau(), Long.valueOf(zze.zzc()), Long.valueOf(zze.zzc())));
                    if (zze.zzq()) {
                        zzgc2.zzai(zze.zzc());
                        zzgc2.zzQ(zze.zzc());
                    }
                    long zzn2 = zzh.zzn();
                    int i12 = (zzn2 > 0 ? 1 : (zzn2 == 0 ? 0 : -1));
                    if (i12 != 0) {
                        zzgc2.zzab(zzn2);
                    }
                    long zzp = zzh.zzp();
                    if (zzp != 0) {
                        zzgc2.zzac(zzp);
                    } else if (i12 != 0) {
                        zzgc2.zzac(zzn2);
                    }
                    String zzD = zzh.zzD();
                    zzqu.zzc();
                    String str4 = str;
                    if (zzr.zzt.zzf().zzs(str4, zzeg.zzao) && zzD != null) {
                        zzgc2.zzah(zzD);
                    }
                    zzh.zzG();
                    zzgc2.zzI((int) zzh.zzo());
                    zzr.zzt.zzf().zzh();
                    zzgc2.zzam(79000);
                    zzgc2.zzal(zzr.zzt.zzax().currentTimeMillis());
                    zzgc2.zzag(true);
                    if (zzr.zzt.zzf().zzs(str2, zzeg.zzas)) {
                        zzr.zzf.zzC(zzgc2.zzaq(), zzgc2);
                    }
                    zzga zzga2 = zzga;
                    zzga2.zza(zzgc2);
                    zzh zzh2 = zzh;
                    zzh2.zzad(zzgc2.zzd());
                    zzh2.zzab(zzgc2.zzc());
                    zzr.zzf.zzh().zzD(zzh2);
                    zzr.zzf.zzh().zzC();
                    zzr.zzf.zzh().zzx();
                    try {
                        return zzr.zzf.zzu().zzz(((zzgb) zzga2.zzaD()).zzbx());
                    } catch (IOException e12) {
                        zzr.zzt.zzaA().zzd().zzc("Data loss. Failed to bundle and serialize. appId", zzet.zzn(str4), e12);
                        return str2;
                    }
                } catch (SecurityException e13) {
                    zzr.zzt.zzaA().zzc().zzb("app instance id encryption failed", e13.getMessage());
                    bArr = new byte[0];
                    zzlh = zzr.zzf;
                }
            }
            zzlh.zzh().zzx();
            return bArr;
        } else {
            zzr.zzt.zzaA().zzc().zzc("Generating a payload for this event is not available. package_name, event_name", str3, zzau.zza);
            return null;
        }
    }
}
