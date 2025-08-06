package com.amazonaws.services.s3.model;

import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class S3Object implements Closeable, Serializable, S3RequesterChargedResult {
    private String bucketName = null;
    private boolean isRequesterCharged;
    private String key = null;
    private ObjectMetadata metadata = new ObjectMetadata();
    private transient S3ObjectInputStream objectContent;
    private String redirectLocation;
    private Integer taggingCount;

    public void close() throws IOException {
        if (getObjectContent() != null) {
            getObjectContent().close();
        }
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public S3ObjectInputStream getObjectContent() {
        return this.objectContent;
    }

    public ObjectMetadata getObjectMetadata() {
        return this.metadata;
    }

    public String getRedirectLocation() {
        return this.redirectLocation;
    }

    public Integer getTaggingCount() {
        return this.taggingCount;
    }

    public boolean isRequesterCharged() {
        return this.isRequesterCharged;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setObjectContent(S3ObjectInputStream s3ObjectInputStream) {
        this.objectContent = s3ObjectInputStream;
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setRedirectLocation(String str) {
        this.redirectLocation = str;
    }

    public void setRequesterCharged(boolean z11) {
        this.isRequesterCharged = z11;
    }

    public void setTaggingCount(Integer num) {
        this.taggingCount = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S3Object [key=");
        sb2.append(getKey());
        sb2.append(",bucket=");
        String str = this.bucketName;
        if (str == null) {
            str = "<Unknown>";
        }
        sb2.append(str);
        sb2.append("]");
        return sb2.toString();
    }

    public void setObjectContent(InputStream inputStream) {
        setObjectContent(new S3ObjectInputStream(inputStream));
    }
}
