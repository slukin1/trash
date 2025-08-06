package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class KeyData {
    private static final int BYTES_PER_FIELD = 8;
    public static final String CHANNEL = "flutter/keydata";
    private static final int FIELD_COUNT = 5;
    private static final String TAG = "KeyData";
    public String character;
    public long logicalKey;
    public long physicalKey;
    public boolean synthesized;
    public long timestamp;
    public Type type;

    public enum Type {
        kDown(0),
        kUp(1),
        kRepeat(2);
        
        private long value;

        private Type(long j11) {
            this.value = j11;
        }

        public static Type fromLong(long j11) {
            int i11 = (int) j11;
            if (i11 == 0) {
                return kDown;
            }
            if (i11 == 1) {
                return kUp;
            }
            if (i11 == 2) {
                return kRepeat;
            }
            throw new AssertionError("Unexpected Type value");
        }

        public long getValue() {
            return this.value;
        }
    }

    public KeyData() {
    }

    public ByteBuffer toBytes() {
        int i11;
        try {
            String str = this.character;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            if (bytes == null) {
                i11 = 0;
            } else {
                i11 = bytes.length;
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i11 + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong((long) i11);
            allocateDirect.putLong(this.timestamp);
            allocateDirect.putLong(this.type.getValue());
            allocateDirect.putLong(this.physicalKey);
            allocateDirect.putLong(this.logicalKey);
            allocateDirect.putLong(this.synthesized ? 1 : 0);
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }

    public KeyData(ByteBuffer byteBuffer) {
        long j11 = byteBuffer.getLong();
        this.timestamp = byteBuffer.getLong();
        this.type = Type.fromLong(byteBuffer.getLong());
        this.physicalKey = byteBuffer.getLong();
        this.logicalKey = byteBuffer.getLong();
        this.synthesized = byteBuffer.getLong() != 0;
        if (((long) byteBuffer.remaining()) == j11) {
            this.character = null;
            if (j11 != 0) {
                int i11 = (int) j11;
                byte[] bArr = new byte[i11];
                byteBuffer.get(bArr, 0, i11);
                try {
                    this.character = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                    throw new AssertionError("UTF-8 unsupported");
                }
            }
        } else {
            throw new AssertionError(String.format("Unexpected char length: charSize is %d while buffer has position %d, capacity %d, limit %d", new Object[]{Long.valueOf(j11), Integer.valueOf(byteBuffer.position()), Integer.valueOf(byteBuffer.capacity()), Integer.valueOf(byteBuffer.limit())}));
        }
    }
}
