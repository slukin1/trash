package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;

final class zabt implements Runnable {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ zabu zab;

    public zabt(zabu zabu, ConnectionResult connectionResult) {
        this.zab = zabu;
        this.zaa = connectionResult;
    }

    public final void run() {
        zabu zabu = this.zab;
        zabq zabq = (zabq) zabu.zaa.zap.get(zabu.zac);
        if (zabq != null) {
            if (this.zaa.isSuccess()) {
                this.zab.zaf = true;
                if (this.zab.zab.requiresSignIn()) {
                    this.zab.zag();
                    return;
                }
                try {
                    zabu zabu2 = this.zab;
                    zabu2.zab.getRemoteService((IAccountAccessor) null, zabu2.zab.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException e11) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e11);
                    this.zab.zab.disconnect("Failed to get service from broker.");
                    zabq.zar(new ConnectionResult(10), (Exception) null);
                }
            } else {
                zabq.zar(this.zaa, (Exception) null);
            }
        }
    }
}
