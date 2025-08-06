package com.tencent.ugc;

final /* synthetic */ class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50294a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50295b;

    /* renamed from: c  reason: collision with root package name */
    private final String f50296c;

    private cn(TXVideoJoiner tXVideoJoiner, int i11, String str) {
        this.f50294a = tXVideoJoiner;
        this.f50295b = i11;
        this.f50296c = str;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, int i11, String str) {
        return new cn(tXVideoJoiner, i11, str);
    }

    public final void run() {
        this.f50294a.joinVideoInternal(this.f50295b, this.f50296c, true);
    }
}
