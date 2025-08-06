package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzr extends zzp<Bundle> {
    public zzr(int i11, int i12, Bundle bundle) {
        super(i11, 1, bundle);
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    public final boolean zzb() {
        return false;
    }
}
