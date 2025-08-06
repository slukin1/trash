package io.reactivex.rxjava3.internal.util;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.io.Serializable;
import java.util.Objects;
import z20.c;
import z20.d;

public enum NotificationLite {
    COMPLETE;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        public final b upstream;

        public DisposableNotification(b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        public final Throwable f55704e;

        public ErrorNotification(Throwable th2) {
            this.f55704e = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return Objects.equals(this.f55704e, ((ErrorNotification) obj).f55704e);
            }
            return false;
        }

        public int hashCode() {
            return this.f55704e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f55704e + "]";
        }
    }

    public static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        public final d upstream;

        public SubscriptionNotification(d dVar) {
            this.upstream = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).f55704e);
            return true;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).f55704e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            cVar.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        } else {
            cVar.onNext(obj);
            return false;
        }
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th2) {
        return new ErrorNotification(th2);
    }

    public static b getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f55704e;
    }

    public static d getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t11) {
        return t11;
    }

    public static Object subscription(d dVar) {
        return new SubscriptionNotification(dVar);
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, k<? super T> kVar) {
        if (obj == COMPLETE) {
            kVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            kVar.onError(((ErrorNotification) obj).f55704e);
            return true;
        } else {
            kVar.onNext(obj);
            return false;
        }
    }

    public static <T> boolean acceptFull(Object obj, k<? super T> kVar) {
        if (obj == COMPLETE) {
            kVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            kVar.onError(((ErrorNotification) obj).f55704e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            kVar.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        } else {
            kVar.onNext(obj);
            return false;
        }
    }
}
