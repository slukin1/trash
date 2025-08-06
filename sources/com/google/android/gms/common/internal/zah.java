package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zah implements BaseGmsClient.BaseConnectionCallbacks {
    public final /* synthetic */ ConnectionCallbacks zaa;

    public zah(ConnectionCallbacks connectionCallbacks) {
        this.zaa = connectionCallbacks;
    }

    public final void onConnected(Bundle bundle) {
        this.zaa.onConnected(bundle);
    }

    public final void onConnectionSuspended(int i11) {
        this.zaa.onConnectionSuspended(i11);
    }
}
