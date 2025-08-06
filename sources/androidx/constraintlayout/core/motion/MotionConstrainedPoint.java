package androidx.constraintlayout.core.motion;

import java.util.LinkedHashMap;

class MotionConstrainedPoint implements Comparable<MotionConstrainedPoint> {
    public static String[] D = {"position", "x", "y", "width", "height", "pathRotate"};
    public int A = 0;
    public double[] B = new double[18];
    public double[] C = new double[18];

    /* renamed from: b  reason: collision with root package name */
    public float f6658b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public int f6659c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f6660d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6661e = false;

    /* renamed from: f  reason: collision with root package name */
    public float f6662f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f6663g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f6664h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f6665i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f6666j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f6667k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f6668l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    public float f6669m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    public float f6670n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    public float f6671o = 0.0f;

    /* renamed from: p  reason: collision with root package name */
    public float f6672p = 0.0f;

    /* renamed from: q  reason: collision with root package name */
    public int f6673q = 0;

    /* renamed from: r  reason: collision with root package name */
    public float f6674r;

    /* renamed from: s  reason: collision with root package name */
    public float f6675s;

    /* renamed from: t  reason: collision with root package name */
    public float f6676t;

    /* renamed from: u  reason: collision with root package name */
    public float f6677u;

    /* renamed from: v  reason: collision with root package name */
    public float f6678v;

    /* renamed from: w  reason: collision with root package name */
    public float f6679w = Float.NaN;

    /* renamed from: x  reason: collision with root package name */
    public float f6680x = Float.NaN;

    /* renamed from: y  reason: collision with root package name */
    public int f6681y = -1;

    /* renamed from: z  reason: collision with root package name */
    public LinkedHashMap<String, a> f6682z = new LinkedHashMap<>();

    public void a(MotionWidget motionWidget) {
        this.f6660d = motionWidget.q();
        this.f6658b = motionWidget.q() != 4 ? 0.0f : motionWidget.a();
        this.f6661e = false;
        this.f6663g = motionWidget.j();
        this.f6664h = motionWidget.h();
        this.f6665i = motionWidget.i();
        this.f6666j = motionWidget.k();
        this.f6667k = motionWidget.l();
        this.f6668l = motionWidget.f();
        this.f6669m = motionWidget.g();
        this.f6670n = motionWidget.n();
        this.f6671o = motionWidget.o();
        this.f6672p = motionWidget.p();
        for (String next : motionWidget.c()) {
            a b11 = motionWidget.b(next);
            if (b11 != null && b11.b()) {
                this.f6682z.put(next, b11);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(MotionConstrainedPoint motionConstrainedPoint) {
        return Float.compare(this.f6674r, motionConstrainedPoint.f6674r);
    }

    public void c(float f11, float f12, float f13, float f14) {
        this.f6675s = f11;
        this.f6676t = f12;
        this.f6677u = f13;
        this.f6678v = f14;
    }

    public void e(MotionWidget motionWidget) {
        c((float) motionWidget.s(), (float) motionWidget.t(), (float) motionWidget.r(), (float) motionWidget.d());
        a(motionWidget);
    }
}
