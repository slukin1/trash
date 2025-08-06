package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.google.android.material.appbar.AppBarLayout;
import com.huobi.tradenew.ui.kline.KlineView;
import com.huobi.tradingbot.ui.ContractGridActivity;
import com.huobi.tradingbot.vm.TradingBotViewModel;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import pro.huobi.R;

public abstract class e extends f {
    public final AppBarLayout B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final View F;
    public final KlineView G;
    public final LinearLayout H;
    public final LinearLayout I;
    public final LinearLayout J;
    public final FrameLayout K;
    public final LinearLayout L;
    public final LinearLayout M;
    public final LinearLayout N;
    public final LinearLayout O;
    public final RelativeLayout P;
    public final SmartRefreshLayout Q;
    public final RelativeLayout R;
    public final View S;
    public final TextView T;
    public final View U;
    public TradingBotViewModel V;
    public ContractGridActivity W;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Object obj, View view, int i11, AppBarLayout appBarLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, View view2, KlineView klineView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, RelativeLayout relativeLayout, SmartRefreshLayout smartRefreshLayout, RelativeLayout relativeLayout2, View view3, TextView textView, View view4) {
        super(obj, view, i11);
        this.B = appBarLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = imageView3;
        this.F = view2;
        this.G = klineView;
        this.H = linearLayout;
        this.I = linearLayout2;
        this.J = linearLayout3;
        this.K = frameLayout;
        this.L = linearLayout4;
        this.M = linearLayout5;
        this.N = linearLayout6;
        this.O = linearLayout7;
        this.P = relativeLayout;
        this.Q = smartRefreshLayout;
        this.R = relativeLayout2;
        this.S = view3;
        this.T = textView;
        this.U = view4;
    }

    public static e K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static e L(LayoutInflater layoutInflater, Object obj) {
        return (e) f.s(layoutInflater, R.layout.activity_contract_grid, (ViewGroup) null, false, obj);
    }

    public abstract void M(ContractGridActivity contractGridActivity);

    public abstract void N(TradingBotViewModel tradingBotViewModel);
}
