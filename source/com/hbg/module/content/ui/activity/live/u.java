package com.hbg.module.content.ui.activity.live;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class u implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroupUserInfoDialog f18707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f18708b;

    public /* synthetic */ u(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
        this.f18707a = groupUserInfoDialog;
        this.f18708b = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        GroupUserInfoDialog.Ih(this.f18707a, this.f18708b, hBDialogFragment);
    }
}
