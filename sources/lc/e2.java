package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.NestedScrollableHost;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class e2 extends f {
    public final AppBarLayout B;
    public final q4 C;
    public final CoIndicator D;
    public final CoordinatorLayout E;
    public final NestedScrollableHost F;
    public final SmartRefreshLayout G;
    public final View H;
    public final ViewPager2 I;

    public e2(Object obj, View view, int i11, AppBarLayout appBarLayout, q4 q4Var, CoIndicator coIndicator, CoordinatorLayout coordinatorLayout, NestedScrollableHost nestedScrollableHost, SmartRefreshLayout smartRefreshLayout, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = appBarLayout;
        this.C = q4Var;
        this.D = coIndicator;
        this.E = coordinatorLayout;
        this.F = nestedScrollableHost;
        this.G = smartRefreshLayout;
        this.H = view2;
        this.I = viewPager2;
    }

    public static e2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e2) f.s(layoutInflater, R$layout.fragment_news_home, viewGroup, z11, obj);
    }
}
