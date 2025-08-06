package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zabl implements BackgroundDetector.BackgroundStateChangeListener {
    public final /* synthetic */ GoogleApiManager zaa;

    public zabl(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z11) {
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zat.sendMessage(googleApiManager.zat.obtainMessage(1, Boolean.valueOf(z11)));
    }
}
