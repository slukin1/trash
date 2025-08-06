package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetAccessKeyInfoRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessKeyId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetAccessKeyInfoRequest)) {
            return false;
        }
        GetAccessKeyInfoRequest getAccessKeyInfoRequest = (GetAccessKeyInfoRequest) obj;
        if ((getAccessKeyInfoRequest.getAccessKeyId() == null) ^ (getAccessKeyId() == null)) {
            return false;
        }
        return getAccessKeyInfoRequest.getAccessKeyId() == null || getAccessKeyInfoRequest.getAccessKeyId().equals(getAccessKeyId());
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public int hashCode() {
        return 31 + (getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode());
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAccessKeyId() != null) {
            sb2.append("AccessKeyId: " + getAccessKeyId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetAccessKeyInfoRequest withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }
}
