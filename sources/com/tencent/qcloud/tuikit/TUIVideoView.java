package com.tencent.qcloud.tuikit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class TUIVideoView extends TXCloudVideoView {
    public TUIVideoView(Context context) {
        super(context);
    }

    public TUIVideoView(SurfaceView surfaceView) {
        super(surfaceView);
    }

    public TUIVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TUIVideoView(Context context, AttributeSet attributeSet, SurfaceView surfaceView) {
        super(context, attributeSet, surfaceView);
    }
}
