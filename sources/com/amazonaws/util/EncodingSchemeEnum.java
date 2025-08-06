package com.amazonaws.util;

public enum EncodingSchemeEnum {
    BASE16 {
        public byte[] decode(String str) {
            return Base16.decode(str);
        }

        public String encodeAsString(byte[] bArr) {
            return Base16.encodeAsString(bArr);
        }
    },
    BASE32 {
        public byte[] decode(String str) {
            return Base32.decode(str);
        }

        public String encodeAsString(byte[] bArr) {
            return Base32.encodeAsString(bArr);
        }
    },
    BASE64 {
        public byte[] decode(String str) {
            return Base64.decode(str);
        }

        public String encodeAsString(byte[] bArr) {
            return Base64.encodeAsString(bArr);
        }
    };

    public abstract String encodeAsString(byte[] bArr);
}
