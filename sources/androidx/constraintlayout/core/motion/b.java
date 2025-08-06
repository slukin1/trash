package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.utils.Rect;
import java.util.ArrayList;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Rect f6729a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    public MotionWidget f6730b;

    /* renamed from: c  reason: collision with root package name */
    public int f6731c = -1;

    /* renamed from: d  reason: collision with root package name */
    public MotionPaths f6732d = new MotionPaths();

    /* renamed from: e  reason: collision with root package name */
    public MotionPaths f6733e = new MotionPaths();

    /* renamed from: f  reason: collision with root package name */
    public MotionConstrainedPoint f6734f = new MotionConstrainedPoint();

    /* renamed from: g  reason: collision with root package name */
    public MotionConstrainedPoint f6735g = new MotionConstrainedPoint();

    /* renamed from: h  reason: collision with root package name */
    public float f6736h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    public float f6737i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f6738j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public int f6739k = 4;

    /* renamed from: l  reason: collision with root package name */
    public float[] f6740l = new float[4];

    /* renamed from: m  reason: collision with root package name */
    public ArrayList<MotionPaths> f6741m = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    public float[] f6742n = new float[1];

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<MotionKey> f6743o = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    public int f6744p = -1;

    /* renamed from: q  reason: collision with root package name */
    public int f6745q = -1;

    /* renamed from: r  reason: collision with root package name */
    public MotionWidget f6746r = null;

    /* renamed from: s  reason: collision with root package name */
    public int f6747s = -1;

    /* renamed from: t  reason: collision with root package name */
    public float f6748t = Float.NaN;

    /* renamed from: u  reason: collision with root package name */
    public androidx.constraintlayout.core.motion.utils.b f6749u = null;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6750v = false;

    public b(MotionWidget motionWidget) {
        d(motionWidget);
    }

    public final void a(MotionPaths motionPaths) {
        motionPaths.c((float) this.f6730b.s(), (float) this.f6730b.t(), (float) this.f6730b.r(), (float) this.f6730b.d());
    }

    public void b(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f6733e;
        motionPaths.f6686d = 1.0f;
        motionPaths.f6687e = 1.0f;
        a(motionPaths);
        this.f6733e.c((float) motionWidget.e(), (float) motionWidget.m(), (float) motionWidget.r(), (float) motionWidget.d());
        this.f6733e.a(motionWidget);
        this.f6735g.e(motionWidget);
    }

    public void c(MotionWidget motionWidget) {
        MotionPaths motionPaths = this.f6732d;
        motionPaths.f6686d = 0.0f;
        motionPaths.f6687e = 0.0f;
        motionPaths.c((float) motionWidget.s(), (float) motionWidget.t(), (float) motionWidget.r(), (float) motionWidget.d());
        this.f6732d.a(motionWidget);
        this.f6734f.e(motionWidget);
    }

    public void d(MotionWidget motionWidget) {
        this.f6730b = motionWidget;
    }

    public String toString() {
        return " start: x: " + this.f6732d.f6688f + " y: " + this.f6732d.f6689g + " end: x: " + this.f6733e.f6688f + " y: " + this.f6733e.f6689g;
    }
}
