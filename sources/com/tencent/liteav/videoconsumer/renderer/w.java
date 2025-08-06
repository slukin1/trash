package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.a;
import java.nio.ByteBuffer;

final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22500a;

    /* renamed from: b  reason: collision with root package name */
    private final RenderViewHelperInterface f22501b;

    /* renamed from: c  reason: collision with root package name */
    private final ByteBuffer f22502c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22503d;

    /* renamed from: e  reason: collision with root package name */
    private final int f22504e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22505f;

    private w(t tVar, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i11, int i12, a aVar) {
        this.f22500a = tVar;
        this.f22501b = renderViewHelperInterface;
        this.f22502c = byteBuffer;
        this.f22503d = i11;
        this.f22504e = i12;
        this.f22505f = aVar;
    }

    public static Runnable a(t tVar, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i11, int i12, a aVar) {
        return new w(tVar, renderViewHelperInterface, byteBuffer, i11, i12, aVar);
    }

    public final void run() {
        t.a(this.f22500a, this.f22501b, this.f22502c, this.f22503d, this.f22504e, this.f22505f);
    }
}
