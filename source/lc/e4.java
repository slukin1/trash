package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.module.community.view.FlowLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.libkt.custom.DividerView;
import com.huobi.view.roundview.RoundFrameLayout;

public abstract class e4 extends f {
    public final RoundFrameLayout B;
    public final FlowLayout C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final DividerView F;

    public e4(Object obj, View view, int i11, RoundFrameLayout roundFrameLayout, FlowLayout flowLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, DividerView dividerView) {
        super(obj, view, i11);
        this.B = roundFrameLayout;
        this.C = flowLayout;
        this.D = appCompatTextView;
        this.E = appCompatTextView2;
        this.F = dividerView;
    }

    public static e4 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static e4 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (e4) f.s(layoutInflater, R$layout.item_fast_news, viewGroup, z11, obj);
    }
}
