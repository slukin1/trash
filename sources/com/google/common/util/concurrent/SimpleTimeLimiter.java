package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@Beta
public final class SimpleTimeLimiter implements TimeLimiter {
    private final ExecutorService executor;

    private SimpleTimeLimiter(ExecutorService executorService) {
        this.executor = (ExecutorService) Preconditions.checkNotNull(executorService);
    }

    /* access modifiers changed from: private */
    public <T> T callWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit, boolean z11) throws Exception {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j11);
        Future<T> submit = this.executor.submit(callable);
        if (!z11) {
            return Uninterruptibles.getUninterruptibly(submit, j11, timeUnit);
        }
        try {
            return submit.get(j11, timeUnit);
        } catch (InterruptedException e11) {
            submit.cancel(true);
            throw e11;
        } catch (ExecutionException e12) {
            throw throwCause(e12, true);
        } catch (TimeoutException e13) {
            submit.cancel(true);
            throw new UncheckedTimeoutException((Throwable) e13);
        }
    }

    private static void checkPositiveTimeout(long j11) {
        Preconditions.checkArgument(j11 > 0, "timeout must be positive: %s", j11);
    }

    public static SimpleTimeLimiter create(ExecutorService executorService) {
        return new SimpleTimeLimiter(executorService);
    }

    private static boolean declaresInterruptedEx(Method method) {
        for (Class<InterruptedException> cls : method.getExceptionTypes()) {
            if (cls == InterruptedException.class) {
                return true;
            }
        }
        return false;
    }

    private static Set<Method> findInterruptibleMethods(Class<?> cls) {
        HashSet newHashSet = Sets.newHashSet();
        for (Method method : cls.getMethods()) {
            if (declaresInterruptedEx(method)) {
                newHashSet.add(method);
            }
        }
        return newHashSet;
    }

    /* access modifiers changed from: private */
    public static Exception throwCause(Exception exc, boolean z11) throws Exception {
        Throwable cause = exc.getCause();
        if (cause != null) {
            if (z11) {
                cause.setStackTrace((StackTraceElement[]) ObjectArrays.concat(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
            }
            if (cause instanceof Exception) {
                throw ((Exception) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw exc;
            }
        } else {
            throw exc;
        }
    }

    private void wrapAndThrowExecutionExceptionOrError(Throwable th2) throws ExecutionException {
        if (th2 instanceof Error) {
            throw new ExecutionError((Error) th2);
        } else if (th2 instanceof RuntimeException) {
            throw new UncheckedExecutionException(th2);
        } else {
            throw new ExecutionException(th2);
        }
    }

    private void wrapAndThrowRuntimeExecutionExceptionOrError(Throwable th2) {
        if (th2 instanceof Error) {
            throw new ExecutionError((Error) th2);
        }
        throw new UncheckedExecutionException(th2);
    }

    @CanIgnoreReturnValue
    public <T> T callUninterruptiblyWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j11);
        Future<T> submit = this.executor.submit(callable);
        try {
            return Uninterruptibles.getUninterruptibly(submit, j11, timeUnit);
        } catch (TimeoutException e11) {
            submit.cancel(true);
            throw e11;
        } catch (ExecutionException e12) {
            wrapAndThrowExecutionExceptionOrError(e12.getCause());
            throw new AssertionError();
        }
    }

    public <T> T newProxy(T t11, Class<T> cls, long j11, TimeUnit timeUnit) {
        Preconditions.checkNotNull(t11);
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j11);
        Preconditions.checkArgument(cls.isInterface(), "interfaceType must be an interface type");
        final Set<Method> findInterruptibleMethods = findInterruptibleMethods(cls);
        final T t12 = t11;
        final long j12 = j11;
        final TimeUnit timeUnit2 = timeUnit;
        return newProxy(cls, new InvocationHandler() {
            public Object invoke(Object obj, final Method method, final Object[] objArr) throws Throwable {
                return SimpleTimeLimiter.this.callWithTimeout(new Callable<Object>() {
                    public Object call() throws Exception {
                        try {
                            return method.invoke(t12, objArr);
                        } catch (InvocationTargetException e11) {
                            throw SimpleTimeLimiter.throwCause(e11, false);
                        }
                    }
                }, j12, timeUnit2, findInterruptibleMethods.contains(method));
            }
        });
    }

    public void runUninterruptiblyWithTimeout(Runnable runnable, long j11, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j11);
        Future<?> submit = this.executor.submit(runnable);
        try {
            Uninterruptibles.getUninterruptibly(submit, j11, timeUnit);
        } catch (TimeoutException e11) {
            submit.cancel(true);
            throw e11;
        } catch (ExecutionException e12) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e12.getCause());
            throw new AssertionError();
        }
    }

    public void runWithTimeout(Runnable runnable, long j11, TimeUnit timeUnit) throws TimeoutException, InterruptedException {
        Preconditions.checkNotNull(runnable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j11);
        Future<?> submit = this.executor.submit(runnable);
        try {
            submit.get(j11, timeUnit);
        } catch (InterruptedException | TimeoutException e11) {
            submit.cancel(true);
            throw e11;
        } catch (ExecutionException e12) {
            wrapAndThrowRuntimeExecutionExceptionOrError(e12.getCause());
            throw new AssertionError();
        }
    }

    private static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    @CanIgnoreReturnValue
    public <T> T callWithTimeout(Callable<T> callable, long j11, TimeUnit timeUnit) throws TimeoutException, InterruptedException, ExecutionException {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(timeUnit);
        checkPositiveTimeout(j11);
        Future<T> submit = this.executor.submit(callable);
        try {
            return submit.get(j11, timeUnit);
        } catch (InterruptedException | TimeoutException e11) {
            submit.cancel(true);
            throw e11;
        } catch (ExecutionException e12) {
            wrapAndThrowExecutionExceptionOrError(e12.getCause());
            throw new AssertionError();
        }
    }
}
