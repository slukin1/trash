package dl;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.flutter.base.AbsGlobalFlutterActivity;

public final /* synthetic */ class a implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f53803a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f53804b;

    public /* synthetic */ a(FragmentActivity fragmentActivity, String str) {
        this.f53803a = fragmentActivity;
        this.f53804b = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        AbsGlobalFlutterActivity.oi(this.f53803a, this.f53804b, hBDialogFragment);
    }
}
