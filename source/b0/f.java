package b0;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.config.d;
import androidx.camera.video.internal.encoder.i1;
import androidx.camera.video.w1;
import androidx.core.util.j;
import c0.a;
import java.util.Objects;

public class f implements j<i1> {

    /* renamed from: g  reason: collision with root package name */
    public static final Size f12269g = new Size(1280, 720);

    /* renamed from: h  reason: collision with root package name */
    public static final Range<Integer> f12270h = new Range<>(1, 60);

    /* renamed from: a  reason: collision with root package name */
    public final String f12271a;

    /* renamed from: b  reason: collision with root package name */
    public final Timebase f12272b;

    /* renamed from: c  reason: collision with root package name */
    public final w1 f12273c;

    /* renamed from: d  reason: collision with root package name */
    public final Size f12274d;

    /* renamed from: e  reason: collision with root package name */
    public final DynamicRange f12275e;

    /* renamed from: f  reason: collision with root package name */
    public final Range<Integer> f12276f;

    public f(String str, Timebase timebase, w1 w1Var, Size size, DynamicRange dynamicRange, Range<Integer> range) {
        this.f12271a = str;
        this.f12272b = timebase;
        this.f12273c = w1Var;
        this.f12274d = size;
        this.f12275e = dynamicRange;
        this.f12276f = range;
    }

    /* renamed from: a */
    public i1 get() {
        int b11 = b();
        Logger.d("VidEncCfgDefaultRslvr", "Resolved VIDEO frame rate: " + b11 + "fps");
        Range<Integer> c11 = this.f12273c.c();
        Logger.d("VidEncCfgDefaultRslvr", "Using fallback VIDEO bitrate");
        int bitDepth = this.f12275e.getBitDepth();
        int width = this.f12274d.getWidth();
        Size size = f12269g;
        int e11 = d.e(14000000, bitDepth, 8, b11, 30, width, size.getWidth(), this.f12274d.getHeight(), size.getHeight(), c11);
        int a11 = a.a(this.f12271a, this.f12275e);
        return i1.c().h(this.f12271a).g(this.f12272b).j(this.f12274d).b(e11).e(b11).i(a11).d(d.b(this.f12271a, a11)).a();
    }

    public final int b() {
        Range<Integer> range = this.f12276f;
        Range<Integer> range2 = SurfaceRequest.FRAME_RATE_RANGE_UNSPECIFIED;
        int intValue = !Objects.equals(range, range2) ? f12270h.clamp(this.f12276f.getUpper()).intValue() : 30;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(intValue);
        objArr[1] = Objects.equals(this.f12276f, range2) ? this.f12276f : "<UNSPECIFIED>";
        Logger.d("VidEncCfgDefaultRslvr", String.format("Default resolved frame rate: %dfps. [Expected operating range: %s]", objArr));
        return intValue;
    }
}
