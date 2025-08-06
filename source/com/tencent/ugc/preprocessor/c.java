package com.tencent.ugc.preprocessor;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final BeautyProcessor f50681a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50682b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50683c;

    private c(BeautyProcessor beautyProcessor, String str, int i11) {
        this.f50681a = beautyProcessor;
        this.f50682b = str;
        this.f50683c = i11;
    }

    public static Runnable a(BeautyProcessor beautyProcessor, String str, int i11) {
        return new c(beautyProcessor, str, i11);
    }

    public final void run() {
        this.f50681a.updateStatsInternal(this.f50682b, (float) this.f50683c);
    }
}
