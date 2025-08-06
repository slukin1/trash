package wh;

import com.google.android.material.tabs.TabLayout;
import com.huobi.asset2.index.BaseAssetTabFragment;

public final /* synthetic */ class m1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TabLayout f61321b;

    public /* synthetic */ m1(TabLayout tabLayout) {
        this.f61321b = tabLayout;
    }

    public final void run() {
        BaseAssetTabFragment.wh(this.f61321b);
    }
}
