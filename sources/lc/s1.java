package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class s1 extends f {
    public final LoadingLayout B;
    public final SmartRefreshLayout C;
    public final RecyclerView D;

    public s1(Object obj, View view, int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = smartRefreshLayout;
        this.D = recyclerView;
    }

    public static s1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static s1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (s1) f.s(layoutInflater, R$layout.fragment_live_category_child, viewGroup, z11, obj);
    }
}
