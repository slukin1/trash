package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UntagResourceRequest extends AmazonWebServiceRequest implements Serializable {
    private String resourceArn;
    private List<String> tagKeys;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UntagResourceRequest)) {
            return false;
        }
        UntagResourceRequest untagResourceRequest = (UntagResourceRequest) obj;
        if ((untagResourceRequest.getResourceArn() == null) ^ (getResourceArn() == null)) {
            return false;
        }
        if (untagResourceRequest.getResourceArn() != null && !untagResourceRequest.getResourceArn().equals(getResourceArn())) {
            return false;
        }
        if ((untagResourceRequest.getTagKeys() == null) ^ (getTagKeys() == null)) {
            return false;
        }
        return untagResourceRequest.getTagKeys() == null || untagResourceRequest.getTagKeys().equals(getTagKeys());
    }

    public String getResourceArn() {
        return this.resourceArn;
    }

    public List<String> getTagKeys() {
        return this.tagKeys;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getResourceArn() == null ? 0 : getResourceArn().hashCode()) + 31) * 31;
        if (getTagKeys() != null) {
            i11 = getTagKeys().hashCode();
        }
        return hashCode + i11;
    }

    public void setResourceArn(String str) {
        this.resourceArn = str;
    }

    public void setTagKeys(Collection<String> collection) {
        if (collection == null) {
            this.tagKeys = null;
        } else {
            this.tagKeys = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getResourceArn() != null) {
            sb2.append("ResourceArn: " + getResourceArn() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTagKeys() != null) {
            sb2.append("TagKeys: " + getTagKeys());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public UntagResourceRequest withResourceArn(String str) {
        this.resourceArn = str;
        return this;
    }

    public UntagResourceRequest withTagKeys(String... strArr) {
        if (getTagKeys() == null) {
            this.tagKeys = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.tagKeys.add(add);
        }
        return this;
    }

    public UntagResourceRequest withTagKeys(Collection<String> collection) {
        setTagKeys(collection);
        return this;
    }
}
