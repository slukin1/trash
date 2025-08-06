package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GetPublicKeyResult implements Serializable {
    private String customerMasterKeySpec;
    private List<String> encryptionAlgorithms = new ArrayList();
    private List<String> keyAgreementAlgorithms = new ArrayList();
    private String keyId;
    private String keySpec;
    private String keyUsage;
    private ByteBuffer publicKey;
    private List<String> signingAlgorithms = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetPublicKeyResult)) {
            return false;
        }
        GetPublicKeyResult getPublicKeyResult = (GetPublicKeyResult) obj;
        if ((getPublicKeyResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (getPublicKeyResult.getKeyId() != null && !getPublicKeyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((getPublicKeyResult.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (getPublicKeyResult.getPublicKey() != null && !getPublicKeyResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((getPublicKeyResult.getCustomerMasterKeySpec() == null) ^ (getCustomerMasterKeySpec() == null)) {
            return false;
        }
        if (getPublicKeyResult.getCustomerMasterKeySpec() != null && !getPublicKeyResult.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if ((getPublicKeyResult.getKeySpec() == null) ^ (getKeySpec() == null)) {
            return false;
        }
        if (getPublicKeyResult.getKeySpec() != null && !getPublicKeyResult.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if ((getPublicKeyResult.getKeyUsage() == null) ^ (getKeyUsage() == null)) {
            return false;
        }
        if (getPublicKeyResult.getKeyUsage() != null && !getPublicKeyResult.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if ((getPublicKeyResult.getEncryptionAlgorithms() == null) ^ (getEncryptionAlgorithms() == null)) {
            return false;
        }
        if (getPublicKeyResult.getEncryptionAlgorithms() != null && !getPublicKeyResult.getEncryptionAlgorithms().equals(getEncryptionAlgorithms())) {
            return false;
        }
        if ((getPublicKeyResult.getSigningAlgorithms() == null) ^ (getSigningAlgorithms() == null)) {
            return false;
        }
        if (getPublicKeyResult.getSigningAlgorithms() != null && !getPublicKeyResult.getSigningAlgorithms().equals(getSigningAlgorithms())) {
            return false;
        }
        if ((getPublicKeyResult.getKeyAgreementAlgorithms() == null) ^ (getKeyAgreementAlgorithms() == null)) {
            return false;
        }
        return getPublicKeyResult.getKeyAgreementAlgorithms() == null || getPublicKeyResult.getKeyAgreementAlgorithms().equals(getKeyAgreementAlgorithms());
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public List<String> getEncryptionAlgorithms() {
        return this.encryptionAlgorithms;
    }

    public List<String> getKeyAgreementAlgorithms() {
        return this.keyAgreementAlgorithms;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public List<String> getSigningAlgorithms() {
        return this.signingAlgorithms;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31) + (getCustomerMasterKeySpec() == null ? 0 : getCustomerMasterKeySpec().hashCode())) * 31) + (getKeySpec() == null ? 0 : getKeySpec().hashCode())) * 31) + (getKeyUsage() == null ? 0 : getKeyUsage().hashCode())) * 31) + (getEncryptionAlgorithms() == null ? 0 : getEncryptionAlgorithms().hashCode())) * 31) + (getSigningAlgorithms() == null ? 0 : getSigningAlgorithms().hashCode())) * 31;
        if (getKeyAgreementAlgorithms() != null) {
            i11 = getKeyAgreementAlgorithms().hashCode();
        }
        return hashCode + i11;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setEncryptionAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.encryptionAlgorithms = null;
        } else {
            this.encryptionAlgorithms = new ArrayList(collection);
        }
    }

    public void setKeyAgreementAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.keyAgreementAlgorithms = null;
        } else {
            this.keyAgreementAlgorithms = new ArrayList(collection);
        }
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public void setSigningAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.signingAlgorithms = null;
        } else {
            this.signingAlgorithms = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPublicKey() != null) {
            sb2.append("PublicKey: " + getPublicKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomerMasterKeySpec() != null) {
            sb2.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeySpec() != null) {
            sb2.append("KeySpec: " + getKeySpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyUsage() != null) {
            sb2.append("KeyUsage: " + getKeyUsage() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionAlgorithms() != null) {
            sb2.append("EncryptionAlgorithms: " + getEncryptionAlgorithms() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSigningAlgorithms() != null) {
            sb2.append("SigningAlgorithms: " + getSigningAlgorithms() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyAgreementAlgorithms() != null) {
            sb2.append("KeyAgreementAlgorithms: " + getKeyAgreementAlgorithms());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetPublicKeyResult withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public GetPublicKeyResult withEncryptionAlgorithms(String... strArr) {
        if (getEncryptionAlgorithms() == null) {
            this.encryptionAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.encryptionAlgorithms.add(add);
        }
        return this;
    }

    public GetPublicKeyResult withKeyAgreementAlgorithms(String... strArr) {
        if (getKeyAgreementAlgorithms() == null) {
            this.keyAgreementAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.keyAgreementAlgorithms.add(add);
        }
        return this;
    }

    public GetPublicKeyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetPublicKeyResult withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public GetPublicKeyResult withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public GetPublicKeyResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public GetPublicKeyResult withSigningAlgorithms(String... strArr) {
        if (getSigningAlgorithms() == null) {
            this.signingAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.signingAlgorithms.add(add);
        }
        return this;
    }

    public void setCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec2) {
        this.customerMasterKeySpec = customerMasterKeySpec2.toString();
    }

    public void setKeySpec(KeySpec keySpec2) {
        this.keySpec = keySpec2.toString();
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public GetPublicKeyResult withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec2) {
        this.customerMasterKeySpec = customerMasterKeySpec2.toString();
        return this;
    }

    public GetPublicKeyResult withKeySpec(KeySpec keySpec2) {
        this.keySpec = keySpec2.toString();
        return this;
    }

    public GetPublicKeyResult withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public GetPublicKeyResult withEncryptionAlgorithms(Collection<String> collection) {
        setEncryptionAlgorithms(collection);
        return this;
    }

    public GetPublicKeyResult withKeyAgreementAlgorithms(Collection<String> collection) {
        setKeyAgreementAlgorithms(collection);
        return this;
    }

    public GetPublicKeyResult withSigningAlgorithms(Collection<String> collection) {
        setSigningAlgorithms(collection);
        return this;
    }
}
