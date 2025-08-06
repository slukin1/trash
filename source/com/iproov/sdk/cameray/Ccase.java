package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.case  reason: invalid class name */
public class Ccase extends Exception {

    /* renamed from: com.iproov.sdk.cameray.case$do  reason: invalid class name */
    public enum Cdo {
        CAMERA_PERMISSION_DENIED,
        CAMERA_ERROR
    }

    public Ccase(Cdo doVar, String str) {
        super(str);
    }

    public Ccase(Cdo doVar, String str, Throwable th2) {
        super(str, th2);
    }

    public Ccase(Cdo doVar, Throwable th2) {
        super(th2);
    }
}
