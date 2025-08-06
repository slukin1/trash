package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonServiceException;

public class IDPRejectedClaimException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public IDPRejectedClaimException(String str) {
        super(str);
    }
}
