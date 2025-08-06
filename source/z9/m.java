package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62069b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f62070c;

    public /* synthetic */ m(FragmentActivity fragmentActivity, Dialog dialog) {
        this.f62069b = fragmentActivity;
        this.f62070c = dialog;
    }

    public final void onClick(View view) {
        DialogUtils.C(this.f62069b, this.f62070c, view);
    }
}
