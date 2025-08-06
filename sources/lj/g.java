package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import pro.huobi.R;

public abstract class g extends f {
    public final FrameLayout B;
    public final AppCompatImageView C;
    public final AppCompatImageView D;
    public final TabLayout E;
    public final AppCompatTextView F;
    public final View G;
    public final ViewPager2 H;

    public g(Object obj, View view, int i11, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TabLayout tabLayout, AppCompatTextView appCompatTextView, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = appCompatImageView;
        this.D = appCompatImageView2;
        this.E = tabLayout;
        this.F = appCompatTextView;
        this.G = view2;
        this.H = viewPager2;
    }

    public static g K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static g L(LayoutInflater layoutInflater, Object obj) {
        return (g) f.s(layoutInflater, R.layout.activity_contract_zero_swap, (ViewGroup) null, false, obj);
    }
}
