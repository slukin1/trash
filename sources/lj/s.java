package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.google.android.material.appbar.AppBarLayout;
import com.huobi.tradingbot.ui.TradingBotActivity;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import com.huobi.view.MarketTitleLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import pro.huobi.R;

public abstract class s extends f {
    public final AppBarLayout B;
    public final RelativeLayout C;
    public final HorizontalScrollView D;
    public final ImageView E;
    public final ImageView F;
    public final ImageView G;
    public final LinearLayout H;
    public final FrameLayout I;
    public final LinearLayout J;
    public final LinearLayout K;
    public final SmartRefreshLayout L;
    public final MarketTitleLayout M;
    public final TextView N;
    public final View O;
    public TradingBotViewModel P;
    public TradingBotActivity Q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(Object obj, View view, int i11, AppBarLayout appBarLayout, RelativeLayout relativeLayout, HorizontalScrollView horizontalScrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, SmartRefreshLayout smartRefreshLayout, MarketTitleLayout marketTitleLayout, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = appBarLayout;
        this.C = relativeLayout;
        this.D = horizontalScrollView;
        this.E = imageView;
        this.F = imageView2;
        this.G = imageView3;
        this.H = linearLayout;
        this.I = frameLayout;
        this.J = linearLayout2;
        this.K = linearLayout3;
        this.L = smartRefreshLayout;
        this.M = marketTitleLayout;
        this.N = textView;
        this.O = view2;
    }

    public static s K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static s L(LayoutInflater layoutInflater, Object obj) {
        return (s) f.s(layoutInflater, R.layout.activity_trading_bot, (ViewGroup) null, false, obj);
    }

    public abstract void M(TradingBotActivity tradingBotActivity);

    public abstract void N(TradingBotViewModel tradingBotViewModel);
}
