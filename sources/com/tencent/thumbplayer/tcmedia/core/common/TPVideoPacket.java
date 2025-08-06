package com.tencent.thumbplayer.tcmedia.core.common;

import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerSurfaceDolbyVisionInfo;

public class TPVideoPacket {
    public byte[] mData;
    public TPNativePlayerSurfaceDolbyVisionInfo mDolbyVisionInfo;
    public long mDtsUs;
    public long mPtsUs;
    public int mSize;
}
