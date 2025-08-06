package org.jmrtd.protocol;

import com.sumsub.sns.prooface.network.b;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import org.jmrtd.Util;

public class AESSecureMessagingWrapper extends SecureMessagingWrapper {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 2086301081448345496L;
    private transient Cipher sscIVCipher;

    public AESSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, long j11) throws GeneralSecurityException {
        this(secretKey, secretKey2, 256, true, j11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return super.equals(obj);
        }
        return false;
    }

    public byte[] getEncodedSendSequenceCounter() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16);
        try {
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            byteArrayOutputStream.write(0);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(getSendSequenceCounter());
            dataOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                LOGGER.log(Level.FINE, "Error closing stream", e11);
            }
            return byteArray;
        } catch (IOException e12) {
            LOGGER.log(Level.FINE, "Error writing to stream", e12);
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (IOException e13) {
                LOGGER.log(Level.FINE, "Error closing stream", e13);
                return null;
            }
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e14) {
                LOGGER.log(Level.FINE, "Error closing stream", e14);
            }
            throw th2;
        }
    }

    public IvParameterSpec getIV() throws GeneralSecurityException {
        return new IvParameterSpec(this.sscIVCipher.doFinal(getEncodedSendSequenceCounter()));
    }

    public int getPadLength() {
        return 16;
    }

    public String getType() {
        return b.f40261d;
    }

    public int hashCode() {
        return (super.hashCode() * 71) + 17;
    }

    public String toString() {
        return "AESSecureMessagingWrapper [" + "ssc: " + getSendSequenceCounter() + ", kEnc: " + getEncryptionKey() + ", kMac: " + getMACKey() + ", shouldCheckMAC: " + shouldCheckMAC() + ", maxTranceiveLength: " + getMaxTranceiveLength() + "]";
    }

    public AESSecureMessagingWrapper(AESSecureMessagingWrapper aESSecureMessagingWrapper) throws GeneralSecurityException {
        this(aESSecureMessagingWrapper.getEncryptionKey(), aESSecureMessagingWrapper.getMACKey(), aESSecureMessagingWrapper.getMaxTranceiveLength(), aESSecureMessagingWrapper.shouldCheckMAC(), aESSecureMessagingWrapper.getSendSequenceCounter());
    }

    public AESSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, int i11, boolean z11, long j11) throws GeneralSecurityException {
        super(secretKey, secretKey2, "AES/CBC/NoPadding", "AESCMAC", i11, z11, j11);
        this.sscIVCipher = Util.getCipher("AES/ECB/NoPadding", 1, secretKey);
    }
}
