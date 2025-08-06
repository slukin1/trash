package oa;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f58811b;

    public /* synthetic */ i(Activity activity) {
        this.f58811b = activity;
    }

    public final void run() {
        DialogUtils.c0((FragmentActivity) this.f58811b, this.f58811b.getResources().getString(R$string.n_permission_alert_storage), (String) null, this.f58811b.getResources().getString(R$string.n_cancel), this.f58811b.getResources().getString(R$string.staring_remind_to_open), o0.f12469a, new f(this.f58811b));
    }
}
