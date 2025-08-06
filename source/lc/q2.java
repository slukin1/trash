package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryData;
import com.hbg.module.content.R$layout;

public abstract class q2 extends f {
    public final ImageView B;
    public final LinearLayout C;
    public final TextView D;
    public LiveCategoryData E;

    public q2(Object obj, View view, int i11, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i11);
        this.B = imageView;
        this.C = linearLayout;
        this.D = textView;
    }

    public static q2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static q2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (q2) f.s(layoutInflater, R$layout.item_category, viewGroup, z11, obj);
    }

    public abstract void M(LiveCategoryData liveCategoryData);
}
