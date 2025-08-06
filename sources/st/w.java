package st;

import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import rx.functions.Func1;

public final /* synthetic */ class w implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f29248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f29249c;

    public /* synthetic */ w(String str, String str2) {
        this.f29248b = str;
        this.f29249c = str2;
    }

    public final Object call(Object obj) {
        return TradeHorizontalSpotPresenter.O2(this.f29248b, this.f29249c, (Long) obj);
    }
}
