package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class y1 extends f {
    public final LinearLayout B;
    public final LoadingLayout C;
    public final SmartRefreshLayout D;
    public final RecyclerView E;

    public y1(Object obj, View view, int i11, LinearLayout linearLayout, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = loadingLayout;
        this.D = smartRefreshLayout;
        this.E = recyclerView;
    }

    public static y1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static y1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (y1) f.s(layoutInflater, R$layout.fragment_live_user, viewGroup, z11, obj);
    }
}
