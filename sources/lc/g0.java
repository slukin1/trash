package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class g0 extends f {
    public final ConstraintLayout B;
    public final ConstraintLayout C;
    public final ImageView D;
    public final ImageView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final View I;
    public final View J;
    public final View K;

    public g0(Object obj, View view, int i11, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, View view2, View view3, View view4) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = constraintLayout2;
        this.D = imageView;
        this.E = imageView2;
        this.F = textView;
        this.G = textView2;
        this.H = textView3;
        this.I = view2;
        this.J = view3;
        this.K = view4;
    }

    public static g0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static g0 L(LayoutInflater layoutInflater, Object obj) {
        return (g0) f.s(layoutInflater, R$layout.dialog_live_more_controller, (ViewGroup) null, false, obj);
    }
}
