package dt;

import android.app.Activity;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.trade.bean.OrderPlaceBean;

public final /* synthetic */ class u2 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d3 f54161a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeType f54162b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f54163c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Activity f54164d;

    public /* synthetic */ u2(d3 d3Var, TradeType tradeType, OrderPlaceBean orderPlaceBean, Activity activity) {
        this.f54161a = d3Var;
        this.f54162b = tradeType;
        this.f54163c = orderPlaceBean;
        this.f54164d = activity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f54161a.U(this.f54162b, this.f54163c, this.f54164d, hBDialogFragment);
    }
}
