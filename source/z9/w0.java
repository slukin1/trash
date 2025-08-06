package z9;

import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class w0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.C0790b f62115b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CheckBox f62116c;

    public /* synthetic */ w0(DialogUtils.b.C0790b bVar, CheckBox checkBox) {
        this.f62115b = bVar;
        this.f62116c = checkBox;
    }

    public final void onClick(View view) {
        this.f62115b.l(this.f62116c, view);
    }
}
