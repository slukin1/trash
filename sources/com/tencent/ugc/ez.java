package com.tencent.ugc;

final /* synthetic */ class ez implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCRecorderJni f50494a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50495b;

    /* renamed from: c  reason: collision with root package name */
    private final float f50496c;

    private ez(UGCRecorderJni uGCRecorderJni, float f11, float f12) {
        this.f50494a = uGCRecorderJni;
        this.f50495b = f11;
        this.f50496c = f12;
    }

    public static Runnable a(UGCRecorderJni uGCRecorderJni, float f11, float f12) {
        return new ez(uGCRecorderJni, f11, f12);
    }

    public final void run() {
        UGCRecorderJni.lambda$setFocusPosition$0(this.f50494a, this.f50495b, this.f50496c);
    }
}
