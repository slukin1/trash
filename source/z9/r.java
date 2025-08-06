package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.c f62091b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62092c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Dialog f62093d;

    public /* synthetic */ r(DialogUtils.c cVar, FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62091b = cVar;
        this.f62092c = fragmentActivity;
        this.f62093d = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.y(this.f62091b, this.f62092c, this.f62093d, view);
    }
}
