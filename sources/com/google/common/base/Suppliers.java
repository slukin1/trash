package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@GwtCompatible
public final class Suppliers {

    @VisibleForTesting
    public static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> delegate;
        public final long durationNanos;
        public volatile transient long expirationNanos;
        public volatile transient T value;

        public ExpiringMemoizingSupplier(Supplier<T> supplier, long j11, TimeUnit timeUnit) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
            this.durationNanos = timeUnit.toNanos(j11);
            Preconditions.checkArgument(j11 > 0, "duration (%s %s) must be > 0", j11, (Object) timeUnit);
        }

        public T get() {
            long j11 = this.expirationNanos;
            long systemNanoTime = Platform.systemNanoTime();
            if (j11 == 0 || systemNanoTime - j11 >= 0) {
                synchronized (this) {
                    if (j11 == this.expirationNanos) {
                        T t11 = this.delegate.get();
                        this.value = t11;
                        long j12 = systemNanoTime + this.durationNanos;
                        if (j12 == 0) {
                            j12 = 1;
                        }
                        this.expirationNanos = j12;
                        return t11;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + ", " + this.durationNanos + ", NANOS)";
        }
    }

    @VisibleForTesting
    public static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> delegate;
        public volatile transient boolean initialized;
        public transient T value;

        public MemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t11 = this.delegate.get();
                        this.value = t11;
                        this.initialized = true;
                        return t11;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            Object obj;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + ">";
            } else {
                obj = this.delegate;
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    @VisibleForTesting
    public static class NonSerializableMemoizingSupplier<T> implements Supplier<T> {
        public volatile Supplier<T> delegate;
        public volatile boolean initialized;
        public T value;

        public NonSerializableMemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t11 = this.delegate.get();
                        this.value = t11;
                        this.initialized = true;
                        this.delegate = null;
                        return t11;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            Object obj = this.delegate;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Suppliers.memoize(");
            if (obj == null) {
                obj = "<supplier that returned " + this.value + ">";
            }
            sb2.append(obj);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Function<? super F, T> function;
        public final Supplier<F> supplier;

        public SupplierComposition(Function<? super F, T> function2, Supplier<F> supplier2) {
            this.function = (Function) Preconditions.checkNotNull(function2);
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SupplierComposition)) {
                return false;
            }
            SupplierComposition supplierComposition = (SupplierComposition) obj;
            if (!this.function.equals(supplierComposition.function) || !this.supplier.equals(supplierComposition.supplier)) {
                return false;
            }
            return true;
        }

        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return Objects.hashCode(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    public interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    public enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }
    }

    public static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final T instance;

        public SupplierOfInstance(T t11) {
            this.instance = t11;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.equal(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return Objects.hashCode(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    public static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final Supplier<T> delegate;

        public ThreadSafeSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) Preconditions.checkNotNull(supplier);
        }

        public T get() {
            T t11;
            synchronized (this.delegate) {
                t11 = this.delegate.get();
            }
            return t11;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    private Suppliers() {
    }

    public static <F, T> Supplier<T> compose(Function<? super F, T> function, Supplier<F> supplier) {
        return new SupplierComposition(function, supplier);
    }

    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        if ((supplier instanceof NonSerializableMemoizingSupplier) || (supplier instanceof MemoizingSupplier)) {
            return supplier;
        }
        return supplier instanceof Serializable ? new MemoizingSupplier(supplier) : new NonSerializableMemoizingSupplier(supplier);
    }

    public static <T> Supplier<T> memoizeWithExpiration(Supplier<T> supplier, long j11, TimeUnit timeUnit) {
        return new ExpiringMemoizingSupplier(supplier, j11, timeUnit);
    }

    public static <T> Supplier<T> ofInstance(T t11) {
        return new SupplierOfInstance(t11);
    }

    public static <T> Function<Supplier<T>, T> supplierFunction() {
        return SupplierFunctionImpl.INSTANCE;
    }

    public static <T> Supplier<T> synchronizedSupplier(Supplier<T> supplier) {
        return new ThreadSafeSupplier(supplier);
    }
}
