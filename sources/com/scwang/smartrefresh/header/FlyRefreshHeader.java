package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.header.flyrefresh.FlyView;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.header.FalsifyHeader;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.i;
import ky.j;

public class FlyRefreshHeader extends FalsifyHeader {

    /* renamed from: c  reason: collision with root package name */
    public FlyView f29516c;

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f29517d;

    /* renamed from: e  reason: collision with root package name */
    public MountainSceneView f29518e;

    /* renamed from: f  reason: collision with root package name */
    public j f29519f;

    /* renamed from: g  reason: collision with root package name */
    public i f29520g;

    /* renamed from: h  reason: collision with root package name */
    public int f29521h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f29522i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29523j = false;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            FlyRefreshHeader.this.onPulling(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0, 0, 0);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f29516c != null) {
                FlyRefreshHeader.this.f29516c.setRotationY(180.0f);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AnimatorListenerAdapter f29526b;

        public c(AnimatorListenerAdapter animatorListenerAdapter) {
            this.f29526b = animatorListenerAdapter;
        }

        public void onAnimationEnd(Animator animator) {
            if (FlyRefreshHeader.this.f29519f != null) {
                FlyRefreshHeader.this.f29519f.i(true);
            }
            AnimatorListenerAdapter animatorListenerAdapter = this.f29526b;
            if (animatorListenerAdapter != null) {
                animatorListenerAdapter.onAnimationEnd(animator);
            }
        }

        public void onAnimationStart(Animator animator) {
            if (FlyRefreshHeader.this.f29516c != null) {
                FlyRefreshHeader.this.f29516c.setRotationY(0.0f);
            }
        }
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void c() {
        d((AnimatorListenerAdapter) null);
    }

    public void d(AnimatorListenerAdapter animatorListenerAdapter) {
        if (this.f29516c != null && this.f29523j && this.f29519f != null) {
            AnimatorSet animatorSet = this.f29517d;
            if (animatorSet != null) {
                animatorSet.end();
                this.f29516c.clearAnimation();
            }
            this.f29523j = false;
            this.f29519f.d(0);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(800);
            FlyView flyView = this.f29516c;
            float f11 = (float) (-this.f29516c.getRight());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(flyView, "translationX", new float[]{flyView.getTranslationX(), f11});
            FlyView flyView2 = this.f29516c;
            float f12 = (float) (-DensityUtil.b(10.0f));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(flyView2, "translationY", new float[]{flyView2.getTranslationY(), f12});
            ofFloat2.setInterpolator(fy.a.a(0.1f, 1.0f));
            FlyView flyView3 = this.f29516c;
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(flyView3, "rotation", new float[]{flyView3.getRotation(), 0.0f});
            FlyView flyView4 = this.f29516c;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView4, "rotationX", new float[]{flyView4.getRotationX(), 30.0f});
            ofFloat3.setInterpolator(new AccelerateInterpolator());
            FlyView flyView5 = this.f29516c;
            float[] fArr = {flyView5.getScaleX(), 0.9f};
            FlyView flyView6 = this.f29516c;
            animatorSet2.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ObjectAnimator.ofFloat(flyView5, "scaleX", fArr), ObjectAnimator.ofFloat(flyView6, "scaleY", new float[]{flyView6.getScaleY(), 0.9f})});
            animatorSet2.addListener(new b());
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.setDuration(800);
            animatorSet3.setInterpolator(new DecelerateInterpolator());
            animatorSet3.playTogether(new Animator[]{ObjectAnimator.ofFloat(this.f29516c, "translationX", new float[]{f11, 0.0f}), ObjectAnimator.ofFloat(this.f29516c, "translationY", new float[]{f12, 0.0f}), ObjectAnimator.ofFloat(this.f29516c, "rotationX", new float[]{30.0f, 0.0f}), ObjectAnimator.ofFloat(this.f29516c, "scaleX", new float[]{0.9f, 1.0f}), ObjectAnimator.ofFloat(this.f29516c, "scaleY", new float[]{0.9f, 1.0f})});
            animatorSet3.setStartDelay(100);
            animatorSet3.addListener(new c(animatorListenerAdapter));
            AnimatorSet animatorSet4 = new AnimatorSet();
            this.f29517d = animatorSet4;
            animatorSet4.playSequentially(new Animator[]{animatorSet2, animatorSet3});
            this.f29517d.start();
        }
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29519f = null;
        this.f29520g = null;
    }

    public int onFinish(j jVar, boolean z11) {
        if (this.f29523j) {
            c();
        }
        return super.onFinish(jVar, z11);
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f29520g = iVar;
        j f11 = iVar.f();
        this.f29519f = f11;
        f11.a(false);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        if (i11 < 0) {
            if (this.f29521h > 0) {
                i11 = 0;
                f11 = 0.0f;
            } else {
                return;
            }
        }
        this.f29521h = i11;
        this.f29522i = f11;
        MountainSceneView mountainSceneView = this.f29518e;
        if (mountainSceneView != null) {
            mountainSceneView.d(f11);
            this.f29518e.postInvalidate();
        }
        FlyView flyView = this.f29516c;
        if (flyView != null) {
            int i14 = i12 + i13;
            if (i14 > 0) {
                flyView.setRotation((((float) i11) * -45.0f) / ((float) i14));
            } else {
                flyView.setRotation(f11 * -45.0f);
            }
        }
    }

    public void onReleased(j jVar, int i11, int i12) {
        this.f29520g.b(0);
        float f11 = this.f29522i;
        if (f11 > 0.0f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f11, 0.0f});
            ofFloat.setDuration(300);
            ofFloat.addUpdateListener(new a());
            ofFloat.start();
            this.f29522i = 0.0f;
        }
        if (this.f29516c != null && !this.f29523j) {
            AnimatorSet animatorSet = this.f29517d;
            if (animatorSet != null) {
                animatorSet.end();
                this.f29516c.clearAnimation();
            }
            this.f29523j = true;
            jVar.i(false);
            int width = ((View) this.f29519f).getWidth() - this.f29516c.getLeft();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29516c, "translationX", new float[]{0.0f, (float) width});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f29516c, "translationY", new float[]{0.0f, (float) (((-(this.f29516c.getTop() - this.f29521h)) * 2) / 3)});
            ofFloat3.setInterpolator(fy.a.a(0.7f, 1.0f));
            FlyView flyView = this.f29516c;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(flyView, "rotation", new float[]{flyView.getRotation(), 0.0f});
            ofFloat4.setInterpolator(new DecelerateInterpolator());
            FlyView flyView2 = this.f29516c;
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(flyView2, "rotationX", new float[]{flyView2.getRotationX(), 50.0f});
            ofFloat5.setInterpolator(new DecelerateInterpolator());
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.setDuration(800);
            FlyView flyView3 = this.f29516c;
            float[] fArr = {flyView3.getScaleX(), 0.5f};
            FlyView flyView4 = this.f29516c;
            animatorSet2.playTogether(new Animator[]{ofFloat2, ofFloat3, ofFloat4, ofFloat5, ObjectAnimator.ofFloat(flyView3, "scaleX", fArr), ObjectAnimator.ofFloat(flyView4, "scaleY", new float[]{flyView4.getScaleY(), 0.5f})});
            this.f29517d = animatorSet2;
            animatorSet2.start();
        }
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        if (!this.f29523j) {
            onPulling(f11, i11, i12, i13);
        }
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        MountainSceneView mountainSceneView;
        if (iArr.length > 0 && (mountainSceneView = this.f29518e) != null) {
            mountainSceneView.setPrimaryColor(iArr[0]);
        }
    }

    public void setUpFlyView(FlyView flyView) {
        this.f29516c = flyView;
    }

    public void setUpMountainSceneView(MountainSceneView mountainSceneView) {
        this.f29518e = mountainSceneView;
    }

    public FlyRefreshHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
