package com.tencent.ugc;

import com.tencent.ugc.videobase.frame.PixelFrame;

public class UGCVideoFrame extends PixelFrame {
    private boolean isEosFrame;

    public boolean isEosFrame() {
        return this.isEosFrame;
    }

    public void setEosFrame(boolean z11) {
        this.isEosFrame = z11;
    }
}
