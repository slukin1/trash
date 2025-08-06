package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyPartRequest extends AmazonWebServiceRequest implements Serializable, S3AccelerateUnsupported {
    private String destinationBucketName;
    private String destinationKey;
    private SSECustomerKey destinationSSECustomerKey;
    private Long firstByte;
    private Long lastByte;
    private final List<String> matchingETagConstraints = new ArrayList();
    private Date modifiedSinceConstraint;
    private final List<String> nonmatchingEtagConstraints = new ArrayList();
    private int partNumber;
    private String sourceBucketName;
    private String sourceKey;
    private SSECustomerKey sourceSSECustomerKey;
    private String sourceVersionId;
    private Date unmodifiedSinceConstraint;
    private String uploadId;

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public SSECustomerKey getDestinationSSECustomerKey() {
        return this.destinationSSECustomerKey;
    }

    public Long getFirstByte() {
        return this.firstByte;
    }

    public Long getLastByte() {
        return this.lastByte;
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

    public int getPartNumber() {
        return this.partNumber;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public SSECustomerKey getSourceSSECustomerKey() {
        return this.sourceSSECustomerKey;
    }

    public String getSourceVersionId() {
        return this.sourceVersionId;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
    }

    public void setDestinationSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.destinationSSECustomerKey = sSECustomerKey;
    }

    public void setFirstByte(Long l11) {
        this.firstByte = l11;
    }

    public void setLastByte(Long l11) {
        this.lastByte = l11;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints.clear();
        this.matchingETagConstraints.addAll(list);
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints.clear();
        this.nonmatchingEtagConstraints.addAll(list);
    }

    public void setPartNumber(int i11) {
        this.partNumber = i11;
    }

    public void setSourceBucketName(String str) {
        this.sourceBucketName = str;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public void setSourceSSECustomerKey(SSECustomerKey sSECustomerKey) {
        this.sourceSSECustomerKey = sSECustomerKey;
    }

    public void setSourceVersionId(String str) {
        this.sourceVersionId = str;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }

    public CopyPartRequest withDestinationBucketName(String str) {
        setDestinationBucketName(str);
        return this;
    }

    public CopyPartRequest withDestinationKey(String str) {
        setDestinationKey(str);
        return this;
    }

    public CopyPartRequest withDestinationSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setDestinationSSECustomerKey(sSECustomerKey);
        return this;
    }

    public CopyPartRequest withFirstByte(Long l11) {
        this.firstByte = l11;
        return this;
    }

    public CopyPartRequest withLastByte(Long l11) {
        this.lastByte = l11;
        return this;
    }

    public CopyPartRequest withMatchingETagConstraint(String str) {
        this.matchingETagConstraints.add(str);
        return this;
    }

    public CopyPartRequest withMatchingETagConstraints(List<String> list) {
        setMatchingETagConstraints(list);
        return this;
    }

    public CopyPartRequest withModifiedSinceConstraint(Date date) {
        setModifiedSinceConstraint(date);
        return this;
    }

    public CopyPartRequest withNonmatchingETagConstraint(String str) {
        this.nonmatchingEtagConstraints.add(str);
        return this;
    }

    public CopyPartRequest withNonmatchingETagConstraints(List<String> list) {
        setNonmatchingETagConstraints(list);
        return this;
    }

    public CopyPartRequest withPartNumber(int i11) {
        this.partNumber = i11;
        return this;
    }

    public CopyPartRequest withSourceBucketName(String str) {
        this.sourceBucketName = str;
        return this;
    }

    public CopyPartRequest withSourceKey(String str) {
        this.sourceKey = str;
        return this;
    }

    public CopyPartRequest withSourceSSECustomerKey(SSECustomerKey sSECustomerKey) {
        setSourceSSECustomerKey(sSECustomerKey);
        return this;
    }

    public CopyPartRequest withSourceVersionId(String str) {
        this.sourceVersionId = str;
        return this;
    }

    public CopyPartRequest withUnmodifiedSinceConstraint(Date date) {
        setUnmodifiedSinceConstraint(date);
        return this;
    }

    public CopyPartRequest withUploadId(String str) {
        this.uploadId = str;
        return this;
    }
}
