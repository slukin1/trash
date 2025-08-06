package bl;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.UsdtExchangeHistoryBean;
import com.huobi.finance.viewhandler.UsdtExchangeHistoryViewHandler;

public final /* synthetic */ class d3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangeHistoryBean f12567b;

    public /* synthetic */ d3(UsdtExchangeHistoryBean usdtExchangeHistoryBean) {
        this.f12567b = usdtExchangeHistoryBean;
    }

    public final void onClick(View view) {
        UsdtExchangeHistoryViewHandler.d(this.f12567b, view);
    }
}
