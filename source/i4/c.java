package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.common.R$layout;
import com.huobi.view.roundview.RoundFrameLayout;
import com.huobi.view.roundview.RoundTextView;

public abstract class c extends f {
    public final FrameLayout B;
    public final RoundFrameLayout C;
    public final LottieAnimationView D;
    public final AppCompatImageView E;
    public final LinearLayout F;
    public final RecyclerView G;
    public final RoundTextView H;
    public final RoundTextView I;
    public final AppCompatTextView J;
    public final AppCompatTextView K;
    public final AppCompatTextView L;

    public c(Object obj, View view, int i11, FrameLayout frameLayout, RoundFrameLayout roundFrameLayout, LottieAnimationView lottieAnimationView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, RecyclerView recyclerView, RoundTextView roundTextView, RoundTextView roundTextView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = roundFrameLayout;
        this.D = lottieAnimationView;
        this.E = appCompatImageView;
        this.F = linearLayout;
        this.G = recyclerView;
        this.H = roundTextView;
        this.I = roundTextView2;
        this.J = appCompatTextView;
        this.K = appCompatTextView2;
        this.L = appCompatTextView3;
    }

    public static c K(LayoutInflater layoutInflater) {
        return L(layoutInflater, androidx.databinding.c.d());
    }

    @Deprecated
    public static c L(LayoutInflater layoutInflater, Object obj) {
        return (c) f.s(layoutInflater, R$layout.dialog_fragment_airdrop_result, (ViewGroup) null, false, obj);
    }
}
