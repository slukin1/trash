package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.a f62040c;

    public /* synthetic */ e0(Dialog dialog, DialogUtils.a aVar) {
        this.f62039b = dialog;
        this.f62040c = aVar;
    }

    public final void onClick(View view) {
        DialogUtils.N(this.f62039b, this.f62040c, view);
    }
}
