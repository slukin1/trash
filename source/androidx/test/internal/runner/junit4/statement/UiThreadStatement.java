package androidx.test.internal.runner.junit4.statement;

import android.os.Looper;
import android.test.UiThreadTest;
import android.util.Log;
import androidx.test.InstrumentationRegistry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.runners.model.Statement;
import x20.c;

public class UiThreadStatement extends Statement {

    /* renamed from: a  reason: collision with root package name */
    public final Statement f11557a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f11558b;

    public UiThreadStatement(Statement statement, boolean z11) {
        this.f11557a = statement;
        this.f11558b = z11;
    }

    public static void d(Runnable runnable) throws Throwable {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("UiThreadStatement", "Already on the UI thread, this method should not be called from the main application thread");
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, (Object) null);
        InstrumentationRegistry.a().runOnMainSync(futureTask);
        try {
            futureTask.get();
        } catch (ExecutionException e11) {
            throw e11.getCause();
        }
    }

    public static boolean e(c cVar) {
        Class<UiThreadTest> cls = UiThreadTest.class;
        if (cVar.getAnnotation(cls) != null) {
            return true;
        }
        try {
            Class<?> cls2 = Class.forName("androidx.test.annotation.UiThreadTest");
            if (cVar.getAnnotation(cls) == null && cVar.getAnnotation(cls2) == null) {
                return false;
            }
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void a() throws Throwable {
        if (this.f11558b) {
            final AtomicReference atomicReference = new AtomicReference();
            d(new Runnable() {
                public void run() {
                    try {
                        UiThreadStatement.this.f11557a.a();
                    } catch (Throwable th2) {
                        atomicReference.set(th2);
                    }
                }
            });
            Throwable th2 = (Throwable) atomicReference.get();
            if (th2 != null) {
                throw th2;
            }
            return;
        }
        this.f11557a.a();
    }

    public boolean c() {
        return this.f11558b;
    }
}
