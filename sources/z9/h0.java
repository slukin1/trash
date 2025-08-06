package z9;

import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class h0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f62050b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CheckBox f62051c;

    public /* synthetic */ h0(DialogUtils.b bVar, CheckBox checkBox) {
        this.f62050b = bVar;
        this.f62051c = checkBox;
    }

    public final void onClick(View view) {
        this.f62050b.J0(this.f62051c, view);
    }
}
