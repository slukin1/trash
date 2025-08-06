package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62117b;

    public /* synthetic */ x(Dialog dialog) {
        this.f62117b = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.I(this.f62117b, view);
    }
}
