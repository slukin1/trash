package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;

public final /* synthetic */ class a implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AsynchronousMediaCodecAdapter f65931a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f65932b;

    public /* synthetic */ a(AsynchronousMediaCodecAdapter asynchronousMediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener) {
        this.f65931a = asynchronousMediaCodecAdapter;
        this.f65932b = onFrameRenderedListener;
    }

    public final void onFrameRendered(MediaCodec mediaCodec, long j11, long j12) {
        this.f65931a.lambda$setOnFrameRenderedListener$0(this.f65932b, mediaCodec, j11, j12);
    }
}
