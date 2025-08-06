package b0;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.config.d;
import androidx.camera.video.internal.encoder.i1;
import androidx.camera.video.w1;
import androidx.core.util.j;
import java.util.Objects;

public class g implements j<i1> {

    /* renamed from: a  reason: collision with root package name */
    public final String f12277a;

    /* renamed from: b  reason: collision with root package name */
    public final Timebase f12278b;

    /* renamed from: c  reason: collision with root package name */
    public final w1 f12279c;

    /* renamed from: d  reason: collision with root package name */
    public final Size f12280d;

    /* renamed from: e  reason: collision with root package name */
    public final EncoderProfilesProxy.VideoProfileProxy f12281e;

    /* renamed from: f  reason: collision with root package name */
    public final DynamicRange f12282f;

    /* renamed from: g  reason: collision with root package name */
    public final Range<Integer> f12283g;

    public g(String str, Timebase timebase, w1 w1Var, Size size, EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, DynamicRange dynamicRange, Range<Integer> range) {
        this.f12277a = str;
        this.f12278b = timebase;
        this.f12279c = w1Var;
        this.f12280d = size;
        this.f12281e = videoProfileProxy;
        this.f12282f = dynamicRange;
        this.f12283g = range;
    }

    /* renamed from: a */
    public i1 get() {
        int b11 = b();
        Logger.d("VidEncVdPrflRslvr", "Resolved VIDEO frame rate: " + b11 + "fps");
        Range<Integer> c11 = this.f12279c.c();
        Logger.d("VidEncVdPrflRslvr", "Using resolved VIDEO bitrate from EncoderProfiles");
        int e11 = d.e(this.f12281e.getBitrate(), this.f12282f.getBitDepth(), this.f12281e.getBitDepth(), b11, this.f12281e.getFrameRate(), this.f12280d.getWidth(), this.f12281e.getWidth(), this.f12280d.getHeight(), this.f12281e.getHeight(), c11);
        int profile = this.f12281e.getProfile();
        return i1.c().h(this.f12277a).g(this.f12278b).j(this.f12280d).b(e11).e(b11).i(profile).d(d.b(this.f12277a, profile)).a();
    }

    public final int b() {
        int frameRate = this.f12281e.getFrameRate();
        Range<Integer> range = this.f12283g;
        Range<Integer> range2 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        int intValue = !Objects.equals(range, range2) ? this.f12283g.clamp(Integer.valueOf(frameRate)).intValue() : frameRate;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(intValue);
        objArr[1] = Integer.valueOf(frameRate);
        objArr[2] = Objects.equals(this.f12283g, range2) ? this.f12283g : "<UNSPECIFIED>";
        Logger.d("VidEncVdPrflRslvr", String.format("Resolved frame rate %dfps [Video profile frame rate: %dfps, Expected operating range: %s]", objArr));
        return intValue;
    }
}
