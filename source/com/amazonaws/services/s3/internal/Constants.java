package com.amazonaws.services.s3.internal;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.SSEAlgorithm;

public class Constants {

    /* renamed from: a  reason: collision with root package name */
    public static Log f15142a = LogFactory.b(AmazonS3Client.class);

    /* renamed from: b  reason: collision with root package name */
    public static final String f15143b = SSEAlgorithm.KMS.getAlgorithm();
}
