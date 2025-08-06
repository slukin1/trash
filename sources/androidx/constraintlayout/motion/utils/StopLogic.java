package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.core.motion.utils.g;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic extends MotionInterpolator {

    /* renamed from: a  reason: collision with root package name */
    public StopLogicEngine f7369a;

    /* renamed from: b  reason: collision with root package name */
    public SpringStopEngine f7370b;

    /* renamed from: c  reason: collision with root package name */
    public g f7371c;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f7369a = stopLogicEngine;
        this.f7371c = stopLogicEngine;
    }

    public float a() {
        return this.f7371c.a();
    }

    public void b(float f11, float f12, float f13, float f14, float f15, float f16) {
        StopLogicEngine stopLogicEngine = this.f7369a;
        this.f7371c = stopLogicEngine;
        stopLogicEngine.d(f11, f12, f13, f14, f15, f16);
    }

    public boolean c() {
        return this.f7371c.b();
    }

    public void d(float f11, float f12, float f13, float f14, float f15, float f16, float f17, int i11) {
        if (this.f7370b == null) {
            this.f7370b = new SpringStopEngine();
        }
        SpringStopEngine springStopEngine = this.f7370b;
        this.f7371c = springStopEngine;
        springStopEngine.d(f11, f12, f13, f14, f15, f16, f17, i11);
    }

    public float getInterpolation(float f11) {
        return this.f7371c.getInterpolation(f11);
    }
}
