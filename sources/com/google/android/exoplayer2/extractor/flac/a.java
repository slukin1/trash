package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

public final /* synthetic */ class a implements BinarySearchSeeker.SeekTimestampConverter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlacStreamMetadata f65890a;

    public /* synthetic */ a(FlacStreamMetadata flacStreamMetadata) {
        this.f65890a = flacStreamMetadata;
    }

    public final long timeUsToTargetTime(long j11) {
        return this.f65890a.getSampleNumber(j11);
    }
}
