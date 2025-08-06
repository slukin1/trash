package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.OrderConfirmDialog;

public final /* synthetic */ class o1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62080b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f62081c;

    public /* synthetic */ o1(Dialog dialog, View.OnClickListener onClickListener) {
        this.f62080b = dialog;
        this.f62081c = onClickListener;
    }

    public final void onClick(View view) {
        OrderConfirmDialog.f(this.f62080b, this.f62081c, view);
    }
}
