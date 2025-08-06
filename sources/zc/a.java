package zc;

import android.content.Context;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.exchange.grid.handler.GridStrategyViewHandler;

public final /* synthetic */ class a implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f62129a;

    public /* synthetic */ a(Context context) {
        this.f62129a = context;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        GridStrategyViewHandler.e(this.f62129a, hBDialogFragment);
    }
}
