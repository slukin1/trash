package com.tencent.ugc;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoJoiner;
import com.tencent.ugc.retriver.FFmpegMediaRetriever;
import com.tencent.ugc.videobase.frame.GLTexturePool;
import com.tencent.ugc.videobase.frame.PixelFrame;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class UGCMediaListSource {
    private static final int MAX_FRAME_SIZE = 5;
    private static final int READ_FRAME_TIME_OUT_MS = 5;
    public static final int SEEK_TIME_OUT = 1000;
    private final UGCFrameQueue<List<AudioFrame>> mAudioFrameListQueue = new UGCFrameQueue<>();
    private CustomHandler mAudioHandler;
    private long mAudioSeekTimeInClip = -1;
    private List<Bitmap> mBitmapList;
    private FutureTask<Long> mCalculateDurationTask;
    private final List<Clip> mClipList = new ArrayList();
    private final AtomicInteger mCountOfPendingResetInputData = new AtomicInteger();
    private int mCurrentAudioClipIndex = 0;
    private UGCAudioFrameProvider mCurrentAudioFrameProvider;
    private UGCPixelFrameProvider mCurrentPixelFrameProvider;
    private int mCurrentVideoClipIndex = 0;
    private TXVideoJoiner.DurationControlMode mDurationControlMode = TXVideoJoiner.DurationControlMode.ALIGNS_TO_LONGEST;
    private int mFps = 20;
    private FutureTask<Boolean> mHasAudioDataTask;
    private boolean mIsPreciseSeek = true;
    private boolean mIsReverse = false;
    private boolean mIsSplitScreenMode = false;
    private long mLastAudioFrameTimestamp = -1;
    private long mLastVideoFrameTimestamp = -1;
    private int mMaxBufferFrame = 3;
    private final List<a> mMediaInfoList = new ArrayList();
    private boolean mNeedAudioSource = false;
    private UGCPixelFrameProvider mNextPixelFrameProvider;
    private int mNextVideoClipIndex = 0;
    private final AtomicReference<Long> mPendingSeekTime = new AtomicReference<>();
    private final UGCFrameQueue<List<PixelFrame>> mPixelFrameListQueue = new UGCFrameQueue<>();
    private long mPlayEndTime = Long.MAX_VALUE;
    private List<TXVideoEditConstants.TXRepeat> mRepeatList;
    private long mSourceRangeEnd = 2147483647L;
    private long mSourceRangeStart = 0;
    private List<String> mSources;
    private List<TXVideoEditConstants.TXSpeed> mSpeedList;
    private final String mTAG = ("UGCMediaListSource_" + hashCode());
    private final List<PixelFrame> mTailPixelFrameList = new ArrayList();
    /* access modifiers changed from: private */
    public long mTailWaterMarkDurationMs = 0;
    private long mTotalDuration = 0;
    private int mTransitionType = 1;
    private CustomHandler mVideoHandler;
    private long mVideoSeekTimeInClip = -1;
    private CustomHandler mWorkHandler;

    private void addClipToList(long j11, long j12, a aVar) {
        if (j11 < j12) {
            Clip clip = new Clip();
            clip.startInFileTime = j11;
            clip.endInFileTime = j12;
            clip.path = aVar.f50091e;
            clip.fps = aVar.f50090d;
            clip.videoMimeType = aVar.f50092f;
            this.mClipList.add(clip);
        }
    }

    private void addVideoTailFrameListToQueue() {
        PixelFrame pixelFrame;
        if (this.mTailWaterMarkDurationMs > 0 && !this.mTailPixelFrameList.isEmpty()) {
            long j11 = 40;
            List<Clip> list = this.mClipList;
            int i11 = 0;
            if (list != null && !list.isEmpty()) {
                float f11 = this.mClipList.get(0).fps;
                if (f11 > 0.0f) {
                    j11 = (long) (1000.0f / f11);
                }
            }
            int i12 = (int) (this.mTailWaterMarkDurationMs / j11);
            while (i11 < i12) {
                LinkedList linkedList = new LinkedList();
                for (PixelFrame next : this.mTailPixelFrameList) {
                    if (next instanceof GLTexturePool.TextureFrame) {
                        GLTexturePool.TextureFrame textureFrame = (GLTexturePool.TextureFrame) next;
                        pixelFrame = textureFrame.getGLTexture().wrap(textureFrame.getGLContext());
                    } else {
                        LiteavLog.w(this.mTAG, "addVideoTailFrameListToQueue: pixelFrame is not TextureFrame");
                        pixelFrame = new PixelFrame(next);
                    }
                    pixelFrame.setTimestamp((((long) (i11 + 1)) * j11) + next.getTimestamp());
                    linkedList.add(pixelFrame);
                }
                if (putPixFrameToQueue(linkedList)) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    private void adjustAudioFrameTimestamp(List<AudioFrame> list) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            AudioFrame audioFrame = list.get(0);
            long calculateAudioFrameDuration = calculateAudioFrameDuration(audioFrame);
            if (this.mLastAudioFrameTimestamp != -1) {
                long timestamp = audioFrame.getTimestamp();
                long j11 = this.mLastAudioFrameTimestamp;
                if (timestamp < j11 + calculateAudioFrameDuration) {
                    if (calculateAudioFrameDuration <= 0) {
                        calculateAudioFrameDuration = 1;
                    }
                    long j12 = j11 + calculateAudioFrameDuration;
                    this.mLastAudioFrameTimestamp = j12;
                    audioFrame.setTimestamp(j12);
                    return;
                }
            }
            this.mLastAudioFrameTimestamp = audioFrame.getTimestamp();
        }
    }

    private void adjustPixelFrameTimestamp(List<PixelFrame> list) {
        if (!CollectionUtils.isEmpty((Collection<?>) list)) {
            PixelFrame pixelFrame = list.get(0);
            if (this.mLastVideoFrameTimestamp != -1) {
                long timestamp = pixelFrame.getTimestamp();
                long j11 = this.mLastVideoFrameTimestamp;
                if (timestamp <= j11) {
                    long j12 = j11 + 1;
                    this.mLastVideoFrameTimestamp = j12;
                    pixelFrame.setTimestamp(j12);
                    return;
                }
            }
            this.mLastVideoFrameTimestamp = pixelFrame.getTimestamp();
        }
    }

    private long calculateAudioFrameDuration(AudioFrame audioFrame) {
        if (audioFrame == null || audioFrame.getData() == null) {
            return 0;
        }
        long sampleRate = ((long) audioFrame.getSampleRate()) * 2 * ((long) audioFrame.getChannelCount());
        if (sampleRate == 0) {
            return 0;
        }
        return (((long) audioFrame.getData().limit()) * 1000) / sampleRate;
    }

    /* access modifiers changed from: private */
    public long calculateTotalDurationOfClips() {
        if (isImageSource()) {
            return getImageDuration();
        }
        long j11 = 0;
        if (!this.mIsSplitScreenMode) {
            for (Clip clipDuration : this.mClipList) {
                j11 += getClipDuration(clipDuration);
            }
            long j12 = this.mSourceRangeEnd - this.mSourceRangeStart;
            return j12 < j11 ? j12 : j11;
        } else if (this.mDurationControlMode == TXVideoJoiner.DurationControlMode.ALIGNS_TO_LONGEST) {
            return getMaxClipDuration(this.mClipList);
        } else {
            return getMinClipDuration(this.mClipList);
        }
    }

    private void clearFrameQueue() {
        clearVideoFrameQueue();
        this.mAudioFrameListQueue.clear();
    }

    private void clearVideoFrameQueue() {
        for (List<PixelFrame> releasePixelFrames : this.mPixelFrameListQueue.dequeueAll()) {
            PixelFrame.releasePixelFrames(releasePixelFrames);
        }
    }

    private void closeCurrentAudioFrameProvider() {
        UGCAudioFrameProvider uGCAudioFrameProvider = this.mCurrentAudioFrameProvider;
        if (uGCAudioFrameProvider != null) {
            uGCAudioFrameProvider.stop();
            this.mCurrentAudioFrameProvider.uninitialize();
            this.mCurrentAudioFrameProvider = null;
        }
    }

    private void closeCurrentPixelFrameProvider() {
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mCurrentPixelFrameProvider;
        if (uGCPixelFrameProvider != null) {
            uGCPixelFrameProvider.stop();
            this.mCurrentPixelFrameProvider.uninitialize();
            this.mCurrentPixelFrameProvider = null;
        }
    }

    private void closeNextPixelFrameProvider() {
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mNextPixelFrameProvider;
        if (uGCPixelFrameProvider != null) {
            uGCPixelFrameProvider.stop();
            this.mNextPixelFrameProvider.uninitialize();
            this.mNextPixelFrameProvider = null;
        }
    }

    private UGCPixelFrameProvider createImageProvider() {
        UGCImageProvider uGCImageProvider = new UGCImageProvider(this.mBitmapList, this.mFps);
        uGCImageProvider.initialize();
        uGCImageProvider.start();
        uGCImageProvider.setPictureTransition(this.mTransitionType);
        return uGCImageProvider;
    }

    private UGCAudioFrameProvider createMuteAudioProvider() {
        Clip clip = new Clip();
        clip.path = UGCSingleFileAudioFrameProvider.MUTE_VIRTUAL_FILE_PATH;
        clip.startInClipsTimeline = 0;
        clip.startTimelineNoSpeed = 0;
        clip.startInFileTime = 0;
        clip.endInFileTime = getImageDuration();
        UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider = new UGCSingleFileAudioFrameProvider(clip, this.mAudioHandler);
        uGCSingleFileAudioFrameProvider.initialize();
        uGCSingleFileAudioFrameProvider.start();
        return uGCSingleFileAudioFrameProvider;
    }

    private TXVideoEditConstants.TXSpeed createTXSpeed(long j11, long j12, int i11) {
        TXVideoEditConstants.TXSpeed tXSpeed = new TXVideoEditConstants.TXSpeed();
        tXSpeed.startTime = j11;
        tXSpeed.endTime = j12;
        tXSpeed.speedLevel = i11;
        return tXSpeed;
    }

    private UGCPixelFrameProvider createVideoFileProvider(int i11, boolean z11) {
        UGCPixelFrameProvider uGCPixelFrameProvider;
        if (this.mVideoHandler == null) {
            HandlerThread handlerThread = new HandlerThread("Video-File-Provider");
            handlerThread.start();
            this.mVideoHandler = new CustomHandler(handlerThread.getLooper());
        }
        if (z11) {
            uGCPixelFrameProvider = new UGCMultiFilePixelFrameProvider(this.mClipList, this.mDurationControlMode, this.mVideoHandler);
        } else {
            UGCSingleFilePixelFrameProvider uGCSingleFilePixelFrameProvider = new UGCSingleFilePixelFrameProvider(this.mClipList.get(i11), this.mVideoHandler);
            uGCSingleFilePixelFrameProvider.setPlayEndPts(this.mPlayEndTime);
            uGCPixelFrameProvider = uGCSingleFilePixelFrameProvider;
        }
        uGCPixelFrameProvider.initialize();
        uGCPixelFrameProvider.setReverse(this.mIsReverse);
        uGCPixelFrameProvider.setMaxBufferFrameCount(this.mMaxBufferFrame);
        uGCPixelFrameProvider.start();
        return uGCPixelFrameProvider;
    }

    private void cutMultipleFileToClips() {
        for (a next : this.mMediaInfoList) {
            addClipToList(0, next.f50088b, next);
        }
    }

    private void cutSingleVideoFileToClips() {
        long j11;
        long j12 = this.mSourceRangeStart;
        List<TXVideoEditConstants.TXRepeat> list = this.mRepeatList;
        if (list == null || list.isEmpty()) {
            j11 = j12;
        } else {
            Collections.sort(this.mRepeatList, em.a());
            j11 = j12;
            for (TXVideoEditConstants.TXRepeat next : this.mRepeatList) {
                if (!isInvalidRepeat(next)) {
                    long j13 = next.endTime;
                    long j14 = this.mSourceRangeEnd;
                    if (j13 <= j14) {
                        j14 = j13;
                    }
                    addClipToList(j11, j14, this.mMediaInfoList.get(0));
                    for (int i11 = 0; i11 < next.repeatTimes - 1; i11++) {
                        addClipToList(next.startTime, j14, this.mMediaInfoList.get(0));
                    }
                    j11 = j14;
                }
            }
        }
        long j15 = this.mTotalDuration;
        long j16 = this.mSourceRangeEnd;
        if (j15 > j16) {
            j15 = j16;
        }
        if (j11 < j15) {
            addClipToList(j11, j15, this.mMediaInfoList.get(0));
        }
    }

    private long estimateSourceOpenTime() {
        List<String> list = this.mSources;
        if (list == null || list.size() <= 1) {
            return 1000;
        }
        return 1000 * ((long) list.size());
    }

    private long getClipDuration(Clip clip) {
        List<TXVideoEditConstants.TXSpeed> list = clip.speedList;
        if (list == null) {
            return clip.endInFileTime - clip.startInFileTime;
        }
        long j11 = 0;
        for (TXVideoEditConstants.TXSpeed next : list) {
            j11 = (long) (((float) j11) + (((float) (next.endTime - next.startTime)) / getSpeed(next.speedLevel)));
        }
        return j11;
    }

    private long getImageDuration() {
        if (!isImageSource() || !updateCurrentPixelFrameProvider()) {
            return 0;
        }
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mCurrentPixelFrameProvider;
        if (uGCPixelFrameProvider instanceof UGCImageProvider) {
            return ((UGCImageProvider) uGCPixelFrameProvider).getDuration();
        }
        return 0;
    }

    private long getMaxClipDuration(List<Clip> list) {
        long j11 = 0;
        for (Clip next : list) {
            if (j11 < getClipDuration(next)) {
                j11 = getClipDuration(next);
            }
        }
        return j11;
    }

    private static a getMediaInfo(String str) {
        boolean z11 = false;
        a aVar = new a((byte) 0);
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
        if (fFmpegMediaRetriever.setDataSource(str) == 0) {
            long audioDurationMs = fFmpegMediaRetriever.getAudioDurationMs();
            aVar.f50088b = Math.max(audioDurationMs, fFmpegMediaRetriever.getVideoDurationMs());
            if (audioDurationMs != 0) {
                z11 = true;
            }
            aVar.f50089c = z11;
            aVar.f50090d = fFmpegMediaRetriever.getFPS();
            aVar.f50092f = fFmpegMediaRetriever.getVideoMimeType();
        }
        return aVar;
    }

    private long getMinClipDuration(List<Clip> list) {
        long j11 = 2147483647L;
        for (Clip next : list) {
            if (j11 > getClipDuration(next)) {
                j11 = getClipDuration(next);
            }
        }
        return j11;
    }

    public static float getSpeed(int i11) {
        if (i11 == 0) {
            return 0.25f;
        }
        if (i11 == 1) {
            return 0.5f;
        }
        if (i11 != 3) {
            return i11 != 4 ? 1.0f : 2.0f;
        }
        return 1.5f;
    }

    /* access modifiers changed from: private */
    public boolean hasAudioDataInternal() {
        for (a aVar : this.mMediaInfoList) {
            if (aVar.f50089c) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r1.mBitmapList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isImageSource() {
        /*
            r1 = this;
            java.util.List<com.tencent.ugc.Clip> r0 = r1.mClipList
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0014
            java.util.List<android.graphics.Bitmap> r0 = r1.mBitmapList
            if (r0 == 0) goto L_0x0014
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0014
            r0 = 1
            return r0
        L_0x0014:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ugc.UGCMediaListSource.isImageSource():boolean");
    }

    private boolean isInvalidRepeat(TXVideoEditConstants.TXRepeat tXRepeat) {
        if (tXRepeat.repeatTimes <= 0) {
            return true;
        }
        long j11 = tXRepeat.startTime;
        long j12 = tXRepeat.endTime;
        return j11 >= j12 || j11 > this.mSourceRangeEnd || j12 < this.mSourceRangeStart;
    }

    public static /* synthetic */ int lambda$cutSingleVideoFileToClips$1(TXVideoEditConstants.TXRepeat tXRepeat, TXVideoEditConstants.TXRepeat tXRepeat2) {
        return (int) (tXRepeat.startTime - tXRepeat2.startTime);
    }

    public static /* synthetic */ void lambda$seekTo$11(UGCMediaListSource uGCMediaListSource, boolean z11) {
        Long andSet = uGCMediaListSource.mPendingSeekTime.getAndSet((Object) null);
        if (andSet != null) {
            uGCMediaListSource.seekToInternal(andSet.longValue(), z11);
        }
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setDurationControlMode$3(UGCMediaListSource uGCMediaListSource, TXVideoJoiner.DurationControlMode durationControlMode, FutureTask futureTask) {
        uGCMediaListSource.mDurationControlMode = durationControlMode;
        futureTask.run();
    }

    public static /* synthetic */ void lambda$setIsSplitScreenMode$4(UGCMediaListSource uGCMediaListSource, boolean z11, FutureTask futureTask) {
        uGCMediaListSource.mIsSplitScreenMode = z11;
        uGCMediaListSource.mSourceRangeStart = 0;
        uGCMediaListSource.mSourceRangeEnd = 2147483647L;
        uGCMediaListSource.updateTimelineToClips();
        futureTask.run();
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setPictureList$6(UGCMediaListSource uGCMediaListSource, List list, int i11) {
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mClipList.clear();
        uGCMediaListSource.mBitmapList = list;
        uGCMediaListSource.mFps = i11;
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setPictureTransition$7(UGCMediaListSource uGCMediaListSource, int i11, FutureTask futureTask) {
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mTransitionType = i11;
        uGCMediaListSource.updateCurrentPixelFrameProvider();
        futureTask.run();
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setPlayEndTime$10(UGCMediaListSource uGCMediaListSource, long j11) {
        uGCMediaListSource.mPlayEndTime = j11;
        UGCPixelFrameProvider uGCPixelFrameProvider = uGCMediaListSource.mCurrentPixelFrameProvider;
        if (uGCPixelFrameProvider != null) {
            uGCPixelFrameProvider.setPlayEndPts(j11);
        }
        UGCAudioFrameProvider uGCAudioFrameProvider = uGCMediaListSource.mCurrentAudioFrameProvider;
        if (uGCAudioFrameProvider != null) {
            uGCAudioFrameProvider.setPlayEndPts(j11);
        }
    }

    public static /* synthetic */ void lambda$setRepeatPlay$12(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask) {
        uGCMediaListSource.mRepeatList = list;
        uGCMediaListSource.updateClipsInfo();
        uGCMediaListSource.resetReadPositionInternal();
        futureTask.run();
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setReverse$13(UGCMediaListSource uGCMediaListSource, boolean z11) {
        uGCMediaListSource.resetReadPositionInternal();
        uGCMediaListSource.mIsReverse = z11;
        if (z11) {
            uGCMediaListSource.mCurrentVideoClipIndex = uGCMediaListSource.mClipList.size() - 1;
        } else {
            uGCMediaListSource.mCurrentVideoClipIndex = 0;
        }
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setSpeedList$14(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask) {
        uGCMediaListSource.mSpeedList = list;
        uGCMediaListSource.updateClipsInfo();
        uGCMediaListSource.resetReadPositionInternal();
        futureTask.run();
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setVideoSourceRange$5(UGCMediaListSource uGCMediaListSource, long j11, long j12, FutureTask futureTask) {
        if (!uGCMediaListSource.mIsSplitScreenMode) {
            uGCMediaListSource.mSourceRangeStart = j11;
            uGCMediaListSource.mSourceRangeEnd = j12;
            uGCMediaListSource.updateClipsInfo();
        }
        uGCMediaListSource.resetReadPositionInternal();
        futureTask.run();
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ void lambda$setVideoSources$0(UGCMediaListSource uGCMediaListSource, List list, FutureTask futureTask, FutureTask futureTask2) {
        uGCMediaListSource.setVideoSourcesInternal(list);
        futureTask.run();
        futureTask2.run();
        uGCMediaListSource.mCountOfPendingResetInputData.decrementAndGet();
    }

    public static /* synthetic */ int lambda$updateSpeedInfoToClips$2(TXVideoEditConstants.TXSpeed tXSpeed, TXVideoEditConstants.TXSpeed tXSpeed2) {
        return (int) (tXSpeed.startTime - tXSpeed2.startTime);
    }

    /* access modifiers changed from: private */
    public void loadNextAudioFrameInternal(long j11) {
        if (this.mAudioFrameListQueue.size() <= 5) {
            if (updateCurrentAudioFrameProvider()) {
                long j12 = this.mAudioSeekTimeInClip;
                if (j12 != -1) {
                    this.mCurrentAudioFrameProvider.seekTo(j12);
                    this.mCurrentAudioFrameProvider.setPlayEndPts(this.mPlayEndTime);
                    this.mAudioSeekTimeInClip = -1;
                }
                readAudioFrameListToQueue(j11);
                scheduleTaskOnWorkerThread(ee.a(this));
            } else if (!putAudioFrameToQueue((List<AudioFrame>) null)) {
                scheduleTaskOnWorkerThread(ed.a(this));
            } else {
                LiteavLog.i(this.mTAG, "getAudioFrameProvider fail.AudioFrameListQueue put null");
            }
        }
    }

    /* access modifiers changed from: private */
    public void loadNextVideoFrameInternal(long j11) {
        if (this.mPixelFrameListQueue.size() < 5) {
            if (!updateCurrentPixelFrameProvider()) {
                addVideoTailFrameListToQueue();
                if (!putPixFrameToQueue((List<PixelFrame>) null)) {
                    scheduleTaskOnWorkerThread(ef.a(this));
                } else {
                    LiteavLog.i(this.mTAG, "getPixelFrameProvider fail.PixelFrameListQueue put null");
                }
            } else {
                long j12 = this.mVideoSeekTimeInClip;
                if (j12 != -1) {
                    this.mCurrentPixelFrameProvider.seekTo(j12, this.mIsPreciseSeek);
                    this.mCurrentPixelFrameProvider.setPlayEndPts(this.mPlayEndTime);
                    this.mVideoSeekTimeInClip = -1;
                }
                readVideoFrameListToQueue(j11);
                scheduleTaskOnWorkerThread(eg.a(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public void prePareNextUGCPixelFrameProvider() {
        int i11;
        closeNextPixelFrameProvider();
        if (this.mIsReverse) {
            this.mNextVideoClipIndex = this.mCurrentVideoClipIndex - 1;
        } else {
            this.mNextVideoClipIndex = this.mCurrentVideoClipIndex + 1;
        }
        if (this.mNextVideoClipIndex < this.mClipList.size() && (i11 = this.mNextVideoClipIndex) >= 0) {
            this.mNextPixelFrameProvider = createVideoFileProvider(i11, false);
        }
    }

    private boolean putPixFrameToQueue(List<PixelFrame> list) {
        if (this.mCountOfPendingResetInputData.get() > 0) {
            PixelFrame.releasePixelFrames(list);
            return false;
        }
        this.mPixelFrameListQueue.queue(list);
        return true;
    }

    private void readAudioFrameListToQueue(long j11) {
        List<AudioFrame> dequeue = this.mCurrentAudioFrameProvider.getFrameQueue().dequeue(j11);
        if (dequeue != null) {
            if (dequeue == UGCAudioFrameProvider.END_OF_STREAM) {
                LiteavLog.i(this.mTAG, "audio frame provider read END_OF_STREAM");
                closeCurrentAudioFrameProvider();
                if (this.mIsReverse) {
                    this.mCurrentAudioClipIndex--;
                } else {
                    this.mCurrentAudioClipIndex++;
                }
            } else {
                if (!this.mIsSplitScreenMode) {
                    adjustAudioFrameTimestamp(dequeue);
                }
                putAudioFrameToQueue(dequeue);
            }
        }
    }

    private void readVideoFrameListToQueue(long j11) {
        List<PixelFrame> dequeue = this.mCurrentPixelFrameProvider.getFrameQueue().dequeue(j11);
        if (dequeue != null) {
            if (dequeue == UGCPixelFrameProvider.END_OF_STREAM) {
                LiteavLog.i(this.mTAG, "video frame provider read END_OF_STREAM");
                closeCurrentPixelFrameProvider();
                if (this.mIsReverse) {
                    this.mCurrentVideoClipIndex--;
                } else {
                    this.mCurrentVideoClipIndex++;
                }
            } else {
                if (!this.mIsSplitScreenMode) {
                    adjustPixelFrameTimestamp(dequeue);
                }
                if (putPixFrameToQueue(dequeue)) {
                    saveTailVideoFrameToList(dequeue);
                }
            }
        }
    }

    private void removeRunnable(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            customHandler.removeCallbacks(runnable);
        }
    }

    private void resetReadPositionInternal() {
        clearFrameQueue();
        PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
        closeCurrentPixelFrameProvider();
        closeCurrentAudioFrameProvider();
        this.mCurrentVideoClipIndex = 0;
        this.mCurrentAudioClipIndex = 0;
        this.mVideoSeekTimeInClip = -1;
        this.mAudioSeekTimeInClip = -1;
        this.mLastAudioFrameTimestamp = -1;
        this.mLastVideoFrameTimestamp = -1;
    }

    private void runOnWorkThread(Runnable runnable) {
        runOnWorkThread(runnable, 0);
    }

    private void saveTailVideoFrameToList(List<PixelFrame> list) {
        if (this.mTailWaterMarkDurationMs != 0) {
            for (PixelFrame release : this.mTailPixelFrameList) {
                release.release();
            }
            this.mTailPixelFrameList.clear();
            for (PixelFrame next : list) {
                next.retain();
                this.mTailPixelFrameList.add(next);
            }
        }
    }

    private void scheduleTaskOnWorkerThread(Runnable runnable) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            customHandler.post(runnable);
        }
    }

    private void seekToInternal(long j11, boolean z11) {
        long a11 = g.a(j11, 0, this.mTotalDuration);
        if (isImageSource()) {
            seekToInternalWithImageSource(a11);
        } else if (!this.mClipList.isEmpty()) {
            this.mLastAudioFrameTimestamp = -1;
            this.mLastVideoFrameTimestamp = -1;
            if (this.mIsSplitScreenMode) {
                this.mVideoSeekTimeInClip = a11;
                this.mAudioSeekTimeInClip = a11;
                clearFrameQueue();
                PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
                return;
            }
            int i11 = -1;
            int i12 = 0;
            while (true) {
                if (i12 >= this.mClipList.size()) {
                    break;
                }
                Clip clip = this.mClipList.get(i12);
                if (clip.startInClipsTimeline + (clip.endInFileTime - clip.startInFileTime) >= a11) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
            if (i11 >= 0) {
                this.mVideoSeekTimeInClip = a11 - this.mClipList.get(i11).startInClipsTimeline;
            } else {
                this.mVideoSeekTimeInClip = a11;
            }
            long j12 = this.mVideoSeekTimeInClip;
            this.mAudioSeekTimeInClip = j12;
            if (this.mIsReverse) {
                this.mAudioSeekTimeInClip = this.mTotalDuration - j12;
            }
            this.mIsPreciseSeek = z11;
            if (this.mCurrentVideoClipIndex != i11) {
                closeCurrentPixelFrameProvider();
            }
            if (this.mCurrentAudioClipIndex != i11) {
                closeCurrentAudioFrameProvider();
            }
            this.mCurrentVideoClipIndex = i11;
            this.mCurrentAudioClipIndex = i11;
            this.mLastVideoFrameTimestamp = -1;
            this.mLastAudioFrameTimestamp = -1;
            clearFrameQueue();
            PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
            loadNextVideoFrameInternal(0);
            if (this.mNeedAudioSource) {
                loadNextAudioFrameInternal(0);
            }
        }
    }

    private void seekToInternalWithImageSource(long j11) {
        this.mCurrentVideoClipIndex = 0;
        this.mVideoSeekTimeInClip = j11;
        this.mLastVideoFrameTimestamp = -1;
        this.mLastAudioFrameTimestamp = -1;
        clearFrameQueue();
        PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
        loadNextVideoFrameInternal(0);
    }

    private void setVideoSourcesInternal(List<String> list) {
        resetReadPositionInternal();
        this.mSources = list;
        this.mMediaInfoList.clear();
        clearFrameQueue();
        this.mTotalDuration = 0;
        for (String next : list) {
            a mediaInfo = getMediaInfo(next);
            String str = this.mTAG;
            LiteavLog.i(str, next + " get media Info. duration = " + mediaInfo.f50088b);
            long j11 = this.mTotalDuration;
            mediaInfo.f50087a = j11;
            mediaInfo.f50091e = next;
            this.mTotalDuration = j11 + mediaInfo.f50088b;
            this.mMediaInfoList.add(mediaInfo);
        }
        this.mSourceRangeStart = 0;
        this.mSourceRangeEnd = this.mTotalDuration;
        updateClipsInfo();
    }

    /* access modifiers changed from: private */
    public void uninitializeInternal() {
        closeCurrentPixelFrameProvider();
        closeNextPixelFrameProvider();
        closeCurrentAudioFrameProvider();
        CustomHandler customHandler = this.mVideoHandler;
        if (customHandler != null) {
            customHandler.quitLooper();
            this.mVideoHandler = null;
        }
        CustomHandler customHandler2 = this.mAudioHandler;
        if (customHandler2 != null) {
            customHandler2.quitLooper();
            this.mAudioHandler = null;
        }
        clearFrameQueue();
        PixelFrame.releasePixelFrames(this.mTailPixelFrameList);
        this.mClipList.clear();
        this.mMediaInfoList.clear();
        this.mSources = null;
        this.mRepeatList = null;
        this.mSpeedList = null;
        this.mSourceRangeStart = 0;
        this.mSourceRangeEnd = 2147483647L;
        this.mCurrentVideoClipIndex = 0;
        this.mCurrentAudioClipIndex = 0;
        this.mVideoSeekTimeInClip = -1;
        this.mAudioSeekTimeInClip = -1;
        this.mLastAudioFrameTimestamp = -1;
        this.mLastVideoFrameTimestamp = -1;
        this.mIsReverse = false;
        this.mNextVideoClipIndex = 0;
        CustomHandler customHandler3 = this.mWorkHandler;
        if (customHandler3 != null) {
            customHandler3.quitLooper();
            this.mWorkHandler = null;
        }
    }

    private void updateClipsInfo() {
        LiteavLog.i(this.mTAG, "updateClipsInfo");
        List<String> list = this.mSources;
        if (list != null && !list.isEmpty()) {
            this.mClipList.clear();
            if (this.mSources.size() > 1) {
                cutMultipleFileToClips();
            } else {
                cutSingleVideoFileToClips();
            }
            for (Clip updateSpeedInfoToClips : this.mClipList) {
                updateSpeedInfoToClips(updateSpeedInfoToClips);
            }
            updateTimelineToClips();
        }
    }

    private boolean updateCurrentAudioFrameProvider() {
        int i11;
        if (this.mCurrentAudioFrameProvider != null) {
            return true;
        }
        if (this.mAudioHandler == null) {
            HandlerThread handlerThread = new HandlerThread("Audio-File-Provider");
            handlerThread.start();
            this.mAudioHandler = new CustomHandler(handlerThread.getLooper());
        }
        if (isImageSource() && this.mCurrentAudioClipIndex == 0) {
            this.mCurrentAudioFrameProvider = createMuteAudioProvider();
            return true;
        } else if (this.mCurrentAudioClipIndex >= this.mClipList.size() || (i11 = this.mCurrentAudioClipIndex) < 0) {
            return false;
        } else {
            if (this.mIsSplitScreenMode) {
                this.mCurrentAudioFrameProvider = new UGCMultiFileAudioFrameProvider(this.mClipList, this.mDurationControlMode, this.mAudioHandler);
                this.mCurrentAudioClipIndex = this.mClipList.size();
            } else {
                this.mCurrentAudioFrameProvider = new UGCSingleFileAudioFrameProvider(this.mClipList.get(i11), this.mAudioHandler);
            }
            this.mCurrentAudioFrameProvider.initialize();
            this.mCurrentAudioFrameProvider.start();
            return true;
        }
    }

    private boolean updateCurrentPixelFrameProvider() {
        int i11;
        if (this.mCurrentPixelFrameProvider != null) {
            return true;
        }
        if (isImageSource() && this.mCurrentVideoClipIndex == 0) {
            this.mCurrentPixelFrameProvider = createImageProvider();
            return true;
        } else if (this.mCurrentVideoClipIndex >= this.mClipList.size() || (i11 = this.mCurrentVideoClipIndex) < 0) {
            return false;
        } else {
            if (!this.mIsSplitScreenMode) {
                if (i11 == this.mNextVideoClipIndex) {
                    this.mCurrentPixelFrameProvider = this.mNextPixelFrameProvider;
                    this.mNextPixelFrameProvider = null;
                }
                if (this.mCurrentPixelFrameProvider == null) {
                    this.mCurrentPixelFrameProvider = createVideoFileProvider(i11, false);
                }
                removeRunnable(eh.a(this));
                runOnWorkThread(ej.a(this), 500);
            } else {
                this.mCurrentPixelFrameProvider = createVideoFileProvider(0, true);
                this.mCurrentVideoClipIndex = this.mClipList.size();
            }
            return true;
        }
    }

    private void updateSpeedInfoToClips(Clip clip) {
        Clip clip2 = clip;
        List<TXVideoEditConstants.TXSpeed> list = this.mSpeedList;
        if (list != null && !list.isEmpty()) {
            Collections.sort(this.mSpeedList, en.a());
            ArrayList arrayList = new ArrayList();
            long j11 = clip2.startInFileTime;
            long j12 = j11;
            for (TXVideoEditConstants.TXSpeed next : this.mSpeedList) {
                long j13 = next.startTime;
                long j14 = clip2.startInSourceListTimeline;
                long j15 = j13 - j14;
                long j16 = next.endTime - j14;
                if (j16 >= clip2.startInFileTime) {
                    long j17 = clip2.endInFileTime;
                    if (j15 > j17 || j12 >= j17) {
                        break;
                    }
                    if (j15 > j12) {
                        arrayList.add(createTXSpeed(j12, j15, 2));
                        j12 = j15;
                    }
                    TXVideoEditConstants.TXSpeed createTXSpeed = createTXSpeed(j12, j16, next.speedLevel);
                    long j18 = createTXSpeed.endTime;
                    long j19 = clip2.endInFileTime;
                    if (j18 > j19) {
                        createTXSpeed.endTime = j19;
                    }
                    arrayList.add(createTXSpeed);
                    j12 = createTXSpeed.endTime;
                }
            }
            long j21 = clip2.endInFileTime;
            if (j12 != j21) {
                arrayList.add(createTXSpeed(j12, j21, 2));
            }
            clip2.speedList = arrayList;
        }
    }

    private void updateTimelineToClips() {
        long j11 = 0;
        long j12 = 0;
        for (Clip next : this.mClipList) {
            next.startInClipsTimeline = j11;
            next.startTimelineNoSpeed = j12;
            if (!this.mIsSplitScreenMode) {
                j11 += getClipDuration(next);
                j12 += next.endInFileTime - next.startInFileTime;
            }
        }
    }

    public long getDuration() {
        FutureTask<Long> futureTask = this.mCalculateDurationTask;
        if (futureTask == null) {
            return 0;
        }
        Long l11 = 0L;
        try {
            l11 = futureTask.get(estimateSourceOpenTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e11) {
            LiteavLog.w(this.mTAG, "getDuration future task exception: ".concat(String.valueOf(e11)));
        }
        return l11.longValue();
    }

    public boolean hasAudioData() {
        FutureTask<Boolean> futureTask = this.mHasAudioDataTask;
        if (futureTask == null) {
            return false;
        }
        Boolean bool = Boolean.FALSE;
        try {
            bool = futureTask.get(estimateSourceOpenTime(), TimeUnit.MILLISECONDS);
        } catch (Exception e11) {
            LiteavLog.w(this.mTAG, "hasAudioData future exception ".concat(String.valueOf(e11)));
        }
        return bool.booleanValue();
    }

    public void impreciseSeekTo(long j11) {
        LiteavLog.i(this.mTAG, "impreciseSeekTo lineTime = ".concat(String.valueOf(j11)));
        seekTo(j11, false);
    }

    public void initialize() {
        LiteavLog.i(this.mTAG, "initialize");
        synchronized (this) {
            if (this.mWorkHandler != null) {
                LiteavLog.w(this.mTAG, "UGCMediaStreamSpliter is initialized");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("ugc-media-list-source");
            handlerThread.start();
            this.mWorkHandler = new CustomHandler(handlerThread.getLooper());
        }
    }

    public boolean putAudioFrameToQueue(List<AudioFrame> list) {
        if (this.mCountOfPendingResetInputData.get() > 0) {
            return false;
        }
        this.mAudioFrameListQueue.queue(list);
        return true;
    }

    public List<AudioFrame> readNextAudioFrame() {
        if (this.mCountOfPendingResetInputData.get() > 0) {
            this.mAudioFrameListQueue.clear();
        }
        runOnWorkThread(dt.a(this));
        return this.mAudioFrameListQueue.dequeue();
    }

    public List<PixelFrame> readNextVideoFrame() {
        if (this.mCountOfPendingResetInputData.get() > 0) {
            clearVideoFrameQueue();
        }
        runOnWorkThread(du.a(this));
        return this.mPixelFrameListQueue.dequeue();
    }

    public void seekTo(long j11) {
        LiteavLog.i(this.mTAG, "seekTo lineTime = ".concat(String.valueOf(j11)));
        seekTo(j11, true);
    }

    public void setDurationControlMode(TXVideoJoiner.DurationControlMode durationControlMode) {
        String str = this.mTAG;
        LiteavLog.i(str, "set duration control mode " + this.mDurationControlMode);
        FutureTask<Long> futureTask = new FutureTask<>(eo.a(this));
        this.mCalculateDurationTask = futureTask;
        runOnWorkThread(ep.a(this, durationControlMode, futureTask));
    }

    public void setIsSplitScreenMode(boolean z11) {
        LiteavLog.i(this.mTAG, "Set split screen mode is ".concat(String.valueOf(z11)));
        FutureTask<Long> futureTask = new FutureTask<>(eq.a(this));
        this.mCalculateDurationTask = futureTask;
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(dn.a(this, z11, futureTask));
    }

    public void setMaxFrameSize(int i11) {
        this.mMaxBufferFrame = i11;
        UGCPixelFrameProvider uGCPixelFrameProvider = this.mCurrentPixelFrameProvider;
        if (uGCPixelFrameProvider != null) {
            uGCPixelFrameProvider.setMaxBufferFrameCount(i11);
        }
    }

    public void setNeedAudioSource(boolean z11) {
        this.mNeedAudioSource = z11;
    }

    public void setPictureList(List<Bitmap> list, int i11) {
        String str = this.mTAG;
        LiteavLog.i(str, "setPictureList bitmapList size = " + list.size() + " fps = " + i11);
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(dq.a(this, list, i11));
    }

    public void setPictureTransition(int i11) {
        LiteavLog.i(this.mTAG, "setPictureTransition type = ".concat(String.valueOf(i11)));
        FutureTask<Long> futureTask = new FutureTask<>(dr.a(this));
        this.mCalculateDurationTask = futureTask;
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(ds.a(this, i11, futureTask));
    }

    public void setPlayEndTime(long j11) {
        runOnWorkThread(dv.a(this, j11));
    }

    public void setRepeatPlay(List<TXVideoEditConstants.TXRepeat> list) {
        LiteavLog.i(this.mTAG, "setRepeatPlay");
        FutureTask<Long> futureTask = new FutureTask<>(dy.a(this));
        this.mCalculateDurationTask = futureTask;
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(dz.a(this, list, futureTask));
    }

    public void setReverse(boolean z11) {
        LiteavLog.i(this.mTAG, "setReverse isReverse = ".concat(String.valueOf(z11)));
        if (z11 != this.mIsReverse) {
            this.mCountOfPendingResetInputData.incrementAndGet();
            runOnWorkThread(ea.a(this, z11));
        }
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        LiteavLog.i(this.mTAG, "setSpeedList");
        FutureTask<Long> futureTask = new FutureTask<>(eb.a(this));
        this.mCalculateDurationTask = futureTask;
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(ec.a(this, list, futureTask));
    }

    public void setTailWaterMarkDurationSecond(int i11) {
        runOnWorkThread(ek.a(this, i11));
    }

    public void setVideoSourceRange(long j11, long j12) {
        String str = this.mTAG;
        LiteavLog.i(str, "setVideoSourceRange startTime = " + j11 + " endTime = " + j12);
        FutureTask<Long> futureTask = new FutureTask<>(Cdo.a(this));
        this.mCalculateDurationTask = futureTask;
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(dp.a(this, j11, j12, futureTask));
    }

    public void setVideoSources(List<String> list) {
        LiteavLog.i(this.mTAG, "setVideoSources");
        FutureTask<Boolean> futureTask = new FutureTask<>(dx.a(this));
        this.mHasAudioDataTask = futureTask;
        FutureTask<Long> futureTask2 = new FutureTask<>(ei.a(this));
        this.mCalculateDurationTask = futureTask2;
        this.mCountOfPendingResetInputData.incrementAndGet();
        runOnWorkThread(el.a(this, list, futureTask, futureTask2));
    }

    public long transitionOffsetTimeWithPts(long j11) {
        return 0;
    }

    public void uninitialize() {
        LiteavLog.i(this.mTAG, "unInitialize");
        runOnWorkThread(dm.a(this));
    }

    private void runOnWorkThread(Runnable runnable, int i11) {
        CustomHandler customHandler = this.mWorkHandler;
        if (customHandler != null) {
            customHandler.runOrPost(runnable, i11);
        }
    }

    private void seekTo(long j11, boolean z11) {
        if (j11 >= 0) {
            this.mPendingSeekTime.set(Long.valueOf(j11));
            this.mCountOfPendingResetInputData.incrementAndGet();
            runOnWorkThread(dw.a(this, z11));
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f50087a;

        /* renamed from: b  reason: collision with root package name */
        public long f50088b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50089c;

        /* renamed from: d  reason: collision with root package name */
        public float f50090d;

        /* renamed from: e  reason: collision with root package name */
        public String f50091e;

        /* renamed from: f  reason: collision with root package name */
        public String f50092f;

        private a() {
            this.f50087a = 0;
            this.f50088b = 0;
            this.f50089c = false;
            this.f50090d = 25.0f;
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }
}
