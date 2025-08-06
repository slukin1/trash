package com.tencent.thumbplayer.tcmedia.api;

public interface ITPSurfaceListener {
    void onFlush();

    void onRenderInfo(TPSurfaceRenderInfo tPSurfaceRenderInfo);

    void onVideoPacket(TPVideoPacketBuffer tPVideoPacketBuffer);
}
