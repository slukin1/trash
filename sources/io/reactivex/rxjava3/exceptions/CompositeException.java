package io.reactivex.rxjava3.exceptions;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public static final class ExceptionOverview extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public ExceptionOverview(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static abstract class a {
        public abstract void a(Object obj);
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public final PrintStream f55438a;

        public b(PrintStream printStream) {
            this.f55438a = printStream;
        }

        public void a(Object obj) {
            this.f55438a.println(obj);
        }
    }

    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        public final PrintWriter f55439a;

        public c(PrintWriter printWriter) {
            this.f55439a = printWriter;
        }

        public void a(Object obj) {
            this.f55439a.println(obj);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeException(Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
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

    public synchronized Throwable getCause() {
        int i11;
        if (this.cause == null) {
            String property = System.getProperty("line.separator");
            if (this.exceptions.size() > 1) {
                IdentityHashMap identityHashMap = new IdentityHashMap();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Multiple exceptions (");
                sb2.append(this.exceptions.size());
                sb2.append(")");
                sb2.append(property);
                for (Throwable next : this.exceptions) {
                    int i12 = 0;
                    while (true) {
                        if (next == null) {
                            break;
                        }
                        for (int i13 = 0; i13 < i12; i13++) {
                            sb2.append("  ");
                        }
                        sb2.append("|-- ");
                        sb2.append(next.getClass().getCanonicalName());
                        sb2.append(l.f34627b);
                        String message2 = next.getMessage();
                        if (message2 == null || !message2.contains(property)) {
                            sb2.append(message2);
                            sb2.append(property);
                        } else {
                            sb2.append(property);
                            for (String str : message2.split(property)) {
                                for (int i14 = 0; i14 < i12 + 2; i14++) {
                                    sb2.append("  ");
                                }
                                sb2.append(str);
                                sb2.append(property);
                            }
                        }
                        int i15 = 0;
                        while (true) {
                            i11 = i12 + 2;
                            if (i15 >= i11) {
                                break;
                            }
                            sb2.append("  ");
                            i15++;
                        }
                        StackTraceElement[] stackTrace = next.getStackTrace();
                        if (stackTrace.length > 0) {
                            sb2.append("at ");
                            sb2.append(stackTrace[0]);
                            sb2.append(property);
                        }
                        if (!identityHashMap.containsKey(next)) {
                            identityHashMap.put(next, Boolean.TRUE);
                            next = next.getCause();
                            i12++;
                        } else {
                            Throwable cause2 = next.getCause();
                            if (cause2 != null) {
                                for (int i16 = 0; i16 < i11; i16++) {
                                    sb2.append("  ");
                                }
                                sb2.append("|-- ");
                                sb2.append("(cause not expanded again) ");
                                sb2.append(cause2.getClass().getCanonicalName());
                                sb2.append(l.f34627b);
                                sb2.append(cause2.getMessage());
                                sb2.append(property);
                            }
                        }
                    }
                }
                this.cause = new ExceptionOverview(sb2.toString().trim());
            } else {
                this.cause = this.exceptions.get(0);
            }
        }
        return this.cause;
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

    public int size() {
        return this.exceptions.size();
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((a) new b(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((a) new c(printWriter));
    }

    public CompositeException(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th2 : iterable) {
                if (th2 instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th2).getExceptions());
                } else if (th2 != null) {
                    linkedHashSet.add(th2);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List<Throwable> unmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.exceptions = unmodifiableList;
            this.message = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    private void printStackTrace(a aVar) {
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
        aVar.a(sb2.toString());
    }
}
