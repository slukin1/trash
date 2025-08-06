package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class b1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.C0790b f62026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62027c;

    public /* synthetic */ b1(DialogUtils.b.C0790b bVar, HBDialogFragment hBDialogFragment) {
        this.f62026b = bVar;
        this.f62027c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62026b.k(this.f62027c, view);
    }
}
