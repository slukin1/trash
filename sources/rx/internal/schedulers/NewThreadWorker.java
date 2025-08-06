package rx.internal.schedulers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.util.PlatformDependent;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SubscriptionList;
import rx.internal.util.SuppressAnimalSniffer;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public class NewThreadWorker extends Scheduler.Worker {
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> EXECUTORS = new ConcurrentHashMap<>();
    private static final String FREQUENCY_KEY = "rx.scheduler.jdk6.purge-frequency-millis";
    private static final AtomicReference<ScheduledExecutorService> PURGE = new AtomicReference<>();
    private static final String PURGE_FORCE_KEY = "rx.scheduler.jdk6.purge-force";
    public static final int PURGE_FREQUENCY = Integer.getInteger(FREQUENCY_KEY, 1000).intValue();
    private static final String PURGE_THREAD_PREFIX = "RxSchedulerPurge-";
    private static final Object SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED = new Object();
    private static final boolean SHOULD_TRY_ENABLE_CANCEL_POLICY;
    private static volatile Object cachedSetRemoveOnCancelPolicyMethod;
    private final ScheduledExecutorService executor;
    public volatile boolean isUnsubscribed;

    static {
        boolean z11 = Boolean.getBoolean(PURGE_FORCE_KEY);
        int androidApiVersion = PlatformDependent.getAndroidApiVersion();
        SHOULD_TRY_ENABLE_CANCEL_POLICY = !z11 && (androidApiVersion == 0 || androidApiVersion >= 21);
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!tryEnableCancelPolicy(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            registerExecutor((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.executor = newScheduledThreadPool;
    }

    public static void deregisterExecutor(ScheduledExecutorService scheduledExecutorService) {
        EXECUTORS.remove(scheduledExecutorService);
    }

    public static Method findSetRemoveOnCancelPolicyMethod(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    @SuppressAnimalSniffer
    public static void purgeExecutors() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it2 = EXECUTORS.keySet().iterator();
            while (it2.hasNext()) {
                ScheduledThreadPoolExecutor next = it2.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it2.remove();
                }
            }
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            RxJavaHooks.onError(th2);
        }
    }

    public static void registerExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = PURGE;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory(PURGE_THREAD_PREFIX));
            if (atomicReference.compareAndSet((Object) null, newScheduledThreadPool)) {
                AnonymousClass1 r52 = new Runnable() {
                    public void run() {
                        NewThreadWorker.purgeExecutors();
                    }
                };
                int i11 = PURGE_FREQUENCY;
                newScheduledThreadPool.scheduleAtFixedRate(r52, (long) i11, (long) i11, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        EXECUTORS.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean tryEnableCancelPolicy(ScheduledExecutorService scheduledExecutorService) {
        Method method;
        if (SHOULD_TRY_ENABLE_CANCEL_POLICY) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = cachedSetRemoveOnCancelPolicyMethod;
                Object obj2 = SET_REMOVE_ON_CANCEL_POLICY_METHOD_NOT_SUPPORTED;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    method = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
                    if (method != null) {
                        obj2 = method;
                    }
                    cachedSetRemoveOnCancelPolicyMethod = obj2;
                } else {
                    method = (Method) obj;
                }
            } else {
                method = findSetRemoveOnCancelPolicyMethod(scheduledExecutorService);
            }
            if (method != null) {
                try {
                    method.invoke(scheduledExecutorService, new Object[]{Boolean.TRUE});
                    return true;
                } catch (InvocationTargetException e11) {
                    RxJavaHooks.onError(e11);
                } catch (IllegalAccessException e12) {
                    RxJavaHooks.onError(e12);
                } catch (IllegalArgumentException e13) {
                    RxJavaHooks.onError(e13);
                }
            }
        }
        return false;
    }

    public boolean isUnsubscribed() {
        return this.isUnsubscribed;
    }

    public Subscription schedule(Action0 action0) {
        return schedule(action0, 0, (TimeUnit) null);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j11, TimeUnit timeUnit) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0));
        if (j11 <= 0) {
            future = this.executor.submit(scheduledAction);
        } else {
            future = this.executor.schedule(scheduledAction, j11, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public void unsubscribe() {
        this.isUnsubscribed = true;
        this.executor.shutdownNow();
        deregisterExecutor(this.executor);
    }

    public Subscription schedule(Action0 action0, long j11, TimeUnit timeUnit) {
        if (this.isUnsubscribed) {
            return Subscriptions.unsubscribed();
        }
        return scheduleActual(action0, j11, timeUnit);
    }

    public ScheduledAction scheduleActual(Action0 action0, long j11, TimeUnit timeUnit, CompositeSubscription compositeSubscription) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), compositeSubscription);
        compositeSubscription.add(scheduledAction);
        if (j11 <= 0) {
            future = this.executor.submit(scheduledAction);
        } else {
            future = this.executor.schedule(scheduledAction, j11, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }

    public ScheduledAction scheduleActual(Action0 action0, long j11, TimeUnit timeUnit, SubscriptionList subscriptionList) {
        Future future;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.onScheduledAction(action0), subscriptionList);
        subscriptionList.add(scheduledAction);
        if (j11 <= 0) {
            future = this.executor.submit(scheduledAction);
        } else {
            future = this.executor.schedule(scheduledAction, j11, timeUnit);
        }
        scheduledAction.add((Future<?>) future);
        return scheduledAction;
    }
}
