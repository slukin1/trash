package rx.exceptions;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import rx.plugins.RxJavaPlugins;

public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        public static final class Primitives {
            public static final Set<Class<?>> INSTANCE = create();

            private static Set<Class<?>> create() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + renderValue(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th2) {
                    obj = th2.getMessage();
                }
            }
            this.value = obj;
        }

        public static String renderValue(Object obj) {
            if (obj == null) {
                return OptionsBridge.NULL_VALUE;
            }
            if (Primitives.INSTANCE.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String handleOnNextValueRendering = RxJavaPlugins.getInstance().getErrorHandler().handleOnNextValueRendering(obj);
            if (handleOnNextValueRendering != null) {
                return handleOnNextValueRendering;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object getValue() {
            return this.value;
        }
    }

    private OnErrorThrowable(Throwable th2) {
        super(th2);
        this.hasValue = false;
        this.value = null;
    }

    public static Throwable addValueAsLastCause(Throwable th2, Object obj) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        Throwable finalCause = Exceptions.getFinalCause(th2);
        if ((finalCause instanceof OnNextValue) && ((OnNextValue) finalCause).getValue() == obj) {
            return th2;
        }
        Exceptions.addCause(th2, new OnNextValue(obj));
        return th2;
    }

    public static OnErrorThrowable from(Throwable th2) {
        if (th2 == null) {
            th2 = new NullPointerException();
        }
        Throwable finalCause = Exceptions.getFinalCause(th2);
        if (finalCause instanceof OnNextValue) {
            return new OnErrorThrowable(th2, ((OnNextValue) finalCause).getValue());
        }
        return new OnErrorThrowable(th2);
    }

    public Object getValue() {
        return this.value;
    }

    public boolean isValueNull() {
        return this.hasValue;
    }

    private OnErrorThrowable(Throwable th2, Object obj) {
        super(th2);
        this.hasValue = true;
        if (!(obj instanceof Serializable)) {
            try {
                obj = String.valueOf(obj);
            } catch (Throwable th3) {
                obj = th3.getMessage();
            }
        }
        this.value = obj;
    }
}
