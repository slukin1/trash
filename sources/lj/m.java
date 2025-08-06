package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import pro.huobi.R;

public abstract class m extends f {
    public final FrameLayout B;
    public final ImageView C;
    public final ImageView D;
    public final LinearLayout E;
    public final RelativeLayout F;
    public final LinearLayout G;
    public final TextView H;
    public final TextView I;
    public final View J;

    public m(Object obj, View view, int i11, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, View view2) {
        super(obj, view, i11);
        this.B = frameLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = linearLayout;
        this.F = relativeLayout;
        this.G = linearLayout2;
        this.H = textView;
        this.I = textView2;
        this.J = view2;
    }

    public static m K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static m L(LayoutInflater layoutInflater, Object obj) {
        return (m) f.s(layoutInflater, R.layout.activity_edge_engine_container, (ViewGroup) null, false, obj);
    }
}
