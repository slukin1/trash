package com.hbg.module.content.ui.activity.live;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import kotlin.jvm.internal.Ref$IntRef;

public final /* synthetic */ class x implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GroupUserInfoDialog f18719a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref$IntRef f18720b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f18721c;

    public /* synthetic */ x(GroupUserInfoDialog groupUserInfoDialog, Ref$IntRef ref$IntRef, FragmentActivity fragmentActivity) {
        this.f18719a = groupUserInfoDialog;
        this.f18720b = ref$IntRef;
        this.f18721c = fragmentActivity;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        GroupUserInfoDialog.Rh(this.f18719a, this.f18720b, this.f18721c, hBDialogFragment);
    }
}
