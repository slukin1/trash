package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class l0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f62066b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62067c;

    public /* synthetic */ l0(DialogUtils.b bVar, HBDialogFragment hBDialogFragment) {
        this.f62066b = bVar;
        this.f62067c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62066b.F0(this.f62067c, view);
    }
}
