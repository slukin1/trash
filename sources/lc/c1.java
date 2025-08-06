package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common.airdrop.view.AirdropView;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class c1 extends f {
    public final AirdropView B;
    public final ImageView C;
    public final ConstraintLayout D;
    public final LoadingLayout E;
    public final RecyclerView F;
    public final SmartRefreshLayout G;

    public c1(Object obj, View view, int i11, AirdropView airdropView, ImageView imageView, ConstraintLayout constraintLayout, LoadingLayout loadingLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout) {
        super(obj, view, i11);
        this.B = airdropView;
        this.C = imageView;
        this.D = constraintLayout;
        this.E = loadingLayout;
        this.F = recyclerView;
        this.G = smartRefreshLayout;
    }

    public static c1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static c1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (c1) f.s(layoutInflater, R$layout.fragment_community, viewGroup, z11, obj);
    }
}
