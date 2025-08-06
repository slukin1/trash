package com.amazonaws.services.s3.model;

import java.io.Serializable;

public class DeleteObjectsRequest$KeyVersion implements Serializable {
    private final String key;
    private final String version;

    public DeleteObjectsRequest$KeyVersion(String str) {
        this(str, (String) null);
    }

    public String getKey() {
        return this.key;
    }

    public String getVersion() {
        return this.version;
    }

    public DeleteObjectsRequest$KeyVersion(String str, String str2) {
        this.key = str;
        this.version = str2;
    }
}
