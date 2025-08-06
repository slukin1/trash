package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class y0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.C0790b f62121b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62122c;

    public /* synthetic */ y0(DialogUtils.b.C0790b bVar, HBDialogFragment hBDialogFragment) {
        this.f62121b = bVar;
        this.f62122c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62121b.p(this.f62122c, view);
    }
}
