package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66100b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f66101c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f66102d;

    public /* synthetic */ e(VideoRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f66100b = eventDispatcher;
        this.f66101c = format;
        this.f66102d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f66100b.lambda$inputFormatChanged$2(this.f66101c, this.f66102d);
    }
}
