package com.tencent.ugc;

final /* synthetic */ class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50174a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50175b;

    /* renamed from: c  reason: collision with root package name */
    private final String f50176c;

    private az(TXVideoEditer tXVideoEditer, int i11, String str) {
        this.f50174a = tXVideoEditer;
        this.f50175b = i11;
        this.f50176c = str;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, String str) {
        return new az(tXVideoEditer, i11, str);
    }

    public final void run() {
        TXVideoEditer.lambda$generateVideo$54(this.f50174a, this.f50175b, this.f50176c);
    }
}
