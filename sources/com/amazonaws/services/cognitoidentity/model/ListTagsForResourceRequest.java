package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListTagsForResourceRequest extends AmazonWebServiceRequest implements Serializable {
    private String resourceArn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListTagsForResourceRequest)) {
            return false;
        }
        ListTagsForResourceRequest listTagsForResourceRequest = (ListTagsForResourceRequest) obj;
        if ((listTagsForResourceRequest.getResourceArn() == null) ^ (getResourceArn() == null)) {
            return false;
        }
        return listTagsForResourceRequest.getResourceArn() == null || listTagsForResourceRequest.getResourceArn().equals(getResourceArn());
    }

    public String getResourceArn() {
        return this.resourceArn;
    }

    public int hashCode() {
        return 31 + (getResourceArn() == null ? 0 : getResourceArn().hashCode());
    }

    public void setResourceArn(String str) {
        this.resourceArn = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getResourceArn() != null) {
            sb2.append("ResourceArn: " + getResourceArn());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListTagsForResourceRequest withResourceArn(String str) {
        this.resourceArn = str;
        return this;
    }
}
