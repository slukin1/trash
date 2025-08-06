package com.google.android.gms.dynamic;

import android.os.Bundle;

final class zac implements zah {
    public final /* synthetic */ Bundle zaa;
    public final /* synthetic */ DeferredLifecycleHelper zab;

    public zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.zab = deferredLifecycleHelper;
        this.zaa = bundle;
    }

    public final int zaa() {
        return 1;
    }

    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zab.zaa.onCreate(this.zaa);
    }
}
