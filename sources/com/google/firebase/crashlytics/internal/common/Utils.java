package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils {
    private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");
    private static final int TIMEOUT_SEC = 4;

    private Utils() {
    }

    public static <T> T awaitEvenIfOnMainThread(Task<T> task) throws InterruptedException, TimeoutException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        task.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, new j(countDownLatch));
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3, TimeUnit.SECONDS);
        } else {
            countDownLatch.await(4, TimeUnit.SECONDS);
        }
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        } else if (task.isComplete()) {
            throw new IllegalStateException(task.getException());
        } else {
            throw new TimeoutException();
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j11, TimeUnit timeUnit) {
        long nanos;
        boolean await;
        boolean z11 = false;
        try {
            nanos = timeUnit.toNanos(j11);
            while (true) {
                await = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                break;
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (InterruptedException unused) {
            z11 = true;
            nanos = (System.nanoTime() + nanos) - System.nanoTime();
        } catch (Throwable th2) {
            if (z11) {
                Thread.currentThread().interrupt();
            }
            throw th2;
        }
    }

    public static <T> Task<T> callTask(Executor executor, Callable<Task<T>> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new k(callable, executor, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$callTask$2(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        } else if (task.getException() == null) {
            return null;
        } else {
            taskCompletionSource.setException(task.getException());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$callTask$3(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new i(taskCompletionSource));
        } catch (Exception e11) {
            taskCompletionSource.setException(e11);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$race$0(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        } else if (task.getException() == null) {
            return null;
        } else {
            taskCompletionSource.trySetException(task.getException());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void lambda$race$1(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
            return null;
        } else if (task.getException() == null) {
            return null;
        } else {
            taskCompletionSource.trySetException(task.getException());
            return null;
        }
    }

    @SuppressLint({"TaskMainThread"})
    public static <T> Task<T> race(Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h hVar = new h(taskCompletionSource);
        task.continueWith(hVar);
        task2.continueWith(hVar);
        return taskCompletionSource.getTask();
    }

    public static <T> Task<T> race(Executor executor, Task<T> task, Task<T> task2) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        g gVar = new g(taskCompletionSource);
        task.continueWith(executor, gVar);
        task2.continueWith(executor, gVar);
        return taskCompletionSource.getTask();
    }
}
