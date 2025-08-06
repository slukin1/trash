package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zacv extends TaskApiCall {
    public final /* synthetic */ TaskApiCall.Builder zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacv(TaskApiCall.Builder builder, Feature[] featureArr, boolean z11, int i11) {
        super(featureArr, z11, i11);
        this.zaa = builder;
    }

    public final void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zaa.zaa.accept(anyClient, taskCompletionSource);
    }
}
