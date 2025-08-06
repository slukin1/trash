package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class RoleMapping implements Serializable {
    private String ambiguousRoleResolution;
    private RulesConfigurationType rulesConfiguration;
    private String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RoleMapping)) {
            return false;
        }
        RoleMapping roleMapping = (RoleMapping) obj;
        if ((roleMapping.getType() == null) ^ (getType() == null)) {
            return false;
        }
        if (roleMapping.getType() != null && !roleMapping.getType().equals(getType())) {
            return false;
        }
        if ((roleMapping.getAmbiguousRoleResolution() == null) ^ (getAmbiguousRoleResolution() == null)) {
            return false;
        }
        if (roleMapping.getAmbiguousRoleResolution() != null && !roleMapping.getAmbiguousRoleResolution().equals(getAmbiguousRoleResolution())) {
            return false;
        }
        if ((roleMapping.getRulesConfiguration() == null) ^ (getRulesConfiguration() == null)) {
            return false;
        }
        return roleMapping.getRulesConfiguration() == null || roleMapping.getRulesConfiguration().equals(getRulesConfiguration());
    }

    public String getAmbiguousRoleResolution() {
        return this.ambiguousRoleResolution;
    }

    public RulesConfigurationType getRulesConfiguration() {
        return this.rulesConfiguration;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int i11;
        int i12 = 0;
        int hashCode = ((getType() == null ? 0 : getType().hashCode()) + 31) * 31;
        if (getAmbiguousRoleResolution() == null) {
            i11 = 0;
        } else {
            i11 = getAmbiguousRoleResolution().hashCode();
        }
        int i13 = (hashCode + i11) * 31;
        if (getRulesConfiguration() != null) {
            i12 = getRulesConfiguration().hashCode();
        }
        return i13 + i12;
    }

    public void setAmbiguousRoleResolution(String str) {
        this.ambiguousRoleResolution = str;
    }

    public void setRulesConfiguration(RulesConfigurationType rulesConfigurationType) {
        this.rulesConfiguration = rulesConfigurationType;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getType() != null) {
            sb2.append("Type: " + getType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getAmbiguousRoleResolution() != null) {
            sb2.append("AmbiguousRoleResolution: " + getAmbiguousRoleResolution() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRulesConfiguration() != null) {
            sb2.append("RulesConfiguration: " + getRulesConfiguration());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public RoleMapping withAmbiguousRoleResolution(String str) {
        this.ambiguousRoleResolution = str;
        return this;
    }

    public RoleMapping withRulesConfiguration(RulesConfigurationType rulesConfigurationType) {
        this.rulesConfiguration = rulesConfigurationType;
        return this;
    }

    public RoleMapping withType(String str) {
        this.type = str;
        return this;
    }

    public void setAmbiguousRoleResolution(AmbiguousRoleResolutionType ambiguousRoleResolutionType) {
        this.ambiguousRoleResolution = ambiguousRoleResolutionType.toString();
    }

    public void setType(RoleMappingType roleMappingType) {
        this.type = roleMappingType.toString();
    }

    public RoleMapping withAmbiguousRoleResolution(AmbiguousRoleResolutionType ambiguousRoleResolutionType) {
        this.ambiguousRoleResolution = ambiguousRoleResolutionType.toString();
        return this;
    }

    public RoleMapping withType(RoleMappingType roleMappingType) {
        this.type = roleMappingType.toString();
        return this;
    }
}
