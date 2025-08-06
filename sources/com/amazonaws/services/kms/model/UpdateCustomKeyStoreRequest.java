package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class UpdateCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudHsmClusterId;
    private String customKeyStoreId;
    private String keyStorePassword;
    private String newCustomKeyStoreName;
    private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;
    private String xksProxyConnectivity;
    private String xksProxyUriEndpoint;
    private String xksProxyUriPath;
    private String xksProxyVpcEndpointServiceName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateCustomKeyStoreRequest)) {
            return false;
        }
        UpdateCustomKeyStoreRequest updateCustomKeyStoreRequest = (UpdateCustomKeyStoreRequest) obj;
        if ((updateCustomKeyStoreRequest.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getCustomKeyStoreId() != null && !updateCustomKeyStoreRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getNewCustomKeyStoreName() == null) ^ (getNewCustomKeyStoreName() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getNewCustomKeyStoreName() != null && !updateCustomKeyStoreRequest.getNewCustomKeyStoreName().equals(getNewCustomKeyStoreName())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getKeyStorePassword() == null) ^ (getKeyStorePassword() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getKeyStorePassword() != null && !updateCustomKeyStoreRequest.getKeyStorePassword().equals(getKeyStorePassword())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getCloudHsmClusterId() != null && !updateCustomKeyStoreRequest.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyUriEndpoint() == null) ^ (getXksProxyUriEndpoint() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriEndpoint() != null && !updateCustomKeyStoreRequest.getXksProxyUriEndpoint().equals(getXksProxyUriEndpoint())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyUriPath() == null) ^ (getXksProxyUriPath() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyUriPath() != null && !updateCustomKeyStoreRequest.getXksProxyUriPath().equals(getXksProxyUriPath())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() == null) ^ (getXksProxyVpcEndpointServiceName() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null && !updateCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName().equals(getXksProxyVpcEndpointServiceName())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() == null) ^ (getXksProxyAuthenticationCredential() == null)) {
            return false;
        }
        if (updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null && !updateCustomKeyStoreRequest.getXksProxyAuthenticationCredential().equals(getXksProxyAuthenticationCredential())) {
            return false;
        }
        if ((updateCustomKeyStoreRequest.getXksProxyConnectivity() == null) ^ (getXksProxyConnectivity() == null)) {
            return false;
        }
        return updateCustomKeyStoreRequest.getXksProxyConnectivity() == null || updateCustomKeyStoreRequest.getXksProxyConnectivity().equals(getXksProxyConnectivity());
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public String getKeyStorePassword() {
        return this.keyStorePassword;
    }

    public String getNewCustomKeyStoreName() {
        return this.newCustomKeyStoreName;
    }

    public XksProxyAuthenticationCredentialType getXksProxyAuthenticationCredential() {
        return this.xksProxyAuthenticationCredential;
    }

    public String getXksProxyConnectivity() {
        return this.xksProxyConnectivity;
    }

    public String getXksProxyUriEndpoint() {
        return this.xksProxyUriEndpoint;
    }

    public String getXksProxyUriPath() {
        return this.xksProxyUriPath;
    }

    public String getXksProxyVpcEndpointServiceName() {
        return this.xksProxyVpcEndpointServiceName;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13 = 0;
        int hashCode = ((((((((((((getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode()) + 31) * 31) + (getNewCustomKeyStoreName() == null ? 0 : getNewCustomKeyStoreName().hashCode())) * 31) + (getKeyStorePassword() == null ? 0 : getKeyStorePassword().hashCode())) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31) + (getXksProxyUriEndpoint() == null ? 0 : getXksProxyUriEndpoint().hashCode())) * 31) + (getXksProxyUriPath() == null ? 0 : getXksProxyUriPath().hashCode())) * 31;
        if (getXksProxyVpcEndpointServiceName() == null) {
            i11 = 0;
        } else {
            i11 = getXksProxyVpcEndpointServiceName().hashCode();
        }
        int i14 = (hashCode + i11) * 31;
        if (getXksProxyAuthenticationCredential() == null) {
            i12 = 0;
        } else {
            i12 = getXksProxyAuthenticationCredential().hashCode();
        }
        int i15 = (i14 + i12) * 31;
        if (getXksProxyConnectivity() != null) {
            i13 = getXksProxyConnectivity().hashCode();
        }
        return i15 + i13;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setKeyStorePassword(String str) {
        this.keyStorePassword = str;
    }

    public void setNewCustomKeyStoreName(String str) {
        this.newCustomKeyStoreName = str;
    }

    public void setXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
    }

    public void setXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
    }

    public void setXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
    }

    public void setXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
    }

    public void setXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNewCustomKeyStoreName() != null) {
            sb2.append("NewCustomKeyStoreName: " + getNewCustomKeyStoreName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyStorePassword() != null) {
            sb2.append("KeyStorePassword: " + getKeyStorePassword() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCloudHsmClusterId() != null) {
            sb2.append("CloudHsmClusterId: " + getCloudHsmClusterId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksProxyUriEndpoint() != null) {
            sb2.append("XksProxyUriEndpoint: " + getXksProxyUriEndpoint() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksProxyUriPath() != null) {
            sb2.append("XksProxyUriPath: " + getXksProxyUriPath() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksProxyVpcEndpointServiceName() != null) {
            sb2.append("XksProxyVpcEndpointServiceName: " + getXksProxyVpcEndpointServiceName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksProxyAuthenticationCredential() != null) {
            sb2.append("XksProxyAuthenticationCredential: " + getXksProxyAuthenticationCredential() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getXksProxyConnectivity() != null) {
            sb2.append("XksProxyConnectivity: " + getXksProxyConnectivity());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public UpdateCustomKeyStoreRequest withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withKeyStorePassword(String str) {
        this.keyStorePassword = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withNewCustomKeyStoreName(String str) {
        this.newCustomKeyStoreName = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
        return this;
    }

    public UpdateCustomKeyStoreRequest withXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
        return this;
    }

    public void setXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
    }

    public UpdateCustomKeyStoreRequest withXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
        return this;
    }
}
