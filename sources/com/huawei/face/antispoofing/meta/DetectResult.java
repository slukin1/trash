package com.huawei.face.antispoofing.meta;

import a.a;
import java.io.Serializable;

public class DetectResult implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f37564a;

    /* renamed from: b  reason: collision with root package name */
    private DetectErrorEnum f37565b;

    /* renamed from: c  reason: collision with root package name */
    private String f37566c;

    /* renamed from: d  reason: collision with root package name */
    private String f37567d;

    private DetectResult(boolean z11, DetectErrorEnum detectErrorEnum, String str, String str2) {
        this.f37564a = z11;
        this.f37565b = detectErrorEnum;
        this.f37566c = str;
        this.f37567d = str2;
    }

    public static DetectResult failed(DetectErrorEnum detectErrorEnum) {
        return new DetectResult(false, detectErrorEnum, (String) null, (String) null);
    }

    public static DetectResult success(String str) {
        return new DetectResult(true, (DetectErrorEnum) null, (String) null, str);
    }

    public String getData() {
        return this.f37567d;
    }

    public DetectErrorEnum getDetectError() {
        return this.f37565b;
    }

    public String getErrorMsg() {
        return this.f37566c;
    }

    public boolean isDetected() {
        return this.f37564a;
    }

    public String toString() {
        StringBuilder c11 = a.c("detected=");
        c11.append(this.f37564a);
        c11.append(", detectError=");
        c11.append(this.f37565b);
        c11.append(", errorMsg='");
        c11.append(this.f37566c);
        c11.append(", data='");
        c11.append(this.f37567d);
        return c11.toString();
    }

    public static DetectResult failed(DetectErrorEnum detectErrorEnum, String str) {
        return new DetectResult(false, detectErrorEnum, str, (String) null);
    }

    public DetectResult() {
    }
}
