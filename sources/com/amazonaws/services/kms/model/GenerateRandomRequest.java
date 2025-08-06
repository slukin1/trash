package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class GenerateRandomRequest extends AmazonWebServiceRequest implements Serializable {
    private String customKeyStoreId;
    private Integer numberOfBytes;
    private RecipientInfo recipient;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateRandomRequest)) {
            return false;
        }
        GenerateRandomRequest generateRandomRequest = (GenerateRandomRequest) obj;
        if ((generateRandomRequest.getNumberOfBytes() == null) ^ (getNumberOfBytes() == null)) {
            return false;
        }
        if (generateRandomRequest.getNumberOfBytes() != null && !generateRandomRequest.getNumberOfBytes().equals(getNumberOfBytes())) {
            return false;
        }
        if ((generateRandomRequest.getCustomKeyStoreId() == null) ^ (getCustomKeyStoreId() == null)) {
            return false;
        }
        if (generateRandomRequest.getCustomKeyStoreId() != null && !generateRandomRequest.getCustomKeyStoreId().equals(getCustomKeyStoreId())) {
            return false;
        }
        if ((generateRandomRequest.getRecipient() == null) ^ (getRecipient() == null)) {
            return false;
        }
        return generateRandomRequest.getRecipient() == null || generateRandomRequest.getRecipient().equals(getRecipient());
    }

    public String getCustomKeyStoreId() {
        return this.customKeyStoreId;
    }

    public Integer getNumberOfBytes() {
        return this.numberOfBytes;
    }

    public RecipientInfo getRecipient() {
        return this.recipient;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getNumberOfBytes() == null ? 0 : getNumberOfBytes().hashCode()) + 31) * 31) + (getCustomKeyStoreId() == null ? 0 : getCustomKeyStoreId().hashCode())) * 31;
        if (getRecipient() != null) {
            i11 = getRecipient().hashCode();
        }
        return hashCode + i11;
    }

    public void setCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
    }

    public void setNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
    }

    public void setRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getNumberOfBytes() != null) {
            sb2.append("NumberOfBytes: " + getNumberOfBytes() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCustomKeyStoreId() != null) {
            sb2.append("CustomKeyStoreId: " + getCustomKeyStoreId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRecipient() != null) {
            sb2.append("Recipient: " + getRecipient());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GenerateRandomRequest withCustomKeyStoreId(String str) {
        this.customKeyStoreId = str;
        return this;
    }

    public GenerateRandomRequest withNumberOfBytes(Integer num) {
        this.numberOfBytes = num;
        return this;
    }

    public GenerateRandomRequest withRecipient(RecipientInfo recipientInfo) {
        this.recipient = recipientInfo;
        return this;
    }
}
