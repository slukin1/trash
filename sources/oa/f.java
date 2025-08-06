package oa;

import android.app.Activity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class f implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f58808a;

    public /* synthetic */ f(Activity activity) {
        this.f58808a = activity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        PermissionUtils.m(this.f58808a, hBDialogFragment);
    }
}
