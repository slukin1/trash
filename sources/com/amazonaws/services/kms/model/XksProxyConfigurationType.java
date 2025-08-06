package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class XksProxyConfigurationType implements Serializable {
    private String accessKeyId;
    private String connectivity;
    private String uriEndpoint;
    private String uriPath;
    private String vpcEndpointServiceName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof XksProxyConfigurationType)) {
            return false;
        }
        XksProxyConfigurationType xksProxyConfigurationType = (XksProxyConfigurationType) obj;
        if ((xksProxyConfigurationType.getConnectivity() == null) ^ (getConnectivity() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getConnectivity() != null && !xksProxyConfigurationType.getConnectivity().equals(getConnectivity())) {
            return false;
        }
        if ((xksProxyConfigurationType.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getAccessKeyId() != null && !xksProxyConfigurationType.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if ((xksProxyConfigurationType.getUriEndpoint() == null) ^ (getUriEndpoint() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getUriEndpoint() != null && !xksProxyConfigurationType.getUriEndpoint().equals(getUriEndpoint())) {
            return false;
        }
        if ((xksProxyConfigurationType.getUriPath() == null) ^ (getUriPath() == null)) {
            return false;
        }
        if (xksProxyConfigurationType.getUriPath() != null && !xksProxyConfigurationType.getUriPath().equals(getUriPath())) {
            return false;
        }
        if ((xksProxyConfigurationType.getVpcEndpointServiceName() == null) ^ (getVpcEndpointServiceName() == null)) {
            return false;
        }
        return xksProxyConfigurationType.getVpcEndpointServiceName() == null || xksProxyConfigurationType.getVpcEndpointServiceName().equals(getVpcEndpointServiceName());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getConnectivity() {
        return this.connectivity;
    }

    public String getUriEndpoint() {
        return this.uriEndpoint;
    }

    public String getUriPath() {
        return this.uriPath;
    }

    public String getVpcEndpointServiceName() {
        return this.vpcEndpointServiceName;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((getConnectivity() == null ? 0 : getConnectivity().hashCode()) + 31) * 31) + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode())) * 31) + (getUriEndpoint() == null ? 0 : getUriEndpoint().hashCode())) * 31) + (getUriPath() == null ? 0 : getUriPath().hashCode())) * 31;
        if (getVpcEndpointServiceName() != null) {
            i11 = getVpcEndpointServiceName().hashCode();
        }
        return hashCode + i11;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setConnectivity(String str) {
        this.connectivity = str;
    }

    public void setUriEndpoint(String str) {
        this.uriEndpoint = str;
    }

    public void setUriPath(String str) {
        this.uriPath = str;
    }

    public void setVpcEndpointServiceName(String str) {
        this.vpcEndpointServiceName = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getConnectivity() != null) {
            sb2.append("Connectivity: " + getConnectivity() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAccessKeyId() != null) {
            sb2.append("AccessKeyId: " + getAccessKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getUriEndpoint() != null) {
            sb2.append("UriEndpoint: " + getUriEndpoint() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getUriPath() != null) {
            sb2.append("UriPath: " + getUriPath() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getVpcEndpointServiceName() != null) {
            sb2.append("VpcEndpointServiceName: " + getVpcEndpointServiceName());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public XksProxyConfigurationType withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public XksProxyConfigurationType withConnectivity(String str) {
        this.connectivity = str;
        return this;
    }

    public XksProxyConfigurationType withUriEndpoint(String str) {
        this.uriEndpoint = str;
        return this;
    }

    public XksProxyConfigurationType withUriPath(String str) {
        this.uriPath = str;
        return this;
    }

    public XksProxyConfigurationType withVpcEndpointServiceName(String str) {
        this.vpcEndpointServiceName = str;
        return this;
    }

    public void setConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.connectivity = xksProxyConnectivityType.toString();
    }

    public XksProxyConfigurationType withConnectivity(XksProxyConnectivityType xksProxyConnectivityType) {
        this.connectivity = xksProxyConnectivityType.toString();
        return this;
    }
}
