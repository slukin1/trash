package com.google.android.gms.measurement.internal;

import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class zzkb extends zzku {
    public final zzfe zza;
    public final zzfe zzb;
    public final zzfe zzc;
    public final zzfe zzd;
    public final zzfe zze;
    private final Map zzg = new HashMap();

    public zzkb(zzlh zzlh) {
        super(zzlh);
        zzfi zzm = this.zzt.zzm();
        zzm.getClass();
        this.zza = new zzfe(zzm, "last_delete_stale", 0);
        zzfi zzm2 = this.zzt.zzm();
        zzm2.getClass();
        this.zzb = new zzfe(zzm2, "backoff", 0);
        zzfi zzm3 = this.zzt.zzm();
        zzm3.getClass();
        this.zzc = new zzfe(zzm3, "last_upload", 0);
        zzfi zzm4 = this.zzt.zzm();
        zzm4.getClass();
        this.zzd = new zzfe(zzm4, "last_upload_attempt", 0);
        zzfi zzm5 = this.zzt.zzm();
        zzm5.getClass();
        this.zze = new zzfe(zzm5, "midnight_offset", 0);
    }

    @Deprecated
    public final Pair zza(String str) {
        zzka zzka;
        zzg();
        long elapsedRealtime = this.zzt.zzax().elapsedRealtime();
        zzka zzka2 = (zzka) this.zzg.get(str);
        if (zzka2 != null && elapsedRealtime < zzka2.zzc) {
            return new Pair(zzka2.zza, Boolean.valueOf(zzka2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzi = this.zzt.zzf().zzi(str, zzeg.zza) + elapsedRealtime;
        try {
            long zzi2 = this.zzt.zzf().zzi(str, zzeg.zzb);
            AdvertisingIdClient.Info info = null;
            if (zzi2 > 0) {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzt.zzaw());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzka2 != null) {
                        if (elapsedRealtime < zzka2.zzc + zzi2) {
                            return new Pair(zzka2.zza, Boolean.valueOf(zzka2.zzb));
                        }
                    }
                }
            } else {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzt.zzaw());
            }
            if (info == null) {
                return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
            }
            String id2 = info.getId();
            if (id2 != null) {
                zzka = new zzka(id2, info.isLimitAdTrackingEnabled(), zzi);
            } else {
                zzka = new zzka("", info.isLimitAdTrackingEnabled(), zzi);
            }
            this.zzg.put(str, zzka);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(zzka.zza, Boolean.valueOf(zzka.zzb));
        } catch (Exception e11) {
            this.zzt.zzaA().zzc().zzb("Unable to get advertising id", e11);
            zzka = new zzka("", false, zzi);
        }
    }

    public final boolean zzb() {
        return false;
    }

    public final Pair zzd(String str, zzhb zzhb) {
        if (zzhb.zzj(zzha.AD_STORAGE)) {
            return zza(str);
        }
        return new Pair("", Boolean.FALSE);
    }

    @Deprecated
    public final String zzf(String str, boolean z11) {
        zzg();
        String str2 = z11 ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest zzF = zzlp.zzF();
        if (zzF == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzF.digest(str2.getBytes()))});
    }
}
