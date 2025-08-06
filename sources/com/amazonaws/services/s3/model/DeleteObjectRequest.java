package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class DeleteObjectRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private boolean isRequesterPays;
    private String key;

    public DeleteObjectRequest(String str, String str2) {
        setBucketName(str);
        setKey(str2);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRequesterPays(boolean z11) {
        this.isRequesterPays = z11;
    }

    public DeleteObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public DeleteObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public DeleteObjectRequest withRequesterPays(boolean z11) {
        setRequesterPays(z11);
        return this;
    }
}
