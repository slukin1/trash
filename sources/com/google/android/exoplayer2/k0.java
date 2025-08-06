package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;

public final /* synthetic */ class k0 implements MediaSource.MediaSourceCaller {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaSourceList f65924b;

    public /* synthetic */ k0(MediaSourceList mediaSourceList) {
        this.f65924b = mediaSourceList;
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        this.f65924b.lambda$prepareChildSource$0(mediaSource, timeline);
    }
}
