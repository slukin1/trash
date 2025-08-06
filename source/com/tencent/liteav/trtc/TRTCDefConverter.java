package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::trtc")
public class TRTCDefConverter {
    private static final String TAG = "TRTCDefConverter";
    private static final a sThrottler = new a(TimeUnit.SECONDS.toMillis(1));

    public static long getGLContextNativeHandle(Object obj) {
        return OpenGlUtils.getGLContextNativeHandle(obj);
    }
}
