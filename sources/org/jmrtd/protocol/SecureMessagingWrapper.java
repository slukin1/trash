package org.jmrtd.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.tlv.TLVUtil;
import org.jmrtd.Util;

public abstract class SecureMessagingWrapper implements Serializable, APDUWrapper {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private static final long serialVersionUID = 4709645514566992414L;
    private transient Cipher cipher;
    private SecretKey ksEnc;
    private SecretKey ksMac;
    private transient Mac mac;
    private int maxTranceiveLength;
    private boolean shouldCheckMAC;
    private long ssc;

    public SecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, String str, String str2, int i11, boolean z11, long j11) throws GeneralSecurityException {
        this.maxTranceiveLength = i11;
        this.shouldCheckMAC = z11;
        this.ksEnc = secretKey;
        this.ksMac = secretKey2;
        this.ssc = j11;
        this.cipher = Util.getCipher(str);
        this.mac = Util.getMac(str2);
    }

    private byte[] encodeLe(int i11) {
        if (i11 < 0 || i11 > 256) {
            return new byte[]{(byte) ((65280 & i11) >> 8), (byte) (i11 & 255)};
        }
        return new byte[]{(byte) i11};
    }

    public static SecureMessagingWrapper getInstance(SecureMessagingWrapper secureMessagingWrapper) {
        try {
            if (secureMessagingWrapper instanceof DESedeSecureMessagingWrapper) {
                return new DESedeSecureMessagingWrapper((DESedeSecureMessagingWrapper) secureMessagingWrapper);
            }
            if (secureMessagingWrapper instanceof AESSecureMessagingWrapper) {
                return new AESSecureMessagingWrapper((AESSecureMessagingWrapper) secureMessagingWrapper);
            }
            LOGGER.warning("Not copying wrapper");
            return secureMessagingWrapper;
        } catch (GeneralSecurityException e11) {
            LOGGER.log(Level.WARNING, "Could not copy wrapper", e11);
        }
    }

    private byte[] readDO87(DataInputStream dataInputStream, boolean z11) throws IOException, GeneralSecurityException {
        int readUnsignedByte;
        int readUnsignedByte2 = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte2 & 128) == 128) {
            int i11 = readUnsignedByte2 & 127;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                i12 = (i12 << 8) | dataInputStream.readUnsignedByte();
            }
            if (z11 || dataInputStream.readUnsignedByte() == 1) {
                readUnsignedByte2 = i12;
            } else {
                throw new IllegalStateException("DO'87 expected 0x01 marker");
            }
        } else if (!z11 && (readUnsignedByte = dataInputStream.readUnsignedByte()) != 1) {
            throw new IllegalStateException("DO'87 expected 0x01 marker, found " + Integer.toHexString(readUnsignedByte & 255));
        }
        if (!z11) {
            readUnsignedByte2--;
        }
        byte[] bArr = new byte[readUnsignedByte2];
        dataInputStream.readFully(bArr);
        return Util.unpad(this.cipher.doFinal(bArr));
    }

    private byte[] readDO8E(DataInputStream dataInputStream) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if (readUnsignedByte == 8 || readUnsignedByte == 16) {
            byte[] bArr = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr);
            return bArr;
        }
        throw new IllegalStateException("DO'8E wrong length for MAC: " + readUnsignedByte);
    }

    private short readDO99(DataInputStream dataInputStream) throws IOException {
        if (dataInputStream.readUnsignedByte() == 2) {
            byte readByte = dataInputStream.readByte();
            return (short) ((dataInputStream.readByte() & 255) | ((readByte & 255) << 8));
        }
        throw new IllegalStateException("DO'99 wrong length");
    }

    private ResponseAPDU unwrapResponseAPDU(ResponseAPDU responseAPDU) throws GeneralSecurityException, IOException {
        byte[] bytes = responseAPDU.getBytes();
        if (bytes == null || bytes.length < 2) {
            throw new IllegalArgumentException("Invalid response APDU");
        }
        this.cipher.init(2, this.ksEnc, getIV());
        byte[] bArr = new byte[0];
        byte[] bArr2 = null;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bytes));
        boolean z11 = false;
        short s11 = 0;
        while (!z11) {
            try {
                byte readByte = dataInputStream.readByte();
                if (readByte == -123) {
                    bArr = readDO87(dataInputStream, true);
                } else if (readByte == -121) {
                    bArr = readDO87(dataInputStream, false);
                } else if (readByte == -114) {
                    bArr2 = readDO8E(dataInputStream);
                    z11 = true;
                } else if (readByte != -103) {
                    LOGGER.warning("Unexpected tag " + Integer.toHexString(readByte));
                } else {
                    s11 = readDO99(dataInputStream);
                }
            } catch (Throwable th2) {
                dataInputStream.close();
                throw th2;
            }
        }
        dataInputStream.close();
        if (!shouldCheckMAC() || checkMac(bytes, bArr2)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr, 0, bArr.length);
            byteArrayOutputStream.write((65280 & s11) >> 8);
            byteArrayOutputStream.write(s11 & 255);
            return new ResponseAPDU(byteArrayOutputStream.toByteArray());
        }
        throw new IllegalStateException("Invalid MAC");
    }

    private CommandAPDU wrapCommandAPDU(CommandAPDU commandAPDU) throws GeneralSecurityException, IOException {
        int cla = commandAPDU.getCLA();
        int ins = commandAPDU.getINS();
        int p12 = commandAPDU.getP1();
        int p22 = commandAPDU.getP2();
        int nc2 = commandAPDU.getNc();
        int ne2 = commandAPDU.getNe();
        byte[] bArr = {(byte) (cla | 12), (byte) ins, (byte) p12, (byte) p22};
        byte[] pad = Util.pad(bArr, getPadLength());
        boolean z11 = ((byte) commandAPDU.getINS()) == -79;
        byte[] bArr2 = new byte[0];
        byte[] bArr3 = new byte[0];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (ne2 > 0) {
            try {
                bArr3 = TLVUtil.wrapDO(151, encodeLe(ne2));
            } catch (Throwable th2) {
                Throwable th3 = th2;
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e11) {
                    LOGGER.log(Level.FINE, "Error closing stream", e11);
                }
                throw th3;
            }
        }
        if (nc2 > 0) {
            byte[] pad2 = Util.pad(commandAPDU.getData(), getPadLength());
            this.cipher.init(1, this.ksEnc, getIV());
            byte[] doFinal = this.cipher.doFinal(pad2);
            byteArrayOutputStream.reset();
            byteArrayOutputStream.write(z11 ? -123 : -121);
            byteArrayOutputStream.write(TLVUtil.getLengthAsBytes(doFinal.length + (z11 ? 0 : 1)));
            if (!z11) {
                byteArrayOutputStream.write(1);
            }
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            bArr2 = byteArrayOutputStream.toByteArray();
        }
        byteArrayOutputStream.reset();
        byteArrayOutputStream.write(getEncodedSendSequenceCounter());
        byteArrayOutputStream.write(pad);
        byteArrayOutputStream.write(bArr2);
        byteArrayOutputStream.write(bArr3);
        byte[] pad3 = Util.pad(byteArrayOutputStream.toByteArray(), getPadLength());
        this.mac.init(this.ksMac);
        byte[] doFinal2 = this.mac.doFinal(pad3);
        int length = doFinal2.length;
        if (length != 8) {
            length = 8;
        }
        byteArrayOutputStream.reset();
        byteArrayOutputStream.write(-114);
        byteArrayOutputStream.write(length);
        byteArrayOutputStream.write(doFinal2, 0, length);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        byteArrayOutputStream.write(bArr2);
        byteArrayOutputStream.write(bArr3);
        byteArrayOutputStream.write(byteArray);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e12) {
            LOGGER.log(Level.FINE, "Error closing stream", e12);
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        if (ne2 <= 256 && byteArray2.length <= 255) {
            return new CommandAPDU(bArr[0], bArr[1], bArr[2], bArr[3], byteArray2, 256);
        }
        if (ne2 > 256 || byteArray2.length > 255) {
            return new CommandAPDU(bArr[0], bArr[1], bArr[2], bArr[3], byteArray2, 65536);
        }
        return new CommandAPDU(bArr[0], bArr[1], bArr[2], bArr[3], byteArray2, getMaxTranceiveLength());
    }

    public boolean checkMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.write(getEncodedSendSequenceCounter());
            byte[] pad = Util.pad(bArr, 0, ((bArr.length - 2) - 8) - 2, getPadLength());
            dataOutputStream.write(pad, 0, pad.length);
            dataOutputStream.flush();
            dataOutputStream.close();
            this.mac.init(this.ksMac);
            byte[] doFinal = this.mac.doFinal(byteArrayOutputStream.toByteArray());
            if (doFinal.length > 8 && bArr2.length == 8) {
                byte[] bArr3 = new byte[8];
                System.arraycopy(doFinal, 0, bArr3, 0, 8);
                doFinal = bArr3;
            }
            return Arrays.equals(bArr2, doFinal);
        } catch (IOException e11) {
            LOGGER.log(Level.WARNING, "Exception checking MAC", e11);
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SecureMessagingWrapper secureMessagingWrapper = (SecureMessagingWrapper) obj;
        SecretKey secretKey = this.ksEnc;
        if (secretKey == null) {
            if (secureMessagingWrapper.ksEnc != null) {
                return false;
            }
        } else if (!secretKey.equals(secureMessagingWrapper.ksEnc)) {
            return false;
        }
        SecretKey secretKey2 = this.ksMac;
        if (secretKey2 == null) {
            if (secureMessagingWrapper.ksMac != null) {
                return false;
            }
        } else if (!secretKey2.equals(secureMessagingWrapper.ksMac)) {
            return false;
        }
        if (this.maxTranceiveLength != secureMessagingWrapper.maxTranceiveLength || this.shouldCheckMAC != secureMessagingWrapper.shouldCheckMAC) {
            return false;
        }
        if (this.ssc == secureMessagingWrapper.ssc) {
            return true;
        }
        return false;
    }

    public abstract byte[] getEncodedSendSequenceCounter();

    public SecretKey getEncryptionKey() {
        return this.ksEnc;
    }

    public abstract IvParameterSpec getIV() throws GeneralSecurityException;

    public SecretKey getMACKey() {
        return this.ksMac;
    }

    public int getMaxTranceiveLength() {
        return this.maxTranceiveLength;
    }

    public abstract int getPadLength();

    public long getSendSequenceCounter() {
        return this.ssc;
    }

    public int hashCode() {
        SecretKey secretKey = this.ksEnc;
        int i11 = 0;
        int hashCode = ((secretKey == null ? 0 : secretKey.hashCode()) + 31) * 31;
        SecretKey secretKey2 = this.ksMac;
        if (secretKey2 != null) {
            i11 = secretKey2.hashCode();
        }
        int i12 = (((hashCode + i11) * 31) + this.maxTranceiveLength) * 31;
        int i13 = this.shouldCheckMAC ? 1231 : 1237;
        long j11 = this.ssc;
        return ((i12 + i13) * 31) + ((int) (j11 ^ (j11 >>> 32)));
    }

    public boolean shouldCheckMAC() {
        return this.shouldCheckMAC;
    }

    public String toString() {
        return "SecureMessagingWrapper [" + "ssc: " + this.ssc + ", ksEnc: " + this.ksEnc + ", ksMac: " + this.ksMac + ", maxTranceiveLength: " + this.maxTranceiveLength + ", shouldCheckMAC: " + this.shouldCheckMAC + "]";
    }

    public ResponseAPDU unwrap(ResponseAPDU responseAPDU) {
        this.ssc++;
        try {
            byte[] data = responseAPDU.getData();
            if (data != null && data.length > 0) {
                return unwrapResponseAPDU(responseAPDU);
            }
            throw new IllegalStateException("Card indicates SM error, SW = " + Integer.toHexString(responseAPDU.getSW() & 65535));
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException("Unexpected exception", e11);
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected exception", e12);
        }
    }

    public CommandAPDU wrap(CommandAPDU commandAPDU) {
        this.ssc++;
        try {
            return wrapCommandAPDU(commandAPDU);
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException("Unexpected exception", e11);
        } catch (IOException e12) {
            throw new IllegalStateException("Unexpected exception", e12);
        }
    }
}
