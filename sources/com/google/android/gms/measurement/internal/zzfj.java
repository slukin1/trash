package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.firebase.messaging.Constants;
import com.xiaomi.mipush.sdk.Constants;

final class zzfj implements Runnable {
    public final /* synthetic */ zzbr zza;
    public final /* synthetic */ ServiceConnection zzb;
    public final /* synthetic */ zzfk zzc;

    public zzfj(zzfk zzfk, zzbr zzbr, ServiceConnection serviceConnection) {
        this.zzc = zzfk;
        this.zza = zzbr;
        this.zzb = serviceConnection;
    }

    public final void run() {
        Bundle bundle;
        zzfk zzfk = this.zzc;
        zzfl zzfl = zzfk.zza;
        String zza2 = zzfk.zzb;
        zzbr zzbr = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        zzfl.zza.zzaB().zzg();
        Bundle bundle2 = new Bundle();
        bundle2.putString(Constants.PACKAGE_NAME, zza2);
        try {
            bundle = zzbr.zzd(bundle2);
            if (bundle == null) {
                zzfl.zza.zzaA().zzd().zza("Install Referrer Service returned a null response");
                bundle = null;
            }
        } catch (Exception e11) {
            zzfl.zza.zzaA().zzd().zzb("Exception occurred while retrieving the Install Referrer", e11.getMessage());
        }
        zzfl.zza.zzaB().zzg();
        zzgd.zzO();
        if (bundle != null) {
            long j11 = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j11 == 0) {
                zzfl.zza.zzaA().zzk().zza("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString(com.adjust.sdk.Constants.INSTALL_REFERRER);
                if (string == null || string.isEmpty()) {
                    zzfl.zza.zzaA().zzd().zza("No referrer defined in Install Referrer response");
                } else {
                    zzfl.zza.zzaA().zzj().zzb("InstallReferrer API result", string);
                    zzlp zzv = zzfl.zza.zzv();
                    Uri parse = Uri.parse("?".concat(string));
                    zzra.zzc();
                    Bundle zzs = zzv.zzs(parse, zzfl.zza.zzf().zzs((String) null, zzeg.zzaw));
                    if (zzs == null) {
                        zzfl.zza.zzaA().zzd().zza("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = zzs.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j12 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j12 == 0) {
                                zzfl.zza.zzaA().zzd().zza("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                zzs.putLong("click_timestamp", j12);
                            }
                        }
                        if (j11 == zzfl.zza.zzm().zzd.zza()) {
                            zzfl.zza.zzaA().zzj().zza("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (zzfl.zza.zzJ()) {
                            zzfl.zza.zzm().zzd.zzb(j11);
                            zzfl.zza.zzaA().zzj().zzb("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            zzs.putString("_cis", "referrer API v2");
                            zzfl.zza.zzq().zzF(TtmlNode.TEXT_EMPHASIS_AUTO, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, zzs, zza2);
                        }
                    }
                }
            }
        }
        ConnectionTracker.getInstance().unbindService(zzfl.zza.zzaw(), serviceConnection);
    }
}
