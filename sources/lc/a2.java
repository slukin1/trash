package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.NestedScrollableHost;
import com.hbg.module.libkt.custom.indicator.CoIndicator;

public abstract class a2 extends f {
    public final CoIndicator B;
    public final ImageView C;
    public final NestedScrollableHost D;
    public final ViewPager2 E;

    public a2(Object obj, View view, int i11, CoIndicator coIndicator, ImageView imageView, NestedScrollableHost nestedScrollableHost, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = coIndicator;
        this.C = imageView;
        this.D = nestedScrollableHost;
        this.E = viewPager2;
    }

    public static a2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static a2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (a2) f.s(layoutInflater, R$layout.fragment_new_content, viewGroup, z11, obj);
    }
}
