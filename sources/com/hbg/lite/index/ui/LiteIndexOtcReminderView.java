package com.hbg.lite.index.ui;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import bb.j;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lite.R$dimen;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.index.bean.ReminderData;

public class LiteIndexOtcReminderView extends BaseHeaderItemView<ReminderData> {

    /* renamed from: f  reason: collision with root package name */
    public int f77160f = PixelUtils.a(63.0f);

    /* renamed from: g  reason: collision with root package name */
    public CountDownTimer f77161g;

    /* renamed from: h  reason: collision with root package name */
    public SafeLottieView f77162h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f77163i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f77164j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f77165k;

    /* renamed from: l  reason: collision with root package name */
    public View f77166l;

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator f77167m;

    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReminderData f77168a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(long j11, long j12, ReminderData reminderData) {
            super(j11, j12);
            this.f77168a = reminderData;
        }

        public void onFinish() {
            LiteIndexOtcReminderView.this.h(true);
        }

        public void onTick(long j11) {
            this.f77168a.o((int) (j11 / 1000));
            LiteIndexOtcReminderView.this.f77165k.setText(this.f77168a.g());
        }
    }

    public LiteIndexOtcReminderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        setItemHeight((int) (((float) this.f77160f) * animatedFraction));
        this.f77166l.setAlpha(animatedFraction);
    }

    private void setItemHeight(int i11) {
        ViewGroup.LayoutParams layoutParams = this.f77166l.getLayoutParams();
        layoutParams.height = i11;
        this.f77166l.setLayoutParams(layoutParams);
    }

    public void a() {
        this.f77166l = this;
        this.f77163i = (TextView) this.f77111e.b(R$id.tv_coin);
        this.f77164j = (TextView) this.f77111e.b(R$id.tv_action);
        this.f77165k = (TextView) this.f77111e.b(R$id.tv_time);
        SafeLottieView safeLottieView = this.f77162h;
        if (safeLottieView != null) {
            safeLottieView.removeAllAnimatorListeners();
        }
        this.f77162h = (SafeLottieView) this.f77166l.findViewById(R$id.iv_anim);
    }

    public final void g() {
        CountDownTimer countDownTimer = this.f77161g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public int getResId() {
        return R$layout.lite_index_otc_reminder_item;
    }

    public final void h(boolean z11) {
        if (!z11) {
            setItemHeight(0);
        } else if (this.f77166l.getHeight() != 0) {
            ValueAnimator valueAnimator = this.f77167m;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
                this.f77167m = duration;
                duration.setInterpolator(new DecelerateInterpolator());
                this.f77167m.addUpdateListener(new j(this));
                this.f77167m.start();
            }
        }
    }

    public final void i() {
        this.f77162h.cancelAnimation();
        g();
        h(false);
    }

    public final void k(ReminderData reminderData) {
        Activity activity = (Activity) this.f77166l.getContext();
        setItemHeight(this.f77160f);
        this.f77163i.setText(reminderData.d(activity));
        this.f77162h.playAnimation();
        if (reminderData.j() == 1) {
            this.f77164j.setText("");
            this.f77165k.setTextSize(0, activity.getResources().getDimension(R$dimen.global_text_size_16));
            g();
            this.f77165k.setText(reminderData.i(activity));
            return;
        }
        this.f77164j.setText(reminderData.i(activity));
        this.f77165k.setTextSize(0, activity.getResources().getDimension(R$dimen.global_text_size_24));
        l(reminderData);
    }

    public final void l(ReminderData reminderData) {
        this.f77165k.setText(reminderData.g());
        g();
        a aVar = new a((long) (reminderData.f() * 1000), 1000, reminderData);
        this.f77161g = aVar;
        aVar.start();
    }

    /* renamed from: m */
    public void c(ReminderData reminderData) {
        if (reminderData == null) {
            i();
        } else {
            k(reminderData);
        }
    }

    public LiteIndexOtcReminderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
