package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;

public final class e {
    public static final void a(int i11, int i12) {
        if (i12 > i11) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i11 + ", got " + i12 + ". Please update the Kotlin standard library.").toString());
        }
    }

    public static final d b(BaseContinuationImpl baseContinuationImpl) {
        return (d) baseContinuationImpl.getClass().getAnnotation(d.class);
    }

    public static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(BaseContinuationImpl baseContinuationImpl) {
        int i11;
        String str;
        d b11 = b(baseContinuationImpl);
        if (b11 == null) {
            return null;
        }
        a(1, b11.v());
        int c11 = c(baseContinuationImpl);
        if (c11 < 0) {
            i11 = -1;
        } else {
            i11 = b11.l()[c11];
        }
        String b12 = g.f56679a.b(baseContinuationImpl);
        if (b12 == null) {
            str = b11.c();
        } else {
            str = b12 + '/' + b11.c();
        }
        return new StackTraceElement(str, b11.m(), b11.f(), i11);
    }
}
