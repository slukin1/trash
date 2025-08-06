package com.hbg.module.content.ui.activity.live;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class v implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroupUserInfoDialog f18711a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f18712b;

    public /* synthetic */ v(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
        this.f18711a = groupUserInfoDialog;
        this.f18712b = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        GroupUserInfoDialog.Zh(this.f18711a, this.f18712b, hBDialogFragment);
    }
}
