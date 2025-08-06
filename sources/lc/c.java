package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.business.common.airdrop.view.AirdropView;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.community.ui.DynamicDetailActivity;
import com.hbg.module.community.widgets.CommunityImageLayout;
import com.hbg.module.community.widgets.rich.RichWebView;
import com.hbg.module.content.R$layout;
import com.hbg.module.huobi.im.group.ui.active.ActiveWebView;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.common.PkCommonView;
import com.huobi.view.roundview.RoundLinearLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public abstract class c extends f {
    public final AppCompatTextView A0;
    public final AirdropView B;
    public final AppCompatTextView B0;
    public final RoundLinearLayout C;
    public final AppCompatTextView C0;
    public final LinearLayout D;
    public final AppCompatTextView D0;
    public final FrameLayout E;
    public final AppCompatTextView E0;
    public final AppCompatImageView F;
    public final TextView F0;
    public final AppCompatImageView G;
    public final View G0;
    public final CommunityImageLayout H;
    public final View H0;
    public final AppCompatImageView I;
    public final View I0;
    public final AppCompatImageView J;
    public final View J0;
    public final AvatarView K;
    public final ActiveWebView K0;
    public final AppCompatImageView L;
    public DynamicDetailActivity L0;
    public final ImageView M;
    public DynamicDetailInfo M0;
    public final AppCompatImageView N;
    public final LinearLayout O;
    public final LinearLayout P;
    public final LinearLayout Q;
    public final LoadingLayout R;
    public final LinearLayout S;
    public final LinearLayout T;
    public final RelativeLayout U;
    public final AppBarLayout V;
    public final PkCommonView W;
    public final RadioButton X;
    public final RadioButton Y;
    public final RichWebView Z;

    /* renamed from: a0  reason: collision with root package name */
    public final RelativeLayout f19146a0;

    /* renamed from: b0  reason: collision with root package name */
    public final RelativeLayout f19147b0;

    /* renamed from: c0  reason: collision with root package name */
    public final RelativeLayout f19148c0;

    /* renamed from: d0  reason: collision with root package name */
    public final RecyclerView f19149d0;

    /* renamed from: e0  reason: collision with root package name */
    public final SmartRefreshLayout f19150e0;

    /* renamed from: f0  reason: collision with root package name */
    public final i3 f19151f0;

    /* renamed from: g0  reason: collision with root package name */
    public final SafeLottieView f19152g0;

    /* renamed from: h0  reason: collision with root package name */
    public final TextView f19153h0;

    /* renamed from: i0  reason: collision with root package name */
    public final AppCompatTextView f19154i0;

    /* renamed from: j0  reason: collision with root package name */
    public final AppCompatTextView f19155j0;

    /* renamed from: k0  reason: collision with root package name */
    public final AppCompatTextView f19156k0;

    /* renamed from: l0  reason: collision with root package name */
    public final AppCompatTextView f19157l0;

    /* renamed from: m0  reason: collision with root package name */
    public final AppCompatTextView f19158m0;

    /* renamed from: n0  reason: collision with root package name */
    public final AppCompatTextView f19159n0;

    /* renamed from: t0  reason: collision with root package name */
    public final AppCompatTextView f19160t0;

    /* renamed from: u0  reason: collision with root package name */
    public final AppCompatTextView f19161u0;

    /* renamed from: v0  reason: collision with root package name */
    public final AppCompatTextView f19162v0;

    /* renamed from: w0  reason: collision with root package name */
    public final TextView f19163w0;

    /* renamed from: x0  reason: collision with root package name */
    public final AppCompatTextView f19164x0;

    /* renamed from: y0  reason: collision with root package name */
    public final AppCompatTextView f19165y0;

    /* renamed from: z0  reason: collision with root package name */
    public final AppCompatTextView f19166z0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Object obj, View view, int i11, AirdropView airdropView, RoundLinearLayout roundLinearLayout, LinearLayout linearLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, CommunityImageLayout communityImageLayout, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AvatarView avatarView, AppCompatImageView appCompatImageView5, ImageView imageView, AppCompatImageView appCompatImageView6, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LoadingLayout loadingLayout, LinearLayout linearLayout5, LinearLayout linearLayout6, RelativeLayout relativeLayout, AppBarLayout appBarLayout, PkCommonView pkCommonView, RadioButton radioButton, RadioButton radioButton2, RichWebView richWebView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, i3 i3Var, SafeLottieView safeLottieView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, TextView textView2, AppCompatTextView appCompatTextView10, AppCompatTextView appCompatTextView11, AppCompatTextView appCompatTextView12, AppCompatTextView appCompatTextView13, AppCompatTextView appCompatTextView14, AppCompatTextView appCompatTextView15, AppCompatTextView appCompatTextView16, AppCompatTextView appCompatTextView17, TextView textView3, View view2, View view3, View view4, View view5, ActiveWebView activeWebView) {
        super(obj, view, i11);
        this.B = airdropView;
        this.C = roundLinearLayout;
        this.D = linearLayout;
        this.E = frameLayout;
        this.F = appCompatImageView;
        this.G = appCompatImageView2;
        this.H = communityImageLayout;
        this.I = appCompatImageView3;
        this.J = appCompatImageView4;
        this.K = avatarView;
        this.L = appCompatImageView5;
        this.M = imageView;
        this.N = appCompatImageView6;
        this.O = linearLayout2;
        this.P = linearLayout3;
        this.Q = linearLayout4;
        this.R = loadingLayout;
        this.S = linearLayout5;
        this.T = linearLayout6;
        this.U = relativeLayout;
        this.V = appBarLayout;
        this.W = pkCommonView;
        this.X = radioButton;
        this.Y = radioButton2;
        this.Z = richWebView;
        this.f19146a0 = relativeLayout2;
        this.f19147b0 = relativeLayout3;
        this.f19148c0 = relativeLayout4;
        this.f19149d0 = recyclerView;
        this.f19150e0 = smartRefreshLayout;
        this.f19151f0 = i3Var;
        this.f19152g0 = safeLottieView;
        this.f19153h0 = textView;
        this.f19154i0 = appCompatTextView;
        this.f19155j0 = appCompatTextView2;
        this.f19156k0 = appCompatTextView3;
        this.f19157l0 = appCompatTextView4;
        this.f19158m0 = appCompatTextView5;
        this.f19159n0 = appCompatTextView6;
        this.f19160t0 = appCompatTextView7;
        this.f19161u0 = appCompatTextView8;
        this.f19162v0 = appCompatTextView9;
        this.f19163w0 = textView2;
        this.f19164x0 = appCompatTextView10;
        this.f19165y0 = appCompatTextView11;
        this.f19166z0 = appCompatTextView12;
        this.A0 = appCompatTextView13;
        this.B0 = appCompatTextView14;
        this.C0 = appCompatTextView15;
        this.D0 = appCompatTextView16;
        this.E0 = appCompatTextView17;
        this.F0 = textView3;
        this.G0 = view2;
        this.H0 = view3;
        this.I0 = view4;
        this.J0 = view5;
        this.K0 = activeWebView;
    }

    public static c K(LayoutInflater layoutInflater) {
        return L(layoutInflater, androidx.databinding.c.d());
    }

    @Deprecated
    public static c L(LayoutInflater layoutInflater, Object obj) {
        return (c) f.s(layoutInflater, R$layout.activity_dynamic_detail, (ViewGroup) null, false, obj);
    }

    public abstract void M(DynamicDetailInfo dynamicDetailInfo);

    public abstract void N(DynamicDetailActivity dynamicDetailActivity);
}
