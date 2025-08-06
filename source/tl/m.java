package tl;

import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class m implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeMarketNewPresenter f29356b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f29357c;

    public /* synthetic */ m(HomeMarketNewPresenter homeMarketNewPresenter, boolean z11) {
        this.f29356b = homeMarketNewPresenter;
        this.f29357c = z11;
    }

    public final Object call(Object obj) {
        return this.f29356b.O1(this.f29357c, (List) obj);
    }
}
