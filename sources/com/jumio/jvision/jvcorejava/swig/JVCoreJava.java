package com.jumio.jvision.jvcorejava.swig;

public class JVCoreJava {
    public static long channelsCount(ImageFormat imageFormat) {
        return JVCoreJavaJNI.channelsCount(imageFormat.swigValue());
    }
}
