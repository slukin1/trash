package com.tencent.ugc.retriver;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.f;
import com.tencent.ugc.MediaExtractorWrapper;
import com.tencent.ugc.common.MediaExtractorBuilder;

public class FFmpegMediaRetriever {
    private static final String TAG = "FFmpegMediaRetriever";
    private final boolean mIsUseMediaExtractor;
    private VideoMetaData mMediaInfo;
    private String mPath;

    public FFmpegMediaRetriever() {
        this(true);
    }

    private VideoMetaData getMediaInfoFromMediaExtractor(String str) {
        MediaExtractorWrapper mediaExtractorWrapper = new MediaExtractorWrapper();
        if (!mediaExtractorWrapper.setDataSource(str)) {
            return null;
        }
        VideoMetaData videoMetaData = new VideoMetaData();
        videoMetaData.setWidth(mediaExtractorWrapper.getWidth());
        videoMetaData.setHeight(mediaExtractorWrapper.getHeight());
        videoMetaData.setVideoDuration(mediaExtractorWrapper.getVideoDuration());
        videoMetaData.setAudioDuration(mediaExtractorWrapper.getAudioDuration());
        videoMetaData.setFps((float) mediaExtractorWrapper.getVideoFrameRate());
        videoMetaData.setVideoMimeType(mediaExtractorWrapper.getVideoMimeType());
        videoMetaData.setChannels(mediaExtractorWrapper.getChannelCount());
        videoMetaData.setSampleRate(mediaExtractorWrapper.getSampleRate());
        videoMetaData.setAudioBitrate((long) mediaExtractorWrapper.getAudioBitrate());
        videoMetaData.setVideoBitrate((long) mediaExtractorWrapper.getVideoBitrate());
        mediaExtractorWrapper.release();
        return videoMetaData;
    }

    private static native VideoMetaData nativeGetMediaInfo(String str);

    public long getAudioBitrate() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getAudioBitrate();
        }
        return 0;
    }

    public long getAudioDurationMs() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getAudioDuration() / 1000;
        }
        return 0;
    }

    public int getChannels() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getChannels();
        }
        return 0;
    }

    public float getFPS() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getFps();
        }
        return 0.0f;
    }

    public int getRotation() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getRotation();
        }
        return 0;
    }

    public int getSampleRate() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getSampleRate();
        }
        return 0;
    }

    public long getVideoBitrate() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getVideoBitrate();
        }
        return 0;
    }

    public long getVideoDurationMs() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getVideoDuration() / 1000;
        }
        return 0;
    }

    public int getVideoHeight() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getHeight();
        }
        return 0;
    }

    public String getVideoMimeType() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getVideoMimeType();
        }
        return null;
    }

    public int getVideoWidth() {
        VideoMetaData videoMetaData = this.mMediaInfo;
        if (videoMetaData != null) {
            return videoMetaData.getWidth();
        }
        return 0;
    }

    public int setDataSource(String str) {
        if (str == null) {
            LiteavLog.e(TAG, "path can't be null!");
            return -1;
        } else if (str.equals(this.mPath)) {
            return 0;
        } else {
            if (MediaExtractorBuilder.isContentUri(str) || f.a(str)) {
                this.mPath = str;
                this.mMediaInfo = nativeGetMediaInfo(str);
                LiteavLog.i(TAG, "nativeGetMediaInfo media info = " + this.mMediaInfo);
                if (this.mMediaInfo == null && this.mIsUseMediaExtractor) {
                    this.mMediaInfo = getMediaInfoFromMediaExtractor(this.mPath);
                }
                if (this.mMediaInfo == null) {
                    return -1;
                }
                return 0;
            }
            LiteavLog.e(TAG, "file isn't exists!");
            return -1;
        }
    }

    public FFmpegMediaRetriever(boolean z11) {
        this.mIsUseMediaExtractor = z11;
    }
}
