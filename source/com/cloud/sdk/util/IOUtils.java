package com.cloud.sdk.util;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import l4.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public enum IOUtils {
    ;
    
    private static final int BUFFER_SIZE = 4096;
    private static final Log defaultLog = null;

    /* access modifiers changed from: public */
    static {
        defaultLog = LogFactory.getLog(IOUtils.class);
    }

    public static void closeQuietly(Closeable closeable, Log log) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e11) {
                if (log == null) {
                    log = defaultLog;
                }
                if (log.isDebugEnabled()) {
                    log.debug("Ignore failure in closing the Closeable", e11);
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
        if (closeable instanceof a) {
            ((a) closeable).release();
        }
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
        return new String(toByteArray(inputStream), StringUtils.f64720a);
    }
}
