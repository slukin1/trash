package com.tencent.ugc.renderer;

import android.graphics.PointF;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.base.TakeSnapshotListener;
import com.tencent.ugc.videobase.frame.PixelFrame;
import java.util.List;

public abstract class VideoRenderInterface {
    public abstract void renderFrame(PixelFrame pixelFrame);

    public abstract void setDisplayView(DisplayTarget displayTarget, boolean z11);

    public abstract void setHorizontalMirror(boolean z11);

    public abstract void setPerspectiveCorrectionPoints(List<PointF> list, List<PointF> list2);

    public abstract void setRenderRotation(k kVar);

    public abstract void setScaleType(GLConstants.GLScaleType gLScaleType);

    public abstract void setVerticalMirror(boolean z11);

    public abstract void start(VideoRenderListener videoRenderListener);

    public abstract void stop(boolean z11);

    public abstract void takeSnapshot(TakeSnapshotListener takeSnapshotListener);
}
