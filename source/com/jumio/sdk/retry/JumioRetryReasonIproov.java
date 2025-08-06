package com.jumio.sdk.retry;

public final class JumioRetryReasonIproov {
    public static final int CAMERA = 200;
    public static final int CAMERA_PERMISSION = 201;
    public static final int CAPTURE_ALREADY_ACTIVE = 202;
    public static final int DEVICE_NOT_SUPPORTED = 111;
    public static final int EYES_CLOSED = 105;
    public static final int FACE_DETECTOR = 207;
    public static final int FACE_TOO_CLOSE = 107;
    public static final int FACE_TOO_FAR = 106;
    public static final int GENERIC_ERROR = 209;
    public static final JumioRetryReasonIproov INSTANCE = new JumioRetryReasonIproov();
    public static final int LIGHTING_TOO_BRIGHT = 102;
    public static final int LIGHTING_TOO_DARK = 103;
    public static final int MISALIGNED_FACE = 104;
    public static final int MULTI_WINDOW = 208;
    public static final int NETWORK = 205;
    public static final int OBSCURED_FACE = 109;
    public static final int SERVER = 204;
    public static final int SUNGLASSES = 108;
    public static final int TOO_MUCH_MOVEMENT = 101;
    public static final int UNEXPECTED_ERROR = 203;
    public static final int UNKNOWN = 100;
    public static final int UNSUPPORTED_DEVICE = 206;
    public static final int USER_TIMEOUT = 110;

    private JumioRetryReasonIproov() {
    }
}
