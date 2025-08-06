package com.tencent.liteav.videoproducer.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VirtualDisplayManager f22605a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f22606b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22607c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22608d;

    /* renamed from: e  reason: collision with root package name */
    private final MediaProjection f22609e;

    /* renamed from: f  reason: collision with root package name */
    private final VirtualDisplayManager.VirtualDisplayListener f22610f;

    private g(VirtualDisplayManager virtualDisplayManager, Surface surface, int i11, int i12, MediaProjection mediaProjection, VirtualDisplayManager.VirtualDisplayListener virtualDisplayListener) {
        this.f22605a = virtualDisplayManager;
        this.f22606b = surface;
        this.f22607c = i11;
        this.f22608d = i12;
        this.f22609e = mediaProjection;
        this.f22610f = virtualDisplayListener;
    }

    public static Runnable a(VirtualDisplayManager virtualDisplayManager, Surface surface, int i11, int i12, MediaProjection mediaProjection, VirtualDisplayManager.VirtualDisplayListener virtualDisplayListener) {
        return new g(virtualDisplayManager, surface, i11, i12, mediaProjection, virtualDisplayListener);
    }

    public final void run() {
        VirtualDisplayManager.a(this.f22605a, this.f22606b, this.f22607c, this.f22608d, this.f22609e, this.f22610f);
    }
}
