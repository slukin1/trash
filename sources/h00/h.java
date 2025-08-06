package h00;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Objects;

public final class h<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final h<Object> f54899b = new h<>((Object) null);

    /* renamed from: a  reason: collision with root package name */
    public final Object f54900a;

    public h(Object obj) {
        this.f54900a = obj;
    }

    public static <T> h<T> a() {
        return f54899b;
    }

    public static <T> h<T> b(Throwable th2) {
        Objects.requireNonNull(th2, "error is null");
        return new h<>(NotificationLite.error(th2));
    }

    public static <T> h<T> c(T t11) {
        Objects.requireNonNull(t11, "value is null");
        return new h<>(t11);
    }

    public Throwable d() {
        Object obj = this.f54900a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public boolean e() {
        return NotificationLite.isError(this.f54900a);
    }

    public boolean equals(Object obj) {
        if (obj instanceof h) {
            return Objects.equals(this.f54900a, ((h) obj).f54900a);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f54900a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f54900a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f54900a + "]";
    }
}
