package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;

final class zaao extends zaav {
    public final /* synthetic */ zaaw zaa;
    private final Map<Api.Client, zaal> zac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaaw, Map<Api.Client, zaal> map) {
        super(zaaw, (zaau) null);
        this.zaa = zaaw;
        this.zac = map;
    }

    public final void zaa() {
        zal zal = new zal(this.zaa.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client next : this.zac.keySet()) {
            if (!next.requiresGooglePlayServices() || this.zac.get(next).zac) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i11 = -1;
        int i12 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i12 < size) {
                i11 = zal.zab(this.zaa.zac, (Api.Client) arrayList.get(i12));
                i12++;
                if (i11 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i12 < size2) {
                i11 = zal.zab(this.zaa.zac, (Api.Client) arrayList2.get(i12));
                i12++;
                if (i11 == 0) {
                    break;
                }
            }
        }
        if (i11 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i11, (PendingIntent) null);
            zaaw zaaw = this.zaa;
            zaaw.zaa.zal(new zaam(this, zaaw, connectionResult));
            return;
        }
        zaaw zaaw2 = this.zaa;
        if (zaaw2.zam && zaaw2.zak != null) {
            zaaw2.zak.zab();
        }
        for (Api.Client next2 : this.zac.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zac.get(next2);
            if (!next2.requiresGooglePlayServices() || zal.zab(this.zaa.zac, next2) == 0) {
                next2.connect(connectionProgressReportCallbacks);
            } else {
                zaaw zaaw3 = this.zaa;
                zaaw3.zaa.zal(new zaan(this, zaaw3, connectionProgressReportCallbacks));
            }
        }
    }
}
