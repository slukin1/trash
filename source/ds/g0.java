package ds;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.staring.ui.BaseRemindFragment;

public final /* synthetic */ class g0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseRemindFragment f53924a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f53925b;

    public /* synthetic */ g0(BaseRemindFragment baseRemindFragment, FragmentActivity fragmentActivity) {
        this.f53924a = baseRemindFragment;
        this.f53925b = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f53924a.ii(this.f53925b, hBDialogFragment);
    }
}
