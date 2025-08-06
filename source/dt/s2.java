package dt;

import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.trade.bean.OrderPlaceBean;

public final /* synthetic */ class s2 implements DialogUtils.b.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54148a;

    public /* synthetic */ s2(OrderPlaceBean orderPlaceBean) {
        this.f54148a = orderPlaceBean;
    }

    public final void a(boolean z11) {
        ConfigPreferences.n("user_config", "config_call_auction_third_confirm_" + this.f54148a.getSymbol(), z11);
    }
}
