package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;

public class h extends g {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final OutputConfiguration f16264a;

        /* renamed from: b  reason: collision with root package name */
        public String f16265b;

        /* renamed from: c  reason: collision with root package name */
        public long f16266c = 1;

        public a(OutputConfiguration outputConfiguration) {
            this.f16264a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Objects.equals(this.f16264a, aVar.f16264a) || this.f16266c != aVar.f16266c || !Objects.equals(this.f16265b, aVar.f16265b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.f16264a.hashCode() ^ 31;
            int i11 = (hashCode << 5) - hashCode;
            String str = this.f16265b;
            int hashCode2 = (str == null ? 0 : str.hashCode()) ^ i11;
            return com.fluttercandies.photo_manager.core.entity.a.a(this.f16266c) ^ ((hashCode2 << 5) - hashCode2);
        }
    }

    public h(int i11, Surface surface) {
        this(new a(new OutputConfiguration(i11, surface)));
    }

    public static h j(OutputConfiguration outputConfiguration) {
        return new h(new a(outputConfiguration));
    }

    public void a(Surface surface) {
        ((OutputConfiguration) g()).addSurface(surface);
    }

    public String b() {
        return ((a) this.f16269a).f16265b;
    }

    public void c() {
        ((OutputConfiguration) g()).enableSurfaceSharing();
    }

    public void e(long j11) {
        ((a) this.f16269a).f16266c = j11;
    }

    public void f(String str) {
        ((a) this.f16269a).f16265b = str;
    }

    public Object g() {
        androidx.core.util.h.a(this.f16269a instanceof a);
        return ((a) this.f16269a).f16264a;
    }

    public final boolean h() {
        throw new AssertionError("isSurfaceSharingEnabled() should not be called on API >= 26");
    }

    public h(Object obj) {
        super(obj);
    }
}
