package lz;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import mz.f;
import retrofit2.Response;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public Throwable f58076a;

    /* renamed from: b  reason: collision with root package name */
    public Response f58077b;

    public b(Throwable th2) {
        this.f58076a = th2;
    }

    public static b c(Response response) {
        return new b(response);
    }

    public static b d(Throwable th2) {
        return new b(th2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f58077b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a() {
        /*
            r1 = this;
            java.lang.Throwable r0 = r1.f58076a
            if (r0 != 0) goto L_0x0010
            retrofit2.Response r0 = r1.f58077b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isSuccessful()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lz.b.a():boolean");
    }

    public boolean b() {
        Throwable th2 = this.f58076a;
        return th2 != null && (th2 instanceof IOException);
    }

    public String getReason() {
        Throwable th2 = this.f58076a;
        if (th2 != null) {
            return th2.getMessage();
        }
        StringBuilder sb2 = new StringBuilder();
        Response response = this.f58077b;
        if (response != null) {
            if (f.c(response.message())) {
                sb2.append(this.f58077b.message());
            } else {
                sb2.append(this.f58077b.code());
            }
        }
        return sb2.toString();
    }

    public String getResponseBody() {
        Response response = this.f58077b;
        if (!(response == null || response.errorBody() == null)) {
            try {
                return new String(this.f58077b.errorBody().bytes(), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                throw new AssertionError("UTF-8 must be supported");
            } catch (IOException unused2) {
            }
        }
        return "";
    }

    public String getResponseBodyType() {
        Response response = this.f58077b;
        return (response == null || response.errorBody() == null) ? "" : this.f58077b.errorBody().contentType().toString();
    }

    public int getStatus() {
        Response response = this.f58077b;
        if (response != null) {
            return response.code();
        }
        return -1;
    }

    public String getUrl() {
        Response response = this.f58077b;
        return (response == null || response.raw().request() == null || this.f58077b.raw().request().url() == null) ? "" : this.f58077b.raw().request().url().toString();
    }

    public b(Response response) {
        this.f58077b = response;
    }
}
