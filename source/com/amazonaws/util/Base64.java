package com.amazonaws.util;

public enum Base64 {
    ;
    
    private static final Base64Codec CODEC = null;

    /* access modifiers changed from: public */
    static {
        CODEC = new Base64Codec();
    }

    public static byte[] decode(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[str.length()];
        return CODEC.a(bArr, CodecUtils.sanitize(str, bArr));
    }

    public static byte[] encode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : CODEC.d(bArr);
    }

    public static String encodeAsString(byte... bArr) {
        if (bArr == null) {
            return null;
        }
        return bArr.length == 0 ? "" : CodecUtils.toStringDirect(CODEC.d(bArr));
    }

    public static byte[] decode(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? bArr : CODEC.a(bArr, bArr.length);
    }
}
