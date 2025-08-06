package com.luck.picture.lib.entity;

public class MediaExtraInfo {
    private long duration;
    private int height;
    private String orientation;
    private String videoThumbnail;
    private int width;

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDuration(long j11) {
        this.duration = j11;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setVideoThumbnail(String str) {
        this.videoThumbnail = str;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }

    public String toString() {
        return "MediaExtraInfo{videoThumbnail='" + this.videoThumbnail + '\'' + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", orientation='" + this.orientation + '\'' + '}';
    }
}
