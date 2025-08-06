package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzrd;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import java.util.HashMap;

public final class zzkw extends zzkt {
    public zzkw(zzlh zzlh) {
        super(zzlh);
    }

    private final String zzd(String str) {
        String zzi = this.zzf.zzm().zzi(str);
        if (TextUtils.isEmpty(zzi)) {
            return (String) zzeg.zzq.zza((Object) null);
        }
        Uri parse = Uri.parse((String) zzeg.zzq.zza((Object) null));
        Uri.Builder buildUpon = parse.buildUpon();
        String authority = parse.getAuthority();
        buildUpon.authority(zzi + InstructionFileId.DOT + authority);
        return buildUpon.build().toString();
    }

    public final zzkv zza(String str) {
        zzrd.zzc();
        zzkv zzkv = null;
        if (this.zzt.zzf().zzs((String) null, zzeg.zzaq)) {
            this.zzt.zzaA().zzj().zza("sgtm feature flag enabled.");
            zzh zzj = this.zzf.zzh().zzj(str);
            if (zzj == null) {
                return new zzkv(zzd(str));
            }
            if (zzj.zzap()) {
                this.zzt.zzaA().zzj().zza("sgtm upload enabled in manifest.");
                zzff zze = this.zzf.zzm().zze(zzj.zzv());
                if (zze != null) {
                    String zzj2 = zze.zzj();
                    if (!TextUtils.isEmpty(zzj2)) {
                        String zzi = zze.zzi();
                        this.zzt.zzaA().zzj().zzc("sgtm configured with upload_url, server_info", zzj2, true != TextUtils.isEmpty(zzi) ? KvStore.N : KvStore.Y);
                        if (TextUtils.isEmpty(zzi)) {
                            this.zzt.zzay();
                            zzkv = new zzkv(zzj2);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("x-google-sgtm-server-info", zzi);
                            zzkv = new zzkv(zzj2, hashMap);
                        }
                    }
                }
            }
            if (zzkv != null) {
                return zzkv;
            }
        }
        return new zzkv(zzd(str));
    }
}
