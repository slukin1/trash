package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

public final /* synthetic */ class g implements MediaCodecUtil.ScoreProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format f65939a;

    public /* synthetic */ g(Format format) {
        this.f65939a = format;
    }

    public final int getScore(Object obj) {
        return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(this.f65939a, (MediaCodecInfo) obj);
    }
}
