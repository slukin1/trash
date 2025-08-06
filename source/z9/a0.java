package z9;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class a0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Dialog f62019b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f62020c;

    public /* synthetic */ a0(Dialog dialog, FragmentActivity fragmentActivity) {
        this.f62019b = dialog;
        this.f62020c = fragmentActivity;
    }

    public final void onClick(View view) {
        DialogUtils.Q(this.f62019b, this.f62020c, view);
    }
}
