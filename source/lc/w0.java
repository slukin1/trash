package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.huobi.view.roundview.RoundTextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class w0 extends f {
    public final RoundTextView B;
    public final RoundTextView C;
    public final LoadingLayout D;
    public final RecyclerView E;
    public final SmartRefreshLayout F;

    public w0(Object obj, View view, int i11, RoundTextView roundTextView, RoundTextView roundTextView2, LoadingLayout loadingLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i11);
        this.B = roundTextView;
        this.C = roundTextView2;
        this.D = loadingLayout;
        this.E = recyclerView;
        this.F = smartRefreshLayout;
    }

    public static w0 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static w0 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (w0) f.s(layoutInflater, R$layout.fragment_achievement_tab, viewGroup, z11, obj);
    }
}
