package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum IOUtils {
    ;
    
    private static final int BUFFER_SIZE = 4096;
    private static final Log logger = null;

    /* access modifiers changed from: public */
    static {
        logger = LogFactory.b(IOUtils.class);
    }

    public static void closeQuietly(Closeable closeable, Log log) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                if (logger.i()) {
                    logger.d("Ignore failure in closing the Closeable", e11);
                }
            }
        }
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j11 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= -1) {
                return j11;
            }
            outputStream.write(bArr, 0, read);
            j11 += (long) read;
        }
    }

    public static void release(Closeable closeable, Log log) {
        closeQuietly(closeable, log);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            byteArrayOutputStream.close();
        }
    }

    public static String toString(InputStream inputStream) throws IOException {
        return new String(toByteArray(inputStream), StringUtils.f15560a);
    }
}
