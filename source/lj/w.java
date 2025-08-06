package lj;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import com.google.android.material.appbar.AppBarLayout;
import com.huobi.copytrading.ui.CopyTradingHomeFragment;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.copytrading.widget.HBNestedScrollView;

public abstract class w extends f {
    public final AppBarLayout B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final LinearLayout F;
    public final HBNestedScrollView G;
    public final TextView H;
    public final TextView I;
    public CopyTradingViewModel J;
    public CopyTradingHomeFragment K;

    public w(Object obj, View view, int i11, AppBarLayout appBarLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, HBNestedScrollView hBNestedScrollView, TextView textView, TextView textView2) {
        super(obj, view, i11);
        this.B = appBarLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = imageView3;
        this.F = linearLayout;
        this.G = hBNestedScrollView;
        this.H = textView;
        this.I = textView2;
    }

    public abstract void K(CopyTradingHomeFragment copyTradingHomeFragment);

    public abstract void L(CopyTradingViewModel copyTradingViewModel);
}
