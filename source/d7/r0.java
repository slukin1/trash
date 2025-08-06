package d7;

import com.hbg.lib.data.symbol.SuperMarginSymbolConfigUtil;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class r0 implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f53529b;

    public /* synthetic */ r0(boolean z11) {
        this.f53529b = z11;
    }

    public final void call(Object obj) {
        SuperMarginSymbolConfigUtil.o(this.f53529b, (Subscriber) obj);
    }
}
