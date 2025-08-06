package com.tencent.ugc.videobase.yuv;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXCGPUImageI420InputFilter f50891a;

    private a(TXCGPUImageI420InputFilter tXCGPUImageI420InputFilter) {
        this.f50891a = tXCGPUImageI420InputFilter;
    }

    public static Runnable a(TXCGPUImageI420InputFilter tXCGPUImageI420InputFilter) {
        return new a(tXCGPUImageI420InputFilter);
    }

    public final void run() {
        TXCGPUImageI420InputFilter.lambda$onInit$0(this.f50891a);
    }
}
