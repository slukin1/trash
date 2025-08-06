package com.amazonaws.services.cognitoidentity.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SetIdentityPoolRolesRequest extends AmazonWebServiceRequest implements Serializable {
    private String identityPoolId;
    private Map<String, RoleMapping> roleMappings;
    private Map<String, String> roles;

    public SetIdentityPoolRolesRequest addRoleMappingsEntry(String str, RoleMapping roleMapping) {
        if (this.roleMappings == null) {
            this.roleMappings = new HashMap();
        }
        if (!this.roleMappings.containsKey(str)) {
            this.roleMappings.put(str, roleMapping);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public SetIdentityPoolRolesRequest addRolesEntry(String str, String str2) {
        if (this.roles == null) {
            this.roles = new HashMap();
        }
        if (!this.roles.containsKey(str)) {
            this.roles.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public SetIdentityPoolRolesRequest clearRoleMappingsEntries() {
        this.roleMappings = null;
        return this;
    }

    public SetIdentityPoolRolesRequest clearRolesEntries() {
        this.roles = null;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetIdentityPoolRolesRequest)) {
            return false;
        }
        SetIdentityPoolRolesRequest setIdentityPoolRolesRequest = (SetIdentityPoolRolesRequest) obj;
        if ((setIdentityPoolRolesRequest.getIdentityPoolId() == null) ^ (getIdentityPoolId() == null)) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getIdentityPoolId() != null && !setIdentityPoolRolesRequest.getIdentityPoolId().equals(getIdentityPoolId())) {
            return false;
        }
        if ((setIdentityPoolRolesRequest.getRoles() == null) ^ (getRoles() == null)) {
            return false;
        }
        if (setIdentityPoolRolesRequest.getRoles() != null && !setIdentityPoolRolesRequest.getRoles().equals(getRoles())) {
            return false;
        }
        if ((setIdentityPoolRolesRequest.getRoleMappings() == null) ^ (getRoleMappings() == null)) {
            return false;
        }
        return setIdentityPoolRolesRequest.getRoleMappings() == null || setIdentityPoolRolesRequest.getRoleMappings().equals(getRoleMappings());
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public Map<String, RoleMapping> getRoleMappings() {
        return this.roleMappings;
    }

    public Map<String, String> getRoles() {
        return this.roles;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getIdentityPoolId() == null ? 0 : getIdentityPoolId().hashCode()) + 31) * 31) + (getRoles() == null ? 0 : getRoles().hashCode())) * 31;
        if (getRoleMappings() != null) {
            i11 = getRoleMappings().hashCode();
        }
        return hashCode + i11;
    }

    public void setIdentityPoolId(String str) {
        this.identityPoolId = str;
    }

    public void setRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
    }

    public void setRoles(Map<String, String> map) {
        this.roles = map;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityPoolId() != null) {
            sb2.append("IdentityPoolId: " + getIdentityPoolId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRoles() != null) {
            sb2.append("Roles: " + getRoles() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRoleMappings() != null) {
            sb2.append("RoleMappings: " + getRoleMappings());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public SetIdentityPoolRolesRequest withIdentityPoolId(String str) {
        this.identityPoolId = str;
        return this;
    }

    public SetIdentityPoolRolesRequest withRoleMappings(Map<String, RoleMapping> map) {
        this.roleMappings = map;
        return this;
    }

    public SetIdentityPoolRolesRequest withRoles(Map<String, String> map) {
        this.roles = map;
        return this;
    }
}
