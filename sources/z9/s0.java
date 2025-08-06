package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class s0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.a f62099b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62100c;

    public /* synthetic */ s0(DialogUtils.b.a aVar, HBDialogFragment hBDialogFragment) {
        this.f62099b = aVar;
        this.f62100c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62099b.h(this.f62100c, view);
    }
}
