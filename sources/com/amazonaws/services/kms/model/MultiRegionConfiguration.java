package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiRegionConfiguration implements Serializable {
    private String multiRegionKeyType;
    private MultiRegionKey primaryKey;
    private List<MultiRegionKey> replicaKeys = new ArrayList();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MultiRegionConfiguration)) {
            return false;
        }
        MultiRegionConfiguration multiRegionConfiguration = (MultiRegionConfiguration) obj;
        if ((multiRegionConfiguration.getMultiRegionKeyType() == null) ^ (getMultiRegionKeyType() == null)) {
            return false;
        }
        if (multiRegionConfiguration.getMultiRegionKeyType() != null && !multiRegionConfiguration.getMultiRegionKeyType().equals(getMultiRegionKeyType())) {
            return false;
        }
        if ((multiRegionConfiguration.getPrimaryKey() == null) ^ (getPrimaryKey() == null)) {
            return false;
        }
        if (multiRegionConfiguration.getPrimaryKey() != null && !multiRegionConfiguration.getPrimaryKey().equals(getPrimaryKey())) {
            return false;
        }
        if ((multiRegionConfiguration.getReplicaKeys() == null) ^ (getReplicaKeys() == null)) {
            return false;
        }
        return multiRegionConfiguration.getReplicaKeys() == null || multiRegionConfiguration.getReplicaKeys().equals(getReplicaKeys());
    }

    public String getMultiRegionKeyType() {
        return this.multiRegionKeyType;
    }

    public MultiRegionKey getPrimaryKey() {
        return this.primaryKey;
    }

    public List<MultiRegionKey> getReplicaKeys() {
        return this.replicaKeys;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getMultiRegionKeyType() == null ? 0 : getMultiRegionKeyType().hashCode()) + 31) * 31) + (getPrimaryKey() == null ? 0 : getPrimaryKey().hashCode())) * 31;
        if (getReplicaKeys() != null) {
            i11 = getReplicaKeys().hashCode();
        }
        return hashCode + i11;
    }

    public void setMultiRegionKeyType(String str) {
        this.multiRegionKeyType = str;
    }

    public void setPrimaryKey(MultiRegionKey multiRegionKey) {
        this.primaryKey = multiRegionKey;
    }

    public void setReplicaKeys(Collection<MultiRegionKey> collection) {
        if (collection == null) {
            this.replicaKeys = null;
        } else {
            this.replicaKeys = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getMultiRegionKeyType() != null) {
            sb2.append("MultiRegionKeyType: " + getMultiRegionKeyType() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPrimaryKey() != null) {
            sb2.append("PrimaryKey: " + getPrimaryKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getReplicaKeys() != null) {
            sb2.append("ReplicaKeys: " + getReplicaKeys());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public MultiRegionConfiguration withMultiRegionKeyType(String str) {
        this.multiRegionKeyType = str;
        return this;
    }

    public MultiRegionConfiguration withPrimaryKey(MultiRegionKey multiRegionKey) {
        this.primaryKey = multiRegionKey;
        return this;
    }

    public MultiRegionConfiguration withReplicaKeys(MultiRegionKey... multiRegionKeyArr) {
        if (getReplicaKeys() == null) {
            this.replicaKeys = new ArrayList(multiRegionKeyArr.length);
        }
        for (MultiRegionKey add : multiRegionKeyArr) {
            this.replicaKeys.add(add);
        }
        return this;
    }

    public void setMultiRegionKeyType(MultiRegionKeyType multiRegionKeyType2) {
        this.multiRegionKeyType = multiRegionKeyType2.toString();
    }

    public MultiRegionConfiguration withMultiRegionKeyType(MultiRegionKeyType multiRegionKeyType2) {
        this.multiRegionKeyType = multiRegionKeyType2.toString();
        return this;
    }

    public MultiRegionConfiguration withReplicaKeys(Collection<MultiRegionKey> collection) {
        setReplicaKeys(collection);
        return this;
    }
}
