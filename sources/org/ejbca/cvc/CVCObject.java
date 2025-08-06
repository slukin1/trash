package org.ejbca.cvc;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;

public abstract class CVCObject implements Serializable {
    public static final int CVC_VERSION = 0;
    private static final int INT_LENGTH = 4;
    private static final int LONG_LENGTH = 8;
    public static final String NEWLINE = System.getProperty("line.separator");
    private static final long serialVersionUID = 1;
    private AbstractSequence parent;
    private final CVCTagEnum tag;

    public CVCObject(CVCTagEnum cVCTagEnum) {
        this.tag = cVCTagEnum;
    }

    public static int decodeLength(DataInputStream dataInputStream) throws IOException {
        int read = dataInputStream.read();
        if (read <= 127) {
            return read;
        }
        if ((read & 15) == 1) {
            return dataInputStream.readUnsignedByte();
        }
        return dataInputStream.readShort();
    }

    public static byte[] encodeLength(int i11) {
        int i12 = i11 > 127 ? i11 > 255 ? 2 : 1 : 0;
        ByteBuffer allocate = ByteBuffer.allocate(i12 + 1);
        if (i12 == 0) {
            allocate.put(0, (byte) i11);
        } else {
            allocate.put(0, (byte) (i12 + 128));
            if (i12 == 1) {
                allocate.put(1, (byte) i11);
            } else {
                allocate.putShort(1, (short) i11);
            }
        }
        return allocate.array();
    }

    public static byte[] toByteArray(Integer num) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(num.intValue());
        return trimByteArray(allocate.array());
    }

    public static byte[] trimByteArray(byte[] bArr) {
        int i11 = 0;
        boolean z11 = false;
        while (i11 < bArr.length) {
            z11 = bArr[i11] != 0;
            if (z11) {
                break;
            }
            i11++;
        }
        if (z11) {
            byte[] bArr2 = new byte[(bArr.length - i11)];
            System.arraycopy(bArr, i11, bArr2, 0, bArr.length - i11);
            return bArr2;
        }
        return new byte[]{0};
    }

    public abstract int encode(DataOutputStream dataOutputStream) throws IOException;

    public String getAsText() {
        return getAsText("", true);
    }

    public AbstractSequence getParent() {
        return this.parent;
    }

    public CVCTagEnum getTag() {
        return this.tag;
    }

    public void setParent(AbstractSequence abstractSequence) {
        this.parent = abstractSequence;
    }

    public String getAsText(boolean z11) {
        return getAsText("", z11);
    }

    public String getAsText(String str) {
        return getAsText(str, true);
    }

    public static byte[] toByteArray(Long l11) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.putLong(l11.longValue());
        return trimByteArray(allocate.array());
    }

    public String getAsText(String str, boolean z11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (z11) {
            stringBuffer.append(Integer.toHexString(getTag().getValue()));
            stringBuffer.append(' ');
        }
        stringBuffer.append(getTag().name());
        stringBuffer.append("  ");
        return stringBuffer.toString();
    }
}
