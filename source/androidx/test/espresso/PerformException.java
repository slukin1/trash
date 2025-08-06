package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;

public final class PerformException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "Error performing '%s' on view '%s'.";
    private final String actionDescription;
    private final String viewDescription;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f11091a;

        /* renamed from: b  reason: collision with root package name */
        public String f11092b;

        /* renamed from: c  reason: collision with root package name */
        public Throwable f11093c;

        public PerformException d() {
            return new PerformException(this);
        }

        public Builder e(String str) {
            this.f11091a = str;
            return this;
        }

        public Builder f(Throwable th2) {
            this.f11093c = th2;
            return this;
        }

        public Builder g(String str) {
            this.f11092b = str;
            return this;
        }
    }

    public String getActionDescription() {
        return this.actionDescription;
    }

    public String getViewDescription() {
        return this.viewDescription;
    }

    private PerformException(Builder builder) {
        super(String.format(MESSAGE_FORMAT, new Object[]{builder.f11091a, builder.f11092b}), builder.f11093c);
        this.actionDescription = (String) Preconditions.i(builder.f11091a);
        this.viewDescription = (String) Preconditions.i(builder.f11092b);
    }
}
