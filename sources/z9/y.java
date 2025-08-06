package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class y implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62120b;

    public /* synthetic */ y(Dialog dialog) {
        this.f62120b = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.A(this.f62120b, view);
    }
}
