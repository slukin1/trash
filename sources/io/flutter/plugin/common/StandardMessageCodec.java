package io.flutter.plugin.common;

import com.twitter.sdk.android.core.internal.network.UrlUtils;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class StandardMessageCodec implements MessageCodec<Object> {
    private static final byte BIGINT = 5;
    private static final byte BYTE_ARRAY = 8;
    private static final byte DOUBLE = 6;
    private static final byte DOUBLE_ARRAY = 11;
    private static final byte FALSE = 2;
    private static final byte FLOAT_ARRAY = 14;
    public static final StandardMessageCodec INSTANCE = new StandardMessageCodec();
    private static final byte INT = 3;
    private static final byte INT_ARRAY = 9;
    private static final byte LIST = 12;
    private static final boolean LITTLE_ENDIAN = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);
    private static final byte LONG = 4;
    private static final byte LONG_ARRAY = 10;
    private static final byte MAP = 13;
    private static final byte NULL = 0;
    private static final byte STRING = 7;
    private static final String TAG = "StandardMessageCodec#";
    private static final byte TRUE = 1;
    private static final Charset UTF8 = Charset.forName(UrlUtils.UTF8);

    public static final class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public byte[] buffer() {
            return this.buf;
        }
    }

    public static final void readAlignment(ByteBuffer byteBuffer, int i11) {
        int position = byteBuffer.position() % i11;
        if (position != 0) {
            byteBuffer.position((byteBuffer.position() + i11) - position);
        }
    }

    public static final byte[] readBytes(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[readSize(byteBuffer)];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static final int readSize(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byte b11 = byteBuffer.get() & 255;
            if (b11 < 254) {
                return b11;
            }
            if (b11 == 254) {
                return byteBuffer.getChar();
            }
            return byteBuffer.getInt();
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public static final void writeAlignment(ByteArrayOutputStream byteArrayOutputStream, int i11) {
        int size = byteArrayOutputStream.size() % i11;
        if (size != 0) {
            for (int i12 = 0; i12 < i11 - size; i12++) {
                byteArrayOutputStream.write(0);
            }
        }
    }

    public static final void writeBytes(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr) {
        writeSize(byteArrayOutputStream, bArr.length);
        byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public static final void writeChar(ByteArrayOutputStream byteArrayOutputStream, int i11) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i11);
            byteArrayOutputStream.write(i11 >>> 8);
            return;
        }
        byteArrayOutputStream.write(i11 >>> 8);
        byteArrayOutputStream.write(i11);
    }

    public static final void writeDouble(ByteArrayOutputStream byteArrayOutputStream, double d11) {
        writeLong(byteArrayOutputStream, Double.doubleToLongBits(d11));
    }

    public static final void writeFloat(ByteArrayOutputStream byteArrayOutputStream, float f11) {
        writeInt(byteArrayOutputStream, Float.floatToIntBits(f11));
    }

    public static final void writeInt(ByteArrayOutputStream byteArrayOutputStream, int i11) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write(i11);
            byteArrayOutputStream.write(i11 >>> 8);
            byteArrayOutputStream.write(i11 >>> 16);
            byteArrayOutputStream.write(i11 >>> 24);
            return;
        }
        byteArrayOutputStream.write(i11 >>> 24);
        byteArrayOutputStream.write(i11 >>> 16);
        byteArrayOutputStream.write(i11 >>> 8);
        byteArrayOutputStream.write(i11);
    }

    public static final void writeLong(ByteArrayOutputStream byteArrayOutputStream, long j11) {
        if (LITTLE_ENDIAN) {
            byteArrayOutputStream.write((byte) ((int) j11));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 8)));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 16)));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 24)));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 32)));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 40)));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 48)));
            byteArrayOutputStream.write((byte) ((int) (j11 >>> 56)));
            return;
        }
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 56)));
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 48)));
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 40)));
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 32)));
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 24)));
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 16)));
        byteArrayOutputStream.write((byte) ((int) (j11 >>> 8)));
        byteArrayOutputStream.write((byte) ((int) j11));
    }

    public static final void writeSize(ByteArrayOutputStream byteArrayOutputStream, int i11) {
        if (i11 < 254) {
            byteArrayOutputStream.write(i11);
        } else if (i11 <= 65535) {
            byteArrayOutputStream.write(254);
            writeChar(byteArrayOutputStream, i11);
        } else {
            byteArrayOutputStream.write(255);
            writeInt(byteArrayOutputStream, i11);
        }
    }

    public Object decodeMessage(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object readValue = readValue(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return readValue;
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public ByteBuffer encodeMessage(Object obj) {
        if (obj == null) {
            return null;
        }
        ExposedByteArrayOutputStream exposedByteArrayOutputStream = new ExposedByteArrayOutputStream();
        writeValue(exposedByteArrayOutputStream, obj);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(exposedByteArrayOutputStream.size());
        allocateDirect.put(exposedByteArrayOutputStream.buffer(), 0, exposedByteArrayOutputStream.size());
        return allocateDirect;
    }

    public final Object readValue(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return readValueOfType(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    /* JADX WARNING: type inference failed for: r1v10, types: [java.util.Map, java.util.HashMap] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object readValueOfType(byte r5, java.nio.ByteBuffer r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 4
            r2 = 8
            switch(r5) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00ef;
                case 2: goto L_0x00ec;
                case 3: goto L_0x00e3;
                case 4: goto L_0x00da;
                case 5: goto L_0x00c7;
                case 6: goto L_0x00bb;
                case 7: goto L_0x00af;
                case 8: goto L_0x00aa;
                case 9: goto L_0x0090;
                case 10: goto L_0x0076;
                case 11: goto L_0x005b;
                case 12: goto L_0x0043;
                case 13: goto L_0x002a;
                case 14: goto L_0x000f;
                default: goto L_0x0007;
            }
        L_0x0007:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Message corrupted"
            r5.<init>(r6)
            throw r5
        L_0x000f:
            int r5 = readSize(r6)
            float[] r0 = new float[r5]
            readAlignment(r6, r1)
            java.nio.FloatBuffer r2 = r6.asFloatBuffer()
            r2.get(r0)
            int r2 = r6.position()
            int r5 = r5 * r1
            int r2 = r2 + r5
            r6.position(r2)
            goto L_0x00f3
        L_0x002a:
            int r5 = readSize(r6)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L_0x0033:
            if (r0 >= r5) goto L_0x0058
            java.lang.Object r2 = r4.readValue(r6)
            java.lang.Object r3 = r4.readValue(r6)
            r1.put(r2, r3)
            int r0 = r0 + 1
            goto L_0x0033
        L_0x0043:
            int r5 = readSize(r6)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r5)
        L_0x004c:
            if (r0 >= r5) goto L_0x0058
            java.lang.Object r2 = r4.readValue(r6)
            r1.add(r2)
            int r0 = r0 + 1
            goto L_0x004c
        L_0x0058:
            r0 = r1
            goto L_0x00f3
        L_0x005b:
            int r5 = readSize(r6)
            double[] r0 = new double[r5]
            readAlignment(r6, r2)
            java.nio.DoubleBuffer r1 = r6.asDoubleBuffer()
            r1.get(r0)
            int r1 = r6.position()
            int r5 = r5 * r2
            int r1 = r1 + r5
            r6.position(r1)
            goto L_0x00f3
        L_0x0076:
            int r5 = readSize(r6)
            long[] r0 = new long[r5]
            readAlignment(r6, r2)
            java.nio.LongBuffer r1 = r6.asLongBuffer()
            r1.get(r0)
            int r1 = r6.position()
            int r5 = r5 * r2
            int r1 = r1 + r5
            r6.position(r1)
            goto L_0x00f3
        L_0x0090:
            int r5 = readSize(r6)
            int[] r0 = new int[r5]
            readAlignment(r6, r1)
            java.nio.IntBuffer r2 = r6.asIntBuffer()
            r2.get(r0)
            int r2 = r6.position()
            int r5 = r5 * r1
            int r2 = r2 + r5
            r6.position(r2)
            goto L_0x00f3
        L_0x00aa:
            byte[] r0 = readBytes(r6)
            goto L_0x00f3
        L_0x00af:
            byte[] r5 = readBytes(r6)
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r6 = UTF8
            r0.<init>(r5, r6)
            goto L_0x00f3
        L_0x00bb:
            readAlignment(r6, r2)
            double r5 = r6.getDouble()
            java.lang.Double r0 = java.lang.Double.valueOf(r5)
            goto L_0x00f3
        L_0x00c7:
            byte[] r5 = readBytes(r6)
            java.math.BigInteger r0 = new java.math.BigInteger
            java.lang.String r6 = new java.lang.String
            java.nio.charset.Charset r1 = UTF8
            r6.<init>(r5, r1)
            r5 = 16
            r0.<init>(r6, r5)
            goto L_0x00f3
        L_0x00da:
            long r5 = r6.getLong()
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            goto L_0x00f3
        L_0x00e3:
            int r5 = r6.getInt()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            goto L_0x00f3
        L_0x00ec:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            goto L_0x00f3
        L_0x00ef:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            goto L_0x00f3
        L_0x00f2:
            r0 = 0
        L_0x00f3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.common.StandardMessageCodec.readValueOfType(byte, java.nio.ByteBuffer):java.lang.Object");
    }

    public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
        int i11 = 0;
        if (obj == null || obj.equals((Object) null)) {
            byteArrayOutputStream.write(0);
        } else if (obj instanceof Boolean) {
            byteArrayOutputStream.write(((Boolean) obj).booleanValue() ? 1 : 2);
        } else if (obj instanceof Number) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                byteArrayOutputStream.write(3);
                writeInt(byteArrayOutputStream, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                byteArrayOutputStream.write(4);
                writeLong(byteArrayOutputStream, ((Long) obj).longValue());
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                byteArrayOutputStream.write(6);
                writeAlignment(byteArrayOutputStream, 8);
                writeDouble(byteArrayOutputStream, ((Number) obj).doubleValue());
            } else if (obj instanceof BigInteger) {
                byteArrayOutputStream.write(5);
                writeBytes(byteArrayOutputStream, ((BigInteger) obj).toString(16).getBytes(UTF8));
            } else {
                throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
            }
        } else if (obj instanceof CharSequence) {
            byteArrayOutputStream.write(7);
            writeBytes(byteArrayOutputStream, obj.toString().getBytes(UTF8));
        } else if (obj instanceof byte[]) {
            byteArrayOutputStream.write(8);
            writeBytes(byteArrayOutputStream, (byte[]) obj);
        } else if (obj instanceof int[]) {
            byteArrayOutputStream.write(9);
            int[] iArr = (int[]) obj;
            writeSize(byteArrayOutputStream, iArr.length);
            writeAlignment(byteArrayOutputStream, 4);
            int length = iArr.length;
            while (i11 < length) {
                writeInt(byteArrayOutputStream, iArr[i11]);
                i11++;
            }
        } else if (obj instanceof long[]) {
            byteArrayOutputStream.write(10);
            long[] jArr = (long[]) obj;
            writeSize(byteArrayOutputStream, jArr.length);
            writeAlignment(byteArrayOutputStream, 8);
            int length2 = jArr.length;
            while (i11 < length2) {
                writeLong(byteArrayOutputStream, jArr[i11]);
                i11++;
            }
        } else if (obj instanceof double[]) {
            byteArrayOutputStream.write(11);
            double[] dArr = (double[]) obj;
            writeSize(byteArrayOutputStream, dArr.length);
            writeAlignment(byteArrayOutputStream, 8);
            int length3 = dArr.length;
            while (i11 < length3) {
                writeDouble(byteArrayOutputStream, dArr[i11]);
                i11++;
            }
        } else if (obj instanceof List) {
            byteArrayOutputStream.write(12);
            List<Object> list = (List) obj;
            writeSize(byteArrayOutputStream, list.size());
            for (Object writeValue : list) {
                writeValue(byteArrayOutputStream, writeValue);
            }
        } else if (obj instanceof Map) {
            byteArrayOutputStream.write(13);
            Map map = (Map) obj;
            writeSize(byteArrayOutputStream, map.size());
            for (Map.Entry entry : map.entrySet()) {
                writeValue(byteArrayOutputStream, entry.getKey());
                writeValue(byteArrayOutputStream, entry.getValue());
            }
        } else if (obj instanceof float[]) {
            byteArrayOutputStream.write(14);
            float[] fArr = (float[]) obj;
            writeSize(byteArrayOutputStream, fArr.length);
            writeAlignment(byteArrayOutputStream, 4);
            int length4 = fArr.length;
            while (i11 < length4) {
                writeFloat(byteArrayOutputStream, fArr[i11]);
                i11++;
            }
        } else {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
    }
}
