package com.jumio.ale.swig;

public class ALESettings {

    /* renamed from: a  reason: collision with root package name */
    public transient long f38908a;
    public transient boolean swigCMemOwn;

    public ALESettings(long j11, boolean z11) {
        this.swigCMemOwn = z11;
        this.f38908a = j11;
    }

    public static long getCPtr(ALESettings aLESettings) {
        if (aLESettings == null) {
            return 0;
        }
        return aLESettings.f38908a;
    }

    public synchronized void delete() {
        long j11 = this.f38908a;
        if (j11 != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALESettings(j11);
            }
            this.f38908a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public String getDirectory() {
        return aleEngineJNI.ALESettings_getDirectory(this.f38908a, this);
    }

    public String getKeyID() {
        return aleEngineJNI.ALESettings_getKeyID(this.f38908a, this);
    }

    public String getPublicKey() {
        return aleEngineJNI.ALESettings_getPublicKey(this.f38908a, this);
    }

    public void setDirectory(String str) {
        aleEngineJNI.ALESettings_setDirectory(this.f38908a, this, str);
    }

    public void setKeyID(String str) {
        aleEngineJNI.ALESettings_setKeyID(this.f38908a, this, str);
    }

    public void setPublicKey(String str) {
        aleEngineJNI.ALESettings_setPublicKey(this.f38908a, this, str);
    }

    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        aleEngineJNI.ALESettings_change_ownership(this, this.f38908a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        aleEngineJNI.ALESettings_change_ownership(this, this.f38908a, true);
    }

    public ALESettings() {
        this(aleEngineJNI.new_ALESettings(), true);
        aleEngineJNI.ALESettings_director_connect(this, this.f38908a, true, true);
    }
}
