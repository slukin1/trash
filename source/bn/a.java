package bn;

import com.huobi.coupon.handler.CouponExperienceRequestHelper;
import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;
import java.util.List;

public final /* synthetic */ class a implements CouponExperienceRequestHelper.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBasePresenter f12811a;

    public /* synthetic */ a(LinearSwapTradeBasePresenter linearSwapTradeBasePresenter) {
        this.f12811a = linearSwapTradeBasePresenter;
    }

    public final void onResult(List list) {
        this.f12811a.R2(list);
    }
}
