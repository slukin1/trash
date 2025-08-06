package com.huobi.home.ui;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HomeFragment$registLogin$2 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$registLogin$2(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.f56620a;
    }

    public final void invoke(Integer num) {
        if (this.this$0.getContext() == null) {
            return;
        }
        if ((!(this.this$0.getContext() instanceof FragmentActivity) || !((FragmentActivity) this.this$0.getContext()).isFinishing()) && num != null) {
            HomeFragment homeFragment = this.this$0;
            num.intValue();
            ViewPager2 Oh = homeFragment.f72529w;
            if (Oh != null) {
                Oh.setCurrentItem(num.intValue(), false);
            }
        }
    }
}
