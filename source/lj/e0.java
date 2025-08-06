package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.huobi.view.roundview.RoundTextView;
import pro.huobi.R;

public abstract class e0 extends f {
    public final AppCompatImageView B;
    public final RoundTextView C;
    public final RoundTextView D;
    public final RoundTextView E;
    public final AppCompatTextView F;
    public final AppCompatTextView G;
    public final AppCompatTextView H;
    public final AppCompatTextView I;
    public final AppCompatTextView J;
    public final AppCompatTextView K;
    public final AppCompatTextView L;

    public e0(Object obj, View view, int i11, AppCompatImageView appCompatImageView, RoundTextView roundTextView, RoundTextView roundTextView2, RoundTextView roundTextView3, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = roundTextView;
        this.D = roundTextView2;
        this.E = roundTextView3;
        this.F = appCompatTextView;
        this.G = appCompatTextView2;
        this.H = appCompatTextView3;
        this.I = appCompatTextView4;
        this.J = appCompatTextView5;
        this.K = appCompatTextView6;
        this.L = appCompatTextView7;
    }

    public static e0 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e0 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e0) f.s(layoutInflater, R.layout.item_dialog_zero_swap, viewGroup, z11, obj);
    }
}
