package com.amazonaws.services.s3.model;

import com.amazonaws.event.ProgressListener;
import java.io.File;
import java.io.InputStream;

public class PutObjectRequest extends AbstractPutObjectRequest {
    private boolean isRequesterPays;

    public PutObjectRequest(String str, String str2, File file) {
        super(str, str2, file);
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setRequesterPays(boolean z11) {
        this.isRequesterPays = z11;
    }

    public PutObjectRequest withRequesterPays(boolean z11) {
        setRequesterPays(z11);
        return this;
    }

    public PutObjectRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public PutObjectRequest withAccessControlList(AccessControlList accessControlList) {
        return (PutObjectRequest) super.withAccessControlList(accessControlList);
    }

    public PutObjectRequest withBucketName(String str) {
        return (PutObjectRequest) super.withBucketName(str);
    }

    public PutObjectRequest withCannedAcl(CannedAccessControlList cannedAccessControlList) {
        return (PutObjectRequest) super.withCannedAcl(cannedAccessControlList);
    }

    public PutObjectRequest withFile(File file) {
        return (PutObjectRequest) super.withFile(file);
    }

    public PutObjectRequest withGeneralProgressListener(ProgressListener progressListener) {
        return (PutObjectRequest) super.withGeneralProgressListener(progressListener);
    }

    public PutObjectRequest withInputStream(InputStream inputStream) {
        return (PutObjectRequest) super.withInputStream(inputStream);
    }

    public PutObjectRequest withKey(String str) {
        return (PutObjectRequest) super.withKey(str);
    }

    public PutObjectRequest withMetadata(ObjectMetadata objectMetadata) {
        return (PutObjectRequest) super.withMetadata(objectMetadata);
    }

    @Deprecated
    public PutObjectRequest withProgressListener(ProgressListener progressListener) {
        return (PutObjectRequest) super.withProgressListener(progressListener);
    }

    public PutObjectRequest withRedirectLocation(String str) {
        return (PutObjectRequest) super.withRedirectLocation(str);
    }

    public PutObjectRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        return (PutObjectRequest) super.withSSEAwsKeyManagementParams(sSEAwsKeyManagementParams);
    }

    public PutObjectRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        return (PutObjectRequest) super.withSSECustomerKey(sSECustomerKey);
    }

    public PutObjectRequest withTagging(ObjectTagging objectTagging) {
        super.setTagging(objectTagging);
        return this;
    }

    public PutObjectRequest(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) {
        super(str, str2, inputStream, objectMetadata);
    }

    public PutObjectRequest withStorageClass(String str) {
        return (PutObjectRequest) super.withStorageClass(str);
    }

    public PutObjectRequest clone() {
        return (PutObjectRequest) copyPutObjectBaseTo((PutObjectRequest) super.clone());
    }

    public PutObjectRequest withStorageClass(StorageClass storageClass) {
        return (PutObjectRequest) super.withStorageClass(storageClass);
    }
}
