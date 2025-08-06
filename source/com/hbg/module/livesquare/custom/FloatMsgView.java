package com.hbg.module.livesquare.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.hbg.lib.network.hbg.core.bean.LivePlayingData;
import com.hbg.module.libkt.base.ext.c;
import java.util.ArrayList;
import kotlin.jvm.internal.r;
import lc.u5;

public final class FloatMsgView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public final int f26475b;

    /* renamed from: c  reason: collision with root package name */
    public final int f26476c;

    /* renamed from: d  reason: collision with root package name */
    public int f26477d;

    /* renamed from: e  reason: collision with root package name */
    public int f26478e;

    /* renamed from: f  reason: collision with root package name */
    public final long f26479f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f26480g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayList<LivePlayingData.FloatMsg> f26481h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList<LivePlayingData.FloatMsg> f26482i;
    @SuppressLint({"HandlerLeak"})

    /* renamed from: j  reason: collision with root package name */
    public Handler f26483j;

    public static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FloatMsgView f26484a;

        public a(FloatMsgView floatMsgView) {
            this.f26484a = floatMsgView;
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            this.f26484a.d();
            sendEmptyMessageDelayed(0, this.f26484a.f26479f);
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FloatMsgView f26485a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LivePlayingData.FloatMsg f26486b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ u5 f26487c;

        public b(FloatMsgView floatMsgView, LivePlayingData.FloatMsg floatMsg, u5 u5Var) {
            this.f26485a = floatMsgView;
            this.f26486b = floatMsg;
            this.f26487c = u5Var;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f26485a.f26480g) {
                this.f26485a.f26482i.remove(this.f26486b);
            }
            this.f26485a.removeView(this.f26487c.getRoot());
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public FloatMsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public FloatMsgView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FloatMsgView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? 0 : i11, (i13 & 8) != 0 ? 0 : i12);
    }

    public final void d() {
        LivePlayingData.FloatMsg floatMsg = this.f26481h.get((int) (Math.random() * ((double) this.f26481h.size())));
        if (this.f26480g) {
            if (!this.f26482i.contains(floatMsg)) {
                this.f26482i.add(floatMsg);
            } else {
                return;
            }
        }
        g(floatMsg);
    }

    public final Animation e(int i11, int i12) {
        TranslateAnimation translateAnimation = new TranslateAnimation((float) i11, (float) i12, 0.0f, 0.0f);
        translateAnimation.setDuration((long) ((Math.abs(i12 - i11) * 5000) / c.c()));
        translateAnimation.setInterpolator(new DecelerateAccelerateInterpolator());
        translateAnimation.setFillAfter(true);
        return translateAnimation;
    }

    public final void f() {
        if (this.f26483j.hasMessages(0)) {
            this.f26483j.removeMessages(0);
        }
        this.f26481h.clear();
        this.f26482i.clear();
        removeAllViews();
    }

    public final void g(LivePlayingData.FloatMsg floatMsg) {
        if (this.f26478e == 0 || getChildCount() < this.f26478e) {
            u5 K = u5.K(LayoutInflater.from(getContext()));
            K.M(floatMsg);
            int right = (getRight() - getLeft()) - getPaddingLeft();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(10);
            int i11 = this.f26477d;
            int i12 = this.f26475b;
            if (i11 == i12) {
                i12 = this.f26476c;
            }
            this.f26477d = i12;
            layoutParams.topMargin = i12;
            K.getRoot().setLayoutParams(layoutParams);
            Animation e11 = e(right, -c.c());
            e11.setAnimationListener(new b(this, floatMsg, K));
            K.getRoot().startAnimation(e11);
            addView(K.getRoot());
        }
    }

    public final Handler getMHandler() {
        return this.f26483j;
    }

    public final void setFloatMsgs(ArrayList<LivePlayingData.FloatMsg> arrayList) {
        f();
        if (!com.hbg.module.libkt.base.ext.b.w(arrayList)) {
            this.f26481h.clear();
            this.f26481h.addAll(arrayList);
            this.f26483j.sendEmptyMessageDelayed(0, this.f26479f);
        }
    }

    public final void setMHandler(Handler handler) {
        this.f26483j = handler;
    }

    public FloatMsgView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        int d11 = c.d(Float.valueOf(20.0f));
        this.f26475b = d11;
        this.f26476c = c.d(Float.valueOf(47.0f));
        this.f26477d = d11;
        this.f26479f = 1000;
        this.f26480g = true;
        this.f26481h = new ArrayList<>();
        this.f26482i = new ArrayList<>();
        this.f26483j = new a(this);
    }
}
