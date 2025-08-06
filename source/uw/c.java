package uw;

import com.kakao.network.exception.ResponseStatusError;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final int f26268a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26269b;

    /* renamed from: c  reason: collision with root package name */
    public final String f26270c;

    /* renamed from: d  reason: collision with root package name */
    public final int f26271d;

    /* renamed from: e  reason: collision with root package name */
    public final Exception f26272e;

    public c(Exception exc) {
        this.f26268a = -777;
        this.f26269b = -777;
        this.f26270c = exc.getMessage();
        this.f26271d = 500;
        this.f26272e = exc;
    }

    public int a() {
        return this.f26269b;
    }

    public String b() {
        return this.f26270c;
    }

    public Exception c() {
        return this.f26272e;
    }

    public int d() {
        return this.f26271d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (a() == cVar.a() && d() == cVar.d()) {
            return b().equals(cVar.b());
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ErrorResult{errorCode=");
        sb2.append(this.f26269b);
        sb2.append(", errorMessage='");
        sb2.append(this.f26270c);
        sb2.append('\'');
        sb2.append(", exception='");
        Exception exc = this.f26272e;
        sb2.append(exc != null ? exc.toString() : null);
        sb2.append('\'');
        sb2.append('}');
        return sb2.toString();
    }

    public c(ResponseStatusError responseStatusError) {
        this.f26268a = -777;
        this.f26269b = responseStatusError.getErrorCode();
        this.f26270c = responseStatusError.getErrorMsg();
        this.f26271d = responseStatusError.getHttpStatusCode();
        this.f26272e = responseStatusError;
    }
}
