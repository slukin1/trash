package com.amazonaws.services.s3.model.inventory;

import com.google.common.net.HttpHeaders;

public enum InventoryOptionalField {
    Size("Size"),
    LastModifiedDate("LastModifiedDate"),
    StorageClass("StorageClass"),
    ETag(HttpHeaders.ETAG),
    IsMultipartUploaded("IsMultipartUploaded"),
    ReplicationStatus("ReplicationStatus");
    
    private final String field;

    private InventoryOptionalField(String str) {
        this.field = str;
    }

    public String toString() {
        return this.field;
    }
}
