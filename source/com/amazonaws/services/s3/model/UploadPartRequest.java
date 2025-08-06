package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.event.ProgressListener;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

public class UploadPartRequest extends AmazonWebServiceRequest implements S3DataSource, Serializable {
    private static final long serialVersionUID = 1;
    private String bucketName;
    private File file;
    private long fileOffset;

    /* renamed from: id  reason: collision with root package name */
    private int f15352id;
    private transient InputStream inputStream;
    private boolean isLastPart;
    private boolean isRequesterPays;
    private String key;
    private int mainUploadId;
    private String md5Digest;
    private ObjectMetadata objectMetadata;
    private int partNumber;
    private long partSize;
    private SSECustomerKey sseCustomerKey;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public File getFile() {
        return this.file;
    }

    public long getFileOffset() {
        return this.fileOffset;
    }

    public int getId() {
        return this.f15352id;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public String getKey() {
        return this.key;
    }

    public int getMainUploadId() {
        return this.mainUploadId;
    }

    public String getMd5Digest() {
        return this.md5Digest;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.objectMetadata;
    }

    public int getPartNumber() {
        return this.partNumber;
    }

    public long getPartSize() {
        return this.partSize;
    }

    @Deprecated
    public ProgressListener getProgressListener() {
        ProgressListener generalProgressListener = getGeneralProgressListener();
        if (generalProgressListener instanceof LegacyS3ProgressListener) {
            return ((LegacyS3ProgressListener) generalProgressListener).c();
        }
        return null;
    }

    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public boolean isLastPart() {
        return this.isLastPart;
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setFile(File file2) {
        this.file = file2;
    }

    public void setFileOffset(long j11) {
        this.fileOffset = j11;
    }

    public void setId(int i11) {
        this.f15352id = i11;
    }

    public void setInputStream(InputStream inputStream2) {
        this.inputStream = inputStream2;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastPart(boolean z11) {
        this.isLastPart = z11;
    }

    public void setMainUploadId(int i11) {
        this.mainUploadId = i11;
    }

    public void setMd5Digest(String str) {
        this.md5Digest = str;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata2) {
        this.objectMetadata = objectMetadata2;
    }

    public void setPartNumber(int i11) {
        this.partNumber = i11;
    }

    public void setPartSize(long j11) {
        this.partSize = j11;
    }

    @Deprecated
    public void setProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    public void setRequesterPays(boolean z11) {
        this.isRequesterPays = z11;
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sseCustomerKey = sSECustomerKey;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public UploadPartRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public UploadPartRequest withFile(File file2) {
        setFile(file2);
        return this;
    }

    public UploadPartRequest withFileOffset(long j11) {
        setFileOffset(j11);
        return this;
    }

    public UploadPartRequest withId(int i11) {
        this.f15352id = i11;
        return this;
    }

    public UploadPartRequest withInputStream(InputStream inputStream2) {
        setInputStream(inputStream2);
        return this;
    }

    public UploadPartRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public UploadPartRequest withLastPart(boolean z11) {
        setLastPart(z11);
        return this;
    }

    public UploadPartRequest withMD5Digest(String str) {
        this.md5Digest = str;
        return this;
    }

    public UploadPartRequest withMainUploadId(int i11) {
        this.mainUploadId = i11;
        return this;
    }

    public UploadPartRequest withObjectMetadata(ObjectMetadata objectMetadata2) {
        setObjectMetadata(objectMetadata2);
        return this;
    }

    public UploadPartRequest withPartNumber(int i11) {
        this.partNumber = i11;
        return this;
    }

    public UploadPartRequest withPartSize(long j11) {
        this.partSize = j11;
        return this;
    }

    @Deprecated
    public UploadPartRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public UploadPartRequest withRequesterPays(boolean z11) {
        setRequesterPays(z11);
        return this;
    }

    public UploadPartRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public UploadPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }
}
