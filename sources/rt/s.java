package rt;

import android.app.Activity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.trade.bean.OrderPlaceBean;

public final /* synthetic */ class s implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ z f25871a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeType f25872b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25873c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f25874d;

    public /* synthetic */ s(z zVar, TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        this.f25871a = zVar;
        this.f25872b = tradeType;
        this.f25873c = orderPlaceBean;
        this.f25874d = activity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f25871a.X(this.f25872b, this.f25873c, this.f25874d, hBDialogFragment);
    }
}
