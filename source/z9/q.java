package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62087b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f62088c;

    public /* synthetic */ q(FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62087b = fragmentActivity;
        this.f62088c = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.E(this.f62087b, this.f62088c, view);
    }
}
