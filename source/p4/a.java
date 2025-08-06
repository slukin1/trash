package p4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66556a = new a();

    public final int a(byte[] bArr) {
        return new m1.a((InputStream) new ByteArrayInputStream(bArr)).s();
    }

    public final int b(byte[] bArr) {
        try {
            return a(bArr);
        } catch (Exception unused) {
            return 0;
        }
    }
}
