package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.content.R$layout;

public abstract class u3 extends f {
    public final LinearLayout B;
    public final RecyclerView C;

    public u3(Object obj, View view, int i11, LinearLayout linearLayout, RecyclerView recyclerView) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = recyclerView;
    }

    public static u3 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static u3 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (u3) f.s(layoutInflater, R$layout.item_community_topic, viewGroup, z11, obj);
    }
}
