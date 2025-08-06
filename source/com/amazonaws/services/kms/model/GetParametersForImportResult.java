package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

public class GetParametersForImportResult implements Serializable {
    private ByteBuffer importToken;
    private String keyId;
    private Date parametersValidTo;
    private ByteBuffer publicKey;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetParametersForImportResult)) {
            return false;
        }
        GetParametersForImportResult getParametersForImportResult = (GetParametersForImportResult) obj;
        if ((getParametersForImportResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (getParametersForImportResult.getKeyId() != null && !getParametersForImportResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((getParametersForImportResult.getImportToken() == null) ^ (getImportToken() == null)) {
            return false;
        }
        if (getParametersForImportResult.getImportToken() != null && !getParametersForImportResult.getImportToken().equals(getImportToken())) {
            return false;
        }
        if ((getParametersForImportResult.getPublicKey() == null) ^ (getPublicKey() == null)) {
            return false;
        }
        if (getParametersForImportResult.getPublicKey() != null && !getParametersForImportResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if ((getParametersForImportResult.getParametersValidTo() == null) ^ (getParametersValidTo() == null)) {
            return false;
        }
        return getParametersForImportResult.getParametersValidTo() == null || getParametersForImportResult.getParametersValidTo().equals(getParametersValidTo());
    }

    public ByteBuffer getImportToken() {
        return this.importToken;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Date getParametersValidTo() {
        return this.parametersValidTo;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getImportToken() == null ? 0 : getImportToken().hashCode())) * 31) + (getPublicKey() == null ? 0 : getPublicKey().hashCode())) * 31;
        if (getParametersValidTo() != null) {
            i11 = getParametersValidTo().hashCode();
        }
        return hashCode + i11;
    }

    public void setImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setParametersValidTo(Date date) {
        this.parametersValidTo = date;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getImportToken() != null) {
            sb2.append("ImportToken: " + getImportToken() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPublicKey() != null) {
            sb2.append("PublicKey: " + getPublicKey() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getParametersValidTo() != null) {
            sb2.append("ParametersValidTo: " + getParametersValidTo());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public GetParametersForImportResult withImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
        return this;
    }

    public GetParametersForImportResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetParametersForImportResult withParametersValidTo(Date date) {
        this.parametersValidTo = date;
        return this;
    }

    public GetParametersForImportResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }
}
