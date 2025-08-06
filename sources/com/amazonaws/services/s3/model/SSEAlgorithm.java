package com.amazonaws.services.s3.model;

public enum SSEAlgorithm {
    AES256("AES256"),
    KMS("aws:kms");
    
    private final String algorithm;

    private SSEAlgorithm(String str) {
        this.algorithm = str;
    }

    public static SSEAlgorithm fromString(String str) {
        if (str == null) {
            return null;
        }
        for (SSEAlgorithm sSEAlgorithm : values()) {
            if (sSEAlgorithm.getAlgorithm().equals(str)) {
                return sSEAlgorithm;
            }
        }
        throw new IllegalArgumentException("Unsupported algorithm " + str);
    }

    public static SSEAlgorithm getDefault() {
        return AES256;
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public String toString() {
        return this.algorithm;
    }
}
