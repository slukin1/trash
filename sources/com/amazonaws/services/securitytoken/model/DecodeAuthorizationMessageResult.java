package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class DecodeAuthorizationMessageResult implements Serializable {
    private String decodedMessage;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DecodeAuthorizationMessageResult)) {
            return false;
        }
        DecodeAuthorizationMessageResult decodeAuthorizationMessageResult = (DecodeAuthorizationMessageResult) obj;
        if ((decodeAuthorizationMessageResult.getDecodedMessage() == null) ^ (getDecodedMessage() == null)) {
            return false;
        }
        return decodeAuthorizationMessageResult.getDecodedMessage() == null || decodeAuthorizationMessageResult.getDecodedMessage().equals(getDecodedMessage());
    }

    public String getDecodedMessage() {
        return this.decodedMessage;
    }

    public int hashCode() {
        return 31 + (getDecodedMessage() == null ? 0 : getDecodedMessage().hashCode());
    }

    public void setDecodedMessage(String str) {
        this.decodedMessage = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getDecodedMessage() != null) {
            sb2.append("DecodedMessage: " + getDecodedMessage());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DecodeAuthorizationMessageResult withDecodedMessage(String str) {
        this.decodedMessage = str;
        return this;
    }
}
