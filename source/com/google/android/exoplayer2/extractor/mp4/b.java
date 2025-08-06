package com.google.android.exoplayer2.extractor.mp4;

import com.google.common.base.Function;

public final /* synthetic */ class b implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentedMp4Extractor f65899b;

    public /* synthetic */ b(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.f65899b = fragmentedMp4Extractor;
    }

    public final Object apply(Object obj) {
        return this.f65899b.modifyTrack((Track) obj);
    }
}
