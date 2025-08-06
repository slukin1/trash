package com.huobi.home.ui;

import androidx.fragment.app.FragmentActivity;
import com.huobi.home.engine.HomeEngineCore;
import com.huobi.home.engine.c;
import com.huobi.home.presenter.HomePresenter;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HomeFragment$registLogin$1 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeFragment$registLogin$1(HomeFragment homeFragment) {
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
        if (!(this.this$0.getContext() instanceof FragmentActivity) || !((FragmentActivity) this.this$0.getContext()).isFinishing()) {
            c.f72480a.b(this.this$0.A);
            ((HomePresenter) this.this$0.yh()).w0();
            HomeEngineCore.f72473a.d(this.this$0.A, (FragmentActivity) this.this$0.getContext());
        }
    }
}
