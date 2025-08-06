package com.google.android.gms.internal.auth;

import android.util.Base64;
import android.util.Log;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.IOException;

final class zzcy extends zzdc {
    public final /* synthetic */ zzhu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcy(zzcz zzcz, String str, Object obj, boolean z11, zzhu zzhu, byte[] bArr) {
        super(zzcz, "getTokenRefactor__blocked_packages", obj, true, (zzdb) null);
        this.zza = zzhu;
    }

    public final Object zza(Object obj) {
        try {
            return zzhr.zzk(Base64.decode((String) obj, 3));
        } catch (IOException | IllegalArgumentException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid byte[] value for " + zzc + l.f34627b + ((String) obj));
            return null;
        }
    }
}
