package fo;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.main.ui.HuobiMainActivity;

public final /* synthetic */ class n implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HuobiMainActivity f54725a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f54726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54727c;

    public /* synthetic */ n(HuobiMainActivity huobiMainActivity, boolean z11, String str) {
        this.f54725a = huobiMainActivity;
        this.f54726b = z11;
        this.f54727c = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f54725a.ci(this.f54726b, this.f54727c, hBDialogFragment);
    }
}
