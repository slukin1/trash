package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import java.util.Objects;

public class l1 extends c1 implements k1 {

    /* renamed from: c  reason: collision with root package name */
    public final MediaCodecInfo.VideoCapabilities f6242c;

    public l1(MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.f6176b.getVideoCapabilities();
        Objects.requireNonNull(videoCapabilities);
        MediaCodecInfo.VideoCapabilities videoCapabilities2 = videoCapabilities;
        this.f6242c = videoCapabilities;
    }

    public static l1 j(i1 i1Var) throws InvalidConfigException {
        return new l1(c1.i(i1Var), i1Var.getMimeType());
    }

    public static IllegalArgumentException k(Throwable th2) {
        if (th2 instanceof IllegalArgumentException) {
            return (IllegalArgumentException) th2;
        }
        return new IllegalArgumentException(th2);
    }

    public Range<Integer> a(int i11) {
        try {
            return this.f6242c.getSupportedWidthsFor(i11);
        } catch (Throwable th2) {
            throw k(th2);
        }
    }

    public Range<Integer> b() {
        return this.f6242c.getBitrateRange();
    }

    public Range<Integer> c(int i11) {
        try {
            return this.f6242c.getSupportedHeightsFor(i11);
        } catch (Throwable th2) {
            throw k(th2);
        }
    }

    public Range<Integer> d() {
        return this.f6242c.getSupportedWidths();
    }

    public Range<Integer> e() {
        return this.f6242c.getSupportedHeights();
    }

    public int f() {
        return this.f6242c.getHeightAlignment();
    }

    public boolean g(int i11, int i12) {
        return this.f6242c.isSizeSupported(i11, i12);
    }

    public int h() {
        return this.f6242c.getWidthAlignment();
    }
}
