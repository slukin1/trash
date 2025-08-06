package com.tencent.ugc.videobase.frame;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::ugc")
public class MirrorInfo {
    public boolean isHorizontal = false;
    public boolean isVertical = false;

    public MirrorInfo() {
    }

    public MirrorInfo(boolean z11, boolean z12) {
        this.isHorizontal = z11;
        this.isVertical = z12;
    }
}
