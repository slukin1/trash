package com.tencent.liteav.audio.musicdecoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.nio.ByteBuffer;

@JNINamespace("liteav::audio")
public class MusicResourceDecoderAndroid {
    private static final String TAG = "MusicResourceDecoderAndroid";
    private final MediaCodecBridge mDecoder = new MediaCodecBridge();
    private String mPath;
    private int mTrackIndex = 0;

    public ByteBuffer decode() {
        return this.mDecoder.processFrame();
    }

    public int getBitrate() {
        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
        if (outputFormat == null) {
            return -1;
        }
        try {
            return outputFormat.getInteger("bitrate");
        } catch (Throwable th2) {
            Log.e(TAG, "getBitrate failed. ".concat(String.valueOf(th2)), new Object[0]);
            return -1;
        }
    }

    public int getChannelCount() {
        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
        if (outputFormat == null) {
            return -1;
        }
        try {
            return outputFormat.getInteger("channel-count");
        } catch (Throwable th2) {
            Log.e(TAG, "getChannelCount failed. ".concat(String.valueOf(th2)), new Object[0]);
            return -1;
        }
    }

    public long getDuration() {
        return (this.mDecoder.getLongestDuration() + 500) / 1000;
    }

    public int getSampleRate() {
        MediaFormat outputFormat = this.mDecoder.getOutputFormat();
        if (outputFormat == null) {
            return -1;
        }
        try {
            return outputFormat.getInteger("sample-rate");
        } catch (Throwable th2) {
            Log.e(TAG, "getSampleRate failed. ".concat(String.valueOf(th2)), new Object[0]);
            return -1;
        }
    }

    public int getTotalRawDataSize() {
        return this.mDecoder.getTotalRawDataSize();
    }

    public int getTrackCount() {
        return this.mDecoder.getTrackCount();
    }

    public boolean isDecodeEnd() {
        return this.mDecoder.isDecodeEnd();
    }

    public boolean seekTo(long j11) {
        if (this.mDecoder.isDecodeEnd()) {
            this.mDecoder.stop();
            this.mDecoder.initAndStart(this.mPath);
            this.mDecoder.setMusicTrack(this.mTrackIndex);
        }
        return this.mDecoder.seekTo(j11 * 1000);
    }

    public void setMusicTrack(int i11) {
        this.mTrackIndex = i11;
        this.mDecoder.setMusicTrack(i11);
    }

    public boolean start(String str) {
        this.mPath = str;
        return this.mDecoder.initAndStart(str);
    }

    public void stop() {
        this.mDecoder.stop();
    }
}
