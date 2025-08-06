package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.c f62105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62106c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Dialog f62107d;

    public /* synthetic */ u(DialogUtils.c cVar, FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62105b = cVar;
        this.f62106c = fragmentActivity;
        this.f62107d = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.w(this.f62105b, this.f62106c, this.f62107d, view);
    }
}
