package org.jmrtd.protocol;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class DESedeSecureMessagingWrapper extends SecureMessagingWrapper {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final IvParameterSpec ZERO_IV_PARAM_SPEC = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0});
    private static final long serialVersionUID = -2859033943345961793L;

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2) throws GeneralSecurityException {
        this(secretKey, secretKey2, true);
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
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new DataOutputStream(byteArrayOutputStream).writeLong(getSendSequenceCounter());
            try {
                byteArrayOutputStream.close();
            } catch (IOException e11) {
                LOGGER.log(Level.FINE, "Error closing stream", e11);
            }
        } catch (IOException e12) {
            LOGGER.log(Level.FINE, "Error writing to stream", e12);
            byteArrayOutputStream.close();
        } catch (Throwable th2) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e13) {
                LOGGER.log(Level.FINE, "Error closing stream", e13);
            }
            throw th2;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public IvParameterSpec getIV() {
        return ZERO_IV_PARAM_SPEC;
    }

    public int getPadLength() {
        return 8;
    }

    public String getType() {
        return "DESede";
    }

    public int hashCode() {
        return (super.hashCode() * 31) + 13;
    }

    public String toString() {
        return "DESedeSecureMessagingWrapper [" + "ssc: " + getSendSequenceCounter() + ", kEnc: " + getEncryptionKey() + ", kMac: " + getMACKey() + ", shouldCheckMAC: " + shouldCheckMAC() + ", maxTranceiveLength: " + getMaxTranceiveLength() + "]";
    }

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, boolean z11) throws GeneralSecurityException {
        this(secretKey, secretKey2, 256, z11, 0);
    }

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, long j11) throws GeneralSecurityException {
        this(secretKey, secretKey2, 256, true, j11);
    }

    public DESedeSecureMessagingWrapper(DESedeSecureMessagingWrapper dESedeSecureMessagingWrapper) throws GeneralSecurityException {
        this(dESedeSecureMessagingWrapper.getEncryptionKey(), dESedeSecureMessagingWrapper.getMACKey(), dESedeSecureMessagingWrapper.getMaxTranceiveLength(), dESedeSecureMessagingWrapper.shouldCheckMAC(), dESedeSecureMessagingWrapper.getSendSequenceCounter());
    }

    public DESedeSecureMessagingWrapper(SecretKey secretKey, SecretKey secretKey2, int i11, boolean z11, long j11) throws GeneralSecurityException {
        super(secretKey, secretKey2, "DESede/CBC/NoPadding", "ISO9797Alg3Mac", i11, z11, j11);
    }
}
