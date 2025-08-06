package com.facebook.stetho.websocket;

import com.facebook.stetho.common.Utf8Charset;

class FrameHelper {
    public static Frame createBinaryFrame(byte[] bArr) {
        return createSimpleFrame((byte) 2, bArr);
    }

    public static Frame createCloseFrame(int i11, String str) {
        byte[] bArr;
        int i12;
        if (str != null) {
            bArr = Utf8Charset.encodeUTF8(str);
            i12 = bArr.length + 2;
        } else {
            bArr = null;
            i12 = 2;
        }
        byte[] bArr2 = new byte[i12];
        bArr2[0] = (byte) ((i11 >> 8) & 255);
        bArr2[1] = (byte) (i11 & 255);
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 2, bArr.length);
        }
        return createSimpleFrame((byte) 8, bArr2);
    }

    public static Frame createPingFrame(byte[] bArr, int i11) {
        return createSimpleFrame((byte) 9, bArr, i11);
    }

    public static Frame createPongFrame(byte[] bArr, int i11) {
        return createSimpleFrame((byte) 10, bArr, i11);
    }

    private static Frame createSimpleFrame(byte b11, byte[] bArr) {
        return createSimpleFrame(b11, bArr, bArr.length);
    }

    public static Frame createTextFrame(String str) {
        return createSimpleFrame((byte) 1, Utf8Charset.encodeUTF8(str));
    }

    private static Frame createSimpleFrame(byte b11, byte[] bArr, int i11) {
        Frame frame = new Frame();
        frame.fin = true;
        frame.hasMask = false;
        frame.opcode = b11;
        frame.payloadLen = (long) i11;
        frame.payloadData = bArr;
        return frame;
    }
}
