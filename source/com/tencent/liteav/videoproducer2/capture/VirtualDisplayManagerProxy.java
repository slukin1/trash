package com.tencent.liteav.videoproducer2.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;
import com.tencent.liteav.videoproducer.capture.g;
import com.tencent.liteav.videoproducer.capture.h;

@JNINamespace("liteav::video")
public class VirtualDisplayManagerProxy {
    private final VirtualDisplayManager mManager = VirtualDisplayManager.a(ContextUtils.getApplicationContext());

    public void startVirtualDisplaySync(Surface surface, int i11, int i12, MediaProjection mediaProjection, VirtualDisplayManager.VirtualDisplayListener virtualDisplayListener) {
        VirtualDisplayManager virtualDisplayManager = this.mManager;
        LiteavLog.i("VirtualDisplayManager", "startVirtualDisplaySync, surface:" + surface + ", width:" + i11 + ", height:" + i12 + ", mediaProjection: " + mediaProjection + ", listener:" + virtualDisplayListener);
        virtualDisplayManager.f22528a.b(g.a(virtualDisplayManager, surface, i11, i12, mediaProjection, virtualDisplayListener));
    }

    public void stopVirtualDisplaySync(Surface surface) {
        VirtualDisplayManager virtualDisplayManager = this.mManager;
        LiteavLog.i("VirtualDisplayManager", "stopVirtualDisplaySync, surface:".concat(String.valueOf(surface)));
        virtualDisplayManager.f22528a.b(h.a(virtualDisplayManager, surface));
    }
}
