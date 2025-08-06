package com.hbg.lib.iplayer.common.model;

import android.net.Uri;
import java.io.Serializable;

public class PlayItem implements Serializable {
    private static final long serialVersionUID = 1;
    private String displayName;
    private long duration;
    private PlayType playType = PlayType.LOCAL;
    private String playUrl;
    private int startPosition;
    private Uri uri;
    private int videoHeight;
    private int videoWidth;

    public enum PlayType {
        ONLINE,
        LOCAL
    }

    public PlayItem() {
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public long getDuration() {
        return this.duration;
    }

    public PlayType getPlayType() {
        return this.playType;
    }

    public String getPlayUrl() {
        return this.playUrl;
    }

    public int getStartPostion() {
        return this.startPosition;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDuration(long j11) {
        this.duration = j11;
    }

    public void setPlayType(PlayType playType2) {
        this.playType = playType2;
    }

    public void setPlayUrl(String str) {
        this.playUrl = str;
    }

    public void setStartPostion(int i11) {
        this.startPosition = i11;
    }

    public void setUri(Uri uri2) {
        this.uri = uri2;
    }

    public void setVideoHeight(int i11) {
        this.videoHeight = i11;
    }

    public void setVideoWidth(int i11) {
        this.videoWidth = i11;
    }

    public PlayItem(String str) {
        setPlayUrl(str);
    }

    public PlayItem(Uri uri2) {
        setUri(uri2);
    }
}
