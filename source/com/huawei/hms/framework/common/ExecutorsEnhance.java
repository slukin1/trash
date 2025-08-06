package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorsEnhance {

    public static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService executorService;

        public DelegatedExecutorService(ExecutorService executorService2) {
            this.executorService = executorService2;
        }

        public boolean awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
            return this.executorService.awaitTermination(j11, timeUnit);
        }

        public void execute(Runnable runnable) {
            this.executorService.execute(runnable);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) throws InterruptedException {
            return this.executorService.invokeAll(collection, j11, timeUnit);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.executorService.invokeAny(collection, j11, timeUnit);
        }

        public boolean isShutdown() {
            return this.executorService.isShutdown();
        }

        public boolean isTerminated() {
            return this.executorService.isTerminated();
        }

        public void shutdown() {
            this.executorService.shutdown();
        }

        public List<Runnable> shutdownNow() {
            return this.executorService.shutdownNow();
        }

        public <T> Future<T> submit(Runnable runnable, T t11) {
            return this.executorService.submit(runnable, t11);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.executorService.invokeAll(collection);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return this.executorService.invokeAny(collection);
        }

        public <T> Future<T> submit(Callable<T> callable) {
            return this.executorService.submit(callable);
        }

        public Future<?> submit(Runnable runnable) {
            return this.executorService.submit(runnable);
        }
    }

    public static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        public FinalizableDelegatedExecutorService(ExecutorService executorService) {
            super(executorService);
        }

        public void finalize() {
            super.shutdown();
        }
    }

    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        return new FinalizableDelegatedExecutorService(threadPoolExcutorEnhance);
    }
}
