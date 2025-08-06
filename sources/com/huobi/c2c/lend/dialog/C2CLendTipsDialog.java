package com.huobi.c2c.lend.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;

public class C2CLendTipsDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public View f42917b;

    /* renamed from: c  reason: collision with root package name */
    public View f42918c;

    /* renamed from: d  reason: collision with root package name */
    public int f42919d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f42920e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42921f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f42922g = new a(Looper.getMainLooper());

    public class a extends Handler {

        /* renamed from: com.huobi.c2c.lend.dialog.C2CLendTipsDialog$a$a  reason: collision with other inner class name */
        public class C0563a extends AnimatorListenerAdapter {
            public C0563a() {
            }

            public void onAnimationEnd(Animator animator) {
                if (C2CLendTipsDialog.this.f42921f) {
                    C2CLendTipsDialog.this.f42922g.removeMessages(0);
                    C2CLendTipsDialog.this.f42922g.sendEmptyMessageDelayed(0, 500);
                }
            }

            public void onAnimationStart(Animator animator) {
                C2CLendTipsDialog.this.f42918c.setAlpha(1.0f);
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (C2CLendTipsDialog.this.f42921f) {
                AnimatorSet unused = C2CLendTipsDialog.this.f42920e = new AnimatorSet();
                C2CLendTipsDialog.this.f42920e.setInterpolator(new DecelerateInterpolator());
                C2CLendTipsDialog.this.f42920e.addListener(new C0563a());
                C2CLendTipsDialog.this.f42920e.playSequentially(new Animator[]{ObjectAnimator.ofFloat(C2CLendTipsDialog.this.f42918c, View.TRANSLATION_Y, new float[]{0.0f, (float) (-C2CLendTipsDialog.this.f42919d)}).setDuration(350), ObjectAnimator.ofFloat(C2CLendTipsDialog.this.f42918c, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(200)});
                C2CLendTipsDialog.this.f42920e.start();
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            if (C2CLendTipsDialog.this.f42921f) {
                C2CLendTipsDialog.this.f42922g.sendEmptyMessage(0);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            C2CLendTipsDialog.this.dismiss();
        }
    }

    public static boolean Ah() {
        return SP.l("SP_KEY_C2C_TIPS", false);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        zh();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void addEvent(r rVar) {
        this.f42917b.setOnClickListener(new pi.b(this));
    }

    public void afterInit() {
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f42919d = getResources().getDimensionPixelOffset(R.dimen.dimen_25);
    }

    public int getContentViewResId() {
        return R.layout.c2c_lend_tips_dialog;
    }

    public int getGravity() {
        return 17;
    }

    public void initView(r rVar) {
        this.f42917b = rVar.b(R.id.id_c2c_lend_tips_dialog);
        this.f42918c = rVar.b(R.id.id_c2c_lend_tips_dialog_hand);
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isTransparent() {
        return true;
    }

    public void onBackPressed() {
        zh();
    }

    public void onPause() {
        super.onPause();
        this.f42921f = false;
        AnimatorSet animatorSet = this.f42920e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        this.f42922g.removeCallbacksAndMessages((Object) null);
    }

    public void onResume() {
        super.onResume();
        this.f42921f = true;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f42917b, View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.addListener(new b());
        ofFloat.setDuration(270);
        ofFloat.start();
    }

    public final void zh() {
        AnimatorSet animatorSet = this.f42920e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SP.y("SP_KEY_C2C_TIPS", true);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.f42917b, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(250);
        duration.addListener(new c());
        duration.start();
    }
}
