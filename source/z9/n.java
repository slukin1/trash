package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f62074c;

    public /* synthetic */ n(FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62073b = fragmentActivity;
        this.f62074c = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.B(this.f62073b, this.f62074c, view);
    }
}
