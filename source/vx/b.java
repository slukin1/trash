package vx;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class b {

    public interface a {
        boolean a(int i11, int i12);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean b(InputStream inputStream, OutputStream outputStream, a aVar, int i11) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i11];
        if (d(aVar, 0, available)) {
            return false;
        }
        int i12 = 0;
        do {
            int read = inputStream.read(bArr, 0, i11);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i12 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!d(aVar, i12, available));
        return false;
    }

    public static void c(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th2) {
                a(inputStream);
                throw th2;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        a(inputStream);
    }

    public static boolean d(a aVar, int i11, int i12) {
        return aVar != null && !aVar.a(i11, i12) && (i11 * 100) / i12 < 75;
    }
}
