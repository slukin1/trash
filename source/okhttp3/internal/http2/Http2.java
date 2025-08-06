package okhttp3.internal.http2;

import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2 {
    private static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FLAGS = new String[64];
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        String[] strArr = new String[256];
        for (int i11 = 0; i11 < 256; i11++) {
            strArr[i11] = StringsKt__StringsJVMKt.F(Util.format("%8s", Integer.toBinaryString(i11)), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i12 = 0; i12 < 1; i12++) {
            int i13 = iArr[i12];
            String[] strArr3 = FLAGS;
            strArr3[i13 | 8] = strArr3[i13] + "|PADDED";
        }
        String[] strArr4 = FLAGS;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i14 = 0; i14 < 3; i14++) {
            int i15 = iArr2[i14];
            for (int i16 = 0; i16 < 1; i16++) {
                int i17 = iArr[i16];
                String[] strArr5 = FLAGS;
                int i18 = i17 | i15;
                strArr5[i18] = strArr5[i17] + '|' + strArr5[i15];
                strArr5[i18 | 8] = strArr5[i17] + '|' + strArr5[i15] + "|PADDED";
            }
        }
        int length = FLAGS.length;
        for (int i19 = 0; i19 < length; i19++) {
            String[] strArr6 = FLAGS;
            if (strArr6[i19] == null) {
                strArr6[i19] = BINARY[i19];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i11, int i12) {
        if (i12 == 0) {
            return "";
        }
        if (!(i11 == 2 || i11 == 3)) {
            if (i11 == 4 || i11 == 6) {
                if (i12 == 1) {
                    return "ACK";
                }
                return BINARY[i12];
            } else if (!(i11 == 7 || i11 == 8)) {
                String[] strArr = FLAGS;
                String str = i12 < strArr.length ? strArr[i12] : BINARY[i12];
                if (i11 != 5 || (i12 & 4) == 0) {
                    return (i11 != 0 || (i12 & 32) == 0) ? str : StringsKt__StringsJVMKt.G(str, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
                }
                return StringsKt__StringsJVMKt.G(str, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            }
        }
        return BINARY[i12];
    }

    public final String formattedType$okhttp(int i11) {
        String[] strArr = FRAME_NAMES;
        if (i11 < strArr.length) {
            return strArr[i11];
        }
        return Util.format("0x%02x", Integer.valueOf(i11));
    }

    public final String frameLog(boolean z11, int i11, int i12, int i13, int i14) {
        return Util.format("%s 0x%08x %5d %-13s %s", z11 ? "<<" : ">>", Integer.valueOf(i11), Integer.valueOf(i12), formattedType$okhttp(i13), formatFlags(i13, i14));
    }
}
