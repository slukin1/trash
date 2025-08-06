package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.GiftUser;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;

public abstract class k1 extends f {
    public final LinearLayout B;
    public final LinearLayout C;
    public final LoadingLayout D;
    public final RecyclerView E;
    public final TextView F;
    public GiftUser G;

    public k1(Object obj, View view, int i11, LinearLayout linearLayout, LinearLayout linearLayout2, LoadingLayout loadingLayout, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i11);
        this.B = linearLayout;
        this.C = linearLayout2;
        this.D = loadingLayout;
        this.E = recyclerView;
        this.F = textView;
    }

    public static k1 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static k1 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (k1) f.s(layoutInflater, R$layout.fragment_gift_rank, viewGroup, z11, obj);
    }

    public abstract void M(GiftUser giftUser);
}
