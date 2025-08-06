package lc;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;

public abstract class a7 extends f {
    public final LinearLayout B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final TextView F;
    public Boolean G;

    public a7(Object obj, View view, int i11, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = textView;
        this.D = textView2;
        this.E = textView3;
        this.F = textView4;
    }

    public abstract void K(Boolean bool);
}
