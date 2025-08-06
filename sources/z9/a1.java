package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class a1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.C0790b f62021b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62022c;

    public /* synthetic */ a1(DialogUtils.b.C0790b bVar, HBDialogFragment hBDialogFragment) {
        this.f62021b = bVar;
        this.f62022c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62021b.j(this.f62022c, view);
    }
}
