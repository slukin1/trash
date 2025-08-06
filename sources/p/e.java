package p;

import android.hardware.camera2.params.InputConfiguration;
import android.os.Build;
import java.util.Objects;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final c f16257a;

    public static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final InputConfiguration f16258a;

        public a(Object obj) {
            this.f16258a = (InputConfiguration) obj;
        }

        public Object a() {
            return this.f16258a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            return Objects.equals(this.f16258a, ((c) obj).a());
        }

        public int hashCode() {
            return this.f16258a.hashCode();
        }

        public String toString() {
            return this.f16258a.toString();
        }
    }

    public static final class b extends a {
        public b(Object obj) {
            super(obj);
        }
    }

    public interface c {
        Object a();
    }

    public e(c cVar) {
        this.f16257a = cVar;
    }

    public static e b(Object obj) {
        int i11;
        if (obj == null || (i11 = Build.VERSION.SDK_INT) < 23) {
            return null;
        }
        if (i11 >= 31) {
            return new e(new b(obj));
        }
        return new e(new a(obj));
    }

    public Object a() {
        return this.f16257a.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f16257a.equals(((e) obj).f16257a);
    }

    public int hashCode() {
        return this.f16257a.hashCode();
    }

    public String toString() {
        return this.f16257a.toString();
    }
}
