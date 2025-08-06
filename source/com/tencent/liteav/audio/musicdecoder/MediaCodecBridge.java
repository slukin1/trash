package com.tencent.liteav.audio.musicdecoder;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::audio")
public class MediaCodecBridge {
    private static final String TAG = "MediaCodecBridge";
    private static final long TIMEOUT_MS = 400;
    private boolean mDecodeEOS;
    private MediaFormat mFormat;
    private long mLongestDurationUs;
    private MediaCodec mMediaCodec;
    private MediaExtractor mMediaExtractor;
    private String mMime;
    private int mRawDataSize;
    private int mTrackCount;
    private int mTrackIndex;

    private ByteBuffer dequeueOutputBuffer() {
        ByteBuffer byteBuffer;
        if (this.mDecodeEOS) {
            return null;
        }
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(TIMEOUT_MS));
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            if (dequeueOutputBuffer == -3) {
                Log.i(TAG, "codec output buffers changed.", new Object[0]);
                return null;
            } else if (dequeueOutputBuffer == -2) {
                this.mFormat = this.mMediaCodec.getOutputFormat();
                Log.i(TAG, "codec output format changed: " + this.mFormat, new Object[0]);
                return null;
            } else if (dequeueOutputBuffer < 0) {
                Log.e(TAG, "unexpected result from dequeueOutputBuffer: ".concat(String.valueOf(dequeueOutputBuffer)), new Object[0]);
                return null;
            } else if ((bufferInfo.flags & 4) != 0) {
                Log.i(TAG, "Decode to EOS", new Object[0]);
                this.mDecodeEOS = true;
                return null;
            } else {
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                    byteBuffer = this.mMediaCodec.getOutputBuffer(dequeueOutputBuffer);
                } else {
                    byteBuffer = this.mMediaCodec.getOutputBuffers()[dequeueOutputBuffer];
                }
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
                allocateDirect.put(byteBuffer);
                this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                return allocateDirect;
            }
        } catch (Throwable th2) {
            Log.e(TAG, "Failed to dequeue output buffer", th2);
            return null;
        }
    }

    private ByteBuffer drainData() {
        for (int i11 = 0; i11 < 3; i11++) {
            ByteBuffer dequeueOutputBuffer = dequeueOutputBuffer();
            if (dequeueOutputBuffer != null) {
                return dequeueOutputBuffer;
            }
        }
        return null;
    }

    private long getDuration(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            return -1;
        }
        try {
            return mediaFormat.getLong("durationUs");
        } catch (Throwable th2) {
            Log.e(TAG, "getDuration failed. ".concat(String.valueOf(th2)), new Object[0]);
            return -1;
        }
    }

    private boolean initMediaCodec() {
        if (!TextUtils.isEmpty(this.mMime) && this.mFormat != null) {
            try {
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.mMime);
                this.mMediaCodec = createDecoderByType;
                createDecoderByType.configure(this.mFormat, (Surface) null, (MediaCrypto) null, 0);
                return true;
            } catch (Throwable th2) {
                th2.printStackTrace();
                this.mMediaCodec = null;
            }
        }
        return false;
    }

    private boolean initMediaExtractor(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.mDecodeEOS = false;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(str);
            this.mTrackCount = this.mMediaExtractor.getTrackCount();
            for (int i11 = 0; i11 < this.mTrackCount; i11++) {
                MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i11);
                String string = trackFormat.getString("mime");
                if (!TextUtils.isEmpty(string) && string.startsWith("audio/")) {
                    long duration = getDuration(trackFormat);
                    if (this.mLongestDurationUs < duration) {
                        this.mLongestDurationUs = duration;
                    }
                }
            }
            int i12 = this.mTrackIndex;
            if (i12 != 0) {
                return selectTrack(i12);
            }
            for (int i13 = 0; i13 < this.mTrackCount; i13++) {
                if (selectTrack(i13)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            Log.e(TAG, "initMediaExtractor: ", th2);
            this.mMediaExtractor = null;
            this.mFormat = null;
            this.mMime = null;
            return false;
        }
    }

    private boolean selectTrack(int i11) {
        MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(i11);
        String string = trackFormat.getString("mime");
        if (TextUtils.isEmpty(string) || !string.startsWith("audio/")) {
            return false;
        }
        this.mMediaExtractor.selectTrack(i11);
        this.mTrackIndex = i11;
        this.mFormat = trackFormat;
        this.mMime = string;
        return true;
    }

    public long getLongestDuration() {
        return this.mLongestDurationUs;
    }

    public MediaFormat getOutputFormat() {
        return this.mFormat;
    }

    public int getTotalRawDataSize() {
        return this.mRawDataSize;
    }

    public int getTrackCount() {
        return this.mTrackCount;
    }

    public boolean initAndStart(String str) {
        if (this.mMediaCodec != null || !initMediaExtractor(str) || !initMediaCodec()) {
            return false;
        }
        try {
            this.mMediaCodec.start();
            return true;
        } catch (Throwable th2) {
            Log.e(TAG, "Cannot start the audio codec", th2);
            return false;
        }
    }

    public boolean isDecodeEnd() {
        return this.mDecodeEOS;
    }

    public ByteBuffer processFrame() {
        int dequeueInputBuffer;
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(TIMEOUT_MS)) < 0) {
            return null;
        }
        ByteBuffer byteBuffer = this.mMediaCodec.getInputBuffers()[dequeueInputBuffer];
        int readSampleData = byteBuffer != null ? this.mMediaExtractor.readSampleData(byteBuffer, 0) : -1;
        if (readSampleData <= 0) {
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0, 4);
        } else {
            this.mRawDataSize += readSampleData;
            this.mMediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mMediaExtractor.getSampleTime(), 0);
            this.mMediaExtractor.advance();
        }
        return drainData();
    }

    public boolean seekTo(long j11) {
        MediaExtractor mediaExtractor;
        if (this.mMediaCodec == null || (mediaExtractor = this.mMediaExtractor) == null || j11 > this.mLongestDurationUs) {
            return false;
        }
        mediaExtractor.seekTo(j11, 2);
        return true;
    }

    public void setMusicTrack(int i11) {
        int i12 = this.mTrackIndex;
        if (i12 != i11) {
            this.mMediaExtractor.unselectTrack(i12);
            if (selectTrack(i11)) {
                MediaCodec mediaCodec = this.mMediaCodec;
                if (mediaCodec != null) {
                    mediaCodec.stop();
                    this.mMediaCodec.release();
                    this.mMediaCodec = null;
                }
                if (initMediaCodec()) {
                    try {
                        this.mMediaCodec.start();
                    } catch (Throwable th2) {
                        Log.e(TAG, "Cannot start the audio codec", th2);
                    }
                }
            }
        }
    }

    public void stop() {
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.mMediaExtractor = null;
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mMediaCodec.release();
            this.mMediaCodec = null;
        }
        this.mDecodeEOS = false;
    }
}
