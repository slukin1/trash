package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.NetworkTypeObserver;

public final /* synthetic */ class d implements NetworkTypeObserver.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultBandwidthMeter f66080a;

    public /* synthetic */ d(DefaultBandwidthMeter defaultBandwidthMeter) {
        this.f66080a = defaultBandwidthMeter;
    }

    public final void onNetworkTypeChanged(int i11) {
        this.f66080a.onNetworkTypeChanged(i11);
    }
}
