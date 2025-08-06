package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateKeyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean bypassPolicyLockoutSafetyCheck;
    private String customKeyStoreId;
    private String customerMasterKeySpec;
    private String description;
    private String keySpec;
    private String keyUsage;
    private Boolean multiRegion;
    private String origin;
    private String policy;
    private List<Tag> tags = new ArrayList();
    private String xksKeyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateKeyRequest)) {
            return false;
        }
        CreateKeyRequest createKeyRequest = (CreateKeyRequest) obj;
        if ((createKeyRequest.getPolicy() == null) ^ (getPolicy() == null)) {
            return false;
        }
        if (createKeyRequest.getPolicy() != null && !createKeyRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if ((createKeyRequest.getDescription() == null) ^ (getDescription() == null)) {
            return false;
        }
        if (createKeyRequest.getDescription() != null && !createKeyRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if ((createKeyRequest.getKeyUsage() == null) ^ (getKeyUsage() == null)) {
            return false;
        }
        if (createKeyRequest.getKeyUsage() != null && !createKeyRequest.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if ((createKeyRequest.getCustomerMasterKeySpec() == null) ^ (getCustomerMasterKeySpec() == null)) {
            return false;
        }
        if (createKeyRequest.getCustomerMasterKeySpec() != null && !createKeyRequest.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if ((createKeyRequest.getKeySpec() == null) ^ (getKeySpec() == null)) {
            return false;
        }
        if (createKeyRequest.getKeySpec() != null && !createKeyRequest.getKeySpec().equals(getKeySpec())) {
            return false;
        }
        if ((createKeyRequest.getOrigin() == null) ^ (getOrigin() == null)) {
            return false;
        }
        if (createKeyRequest.getOrigin() != null && !createKeyRequest.getOrigin().equals(getOrigin())) {
            return false;
        }
        if ((createKeyRequest.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (createKeyRequest.getCustomKeyStoreId() != null && !createKeyRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((createKeyRequest.getBypassPolicyLockoutSafetyCheck() == null) ^ (getBypassPolicyLockoutSafetyCheck() == null)) {
            return false;
        }
        if (createKeyRequest.getBypassPolicyLockoutSafetyCheck() != null && !createKeyRequest.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck())) {
            return false;
        }
        if ((createKeyRequest.getTags() == null) ^ (getTags() == null)) {
            return false;
        }
        if (createKeyRequest.getTags() != null && !createKeyRequest.getTags().equals(getTags())) {
            return false;
        }
        if ((createKeyRequest.getMultiRegion() == null) ^ (getMultiRegion() == null)) {
            return false;
        }
        if (createKeyRequest.getMultiRegion() != null && !createKeyRequest.getMultiRegion().equals(getMultiRegion())) {
            return false;
        }
        if ((createKeyRequest.getXksKeyId() == null) ^ (getXksKeyId() == null)) {
            return false;
        }
        return createKeyRequest.getXksKeyId() == null || createKeyRequest.getXksKeyId().equals(getXksKeyId());
    }

    public Boolean getBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKeySpec() {
        return this.keySpec;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public Boolean getMultiRegion() {
        return this.multiRegion;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public String getXksKeyId() {
        return this.xksKeyId;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((((((((((((((getPolicy() == null ? 0 : getPolicy().hashCode()) + 31) * 31) + (getDescription() == null ? 0 : getDescription().hashCode())) * 31) + (getKeyUsage() == null ? 0 : getKeyUsage().hashCode())) * 31) + (getCustomerMasterKeySpec() == null ? 0 : getCustomerMasterKeySpec().hashCode())) * 31) + (getKeySpec() == null ? 0 : getKeySpec().hashCode())) * 31) + (getOrigin() == null ? 0 : getOrigin().hashCode())) * 31) + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode())) * 31;
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            i11 = 0;
        } else {
            i11 = getBypassPolicyLockoutSafetyCheck().hashCode();
        }
        int hashCode2 = (((((hashCode + i11) * 31) + (getTags() == null ? 0 : getTags().hashCode())) * 31) + (getMultiRegion() == null ? 0 : getMultiRegion().hashCode())) * 31;
        if (getXksKeyId() != null) {
            i12 = getXksKeyId().hashCode();
        }
        return hashCode2 + i12;
    }

    public Boolean isBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public Boolean isMultiRegion() {
        return this.multiRegion;
    }

    public void setBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setKeySpec(String str) {
        this.keySpec = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setMultiRegion(Boolean bool) {
        this.multiRegion = bool;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setXksKeyId(String str) {
        this.xksKeyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getPolicy() != null) {
            sb2.append("Policy: " + getPolicy() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDescription() != null) {
            sb2.append("Description: " + getDescription() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyUsage() != null) {
            sb2.append("KeyUsage: " + getKeyUsage() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomerMasterKeySpec() != null) {
            sb2.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeySpec() != null) {
            sb2.append("KeySpec: " + getKeySpec() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getOrigin() != null) {
            sb2.append("Origin: " + getOrigin() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            sb2.append("BypassPolicyLockoutSafetyCheck: " + getBypassPolicyLockoutSafetyCheck() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTags() != null) {
            sb2.append("Tags: " + getTags() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMultiRegion() != null) {
            sb2.append("MultiRegion: " + getMultiRegion() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksKeyId() != null) {
            sb2.append("XksKeyId: " + getXksKeyId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public CreateKeyRequest withBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
        return this;
    }

    public CreateKeyRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public CreateKeyRequest withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public CreateKeyRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public CreateKeyRequest withKeySpec(String str) {
        this.keySpec = str;
        return this;
    }

    public CreateKeyRequest withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public CreateKeyRequest withMultiRegion(Boolean bool) {
        this.multiRegion = bool;
        return this;
    }

    public CreateKeyRequest withOrigin(String str) {
        this.origin = str;
        return this;
    }

    public CreateKeyRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public CreateKeyRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag add : tagArr) {
            this.tags.add(add);
        }
        return this;
    }

    public CreateKeyRequest withXksKeyId(String str) {
        this.xksKeyId = str;
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

    public void setOrigin(OriginType originType) {
        this.origin = originType.toString();
    }

    public CreateKeyRequest withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec2) {
        this.customerMasterKeySpec = customerMasterKeySpec2.toString();
        return this;
    }

    public CreateKeyRequest withKeySpec(KeySpec keySpec2) {
        this.keySpec = keySpec2.toString();
        return this;
    }

    public CreateKeyRequest withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public CreateKeyRequest withOrigin(OriginType originType) {
        this.origin = originType.toString();
        return this;
    }

    public CreateKeyRequest withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
