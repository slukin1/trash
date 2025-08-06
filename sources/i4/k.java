package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.business.common.R$layout;
import com.huobi.view.roundview.RoundTextView;

public abstract class k extends f {
    public final FrameLayout B;
    public final LottieAnimationView C;
    public final RoundTextView D;

    public k(Object obj, View view, int i11, FrameLayout frameLayout, LottieAnimationView lottieAnimationView, RoundTextView roundTextView) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = lottieAnimationView;
        this.D = roundTextView;
    }

    public static k K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static k L(LayoutInflater layoutInflater, Object obj) {
        return (k) f.s(layoutInflater, R$layout.view_airdrop, (ViewGroup) null, false, obj);
    }
}
