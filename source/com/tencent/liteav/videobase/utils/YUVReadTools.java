package com.tencent.liteav.videobase.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
public class YUVReadTools {
    public static native void nativeReadYUVPlanesForByteArray(int i11, int i12, byte[] bArr);

    public static native void nativeReadYUVPlanesForByteBuffer(int i11, int i12, ByteBuffer byteBuffer);
}
