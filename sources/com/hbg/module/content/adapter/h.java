package com.hbg.module.content.adapter;

import android.animation.Animator;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveSpeaker;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$anim;
import com.hbg.module.content.R$drawable;
import com.hbg.module.content.R$raw;
import com.hbg.module.content.R$string;
import com.hbg.module.content.helper.live.HbgLiveHelper;
import com.hbg.module.content.helper.live.f;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.libkt.utils.event.bean.Financial;
import com.hbg.module.libkt.utils.event.bean.GiftBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.twitter.sdk.android.core.internal.VineCardUtils;
import he.c;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.d0;
import kotlin.l;
import lc.i4;
import rd.s;

public final class h extends he.c<GiftBean, c.a<i4>> {

    /* renamed from: f  reason: collision with root package name */
    public Financial f17853f;

    /* renamed from: g  reason: collision with root package name */
    public final String f17854g = "live_detail_never_show";

    /* renamed from: h  reason: collision with root package name */
    public int f17855h;

    /* renamed from: i  reason: collision with root package name */
    public int f17856i = 1;

    /* renamed from: j  reason: collision with root package name */
    public Animation f17857j;

    /* renamed from: k  reason: collision with root package name */
    public Animation f17858k;

    /* renamed from: l  reason: collision with root package name */
    public Animation f17859l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f17860m;

    public static final class a implements com.hbg.module.content.helper.live.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h f17861a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ i4 f17862b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ GiftBean f17863c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f17864d;

        public a(h hVar, i4 i4Var, GiftBean giftBean, int i11) {
            this.f17861a = hVar;
            this.f17862b = i4Var;
            this.f17863c = giftBean;
            this.f17864d = i11;
        }

        public void a() {
            this.f17861a.v(this.f17862b, this.f17863c, this.f17864d);
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17865b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17866c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f17867d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f17868e;

        public b(View view, long j11, h hVar, int i11) {
            this.f17865b = view;
            this.f17866c = j11;
            this.f17867d = hVar;
            this.f17868e = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            List<LiveSpeaker> list;
            LiveSpeaker liveSpeaker;
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17865b) > this.f17866c || (this.f17865b instanceof Checkable)) {
                sVar.e(this.f17865b, currentTimeMillis);
                RelativeLayout relativeLayout = (RelativeLayout) this.f17865b;
                if (this.f17867d.f17855h != this.f17868e) {
                    Pair[] pairArr = new Pair[5];
                    HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
                    LiveDetailBean n11 = hbgLiveHelper.n();
                    String str = null;
                    pairArr[0] = l.a("state", n11 != null ? Integer.valueOf(n11.status) : null);
                    LiveDetailBean n12 = hbgLiveHelper.n();
                    pairArr[1] = l.a("liveId", n12 != null ? n12.f70249id : null);
                    pairArr[2] = l.a(VineCardUtils.PLAYER_CARD, 1);
                    LiveDetailBean n13 = hbgLiveHelper.n();
                    pairArr[3] = l.a("title", n13 != null ? n13.title : null);
                    LiveDetailBean n14 = hbgLiveHelper.n();
                    if (com.hbg.module.libkt.base.ext.b.w(n14 != null ? n14.speakerList : null)) {
                        str = "";
                    } else {
                        LiveDetailBean n15 = hbgLiveHelper.n();
                        if (!(n15 == null || (list = n15.speakerList) == null || (liveSpeaker = list.get(0)) == null)) {
                            str = liveSpeaker.showId;
                        }
                    }
                    pairArr[4] = l.a("upid", str);
                    nc.c.a("APP_LIVE_reward_panelclk", MapsKt__MapsKt.j(pairArr));
                    int l11 = this.f17867d.f17855h;
                    this.f17867d.f17855h = this.f17868e;
                    this.f17867d.x(1);
                    this.f17867d.notifyItemChanged(l11);
                    this.f17867d.notifyItemChanged(this.f17868e);
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17869b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17870c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f17871d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a f17872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftBean f17873f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17874g;

        public c(View view, long j11, h hVar, c.a aVar, GiftBean giftBean, int i11) {
            this.f17869b = view;
            this.f17870c = j11;
            this.f17871d = hVar;
            this.f17872e = aVar;
            this.f17873f = giftBean;
            this.f17874g = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17869b) > this.f17870c || (this.f17869b instanceof Checkable)) {
                sVar.e(this.f17869b, currentTimeMillis);
                TextView textView = (TextView) this.f17869b;
                this.f17871d.o((i4) this.f17872e.e(), this.f17873f, this.f17874g);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17875b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f17876c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f17877d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a f17878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GiftBean f17879f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f17880g;

        public d(View view, long j11, h hVar, c.a aVar, GiftBean giftBean, int i11) {
            this.f17875b = view;
            this.f17876c = j11;
            this.f17877d = hVar;
            this.f17878e = aVar;
            this.f17879f = giftBean;
            this.f17880g = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f17875b) > this.f17876c || (this.f17875b instanceof Checkable)) {
                sVar.e(this.f17875b, currentTimeMillis);
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f17875b;
                this.f17877d.o((i4) this.f17878e.e(), this.f17879f, this.f17880g);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f17881b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17882c;

        public e(h hVar, int i11) {
            this.f17881b = hVar;
            this.f17882c = i11;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f17881b.x(1);
            this.f17881b.notifyItemChanged(this.f17882c);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public h(FragmentActivity fragmentActivity, Financial financial) {
        super(fragmentActivity);
        this.f17853f = financial;
        this.f17857j = AnimationUtils.loadAnimation(fragmentActivity, R$anim.live_gift_scale);
        this.f17858k = AnimationUtils.loadAnimation(fragmentActivity, R$anim.gift_combo_scale);
        this.f17859l = AnimationUtils.loadAnimation(fragmentActivity, R$anim.gift_combo_num_anim);
        this.f17860m = true;
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public final void o(i4 i4Var, GiftBean giftBean, int i11) {
        if (giftBean.getLabel() <= 1) {
            v(i4Var, giftBean, i11);
        } else if (SPUtil.g(this.f17854g, false)) {
            v(i4Var, giftBean, i11);
        } else {
            f.f18246a.g(new a(this, i4Var, giftBean, i11));
            we.c.D();
        }
    }

    public final int p(int i11) {
        switch (i11) {
            case 0:
                return R$drawable.icon_live_0;
            case 1:
                return R$drawable.icon_live_1;
            case 2:
                return R$drawable.icon_live_2;
            case 3:
                return R$drawable.icon_live_3;
            case 4:
                return R$drawable.icon_live_4;
            case 5:
                return R$drawable.icon_live_5;
            case 6:
                return R$drawable.icon_live_6;
            case 7:
                return R$drawable.icon_live_7;
            case 8:
                return R$drawable.icon_live_8;
            default:
                return R$drawable.icon_live_9;
        }
    }

    public final void q(i4 i4Var, int i11) {
        ViewGroup.LayoutParams layoutParams = i4Var.H.getLayoutParams();
        if (layoutParams != null) {
            if (i11 < 3) {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = com.hbg.module.libkt.base.ext.c.d(Float.valueOf(10.0f));
            } else {
                ((RelativeLayout.LayoutParams) layoutParams).topMargin = 0;
            }
            int c11 = (int) (((float) ((com.hbg.module.libkt.base.ext.c.c() - com.hbg.module.libkt.base.ext.c.d(Float.valueOf(32.0f))) - com.hbg.module.libkt.base.ext.c.d(Float.valueOf(20.0f)))) / 3.0f);
            layoutParams.width = c11;
            layoutParams.height = (int) (((float) c11) * 1.018868f);
            ViewGroup.LayoutParams layoutParams2 = i4Var.I.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = (int) (((float) layoutParams.width) * 0.8f);
                layoutParams2.height = (int) (((float) layoutParams.height) * 0.8f);
            }
            ViewGroup.LayoutParams layoutParams3 = i4Var.D.getLayoutParams();
            if (layoutParams3 != null) {
                int i12 = layoutParams.height;
                layoutParams3.width = (int) (((float) i12) * 0.8f * 0.6f);
                layoutParams3.height = (int) (((float) i12) * 0.8f * 0.6f);
            }
            ViewGroup.LayoutParams layoutParams4 = i4Var.N.getLayoutParams();
            if (layoutParams4 != null) {
                layoutParams4.height = (int) (((float) layoutParams.height) * 0.8f * 0.245f);
            }
        }
    }

    public final void r() {
        this.f17860m = false;
        notifyDataSetChanged();
    }

    /* renamed from: s */
    public void onBindViewHolder(c.a<i4> aVar, int i11) {
        int i12;
        String str;
        String str2;
        String str3;
        super.onBindViewHolder(aVar, i11);
        GiftBean giftBean = (GiftBean) g().get(i11);
        q(aVar.e(), i11);
        aVar.e().M(giftBean);
        aVar.e().F.removeAllAnimatorListeners();
        aVar.e().F.cancelAnimation();
        int i13 = 0;
        if (giftBean.getLabel() == 1) {
            aVar.e().O.setBackgroundResource(R$drawable.bg_integral_free_tips);
            aVar.e().O.setText(f().getResources().getString(R$string.n_live_free));
            aVar.e().O.setVisibility(0);
            TextView textView = aVar.e().M;
            f fVar = f.f18246a;
            if (fVar.c() >= giftBean.getUnlockIntegral()) {
                giftBean.setLeftIntegral(0);
                d0 d0Var = d0.f56774a;
                str = String.format(f().getResources().getString(R$string.n_live_x_coin_hot), Arrays.copyOf(new Object[]{String.valueOf(giftBean.getUnlockIntegral())}, 1));
            } else {
                if (fVar.c() >= 0) {
                    giftBean.setLeftIntegral(giftBean.getUnlockIntegral() - fVar.c());
                }
                d0 d0Var2 = d0.f56774a;
                String string = f().getResources().getString(R$string.n_live_x_coin_hot);
                Object[] objArr = new Object[1];
                if (fVar.c() == -1) {
                    fVar.i(giftBean.getUnlockIntegral() - giftBean.getLeftIntegral());
                    str3 = String.valueOf(giftBean.getUnlockIntegral());
                } else {
                    str3 = String.valueOf(giftBean.getUnlockIntegral());
                }
                objArr[0] = str3;
                str = String.format(string, Arrays.copyOf(objArr, 1));
            }
            textView.setText(str);
            if (fVar.c() > giftBean.getUnlockIntegral()) {
                int c11 = giftBean.getUnlockIntegral() > 0 ? fVar.c() / giftBean.getUnlockIntegral() : Integer.MAX_VALUE;
                if (c11 > 99) {
                    str2 = "x 99+";
                } else {
                    str2 = "x " + c11;
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                spannableStringBuilder.setSpan(new ke.b(6.0f), 0, 2, 33);
                aVar.e().J.setText(spannableStringBuilder);
                aVar.e().J.setVisibility(0);
            } else {
                aVar.e().J.setVisibility(8);
            }
        } else {
            aVar.e().J.setVisibility(8);
            TextView textView2 = aVar.e().O;
            if (giftBean.getLabel() == 2) {
                i12 = 8;
            } else {
                aVar.e().O.setBackgroundResource(R$drawable.bg_large_gift_tips);
                aVar.e().O.setText(f().getResources().getString(R$string.n_live_animation));
                i12 = 0;
            }
            textView2.setVisibility(i12);
            String plainString = new BigDecimal(giftBean.getAmount()).stripTrailingZeros().toPlainString();
            TextView textView3 = aVar.e().M;
            d0 d0Var3 = d0.f56774a;
            textView3.setText(String.format("%s%s", Arrays.copyOf(new Object[]{plainString, giftBean.getCurrency().toUpperCase(Locale.getDefault())}, 2)));
        }
        aVar.e().L.setText(aVar.e().M.getText());
        aVar.e().D.setVisibility(0);
        aVar.e().F.clearAnimation();
        aVar.e().E.clearAnimation();
        aVar.e().F.setVisibility(8);
        aVar.e().E.setVisibility(8);
        aVar.e().G.setVisibility(8);
        RelativeLayout relativeLayout = aVar.e().I;
        if (this.f17855h == i11) {
            if (this.f17860m) {
                aVar.e().I.startAnimation(this.f17857j);
            } else {
                this.f17860m = true;
            }
            we.c.t(giftBean);
            aVar.e().K.setVisibility(8);
            aVar.e().M.setVisibility(8);
            aVar.e().L.setVisibility(0);
            aVar.e().N.setVisibility(0);
            i13 = R$drawable.bg_gift_panel;
        } else {
            aVar.e().I.clearAnimation();
            aVar.e().K.setVisibility(0);
            aVar.e().M.setVisibility(0);
            aVar.e().L.setVisibility(8);
            aVar.e().N.setVisibility(8);
        }
        relativeLayout.setBackgroundResource(i13);
        s sVar = s.f23381a;
        RelativeLayout relativeLayout2 = aVar.e().I;
        relativeLayout2.setOnClickListener(new b(relativeLayout2, 800, this, i11));
        TextView textView4 = aVar.e().N;
        c.a<i4> aVar2 = aVar;
        GiftBean giftBean2 = giftBean;
        int i14 = i11;
        textView4.setOnClickListener(new c(textView4, 800, this, aVar2, giftBean2, i14));
        LottieAnimationView lottieAnimationView = aVar.e().F;
        lottieAnimationView.setOnClickListener(new d(lottieAnimationView, 800, this, aVar2, giftBean2, i14));
    }

    /* renamed from: t */
    public c.a<i4> onCreateViewHolder(ViewGroup viewGroup, int i11) {
        this.f17857j.setFillAfter(true);
        this.f17858k.setFillAfter(true);
        this.f17859l.setFillAfter(true);
        return new c.a<>(i4.K(h(), viewGroup, false));
    }

    public final void u(i4 i4Var, GiftBean giftBean, int i11) {
        w(i4Var);
        giftBean.setCombo(this.f17856i - 1);
        int[] iArr = new int[2];
        i4Var.E.getLocationOnScreen(iArr);
        we.c.C(giftBean, 0, 0, iArr, 6, (Object) null);
        i4Var.F.removeAllAnimatorListeners();
        i4Var.F.cancelAnimation();
        i4Var.F.clearAnimation();
        i4Var.E.clearAnimation();
        if (giftBean.getLabel() == 3) {
            this.f17856i = 1;
            notifyItemChanged(i11);
            return;
        }
        i4Var.F.startAnimation(this.f17858k);
        i4Var.E.startAnimation(this.f17858k);
        i4Var.F.setVisibility(0);
        i4Var.E.setVisibility(0);
        i4Var.F.setAnimation(R$raw.huobi_live_gift_batter_bg_blue);
        i4Var.F.addAnimatorListener(new e(this, i11));
        i4Var.F.playAnimation();
    }

    public final void v(i4 i4Var, GiftBean giftBean, int i11) {
        int i12;
        f fVar = f.f18246a;
        if (fVar.b() == 0) {
            i12 = 1;
        } else {
            i12 = fVar.b();
        }
        if (giftBean.getLabel() > 1) {
            Financial financial = this.f17853f;
            if ((financial != null ? financial.getBalance() : 0.0d) < Double.parseDouble(giftBean.getAmount()) * ((double) i12)) {
                we.c.r();
                return;
            }
        } else if (giftBean.getLeftIntegral() > 0 || fVar.c() < giftBean.getUnlockIntegral() * i12) {
            FragmentActivity d11 = d();
            LiveDetailActivity liveDetailActivity = d11 instanceof LiveDetailActivity ? (LiveDetailActivity) d11 : null;
            if (liveDetailActivity != null) {
                liveDetailActivity.jl();
            }
            HuobiToastUtil.i(f().getResources().getString(R$string.n_live_gift_coin_insufficient));
            notifyDataSetChanged();
            return;
        }
        if (giftBean.getLabel() == 1) {
            fVar.i(fVar.c() - (giftBean.getUnlockIntegral() * i12));
            if (fVar.c() < giftBean.getUnlockIntegral()) {
                giftBean.setLeftIntegral(giftBean.getUnlockIntegral() - fVar.c());
            }
        } else {
            Financial financial2 = this.f17853f;
            financial2.setBalance(financial2.getBalance() - Double.parseDouble(giftBean.getAmount()));
        }
        u(i4Var, giftBean, i11);
    }

    public final void w(i4 i4Var) {
        i4Var.I.setBackgroundResource(0);
        i4Var.D.setVisibility(8);
        i4Var.L.setVisibility(8);
        i4Var.K.setVisibility(8);
        i4Var.O.setVisibility(8);
        i4Var.N.setVisibility(8);
        i4Var.M.setText(f().getResources().getString(R$string.n_live_gift_tap));
        i4Var.M.setVisibility(0);
        i4Var.G.clearAnimation();
        i4Var.G.startAnimation(this.f17859l);
        i4Var.G.setVisibility(0);
        int i11 = this.f17856i;
        if (i11 < 10) {
            i4Var.C.setVisibility(8);
            i4Var.B.setImageResource(p(this.f17856i));
        } else if (i11 < 100) {
            i4Var.B.setImageResource(p(i11 / 10));
            i4Var.C.setImageResource(p(this.f17856i % 10));
            i4Var.C.setVisibility(0);
        }
        this.f17856i++;
    }

    public final void x(int i11) {
        this.f17856i = i11;
    }
}
