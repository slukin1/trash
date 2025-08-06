package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class k0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f62061b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62062c;

    public /* synthetic */ k0(DialogUtils.b bVar, HBDialogFragment hBDialogFragment) {
        this.f62061b = bVar;
        this.f62062c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62061b.N0(this.f62062c, view);
    }
}
