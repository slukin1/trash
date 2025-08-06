package com.iproov.sdk.cameray;

/* renamed from: com.iproov.sdk.cameray.catch  reason: invalid class name */
public enum Ccatch {
    CAMERA1(Cconst.CAMERA1),
    CAMERA2_LEGACY(r2),
    CAMERA2_EXTERNAL(r2),
    CAMERA2_LIMITED(r2),
    CAMERA2_FULL(r2),
    CAMERA2_LEVEL3(r2);

    private Ccatch(Cconst constR) {
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m94do(Ccatch catchR) {
        return compareTo(catchR) >= 0;
    }
}
