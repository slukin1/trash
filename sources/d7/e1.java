package d7;

import com.hbg.lib.data.symbol.SymbolsDataProvider;
import rx.Observable;
import rx.Subscriber;

public final /* synthetic */ class e1 implements Observable.OnSubscribe {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f53500b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f53501c;

    public /* synthetic */ e1(boolean z11, String str) {
        this.f53500b = z11;
        this.f53501c = str;
    }

    public final void call(Object obj) {
        SymbolsDataProvider.q(this.f53500b, this.f53501c, (Subscriber) obj);
    }
}
