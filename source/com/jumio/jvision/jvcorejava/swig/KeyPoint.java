package com.jumio.jvision.jvcorejava.swig;

public class KeyPoint {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21260a;
    public transient boolean swigCMemOwn;

    public KeyPoint(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21260a = j11;
    }

    public static long getCPtr(KeyPoint keyPoint) {
        if (keyPoint == null) {
            return 0;
        }
        return keyPoint.f21260a;
    }

    public synchronized void delete() {
        long j11 = this.f21260a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_KeyPoint(j11);
            }
            this.f21260a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public float getAngle() {
        return JVCoreJavaJNI.KeyPoint_angle_get(this.f21260a, this);
    }

    public int getClass_id() {
        return JVCoreJavaJNI.KeyPoint_class_id_get(this.f21260a, this);
    }

    public int getOctave() {
        return JVCoreJavaJNI.KeyPoint_octave_get(this.f21260a, this);
    }

    public Point2f getPt() {
        long KeyPoint_pt_get = JVCoreJavaJNI.KeyPoint_pt_get(this.f21260a, this);
        if (KeyPoint_pt_get == 0) {
            return null;
        }
        return new Point2f(KeyPoint_pt_get, false);
    }

    public float getResponse() {
        return JVCoreJavaJNI.KeyPoint_response_get(this.f21260a, this);
    }

    public float getSize() {
        return JVCoreJavaJNI.KeyPoint_size_get(this.f21260a, this);
    }

    public void setAngle(float f11) {
        JVCoreJavaJNI.KeyPoint_angle_set(this.f21260a, this, f11);
    }

    public void setClass_id(int i11) {
        JVCoreJavaJNI.KeyPoint_class_id_set(this.f21260a, this, i11);
    }

    public void setOctave(int i11) {
        JVCoreJavaJNI.KeyPoint_octave_set(this.f21260a, this, i11);
    }

    public void setPt(Point2f point2f) {
        JVCoreJavaJNI.KeyPoint_pt_set(this.f21260a, this, Point2f.getCPtr(point2f), point2f);
    }

    public void setResponse(float f11) {
        JVCoreJavaJNI.KeyPoint_response_set(this.f21260a, this, f11);
    }

    public void setSize(float f11) {
        JVCoreJavaJNI.KeyPoint_size_set(this.f21260a, this, f11);
    }

    public KeyPoint() {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_0(), true);
    }

    public KeyPoint(Point2f point2f, float f11, float f12, float f13, int i11, int i12) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_1(Point2f.getCPtr(point2f), point2f, f11, f12, f13, i11, i12), true);
    }

    public KeyPoint(Point2f point2f, float f11, float f12, float f13, int i11) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_2(Point2f.getCPtr(point2f), point2f, f11, f12, f13, i11), true);
    }

    public KeyPoint(Point2f point2f, float f11, float f12, float f13) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_3(Point2f.getCPtr(point2f), point2f, f11, f12, f13), true);
    }

    public KeyPoint(Point2f point2f, float f11, float f12) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_4(Point2f.getCPtr(point2f), point2f, f11, f12), true);
    }

    public KeyPoint(Point2f point2f, float f11) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_5(Point2f.getCPtr(point2f), point2f, f11), true);
    }

    public KeyPoint(float f11, float f12, float f13, float f14, float f15, int i11, int i12) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_6(f11, f12, f13, f14, f15, i11, i12), true);
    }

    public KeyPoint(float f11, float f12, float f13, float f14, float f15, int i11) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_7(f11, f12, f13, f14, f15, i11), true);
    }

    public KeyPoint(float f11, float f12, float f13, float f14, float f15) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_8(f11, f12, f13, f14, f15), true);
    }

    public KeyPoint(float f11, float f12, float f13, float f14) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_9(f11, f12, f13, f14), true);
    }

    public KeyPoint(float f11, float f12, float f13) {
        this(JVCoreJavaJNI.new_KeyPoint__SWIG_10(f11, f12, f13), true);
    }
}
