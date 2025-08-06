package l3;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public interface a {

    /* renamed from: l3.a$a  reason: collision with other inner class name */
    public interface C0722a {
        byte[] a(int i11);

        Bitmap b(int i11, int i12, Bitmap.Config config);

        void c(Bitmap bitmap);

        int[] d(int i11);

        void e(byte[] bArr);

        void f(int[] iArr);
    }

    void a(Bitmap.Config config);

    void b();

    int c();

    void clear();

    int d();

    Bitmap e();

    void f();

    int g();

    ByteBuffer getData();

    int h();
}
