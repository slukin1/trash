package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.content.R$layout;

public abstract class u2 extends f {
    public final RecyclerView B;
    public final TextView C;

    public u2(Object obj, View view, int i11, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = recyclerView;
        this.C = textView;
    }

    public static u2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static u2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (u2) f.s(layoutInflater, R$layout.item_community_attention_recommend, viewGroup, z11, obj);
    }
}
