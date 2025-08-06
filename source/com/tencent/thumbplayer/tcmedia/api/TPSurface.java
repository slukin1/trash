package com.tencent.thumbplayer.tcmedia.api;

import android.graphics.SurfaceTexture;
import com.tencent.thumbplayer.tcmedia.adapter.a.b.c;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoPacket;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerSurfaceCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerSurface;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerSurfaceRenderInfo;

public final class TPSurface extends TPNativePlayerSurface {
    private ITPNativePlayerSurfaceCallback mITPSurfaceCallback;
    /* access modifiers changed from: private */
    public ITPSurfaceListener mPlayerSurfaceListener = null;

    public TPSurface(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        AnonymousClass1 r12 = new ITPNativePlayerSurfaceCallback() {
            public void onFlush() {
                ITPSurfaceListener access$000 = TPSurface.this.mPlayerSurfaceListener;
                if (access$000 != null) {
                    access$000.onFlush();
                }
            }

            public void onRenderInfo(TPNativePlayerSurfaceRenderInfo tPNativePlayerSurfaceRenderInfo) {
                ITPSurfaceListener access$000 = TPSurface.this.mPlayerSurfaceListener;
                if (access$000 != null) {
                    access$000.onRenderInfo(c.a(tPNativePlayerSurfaceRenderInfo));
                }
            }

            public void onVideoPacket(TPVideoPacket tPVideoPacket) {
                ITPSurfaceListener access$000 = TPSurface.this.mPlayerSurfaceListener;
                if (access$000 != null) {
                    access$000.onVideoPacket(c.a(tPVideoPacket));
                }
            }
        };
        this.mITPSurfaceCallback = r12;
        super.setTPSurfaceCallback(r12);
    }

    public final void finalize() {
        super.release();
        super.finalize();
    }

    public final void setSurfaceListener(ITPSurfaceListener iTPSurfaceListener) {
        this.mPlayerSurfaceListener = iTPSurfaceListener;
    }
}
