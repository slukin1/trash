package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = f.f65938a;

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException;
}
