package pu;

import com.google.android.exoplayer2.C;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f23312a = Charset.forName(C.ASCII_NAME);

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f23313b = Charset.forName("UTF-8");

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i11 = 0;
            while (i11 < length) {
                File file2 = listFiles[i11];
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (file2.delete()) {
                    i11++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
