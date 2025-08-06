package org.junit;

import o20.c;

public class ComparisonFailure extends AssertionError {
    private static final int MAX_CONTEXT_LENGTH = 20;
    private static final long serialVersionUID = 1;
    private String fActual;
    private String fExpected;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f25417a;

        /* renamed from: b  reason: collision with root package name */
        public final String f25418b;

        /* renamed from: c  reason: collision with root package name */
        public final String f25419c;

        public class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f25420a;

            /* renamed from: b  reason: collision with root package name */
            public final String f25421b;

            public String a() {
                return e(b.this.f25419c);
            }

            public String b() {
                if (this.f25420a.length() <= b.this.f25417a) {
                    return this.f25420a;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("...");
                String str = this.f25420a;
                sb2.append(str.substring(str.length() - b.this.f25417a));
                return sb2.toString();
            }

            public String c() {
                if (this.f25421b.length() <= b.this.f25417a) {
                    return this.f25421b;
                }
                return this.f25421b.substring(0, b.this.f25417a) + "...";
            }

            public String d() {
                return e(b.this.f25418b);
            }

            public final String e(String str) {
                return "[" + str.substring(this.f25420a.length(), str.length() - this.f25421b.length()) + "]";
            }

            public a() {
                String a11 = b.this.g();
                this.f25420a = a11;
                this.f25421b = b.this.h(a11);
            }
        }

        public b(int i11, String str, String str2) {
            this.f25417a = i11;
            this.f25418b = str;
            this.f25419c = str2;
        }

        public String f(String str) {
            String str2;
            String str3 = this.f25418b;
            if (str3 == null || (str2 = this.f25419c) == null || str3.equals(str2)) {
                return c.e(str, this.f25418b, this.f25419c);
            }
            a aVar = new a();
            String b11 = aVar.b();
            String c11 = aVar.c();
            return c.e(str, b11 + aVar.d() + c11, b11 + aVar.a() + c11);
        }

        public final String g() {
            int min = Math.min(this.f25418b.length(), this.f25419c.length());
            for (int i11 = 0; i11 < min; i11++) {
                if (this.f25418b.charAt(i11) != this.f25419c.charAt(i11)) {
                    return this.f25418b.substring(0, i11);
                }
            }
            return this.f25418b.substring(0, min);
        }

        public final String h(String str) {
            int min = Math.min(this.f25418b.length() - str.length(), this.f25419c.length() - str.length()) - 1;
            int i11 = 0;
            while (i11 <= min) {
                String str2 = this.f25418b;
                char charAt = str2.charAt((str2.length() - 1) - i11);
                String str3 = this.f25419c;
                if (charAt != str3.charAt((str3.length() - 1) - i11)) {
                    break;
                }
                i11++;
            }
            String str4 = this.f25418b;
            return str4.substring(str4.length() - i11);
        }
    }

    public ComparisonFailure(String str, String str2, String str3) {
        super(str);
        this.fExpected = str2;
        this.fActual = str3;
    }

    public String getActual() {
        return this.fActual;
    }

    public String getExpected() {
        return this.fExpected;
    }

    public String getMessage() {
        return new b(20, this.fExpected, this.fActual).f(super.getMessage());
    }
}
