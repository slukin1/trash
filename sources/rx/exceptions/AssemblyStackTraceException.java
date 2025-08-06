package rx.exceptions;

import java.util.HashSet;
import rx.plugins.RxJavaHooks;

public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    public AssemblyStackTraceException(String str) {
        super(str);
    }

    public static AssemblyStackTraceException find(Throwable th2) {
        HashSet hashSet = new HashSet();
        while (!(th2 instanceof AssemblyStackTraceException)) {
            if (th2 == null || th2.getCause() == null) {
                return null;
            }
            th2 = th2.getCause();
            if (!hashSet.add(th2)) {
                return null;
            }
        }
        return (AssemblyStackTraceException) th2;
    }

    public void attachTo(Throwable th2) {
        HashSet hashSet = new HashSet();
        while (th2.getCause() != null) {
            th2 = th2.getCause();
            if (!hashSet.add(th2)) {
                RxJavaHooks.onError(this);
                return;
            }
        }
        try {
            th2.initCause(this);
        } catch (IllegalStateException unused) {
            RxJavaHooks.onError(new RuntimeException("Received an exception with a cause set to null, instead of being unset. To fix this, look down the chain of causes. The last exception had a cause explicitly set to null. It should be unset instead.", th2));
        }
    }

    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
