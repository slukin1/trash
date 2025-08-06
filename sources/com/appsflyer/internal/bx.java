package com.appsflyer.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class bx extends FilterInputStream {
    private final int AFInAppEventParameterName;
    private short AFInAppEventType;
    private long[] AFKeystoreWrapper;
    private int AppsFlyer2dXConversionCallback = Integer.MAX_VALUE;
    private int getLevel;
    private int init;
    private byte[] valueOf;
    private long[] values;

    public bx(InputStream inputStream, int i11, int i12, short s11, int i13, int i14) throws IOException {
        super(inputStream);
        int min = Math.min(Math.max(s11, 4), 8);
        this.AFInAppEventParameterName = min;
        this.valueOf = new byte[min];
        this.AFKeystoreWrapper = new long[4];
        this.values = new long[4];
        this.getLevel = min;
        this.init = min;
        this.AFKeystoreWrapper = cb.values(i11 ^ i14, min ^ i14);
        this.values = cb.values(i12 ^ i14, i13 ^ i14);
    }

    private void AFInAppEventParameterName() {
        long[] jArr = this.AFKeystoreWrapper;
        long[] jArr2 = this.values;
        short s11 = this.AFInAppEventType;
        int i11 = (s11 + 2) % 4;
        int i12 = (s11 + 3) % 4;
        jArr2[i12] = ((jArr[i12] * 2147483085) + jArr2[i11]) / 2147483647L;
        jArr[i12] = ((jArr[s11 % 4] * 2147483085) + jArr2[i11]) % 2147483647L;
        for (int i13 = 0; i13 < this.AFInAppEventParameterName; i13++) {
            byte[] bArr = this.valueOf;
            bArr[i13] = (byte) ((int) (((long) bArr[i13]) ^ ((this.AFKeystoreWrapper[this.AFInAppEventType] >> (i13 << 3)) & 255)));
        }
        this.AFInAppEventType = (short) ((this.AFInAppEventType + 1) % 4);
    }

    private int AFKeystoreWrapper() throws IOException {
        int read;
        int i11;
        if (this.AppsFlyer2dXConversionCallback == Integer.MAX_VALUE) {
            this.AppsFlyer2dXConversionCallback = this.in.read();
        }
        if (this.getLevel == this.AFInAppEventParameterName) {
            byte[] bArr = this.valueOf;
            int i12 = this.AppsFlyer2dXConversionCallback;
            bArr[0] = (byte) i12;
            if (i12 >= 0) {
                int i13 = 1;
                do {
                    read = this.in.read(this.valueOf, i13, this.AFInAppEventParameterName - i13);
                    if (read <= 0 || (i13 = i13 + read) >= this.AFInAppEventParameterName) {
                    }
                    read = this.in.read(this.valueOf, i13, this.AFInAppEventParameterName - i13);
                    break;
                } while ((i13 = i13 + read) >= this.AFInAppEventParameterName);
                if (i13 >= this.AFInAppEventParameterName) {
                    AFInAppEventParameterName();
                    int read2 = this.in.read();
                    this.AppsFlyer2dXConversionCallback = read2;
                    this.getLevel = 0;
                    if (read2 < 0) {
                        int i14 = this.AFInAppEventParameterName;
                        i11 = i14 - (this.valueOf[i14 - 1] & 255);
                    } else {
                        i11 = this.AFInAppEventParameterName;
                    }
                    this.init = i11;
                } else {
                    throw new IllegalStateException("unexpected block size");
                }
            } else {
                throw new IllegalStateException("unexpected block size");
            }
        }
        return this.init;
    }

    public final int available() throws IOException {
        AFKeystoreWrapper();
        return this.init - this.getLevel;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        AFKeystoreWrapper();
        int i11 = this.getLevel;
        if (i11 >= this.init) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.getLevel = i11 + 1;
        return bArr[i11] & 255;
    }

    public final long skip(long j11) throws IOException {
        long j12 = 0;
        while (j12 < j11 && read() != -1) {
            j12++;
        }
        return j12;
    }

    public final int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = i11 + i12;
        int i14 = i11;
        while (i14 < i13) {
            AFKeystoreWrapper();
            int i15 = this.getLevel;
            if (i15 < this.init) {
                byte[] bArr2 = this.valueOf;
                this.getLevel = i15 + 1;
                bArr[i14] = bArr2[i15];
                i14++;
            } else if (i14 == i11) {
                return -1;
            } else {
                return i12 - (i13 - i14);
            }
        }
        return i12;
    }
}
