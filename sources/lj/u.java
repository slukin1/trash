package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.huobi.view.roundview.RoundLinearLayout;
import com.huobi.view.roundview.RoundTextView;
import pro.huobi.R;

public abstract class u extends f {
    public final ConstraintLayout B;
    public final RoundTextView C;
    public final NestedScrollView D;
    public final AppCompatImageView E;
    public final LinearLayout F;
    public final RoundLinearLayout G;
    public final ConstraintLayout H;
    public final AppCompatTextView I;
    public final AppCompatTextView J;

    public u(Object obj, View view, int i11, ConstraintLayout constraintLayout, RoundTextView roundTextView, NestedScrollView nestedScrollView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout, ConstraintLayout constraintLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = roundTextView;
        this.D = nestedScrollView;
        this.E = appCompatImageView;
        this.F = linearLayout;
        this.G = roundLinearLayout;
        this.H = constraintLayout2;
        this.I = appCompatTextView;
        this.J = appCompatTextView2;
    }

    public static u K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static u L(LayoutInflater layoutInflater, Object obj) {
        return (u) f.s(layoutInflater, R.layout.dialog_fragment_zero_swap, (ViewGroup) null, false, obj);
    }
}
