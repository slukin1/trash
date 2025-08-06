package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class GenerateMacResult implements Serializable {
    private String keyId;
    private ByteBuffer mac;
    private String macAlgorithm;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateMacResult)) {
            return false;
        }
        GenerateMacResult generateMacResult = (GenerateMacResult) obj;
        if ((generateMacResult.getMac() == null) ^ (getMac() == null)) {
            return false;
        }
        if (generateMacResult.getMac() != null && !generateMacResult.getMac().equals(getMac())) {
            return false;
        }
        if ((generateMacResult.getMacAlgorithm() == null) ^ (getMacAlgorithm() == null)) {
            return false;
        }
        if (generateMacResult.getMacAlgorithm() != null && !generateMacResult.getMacAlgorithm().equals(getMacAlgorithm())) {
            return false;
        }
        if ((generateMacResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        return generateMacResult.getKeyId() == null || generateMacResult.getKeyId().equals(getKeyId());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public ByteBuffer getMac() {
        return this.mac;
    }

    public String getMacAlgorithm() {
        return this.macAlgorithm;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((getMac() == null ? 0 : getMac().hashCode()) + 31) * 31) + (getMacAlgorithm() == null ? 0 : getMacAlgorithm().hashCode())) * 31;
        if (getKeyId() != null) {
            i11 = getKeyId().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
    }

    public void setMacAlgorithm(String str) {
        this.macAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getMac() != null) {
            sb2.append("Mac: " + getMac() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getMacAlgorithm() != null) {
            sb2.append("MacAlgorithm: " + getMacAlgorithm() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GenerateMacResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateMacResult withMac(ByteBuffer byteBuffer) {
        this.mac = byteBuffer;
        return this;
    }

    public GenerateMacResult withMacAlgorithm(String str) {
        this.macAlgorithm = str;
        return this;
    }

    public void setMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
    }

    public GenerateMacResult withMacAlgorithm(MacAlgorithmSpec macAlgorithmSpec) {
        this.macAlgorithm = macAlgorithmSpec.toString();
        return this;
    }
}
