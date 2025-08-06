package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.common.LiveRecommendPkCommonView;

public abstract class k0 extends f {
    public final ConstraintLayout B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final LinearLayout F;
    public final LiveRecommendPkCommonView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    public final TextView T;
    public final TextView U;
    public final TextView V;
    public final TextView W;
    public final View X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(Object obj, View view, int i11, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LiveRecommendPkCommonView liveRecommendPkCommonView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, View view2) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = imageView3;
        this.F = linearLayout;
        this.G = liveRecommendPkCommonView;
        this.H = textView;
        this.I = textView2;
        this.J = textView3;
        this.K = textView4;
        this.L = textView5;
        this.M = textView6;
        this.N = textView7;
        this.O = textView8;
        this.P = textView9;
        this.Q = textView10;
        this.R = textView11;
        this.S = textView12;
        this.T = textView13;
        this.U = textView14;
        this.V = textView15;
        this.W = textView16;
        this.X = view2;
    }

    public static k0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static k0 L(LayoutInflater layoutInflater, Object obj) {
        return (k0) f.s(layoutInflater, R$layout.dialog_live_recommend, (ViewGroup) null, false, obj);
    }
}
