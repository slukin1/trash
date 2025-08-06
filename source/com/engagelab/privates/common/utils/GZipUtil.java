package com.engagelab.privates.common.utils;

import com.engagelab.privates.common.log.MTCommonLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZipUtil {
    private static final String TAG = "GZipUtil";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th2) {
                MTCommonLog.w(TAG, "closeQuietly failed " + th2.getMessage());
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static byte[] unzip(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    closeQuietly(byteArrayOutputStream);
                    closeQuietly(byteArrayInputStream);
                    closeQuietly(gZIPInputStream);
                    return byteArray;
                }
            }
        } catch (Throwable th2) {
            closeQuietly(byteArrayOutputStream);
            closeQuietly(byteArrayInputStream);
            closeQuietly(gZIPInputStream);
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public static byte[] zip(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            closeQuietly(byteArrayOutputStream);
            closeQuietly(gZIPOutputStream);
            return byteArray;
        } catch (Throwable th2) {
            closeQuietly(byteArrayOutputStream);
            closeQuietly(gZIPOutputStream);
            throw th2;
        }
    }
}
