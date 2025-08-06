package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonServiceException;

public class InvalidIdentityTokenException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public InvalidIdentityTokenException(String str) {
        super(str);
    }
}
