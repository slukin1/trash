package p;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.core.util.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p.f;

public class k implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final Object f16269a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<Surface> f16270a;

        /* renamed from: b  reason: collision with root package name */
        public final Size f16271b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16272c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16273d;

        /* renamed from: e  reason: collision with root package name */
        public String f16274e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16275f = false;

        /* renamed from: g  reason: collision with root package name */
        public long f16276g = 1;

        public a(Surface surface) {
            h.h(surface, "Surface must not be null");
            this.f16270a = Collections.singletonList(surface);
            this.f16271b = c(surface);
            this.f16272c = a(surface);
            this.f16273d = b(surface);
        }

        @SuppressLint({"BlockedPrivateApi", "BanUncheckedReflection"})
        public static int a(Surface surface) {
            try {
                Method declaredMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("detectSurfaceType", new Class[]{Surface.class});
                if (Build.VERSION.SDK_INT < 22) {
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) declaredMethod.invoke((Object) null, new Object[]{surface})).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                Logger.e("OutputConfigCompat", "Unable to retrieve surface format.", e11);
                return 0;
            }
        }

        @SuppressLint({"SoonBlockedPrivateApi", "BlockedPrivateApi", "BanUncheckedReflection"})
        public static int b(Surface surface) {
            try {
                return ((Integer) Surface.class.getDeclaredMethod("getGenerationId", new Class[0]).invoke(surface, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                Logger.e("OutputConfigCompat", "Unable to retrieve surface generation id.", e11);
                return -1;
            }
        }

        @SuppressLint({"BlockedPrivateApi", "BanUncheckedReflection"})
        public static Size c(Surface surface) {
            try {
                Method declaredMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("getSurfaceSize", new Class[]{Surface.class});
                declaredMethod.setAccessible(true);
                return (Size) declaredMethod.invoke((Object) null, new Object[]{surface});
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                Logger.e("OutputConfigCompat", "Unable to retrieve surface size.", e11);
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f16271b.equals(aVar.f16271b) || this.f16272c != aVar.f16272c || this.f16273d != aVar.f16273d || this.f16275f != aVar.f16275f || this.f16276g != aVar.f16276g || !Objects.equals(this.f16274e, aVar.f16274e)) {
                return false;
            }
            int min = Math.min(this.f16270a.size(), aVar.f16270a.size());
            for (int i11 = 0; i11 < min; i11++) {
                if (this.f16270a.get(i11) != aVar.f16270a.get(i11)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.f16270a.hashCode() ^ 31;
            int i11 = this.f16273d ^ ((hashCode << 5) - hashCode);
            int hashCode2 = this.f16271b.hashCode() ^ ((i11 << 5) - i11);
            int i12 = this.f16272c ^ ((hashCode2 << 5) - hashCode2);
            boolean z11 = this.f16275f ^ ((i12 << 5) - i12);
            int i13 = ((z11 ? 1 : 0) << true) - z11;
            String str = this.f16274e;
            int hashCode3 = (str == null ? 0 : str.hashCode()) ^ i13;
            return com.fluttercandies.photo_manager.core.entity.a.a(this.f16276g) ^ ((hashCode3 << 5) - hashCode3);
        }
    }

    public k(Surface surface) {
        this.f16269a = new a(surface);
    }

    public void a(Surface surface) {
        h.h(surface, "Surface must not be null");
        if (getSurface() == surface) {
            throw new IllegalStateException("Surface is already added!");
        } else if (!h()) {
            throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
        } else {
            throw new IllegalArgumentException("Exceeds maximum number of surfaces");
        }
    }

    public String b() {
        return ((a) this.f16269a).f16274e;
    }

    public void c() {
        ((a) this.f16269a).f16275f = true;
    }

    public void d(long j11) {
    }

    public void e(long j11) {
        ((a) this.f16269a).f16276g = j11;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        return Objects.equals(this.f16269a, ((k) obj).f16269a);
    }

    public void f(String str) {
        ((a) this.f16269a).f16274e = str;
    }

    public Object g() {
        return null;
    }

    public Surface getSurface() {
        List<Surface> list = ((a) this.f16269a).f16270a;
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public boolean h() {
        return ((a) this.f16269a).f16275f;
    }

    public int hashCode() {
        return this.f16269a.hashCode();
    }

    public k(Object obj) {
        this.f16269a = obj;
    }
}
