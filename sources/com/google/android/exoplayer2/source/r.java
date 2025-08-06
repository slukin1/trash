package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

public final /* synthetic */ class r implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtractorsFactory f66047a;

    public /* synthetic */ r(ExtractorsFactory extractorsFactory) {
        this.f66047a = extractorsFactory;
    }

    public final ProgressiveMediaExtractor createProgressiveMediaExtractor() {
        return ProgressiveMediaSource.Factory.lambda$new$0(this.f66047a);
    }
}
