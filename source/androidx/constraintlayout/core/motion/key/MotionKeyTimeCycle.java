package androidx.constraintlayout.core.motion.key;

import java.util.HashMap;

public class MotionKeyTimeCycle extends MotionKey {

    /* renamed from: g  reason: collision with root package name */
    public String f6806g;

    /* renamed from: h  reason: collision with root package name */
    public int f6807h = -1;

    /* renamed from: i  reason: collision with root package name */
    public float f6808i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    public float f6809j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f6810k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public float f6811l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f6812m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f6813n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public float f6814o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    public float f6815p = Float.NaN;

    /* renamed from: q  reason: collision with root package name */
    public float f6816q = Float.NaN;

    /* renamed from: r  reason: collision with root package name */
    public float f6817r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    public float f6818s = Float.NaN;

    /* renamed from: t  reason: collision with root package name */
    public float f6819t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public int f6820u = 0;

    /* renamed from: v  reason: collision with root package name */
    public String f6821v = null;

    /* renamed from: w  reason: collision with root package name */
    public float f6822w = Float.NaN;

    /* renamed from: x  reason: collision with root package name */
    public float f6823x = 0.0f;

    public MotionKeyTimeCycle() {
        this.f6756d = 3;
        this.f6757e = new HashMap<>();
    }

    /* renamed from: a */
    public MotionKey clone() {
        return new MotionKeyTimeCycle().c(this);
    }

    public MotionKeyTimeCycle c(MotionKey motionKey) {
        super.b(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.f6806g = motionKeyTimeCycle.f6806g;
        this.f6807h = motionKeyTimeCycle.f6807h;
        this.f6820u = motionKeyTimeCycle.f6820u;
        this.f6822w = motionKeyTimeCycle.f6822w;
        this.f6823x = motionKeyTimeCycle.f6823x;
        this.f6819t = motionKeyTimeCycle.f6819t;
        this.f6808i = motionKeyTimeCycle.f6808i;
        this.f6809j = motionKeyTimeCycle.f6809j;
        this.f6810k = motionKeyTimeCycle.f6810k;
        this.f6813n = motionKeyTimeCycle.f6813n;
        this.f6811l = motionKeyTimeCycle.f6811l;
        this.f6812m = motionKeyTimeCycle.f6812m;
        this.f6814o = motionKeyTimeCycle.f6814o;
        this.f6815p = motionKeyTimeCycle.f6815p;
        this.f6816q = motionKeyTimeCycle.f6816q;
        this.f6817r = motionKeyTimeCycle.f6817r;
        this.f6818s = motionKeyTimeCycle.f6818s;
        return this;
    }
}
