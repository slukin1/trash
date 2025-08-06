package fo;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.main.ui.HuobiMainActivity;

public final /* synthetic */ class m implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HuobiMainActivity f54723a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f54724b;

    public /* synthetic */ m(HuobiMainActivity huobiMainActivity, String str) {
        this.f54723a = huobiMainActivity;
        this.f54724b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f54723a.di(this.f54724b, hBDialogFragment);
    }
}
