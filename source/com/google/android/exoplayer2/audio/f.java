package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65828b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Format f65829c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DecoderReuseEvaluation f65830d;

    public /* synthetic */ f(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f65828b = eventDispatcher;
        this.f65829c = format;
        this.f65830d = decoderReuseEvaluation;
    }

    public final void run() {
        this.f65828b.lambda$inputFormatChanged$2(this.f65829c, this.f65830d);
    }
}
