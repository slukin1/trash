package net.lucode.hackware.magicindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

@TargetApi(11)
public class FragmentContainerHelper {

    /* renamed from: a  reason: collision with root package name */
    public List<MagicIndicator> f58453a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f58454b;

    /* renamed from: c  reason: collision with root package name */
    public int f58455c;

    /* renamed from: d  reason: collision with root package name */
    public int f58456d = 150;

    /* renamed from: e  reason: collision with root package name */
    public Interpolator f58457e = new AccelerateDecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    public Animator.AnimatorListener f58458f = new a();

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f58459g = new b();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            FragmentContainerHelper.this.d(0);
            ValueAnimator unused = FragmentContainerHelper.this.f58454b = null;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i11 = (int) floatValue;
            float f11 = floatValue - ((float) i11);
            if (floatValue < 0.0f) {
                i11--;
                f11 += 1.0f;
            }
            FragmentContainerHelper.this.e(i11, f11, 0);
        }
    }

    public FragmentContainerHelper() {
    }

    public static PositionData g(List<PositionData> list, int i11) {
        PositionData positionData;
        if (i11 >= 0 && i11 <= list.size() - 1) {
            return list.get(i11);
        }
        PositionData positionData2 = new PositionData();
        if (i11 < 0) {
            positionData = list.get(0);
        } else {
            i11 = (i11 - list.size()) + 1;
            positionData = list.get(list.size() - 1);
        }
        positionData2.f58515a = positionData.f58515a + (positionData.b() * i11);
        positionData2.f58516b = positionData.f58516b;
        positionData2.f58517c = positionData.f58517c + (positionData.b() * i11);
        positionData2.f58518d = positionData.f58518d;
        positionData2.f58519e = positionData.f58519e + (positionData.b() * i11);
        positionData2.f58520f = positionData.f58520f;
        positionData2.f58521g = positionData.f58521g + (i11 * positionData.b());
        positionData2.f58522h = positionData.f58522h;
        return positionData2;
    }

    public final void d(int i11) {
        for (MagicIndicator a11 : this.f58453a) {
            a11.a(i11);
        }
    }

    public final void e(int i11, float f11, int i12) {
        for (MagicIndicator b11 : this.f58453a) {
            b11.b(i11, f11, i12);
        }
    }

    public final void f(int i11) {
        for (MagicIndicator c11 : this.f58453a) {
            c11.c(i11);
        }
    }

    public void h(int i11) {
        i(i11, true);
    }

    public void i(int i11, boolean z11) {
        if (this.f58455c != i11) {
            if (z11) {
                ValueAnimator valueAnimator = this.f58454b;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    d(2);
                }
                f(i11);
                float f11 = (float) this.f58455c;
                ValueAnimator valueAnimator2 = this.f58454b;
                if (valueAnimator2 != null) {
                    f11 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    this.f58454b.cancel();
                    this.f58454b = null;
                }
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f58454b = valueAnimator3;
                valueAnimator3.setFloatValues(new float[]{f11, (float) i11});
                this.f58454b.addUpdateListener(this.f58459g);
                this.f58454b.addListener(this.f58458f);
                this.f58454b.setInterpolator(this.f58457e);
                this.f58454b.setDuration((long) this.f58456d);
                this.f58454b.start();
            } else {
                f(i11);
                ValueAnimator valueAnimator4 = this.f58454b;
                if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                    e(this.f58455c, 0.0f, 0);
                }
                d(0);
                e(i11, 0.0f, 0);
            }
            this.f58455c = i11;
        }
    }

    public FragmentContainerHelper(MagicIndicator magicIndicator) {
        this.f58453a.add(magicIndicator);
    }
}
