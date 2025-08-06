package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;

@GwtCompatible
public final class MoreObjects {

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        public static final class ValueHolder {
            public String name;
            public ValueHolder next;
            public Object value;

            private ValueHolder() {
            }
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, Object obj) {
            return addHolder(str, obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(Object obj) {
            return addHolder(obj);
        }

        @CanIgnoreReturnValue
        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public String toString() {
            boolean z11 = this.omitNullValues;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.className);
            sb2.append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!z11 || obj != null) {
                    sb2.append(str);
                    String str2 = valueHolder.name;
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

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, boolean z11) {
            return addHolder(str, String.valueOf(z11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(boolean z11) {
            return addHolder(String.valueOf(z11));
        }

        private ToStringHelper addHolder(Object obj) {
            addHolder().value = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, char c11) {
            return addHolder(str, String.valueOf(c11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(char c11) {
            return addHolder(String.valueOf(c11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, double d11) {
            return addHolder(str, String.valueOf(d11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(double d11) {
            return addHolder(String.valueOf(d11));
        }

        private ToStringHelper addHolder(String str, Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, float f11) {
            return addHolder(str, String.valueOf(f11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(float f11) {
            return addHolder(String.valueOf(f11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, int i11) {
            return addHolder(str, String.valueOf(i11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(int i11) {
            return addHolder(String.valueOf(i11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper add(String str, long j11) {
            return addHolder(str, String.valueOf(j11));
        }

        @CanIgnoreReturnValue
        public ToStringHelper addValue(long j11) {
            return addHolder(String.valueOf(j11));
        }
    }

    private MoreObjects() {
    }

    public static <T> T firstNonNull(T t11, T t12) {
        if (t11 != null) {
            return t11;
        }
        Objects.requireNonNull(t12, "Both parameters are null");
        return t12;
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }
}
