package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62082b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f62083c;

    public /* synthetic */ p(FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62082b = fragmentActivity;
        this.f62083c = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.D(this.f62082b, this.f62083c, view);
    }
}
