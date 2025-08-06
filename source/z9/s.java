package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.c f62096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62097c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Dialog f62098d;

    public /* synthetic */ s(DialogUtils.c cVar, FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62096b = cVar;
        this.f62097c = fragmentActivity;
        this.f62098d = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.z(this.f62096b, this.f62097c, this.f62098d, view);
    }
}
