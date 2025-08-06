package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class w6 extends f {
    public final ImageView B;
    public final ImageView C;
    public final LinearLayout D;
    public final LinearLayout E;
    public final LinearLayout F;
    public final LinearLayout G;
    public final LinearLayout H;
    public final LinearLayout I;

    public w6(Object obj, View view, int i11, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = imageView2;
        this.D = linearLayout;
        this.E = linearLayout2;
        this.F = linearLayout3;
        this.G = linearLayout4;
        this.H = linearLayout5;
        this.I = linearLayout6;
    }

    public static w6 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static w6 L(LayoutInflater layoutInflater, Object obj) {
        return (w6) f.s(layoutInflater, R$layout.pop_tips, (ViewGroup) null, false, obj);
    }
}
