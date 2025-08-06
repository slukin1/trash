package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;

public final /* synthetic */ class a implements MediaSource.MediaSourceCaller {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompositeMediaSource f65981b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f65982c;

    public /* synthetic */ a(CompositeMediaSource compositeMediaSource, Object obj) {
        this.f65981b = compositeMediaSource;
        this.f65982c = obj;
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        this.f65981b.lambda$prepareChildSource$0(this.f65982c, mediaSource, timeline);
    }
}
