package com.xiaomi.push;

import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.PrintStream;
import java.io.PrintWriter;

public class fj extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private fs f51797a = null;

    /* renamed from: a  reason: collision with other field name */
    private ft f2864a = null;

    /* renamed from: a  reason: collision with other field name */
    private Throwable f2865a = null;

    public fj() {
    }

    public Throwable a() {
        return this.f2865a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        r1 = r2.f51797a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMessage() {
        /*
            r2 = this;
            java.lang.String r0 = super.getMessage()
            if (r0 != 0) goto L_0x000f
            com.xiaomi.push.ft r1 = r2.f2864a
            if (r1 == 0) goto L_0x000f
            java.lang.String r0 = r1.toString()
            return r0
        L_0x000f:
            if (r0 != 0) goto L_0x0019
            com.xiaomi.push.fs r1 = r2.f51797a
            if (r1 == 0) goto L_0x0019
            java.lang.String r0 = r1.toString()
        L_0x0019:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fj.getMessage():java.lang.String");
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb2.append(message);
            sb2.append(l.f34627b);
        }
        ft ftVar = this.f2864a;
        if (ftVar != null) {
            sb2.append(ftVar);
        }
        fs fsVar = this.f51797a;
        if (fsVar != null) {
            sb2.append(fsVar);
        }
        if (this.f2865a != null) {
            sb2.append("\n  -- caused by: ");
            sb2.append(this.f2865a);
        }
        return sb2.toString();
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f2865a != null) {
            printStream.println("Nested Exception: ");
            this.f2865a.printStackTrace(printStream);
        }
    }

    public fj(String str) {
        super(str);
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f2865a != null) {
            printWriter.println("Nested Exception: ");
            this.f2865a.printStackTrace(printWriter);
        }
    }

    public fj(Throwable th2) {
        this.f2865a = th2;
    }

    public fj(fs fsVar) {
        this.f51797a = fsVar;
    }

    public fj(String str, Throwable th2) {
        super(str);
        this.f2865a = th2;
    }
}
