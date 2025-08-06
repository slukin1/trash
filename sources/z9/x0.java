package z9;

import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class x0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b.C0790b f62118b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CheckBox f62119c;

    public /* synthetic */ x0(DialogUtils.b.C0790b bVar, CheckBox checkBox) {
        this.f62118b = bVar;
        this.f62119c = checkBox;
    }

    public final void onClick(View view) {
        this.f62118b.n(this.f62119c, view);
    }
}
