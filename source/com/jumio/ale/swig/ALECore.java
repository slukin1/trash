package com.jumio.ale.swig;

public class ALECore {

    /* renamed from: a  reason: collision with root package name */
    public transient long f38893a;
    public transient boolean swigCMemOwn;

    public ALECore(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f38893a = j11;
    }

    public static long getCPtr(ALECore aLECore) {
        if (aLECore == null) {
            return 0;
        }
        return aLECore.f38893a;
    }

    public ALERequest createRequest() throws Exception {
        long ALECore_createRequest = aleEngineJNI.ALECore_createRequest(this.f38893a, this);
        if (ALECore_createRequest == 0) {
            return null;
        }
        return new ALERequest(ALECore_createRequest, false);
    }

    public synchronized void delete() {
        long j11 = this.f38893a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALECore(j11);
            }
            this.f38893a = 0;
        }
    }

    public void destroyRequest(ALERequest aLERequest) {
        aleEngineJNI.ALECore_destroyRequest(this.f38893a, this, ALERequest.getCPtr(aLERequest), aLERequest);
    }

    public void finalize() {
        delete();
    }

    public ALECore(ALESettings aLESettings) {
        this(aleEngineJNI.new_ALECore(ALESettings.getCPtr(aLESettings), aLESettings), true);
    }
}
