package com.tencent.ugc.videobase.frame;

import com.tencent.ugc.videobase.frame.GLTexturePool;

final /* synthetic */ class b implements IRecycler {

    /* renamed from: a  reason: collision with root package name */
    private static final b f50860a = new b();

    private b() {
    }

    public static IRecycler a() {
        return f50860a;
    }

    public final void recycle(RefCounted refCounted) {
        ((GLTexturePool.TextureFrame) refCounted).mTexture.release();
    }
}
