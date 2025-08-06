package com.hbg.lib.widgets;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.router.HbgRouter;

public class ClosePathFloatView extends FrameLayout {

    /* renamed from: l  reason: collision with root package name */
    public static String f71041l;

    /* renamed from: m  reason: collision with root package name */
    public static Bundle f71042m;

    /* renamed from: n  reason: collision with root package name */
    public static String f71043n;

    /* renamed from: b  reason: collision with root package name */
    public View f71044b;

    /* renamed from: c  reason: collision with root package name */
    public View f71045c;

    /* renamed from: d  reason: collision with root package name */
    public float f71046d;

    /* renamed from: e  reason: collision with root package name */
    public float f71047e;

    /* renamed from: f  reason: collision with root package name */
    public float f71048f;

    /* renamed from: g  reason: collision with root package name */
    public float f71049g;

    /* renamed from: h  reason: collision with root package name */
    public int f71050h;

    /* renamed from: i  reason: collision with root package name */
    public float f71051i;

    /* renamed from: j  reason: collision with root package name */
    public int f71052j;

    /* renamed from: k  reason: collision with root package name */
    public d f71053k;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (ClosePathFloatView.this.isShown()) {
                ClosePathFloatView.this.i();
            }
        }

        public void onAnimationEnd(Animator animator) {
            ClosePathFloatView.this.postDelayed(new h(this), 3000);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            ClosePathFloatView.this.setVisibility(8);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            ClosePathFloatView.this.f71045c.setVisibility(8);
        }
    }

    public interface d {
        void a();

        void onCloseClick();

        void onShow();
    }

    public ClosePathFloatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static void c() {
        f((String) null, (String) null, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.f71045c.getLayoutParams();
        layoutParams.width = intValue;
        this.f71045c.setLayoutParams(layoutParams);
    }

    public static void f(String str, String str2, Bundle bundle) {
        f71043n = str;
        f71041l = str2;
        f71042m = bundle;
    }

    public static void g(String str, Activity activity, boolean z11) {
        ClosePathFloatView closePathFloatView;
        if (str == null || !str.equalsIgnoreCase(f71043n)) {
            c();
        }
        if (activity != null && (closePathFloatView = (ClosePathFloatView) activity.findViewById(R$id.id_close_path_float_view)) != null) {
            boolean z12 = z11 && str != null && str.equalsIgnoreCase(f71043n) && f71042m != null && !TextUtils.isEmpty(f71041l);
            boolean z13 = closePathFloatView.getVisibility() == 0;
            ViewUtil.m(closePathFloatView, z12);
            if (!z13 && z12) {
                closePathFloatView.j();
            }
            if (!z12) {
                return;
            }
            if (SP.l("SP_KEY_CLOSE_PATH_ANIM", false)) {
                closePathFloatView.d();
            } else {
                SP.y("SP_KEY_CLOSE_PATH_ANIM", true);
            }
        }
    }

    public void d() {
        View view = this.f71045c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void h() {
        c();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, new float[]{0.0f, -((float) getWidth())});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(270);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    public void i() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f71045c.getWidth(), 0});
        ofInt.setDuration(270);
        ofInt.setInterpolator(new FastOutSlowInInterpolator());
        ofInt.addUpdateListener(new g(this));
        ofInt.addListener(new c());
        ofInt.start();
        this.f71044b.setVisibility(0);
        this.f71044b.setAlpha(0.0f);
        this.f71044b.animate().setDuration(270).alpha(1.0f);
    }

    public void j() {
        float f11 = -((float) getResources().getDisplayMetrics().widthPixels);
        setTranslationX(f11);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, View.TRANSLATION_X, new float[]{f11, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(270);
        animatorSet.setInterpolator(new LinearOutSlowInInterpolator());
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setStartDelay(100);
        if (this.f71045c.isShown()) {
            animatorSet.addListener(new a());
        }
        animatorSet.start();
        d dVar = this.f71053k;
        if (dVar != null) {
            dVar.onShow();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f71047e = motionEvent.getRawX();
            this.f71048f = motionEvent.getRawY();
            if (this.f71049g == 0.0f) {
                this.f71049g = getY();
            }
        } else if (action == 1) {
            this.f71046d = this.f71051i;
            float abs = Math.abs(motionEvent.getRawX() - this.f71047e);
            float abs2 = Math.abs(motionEvent.getRawY() - this.f71048f);
            int i11 = this.f71052j;
            if (abs <= ((float) i11) && abs2 <= ((float) i11)) {
                if (motionEvent.getX() >= ((float) (getWidth() - this.f71044b.getWidth()))) {
                    h();
                    d dVar = this.f71053k;
                    if (dVar != null) {
                        dVar.onCloseClick();
                    }
                } else {
                    if (f71042m != null && !TextUtils.isEmpty(f71041l)) {
                        HbgRouter.i(getContext(), "/webView/index", f71042m);
                        c();
                    }
                    d dVar2 = this.f71053k;
                    if (dVar2 != null) {
                        dVar2.a();
                    }
                }
            }
        } else if (action == 2) {
            float rawY = (this.f71046d + motionEvent.getRawY()) - this.f71048f;
            this.f71051i = rawY;
            float max = Math.max(rawY, ((float) this.f71050h) - this.f71049g);
            this.f71051i = max;
            float min = Math.min(max, (float) this.f71050h);
            this.f71051i = min;
            setTranslationY(min);
        } else if (action == 3) {
            this.f71046d = this.f71051i;
        }
        return true;
    }

    public void setCallback(d dVar) {
        this.f71053k = dVar;
    }

    public ClosePathFloatView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        FrameLayout.inflate(context, R$layout.layout_close_path_float_view, this);
        this.f71044b = findViewById(R$id.id_close_path_float_view_close_btn);
        this.f71045c = findViewById(R$id.id_close_path_float_view_tv_parent);
        this.f71050h = getResources().getDimensionPixelOffset(R$dimen.dimen_44);
        this.f71052j = ViewConfiguration.get(context).getScaledTouchSlop();
        int i12 = 0;
        boolean l11 = SP.l("SP_KEY_CLOSE_PATH_ANIM", false);
        this.f71045c.setVisibility(!l11 ? 0 : 8);
        this.f71044b.setVisibility(!l11 ? 8 : i12);
    }
}
