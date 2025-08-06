package cd;

import com.google.android.material.appbar.AppBarLayout;
import com.hbg.module.exchange.grid.ui.GridTradeInputView;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f13022b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout.Behavior f13023c;

    public /* synthetic */ a0(AppBarLayout appBarLayout, AppBarLayout.Behavior behavior) {
        this.f13022b = appBarLayout;
        this.f13023c = behavior;
    }

    public final void run() {
        GridTradeInputView.j(this.f13022b, this.f13023c);
    }
}
