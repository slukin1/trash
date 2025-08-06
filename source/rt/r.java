package rt;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.trade.bean.OrderPlaceBean;

public final /* synthetic */ class r implements DialogUtils.b.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25868a;

    public /* synthetic */ r(OrderPlaceBean orderPlaceBean) {
        this.f25868a = orderPlaceBean;
    }

    public final void a(boolean z11) {
        ConfigPreferences.n("user_config", "config_call_auction_third_confirm_" + this.f25868a.getSymbol(), z11);
    }
}
