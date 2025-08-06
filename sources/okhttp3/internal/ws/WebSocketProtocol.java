package okhttp3.internal.ws;

import okio.Buffer;
import okio.ByteString;

public final class WebSocketProtocol {
    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final WebSocketProtocol INSTANCE = new WebSocketProtocol();
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535;

    private WebSocketProtocol() {
    }

    public final String acceptHeader(String str) {
        ByteString.Companion companion = ByteString.Companion;
        return companion.encodeUtf8(str + ACCEPT_MAGIC).sha1().base64();
    }

    public final String closeCodeExceptionMessage(int i11) {
        if (i11 < 1000 || i11 >= 5000) {
            return "Code must be in range [1000,5000): " + i11;
        }
        boolean z11 = true;
        if (!(1004 <= i11 && i11 < 1007)) {
            if (1015 > i11 || i11 >= 3000) {
                z11 = false;
            }
            if (!z11) {
                return null;
            }
        }
        return "Code " + i11 + " is reserved and may not be used.";
    }

    public final void toggleMask(Buffer.UnsafeCursor unsafeCursor, byte[] bArr) {
        int length = bArr.length;
        int i11 = 0;
        do {
            byte[] bArr2 = unsafeCursor.data;
            int i12 = unsafeCursor.start;
            int i13 = unsafeCursor.end;
            if (bArr2 != null) {
                while (i12 < i13) {
                    int i14 = i11 % length;
                    bArr2[i12] = (byte) (bArr2[i12] ^ bArr[i14]);
                    i12++;
                    i11 = i14 + 1;
                }
            }
        } while (unsafeCursor.next() != -1);
    }

    public final void validateCloseCode(int i11) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i11);
        if (!(closeCodeExceptionMessage == null)) {
            throw new IllegalArgumentException(closeCodeExceptionMessage.toString());
        }
    }
}
