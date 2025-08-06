package com.google.android.gms.internal.p041authapi;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbap  reason: invalid package */
public final /* synthetic */ class zbap implements RemoteCall {
    public final /* synthetic */ zbay zba;
    public final /* synthetic */ BeginSignInRequest zbb;

    public /* synthetic */ zbap(zbay zbay, BeginSignInRequest beginSignInRequest) {
        this.zba = zbay;
        this.zbb = beginSignInRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zbay zbay = this.zba;
        BeginSignInRequest beginSignInRequest = this.zbb;
        ((zbai) ((zbaz) obj).getService()).zbc(new zbau(zbay, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(beginSignInRequest));
    }
}
