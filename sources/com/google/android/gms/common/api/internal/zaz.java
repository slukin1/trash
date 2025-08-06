package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class zaz implements zabz {
    public final /* synthetic */ zaaa zaa;

    public /* synthetic */ zaz(zaaa zaaa, zay zay) {
        this.zaa = zaaa;
    }

    public final void zaa(ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zak = connectionResult;
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public final void zab(Bundle bundle) {
        this.zaa.zam.lock();
        try {
            this.zaa.zak = ConnectionResult.RESULT_SUCCESS;
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public final void zac(int i11, boolean z11) {
        Lock zaj;
        this.zaa.zam.lock();
        try {
            zaaa zaaa = this.zaa;
            if (zaaa.zal) {
                zaaa.zal = false;
                zaaa.zan(this.zaa, i11, z11);
                zaj = this.zaa.zam;
            } else {
                zaaa.zal = true;
                this.zaa.zad.onConnectionSuspended(i11);
                zaj = this.zaa.zam;
            }
            zaj.unlock();
        } catch (Throwable th2) {
            this.zaa.zam.unlock();
            throw th2;
        }
    }
}
