package lj;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.DeepNews;
import com.huobi.view.roundview.RoundLinearLayout;

public abstract class i0 extends f {
    public final ImageView B;
    public final View C;
    public final View D;
    public final LinearLayout E;
    public final RoundLinearLayout F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public DeepNews L;

    public i0(Object obj, View view, int i11, ImageView imageView, View view2, View view3, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = view2;
        this.D = view3;
        this.E = linearLayout;
        this.F = roundLinearLayout;
        this.G = textView;
        this.H = textView2;
        this.I = textView3;
        this.J = textView4;
        this.K = textView5;
    }
}
