package com.tencent.android.tpns.mqtt.internal.websocket;

import java.util.Objects;
import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

public class Base64 {
    private static final Base64Encoder ENCODER;
    private static final Base64 INSTANCE;

    public class Base64Encoder extends AbstractPreferences {
        private String base64String = null;

        public Base64Encoder() {
            super((AbstractPreferences) null, "");
        }

        public AbstractPreferences childSpi(String str) {
            return null;
        }

        public String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        public void flushSpi() throws BackingStoreException {
        }

        public String getBase64String() {
            return this.base64String;
        }

        public String getSpi(String str) {
            return null;
        }

        public String[] keysSpi() throws BackingStoreException {
            return null;
        }

        public void putSpi(String str, String str2) {
            this.base64String = str2;
        }

        public void removeNodeSpi() throws BackingStoreException {
        }

        public void removeSpi(String str) {
        }

        public void syncSpi() throws BackingStoreException {
        }
    }

    static {
        Base64 base64 = new Base64();
        INSTANCE = base64;
        Objects.requireNonNull(base64);
        ENCODER = new Base64Encoder();
    }

    public static String encode(String str) {
        Base64Encoder base64Encoder = ENCODER;
        base64Encoder.putByteArray("akey", str.getBytes());
        return base64Encoder.getBase64String();
    }

    public static String encodeBytes(byte[] bArr) {
        Base64Encoder base64Encoder = ENCODER;
        base64Encoder.putByteArray("aKey", bArr);
        return base64Encoder.getBase64String();
    }
}
