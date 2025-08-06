package dh;

import rx.Observable;
import rx.functions.Func0;

public final /* synthetic */ class a implements Func0 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53632b;

    public /* synthetic */ a(String str) {
        this.f53632b = str;
    }

    public final Object call() {
        return Observable.just(c.d(this.f53632b));
    }
}
