package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

public final /* synthetic */ class s implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtractorsFactory f66048a;

    public /* synthetic */ s(ExtractorsFactory extractorsFactory) {
        this.f66048a = extractorsFactory;
    }

    public final ProgressiveMediaExtractor createProgressiveMediaExtractor() {
        return ProgressiveMediaSource.Factory.lambda$setExtractorsFactory$1(this.f66048a);
    }
}
