package m1;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class b {

    public static class a {
        public static void a(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        public static FileDescriptor b(FileDescriptor fileDescriptor) throws ErrnoException {
            return Os.dup(fileDescriptor);
        }

        public static long c(FileDescriptor fileDescriptor, long j11, int i11) throws ErrnoException {
            return Os.lseek(fileDescriptor, j11, i11);
        }
    }

    /* renamed from: m1.b$b  reason: collision with other inner class name */
    public static class C0090b {
        public static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            sb2.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i11])}));
        }
        return sb2.toString();
    }

    public static void b(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                a.a(fileDescriptor);
            } catch (Exception unused) {
                Log.e("ExifInterfaceUtils", "Error closing fd.");
            }
        } else {
            Log.e("ExifInterfaceUtils", "closeFileDescriptor is called in API < 21, which must be wrong.");
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static long[] d(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                jArr[i11] = (long) iArr[i11];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }

    public static int e(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i11 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i11;
            }
            i11 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    public static void f(InputStream inputStream, OutputStream outputStream, int i11) throws IOException {
        byte[] bArr = new byte[8192];
        while (i11 > 0) {
            int min = Math.min(i11, 8192);
            int read = inputStream.read(bArr, 0, min);
            if (read == min) {
                i11 -= read;
                outputStream.write(bArr, 0, read);
            } else {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
        }
    }

    public static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }
}
