package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonServiceException;

public class IncorrectKeyMaterialException extends AmazonServiceException {
    private static final long serialVersionUID = 1;

    public IncorrectKeyMaterialException(String str) {
        super(str);
    }
}
