package oa;

import android.app.Activity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.PermissionUtils;

public final /* synthetic */ class d implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f58806a;

    public /* synthetic */ d(Activity activity) {
        this.f58806a = activity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        PermissionUtils.k(this.f58806a, hBDialogFragment);
    }
}
