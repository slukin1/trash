package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;

public abstract class w1 extends f {
    public final LoadingLayout B;
    public final RecyclerView C;

    public w1(Object obj, View view, int i11, LoadingLayout loadingLayout, RecyclerView recyclerView) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = recyclerView;
    }

    public static w1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static w1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (w1) f.s(layoutInflater, R$layout.fragment_live_self_award, viewGroup, z11, obj);
    }
}
