package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.utils.OpenGlUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private int f22197a = -1;

    public final void a() {
        if (this.f22197a == -1) {
            this.f22197a = OpenGlUtils.generateFrameBufferId();
        }
    }

    public final void b() {
        OpenGlUtils.bindFramebuffer(36160, this.f22197a);
    }

    public final void c() {
        int i11 = this.f22197a;
        if (i11 == -1) {
            LiteavLog.d("GLFrameBuffer", "FrameBuffer is invalid");
        } else {
            OpenGlUtils.detachTextureFromFrameBuffer(i11);
        }
    }

    public final void d() {
        int i11 = this.f22197a;
        if (i11 != -1) {
            OpenGlUtils.deleteFrameBuffer(i11);
            this.f22197a = -1;
        }
    }

    public final void a(int i11) {
        int i12 = this.f22197a;
        if (i12 == -1) {
            LiteavLog.d("GLFrameBuffer", "FrameBuffer is invalid");
        } else {
            OpenGlUtils.attachTextureToFrameBuffer(i11, i12);
        }
    }
}
