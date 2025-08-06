package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class a0 extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final TextView D;
    public final TextView E;

    public a0(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = textView;
        this.E = textView2;
    }

    public static a0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a0 L(LayoutInflater layoutInflater, Object obj) {
        return (a0) f.s(layoutInflater, R$layout.custom_coin_tag, (ViewGroup) null, false, obj);
    }
}
