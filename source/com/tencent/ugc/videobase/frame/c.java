package com.tencent.ugc.videobase.frame;

import com.tencent.ugc.videobase.frame.TextureHolderPool;

final /* synthetic */ class c implements IRecycler {

    /* renamed from: a  reason: collision with root package name */
    private static final c f50861a = new c();

    private c() {
    }

    public static IRecycler a() {
        return f50861a;
    }

    public final void recycle(RefCounted refCounted) {
        ((TextureHolderPool.a) refCounted).f50858a.release();
    }
}
