package z9;

import android.app.Dialog;
import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62024b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.a f62025c;

    public /* synthetic */ b0(Dialog dialog, DialogUtils.a aVar) {
        this.f62024b = dialog;
        this.f62025c = aVar;
    }

    public final void onClick(View view) {
        DialogUtils.O(this.f62024b, this.f62025c, view);
    }
}
