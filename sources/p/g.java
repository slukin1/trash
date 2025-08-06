package p;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.core.util.h;
import java.util.Objects;

public class g extends k {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final OutputConfiguration f16260a;

        /* renamed from: b  reason: collision with root package name */
        public String f16261b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f16262c;

        /* renamed from: d  reason: collision with root package name */
        public long f16263d = 1;

        public a(OutputConfiguration outputConfiguration) {
            this.f16260a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!Objects.equals(this.f16260a, aVar.f16260a) || this.f16262c != aVar.f16262c || this.f16263d != aVar.f16263d || !Objects.equals(this.f16261b, aVar.f16261b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.f16260a.hashCode() ^ 31;
            boolean z11 = this.f16262c ^ ((hashCode << 5) - hashCode);
            int i11 = ((z11 ? 1 : 0) << true) - z11;
            String str = this.f16261b;
            int hashCode2 = (str == null ? 0 : str.hashCode()) ^ i11;
            return com.fluttercandies.photo_manager.core.entity.a.a(this.f16263d) ^ ((hashCode2 << 5) - hashCode2);
        }
    }

    public g(int i11, Surface surface) {
        this(new a(new OutputConfiguration(i11, surface)));
    }

    public static g i(OutputConfiguration outputConfiguration) {
        return new g(new a(outputConfiguration));
    }

    public String b() {
        return ((a) this.f16269a).f16261b;
    }

    public void c() {
        ((a) this.f16269a).f16262c = true;
    }

    public void e(long j11) {
        ((a) this.f16269a).f16263d = j11;
    }

    public void f(String str) {
        ((a) this.f16269a).f16261b = str;
    }

    public Object g() {
        h.a(this.f16269a instanceof a);
        return ((a) this.f16269a).f16260a;
    }

    public Surface getSurface() {
        return ((OutputConfiguration) g()).getSurface();
    }

    public boolean h() {
        return ((a) this.f16269a).f16262c;
    }

    public g(Object obj) {
        super(obj);
    }
}
