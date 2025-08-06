package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.Collections;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public final class zaax implements zabf {
    @NotOnlyInitialized
    private final zabi zaa;

    public zaax(zabi zabi) {
        this.zaa = zabi;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t11) {
        this.zaa.zag.zaa.add(t11);
        return t11;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t11) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void zad() {
        for (Api.Client disconnect : this.zaa.zaa.values()) {
            disconnect.disconnect();
        }
        this.zaa.zag.zad = Collections.emptySet();
    }

    public final void zae() {
        this.zaa.zaj();
    }

    public final void zag(Bundle bundle) {
    }

    public final void zah(ConnectionResult connectionResult, Api<?> api, boolean z11) {
    }

    public final void zai(int i11) {
    }

    public final boolean zaj() {
        return true;
    }
}
