package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.ui.activity.NewContentActivity;
import com.hbg.module.libkt.custom.indicator.CoIndicator;

public abstract class o extends f {
    public final CoIndicator B;
    public final ImageView C;
    public final View D;
    public final ViewPager2 E;
    public NewContentActivity F;

    public o(Object obj, View view, int i11, CoIndicator coIndicator, ImageView imageView, View view2, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = coIndicator;
        this.C = imageView;
        this.D = view2;
        this.E = viewPager2;
    }

    public static o K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static o L(LayoutInflater layoutInflater, Object obj) {
        return (o) f.s(layoutInflater, R$layout.activity_new_content, (ViewGroup) null, false, obj);
    }

    public abstract void M(NewContentActivity newContentActivity);
}
