package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DecodeAuthorizationMessageRequest extends AmazonWebServiceRequest implements Serializable {
    private String encodedMessage;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecodeAuthorizationMessageRequest)) {
            return false;
        }
        DecodeAuthorizationMessageRequest decodeAuthorizationMessageRequest = (DecodeAuthorizationMessageRequest) obj;
        if ((decodeAuthorizationMessageRequest.getEncodedMessage() == null) ^ (getEncodedMessage() == null)) {
            return false;
        }
        return decodeAuthorizationMessageRequest.getEncodedMessage() == null || decodeAuthorizationMessageRequest.getEncodedMessage().equals(getEncodedMessage());
    }

    public String getEncodedMessage() {
        return this.encodedMessage;
    }

    public int hashCode() {
        return 31 + (getEncodedMessage() == null ? 0 : getEncodedMessage().hashCode());
    }

    public void setEncodedMessage(String str) {
        this.encodedMessage = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getEncodedMessage() != null) {
            sb2.append("EncodedMessage: " + getEncodedMessage());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DecodeAuthorizationMessageRequest withEncodedMessage(String str) {
        this.encodedMessage = str;
        return this;
    }
}
