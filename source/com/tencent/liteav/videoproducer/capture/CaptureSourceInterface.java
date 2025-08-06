package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.util.Locale;

@JNINamespace("liteav::video")
public abstract class CaptureSourceInterface {
    private static final String TAG = "CaptureSourceInterface";

    public static class CaptureParams {

        /* renamed from: b  reason: collision with root package name */
        public int f22524b;

        /* renamed from: c  reason: collision with root package name */
        public int f22525c;

        /* renamed from: d  reason: collision with root package name */
        public int f22526d;

        public boolean equals(Object obj) {
            if (!(obj instanceof CaptureParams)) {
                return false;
            }
            CaptureParams captureParams = (CaptureParams) obj;
            if (this.f22524b == captureParams.f22524b && this.f22525c == captureParams.f22525c && this.f22526d == captureParams.f22526d) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format(Locale.ENGLISH, "size: %dx%d, fps: %d", new Object[]{Integer.valueOf(this.f22525c), Integer.valueOf(this.f22526d), Integer.valueOf(this.f22524b)});
        }
    }

    public interface CaptureSourceListener {
    }

    public abstract void pause();

    public abstract void resume();

    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
    }

    public abstract void start(Object obj, CaptureParams captureParams, CaptureSourceListener captureSourceListener);

    public abstract void stop();

    public abstract void updateParams(CaptureParams captureParams);
}
