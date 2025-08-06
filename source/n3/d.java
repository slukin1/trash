package n3;

import f4.h;
import java.security.MessageDigest;

public final class d<T> {

    /* renamed from: e  reason: collision with root package name */
    public static final b<Object> f66508e = new a();

    /* renamed from: a  reason: collision with root package name */
    public final T f66509a;

    /* renamed from: b  reason: collision with root package name */
    public final b<T> f66510b;

    /* renamed from: c  reason: collision with root package name */
    public final String f66511c;

    /* renamed from: d  reason: collision with root package name */
    public volatile byte[] f66512d;

    public class a implements b<Object> {
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    public interface b<T> {
        void a(byte[] bArr, T t11, MessageDigest messageDigest);
    }

    public d(String str, T t11, b<T> bVar) {
        this.f66511c = h.b(str);
        this.f66509a = t11;
        this.f66510b = (b) h.d(bVar);
    }

    public static <T> d<T> a(String str, T t11, b<T> bVar) {
        return new d<>(str, t11, bVar);
    }

    public static <T> b<T> b() {
        return f66508e;
    }

    public static <T> d<T> e(String str) {
        return new d<>(str, (Object) null, b());
    }

    public static <T> d<T> f(String str, T t11) {
        return new d<>(str, t11, b());
    }

    public T c() {
        return this.f66509a;
    }

    public final byte[] d() {
        if (this.f66512d == null) {
            this.f66512d = this.f66511c.getBytes(b.f66506a);
        }
        return this.f66512d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f66511c.equals(((d) obj).f66511c);
        }
        return false;
    }

    public void g(T t11, MessageDigest messageDigest) {
        this.f66510b.a(d(), t11, messageDigest);
    }

    public int hashCode() {
        return this.f66511c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f66511c + '\'' + '}';
    }
}
