package com.huobi.zeroswap.ui;

import android.content.DialogInterface;
import com.hbg.lib.network.hbg.core.bean.ActivityZeroCreateBean;
import com.huobi.feature.ui.ZeroSwapDialogFragment;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class ZeroSwapActivity$onCreate$3 extends Lambda implements l<ActivityZeroCreateBean, Unit> {
    public final /* synthetic */ ZeroSwapActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ZeroSwapActivity$onCreate$3(ZeroSwapActivity zeroSwapActivity) {
        super(1);
        this.this$0 = zeroSwapActivity;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(ZeroSwapActivity zeroSwapActivity, DialogInterface dialogInterface) {
        zeroSwapActivity.Hh().t0();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ActivityZeroCreateBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(ActivityZeroCreateBean activityZeroCreateBean) {
        if (activityZeroCreateBean != null) {
            ZeroSwapActivity zeroSwapActivity = this.this$0;
            if (activityZeroCreateBean.isShow()) {
                ZeroSwapDialogFragment zeroSwapDialogFragment = new ZeroSwapDialogFragment(activityZeroCreateBean);
                zeroSwapDialogFragment.Dh(new e(zeroSwapActivity));
                zeroSwapDialogFragment.show(zeroSwapActivity.getSupportFragmentManager(), "ZeroSwapDialog");
            }
        }
    }
}
