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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.c;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveGroup;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.content.R$layout;
import com.hbg.module.content.custom.ConflictNestedScrollView;
import com.hbg.module.content.custom.like.KsgLikeView;
import com.hbg.module.content.ui.activity.LiveGroupUserListView;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.content.widgets.AutoMarqueeTextView;
import com.hbg.module.huobi.im.view.AvatarView;
import com.hbg.module.libkt.custom.CircleProgress;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.utils.event.bean.LiveRedpacketBean;
import com.huobi.view.roundview.RoundTextView;
import com.tencent.rtmp.ui.TXCloudVideoView;

public abstract class m extends f {
    public final ImageView A0;
    public final RecyclerView A1;
    public final TextView A2;
    public final a7 B;
    public final KsgLikeView B0;
    public final RecyclerView B1;
    public final TextView B2;
    public final View C;
    public final LottieAnimationView C0;
    public final SafeLottieView C1;
    public final TXCloudVideoView C2;
    public final CircleProgress D;
    public final LottieAnimationView D0;
    public final SafeLottieView D1;
    public final View D2;
    public final a7 E;
    public final ImageView E0;
    public final SafeLottieView E1;
    public final View E2;
    public final ConstraintLayout F;
    public final e6 F0;
    public final TextView F1;
    public final LinearLayout F2;
    public final ConstraintLayout G;
    public final u0 G0;
    public final TextView G1;
    public final View G2;
    public final ConstraintLayout H;
    public final FrameLayout H0;
    public final TextView H1;
    public final View H2;
    public final ConstraintLayout I;
    public final e6 I0;
    public final TextView I1;
    public final View I2;
    public final CoIndicator J;
    public final o6 J0;
    public final TextView J1;
    public final View J2;
    public final FrameLayout K;
    public final RelativeLayout K0;
    public final TextView K1;
    public final View K2;
    public final FrameLayout L;
    public final g6 L0;
    public final TextView L1;
    public final View L2;
    public final LiveGroupUserListView M;
    public final k6 M0;
    public final TextView M1;
    public final View M2;
    public final ConflictNestedScrollView N;
    public final m6 N0;
    public final TextView N1;
    public final View N2;
    public final ImageView O;
    public final u6 O0;
    public final TextView O1;
    public final View O2;
    public final AvatarView P;
    public final LinearLayout P0;
    public final TextView P1;
    public final View P2;
    public final AvatarView Q;
    public final FrameLayout Q0;
    public final TextView Q1;
    public final ViewPager2 Q2;
    public final ImageView R;
    public final FrameLayout R0;
    public final TextView R1;
    public LiveDetailActivity R2;
    public final ImageView S;
    public final RelativeLayout S0;
    public final TextView S1;
    public LiveDetailBean S2;
    public final AvatarView T;
    public final LinearLayout T0;
    public final TextView T1;
    public LiveSpeaker T2;
    public final ImageView U;
    public final LinearLayout U0;
    public final TextView U1;
    public LiveGroup U2;
    public final ImageView V;
    public final LinearLayout V0;
    public final TextView V1;
    public Integer V2;
    public final ImageView W;
    public final LinearLayout W0;
    public final RoundTextView W1;
    public Integer W2;
    public final ImageView X;
    public final LinearLayout X0;
    public final TextView X1;
    public LiveRedpacketBean X2;
    public final ImageView Y;
    public final LinearLayout Y0;
    public final RoundTextView Y1;
    public Integer Y2;
    public final ImageView Z;
    public final LinearLayout Z0;
    public final TextView Z1;

    /* renamed from: a0  reason: collision with root package name */
    public final ImageView f19197a0;

    /* renamed from: a1  reason: collision with root package name */
    public final LinearLayout f19198a1;

    /* renamed from: a2  reason: collision with root package name */
    public final TextView f19199a2;

    /* renamed from: b0  reason: collision with root package name */
    public final ImageView f19200b0;

    /* renamed from: b1  reason: collision with root package name */
    public final LinearLayout f19201b1;

    /* renamed from: b2  reason: collision with root package name */
    public final AutoMarqueeTextView f19202b2;

    /* renamed from: c0  reason: collision with root package name */
    public final ImageView f19203c0;

    /* renamed from: c1  reason: collision with root package name */
    public final LinearLayout f19204c1;

    /* renamed from: c2  reason: collision with root package name */
    public final AutoMarqueeTextView f19205c2;

    /* renamed from: d0  reason: collision with root package name */
    public final ImageView f19206d0;

    /* renamed from: d1  reason: collision with root package name */
    public final LinearLayout f19207d1;

    /* renamed from: d2  reason: collision with root package name */
    public final TextView f19208d2;

    /* renamed from: e0  reason: collision with root package name */
    public final ImageView f19209e0;

    /* renamed from: e1  reason: collision with root package name */
    public final LinearLayout f19210e1;

    /* renamed from: e2  reason: collision with root package name */
    public final TextView f19211e2;

    /* renamed from: f0  reason: collision with root package name */
    public final ImageView f19212f0;

    /* renamed from: f1  reason: collision with root package name */
    public final LinearLayout f19213f1;

    /* renamed from: f2  reason: collision with root package name */
    public final TextView f19214f2;

    /* renamed from: g0  reason: collision with root package name */
    public final ImageView f19215g0;

    /* renamed from: g1  reason: collision with root package name */
    public final LinearLayout f19216g1;

    /* renamed from: g2  reason: collision with root package name */
    public final TextView f19217g2;

    /* renamed from: h0  reason: collision with root package name */
    public final ImageView f19218h0;

    /* renamed from: h1  reason: collision with root package name */
    public final LinearLayout f19219h1;

    /* renamed from: h2  reason: collision with root package name */
    public final TextView f19220h2;

    /* renamed from: i0  reason: collision with root package name */
    public final ImageView f19221i0;

    /* renamed from: i1  reason: collision with root package name */
    public final LinearLayout f19222i1;

    /* renamed from: i2  reason: collision with root package name */
    public final TextView f19223i2;

    /* renamed from: j0  reason: collision with root package name */
    public final ImageView f19224j0;

    /* renamed from: j1  reason: collision with root package name */
    public final LinearLayout f19225j1;

    /* renamed from: j2  reason: collision with root package name */
    public final TextView f19226j2;

    /* renamed from: k0  reason: collision with root package name */
    public final SafeLottieView f19227k0;

    /* renamed from: k1  reason: collision with root package name */
    public final LinearLayout f19228k1;

    /* renamed from: k2  reason: collision with root package name */
    public final ImageView f19229k2;

    /* renamed from: l0  reason: collision with root package name */
    public final ImageView f19230l0;

    /* renamed from: l1  reason: collision with root package name */
    public final SeekBar f19231l1;

    /* renamed from: l2  reason: collision with root package name */
    public final RelativeLayout f19232l2;

    /* renamed from: m0  reason: collision with root package name */
    public final ImageView f19233m0;

    /* renamed from: m1  reason: collision with root package name */
    public final RelativeLayout f19234m1;

    /* renamed from: m2  reason: collision with root package name */
    public final LinearLayout f19235m2;

    /* renamed from: n0  reason: collision with root package name */
    public final ImageView f19236n0;

    /* renamed from: n1  reason: collision with root package name */
    public final RelativeLayout f19237n1;

    /* renamed from: n2  reason: collision with root package name */
    public final LinearLayout f19238n2;

    /* renamed from: o1  reason: collision with root package name */
    public final RelativeLayout f19239o1;

    /* renamed from: o2  reason: collision with root package name */
    public final ImageView f19240o2;

    /* renamed from: p1  reason: collision with root package name */
    public final RelativeLayout f19241p1;

    /* renamed from: p2  reason: collision with root package name */
    public final TextView f19242p2;

    /* renamed from: q1  reason: collision with root package name */
    public final RelativeLayout f19243q1;

    /* renamed from: q2  reason: collision with root package name */
    public final AppCompatTextView f19244q2;

    /* renamed from: r1  reason: collision with root package name */
    public final RelativeLayout f19245r1;

    /* renamed from: r2  reason: collision with root package name */
    public final TextView f19246r2;

    /* renamed from: s1  reason: collision with root package name */
    public final RelativeLayout f19247s1;

    /* renamed from: s2  reason: collision with root package name */
    public final TextView f19248s2;

    /* renamed from: t0  reason: collision with root package name */
    public final ImageView f19249t0;

    /* renamed from: t1  reason: collision with root package name */
    public final RelativeLayout f19250t1;

    /* renamed from: t2  reason: collision with root package name */
    public final TextView f19251t2;

    /* renamed from: u0  reason: collision with root package name */
    public final ImageView f19252u0;

    /* renamed from: u1  reason: collision with root package name */
    public final RelativeLayout f19253u1;

    /* renamed from: u2  reason: collision with root package name */
    public final LinearLayout f19254u2;

    /* renamed from: v0  reason: collision with root package name */
    public final ImageView f19255v0;

    /* renamed from: v1  reason: collision with root package name */
    public final RelativeLayout f19256v1;

    /* renamed from: v2  reason: collision with root package name */
    public final TextView f19257v2;

    /* renamed from: w0  reason: collision with root package name */
    public final ImageView f19258w0;

    /* renamed from: w1  reason: collision with root package name */
    public final RelativeLayout f19259w1;

    /* renamed from: w2  reason: collision with root package name */
    public final TextView f19260w2;

    /* renamed from: x0  reason: collision with root package name */
    public final ImageView f19261x0;

    /* renamed from: x1  reason: collision with root package name */
    public final RelativeLayout f19262x1;

    /* renamed from: x2  reason: collision with root package name */
    public final TextView f19263x2;

    /* renamed from: y0  reason: collision with root package name */
    public final AppCompatImageView f19264y0;

    /* renamed from: y1  reason: collision with root package name */
    public final RelativeLayout f19265y1;

    /* renamed from: y2  reason: collision with root package name */
    public final TextView f19266y2;

    /* renamed from: z0  reason: collision with root package name */
    public final ImageView f19267z0;

    /* renamed from: z1  reason: collision with root package name */
    public final RecyclerView f19268z1;

    /* renamed from: z2  reason: collision with root package name */
    public final TextView f19269z2;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Object obj, View view, int i11, a7 a7Var, View view2, CircleProgress circleProgress, a7 a7Var2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, CoIndicator coIndicator, FrameLayout frameLayout, FrameLayout frameLayout2, LiveGroupUserListView liveGroupUserListView, ConflictNestedScrollView conflictNestedScrollView, ImageView imageView, AvatarView avatarView, AvatarView avatarView2, ImageView imageView2, ImageView imageView3, AvatarView avatarView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, ImageView imageView17, ImageView imageView18, ImageView imageView19, SafeLottieView safeLottieView, ImageView imageView20, ImageView imageView21, ImageView imageView22, ImageView imageView23, ImageView imageView24, ImageView imageView25, ImageView imageView26, ImageView imageView27, AppCompatImageView appCompatImageView, ImageView imageView28, ImageView imageView29, KsgLikeView ksgLikeView, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, ImageView imageView30, e6 e6Var, u0 u0Var, FrameLayout frameLayout3, e6 e6Var2, o6 o6Var, RelativeLayout relativeLayout, g6 g6Var, k6 k6Var, m6 m6Var, u6 u6Var, LinearLayout linearLayout, FrameLayout frameLayout4, FrameLayout frameLayout5, RelativeLayout relativeLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, LinearLayout linearLayout16, LinearLayout linearLayout17, LinearLayout linearLayout18, LinearLayout linearLayout19, SeekBar seekBar, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, SafeLottieView safeLottieView2, SafeLottieView safeLottieView3, SafeLottieView safeLottieView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, RoundTextView roundTextView, TextView textView18, RoundTextView roundTextView2, TextView textView19, TextView textView20, AutoMarqueeTextView autoMarqueeTextView, AutoMarqueeTextView autoMarqueeTextView2, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, ImageView imageView31, RelativeLayout relativeLayout16, LinearLayout linearLayout20, LinearLayout linearLayout21, ImageView imageView32, TextView textView28, AppCompatTextView appCompatTextView, TextView textView29, TextView textView30, TextView textView31, LinearLayout linearLayout22, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TXCloudVideoView tXCloudVideoView, View view3, View view4, LinearLayout linearLayout23, View view5, View view6, View view7, View view8, View view9, View view10, View view11, View view12, View view13, View view14, ViewPager2 viewPager2) {
        super(obj, view, i11);
        this.B = a7Var;
        this.C = view2;
        this.D = circleProgress;
        this.E = a7Var2;
        this.F = constraintLayout;
        this.G = constraintLayout2;
        this.H = constraintLayout3;
        this.I = constraintLayout4;
        this.J = coIndicator;
        this.K = frameLayout;
        this.L = frameLayout2;
        this.M = liveGroupUserListView;
        this.N = conflictNestedScrollView;
        this.O = imageView;
        this.P = avatarView;
        this.Q = avatarView2;
        this.R = imageView2;
        this.S = imageView3;
        this.T = avatarView3;
        this.U = imageView4;
        this.V = imageView5;
        this.W = imageView6;
        this.X = imageView7;
        this.Y = imageView8;
        this.Z = imageView9;
        this.f19197a0 = imageView10;
        this.f19200b0 = imageView11;
        this.f19203c0 = imageView12;
        this.f19206d0 = imageView13;
        this.f19209e0 = imageView14;
        this.f19212f0 = imageView15;
        this.f19215g0 = imageView16;
        this.f19218h0 = imageView17;
        this.f19221i0 = imageView18;
        this.f19224j0 = imageView19;
        this.f19227k0 = safeLottieView;
        this.f19230l0 = imageView20;
        this.f19233m0 = imageView21;
        this.f19236n0 = imageView22;
        this.f19249t0 = imageView23;
        this.f19252u0 = imageView24;
        this.f19255v0 = imageView25;
        this.f19258w0 = imageView26;
        this.f19261x0 = imageView27;
        this.f19264y0 = appCompatImageView;
        this.f19267z0 = imageView28;
        this.A0 = imageView29;
        this.B0 = ksgLikeView;
        this.C0 = lottieAnimationView;
        this.D0 = lottieAnimationView2;
        this.E0 = imageView30;
        this.F0 = e6Var;
        this.G0 = u0Var;
        this.H0 = frameLayout3;
        this.I0 = e6Var2;
        this.J0 = o6Var;
        this.K0 = relativeLayout;
        this.L0 = g6Var;
        this.M0 = k6Var;
        this.N0 = m6Var;
        this.O0 = u6Var;
        this.P0 = linearLayout;
        this.Q0 = frameLayout4;
        this.R0 = frameLayout5;
        this.S0 = relativeLayout2;
        this.T0 = linearLayout2;
        this.U0 = linearLayout3;
        this.V0 = linearLayout4;
        this.W0 = linearLayout5;
        this.X0 = linearLayout6;
        this.Y0 = linearLayout7;
        this.Z0 = linearLayout8;
        this.f19198a1 = linearLayout9;
        this.f19201b1 = linearLayout10;
        this.f19204c1 = linearLayout11;
        this.f19207d1 = linearLayout12;
        this.f19210e1 = linearLayout13;
        this.f19213f1 = linearLayout14;
        this.f19216g1 = linearLayout15;
        this.f19219h1 = linearLayout16;
        this.f19222i1 = linearLayout17;
        this.f19225j1 = linearLayout18;
        this.f19228k1 = linearLayout19;
        this.f19231l1 = seekBar;
        this.f19234m1 = relativeLayout3;
        this.f19237n1 = relativeLayout4;
        this.f19239o1 = relativeLayout5;
        this.f19241p1 = relativeLayout6;
        this.f19243q1 = relativeLayout7;
        this.f19245r1 = relativeLayout8;
        this.f19247s1 = relativeLayout9;
        this.f19250t1 = relativeLayout10;
        this.f19253u1 = relativeLayout11;
        this.f19256v1 = relativeLayout12;
        this.f19259w1 = relativeLayout13;
        this.f19262x1 = relativeLayout14;
        this.f19265y1 = relativeLayout15;
        this.f19268z1 = recyclerView;
        this.A1 = recyclerView2;
        this.B1 = recyclerView3;
        this.C1 = safeLottieView2;
        this.D1 = safeLottieView3;
        this.E1 = safeLottieView4;
        this.F1 = textView;
        this.G1 = textView2;
        this.H1 = textView3;
        this.I1 = textView4;
        this.J1 = textView5;
        this.K1 = textView6;
        this.L1 = textView7;
        this.M1 = textView8;
        this.N1 = textView9;
        this.O1 = textView10;
        this.P1 = textView11;
        this.Q1 = textView12;
        this.R1 = textView13;
        this.S1 = textView14;
        this.T1 = textView15;
        this.U1 = textView16;
        this.V1 = textView17;
        this.W1 = roundTextView;
        this.X1 = textView18;
        this.Y1 = roundTextView2;
        this.Z1 = textView19;
        this.f19199a2 = textView20;
        this.f19202b2 = autoMarqueeTextView;
        this.f19205c2 = autoMarqueeTextView2;
        this.f19208d2 = textView21;
        this.f19211e2 = textView22;
        this.f19214f2 = textView23;
        this.f19217g2 = textView24;
        this.f19220h2 = textView25;
        this.f19223i2 = textView26;
        this.f19226j2 = textView27;
        this.f19229k2 = imageView31;
        this.f19232l2 = relativeLayout16;
        this.f19235m2 = linearLayout20;
        this.f19238n2 = linearLayout21;
        this.f19240o2 = imageView32;
        this.f19242p2 = textView28;
        this.f19244q2 = appCompatTextView;
        this.f19246r2 = textView29;
        this.f19248s2 = textView30;
        this.f19251t2 = textView31;
        this.f19254u2 = linearLayout22;
        this.f19257v2 = textView32;
        this.f19260w2 = textView33;
        this.f19263x2 = textView34;
        this.f19266y2 = textView35;
        this.f19269z2 = textView36;
        this.A2 = textView37;
        this.B2 = textView38;
        this.C2 = tXCloudVideoView;
        this.D2 = view3;
        this.E2 = view4;
        this.F2 = linearLayout23;
        this.G2 = view5;
        this.H2 = view6;
        this.I2 = view7;
        this.J2 = view8;
        this.K2 = view9;
        this.L2 = view10;
        this.M2 = view11;
        this.N2 = view12;
        this.O2 = view13;
        this.P2 = view14;
        this.Q2 = viewPager2;
    }

    public static m K(LayoutInflater layoutInflater) {
        return L(layoutInflater, c.d());
    }

    @Deprecated
    public static m L(LayoutInflater layoutInflater, Object obj) {
        return (m) f.s(layoutInflater, R$layout.activity_live_detail, (ViewGroup) null, false, obj);
    }

    public abstract void M(LiveDetailBean liveDetailBean);

    public abstract void N(LiveGroup liveGroup);

    public abstract void O(Integer num);

    public abstract void P(LiveDetailActivity liveDetailActivity);

    public abstract void Q(LiveRedpacketBean liveRedpacketBean);

    public abstract void R(Integer num);

    public abstract void S(Integer num);

    public abstract void T(LiveSpeaker liveSpeaker);
}
