package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.hbg.module.content.R$layout;

public abstract class a4 extends f {
    public final View B;
    public final ImageView C;
    public final LinearLayout D;
    public final TextView E;
    public final TextView F;
    public final TextView G;
    public DeepNews H;

    public a4(Object obj, View view, int i11, View view2, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i11);
        this.B = view2;
        this.C = imageView;
        this.D = linearLayout;
        this.E = textView;
        this.F = textView2;
        this.G = textView3;
    }

    public static a4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static a4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (a4) f.s(layoutInflater, R$layout.item_deep_news, viewGroup, z11, obj);
    }

    public abstract void M(DeepNews deepNews);
}
