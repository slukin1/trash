package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.content.R$layout;

public abstract class u4 extends f {
    public final TextView B;
    public final View C;

    public u4(Object obj, View view, int i11, TextView textView, View view2) {
        super(obj, view, i11);
        this.B = textView;
        this.C = view2;
    }

    public static u4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static u4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (u4) f.s(layoutInflater, R$layout.item_live_category_title, viewGroup, z11, obj);
    }
}
