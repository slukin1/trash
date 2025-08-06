package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.h;
import java.util.Objects;

public class i extends h {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final OutputConfiguration f16267a;

        /* renamed from: b  reason: collision with root package name */
        public long f16268b = 1;

        public a(OutputConfiguration outputConfiguration) {
            this.f16267a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Objects.equals(this.f16267a, aVar.f16267a) || this.f16268b != aVar.f16268b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.f16267a.hashCode() ^ 31;
            return com.fluttercandies.photo_manager.core.entity.a.a(this.f16268b) ^ ((hashCode << 5) - hashCode);
        }
    }

    public i(int i11, Surface surface) {
        this(new a(new OutputConfiguration(i11, surface)));
    }

    public static i k(OutputConfiguration outputConfiguration) {
        return new i(new a(outputConfiguration));
    }

    public String b() {
        return null;
    }

    public void e(long j11) {
        ((a) this.f16269a).f16268b = j11;
    }

    public void f(String str) {
        ((OutputConfiguration) g()).setPhysicalCameraId(str);
    }

    public Object g() {
        h.a(this.f16269a instanceof a);
        return ((a) this.f16269a).f16267a;
    }

    public i(Object obj) {
        super(obj);
    }
}
