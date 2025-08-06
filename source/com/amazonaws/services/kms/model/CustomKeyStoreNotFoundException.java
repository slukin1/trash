package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class CustomKeyStoreNotFoundException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public CustomKeyStoreNotFoundException(String str) {
        super(str);
    }
}
