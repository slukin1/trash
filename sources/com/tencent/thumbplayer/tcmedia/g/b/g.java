package com.tencent.thumbplayer.tcmedia.g.b;

import android.media.MediaCodec;
import com.tencent.thumbplayer.tcmedia.g.f.a;
import com.tencent.thumbplayer.tcmedia.g.h.c;

public final class g extends f {
    public g(MediaCodec mediaCodec, e eVar) {
        super(mediaCodec, eVar);
    }

    public final a.b a(e eVar) {
        if (a.a((f) this, eVar)) {
            int i11 = eVar.f49232b;
            b bVar = this.f49250g;
            if (i11 <= bVar.f49224a && eVar.f49233c <= bVar.f49225b && c.a((f) this, eVar) <= this.f49250g.f49226c) {
                return eVar.a(this.f49248e) ? a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION : a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION;
            }
        }
        return a.b.KEEP_CODEC_RESULT_NO;
    }

    public final boolean j() {
        return super.j() && this.f49249f != null && this.f49248e.f49234d == 0;
    }

    public final String toString() {
        return "VideoCodecWrapper[" + hashCode() + ']';
    }
}
