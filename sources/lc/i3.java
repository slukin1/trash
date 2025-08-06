package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;
import com.huobi.view.roundimg.RoundedImageView;

public abstract class i3 extends f {
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final ConstraintLayout E;
    public final ImageView F;
    public final RoundedImageView G;
    public final ImageView H;
    public final LinearLayout I;
    public final LinearLayout J;
    public final LinearLayout K;
    public final SafeLottieView L;
    public final TextView M;

    public i3(Object obj, View view, int i11, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ConstraintLayout constraintLayout, ImageView imageView, RoundedImageView roundedImageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, SafeLottieView safeLottieView, TextView textView) {
        super(obj, view, i11);
        this.B = appCompatTextView;
        this.C = appCompatTextView2;
        this.D = appCompatTextView3;
        this.E = constraintLayout;
        this.F = imageView;
        this.G = roundedImageView;
        this.H = imageView2;
        this.I = linearLayout;
        this.J = linearLayout2;
        this.K = linearLayout3;
        this.L = safeLottieView;
        this.M = textView;
    }

    public static i3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static i3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (i3) f.s(layoutInflater, R$layout.item_community_feed_share, viewGroup, z11, obj);
    }
}
