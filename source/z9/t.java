package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.c f62101b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62102c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Dialog f62103d;

    public /* synthetic */ t(DialogUtils.c cVar, FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62101b = cVar;
        this.f62102c = fragmentActivity;
        this.f62103d = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.H(this.f62101b, this.f62102c, this.f62103d, view);
    }
}
