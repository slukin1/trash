package androidx.test.espresso;

import android.util.Log;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class IdlingPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final long f11078a;

    /* renamed from: b  reason: collision with root package name */
    public final TimeUnit f11079b;

    /* renamed from: c  reason: collision with root package name */
    public final ResponseAction f11080c;

    /* renamed from: androidx.test.espresso.IdlingPolicy$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11081a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.test.espresso.IdlingPolicy$ResponseAction[] r0 = androidx.test.espresso.IdlingPolicy.ResponseAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11081a = r0
                androidx.test.espresso.IdlingPolicy$ResponseAction r1 = androidx.test.espresso.IdlingPolicy.ResponseAction.THROW_APP_NOT_IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11081a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.test.espresso.IdlingPolicy$ResponseAction r1 = androidx.test.espresso.IdlingPolicy.ResponseAction.THROW_IDLE_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11081a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.test.espresso.IdlingPolicy$ResponseAction r1 = androidx.test.espresso.IdlingPolicy.ResponseAction.LOG_ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.IdlingPolicy.AnonymousClass1.<clinit>():void");
        }
    }

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public long f11082a = -1;

        /* renamed from: b  reason: collision with root package name */
        public TimeUnit f11083b = null;

        /* renamed from: c  reason: collision with root package name */
        public ResponseAction f11084c = null;

        public IdlingPolicy d() {
            return new IdlingPolicy(this, (AnonymousClass1) null);
        }

        public Builder e() {
            this.f11084c = ResponseAction.LOG_ERROR;
            return this;
        }

        public Builder f() {
            this.f11084c = ResponseAction.THROW_APP_NOT_IDLE;
            return this;
        }

        public Builder g() {
            this.f11084c = ResponseAction.THROW_IDLE_TIMEOUT;
            return this;
        }

        public Builder h(long j11) {
            this.f11082a = j11;
            return this;
        }

        public Builder i(TimeUnit timeUnit) {
            this.f11083b = timeUnit;
            return this;
        }
    }

    public enum ResponseAction {
        THROW_APP_NOT_IDLE,
        THROW_IDLE_TIMEOUT,
        LOG_ERROR
    }

    public /* synthetic */ IdlingPolicy(Builder builder, AnonymousClass1 r22) {
        this(builder);
    }

    public long a() {
        return this.f11078a;
    }

    public TimeUnit b() {
        return this.f11079b;
    }

    public void c(List<String> list, String str) {
        int i11 = AnonymousClass1.f11081a[this.f11080c.ordinal()];
        if (i11 == 1) {
            throw AppNotIdleException.create(list, str);
        } else if (i11 == 2) {
            throw new IdlingResourceTimeoutException(list);
        } else if (i11 == 3) {
            String valueOf = String.valueOf(list);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
            sb2.append("These resources are not idle: ");
            sb2.append(valueOf);
            Log.w("IdlingPolicy", sb2.toString());
        } else {
            String valueOf2 = String.valueOf(list);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 24);
            sb3.append("should never reach here.");
            sb3.append(valueOf2);
            throw new IllegalStateException(sb3.toString());
        }
    }

    public IdlingPolicy(Builder builder) {
        Preconditions.d(builder.f11082a > 0);
        this.f11078a = builder.f11082a;
        this.f11079b = (TimeUnit) Preconditions.i(builder.f11083b);
        this.f11080c = (ResponseAction) Preconditions.i(builder.f11084c);
    }
}
