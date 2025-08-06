package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.business.common.R$layout;

public abstract class a extends f {
    public final ConstraintLayout B;
    public final ConstraintLayout C;
    public final LottieAnimationView D;
    public final AppCompatImageView E;
    public final LottieAnimationView F;
    public final AppCompatImageView G;
    public final AppCompatTextView H;
    public final AppCompatTextView I;
    public final AppCompatTextView J;
    public final TextView K;
    public final TextView L;
    public final AppCompatTextView M;
    public final AppCompatTextView N;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Object obj, View view, int i11, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView, LottieAnimationView lottieAnimationView2, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView, TextView textView2, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = constraintLayout2;
        this.D = lottieAnimationView;
        this.E = appCompatImageView;
        this.F = lottieAnimationView2;
        this.G = appCompatImageView2;
        this.H = appCompatTextView;
        this.I = appCompatTextView2;
        this.J = appCompatTextView3;
        this.K = textView;
        this.L = textView2;
        this.M = appCompatTextView4;
        this.N = appCompatTextView5;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R$layout.dialog_fragment_airdrop_claim, (ViewGroup) null, false, obj);
    }
}
