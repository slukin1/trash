package com.jumio.jvision.jvcorejava.swig;

public class Color {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21250a;
    public transient boolean swigCMemOwn;

    public Color(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21250a = j11;
    }

    public static long getCPtr(Color color) {
        if (color == null) {
            return 0;
        }
        return color.f21250a;
    }

    public synchronized void delete() {
        long j11 = this.f21250a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Color(j11);
            }
            this.f21250a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getA() {
        return JVCoreJavaJNI.Color_getA(this.f21250a, this);
    }

    public int getB() {
        return JVCoreJavaJNI.Color_getB(this.f21250a, this);
    }

    public int getG() {
        return JVCoreJavaJNI.Color_getG(this.f21250a, this);
    }

    public int getR() {
        return JVCoreJavaJNI.Color_getR(this.f21250a, this);
    }

    public void setA(int i11) {
        JVCoreJavaJNI.Color_setA(this.f21250a, this, i11);
    }

    public void setB(int i11) {
        JVCoreJavaJNI.Color_setB(this.f21250a, this, i11);
    }

    public void setG(int i11) {
        JVCoreJavaJNI.Color_setG(this.f21250a, this, i11);
    }

    public void setR(int i11) {
        JVCoreJavaJNI.Color_setR(this.f21250a, this, i11);
    }

    public Color() {
        this(JVCoreJavaJNI.new_Color__SWIG_0(), true);
    }

    public Color(int i11, int i12, int i13, int i14) {
        this(JVCoreJavaJNI.new_Color__SWIG_1(i11, i12, i13, i14), true);
    }
}
