package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzov;
import com.hbg.lib.network.pro.core.util.Period;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

final class zzfi extends zzgx {
    public static final Pair zza = new Pair("", 0L);
    public zzfg zzb;
    public final zzfe zzc = new zzfe(this, "first_open_time", 0);
    public final zzfe zzd = new zzfe(this, "app_install_time", 0);
    public final zzfh zze = new zzfh(this, "app_instance_id", (String) null);
    public final zzfe zzf = new zzfe(this, "session_timeout", Period.MIN30_MILLS);
    public final zzfc zzg = new zzfc(this, "start_new_session", true);
    public final zzfh zzh = new zzfh(this, "non_personalized_ads", (String) null);
    public final zzfc zzi = new zzfc(this, "allow_remote_dynamite", false);
    public final zzfe zzj = new zzfe(this, "last_pause_time", 0);
    public final zzfe zzk = new zzfe(this, "session_id", 0);
    public boolean zzl;
    public final zzfc zzm = new zzfc(this, "app_backgrounded", false);
    public final zzfc zzn = new zzfc(this, "deep_link_retrieval_complete", false);
    public final zzfe zzo = new zzfe(this, "deep_link_retrieval_attempts", 0);
    public final zzfh zzp = new zzfh(this, "firebase_feature_rollouts", (String) null);
    public final zzfh zzq = new zzfh(this, "deferred_attribution_cache", (String) null);
    public final zzfe zzr = new zzfe(this, "deferred_attribution_cache_timestamp", 0);
    public final zzfd zzs = new zzfd(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzu;
    private String zzv;
    private boolean zzw;
    private long zzx;

    public zzfi(zzgd zzgd) {
        super(zzgd);
    }

    public final SharedPreferences zza() {
        zzg();
        zzv();
        Preconditions.checkNotNull(this.zzu);
        return this.zzu;
    }

    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzaC() {
        SharedPreferences sharedPreferences = this.zzt.zzaw().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzu = sharedPreferences;
        boolean z11 = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzl = z11;
        if (!z11) {
            SharedPreferences.Editor edit = this.zzu.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzt.zzf();
        this.zzb = new zzfg(this, "health_monitor", Math.max(0, ((Long) zzeg.zzc.zza((Object) null)).longValue()), (zzff) null);
    }

    public final Pair zzb(String str) {
        zzg();
        zzov.zzc();
        if (this.zzt.zzf().zzs((String) null, zzeg.zzaI) && !zzc().zzj(zzha.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long elapsedRealtime = this.zzt.zzax().elapsedRealtime();
        String str2 = this.zzv;
        if (str2 != null && elapsedRealtime < this.zzx) {
            return new Pair(str2, Boolean.valueOf(this.zzw));
        }
        this.zzx = elapsedRealtime + this.zzt.zzf().zzi(str, zzeg.zza);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.zzt.zzaw());
            this.zzv = "";
            String id2 = advertisingIdInfo.getId();
            if (id2 != null) {
                this.zzv = id2;
            }
            this.zzw = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e11) {
            this.zzt.zzaA().zzc().zzb("Unable to get advertising id", e11);
            this.zzv = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.zzv, Boolean.valueOf(this.zzw));
    }

    public final zzhb zzc() {
        zzg();
        return zzhb.zzc(zza().getString("consent_settings", "G1"), zza().getInt("consent_source", 100));
    }

    public final Boolean zzd() {
        zzg();
        if (zza().contains("measurement_enabled")) {
            return Boolean.valueOf(zza().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final boolean zzf() {
        return true;
    }

    public final void zzh(Boolean bool) {
        zzg();
        SharedPreferences.Editor edit = zza().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    public final void zzi(boolean z11) {
        zzg();
        this.zzt.zzaA().zzj().zzb("App measurement setting deferred collection", Boolean.valueOf(z11));
        SharedPreferences.Editor edit = zza().edit();
        edit.putBoolean("deferred_analytics_collection", z11);
        edit.apply();
    }

    public final boolean zzj() {
        SharedPreferences sharedPreferences = this.zzu;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final boolean zzk(long j11) {
        return j11 - this.zzf.zza() > this.zzj.zza();
    }

    public final boolean zzl(int i11) {
        return zzhb.zzk(i11, zza().getInt("consent_source", 100));
    }
}
