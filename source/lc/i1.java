package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.module.content.R$layout;

public abstract class i1 extends f {
    public final RecyclerView B;

    public i1(Object obj, View view, int i11, RecyclerView recyclerView) {
        super(obj, view, i11);
        this.B = recyclerView;
    }

    public static i1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static i1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (i1) f.s(layoutInflater, R$layout.fragment_gift_list, viewGroup, z11, obj);
    }
}
