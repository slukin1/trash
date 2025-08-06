package com.jumio.liveness;

import android.media.Image;
import java.nio.ByteBuffer;

public class DaClient {
    public static final String ATTR_CAMERA_MATRIX = "camera_matrix";
    public static final String ATTR_DISTANCE = "distance";
    public static final String ATTR_FACE_BRIGHTNESS = "face_brightness";
    public static final String ATTR_FACE_ROI = "face_roi";
    public static final String ATTR_IOD = "iod";
    public static final String ATTR_IS_TRUE = "is_true";
    public static final String ATTR_METADATA = "metadata";
    public static final String ATTR_OFFSET_X = "offset_x";
    public static final String ATTR_OFFSET_Y = "offset_y";
    public static final String ATTR_PITCH = "pitch";
    public static final String ATTR_PSEUDO_PITCH = "pseudo_pitch";
    public static final String ATTR_PSEUDO_YAW = "pseudo_yaw";
    public static final String ATTR_ROLL = "roll";
    public static final String ATTR_SEQUENCE_ID = "sequence_id";
    public static final String ATTR_SERVER_DATA = "server_data";
    public static final String ATTR_SHIFT = "shift";
    public static final String ATTR_TARGET_DEPTH = "target_depth";
    public static final String ATTR_YAW = "yaw";
    public static final String EVENT_CAMERA_INFO = "camera_info";
    public static final String EVENT_FAR_PHOTINUS_END = "far_photinus_end";
    public static final String EVENT_FAR_PHOTINUS_START = "far_photinus_start";
    public static final String EVENT_NEAR_PHOTINUS_END = "near_photinus_end";
    public static final String EVENT_NEAR_PHOTINUS_START = "near_photinus_start";
    public static final String EVENT_PHOTINUS_PATTERN = "photinus_pattern";
    public static final String EVENT_POSE = "pose";
    public static final String EVENT_POSE_READY = "pose_ready";
    public static final String EVENT_POSE_START = "pose_start";
    public static final String EVENT_SERVER_DATA_BLOB = "server_data_blob";
    public static final String EVENT_START_SESSION = "start_session";

    /* renamed from: a  reason: collision with root package name */
    public static boolean f24940a = false;

    private static native void deinit();

    public static void deinitCompat() {
        f24940a = false;
        deinit();
    }

    public static boolean hasStarted() {
        return f24940a;
    }

    private static native boolean init(ByteBuffer byteBuffer, String str, String str2, String str3, IEventHandler iEventHandler);

    public static boolean initCompat(ByteBuffer byteBuffer, String str, String str2, String str3, IEventHandler iEventHandler) {
        f24940a = false;
        return init(byteBuffer, str, str2, str3, iEventHandler);
    }

    public static native boolean isBusy();

    public static native boolean isInitialized();

    public static native void sendAccel(long j11, float f11, float f12, float f13);

    public static native void sendEvent(long j11, String str, String str2, String str3);

    public static native void sendEvent2(long j11, String str, String str2, String str3, String str4, String str5);

    public static native void sendFrame(long j11, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16);

    public static native void sendFrameYUV(long j11, Image image, int i11, int i12, int i13) throws IllegalArgumentException;

    public static native void sendGyro(long j11, float f11, float f12, float f13);

    public static native void setEventHandler(IEventHandler iEventHandler);

    private static native void start();

    public static void startCompat() {
        f24940a = true;
        start();
    }

    private static native void stop();

    public static void stopCompat() {
        f24940a = false;
        stop();
    }
}
