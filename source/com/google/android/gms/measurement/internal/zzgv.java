package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public final class zzgv extends zzei {
    /* access modifiers changed from: private */
    public final zzlh zza;
    private Boolean zzb;
    private String zzc = null;

    public zzgv(zzlh zzlh, String str) {
        Preconditions.checkNotNull(zzlh);
        this.zza = zzlh;
    }

    private final void zzA(zzau zzau, zzq zzq) {
        this.zza.zzA();
        this.zza.zzE(zzau, zzq);
    }

    private final void zzy(zzq zzq, boolean z11) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.zza);
        zzz(zzq.zza, false);
        this.zza.zzv().zzY(zzq.zzb, zzq.zzq);
    }

    private final void zzz(String str, boolean z11) {
        boolean z12;
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzaw(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzaw()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z12 = false;
                                this.zzb = Boolean.valueOf(z12);
                            }
                        }
                        z12 = true;
                        this.zzb = Boolean.valueOf(z12);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e11) {
                    this.zza.zzaA().zzd().zzb("Measurement Service called with invalid calling package. appId", zzet.zzn(str));
                    throw e11;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzaw(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzaA().zzd().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    public final zzau zzb(zzau zzau, zzq zzq) {
        zzas zzas;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzau.zza) || (zzas = zzau.zzb) == null || zzas.zza() == 0)) {
            String zzg = zzau.zzb.zzg("_cis");
            if ("referrer broadcast".equals(zzg) || "referrer API".equals(zzg)) {
                this.zza.zzaA().zzi().zzb("Event has been filtered ", zzau.toString());
                return new zzau("_cmpx", zzau.zzb, zzau.zzc, zzau.zzd);
            }
        }
        return zzau;
    }

    public final String zzd(zzq zzq) {
        zzy(zzq, false);
        return this.zza.zzx(zzq);
    }

    public final List zze(zzq zzq, boolean z11) {
        zzy(zzq, false);
        String str = zzq.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzlm> list = (List) this.zza.zzaB().zzh(new zzgs(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlm zzlm : list) {
                if (z11 || !zzlp.zzaj(zzlm.zzc)) {
                    arrayList.add(new zzlk(zzlm));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e11) {
            this.zza.zzaA().zzd().zzc("Failed to get user properties. appId", zzet.zzn(zzq.zza), e11);
            return null;
        }
    }

    public final List zzf(String str, String str2, zzq zzq) {
        zzy(zzq, false);
        String str3 = zzq.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaB().zzh(new zzgj(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e11) {
            this.zza.zzaA().zzd().zzb("Failed to get conditional user properties", e11);
            return Collections.emptyList();
        }
    }

    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        try {
            return (List) this.zza.zzaB().zzh(new zzgk(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e11) {
            this.zza.zzaA().zzd().zzb("Failed to get conditional user properties as", e11);
            return Collections.emptyList();
        }
    }

    public final List zzh(String str, String str2, boolean z11, zzq zzq) {
        zzy(zzq, false);
        String str3 = zzq.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzlm> list = (List) this.zza.zzaB().zzh(new zzgh(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlm zzlm : list) {
                if (z11 || !zzlp.zzaj(zzlm.zzc)) {
                    arrayList.add(new zzlk(zzlm));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e11) {
            this.zza.zzaA().zzd().zzc("Failed to query user properties. appId", zzet.zzn(zzq.zza), e11);
            return Collections.emptyList();
        }
    }

    public final List zzi(String str, String str2, String str3, boolean z11) {
        zzz(str, true);
        try {
            List<zzlm> list = (List) this.zza.zzaB().zzh(new zzgi(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzlm zzlm : list) {
                if (z11 || !zzlp.zzaj(zzlm.zzc)) {
                    arrayList.add(new zzlk(zzlm));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e11) {
            this.zza.zzaA().zzd().zzc("Failed to get user properties as. appId", zzet.zzn(str), e11);
            return Collections.emptyList();
        }
    }

    public final void zzj(zzq zzq) {
        zzy(zzq, false);
        zzx(new zzgt(this, zzq));
    }

    public final void zzk(zzau zzau, zzq zzq) {
        Preconditions.checkNotNull(zzau);
        zzy(zzq, false);
        zzx(new zzgo(this, zzau, zzq));
    }

    public final void zzl(zzau zzau, String str, String str2) {
        Preconditions.checkNotNull(zzau);
        Preconditions.checkNotEmpty(str);
        zzz(str, true);
        zzx(new zzgp(this, zzau, str));
    }

    public final void zzm(zzq zzq) {
        Preconditions.checkNotEmpty(zzq.zza);
        zzz(zzq.zza, false);
        zzx(new zzgl(this, zzq));
    }

    public final void zzn(zzac zzac, zzq zzq) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotNull(zzac.zzc);
        zzy(zzq, false);
        zzac zzac2 = new zzac(zzac);
        zzac2.zza = zzq.zza;
        zzx(new zzgf(this, zzac2, zzq));
    }

    public final void zzo(zzac zzac) {
        Preconditions.checkNotNull(zzac);
        Preconditions.checkNotNull(zzac.zzc);
        Preconditions.checkNotEmpty(zzac.zza);
        zzz(zzac.zza, true);
        zzx(new zzgg(this, new zzac(zzac)));
    }

    public final void zzp(zzq zzq) {
        Preconditions.checkNotEmpty(zzq.zza);
        Preconditions.checkNotNull(zzq.zzv);
        zzgn zzgn = new zzgn(this, zzq);
        Preconditions.checkNotNull(zzgn);
        if (this.zza.zzaB().zzs()) {
            zzgn.run();
        } else {
            this.zza.zzaB().zzq(zzgn);
        }
    }

    public final void zzq(long j11, String str, String str2, String str3) {
        zzx(new zzgu(this, str2, str3, str, j11));
    }

    public final void zzr(Bundle bundle, zzq zzq) {
        zzy(zzq, false);
        String str = zzq.zza;
        Preconditions.checkNotNull(str);
        zzx(new zzge(this, str, bundle));
    }

    public final void zzs(zzq zzq) {
        zzy(zzq, false);
        zzx(new zzgm(this, zzq));
    }

    public final void zzt(zzlk zzlk, zzq zzq) {
        Preconditions.checkNotNull(zzlk);
        zzy(zzq, false);
        zzx(new zzgr(this, zzlk, zzq));
    }

    public final byte[] zzu(zzau zzau, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzau);
        zzz(str, true);
        this.zza.zzaA().zzc().zzb("Log and bundle. event", this.zza.zzi().zzd(zzau.zza));
        long nanoTime = this.zza.zzax().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzaB().zzi(new zzgq(this, zzau, str)).get();
            if (bArr == null) {
                this.zza.zzaA().zzd().zzb("Log and bundle returned null. appId", zzet.zzn(str));
                bArr = new byte[0];
            }
            this.zza.zzaA().zzc().zzd("Log and bundle processed. event, size, time_ms", this.zza.zzi().zzd(zzau.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzax().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e11) {
            this.zza.zzaA().zzd().zzd("Failed to log and bundle. appId, event, error", zzet.zzn(str), this.zza.zzi().zzd(zzau.zza), e11);
            return null;
        }
    }

    public final void zzv(zzau zzau, zzq zzq) {
        zzc zzc2;
        if (!this.zza.zzm().zzo(zzq.zza)) {
            zzA(zzau, zzq);
            return;
        }
        this.zza.zzaA().zzj().zzb("EES config found for", zzq.zza);
        zzfu zzm = this.zza.zzm();
        String str = zzq.zza;
        if (TextUtils.isEmpty(str)) {
            zzc2 = null;
        } else {
            zzc2 = (zzc) zzm.zzd.get(str);
        }
        if (zzc2 != null) {
            try {
                Map zzt = this.zza.zzu().zzt(zzau.zzb.zzc(), true);
                String zza2 = zzhc.zza(zzau.zza);
                if (zza2 == null) {
                    zza2 = zzau.zza;
                }
                if (zzc2.zze(new zzaa(zza2, zzau.zzd, zzt))) {
                    if (zzc2.zzg()) {
                        this.zza.zzaA().zzj().zzb("EES edited event", zzau.zza);
                        zzA(this.zza.zzu().zzj(zzc2.zza().zzb()), zzq);
                    } else {
                        zzA(zzau, zzq);
                    }
                    if (zzc2.zzf()) {
                        for (zzaa zzaa : zzc2.zza().zzc()) {
                            this.zza.zzaA().zzj().zzb("EES logging created event", zzaa.zzd());
                            zzA(this.zza.zzu().zzj(zzaa), zzq);
                        }
                        return;
                    }
                    return;
                }
            } catch (zzd unused) {
                this.zza.zzaA().zzd().zzc("EES error. appId, eventName", zzq.zzb, zzau.zza);
            }
            this.zza.zzaA().zzj().zzb("EES was not applied to event", zzau.zza);
            zzA(zzau, zzq);
            return;
        }
        this.zza.zzaA().zzj().zzb("EES not loaded for", zzq.zza);
        zzA(zzau, zzq);
    }

    public final /* synthetic */ void zzw(String str, Bundle bundle) {
        zzak zzh = this.zza.zzh();
        zzh.zzg();
        zzh.zzW();
        byte[] zzbx = zzh.zzf.zzu().zzl(new zzap(zzh.zzt, "", str, "dep", 0, 0, bundle)).zzbx();
        zzh.zzt.zzaA().zzj().zzc("Saving default event parameters, appId, data size", zzh.zzt.zzj().zzd(str), Integer.valueOf(zzbx.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", zzbx);
        try {
            if (zzh.zzh().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                zzh.zzt.zzaA().zzd().zzb("Failed to insert default event parameters (got -1). appId", zzet.zzn(str));
            }
        } catch (SQLiteException e11) {
            zzh.zzt.zzaA().zzd().zzc("Error storing default event parameters. appId", zzet.zzn(str), e11);
        }
    }

    public final void zzx(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzaB().zzs()) {
            runnable.run();
        } else {
            this.zza.zzaB().zzp(runnable);
        }
    }
}
