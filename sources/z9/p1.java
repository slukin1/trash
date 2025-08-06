package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.OrderConfirmDialog;

public final /* synthetic */ class p1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f62086c;

    public /* synthetic */ p1(Dialog dialog, View.OnClickListener onClickListener) {
        this.f62085b = dialog;
        this.f62086c = onClickListener;
    }

    public final void onClick(View view) {
        OrderConfirmDialog.g(this.f62085b, this.f62086c, view);
    }
}
