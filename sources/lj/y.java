package lj;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.huobi.copytrading.ui.CopyTradingMeFragment;

public abstract class y extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final LinearLayout D;
    public final TabLayout E;
    public final TextView F;
    public final TextView G;
    public final ViewPager2 H;
    public CopyTradingMeFragment I;

    public y(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TabLayout tabLayout, TextView textView, TextView textView2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = linearLayout2;
        this.E = tabLayout;
        this.F = textView;
        this.G = textView2;
        this.H = viewPager2;
    }

    public abstract void K(CopyTradingMeFragment copyTradingMeFragment);
}
