package ji;

import com.huobi.assetrecord.presenter.AppleOrderHistoryRecordPresenter;
import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppleOrderHistoryRecordPresenter f55948b;

    public /* synthetic */ e(AppleOrderHistoryRecordPresenter appleOrderHistoryRecordPresenter) {
        this.f55948b = appleOrderHistoryRecordPresenter;
    }

    public final void call(Object obj) {
        this.f55948b.Y((SecurityStrategySet) obj);
    }
}
