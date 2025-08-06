package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class d0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62035b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.a f62036c;

    public /* synthetic */ d0(Dialog dialog, DialogUtils.a aVar) {
        this.f62035b = dialog;
        this.f62036c = aVar;
    }

    public final void onClick(View view) {
        DialogUtils.M(this.f62035b, this.f62036c, view);
    }
}
