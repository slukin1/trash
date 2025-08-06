package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompleteMultipartUploadRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private boolean isRequesterPays;
    private String key;
    private List<PartETag> partETags = new ArrayList();
    private String uploadId;

    public CompleteMultipartUploadRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public List<PartETag> getPartETags() {
        return this.partETags;
    }

    public String getUploadId() {
        return this.uploadId;
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

    public void setPartETags(List<PartETag> list) {
        this.partETags = list;
    }

    public void setRequesterPays(boolean z11) {
        this.isRequesterPays = z11;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public CompleteMultipartUploadRequest withBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public CompleteMultipartUploadRequest withKey(String str) {
        this.key = str;
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(List<PartETag> list) {
        setPartETags(list);
        return this;
    }

    public CompleteMultipartUploadRequest withRequesterPays(boolean z11) {
        setRequesterPays(z11);
        return this;
    }

    public CompleteMultipartUploadRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }

    public CompleteMultipartUploadRequest withPartETags(UploadPartResult... uploadPartResultArr) {
        for (UploadPartResult uploadPartResult : uploadPartResultArr) {
            this.partETags.add(new PartETag(uploadPartResult.getPartNumber(), uploadPartResult.getETag()));
        }
        return this;
    }

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        this.bucketName = str;
        this.key = str2;
        this.uploadId = str3;
        this.partETags = list;
    }

    public CompleteMultipartUploadRequest withPartETags(Collection<UploadPartResult> collection) {
        for (UploadPartResult next : collection) {
            this.partETags.add(new PartETag(next.getPartNumber(), next.getETag()));
        }
        return this;
    }
}
