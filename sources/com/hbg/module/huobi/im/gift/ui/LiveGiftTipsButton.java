package com.hbg.module.huobi.im.gift.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$color;
import com.huobi.view.roundview.RoundLinearLayout;
import com.huobi.view.roundview.RoundViewDelegate;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import rd.s;

public final class LiveGiftTipsButton extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f19847b;

    /* renamed from: c  reason: collision with root package name */
    public RoundLinearLayout f19848c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f19849d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19850e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19851f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19852g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19853h;

    /* renamed from: i  reason: collision with root package name */
    public d10.a<Unit> f19854i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f19855j;

    /* renamed from: k  reason: collision with root package name */
    public int f19856k;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19857b;

        public a(LiveGiftTipsButton liveGiftTipsButton) {
            this.f19857b = liveGiftTipsButton;
        }

        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            LiveGiftTipsButton liveGiftTipsButton = this.f19857b;
            RoundLinearLayout llGiftTip = liveGiftTipsButton.getLlGiftTip();
            liveGiftTipsButton.setLlGiftTipWidth((llGiftTip != null ? Integer.valueOf(llGiftTip.getWidth()) : null).intValue());
            RoundLinearLayout llGiftTip2 = this.f19857b.getLlGiftTip();
            if (llGiftTip2 != null && (viewTreeObserver = llGiftTip2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19858b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f19859c;

        public b(LiveGiftTipsButton liveGiftTipsButton, boolean z11) {
            this.f19858b = liveGiftTipsButton;
            this.f19859c = z11;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (this.f19859c) {
                RoundLinearLayout llGiftTip = this.f19858b.getLlGiftTip();
                if (llGiftTip != null) {
                    llGiftTip.setVisibility(0);
                }
                ImageView imgGift = this.f19858b.getImgGift();
                if (imgGift != null) {
                    imgGift.setVisibility(8);
                    return;
                }
                return;
            }
            RoundLinearLayout llGiftTip2 = this.f19858b.getLlGiftTip();
            if (llGiftTip2 != null) {
                llGiftTip2.setVisibility(4);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            RoundLinearLayout llGiftTip = this.f19858b.getLlGiftTip();
            if (llGiftTip != null) {
                llGiftTip.setVisibility(0);
            }
            ImageView imgGift = this.f19858b.getImgGift();
            if (imgGift != null) {
                imgGift.setVisibility(8);
            }
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19860b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f19861c;

        public c(LiveGiftTipsButton liveGiftTipsButton, boolean z11) {
            this.f19860b = liveGiftTipsButton;
            this.f19861c = z11;
        }

        public void onAnimationEnd(Animator animator) {
            ImageView imgGift;
            super.onAnimationEnd(animator);
            if (this.f19861c && (imgGift = this.f19860b.getImgGift()) != null) {
                imgGift.setVisibility(8);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ImageView imgGift = this.f19860b.getImgGift();
            if (imgGift != null) {
                imgGift.setVisibility(0);
            }
        }
    }

    public static final class d implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19862b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19863c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19864d;

        public d(View view, long j11, LiveGiftTipsButton liveGiftTipsButton) {
            this.f19862b = view;
            this.f19863c = j11;
            this.f19864d = liveGiftTipsButton;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19862b) > this.f19863c || (this.f19862b instanceof Checkable)) {
                sVar.e(this.f19862b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f19862b;
                this.f19864d.d(1, true);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19865b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19866c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19867d;

        public e(View view, long j11, LiveGiftTipsButton liveGiftTipsButton) {
            this.f19865b = view;
            this.f19866c = j11;
            this.f19867d = liveGiftTipsButton;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19865b) > this.f19866c || (this.f19865b instanceof Checkable)) {
                sVar.e(this.f19865b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f19865b;
                this.f19867d.d(0, true);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class f implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19868b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19869c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19870d;

        public f(View view, long j11, LiveGiftTipsButton liveGiftTipsButton) {
            this.f19868b = view;
            this.f19869c = j11;
            this.f19870d = liveGiftTipsButton;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19868b) > this.f19869c || (this.f19868b instanceof Checkable)) {
                sVar.e(this.f19868b, currentTimeMillis);
                TextView textView = (TextView) this.f19868b;
                d10.a<Unit> onOpenLiveGiftClick = this.f19870d.getOnOpenLiveGiftClick();
                if (onOpenLiveGiftClick != null) {
                    onOpenLiveGiftClick.invoke();
                }
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class g implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f19871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f19872c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ LiveGiftTipsButton f19873d;

        public g(View view, long j11, LiveGiftTipsButton liveGiftTipsButton) {
            this.f19871b = view;
            this.f19872c = j11;
            this.f19873d = liveGiftTipsButton;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f19871b) > this.f19872c || (this.f19871b instanceof Checkable)) {
                sVar.e(this.f19871b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f19871b;
                this.f19873d.d(0, true);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public LiveGiftTipsButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LiveGiftTipsButton(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r0.getLayoutParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(boolean r9) {
        /*
            r8 = this;
            int r0 = r8.f19856k
            if (r0 >= 0) goto L_0x001c
            com.huobi.view.roundview.RoundLinearLayout r0 = r8.f19848c
            if (r0 == 0) goto L_0x0015
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L_0x0015
            int r0 = r0.width
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            int r0 = r0.intValue()
            r8.f19856k = r0
        L_0x001c:
            int r0 = r8.f19856k
            float r1 = (float) r0
            float r1 = -r1
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r9 != 0) goto L_0x002b
            float r0 = (float) r0
            float r0 = -r0
            r1 = r3
            r3 = r2
            r2 = r1
            goto L_0x002c
        L_0x002b:
            r0 = r3
        L_0x002c:
            com.huobi.view.roundview.RoundLinearLayout r4 = r8.f19848c
            r5 = 2
            float[] r6 = new float[r5]
            r7 = 0
            r6[r7] = r1
            r1 = 1
            r6[r1] = r0
            java.lang.String r0 = "translationX"
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r4, r0, r6)
            android.widget.ImageView r4 = r8.f19853h
            float[] r6 = new float[r5]
            r6[r7] = r2
            r6[r1] = r3
            java.lang.String r2 = "alpha"
            android.animation.ObjectAnimator r2 = android.animation.ObjectAnimator.ofFloat(r4, r2, r6)
            androidx.interpolator.view.animation.FastOutSlowInInterpolator r3 = new androidx.interpolator.view.animation.FastOutSlowInInterpolator
            r3.<init>()
            r2.setInterpolator(r3)
            r3 = 300(0x12c, double:1.48E-321)
            r2.setDuration(r3)
            androidx.interpolator.view.animation.FastOutSlowInInterpolator r3 = new androidx.interpolator.view.animation.FastOutSlowInInterpolator
            r3.<init>()
            r0.setInterpolator(r3)
            r3 = 400(0x190, double:1.976E-321)
            r0.setDuration(r3)
            com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton$b r3 = new com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton$b
            r3.<init>(r8, r9)
            r0.addListener(r3)
            com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton$c r3 = new com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton$c
            r3.<init>(r8, r9)
            r2.addListener(r3)
            android.animation.AnimatorSet r9 = new android.animation.AnimatorSet
            r9.<init>()
            android.animation.Animator[] r3 = new android.animation.Animator[r5]
            r3[r7] = r0
            r3[r1] = r2
            r9.playTogether(r3)
            r9.start()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton.b(boolean):void");
    }

    public final void c() {
        d(-1, false);
        this.f19855j = false;
        removeAllViews();
        removeAllViewsInLayout();
    }

    public final void d(int i11, boolean z11) {
        if (!(indexOfChild(this.f19847b) != -1)) {
            addView(this.f19847b, new FrameLayout.LayoutParams(-2, -2));
        }
        if (i11 == -1) {
            this.f19855j = false;
            RoundLinearLayout roundLinearLayout = this.f19848c;
            if (roundLinearLayout != null) {
                roundLinearLayout.setVisibility(8);
            }
        } else if (i11 == 0) {
            this.f19855j = true;
            ImageView imageView = this.f19853h;
            if (imageView != null) {
                s sVar = s.f23381a;
                imageView.setOnClickListener(new d(imageView, 800, this));
            }
            if (z11) {
                b(false);
                return;
            }
            ImageView imageView2 = this.f19853h;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            RoundLinearLayout roundLinearLayout2 = this.f19848c;
            if (roundLinearLayout2 != null) {
                roundLinearLayout2.setVisibility(4);
            }
        } else if (i11 == 1) {
            this.f19855j = true;
            RoundLinearLayout roundLinearLayout3 = this.f19848c;
            RoundViewDelegate roundViewDelegate = null;
            RoundViewDelegate delegate = roundLinearLayout3 != null ? roundLinearLayout3.getDelegate() : null;
            if (delegate != null) {
                delegate.setBackgroundColor(getResources().getColor(R$color.color_live_gift_tips_bg));
            }
            RoundLinearLayout roundLinearLayout4 = this.f19848c;
            if (roundLinearLayout4 != null) {
                roundViewDelegate = roundLinearLayout4.getDelegate();
            }
            if (roundViewDelegate != null) {
                roundViewDelegate.setBackgroundPressColor(getResources().getColor(R$color.color_live_gift_tips_bg));
            }
            ImageView imageView3 = this.f19849d;
            if (imageView3 != null) {
                s sVar2 = s.f23381a;
                imageView3.setOnClickListener(new e(imageView3, 800, this));
            }
            TextView textView = this.f19851f;
            if (textView != null) {
                s sVar3 = s.f23381a;
                textView.setOnClickListener(new f(textView, 800, this));
            }
            LinearLayout linearLayout = this.f19852g;
            if (linearLayout != null) {
                s sVar4 = s.f23381a;
                linearLayout.setOnClickListener(new g(linearLayout, 800, this));
            }
            if (z11) {
                b(true);
                return;
            }
            ImageView imageView4 = this.f19853h;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
            RoundLinearLayout roundLinearLayout5 = this.f19848c;
            if (roundLinearLayout5 != null) {
                roundLinearLayout5.setVisibility(0);
            }
        }
    }

    public final void e(String str) {
        if (!this.f19855j) {
            d(0, false);
        }
        TextView textView = this.f19850e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final TextView getBtnGiftTip() {
        return this.f19851f;
    }

    public final ImageView getImgGift() {
        return this.f19853h;
    }

    public final ImageView getImgGiftTip() {
        return this.f19849d;
    }

    public final LinearLayout getLlClose() {
        return this.f19852g;
    }

    public final RoundLinearLayout getLlGiftTip() {
        return this.f19848c;
    }

    public final int getLlGiftTipWidth() {
        return this.f19856k;
    }

    public final View getMView() {
        return this.f19847b;
    }

    public final d10.a<Unit> getOnOpenLiveGiftClick() {
        return this.f19854i;
    }

    public final TextView getTvGiftTip() {
        return this.f19850e;
    }

    public final void setBtnGiftTip(TextView textView) {
        this.f19851f = textView;
    }

    public final void setImgGift(ImageView imageView) {
        this.f19853h = imageView;
    }

    public final void setImgGiftTip(ImageView imageView) {
        this.f19849d = imageView;
    }

    public final void setLlClose(LinearLayout linearLayout) {
        this.f19852g = linearLayout;
    }

    public final void setLlGiftTip(RoundLinearLayout roundLinearLayout) {
        this.f19848c = roundLinearLayout;
    }

    public final void setLlGiftTipWidth(int i11) {
        this.f19856k = i11;
    }

    public final void setMView(View view) {
        this.f19847b = view;
    }

    public final void setOnOpenLiveGiftClick(d10.a<Unit> aVar) {
        this.f19854i = aVar;
    }

    public final void setOpenWindow(boolean z11) {
        this.f19855j = z11;
    }

    public final void setTvGiftTip(TextView textView) {
        this.f19850e = textView;
    }

    /* JADX WARNING: type inference failed for: r1v15, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public LiveGiftTipsButton(android.content.Context r1, android.util.AttributeSet r2, int r3) {
        /*
            r0 = this;
            r0.<init>(r1, r2, r3)
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r1)
            int r2 = com.hbg.module.huobi.im.R$layout.lay_live_gift_tips
            r3 = 0
            android.view.View r1 = r1.inflate(r2, r0, r3)
            r0.f19847b = r1
            r2 = 0
            if (r1 == 0) goto L_0x001c
            int r3 = com.hbg.module.huobi.im.R$id.llGiftTip
            android.view.View r1 = r1.findViewById(r3)
            com.huobi.view.roundview.RoundLinearLayout r1 = (com.huobi.view.roundview.RoundLinearLayout) r1
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            r0.f19848c = r1
            android.view.View r1 = r0.f19847b
            if (r1 == 0) goto L_0x002c
            int r3 = com.hbg.module.huobi.im.R$id.imgGiftTip
            android.view.View r1 = r1.findViewById(r3)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            r0.f19849d = r1
            android.view.View r1 = r0.f19847b
            if (r1 == 0) goto L_0x003c
            int r3 = com.hbg.module.huobi.im.R$id.imgGift
            android.view.View r1 = r1.findViewById(r3)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            r0.f19853h = r1
            android.view.View r1 = r0.f19847b
            if (r1 == 0) goto L_0x004c
            int r3 = com.hbg.module.huobi.im.R$id.tvGiftTip
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x004d
        L_0x004c:
            r1 = r2
        L_0x004d:
            r0.f19850e = r1
            android.view.View r1 = r0.f19847b
            if (r1 == 0) goto L_0x005c
            int r3 = com.hbg.module.huobi.im.R$id.btnGiftTip
            android.view.View r1 = r1.findViewById(r3)
            android.widget.TextView r1 = (android.widget.TextView) r1
            goto L_0x005d
        L_0x005c:
            r1 = r2
        L_0x005d:
            r0.f19851f = r1
            android.view.View r1 = r0.f19847b
            if (r1 == 0) goto L_0x006c
            int r2 = com.hbg.module.huobi.im.R$id.llClose
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
        L_0x006c:
            r0.f19852g = r2
            com.huobi.view.roundview.RoundLinearLayout r1 = r0.f19848c
            if (r1 == 0) goto L_0x0080
            android.view.ViewTreeObserver r1 = r1.getViewTreeObserver()
            if (r1 == 0) goto L_0x0080
            com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton$a r2 = new com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton$a
            r2.<init>(r0)
            r1.addOnGlobalLayoutListener(r2)
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.huobi.im.gift.ui.LiveGiftTipsButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
