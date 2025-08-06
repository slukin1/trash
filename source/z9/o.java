package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62077b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f62078c;

    public /* synthetic */ o(FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62077b = fragmentActivity;
        this.f62078c = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.F(this.f62077b, this.f62078c, view);
    }
}
