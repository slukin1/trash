package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class a1 extends f {
    public final LoadingLayout B;
    public final RecyclerView C;
    public final SmartRefreshLayout D;
    public final TextView E;

    public a1(Object obj, View view, int i11, LoadingLayout loadingLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = recyclerView;
        this.D = smartRefreshLayout;
        this.E = textView;
    }

    public static a1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static a1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (a1) f.s(layoutInflater, R$layout.fragment_comment_list, viewGroup, z11, obj);
    }
}
