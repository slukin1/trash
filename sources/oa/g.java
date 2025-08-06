package oa;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f58809b;

    public /* synthetic */ g(Activity activity) {
        this.f58809b = activity;
    }

    public final void run() {
        DialogUtils.c0((FragmentActivity) this.f58809b, this.f58809b.getResources().getString(R$string.n_permission_alert_camera), (String) null, this.f58809b.getResources().getString(R$string.n_cancel), this.f58809b.getResources().getString(R$string.staring_remind_to_open), o0.f12469a, new d(this.f58809b));
    }
}
