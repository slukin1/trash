package com.iproov.sdk.p015goto;

/* renamed from: com.iproov.sdk.goto.if  reason: invalid class name and invalid package */
public enum Cif {
    NO_FACE_PATH("no_face_path", false),
    FACE_PATH("face_path", false),
    END_FACE_PATH("end_face_path", false, true),
    TOO_FAR_FACE_PATH("too_far_face_path"),
    TOO_CLOSE_FACE_PATH("too_close_face_path"),
    NO_FACE("no_face", false),
    TOO_FAR("face_too_small"),
    TOO_CLOSE("face_too_big"),
    TOO_BRIGHT("too_bright"),
    ROLL_TOO_HIGH("roll_too_high"),
    ROLL_TOO_LOW("roll_too_low"),
    YAW_TOO_HIGH("yaw_too_high"),
    YAW_TOO_LOW("yaw_too_low"),
    PITCH_TOO_HIGH("pitch_too_high"),
    PITCH_TOO_LOW("pitch_too_low"),
    READY("ready");
    

    /* renamed from: do  reason: not valid java name */
    private String f589do;

    private Cif(String str) {
        this.f589do = str;
    }

    /* renamed from: do  reason: not valid java name */
    public String m692do() {
        return this.f589do;
    }

    private Cif(String str, boolean z11) {
        this.f589do = str;
    }

    private Cif(String str, boolean z11, boolean z12) {
        this.f589do = str;
    }
}
