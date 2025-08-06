package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;

public final /* synthetic */ class a implements OutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SimpleSubtitleDecoder f66057a;

    public /* synthetic */ a(SimpleSubtitleDecoder simpleSubtitleDecoder) {
        this.f66057a = simpleSubtitleDecoder;
    }

    public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
        this.f66057a.releaseOutputBuffer((SubtitleOutputBuffer) outputBuffer);
    }
}
