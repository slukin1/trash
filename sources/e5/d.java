package e5;

import com.github.mikephil.charting.components.YAxis;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public float f66227a;

    /* renamed from: b  reason: collision with root package name */
    public float f66228b;

    /* renamed from: c  reason: collision with root package name */
    public float f66229c;

    /* renamed from: d  reason: collision with root package name */
    public float f66230d;

    /* renamed from: e  reason: collision with root package name */
    public int f66231e;

    /* renamed from: f  reason: collision with root package name */
    public int f66232f;

    /* renamed from: g  reason: collision with root package name */
    public int f66233g;

    /* renamed from: h  reason: collision with root package name */
    public YAxis.AxisDependency f66234h;

    /* renamed from: i  reason: collision with root package name */
    public float f66235i;

    /* renamed from: j  reason: collision with root package name */
    public float f66236j;

    public d(float f11, float f12, float f13, float f14, int i11, YAxis.AxisDependency axisDependency) {
        this.f66227a = Float.NaN;
        this.f66228b = Float.NaN;
        this.f66231e = -1;
        this.f66233g = -1;
        this.f66227a = f11;
        this.f66228b = f12;
        this.f66229c = f13;
        this.f66230d = f14;
        this.f66232f = i11;
        this.f66234h = axisDependency;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f66232f == dVar.f66232f && this.f66227a == dVar.f66227a && this.f66233g == dVar.f66233g && this.f66231e == dVar.f66231e;
    }

    public YAxis.AxisDependency b() {
        return this.f66234h;
    }

    public int c() {
        return this.f66231e;
    }

    public int d() {
        return this.f66232f;
    }

    public float e() {
        return this.f66235i;
    }

    public float f() {
        return this.f66236j;
    }

    public int g() {
        return this.f66233g;
    }

    public float h() {
        return this.f66227a;
    }

    public float i() {
        return this.f66229c;
    }

    public float j() {
        return this.f66228b;
    }

    public float k() {
        return this.f66230d;
    }

    public void l(int i11) {
        this.f66231e = i11;
    }

    public void m(float f11, float f12) {
        this.f66235i = f11;
        this.f66236j = f12;
    }

    public String toString() {
        return "Highlight, x: " + this.f66227a + ", y: " + this.f66228b + ", dataSetIndex: " + this.f66232f + ", stackIndex (only stacked barentry): " + this.f66233g;
    }

    public d(float f11, float f12, float f13, float f14, int i11, int i12, YAxis.AxisDependency axisDependency) {
        this(f11, f12, f13, f14, i11, axisDependency);
        this.f66233g = i12;
    }
}
