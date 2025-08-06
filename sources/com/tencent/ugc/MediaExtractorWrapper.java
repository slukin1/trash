package com.tencent.ugc;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.liteav.base.Log;
import com.tencent.ugc.common.MediaExtractorBuilder;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.common.VideoFrameType;
import java.nio.ByteBuffer;

public class MediaExtractorWrapper {
    private static final int INIT_SAMPLE_SIZE = 1048576;
    private static final int MAX_SAMPLE_SIZE = 10485760;
    private static final String TAG = "MediaExtractorWrapper";
    private MediaExtractor mAudioExtractor;
    private MediaFormat mAudioFormat;
    private boolean mIsReachEOF = false;
    private ByteBuffer mVideoBuffer;
    private MediaExtractor mVideoExtractor;
    private MediaFormat mVideoFormat;

    private int getIntegerFormatValue(MediaFormat mediaFormat, String str) {
        if (mediaFormat == null) {
            return 0;
        }
        try {
            return mediaFormat.getInteger(str);
        } catch (Exception e11) {
            Log.e(TAG, "getFormatValue key = " + str + " Exception e = " + e11, new Object[0]);
            return 0;
        }
    }

    private long getLongFormatValue(MediaFormat mediaFormat, String str) {
        if (mediaFormat == null) {
            return 0;
        }
        try {
            return mediaFormat.getLong(str);
        } catch (Exception e11) {
            Log.e(TAG, "getFormatValue key = " + str + " Exception e = " + e11, new Object[0]);
            return 0;
        }
    }

    private String getStringFormatValue(MediaFormat mediaFormat, String str) {
        if (mediaFormat == null) {
            return null;
        }
        try {
            return mediaFormat.getString(str);
        } catch (Exception e11) {
            Log.e(TAG, "getFormatValue key = " + str + " Exception e = " + e11, new Object[0]);
            return null;
        }
    }

    private ByteBuffer readData(MediaExtractor mediaExtractor) {
        if (this.mVideoBuffer == null) {
            this.mVideoBuffer = ByteBuffer.allocateDirect(1048576);
        }
        int i11 = 0;
        while (i11 == 0) {
            try {
                i11 = mediaExtractor.readSampleData(this.mVideoBuffer, 0);
            } catch (IllegalArgumentException unused) {
                if (this.mVideoBuffer.capacity() > MAX_SAMPLE_SIZE) {
                    break;
                }
                this.mVideoBuffer = ByteBuffer.allocateDirect(this.mVideoBuffer.capacity() * 2);
                Log.e(TAG, "resize sample buffer size to " + this.mVideoBuffer.capacity(), new Object[0]);
            }
        }
        if (i11 == 0) {
            return null;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i11);
        allocateDirect.put(this.mVideoBuffer);
        allocateDirect.position(0);
        this.mVideoBuffer.position(0);
        return allocateDirect;
    }

    private static MediaFormat selectFormat(MediaExtractor mediaExtractor, String str) {
        if (mediaExtractor == null) {
            return null;
        }
        int i11 = 0;
        while (i11 < mediaExtractor.getTrackCount()) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i11);
            String string = trackFormat.getString("mime");
            if (string == null || !string.startsWith(str)) {
                i11++;
            } else {
                Log.i(TAG, "selectFormat ".concat(String.valueOf(trackFormat)), new Object[0]);
                mediaExtractor.selectTrack(i11);
                return trackFormat;
            }
        }
        return null;
    }

    public int getAudioBitrate() {
        return getIntegerFormatValue(this.mAudioFormat, "bitrate");
    }

    public long getAudioDuration() {
        return getLongFormatValue(this.mAudioFormat, "durationUs");
    }

    public MediaFormat getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getChannelCount() {
        return getIntegerFormatValue(this.mAudioFormat, "channel-count");
    }

    public int getHeight() {
        return getIntegerFormatValue(this.mVideoFormat, "height");
    }

    public int getSampleRate() {
        return getIntegerFormatValue(this.mAudioFormat, "sample-rate");
    }

    public int getVideoBitrate() {
        return getIntegerFormatValue(this.mVideoFormat, "bitrate");
    }

    public long getVideoDuration() {
        return getLongFormatValue(this.mVideoFormat, "durationUs");
    }

    public MediaFormat getVideoFormat() {
        return this.mVideoFormat;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        return r3.mVideoFormat.getInteger("video-framerate");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        return 20;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getVideoFrameRate() {
        /*
            r3 = this;
            r0 = 20
            android.media.MediaFormat r1 = r3.mVideoFormat     // Catch:{ NullPointerException -> 0x000e }
            if (r1 != 0) goto L_0x0007
            return r0
        L_0x0007:
            java.lang.String r2 = "frame-rate"
            int r0 = r1.getInteger(r2)     // Catch:{ NullPointerException -> 0x000e }
            return r0
        L_0x000e:
            android.media.MediaFormat r1 = r3.mVideoFormat     // Catch:{ NullPointerException -> 0x0016 }
            java.lang.String r2 = "video-framerate"
            int r0 = r1.getInteger(r2)     // Catch:{ NullPointerException -> 0x0016 }
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.MediaExtractorWrapper.getVideoFrameRate():int");
    }

    public String getVideoMimeType() {
        return getStringFormatValue(this.mVideoFormat, "mime");
    }

    public int getWidth() {
        return getIntegerFormatValue(this.mVideoFormat, "width");
    }

    public EncodedVideoFrame readVideoSampleData() {
        MediaExtractor mediaExtractor = this.mVideoExtractor;
        if (mediaExtractor == null) {
            Log.v(TAG, "readVideoSampleData mVideoExtractor is null", new Object[0]);
            return VideoDemuxer.END_OF_STREAM;
        }
        long sampleTime = mediaExtractor.getSampleTime();
        if (sampleTime == -1 || this.mIsReachEOF) {
            Log.i(TAG, "readVideoSampleData end", new Object[0]);
            return VideoDemuxer.END_OF_STREAM;
        }
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        try {
            encodedVideoFrame.data = readData(this.mVideoExtractor);
            encodedVideoFrame.nalType = VideoFrameType.UNKNOWN;
            if ((this.mVideoExtractor.getSampleFlags() & 1) != 0) {
                encodedVideoFrame.nalType = VideoFrameType.IDR;
                encodedVideoFrame.videoFormat = this.mVideoFormat;
            }
            encodedVideoFrame.pts = sampleTime / 1000;
            encodedVideoFrame.width = getWidth();
            encodedVideoFrame.height = getHeight();
            this.mIsReachEOF = !this.mVideoExtractor.advance();
            return encodedVideoFrame;
        } catch (Exception e11) {
            Log.w(TAG, "read sample data failed.", e11);
            this.mIsReachEOF = true;
            return VideoDemuxer.END_OF_STREAM;
        }
    }

    public void release() {
        Log.i(TAG, "release", new Object[0]);
        MediaExtractor mediaExtractor = this.mVideoExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mVideoExtractor = null;
        }
        MediaExtractor mediaExtractor2 = this.mAudioExtractor;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
            this.mAudioExtractor = null;
        }
    }

    public void seekVideo(long j11) {
        if (this.mVideoExtractor != null) {
            Log.i(TAG, "seekVideo time = ".concat(String.valueOf(j11)), new Object[0]);
            this.mVideoExtractor.seekTo(j11, 0);
        }
    }

    public boolean setDataSource(String str) {
        Log.i(TAG, " setDataSource path: ".concat(String.valueOf(str)), new Object[0]);
        MediaExtractor mediaExtractor = this.mVideoExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
        MediaExtractor mediaExtractor2 = this.mAudioExtractor;
        if (mediaExtractor2 != null) {
            mediaExtractor2.release();
        }
        this.mVideoExtractor = new MediaExtractorBuilder().setPath(str).build();
        this.mAudioExtractor = new MediaExtractorBuilder().setPath(str).build();
        this.mVideoFormat = selectFormat(this.mVideoExtractor, "video");
        MediaFormat selectFormat = selectFormat(this.mAudioExtractor, "audio");
        this.mAudioFormat = selectFormat;
        if (this.mVideoFormat == null && selectFormat == null) {
            return false;
        }
        return true;
    }
}
