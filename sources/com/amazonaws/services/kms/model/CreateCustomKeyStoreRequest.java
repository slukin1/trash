package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class CreateCustomKeyStoreRequest extends AmazonWebServiceRequest implements Serializable {
    private String cloudHsmClusterId;
    private String customKeyStoreName;
    private String customKeyStoreType;
    private String keyStorePassword;
    private String trustAnchorCertificate;
    private XksProxyAuthenticationCredentialType xksProxyAuthenticationCredential;
    private String xksProxyConnectivity;
    private String xksProxyUriEndpoint;
    private String xksProxyUriPath;
    private String xksProxyVpcEndpointServiceName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateCustomKeyStoreRequest)) {
            return false;
        }
        CreateCustomKeyStoreRequest createCustomKeyStoreRequest = (CreateCustomKeyStoreRequest) obj;
        if ((createCustomKeyStoreRequest.getCustomKeyStoreName() == null) ^ (getCustomKeyStoreName() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreName() != null && !createCustomKeyStoreRequest.getCustomKeyStoreName().equals(getCustomKeyStoreName())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getCloudHsmClusterId() == null) ^ (getCloudHsmClusterId() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCloudHsmClusterId() != null && !createCustomKeyStoreRequest.getCloudHsmClusterId().equals(getCloudHsmClusterId())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getTrustAnchorCertificate() == null) ^ (getTrustAnchorCertificate() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getTrustAnchorCertificate() != null && !createCustomKeyStoreRequest.getTrustAnchorCertificate().equals(getTrustAnchorCertificate())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getKeyStorePassword() == null) ^ (getKeyStorePassword() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getKeyStorePassword() != null && !createCustomKeyStoreRequest.getKeyStorePassword().equals(getKeyStorePassword())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getCustomKeyStoreType() == null) ^ (getCustomKeyStoreType() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getCustomKeyStoreType() != null && !createCustomKeyStoreRequest.getCustomKeyStoreType().equals(getCustomKeyStoreType())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyUriEndpoint() == null) ^ (getXksProxyUriEndpoint() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriEndpoint() != null && !createCustomKeyStoreRequest.getXksProxyUriEndpoint().equals(getXksProxyUriEndpoint())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyUriPath() == null) ^ (getXksProxyUriPath() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyUriPath() != null && !createCustomKeyStoreRequest.getXksProxyUriPath().equals(getXksProxyUriPath())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() == null) ^ (getXksProxyVpcEndpointServiceName() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName() != null && !createCustomKeyStoreRequest.getXksProxyVpcEndpointServiceName().equals(getXksProxyVpcEndpointServiceName())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() == null) ^ (getXksProxyAuthenticationCredential() == null)) {
            return false;
        }
        if (createCustomKeyStoreRequest.getXksProxyAuthenticationCredential() != null && !createCustomKeyStoreRequest.getXksProxyAuthenticationCredential().equals(getXksProxyAuthenticationCredential())) {
            return false;
        }
        if ((createCustomKeyStoreRequest.getXksProxyConnectivity() == null) ^ (getXksProxyConnectivity() == null)) {
            return false;
        }
        return createCustomKeyStoreRequest.getXksProxyConnectivity() == null || createCustomKeyStoreRequest.getXksProxyConnectivity().equals(getXksProxyConnectivity());
    }

    public String getCloudHsmClusterId() {
        return this.cloudHsmClusterId;
    }

    public String getCustomKeyStoreName() {
        return this.customKeyStoreName;
    }

    public String getCustomKeyStoreType() {
        return this.customKeyStoreType;
    }

    public String getKeyStorePassword() {
        return this.keyStorePassword;
    }

    public String getTrustAnchorCertificate() {
        return this.trustAnchorCertificate;
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
        int i13;
        int i14 = 0;
        int hashCode = ((((getCustomKeyStoreName() == null ? 0 : getCustomKeyStoreName().hashCode()) + 31) * 31) + (getCloudHsmClusterId() == null ? 0 : getCloudHsmClusterId().hashCode())) * 31;
        if (getTrustAnchorCertificate() == null) {
            i11 = 0;
        } else {
            i11 = getTrustAnchorCertificate().hashCode();
        }
        int hashCode2 = (((((((((hashCode + i11) * 31) + (getKeyStorePassword() == null ? 0 : getKeyStorePassword().hashCode())) * 31) + (getCustomKeyStoreType() == null ? 0 : getCustomKeyStoreType().hashCode())) * 31) + (getXksProxyUriEndpoint() == null ? 0 : getXksProxyUriEndpoint().hashCode())) * 31) + (getXksProxyUriPath() == null ? 0 : getXksProxyUriPath().hashCode())) * 31;
        if (getXksProxyVpcEndpointServiceName() == null) {
            i12 = 0;
        } else {
            i12 = getXksProxyVpcEndpointServiceName().hashCode();
        }
        int i15 = (hashCode2 + i12) * 31;
        if (getXksProxyAuthenticationCredential() == null) {
            i13 = 0;
        } else {
            i13 = getXksProxyAuthenticationCredential().hashCode();
        }
        int i16 = (i15 + i13) * 31;
        if (getXksProxyConnectivity() != null) {
            i14 = getXksProxyConnectivity().hashCode();
        }
        return i16 + i14;
    }

    public void setCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
    }

    public void setCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
    }

    public void setCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
    }

    public void setKeyStorePassword(String str) {
        this.keyStorePassword = str;
    }

    public void setTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
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
        if (getCustomKeyStoreName() != null) {
            sb2.append("CustomKeyStoreName: " + getCustomKeyStoreName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCloudHsmClusterId() != null) {
            sb2.append("CloudHsmClusterId: " + getCloudHsmClusterId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTrustAnchorCertificate() != null) {
            sb2.append("TrustAnchorCertificate: " + getTrustAnchorCertificate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyStorePassword() != null) {
            sb2.append("KeyStorePassword: " + getKeyStorePassword() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreType() != null) {
            sb2.append("CustomKeyStoreType: " + getCustomKeyStoreType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
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

    public CreateCustomKeyStoreRequest withCloudHsmClusterId(String str) {
        this.cloudHsmClusterId = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreName(String str) {
        this.customKeyStoreName = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreType(String str) {
        this.customKeyStoreType = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withKeyStorePassword(String str) {
        this.keyStorePassword = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withTrustAnchorCertificate(String str) {
        this.trustAnchorCertificate = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyAuthenticationCredential(XksProxyAuthenticationCredentialType xksProxyAuthenticationCredentialType) {
        this.xksProxyAuthenticationCredential = xksProxyAuthenticationCredentialType;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyConnectivity(String str) {
        this.xksProxyConnectivity = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyUriEndpoint(String str) {
        this.xksProxyUriEndpoint = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyUriPath(String str) {
        this.xksProxyUriPath = str;
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyVpcEndpointServiceName(String str) {
        this.xksProxyVpcEndpointServiceName = str;
        return this;
    }

    public void setCustomKeyStoreType(CustomKeyStoreType customKeyStoreType2) {
        this.customKeyStoreType = customKeyStoreType2.toString();
    }

    public void setXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
    }

    public CreateCustomKeyStoreRequest withCustomKeyStoreType(CustomKeyStoreType customKeyStoreType2) {
        this.customKeyStoreType = customKeyStoreType2.toString();
        return this;
    }

    public CreateCustomKeyStoreRequest withXksProxyConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.xksProxyConnectivity = xksProxyConnectivityType.toString();
        return this;
    }
}
