package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import com.hbg.lib.network.hbg.core.bean.TraderRank;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.widget.LineChartWidget;

public abstract class y5 extends f {
    public final ConstraintLayout B;
    public final ImageView C;
    public final ImageView D;
    public final LineChartWidget E;
    public final TextView F;
    public final TextView G;
    public final TextView H;
    public final TextView I;
    public final TextView J;
    public final TextView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final View Q;
    public TraderRank.TraderInfo R;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y5(Object obj, View view, int i11, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LineChartWidget lineChartWidget, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view2) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = imageView;
        this.D = imageView2;
        this.E = lineChartWidget;
        this.F = textView;
        this.G = textView2;
        this.H = textView3;
        this.I = textView4;
        this.J = textView5;
        this.K = textView6;
        this.L = textView7;
        this.M = textView8;
        this.N = textView9;
        this.O = textView10;
        this.P = textView11;
        this.Q = view2;
    }

    public static y5 K(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11) {
        return L(layoutInflater, viewGroup, z11, c.d());
    }

    @Deprecated
    public static y5 L(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z11, Object obj) {
        return (y5) f.s(layoutInflater, R$layout.item_trader_rank, viewGroup, z11, obj);
    }

    public abstract void M(TraderRank.TraderInfo traderInfo);
}
