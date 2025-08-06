package com.jumio.ale.swig;

public class ALERequest {

    /* renamed from: a  reason: collision with root package name */
    public transient long f38907a;
    public transient boolean swigCMemOwn;

    public ALERequest(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f38907a = j11;
    }

    public static long getCPtr(ALERequest aLERequest) {
        if (aLERequest == null) {
            return 0;
        }
        return aLERequest.f38907a;
    }

    public int calculateRequestFinish() {
        return aleEngineJNI.ALERequest_calculateRequestFinish(this.f38907a, this);
    }

    public int calculateRequestInit(ALEHeader aLEHeader, int i11) {
        return aleEngineJNI.ALERequest_calculateRequestInit(this.f38907a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i11);
    }

    public int calculateRequestSize(ALEHeader aLEHeader, int i11) {
        return aleEngineJNI.ALERequest_calculateRequestSize(this.f38907a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i11);
    }

    public int calculateRequestUpdate(int i11) {
        return aleEngineJNI.ALERequest_calculateRequestUpdate(this.f38907a, this, i11);
    }

    public int calculateResponseSize(byte[] bArr) throws Exception {
        return aleEngineJNI.ALERequest_calculateResponseSize(this.f38907a, this, bArr);
    }

    public synchronized void delete() {
        if (this.f38907a != 0) {
            if (!this.swigCMemOwn) {
                this.f38907a = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }

    public int finishRequest(byte[] bArr, int i11) throws Exception {
        return aleEngineJNI.ALERequest_finishRequest__SWIG_0(this.f38907a, this, bArr, i11);
    }

    public boolean finishResponse() throws Exception {
        return aleEngineJNI.ALERequest_finishResponse(this.f38907a, this);
    }

    public int getErrorCode() {
        return aleEngineJNI.ALERequest_getErrorCode(this.f38907a, this);
    }

    public int initRequest(ALEHeader aLEHeader, int i11, byte[] bArr, int i12) throws Exception {
        return aleEngineJNI.ALERequest_initRequest__SWIG_0(this.f38907a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i11, bArr, i12);
    }

    public void initResponse() {
        aleEngineJNI.ALERequest_initResponse(this.f38907a, this);
    }

    public boolean isKeyUpdate() {
        return aleEngineJNI.ALERequest_isKeyUpdate(this.f38907a, this);
    }

    public boolean isVerified() {
        return aleEngineJNI.ALERequest_isVerified(this.f38907a, this);
    }

    public int request(ALEHeader aLEHeader, byte[] bArr, byte[] bArr2, int i11) throws Exception {
        return aleEngineJNI.ALERequest_request__SWIG_0(this.f38907a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, bArr, bArr2, i11);
    }

    public int response(byte[] bArr, byte[] bArr2, int i11) throws Exception {
        return aleEngineJNI.ALERequest_response__SWIG_0(this.f38907a, this, bArr, bArr2, i11);
    }

    public int updateRequest(byte[] bArr, byte[] bArr2, int i11) throws Exception {
        return aleEngineJNI.ALERequest_updateRequest__SWIG_0(this.f38907a, this, bArr, bArr2, i11);
    }

    public int updateResponse(byte[] bArr, byte[] bArr2, int i11) throws Exception {
        return aleEngineJNI.ALERequest_updateResponse__SWIG_0(this.f38907a, this, bArr, bArr2, i11);
    }

    public int finishRequest(byte[] bArr) throws Exception {
        return aleEngineJNI.ALERequest_finishRequest__SWIG_1(this.f38907a, this, bArr);
    }

    public int initRequest(ALEHeader aLEHeader, int i11, byte[] bArr) throws Exception {
        return aleEngineJNI.ALERequest_initRequest__SWIG_1(this.f38907a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, i11, bArr);
    }

    public int request(ALEHeader aLEHeader, byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_request__SWIG_1(this.f38907a, this, ALEHeader.getCPtr(aLEHeader), aLEHeader, bArr, bArr2);
    }

    public int response(byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_response__SWIG_1(this.f38907a, this, bArr, bArr2);
    }

    public int updateRequest(byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_updateRequest__SWIG_1(this.f38907a, this, bArr, bArr2);
    }

    public int updateResponse(byte[] bArr, byte[] bArr2) throws Exception {
        return aleEngineJNI.ALERequest_updateResponse__SWIG_1(this.f38907a, this, bArr, bArr2);
    }
}
