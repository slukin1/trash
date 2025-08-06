package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.d f62065c;

    public /* synthetic */ l(Dialog dialog, DialogUtils.d dVar) {
        this.f62064b = dialog;
        this.f62065c = dVar;
    }

    public final void onClick(View view) {
        DialogUtils.K(this.f62064b, this.f62065c, view);
    }
}
