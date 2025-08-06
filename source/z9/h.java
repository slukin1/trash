package z9;

import android.view.View;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.a;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.C0792a f62048b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62049c;

    public /* synthetic */ h(a.C0792a aVar, HBDialogFragment hBDialogFragment) {
        this.f62048b = aVar;
        this.f62049c = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62048b.i(this.f62049c, view);
    }
}
