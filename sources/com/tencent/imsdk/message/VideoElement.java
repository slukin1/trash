package com.tencent.imsdk.message;

public class VideoElement extends MessageBaseElement {
    private String snapshotDownloadUrl;
    private String snapshotFilePath;
    private int snapshotFileSize;
    private int snapshotHeight;
    private String snapshotType;
    private String snapshotUUID;
    private int snapshotWidth;
    private int videoBusinessID;
    private String videoDownloadUrl;
    private int videoDuration;
    private String videoFilePath;
    private int videoFileSize;
    private String videoType;
    private String videoUUID;

    public VideoElement() {
        setElementType(5);
    }

    public String getSnapshotDownloadUrl() {
        return this.snapshotDownloadUrl;
    }

    public String getSnapshotFilePath() {
        return this.snapshotFilePath;
    }

    public int getSnapshotFileSize() {
        return this.snapshotFileSize;
    }

    public int getSnapshotHeight() {
        return this.snapshotHeight;
    }

    public String getSnapshotType() {
        return this.snapshotType;
    }

    public String getSnapshotUUID() {
        return this.snapshotUUID;
    }

    public int getSnapshotWidth() {
        return this.snapshotWidth;
    }

    public int getVideoBusinessID() {
        return this.videoBusinessID;
    }

    public String getVideoDownloadUrl() {
        return this.videoDownloadUrl;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public String getVideoFilePath() {
        return this.videoFilePath;
    }

    public int getVideoFileSize() {
        return this.videoFileSize;
    }

    public String getVideoType() {
        return this.videoType;
    }

    public String getVideoUUID() {
        return this.videoUUID;
    }

    public void setSnapshotFilePath(String str) {
        this.snapshotFilePath = str;
    }

    public void setVideoDuration(int i11) {
        this.videoDuration = i11;
    }

    public void setVideoFilePath(String str) {
        this.videoFilePath = str;
    }

    public void setVideoType(String str) {
        this.videoType = str;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        if (this.elementType != messageBaseElement.elementType) {
            return false;
        }
        VideoElement videoElement = (VideoElement) messageBaseElement;
        if (!this.videoFilePath.equals(videoElement.videoFilePath) || !this.snapshotFilePath.equals(videoElement.snapshotFilePath)) {
            return false;
        }
        this.videoUUID = videoElement.videoUUID;
        this.videoType = videoElement.videoType;
        this.videoFileSize = videoElement.videoFileSize;
        this.videoDuration = videoElement.videoDuration;
        this.videoDownloadUrl = videoElement.videoDownloadUrl;
        this.videoBusinessID = videoElement.videoBusinessID;
        this.snapshotUUID = videoElement.snapshotUUID;
        this.snapshotType = videoElement.snapshotType;
        this.snapshotFileSize = videoElement.snapshotFileSize;
        this.snapshotWidth = videoElement.snapshotWidth;
        this.snapshotHeight = videoElement.snapshotHeight;
        this.snapshotDownloadUrl = videoElement.snapshotDownloadUrl;
        return true;
    }
}
