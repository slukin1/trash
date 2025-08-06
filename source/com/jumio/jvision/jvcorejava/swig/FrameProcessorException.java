package com.jumio.jvision.jvcorejava.swig;

public class FrameProcessorException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public transient long f21252a;
    public transient boolean swigCMemOwn;

    public FrameProcessorException(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f21252a = j11;
    }

    public static long getCPtr(FrameProcessorException frameProcessorException) {
        if (frameProcessorException == null) {
            return 0;
        }
        return frameProcessorException.f21252a;
    }

    public synchronized void delete() {
        long j11 = this.f21252a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_FrameProcessorException(j11);
            }
            this.f21252a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public String getMessage() {
        return what();
    }

    public String what() {
        return JVCoreJavaJNI.FrameProcessorException_what(this.f21252a, this);
    }

    public FrameProcessorException(String str) {
        this(JVCoreJavaJNI.new_FrameProcessorException__SWIG_0(str), true);
    }
}
