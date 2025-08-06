package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Looper;
import android.text.TextUtils;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.f;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.l;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.ugc.MP4Writer;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoJoiner;
import com.tencent.ugc.UGCAVSyncer;
import com.tencent.ugc.UGCAudioProcessor;
import com.tencent.ugc.UGCThumbnailGenerator;
import com.tencent.ugc.UGCVideoProcessor;
import com.tencent.ugc.common.MediaExtractorBuilder;
import com.tencent.ugc.common.UGCConstants;
import com.tencent.ugc.common.UGCTranscodeAudioEncodeParamsDecider;
import com.tencent.ugc.common.UGCTranscodeVideoEncodeParamsDecider;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.encoder.VideoEncodeParams;
import com.tencent.ugc.encoder.VideoEncoderDef;
import com.tencent.ugc.retriver.FFmpegMediaRetriever;
import com.tencent.ugc.videobase.base.GLConstants;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class TXVideoEditer {
    private static final long MIN_SEEK_DIR = 100;
    private static final String TAG = "TXVideoEditer";
    private static final int WAIT_FOR_THUMBNAIL_TIMEOUT = 500;
    private static final HashSet<String> sVideoExtHashSet = new HashSet<>(Arrays.asList(new String[]{"3gpp", "3gp", "3g2", "m4v", "mpeg", "mpg", "mpe", "mp4", "vob", "qt", "mov", "wmv", "avi"}));
    private final UGCAVSyncer mAVSyncer;
    private final ArrayList<UGCThumbnailGenerator> mAllThumbnailGeneratorList;
    private int mAudioEncodeBitrate;
    private AudioEncodeParams mAudioEncodeParams;
    private UGCAudioProcessor.AudioEncodedFrameListener mAudioEncodedFrameListener;
    private List<MediaFormat> mAudioFormatList;
    private final UGCAudioProcessor mAudioProcessor;
    private MediaFormat mBGMFormat;
    private CombineFilterInfo mCombineFilterInfo;
    private final Context mContext;
    private long mCutEndTimeMs;
    private long mCutStartTimeMs;
    private int mEncodeProfile;
    private Size mEncodeResolution;
    private FrameLayout mFrameLayout;
    private boolean mHasBGM;
    private final AtomicBoolean mHasNotifyProcessComplete;
    /* access modifiers changed from: private */
    public boolean mIsAudioEncoderStarted;
    private boolean mIsAudioEnd;
    /* access modifiers changed from: private */
    public boolean mIsFullIFrame;
    private boolean mIsGenerating;
    private boolean mIsPlaying;
    private boolean mIsProcessToFullKeyFrame;
    /* access modifiers changed from: private */
    public final AtomicBoolean mIsRelease;
    /* access modifiers changed from: private */
    public boolean mIsReverse;
    /* access modifiers changed from: private */
    public boolean mIsVideoEncoderStarted;
    private boolean mIsVideoEnd;
    private float mLastVideoEncodeProgress;
    private final CustomHandler mMainHandler;
    /* access modifiers changed from: private */
    public final UGCMediaListSource mMediaListSource;
    private MP4Writer mMp4Writer;
    private final MP4Writer.MP4WriterListener mMp4WriterListener;
    private boolean mNeedWaitProcessFullI;
    private boolean mNeedWaitThumbnailProcess;
    private final AtomicReference<Long> mPendingPreviewAtTime;
    private UGCAVSyncer.SyncMode mPreviewSyncMode;
    private String mProcessOutputPath;
    private UGCThumbnailGenerator.UGCThumbnailGenerateParams mProcessThumbnailInfo;
    private TXThumbnailListener mProcessThumbnailListener;
    private String mRecordOutputPath;
    private k mRotation;
    /* access modifiers changed from: private */
    public Runnable mRunnableVideoProcessOnComplete;
    public final l mSequenceTaskRunner;
    private String mSourcePath;
    private long mSourceRangeEndTimeMs;
    private long mSourceRangeStartTimeMs;
    private final AtomicReference<Long> mTargetSeekPts;
    private int mVideoEncodeBitrate;
    private VideoEncodeParams mVideoEncodeParams;
    private UGCVideoProcessor.VideoEncodedFrameListener mVideoEncodedFrameListener;
    private List<MediaFormat> mVideoFormatList;
    private TXVideoGenerateListener mVideoGenerateListener;
    private TXVideoPreviewListener mVideoPreviewListener;
    private TXVideoProcessListener mVideoProcessListener;
    private UGCVideoProcessor.VideoProcessListener mVideoProcessProgressListener;
    private final UGCVideoProcessor mVideoProcessor;
    private List<String> mVideoSourceList;

    public interface TXPCMCallbackListener {
        TXAudioFrame onPCMCallback(TXAudioFrame tXAudioFrame);
    }

    public interface TXThumbnailListener {
        void onThumbnail(int i11, long j11, Bitmap bitmap);
    }

    public interface TXVideoCustomProcessListener {
        int onTextureCustomProcess(int i11, int i12, int i13, long j11);

        void onTextureDestroyed();
    }

    public interface TXVideoGenerateListener {
        void onGenerateComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onGenerateProgress(float f11);
    }

    public interface TXVideoPreviewListener {
        void onPreviewFinished();

        void onPreviewProgress(int i11);
    }

    public interface TXVideoPreviewListenerEx extends TXVideoPreviewListener {
        void onPreviewError(TXVideoEditConstants.TXPreviewError tXPreviewError);
    }

    public interface TXVideoProcessListener {
        void onProcessComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onProcessProgress(float f11);
    }

    public TXVideoEditer(Context context) {
        this(context, new l());
        LiteavLog.i(TAG, "version:" + CommonUtil.getSDKVersionStr());
    }

    private float calculateProgress(long j11) {
        long duration = this.mMediaListSource.getDuration();
        if (duration == 0) {
            duration = 1;
        }
        return (((float) j11) * 1.0f) / ((float) duration);
    }

    private void cancelAllThumbnailGenerator() {
        if (this.mAllThumbnailGeneratorList.size() > 0) {
            Iterator<UGCThumbnailGenerator> it2 = this.mAllThumbnailGeneratorList.iterator();
            while (it2.hasNext()) {
                UGCThumbnailGenerator next = it2.next();
                next.stop();
                next.uninitialize();
            }
            this.mAllThumbnailGeneratorList.clear();
        }
    }

    private static boolean checkIsVideoType(String str) {
        String fileExtension = CommonUtil.getFileExtension(str);
        return !TextUtils.isEmpty(fileExtension) && sVideoExtHashSet.contains(fileExtension.toLowerCase());
    }

    /* access modifiers changed from: private */
    public void doGetThumbnail(final List<Long> list, int i11, int i12, boolean z11, final TXThumbnailListener tXThumbnailListener) {
        LiteavLog.i(TAG, "getThumbnail: width= " + i11 + " height= " + i12 + ",fast= " + z11 + ",list.size= " + list.size());
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams = new UGCThumbnailGenerator.UGCThumbnailGenerateParams();
        uGCThumbnailGenerateParams.thumbnailPtsList = list;
        uGCThumbnailGenerateParams.width = i11;
        uGCThumbnailGenerateParams.height = i12;
        uGCThumbnailGenerateParams.fast = z11;
        final UGCThumbnailGenerator uGCThumbnailGenerator = new UGCThumbnailGenerator();
        uGCThumbnailGenerator.initialize();
        uGCThumbnailGenerator.setVideoSourceList(Collections.singletonList(this.mSourcePath));
        uGCThumbnailGenerator.start(uGCThumbnailGenerateParams, new TXThumbnailListener() {
            public static /* synthetic */ void a(AnonymousClass5 r02, TXThumbnailListener tXThumbnailListener, int i11, long j11, Bitmap bitmap, List list, UGCThumbnailGenerator uGCThumbnailGenerator) {
                if (tXThumbnailListener != null) {
                    tXThumbnailListener.onThumbnail(i11, j11, bitmap);
                }
                if (!TXVideoEditer.this.mIsRelease.get() && i11 == list.size()) {
                    LiteavLog.i(TXVideoEditer.TAG, "getThumbnail finished!");
                    TXVideoEditer.this.releaseThumbnailGenerator(uGCThumbnailGenerator);
                }
            }

            public final void onThumbnail(int i11, long j11, Bitmap bitmap) {
                TXVideoEditer.this.mSequenceTaskRunner.a(cf.a(this, tXThumbnailListener, i11, j11, bitmap, list, uGCThumbnailGenerator));
            }
        });
        this.mAllThumbnailGeneratorList.add(uGCThumbnailGenerator);
    }

    private void doStopPlayInner() {
        LiteavLog.i(TAG, "doStopPlayInner");
        this.mVideoProcessor.setProgressListener((UGCVideoProcessor.VideoProcessListener) null);
        this.mAudioProcessor.setProgressListener((UGCAudioProcessor.AudioProgressListener) null);
        this.mAVSyncer.stop();
        this.mVideoProcessor.stop();
        this.mAudioProcessor.stop();
        this.mIsPlaying = false;
    }

    private boolean filtInvalidatedFrame(long j11) {
        return this.mTargetSeekPts.get() != null && Math.abs(j11 - this.mTargetSeekPts.get().longValue()) > 100;
    }

    private String generateVideoPath() {
        File externalFilesDir = this.mContext.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            LiteavLog.e(TAG, "generateVideoPath getExternalFilesDir return null.");
            return null;
        }
        File file = new File(externalFilesDir + File.separator + "liteav");
        if (!file.exists()) {
            file.mkdirs();
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
        String format = simpleDateFormat.format(new Date(Long.parseLong(valueOf + "000")));
        return file + "/" + String.format("TXVideo_%s_process.mp4", new Object[]{format});
    }

    private void getAllMediaFormatFromSource(List<String> list) {
        for (String path : list) {
            MediaExtractor build = new MediaExtractorBuilder().setPath(path).build();
            if (build != null) {
                int trackCount = build.getTrackCount();
                for (int i11 = 0; i11 < trackCount; i11++) {
                    MediaFormat trackFormat = build.getTrackFormat(i11);
                    String string = trackFormat.getString("mime");
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            this.mVideoFormatList.add(trackFormat);
                        }
                        if (string.startsWith("audio/")) {
                            this.mAudioFormatList.add(trackFormat);
                        }
                    }
                }
            } else {
                LiteavLog.e(TAG, "build extractor fail.");
            }
        }
    }

    private void handleEncodedCompletedInner() {
        if (this.mIsAudioEnd && this.mIsVideoEnd) {
            LiteavLog.i(TAG, "handleEncodedCompleted");
            this.mAVSyncer.stop();
            stopMp4Writer();
        }
    }

    /* access modifiers changed from: private */
    public void handleProcessComplete(int i11) {
        TXVideoProcessListener tXVideoProcessListener;
        if (!this.mHasNotifyProcessComplete.getAndSet(true) && (tXVideoProcessListener = this.mVideoProcessListener) != null) {
            TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
            tXGenerateResult.retCode = i11;
            tXGenerateResult.descMsg = "";
            tXVideoProcessListener.onProcessComplete(tXGenerateResult);
        }
    }

    /* access modifiers changed from: private */
    public void handleThumbnailGeneratedDuringProcessing(UGCThumbnailGenerator uGCThumbnailGenerator, boolean z11, int i11, long j11, Bitmap bitmap) {
        TXVideoProcessListener tXVideoProcessListener;
        TXThumbnailListener tXThumbnailListener = this.mProcessThumbnailListener;
        if (tXThumbnailListener != null) {
            tXThumbnailListener.onThumbnail(i11, j11, bitmap);
        }
        int thumbnailCount = getThumbnailCount();
        if (thumbnailCount == i11) {
            LiteavLog.i(TAG, "mInnerThumbnailListener: notifyProcessComplete");
            if (z11) {
                this.mProcessOutputPath = this.mSourcePath;
            }
            notifyProcessComplete(0, true);
            releaseThumbnailGenerator(uGCThumbnailGenerator);
        }
        if (z11 && (tXVideoProcessListener = this.mVideoProcessListener) != null) {
            this.mMainHandler.post(al.a(this, thumbnailCount, j11, i11, tXVideoProcessListener));
        }
    }

    /* access modifiers changed from: private */
    public void handleWriteMP4Completed(int i11, long j11) {
        this.mSequenceTaskRunner.a(bk.a(this, i11, j11));
    }

    private int isBGMValid(String str) {
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever(false);
        if (fFmpegMediaRetriever.setDataSource(str) != 0 || fFmpegMediaRetriever.getAudioDurationMs() <= 0) {
            return -1001;
        }
        return 0;
    }

    private boolean isFullIFrame(String str) {
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).setMimeType("video/").build();
        if (build == null) {
            LiteavLog.w("ContentValues", "judgeFullIFrame: extractor is null.");
            return false;
        }
        build.seekTo(0, 0);
        int i11 = 0;
        for (int i12 = 0; i12 < 7; i12++) {
            if ((build.getSampleFlags() & 1) == 1) {
                i11++;
            }
            build.advance();
        }
        if (i11 > 5) {
            return true;
        }
        return false;
    }

    private boolean isGopEqualOne(String str) {
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).setMimeType("video/").build();
        if (build == null) {
            LiteavLog.w(TAG, "extractor is null.");
            return false;
        }
        build.seekTo(1, 1);
        long sampleTime = build.getSampleTime();
        build.release();
        if (sampleTime <= IndexSeeker.MIN_TIME_BETWEEN_POINTS_US || sampleTime >= 1100000) {
            return false;
        }
        return true;
    }

    public static int isMediaSourceValid(String str) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "checkLegality: path is null.");
            return TXVideoEditConstants.ERR_SOURCE_NO_FOUND;
        } else if (MediaExtractorBuilder.isContentUri(str)) {
            return 0;
        } else {
            if (!new File(str).exists()) {
                LiteavLog.e(TAG, "checkLegality:source no found!");
                return TXVideoEditConstants.ERR_SOURCE_NO_FOUND;
            } else if (checkIsVideoType(str)) {
                return 0;
            } else {
                LiteavLog.e(TAG, "checkLegality:source type error!");
                return TXVideoEditConstants.ERR_SOURCE_DAMAGED;
            }
        }
    }

    public static /* synthetic */ void lambda$cancel$55(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "cancel");
        tXVideoEditer.mIsGenerating = false;
        tXVideoEditer.mIsVideoEncoderStarted = false;
        tXVideoEditer.mIsAudioEncoderStarted = false;
        tXVideoEditer.mIsProcessToFullKeyFrame = false;
        tXVideoEditer.mVideoProcessor.setVideoEncodedFrameListener((UGCVideoProcessor.VideoEncodedFrameListener) null);
        tXVideoEditer.mAudioProcessor.setAudioEncodedFrameListener((UGCAudioProcessor.AudioEncodedFrameListener) null);
        tXVideoEditer.mMediaListSource.setVideoSourceRange(0, 2147483647L);
        tXVideoEditer.mMediaListSource.setTailWaterMarkDurationSecond(0);
        tXVideoEditer.cancelAllThumbnailGenerator();
        if (!tXVideoEditer.mIsPlaying) {
            tXVideoEditer.mAudioProcessor.stop();
            tXVideoEditer.mVideoProcessor.stop();
        }
        MP4Writer mP4Writer = tXVideoEditer.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.setListener((MP4Writer.MP4WriterListener) null);
        }
        tXVideoEditer.stopMp4Writer();
    }

    public static /* synthetic */ void lambda$deleteAllEffect$31(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "deleteAllEffect");
        tXVideoEditer.mVideoProcessor.getEffectProcessor().deleteAllEffect();
    }

    public static /* synthetic */ void lambda$deleteLastEffect$30(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "deleteLastEffect");
        tXVideoEditer.mVideoProcessor.getEffectProcessor().deleteLastEffect();
    }

    public static /* synthetic */ void lambda$deleteLastTransitionEffect$27(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "deleteLastTransitionEffect");
        tXVideoEditer.mVideoProcessor.getTransitionProcessor().deleteLastTransitionEffect();
    }

    public static /* synthetic */ void lambda$generateVideo$54(TXVideoEditer tXVideoEditer, int i11, String str) {
        Size size;
        LiteavLog.i(TAG, "generateVideo: videoCompressed= " + i11 + ", videoOutputPath= " + str);
        if (!UGCLicenseChecker.isSimpleFunctionSupport()) {
            TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
            tXGenerateResult.retCode = -5;
            tXGenerateResult.descMsg = "licence verify failed";
            TXVideoGenerateListener tXVideoGenerateListener = tXVideoEditer.mVideoGenerateListener;
            if (tXVideoGenerateListener != null) {
                tXVideoGenerateListener.onGenerateComplete(tXGenerateResult);
                return;
            }
            return;
        }
        UGCTranscodeVideoEncodeParamsDecider uGCTranscodeVideoEncodeParamsDecider = new UGCTranscodeVideoEncodeParamsDecider();
        uGCTranscodeVideoEncodeParamsDecider.setSourceType(UGCConstants.SourceType.VIDEO);
        uGCTranscodeVideoEncodeParamsDecider.setFullIFrame(tXVideoEditer.mIsFullIFrame);
        uGCTranscodeVideoEncodeParamsDecider.setOutputResolution(i11);
        uGCTranscodeVideoEncodeParamsDecider.setEncodeRotation(tXVideoEditer.mRotation);
        uGCTranscodeVideoEncodeParamsDecider.setEncodeProfile(tXVideoEditer.mEncodeProfile);
        uGCTranscodeVideoEncodeParamsDecider.setInputVideoMediaFormat(tXVideoEditer.mVideoFormatList);
        UGCTranscodeAudioEncodeParamsDecider uGCTranscodeAudioEncodeParamsDecider = new UGCTranscodeAudioEncodeParamsDecider();
        uGCTranscodeAudioEncodeParamsDecider.setInputAudioMediaFormat(tXVideoEditer.mAudioFormatList);
        uGCTranscodeAudioEncodeParamsDecider.setBGMMediaFormat(tXVideoEditer.mBGMFormat);
        if (TextUtils.isEmpty(tXVideoEditer.mSourcePath)) {
            uGCTranscodeVideoEncodeParamsDecider.setSourceType(UGCConstants.SourceType.PICTURE);
        }
        int i12 = tXVideoEditer.mVideoEncodeBitrate;
        if (i12 != -1) {
            uGCTranscodeVideoEncodeParamsDecider.setEncodeBitrate(i12);
        }
        int i13 = tXVideoEditer.mAudioEncodeBitrate;
        if (i13 != -1) {
            uGCTranscodeAudioEncodeParamsDecider.setEncodeBitrate(i13);
        }
        VideoEncodeParams decidedEncodeParams = uGCTranscodeVideoEncodeParamsDecider.getDecidedEncodeParams();
        tXVideoEditer.mVideoEncodeParams = decidedEncodeParams;
        if (i11 < 0 && (size = tXVideoEditer.mEncodeResolution) != null) {
            decidedEncodeParams.width = size.width;
            decidedEncodeParams.height = size.height;
        }
        tXVideoEditer.mAudioEncodeParams = uGCTranscodeAudioEncodeParamsDecider.getDecidedEncodeParams();
        tXVideoEditer.mIsProcessToFullKeyFrame = false;
        tXVideoEditer.mRecordOutputPath = str;
        tXVideoEditer.mLastVideoEncodeProgress = 0.0f;
        tXVideoEditer.startProcessVideo(VideoEncoderDef.EncoderType.HARDWARE);
    }

    public static /* synthetic */ void lambda$getThumbnail$34(TXVideoEditer tXVideoEditer, int i11, int i12, boolean z11, int i13, TXThumbnailListener tXThumbnailListener) {
        StringBuilder sb2 = new StringBuilder("getThumbnail: width= ");
        int i14 = i11;
        sb2.append(i11);
        sb2.append(" height= ");
        sb2.append(i12);
        sb2.append(",fast= ");
        sb2.append(z11);
        sb2.append(",count= ");
        sb2.append(i13);
        LiteavLog.i(TAG, sb2.toString());
        FFmpegMediaRetriever fFmpegMediaRetriever = new FFmpegMediaRetriever();
        fFmpegMediaRetriever.setDataSource(tXVideoEditer.mSourcePath);
        List<Long> calculateThumbnailList = UGCThumbnailGenerator.calculateThumbnailList(i13, 0, fFmpegMediaRetriever.getVideoDurationMs(), fFmpegMediaRetriever.getVideoDurationMs());
        if (calculateThumbnailList != null) {
            tXVideoEditer.doGetThumbnail(calculateThumbnailList, i11, i12, z11, tXThumbnailListener);
        }
    }

    public static /* synthetic */ void lambda$handleThumbnailGeneratedDuringProcessing$40(TXVideoEditer tXVideoEditer, int i11, long j11, int i12, TXVideoProcessListener tXVideoProcessListener) {
        tXVideoProcessListener.onProcessProgress(i11 == 0 ? tXVideoEditer.calculateProgress(j11) : (((float) i12) * 1.0f) / ((float) i11));
    }

    public static /* synthetic */ void lambda$handleWriteMP4Completed$64(TXVideoEditer tXVideoEditer, int i11, long j11) {
        LiteavLog.i(TAG, "handleWriteMP4Completed: mIsProcessToFullKeyFrame=" + tXVideoEditer.mIsProcessToFullKeyFrame + ",resultCode=" + i11 + ",mIsGenerating= " + tXVideoEditer.mIsGenerating);
        if (tXVideoEditer.mIsGenerating) {
            tXVideoEditer.mAVSyncer.stop();
            tXVideoEditer.mVideoProcessor.stop();
            tXVideoEditer.mAudioProcessor.stop();
            tXVideoEditer.stopMp4Writer();
            tXVideoEditer.mIsGenerating = false;
            tXVideoEditer.mIsVideoEncoderStarted = false;
            tXVideoEditer.mIsAudioEncoderStarted = false;
            if (tXVideoEditer.mIsProcessToFullKeyFrame) {
                if (f.a(tXVideoEditer.mProcessOutputPath) && i11 == 0) {
                    k kVar = tXVideoEditer.mRotation;
                    k kVar2 = k.NORMAL;
                    if (kVar != kVar2) {
                        tXVideoEditer.mRotation = kVar2;
                        tXVideoEditer.mVideoProcessor.setRenderRotation(kVar2);
                    }
                    tXVideoEditer.setMediaSourcePathsInternal(Collections.singletonList(tXVideoEditer.mProcessOutputPath));
                }
                tXVideoEditer.notifyProcessComplete(i11, false);
                return;
            }
            tXVideoEditer.notifyGenerateComplete(i11, j11);
        }
    }

    public static /* synthetic */ void lambda$initWithPreview$44(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        FrameLayout frameLayout = tXVideoEditer.mFrameLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        TextureView textureView = new TextureView(tXVideoEditer.mContext);
        FrameLayout frameLayout2 = tXPreviewParam.videoView;
        tXVideoEditer.mFrameLayout = frameLayout2;
        if (frameLayout2 != null) {
            frameLayout2.addView(textureView);
        }
        tXVideoEditer.mSequenceTaskRunner.a(bt.a(tXVideoEditer, tXPreviewParam, new DisplayTarget(textureView)));
    }

    public static /* synthetic */ void lambda$new$0(TXVideoEditer tXVideoEditer) {
        if (!tXVideoEditer.mIsVideoEnd) {
            tXVideoEditer.mIsVideoEnd = true;
            tXVideoEditer.mIsAudioEnd = true;
            tXVideoEditer.mAVSyncer.setVideoEos();
            tXVideoEditer.mAVSyncer.setAudioEos();
            tXVideoEditer.onPlayProgressEnd();
        }
    }

    public static /* synthetic */ void lambda$new$1(TXVideoEditer tXVideoEditer) {
        UGCInitializer.initialize();
        tXVideoEditer.mVideoProcessor.initialize();
        tXVideoEditer.mAudioProcessor.initialize();
        tXVideoEditer.mMediaListSource.initialize();
        UGCDataReport.reportDAU(1004);
    }

    public static /* synthetic */ void lambda$notifyGenerateComplete$70(int i11, TXVideoGenerateListener tXVideoGenerateListener) {
        TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
        tXGenerateResult.retCode = i11;
        tXGenerateResult.descMsg = "";
        tXVideoGenerateListener.onGenerateComplete(tXGenerateResult);
    }

    public static /* synthetic */ void lambda$notifyPreviewProgress$65(TXVideoEditer tXVideoEditer, int i11, TXVideoPreviewListener tXVideoPreviewListener) {
        if (!tXVideoEditer.filtInvalidatedFrame((long) (i11 / 1000))) {
            tXVideoPreviewListener.onPreviewProgress(i11);
            tXVideoEditer.mTargetSeekPts.set((Object) null);
        }
    }

    public static /* synthetic */ void lambda$null$43(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXPreviewParam tXPreviewParam, DisplayTarget displayTarget) {
        GLConstants.GLScaleType gLScaleType = GLConstants.GLScaleType.CENTER_CROP;
        if (tXPreviewParam.renderMode == 2) {
            gLScaleType = GLConstants.GLScaleType.FIT_CENTER;
        }
        tXVideoEditer.mVideoProcessor.setDisplayView(displayTarget, gLScaleType);
    }

    public static /* synthetic */ void lambda$pausePlay$46(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "pausePlay " + tXVideoEditer.mIsGenerating);
        if (!tXVideoEditer.mIsGenerating) {
            tXVideoEditer.mAVSyncer.stop();
            tXVideoEditer.mVideoProcessor.stop();
            tXVideoEditer.mAudioProcessor.stop();
        }
    }

    public static /* synthetic */ void lambda$previewAtTime$49(TXVideoEditer tXVideoEditer) {
        Long andSet = tXVideoEditer.mPendingPreviewAtTime.getAndSet((Object) null);
        if (andSet != null) {
            LiteavLog.i(TAG, "previewAtTime time = ".concat(String.valueOf(andSet)));
            tXVideoEditer.mMediaListSource.seekTo(andSet.longValue());
            tXVideoEditer.mVideoProcessor.seekTo(andSet.longValue());
            tXVideoEditer.mSequenceTaskRunner.c(tXVideoEditer.mRunnableVideoProcessOnComplete);
            tXVideoEditer.mAVSyncer.resetClock();
        }
    }

    public static /* synthetic */ void lambda$processVideoInternal$37(TXVideoProcessListener tXVideoProcessListener) {
        TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
        tXGenerateResult.retCode = -5;
        tXGenerateResult.descMsg = "licence verify failed";
        if (tXVideoProcessListener != null) {
            tXVideoProcessListener.onProcessComplete(tXGenerateResult);
        }
    }

    public static /* synthetic */ void lambda$release$41(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "release");
        tXVideoEditer.mIsRelease.set(true);
        tXVideoEditer.cancelAllThumbnailGenerator();
        tXVideoEditer.mVideoProcessor.unInitialize();
        tXVideoEditer.mAudioProcessor.unInitialize();
        tXVideoEditer.mAudioProcessor.destroy();
        tXVideoEditer.mMediaListSource.uninitialize();
        tXVideoEditer.stopMp4Writer();
        UGCInitializer.uninitialize();
    }

    public static /* synthetic */ void lambda$resumePlay$47(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "resumePlay " + tXVideoEditer.mIsGenerating);
        if (!tXVideoEditer.mIsGenerating) {
            tXVideoEditer.mAVSyncer.start();
            tXVideoEditer.mVideoProcessor.start(false, VideoEncoderDef.EncoderType.HARDWARE);
            tXVideoEditer.mAudioProcessor.start(false);
        }
    }

    public static /* synthetic */ void lambda$setAnimatedPasterList$20(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setAnimatedPasterList");
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setAnimatedPasterList(list);
    }

    public static /* synthetic */ void lambda$setAudioBitrate$53(TXVideoEditer tXVideoEditer, int i11) {
        LiteavLog.i(TAG, "setAudioBitrate: bitrate= ".concat(String.valueOf(i11)));
        tXVideoEditer.mAudioEncodeBitrate = i11;
    }

    public static /* synthetic */ void lambda$setBGM$11(TXVideoEditer tXVideoEditer, String str, boolean z11) {
        tXVideoEditer.mAudioProcessor.setBGM(str);
        tXVideoEditer.doStopPlayInner();
        if (z11) {
            tXVideoEditer.mBGMFormat = null;
            tXVideoEditer.mHasBGM = false;
            if (CollectionUtils.isEmpty((Collection<?>) tXVideoEditer.mAudioFormatList)) {
                tXVideoEditer.mAVSyncer.setAudioExist(false);
                UGCAVSyncer.SyncMode syncMode = UGCAVSyncer.SyncMode.VIDEO_MASTER;
                tXVideoEditer.mPreviewSyncMode = syncMode;
                tXVideoEditer.mAVSyncer.setSyncMode(syncMode);
                return;
            }
            return;
        }
        tXVideoEditer.mHasBGM = true;
        MediaExtractor build = new MediaExtractorBuilder().setPath(str).setMimeType("audio/").build();
        if (build == null) {
            LiteavLog.w(TAG, "setBGM: build extractor fail.");
            return;
        }
        tXVideoEditer.mBGMFormat = build.getTrackFormat(build.getSampleTrackIndex());
        tXVideoEditer.mAVSyncer.setAudioExist(true);
        UGCAVSyncer.SyncMode syncMode2 = UGCAVSyncer.SyncMode.AUDIO_MASTER;
        tXVideoEditer.mPreviewSyncMode = syncMode2;
        tXVideoEditer.mAVSyncer.setSyncMode(syncMode2);
    }

    public static /* synthetic */ void lambda$setBGMAtVideoTime$13(TXVideoEditer tXVideoEditer, long j11) {
        LiteavLog.i(TAG, "setBGMAtVideoTime: videoStartTime= ".concat(String.valueOf(j11)));
        tXVideoEditer.mAudioProcessor.setBGMAtVideoTime(j11);
    }

    public static /* synthetic */ void lambda$setBGMFadeInOutDuration$16(TXVideoEditer tXVideoEditer, long j11, long j12) {
        LiteavLog.i(TAG, "setBGMFadeInOutDuration: fadeInDuration= " + j11 + ",fadeOutDuration= " + j12);
        tXVideoEditer.mAudioProcessor.setFadeInOutDuration(j11, j12);
    }

    public static /* synthetic */ void lambda$setBGMLoop$12(TXVideoEditer tXVideoEditer, boolean z11) {
        LiteavLog.i(TAG, "setBGMLoop: looping= ".concat(String.valueOf(z11)));
        tXVideoEditer.mAudioProcessor.setBGMLoop(z11);
    }

    public static /* synthetic */ void lambda$setBGMStartTime$14(TXVideoEditer tXVideoEditer, long j11, long j12) {
        LiteavLog.i(TAG, "setBGMStartTime: startTime= " + j11 + ", endTime= " + j12);
        tXVideoEditer.mAudioProcessor.setBGMStartTime(j11, j12);
    }

    public static /* synthetic */ void lambda$setBGMVolume$15(TXVideoEditer tXVideoEditer, float f11) {
        LiteavLog.i(TAG, "setBGMVolume: ".concat(String.valueOf(f11)));
        tXVideoEditer.mAudioProcessor.setBGMVolume(f11);
    }

    public static /* synthetic */ void lambda$setBeautyFilter$8(TXVideoEditer tXVideoEditer, int i11, int i12) {
        LiteavLog.i(TAG, "setBeautyFilter: beautyLevel= " + i11 + ",whiteningLevel= " + i12);
        tXVideoEditer.mVideoProcessor.setBeautyFilter(i11, i12);
    }

    public static /* synthetic */ void lambda$setCustomVideoProcessListener$3(TXVideoEditer tXVideoEditer, TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        LiteavLog.i(TAG, "setCustomVideoProcessListener: ".concat(String.valueOf(tXVideoCustomProcessListener)));
        tXVideoEditer.mVideoProcessor.setCustomVideoProcessListener(tXVideoCustomProcessListener);
    }

    public static /* synthetic */ void lambda$setCutFromTime$51(TXVideoEditer tXVideoEditer, long j11, long j12) {
        LiteavLog.i(TAG, "setCutFromTime: startTime= " + j11 + ",endTime= " + j12);
        tXVideoEditer.mCutStartTimeMs = j11;
        tXVideoEditer.mCutEndTimeMs = j12;
    }

    public static /* synthetic */ void lambda$setFilter$6(TXVideoEditer tXVideoEditer, Bitmap bitmap) {
        float f11;
        float f12;
        LiteavLog.i(TAG, "setFilter: ".concat(String.valueOf(bitmap)));
        CombineFilterInfo combineFilterInfo = tXVideoEditer.mCombineFilterInfo;
        if (combineFilterInfo != null) {
            f12 = combineFilterInfo.getLeftSpecialRatio();
            f11 = tXVideoEditer.mCombineFilterInfo.getRightSpecialRatio();
        } else {
            f12 = 0.5f;
            f11 = 0.0f;
        }
        tXVideoEditer.setFilter(bitmap, f12, (Bitmap) null, f11, 1.0f);
    }

    public static /* synthetic */ void lambda$setFilter$7(TXVideoEditer tXVideoEditer, float f11, float f12, float f13, Bitmap bitmap, Bitmap bitmap2) {
        LiteavLog.i(TAG, "setFilter: leftIntensity= " + f11 + ",rightIntensity= " + f12 + ",leftRatio= " + f13);
        tXVideoEditer.mVideoProcessor.setFilter(bitmap, f11, bitmap2, f12, f13);
    }

    public static /* synthetic */ void lambda$setIsSplitScreen$56(TXVideoEditer tXVideoEditer, boolean z11) {
        tXVideoEditer.mMediaListSource.setIsSplitScreenMode(z11);
        if (!z11) {
            tXVideoEditer.mVideoProcessor.setSplitScreenList((List<TXVideoEditConstants.TXAbsoluteRect>) null, -1, -1);
            tXVideoEditer.mEncodeResolution = null;
        }
    }

    public static /* synthetic */ void lambda$setPasterList$21(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setPasterList");
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setPasterList(list);
    }

    public static /* synthetic */ void lambda$setPictureList$9(TXVideoEditer tXVideoEditer, int i11, List list) {
        LiteavLog.i(TAG, "setPictureList: fps= " + i11 + ",bitmapList.size= " + list.size());
        tXVideoEditer.mMediaListSource.setPictureList(list, i11);
        tXVideoEditer.mEncodeResolution = new Size(720, 1280);
    }

    public static /* synthetic */ void lambda$setPictureTransition$10(TXVideoEditer tXVideoEditer, int i11) {
        LiteavLog.i(TAG, "setPictureTransition: ".concat(String.valueOf(i11)));
        tXVideoEditer.mMediaListSource.setPictureTransition(i11);
        tXVideoEditer.mVideoProcessor.setPictureTransition(i11);
    }

    public static /* synthetic */ void lambda$setProfile$4(TXVideoEditer tXVideoEditer, int i11) {
        LiteavLog.i(TAG, "setProfile: ".concat(String.valueOf(i11)));
        tXVideoEditer.mEncodeProfile = i11;
    }

    public static /* synthetic */ void lambda$setRenderRotation$22(TXVideoEditer tXVideoEditer, int i11) {
        LiteavLog.i(TAG, "setRenderRotation: rotation= ".concat(String.valueOf(i11)));
        k a11 = k.a(i11);
        tXVideoEditer.mRotation = a11;
        if (!tXVideoEditer.mIsGenerating) {
            tXVideoEditer.mVideoProcessor.setRenderRotation(a11);
        }
    }

    public static /* synthetic */ void lambda$setRepeatPlay$24(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setRepeatPlay");
        tXVideoEditer.mMediaListSource.setRepeatPlay(list);
    }

    public static /* synthetic */ void lambda$setReverse$25(TXVideoEditer tXVideoEditer, boolean z11) {
        LiteavLog.i(TAG, "setReverse: isReverse= ".concat(String.valueOf(z11)));
        tXVideoEditer.mIsReverse = z11;
        tXVideoEditer.mMediaListSource.setReverse(z11);
        tXVideoEditer.mVideoProcessor.setReverse(z11);
        tXVideoEditer.mVideoProcessor.getEffectProcessor().setReverse(z11, tXVideoEditer.mMediaListSource.getDuration());
        tXVideoEditer.mVideoProcessor.getTransitionProcessor().setReverse(z11, tXVideoEditer.mMediaListSource.getDuration());
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setReverse(z11, tXVideoEditer.mMediaListSource.getDuration());
        tXVideoEditer.doStopPlayInner();
    }

    public static /* synthetic */ void lambda$setSpecialRatio$5(TXVideoEditer tXVideoEditer, float f11) {
        LiteavLog.i(TAG, "setSpecialRatio: ".concat(String.valueOf(f11)));
        if (tXVideoEditer.mCombineFilterInfo == null) {
            tXVideoEditer.mCombineFilterInfo = new CombineFilterInfo();
        }
        tXVideoEditer.mCombineFilterInfo.setLeftSpecialRatio(f11);
        tXVideoEditer.mCombineFilterInfo.setRightSpecialRatio(0.0f);
        tXVideoEditer.mVideoProcessor.setSpecialRatio(f11);
    }

    public static /* synthetic */ void lambda$setSpeedList$23(TXVideoEditer tXVideoEditer, List list) {
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                TXVideoEditConstants.TXSpeed tXSpeed = (TXVideoEditConstants.TXSpeed) it2.next();
                LiteavLog.i(TAG, "setSpeedList " + tXSpeed.startTime + " " + tXSpeed.endTime + " speed: " + tXSpeed.speedLevel);
            }
        }
        tXVideoEditer.mVideoProcessor.setSpeedList(list);
        tXVideoEditer.mAudioProcessor.setSpeedList(list);
        tXVideoEditer.mMediaListSource.setSpeedList(list);
    }

    public static /* synthetic */ void lambda$setSplitScreenList$58(TXVideoEditer tXVideoEditer, List list, int i11, int i12) {
        tXVideoEditer.mVideoProcessor.setSplitScreenList(list, i11, i12);
        tXVideoEditer.mEncodeResolution = new Size(i11, i12);
    }

    public static /* synthetic */ void lambda$setSubtitleList$19(TXVideoEditer tXVideoEditer, List list) {
        LiteavLog.i(TAG, "setSubtitleList");
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setSubtitleList(list);
    }

    public static /* synthetic */ void lambda$setTXVideoPreviewListener$42(TXVideoEditer tXVideoEditer, TXVideoPreviewListener tXVideoPreviewListener) {
        LiteavLog.i(TAG, "setTXVideoPreviewListener: listener= ".concat(String.valueOf(tXVideoPreviewListener)));
        tXVideoEditer.mVideoPreviewListener = tXVideoPreviewListener;
    }

    public static /* synthetic */ void lambda$setTailWaterMark$18(TXVideoEditer tXVideoEditer, int i11, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        LiteavLog.i(TAG, "setTailWaterMark: duration= ".concat(String.valueOf(i11)));
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setTailWaterMark(bitmap, tXRect, tXVideoEditer.mMediaListSource.getDuration(), i11);
        tXVideoEditer.mMediaListSource.setTailWaterMarkDurationSecond(i11);
    }

    public static /* synthetic */ void lambda$setThumbnail$35(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXThumbnail tXThumbnail) {
        LiteavLog.i(TAG, "setThumbnail: thumbnail.count= " + tXThumbnail.count + " ,thumbnail.width= " + tXThumbnail.width + " ,thumbnail.height= " + tXThumbnail.height);
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams = new UGCThumbnailGenerator.UGCThumbnailGenerateParams();
        tXVideoEditer.mProcessThumbnailInfo = uGCThumbnailGenerateParams;
        uGCThumbnailGenerateParams.thumbnailCount = tXThumbnail.count;
        uGCThumbnailGenerateParams.width = tXThumbnail.width;
        uGCThumbnailGenerateParams.height = tXThumbnail.height;
        uGCThumbnailGenerateParams.fast = false;
    }

    public static /* synthetic */ void lambda$setThumbnailListener$36(TXVideoEditer tXVideoEditer, TXThumbnailListener tXThumbnailListener) {
        LiteavLog.i(TAG, "setThumbnailListener: listener= ".concat(String.valueOf(tXThumbnailListener)));
        tXVideoEditer.mProcessThumbnailListener = tXThumbnailListener;
    }

    public static /* synthetic */ void lambda$setTransitionEffect$26(TXVideoEditer tXVideoEditer, int i11, long j11, long j12, AtomicBoolean atomicBoolean) {
        LiteavLog.i(TAG, "setTransitionEffect: type=" + i11 + " ,startTimeMs= " + j11 + " ,transitionDurationMs= " + j12);
        atomicBoolean.set(tXVideoEditer.mVideoProcessor.getTransitionProcessor().setTransitionEffect(i11, tXVideoEditer.mMediaListSource.getDuration(), j11, j12));
    }

    public static /* synthetic */ void lambda$setVideoBitrate$52(TXVideoEditer tXVideoEditer, int i11) {
        LiteavLog.i(TAG, "setVideoBitrate: bitrate= ".concat(String.valueOf(i11)));
        tXVideoEditer.mVideoEncodeBitrate = i11;
    }

    public static /* synthetic */ void lambda$setVideoGenerateListener$50(TXVideoEditer tXVideoEditer, TXVideoGenerateListener tXVideoGenerateListener) {
        LiteavLog.i(TAG, "setVideoGenerateListener: listener= ".concat(String.valueOf(tXVideoGenerateListener)));
        tXVideoEditer.mVideoGenerateListener = tXVideoGenerateListener;
    }

    public static /* synthetic */ void lambda$setVideoProcessListener$32(TXVideoEditer tXVideoEditer, TXVideoProcessListener tXVideoProcessListener) {
        LiteavLog.i(TAG, "setVideoProcessListener: listener= ".concat(String.valueOf(tXVideoProcessListener)));
        tXVideoEditer.mVideoProcessListener = tXVideoProcessListener;
    }

    public static /* synthetic */ void lambda$setVideoVolume$63(TXVideoEditer tXVideoEditer, float f11) {
        LiteavLog.i(TAG, "setVideoVolume: volume= ".concat(String.valueOf(f11)));
        tXVideoEditer.mAudioProcessor.setVideoVolume(f11);
    }

    public static /* synthetic */ void lambda$setWaterMark$17(TXVideoEditer tXVideoEditer, TXVideoEditConstants.TXRect tXRect, Bitmap bitmap) {
        LiteavLog.i(TAG, "setWaterMark: " + tXRect.toString());
        tXVideoEditer.mVideoProcessor.getWatermarkProcessor().setWaterMark(bitmap, tXRect);
    }

    public static /* synthetic */ void lambda$startEffect$28(TXVideoEditer tXVideoEditer, int i11, long j11) {
        LiteavLog.i(TAG, "startEffect: type=" + i11 + ",startTime= " + j11);
        tXVideoEditer.mVideoProcessor.getEffectProcessor().startEffect(i11, j11);
    }

    public static /* synthetic */ void lambda$startPlayFromTime$45(TXVideoEditer tXVideoEditer, long j11, long j12) {
        LiteavLog.i(TAG, "startPlayFromTime: startTime= " + j11 + ", endTime= " + j12);
        tXVideoEditer.doStopPlayInner();
        Size size = tXVideoEditer.mEncodeResolution;
        if (size == null) {
            tXVideoEditer.mVideoProcessor.setOutputSize(-1, -1, GLConstants.GLScaleType.FIT_CENTER);
        } else {
            tXVideoEditer.mVideoProcessor.setOutputSize(size.width, size.height, GLConstants.GLScaleType.FIT_CENTER);
        }
        tXVideoEditer.mIsAudioEnd = false;
        tXVideoEditer.mIsVideoEnd = false;
        tXVideoEditer.mAVSyncer.setSyncMode(tXVideoEditer.mPreviewSyncMode);
        tXVideoEditer.mAVSyncer.start();
        if (tXVideoEditer.mSourceRangeStartTimeMs != 0 || ((j12 != tXVideoEditer.mSourceRangeEndTimeMs && j12 >= 0) || tXVideoEditer.mIsReverse)) {
            tXVideoEditer.mSourceRangeStartTimeMs = 0;
            tXVideoEditer.mSourceRangeEndTimeMs = j12;
            if (tXVideoEditer.mIsReverse) {
                tXVideoEditer.mSourceRangeStartTimeMs = j11;
            }
        }
        if (!tXVideoEditer.mIsReverse) {
            tXVideoEditer.mMediaListSource.seekTo(j11);
            tXVideoEditer.mMediaListSource.setPlayEndTime(j12);
        } else {
            tXVideoEditer.mMediaListSource.seekTo(j12);
            tXVideoEditer.mMediaListSource.setPlayEndTime(Long.MAX_VALUE);
        }
        tXVideoEditer.mVideoProcessor.setProgressListener(tXVideoEditer.mVideoProcessProgressListener);
        tXVideoEditer.mVideoProcessor.setRenderRotation(tXVideoEditer.mRotation);
        tXVideoEditer.mVideoProcessor.start(false, VideoEncoderDef.EncoderType.HARDWARE);
        tXVideoEditer.mAudioProcessor.start(false);
        tXVideoEditer.mIsProcessToFullKeyFrame = false;
        tXVideoEditer.mIsGenerating = false;
        tXVideoEditer.mIsVideoEncoderStarted = false;
        tXVideoEditer.mIsAudioEncoderStarted = false;
        tXVideoEditer.mIsPlaying = true;
        tXVideoEditer.mTargetSeekPts.set((Object) null);
    }

    public static /* synthetic */ void lambda$stopEffect$29(TXVideoEditer tXVideoEditer, int i11, long j11) {
        LiteavLog.i(TAG, "stopEffect");
        tXVideoEditer.mVideoProcessor.getEffectProcessor().stopEffect(i11, j11);
    }

    public static /* synthetic */ void lambda$stopPlay$48(TXVideoEditer tXVideoEditer) {
        LiteavLog.i(TAG, "stopPlay");
        tXVideoEditer.doStopPlayInner();
    }

    private void notifyGenerateComplete(int i11, long j11) {
        TXVideoGenerateListener tXVideoGenerateListener = this.mVideoGenerateListener;
        if (!TextUtils.isEmpty(this.mProcessOutputPath) && new File(this.mProcessOutputPath).exists()) {
            UGCDataReport.reportDAU(1032, (int) new File(this.mProcessOutputPath).length(), "");
            UGCDataReport.reportDAU(1033, (int) j11, "");
        }
        if (tXVideoGenerateListener != null) {
            this.mMainHandler.post(bs.a(i11, tXVideoGenerateListener));
        }
    }

    private void notifyGenerateProgress(float f11) {
        TXVideoGenerateListener tXVideoGenerateListener = this.mVideoGenerateListener;
        if (tXVideoGenerateListener != null) {
            this.mMainHandler.post(br.a(tXVideoGenerateListener, f11));
        }
    }

    private void notifyPreviewFinished() {
        TXVideoPreviewListener tXVideoPreviewListener = this.mVideoPreviewListener;
        if (tXVideoPreviewListener != null) {
            this.mMainHandler.post(bm.a(tXVideoPreviewListener));
        }
    }

    /* access modifiers changed from: private */
    public void notifyPreviewProgress(int i11) {
        TXVideoPreviewListener tXVideoPreviewListener = this.mVideoPreviewListener;
        if (tXVideoPreviewListener != null) {
            this.mMainHandler.post(bl.a(this, i11, tXVideoPreviewListener));
        }
    }

    private void notifyProcessComplete(int i11, boolean z11) {
        LiteavLog.i(TAG, "notifyProcessComplete: resultCode:" + i11 + " isThumbnailProcessFinish:" + z11);
        this.mHasNotifyProcessComplete.set(false);
        if (z11) {
            this.mNeedWaitThumbnailProcess = false;
        } else {
            this.mNeedWaitProcessFullI = false;
        }
        if (!this.mNeedWaitProcessFullI && !this.mNeedWaitThumbnailProcess) {
            this.mMainHandler.post(bo.a(this, i11));
        } else if (this.mNeedWaitThumbnailProcess) {
            this.mMainHandler.postDelayed(bn.a(this, i11), 500);
        }
    }

    private void notifyProcessProgress(float f11) {
        TXVideoProcessListener tXVideoProcessListener = this.mVideoProcessListener;
        if (tXVideoProcessListener != null) {
            this.mMainHandler.post(bp.a(tXVideoProcessListener, f11));
        }
    }

    /* access modifiers changed from: private */
    public void onAudioEncodedFrame(AudioFrame audioFrame) {
        MP4Writer mP4Writer = this.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.writeAudioFrame(audioFrame);
        }
    }

    /* access modifiers changed from: private */
    public void onAudioEncodedFrameComplete() {
        LiteavLog.i(TAG, "onAudioEncodedFrameComplete end flag = " + this.mIsAudioEnd);
        if (!this.mIsAudioEnd) {
            this.mIsAudioEnd = true;
            this.mAVSyncer.setAudioEos();
            handleEncodedCompletedInner();
        }
    }

    private void onPlayProgressEnd() {
        LiteavLog.i(TAG, "onProgressEnd mIsPreviewAudioEnd=" + this.mIsAudioEnd + " mIsPreviewVideoEnd=" + this.mIsVideoEnd);
        if (this.mIsAudioEnd && this.mIsVideoEnd) {
            this.mAVSyncer.stop();
            notifyPreviewFinished();
        }
    }

    /* access modifiers changed from: private */
    public void onVideoEncodedFail(VideoEncoderDef.EncoderType encoderType) {
        LiteavLog.i(TAG, "on video encoded fail. encoder type is ".concat(String.valueOf(encoderType)));
        if (encoderType == VideoEncoderDef.EncoderType.HARDWARE) {
            startProcessVideo(VideoEncoderDef.EncoderType.SOFTWARE);
        } else {
            onVideoEncodedFrameComplete();
        }
    }

    /* access modifiers changed from: private */
    public void onVideoEncodedFrame(EncodedVideoFrame encodedVideoFrame) {
        MP4Writer mP4Writer = this.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.writeVideoFrame(encodedVideoFrame);
        }
        float calculateProgress = calculateProgress(encodedVideoFrame.pts);
        if (calculateProgress >= this.mLastVideoEncodeProgress) {
            this.mLastVideoEncodeProgress = calculateProgress;
            if (this.mIsProcessToFullKeyFrame) {
                notifyProcessProgress(calculateProgress);
            } else {
                notifyGenerateProgress(calculateProgress);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onVideoEncodedFrameComplete() {
        LiteavLog.i(TAG, "onVideoEncodedFrameComplete end flag = " + this.mIsVideoEnd);
        if (!this.mIsVideoEnd) {
            this.mAVSyncer.setVideoEos();
            this.mIsVideoEnd = true;
            handleEncodedCompletedInner();
        }
    }

    /* access modifiers changed from: private */
    public void processVideoInternal() {
        if (!UGCLicenseChecker.isSimpleFunctionSupport()) {
            this.mMainHandler.post(ai.a(this.mVideoProcessListener));
            return;
        }
        UGCDataReport.reportDAU(1034);
        LiteavLog.i(TAG, "processVideoInternal");
        String generateVideoPath = generateVideoPath();
        this.mProcessOutputPath = generateVideoPath;
        this.mRecordOutputPath = generateVideoPath;
        boolean isFullIFrame = isFullIFrame(this.mSourcePath);
        UGCTranscodeVideoEncodeParamsDecider uGCTranscodeVideoEncodeParamsDecider = new UGCTranscodeVideoEncodeParamsDecider();
        uGCTranscodeVideoEncodeParamsDecider.setSourceType(UGCConstants.SourceType.VIDEO);
        uGCTranscodeVideoEncodeParamsDecider.setFullIFrame(true);
        uGCTranscodeVideoEncodeParamsDecider.setEncodeRotation(this.mRotation);
        uGCTranscodeVideoEncodeParamsDecider.setOutputResolution(4);
        uGCTranscodeVideoEncodeParamsDecider.setInputVideoMediaFormat(this.mVideoFormatList);
        this.mVideoEncodeParams = uGCTranscodeVideoEncodeParamsDecider.getDecidedEncodeParams();
        UGCTranscodeAudioEncodeParamsDecider uGCTranscodeAudioEncodeParamsDecider = new UGCTranscodeAudioEncodeParamsDecider();
        uGCTranscodeAudioEncodeParamsDecider.setInputAudioMediaFormat(this.mAudioFormatList);
        this.mAudioEncodeParams = uGCTranscodeAudioEncodeParamsDecider.getDecidedEncodeParams();
        boolean isGopEqualOne = isGopEqualOne(this.mSourcePath);
        LiteavLog.i(TAG, "processVideoInternal: hasIFramePerMinute= " + isGopEqualOne + ", inputFullIFrame= " + isFullIFrame + ",mProcessOutputPath= " + this.mProcessOutputPath);
        this.mIsProcessToFullKeyFrame = true;
        this.mNeedWaitProcessFullI = true;
        this.mLastVideoEncodeProgress = 0.0f;
        if (!isFullIFrame) {
            startProcessVideo(VideoEncoderDef.EncoderType.HARDWARE);
        }
        startThumbnailGeneratorByProcess(this.mVideoEncodeParams, isFullIFrame);
    }

    /* access modifiers changed from: private */
    public void releaseThumbnailGenerator(UGCThumbnailGenerator uGCThumbnailGenerator) {
        if (this.mAllThumbnailGeneratorList.size() > 0 && this.mAllThumbnailGeneratorList.contains(uGCThumbnailGenerator)) {
            uGCThumbnailGenerator.stop();
            uGCThumbnailGenerator.uninitialize();
            this.mAllThumbnailGeneratorList.remove(uGCThumbnailGenerator);
        }
    }

    /* access modifiers changed from: private */
    public void setMediaSourcePathsInternal(List<String> list) {
        Size size = this.mEncodeResolution;
        if (size == null) {
            this.mVideoProcessor.setOutputSize(-1, -1, GLConstants.GLScaleType.FIT_CENTER);
        } else {
            this.mVideoProcessor.setOutputSize(size.width, size.height, GLConstants.GLScaleType.FIT_CENTER);
        }
        this.mVideoSourceList = list;
        this.mMediaListSource.setVideoSources(list);
        this.mSourcePath = list.get(0);
        this.mVideoFormatList = new LinkedList();
        this.mAudioFormatList = new LinkedList();
        getAllMediaFormatFromSource(list);
        if (!CollectionUtils.isEmpty((Collection<?>) this.mVideoFormatList)) {
            this.mAVSyncer.setVideoExist(true);
        }
        if (!CollectionUtils.isEmpty((Collection<?>) this.mAudioFormatList)) {
            this.mAVSyncer.setAudioExist(true);
        }
        if (CollectionUtils.isEmpty((Collection<?>) this.mAudioFormatList)) {
            this.mPreviewSyncMode = UGCAVSyncer.SyncMode.VIDEO_MASTER;
        } else if (list.size() > 1) {
            this.mPreviewSyncMode = UGCAVSyncer.SyncMode.CLOCK_MASTER;
        } else {
            this.mPreviewSyncMode = UGCAVSyncer.SyncMode.AUDIO_MASTER;
        }
    }

    private void startMP4Writer(String str) {
        LiteavLog.i(TAG, "startMP4Writer ".concat(String.valueOf(str)));
        MP4Writer mP4Writer = new MP4Writer();
        this.mMp4Writer = mP4Writer;
        mP4Writer.setListener(this.mMp4WriterListener);
        if (!CollectionUtils.isEmpty((Collection<?>) this.mAudioFormatList) || this.mHasBGM) {
            this.mMp4Writer.setHasAudio(true);
        }
        this.mMp4Writer.setHasVideo(true);
        this.mMp4Writer.setPath(str);
        this.mMp4Writer.start();
    }

    private void startProcessVideo(VideoEncoderDef.EncoderType encoderType) {
        doStopPlayInner();
        MP4Writer mP4Writer = this.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.setListener((MP4Writer.MP4WriterListener) null);
            this.mMp4Writer.stop();
        }
        this.mIsGenerating = true;
        startMP4Writer(this.mRecordOutputPath);
        this.mIsVideoEncoderStarted = false;
        this.mIsAudioEncoderStarted = false;
        this.mVideoProcessor.setVideoEncodedFrameListener(this.mVideoEncodedFrameListener);
        this.mAudioProcessor.setAudioEncodedFrameListener(this.mAudioEncodedFrameListener);
        this.mAVSyncer.setSyncMode(UGCAVSyncer.SyncMode.INTERLEAVE_OUTPUT_WITHOUT_SKIP);
        this.mAVSyncer.start();
        this.mIsAudioEnd = false;
        this.mIsVideoEnd = false;
        this.mMediaListSource.setPlayEndTime(Long.MAX_VALUE);
        this.mMediaListSource.setVideoSourceRange(this.mCutStartTimeMs, this.mCutEndTimeMs);
        UGCVideoProcessor uGCVideoProcessor = this.mVideoProcessor;
        VideoEncodeParams videoEncodeParams = this.mVideoEncodeParams;
        uGCVideoProcessor.setOutputSize(videoEncodeParams.width, videoEncodeParams.height, GLConstants.GLScaleType.FIT_CENTER);
        this.mVideoProcessor.setEncodeParams(this.mVideoEncodeParams);
        this.mVideoProcessor.start(true, encoderType);
        this.mAudioProcessor.setEncodeParams(this.mAudioEncodeParams);
        this.mAudioProcessor.start(true);
    }

    private void startThumbnailGeneratorByProcess(VideoEncodeParams videoEncodeParams, boolean z11) {
        UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams = this.mProcessThumbnailInfo;
        if (uGCThumbnailGenerateParams != null) {
            if (uGCThumbnailGenerateParams.width == 0 || uGCThumbnailGenerateParams.height == 0) {
                uGCThumbnailGenerateParams.width = videoEncodeParams.width;
                uGCThumbnailGenerateParams.height = videoEncodeParams.height;
            }
            UGCThumbnailGenerator uGCThumbnailGenerator = new UGCThumbnailGenerator();
            uGCThumbnailGenerator.initialize();
            uGCThumbnailGenerator.setVideoSourceList(this.mVideoSourceList);
            uGCThumbnailGenerator.setVideoSourceRange(this.mCutStartTimeMs, this.mCutEndTimeMs);
            UGCThumbnailGenerator.UGCThumbnailGenerateParams uGCThumbnailGenerateParams2 = this.mProcessThumbnailInfo;
            uGCThumbnailGenerateParams2.thumbnailPtsList = UGCThumbnailGenerator.calculateThumbnailList(uGCThumbnailGenerateParams2.thumbnailCount, 0, this.mCutEndTimeMs - this.mCutStartTimeMs, this.mMediaListSource.getDuration());
            this.mNeedWaitThumbnailProcess = true;
            uGCThumbnailGenerator.start(this.mProcessThumbnailInfo, ak.a(this, uGCThumbnailGenerator, z11));
            this.mAllThumbnailGeneratorList.add(uGCThumbnailGenerator);
        }
    }

    private void stopMp4Writer() {
        LiteavLog.i(TAG, "stopMp4Writer");
        MP4Writer mP4Writer = this.mMp4Writer;
        if (mP4Writer != null) {
            mP4Writer.stop();
            this.mMp4Writer = null;
        }
    }

    public void cancel() {
        this.mSequenceTaskRunner.a(ba.a(this));
    }

    public void deleteAllEffect() {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "deleteAllEffect is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(ab.a(this));
        }
    }

    public void deleteLastEffect() {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "deleteLastEffect is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(aa.a(this));
        }
    }

    public void deleteLastTransitionEffect() {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "deleteLastTransitionEffect is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(w.a(this));
        }
    }

    public void generateVideo(int i11, String str) {
        this.mSequenceTaskRunner.a(az.a(this, i11, str));
    }

    public long getDuration() {
        return this.mMediaListSource.getDuration();
    }

    public void getThumbnail(List<Long> list, int i11, int i12, boolean z11, TXThumbnailListener tXThumbnailListener) {
        this.mSequenceTaskRunner.a(ad.a(this, list, i11, i12, z11, tXThumbnailListener));
    }

    public int getThumbnailCount() {
        LiteavLog.i(TAG, "getThumbnailCount");
        List<Long> list = this.mProcessThumbnailInfo.thumbnailPtsList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public String getVideoProcessPath() {
        LiteavLog.i(TAG, "getVideoProcessPath: process output path= " + this.mProcessOutputPath);
        return this.mProcessOutputPath;
    }

    public String getVideoSourcePath() {
        LiteavLog.i(TAG, "getVideoSourcePath: sourcePath= " + this.mSourcePath);
        return this.mSourcePath;
    }

    public void initWithPreview(TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        if (tXPreviewParam == null) {
            LiteavLog.i(TAG, "initWithPreview param is null.");
            return;
        }
        LiteavLog.i(TAG, "initWithPreview: view= " + tXPreviewParam.videoView + " renderMode= " + tXPreviewParam.renderMode);
        this.mMainHandler.runOrPost(ao.a(this, tXPreviewParam));
    }

    public boolean isHasAudio() {
        return this.mMediaListSource.hasAudioData();
    }

    public void pausePlay() {
        this.mSequenceTaskRunner.a(aq.a(this));
    }

    public void previewAtTime(long j11) {
        this.mPendingPreviewAtTime.set(Long.valueOf(j11));
        this.mTargetSeekPts.set(Long.valueOf(j11));
        this.mSequenceTaskRunner.a(at.a(this));
    }

    public void processVideo() {
        this.mSequenceTaskRunner.a(ah.a(this));
    }

    public void refreshOneFrame() {
        LiteavLog.i(TAG, "refreshOneFrame");
        this.mSequenceTaskRunner.a(bi.a(this));
    }

    public void release() {
        this.mSequenceTaskRunner.a(am.a(this));
    }

    public void resumePlay() {
        this.mSequenceTaskRunner.a(ar.a(this));
    }

    public void setAnimatedPasterList(List<TXVideoEditConstants.TXAnimatedPaster> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setAnimatedPasterList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1026);
        this.mSequenceTaskRunner.a(p.a(this, list));
    }

    @Deprecated
    public void setAudioBitrate(int i11) {
        this.mSequenceTaskRunner.a(ay.a(this, i11));
    }

    public int setBGM(String str) {
        boolean z11;
        int i11;
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGM is not supported in UGC_Smart license");
            return 0;
        }
        LiteavLog.i(TAG, "setBGM: path= ".concat(String.valueOf(str)));
        if (!TextUtils.isEmpty(str)) {
            i11 = isBGMValid(str);
            z11 = false;
        } else {
            LiteavLog.e(TAG, " setBGM: bgm path is empty.");
            z11 = true;
            i11 = 0;
        }
        if (i11 != 0) {
            LiteavLog.e(TAG, " bgm file is invalid. error code  ".concat(String.valueOf(i11)));
            return i11;
        }
        this.mSequenceTaskRunner.a(f.a(this, str, z11));
        UGCDataReport.reportDAU(1024);
        return 0;
    }

    public void setBGMAtVideoTime(long j11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMAtVideoTime is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(h.a(this, j11));
        }
    }

    public void setBGMFadeInOutDuration(long j11, long j12) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMFadeInOutDuration is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(k.a(this, j11, j12));
        }
    }

    public void setBGMLoop(boolean z11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMLoop is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(g.a(this, z11));
        }
    }

    public void setBGMStartTime(long j11, long j12) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMStartTime is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(i.a(this, j11, j12));
        }
    }

    public void setBGMVolume(float f11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBGMVolume is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(j.a(this, f11));
        }
    }

    public void setBeautyFilter(int i11, int i12) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setBeautyFilter is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(bw.a(this, i11, i12));
        }
    }

    public void setCustomVideoProcessListener(TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setCustomVideoProcessListener is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(aj.a(this, tXVideoCustomProcessListener));
        }
    }

    public void setCutFromTime(long j11, long j12) {
        this.mSequenceTaskRunner.a(aw.a(this, j11, j12));
        UGCDataReport.reportDAU(1018);
    }

    public void setDurationControlMode(TXVideoJoiner.DurationControlMode durationControlMode) {
        LiteavLog.i(TAG, "set duration control mode ".concat(String.valueOf(durationControlMode)));
        this.mSequenceTaskRunner.a(bc.a(this, durationControlMode));
    }

    public void setFilter(Bitmap bitmap) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setFilter is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1023);
        this.mSequenceTaskRunner.a(bq.a(this, bitmap));
    }

    public void setIsFullIFrame(boolean z11) {
        this.mSequenceTaskRunner.a(bg.a(this, z11));
    }

    public void setIsSplitScreen(boolean z11) {
        this.mSequenceTaskRunner.a(bb.a(this, z11));
    }

    public void setMediaSourcePaths(List<String> list) {
        this.mSequenceTaskRunner.a(bh.a(this, list));
    }

    public void setPasterList(List<TXVideoEditConstants.TXPaster> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPasterList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1025);
        this.mSequenceTaskRunner.a(q.a(this, list));
    }

    public int setPictureList(List<Bitmap> list, int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPictureList is not supported in UGC_Smart license");
            return -1;
        }
        UGCDataReport.reportDAU(1030);
        this.mSequenceTaskRunner.a(d.a(this, i11, list));
        return 0;
    }

    public long setPictureTransition(int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setPictureTransition is not supported in UGC_Smart license");
            return 0;
        }
        this.mSequenceTaskRunner.b(e.a(this, i11));
        return this.mMediaListSource.getDuration();
    }

    public void setProfile(int i11) {
        this.mSequenceTaskRunner.a(au.a(this, i11));
    }

    public void setRenderRotation(int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setRenderRotation is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(r.a(this, i11));
        }
    }

    public void setRepeatPlay(List<TXVideoEditConstants.TXRepeat> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setRepeatPlay is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1020);
        this.mSequenceTaskRunner.a(t.a(this, list));
    }

    public void setReverse(boolean z11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setReverse is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1021);
        this.mSequenceTaskRunner.a(u.a(this, z11));
    }

    public void setSpecialRatio(float f11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setSpecialRatio is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(bf.a(this, f11));
        }
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setSpeedList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1019);
        this.mSequenceTaskRunner.a(s.a(this, list));
    }

    public void setSplitScreenList(List<TXVideoEditConstants.TXAbsoluteRect> list, int i11, int i12) {
        this.mSequenceTaskRunner.a(bd.a(this, list, i11, i12));
    }

    public void setSubtitleList(List<TXVideoEditConstants.TXSubtitle> list) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setSubtitleList is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1027);
        this.mSequenceTaskRunner.a(o.a(this, list));
    }

    public void setTXVideoPreviewListener(TXVideoPreviewListener tXVideoPreviewListener) {
        this.mSequenceTaskRunner.a(an.a(this, tXVideoPreviewListener));
    }

    public void setTailWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, int i11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setTailWaterMark is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1029);
        this.mSequenceTaskRunner.a(m.a(this, i11, bitmap, tXRect));
    }

    public void setThumbnail(TXVideoEditConstants.TXThumbnail tXThumbnail) {
        this.mSequenceTaskRunner.a(af.a(this, tXThumbnail));
    }

    public void setThumbnailListener(TXThumbnailListener tXThumbnailListener) {
        this.mSequenceTaskRunner.a(ag.a(this, tXThumbnailListener));
    }

    public boolean setTransitionEffect(int i11, long j11, long j12) {
        return setTransitionEffect(i11, j12, j11, 1000);
    }

    public void setVideoBitrate(int i11) {
        this.mSequenceTaskRunner.a(ax.a(this, i11));
    }

    public void setVideoGenerateListener(TXVideoGenerateListener tXVideoGenerateListener) {
        this.mSequenceTaskRunner.a(av.a(this, tXVideoGenerateListener));
    }

    public int setVideoPath(String str) {
        LiteavLog.i(TAG, "setVideoPath ".concat(String.valueOf(str)));
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int isMediaSourceValid = isMediaSourceValid(str);
        if (isMediaSourceValid != 0) {
            LiteavLog.e(TAG, "setVideoPath " + str + " is illegal." + isMediaSourceValid);
            return isMediaSourceValid;
        }
        this.mSequenceTaskRunner.a(y.a(this, str));
        return 0;
    }

    public void setVideoProcessListener(TXVideoProcessListener tXVideoProcessListener) {
        this.mSequenceTaskRunner.a(ac.a(this, tXVideoProcessListener));
    }

    public void setVideoVolume(float f11) {
        this.mSequenceTaskRunner.a(bj.a(this, f11));
    }

    public void setVideoVolumes(float[] fArr) {
        this.mSequenceTaskRunner.a(be.a(this, fArr));
    }

    public void setWaterMark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setWaterMark is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1028);
        this.mSequenceTaskRunner.a(l.a(this, tXRect, bitmap));
    }

    public void startEffect(int i11, long j11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "startEffect is not supported in UGC_Smart license");
            return;
        }
        UGCDataReport.reportDAU(1022, i11, "");
        this.mSequenceTaskRunner.a(x.a(this, i11, j11));
    }

    public void startPlayFromTime(long j11, long j12) {
        this.mSequenceTaskRunner.a(ap.a(this, j11, j12));
    }

    public void stopEffect(int i11, long j11) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "stopEffect is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(z.a(this, i11, j11));
        }
    }

    public void stopPlay() {
        this.mSequenceTaskRunner.a(as.a(this));
    }

    public void getThumbnail(int i11, int i12, int i13, boolean z11, TXThumbnailListener tXThumbnailListener) {
        this.mSequenceTaskRunner.a(ae.a(this, i12, i13, z11, i11, tXThumbnailListener));
    }

    public boolean setTransitionEffect(int i11, long j11, long j12, long j13) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setTransitionEffect is not supported in UGC_Smart license");
            return false;
        }
        UGCDataReport.reportDAU(1035);
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.mSequenceTaskRunner.b(v.a(this, i11, j12, j13, atomicBoolean));
        return atomicBoolean.get();
    }

    public TXVideoEditer(Context context, l lVar) {
        this.mPendingPreviewAtTime = new AtomicReference<>();
        UGCAVSyncer uGCAVSyncer = new UGCAVSyncer();
        this.mAVSyncer = uGCAVSyncer;
        this.mTargetSeekPts = new AtomicReference<>();
        this.mIsRelease = new AtomicBoolean(false);
        this.mAllThumbnailGeneratorList = new ArrayList<>();
        this.mHasNotifyProcessComplete = new AtomicBoolean(false);
        this.mPreviewSyncMode = UGCAVSyncer.SyncMode.VIDEO_MASTER;
        this.mIsGenerating = false;
        this.mIsPlaying = false;
        this.mIsProcessToFullKeyFrame = false;
        this.mHasBGM = false;
        this.mNeedWaitProcessFullI = false;
        this.mNeedWaitThumbnailProcess = false;
        this.mLastVideoEncodeProgress = 0.0f;
        this.mMp4WriterListener = new MP4Writer.MP4WriterListener() {
            public final void onComplete(long j11) {
                LiteavLog.i(TXVideoEditer.TAG, "onComplete ".concat(String.valueOf(j11)));
                TXVideoEditer.this.handleWriteMP4Completed(0, j11);
            }

            public final void onError(String str) {
                LiteavLog.e(TXVideoEditer.TAG, "mp4 writer is error. info is ".concat(String.valueOf(str)));
                TXVideoEditer.this.handleWriteMP4Completed(-1, 0);
            }
        };
        this.mMainHandler = new CustomHandler(Looper.getMainLooper());
        this.mIsVideoEnd = false;
        this.mIsAudioEnd = false;
        this.mVideoEncodeBitrate = -1;
        this.mAudioEncodeBitrate = -1;
        this.mEncodeProfile = -1;
        this.mSourceRangeStartTimeMs = 0;
        this.mSourceRangeEndTimeMs = 2147483647L;
        this.mCutStartTimeMs = 0;
        this.mCutEndTimeMs = 2147483647L;
        this.mIsReverse = false;
        this.mIsFullIFrame = false;
        this.mRotation = k.NORMAL;
        this.mIsVideoEncoderStarted = false;
        this.mIsAudioEncoderStarted = false;
        this.mVideoEncodedFrameListener = new UGCVideoProcessor.VideoEncodedFrameListener() {
            public static /* synthetic */ void a(AnonymousClass2 r12, EncodedVideoFrame encodedVideoFrame) {
                if (!TXVideoEditer.this.mIsVideoEncoderStarted) {
                    encodedVideoFrame.release();
                } else {
                    TXVideoEditer.this.onVideoEncodedFrame(encodedVideoFrame);
                }
            }

            public final void onEncodedFail(VideoEncoderDef.EncoderType encoderType) {
                TXVideoEditer.this.mSequenceTaskRunner.a(ca.a(this, encoderType));
            }

            public final void onVideoEncodeStarted() {
                TXVideoEditer.this.mSequenceTaskRunner.a(bx.a(this));
            }

            public final void onVideoEncodingCompleted() {
                TXVideoEditer.this.mSequenceTaskRunner.a(bz.a(this));
            }

            public final void onVideoFrameEncoded(EncodedVideoFrame encodedVideoFrame) {
                if (encodedVideoFrame == null) {
                    LiteavLog.w(TXVideoEditer.TAG, "onVideoEncodedFrame frame is null.");
                } else {
                    TXVideoEditer.this.mSequenceTaskRunner.a(by.a(this, encodedVideoFrame));
                }
            }

            public static /* synthetic */ void a(AnonymousClass2 r12) {
                if (TXVideoEditer.this.mIsVideoEncoderStarted) {
                    TXVideoEditer.this.onVideoEncodedFrameComplete();
                }
            }

            public static /* synthetic */ void a(AnonymousClass2 r12, VideoEncoderDef.EncoderType encoderType) {
                if (TXVideoEditer.this.mIsVideoEncoderStarted) {
                    TXVideoEditer.this.onVideoEncodedFail(encoderType);
                }
            }
        };
        this.mAudioEncodedFrameListener = new UGCAudioProcessor.AudioEncodedFrameListener() {
            public static /* synthetic */ void a(AnonymousClass3 r12, AudioFrame audioFrame) {
                if (TXVideoEditer.this.mIsAudioEncoderStarted) {
                    TXVideoEditer.this.onAudioEncodedFrame(audioFrame);
                }
            }

            public static /* synthetic */ void b(AnonymousClass3 r22) {
                LiteavLog.i(TXVideoEditer.TAG, "on audioEncoding started");
                boolean unused = TXVideoEditer.this.mIsAudioEncoderStarted = true;
            }

            public final void onAudioEncodingCompleted() {
                TXVideoEditer.this.mSequenceTaskRunner.a(cd.a(this));
            }

            public final void onAudioEncodingStarted() {
                TXVideoEditer.this.mSequenceTaskRunner.a(cb.a(this));
            }

            public final void onAudioFrameEncoded(AudioFrame audioFrame) {
                if (audioFrame == null) {
                    LiteavLog.w(TXVideoEditer.TAG, "onAudioEncodedFrame frame is null.");
                } else {
                    TXVideoEditer.this.mSequenceTaskRunner.a(cc.a(this, audioFrame));
                }
            }

            public static /* synthetic */ void a(AnonymousClass3 r12) {
                if (TXVideoEditer.this.mIsAudioEncoderStarted) {
                    TXVideoEditer.this.onAudioEncodedFrameComplete();
                }
            }
        };
        this.mVideoProcessProgressListener = new UGCVideoProcessor.VideoProcessListener() {
            public static /* synthetic */ void a(AnonymousClass4 r82, long j11) {
                long j12 = j11 * 1000;
                if (TXVideoEditer.this.mIsReverse) {
                    j12 = (TXVideoEditer.this.mMediaListSource.getDuration() * 1000) - j12;
                }
                TXVideoEditer.this.notifyPreviewProgress((int) g.a(j12, 0, TXVideoEditer.this.mMediaListSource.getDuration() * 1000));
            }

            public final void onComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult) {
                if (tXGenerateResult != null) {
                    LiteavLog.i(TXVideoEditer.TAG, "on video progress complete: retCode= " + tXGenerateResult.retCode + ", descMsg= " + tXGenerateResult.descMsg);
                }
                TXVideoEditer tXVideoEditer = TXVideoEditer.this;
                tXVideoEditer.mSequenceTaskRunner.a(tXVideoEditer.mRunnableVideoProcessOnComplete);
            }

            public final void onProgress(long j11) {
                TXVideoEditer.this.mSequenceTaskRunner.a(ce.a(this, j11));
            }
        };
        this.mRunnableVideoProcessOnComplete = c.a(this);
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        UGCMediaListSource uGCMediaListSource = new UGCMediaListSource();
        this.mMediaListSource = uGCMediaListSource;
        this.mVideoProcessor = new UGCVideoProcessor(applicationContext, uGCMediaListSource, uGCAVSyncer, true);
        this.mAudioProcessor = new UGCAudioProcessor(uGCAVSyncer, uGCMediaListSource);
        this.mSequenceTaskRunner = lVar;
        lVar.a(n.a(this));
        UGCDataReport.reportLicenseIsValid();
    }

    public void setFilter(Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "setFilter is not supported in UGC_Smart license");
        } else {
            this.mSequenceTaskRunner.a(bv.a(this, f11, f12, f13, bitmap, bitmap2));
        }
    }
}
