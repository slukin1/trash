package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;

public interface S3DirectSpi {
    UploadPartResult a(UploadPartRequest uploadPartRequest);
}
