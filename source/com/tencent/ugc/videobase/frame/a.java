package com.tencent.ugc.videobase.frame;

final /* synthetic */ class a implements IRecycler {

    /* renamed from: a  reason: collision with root package name */
    private final FramePool f50859a;

    private a(FramePool framePool) {
        this.f50859a = framePool;
    }

    public static IRecycler a(FramePool framePool) {
        return new a(framePool);
    }

    public final void recycle(RefCounted refCounted) {
        FramePool.lambda$new$0(this.f50859a, refCounted);
    }
}
