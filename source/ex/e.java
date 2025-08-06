package ex;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Map;

public final class e {
    public static byte[] a(File file, int i11) {
        ByteBuffer byteBuffer;
        Map<Integer, ByteBuffer> b11 = b(file);
        if (b11 == null || (byteBuffer = b11.get(Integer.valueOf(i11))) == null) {
            return null;
        }
        return c(byteBuffer);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:12|(2:20|21)|(2:24|25)|26|27) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:0|(7:1|2|3|4|5|6|(2:8|9))|10|11|36|(2:(0)|(0))) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x003f, code lost:
        if (r1 == null) goto L_0x0042;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0037 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002f A[SYNTHETIC, Splitter:B:20:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034 A[SYNTHETIC, Splitter:B:24:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x003c A[SYNTHETIC, Splitter:B:32:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[ExcHandler: SignatureNotFoundException (unused com.meituan.android.walle.SignatureNotFoundException), SYNTHETIC, Splitter:B:10:0x001f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.Integer, java.nio.ByteBuffer> b(java.io.File r3) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0038, all -> 0x002a }
            java.lang.String r2 = "r"
            r1.<init>(r3, r2)     // Catch:{ IOException -> 0x0038, all -> 0x002a }
            java.nio.channels.FileChannel r3 = r1.getChannel()     // Catch:{ IOException -> 0x0028, all -> 0x0025 }
            ex.d r2 = ex.a.b(r3)     // Catch:{ IOException -> 0x003a, all -> 0x0023 }
            java.lang.Object r2 = r2.a()     // Catch:{ IOException -> 0x003a, all -> 0x0023 }
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch:{ IOException -> 0x003a, all -> 0x0023 }
            java.util.Map r0 = ex.a.f(r2)     // Catch:{ IOException -> 0x003a, all -> 0x0023 }
            if (r3 == 0) goto L_0x001f
            r3.close()     // Catch:{ IOException -> 0x001f }
        L_0x001f:
            r1.close()     // Catch:{ SignatureNotFoundException -> 0x0042, SignatureNotFoundException -> 0x0042 }
            goto L_0x0042
        L_0x0023:
            r2 = move-exception
            goto L_0x002d
        L_0x0025:
            r2 = move-exception
            r3 = r0
            goto L_0x002d
        L_0x0028:
            r3 = r0
            goto L_0x003a
        L_0x002a:
            r2 = move-exception
            r3 = r0
            r1 = r3
        L_0x002d:
            if (r3 == 0) goto L_0x0032
            r3.close()     // Catch:{ IOException -> 0x0032 }
        L_0x0032:
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            throw r2     // Catch:{  }
        L_0x0038:
            r3 = r0
            r1 = r3
        L_0x003a:
            if (r3 == 0) goto L_0x003f
            r3.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            if (r1 == 0) goto L_0x0042
            goto L_0x001f
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ex.e.b(java.io.File):java.util.Map");
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String d(File file, int i11) {
        byte[] a11 = a(file, i11);
        if (a11 == null) {
            return null;
        }
        try {
            return new String(a11, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
