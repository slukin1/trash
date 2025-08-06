package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62109b;

    public /* synthetic */ v(Dialog dialog) {
        this.f62109b = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.L(this.f62109b, view);
    }
}
