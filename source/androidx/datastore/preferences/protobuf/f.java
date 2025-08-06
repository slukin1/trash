package androidx.datastore.preferences.protobuf;

import com.appsflyer.AppsFlyerProperties;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SoftReference<byte[]>> f9107a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final Class<?> f9108b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f9109c;

    static {
        Class<?> e11 = e("java.io.FileOutputStream");
        f9108b = e11;
        f9109c = b(e11);
    }

    public static byte[] a() {
        SoftReference softReference = f9107a.get();
        if (softReference == null) {
            return null;
        }
        return (byte[]) softReference.get();
    }

    public static long b(Class<?> cls) {
        if (cls == null) {
            return -1;
        }
        try {
            if (c1.G()) {
                return c1.I(cls.getDeclaredField(AppsFlyerProperties.CHANNEL));
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static byte[] c(int i11) {
        int max = Math.max(i11, 1024);
        byte[] a11 = a();
        if (a11 == null || d(max, a11.length)) {
            a11 = new byte[max];
            if (max <= 16384) {
                f(a11);
            }
        }
        return a11;
    }

    public static boolean d(int i11, int i12) {
        return i12 < i11 && ((float) i12) < ((float) i11) * 0.5f;
    }

    public static Class<?> e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static void f(byte[] bArr) {
        f9107a.set(new SoftReference(bArr));
    }

    public static void g(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        int position = byteBuffer.position();
        try {
            if (byteBuffer.hasArray()) {
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            } else if (!h(byteBuffer, outputStream)) {
                byte[] c11 = c(byteBuffer.remaining());
                while (byteBuffer.hasRemaining()) {
                    int min = Math.min(byteBuffer.remaining(), c11.length);
                    byteBuffer.get(c11, 0, min);
                    outputStream.write(c11, 0, min);
                }
            }
        } finally {
            byteBuffer.position(position);
        }
    }

    public static boolean h(ByteBuffer byteBuffer, OutputStream outputStream) throws IOException {
        long j11 = f9109c;
        if (j11 < 0 || !f9108b.isInstance(outputStream)) {
            return false;
        }
        WritableByteChannel writableByteChannel = null;
        try {
            writableByteChannel = (WritableByteChannel) c1.E(outputStream, j11);
        } catch (ClassCastException unused) {
        }
        if (writableByteChannel == null) {
            return false;
        }
        writableByteChannel.write(byteBuffer);
        return true;
    }
}
