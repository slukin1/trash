package com.jumio.ale.swig;

public class ALEHeader {

    /* renamed from: a  reason: collision with root package name */
    public transient long f38894a;
    public transient boolean swigCMemOwn;

    public ALEHeader(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f38894a = j11;
    }

    public static long getCPtr(ALEHeader aLEHeader) {
        if (aLEHeader == null) {
            return 0;
        }
        return aLEHeader.f38894a;
    }

    public void add(String str, String str2) {
        aleEngineJNI.ALEHeader_add__SWIG_0(this.f38894a, this, str, str2);
    }

    public void clear() {
        aleEngineJNI.ALEHeader_clear(this.f38894a, this);
    }

    public synchronized void delete() {
        long j11 = this.f38894a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALEHeader(j11);
            }
            this.f38894a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public ALEHeader() {
        this(aleEngineJNI.new_ALEHeader(), true);
    }
}
