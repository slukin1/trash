package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class GrantListEntry implements Serializable {
    private GrantConstraints constraints;
    private Date creationDate;
    private String grantId;
    private String granteePrincipal;
    private String issuingAccount;
    private String keyId;
    private String name;
    private List<String> operations = new ArrayList();
    private String retiringPrincipal;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantListEntry)) {
            return false;
        }
        GrantListEntry grantListEntry = (GrantListEntry) obj;
        if ((grantListEntry.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (grantListEntry.getKeyId() != null && !grantListEntry.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((grantListEntry.getGrantId() == null) ^ (getGrantId() == null)) {
            return false;
        }
        if (grantListEntry.getGrantId() != null && !grantListEntry.getGrantId().equals(getGrantId())) {
            return false;
        }
        if ((grantListEntry.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (grantListEntry.getName() != null && !grantListEntry.getName().equals(getName())) {
            return false;
        }
        if ((grantListEntry.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (grantListEntry.getCreationDate() != null && !grantListEntry.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((grantListEntry.getGranteePrincipal() == null) ^ (getGranteePrincipal() == null)) {
            return false;
        }
        if (grantListEntry.getGranteePrincipal() != null && !grantListEntry.getGranteePrincipal().equals(getGranteePrincipal())) {
            return false;
        }
        if ((grantListEntry.getRetiringPrincipal() == null) ^ (getRetiringPrincipal() == null)) {
            return false;
        }
        if (grantListEntry.getRetiringPrincipal() != null && !grantListEntry.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return false;
        }
        if ((grantListEntry.getIssuingAccount() == null) ^ (getIssuingAccount() == null)) {
            return false;
        }
        if (grantListEntry.getIssuingAccount() != null && !grantListEntry.getIssuingAccount().equals(getIssuingAccount())) {
            return false;
        }
        if ((grantListEntry.getOperations() == null) ^ (getOperations() == null)) {
            return false;
        }
        if (grantListEntry.getOperations() != null && !grantListEntry.getOperations().equals(getOperations())) {
            return false;
        }
        if ((grantListEntry.getConstraints() == null) ^ (getConstraints() == null)) {
            return false;
        }
        return grantListEntry.getConstraints() == null || grantListEntry.getConstraints().equals(getConstraints());
    }

    public GrantConstraints getConstraints() {
        return this.constraints;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
    }

    public String getIssuingAccount() {
        return this.issuingAccount;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getOperations() {
        return this.operations;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getGrantId() == null ? 0 : getGrantId().hashCode())) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31) + (getGranteePrincipal() == null ? 0 : getGranteePrincipal().hashCode())) * 31) + (getRetiringPrincipal() == null ? 0 : getRetiringPrincipal().hashCode())) * 31) + (getIssuingAccount() == null ? 0 : getIssuingAccount().hashCode())) * 31) + (getOperations() == null ? 0 : getOperations().hashCode())) * 31;
        if (getConstraints() != null) {
            i11 = getConstraints().hashCode();
        }
        return hashCode + i11;
    }

    public void setConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
    }

    public void setIssuingAccount(String str) {
        this.issuingAccount = str;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOperations(Collection<String> collection) {
        if (collection == null) {
            this.operations = null;
        } else {
            this.operations = new ArrayList(collection);
        }
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantId() != null) {
            sb2.append("GrantId: " + getGrantId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getName() != null) {
            sb2.append("Name: " + getName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCreationDate() != null) {
            sb2.append("CreationDate: " + getCreationDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGranteePrincipal() != null) {
            sb2.append("GranteePrincipal: " + getGranteePrincipal() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRetiringPrincipal() != null) {
            sb2.append("RetiringPrincipal: " + getRetiringPrincipal() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getIssuingAccount() != null) {
            sb2.append("IssuingAccount: " + getIssuingAccount() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getOperations() != null) {
            sb2.append("Operations: " + getOperations() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getConstraints() != null) {
            sb2.append("Constraints: " + getConstraints());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GrantListEntry withConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
        return this;
    }

    public GrantListEntry withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public GrantListEntry withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public GrantListEntry withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public GrantListEntry withIssuingAccount(String str) {
        this.issuingAccount = str;
        return this;
    }

    public GrantListEntry withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GrantListEntry withName(String str) {
        this.name = str;
        return this;
    }

    public GrantListEntry withOperations(String... strArr) {
        if (getOperations() == null) {
            this.operations = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.operations.add(add);
        }
        return this;
    }

    public GrantListEntry withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public GrantListEntry withOperations(Collection<String> collection) {
        setOperations(collection);
        return this;
    }
}
