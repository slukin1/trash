package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zaap extends zaav {
    public final /* synthetic */ zaaw zaa;
    private final ArrayList<Api.Client> zac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaaw, ArrayList<Api.Client> arrayList) {
        super(zaaw, (zaau) null);
        this.zaa = zaaw;
        this.zac = arrayList;
    }

    public final void zaa() {
        zaaw zaaw = this.zaa;
        zaaw.zaa.zag.zad = zaaw.zao(zaaw);
        ArrayList<Api.Client> arrayList = this.zac;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zaaw zaaw2 = this.zaa;
            arrayList.get(i11).getRemoteService(zaaw2.zao, zaaw2.zaa.zag.zad);
        }
    }
}
