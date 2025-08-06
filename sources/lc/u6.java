package lc;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.viewpager.widget.ViewPager;

public abstract class u6 extends f {
    public final LinearLayout B;
    public final TextView C;
    public final ViewPager D;

    public u6(Object obj, View view, int i11, LinearLayout linearLayout, TextView textView, ViewPager viewPager) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = textView;
        this.D = viewPager;
    }
}
