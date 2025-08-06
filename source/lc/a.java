package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.network.hbg.core.bean.CommentInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.ui.activity.CommentDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class a extends f {
    public final AppCompatImageView B;
    public final AppCompatTextView C;
    public final FrameLayout D;
    public final ImageView E;
    public final ImageView F;
    public final ImageView G;
    public final LinearLayout H;
    public final LoadingLayout I;
    public final SmartRefreshLayout J;
    public final RecyclerView K;
    public final TextView L;
    public final TextView M;
    public final TextView N;
    public final TextView O;
    public final TextView P;
    public final TextView Q;
    public final TextView R;
    public final View S;
    public CommentDetailActivity T;
    public CommentInfo U;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Object obj, View view, int i11, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, View view2) {
        super(obj, view, i11);
        this.B = appCompatImageView;
        this.C = appCompatTextView;
        this.D = frameLayout;
        this.E = imageView;
        this.F = imageView2;
        this.G = imageView3;
        this.H = linearLayout;
        this.I = loadingLayout;
        this.J = smartRefreshLayout;
        this.K = recyclerView;
        this.L = textView;
        this.M = textView2;
        this.N = textView3;
        this.O = textView4;
        this.P = textView5;
        this.Q = textView6;
        this.R = textView7;
        this.S = view2;
    }

    public static a K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static a L(LayoutInflater layoutInflater, Object obj) {
        return (a) f.s(layoutInflater, R$layout.activity_comment_detail, (ViewGroup) null, false, obj);
    }

    public abstract void M(CommentInfo commentInfo);

    public abstract void N(CommentDetailActivity commentDetailActivity);
}
