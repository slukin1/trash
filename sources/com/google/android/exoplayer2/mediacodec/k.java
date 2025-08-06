package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class k implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SynchronousMediaCodecAdapter f65943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f65944b;

    public /* synthetic */ k(SynchronousMediaCodecAdapter synchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f65943a = synchronousMediaCodecAdapter;
        this.f65944b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
        this.f65943a.lambda$setOnFrameRenderedListener$0(this.f65944b, mediaCodec, j11, j12);
    }
}
