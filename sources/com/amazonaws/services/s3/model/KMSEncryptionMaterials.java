package com.amazonaws.services.s3.model;

import java.security.KeyPair;
import javax.crypto.SecretKey;

@Deprecated
public class KMSEncryptionMaterials extends EncryptionMaterials {
    public static final String CUSTOMER_MASTER_KEY_ID = "kms_cmk_id";

    public KMSEncryptionMaterials(String str) {
        super((KeyPair) null, (SecretKey) null);
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The default customer master key id must be specified");
        }
        addDescription(CUSTOMER_MASTER_KEY_ID, str);
    }

    public String getCustomerMasterKeyId() {
        return getDescription(CUSTOMER_MASTER_KEY_ID);
    }

    public final KeyPair getKeyPair() {
        throw new UnsupportedOperationException();
    }

    public final SecretKey getSymmetricKey() {
        throw new UnsupportedOperationException();
    }

    public final boolean isKMSEnabled() {
        return true;
    }

    public String toString() {
        return String.valueOf(getMaterialsDescription());
    }
}
