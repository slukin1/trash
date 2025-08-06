package com.huawei.face.antispoofing.jni;

public class DetectorJNI {
    public long detectorObject = 0;

    static {
        System.loadLibrary("FaceAntispoofing");
    }

    public static native boolean init(Object obj, String str);

    public native synchronized void createAndSetModelPath(String str, String str2, String str3) throws Exception;

    public native synchronized void delete() throws Exception;

    public native void getFaceImage(long j11) throws Exception;

    public native String getResult() throws Exception;

    public native int runDetect(byte[] bArr, int i11, int i12, int i13) throws Exception;
}
