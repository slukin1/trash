package oa;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.widgets.R$string;
import com.hbg.lib.widgets.dialog.DialogUtils;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f58810b;

    public /* synthetic */ h(Activity activity) {
        this.f58810b = activity;
    }

    public final void run() {
        DialogUtils.c0((FragmentActivity) this.f58810b, this.f58810b.getResources().getString(R$string.n_permission_alert_storage), (String) null, this.f58810b.getResources().getString(R$string.n_cancel), this.f58810b.getResources().getString(R$string.staring_remind_to_open), o0.f12469a, new e(this.f58810b));
    }
}
