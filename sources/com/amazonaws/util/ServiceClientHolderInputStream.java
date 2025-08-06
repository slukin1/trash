package com.amazonaws.util;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

public class ServiceClientHolderInputStream extends SdkFilterInputStream {

    /* renamed from: b  reason: collision with root package name */
    public AmazonWebServiceClient f15559b;

    public ServiceClientHolderInputStream(InputStream inputStream, AmazonWebServiceClient amazonWebServiceClient) {
        super(inputStream);
        this.f15559b = amazonWebServiceClient;
    }
}
