package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.livesquare.ui.RecommendSpeakerActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class w extends f {
    public final LoadingLayout B;
    public final AppBarLayout C;
    public final RelativeLayout D;
    public final SmartRefreshLayout E;
    public final RecyclerView F;
    public final RelativeLayout G;
    public final TextView H;
    public final TextView I;
    public final View J;
    public final View K;
    public RecommendSpeakerActivity L;

    public w(Object obj, View view, int i11, LoadingLayout loadingLayout, AppBarLayout appBarLayout, RelativeLayout relativeLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, RelativeLayout relativeLayout2, TextView textView, TextView textView2, View view2, View view3) {
        super(obj, view, i11);
        this.B = loadingLayout;
        this.C = appBarLayout;
        this.D = relativeLayout;
        this.E = smartRefreshLayout;
        this.F = recyclerView;
        this.G = relativeLayout2;
        this.H = textView;
        this.I = textView2;
        this.J = view2;
        this.K = view3;
    }

    public static w K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static w L(LayoutInflater layoutInflater, Object obj) {
        return (w) f.s(layoutInflater, R$layout.activity_recommend_speaker, (ViewGroup) null, false, obj);
    }

    public abstract void M(RecommendSpeakerActivity recommendSpeakerActivity);
}
