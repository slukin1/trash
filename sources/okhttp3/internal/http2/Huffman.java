package okhttp3.internal.http2;

import com.google.common.base.Ascii;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public final class Huffman {
    private static final int[] CODES = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
    private static final byte[] CODE_BIT_COUNTS;
    public static final Huffman INSTANCE = new Huffman();
    private static final Node root = new Node();

    static {
        byte[] bArr = {13, 23, 28, 28, 28, 28, 28, 28, 28, Ascii.CAN, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, Ascii.CAN, 23, Ascii.CAN, Ascii.CAN, 22, 23, Ascii.CAN, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, Ascii.CAN, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, Ascii.CAN, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, Ascii.SUB, Ascii.SUB, 20, 19, 22, 23, 22, Ascii.EM, Ascii.SUB, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.CAN, Ascii.EM, 19, 21, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.SUB, Ascii.ESC, Ascii.CAN, 21, 21, Ascii.SUB, Ascii.SUB, 28, Ascii.ESC, Ascii.ESC, Ascii.ESC, 20, Ascii.CAN, 20, 21, 22, 21, 21, 23, 22, 22, Ascii.EM, Ascii.EM, Ascii.CAN, Ascii.CAN, Ascii.SUB, 23, Ascii.SUB, Ascii.ESC, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, 28, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.ESC, Ascii.SUB};
        CODE_BIT_COUNTS = bArr;
        int length = bArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            INSTANCE.addCode(i11, CODES[i11], CODE_BIT_COUNTS[i11]);
        }
    }

    private Huffman() {
    }

    private final void addCode(int i11, int i12, int i13) {
        Node node = new Node(i11, i13);
        Node node2 = root;
        while (i13 > 8) {
            i13 -= 8;
            int i14 = (i12 >>> i13) & 255;
            Node[] children = node2.getChildren();
            Node node3 = children[i14];
            if (node3 == null) {
                node3 = new Node();
                children[i14] = node3;
            }
            node2 = node3;
        }
        int i15 = 8 - i13;
        int i16 = (i12 << i15) & 255;
        ArraysKt___ArraysJvmKt.m(node2.getChildren(), node, i16, (1 << i15) + i16);
    }

    public final void decode(BufferedSource bufferedSource, long j11, BufferedSink bufferedSink) {
        Node node = root;
        int i11 = 0;
        int i12 = 0;
        for (long j12 = 0; j12 < j11; j12++) {
            i11 = (i11 << 8) | Util.and(bufferedSource.readByte(), 255);
            i12 += 8;
            while (i12 >= 8) {
                node = node.getChildren()[(i11 >>> (i12 - 8)) & 255];
                if (node.getChildren() == null) {
                    bufferedSink.writeByte(node.getSymbol());
                    i12 -= node.getTerminalBitCount();
                    node = root;
                } else {
                    i12 -= 8;
                }
            }
        }
        while (i12 > 0) {
            Node node2 = node.getChildren()[(i11 << (8 - i12)) & 255];
            if (node2.getChildren() == null && node2.getTerminalBitCount() <= i12) {
                bufferedSink.writeByte(node2.getSymbol());
                i12 -= node2.getTerminalBitCount();
                node = root;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void encode(okio.ByteString r9, okio.BufferedSink r10) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r9.size()
            r1 = 0
            r2 = 0
            r3 = r2
            r2 = r1
        L_0x0009:
            if (r1 >= r0) goto L_0x0031
            byte r5 = r9.getByte(r1)
            r6 = 255(0xff, float:3.57E-43)
            int r5 = okhttp3.internal.Util.and((byte) r5, (int) r6)
            int[] r6 = CODES
            r6 = r6[r5]
            byte[] r7 = CODE_BIT_COUNTS
            byte r5 = r7[r5]
            long r3 = r3 << r5
            long r6 = (long) r6
            long r3 = r3 | r6
            int r2 = r2 + r5
        L_0x0021:
            r5 = 8
            if (r2 < r5) goto L_0x002e
            int r2 = r2 + -8
            long r5 = r3 >> r2
            int r5 = (int) r5
            r10.writeByte(r5)
            goto L_0x0021
        L_0x002e:
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0031:
            if (r2 <= 0) goto L_0x0040
            int r9 = 8 - r2
            long r0 = r3 << r9
            r3 = 255(0xff, double:1.26E-321)
            long r2 = r3 >>> r2
            long r0 = r0 | r2
            int r9 = (int) r0
            r10.writeByte(r9)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Huffman.encode(okio.ByteString, okio.BufferedSink):void");
    }

    public final int encodedLength(ByteString byteString) {
        int size = byteString.size();
        long j11 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j11 += (long) CODE_BIT_COUNTS[Util.and(byteString.getByte(i11), 255)];
        }
        return (int) ((j11 + ((long) 7)) >> 3);
    }

    public static final class Node {
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node(int i11, int i12) {
            this.children = null;
            this.symbol = i11;
            int i13 = i12 & 7;
            this.terminalBitCount = i13 == 0 ? 8 : i13;
        }
    }
}
