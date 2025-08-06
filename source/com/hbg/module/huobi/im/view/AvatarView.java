package com.hbg.module.huobi.im.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$raw;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$styleable;
import com.hbg.module.libkt.common.HexagonImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.android.tpush.common.Constants;
import i6.n;
import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;
import rd.s;
import u6.g;

public final class AvatarView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public HexagonImageView f20548b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20549c;

    /* renamed from: d  reason: collision with root package name */
    public int f20550d;

    /* renamed from: e  reason: collision with root package name */
    public String f20551e;

    /* renamed from: f  reason: collision with root package name */
    public String f20552f;

    /* renamed from: g  reason: collision with root package name */
    public int f20553g;

    /* renamed from: h  reason: collision with root package name */
    public a f20554h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f20555i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f20556j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f20557k;

    /* renamed from: l  reason: collision with root package name */
    public LottieAnimationView f20558l;

    /* renamed from: m  reason: collision with root package name */
    public LottieAnimationView f20559m;

    /* renamed from: n  reason: collision with root package name */
    public LottieAnimationView f20560n;

    /* renamed from: o  reason: collision with root package name */
    public ScaleAnimation f20561o;

    /* renamed from: p  reason: collision with root package name */
    public View.OnAttachStateChangeListener f20562p;

    /* renamed from: q  reason: collision with root package name */
    public ImageView f20563q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f20564r;

    /* renamed from: s  reason: collision with root package name */
    public String f20565s;

    /* renamed from: t  reason: collision with root package name */
    public String f20566t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f20567u;

    /* renamed from: v  reason: collision with root package name */
    public int f20568v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f20569w;

    public interface a {

        /* renamed from: com.hbg.module.huobi.im.view.AvatarView$a$a  reason: collision with other inner class name */
        public static final class C0156a {
            public static void a(a aVar, int i11, int i12) {
            }

            public static void b(a aVar) {
            }
        }

        void a();

        void b(int i11, int i12);
    }

    public static final class b implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AvatarView f20570b;

        public b(AvatarView avatarView) {
            this.f20570b = avatarView;
        }

        public void onViewAttachedToWindow(View view) {
            if (this.f20570b.f20568v == 1) {
                LottieAnimationView g11 = this.f20570b.f20559m;
                if (g11 != null) {
                    g11.setVisibility(0);
                }
                LottieAnimationView g12 = this.f20570b.f20559m;
                if (g12 != null) {
                    g12.setRepeatCount(-1);
                }
                LottieAnimationView g13 = this.f20570b.f20559m;
                if (g13 != null) {
                    g13.playAnimation();
                }
                if (this.f20570b.f20564r || this.f20570b.f20567u) {
                    this.f20570b.getAvatar().clearAnimation();
                    if (!sd.a.c(this.f20570b.f20566t)) {
                        LottieAnimationView h11 = this.f20570b.f20560n;
                        if (h11 != null) {
                            h11.setVisibility(0);
                        }
                        LottieAnimationView h12 = this.f20570b.f20560n;
                        if (h12 != null) {
                            h12.cancelAnimation();
                        }
                        LottieAnimationView h13 = this.f20570b.f20560n;
                        if (h13 != null) {
                            h13.setAnimationFromUrl(this.f20570b.f20566t);
                        }
                        LottieAnimationView h14 = this.f20570b.f20560n;
                        if (h14 != null) {
                            h14.setRepeatCount(-1);
                        }
                        LottieAnimationView h15 = this.f20570b.f20560n;
                        if (h15 != null) {
                            h15.playAnimation();
                            return;
                        }
                        return;
                    }
                    return;
                }
                LottieAnimationView f11 = this.f20570b.f20558l;
                if (f11 != null) {
                    f11.setVisibility(0);
                }
                LottieAnimationView f12 = this.f20570b.f20558l;
                if (f12 != null) {
                    f12.setRepeatCount(-1);
                }
                LottieAnimationView f13 = this.f20570b.f20558l;
                if (f13 != null) {
                    f13.playAnimation();
                }
                this.f20570b.getAvatar().startAnimation(this.f20570b.getScaleAnim());
                LottieAnimationView h16 = this.f20570b.f20560n;
                if (h16 != null) {
                    h16.cancelAnimation();
                }
            }
        }

        public void onViewDetachedFromWindow(View view) {
            LottieAnimationView g11 = this.f20570b.f20559m;
            if (g11 != null) {
                g11.cancelAnimation();
            }
            LottieAnimationView f11 = this.f20570b.f20558l;
            if (f11 != null) {
                f11.cancelAnimation();
            }
            LottieAnimationView h11 = this.f20570b.f20560n;
            if (h11 != null) {
                h11.cancelAnimation();
            }
            this.f20570b.getAvatar().clearAnimation();
        }
    }

    public static final class c extends BaseSubscriber<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AvatarView f20571b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f20572c;

        public c(AvatarView avatarView, int i11) {
            this.f20571b = avatarView;
            this.f20572c = i11;
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            AvatarView avatarView = this.f20571b;
            avatarView.f20550d = avatarView.f20550d == 0 ? 1 : 0;
            this.f20571b.r();
            a c11 = this.f20571b.f20554h;
            if (c11 != null) {
                c11.b(this.f20571b.f20550d, this.f20572c);
            }
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.i(((APIStatusErrorException) th2).getErrMsg());
            } else {
                HuobiToastUtil.g(R$string.n_service_error);
            }
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20573b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20574c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AvatarView f20575d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20576e;

        public d(View view, long j11, AvatarView avatarView, int i11) {
            this.f20573b = view;
            this.f20574c = j11;
            this.f20575d = avatarView;
            this.f20576e = i11;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20573b) > this.f20574c || (this.f20573b instanceof Checkable)) {
                sVar.e(this.f20573b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f20573b;
                this.f20575d.p(this.f20576e);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20577b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20578c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AvatarView f20579d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f20580e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20581f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f20582g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f20583h;

        public e(View view, long j11, AvatarView avatarView, int i11, String str, String str2, String str3) {
            this.f20577b = view;
            this.f20578c = j11;
            this.f20579d = avatarView;
            this.f20580e = i11;
            this.f20581f = str;
            this.f20582g = str2;
            this.f20583h = str3;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20577b) > this.f20578c || (this.f20577b instanceof Checkable)) {
                sVar.e(this.f20577b, currentTimeMillis);
                AvatarView avatarView = (AvatarView) this.f20577b;
                a c11 = this.f20579d.f20554h;
                if (c11 != null) {
                    c11.a();
                }
                if (this.f20580e == 1 && !sd.a.c(this.f20581f)) {
                    b2.a.d().a("/live/room").withString("liveId", this.f20581f).navigation();
                } else if (!sd.a.c(this.f20582g) || !sd.a.c(this.f20583h)) {
                    b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f20582g).withString(Constants.FLAG_ACCOUNT, this.f20583h).navigation();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f20584b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f20585c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ AvatarView f20586d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20588f;

        public f(View view, long j11, AvatarView avatarView, String str, String str2) {
            this.f20584b = view;
            this.f20585c = j11;
            this.f20586d = avatarView;
            this.f20587e = str;
            this.f20588f = str2;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f20584b) > this.f20585c || (this.f20584b instanceof Checkable)) {
                sVar.e(this.f20584b, currentTimeMillis);
                AvatarView avatarView = (AvatarView) this.f20584b;
                a c11 = this.f20586d.f20554h;
                if (c11 != null) {
                    c11.a();
                }
                b2.a.d().a("/content/PersonalCenter").withString("uidUnique", this.f20587e).withString(Constants.FLAG_ACCOUNT, this.f20588f).navigation();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public AvatarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public AvatarView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvatarView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    /* access modifiers changed from: private */
    public final ScaleAnimation getScaleAnim() {
        if (this.f20561o == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 0.5f);
            this.f20561o = scaleAnimation;
            scaleAnimation.setRepeatMode(2);
            ScaleAnimation scaleAnimation2 = this.f20561o;
            if (scaleAnimation2 != null) {
                scaleAnimation2.setRepeatCount(-1);
            }
            ScaleAnimation scaleAnimation3 = this.f20561o;
            if (scaleAnimation3 != null) {
                scaleAnimation3.setDuration(650);
            }
        }
        return this.f20561o;
    }

    public static /* synthetic */ AvatarView t(AvatarView avatarView, int i11, int i12, String str, String str2, String str3, int i13, int i14, Object obj) {
        return avatarView.s(i11, i12, str, (i14 & 8) != 0 ? null : str2, (i14 & 16) != 0 ? null : str3, (i14 & 32) != 0 ? 0 : i13);
    }

    public static /* synthetic */ AvatarView x(AvatarView avatarView, String str, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return avatarView.w(str, i11);
    }

    public final AvatarView A(boolean z11) {
        this.f20569w = z11;
        if (z11) {
            C(12);
        } else {
            ImageView imageView = this.f20563q;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
        return this;
    }

    public final void B(int i11) {
        int i12;
        if (this.f20559m == null) {
            this.f20559m = new LottieAnimationView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(sd.a.b(Float.valueOf(q(this.f20567u ? 0.4f : 0.327f, 19.0f))), sd.a.b(Float.valueOf(q(this.f20567u ? 0.28f : 0.224f, 13.0f))));
            layoutParams.getRules()[11] = -1;
            if (!this.f20567u) {
                layoutParams.setMarginEnd(sd.a.b(Float.valueOf(6.0f)));
            }
            LottieAnimationView lottieAnimationView = this.f20559m;
            if (lottieAnimationView != null) {
                lottieAnimationView.setLayoutParams(layoutParams);
            }
            addView(this.f20559m);
        }
        ViewGroup.LayoutParams layoutParams2 = null;
        if (i11 == 10) {
            LottieAnimationView lottieAnimationView2 = this.f20559m;
            ((RelativeLayout.LayoutParams) (lottieAnimationView2 != null ? lottieAnimationView2.getLayoutParams() : null)).getRules()[10] = -1;
            LottieAnimationView lottieAnimationView3 = this.f20559m;
            if (lottieAnimationView3 != null) {
                layoutParams2 = lottieAnimationView3.getLayoutParams();
            }
            ((RelativeLayout.LayoutParams) layoutParams2).getRules()[12] = 0;
        } else {
            LottieAnimationView lottieAnimationView4 = this.f20559m;
            ((RelativeLayout.LayoutParams) (lottieAnimationView4 != null ? lottieAnimationView4.getLayoutParams() : null)).getRules()[10] = 0;
            LottieAnimationView lottieAnimationView5 = this.f20559m;
            if (lottieAnimationView5 != null) {
                layoutParams2 = lottieAnimationView5.getLayoutParams();
            }
            ((RelativeLayout.LayoutParams) layoutParams2).getRules()[12] = -1;
        }
        LottieAnimationView lottieAnimationView6 = this.f20559m;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        LottieAnimationView lottieAnimationView7 = this.f20559m;
        if (lottieAnimationView7 != null) {
            lottieAnimationView7.bringToFront();
        }
        LottieAnimationView lottieAnimationView8 = this.f20559m;
        if (lottieAnimationView8 != null) {
            lottieAnimationView8.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView9 = this.f20559m;
        if (lottieAnimationView9 != null) {
            if (NightHelper.e().g()) {
                i12 = R$raw.news_live_hot_anchor_label_night;
            } else {
                i12 = R$raw.news_live_hot_anchor_label_day;
            }
            lottieAnimationView9.setAnimation(i12);
        }
        LottieAnimationView lottieAnimationView10 = this.f20559m;
        if (lottieAnimationView10 != null) {
            lottieAnimationView10.setVisibility(0);
        }
        LottieAnimationView lottieAnimationView11 = this.f20559m;
        if (lottieAnimationView11 != null) {
            lottieAnimationView11.setRepeatCount(-1);
        }
        LottieAnimationView lottieAnimationView12 = this.f20559m;
        if (lottieAnimationView12 != null) {
            lottieAnimationView12.playAnimation();
        }
    }

    public final void C(int i11) {
        if (this.f20563q == null) {
            this.f20563q = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(sd.a.b(Float.valueOf(q(this.f20567u ? 0.4f : 0.327f, 19.0f))), sd.a.b(Float.valueOf(q(this.f20567u ? 0.28f : 0.224f, 13.0f))));
            layoutParams.getRules()[11] = -1;
            if (!this.f20567u) {
                layoutParams.setMarginEnd(sd.a.b(Float.valueOf(6.0f)));
            }
            ImageView imageView = this.f20563q;
            if (imageView != null) {
                imageView.setLayoutParams(layoutParams);
            }
            addView(this.f20563q);
        }
        ViewGroup.LayoutParams layoutParams2 = null;
        if (i11 == 10) {
            ImageView imageView2 = this.f20563q;
            ((RelativeLayout.LayoutParams) (imageView2 != null ? imageView2.getLayoutParams() : null)).getRules()[10] = -1;
            ImageView imageView3 = this.f20563q;
            if (imageView3 != null) {
                layoutParams2 = imageView3.getLayoutParams();
            }
            ((RelativeLayout.LayoutParams) layoutParams2).getRules()[12] = 0;
        } else {
            ImageView imageView4 = this.f20563q;
            ((RelativeLayout.LayoutParams) (imageView4 != null ? imageView4.getLayoutParams() : null)).getRules()[10] = 0;
            ImageView imageView5 = this.f20563q;
            if (imageView5 != null) {
                layoutParams2 = imageView5.getLayoutParams();
            }
            ((RelativeLayout.LayoutParams) layoutParams2).getRules()[12] = -1;
        }
        ImageView imageView6 = this.f20563q;
        if (imageView6 != null) {
            imageView6.setImageResource(R$drawable.account_user_v_tag);
        }
        ImageView imageView7 = this.f20563q;
        if (imageView7 != null) {
            imageView7.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        ImageView imageView8 = this.f20563q;
        if (imageView8 != null) {
            imageView8.setVisibility(0);
        }
    }

    public final HexagonImageView getAvatar() {
        HexagonImageView hexagonImageView = this.f20548b;
        if (hexagonImageView != null) {
            return hexagonImageView;
        }
        return null;
    }

    public final void n() {
        b bVar = new b(this);
        this.f20562p = bVar;
        addOnAttachStateChangeListener(bVar);
    }

    public final AvatarView o(int i11, float f11) {
        if (this.f20568v != 1 && !this.f20564r) {
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n.a(getContext(), f11), n.a(getContext(), f11));
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (i11 == 1) {
                imageView.setImageResource(R$drawable.icon_speaker);
            } else if (i11 == 8) {
                imageView.setImageResource(R$drawable.icon_manager_tag_big);
            }
            addView(imageView);
        }
        return this;
    }

    public final void p(int i11) {
        if (BaseModuleConfig.a().m0((Activity) getContext())) {
            IHbgApi a11 = v7.b.a();
            Pair[] pairArr = new Pair[2];
            pairArr[0] = l.a("type", Integer.valueOf(this.f20550d == 0 ? 1 : 0));
            pairArr[1] = l.a("uidUnique", this.f20551e);
            a11.requestCommunityAttention(MapsKt__MapsKt.l(pairArr)).b().compose(RxJavaHelper.t((g) null)).subscribe(new c(this, i11));
        }
    }

    public final float q(float f11, float f12) {
        int i11 = this.f20553g;
        return i11 > 0 ? ((float) i11) * f11 : f12;
    }

    public final void r() {
        if (this.f20550d == 1) {
            ImageView imageView = this.f20556j;
            if (imageView != null) {
                imageView.setImageResource(R$drawable.icon_attention_already);
            }
            TextView textView = this.f20557k;
            if (textView != null) {
                textView.setTextColor(getContext().getResources().getColor(R$color.baseColorPrimaryText));
            }
            LinearLayout linearLayout = this.f20555i;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R$drawable.bg_speaker_attentioned);
                return;
            }
            return;
        }
        ImageView imageView2 = this.f20556j;
        if (imageView2 != null) {
            imageView2.setImageResource(R$drawable.icon_attention_add);
        }
        TextView textView2 = this.f20557k;
        if (textView2 != null) {
            textView2.setTextColor(getContext().getResources().getColor(R$color.baseColorMajorTheme100));
        }
        LinearLayout linearLayout2 = this.f20555i;
        if (linearLayout2 != null) {
            linearLayout2.setBackgroundResource(R$drawable.bg_speaker_attention);
        }
    }

    public final AvatarView s(int i11, int i12, String str, String str2, String str3, int i13) {
        int i14 = i11;
        int i15 = i12;
        this.f20568v = i14;
        this.f20550d = i15;
        this.f20551e = str;
        this.f20552f = str2;
        getAvatar().clearAnimation();
        LottieAnimationView lottieAnimationView = this.f20558l;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        LottieAnimationView lottieAnimationView2 = this.f20559m;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
        if (this.f20567u) {
            ((RelativeLayout.LayoutParams) getAvatar().getLayoutParams()).setMargins(0, 0, 0, 0);
        } else {
            int b11 = sd.a.b(Float.valueOf(q(0.137f, 8.0f)));
            ((RelativeLayout.LayoutParams) getAvatar().getLayoutParams()).setMargins(b11, b11, b11, b11);
        }
        if (this.f20564r) {
            getAvatar().f(MathKt__MathJVMKt.b(q(0.928f, (float) this.f20553g)), 0, this.f20565s, true);
            LottieAnimationView lottieAnimationView3 = this.f20560n;
            if (lottieAnimationView3 != null) {
                lottieAnimationView3.clearAnimation();
            }
            LottieAnimationView lottieAnimationView4 = this.f20560n;
            if (lottieAnimationView4 != null) {
                lottieAnimationView4.setVisibility(8);
            }
            if (i14 == 1) {
                B(12);
            }
        } else {
            this.f20549c = true;
            LottieAnimationView lottieAnimationView5 = this.f20560n;
            if (lottieAnimationView5 != null) {
                lottieAnimationView5.setVisibility(8);
            }
            if (i14 == 1) {
                if (this.f20558l == null && !this.f20567u) {
                    LottieAnimationView lottieAnimationView6 = new LottieAnimationView(getContext());
                    this.f20558l = lottieAnimationView6;
                    addView(lottieAnimationView6, 1);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    int b12 = sd.a.b(Float.valueOf(q(0.034f, 2.0f)));
                    layoutParams.setMargins(b12, b12, b12, b12);
                    layoutParams.getRules()[13] = -1;
                    LottieAnimationView lottieAnimationView7 = this.f20558l;
                    if (lottieAnimationView7 != null) {
                        lottieAnimationView7.setLayoutParams(layoutParams);
                    }
                    LottieAnimationView lottieAnimationView8 = this.f20558l;
                    if (lottieAnimationView8 != null) {
                        lottieAnimationView8.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                    LottieAnimationView lottieAnimationView9 = this.f20558l;
                    if (lottieAnimationView9 != null) {
                        lottieAnimationView9.setAnimation(R$raw.news_live_hot_anchor_bg);
                    }
                }
                B(this.f20567u ? 12 : 10);
                LottieAnimationView lottieAnimationView10 = this.f20558l;
                if (lottieAnimationView10 != null) {
                    lottieAnimationView10.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView11 = this.f20558l;
                if (lottieAnimationView11 != null) {
                    lottieAnimationView11.setRepeatCount(-1);
                }
                LottieAnimationView lottieAnimationView12 = this.f20558l;
                if (lottieAnimationView12 != null) {
                    lottieAnimationView12.playAnimation();
                }
                if (!this.f20567u) {
                    getAvatar().startAnimation(getScaleAnim());
                }
            }
            HexagonImageView.g(getAvatar(), 0, 0, this.f20565s, false, 8, (Object) null);
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f20562p;
        if (onAttachStateChangeListener != null) {
            removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
        if (i15 >= 0 && this.f20555i == null) {
            this.f20555i = new LinearLayout(getContext());
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, sd.a.b(Float.valueOf(16.0f)));
            layoutParams2.getRules()[12] = -1;
            layoutParams2.getRules()[14] = -1;
            LinearLayout linearLayout = this.f20555i;
            if (linearLayout != null) {
                linearLayout.setLayoutParams(layoutParams2);
            }
            LinearLayout linearLayout2 = this.f20555i;
            if (linearLayout2 != null) {
                linearLayout2.setGravity(17);
            }
            LinearLayout linearLayout3 = this.f20555i;
            if (linearLayout3 != null) {
                linearLayout3.setPadding(sd.a.b(Float.valueOf(4.0f)), 0, sd.a.b(Float.valueOf(4.0f)), 0);
            }
            ImageView imageView = new ImageView(getContext());
            this.f20556j = imageView;
            imageView.setLayoutParams(new LinearLayout.LayoutParams(sd.a.b(Float.valueOf(10.0f)), sd.a.b(Float.valueOf(10.0f))));
            ImageView imageView2 = this.f20556j;
            if (imageView2 != null) {
                imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            TextView textView = new TextView(getContext());
            this.f20557k = textView;
            textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            TextView textView2 = this.f20557k;
            if (textView2 != null) {
                textView2.setText(getContext().getResources().getString(R$string.n_content_communityList_attention));
            }
            TextView textView3 = this.f20557k;
            if (textView3 != null) {
                textView3.setSingleLine(true);
            }
            TextView textView4 = this.f20557k;
            if (textView4 != null) {
                textView4.setEllipsize(TextUtils.TruncateAt.END);
            }
            TextView textView5 = this.f20557k;
            if (textView5 != null) {
                textView5.setTextSize(10.0f);
            }
            LinearLayout linearLayout4 = this.f20555i;
            if (linearLayout4 != null) {
                linearLayout4.addView(this.f20556j);
            }
            LinearLayout linearLayout5 = this.f20555i;
            if (linearLayout5 != null) {
                linearLayout5.addView(this.f20557k);
            }
            addView(this.f20555i);
            LinearLayout linearLayout6 = this.f20555i;
            if (linearLayout6 != null) {
                s sVar = s.f23381a;
                linearLayout6.setOnClickListener(new d(linearLayout6, 800, this, i13));
            }
        }
        r();
        s sVar2 = s.f23381a;
        setOnClickListener(new e(this, 800, this, i11, str3, str, str2));
        return this;
    }

    public final void setAvatar(HexagonImageView hexagonImageView) {
        this.f20548b = hexagonImageView;
    }

    public final void setAvatarClickListener(a aVar) {
        this.f20554h = aVar;
    }

    @Keep
    public final void setImageDrawable(Drawable drawable) {
        getAvatar().setImageDrawable(drawable);
    }

    public final AvatarView u(String str, boolean z11, String str2) {
        this.f20567u = true;
        this.f20564r = z11;
        this.f20565s = str;
        this.f20566t = str2;
        return this;
    }

    public final void v(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.AvatarView);
        obtainStyledAttributes.getInteger(R$styleable.AvatarView_avatarType, 0);
        this.f20551e = obtainStyledAttributes.getString(R$styleable.AvatarView_uidUnique);
        this.f20552f = obtainStyledAttributes.getString(R$styleable.AvatarView_account);
        this.f20553g = obtainStyledAttributes.getInteger(R$styleable.AvatarView_viewSize, 0);
        setAvatar(new HexagonImageView(getContext(), (AttributeSet) null, 0, 6, (r) null));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.getRules()[13] = -1;
        getAvatar().setLayoutParams(layoutParams);
        getAvatar().setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(getAvatar());
        n();
    }

    public final AvatarView w(String str, int i11) {
        if (this.f20548b != null) {
            HexagonImageView.g(getAvatar(), 0, -1, str, false, 8, (Object) null);
        }
        return this;
    }

    public final void y(int i11, int i12) {
        this.f20564r = false;
        this.f20565s = null;
        this.f20566t = null;
        this.f20568v = i12;
        if (this.f20548b != null) {
            HexagonImageView.g(getAvatar(), 0, -1, (String) null, false, 8, (Object) null);
            getAvatar().setImageResource(i11);
        }
        if (i12 == 1) {
            B(12);
            return;
        }
        LottieAnimationView lottieAnimationView = this.f20559m;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.f20559m;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
    }

    public final AvatarView z(String str, String str2) {
        this.f20564r = false;
        this.f20565s = null;
        this.f20566t = null;
        this.f20568v = 0;
        LottieAnimationView lottieAnimationView = this.f20560n;
        if (lottieAnimationView != null) {
            lottieAnimationView.clearAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.f20560n;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setVisibility(8);
        }
        if (!sd.a.c(str) || !sd.a.c(str2)) {
            s sVar = s.f23381a;
            setOnClickListener(new f(this, 800, this, str, str2));
        }
        return this;
    }

    public AvatarView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f20550d = -1;
        v(attributeSet);
    }
}
