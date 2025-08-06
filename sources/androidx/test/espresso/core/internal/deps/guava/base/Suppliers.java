package androidx.test.espresso.core.internal.deps.guava.base;

import java.io.Serializable;

public final class Suppliers {

    public static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        public final T instance;

        public SupplierOfInstance(T t11) {
            this.instance = t11;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return Objects.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return Objects.b(this.instance);
        }

        public String toString() {
            String valueOf = String.valueOf(this.instance);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
            sb2.append("Suppliers.ofInstance(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static <T> Supplier<T> a(T t11) {
        return new SupplierOfInstance(t11);
    }
}
