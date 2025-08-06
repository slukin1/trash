package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

public final class zaaj implements zabf {
    /* access modifiers changed from: private */
    public final zabi zaa;
    private boolean zab = false;

    public zaaj(zabi zabi) {
        this.zaa = zabi;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T zaa(T t11) {
        zab(t11);
        return t11;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T zab(T t11) {
        try {
            this.zaa.zag.zai.zaa(t11);
            zabe zabe = this.zaa.zag;
            Api.Client client = zabe.zac.get(t11.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.zaa.zab.containsKey(t11.getClientKey())) {
                t11.run(client);
            } else {
                t11.setFailedResult(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.zaa.zal(new zaah(this, this));
        }
        return t11;
    }

    public final void zad() {
    }

    public final void zae() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zal(new zaai(this, this));
        }
    }

    public final void zaf() {
        if (this.zab) {
            this.zab = false;
            this.zaa.zag.zai.zab();
            zaj();
        }
    }

    public final void zag(Bundle bundle) {
    }

    public final void zah(ConnectionResult connectionResult, Api<?> api, boolean z11) {
    }

    public final void zai(int i11) {
        this.zaa.zak((ConnectionResult) null);
        this.zaa.zah.zac(i11, this.zab);
    }

    public final boolean zaj() {
        if (this.zab) {
            return false;
        }
        Set<zada> set = this.zaa.zag.zah;
        if (set == null || set.isEmpty()) {
            this.zaa.zak((ConnectionResult) null);
            return true;
        }
        this.zab = true;
        for (zada zah : set) {
            zah.zah();
        }
        return false;
    }
}
