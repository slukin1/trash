package com.tencent.thumbplayer.tcmedia.core.player;

import com.tencent.thumbplayer.tcmedia.core.common.TPSubtitleFrame;

public interface ITPNativePlayerSubtitleFrameCallback {
    public static final int FLAG_EOS = 1;

    void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame, int i11);
}
