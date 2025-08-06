package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

public class CustomKeyStoresListEntry implements Serializable {
    private String cloudHsmClusterId;
    private String connectionErrorCode;
    private String connectionState;
    private Date creationDate;
    private String customKeyStoreId;
    private String customKeyStoreName;
    private String customKeyStoreType;
    private String trustAnchorCertificate;
    private XksProxyConfigurationType xksProxyConfiguration;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CustomKeyStoresListEntry)) {
            return false;
        }
        CustomKeyStoresListEntry customKeyStoresListEntry = (CustomKeyStoresListEntry) obj;
        if ((customKeyStoresListEntry.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreId() != null && !customKeyStoresListEntry.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((customKeyStoresListEntry.getCustomKeyStoreName() == null) ^ (getCustomKeyStoreName() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreName() != null && !customKeyStoresListEntry.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if ((customKeyStoresListEntry.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getCloudHsmClusterId() != null && !customKeyStoresListEntry.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((customKeyStoresListEntry.getTrustAnchorCertificate() == null) ^ (getTrustAnchorCertificate() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getTrustAnchorCertificate() != null && !customKeyStoresListEntry.getTrustAnchorCertificate().equals(getTrustAnchorCertificate())) {
            return false;
        }
        if ((customKeyStoresListEntry.getConnectionState() == null) ^ (getConnectionState() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getConnectionState() != null && !customKeyStoresListEntry.getConnectionState().equals(getConnectionState())) {
            return false;
        }
        if ((customKeyStoresListEntry.getConnectionErrorCode() == null) ^ (getConnectionErrorCode() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getConnectionErrorCode() != null && !customKeyStoresListEntry.getConnectionErrorCode().equals(getConnectionErrorCode())) {
            return false;
        }
        if ((customKeyStoresListEntry.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getCreationDate() != null && !customKeyStoresListEntry.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((customKeyStoresListEntry.getCustomKeyStoreType() == null) ^ (getCustomKeyStoreType() == null)) {
            return false;
        }
        if (customKeyStoresListEntry.getCustomKeyStoreType() != null && !customKeyStoresListEntry.getCustomKeyStoreType().equals(getCustomKeyStoreType())) {
            return false;
        }
        if ((customKeyStoresListEntry.getXksProxyConfiguration() == null) ^ (getXksProxyConfiguration() == null)) {
            return false;
        }
        return customKeyStoresListEntry.getXksProxyConfiguration() == null || customKeyStoresListEntry.getXksProxyConfiguration().equals(getXksProxyConfiguration());
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public String getConnectionErrorCode() {
        return this.connectionErrorCode;
    }

    public String getConnectionState() {
        return this.connectionState;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
    }

    public String getCustomKeyStoreType() {
        return this.customKeyStoreType;
    }

    public String getTrustAnchorCertificate() {
        return this.trustAnchorCertificate;
    }

    public XksProxyConfigurationType getXksProxyConfiguration() {
        return this.xksProxyConfiguration;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((((((getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode()) + 31) * 31) + (getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode())) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31;
        if (getTrustAnchorCertificate() == null) {
            i11 = 0;
        } else {
            i11 = getTrustAnchorCertificate().hashCode();
        }
        int hashCode2 = (((((((((hashCode + i11) * 31) + (getConnectionState() == null ? 0 : getConnectionState().hashCode())) * 31) + (getConnectionErrorCode() == null ? 0 : getConnectionErrorCode().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getCustomKeyStoreType() == null ? 0 : getCustomKeyStoreType().hashCode())) * 31;
        if (getXksProxyConfiguration() != null) {
            i12 = getXksProxyConfiguration().hashCode();
        }
        return hashCode2 + i12;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setConnectionErrorCode(String str) {
        this.connectionErrorCode = str;
    }

    public void setConnectionState(String str) {
        this.connectionState = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
    }

    public void setCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
    }

    public void setTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
    }

    public void setXksProxyConfiguration(XksProxyConfigurationType xksProxyConfigurationType) {
        this.xksProxyConfiguration = xksProxyConfigurationType;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreName() != null) {
            sb2.append("CustomKeyStoreName: " + getCustomKeyStoreName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCloudHsmClusterId() != null) {
            sb2.append("CloudHsmClusterId: " + getCloudHsmClusterId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTrustAnchorCertificate() != null) {
            sb2.append("TrustAnchorCertificate: " + getTrustAnchorCertificate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getConnectionState() != null) {
            sb2.append("ConnectionState: " + getConnectionState() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getConnectionErrorCode() != null) {
            sb2.append("ConnectionErrorCode: " + getConnectionErrorCode() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCreationDate() != null) {
            sb2.append("CreationDate: " + getCreationDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreType() != null) {
            sb2.append("CustomKeyStoreType: " + getCustomKeyStoreType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksProxyConfiguration() != null) {
            sb2.append("XksProxyConfiguration: " + getXksProxyConfiguration());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public CustomKeyStoresListEntry withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public CustomKeyStoresListEntry withConnectionErrorCode(String str) {
        this.connectionErrorCode = str;
        return this;
    }

    public CustomKeyStoresListEntry withConnectionState(String str) {
        this.connectionState = str;
        return this;
    }

    public CustomKeyStoresListEntry withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
        return this;
    }

    public CustomKeyStoresListEntry withTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
        return this;
    }

    public CustomKeyStoresListEntry withXksProxyConfiguration(XksProxyConfigurationType xksProxyConfigurationType) {
        this.xksProxyConfiguration = xksProxyConfigurationType;
        return this;
    }

    public void setConnectionErrorCode(ConnectionErrorCodeType connectionErrorCodeType) {
        this.connectionErrorCode = connectionErrorCodeType.toString();
    }

    public void setConnectionState(ConnectionStateType connectionStateType) {
        this.connectionState = connectionStateType.toString();
    }

    public void setCustomKeyStoreType(CustomKeyStoreType customKeyStoreType2) {
        this.customKeyStoreType = customKeyStoreType2.toString();
    }

    public CustomKeyStoresListEntry withConnectionErrorCode(ConnectionErrorCodeType connectionErrorCodeType) {
        this.connectionErrorCode = connectionErrorCodeType.toString();
        return this;
    }

    public CustomKeyStoresListEntry withConnectionState(ConnectionStateType connectionStateType) {
        this.connectionState = connectionStateType.toString();
        return this;
    }

    public CustomKeyStoresListEntry withCustomKeyStoreType(CustomKeyStoreType customKeyStoreType2) {
        this.customKeyStoreType = customKeyStoreType2.toString();
        return this;
    }
}
