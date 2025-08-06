package ao;

import android.app.Activity;
import com.hbg.lib.network.retrofit.eventbus.HKPayOffEvent;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.main.presenter.HuobiMainPresenter;

public final /* synthetic */ class f implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HKPayOffEvent f12166a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f12167b;

    public /* synthetic */ f(HKPayOffEvent hKPayOffEvent, Activity activity) {
        this.f12166a = hKPayOffEvent;
        this.f12167b = activity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        HuobiMainPresenter.h.b(this.f12166a, this.f12167b, hBDialogFragment);
    }
}
