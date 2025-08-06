package rx.internal.operators;

import java.io.Serializable;
import rx.Observer;

public final class NotificationLite {
    private static final Object ON_COMPLETED_SENTINEL = new Serializable() {
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };
    private static final Object ON_NEXT_NULL_SENTINEL = new Serializable() {
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    public static final class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f53403e;

        public OnErrorSentinel(Throwable th2) {
            this.f53403e = th2;
        }

        public String toString() {
            return "Notification=>Error:" + this.f53403e;
        }
    }

    private NotificationLite() {
    }

    public static <T> boolean accept(Observer<? super T> observer, Object obj) {
        if (obj == ON_COMPLETED_SENTINEL) {
            observer.onCompleted();
            return true;
        } else if (obj == ON_NEXT_NULL_SENTINEL) {
            observer.onNext(null);
            return false;
        } else if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (obj.getClass() == OnErrorSentinel.class) {
            observer.onError(((OnErrorSentinel) obj).f53403e);
            return true;
        } else {
            observer.onNext(obj);
            return false;
        }
    }

    public static Object completed() {
        return ON_COMPLETED_SENTINEL;
    }

    public static Object error(Throwable th2) {
        return new OnErrorSentinel(th2);
    }

    public static Throwable getError(Object obj) {
        return ((OnErrorSentinel) obj).f53403e;
    }

    public static <T> T getValue(Object obj) {
        if (obj == ON_NEXT_NULL_SENTINEL) {
            return null;
        }
        return obj;
    }

    public static boolean isCompleted(Object obj) {
        return obj == ON_COMPLETED_SENTINEL;
    }

    public static boolean isError(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public static boolean isNext(Object obj) {
        return obj != null && !isError(obj) && !isCompleted(obj);
    }

    public static boolean isNull(Object obj) {
        return obj == ON_NEXT_NULL_SENTINEL;
    }

    public static <T> Object next(T t11) {
        return t11 == null ? ON_NEXT_NULL_SENTINEL : t11;
    }
}
