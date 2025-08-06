package com.iproov.sdk;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

/* renamed from: com.iproov.sdk.for  reason: invalid class name */
public enum Cfor {
    f560for("unknown", R.string.iproov__failure_unknown),
    TOO_MUCH_MOVEMENT("too_much_movement", R.string.iproov__failure_too_much_movement),
    TOO_BRIGHT("too_bright", R.string.iproov__failure_too_bright),
    TOO_DARK("too_dark", R.string.iproov__failure_too_dark),
    MISALIGNED_FACE("misaligned_face", R.string.iproov__failure_misaligned_face),
    EYES_CLOSED("eyes_closed", R.string.iproov__failure_eyes_closed),
    FACE_TOO_FAR("face_too_far", R.string.iproov__failure_face_too_far),
    FACE_TOO_CLOSE("face_too_close", R.string.iproov__failure_face_too_close),
    SUNGLASSES("sunglasses", R.string.iproov__failure_sunglasses),
    OBSCURED_FACE("obscured_face", R.string.iproov__failure_obscured_face),
    USER_TIMEOUT("user_timeout", R.string.iproov__failure_user_timeout),
    NOT_SUPPORTED("not_supported", R.string.iproov__failure_not_supported);
    

    /* renamed from: if  reason: not valid java name */
    public static final Cdo f562if = null;

    /* renamed from: do  reason: not valid java name */
    private final String f567do;

    /* renamed from: com.iproov.sdk.for$do  reason: invalid class name */
    public static final class Cdo {
        private Cdo() {
        }

        public /* synthetic */ Cdo(r rVar) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public final Cfor m686do(String str) {
            Cfor forR;
            Cfor[] values = Cfor.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    forR = null;
                    break;
                }
                forR = values[i11];
                if (x.b(forR.m685if(), str)) {
                    break;
                }
                i11++;
            }
            return forR == null ? Cfor.f560for : forR;
        }
    }

    /* access modifiers changed from: public */
    static {
        f562if = new Cdo((r) null);
    }

    private Cfor(String str, int i11) {
        this.f567do = str;
    }

    /* renamed from: if  reason: not valid java name */
    public final String m685if() {
        return this.f567do;
    }
}
