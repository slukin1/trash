package bl;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.HtExchangeHistoryBean;
import com.huobi.finance.viewhandler.HtExchangeHistoryViewHandler;

public final /* synthetic */ class r2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HtExchangeHistoryBean f12724b;

    public /* synthetic */ r2(HtExchangeHistoryBean htExchangeHistoryBean) {
        this.f12724b = htExchangeHistoryBean;
    }

    public final void onClick(View view) {
        HtExchangeHistoryViewHandler.d(this.f12724b, view);
    }
}
