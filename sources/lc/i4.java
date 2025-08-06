package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.utils.event.bean.GiftBean;

public abstract class i4 extends f {
    public final ImageView B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final LottieAnimationView F;
    public final LinearLayout G;
    public final RelativeLayout H;
    public final RelativeLayout I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public GiftBean P;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i4(Object obj, View view, int i11, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LottieAnimationView lottieAnimationView, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = imageView2;
        this.D = imageView3;
        this.E = imageView4;
        this.F = lottieAnimationView;
        this.G = linearLayout;
        this.H = relativeLayout;
        this.I = relativeLayout2;
        this.J = textView;
        this.K = textView2;
        this.L = textView3;
        this.M = textView4;
        this.N = textView5;
        this.O = textView6;
    }

    public static i4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static i4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (i4) f.s(layoutInflater, R$layout.item_gift, viewGroup, z11, obj);
    }

    public abstract void M(GiftBean giftBean);
}
