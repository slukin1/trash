package d0;

import a0.d;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.video.v;
import java.util.HashMap;
import java.util.Map;

public class b implements EncoderProfilesProvider {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Integer, v> f15603d;

    /* renamed from: a  reason: collision with root package name */
    public final EncoderProfilesProvider f15604a;

    /* renamed from: b  reason: collision with root package name */
    public final CameraInfoInternal f15605b;

    /* renamed from: c  reason: collision with root package name */
    public final Quirks f15606c;

    static {
        HashMap hashMap = new HashMap();
        f15603d = hashMap;
        hashMap.put(1, v.f6370f);
        hashMap.put(8, v.f6368d);
        hashMap.put(6, v.f6367c);
        hashMap.put(5, v.f6366b);
        hashMap.put(4, v.f6365a);
        hashMap.put(0, v.f6369e);
    }

    public b(EncoderProfilesProvider encoderProfilesProvider, CameraInfoInternal cameraInfoInternal, Quirks quirks) {
        this.f15604a = encoderProfilesProvider;
        this.f15605b = cameraInfoInternal;
        this.f15606c = quirks;
    }

    public final boolean a(int i11) {
        v vVar = f15603d.get(Integer.valueOf(i11));
        if (vVar == null) {
            return true;
        }
        for (d next : this.f15606c.getAll(d.class)) {
            if (next != null && next.b(this.f15605b, vVar) && !next.a()) {
                return false;
            }
        }
        return true;
    }

    public EncoderProfilesProxy getAll(int i11) {
        if (!hasProfile(i11)) {
            return null;
        }
        return this.f15604a.getAll(i11);
    }

    public boolean hasProfile(int i11) {
        return this.f15604a.hasProfile(i11) && a(i11);
    }
}
