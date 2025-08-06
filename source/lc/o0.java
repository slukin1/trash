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
import com.hbg.module.huobi.im.view.AvatarView;

public abstract class o0 extends f {
    public final AvatarView B;
    public final LinearLayout C;
    public final LinearLayout D;
    public final LinearLayout E;
    public final TextView F;
    public final TextView G;
    public final ImageView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final View P;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o0(Object obj, View view, int i11, AvatarView avatarView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view2) {
        super(obj, view, i11);
        this.B = avatarView;
        this.C = linearLayout;
        this.D = linearLayout2;
        this.E = linearLayout3;
        this.F = textView;
        this.G = textView2;
        this.H = imageView;
        this.I = textView3;
        this.J = textView4;
        this.K = textView5;
        this.L = textView6;
        this.M = textView7;
        this.N = textView8;
        this.O = textView9;
        this.P = view2;
    }

    public static o0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static o0 L(LayoutInflater layoutInflater, Object obj) {
        return (o0) f.s(layoutInflater, R$layout.dialog_live_user_info, (ViewGroup) null, false, obj);
    }
}
