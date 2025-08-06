package com.hbg.module.huobi.im.gift.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.group.ui.active.RewardsAnim;
import com.tencent.imsdk.v2.V2TIMManager;
import java.util.ArrayList;
import kotlin.jvm.internal.r;

public final class LiveGiftShowView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final String f19825b;

    /* renamed from: c  reason: collision with root package name */
    public View f19826c;

    /* renamed from: d  reason: collision with root package name */
    public SafeLottieView f19827d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f19828e;

    /* renamed from: f  reason: collision with root package name */
    public ConstraintLayout f19829f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19830g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19831h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19832i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f19833j;

    /* renamed from: k  reason: collision with root package name */
    public LinearLayout f19834k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f19835l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f19836m;

    /* renamed from: n  reason: collision with root package name */
    public int f19837n;

    /* renamed from: o  reason: collision with root package name */
    public Handler f19838o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f19839p;

    /* renamed from: q  reason: collision with root package name */
    public String f19840q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f19841r;

    /* renamed from: s  reason: collision with root package name */
    public Runnable f19842s;

    public static final class a extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f19843b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LiveGiftShowView f19844c;

        public a(boolean z11, LiveGiftShowView liveGiftShowView) {
            this.f19843b = z11;
            this.f19844c = liveGiftShowView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f19843b) {
                this.f19844c.h(0);
                return;
            }
            SafeLottieView d11 = this.f19844c.f19827d;
            if (d11 != null) {
                d11.playAnimation();
            }
            this.f19844c.h(1000);
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveGiftShowView f19845b;

        public b(LiveGiftShowView liveGiftShowView) {
            this.f19845b = liveGiftShowView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f19845b.setVisibility(4);
            this.f19845b.f19841r = false;
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveGiftShowView f19846b;

        public c(LiveGiftShowView liveGiftShowView) {
            this.f19846b = liveGiftShowView;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.f19846b.g(false);
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f19846b.setVisibility(0);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveGiftShowView(Context context, AttributeSet attributeSet, int i11, r rVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public static final void f(LiveGiftShowView liveGiftShowView) {
        liveGiftShowView.i();
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void g(boolean z11) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f19835l, "scaleX", new float[]{1.0f, 1.5f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f19835l, "scaleY", new float[]{1.0f, 1.5f});
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(30);
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        ofFloat2.setDuration(30);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f19836m, "scaleX", new float[]{1.0f, 1.5f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f19836m, "scaleY", new float[]{1.0f, 1.5f});
        ofFloat3.setInterpolator(new AccelerateInterpolator());
        ofFloat3.setDuration(30);
        ofFloat4.setInterpolator(new AccelerateInterpolator());
        ofFloat4.setDuration(30);
        arrayList.add(ofFloat3);
        arrayList.add(ofFloat4);
        ArrayList arrayList2 = new ArrayList();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f19835l, "scaleX", new float[]{1.5f, 1.0f});
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f19835l, "scaleY", new float[]{1.5f, 1.0f});
        ofFloat5.setInterpolator(new DecelerateInterpolator());
        ofFloat5.setDuration(130);
        ofFloat5.setStartDelay(30);
        ofFloat6.setInterpolator(new DecelerateInterpolator());
        ofFloat6.setDuration(130);
        ofFloat6.setStartDelay(30);
        arrayList2.add(ofFloat5);
        arrayList2.add(ofFloat6);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f19836m, "scaleX", new float[]{1.5f, 1.0f});
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f19836m, "scaleY", new float[]{1.5f, 1.0f});
        ofFloat7.setInterpolator(new DecelerateInterpolator());
        ofFloat7.setDuration(130);
        ofFloat7.setStartDelay(30);
        ofFloat8.setInterpolator(new DecelerateInterpolator());
        ofFloat8.setDuration(130);
        ofFloat8.setStartDelay(30);
        arrayList2.add(ofFloat7);
        arrayList2.add(ofFloat8);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.playTogether(arrayList2);
        animatorSet.addListener(new a(z11, this));
        animatorSet.start();
    }

    public final void h(long j11) {
        Handler handler = this.f19838o;
        if (handler != null) {
            handler.postDelayed(this.f19842s, ((long) 2000) + j11);
        }
    }

    @SuppressLint({"ObjectAnimatorBinding", "Recycle"})
    public final void i() {
        if (getVisibility() != 4) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(260);
            ofFloat.addListener(new b(this));
            ofFloat.start();
        }
    }

    public final boolean j(String str, ArrayList<String> arrayList) {
        if (StringsKt__StringsJVMKt.x(this.f19840q, str, false, 2, (Object) null)) {
            return (arrayList == null || arrayList.contains(V2TIMManager.getInstance().getLoginUser())) && getVisibility() == 0;
        }
        return false;
    }

    public final boolean k() {
        return getVisibility() == 0 || this.f19841r;
    }

    @SuppressLint({"ObjectAnimatorBinding"})
    public final void l(RewardsAnim rewardsAnim) {
        m(rewardsAnim, 0);
    }

    @SuppressLint({"ObjectAnimatorBinding", "SetTextI18n"})
    public final void m(RewardsAnim rewardsAnim, long j11) {
        View view;
        ViewGroup.LayoutParams layoutParams;
        if (rewardsAnim != null && (view = this.f19826c) != null) {
            Drawable drawable = null;
            if ((view != null ? view.getContext() : null) instanceof Activity) {
                View view2 = this.f19826c;
                if (((Activity) (view2 != null ? view2.getContext() : null)).isDestroyed()) {
                    return;
                }
            }
            Log.d(this.f19825b, "giftBean:" + rewardsAnim);
            this.f19839p = false;
            Handler handler = this.f19838o;
            if (handler != null) {
                handler.removeCallbacks(this.f19842s);
            }
            if (this.f19837n == 0) {
                FrameLayout frameLayout = this.f19828e;
                this.f19837n = ((frameLayout == null || (layoutParams = frameLayout.getLayoutParams()) == null) ? null : Integer.valueOf(layoutParams.width)).intValue();
                FrameLayout frameLayout2 = this.f19828e;
                this.f19837n += ((FrameLayout.LayoutParams) (frameLayout2 != null ? frameLayout2.getLayoutParams() : null)).leftMargin;
            }
            this.f19840q = rewardsAnim.getGiftId();
            String avatar = rewardsAnim.getAvatar();
            String nickname = rewardsAnim.getNickname();
            String giftName = rewardsAnim.getGiftName();
            String pngUrl = rewardsAnim.getPngUrl();
            int giftNum = rewardsAnim.getGiftNum();
            f6.c.a().j(this.f19830g, avatar, R$drawable.icon_live_default_user_avator);
            ConstraintLayout constraintLayout = this.f19829f;
            if (constraintLayout != null) {
                drawable = constraintLayout.getBackground();
            }
            if (drawable != null) {
                drawable.setAlpha(59);
            }
            TextView textView = this.f19831h;
            if (textView != null) {
                textView.setText(nickname);
            }
            TextView textView2 = this.f19832i;
            if (textView2 != null) {
                textView2.setText(getResources().getText(R$string.n_live_gift_send) + giftName);
            }
            f6.c.a().e(this.f19833j, pngUrl);
            TextView textView3 = this.f19836m;
            if (textView3 != null) {
                textView3.setText(String.valueOf(giftNum));
            }
            setAlpha(1.0f);
            if (!k()) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationX", new float[]{-((float) this.f19837n), 0.0f});
                ofFloat.setInterpolator(new FastOutSlowInInterpolator());
                ofFloat.setDuration(260);
                ofFloat.setStartDelay(j11);
                if (j11 > 0) {
                    this.f19841r = true;
                }
                ofFloat.addListener(new c(this));
                ofFloat.start();
                return;
            }
            g(true);
        }
    }

    /* JADX WARNING: type inference failed for: r2v24, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LiveGiftShowView(android.content.Context r2, android.util.AttributeSet r3) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            java.lang.String r3 = "LiveGiftShowView"
            r1.f19825b = r3
            java.lang.String r3 = ""
            r1.f19840q = r3
            id.u r3 = new id.u
            r3.<init>(r1)
            r1.f19842s = r3
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            int r3 = com.hbg.module.huobi.im.R$layout.im_live_gift_show_view
            r0 = 0
            android.view.View r2 = r2.inflate(r3, r1, r0)
            r1.f19826c = r2
            r3 = 0
            if (r2 == 0) goto L_0x002b
            int r0 = com.hbg.module.huobi.im.R$id.lottie_brushed
            android.view.View r2 = r2.findViewById(r0)
            com.hbg.lib.widgets.SafeLottieView r2 = (com.hbg.lib.widgets.SafeLottieView) r2
            goto L_0x002c
        L_0x002b:
            r2 = r3
        L_0x002c:
            r1.f19827d = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x003b
            int r0 = com.hbg.module.huobi.im.R$id.rootView
            android.view.View r2 = r2.findViewById(r0)
            android.widget.FrameLayout r2 = (android.widget.FrameLayout) r2
            goto L_0x003c
        L_0x003b:
            r2 = r3
        L_0x003c:
            r1.f19828e = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x004b
            int r0 = com.hbg.module.huobi.im.R$id.leftLayout
            android.view.View r2 = r2.findViewById(r0)
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            goto L_0x004c
        L_0x004b:
            r2 = r3
        L_0x004c:
            r1.f19829f = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x005b
            int r0 = com.hbg.module.huobi.im.R$id.ivAvatar
            android.view.View r2 = r2.findViewById(r0)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x005c
        L_0x005b:
            r2 = r3
        L_0x005c:
            r1.f19830g = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x006b
            int r0 = com.hbg.module.huobi.im.R$id.tvName
            android.view.View r2 = r2.findViewById(r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x006c
        L_0x006b:
            r2 = r3
        L_0x006c:
            r1.f19831h = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x007b
            int r0 = com.hbg.module.huobi.im.R$id.tvGiftDesc
            android.view.View r2 = r2.findViewById(r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x007c
        L_0x007b:
            r2 = r3
        L_0x007c:
            r1.f19832i = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x008b
            int r0 = com.hbg.module.huobi.im.R$id.ivGiftImg
            android.view.View r2 = r2.findViewById(r0)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x008c
        L_0x008b:
            r2 = r3
        L_0x008c:
            r1.f19833j = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x009b
            int r0 = com.hbg.module.huobi.im.R$id.llNumLayout
            android.view.View r2 = r2.findViewById(r0)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            goto L_0x009c
        L_0x009b:
            r2 = r3
        L_0x009c:
            r1.f19834k = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x00ab
            int r0 = com.hbg.module.huobi.im.R$id.tvX
            android.view.View r2 = r2.findViewById(r0)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x00ac
        L_0x00ab:
            r2 = r3
        L_0x00ac:
            r1.f19835l = r2
            android.view.View r2 = r1.f19826c
            if (r2 == 0) goto L_0x00bb
            int r3 = com.hbg.module.huobi.im.R$id.tvGiftNum
            android.view.View r2 = r2.findViewById(r3)
            r3 = r2
            android.widget.TextView r3 = (android.widget.TextView) r3
        L_0x00bb:
            r1.f19836m = r3
            android.view.View r2 = r1.f19826c
            r1.addView(r2)
            r2 = 4
            r1.setVisibility(r2)
            android.os.Handler r2 = new android.os.Handler
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            r2.<init>(r3)
            r1.f19838o = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftShowView.<init>(android.content.Context, android.util.AttributeSet):void");
    }
}
