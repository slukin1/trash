package androidx.test.internal.util;

import java.io.File;

public final class ProcSummary {

    /* renamed from: a  reason: collision with root package name */
    public final String f11609a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11610b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11611c;

    /* renamed from: d  reason: collision with root package name */
    public final String f11612d;

    /* renamed from: e  reason: collision with root package name */
    public final String f11613e;

    /* renamed from: f  reason: collision with root package name */
    public final long f11614f;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f11615a;

        /* renamed from: b  reason: collision with root package name */
        public String f11616b;

        /* renamed from: c  reason: collision with root package name */
        public String f11617c;

        /* renamed from: d  reason: collision with root package name */
        public String f11618d;

        /* renamed from: e  reason: collision with root package name */
        public long f11619e;

        /* renamed from: f  reason: collision with root package name */
        public String f11620f;

        public ProcSummary g() {
            return new ProcSummary(this);
        }

        public Builder h(String str) {
            this.f11618d = str;
            return this;
        }

        public Builder i(String str) {
            this.f11615a = str;
            return this;
        }

        public Builder j(String str) {
            try {
                Integer.parseInt(str);
                this.f11620f = str;
                return this;
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "not a pid: ".concat(valueOf) : new String("not a pid: "));
            }
        }

        public Builder k(String str) {
            try {
                Integer.parseInt(str);
                this.f11616b = str;
                return this;
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "not a pid: ".concat(valueOf) : new String("not a pid: "));
            }
        }

        public Builder l(String str) {
            try {
                Integer.parseInt(str);
                this.f11617c = str;
                return this;
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "not a uid: ".concat(valueOf) : new String("not a uid: "));
            }
        }

        public Builder m(long j11) {
            this.f11619e = j11;
            return this;
        }
    }

    public static class SummaryException extends RuntimeException {
        public SummaryException(String str, Throwable th2) {
            super(str, th2);
        }

        public SummaryException(String str) {
            super(str);
        }
    }

    public static ProcSummary a(String str, String str2, String str3) {
        String[] split = str.substring(str.lastIndexOf(41) + 2).split(" ", -1);
        String substring = str2.substring(str2.indexOf("\nUid:") + 1);
        return new Builder().k(str.substring(0, str.indexOf(32))).i(str.substring(str.indexOf(40) + 1, str.lastIndexOf(41))).j(split[1]).l(substring.substring(0, substring.indexOf(10)).split("\\s", -1)[1]).h(str3.trim().replace(0, ' ')).m(Long.parseLong(split[19])).g();
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079 A[SYNTHETIC, Splitter:B:28:0x0079] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(java.io.File r7) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r1]
            r3 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ RuntimeException -> 0x0055, IOException -> 0x0033 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ RuntimeException -> 0x0055, IOException -> 0x0033 }
            r5.<init>(r7)     // Catch:{ RuntimeException -> 0x0055, IOException -> 0x0033 }
            r4.<init>(r5)     // Catch:{ RuntimeException -> 0x0055, IOException -> 0x0033 }
        L_0x0014:
            r3 = 0
            int r5 = r4.read(r2, r3, r1)     // Catch:{ RuntimeException -> 0x002e, IOException -> 0x002b, all -> 0x0028 }
            r6 = -1
            if (r5 == r6) goto L_0x0020
            r0.append(r2, r3, r5)     // Catch:{ RuntimeException -> 0x002e, IOException -> 0x002b, all -> 0x0028 }
            goto L_0x0014
        L_0x0020:
            java.lang.String r7 = r0.toString()     // Catch:{ RuntimeException -> 0x002e, IOException -> 0x002b, all -> 0x0028 }
            r4.close()     // Catch:{ IOException -> 0x0027 }
        L_0x0027:
            return r7
        L_0x0028:
            r7 = move-exception
            r3 = r4
            goto L_0x0077
        L_0x002b:
            r0 = move-exception
            r3 = r4
            goto L_0x0034
        L_0x002e:
            r0 = move-exception
            r3 = r4
            goto L_0x0056
        L_0x0031:
            r7 = move-exception
            goto L_0x0077
        L_0x0033:
            r0 = move-exception
        L_0x0034:
            androidx.test.internal.util.ProcSummary$SummaryException r1 = new androidx.test.internal.util.ProcSummary$SummaryException     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0031 }
            int r2 = r7.length()     // Catch:{ all -> 0x0031 }
            int r2 = r2 + 16
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r2)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "Could not read: "
            r4.append(r2)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0031 }
            r1.<init>(r7, r0)     // Catch:{ all -> 0x0031 }
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x0055:
            r0 = move-exception
        L_0x0056:
            androidx.test.internal.util.ProcSummary$SummaryException r1 = new androidx.test.internal.util.ProcSummary$SummaryException     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0031 }
            int r2 = r7.length()     // Catch:{ all -> 0x0031 }
            int r2 = r2 + 15
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0031 }
            r4.<init>(r2)     // Catch:{ all -> 0x0031 }
            java.lang.String r2 = "Error reading: "
            r4.append(r2)     // Catch:{ all -> 0x0031 }
            r4.append(r7)     // Catch:{ all -> 0x0031 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0031 }
            r1.<init>(r7, r0)     // Catch:{ all -> 0x0031 }
            throw r1     // Catch:{ all -> 0x0031 }
        L_0x0077:
            if (r3 == 0) goto L_0x007c
            r3.close()     // Catch:{ IOException -> 0x007c }
        L_0x007c:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.util.ProcSummary.b(java.io.File):java.lang.String");
    }

    public static ProcSummary c(String str) {
        return a(b(new File(new File("/proc", str), "stat")), b(new File(new File("/proc", str), "status")), b(new File(new File("/proc", str), "cmdline")));
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProcSummary)) {
            return false;
        }
        ProcSummary procSummary = (ProcSummary) obj;
        if (!procSummary.f11609a.equals(this.f11609a) || !procSummary.f11610b.equals(this.f11610b) || !procSummary.f11611c.equals(this.f11611c) || !procSummary.f11612d.equals(this.f11612d) || !procSummary.f11613e.equals(this.f11613e) || procSummary.f11614f != this.f11614f) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f11610b.hashCode();
    }

    public String toString() {
        return String.format("ProcSummary(name: '%s', cmdline: '%s', pid: '%s', parent: '%s', realUid: '%s', startTime: %d)", new Object[]{this.f11609a, this.f11613e, this.f11610b, this.f11611c, this.f11612d, Long.valueOf(this.f11614f)});
    }

    public ProcSummary(Builder builder) {
        this.f11609a = (String) Checks.b(builder.f11615a);
        this.f11610b = (String) Checks.b(builder.f11616b);
        this.f11612d = (String) Checks.b(builder.f11617c);
        this.f11611c = (String) Checks.b(builder.f11620f);
        this.f11613e = (String) Checks.b(builder.f11618d);
        this.f11614f = builder.f11619e;
    }
}
