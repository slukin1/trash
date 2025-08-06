package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.module.content.R$layout;

public abstract class o5 extends f {
    public final ImageView B;
    public final ImageView C;
    public final LinearLayout D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public CommentInfo M;

    public o5(Object obj, View view, int i11, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = imageView2;
        this.D = linearLayout;
        this.E = textView;
        this.F = textView2;
        this.G = textView3;
        this.H = textView4;
        this.I = textView5;
        this.J = textView6;
        this.K = textView7;
        this.L = textView8;
    }

    public static o5 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static o5 L(LayoutInflater layoutInflater, Object obj) {
        return (o5) f.s(layoutInflater, R$layout.item_reply, (ViewGroup) null, false, obj);
    }

    public abstract void M(CommentInfo commentInfo);
}
