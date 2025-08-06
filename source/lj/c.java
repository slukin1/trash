package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.tradingbot.ui.BotDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import pro.huobi.R;

public abstract class c extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final LinearLayout D;
    public final FrameLayout E;
    public final FrameLayout F;
    public final LoadingLayout G;
    public final SmartRefreshLayout H;
    public final TextView I;
    public final View J;
    public final ViewPager2 K;
    public BotDetailActivity L;

    public c(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, TextView textView, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = linearLayout2;
        this.E = frameLayout;
        this.F = frameLayout2;
        this.G = loadingLayout;
        this.H = smartRefreshLayout;
        this.I = textView;
        this.J = view2;
        this.K = viewPager2;
    }

    public static c K(LayoutInflater layoutInflater) {
        return L(layoutInflater, androidx.databinding.c.d());
    }

    @Deprecated
    public static c L(LayoutInflater layoutInflater, Object obj) {
        return (c) f.s(layoutInflater, R.layout.activity_contract_bot_detail, (ViewGroup) null, false, obj);
    }

    public abstract void M(BotDetailActivity botDetailActivity);
}
