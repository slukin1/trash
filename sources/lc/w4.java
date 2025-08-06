package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;

public abstract class w4 extends f {
    public final ConstraintLayout B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final SafeLottieView F;
    public final LinearLayout G;
    public final LinearLayout H;
    public final LinearLayout I;
    public final RelativeLayout J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    public LiveDetailBean T;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w4(Object obj, View view, int i11, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, SafeLottieView safeLottieView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = imageView3;
        this.F = safeLottieView;
        this.G = linearLayout;
        this.H = linearLayout2;
        this.I = linearLayout3;
        this.J = relativeLayout;
        this.K = textView;
        this.L = textView2;
        this.M = textView3;
        this.N = textView4;
        this.O = textView5;
        this.P = textView6;
        this.Q = textView7;
        this.R = textView8;
        this.S = textView9;
    }

    public static w4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static w4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (w4) f.s(layoutInflater, R$layout.item_live_content_one_cell_category, viewGroup, z11, obj);
    }

    public abstract void M(LiveDetailBean liveDetailBean);
}
