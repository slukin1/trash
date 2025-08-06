package qt;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import qt.q;
import u6.g;

public final /* synthetic */ class o implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f70480a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f70481b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f70482c;

    public /* synthetic */ o(FragmentActivity fragmentActivity, g gVar, String str) {
        this.f70480a = fragmentActivity;
        this.f70481b = gVar;
        this.f70482c = str;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        q.a.d(this.f70480a, this.f70481b, this.f70482c, hBDialogFragment);
    }
}
