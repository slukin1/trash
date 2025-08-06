package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder;

public final /* synthetic */ class b implements OutputBuffer.Owner {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CeaDecoder f66059a;

    public /* synthetic */ b(CeaDecoder ceaDecoder) {
        this.f66059a = ceaDecoder;
    }

    public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
        this.f66059a.releaseOutputBuffer((CeaDecoder.CeaOutputBuffer) outputBuffer);
    }
}
