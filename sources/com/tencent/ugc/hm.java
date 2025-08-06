package com.tencent.ugc;

final /* synthetic */ class hm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCWatermarkAlphaTextureFilter f50619a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50620b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50621c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50622d;

    /* renamed from: e  reason: collision with root package name */
    private final float f50623e;

    /* renamed from: f  reason: collision with root package name */
    private final float f50624f;

    /* renamed from: g  reason: collision with root package name */
    private final float f50625g;

    private hm(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, int i11, int i12, int i13, float f11, float f12, float f13) {
        this.f50619a = uGCWatermarkAlphaTextureFilter;
        this.f50620b = i11;
        this.f50621c = i12;
        this.f50622d = i13;
        this.f50623e = f11;
        this.f50624f = f12;
        this.f50625g = f13;
    }

    public static Runnable a(UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter, int i11, int i12, int i13, float f11, float f12, float f13) {
        return new hm(uGCWatermarkAlphaTextureFilter, i11, i12, i13, f11, f12, f13);
    }

    public final void run() {
        UGCWatermarkAlphaTextureFilter.lambda$setTextureWatermark$1(this.f50619a, this.f50620b, this.f50621c, this.f50622d, this.f50623e, this.f50624f, this.f50625g);
    }
}
