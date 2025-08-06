package et;

import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import rx.functions.Func1;

public final /* synthetic */ class y implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54455b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54456c;

    public /* synthetic */ y(String str, String str2) {
        this.f54455b = str;
        this.f54456c = str2;
    }

    public final Object call(Object obj) {
        return TradeVerticalSpotPresenter.d3(this.f54455b, this.f54456c, (Long) obj);
    }
}
