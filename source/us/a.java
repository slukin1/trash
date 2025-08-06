package us;

import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import us.e;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CheckBox f60922b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBDialogFragment f60923c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f60924d;

    public /* synthetic */ a(CheckBox checkBox, HBDialogFragment hBDialogFragment, View.OnClickListener onClickListener) {
        this.f60922b = checkBox;
        this.f60923c = hBDialogFragment;
        this.f60924d = onClickListener;
    }

    public final void onClick(View view) {
        e.a.g(this.f60922b, this.f60923c, this.f60924d, view);
    }
}
