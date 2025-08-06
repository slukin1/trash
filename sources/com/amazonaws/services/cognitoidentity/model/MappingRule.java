package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class MappingRule implements Serializable {
    private String claim;
    private String matchType;
    private String roleARN;
    private String value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MappingRule)) {
            return false;
        }
        MappingRule mappingRule = (MappingRule) obj;
        if ((mappingRule.getClaim() == null) ^ (getClaim() == null)) {
            return false;
        }
        if (mappingRule.getClaim() != null && !mappingRule.getClaim().equals(getClaim())) {
            return false;
        }
        if ((mappingRule.getMatchType() == null) ^ (getMatchType() == null)) {
            return false;
        }
        if (mappingRule.getMatchType() != null && !mappingRule.getMatchType().equals(getMatchType())) {
            return false;
        }
        if ((mappingRule.getValue() == null) ^ (getValue() == null)) {
            return false;
        }
        if (mappingRule.getValue() != null && !mappingRule.getValue().equals(getValue())) {
            return false;
        }
        if ((mappingRule.getRoleARN() == null) ^ (getRoleARN() == null)) {
            return false;
        }
        return mappingRule.getRoleARN() == null || mappingRule.getRoleARN().equals(getRoleARN());
    }

    public String getClaim() {
        return this.claim;
    }

    public String getMatchType() {
        return this.matchType;
    }

    public String getRoleARN() {
        return this.roleARN;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getClaim() == null ? 0 : getClaim().hashCode()) + 31) * 31) + (getMatchType() == null ? 0 : getMatchType().hashCode())) * 31) + (getValue() == null ? 0 : getValue().hashCode())) * 31;
        if (getRoleARN() != null) {
            i11 = getRoleARN().hashCode();
        }
        return hashCode + i11;
    }

    public void setClaim(String str) {
        this.claim = str;
    }

    public void setMatchType(String str) {
        this.matchType = str;
    }

    public void setRoleARN(String str) {
        this.roleARN = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getClaim() != null) {
            sb2.append("Claim: " + getClaim() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMatchType() != null) {
            sb2.append("MatchType: " + getMatchType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getValue() != null) {
            sb2.append("Value: " + getValue() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRoleARN() != null) {
            sb2.append("RoleARN: " + getRoleARN());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public MappingRule withClaim(String str) {
        this.claim = str;
        return this;
    }

    public MappingRule withMatchType(String str) {
        this.matchType = str;
        return this;
    }

    public MappingRule withRoleARN(String str) {
        this.roleARN = str;
        return this;
    }

    public MappingRule withValue(String str) {
        this.value = str;
        return this;
    }

    public void setMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
    }

    public MappingRule withMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
        return this;
    }
}
