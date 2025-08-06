package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class KeyMetadata implements Serializable {
    private String aWSAccountId;
    private String arn;
    private String cloudHsmClusterId;
    private Date creationDate;
    private String customKeyStoreId;
    private String customerMasterKeySpec;
    private Date deletionDate;
    private String description;
    private Boolean enabled;
    private List<String> encryptionAlgorithms = new ArrayList();
    private String expirationModel;
    private List<String> keyAgreementAlgorithms = new ArrayList();
    private String keyId;
    private String keyManager;
    private String keySpec;
    private String keyState;
    private String keyUsage;
    private List<String> macAlgorithms = new ArrayList();
    private Boolean multiRegion;
    private MultiRegionConfiguration multiRegionConfiguration;
    private String origin;
    private Integer pendingDeletionWindowInDays;
    private List<String> signingAlgorithms = new ArrayList();
    private Date validTo;
    private XksKeyConfigurationType xksKeyConfiguration;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof KeyMetadata)) {
            return false;
        }
        KeyMetadata keyMetadata = (KeyMetadata) obj;
        if ((keyMetadata.getAWSAccountId() == null) ^ (getAWSAccountId() == null)) {
            return false;
        }
        if (keyMetadata.getAWSAccountId() != null && !keyMetadata.getAWSAccountId().equals(getAWSAccountId())) {
            return false;
        }
        if ((keyMetadata.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (keyMetadata.getKeyId() != null && !keyMetadata.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((keyMetadata.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        if (keyMetadata.getArn() != null && !keyMetadata.getArn().equals(getArn())) {
            return false;
        }
        if ((keyMetadata.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (keyMetadata.getCreationDate() != null && !keyMetadata.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((keyMetadata.getEnabled() == null) ^ (getEnabled() == null)) {
            return false;
        }
        if (keyMetadata.getEnabled() != null && !keyMetadata.getEnabled().equals(getEnabled())) {
            return false;
        }
        if ((keyMetadata.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        if (keyMetadata.getDescription() != null && !keyMetadata.getDescription().equals(getDescription())) {
            return false;
        }
        if ((keyMetadata.getKeyUsage() == null) ^ (getKeyUsage() == null)) {
            return false;
        }
        if (keyMetadata.getKeyUsage() != null && !keyMetadata.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if ((keyMetadata.getKeyState() == null) ^ (getKeyState() == null)) {
            return false;
        }
        if (keyMetadata.getKeyState() != null && !keyMetadata.getKeyState().equals(getKeyState())) {
            return false;
        }
        if ((keyMetadata.getDeletionDate() == null) ^ (getDeletionDate() == null)) {
            return false;
        }
        if (keyMetadata.getDeletionDate() != null && !keyMetadata.getDeletionDate().equals(getDeletionDate())) {
            return false;
        }
        if ((keyMetadata.getValidTo() == null) ^ (getValidTo() == null)) {
            return false;
        }
        if (keyMetadata.getValidTo() != null && !keyMetadata.getValidTo().equals(getValidTo())) {
            return false;
        }
        if ((keyMetadata.getOrigin() == null) ^ (getOrigin() == null)) {
            return false;
        }
        if (keyMetadata.getOrigin() != null && !keyMetadata.getOrigin().equals(getOrigin())) {
            return false;
        }
        if ((keyMetadata.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (keyMetadata.getCustomKeyStoreId() != null && !keyMetadata.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((keyMetadata.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (keyMetadata.getCloudHsmClusterId() != null && !keyMetadata.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((keyMetadata.getExpirationModel() == null) ^ (getExpirationModel() == null)) {
            return false;
        }
        if (keyMetadata.getExpirationModel() != null && !keyMetadata.getExpirationModel().equals(getExpirationModel())) {
            return false;
        }
        if ((keyMetadata.getKeyManager() == null) ^ (getKeyManager() == null)) {
            return false;
        }
        if (keyMetadata.getKeyManager() != null && !keyMetadata.getKeyManager().equals(getKeyManager())) {
            return false;
        }
        if ((keyMetadata.getCustomerMasterKeySpec() == null) ^ (getCustomerMasterKeySpec() == null)) {
            return false;
        }
        if (keyMetadata.getCustomerMasterKeySpec() != null && !keyMetadata.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if ((keyMetadata.getKeySpec() == null) ^ (getKeySpec() == null)) {
            return false;
        }
        if (keyMetadata.getKeySpec() != null && !keyMetadata.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if ((keyMetadata.getEncryptionAlgorithms() == null) ^ (getEncryptionAlgorithms() == null)) {
            return false;
        }
        if (keyMetadata.getEncryptionAlgorithms() != null && !keyMetadata.getEncryptionAlgorithms().equals(getEncryptionAlgorithms())) {
            return false;
        }
        if ((keyMetadata.getSigningAlgorithms() == null) ^ (getSigningAlgorithms() == null)) {
            return false;
        }
        if (keyMetadata.getSigningAlgorithms() != null && !keyMetadata.getSigningAlgorithms().equals(getSigningAlgorithms())) {
            return false;
        }
        if ((keyMetadata.getKeyAgreementAlgorithms() == null) ^ (getKeyAgreementAlgorithms() == null)) {
            return false;
        }
        if (keyMetadata.getKeyAgreementAlgorithms() != null && !keyMetadata.getKeyAgreementAlgorithms().equals(getKeyAgreementAlgorithms())) {
            return false;
        }
        if ((keyMetadata.getMultiRegion() == null) ^ (getMultiRegion() == null)) {
            return false;
        }
        if (keyMetadata.getMultiRegion() != null && !keyMetadata.getMultiRegion().equals(getMultiRegion())) {
            return false;
        }
        if ((keyMetadata.getMultiRegionConfiguration() == null) ^ (getMultiRegionConfiguration() == null)) {
            return false;
        }
        if (keyMetadata.getMultiRegionConfiguration() != null && !keyMetadata.getMultiRegionConfiguration().equals(getMultiRegionConfiguration())) {
            return false;
        }
        if ((keyMetadata.getPendingDeletionWindowInDays() == null) ^ (getPendingDeletionWindowInDays() == null)) {
            return false;
        }
        if (keyMetadata.getPendingDeletionWindowInDays() != null && !keyMetadata.getPendingDeletionWindowInDays().equals(getPendingDeletionWindowInDays())) {
            return false;
        }
        if ((keyMetadata.getMacAlgorithms() == null) ^ (getMacAlgorithms() == null)) {
            return false;
        }
        if (keyMetadata.getMacAlgorithms() != null && !keyMetadata.getMacAlgorithms().equals(getMacAlgorithms())) {
            return false;
        }
        if ((keyMetadata.getXksKeyConfiguration() == null) ^ (getXksKeyConfiguration() == null)) {
            return false;
        }
        return keyMetadata.getXksKeyConfiguration() == null || keyMetadata.getXksKeyConfiguration().equals(getXksKeyConfiguration());
    }

    public String getAWSAccountId() {
        return this.aWSAccountId;
    }

    public String getArn() {
        return this.arn;
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public Date getDeletionDate() {
        return this.deletionDate;
    }

    public String getDescription() {
        return this.description;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public List<String> getEncryptionAlgorithms() {
        return this.encryptionAlgorithms;
    }

    public String getExpirationModel() {
        return this.expirationModel;
    }

    public List<String> getKeyAgreementAlgorithms() {
        return this.keyAgreementAlgorithms;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyManager() {
        return this.keyManager;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public String getKeyState() {
        return this.keyState;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public List<String> getMacAlgorithms() {
        return this.macAlgorithms;
    }

    public Boolean getMultiRegion() {
        return this.multiRegion;
    }

    public MultiRegionConfiguration getMultiRegionConfiguration() {
        return this.multiRegionConfiguration;
    }

    public String getOrigin() {
        return this.origin;
    }

    public Integer getPendingDeletionWindowInDays() {
        return this.pendingDeletionWindowInDays;
    }

    public List<String> getSigningAlgorithms() {
        return this.signingAlgorithms;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public XksKeyConfigurationType getXksKeyConfiguration() {
        return this.xksKeyConfiguration;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        int hashCode = ((((((((((((((((((((((((((((((((((((((getAWSAccountId() == null ? 0 : getAWSAccountId().hashCode()) + 31) * 31) + (getKeyId() == null ? 0 : getKeyId().hashCode())) * 31) + (getArn() == null ? 0 : getArn().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getEnabled() == null ? 0 : getEnabled().hashCode())) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31) + (getKeyUsage() == null ? 0 : getKeyUsage().hashCode())) * 31) + (getKeyState() == null ? 0 : getKeyState().hashCode())) * 31) + (getDeletionDate() == null ? 0 : getDeletionDate().hashCode())) * 31) + (getValidTo() == null ? 0 : getValidTo().hashCode())) * 31) + (getOrigin() == null ? 0 : getOrigin().hashCode())) * 31) + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode())) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31) + (getExpirationModel() == null ? 0 : getExpirationModel().hashCode())) * 31) + (getKeyManager() == null ? 0 : getKeyManager().hashCode())) * 31) + (getCustomerMasterKeySpec() == null ? 0 : getCustomerMasterKeySpec().hashCode())) * 31) + (getKeySpec() == null ? 0 : getKeySpec().hashCode())) * 31) + (getEncryptionAlgorithms() == null ? 0 : getEncryptionAlgorithms().hashCode())) * 31) + (getSigningAlgorithms() == null ? 0 : getSigningAlgorithms().hashCode())) * 31;
        if (getKeyAgreementAlgorithms() == null) {
            i11 = 0;
        } else {
            i11 = getKeyAgreementAlgorithms().hashCode();
        }
        int hashCode2 = (((hashCode + i11) * 31) + (getMultiRegion() == null ? 0 : getMultiRegion().hashCode())) * 31;
        if (getMultiRegionConfiguration() == null) {
            i12 = 0;
        } else {
            i12 = getMultiRegionConfiguration().hashCode();
        }
        int i15 = (hashCode2 + i12) * 31;
        if (getPendingDeletionWindowInDays() == null) {
            i13 = 0;
        } else {
            i13 = getPendingDeletionWindowInDays().hashCode();
        }
        int hashCode3 = (((i15 + i13) * 31) + (getMacAlgorithms() == null ? 0 : getMacAlgorithms().hashCode())) * 31;
        if (getXksKeyConfiguration() != null) {
            i14 = getXksKeyConfiguration().hashCode();
        }
        return hashCode3 + i14;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean isMultiRegion() {
        return this.multiRegion;
    }

    public void setAWSAccountId(String str) {
        this.aWSAccountId = str;
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setDeletionDate(Date date) {
        this.deletionDate = date;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public void setEncryptionAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.encryptionAlgorithms = null;
        } else {
            this.encryptionAlgorithms = new ArrayList(collection);
        }
    }

    public void setExpirationModel(String str) {
        this.expirationModel = str;
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

    public void setKeyManager(String str) {
        this.keyManager = str;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setKeyState(String str) {
        this.keyState = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setMacAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.macAlgorithms = null;
        } else {
            this.macAlgorithms = new ArrayList(collection);
        }
    }

    public void setMultiRegion(Boolean bool) {
        this.multiRegion = bool;
    }

    public void setMultiRegionConfiguration(MultiRegionConfiguration multiRegionConfiguration2) {
        this.multiRegionConfiguration = multiRegionConfiguration2;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setPendingDeletionWindowInDays(Integer num) {
        this.pendingDeletionWindowInDays = num;
    }

    public void setSigningAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.signingAlgorithms = null;
        } else {
            this.signingAlgorithms = new ArrayList(collection);
        }
    }

    public void setValidTo(Date date) {
        this.validTo = date;
    }

    public void setXksKeyConfiguration(XksKeyConfigurationType xksKeyConfigurationType) {
        this.xksKeyConfiguration = xksKeyConfigurationType;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAWSAccountId() != null) {
            sb2.append("AWSAccountId: " + getAWSAccountId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getArn() != null) {
            sb2.append("Arn: " + getArn() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCreationDate() != null) {
            sb2.append("CreationDate: " + getCreationDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEnabled() != null) {
            sb2.append("Enabled: " + getEnabled() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDescription() != null) {
            sb2.append("Description: " + getDescription() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyUsage() != null) {
            sb2.append("KeyUsage: " + getKeyUsage() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyState() != null) {
            sb2.append("KeyState: " + getKeyState() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDeletionDate() != null) {
            sb2.append("DeletionDate: " + getDeletionDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getValidTo() != null) {
            sb2.append("ValidTo: " + getValidTo() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getOrigin() != null) {
            sb2.append("Origin: " + getOrigin() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCloudHsmClusterId() != null) {
            sb2.append("CloudHsmClusterId: " + getCloudHsmClusterId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getExpirationModel() != null) {
            sb2.append("ExpirationModel: " + getExpirationModel() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyManager() != null) {
            sb2.append("KeyManager: " + getKeyManager() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomerMasterKeySpec() != null) {
            sb2.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeySpec() != null) {
            sb2.append("KeySpec: " + getKeySpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getEncryptionAlgorithms() != null) {
            sb2.append("EncryptionAlgorithms: " + getEncryptionAlgorithms() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSigningAlgorithms() != null) {
            sb2.append("SigningAlgorithms: " + getSigningAlgorithms() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyAgreementAlgorithms() != null) {
            sb2.append("KeyAgreementAlgorithms: " + getKeyAgreementAlgorithms() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMultiRegion() != null) {
            sb2.append("MultiRegion: " + getMultiRegion() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMultiRegionConfiguration() != null) {
            sb2.append("MultiRegionConfiguration: " + getMultiRegionConfiguration() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPendingDeletionWindowInDays() != null) {
            sb2.append("PendingDeletionWindowInDays: " + getPendingDeletionWindowInDays() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMacAlgorithms() != null) {
            sb2.append("MacAlgorithms: " + getMacAlgorithms() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksKeyConfiguration() != null) {
            sb2.append("XksKeyConfiguration: " + getXksKeyConfiguration());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public KeyMetadata withAWSAccountId(String str) {
        this.aWSAccountId = str;
        return this;
    }

    public KeyMetadata withArn(String str) {
        this.arn = str;
        return this;
    }

    public KeyMetadata withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public KeyMetadata withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public KeyMetadata withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public KeyMetadata withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public KeyMetadata withDeletionDate(Date date) {
        this.deletionDate = date;
        return this;
    }

    public KeyMetadata withDescription(String str) {
        this.description = str;
        return this;
    }

    public KeyMetadata withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public KeyMetadata withEncryptionAlgorithms(String... strArr) {
        if (getEncryptionAlgorithms() == null) {
            this.encryptionAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.encryptionAlgorithms.add(add);
        }
        return this;
    }

    public KeyMetadata withExpirationModel(String str) {
        this.expirationModel = str;
        return this;
    }

    public KeyMetadata withKeyAgreementAlgorithms(String... strArr) {
        if (getKeyAgreementAlgorithms() == null) {
            this.keyAgreementAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.keyAgreementAlgorithms.add(add);
        }
        return this;
    }

    public KeyMetadata withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public KeyMetadata withKeyManager(String str) {
        this.keyManager = str;
        return this;
    }

    public KeyMetadata withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public KeyMetadata withKeyState(String str) {
        this.keyState = str;
        return this;
    }

    public KeyMetadata withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public KeyMetadata withMacAlgorithms(String... strArr) {
        if (getMacAlgorithms() == null) {
            this.macAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.macAlgorithms.add(add);
        }
        return this;
    }

    public KeyMetadata withMultiRegion(Boolean bool) {
        this.multiRegion = bool;
        return this;
    }

    public KeyMetadata withMultiRegionConfiguration(MultiRegionConfiguration multiRegionConfiguration2) {
        this.multiRegionConfiguration = multiRegionConfiguration2;
        return this;
    }

    public KeyMetadata withOrigin(String str) {
        this.origin = str;
        return this;
    }

    public KeyMetadata withPendingDeletionWindowInDays(Integer num) {
        this.pendingDeletionWindowInDays = num;
        return this;
    }

    public KeyMetadata withSigningAlgorithms(String... strArr) {
        if (getSigningAlgorithms() == null) {
            this.signingAlgorithms = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.signingAlgorithms.add(add);
        }
        return this;
    }

    public KeyMetadata withValidTo(Date date) {
        this.validTo = date;
        return this;
    }

    public KeyMetadata withXksKeyConfiguration(XksKeyConfigurationType xksKeyConfigurationType) {
        this.xksKeyConfiguration = xksKeyConfigurationType;
        return this;
    }

    public void setCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec2) {
        this.customerMasterKeySpec = customerMasterKeySpec2.toString();
    }

    public void setExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
    }

    public void setKeyManager(KeyManagerType keyManagerType) {
        this.keyManager = keyManagerType.toString();
    }

    public void setKeySpec(KeySpec keySpec2) {
        this.keySpec = keySpec2.toString();
    }

    public void setKeyState(KeyState keyState2) {
        this.keyState = keyState2.toString();
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public void setOrigin(OriginType originType) {
        this.origin = originType.toString();
    }

    public KeyMetadata withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec2) {
        this.customerMasterKeySpec = customerMasterKeySpec2.toString();
        return this;
    }

    public KeyMetadata withExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
        return this;
    }

    public KeyMetadata withKeyManager(KeyManagerType keyManagerType) {
        this.keyManager = keyManagerType.toString();
        return this;
    }

    public KeyMetadata withKeySpec(KeySpec keySpec2) {
        this.keySpec = keySpec2.toString();
        return this;
    }

    public KeyMetadata withKeyState(KeyState keyState2) {
        this.keyState = keyState2.toString();
        return this;
    }

    public KeyMetadata withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public KeyMetadata withOrigin(OriginType originType) {
        this.origin = originType.toString();
        return this;
    }

    public KeyMetadata withEncryptionAlgorithms(Collection<String> collection) {
        setEncryptionAlgorithms(collection);
        return this;
    }

    public KeyMetadata withKeyAgreementAlgorithms(Collection<String> collection) {
        setKeyAgreementAlgorithms(collection);
        return this;
    }

    public KeyMetadata withMacAlgorithms(Collection<String> collection) {
        setMacAlgorithms(collection);
        return this;
    }

    public KeyMetadata withSigningAlgorithms(Collection<String> collection) {
        setSigningAlgorithms(collection);
        return this;
    }
}
