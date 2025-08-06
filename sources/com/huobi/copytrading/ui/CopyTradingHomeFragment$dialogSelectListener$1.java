package com.huobi.copytrading.ui;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.module.libkt.base.ui.BaseActivity;
import d10.q;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lj.w;

public final class CopyTradingHomeFragment$dialogSelectListener$1 extends Lambda implements q<View, MenuItemBean, Integer, Unit> {
    public final /* synthetic */ CopyTradingHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CopyTradingHomeFragment$dialogSelectListener$1(CopyTradingHomeFragment copyTradingHomeFragment) {
        super(3);
        this.this$0 = copyTradingHomeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((View) obj, (MenuItemBean) obj2, ((Number) obj3).intValue());
        return Unit.f56620a;
    }

    public final void invoke(View view, MenuItemBean menuItemBean, int i11) {
        FragmentActivity requireActivity = this.this$0.requireActivity();
        if (requireActivity instanceof BaseActivity) {
            ((BaseActivity) requireActivity).sh();
        }
        this.this$0.f43610i = i11;
        this.this$0.Ih().A0(i11, this.this$0.Ih().x0().getValue());
        if (i11 < this.this$0.f43609h.th().size()) {
            w Dh = this.this$0.f43608g;
            if (Dh == null) {
                Dh = null;
            }
            Dh.H.setText(this.this$0.f43609h.th().get(i11).getText());
        }
        this.this$0.f43609h.dismiss();
    }
}
