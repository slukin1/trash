package jumio.core;

import java.io.InputStream;
import kotlin.jvm.internal.x;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public final int f56121a;

    /* renamed from: b  reason: collision with root package name */
    public final int f56122b;

    /* renamed from: c  reason: collision with root package name */
    public final InputStream f56123c;

    public a1(int i11, int i12, InputStream inputStream) {
        this.f56121a = i11;
        this.f56122b = i12;
        this.f56123c = inputStream;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return this.f56121a == a1Var.f56121a && this.f56122b == a1Var.f56122b && x.b(this.f56123c, a1Var.f56123c);
    }

    public final int hashCode() {
        int a11 = p1.a(this.f56122b, this.f56121a * 31, 31);
        InputStream inputStream = this.f56123c;
        return a11 + (inputStream == null ? 0 : inputStream.hashCode());
    }

    public final String toString() {
        int i11 = this.f56121a;
        int i12 = this.f56122b;
        InputStream inputStream = this.f56123c;
        return "DownloadResponse(code=" + i11 + ", length=" + i12 + ", stream=" + inputStream + ")";
    }
}
