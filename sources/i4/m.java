package i4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.business.common.R$layout;
import com.huobi.view.roundview.RoundLinearLayout;

public abstract class m extends f {
    public final AppCompatImageView B;
    public final AppCompatImageView C;
    public final LinearLayout D;
    public final RoundLinearLayout E;
    public final AppCompatTextView F;

    public m(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout, AppCompatTextView appCompatTextView) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatImageView2;
        this.D = linearLayout;
        this.E = roundLinearLayout;
        this.F = appCompatTextView;
    }

    public static m K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static m L(LayoutInflater layoutInflater, Object obj) {
        return (m) f.s(layoutInflater, R$layout.view_swap_zero_side, (ViewGroup) null, false, obj);
    }
}
