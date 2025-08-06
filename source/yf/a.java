package yf;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.share.R$layout;
import com.hbg.module.share.ui.FeedShareActivity;
import com.huobi.view.roundimg.RoundedImageView;

public abstract class a extends f {
    public final EditText B;
    public final RoundedImageView C;
    public final LinearLayout D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final View J;
    public FeedShareActivity K;

    public a(Object obj, View view, int i11, EditText editText, RoundedImageView roundedImageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2) {
        super(obj, view, i11);
        this.B = editText;
        this.C = roundedImageView;
        this.D = linearLayout;
        this.E = textView;
        this.F = textView2;
        this.G = textView3;
        this.H = textView4;
        this.I = textView5;
        this.J = view2;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R$layout.activity_feed_share, (ViewGroup) null, false, obj);
    }

    public abstract void M(FeedShareActivity feedShareActivity);
}
