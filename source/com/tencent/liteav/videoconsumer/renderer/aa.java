package com.tencent.liteav.videoconsumer.renderer;

import android.graphics.Matrix;
import com.tencent.liteav.videobase.base.a;
import java.nio.ByteBuffer;

final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22401a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteBuffer f22402b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22403c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22404d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f22405e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22406f;

    private aa(t tVar, ByteBuffer byteBuffer, int i11, int i12, Matrix matrix, a aVar) {
        this.f22401a = tVar;
        this.f22402b = byteBuffer;
        this.f22403c = i11;
        this.f22404d = i12;
        this.f22405e = matrix;
        this.f22406f = aVar;
    }

    public static Runnable a(t tVar, ByteBuffer byteBuffer, int i11, int i12, Matrix matrix, a aVar) {
        return new aa(tVar, byteBuffer, i11, i12, matrix, aVar);
    }

    public final void run() {
        t.a(this.f22401a, this.f22402b, this.f22403c, this.f22404d, this.f22405e, this.f22406f);
    }
}
