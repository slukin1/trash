package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class r0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.a f62094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62095c;

    public /* synthetic */ r0(DialogUtils.b.a aVar, HBDialogFragment hBDialogFragment) {
        this.f62094b = aVar;
        this.f62095c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62094b.m(this.f62095c, view);
    }
}
