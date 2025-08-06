package com.tencent.ugc.videobase.chain;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageFilter f50827a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50828b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50829c;

    private a(TXCGPUImageFilter tXCGPUImageFilter, int i11, float f11) {
        this.f50827a = tXCGPUImageFilter;
        this.f50828b = i11;
        this.f50829c = f11;
    }

    public static Runnable a(TXCGPUImageFilter tXCGPUImageFilter, int i11, float f11) {
        return new a(tXCGPUImageFilter, i11, f11);
    }

    public final void run() {
        TXCGPUImageFilter.lambda$setFloatOnDraw$0(this.f50827a, this.f50828b, this.f50829c);
    }
}
