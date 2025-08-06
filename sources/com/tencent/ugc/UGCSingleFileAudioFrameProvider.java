package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import com.tencent.ugc.AudioFrame;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCFrameQueue;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@JNINamespace("liteav::ugc")
public class UGCSingleFileAudioFrameProvider implements UGCAudioFrameProvider, UGCFrameQueue.UGCFrameQueueListener {
    private static final int DEFAULT_CHANNEL_COUNT = 2;
    private static final int DEFAULT_FRAME_DURATION = 20;
    private static final int DEFAULT_SAMPLE_RATE = 48000;
    private static final int MAX_FRAME_SIZE = 5;
    public static final String MUTE_VIRTUAL_FILE_PATH = "mute_virtual_file_path";
    private final String TAG = ("UGCAudioFileProvider_" + hashCode());
    private final UGCFrameQueue<List<AudioFrame>> mAudioFrameQueue;
    private final Clip mClip;
    private long mCurrentMuteFramePts = 0;
    private long mEndPlayPts = Long.MAX_VALUE;
    private long mFirstFramePtsOfAllStream = 0;
    private AudioFrame mLastFrame;
    private long mNativeHandle;
    private Long mSeekFileTime = 0L;
    private final CustomHandler mWorkHandler;

    public UGCSingleFileAudioFrameProvider(Clip clip, CustomHandler customHandler) {
        this.mClip = new Clip(clip);
        this.mAudioFrameQueue = new UGCFrameQueue<>();
        this.mWorkHandler = customHandler;
    }

    /* access modifiers changed from: private */
    public void DecodeOrAppendMuteFrame() {
        if (this.mAudioFrameQueue.size() < 5) {
            long j11 = this.mNativeHandle;
            if (j11 != 0) {
                nativeDecode(j11);
            } else {
                appendOneMuteFrame(this.mCurrentMuteFramePts, 20, 48000, 2);
                this.mCurrentMuteFramePts += 20;
            }
            this.mWorkHandler.removeCallbacks(fm.a(this));
            this.mWorkHandler.post(fn.a(this));
        }
    }

    private void appendMultipleMuteFrame(long j11, int i11, int i12, int i13) {
        if (i11 > 0 && i12 > 0 && i13 > 0) {
            int i14 = i11 / 20;
            for (int i15 = 0; i15 < i14; i15++) {
                appendOneMuteFrame(j11, 20, i12, i13);
                j11 += 20;
            }
            int i16 = i11 - (i14 * 20);
            if (i16 != 0) {
                appendOneMuteFrame(j11, i16, i12, i13);
            }
        }
    }

    private void appendMuteFrameWhenDecodeFinish() {
        AudioFrame audioFrame = this.mLastFrame;
        if (audioFrame != null) {
            long calculateAudioFrameDuration = calculateAudioFrameDuration(audioFrame) + timelineToFileTime(this.mLastFrame.getTimestamp());
            if (calculateAudioFrameDuration < this.mClip.endInFileTime) {
                appendMultipleMuteFrame(fileTimeToTimelineNoSpeed(calculateAudioFrameDuration), (int) (this.mClip.endInFileTime - calculateAudioFrameDuration), this.mLastFrame.getSampleRate(), this.mLastFrame.getChannelCount());
            }
        }
    }

    private void appendOneMuteFrame(long j11, int i11, int i12, int i13) {
        if (i11 > 0 && i12 > 0 && i13 > 0) {
            Clip clip = this.mClip;
            if (j11 >= clip.startInClipsTimeline + (clip.endInFileTime - clip.startInFileTime)) {
                putEndOfStreamFrameToQueue();
                return;
            }
            AudioFrame audioFrame = new AudioFrame();
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect((((i13 * 2) * i12) * i11) / 1000);
            Arrays.fill(allocateDirect.array(), (byte) 0);
            audioFrame.setData(allocateDirect);
            audioFrame.setChannelCount(i13);
            audioFrame.setSampleRate(i12);
            audioFrame.setCodecFormat(AudioFrame.AudioCodecFormat.PCM);
            audioFrame.setTimestamp(j11);
            this.mLastFrame = audioFrame;
            this.mAudioFrameQueue.queue(Collections.singletonList(audioFrame));
        }
    }

    private long calculateAudioFrameDuration(AudioFrame audioFrame) {
        if (audioFrame == null || !audioFrame.isValidFrame() || audioFrame.getCodecFormat() != AudioFrame.AudioCodecFormat.PCM) {
            return 0;
        }
        return (((long) audioFrame.getData().remaining()) * 1000) / ((((long) audioFrame.getChannelCount()) * 2) * ((long) audioFrame.getSampleRate()));
    }

    private long fileTimeToTimelineNoSpeed(long j11) {
        Clip clip = this.mClip;
        return clip.startTimelineNoSpeed + (j11 - clip.startInFileTime);
    }

    private ByteBuffer getByteBufferFromAudioFrame(AudioFrame audioFrame) {
        return audioFrame.getData();
    }

    private float getTimeMultipleInSpeed(int i11) {
        return UGCMediaListSource.getSpeed(i11);
    }

    public static /* synthetic */ void lambda$initialize$0(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        if (uGCSingleFileAudioFrameProvider.mClip.path.equals(MUTE_VIRTUAL_FILE_PATH)) {
            uGCSingleFileAudioFrameProvider.mNativeHandle = 0;
            return;
        }
        long nativeCreate = nativeCreate(uGCSingleFileAudioFrameProvider);
        uGCSingleFileAudioFrameProvider.mNativeHandle = nativeCreate;
        if (nativeCreate == 0) {
            LiteavLog.e(uGCSingleFileAudioFrameProvider.TAG, "create native instance failed.");
        }
    }

    public static /* synthetic */ void lambda$uninitialize$1(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        long j11 = uGCSingleFileAudioFrameProvider.mNativeHandle;
        if (j11 != 0) {
            nativeClose(j11);
            nativeDestroy(uGCSingleFileAudioFrameProvider.mNativeHandle);
            uGCSingleFileAudioFrameProvider.mNativeHandle = 0;
        }
        uGCSingleFileAudioFrameProvider.mAudioFrameQueue.clear();
    }

    private static native void nativeClose(long j11);

    private static native long nativeCreate(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider);

    private static native void nativeDecode(long j11);

    private static native void nativeDestroy(long j11);

    private static native long nativeGetDuration(long j11);

    private static native int nativeOpen(long j11, String str);

    private static native int nativeSeekTo(long j11, long j12);

    private AudioFrame obtainAudioFrame(int i11, int i12, long j11, int i13) {
        AudioFrame audioFrame = new AudioFrame();
        audioFrame.setSampleRate(i11);
        audioFrame.setChannelCount(i12);
        audioFrame.setTimestamp(j11);
        audioFrame.setCodecFormat(AudioFrame.AudioCodecFormat.PCM);
        audioFrame.setData(ByteBuffer.allocateDirect(i13));
        return audioFrame;
    }

    private void onDecodeEndOfFile() {
        LiteavLog.i(this.TAG, "onDecodeEndOfFile");
        appendMuteFrameWhenDecodeFinish();
        putEndOfStreamFrameToQueue();
    }

    private void onDecodeError(String str) {
        LiteavLog.i(this.TAG, "onDecodeError reason = ".concat(String.valueOf(str)));
        appendMuteFrameWhenDecodeFinish();
        putEndOfStreamFrameToQueue();
    }

    private void onDecodeFrame(AudioFrame audioFrame) {
        if (audioFrame != null) {
            long timestamp = audioFrame.getTimestamp() - this.mFirstFramePtsOfAllStream;
            if (timestamp >= this.mClip.startInFileTime) {
                Long l11 = this.mSeekFileTime;
                if (l11 != null) {
                    if (timestamp >= l11.longValue()) {
                        appendMultipleMuteFrame(fileTimeToTimelineNoSpeed(this.mSeekFileTime.longValue()), (int) (timestamp - this.mSeekFileTime.longValue()), audioFrame.getSampleRate(), audioFrame.getChannelCount());
                    } else {
                        return;
                    }
                }
                this.mSeekFileTime = null;
                if (timestamp > this.mClip.endInFileTime || timestamp > this.mEndPlayPts) {
                    LiteavLog.i(this.TAG, "decode frame pts is bigger than end time");
                    putEndOfStreamFrameToQueue();
                    return;
                }
                this.mLastFrame = audioFrame;
                audioFrame.setTimestamp(fileTimeToTimelineNoSpeed(timestamp));
                this.mAudioFrameQueue.queue(Collections.singletonList(audioFrame));
            }
        }
    }

    private void putEndOfStreamFrameToQueue() {
        this.mLastFrame = null;
        this.mAudioFrameQueue.queue(UGCAudioFrameProvider.END_OF_STREAM);
    }

    /* access modifiers changed from: private */
    public void seekToInFileTime(long j11) {
        Clip clip = this.mClip;
        this.mSeekFileTime = Long.valueOf(g.a(j11, clip.startInFileTime, clip.endInFileTime));
        String str = this.TAG;
        LiteavLog.i(str, "seekTo fileTime " + this.mSeekFileTime);
        this.mCurrentMuteFramePts = fileTimeToTimelineNoSpeed(this.mSeekFileTime.longValue());
        long j12 = this.mNativeHandle;
        if (!(j12 == 0 || nativeSeekTo(j12, this.mSeekFileTime.longValue()) == 0)) {
            LiteavLog.w(this.TAG, "nativeSeekTo fail");
        }
        this.mAudioFrameQueue.clear();
        this.mWorkHandler.runOrPost(fl.a(this));
    }

    /* access modifiers changed from: private */
    public void startInternal() {
        long j11 = this.mNativeHandle;
        if (!(j11 == 0 || nativeOpen(j11, this.mClip.path) == 0)) {
            LiteavLog.e(this.TAG, "native MusicResourceDecoderFFmpeg open failed.");
            nativeClose(this.mNativeHandle);
            nativeDestroy(this.mNativeHandle);
            this.mNativeHandle = 0;
        }
        VideoDemuxerFFmpeg videoDemuxerFFmpeg = new VideoDemuxerFFmpeg();
        if (videoDemuxerFFmpeg.open(this.mClip.path)) {
            this.mFirstFramePtsOfAllStream = videoDemuxerFFmpeg.getFirstFramePtsOfAllStream();
        }
        videoDemuxerFFmpeg.close();
        this.mCurrentMuteFramePts = this.mClip.startInClipsTimeline;
        this.mAudioFrameQueue.setUGCFrameQueueListener(this);
        this.mAudioFrameQueue.clear();
        this.mSeekFileTime = 0L;
        long j12 = this.mClip.startInFileTime;
        if (j12 != 0) {
            seekToInFileTime(j12);
        }
        DecodeOrAppendMuteFrame();
    }

    /* access modifiers changed from: private */
    public void stopInternal() {
        long j11 = this.mNativeHandle;
        if (j11 != 0) {
            nativeClose(j11);
        }
        this.mAudioFrameQueue.setUGCFrameQueueListener((UGCFrameQueue.UGCFrameQueueListener) null);
        this.mWorkHandler.removeCallbacks(fj.a(this));
        this.mAudioFrameQueue.clear();
        putEndOfStreamFrameToQueue();
    }

    private long timelineToFileTime(long j11) {
        Clip clip = this.mClip;
        List<TXVideoEditConstants.TXSpeed> list = clip.speedList;
        if (list == null) {
            return j11 + clip.startInFileTime;
        }
        long j12 = 0;
        for (TXVideoEditConstants.TXSpeed next : list) {
            float timeMultipleInSpeed = 1.0f / getTimeMultipleInSpeed(next.speedLevel);
            long j13 = next.endTime;
            long j14 = next.startTime;
            long j15 = (long) (((float) (j13 - j14)) * timeMultipleInSpeed);
            j12 = ((long) (((float) j11) / timeMultipleInSpeed)) + j14;
            if (j11 < j15) {
                break;
            }
            j11 -= j15;
        }
        return j12;
    }

    public UGCFrameQueue<List<AudioFrame>> getFrameQueue() {
        return this.mAudioFrameQueue;
    }

    public void initialize() {
        LiteavLog.i(this.TAG, "initialize");
        this.mWorkHandler.runOrPost(fe.a(this));
    }

    public void onFrameDequeued() {
        this.mWorkHandler.runOrPost(ff.a(this));
    }

    public void seekTo(long j11) {
        this.mWorkHandler.runAndWaitDone(fk.a(this, j11), 1000);
    }

    public void setPlayEndPts(long j11) {
        this.mEndPlayPts = j11;
    }

    public void start() {
        this.mWorkHandler.runOrPost(fh.a(this));
    }

    public void stop() {
        this.mWorkHandler.runOrPost(fi.a(this));
    }

    public void uninitialize() {
        this.mWorkHandler.runOrPost(fg.a(this));
    }
}
