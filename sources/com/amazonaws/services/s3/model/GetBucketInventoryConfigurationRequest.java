package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class GetBucketInventoryConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;

    /* renamed from: id  reason: collision with root package name */
    private String f15220id;

    public GetBucketInventoryConfigurationRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getId() {
        return this.f15220id;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setId(String str) {
        this.f15220id = str;
    }

    public GetBucketInventoryConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetBucketInventoryConfigurationRequest withId(String str) {
        setId(str);
        return this;
    }

    public GetBucketInventoryConfigurationRequest(String str, String str2) {
        this.bucketName = str;
        this.f15220id = str2;
    }
}
