package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.SisterBean;
import com.hbg.module.content.R$layout;

public abstract class q5 extends f {
    public final ImageView B;
    public final ImageView C;
    public final LinearLayout D;
    public final TextView E;
    public final View F;
    public final View G;
    public SisterBean H;

    public q5(Object obj, View view, int i11, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, View view2, View view3) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = imageView2;
        this.D = linearLayout;
        this.E = textView;
        this.F = view2;
        this.G = view3;
    }

    public static q5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static q5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (q5) f.s(layoutInflater, R$layout.item_sister, viewGroup, z11, obj);
    }

    public abstract void M(SisterBean sisterBean);
}
