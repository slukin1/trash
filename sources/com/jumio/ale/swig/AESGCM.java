package com.jumio.ale.swig;

public class AESGCM {

    /* renamed from: a  reason: collision with root package name */
    public transient long f38888a;
    public transient boolean swigCMemOwn;

    public AESGCM(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f38888a = j11;
    }

    public static long getCPtr(AESGCM aesgcm) {
        if (aesgcm == null) {
            return 0;
        }
        return aesgcm.f38888a;
    }

    public synchronized void delete() {
        long j11 = this.f38888a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_AESGCM(j11);
            }
            this.f38888a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int finish(byte[] bArr, int i11) throws Exception {
        return aleEngineJNI.AESGCM_finish(this.f38888a, this, bArr, i11);
    }

    public void generateIV() throws Exception {
        aleEngineJNI.AESGCM_generateIV(this.f38888a, this);
    }

    public void generateKey() throws Exception {
        aleEngineJNI.AESGCM_generateKey(this.f38888a, this);
    }

    public void init() {
        aleEngineJNI.AESGCM_init(this.f38888a, this);
    }

    public void reset() throws Exception {
        aleEngineJNI.AESGCM_reset(this.f38888a, this);
    }

    public void setIV(byte[] bArr) throws Exception {
        aleEngineJNI.AESGCM_setIV(this.f38888a, this, bArr);
    }

    public void setKey(byte[] bArr) throws Exception {
        aleEngineJNI.AESGCM_setKey__SWIG_0(this.f38888a, this, bArr);
    }

    public void setMode(int i11) throws Exception {
        aleEngineJNI.AESGCM_setMode(this.f38888a, this, i11);
    }

    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        aleEngineJNI.AESGCM_change_ownership(this, this.f38888a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        aleEngineJNI.AESGCM_change_ownership(this, this.f38888a, true);
    }

    public int update(byte[] bArr, int i11, byte[] bArr2, int i12) throws Exception {
        return aleEngineJNI.AESGCM_update(this.f38888a, this, bArr, i11, bArr2, i12);
    }

    public AESGCM() throws Exception {
        this(aleEngineJNI.new_AESGCM(), true);
        aleEngineJNI.AESGCM_director_connect(this, this.f38888a, true, true);
    }
}
