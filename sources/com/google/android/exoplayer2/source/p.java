package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.SeekMap;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProgressiveMediaPeriod f66044b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SeekMap f66045c;

    public /* synthetic */ p(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.f66044b = progressiveMediaPeriod;
        this.f66045c = seekMap;
    }

    public final void run() {
        this.f66044b.lambda$seekMap$1(this.f66045c);
    }
}
