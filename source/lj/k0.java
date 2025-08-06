package lj;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.f;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.libkt.custom.blur.BlurView;
import com.huobi.view.roundview.RoundTextView;

public abstract class k0 extends f {
    public final BlurView B;
    public final CardView C;
    public final FrameLayout D;
    public final AppCompatImageView E;
    public final AppCompatImageView F;
    public final AppCompatImageView G;
    public final SafeLottieView H;
    public final LinearLayout I;
    public final LinearLayout J;
    public final RelativeLayout K;
    public final LinearLayout L;
    public final AppCompatTextView M;
    public final AppCompatTextView N;
    public final RoundTextView O;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(Object obj, View view, int i11, BlurView blurView, CardView cardView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, SafeLottieView safeLottieView, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, LinearLayout linearLayout3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, RoundTextView roundTextView) {
        super(obj, view, i11);
        this.B = blurView;
        this.C = cardView;
        this.D = frameLayout;
        this.E = appCompatImageView;
        this.F = appCompatImageView2;
        this.G = appCompatImageView3;
        this.H = safeLottieView;
        this.I = linearLayout;
        this.J = linearLayout2;
        this.K = relativeLayout;
        this.L = linearLayout3;
        this.M = appCompatTextView;
        this.N = appCompatTextView2;
        this.O = roundTextView;
    }
}
