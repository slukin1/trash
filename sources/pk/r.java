package pk;

import android.view.View;
import com.business.common.swapzero.view.SwapZeroSideView;
import com.hbg.lib.network.hbg.core.bean.NewBannerBean;
import com.huobi.feature.ui.FutureTradeFragment;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FutureTradeFragment f53131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NewBannerBean.BannerAdv f53132c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SwapZeroSideView f53133d;

    public /* synthetic */ r(FutureTradeFragment futureTradeFragment, NewBannerBean.BannerAdv bannerAdv, SwapZeroSideView swapZeroSideView) {
        this.f53131b = futureTradeFragment;
        this.f53132c = bannerAdv;
        this.f53133d = swapZeroSideView;
    }

    public final void onClick(View view) {
        this.f53131b.Wh(this.f53132c, this.f53133d, view);
    }
}
