package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListAliasesResult implements Serializable {
    private List<AliasListEntry> aliases = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListAliasesResult)) {
            return false;
        }
        ListAliasesResult listAliasesResult = (ListAliasesResult) obj;
        if ((listAliasesResult.getAliases() == null) ^ (getAliases() == null)) {
            return false;
        }
        if (listAliasesResult.getAliases() != null && !listAliasesResult.getAliases().equals(getAliases())) {
            return false;
        }
        if ((listAliasesResult.getNextMarker() == null) ^ (getNextMarker() == null)) {
            return false;
        }
        if (listAliasesResult.getNextMarker() != null && !listAliasesResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if ((listAliasesResult.getTruncated() == null) ^ (getTruncated() == null)) {
            return false;
        }
        return listAliasesResult.getTruncated() == null || listAliasesResult.getTruncated().equals(getTruncated());
    }

    public List<AliasListEntry> getAliases() {
        return this.aliases;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getAliases() == null ? 0 : getAliases().hashCode()) + 31) * 31) + (getNextMarker() == null ? 0 : getNextMarker().hashCode())) * 31;
        if (getTruncated() != null) {
            i11 = getTruncated().hashCode();
        }
        return hashCode + i11;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setAliases(Collection<AliasListEntry> collection) {
        if (collection == null) {
            this.aliases = null;
        } else {
            this.aliases = new ArrayList(collection);
        }
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getAliases() != null) {
            sb2.append("Aliases: " + getAliases() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getNextMarker() != null) {
            sb2.append("NextMarker: " + getNextMarker() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getTruncated() != null) {
            sb2.append("Truncated: " + getTruncated());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ListAliasesResult withAliases(AliasListEntry... aliasListEntryArr) {
        if (getAliases() == null) {
            this.aliases = new ArrayList(aliasListEntryArr.length);
        }
        for (AliasListEntry add : aliasListEntryArr) {
            this.aliases.add(add);
        }
        return this;
    }

    public ListAliasesResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListAliasesResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListAliasesResult withAliases(Collection<AliasListEntry> collection) {
        setAliases(collection);
        return this;
    }
}
