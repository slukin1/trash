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

public abstract class k2 extends f {
    public final RecyclerView B;
    public final LoadingLayout C;
    public final SmartRefreshLayout D;

    public k2(Object obj, View view, int i11, RecyclerView recyclerView, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i11);
        this.B = recyclerView;
        this.C = loadingLayout;
        this.D = smartRefreshLayout;
    }

    public static k2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static k2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (k2) f.s(layoutInflater, R$layout.fragment_topic_detail_tab, viewGroup, z11, obj);
    }
}
