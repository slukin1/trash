package o;

import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;
import java.util.HashMap;
import java.util.Map;
import r.i;

public class r0 {

    /* renamed from: a  reason: collision with root package name */
    public final a f16206a;

    /* renamed from: b  reason: collision with root package name */
    public final i f16207b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Integer, Size[]> f16208c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, Size[]> f16209d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final Map<Class<?>, Size[]> f16210e = new HashMap();

    public interface a {
        StreamConfigurationMap a();

        Size[] b(int i11);

        Size[] c(int i11);
    }

    public r0(StreamConfigurationMap streamConfigurationMap, i iVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f16206a = new s0(streamConfigurationMap);
        } else {
            this.f16206a = new t0(streamConfigurationMap);
        }
        this.f16207b = iVar;
    }

    public static r0 d(StreamConfigurationMap streamConfigurationMap, i iVar) {
        return new r0(streamConfigurationMap, iVar);
    }

    public Size[] a(int i11) {
        if (!this.f16209d.containsKey(Integer.valueOf(i11))) {
            Size[] c11 = this.f16206a.c(i11);
            if (c11 != null && c11.length > 0) {
                c11 = this.f16207b.b(c11, i11);
            }
            this.f16209d.put(Integer.valueOf(i11), c11);
            if (c11 != null) {
                return (Size[]) c11.clone();
            }
            return null;
        } else if (this.f16209d.get(Integer.valueOf(i11)) == null) {
            return null;
        } else {
            return (Size[]) this.f16209d.get(Integer.valueOf(i11)).clone();
        }
    }

    public Size[] b(int i11) {
        if (!this.f16208c.containsKey(Integer.valueOf(i11))) {
            Size[] b11 = this.f16206a.b(i11);
            if (b11 == null || b11.length == 0) {
                Logger.w("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i11);
                return b11;
            }
            Size[] b12 = this.f16207b.b(b11, i11);
            this.f16208c.put(Integer.valueOf(i11), b12);
            return (Size[]) b12.clone();
        } else if (this.f16208c.get(Integer.valueOf(i11)) == null) {
            return null;
        } else {
            return (Size[]) this.f16208c.get(Integer.valueOf(i11)).clone();
        }
    }

    public StreamConfigurationMap c() {
        return this.f16206a.a();
    }
}
