package com.amazonaws.services.s3.model.analytics;

public enum StorageClassAnalysisSchemaVersion {
    V_1("V_1");
    
    private final String version;

    private StorageClassAnalysisSchemaVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return this.version;
    }
}
