package com.tencent.thumbplayer.tcmedia.api;

public class TPTrackInfo {
    public static final int TP_MEDIA_CONTAINER_TYPE_DASH = 2;
    public static final int TP_MEDIA_CONTAINER_TYPE_HLS = 1;
    public static final int TP_MEDIA_CONTAINER_TYPE_UNKNOWN = 0;
    public static final int TP_MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int TP_MEDIA_TRACK_TYPE_SUBTITLE = 3;
    public static final int TP_MEDIA_TRACK_TYPE_UNKNOW = 0;
    public static final int TP_MEDIA_TRACK_TYPE_VIDEO = 1;
    public int containerType = 0;
    public TPDashFormat dashFormat = new TPDashFormat();
    public TPHlsTag hlsTag = new TPHlsTag();
    public boolean isExclusive = true;
    public boolean isInternal = true;
    public boolean isSelected = false;
    public String language;
    public String name;
    public int trackType = 0;

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TPTrackInfo)) {
            TPTrackInfo tPTrackInfo = (TPTrackInfo) obj;
            return this.name.equals(tPTrackInfo.name) && this.trackType == tPTrackInfo.trackType;
        }
    }

    public TPDashFormat getDashFormat() {
        return this.dashFormat;
    }

    public TPHlsTag getHlsTag() {
        return this.hlsTag;
    }

    public String getName() {
        return this.name;
    }

    public int getTrackType() {
        return this.trackType;
    }
}
