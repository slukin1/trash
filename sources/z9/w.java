package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.c f62112b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62113c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Dialog f62114d;

    public /* synthetic */ w(DialogUtils.c cVar, FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62112b = cVar;
        this.f62113c = fragmentActivity;
        this.f62114d = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.x(this.f62112b, this.f62113c, this.f62114d, view);
    }
}
