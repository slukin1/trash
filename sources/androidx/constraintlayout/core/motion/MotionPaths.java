package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.HashMap;

public class MotionPaths implements Comparable<MotionPaths> {

    /* renamed from: u  reason: collision with root package name */
    public static String[] f6683u = {"position", "x", "y", "width", "height", "pathRotate"};

    /* renamed from: b  reason: collision with root package name */
    public Easing f6684b;

    /* renamed from: c  reason: collision with root package name */
    public int f6685c = 0;

    /* renamed from: d  reason: collision with root package name */
    public float f6686d;

    /* renamed from: e  reason: collision with root package name */
    public float f6687e;

    /* renamed from: f  reason: collision with root package name */
    public float f6688f;

    /* renamed from: g  reason: collision with root package name */
    public float f6689g;

    /* renamed from: h  reason: collision with root package name */
    public float f6690h;

    /* renamed from: i  reason: collision with root package name */
    public float f6691i;

    /* renamed from: j  reason: collision with root package name */
    public float f6692j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    public float f6693k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    public int f6694l = -1;

    /* renamed from: m  reason: collision with root package name */
    public int f6695m = -1;

    /* renamed from: n  reason: collision with root package name */
    public float f6696n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    public b f6697o = null;

    /* renamed from: p  reason: collision with root package name */
    public HashMap<String, a> f6698p = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    public int f6699q = 0;

    /* renamed from: r  reason: collision with root package name */
    public int f6700r;

    /* renamed from: s  reason: collision with root package name */
    public double[] f6701s = new double[18];

    /* renamed from: t  reason: collision with root package name */
    public double[] f6702t = new double[18];

    public void a(MotionWidget motionWidget) {
        this.f6684b = Easing.c(motionWidget.f6704b.f6708c);
        MotionWidget.Motion motion = motionWidget.f6704b;
        this.f6694l = motion.f6709d;
        this.f6695m = motion.f6706a;
        this.f6692j = motion.f6713h;
        this.f6685c = motion.f6710e;
        this.f6700r = motion.f6707b;
        this.f6693k = motionWidget.f6705c.f6722d;
        this.f6696n = 0.0f;
        for (String next : motionWidget.c()) {
            a b11 = motionWidget.b(next);
            if (b11 != null && b11.b()) {
                this.f6698p.put(next, b11);
            }
        }
    }

    /* renamed from: b */
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.f6687e, motionPaths.f6687e);
    }

    public void c(float f11, float f12, float f13, float f14) {
        this.f6688f = f11;
        this.f6689g = f12;
        this.f6690h = f13;
        this.f6691i = f14;
    }
}
