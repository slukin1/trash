package com.tencent.ugc.renderer;

import android.view.Surface;
import com.tencent.ugc.videobase.frame.PixelFrame;

public abstract class VideoRenderListener {

    public enum RenderResult {
        RENDER_FAILED,
        RENDER_ON_VIEW,
        RENDER_WITHOUT_VIEW,
        RENDER_WITH_HDR
    }

    public void onRenderFrame(PixelFrame pixelFrame, RenderResult renderResult) {
    }

    public void onRenderSurfaceChanged(Surface surface) {
    }

    public void onRenderTargetSizeChanged(int i11, int i12) {
    }
}
