package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import pro.huobi.R;

public abstract class q extends f {
    public final CoIndicator B;
    public final AppCompatImageView C;
    public final AppCompatImageView D;
    public final AppCompatImageView E;
    public final ConstraintLayout F;
    public final View G;
    public final ViewPager2 H;

    public q(Object obj, View view, int i11, CoIndicator coIndicator, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = coIndicator;
        this.C = appCompatImageView;
        this.D = appCompatImageView2;
        this.E = appCompatImageView3;
        this.F = constraintLayout;
        this.G = view2;
        this.H = viewPager2;
    }

    public static q K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static q L(LayoutInflater layoutInflater, Object obj) {
        return (q) f.s(layoutInflater, R.layout.activity_message, (ViewGroup) null, false, obj);
    }
}
