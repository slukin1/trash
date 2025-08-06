package lc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.like.KsgLikeView;
import com.hbg.module.content.ui.activity.live.FullScreenLiveActivity;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean;
import com.huobi.view.roundview.RoundTextView;

public abstract class i extends f {
    public final TextView A0;
    public final ConstraintLayout B;
    public final TextView B0;
    public final FrameLayout C;
    public final TextView C0;
    public final AvatarView D;
    public final View D0;
    public final ImageView E;
    public final LinearLayout E0;
    public final ImageView F;
    public final View F0;
    public final ImageView G;
    public FullScreenLiveActivity G0;
    public final ImageView H;
    public LiveDetailBean H0;
    public final ImageView I;
    public LiveSpeaker I0;
    public final ImageView J;
    public Integer J0;
    public final ImageView K;
    public LiveRedpacketBean K0;
    public final ImageView L;
    public Integer L0;
    public final KsgLikeView M;
    public final FrameLayout N;
    public final LottieAnimationView O;
    public final ImageView P;
    public final FrameLayout Q;
    public final o6 R;
    public final g6 S;
    public final k6 T;
    public final m6 U;
    public final FrameLayout V;
    public final FrameLayout W;
    public final LottieAnimationView X;
    public final LinearLayout Y;
    public final ConstraintLayout Z;

    /* renamed from: a0  reason: collision with root package name */
    public final LinearLayout f19173a0;

    /* renamed from: b0  reason: collision with root package name */
    public final LinearLayout f19174b0;

    /* renamed from: c0  reason: collision with root package name */
    public final RelativeLayout f19175c0;

    /* renamed from: d0  reason: collision with root package name */
    public final SeekBar f19176d0;

    /* renamed from: e0  reason: collision with root package name */
    public final RelativeLayout f19177e0;

    /* renamed from: f0  reason: collision with root package name */
    public final RelativeLayout f19178f0;

    /* renamed from: g0  reason: collision with root package name */
    public final RelativeLayout f19179g0;

    /* renamed from: h0  reason: collision with root package name */
    public final RecyclerView f19180h0;

    /* renamed from: i0  reason: collision with root package name */
    public final SafeLottieView f19181i0;

    /* renamed from: j0  reason: collision with root package name */
    public final TextView f19182j0;

    /* renamed from: k0  reason: collision with root package name */
    public final TextView f19183k0;

    /* renamed from: l0  reason: collision with root package name */
    public final TextView f19184l0;

    /* renamed from: m0  reason: collision with root package name */
    public final TextView f19185m0;

    /* renamed from: n0  reason: collision with root package name */
    public final TextView f19186n0;

    /* renamed from: t0  reason: collision with root package name */
    public final RoundTextView f19187t0;

    /* renamed from: u0  reason: collision with root package name */
    public final TextView f19188u0;

    /* renamed from: v0  reason: collision with root package name */
    public final TextView f19189v0;

    /* renamed from: w0  reason: collision with root package name */
    public final TextView f19190w0;

    /* renamed from: x0  reason: collision with root package name */
    public final TextView f19191x0;

    /* renamed from: y0  reason: collision with root package name */
    public final TextView f19192y0;

    /* renamed from: z0  reason: collision with root package name */
    public final LinearLayout f19193z0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Object obj, View view, int i11, ConstraintLayout constraintLayout, FrameLayout frameLayout, AvatarView avatarView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, KsgLikeView ksgLikeView, FrameLayout frameLayout2, LottieAnimationView lottieAnimationView, ImageView imageView9, FrameLayout frameLayout3, o6 o6Var, g6 g6Var, k6 k6Var, m6 m6Var, FrameLayout frameLayout4, FrameLayout frameLayout5, LottieAnimationView lottieAnimationView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, RelativeLayout relativeLayout, SeekBar seekBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RecyclerView recyclerView, SafeLottieView safeLottieView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoundTextView roundTextView, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, LinearLayout linearLayout4, TextView textView11, TextView textView12, TextView textView13, View view2, LinearLayout linearLayout5, View view3) {
        super(obj, view, i11);
        this.B = constraintLayout;
        this.C = frameLayout;
        this.D = avatarView;
        this.E = imageView;
        this.F = imageView2;
        this.G = imageView3;
        this.H = imageView4;
        this.I = imageView5;
        this.J = imageView6;
        this.K = imageView7;
        this.L = imageView8;
        this.M = ksgLikeView;
        this.N = frameLayout2;
        this.O = lottieAnimationView;
        this.P = imageView9;
        this.Q = frameLayout3;
        this.R = o6Var;
        this.S = g6Var;
        this.T = k6Var;
        this.U = m6Var;
        this.V = frameLayout4;
        this.W = frameLayout5;
        this.X = lottieAnimationView2;
        this.Y = linearLayout;
        this.Z = constraintLayout2;
        this.f19173a0 = linearLayout2;
        this.f19174b0 = linearLayout3;
        this.f19175c0 = relativeLayout;
        this.f19176d0 = seekBar;
        this.f19177e0 = relativeLayout2;
        this.f19178f0 = relativeLayout3;
        this.f19179g0 = relativeLayout4;
        this.f19180h0 = recyclerView;
        this.f19181i0 = safeLottieView;
        this.f19182j0 = textView;
        this.f19183k0 = textView2;
        this.f19184l0 = textView3;
        this.f19185m0 = textView4;
        this.f19186n0 = textView5;
        this.f19187t0 = roundTextView;
        this.f19188u0 = textView6;
        this.f19189v0 = textView7;
        this.f19190w0 = textView8;
        this.f19191x0 = textView9;
        this.f19192y0 = textView10;
        this.f19193z0 = linearLayout4;
        this.A0 = textView11;
        this.B0 = textView12;
        this.C0 = textView13;
        this.D0 = view2;
        this.E0 = linearLayout5;
        this.F0 = view3;
    }

    public static i K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static i L(LayoutInflater layoutInflater, Object obj) {
        return (i) f.s(layoutInflater, R$layout.activity_full_screen_live, (ViewGroup) null, false, obj);
    }

    public abstract void M(LiveDetailBean liveDetailBean);

    public abstract void N(Integer num);

    public abstract void O(FullScreenLiveActivity fullScreenLiveActivity);

    public abstract void P(LiveRedpacketBean liveRedpacketBean);

    public abstract void Q(Integer num);

    public abstract void R(LiveSpeaker liveSpeaker);
}
