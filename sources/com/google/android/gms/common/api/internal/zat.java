package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

public final class zat implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final Api<?> zaa;
    private final boolean zab;
    private zau zac;

    public zat(Api<?> api, boolean z11) {
        this.zaa = api;
        this.zab = z11;
    }

    private final zau zab() {
        Preconditions.checkNotNull(this.zac, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
        return this.zac;
    }

    public final void onConnected(Bundle bundle) {
        zab().onConnected(bundle);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zab().zaa(connectionResult, this.zaa, this.zab);
    }

    public final void onConnectionSuspended(int i11) {
        zab().onConnectionSuspended(i11);
    }

    public final void zaa(zau zau) {
        this.zac = zau;
    }
}
