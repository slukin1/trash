package jq;

import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f56100b;

    public /* synthetic */ c(int i11) {
        this.f56100b = i11;
    }

    public final Object call(Object obj) {
        return Long.valueOf(((long) this.f56100b) - ((Long) obj).longValue());
    }
}
