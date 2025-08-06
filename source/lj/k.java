package lj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.huobi.view.radiogroup.RadioGroupContainer;
import pro.huobi.R;

public abstract class k extends f {
    public final RadioGroupContainer B;
    public final LinearLayout C;
    public final View D;
    public final View E;
    public final ViewPager2 F;

    public k(Object obj, View view, int i11, RadioGroupContainer radioGroupContainer, LinearLayout linearLayout, View view2, View view3, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = radioGroupContainer;
        this.C = linearLayout;
        this.D = view2;
        this.E = view3;
        this.F = viewPager2;
    }

    public static k K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static k L(LayoutInflater layoutInflater, Object obj) {
        return (k) f.s(layoutInflater, R.layout.activity_copytrading_main, (ViewGroup) null, false, obj);
    }
}
