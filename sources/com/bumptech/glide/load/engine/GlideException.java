package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n3.b;

public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private b key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void addRootCauses(Throwable th2, List<Throwable> list) {
        if (th2 instanceof GlideException) {
            for (Throwable addRootCauses : ((GlideException) th2).getCauses()) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th2);
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            appendable.append("Cause (").append(String.valueOf(i12)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = list.get(i11);
            if (th2 instanceof GlideException) {
                ((GlideException) th2).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th2, appendable);
            }
            i11 = i12;
        }
    }

    private static void appendExceptionMessage(Throwable th2, Appendable appendable) {
        try {
            appendable.append(th2.getClass().toString()).append(l.f34627b).append(th2.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder(71);
        sb2.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass != null) {
            str = ", " + this.dataClass;
        } else {
            str = str3;
        }
        sb2.append(str);
        if (this.dataSource != null) {
            str2 = ", " + this.dataSource;
        } else {
            str2 = str3;
        }
        sb2.append(str2);
        if (this.key != null) {
            str3 = ", " + this.key;
        }
        sb2.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb2.toString();
        }
        if (rootCauses.size() == 1) {
            sb2.append("\nThere was 1 cause:");
        } else {
            sb2.append("\nThere were ");
            sb2.append(rootCauses.size());
            sb2.append(" causes:");
        }
        for (Throwable next : rootCauses) {
            sb2.append(10);
            sb2.append(next.getClass().getName());
            sb2.append('(');
            sb2.append(next.getMessage());
            sb2.append(')');
        }
        sb2.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb2.toString();
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i11 = 0;
        while (i11 < size) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Root cause (");
            int i12 = i11 + 1;
            sb2.append(i12);
            sb2.append(" of ");
            sb2.append(size);
            sb2.append(")");
            Log.i(str, sb2.toString(), rootCauses.get(i11));
            i11 = i12;
        }
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setLoggingDetails(b bVar, DataSource dataSource2) {
        setLoggingDetails(bVar, dataSource2, (Class<?>) null);
    }

    public void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public GlideException(String str, Throwable th2) {
        this(str, (List<Throwable>) Collections.singletonList(th2));
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public void setLoggingDetails(b bVar, DataSource dataSource2, Class<?> cls) {
        this.key = bVar;
        this.dataSource = dataSource2;
        this.dataClass = cls;
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new a(appendable));
    }

    public static final class a implements Appendable {

        /* renamed from: b  reason: collision with root package name */
        public final Appendable f63714b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63715c = true;

        public a(Appendable appendable) {
            this.f63714b = appendable;
        }

        public final CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c11) throws IOException {
            boolean z11 = false;
            if (this.f63715c) {
                this.f63715c = false;
                this.f63714b.append("  ");
            }
            if (c11 == 10) {
                z11 = true;
            }
            this.f63715c = z11;
            this.f63714b.append(c11);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a11 = a(charSequence);
            return append(a11, 0, a11.length());
        }

        public Appendable append(CharSequence charSequence, int i11, int i12) throws IOException {
            CharSequence a11 = a(charSequence);
            boolean z11 = false;
            if (this.f63715c) {
                this.f63715c = false;
                this.f63714b.append("  ");
            }
            if (a11.length() > 0 && a11.charAt(i12 - 1) == 10) {
                z11 = true;
            }
            this.f63715c = z11;
            this.f63714b.append(a11, i11, i12);
            return this;
        }
    }
}
