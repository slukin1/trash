package cd;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.exchange.grid.ui.GridTradeActivity;

public final /* synthetic */ class n implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f13051a;

    public /* synthetic */ n(FragmentActivity fragmentActivity) {
        this.f13051a = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        GridTradeActivity.c.w(this.f13051a, hBDialogFragment);
    }
}
