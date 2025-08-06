package androidx.datastore.preferences.protobuf;

import com.google.common.base.Ascii;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import java.nio.ByteBuffer;
import net.sf.scuba.smartcards.ISO7816;

public final class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    public static final b f9050a = ((!d.m() || b.c()) ? new c() : new d());

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i11, int i12) {
            super("Unpaired surrogate at index " + i11 + " of " + i12);
        }
    }

    public static class a {
        public static void h(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) throws InvalidProtocolBufferException {
            if (m(b12) || (((b11 << 28) + (b12 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) != 0 || m(b13) || m(b14)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int r11 = ((b11 & 7) << 18) | (r(b12) << 12) | (r(b13) << 6) | r(b14);
            cArr[i11] = l(r11);
            cArr[i11 + 1] = q(r11);
        }

        public static void i(byte b11, char[] cArr, int i11) {
            cArr[i11] = (char) b11;
        }

        public static void j(byte b11, byte b12, byte b13, char[] cArr, int i11) throws InvalidProtocolBufferException {
            if (m(b12) || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || m(b13)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i11] = (char) (((b11 & 15) << 12) | (r(b12) << 6) | r(b13));
        }

        public static void k(byte b11, byte b12, char[] cArr, int i11) throws InvalidProtocolBufferException {
            if (b11 < -62 || m(b12)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i11] = (char) (((b11 & Ascii.US) << 6) | r(b12));
        }

        public static char l(int i11) {
            return (char) ((i11 >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        public static boolean m(byte b11) {
            return b11 > -65;
        }

        public static boolean n(byte b11) {
            return b11 >= 0;
        }

        public static boolean o(byte b11) {
            return b11 < -16;
        }

        public static boolean p(byte b11) {
            return b11 < -32;
        }

        public static char q(int i11) {
            return (char) ((i11 & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        public static int r(byte b11) {
            return b11 & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    public static abstract class b {
        public static int j(ByteBuffer byteBuffer, int i11, int i12) {
            int e11 = i11 + Utf8.l(byteBuffer, i11, i12);
            while (e11 < i12) {
                int i13 = e11 + 1;
                byte b11 = byteBuffer.get(e11);
                if (b11 < 0) {
                    if (b11 < -32) {
                        if (i13 >= i12) {
                            return b11;
                        }
                        if (b11 < -62 || byteBuffer.get(i13) > -65) {
                            return -1;
                        }
                        i13++;
                    } else if (b11 < -16) {
                        if (i13 >= i12 - 1) {
                            return Utf8.p(byteBuffer, b11, i13, i12 - i13);
                        }
                        int i14 = i13 + 1;
                        byte b12 = byteBuffer.get(i13);
                        if (b12 > -65 || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || byteBuffer.get(i14) > -65))) {
                            return -1;
                        }
                        e11 = i14 + 1;
                    } else if (i13 >= i12 - 2) {
                        return Utf8.p(byteBuffer, b11, i13, i12 - i13);
                    } else {
                        int i15 = i13 + 1;
                        byte b13 = byteBuffer.get(i13);
                        if (b13 <= -65 && (((b11 << 28) + (b13 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                            int i16 = i15 + 1;
                            if (byteBuffer.get(i15) <= -65) {
                                i13 = i16 + 1;
                                if (byteBuffer.get(i16) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                e11 = i13;
            }
            return 0;
        }

        public final String a(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i11, i12);
            } else if (byteBuffer.isDirect()) {
                return d(byteBuffer, i11, i12);
            } else {
                return c(byteBuffer, i11, i12);
            }
        }

        public abstract String b(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException;

        public final String c(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            if ((i11 | i12 | ((byteBuffer.limit() - i11) - i12)) >= 0) {
                int i13 = i11 + i12;
                char[] cArr = new char[i12];
                int i14 = 0;
                while (r13 < i13) {
                    byte b11 = byteBuffer.get(r13);
                    if (!a.n(b11)) {
                        break;
                    }
                    i11 = r13 + 1;
                    a.i(b11, cArr, i14);
                    i14++;
                }
                int i15 = i14;
                while (r13 < i13) {
                    int i16 = r13 + 1;
                    byte b12 = byteBuffer.get(r13);
                    if (a.n(b12)) {
                        int i17 = i15 + 1;
                        a.i(b12, cArr, i15);
                        while (i16 < i13) {
                            byte b13 = byteBuffer.get(i16);
                            if (!a.n(b13)) {
                                break;
                            }
                            i16++;
                            a.i(b13, cArr, i17);
                            i17++;
                        }
                        r13 = i16;
                        i15 = i17;
                    } else if (a.p(b12)) {
                        if (i16 < i13) {
                            a.k(b12, byteBuffer.get(i16), cArr, i15);
                            r13 = i16 + 1;
                            i15++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (a.o(b12)) {
                        if (i16 < i13 - 1) {
                            int i18 = i16 + 1;
                            a.j(b12, byteBuffer.get(i16), byteBuffer.get(i18), cArr, i15);
                            r13 = i18 + 1;
                            i15++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i16 < i13 - 2) {
                        int i19 = i16 + 1;
                        byte b14 = byteBuffer.get(i16);
                        int i21 = i19 + 1;
                        a.h(b12, b14, byteBuffer.get(i19), byteBuffer.get(i21), cArr, i15);
                        r13 = i21 + 1;
                        i15 = i15 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i15);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)}));
        }

        public abstract String d(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException;

        public abstract int e(CharSequence charSequence, byte[] bArr, int i11, int i12);

        public final boolean f(ByteBuffer byteBuffer, int i11, int i12) {
            return h(0, byteBuffer, i11, i12) == 0;
        }

        public final boolean g(byte[] bArr, int i11, int i12) {
            return i(0, bArr, i11, i12) == 0;
        }

        public final int h(int i11, ByteBuffer byteBuffer, int i12, int i13) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return i(i11, byteBuffer.array(), i12 + arrayOffset, arrayOffset + i13);
            } else if (byteBuffer.isDirect()) {
                return l(i11, byteBuffer, i12, i13);
            } else {
                return k(i11, byteBuffer, i12, i13);
            }
        }

        public abstract int i(int i11, byte[] bArr, int i12, int i13);

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008b, code lost:
            if (r8.get(r9) > -65) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int k(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x008e
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001e
                r7 = -62
                if (r0 < r7) goto L_0x001d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
                goto L_0x001d
            L_0x001a:
                r9 = r7
                goto L_0x008e
            L_0x001d:
                return r2
            L_0x001e:
                r4 = -16
                if (r0 >= r4) goto L_0x004f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0038
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L_0x0035
                int r7 = androidx.datastore.preferences.protobuf.Utf8.n(r0, r9)
                return r7
            L_0x0035:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0038:
                if (r7 > r3) goto L_0x004e
                r4 = -96
                if (r0 != r1) goto L_0x0040
                if (r7 < r4) goto L_0x004e
            L_0x0040:
                r1 = -19
                if (r0 != r1) goto L_0x0046
                if (r7 >= r4) goto L_0x004e
            L_0x0046:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x004e:
                return r2
            L_0x004f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x0065
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L_0x0063
                int r7 = androidx.datastore.preferences.protobuf.Utf8.n(r0, r1)
                return r7
            L_0x0063:
                r9 = r7
                goto L_0x0068
            L_0x0065:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0068:
                if (r4 != 0) goto L_0x0078
                int r7 = r9 + 1
                byte r4 = r8.get(r9)
                if (r7 < r10) goto L_0x0077
                int r7 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r1, r4)
                return r7
            L_0x0077:
                r9 = r7
            L_0x0078:
                if (r1 > r3) goto L_0x008d
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x008d
                if (r4 > r3) goto L_0x008d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L_0x001a
            L_0x008d:
                return r2
            L_0x008e:
                int r7 = j(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.b.k(int, java.nio.ByteBuffer, int, int):int");
        }

        public abstract int l(int i11, ByteBuffer byteBuffer, int i12, int i13);
    }

    public static final class c extends b {
        public static int m(byte[] bArr, int i11, int i12) {
            while (i11 < i12 && bArr[i11] >= 0) {
                i11++;
            }
            if (i11 >= i12) {
                return 0;
            }
            return n(bArr, i11, i12);
        }

        public static int n(byte[] bArr, int i11, int i12) {
            while (i11 < i12) {
                int i13 = i11 + 1;
                byte b11 = bArr[i11];
                if (b11 < 0) {
                    if (b11 < -32) {
                        if (i13 >= i12) {
                            return b11;
                        }
                        if (b11 >= -62) {
                            i11 = i13 + 1;
                            if (bArr[i13] > -65) {
                            }
                        }
                        return -1;
                    } else if (b11 < -16) {
                        if (i13 >= i12 - 1) {
                            return Utf8.q(bArr, i13, i12);
                        }
                        int i14 = i13 + 1;
                        byte b12 = bArr[i13];
                        if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                            i11 = i14 + 1;
                            if (bArr[i14] > -65) {
                            }
                        }
                        return -1;
                    } else if (i13 >= i12 - 2) {
                        return Utf8.q(bArr, i13, i12);
                    } else {
                        int i15 = i13 + 1;
                        byte b13 = bArr[i13];
                        if (b13 <= -65 && (((b11 << 28) + (b13 + ISO7816.INS_MANAGE_CHANNEL)) >> 30) == 0) {
                            int i16 = i15 + 1;
                            if (bArr[i15] <= -65) {
                                i13 = i16 + 1;
                                if (bArr[i16] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i11 = i13;
            }
            return 0;
        }

        public String b(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            if ((i11 | i12 | ((bArr.length - i11) - i12)) >= 0) {
                int i13 = i11 + i12;
                char[] cArr = new char[i12];
                int i14 = 0;
                while (r13 < i13) {
                    byte b11 = bArr[r13];
                    if (!a.n(b11)) {
                        break;
                    }
                    i11 = r13 + 1;
                    a.i(b11, cArr, i14);
                    i14++;
                }
                int i15 = i14;
                while (r13 < i13) {
                    int i16 = r13 + 1;
                    byte b12 = bArr[r13];
                    if (a.n(b12)) {
                        int i17 = i15 + 1;
                        a.i(b12, cArr, i15);
                        while (i16 < i13) {
                            byte b13 = bArr[i16];
                            if (!a.n(b13)) {
                                break;
                            }
                            i16++;
                            a.i(b13, cArr, i17);
                            i17++;
                        }
                        r13 = i16;
                        i15 = i17;
                    } else if (a.p(b12)) {
                        if (i16 < i13) {
                            a.k(b12, bArr[i16], cArr, i15);
                            r13 = i16 + 1;
                            i15++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (a.o(b12)) {
                        if (i16 < i13 - 1) {
                            int i18 = i16 + 1;
                            a.j(b12, bArr[i16], bArr[i18], cArr, i15);
                            r13 = i18 + 1;
                            i15++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i16 < i13 - 2) {
                        int i19 = i16 + 1;
                        byte b14 = bArr[i16];
                        int i21 = i19 + 1;
                        a.h(b12, b14, bArr[i19], bArr[i21], cArr, i15);
                        r13 = i21 + 1;
                        i15 = i15 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i15);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
        }

        public String d(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            return c(byteBuffer, i11, i12);
        }

        public int e(CharSequence charSequence, byte[] bArr, int i11, int i12) {
            int i13;
            int i14;
            int i15;
            char charAt;
            int length = charSequence.length();
            int i16 = i12 + i11;
            int i17 = 0;
            while (i17 < length && (i15 = i17 + i11) < i16 && (charAt = charSequence.charAt(i17)) < 128) {
                bArr[i15] = (byte) charAt;
                i17++;
            }
            if (i17 == length) {
                return i11 + length;
            }
            int i18 = i11 + i17;
            while (i17 < length) {
                char charAt2 = charSequence.charAt(i17);
                if (charAt2 < 128 && i18 < i16) {
                    i14 = i18 + 1;
                    bArr[i18] = (byte) charAt2;
                } else if (charAt2 < 2048 && i18 <= i16 - 2) {
                    int i19 = i18 + 1;
                    bArr[i18] = (byte) ((charAt2 >>> 6) | 960);
                    i18 = i19 + 1;
                    bArr[i19] = (byte) ((charAt2 & '?') | 128);
                    i17++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i18 <= i16 - 3) {
                    int i21 = i18 + 1;
                    bArr[i18] = (byte) ((charAt2 >>> 12) | TXVodDownloadDataSource.QUALITY_480P);
                    int i22 = i21 + 1;
                    bArr[i21] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i14 = i22 + 1;
                    bArr[i22] = (byte) ((charAt2 & '?') | 128);
                } else if (i18 <= i16 - 4) {
                    int i23 = i17 + 1;
                    if (i23 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i23);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i24 = i18 + 1;
                            bArr[i18] = (byte) ((codePoint >>> 18) | 240);
                            int i25 = i24 + 1;
                            bArr[i24] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i26 = i25 + 1;
                            bArr[i25] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i18 = i26 + 1;
                            bArr[i26] = (byte) ((codePoint & 63) | 128);
                            i17 = i23;
                            i17++;
                        } else {
                            i17 = i23;
                        }
                    }
                    throw new UnpairedSurrogateException(i17 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i13 = i17 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i13)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i18);
                } else {
                    throw new UnpairedSurrogateException(i17, length);
                }
                i18 = i14;
                i17++;
            }
            return i18;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
            if (r8[r9] > -65) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int i(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0082
                if (r9 < r10) goto L_0x0005
                return r7
            L_0x0005:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001c
                r7 = -62
                if (r0 < r7) goto L_0x001b
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
                goto L_0x001b
            L_0x0018:
                r9 = r7
                goto L_0x0082
            L_0x001b:
                return r2
            L_0x001c:
                r4 = -16
                if (r0 >= r4) goto L_0x0049
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L_0x0034
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r7 < r10) goto L_0x0031
                int r7 = androidx.datastore.preferences.protobuf.Utf8.n(r0, r9)
                return r7
            L_0x0031:
                r5 = r9
                r9 = r7
                r7 = r5
            L_0x0034:
                if (r7 > r3) goto L_0x0048
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r7 < r4) goto L_0x0048
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r7 >= r4) goto L_0x0048
            L_0x0042:
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0048:
                return r2
            L_0x0049:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x005d
                int r7 = r9 + 1
                byte r1 = r8[r9]
                if (r7 < r10) goto L_0x005b
                int r7 = androidx.datastore.preferences.protobuf.Utf8.n(r0, r1)
                return r7
            L_0x005b:
                r9 = r7
                goto L_0x0060
            L_0x005d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L_0x0060:
                if (r4 != 0) goto L_0x006e
                int r7 = r9 + 1
                byte r4 = r8[r9]
                if (r7 < r10) goto L_0x006d
                int r7 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r1, r4)
                return r7
            L_0x006d:
                r9 = r7
            L_0x006e:
                if (r1 > r3) goto L_0x0081
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L_0x0081
                if (r4 > r3) goto L_0x0081
                int r7 = r9 + 1
                byte r9 = r8[r9]
                if (r9 <= r3) goto L_0x0018
            L_0x0081:
                return r2
            L_0x0082:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.c.i(int, byte[], int, int):int");
        }

        public int l(int i11, ByteBuffer byteBuffer, int i12, int i13) {
            return k(i11, byteBuffer, i12, i13);
        }
    }

    public static final class d extends b {
        public static boolean m() {
            return c1.G() && c1.H();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int n(long r8, int r10) {
            /*
                int r0 = p(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L_0x0007:
                r0 = 0
                r1 = r0
            L_0x0009:
                r2 = 1
                if (r10 <= 0) goto L_0x001a
                long r4 = r8 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r8)
                if (r1 < 0) goto L_0x0019
                int r10 = r10 + -1
                r8 = r4
                goto L_0x0009
            L_0x0019:
                r8 = r4
            L_0x001a:
                if (r10 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r10 = r10 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r10 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r10 = r10 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r8
                byte r8 = androidx.datastore.preferences.protobuf.c1.u(r8)
                if (r8 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r8 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r10 >= r6) goto L_0x0046
                int r8 = r(r8, r1, r10)
                return r8
            L_0x0046:
                int r10 = r10 + -2
                long r6 = r8 + r2
                byte r8 = androidx.datastore.preferences.protobuf.c1.u(r8)
                if (r8 > r4) goto L_0x0063
                r9 = -96
                if (r1 != r0) goto L_0x0056
                if (r8 < r9) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r8 >= r9) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r8 = androidx.datastore.preferences.protobuf.c1.u(r6)
                if (r8 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r10 >= r0) goto L_0x006c
                int r8 = r(r8, r1, r10)
                return r8
            L_0x006c:
                int r10 = r10 + -3
                long r6 = r8 + r2
                byte r8 = androidx.datastore.preferences.protobuf.c1.u(r8)
                if (r8 > r4) goto L_0x008e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L_0x008e
                long r8 = r6 + r2
                byte r0 = androidx.datastore.preferences.protobuf.c1.u(r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r8
                byte r8 = androidx.datastore.preferences.protobuf.c1.u(r8)
                if (r8 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.n(long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int o(byte[] r8, long r9, int r11) {
            /*
                int r0 = q(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L_0x0007:
                r0 = 0
                r1 = r0
            L_0x0009:
                r2 = 1
                if (r11 <= 0) goto L_0x001a
                long r4 = r9 + r2
                byte r1 = androidx.datastore.preferences.protobuf.c1.v(r8, r9)
                if (r1 < 0) goto L_0x0019
                int r11 = r11 + -1
                r9 = r4
                goto L_0x0009
            L_0x0019:
                r9 = r4
            L_0x001a:
                if (r11 != 0) goto L_0x001d
                return r0
            L_0x001d:
                int r11 = r11 + -1
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L_0x003a
                if (r11 != 0) goto L_0x0029
                return r1
            L_0x0029:
                int r11 = r11 + -1
                r0 = -62
                if (r1 < r0) goto L_0x0039
                long r2 = r2 + r9
                byte r9 = androidx.datastore.preferences.protobuf.c1.v(r8, r9)
                if (r9 <= r4) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r9 = r2
                goto L_0x0007
            L_0x0039:
                return r5
            L_0x003a:
                r6 = -16
                if (r1 >= r6) goto L_0x0064
                r6 = 2
                if (r11 >= r6) goto L_0x0046
                int r8 = s(r8, r1, r9, r11)
                return r8
            L_0x0046:
                int r11 = r11 + -2
                long r6 = r9 + r2
                byte r9 = androidx.datastore.preferences.protobuf.c1.v(r8, r9)
                if (r9 > r4) goto L_0x0063
                r10 = -96
                if (r1 != r0) goto L_0x0056
                if (r9 < r10) goto L_0x0063
            L_0x0056:
                r0 = -19
                if (r1 != r0) goto L_0x005c
                if (r9 >= r10) goto L_0x0063
            L_0x005c:
                long r2 = r2 + r6
                byte r9 = androidx.datastore.preferences.protobuf.c1.v(r8, r6)
                if (r9 <= r4) goto L_0x0037
            L_0x0063:
                return r5
            L_0x0064:
                r0 = 3
                if (r11 >= r0) goto L_0x006c
                int r8 = s(r8, r1, r9, r11)
                return r8
            L_0x006c:
                int r11 = r11 + -3
                long r6 = r9 + r2
                byte r9 = androidx.datastore.preferences.protobuf.c1.v(r8, r9)
                if (r9 > r4) goto L_0x008e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L_0x008e
                long r9 = r6 + r2
                byte r0 = androidx.datastore.preferences.protobuf.c1.v(r8, r6)
                if (r0 > r4) goto L_0x008e
                long r2 = r2 + r9
                byte r9 = androidx.datastore.preferences.protobuf.c1.v(r8, r9)
                if (r9 <= r4) goto L_0x0037
            L_0x008e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.o(byte[], long, int):int");
        }

        public static int p(long j11, int i11) {
            if (i11 < 16) {
                return 0;
            }
            int i12 = 8 - (((int) j11) & 7);
            int i13 = i12;
            while (i13 > 0) {
                long j12 = 1 + j11;
                if (c1.u(j11) < 0) {
                    return i12 - i13;
                }
                i13--;
                j11 = j12;
            }
            int i14 = i11 - i12;
            while (i14 >= 8 && (c1.B(j11) & -9187201950435737472L) == 0) {
                j11 += 8;
                i14 -= 8;
            }
            return i11 - i14;
        }

        public static int q(byte[] bArr, long j11, int i11) {
            int i12 = 0;
            if (i11 < 16) {
                return 0;
            }
            while (i12 < i11) {
                long j12 = 1 + j11;
                if (c1.v(bArr, j11) < 0) {
                    return i12;
                }
                i12++;
                j11 = j12;
            }
            return i11;
        }

        public static int r(long j11, int i11, int i12) {
            if (i12 == 0) {
                return Utf8.m(i11);
            }
            if (i12 == 1) {
                return Utf8.n(i11, c1.u(j11));
            }
            if (i12 == 2) {
                return Utf8.o(i11, c1.u(j11), c1.u(j11 + 1));
            }
            throw new AssertionError();
        }

        public static int s(byte[] bArr, int i11, long j11, int i12) {
            if (i12 == 0) {
                return Utf8.m(i11);
            }
            if (i12 == 1) {
                return Utf8.n(i11, c1.v(bArr, j11));
            }
            if (i12 == 2) {
                return Utf8.o(i11, c1.v(bArr, j11), c1.v(bArr, j11 + 1));
            }
            throw new AssertionError();
        }

        public String b(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
            if ((i11 | i12 | ((bArr.length - i11) - i12)) >= 0) {
                int i13 = i11 + i12;
                char[] cArr = new char[i12];
                int i14 = 0;
                while (r13 < i13) {
                    byte v11 = c1.v(bArr, (long) r13);
                    if (!a.n(v11)) {
                        break;
                    }
                    i11 = r13 + 1;
                    a.i(v11, cArr, i14);
                    i14++;
                }
                int i15 = i14;
                while (r13 < i13) {
                    int i16 = r13 + 1;
                    byte v12 = c1.v(bArr, (long) r13);
                    if (a.n(v12)) {
                        int i17 = i15 + 1;
                        a.i(v12, cArr, i15);
                        while (i16 < i13) {
                            byte v13 = c1.v(bArr, (long) i16);
                            if (!a.n(v13)) {
                                break;
                            }
                            i16++;
                            a.i(v13, cArr, i17);
                            i17++;
                        }
                        r13 = i16;
                        i15 = i17;
                    } else if (a.p(v12)) {
                        if (i16 < i13) {
                            a.k(v12, c1.v(bArr, (long) i16), cArr, i15);
                            r13 = i16 + 1;
                            i15++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (a.o(v12)) {
                        if (i16 < i13 - 1) {
                            int i18 = i16 + 1;
                            a.j(v12, c1.v(bArr, (long) i16), c1.v(bArr, (long) i18), cArr, i15);
                            r13 = i18 + 1;
                            i15++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i16 < i13 - 2) {
                        int i19 = i16 + 1;
                        byte v14 = c1.v(bArr, (long) i16);
                        int i21 = i19 + 1;
                        a.h(v12, v14, c1.v(bArr, (long) i19), c1.v(bArr, (long) i21), cArr, i15);
                        r13 = i21 + 1;
                        i15 = i15 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i15);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
        }

        public String d(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
            long j11;
            int i13 = i11;
            int i14 = i12;
            if ((i13 | i14 | ((byteBuffer.limit() - i13) - i14)) >= 0) {
                long i15 = c1.i(byteBuffer) + ((long) i13);
                long j12 = ((long) i14) + i15;
                char[] cArr = new char[i14];
                int i16 = 0;
                while (i15 < j12) {
                    byte u11 = c1.u(i15);
                    if (!a.n(u11)) {
                        break;
                    }
                    i15++;
                    a.i(u11, cArr, i16);
                    i16++;
                }
                while (true) {
                    int i17 = i16;
                    while (j11 < j12) {
                        long j13 = j11 + 1;
                        byte u12 = c1.u(j11);
                        if (a.n(u12)) {
                            int i18 = i17 + 1;
                            a.i(u12, cArr, i17);
                            while (j13 < j12) {
                                byte u13 = c1.u(j13);
                                if (!a.n(u13)) {
                                    break;
                                }
                                j13++;
                                a.i(u13, cArr, i18);
                                i18++;
                            }
                            i17 = i18;
                            j11 = j13;
                        } else if (a.p(u12)) {
                            if (j13 < j12) {
                                j11 = j13 + 1;
                                a.k(u12, c1.u(j13), cArr, i17);
                                i17++;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (a.o(u12)) {
                            if (j13 < j12 - 1) {
                                long j14 = j13 + 1;
                                a.j(u12, c1.u(j13), c1.u(j14), cArr, i17);
                                i17++;
                                j11 = j14 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (j13 < j12 - 2) {
                            long j15 = j13 + 1;
                            byte u14 = c1.u(j13);
                            long j16 = j15 + 1;
                            byte u15 = c1.u(j15);
                            i15 = j16 + 1;
                            a.h(u12, u14, u15, c1.u(j16), cArr, i17);
                            i16 = i17 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                    return new String(cArr, 0, i17);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i11), Integer.valueOf(i12)}));
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e(java.lang.CharSequence r22, byte[] r23, int r24, int r25) {
            /*
                r21 = this;
                r0 = r22
                r1 = r23
                r2 = r24
                r3 = r25
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r22.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0144
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0144
                r2 = 0
            L_0x001a:
                r3 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                androidx.datastore.preferences.protobuf.c1.M(r1, r4, r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x0142
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004a
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004a
                long r14 = r4 + r11
                byte r13 = (byte) r13
                androidx.datastore.preferences.protobuf.c1.M(r1, r4, r13)
                r4 = r11
                r12 = r14
                r11 = r3
                goto L_0x00fc
            L_0x004a:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x0074
                r14 = 2
                long r14 = r6 - r14
                int r14 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r14 > 0) goto L_0x0074
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.c1.M(r1, r4, r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                androidx.datastore.preferences.protobuf.c1.M(r1, r14, r5)
                r19 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r19
                goto L_0x00fc
            L_0x0074:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x007e
                if (r3 >= r13) goto L_0x00af
            L_0x007e:
                r15 = 3
                long r15 = r6 - r15
                int r15 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r15 > 0) goto L_0x00af
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                androidx.datastore.preferences.protobuf.c1.M(r1, r4, r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                androidx.datastore.preferences.protobuf.c1.M(r1, r14, r5)
                r14 = 1
                long r17 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                androidx.datastore.preferences.protobuf.c1.M(r1, r3, r5)
                r12 = r17
                r4 = 1
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x00fc
            L_0x00af:
                r11 = 4
                long r11 = r6 - r11
                int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r11 > 0) goto L_0x010f
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0107
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0106
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                androidx.datastore.preferences.protobuf.c1.M(r1, r4, r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                androidx.datastore.preferences.protobuf.c1.M(r1, r13, r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                androidx.datastore.preferences.protobuf.c1.M(r1, r4, r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                androidx.datastore.preferences.protobuf.c1.M(r1, r14, r2)
                r2 = r3
            L_0x00fc:
                int r2 = r2 + 1
                r3 = r11
                r19 = r4
                r4 = r12
                r11 = r19
                goto L_0x0033
            L_0x0106:
                r2 = r3
            L_0x0107:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010f:
                if (r14 > r13) goto L_0x0127
                if (r13 > r3) goto L_0x0127
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0121
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0127
            L_0x0121:
                androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException r0 = new androidx.datastore.preferences.protobuf.Utf8$UnpairedSurrogateException
                r0.<init>(r2, r8)
                throw r0
            L_0x0127:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0142:
                int r0 = (int) r4
                return r0
            L_0x0144:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                r4.append(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.e(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (androidx.datastore.preferences.protobuf.c1.v(r13, r2) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (androidx.datastore.preferences.protobuf.c1.v(r13, r2) > -65) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int i(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00a8
                long r2 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x00a1
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r0 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r0 >= r4) goto L_0x002b
                r12 = -62
                if (r0 < r12) goto L_0x002a
                long r7 = r7 + r2
                byte r12 = androidx.datastore.preferences.protobuf.c1.v(r13, r2)
                if (r12 <= r6) goto L_0x0027
                goto L_0x002a
            L_0x0027:
                r2 = r7
                goto L_0x00a1
            L_0x002a:
                return r5
            L_0x002b:
                r9 = -16
                if (r0 >= r9) goto L_0x005f
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0045
                long r9 = r2 + r7
                byte r12 = androidx.datastore.preferences.protobuf.c1.v(r13, r2)
                int r1 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r1 < 0) goto L_0x0044
                int r12 = androidx.datastore.preferences.protobuf.Utf8.n(r0, r12)
                return r12
            L_0x0044:
                r2 = r9
            L_0x0045:
                if (r12 > r6) goto L_0x005e
                r1 = -96
                if (r0 != r4) goto L_0x004d
                if (r12 < r1) goto L_0x005e
            L_0x004d:
                r4 = -19
                if (r0 != r4) goto L_0x0053
                if (r12 >= r1) goto L_0x005e
            L_0x0053:
                long r0 = r2 + r7
                byte r12 = androidx.datastore.preferences.protobuf.c1.v(r13, r2)
                if (r12 <= r6) goto L_0x005c
                goto L_0x005e
            L_0x005c:
                r2 = r0
                goto L_0x00a1
            L_0x005e:
                return r5
            L_0x005f:
                int r4 = r12 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0076
                long r9 = r2 + r7
                byte r4 = androidx.datastore.preferences.protobuf.c1.v(r13, r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0074
                int r12 = androidx.datastore.preferences.protobuf.Utf8.n(r0, r4)
                return r12
            L_0x0074:
                r2 = r9
                goto L_0x0079
            L_0x0076:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0079:
                if (r1 != 0) goto L_0x008b
                long r9 = r2 + r7
                byte r1 = androidx.datastore.preferences.protobuf.c1.v(r13, r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x008a
                int r12 = androidx.datastore.preferences.protobuf.Utf8.o(r0, r4, r1)
                return r12
            L_0x008a:
                r2 = r9
            L_0x008b:
                if (r4 > r6) goto L_0x00a0
                int r12 = r0 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00a0
                if (r1 > r6) goto L_0x00a0
                long r0 = r2 + r7
                byte r12 = androidx.datastore.preferences.protobuf.c1.v(r13, r2)
                if (r12 <= r6) goto L_0x005c
            L_0x00a0:
                return r5
            L_0x00a1:
                long r14 = r14 - r2
                int r12 = (int) r14
                int r12 = o(r13, r2, r12)
                return r12
            L_0x00a8:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.i(int, byte[], int, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (androidx.datastore.preferences.protobuf.c1.u(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (androidx.datastore.preferences.protobuf.c1.u(r2) > -65) goto L_0x00aa;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int l(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.limit()
                int r1 = r1 - r14
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00b2
                long r2 = androidx.datastore.preferences.protobuf.c1.i(r12)
                long r4 = (long) r13
                long r2 = r2 + r4
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r2
                if (r11 == 0) goto L_0x00ab
                int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r0 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r0) goto L_0x0035
                r11 = -62
                if (r14 < r11) goto L_0x0034
                long r6 = r6 + r2
                byte r11 = androidx.datastore.preferences.protobuf.c1.u(r2)
                if (r11 <= r5) goto L_0x0031
                goto L_0x0034
            L_0x0031:
                r2 = r6
                goto L_0x00ab
            L_0x0034:
                return r4
            L_0x0035:
                r8 = -16
                if (r14 >= r8) goto L_0x0069
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004f
                long r8 = r2 + r6
                byte r11 = androidx.datastore.preferences.protobuf.c1.u(r2)
                int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r1 < 0) goto L_0x004e
                int r11 = androidx.datastore.preferences.protobuf.Utf8.n(r14, r11)
                return r11
            L_0x004e:
                r2 = r8
            L_0x004f:
                if (r11 > r5) goto L_0x0068
                r1 = -96
                if (r14 != r0) goto L_0x0057
                if (r11 < r1) goto L_0x0068
            L_0x0057:
                r0 = -19
                if (r14 != r0) goto L_0x005d
                if (r11 >= r1) goto L_0x0068
            L_0x005d:
                long r0 = r2 + r6
                byte r11 = androidx.datastore.preferences.protobuf.c1.u(r2)
                if (r11 <= r5) goto L_0x0066
                goto L_0x0068
            L_0x0066:
                r2 = r0
                goto L_0x00ab
            L_0x0068:
                return r4
            L_0x0069:
                int r0 = r11 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x0080
                long r8 = r2 + r6
                byte r0 = androidx.datastore.preferences.protobuf.c1.u(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x007e
                int r11 = androidx.datastore.preferences.protobuf.Utf8.n(r14, r0)
                return r11
            L_0x007e:
                r2 = r8
                goto L_0x0083
            L_0x0080:
                int r11 = r11 >> 16
                byte r1 = (byte) r11
            L_0x0083:
                if (r1 != 0) goto L_0x0095
                long r8 = r2 + r6
                byte r1 = androidx.datastore.preferences.protobuf.c1.u(r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0094
                int r11 = androidx.datastore.preferences.protobuf.Utf8.o(r14, r0, r1)
                return r11
            L_0x0094:
                r2 = r8
            L_0x0095:
                if (r0 > r5) goto L_0x00aa
                int r11 = r14 << 28
                int r0 = r0 + 112
                int r11 = r11 + r0
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00aa
                if (r1 > r5) goto L_0x00aa
                long r0 = r2 + r6
                byte r11 = androidx.datastore.preferences.protobuf.c1.u(r2)
                if (r11 <= r5) goto L_0x0066
            L_0x00aa:
                return r4
            L_0x00ab:
                long r12 = r12 - r2
                int r11 = (int) r12
                int r11 = n(r2, r11)
                return r11
            L_0x00b2:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                r0[r1] = r12
                r12 = 1
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r12] = r13
                r12 = 2
                java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
                r0[r12] = r13
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.Utf8.d.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    public static String g(ByteBuffer byteBuffer, int i11, int i12) throws InvalidProtocolBufferException {
        return f9050a.a(byteBuffer, i11, i12);
    }

    public static String h(byte[] bArr, int i11, int i12) throws InvalidProtocolBufferException {
        return f9050a.b(bArr, i11, i12);
    }

    public static int i(CharSequence charSequence, byte[] bArr, int i11, int i12) {
        return f9050a.e(charSequence, bArr, i11, i12);
    }

    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i11 = 0;
        while (i11 < length && charSequence.charAt(i11) < 128) {
            i11++;
        }
        int i12 = length;
        while (true) {
            if (i11 < length) {
                char charAt = charSequence.charAt(i11);
                if (charAt >= 2048) {
                    i12 += k(charSequence, i11);
                    break;
                }
                i12 += (127 - charAt) >>> 31;
                i11++;
            } else {
                break;
            }
        }
        if (i12 >= length) {
            return i12;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i12) + 4294967296L));
    }

    public static int k(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        int i12 = 0;
        while (i11 < length) {
            char charAt = charSequence.charAt(i11);
            if (charAt < 2048) {
                i12 += (127 - charAt) >>> 31;
            } else {
                i12 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i11) >= 65536) {
                        i11++;
                    } else {
                        throw new UnpairedSurrogateException(i11, length);
                    }
                }
            }
            i11++;
        }
        return i12;
    }

    public static int l(ByteBuffer byteBuffer, int i11, int i12) {
        int i13 = i12 - 7;
        int i14 = i11;
        while (i14 < i13 && (byteBuffer.getLong(i14) & -9187201950435737472L) == 0) {
            i14 += 8;
        }
        return i14 - i11;
    }

    public static int m(int i11) {
        if (i11 > -12) {
            return -1;
        }
        return i11;
    }

    public static int n(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    public static int o(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }

    public static int p(ByteBuffer byteBuffer, int i11, int i12, int i13) {
        if (i13 == 0) {
            return m(i11);
        }
        if (i13 == 1) {
            return n(i11, byteBuffer.get(i12));
        }
        if (i13 == 2) {
            return o(i11, byteBuffer.get(i12), byteBuffer.get(i12 + 1));
        }
        throw new AssertionError();
    }

    public static int q(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 == 0) {
            return m(b11);
        }
        if (i13 == 1) {
            return n(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return o(b11, bArr[i11], bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean r(ByteBuffer byteBuffer) {
        return f9050a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    public static boolean s(byte[] bArr) {
        return f9050a.g(bArr, 0, bArr.length);
    }

    public static boolean t(byte[] bArr, int i11, int i12) {
        return f9050a.g(bArr, i11, i12);
    }

    public static int u(int i11, ByteBuffer byteBuffer, int i12, int i13) {
        return f9050a.h(i11, byteBuffer, i12, i13);
    }

    public static int v(int i11, byte[] bArr, int i12, int i13) {
        return f9050a.i(i11, bArr, i12, i13);
    }
}
