package com.amazonaws.services.securitytoken.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class AssumeRoleWithWebIdentityResult implements Serializable {
    private AssumedRoleUser assumedRoleUser;
    private String audience;
    private Credentials credentials;
    private Integer packedPolicySize;
    private String provider;
    private String sourceIdentity;
    private String subjectFromWebIdentityToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssumeRoleWithWebIdentityResult)) {
            return false;
        }
        AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentityResult = (AssumeRoleWithWebIdentityResult) obj;
        if ((assumeRoleWithWebIdentityResult.getCredentials() == null) ^ (getCredentials() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getCredentials() != null && !assumeRoleWithWebIdentityResult.getCredentials().equals(getCredentials())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getSubjectFromWebIdentityToken() == null) ^ (getSubjectFromWebIdentityToken() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getSubjectFromWebIdentityToken() != null && !assumeRoleWithWebIdentityResult.getSubjectFromWebIdentityToken().equals(getSubjectFromWebIdentityToken())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getAssumedRoleUser() == null) ^ (getAssumedRoleUser() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getAssumedRoleUser() != null && !assumeRoleWithWebIdentityResult.getAssumedRoleUser().equals(getAssumedRoleUser())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getPackedPolicySize() == null) ^ (getPackedPolicySize() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getPackedPolicySize() != null && !assumeRoleWithWebIdentityResult.getPackedPolicySize().equals(getPackedPolicySize())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getProvider() == null) ^ (getProvider() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getProvider() != null && !assumeRoleWithWebIdentityResult.getProvider().equals(getProvider())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getAudience() == null) ^ (getAudience() == null)) {
            return false;
        }
        if (assumeRoleWithWebIdentityResult.getAudience() != null && !assumeRoleWithWebIdentityResult.getAudience().equals(getAudience())) {
            return false;
        }
        if ((assumeRoleWithWebIdentityResult.getSourceIdentity() == null) ^ (getSourceIdentity() == null)) {
            return false;
        }
        return assumeRoleWithWebIdentityResult.getSourceIdentity() == null || assumeRoleWithWebIdentityResult.getSourceIdentity().equals(getSourceIdentity());
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

    public Integer getPackedPolicySize() {
        return this.packedPolicySize;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getSourceIdentity() {
        return this.sourceIdentity;
    }

    public String getSubjectFromWebIdentityToken() {
        return this.subjectFromWebIdentityToken;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((getCredentials() == null ? 0 : getCredentials().hashCode()) + 31) * 31;
        if (getSubjectFromWebIdentityToken() == null) {
            i11 = 0;
        } else {
            i11 = getSubjectFromWebIdentityToken().hashCode();
        }
        int hashCode2 = (((((((((hashCode + i11) * 31) + (getAssumedRoleUser() == null ? 0 : getAssumedRoleUser().hashCode())) * 31) + (getPackedPolicySize() == null ? 0 : getPackedPolicySize().hashCode())) * 31) + (getProvider() == null ? 0 : getProvider().hashCode())) * 31) + (getAudience() == null ? 0 : getAudience().hashCode())) * 31;
        if (getSourceIdentity() != null) {
            i12 = getSourceIdentity().hashCode();
        }
        return hashCode2 + i12;
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

    public void setPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public void setSourceIdentity(String str) {
        this.sourceIdentity = str;
    }

    public void setSubjectFromWebIdentityToken(String str) {
        this.subjectFromWebIdentityToken = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getCredentials() != null) {
            sb2.append("Credentials: " + getCredentials() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSubjectFromWebIdentityToken() != null) {
            sb2.append("SubjectFromWebIdentityToken: " + getSubjectFromWebIdentityToken() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAssumedRoleUser() != null) {
            sb2.append("AssumedRoleUser: " + getAssumedRoleUser() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPackedPolicySize() != null) {
            sb2.append("PackedPolicySize: " + getPackedPolicySize() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getProvider() != null) {
            sb2.append("Provider: " + getProvider() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAudience() != null) {
            sb2.append("Audience: " + getAudience() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getSourceIdentity() != null) {
            sb2.append("SourceIdentity: " + getSourceIdentity());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public AssumeRoleWithWebIdentityResult withAssumedRoleUser(AssumedRoleUser assumedRoleUser2) {
        this.assumedRoleUser = assumedRoleUser2;
        return this;
    }

    public AssumeRoleWithWebIdentityResult withAudience(String str) {
        this.audience = str;
        return this;
    }

    public AssumeRoleWithWebIdentityResult withCredentials(Credentials credentials2) {
        this.credentials = credentials2;
        return this;
    }

    public AssumeRoleWithWebIdentityResult withPackedPolicySize(Integer num) {
        this.packedPolicySize = num;
        return this;
    }

    public AssumeRoleWithWebIdentityResult withProvider(String str) {
        this.provider = str;
        return this;
    }

    public AssumeRoleWithWebIdentityResult withSourceIdentity(String str) {
        this.sourceIdentity = str;
        return this;
    }

    public AssumeRoleWithWebIdentityResult withSubjectFromWebIdentityToken(String str) {
        this.subjectFromWebIdentityToken = str;
        return this;
    }
}
