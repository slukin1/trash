package z9;

import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.dialog.a;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.C0792a f62043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CheckBox f62044c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f62045d;

    public /* synthetic */ g(a.C0792a aVar, CheckBox checkBox, HBDialogFragment hBDialogFragment) {
        this.f62043b = aVar;
        this.f62044c = checkBox;
        this.f62045d = hBDialogFragment;
    }

    public final void onClick(View view) {
        this.f62043b.h(this.f62044c, this.f62045d, view);
    }
}
