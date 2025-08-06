package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.NestedScrollableHost;
import com.hbg.module.libkt.custom.indicator.CoIndicator;

public abstract class q1 extends f {
    public final CoIndicator B;
    public final LoadingLayout C;
    public final NestedScrollableHost D;
    public final ViewPager2 E;

    public q1(Object obj, View view, int i11, CoIndicator coIndicator, LoadingLayout loadingLayout, NestedScrollableHost nestedScrollableHost, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = coIndicator;
        this.C = loadingLayout;
        this.D = nestedScrollableHost;
        this.E = viewPager2;
    }

    public static q1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static q1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (q1) f.s(layoutInflater, R$layout.fragment_live_category, viewGroup, z11, obj);
    }
}
