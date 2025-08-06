package androidx.test.internal.runner.junit3;

import android.os.Looper;
import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import o20.h;

@h
class AndroidTestSuite extends DelegatingFilterableTestSuite {

    /* renamed from: d  reason: collision with root package name */
    public final AndroidRunnerParams f11529d;

    public AndroidTestSuite(Class<?> cls, AndroidRunnerParams androidRunnerParams) {
        this((TestSuite) new NonLeakyTestSuite(cls), androidRunnerParams);
    }

    public void run(TestResult testResult) {
        AndroidTestResult androidTestResult = new AndroidTestResult(this.f11529d.a(), this.f11529d.b(), testResult);
        long c11 = this.f11529d.c();
        if (c11 > 0) {
            u(c11, androidTestResult);
        } else {
            super.run(androidTestResult);
        }
    }

    public final String s() {
        StringBuilder sb2 = new StringBuilder();
        Thread currentThread = Thread.currentThread();
        sb2.append(currentThread.toString());
        sb2.append(10);
        for (StackTraceElement stackTraceElement : currentThread.getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(stackTraceElement.toString());
            sb2.append(10);
        }
        sb2.append(10);
        Thread thread = Looper.getMainLooper().getThread();
        sb2.append(thread.toString());
        sb2.append(10);
        for (StackTraceElement stackTraceElement2 : thread.getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(stackTraceElement2.toString());
            sb2.append(10);
        }
        sb2.append(10);
        return sb2.toString();
    }

    public final void t(final Test test, final AndroidTestResult androidTestResult, long j11) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory(this) {
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName("AndroidTestSuite");
                return newThread;
            }
        });
        AnonymousClass2 r32 = new Runnable(this) {
            public void run() {
                test.run(androidTestResult);
            }
        };
        androidTestResult.j(j11);
        Future<?> submit = newSingleThreadExecutor.submit(r32);
        newSingleThreadExecutor.shutdown();
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (!newSingleThreadExecutor.awaitTermination(j11, timeUnit)) {
                newSingleThreadExecutor.shutdownNow();
                if (!newSingleThreadExecutor.awaitTermination(1, TimeUnit.MINUTES)) {
                    Log.e("AndroidTestSuite", "Failed to to stop test execution thread, the correctness of the test runner is at risk. Abort all execution!");
                    try {
                        submit.get(0, timeUnit);
                    } catch (ExecutionException e11) {
                        Log.e("AndroidTestSuite", "Exception from the execution thread", e11.getCause());
                    } catch (TimeoutException e12) {
                        Log.e("AndroidTestSuite", "Exception from the execution thread", e12);
                    }
                    v(new IllegalStateException(String.format("Test timed out after %d milliseconds but execution thread failed to terminate\nDumping instr and main threads:\n%s", new Object[]{Long.valueOf(j11), s()})));
                }
            }
        } catch (InterruptedException e13) {
            Log.e("AndroidTestSuite", "The correctness of the test runner is at risk. Abort all execution!");
            v(new IllegalStateException(String.format("Test execution thread got interrupted:\n%s\nDumping instr and main threads:\n%s", new Object[]{e13, s()})));
        }
    }

    public final void u(long j11, AndroidTestResult androidTestResult) {
        int n11 = n();
        for (int i11 = 0; i11 < n11; i11++) {
            t(m(i11), androidTestResult, j11);
        }
    }

    public final void v(final RuntimeException runtimeException) {
        Thread thread = new Thread(new Runnable(this) {
            public void run() {
                throw runtimeException;
            }
        }, "Terminator");
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException unused) {
        }
    }

    public AndroidTestSuite(TestSuite testSuite, AndroidRunnerParams androidRunnerParams) {
        super(testSuite);
        this.f11529d = androidRunnerParams;
    }
}
