package okio;

import com.tencent.android.tpush.common.Constants;
import okio.Buffer;
import okio.internal.ByteString;

/* renamed from: okio.-SegmentedByteString  reason: invalid class name */
public final class SegmentedByteString {
    private static final int DEFAULT__ByteString_size = -1234567890;
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();

    public static final int and(byte b11, int i11) {
        return b11 & i11;
    }

    public static final long and(byte b11, long j11) {
        return ((long) b11) & j11;
    }

    public static final long and(int i11, long j11) {
        return ((long) i11) & j11;
    }

    public static final boolean arrayRangeEquals(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            if (bArr[i14 + i11] != bArr2[i14 + i12]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException("size=" + j11 + " offset=" + j12 + " byteCount=" + j13);
        }
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    public static final int leftRotate(int i11, int i12) {
        return (i11 >>> (32 - i12)) | (i11 << i12);
    }

    public static final long minOf(long j11, int i11) {
        return Math.min(j11, (long) i11);
    }

    public static final Buffer.UnsafeCursor resolveDefaultParameter(Buffer.UnsafeCursor unsafeCursor) {
        return unsafeCursor == DEFAULT__new_UnsafeCursor ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int reverseBytes(int i11) {
        return ((i11 & 255) << 24) | ((-16777216 & i11) >>> 24) | ((16711680 & i11) >>> 8) | ((65280 & i11) << 8);
    }

    public static final long reverseBytes(long j11) {
        return ((j11 & 255) << 56) | ((-72057594037927936L & j11) >>> 56) | ((71776119061217280L & j11) >>> 40) | ((280375465082880L & j11) >>> 24) | ((1095216660480L & j11) >>> 8) | ((4278190080L & j11) << 8) | ((16711680 & j11) << 24) | ((65280 & j11) << 40);
    }

    public static final short reverseBytes(short s11) {
        short s12 = s11 & Constants.PROTOCOL_NONE;
        return (short) (((s12 & 255) << 8) | ((65280 & s12) >>> 8));
    }

    public static final long rightRotate(long j11, int i11) {
        return (j11 << (64 - i11)) | (j11 >>> i11);
    }

    public static final int shl(byte b11, int i11) {
        return b11 << i11;
    }

    public static final int shr(byte b11, int i11) {
        return b11 >> i11;
    }

    public static final String toHexString(byte b11) {
        return StringsKt__StringsJVMKt.q(new char[]{ByteString.getHEX_DIGIT_CHARS()[(b11 >> 4) & 15], ByteString.getHEX_DIGIT_CHARS()[b11 & 15]});
    }

    public static final byte xor(byte b11, byte b12) {
        return (byte) (b11 ^ b12);
    }

    public static final long minOf(int i11, long j11) {
        return Math.min((long) i11, j11);
    }

    public static final int resolveDefaultParameter(ByteString byteString, int i11) {
        return i11 == DEFAULT__ByteString_size ? byteString.size() : i11;
    }

    public static final int resolveDefaultParameter(byte[] bArr, int i11) {
        return i11 == DEFAULT__ByteString_size ? bArr.length : i11;
    }

    public static final String toHexString(int i11) {
        if (i11 == 0) {
            return "0";
        }
        int i12 = 0;
        char[] cArr = {ByteString.getHEX_DIGIT_CHARS()[(i11 >> 28) & 15], ByteString.getHEX_DIGIT_CHARS()[(i11 >> 24) & 15], ByteString.getHEX_DIGIT_CHARS()[(i11 >> 20) & 15], ByteString.getHEX_DIGIT_CHARS()[(i11 >> 16) & 15], ByteString.getHEX_DIGIT_CHARS()[(i11 >> 12) & 15], ByteString.getHEX_DIGIT_CHARS()[(i11 >> 8) & 15], ByteString.getHEX_DIGIT_CHARS()[(i11 >> 4) & 15], ByteString.getHEX_DIGIT_CHARS()[i11 & 15]};
        while (i12 < 8 && cArr[i12] == '0') {
            i12++;
        }
        return StringsKt__StringsJVMKt.r(cArr, i12, 8);
    }

    public static final String toHexString(long j11) {
        if (j11 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 60) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 56) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 52) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 48) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 44) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 40) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 36) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 32) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 28) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 24) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 20) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 16) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 12) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 8) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j11 >> 4) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) (j11 & 15)]};
        while (i11 < 16 && cArr[i11] == '0') {
            i11++;
        }
        return StringsKt__StringsJVMKt.r(cArr, i11, 16);
    }
}
