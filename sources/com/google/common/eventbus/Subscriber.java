package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

class Subscriber {
    /* access modifiers changed from: private */
    @Weak
    public EventBus bus;
    private final Executor executor;
    private final Method method;
    @VisibleForTesting
    public final Object target;

    @VisibleForTesting
    public static final class SynchronizedSubscriber extends Subscriber {
        public void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
            synchronized (this) {
                Subscriber.super.invokeSubscriberMethod(obj);
            }
        }

        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }
    }

    /* access modifiers changed from: private */
    public SubscriberExceptionContext context(Object obj) {
        return new SubscriberExceptionContext(this.bus, obj, this.target, this.method);
    }

    public static Subscriber create(EventBus eventBus, Object obj, Method method2) {
        return isDeclaredThreadSafe(method2) ? new Subscriber(eventBus, obj, method2) : new SynchronizedSubscriber(eventBus, obj, method2);
    }

    private static boolean isDeclaredThreadSafe(Method method2) {
        return method2.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    public final void dispatchEvent(final Object obj) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    Subscriber.this.invokeSubscriberMethod(obj);
                } catch (InvocationTargetException e11) {
                    Subscriber.this.bus.handleSubscriberException(e11.getCause(), Subscriber.this.context(obj));
                }
            }
        });
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        if (this.target != subscriber.target || !this.method.equals(subscriber.method)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    @VisibleForTesting
    public void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
        try {
            this.method.invoke(this.target, new Object[]{Preconditions.checkNotNull(obj)});
        } catch (IllegalArgumentException e11) {
            throw new Error("Method rejected target/argument: " + obj, e11);
        } catch (IllegalAccessException e12) {
            throw new Error("Method became inaccessible: " + obj, e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof Error) {
                throw ((Error) e13.getCause());
            }
            throw e13;
        }
    }

    private Subscriber(EventBus eventBus, Object obj, Method method2) {
        this.bus = eventBus;
        this.target = Preconditions.checkNotNull(obj);
        this.method = method2;
        method2.setAccessible(true);
        this.executor = eventBus.executor();
    }
}
