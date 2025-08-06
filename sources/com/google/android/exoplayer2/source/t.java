package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class t implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ t f66051a = new t();

    public final void accept(Object obj) {
        ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
    }
}
