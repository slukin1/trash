package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class AssumeRoleWithSAMLResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private String audience;
    private Credentials credentials;
    private String issuer;
    private String nameQualifier;
    private Integer packedPolicySize;
    private String sourceIdentity;
    private String subject;
    private String subjectType;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithSAMLResult)) {
            return false;
        }
        AssumeRoleWithSAMLResult assumeRoleWithSAMLResult = (AssumeRoleWithSAMLResult) obj;
        if ((assumeRoleWithSAMLResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getCredentials() != null && !assumeRoleWithSAMLResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getAssumedRoleUser() == null) ^ (getAssumedRoleUser() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAssumedRoleUser() != null && !assumeRoleWithSAMLResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getPackedPolicySize() == null) ^ (getPackedPolicySize() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getPackedPolicySize() != null && !assumeRoleWithSAMLResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getSubject() == null) ^ (getSubject() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubject() != null && !assumeRoleWithSAMLResult.getSubject().equals(getSubject())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getSubjectType() == null) ^ (getSubjectType() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getSubjectType() != null && !assumeRoleWithSAMLResult.getSubjectType().equals(getSubjectType())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getIssuer() == null) ^ (getIssuer() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getIssuer() != null && !assumeRoleWithSAMLResult.getIssuer().equals(getIssuer())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getAudience() == null) ^ (getAudience() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getAudience() != null && !assumeRoleWithSAMLResult.getAudience().equals(getAudience())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getNameQualifier() == null) ^ (getNameQualifier() == null)) {
            return false;
        }
        if (assumeRoleWithSAMLResult.getNameQualifier() != null && !assumeRoleWithSAMLResult.getNameQualifier().equals(getNameQualifier())) {
            return false;
        }
        if ((assumeRoleWithSAMLResult.getSourceIdentity() == null) ^ (getSourceIdentity() == null)) {
            return false;
        }
        return assumeRoleWithSAMLResult.getSourceIdentity() == null || assumeRoleWithSAMLResult.getSourceIdentity().equals(getSourceIdentity());
    }

    public AssumedRoleUser getAssumedRoleUser() {
        return this.assumedRoleUser;
    }

    public String getAudience() {
        return this.audience;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public String getNameQualifier() {
        return this.nameQualifier;
    }

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getSubjectType() {
        return this.subjectType;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((((((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31) + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode())) * 31) + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode())) * 31) + (getSubject() == null ? 0 : getSubject().hashCode())) * 31) + (getSubjectType() == null ? 0 : getSubjectType().hashCode())) * 31) + (getIssuer() == null ? 0 : getIssuer().hashCode())) * 31) + (getAudience() == null ? 0 : getAudience().hashCode())) * 31) + (getNameQualifier() == null ? 0 : getNameQualifier().hashCode())) * 31;
        if (getSourceIdentity() != null) {
            i11 = getSourceIdentity().hashCode();
        }
        return hashCode + i11;
    }

    public void setAssumedRoleUser(AssumedRoleUser assumedRoleUser2) {
        this.assumedRoleUser = assumedRoleUser2;
    }

    public void setAudience(String str) {
        this.audience = str;
    }

    public void setCredentials(Credentials credentials2) {
        this.credentials = credentials2;
    }

    public void setIssuer(String str) {
        this.issuer = str;
    }

    public void setNameQualifier(String str) {
        this.nameQualifier = str;
    }

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setSubjectType(String str) {
        this.subjectType = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCredentials() != null) {
            sb2.append("Credentials: " + getCredentials() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAssumedRoleUser() != null) {
            sb2.append("AssumedRoleUser: " + getAssumedRoleUser() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPackedPolicySize() != null) {
            sb2.append("PackedPolicySize: " + getPackedPolicySize() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSubject() != null) {
            sb2.append("Subject: " + getSubject() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSubjectType() != null) {
            sb2.append("SubjectType: " + getSubjectType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIssuer() != null) {
            sb2.append("Issuer: " + getIssuer() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAudience() != null) {
            sb2.append("Audience: " + getAudience() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNameQualifier() != null) {
            sb2.append("NameQualifier: " + getNameQualifier() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceIdentity() != null) {
            sb2.append("SourceIdentity: " + getSourceIdentity());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public AssumeRoleWithSAMLResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser2) {
        this.assumedRoleUser = assumedRoleUser2;
        return this;
    }

    public AssumeRoleWithSAMLResult withAudience(String str) {
        this.audience = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withCredentials(Credentials credentials2) {
        this.credentials = credentials2;
        return this;
    }

    public AssumeRoleWithSAMLResult withIssuer(String str) {
        this.issuer = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withNameQualifier(String str) {
        this.nameQualifier = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public AssumeRoleWithSAMLResult withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withSubject(String str) {
        this.subject = str;
        return this;
    }

    public AssumeRoleWithSAMLResult withSubjectType(String str) {
        this.subjectType = str;
        return this;
    }
}
