package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

final class zabp implements BaseGmsClient.SignOutCallbacks {
    public final /* synthetic */ zabq zaa;

    public zabp(zabq zabq) {
        this.zaa = zabq;
    }

    public final void onSignOutComplete() {
        this.zaa.zaa.zat.post(new zabo(this));
    }
}
