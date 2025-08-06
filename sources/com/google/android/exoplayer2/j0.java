package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaPeriodQueue f65919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImmutableList.Builder f65920c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaSource.MediaPeriodId f65921d;

    public /* synthetic */ j0(MediaPeriodQueue mediaPeriodQueue, ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f65919b = mediaPeriodQueue;
        this.f65920c = builder;
        this.f65921d = mediaPeriodId;
    }

    public final void run() {
        this.f65919b.lambda$notifyQueueUpdate$0(this.f65920c, this.f65921d);
    }
}
