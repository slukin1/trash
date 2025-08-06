package com.google.zxing.pdf417;

public final class PDF417ResultMetadata {
    private String addressee;
    private int checksum = -1;
    private String fileId;
    private String fileName;
    private long fileSize = -1;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentCount = -1;
    private int segmentIndex;
    private String sender;
    private long timestamp = -1;

    public String getAddressee() {
        return this.addressee;
    }

    public int getChecksum() {
        return this.checksum;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    @Deprecated
    public int[] getOptionalData() {
        return this.optionalData;
    }

    public int getSegmentCount() {
        return this.segmentCount;
    }

    public int getSegmentIndex() {
        return this.segmentIndex;
    }

    public String getSender() {
        return this.sender;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isLastSegment() {
        return this.lastSegment;
    }

    public void setAddressee(String str) {
        this.addressee = str;
    }

    public void setChecksum(int i11) {
        this.checksum = i11;
    }

    public void setFileId(String str) {
        this.fileId = str;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(long j11) {
        this.fileSize = j11;
    }

    public void setLastSegment(boolean z11) {
        this.lastSegment = z11;
    }

    @Deprecated
    public void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    public void setSegmentCount(int i11) {
        this.segmentCount = i11;
    }

    public void setSegmentIndex(int i11) {
        this.segmentIndex = i11;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public void setTimestamp(long j11) {
        this.timestamp = j11;
    }
}
