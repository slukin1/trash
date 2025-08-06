package com.tencent.thumbplayer.tcmedia.g.c;

import android.graphics.SurfaceTexture;

public final class b extends SurfaceTexture {

    /* renamed from: a  reason: collision with root package name */
    private a f49286a;

    public interface a {
        void a();
    }

    public b(int i11) {
        super(i11);
    }

    public final void a(a aVar) {
        this.f49286a = aVar;
    }

    public final void release() {
        super.release();
        a aVar = this.f49286a;
        if (aVar != null) {
            aVar.a();
        }
    }
}
