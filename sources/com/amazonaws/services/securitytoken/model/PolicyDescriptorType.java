package com.amazonaws.services.securitytoken.model;

import java.io.Serializable;

public class PolicyDescriptorType implements Serializable {
    private String arn;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PolicyDescriptorType)) {
            return false;
        }
        PolicyDescriptorType policyDescriptorType = (PolicyDescriptorType) obj;
        if ((policyDescriptorType.getArn() == null) ^ (getArn() == null)) {
            return false;
        }
        return policyDescriptorType.getArn() == null || policyDescriptorType.getArn().equals(getArn());
    }

    public String getArn() {
        return this.arn;
    }

    public int hashCode() {
        return 31 + (getArn() == null ? 0 : getArn().hashCode());
    }

    public void setArn(String str) {
        this.arn = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getArn() != null) {
            sb2.append("arn: " + getArn());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public PolicyDescriptorType withArn(String str) {
        this.arn = str;
        return this;
    }
}
