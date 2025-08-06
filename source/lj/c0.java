package lj;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.huobi.copytrading.ui.CopyTradingTradeFragment;
import com.huobi.tradenew.ui.kline.KlineView;

public abstract class c0 extends f {
    public final View B;
    public final View C;
    public final KlineView D;
    public final RelativeLayout E;
    public final LinearLayout F;
    public final LinearLayout G;
    public final LinearLayout H;
    public final TabLayout I;
    public final View J;
    public final RelativeLayout K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final ViewPager2 P;
    public CopyTradingTradeFragment Q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c0(Object obj, View view, int i11, View view2, View view3, KlineView klineView, RelativeLayout relativeLayout, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TabLayout tabLayout, View view4, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = view2;
        this.C = view3;
        this.D = klineView;
        this.E = relativeLayout;
        this.F = linearLayout;
        this.G = linearLayout2;
        this.H = linearLayout3;
        this.I = tabLayout;
        this.J = view4;
        this.K = relativeLayout2;
        this.L = textView;
        this.M = textView2;
        this.N = textView3;
        this.O = textView4;
        this.P = viewPager2;
    }

    public abstract void K(CopyTradingTradeFragment copyTradingTradeFragment);
}
