package com.tencent.ugc;

import com.tencent.ugc.videobase.common.EncodedVideoFrame;

public class VideoDemuxerSystem implements VideoDemuxer {
    public MediaExtractorWrapper mMediaExtractorWrapper;

    public void close() {
        MediaExtractorWrapper mediaExtractorWrapper = this.mMediaExtractorWrapper;
        if (mediaExtractorWrapper != null) {
            mediaExtractorWrapper.release();
        }
        this.mMediaExtractorWrapper = null;
    }

    public EncodedVideoFrame getNextEncodeVideoFrame() {
        MediaExtractorWrapper mediaExtractorWrapper = this.mMediaExtractorWrapper;
        if (mediaExtractorWrapper != null) {
            return mediaExtractorWrapper.readVideoSampleData();
        }
        return VideoDemuxer.END_OF_STREAM;
    }

    public boolean open(String str) {
        MediaExtractorWrapper mediaExtractorWrapper = new MediaExtractorWrapper();
        this.mMediaExtractorWrapper = mediaExtractorWrapper;
        return mediaExtractorWrapper.setDataSource(str);
    }

    public boolean seek(long j11) {
        MediaExtractorWrapper mediaExtractorWrapper = this.mMediaExtractorWrapper;
        if (mediaExtractorWrapper == null) {
            return true;
        }
        mediaExtractorWrapper.seekVideo(j11);
        return true;
    }
}
