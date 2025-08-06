package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class TagException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public TagException(String str) {
        super(str);
    }
}
