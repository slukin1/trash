package com.tencent.ugc.beauty.decoder;

import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.liteav.base.util.LiteavLog;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Extractor {
    private static final String TAG = "Extractor";
    private final ExtractorAdvancer mAdvancer;
    private AssetFileDescriptor mFileDescripter;
    private final String mFileName;
    private final boolean mIsVideo;
    private MediaExtractor mMediaExtractor;
    private MediaFormat mMediaFormat;
    private int mTrackIndex;

    public Extractor(boolean z11, String str, ExtractorAdvancer extractorAdvancer) {
        this.mIsVideo = z11;
        this.mAdvancer = extractorAdvancer;
        this.mFileName = str;
        this.mFileDescripter = null;
    }

    private void initMediaExtractor() throws SetupException {
        releaseMediaExtractor();
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            AssetFileDescriptor assetFileDescriptor = this.mFileDescripter;
            if (assetFileDescriptor != null) {
                mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), this.mFileDescripter.getStartOffset(), this.mFileDescripter.getLength());
            } else {
                mediaExtractor.setDataSource(this.mFileName);
            }
            int selectTrack = selectTrack(this.mMediaExtractor);
            this.mTrackIndex = selectTrack;
            if (selectTrack >= 0) {
                this.mMediaExtractor.selectTrack(selectTrack);
                this.mMediaFormat = this.mMediaExtractor.getTrackFormat(this.mTrackIndex);
                return;
            }
            throw new SetupException("No wanted track found");
        } catch (IOException e11) {
            throw new SetupException("updateExtractor extractor failed.", e11);
        }
    }

    private boolean isWantedMime(String str) {
        return str.startsWith(this.mIsVideo ? "video/" : "audio/");
    }

    private void releaseMediaExtractor() {
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mMediaExtractor = null;
        }
    }

    private int selectTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i11 = 0; i11 < trackCount; i11++) {
            if (isWantedMime(mediaExtractor.getTrackFormat(i11).getString("mime"))) {
                return i11;
            }
        }
        return -1;
    }

    public MediaFormat getMediaFormat() {
        return this.mMediaFormat;
    }

    public int getTraceIndex() {
        return this.mTrackIndex;
    }

    public MediaCodec.BufferInfo readSampleData(ByteBuffer byteBuffer) {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        this.mAdvancer.readSampleData(bufferInfo, byteBuffer, 0);
        if (bufferInfo.size < 0) {
            bufferInfo.size = 0;
            bufferInfo.flags |= 4;
            Object[] objArr = new Object[1];
            objArr[0] = this.mIsVideo ? "video" : "audio";
            LiteavLog.i(TAG, "[%s] meet end of stream", objArr);
        }
        this.mAdvancer.advance();
        return bufferInfo;
    }

    public void release() {
        releaseMediaExtractor();
        AssetFileDescriptor assetFileDescriptor = this.mFileDescripter;
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (IOException e11) {
                LiteavLog.e(TAG, "close file descriptor failed.", (Throwable) e11);
            }
            this.mFileDescripter = null;
        }
    }

    public void restart() throws SetupException {
        releaseMediaExtractor();
        initMediaExtractor();
        this.mAdvancer.updateExtractor(this.mMediaExtractor);
    }

    public void setup() throws SetupException {
        initMediaExtractor();
        this.mAdvancer.updateExtractor(this.mMediaExtractor);
    }

    public Extractor(boolean z11, AssetFileDescriptor assetFileDescriptor, ExtractorAdvancer extractorAdvancer) {
        this.mIsVideo = z11;
        this.mFileDescripter = assetFileDescriptor;
        this.mAdvancer = extractorAdvancer;
        this.mFileName = null;
    }
}
