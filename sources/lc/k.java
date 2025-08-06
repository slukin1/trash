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
import com.hbg.module.livesquare.ui.LiveCategoryActivity;

public abstract class k extends f {
    public final CoIndicator B;
    public final LoadingLayout C;
    public final NestedScrollableHost D;
    public final View E;
    public final ViewPager2 F;
    public LiveCategoryActivity G;

    public k(Object obj, View view, int i11, CoIndicator coIndicator, LoadingLayout loadingLayout, NestedScrollableHost nestedScrollableHost, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = coIndicator;
        this.C = loadingLayout;
        this.D = nestedScrollableHost;
        this.E = view2;
        this.F = viewPager2;
    }

    public static k K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static k L(LayoutInflater layoutInflater, Object obj) {
        return (k) f.s(layoutInflater, R$layout.activity_live_category, (ViewGroup) null, false, obj);
    }

    public abstract void M(LiveCategoryActivity liveCategoryActivity);
}
