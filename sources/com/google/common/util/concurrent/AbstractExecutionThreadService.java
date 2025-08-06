package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@GwtIncompatible
@Beta
public abstract class AbstractExecutionThreadService implements Service {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new AbstractService() {
        public final void doStart() {
            MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), (Supplier<String>) new Supplier<String>() {
                public String get() {
                    return AbstractExecutionThreadService.this.serviceName();
                }
            }).execute(new Runnable() {
                public void run() {
                    try {
                        AbstractExecutionThreadService.this.startUp();
                        AnonymousClass1.this.notifyStarted();
                        if (AnonymousClass1.this.isRunning()) {
                            AbstractExecutionThreadService.this.run();
                        }
                        AbstractExecutionThreadService.this.shutDown();
                        AnonymousClass1.this.notifyStopped();
                    } catch (Throwable th2) {
                        AnonymousClass1.this.notifyFailed(th2);
                    }
                }
            });
        }

        public void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }

        public String toString() {
            return AbstractExecutionThreadService.this.toString();
        }
    };

    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public Executor executor() {
        return new Executor() {
            public void execute(Runnable runnable) {
                MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), runnable).start();
            }
        };
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public abstract void run() throws Exception;

    public String serviceName() {
        return getClass().getSimpleName();
    }

    public void shutDown() throws Exception {
    }

    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public void startUp() throws Exception {
    }

    public final Service.State state() {
        return this.delegate.state();
    }

    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public void triggerShutdown() {
    }

    public final void awaitRunning(long j11, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j11, timeUnit);
    }

    public final void awaitTerminated(long j11, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j11, timeUnit);
    }
}
