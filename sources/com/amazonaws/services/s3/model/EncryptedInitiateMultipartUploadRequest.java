package com.amazonaws.services.s3.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EncryptedInitiateMultipartUploadRequest extends InitiateMultipartUploadRequest {
    private boolean createEncryptionMaterial = true;
    private Map<String, String> materialsDescription;

    public EncryptedInitiateMultipartUploadRequest(String str, String str2) {
        super(str, str2);
    }

    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public boolean isCreateEncryptionMaterial() {
        return this.createEncryptionMaterial;
    }

    public void setCreateEncryptionMaterial(boolean z11) {
        this.createEncryptionMaterial = z11;
    }

    public void setMaterialsDescription(Map<String, String> map) {
        Map<String, String> map2;
        if (map == null) {
            map2 = null;
        } else {
            map2 = Collections.unmodifiableMap(new HashMap(map));
        }
        this.materialsDescription = map2;
    }

    public EncryptedInitiateMultipartUploadRequest withCreateEncryptionMaterial(boolean z11) {
        this.createEncryptionMaterial = z11;
        return this;
    }

    public EncryptedInitiateMultipartUploadRequest withMaterialsDescription(Map<String, String> map) {
        setMaterialsDescription(map);
        return this;
    }

    public EncryptedInitiateMultipartUploadRequest(String str, String str2, ObjectMetadata objectMetadata) {
        super(str, str2, objectMetadata);
    }
}
