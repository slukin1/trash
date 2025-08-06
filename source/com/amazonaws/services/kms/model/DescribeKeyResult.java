package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class DescribeKeyResult implements Serializable {
    private KeyMetadata keyMetadata;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeKeyResult)) {
            return false;
        }
        DescribeKeyResult describeKeyResult = (DescribeKeyResult) obj;
        if ((describeKeyResult.getKeyMetadata() == null) ^ (getKeyMetadata() == null)) {
            return false;
        }
        return describeKeyResult.getKeyMetadata() == null || describeKeyResult.getKeyMetadata().equals(getKeyMetadata());
    }

    public KeyMetadata getKeyMetadata() {
        return this.keyMetadata;
    }

    public int hashCode() {
        return 31 + (getKeyMetadata() == null ? 0 : getKeyMetadata().hashCode());
    }

    public void setKeyMetadata(KeyMetadata keyMetadata2) {
        this.keyMetadata = keyMetadata2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyMetadata() != null) {
            sb2.append("KeyMetadata: " + getKeyMetadata());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public DescribeKeyResult withKeyMetadata(KeyMetadata keyMetadata2) {
        this.keyMetadata = keyMetadata2;
        return this;
    }
}
