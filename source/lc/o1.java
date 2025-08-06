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

public abstract class o1 extends f {
    public final LoadingLayout B;
    public final RecyclerView C;
    public final SmartRefreshLayout D;

    public o1(Object obj, View view, int i11, LoadingLayout loadingLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = recyclerView;
        this.D = smartRefreshLayout;
    }

    public static o1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static o1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (o1) f.s(layoutInflater, R$layout.fragment_kline_deep, viewGroup, z11, obj);
    }
}
