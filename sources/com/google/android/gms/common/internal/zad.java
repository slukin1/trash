package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class zad extends zag {
    public final /* synthetic */ Intent zaa;
    public final /* synthetic */ Activity zab;
    public final /* synthetic */ int zac;

    public zad(Intent intent, Activity activity, int i11) {
        this.zaa = intent;
        this.zab = activity;
        this.zac = i11;
    }

    public final void zaa() {
        Intent intent = this.zaa;
        if (intent != null) {
            this.zab.startActivityForResult(intent, this.zac);
        }
    }
}
