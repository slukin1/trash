package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Arrays;
import java.util.Objects;

public final class MoreObjects {

    public static final class ToStringHelper {

        /* renamed from: a  reason: collision with root package name */
        public final String f11150a;

        /* renamed from: b  reason: collision with root package name */
        public final ValueHolder f11151b;

        /* renamed from: c  reason: collision with root package name */
        public ValueHolder f11152c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11153d;

        public static final class ValueHolder {

            /* renamed from: a  reason: collision with root package name */
            public String f11154a;

            /* renamed from: b  reason: collision with root package name */
            public Object f11155b;

            /* renamed from: c  reason: collision with root package name */
            public ValueHolder f11156c;

            private ValueHolder() {
            }
        }

        public ToStringHelper a(String str, float f11) {
            return h(str, String.valueOf(f11));
        }

        public ToStringHelper b(String str, int i11) {
            return h(str, String.valueOf(i11));
        }

        public ToStringHelper c(String str, long j11) {
            return h(str, String.valueOf(j11));
        }

        public ToStringHelper d(String str, Object obj) {
            return h(str, obj);
        }

        public ToStringHelper e(String str, boolean z11) {
            return h(str, String.valueOf(z11));
        }

        public final ValueHolder f() {
            ValueHolder valueHolder = new ValueHolder();
            this.f11152c.f11156c = valueHolder;
            this.f11152c = valueHolder;
            return valueHolder;
        }

        public final ToStringHelper g(Object obj) {
            f().f11155b = obj;
            return this;
        }

        public final ToStringHelper h(String str, Object obj) {
            ValueHolder f11 = f();
            f11.f11155b = obj;
            f11.f11154a = (String) Preconditions.i(str);
            return this;
        }

        public ToStringHelper i(Object obj) {
            return g(obj);
        }

        public String toString() {
            boolean z11 = this.f11153d;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f11150a);
            sb2.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.f11151b.f11156c; valueHolder != null; valueHolder = valueHolder.f11156c) {
                Object obj = valueHolder.f11155b;
                if (!z11 || obj != null) {
                    sb2.append(str);
                    String str2 = valueHolder.f11154a;
                    if (str2 != null) {
                        sb2.append(str2);
                        sb2.append('=');
                    }
                    if (obj == null || !obj.getClass().isArray()) {
                        sb2.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb2.append(deepToString, 1, deepToString.length() - 1);
                    }
                    str = ", ";
                }
            }
            sb2.append('}');
            return sb2.toString();
        }

        public ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.f11151b = valueHolder;
            this.f11152c = valueHolder;
            this.f11153d = false;
            this.f11150a = (String) Preconditions.i(str);
        }
    }

    public static <T> T a(T t11, T t12) {
        if (t11 != null) {
            return t11;
        }
        Objects.requireNonNull(t12, "Both parameters are null");
        return t12;
    }

    public static ToStringHelper b(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }
}
