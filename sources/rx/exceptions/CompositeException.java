package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        public static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        public String getMessage() {
            return MESSAGE;
        }
    }

    public static abstract class PrintStreamOrWriter {
        public abstract Object lock();

        public abstract void println(Object obj);
    }

    public static final class WrappedPrintStream extends PrintStreamOrWriter {
        private final PrintStream printStream;

        public WrappedPrintStream(PrintStream printStream2) {
            this.printStream = printStream2;
        }

        public Object lock() {
            return this.printStream;
        }

        public void println(Object obj) {
            this.printStream.println(obj);
        }
    }

    public static final class WrappedPrintWriter extends PrintStreamOrWriter {
        private final PrintWriter printWriter;

        public WrappedPrintWriter(PrintWriter printWriter2) {
            this.printWriter = printWriter2;
        }

        public Object lock() {
            return this.printWriter;
        }

        public void println(Object obj) {
            this.printWriter.println(obj);
        }
    }

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Throwable th2 : collection) {
                if (th2 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }

    private void appendStackTrace(StringBuilder sb2, Throwable th2, String str) {
        sb2.append(str);
        sb2.append(th2);
        sb2.append(10);
        for (StackTraceElement append : th2.getStackTrace()) {
            sb2.append("\t\tat ");
            sb2.append(append);
            sb2.append(10);
        }
        if (th2.getCause() != null) {
            sb2.append("\tCaused by: ");
            appendStackTrace(sb2, th2.getCause(), "");
        }
    }

    private List<Throwable> getListOfCauses(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        Throwable cause2 = th2.getCause();
        if (cause2 != null && cause2 != th2) {
            while (true) {
                arrayList.add(cause2);
                Throwable cause3 = cause2.getCause();
                if (cause3 == null || cause3 == cause2) {
                    break;
                }
                cause2 = cause2.getCause();
            }
        }
        return arrayList;
    }

    private Throwable getRootCause(Throwable th2) {
        Throwable cause2 = th2.getCause();
        if (cause2 == null || cause2 == th2) {
            return th2;
        }
        while (true) {
            Throwable cause3 = cause2.getCause();
            if (cause3 == null || cause3 == cause2) {
                return cause2;
            }
            cause2 = cause2.getCause();
        }
        return cause2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|(4:13|(2:15|33)(2:16|34)|32|11)|17|18|19|20|31) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.cause     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x005c
            rx.exceptions.CompositeException$CompositeExceptionCausalChain r0 = new rx.exceptions.CompositeException$CompositeExceptionCausalChain     // Catch:{ all -> 0x0060 }
            r0.<init>()     // Catch:{ all -> 0x0060 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0060 }
            r1.<init>()     // Catch:{ all -> 0x0060 }
            java.util.List<java.lang.Throwable> r2 = r8.exceptions     // Catch:{ all -> 0x0060 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0060 }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0060 }
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0060 }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x0060 }
            java.util.List r5 = r8.getListOfCauses(r4)     // Catch:{ all -> 0x0060 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0060 }
        L_0x0034:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0060 }
            if (r6 == 0) goto L_0x0052
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0060 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0060 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x004e
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0060 }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x004e:
            r1.add(r6)     // Catch:{ all -> 0x0060 }
            goto L_0x0034
        L_0x0052:
            r3.initCause(r4)     // Catch:{ all -> 0x0055 }
        L_0x0055:
            java.lang.Throwable r3 = r8.getRootCause(r3)     // Catch:{ all -> 0x0060 }
            goto L_0x0016
        L_0x005a:
            r8.cause = r0     // Catch:{ all -> 0x0060 }
        L_0x005c:
            java.lang.Throwable r0 = r8.cause     // Catch:{ all -> 0x0060 }
            monitor-exit(r8)
            return r0
        L_0x0060:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    public String getMessage() {
        return this.message;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((PrintStreamOrWriter) new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((PrintStreamOrWriter) new WrappedPrintWriter(printWriter));
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(this);
        sb2.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb2.append("\tat ");
            sb2.append(append);
            sb2.append(10);
        }
        int i11 = 1;
        for (Throwable appendStackTrace : this.exceptions) {
            sb2.append("  ComposedException ");
            sb2.append(i11);
            sb2.append(" :\n");
            appendStackTrace(sb2, appendStackTrace, "\t");
            i11++;
        }
        synchronized (printStreamOrWriter.lock()) {
            printStreamOrWriter.println(sb2.toString());
        }
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this((String) null, collection);
    }

    public CompositeException(Throwable... thArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (thArr != null) {
            for (CompositeException compositeException : thArr) {
                if (compositeException instanceof CompositeException) {
                    linkedHashSet.addAll(compositeException.getExceptions());
                } else if (compositeException != null) {
                    linkedHashSet.add(compositeException);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.exceptions = unmodifiableList;
        this.message = unmodifiableList.size() + " exceptions occurred. ";
    }
}
