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
import com.huobi.view.roundview.RoundTextView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class i2 extends f {
    public final LinearLayout B;
    public final LoadingLayout C;
    public final RecyclerView D;
    public final SmartRefreshLayout E;
    public final TextView F;
    public final RoundTextView G;

    public i2(Object obj, View view, int i11, LinearLayout linearLayout, LoadingLayout loadingLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, TextView textView, RoundTextView roundTextView) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = loadingLayout;
        this.D = recyclerView;
        this.E = smartRefreshLayout;
        this.F = textView;
        this.G = roundTextView;
    }

    public static i2 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static i2 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (i2) f.s(layoutInflater, R$layout.fragment_recycler_list, viewGroup, z11, obj);
    }
}
