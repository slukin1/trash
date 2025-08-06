package com.hbg.module.content.ui.activity.live;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;

public final /* synthetic */ class w implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroupUserInfoDialog f18715a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f18716b;

    public /* synthetic */ w(GroupUserInfoDialog groupUserInfoDialog, FragmentActivity fragmentActivity) {
        this.f18715a = groupUserInfoDialog;
        this.f18716b = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        GroupUserInfoDialog.Nh(this.f18715a, this.f18716b, hBDialogFragment);
    }
}
