package com.google.android.gms.measurement.internal;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzfn implements Callable {
    public final /* synthetic */ zzfu zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfn(zzfu zzfu, String str) {
        this.zza = zzfu;
        this.zzb = str;
    }

    public final Object call() {
        zzfu zzfu = this.zza;
        String str = this.zzb;
        zzh zzj = zzfu.zzf.zzh().zzj(str);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "android");
        hashMap.put(Constants.PACKAGE_NAME, str);
        zzfu.zzt.zzf().zzh();
        hashMap.put("gmp_version", 79000L);
        if (zzj != null) {
            String zzy = zzj.zzy();
            if (zzy != null) {
                hashMap.put(Constants.EXTRA_KEY_APP_VERSION, zzy);
            }
            hashMap.put("app_version_int", Long.valueOf(zzj.zzb()));
            hashMap.put("dynamite_version", Long.valueOf(zzj.zzk()));
        }
        return hashMap;
    }
}
