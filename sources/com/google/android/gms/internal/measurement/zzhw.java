package com.google.android.gms.internal.measurement;

import android.util.Log;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;

final class zzhw extends zzib {
    public zzhw(zzhy zzhy, String str, Double d11, boolean z11) {
        super(zzhy, "measurement.test.double_flag", d11, true, (zzia) null);
    }

    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String str = this.zzb;
            Log.e("PhenotypeFlag", "Invalid double value for " + str + l.f34627b + ((String) obj));
            return null;
        }
    }
}
