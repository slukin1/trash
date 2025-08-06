package sq;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.quicktrade.trade.ui.QuickTradeBaseFragment;

public final /* synthetic */ class f implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuickTradeBaseFragment f26125a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f26126b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26127c;

    public /* synthetic */ f(QuickTradeBaseFragment quickTradeBaseFragment, String str, int i11) {
        this.f26125a = quickTradeBaseFragment;
        this.f26126b = str;
        this.f26127c = i11;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f26125a.Mh(this.f26126b, this.f26127c, hBDialogFragment);
    }
}
