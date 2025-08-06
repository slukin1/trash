package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;

public final /* synthetic */ class c implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f65998a = new c();

    public final ProgressiveMediaExtractor createProgressiveMediaExtractor() {
        return new MediaParserExtractorAdapter();
    }
}
