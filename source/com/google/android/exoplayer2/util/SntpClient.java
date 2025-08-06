package com.google.android.exoplayer2.util;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

public final class SntpClient {
    public static final String DEFAULT_NTP_HOST = "time.android.com";
    private static final int NTP_LEAP_NOSYNC = 3;
    private static final int NTP_MODE_BROADCAST = 5;
    private static final int NTP_MODE_CLIENT = 3;
    private static final int NTP_MODE_SERVER = 4;
    private static final int NTP_PACKET_SIZE = 48;
    private static final int NTP_PORT = 123;
    private static final int NTP_STRATUM_DEATH = 0;
    private static final int NTP_STRATUM_MAX = 15;
    private static final int NTP_VERSION = 3;
    private static final long OFFSET_1900_TO_1970 = 2208988800L;
    private static final int ORIGINATE_TIME_OFFSET = 24;
    private static final int RECEIVE_TIME_OFFSET = 32;
    private static final int TIMEOUT_MS = 10000;
    private static final int TRANSMIT_TIME_OFFSET = 40;
    /* access modifiers changed from: private */
    public static long elapsedRealtimeOffsetMs = 0;
    /* access modifiers changed from: private */
    public static boolean isInitialized = false;
    /* access modifiers changed from: private */
    public static final Object loaderLock = new Object();
    private static String ntpHost = "time.android.com";
    /* access modifiers changed from: private */
    public static final Object valueLock = new Object();

    public interface InitializationCallback {
        void onInitializationFailed(IOException iOException);

        void onInitialized();
    }

    public static final class NtpTimeCallback implements Loader.Callback<Loader.Loadable> {
        private final InitializationCallback callback;

        public NtpTimeCallback(InitializationCallback initializationCallback) {
            this.callback = initializationCallback;
        }

        public void onLoadCanceled(Loader.Loadable loadable, long j11, long j12, boolean z11) {
        }

        public void onLoadCompleted(Loader.Loadable loadable, long j11, long j12) {
            if (this.callback == null) {
                return;
            }
            if (!SntpClient.isInitialized()) {
                this.callback.onInitializationFailed(new IOException(new ConcurrentModificationException()));
            } else {
                this.callback.onInitialized();
            }
        }

        public Loader.LoadErrorAction onLoadError(Loader.Loadable loadable, long j11, long j12, IOException iOException, int i11) {
            InitializationCallback initializationCallback = this.callback;
            if (initializationCallback != null) {
                initializationCallback.onInitializationFailed(iOException);
            }
            return Loader.DONT_RETRY;
        }
    }

    public static final class NtpTimeLoadable implements Loader.Loadable {
        private NtpTimeLoadable() {
        }

        public void cancelLoad() {
        }

        public void load() throws IOException {
            synchronized (SntpClient.loaderLock) {
                synchronized (SntpClient.valueLock) {
                    if (!SntpClient.isInitialized) {
                        long access$400 = SntpClient.loadNtpTimeOffsetMs();
                        synchronized (SntpClient.valueLock) {
                            long unused = SntpClient.elapsedRealtimeOffsetMs = access$400;
                            boolean unused2 = SntpClient.isInitialized = true;
                        }
                    }
                }
            }
        }
    }

    private SntpClient() {
    }

    private static void checkValidServerReply(byte b11, byte b12, int i11, long j11) throws IOException {
        if (b11 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        } else if (b12 != 4 && b12 != 5) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("SNTP: Untrusted mode: ");
            sb2.append(b12);
            throw new IOException(sb2.toString());
        } else if (i11 == 0 || i11 > 15) {
            StringBuilder sb3 = new StringBuilder(36);
            sb3.append("SNTP: Untrusted stratum: ");
            sb3.append(i11);
            throw new IOException(sb3.toString());
        } else if (j11 == 0) {
            throw new IOException("SNTP: Zero transmitTime");
        }
    }

    public static long getElapsedRealtimeOffsetMs() {
        long j11;
        synchronized (valueLock) {
            j11 = isInitialized ? elapsedRealtimeOffsetMs : -9223372036854775807L;
        }
        return j11;
    }

    public static String getNtpHost() {
        String str;
        synchronized (valueLock) {
            str = ntpHost;
        }
        return str;
    }

    public static void initialize(Loader loader, InitializationCallback initializationCallback) {
        if (!isInitialized()) {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.startLoading(new NtpTimeLoadable(), new NtpTimeCallback(initializationCallback), 1);
        } else if (initializationCallback != null) {
            initializationCallback.onInitialized();
        }
    }

    public static boolean isInitialized() {
        boolean z11;
        synchronized (valueLock) {
            z11 = isInitialized;
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public static long loadNtpTimeOffsetMs() throws IOException {
        InetAddress byName = InetAddress.getByName(getNtpHost());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = Ascii.ESC;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            writeTimestamp(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j11 = currentTimeMillis + (elapsedRealtime2 - elapsedRealtime);
            long readTimestamp = readTimestamp(bArr, 24);
            long readTimestamp2 = readTimestamp(bArr, 32);
            long readTimestamp3 = readTimestamp(bArr, 40);
            checkValidServerReply((byte) ((bArr[0] >> 6) & 3), (byte) (bArr[0] & 7), bArr[1] & 255, readTimestamp3);
            long j12 = (j11 + (((readTimestamp2 - readTimestamp) + (readTimestamp3 - j11)) / 2)) - elapsedRealtime2;
            datagramSocket.close();
            return j12;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private static long read32(byte[] bArr, int i11) {
        byte b11 = bArr[i11];
        byte b12 = bArr[i11 + 1];
        byte b13 = bArr[i11 + 2];
        byte b14 = bArr[i11 + 3];
        byte b15 = b11 & true;
        int i12 = b11;
        if (b15 == true) {
            i12 = (b11 & Ascii.DEL) + 128;
        }
        byte b16 = b12 & true;
        int i13 = b12;
        if (b16 == true) {
            i13 = (b12 & Ascii.DEL) + 128;
        }
        byte b17 = b13 & true;
        int i14 = b13;
        if (b17 == true) {
            i14 = (b13 & Ascii.DEL) + 128;
        }
        byte b18 = b14 & true;
        int i15 = b14;
        if (b18 == true) {
            i15 = (b14 & Ascii.DEL) + 128;
        }
        return (((long) i12) << 24) + (((long) i13) << 16) + (((long) i14) << 8) + ((long) i15);
    }

    private static long readTimestamp(byte[] bArr, int i11) {
        long read32 = read32(bArr, i11);
        long read322 = read32(bArr, i11 + 4);
        if (read32 == 0 && read322 == 0) {
            return 0;
        }
        return ((read32 - OFFSET_1900_TO_1970) * 1000) + ((read322 * 1000) / 4294967296L);
    }

    public static void setNtpHost(String str) {
        synchronized (valueLock) {
            if (!ntpHost.equals(str)) {
                ntpHost = str;
                isInitialized = false;
            }
        }
    }

    private static void writeTimestamp(byte[] bArr, int i11, long j11) {
        if (j11 == 0) {
            Arrays.fill(bArr, i11, i11 + 8, (byte) 0);
            return;
        }
        long j12 = j11 / 1000;
        long j13 = j12 + OFFSET_1900_TO_1970;
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((int) (j13 >> 24));
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((int) (j13 >> 16));
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((int) (j13 >> 8));
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((int) (j13 >> 0));
        long j14 = ((j11 - (j12 * 1000)) * 4294967296L) / 1000;
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((int) (j14 >> 24));
        int i17 = i16 + 1;
        bArr[i16] = (byte) ((int) (j14 >> 16));
        bArr[i17] = (byte) ((int) (j14 >> 8));
        bArr[i17 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }
}
