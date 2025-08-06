package com.tencent.thumbplayer.tcmedia.core.demuxer;

public interface ITPNativeDemuxerCallback {
    void onDurationUpdated();

    TPNativeRemoteSdpInfo onSdpExchange(String str, int i11);
}
