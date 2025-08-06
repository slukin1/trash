package com.amazonaws.services.cognitoidentity.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class IdentityDescription implements Serializable {
    private Date creationDate;
    private String identityId;
    private Date lastModifiedDate;
    private List<String> logins;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IdentityDescription)) {
            return false;
        }
        IdentityDescription identityDescription = (IdentityDescription) obj;
        if ((identityDescription.getIdentityId() == null) ^ (getIdentityId() == null)) {
            return false;
        }
        if (identityDescription.getIdentityId() != null && !identityDescription.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if ((identityDescription.getLogins() == null) ^ (getLogins() == null)) {
            return false;
        }
        if (identityDescription.getLogins() != null && !identityDescription.getLogins().equals(getLogins())) {
            return false;
        }
        if ((identityDescription.getCreationDate() == null) ^ (getCreationDate() == null)) {
            return false;
        }
        if (identityDescription.getCreationDate() != null && !identityDescription.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if ((identityDescription.getLastModifiedDate() == null) ^ (getLastModifiedDate() == null)) {
            return false;
        }
        return identityDescription.getLastModifiedDate() == null || identityDescription.getLastModifiedDate().equals(getLastModifiedDate());
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public List<String> getLogins() {
        return this.logins;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getIdentityId() == null ? 0 : getIdentityId().hashCode()) + 31) * 31) + (getLogins() == null ? 0 : getLogins().hashCode())) * 31) + (getCreationDate() == null ? 0 : getCreationDate().hashCode())) * 31;
        if (getLastModifiedDate() != null) {
            i11 = getLastModifiedDate().hashCode();
        }
        return hashCode + i11;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setLogins(Collection<String> collection) {
        if (collection == null) {
            this.logins = null;
        } else {
            this.logins = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getIdentityId() != null) {
            sb2.append("IdentityId: " + getIdentityId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLogins() != null) {
            sb2.append("Logins: " + getLogins() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getCreationDate() != null) {
            sb2.append("CreationDate: " + getCreationDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getLastModifiedDate() != null) {
            sb2.append("LastModifiedDate: " + getLastModifiedDate());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public IdentityDescription withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public IdentityDescription withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public IdentityDescription withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public IdentityDescription withLogins(String... strArr) {
        if (getLogins() == null) {
            this.logins = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.logins.add(add);
        }
        return this;
    }

    public IdentityDescription withLogins(Collection<String> collection) {
        setLogins(collection);
        return this;
    }
}
