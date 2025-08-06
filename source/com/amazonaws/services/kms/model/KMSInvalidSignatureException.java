package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class KMSInvalidSignatureException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public KMSInvalidSignatureException(String str) {
        super(str);
    }
}
