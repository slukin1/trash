package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;

public class UTF8Decoder extends CharsetDecoder {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f14446a = Charset.forName("UTF-8");

    public static class a {
        static {
            Class<UTF8Decoder> cls = UTF8Decoder.class;
        }

        public static char a(int i11) {
            return (char) ((((i11 - 65536) >> 10) & 1023) | 55296);
        }

        public static char b(int i11) {
            return (char) (((i11 - 65536) & 1023) | Utf8.LOG_SURROGATE_HEADER);
        }

        public static boolean c(int i11) {
            return i11 >= 65536 && i11 <= 1114111;
        }
    }

    public UTF8Decoder() {
        super(f14446a, 1.0f, 1.0f);
    }

    public static boolean b(int i11, int i12) {
        return (i11 & 30) == 0 || (i12 & 192) != 128;
    }

    public static boolean c(int i11, int i12, int i13) {
        return ((i11 != -32 || (i12 & 224) != 128) && (i12 & 192) == 128 && (i13 & 192) == 128) ? false : true;
    }

    public static boolean d(int i11, int i12, int i13) {
        return ((i11 & 192) == 128 && (i12 & 192) == 128 && (i13 & 192) == 128) ? false : true;
    }

    public static boolean e(int i11) {
        return (i11 & 192) != 128;
    }

    public static CoderResult f(ByteBuffer byteBuffer, int i11) {
        for (int i12 = 1; i12 < i11; i12++) {
            if (e(byteBuffer.get())) {
                return CoderResult.malformedForLength(i12);
            }
        }
        return CoderResult.malformedForLength(i11);
    }

    public static CoderResult g(ByteBuffer byteBuffer, int i11, CharBuffer charBuffer, int i12, int i13) {
        byteBuffer.position(i11 - byteBuffer.arrayOffset());
        CoderResult h11 = h(byteBuffer, i13);
        i(byteBuffer, i11, charBuffer, i12);
        return h11;
    }

    public static CoderResult h(ByteBuffer byteBuffer, int i11) {
        int i12 = 1;
        if (i11 == 1) {
            byte b11 = byteBuffer.get();
            if ((b11 >> 2) == -2) {
                if (byteBuffer.remaining() < 4) {
                    return CoderResult.UNDERFLOW;
                }
                return f(byteBuffer, 5);
            } else if ((b11 >> 1) != -2) {
                return CoderResult.malformedForLength(1);
            } else {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return f(byteBuffer, 6);
            }
        } else if (i11 == 2) {
            return CoderResult.malformedForLength(1);
        } else {
            if (i11 == 3) {
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                if (!(b12 == -32 && (b13 & ISO7816.INS_CREATE_FILE) == 128) && !e(b13)) {
                    i12 = 2;
                }
                return CoderResult.malformedForLength(i12);
            } else if (i11 == 4) {
                byte b14 = byteBuffer.get() & 255;
                byte b15 = byteBuffer.get() & 255;
                if (b14 > 244 || ((b14 == 240 && (b15 < 144 || b15 > 191)) || ((b14 == 244 && (b15 & 240) != 128) || e(b15)))) {
                    return CoderResult.malformedForLength(1);
                }
                if (e(byteBuffer.get())) {
                    return CoderResult.malformedForLength(2);
                }
                return CoderResult.malformedForLength(3);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public static void i(Buffer buffer, int i11, Buffer buffer2, int i12) {
        buffer.position(i11);
        buffer2.position(i12);
    }

    public static CoderResult j(Buffer buffer, int i11, int i12, Buffer buffer2, int i13, int i14) {
        i(buffer, i11, buffer2, i13);
        return (i14 == 0 || i12 - i11 < i14) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        return j(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ca, code lost:
        return j(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0123, code lost:
        return j(r13, r5, r6, r14, r8, 4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.nio.charset.CoderResult a(java.nio.ByteBuffer r13, java.nio.CharBuffer r14) {
        /*
            r12 = this;
            byte[] r0 = r13.array()
            int r1 = r13.arrayOffset()
            int r2 = r13.position()
            int r1 = r1 + r2
            int r2 = r13.arrayOffset()
            int r3 = r13.limit()
            int r6 = r2 + r3
            char[] r2 = r14.array()
            int r3 = r14.arrayOffset()
            int r4 = r14.position()
            int r3 = r3 + r4
            int r4 = r14.arrayOffset()
            int r5 = r14.limit()
            int r4 = r4 + r5
            int r5 = r6 - r1
            int r7 = r4 - r3
            int r5 = java.lang.Math.min(r5, r7)
            int r5 = r5 + r3
        L_0x0036:
            if (r3 >= r5) goto L_0x0048
            byte r7 = r0[r1]
            if (r7 < 0) goto L_0x0048
            int r7 = r3 + 1
            int r8 = r1 + 1
            byte r1 = r0[r1]
            char r1 = (char) r1
            r2[r3] = r1
            r3 = r7
            r1 = r8
            goto L_0x0036
        L_0x0048:
            r5 = r1
        L_0x0049:
            r8 = r3
        L_0x004a:
            if (r5 >= r6) goto L_0x012a
            byte r1 = r0[r5]
            if (r1 < 0) goto L_0x0062
            if (r8 < r4) goto L_0x005a
            r9 = 1
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = j(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x005a:
            int r3 = r8 + 1
            char r1 = (char) r1
            r2[r8] = r1
            int r5 = r5 + 1
            goto L_0x0049
        L_0x0062:
            int r3 = r1 >> 5
            r7 = -2
            r9 = 2
            if (r3 != r7) goto L_0x0094
            int r3 = r6 - r5
            if (r3 < r9) goto L_0x008c
            if (r8 < r4) goto L_0x006f
            goto L_0x008c
        L_0x006f:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            boolean r7 = b(r1, r3)
            if (r7 == 0) goto L_0x007e
            java.nio.charset.CoderResult r13 = g(r13, r5, r14, r8, r9)
            return r13
        L_0x007e:
            int r7 = r8 + 1
            int r1 = r1 << 6
            r1 = r1 ^ r3
            r1 = r1 ^ 3968(0xf80, float:5.56E-42)
            char r1 = (char) r1
            r2[r8] = r1
            int r5 = r5 + 2
        L_0x008a:
            r8 = r7
            goto L_0x004a
        L_0x008c:
            r9 = 2
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = j(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x0094:
            int r3 = r1 >> 4
            if (r3 != r7) goto L_0x00cb
            int r3 = r6 - r5
            r7 = 3
            if (r3 < r7) goto L_0x00c3
            if (r8 < r4) goto L_0x00a0
            goto L_0x00c3
        L_0x00a0:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            int r9 = r5 + 2
            byte r9 = r0[r9]
            boolean r10 = c(r1, r3, r9)
            if (r10 == 0) goto L_0x00b3
            java.nio.charset.CoderResult r13 = g(r13, r5, r14, r8, r7)
            return r13
        L_0x00b3:
            int r7 = r8 + 1
            int r1 = r1 << 12
            int r3 = r3 << 6
            r1 = r1 ^ r3
            r1 = r1 ^ r9
            r1 = r1 ^ 8064(0x1f80, float:1.13E-41)
            char r1 = (char) r1
            r2[r8] = r1
            int r5 = r5 + 3
            goto L_0x008a
        L_0x00c3:
            r9 = 3
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = j(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x00cb:
            int r3 = r1 >> 3
            if (r3 != r7) goto L_0x0124
            int r3 = r6 - r5
            r7 = 4
            if (r3 < r7) goto L_0x011c
            int r3 = r4 - r8
            if (r3 >= r9) goto L_0x00d9
            goto L_0x011c
        L_0x00d9:
            int r3 = r5 + 1
            byte r3 = r0[r3]
            int r9 = r5 + 2
            byte r9 = r0[r9]
            int r10 = r5 + 3
            byte r10 = r0[r10]
            r1 = r1 & 7
            int r1 = r1 << 18
            r11 = r3 & 63
            int r11 = r11 << 12
            r1 = r1 | r11
            r11 = r9 & 63
            int r11 = r11 << 6
            r1 = r1 | r11
            r11 = r10 & 63
            r1 = r1 | r11
            boolean r3 = d(r3, r9, r10)
            if (r3 != 0) goto L_0x0117
            boolean r3 = com.alibaba.fastjson.util.UTF8Decoder.a.c(r1)
            if (r3 != 0) goto L_0x0103
            goto L_0x0117
        L_0x0103:
            int r3 = r8 + 1
            char r7 = com.alibaba.fastjson.util.UTF8Decoder.a.a(r1)
            r2[r8] = r7
            int r7 = r3 + 1
            char r1 = com.alibaba.fastjson.util.UTF8Decoder.a.b(r1)
            r2[r3] = r1
            int r5 = r5 + 4
            goto L_0x008a
        L_0x0117:
            java.nio.charset.CoderResult r13 = g(r13, r5, r14, r8, r7)
            return r13
        L_0x011c:
            r9 = 4
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = j(r4, r5, r6, r7, r8, r9)
            return r13
        L_0x0124:
            r0 = 1
            java.nio.charset.CoderResult r13 = g(r13, r5, r14, r8, r0)
            return r13
        L_0x012a:
            r9 = 0
            r4 = r13
            r7 = r14
            java.nio.charset.CoderResult r13 = j(r4, r5, r6, r7, r8, r9)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.UTF8Decoder.a(java.nio.ByteBuffer, java.nio.CharBuffer):java.nio.charset.CoderResult");
    }

    public CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return a(byteBuffer, charBuffer);
    }
}
