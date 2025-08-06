package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class InitiateMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private AccessControlList accessControlList;
    private String bucketName;
    private CannedAccessControlList cannedACL;
    private boolean isRequesterPays;
    private String key;
    public ObjectMetadata objectMetadata;
    private String redirectLocation;
    private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
    private SSECustomerKey sseCustomerKey;
    private StorageClass storageClass;
    private ObjectTagging tagging;

    public InitiateMultipartUploadRequest(String str, String str2) {
        this.bucketName = str;
        this.key = str2;
    }

    public AccessControlList getAccessControlList() {
        return this.accessControlList;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public CannedAccessControlList getCannedACL() {
        return this.cannedACL;
    }

    public String getKey() {
        return this.key;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public SSEAwsKeyManagementParams getSSEAwsKeyManagementParams() {
        return this.sseAwsKeyManagementParams;
    }

    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public StorageClass getStorageClass() {
        return this.storageClass;
    }

    public ObjectTagging getTagging() {
        return this.tagging;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setAccessControlList(AccessControlList accessControlList2) {
        this.accessControlList = accessControlList2;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCannedACL(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public void setRequesterPays(boolean z11) {
        this.isRequesterPays = z11;
    }

    public void setSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        if (sSEAwsKeyManagementParams == null || this.sseCustomerKey == null) {
            this.sseAwsKeyManagementParams = sSEAwsKeyManagementParams;
            return;
        }
        throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        if (sSECustomerKey == null || this.sseAwsKeyManagementParams == null) {
            this.sseCustomerKey = sSECustomerKey;
            return;
        }
        throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }

    public void setStorageClass(StorageClass storageClass2) {
        this.storageClass = storageClass2;
    }

    public void setTagging(ObjectTagging objectTagging) {
        this.tagging = objectTagging;
    }

    public InitiateMultipartUploadRequest withAccessControlList(AccessControlList accessControlList2) {
        setAccessControlList(accessControlList2);
        return this;
    }

    public InitiateMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public InitiateMultipartUploadRequest withCannedACL(CannedAccessControlList cannedAccessControlList) {
        this.cannedACL = cannedAccessControlList;
        return this;
    }

    public InitiateMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public InitiateMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public InitiateMultipartUploadRequest withRedirectLocation(String str) {
        this.redirectLocation = str;
        return this;
    }

    public InitiateMultipartUploadRequest withRequesterPays(boolean z11) {
        setRequesterPays(z11);
        return this;
    }

    public InitiateMultipartUploadRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sSEAwsKeyManagementParams) {
        setSSEAwsKeyManagementParams(sSEAwsKeyManagementParams);
        return this;
    }

    public InitiateMultipartUploadRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public InitiateMultipartUploadRequest withStorageClass(StorageClass storageClass2) {
        this.storageClass = storageClass2;
        return this;
    }

    public InitiateMultipartUploadRequest withTagging(ObjectTagging objectTagging) {
        setTagging(objectTagging);
        return this;
    }

    public InitiateMultipartUploadRequest withStorageClass(String str) {
        if (str != null) {
            this.storageClass = StorageClass.fromValue(str);
        } else {
            this.storageClass = null;
        }
        return this;
    }

    public InitiateMultipartUploadRequest(String str, String str2, ObjectMetadata objectMetadata2) {
        this.bucketName = str;
        this.key = str2;
        this.objectMetadata = objectMetadata2;
    }
}
