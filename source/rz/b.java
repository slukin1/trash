package rz;

import java.util.Objects;

public class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final String f60119a;

    public b(String str) {
        this.f60119a = str;
    }

    public static <T> b<T> c(String str) {
        return new b<>(str);
    }

    public T a(c cVar) {
        return cVar.c(this);
    }

    public T b(c cVar, T t11) {
        return cVar.a(this, t11);
    }

    public T d(c cVar) {
        T a11 = a(cVar);
        Objects.requireNonNull(a11, this.f60119a);
        return a11;
    }

    public void e(c cVar, T t11) {
        cVar.b(this, t11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f60119a.equals(((b) obj).f60119a);
    }

    public int hashCode() {
        return this.f60119a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f60119a + '\'' + '}';
    }
}
