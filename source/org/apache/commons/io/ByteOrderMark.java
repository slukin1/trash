package org.apache.commons.io;

import com.google.android.exoplayer2.C;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ByteOrderMark implements Serializable {
    public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", 254, 255);
    public static final ByteOrderMark UTF_16LE = new ByteOrderMark(C.UTF16LE_NAME, 255, 254);
    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0, 0, 254, 255);
    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 255, 254, 0, 0);
    public static final ByteOrderMark UTF_8 = new ByteOrderMark("UTF-8", TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 187, 191);
    public static final char UTF_BOM = '﻿';
    private static final long serialVersionUID = 1;
    private final int[] bytes;
    private final String charsetName;

    public ByteOrderMark(String str, int... iArr) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("No charsetName specified");
        } else if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        } else {
            this.charsetName = str;
            int[] iArr2 = new int[iArr.length];
            this.bytes = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark byteOrderMark = (ByteOrderMark) obj;
        if (this.bytes.length != byteOrderMark.length()) {
            return false;
        }
        int i11 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i11 >= iArr.length) {
                return true;
            }
            if (iArr[i11] != byteOrderMark.get(i11)) {
                return false;
            }
            i11++;
        }
    }

    public int get(int i11) {
        return this.bytes[i11];
    }

    public byte[] getBytes() {
        byte[] bArr = new byte[this.bytes.length];
        int i11 = 0;
        while (true) {
            int[] iArr = this.bytes;
            if (i11 >= iArr.length) {
                return bArr;
            }
            bArr[i11] = (byte) iArr[i11];
            i11++;
        }
    }

    public String getCharsetName() {
        return this.charsetName;
    }

    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (int i11 : this.bytes) {
            hashCode += i11;
        }
        return hashCode;
    }

    public int length() {
        return this.bytes.length;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        sb2.append(this.charsetName);
        sb2.append(l.f34627b);
        for (int i11 = 0; i11 < this.bytes.length; i11++) {
            if (i11 > 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.bytes[i11] & 255).toUpperCase());
        }
        sb2.append(']');
        return sb2.toString();
    }
}
