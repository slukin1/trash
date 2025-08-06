package com.google.android.gms.internal.p041authapi;

import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbaq  reason: invalid package */
public final /* synthetic */ class zbaq implements RemoteCall {
    public final /* synthetic */ zbay zba;
    public final /* synthetic */ GetSignInIntentRequest zbb;

    public /* synthetic */ zbaq(zbay zbay, GetSignInIntentRequest getSignInIntentRequest) {
        this.zba = zbay;
        this.zbb = getSignInIntentRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbay zbay = this.zba;
        GetSignInIntentRequest getSignInIntentRequest = this.zbb;
        ((zbai) ((zbaz) obj).getService()).zbe(new zbaw(zbay, (TaskCompletionSource) obj2), (GetSignInIntentRequest) Preconditions.checkNotNull(getSignInIntentRequest));
    }
}
