package z9;

import android.view.View;
import android.widget.CheckBox;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class g0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f62046b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CheckBox f62047c;

    public /* synthetic */ g0(DialogUtils.b bVar, CheckBox checkBox) {
        this.f62046b = bVar;
        this.f62047c = checkBox;
    }

    public final void onClick(View view) {
        this.f62046b.H0(this.f62047c, view);
    }
}
