package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.huobi.copytrading.ui.CopyTradingTraderInfoActivity;
import pro.huobi.R;

public abstract class i extends f {
    public final AppBarLayout B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final LinearLayout F;
    public final LinearLayout G;
    public final LinearLayout H;
    public final RelativeLayout I;
    public final RelativeLayout J;
    public final TabLayout K;
    public final TextView L;
    public final TextView M;
    public final View N;
    public final ViewPager2 O;
    public CopyTradingTraderInfoActivity P;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Object obj, View view, int i11, AppBarLayout appBarLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TabLayout tabLayout, TextView textView, TextView textView2, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = appBarLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = imageView3;
        this.F = linearLayout;
        this.G = linearLayout2;
        this.H = linearLayout3;
        this.I = relativeLayout;
        this.J = relativeLayout2;
        this.K = tabLayout;
        this.L = textView;
        this.M = textView2;
        this.N = view2;
        this.O = viewPager2;
    }

    public static i K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static i L(LayoutInflater layoutInflater, Object obj) {
        return (i) f.s(layoutInflater, R.layout.activity_copy_trading_trader_info, (ViewGroup) null, false, obj);
    }

    public abstract void M(CopyTradingTraderInfoActivity copyTradingTraderInfoActivity);
}
