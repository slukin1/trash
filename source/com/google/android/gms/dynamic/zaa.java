package com.google.android.gms.dynamic;

import java.util.Iterator;

final class zaa implements OnDelegateCreatedListener {
    public final /* synthetic */ DeferredLifecycleHelper zaa;

    public zaa(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa = lifecycleDelegate;
        Iterator it2 = this.zaa.zac.iterator();
        while (it2.hasNext()) {
            ((zah) it2.next()).zab(this.zaa.zaa);
        }
        this.zaa.zac.clear();
        this.zaa.zab = null;
    }
}
