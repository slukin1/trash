package ds;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.staring.ui.BaseRemindActivity;

public final /* synthetic */ class h implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseRemindActivity f53929a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f53930b;

    public /* synthetic */ h(BaseRemindActivity baseRemindActivity, FragmentActivity fragmentActivity) {
        this.f53929a = baseRemindActivity;
        this.f53930b = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f53929a.Nh(this.f53930b, hBDialogFragment);
    }
}
