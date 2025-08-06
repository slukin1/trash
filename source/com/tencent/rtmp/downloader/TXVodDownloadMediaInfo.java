package com.tencent.rtmp.downloader;

import com.tencent.liteav.txcvodplayer.b.d;
import com.tencent.rtmp.TXPlayerDrmBuilder;
import com.tencent.rtmp.downloader.a.a;

public class TXVodDownloadMediaInfo {
    public static final int STATE_ERROR = 3;
    public static final int STATE_FINISH = 4;
    public static final int STATE_INIT = 0;
    public static final int STATE_START = 1;
    public static final int STATE_STOP = 2;
    public a dataSource;
    public int downloadSegments;
    @Deprecated
    public int downloadSize;
    public int downloadState = 0;
    public TXPlayerDrmBuilder drmBuilder;
    public int duration;
    public boolean isResourceBroken = false;
    @Deprecated
    public d netApi;
    public String playPath;
    public int playableDuration;
    public long playableSize;
    public long preferredResolution = 921600;
    public float progress;
    public int segments;
    @Deprecated
    public int size;
    public int speed;
    public int tid = -1;
    public long totalSize;
    public String url;
    public String userName = "default";

    public TXVodDownloadDataSource getDataSource() {
        return this.dataSource;
    }

    public long getDownloadSize() {
        if (this.playableSize != 0 || this.totalSize <= 0 || getProgress() <= 0.0f) {
            return Math.min(this.playableSize, this.totalSize);
        }
        return Math.min((long) (((float) this.totalSize) * getProgress()), this.totalSize);
    }

    public int getDownloadState() {
        return this.downloadState;
    }

    public TXPlayerDrmBuilder getDrmBuilder() {
        return this.drmBuilder;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getPlayPath() {
        return this.playPath;
    }

    public int getPlayableDuration() {
        if (this.playableDuration != 0 || this.duration <= 0 || getProgress() <= 0.0f) {
            return this.playableDuration;
        }
        return Math.min((int) (((float) this.duration) * getProgress()), this.duration);
    }

    public long getPreferredResolution() {
        return this.preferredResolution;
    }

    public float getProgress() {
        float f11;
        int i11;
        int i12;
        int i13 = this.playableDuration;
        if (i13 <= 0 || (i12 = this.duration) <= 0) {
            long j11 = this.playableSize;
            if (j11 > 0) {
                long j12 = this.totalSize;
                if (j12 > 0) {
                    f11 = Math.min(((float) j11) / ((float) j12), 1.0f);
                }
            }
            f11 = 0.0f;
        } else {
            f11 = Math.min(((float) i13) / ((float) i12), 1.0f);
        }
        int i14 = this.downloadSegments;
        if (i14 > 0 && (i11 = this.segments) > 0) {
            f11 = Math.min(((float) i14) / ((float) i11), 1.0f);
        }
        float f12 = this.progress;
        return f12 > 0.0f ? Math.max(f11, f12) : f11;
    }

    public long getSize() {
        return this.totalSize;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getTaskId() {
        return this.tid;
    }

    public String getUrl() {
        return this.url;
    }

    public String getUserName() {
        a aVar = this.dataSource;
        if (aVar != null) {
            return aVar.getUserName();
        }
        return this.userName;
    }

    public boolean isDownloadFinished() {
        return this.downloadState == 4;
    }

    public boolean isResourceBroken() {
        return this.isResourceBroken;
    }
}
