package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class q0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.a f62089b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62090c;

    public /* synthetic */ q0(DialogUtils.b.a aVar, HBDialogFragment hBDialogFragment) {
        this.f62089b = aVar;
        this.f62090c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62089b.k(this.f62090c, view);
    }
}
