package us;

import android.view.View;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import us.e;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f60925b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f60926c;

    public /* synthetic */ b(HBDialogFragment hBDialogFragment, View.OnClickListener onClickListener) {
        this.f60925b = hBDialogFragment;
        this.f60926c = onClickListener;
    }

    public final void onClick(View view) {
        e.a.f(this.f60925b, this.f60926c, view);
    }
}
