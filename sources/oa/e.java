package oa;

import android.app.Activity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class e implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f58807a;

    public /* synthetic */ e(Activity activity) {
        this.f58807a = activity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        PermissionUtils.o(this.f58807a, hBDialogFragment);
    }
}
