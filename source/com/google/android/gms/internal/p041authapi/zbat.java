package com.google.android.gms.internal.p041authapi;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.identity.zbp;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;

/* renamed from: com.google.android.gms.internal.auth-api.zbat  reason: invalid package */
final class zbat extends Api.AbstractClientBuilder {
    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zbaz(context, looper, (zbp) obj, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
