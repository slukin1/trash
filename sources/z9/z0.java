package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class z0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.C0790b f62125b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62126c;

    public /* synthetic */ z0(DialogUtils.b.C0790b bVar, HBDialogFragment hBDialogFragment) {
        this.f62125b = bVar;
        this.f62126c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62125b.q(this.f62126c, view);
    }
}
