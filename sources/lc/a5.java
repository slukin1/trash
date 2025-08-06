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
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;

public abstract class a5 extends f {
    public final ConstraintLayout B;
    public final ImageView C;
    public final ImageView D;
    public final ImageView E;
    public final SafeLottieView F;
    public final LinearLayout G;
    public final LinearLayout H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public LiveDetailBean N;

    public a5(Object obj, View view, int i11, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, SafeLottieView safeLottieView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = imageView3;
        this.F = safeLottieView;
        this.G = linearLayout;
        this.H = linearLayout2;
        this.I = textView;
        this.J = textView2;
        this.K = textView3;
        this.L = textView4;
        this.M = textView5;
    }

    public static a5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static a5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (a5) f.s(layoutInflater, R$layout.item_live_content_two_cell_category, viewGroup, z11, obj);
    }

    public abstract void M(LiveDetailBean liveDetailBean);
}
