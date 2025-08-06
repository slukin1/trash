package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.event.ProgressListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetObjectRequest extends AmazonWebServiceRequest implements Serializable {
    private ProgressListener generalProgressListener;
    private boolean isRequesterPays;
    private List<String> matchingETagConstraints;
    private Date modifiedSinceConstraint;
    private List<String> nonmatchingEtagConstraints;
    private Integer partNumber;
    private long[] range;
    private ResponseHeaderOverrides responseHeaders;
    private S3ObjectIdBuilder s3ObjectIdBuilder;
    private SSECustomerKey sseCustomerKey;
    private Date unmodifiedSinceConstraint;

    public GetObjectRequest(String str, String str2) {
        this(str, str2, (String) null);
    }

    public String getBucketName() {
        return this.s3ObjectIdBuilder.getBucket();
    }

    public ProgressListener getGeneralProgressListener() {
        return this.generalProgressListener;
    }

    public String getKey() {
        return this.s3ObjectIdBuilder.getKey();
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public List<String> getNonmatchingETagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public Integer getPartNumber() {
        return this.partNumber;
    }

    @Deprecated
    public ProgressListener getProgressListener() {
        ProgressListener progressListener = this.generalProgressListener;
        if (progressListener instanceof LegacyS3ProgressListener) {
            return ((LegacyS3ProgressListener) progressListener).c();
        }
        return null;
    }

    public long[] getRange() {
        long[] jArr = this.range;
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public ResponseHeaderOverrides getResponseHeaders() {
        return this.responseHeaders;
    }

    public S3ObjectId getS3ObjectId() {
        return this.s3ObjectIdBuilder.build();
    }

    public SSECustomerKey getSSECustomerKey() {
        return this.sseCustomerKey;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public String getVersionId() {
        return this.s3ObjectIdBuilder.getVersionId();
    }

    public boolean isRequesterPays() {
        return this.isRequesterPays;
    }

    public void setBucketName(String str) {
        this.s3ObjectIdBuilder.setBucket(str);
    }

    public void setGeneralProgressListener(ProgressListener progressListener) {
        this.generalProgressListener = progressListener;
    }

    public void setKey(String str) {
        this.s3ObjectIdBuilder.setKey(str);
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints = list;
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints = list;
    }

    public void setPartNumber(Integer num) {
        this.partNumber = num;
    }

    @Deprecated
    public void setProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
    }

    public void setRange(long j11, long j12) {
        this.range = new long[]{j11, j12};
    }

    public void setRequesterPays(boolean z11) {
        this.isRequesterPays = z11;
    }

    public void setResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        this.responseHeaders = responseHeaderOverrides;
    }

    public void setS3ObjectId(S3ObjectId s3ObjectId) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder(s3ObjectId);
    }

    public void setSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sseCustomerKey = sSECustomerKey;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public void setVersionId(String str) {
        this.s3ObjectIdBuilder.setVersionId(str);
    }

    public GetObjectRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public GetObjectRequest withKey(String str) {
        setKey(str);
        return this;
    }

    public GetObjectRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public GetObjectRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public GetObjectRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public GetObjectRequest withPartNumber(Integer num) {
        setPartNumber(num);
        return this;
    }

    @Deprecated
    public GetObjectRequest withProgressListener(ProgressListener progressListener) {
        setProgressListener(progressListener);
        return this;
    }

    public GetObjectRequest withRange(long j11, long j12) {
        setRange(j11, j12);
        return this;
    }

    public GetObjectRequest withRequesterPays(boolean z11) {
        setRequesterPays(z11);
        return this;
    }

    public GetObjectRequest withResponseHeaders(ResponseHeaderOverrides responseHeaderOverrides) {
        setResponseHeaders(responseHeaderOverrides);
        return this;
    }

    public GetObjectRequest withS3ObjectId(S3ObjectId s3ObjectId) {
        setS3ObjectId(s3ObjectId);
        return this;
    }

    public GetObjectRequest withSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSSECustomerKey(sSECustomerKey);
        return this;
    }

    public GetObjectRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public GetObjectRequest withVersionId(String str) {
        setVersionId(str);
        return this;
    }

    public GetObjectRequest(String str, String str2, String str3) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        setBucketName(str);
        setKey(str2);
        setVersionId(str3);
    }

    public void setRange(long j11) {
        setRange(j11, 9223372036854775806L);
    }

    public GetObjectRequest withGeneralProgressListener(ProgressListener progressListener) {
        setGeneralProgressListener(progressListener);
        return this;
    }

    public GetObjectRequest withRange(long j11) {
        setRange(j11);
        return this;
    }

    public GetObjectRequest(S3ObjectId s3ObjectId) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder(s3ObjectId);
    }

    public GetObjectRequest(String str, String str2, boolean z11) {
        this.s3ObjectIdBuilder = new S3ObjectIdBuilder();
        this.matchingETagConstraints = new ArrayList();
        this.nonmatchingEtagConstraints = new ArrayList();
        this.s3ObjectIdBuilder.withBucket(str).withKey(str2);
        this.isRequesterPays = z11;
    }
}
