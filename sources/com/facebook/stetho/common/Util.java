package com.facebook.stetho.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Util {
    /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|3|2) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:1:?, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void awaitUninterruptibly(java.util.concurrent.CountDownLatch r0) {
        /*
        L_0x0000:
            r0.await()     // Catch:{ InterruptedException -> 0x0000 }
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.Util.awaitUninterruptibly(java.util.concurrent.CountDownLatch):void");
    }

    public static void close(Closeable closeable, boolean z11) throws IOException {
        if (closeable == null) {
            return;
        }
        if (z11) {
            try {
                closeable.close();
            } catch (IOException e11) {
                LogUtil.e((Throwable) e11, "Hiding IOException because another is pending");
            }
        } else {
            closeable.close();
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static <T> T getUninterruptibly(Future<T> future, long j11, TimeUnit timeUnit) throws TimeoutException, ExecutionException {
        long millis = timeUnit.toMillis(j11);
        while (true) {
            try {
                return future.get(millis, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                millis -= System.currentTimeMillis() - System.currentTimeMillis();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|3|2) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:1:?, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void joinUninterruptibly(java.lang.Thread r0) {
        /*
        L_0x0000:
            r0.join()     // Catch:{ InterruptedException -> 0x0000 }
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.Util.joinUninterruptibly(java.lang.Thread):void");
    }

    public static String readAsUTF8(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, new byte[1024]);
        return byteArrayOutputStream.toString("UTF-8");
    }

    public static void sleepUninterruptibly(long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        do {
            try {
                Thread.sleep(j11);
                return;
            } catch (InterruptedException unused) {
                j11 -= System.currentTimeMillis() - currentTimeMillis;
                if (j11 <= 0) {
                }
            }
        } while (j11 <= 0);
    }

    public static void throwIf(boolean z11) {
        if (z11) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNot(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void throwIfNotNull(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public static <T> T throwIfNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static void throwIfNot(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T1, T2> void throwIfNull(T1 t12, T2 t22) {
        throwIfNull(t12);
        throwIfNull(t22);
    }

    public static <T1, T2, T3> void throwIfNull(T1 t12, T2 t22, T3 t32) {
        throwIfNull(t12);
        throwIfNull(t22);
        throwIfNull(t32);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:0|1|2) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T getUninterruptibly(java.util.concurrent.Future<T> r0) throws java.util.concurrent.ExecutionException {
        /*
        L_0x0000:
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x0000 }
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.Util.getUninterruptibly(java.util.concurrent.Future):java.lang.Object");
    }
}
