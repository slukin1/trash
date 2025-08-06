package com.tencent.thumbplayer.tcmedia.core.player;

import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;

public interface ITPNativePlayerEventRecordCallback {
    void onDrmInfo(TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams);
}
