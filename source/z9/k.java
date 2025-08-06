package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62060b;

    public /* synthetic */ k(Dialog dialog) {
        this.f62060b = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.G(this.f62060b, view);
    }
}
