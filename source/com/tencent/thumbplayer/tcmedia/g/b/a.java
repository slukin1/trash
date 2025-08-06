package com.tencent.thumbplayer.tcmedia.g.b;

import android.media.MediaCodec;
import com.tencent.thumbplayer.tcmedia.g.f.a;

public final class a extends f {
    public a(MediaCodec mediaCodec, e eVar) {
        super(mediaCodec, eVar);
    }

    public final a.b a(e eVar) {
        return com.tencent.thumbplayer.tcmedia.g.f.a.a((f) this, eVar) ? a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION : a.b.KEEP_CODEC_RESULT_NO;
    }

    public final String toString() {
        return "AudioCodecWrapper[" + hashCode() + ']';
    }
}
