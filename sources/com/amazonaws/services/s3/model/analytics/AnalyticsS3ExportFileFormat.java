package com.amazonaws.services.s3.model.analytics;

public enum AnalyticsS3ExportFileFormat {
    CSV("CSV");
    
    private final String format;

    private AnalyticsS3ExportFileFormat(String str) {
        this.format = str;
    }

    public String toString() {
        return this.format;
    }
}
