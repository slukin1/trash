package com.appsflyer.internal;

import com.google.common.base.Ascii;
import com.huobi.view.roundimg.RoundedDrawable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ca extends FilterInputStream {
    private static final short AFInAppEventParameterName = ((short) ((int) ((Math.sqrt(5.0d) - 1.0d) * Math.pow(2.0d, 15.0d))));
    private byte[] AFInAppEventType = new byte[8];
    private int AFKeystoreWrapper = 8;
    private int AFLogger$LogLevel;
    private int AFVersionDeclaration = Integer.MAX_VALUE;
    private int AppsFlyer2dXConversionCallback;
    private int getLevel = 8;
    private int init;
    private int onAppOpenAttributionNative;
    private int onAttributionFailureNative;
    private int onDeepLinkingNative;
    private byte[] valueOf = new byte[8];
    private byte[] values = new byte[8];

    public ca(InputStream inputStream, int[] iArr, int i11, byte[] bArr, int i12, int i13) throws IOException {
        super(inputStream);
        this.init = Math.min(Math.max(i12, 5), 16);
        this.AppsFlyer2dXConversionCallback = i13;
        if (i13 == 3) {
            System.arraycopy(bArr, 0, this.values, 0, 8);
        }
        long j11 = ((((long) iArr[0]) & 4294967295L) << 32) | (4294967295L & ((long) iArr[1]));
        if (i11 == 0) {
            this.AFLogger$LogLevel = (int) j11;
            long j12 = j11 >> 3;
            short s11 = AFInAppEventParameterName;
            this.onAppOpenAttributionNative = (int) ((((long) s11) * j12) >> 32);
            this.onAttributionFailureNative = (int) (j11 >> 32);
            this.onDeepLinkingNative = (int) (j12 + ((long) s11));
            return;
        }
        int i14 = (int) j11;
        this.AFLogger$LogLevel = i14;
        this.onAppOpenAttributionNative = i14 * i11;
        this.onAttributionFailureNative = i14 ^ i11;
        this.onDeepLinkingNative = (int) (j11 >> 32);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int valueOf() throws java.io.IOException {
        /*
            r7 = this;
            int r0 = r7.AFVersionDeclaration
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 != r1) goto L_0x000f
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.AFVersionDeclaration = r0
        L_0x000f:
            int r0 = r7.AFKeystoreWrapper
            r1 = 8
            if (r0 != r1) goto L_0x0059
            byte[] r0 = r7.valueOf
            int r2 = r7.AFVersionDeclaration
            byte r3 = (byte) r2
            r4 = 0
            r0[r4] = r3
            java.lang.String r0 = "unexpected block size"
            if (r2 < 0) goto L_0x0053
            r2 = 1
        L_0x0022:
            java.io.InputStream r3 = r7.in
            byte[] r5 = r7.valueOf
            int r6 = 8 - r2
            int r3 = r3.read(r5, r2, r6)
            if (r3 <= 0) goto L_0x0031
            int r2 = r2 + r3
            if (r2 < r1) goto L_0x0022
        L_0x0031:
            if (r2 < r1) goto L_0x004d
            r7.values()
            java.io.InputStream r0 = r7.in
            int r0 = r0.read()
            r7.AFVersionDeclaration = r0
            r7.AFKeystoreWrapper = r4
            if (r0 >= 0) goto L_0x004a
            byte[] r0 = r7.valueOf
            r2 = 7
            byte r0 = r0[r2]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r1 = r1 - r0
        L_0x004a:
            r7.getLevel = r1
            goto L_0x0059
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>(r0)
            throw r1
        L_0x0059:
            int r0 = r7.getLevel
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ca.valueOf():int");
    }

    private void values() {
        if (this.AppsFlyer2dXConversionCallback == 3) {
            byte[] bArr = this.valueOf;
            System.arraycopy(bArr, 0, this.AFInAppEventType, 0, bArr.length);
        }
        byte[] bArr2 = this.valueOf;
        int i11 = ((bArr2[0] << Ascii.CAN) & RoundedDrawable.DEFAULT_BORDER_COLOR) + ((bArr2[1] << 16) & 16711680) + ((bArr2[2] << 8) & 65280) + (bArr2[3] & 255);
        int i12 = (-16777216 & (bArr2[4] << Ascii.CAN)) + (16711680 & (bArr2[5] << 16)) + (65280 & (bArr2[6] << 8)) + (bArr2[7] & 255);
        int i13 = 0;
        while (true) {
            int i14 = this.init;
            if (i13 >= i14) {
                break;
            }
            short s11 = AFInAppEventParameterName;
            i12 -= ((((i14 - i13) * s11) + i11) ^ ((i11 << 4) + this.onAttributionFailureNative)) ^ ((i11 >>> 5) + this.onDeepLinkingNative);
            i11 -= (((i12 << 4) + this.AFLogger$LogLevel) ^ ((s11 * (i14 - i13)) + i12)) ^ ((i12 >>> 5) + this.onAppOpenAttributionNative);
            i13++;
        }
        byte[] bArr3 = this.valueOf;
        bArr3[0] = (byte) (i11 >> 24);
        bArr3[1] = (byte) (i11 >> 16);
        bArr3[2] = (byte) (i11 >> 8);
        bArr3[3] = (byte) i11;
        bArr3[4] = (byte) (i12 >> 24);
        bArr3[5] = (byte) (i12 >> 16);
        bArr3[6] = (byte) (i12 >> 8);
        bArr3[7] = (byte) i12;
        if (this.AppsFlyer2dXConversionCallback == 3) {
            for (int i15 = 0; i15 < 8; i15++) {
                byte[] bArr4 = this.valueOf;
                bArr4[i15] = (byte) (bArr4[i15] ^ this.values[i15]);
            }
            byte[] bArr5 = this.AFInAppEventType;
            System.arraycopy(bArr5, 0, this.values, 0, bArr5.length);
        }
    }

    public final int available() throws IOException {
        valueOf();
        return this.getLevel - this.AFKeystoreWrapper;
    }

    public final boolean markSupported() {
        return false;
    }

    public final int read() throws IOException {
        valueOf();
        int i11 = this.AFKeystoreWrapper;
        if (i11 >= this.getLevel) {
            return -1;
        }
        byte[] bArr = this.valueOf;
        this.AFKeystoreWrapper = i11 + 1;
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
            valueOf();
            int i15 = this.AFKeystoreWrapper;
            if (i15 < this.getLevel) {
                byte[] bArr2 = this.valueOf;
                this.AFKeystoreWrapper = i15 + 1;
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
