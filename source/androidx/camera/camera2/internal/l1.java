package androidx.camera.camera2.internal;

import android.content.Context;
import android.media.CamcorderProfile;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.h;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import o.l0;

public final class l1 implements CameraDeviceSurfaceManager {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, p3> f5182a;

    /* renamed from: b  reason: collision with root package name */
    public final d f5183b;

    public class a implements d {
        public CamcorderProfile a(int i11, int i12) {
            return CamcorderProfile.get(i11, i12);
        }

        public boolean b(int i11, int i12) {
            return CamcorderProfile.hasProfile(i11, i12);
        }
    }

    public l1(Context context, Object obj, Set<String> set) throws CameraUnavailableException {
        this(context, new a(), obj, set);
    }

    public final void a(Context context, l0 l0Var, Set<String> set) throws CameraUnavailableException {
        h.g(context);
        for (String next : set) {
            this.f5182a.put(next, new p3(context, next, l0Var, this.f5183b));
        }
    }

    public Pair<Map<UseCaseConfig<?>, StreamSpec>, Map<AttachedSurfaceInfo, StreamSpec>> getSuggestedStreamSpecs(int i11, String str, List<AttachedSurfaceInfo> list, Map<UseCaseConfig<?>, List<Size>> map) {
        h.b(!map.isEmpty(), "No new use cases to be bound.");
        p3 p3Var = this.f5182a.get(str);
        if (p3Var != null) {
            return p3Var.y(i11, list, map);
        }
        throw new IllegalArgumentException("No such camera id in supported combination list: " + str);
    }

    public SurfaceConfig transformSurfaceConfig(int i11, String str, int i12, Size size) {
        p3 p3Var = this.f5182a.get(str);
        if (p3Var != null) {
            return p3Var.I(i11, i12, size);
        }
        return null;
    }

    public l1(Context context, d dVar, Object obj, Set<String> set) throws CameraUnavailableException {
        l0 l0Var;
        this.f5182a = new HashMap();
        h.g(dVar);
        this.f5183b = dVar;
        if (obj instanceof l0) {
            l0Var = (l0) obj;
        } else {
            l0Var = l0.a(context);
        }
        a(context, l0Var, set);
    }
}
