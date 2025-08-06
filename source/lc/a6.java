package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.ContentUGCModel;
import com.hbg.module.content.R$layout;

public abstract class a6 extends f {
    public final ImageView B;
    public final ImageView C;
    public final LinearLayout D;
    public final RelativeLayout E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final Space J;
    public final Space K;
    public ContentUGCModel.UGCTaskModel L;

    public a6(Object obj, View view, int i11, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, Space space, Space space2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = imageView2;
        this.D = linearLayout;
        this.E = relativeLayout;
        this.F = textView;
        this.G = textView2;
        this.H = textView3;
        this.I = textView4;
        this.J = space;
        this.K = space2;
    }

    public static a6 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static a6 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (a6) f.s(layoutInflater, R$layout.item_ugc_task, viewGroup, z11, obj);
    }

    public abstract void M(ContentUGCModel.UGCTaskModel uGCTaskModel);
}
