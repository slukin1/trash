package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class g2 extends f {
    public final View B;
    public final LinearLayout C;
    public final RecyclerView D;
    public final RecyclerView E;
    public final LoadingLayout F;
    public final SmartRefreshLayout G;
    public final TextView H;
    public final TextView I;
    public final TextView J;

    public g2(Object obj, View view, int i11, View view2, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i11);
        this.B = view2;
        this.C = linearLayout;
        this.D = recyclerView;
        this.E = recyclerView2;
        this.F = loadingLayout;
        this.G = smartRefreshLayout;
        this.H = textView;
        this.I = textView2;
        this.J = textView3;
    }

    public static g2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static g2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (g2) f.s(layoutInflater, R$layout.fragment_personal_center_tab, viewGroup, z11, obj);
    }
}
