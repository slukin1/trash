package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.custom.indicator.CoIndicator;

public abstract class i0 extends f {
    public final CoIndicator B;
    public final ImageView C;
    public final ImageView D;
    public final RelativeLayout E;
    public final RelativeLayout F;
    public final TextView G;
    public final TextView H;
    public final View I;
    public final ViewPager2 J;

    public i0(Object obj, View view, int i11, CoIndicator coIndicator, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = coIndicator;
        this.C = imageView;
        this.D = imageView2;
        this.E = relativeLayout;
        this.F = relativeLayout2;
        this.G = textView;
        this.H = textView2;
        this.I = view2;
        this.J = viewPager2;
    }

    public static i0 K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static i0 L(LayoutInflater layoutInflater, Object obj) {
        return (i0) f.s(layoutInflater, R$layout.dialog_live_rank, (ViewGroup) null, false, obj);
    }
}
