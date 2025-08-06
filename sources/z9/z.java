package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class z implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62124c;

    public /* synthetic */ z(Dialog dialog, FragmentActivity fragmentActivity) {
        this.f62123b = dialog;
        this.f62124c = fragmentActivity;
    }

    public final void onClick(View view) {
        DialogUtils.J(this.f62123b, this.f62124c, view);
    }
}
