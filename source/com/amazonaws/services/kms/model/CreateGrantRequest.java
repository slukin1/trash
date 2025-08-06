package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateGrantRequest extends AmazonWebServiceRequest implements Serializable {
    private GrantConstraints constraints;
    private Boolean dryRun;
    private List<String> grantTokens = new ArrayList();
    private String granteePrincipal;
    private String keyId;
    private String name;
    private List<String> operations = new ArrayList();
    private String retiringPrincipal;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGrantRequest)) {
            return false;
        }
        CreateGrantRequest createGrantRequest = (CreateGrantRequest) obj;
        if ((createGrantRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (createGrantRequest.getKeyId() != null && !createGrantRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((createGrantRequest.getGranteePrincipal() == null) ^ (getGranteePrincipal() == null)) {
            return false;
        }
        if (createGrantRequest.getGranteePrincipal() != null && !createGrantRequest.getGranteePrincipal().equals(getGranteePrincipal())) {
            return false;
        }
        if ((createGrantRequest.getRetiringPrincipal() == null) ^ (getRetiringPrincipal() == null)) {
            return false;
        }
        if (createGrantRequest.getRetiringPrincipal() != null && !createGrantRequest.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return false;
        }
        if ((createGrantRequest.getOperations() == null) ^ (getOperations() == null)) {
            return false;
        }
        if (createGrantRequest.getOperations() != null && !createGrantRequest.getOperations().equals(getOperations())) {
            return false;
        }
        if ((createGrantRequest.getConstraints() == null) ^ (getConstraints() == null)) {
            return false;
        }
        if (createGrantRequest.getConstraints() != null && !createGrantRequest.getConstraints().equals(getConstraints())) {
            return false;
        }
        if ((createGrantRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        if (createGrantRequest.getGrantTokens() != null && !createGrantRequest.getGrantTokens().equals(getGrantTokens())) {
            return false;
        }
        if ((createGrantRequest.getName() == null) ^ (getName() == null)) {
            return false;
        }
        if (createGrantRequest.getName() != null && !createGrantRequest.getName().equals(getName())) {
            return false;
        }
        if ((createGrantRequest.getDryRun() == null) ^ (getDryRun() == null)) {
            return false;
        }
        return createGrantRequest.getDryRun() == null || createGrantRequest.getDryRun().equals(getDryRun());
    }

    public GrantConstraints getConstraints() {
        return this.constraints;
    }

    public Boolean getDryRun() {
        return this.dryRun;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public String getGranteePrincipal() {
        return this.granteePrincipal;
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
        int hashCode = ((((((((((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getGranteePrincipal() == null ? 0 : getGranteePrincipal().hashCode())) * 31) + (getRetiringPrincipal() == null ? 0 : getRetiringPrincipal().hashCode())) * 31) + (getOperations() == null ? 0 : getOperations().hashCode())) * 31) + (getConstraints() == null ? 0 : getConstraints().hashCode())) * 31) + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode())) * 31) + (getName() == null ? 0 : getName().hashCode())) * 31;
        if (getDryRun() != null) {
            i11 = getDryRun().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isDryRun() {
        return this.dryRun;
    }

    public void setConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
    }

    public void setDryRun(Boolean bool) {
        this.dryRun = bool;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public void setGranteePrincipal(String str) {
        this.granteePrincipal = str;
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
        if (getGranteePrincipal() != null) {
            sb2.append("GranteePrincipal: " + getGranteePrincipal() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getRetiringPrincipal() != null) {
            sb2.append("RetiringPrincipal: " + getRetiringPrincipal() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getOperations() != null) {
            sb2.append("Operations: " + getOperations() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getConstraints() != null) {
            sb2.append("Constraints: " + getConstraints() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getGrantTokens() != null) {
            sb2.append("GrantTokens: " + getGrantTokens() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getName() != null) {
            sb2.append("Name: " + getName() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getDryRun() != null) {
            sb2.append("DryRun: " + getDryRun());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public CreateGrantRequest withConstraints(GrantConstraints grantConstraints) {
        this.constraints = grantConstraints;
        return this;
    }

    public CreateGrantRequest withDryRun(Boolean bool) {
        this.dryRun = bool;
        return this;
    }

    public CreateGrantRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public CreateGrantRequest withGranteePrincipal(String str) {
        this.granteePrincipal = str;
        return this;
    }

    public CreateGrantRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public CreateGrantRequest withName(String str) {
        this.name = str;
        return this;
    }

    public CreateGrantRequest withOperations(String... strArr) {
        if (getOperations() == null) {
            this.operations = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.operations.add(add);
        }
        return this;
    }

    public CreateGrantRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }

    public CreateGrantRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public CreateGrantRequest withOperations(Collection<String> collection) {
        setOperations(collection);
        return this;
    }
}
