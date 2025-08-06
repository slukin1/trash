package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class c0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62031b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.a f62032c;

    public /* synthetic */ c0(Dialog dialog, DialogUtils.a aVar) {
        this.f62031b = dialog;
        this.f62032c = aVar;
    }

    public final void onClick(View view) {
        DialogUtils.P(this.f62031b, this.f62032c, view);
    }
}
