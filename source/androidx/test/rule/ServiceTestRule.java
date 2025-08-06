package androidx.test.rule;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.test.InstrumentationRegistry;
import androidx.test.annotation.Beta;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import u20.c;

@Beta
public class ServiceTestRule implements c {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f11644a;

    /* renamed from: b  reason: collision with root package name */
    public Intent f11645b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f11646c;

    /* renamed from: d  reason: collision with root package name */
    public long f11647d;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f11648e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11649f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f11650g;

    public class ServiceStatement extends Statement {

        /* renamed from: a  reason: collision with root package name */
        public final Statement f11651a;

        public ServiceStatement(Statement statement) {
            this.f11651a = statement;
        }

        public void a() throws Throwable {
            try {
                ServiceTestRule.this.c();
                this.f11651a.a();
            } finally {
                ServiceTestRule.this.d();
                ServiceTestRule.this.b();
            }
        }
    }

    public ServiceTestRule() {
        this(5, TimeUnit.SECONDS);
    }

    public Statement a(Statement statement, Description description) {
        return new ServiceStatement(statement);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() throws TimeoutException {
        if (this.f11649f) {
            InstrumentationRegistry.b().stopService(this.f11645b);
            this.f11649f = false;
        }
        e();
    }

    public void e() {
        if (this.f11650g) {
            InstrumentationRegistry.b().unbindService(this.f11646c);
            this.f11644a = null;
            this.f11650g = false;
        }
    }

    public ServiceTestRule(long j11, TimeUnit timeUnit) {
        this.f11649f = false;
        this.f11650g = false;
        this.f11647d = j11;
        this.f11648e = timeUnit;
    }
}
