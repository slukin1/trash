package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class zan extends zabw {
    public final /* synthetic */ Dialog zaa;
    public final /* synthetic */ zao zab;

    public zan(zao zao, Dialog dialog) {
        this.zab = zao;
        this.zaa = dialog;
    }

    public final void zaa() {
        this.zab.zaa.zad();
        if (this.zaa.isShowing()) {
            this.zaa.dismiss();
        }
    }
}
