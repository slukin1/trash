package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.tag.TagLayout;
import com.hbg.module.content.ui.activity.NewsDetailActivity;
import com.hbg.module.content.widgets.ad.AdItemView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class q extends f {
    public final AdItemView B;
    public final AppBarLayout C;
    public final ConstraintLayout D;
    public final ConstraintLayout E;
    public final ConstraintLayout F;
    public final ConstraintLayout G;
    public final ImageView H;
    public final ImageView I;
    public final ImageView J;
    public final ImageView K;
    public final ImageView L;
    public final ImageView M;
    public final ImageView N;
    public final ImageView O;
    public final ImageView P;
    public final TagLayout Q;
    public final LoadingLayout R;
    public final LottieAnimationView S;
    public final LottieAnimationView T;
    public final LottieAnimationView U;
    public final RelativeLayout V;
    public final RelativeLayout W;
    public final RecyclerView X;
    public final RecyclerView Y;
    public final SmartRefreshLayout Z;

    /* renamed from: a0  reason: collision with root package name */
    public final TextView f19296a0;

    /* renamed from: b0  reason: collision with root package name */
    public final TextView f19297b0;

    /* renamed from: c0  reason: collision with root package name */
    public final TextView f19298c0;

    /* renamed from: d0  reason: collision with root package name */
    public final TextView f19299d0;

    /* renamed from: e0  reason: collision with root package name */
    public final TextView f19300e0;

    /* renamed from: f0  reason: collision with root package name */
    public final TextView f19301f0;

    /* renamed from: g0  reason: collision with root package name */
    public final TextView f19302g0;

    /* renamed from: h0  reason: collision with root package name */
    public final AppCompatTextView f19303h0;

    /* renamed from: i0  reason: collision with root package name */
    public final TextView f19304i0;

    /* renamed from: j0  reason: collision with root package name */
    public final TextView f19305j0;

    /* renamed from: k0  reason: collision with root package name */
    public final TextView f19306k0;

    /* renamed from: l0  reason: collision with root package name */
    public final TextView f19307l0;

    /* renamed from: m0  reason: collision with root package name */
    public final View f19308m0;

    /* renamed from: n0  reason: collision with root package name */
    public final View f19309n0;

    /* renamed from: t0  reason: collision with root package name */
    public final View f19310t0;

    /* renamed from: u0  reason: collision with root package name */
    public NewsDetailActivity f19311u0;

    /* renamed from: v0  reason: collision with root package name */
    public NewFlashInformation f19312v0;

    /* renamed from: w0  reason: collision with root package name */
    public NewFlashInformationImage f19313w0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(Object obj, View view, int i11, AdItemView adItemView, AppBarLayout appBarLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, TagLayout tagLayout, LoadingLayout loadingLayout, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, AppCompatTextView appCompatTextView, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view2, View view3, View view4) {
        super(obj, view, i11);
        this.B = adItemView;
        this.C = appBarLayout;
        this.D = constraintLayout;
        this.E = constraintLayout2;
        this.F = constraintLayout3;
        this.G = constraintLayout4;
        this.H = imageView;
        this.I = imageView2;
        this.J = imageView3;
        this.K = imageView4;
        this.L = imageView5;
        this.M = imageView6;
        this.N = imageView7;
        this.O = imageView8;
        this.P = imageView9;
        this.Q = tagLayout;
        this.R = loadingLayout;
        this.S = lottieAnimationView;
        this.T = lottieAnimationView2;
        this.U = lottieAnimationView3;
        this.V = relativeLayout;
        this.W = relativeLayout2;
        this.X = recyclerView;
        this.Y = recyclerView2;
        this.Z = smartRefreshLayout;
        this.f19296a0 = textView;
        this.f19297b0 = textView2;
        this.f19298c0 = textView3;
        this.f19299d0 = textView4;
        this.f19300e0 = textView5;
        this.f19301f0 = textView6;
        this.f19302g0 = textView7;
        this.f19303h0 = appCompatTextView;
        this.f19304i0 = textView8;
        this.f19305j0 = textView9;
        this.f19306k0 = textView10;
        this.f19307l0 = textView11;
        this.f19308m0 = view2;
        this.f19309n0 = view3;
        this.f19310t0 = view4;
    }

    public static q K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static q L(LayoutInflater layoutInflater, Object obj) {
        return (q) f.s(layoutInflater, R$layout.activity_news_detail, (ViewGroup) null, false, obj);
    }

    public abstract void M(NewFlashInformationImage newFlashInformationImage);

    public abstract void N(NewsDetailActivity newsDetailActivity);

    public abstract void O(NewFlashInformation newFlashInformation);
}
