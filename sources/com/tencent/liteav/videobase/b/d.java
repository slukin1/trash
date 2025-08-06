package com.tencent.liteav.videobase.b;

import com.tencent.liteav.videobase.a.a;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

public final class d extends a {

    /* renamed from: h  reason: collision with root package name */
    private int f22068h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f22069i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f22070j = -1;

    public final void a(int i11, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.a(this.f22070j, dVar, floatBuffer, floatBuffer2);
    }

    public final void c() {
        super.c();
        OpenGlUtils.deleteTexture(this.f22070j);
        this.f22070j = -1;
    }

    public final void a(Buffer buffer, int i11, int i12) {
        if (!(this.f22068h == i11 && this.f22069i == i12)) {
            this.f22068h = i11;
            this.f22069i = i12;
            OpenGlUtils.deleteTexture(this.f22070j);
            this.f22070j = -1;
        }
        this.f22070j = OpenGlUtils.loadTexture(6408, buffer, i11, i12, this.f22070j);
    }
}
