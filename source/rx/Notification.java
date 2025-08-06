package rx;

public final class Notification<T> {
    private static final Notification<Void> ON_COMPLETED = new Notification<>(Kind.OnCompleted, (Object) null, (Throwable) null);
    private final Kind kind;
    private final Throwable throwable;
    private final T value;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    private Notification(Kind kind2, T t11, Throwable th2) {
        this.value = t11;
        this.throwable = th2;
        this.kind = kind2;
    }

    public static <T> Notification<T> createOnCompleted() {
        return ON_COMPLETED;
    }

    public static <T> Notification<T> createOnError(Throwable th2) {
        return new Notification<>(Kind.OnError, (Object) null, th2);
    }

    public static <T> Notification<T> createOnNext(T t11) {
        return new Notification<>(Kind.OnNext, t11, (Throwable) null);
    }

    public void accept(Observer<? super T> observer) {
        Kind kind2 = this.kind;
        if (kind2 == Kind.OnNext) {
            observer.onNext(getValue());
        } else if (kind2 == Kind.OnCompleted) {
            observer.onCompleted();
        } else {
            observer.onError(getThrowable());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.getKind() != getKind()) {
            return false;
        }
        T t11 = this.value;
        T t12 = notification.value;
        if (t11 != t12 && (t11 == null || !t11.equals(t12))) {
            return false;
        }
        Throwable th2 = this.throwable;
        Throwable th3 = notification.throwable;
        if (th2 == th3 || (th2 != null && th2.equals(th3))) {
            return true;
        }
        return false;
    }

    public Kind getKind() {
        return this.kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasThrowable() {
        return isOnError() && this.throwable != null;
    }

    public boolean hasValue() {
        return isOnNext() && this.value != null;
    }

    public int hashCode() {
        int hashCode = getKind().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        return hasThrowable() ? (hashCode * 31) + getThrowable().hashCode() : hashCode;
    }

    public boolean isOnCompleted() {
        return getKind() == Kind.OnCompleted;
    }

    public boolean isOnError() {
        return getKind() == Kind.OnError;
    }

    public boolean isOnNext() {
        return getKind() == Kind.OnNext;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append('[');
        sb2.append(super.toString());
        sb2.append(' ');
        sb2.append(getKind());
        if (hasValue()) {
            sb2.append(' ');
            sb2.append(getValue());
        }
        if (hasThrowable()) {
            sb2.append(' ');
            sb2.append(getThrowable().getMessage());
        }
        sb2.append(']');
        return sb2.toString();
    }

    @Deprecated
    public static <T> Notification<T> createOnCompleted(Class<T> cls) {
        return ON_COMPLETED;
    }
}
