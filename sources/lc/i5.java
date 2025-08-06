package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.content.R$layout;

public abstract class i5 extends f {
    public final LinearLayout B;
    public final RecyclerView C;
    public final TextView D;

    public i5(Object obj, View view, int i11, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = recyclerView;
        this.D = textView;
    }

    public static i5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static i5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (i5) f.s(layoutInflater, R$layout.item_recommend_live, viewGroup, z11, obj);
    }
}
