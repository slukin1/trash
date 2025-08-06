package net.sf.scuba.tlv;

import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.ISO7816;

public class TLVUtil implements ASN1Constants {
    private static final Logger LOGGER = Logger.getLogger("net.sf.scuba.tlv");

    private TLVUtil() {
    }

    public static byte[] getLengthAsBytes(int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i11 < 128) {
            byteArrayOutputStream.write(i11);
        } else {
            int log = log(i11, 256);
            byteArrayOutputStream.write(log | 128);
            for (int i12 = 0; i12 < log; i12++) {
                int i13 = ((log - i12) - 1) * 8;
                byteArrayOutputStream.write(((255 << i13) & i11) >> i13);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int getLengthLength(int i11) {
        return getLengthAsBytes(i11).length;
    }

    public static byte[] getTagAsBytes(int i11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int log = ((int) (Math.log((double) i11) / Math.log(256.0d))) + 1;
        for (int i12 = 0; i12 < log; i12++) {
            int i13 = ((log - i12) - 1) * 8;
            byteArrayOutputStream.write(((255 << i13) & i11) >> i13);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int tagClass = getTagClass(i11);
        if (tagClass == 1) {
            byteArray[0] = (byte) (byteArray[0] | SignedBytes.MAX_POWER_OF_TWO);
        } else if (tagClass == 2) {
            byteArray[0] = (byte) (byteArray[0] | 128);
        } else if (tagClass == 3) {
            byteArray[0] = (byte) (byteArray[0] | ISO7816.INS_GET_RESPONSE);
        }
        if (!isPrimitive(i11)) {
            byteArray[0] = (byte) (byteArray[0] | 32);
        }
        return byteArray;
    }

    public static int getTagClass(int i11) {
        int i12 = 3;
        while (i12 >= 0 && ((255 << (i12 * 8)) & i11) == 0) {
            i12--;
        }
        int i13 = i12 * 8;
        int i14 = ((i11 & (255 << i13)) >> i13) & 255 & 192;
        if (i14 == 0) {
            return 0;
        }
        if (i14 != 64) {
            return i14 != 128 ? 3 : 2;
        }
        return 1;
    }

    public static int getTagLength(int i11) {
        return getTagAsBytes(i11).length;
    }

    public static boolean isPrimitive(int i11) {
        int i12 = 3;
        while (i12 >= 0 && ((255 << (i12 * 8)) & i11) == 0) {
            i12--;
        }
        int i13 = i12 * 8;
        return ((((i11 & (255 << i13)) >> i13) & 255) & 32) == 0;
    }

    private static int log(int i11, int i12) {
        int i13 = 0;
        while (i11 > 0) {
            i11 /= i12;
            i13++;
        }
        return i13;
    }

    public static byte[] unwrapDO(int i11, byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            throw new IllegalArgumentException("Wrapped data is null or length < 2");
        }
        TLVInputStream tLVInputStream = new TLVInputStream(new ByteArrayInputStream(bArr));
        try {
            int readTag = tLVInputStream.readTag();
            if (readTag == i11) {
                int readLength = tLVInputStream.readLength();
                byte[] bArr2 = new byte[readLength];
                System.arraycopy(tLVInputStream.readValue(), 0, bArr2, 0, readLength);
                try {
                    tLVInputStream.close();
                } catch (IOException e11) {
                    LOGGER.log(Level.FINE, "Error closing stream", e11);
                }
                return bArr2;
            }
            throw new IllegalArgumentException("Expected tag " + Integer.toHexString(i11) + ", found tag " + Integer.toHexString(readTag));
        } catch (IOException e12) {
            throw new IllegalStateException("Error reading from stream", e12);
        } catch (Throwable th2) {
            try {
                tLVInputStream.close();
            } catch (IOException e13) {
                LOGGER.log(Level.FINE, "Error closing stream", e13);
            }
            throw th2;
        }
    }

    public static byte[] wrapDO(int i11, byte[] bArr) {
        if (bArr != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                TLVOutputStream tLVOutputStream = new TLVOutputStream(byteArrayOutputStream);
                tLVOutputStream.writeTag(i11);
                tLVOutputStream.writeValue(bArr);
                tLVOutputStream.flush();
                tLVOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e11) {
                    LOGGER.log(Level.FINE, "Error closing stream", e11);
                }
                return byteArray;
            } catch (IOException e12) {
                throw new IllegalStateException("Error writing stream", e12);
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e13) {
                    LOGGER.log(Level.FINE, "Error closing stream", e13);
                }
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Data to wrap is null");
        }
    }
}
