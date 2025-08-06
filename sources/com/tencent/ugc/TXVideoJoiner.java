package com.tencent.ugc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;
import com.tencent.ugc.RemuxJoiner;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.videobase.utils.CollectionUtils;
import java.io.File;
import java.util.Collection;
import java.util.List;

public class TXVideoJoiner {
    private static final String TAG = "TXVideoJoiner";
    private static final int VIDEO_COMPRESSED_UNDEFINED = -1;
    private final Context mContext;
    private DurationControlMode mDurationControlMode = DurationControlMode.ALIGNS_TO_LONGEST;
    /* access modifiers changed from: private */
    public boolean mIsNeedEdit = false;
    /* access modifiers changed from: private */
    public int mProfile = -1;
    private RemuxJoiner mRemuxJoiner;
    private final RemuxJoiner.RemuxJoinerListener mRemuxJoinerListener = new RemuxJoiner.RemuxJoinerListener() {
        public final void onRemuxJoinerComplete(int i11, String str) {
            TXVideoJoiner.this.mSequenceTaskRunner.a(da.a(this, i11, str));
        }

        public final void onRemuxJoinerProgress(float f11) {
            TXVideoJoiner.this.mSequenceTaskRunner.a(cz.a(this, f11));
        }

        public static /* synthetic */ void a(AnonymousClass3 r12, int i11, String str) {
            TXVideoJoiner.this.notifyJoinComplete(i11, str);
            TXVideoJoiner.this.destroyRemuxJoiner();
        }
    };
    /* access modifiers changed from: private */
    public final l mSequenceTaskRunner = new l();
    private int mSplitScreenCanvasHeight = -1;
    private int mSplitScreenCanvasWidth = -1;
    private List<TXVideoEditConstants.TXAbsoluteRect> mSplitScreenRects;
    private final TXVideoEditer.TXVideoGenerateListener mTXEditerVideoJoinerListener = new TXVideoEditer.TXVideoGenerateListener() {
        public final void onGenerateComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult) {
            TXVideoJoiner.this.notifyJoinComplete(tXGenerateResult.retCode, tXGenerateResult.descMsg);
        }

        public final void onGenerateProgress(float f11) {
            TXVideoJoiner.this.notifyJoinProgress(f11);
        }
    };
    private final TXVideoEditer.TXVideoPreviewListener mTXEditerVideoPreviewListener = new TXVideoEditer.TXVideoPreviewListener() {
        public final void onPreviewFinished() {
            TXVideoJoiner.this.mSequenceTaskRunner.a(cy.a(this));
            TXVideoPreviewListener access$000 = TXVideoJoiner.this.mTXVideoPreviewListener;
            if (access$000 != null) {
                access$000.onPreviewFinished();
            }
        }

        public final void onPreviewProgress(int i11) {
            TXVideoPreviewListener access$000 = TXVideoJoiner.this.mTXVideoPreviewListener;
            if (access$000 != null) {
                access$000.onPreviewProgress(i11);
            }
        }
    };
    private TXVideoEditer mTXVideoEditer;
    /* access modifiers changed from: private */
    public TXVideoJoinerListener mTXVideoJoinerListener;
    /* access modifiers changed from: private */
    public TXVideoPreviewListener mTXVideoPreviewListener;
    private TXVideoEditConstants.TXPreviewParam mTxPreviewParam;
    private String mVideoOutputPath;
    /* access modifiers changed from: private */
    public List<String> mVideoSourceList;
    private float[] mVideoVolumes;

    public enum DurationControlMode {
        ALIGNS_TO_LONGEST,
        ALIGNS_TO_SHORTEST
    }

    public static class SplitScreenParam {
        public int canvasHeight;
        public int canvasWidth;
        public DurationControlMode durationControlMode;
        public List<TXVideoEditConstants.TXAbsoluteRect> rects;
    }

    public interface TXVideoJoinerListener {
        void onJoinComplete(TXVideoEditConstants.TXJoinerResult tXJoinerResult);

        void onJoinProgress(float f11);
    }

    public interface TXVideoPreviewListener {
        void onPreviewFinished();

        void onPreviewProgress(int i11);
    }

    public TXVideoJoiner(Context context) {
        this.mContext = context.getApplicationContext();
        UGCDataReport.reportDAU(1005);
    }

    /* access modifiers changed from: private */
    public void destroyRemuxJoiner() {
        RemuxJoiner remuxJoiner = this.mRemuxJoiner;
        if (remuxJoiner != null) {
            remuxJoiner.stop();
            this.mRemuxJoiner.uninitialize();
            this.mRemuxJoiner = null;
        }
    }

    private void destroyVideoEditer() {
        TXVideoEditer tXVideoEditer = this.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.cancel();
            this.mTXVideoEditer.release();
            this.mTXVideoEditer = null;
        }
    }

    /* access modifiers changed from: private */
    public void joinVideoInternal(int i11, String str, boolean z11) {
        destroyVideoEditer();
        TXVideoEditer tXVideoEditer = new TXVideoEditer(this.mContext, this.mSequenceTaskRunner);
        this.mTXVideoEditer = tXVideoEditer;
        tXVideoEditer.setMediaSourcePaths(this.mVideoSourceList);
        if (z11 && !CollectionUtils.isEmpty((Collection<?>) this.mSplitScreenRects)) {
            this.mTXVideoEditer.setIsSplitScreen(true);
            this.mTXVideoEditer.setDurationControlMode(this.mDurationControlMode);
            this.mTXVideoEditer.setSplitScreenList(this.mSplitScreenRects, this.mSplitScreenCanvasWidth, this.mSplitScreenCanvasHeight);
            float[] fArr = this.mVideoVolumes;
            if (fArr != null) {
                this.mTXVideoEditer.setVideoVolumes(fArr);
            }
        }
        this.mTXVideoEditer.setVideoGenerateListener(this.mTXEditerVideoJoinerListener);
        this.mTXVideoEditer.setIsFullIFrame(this.mIsNeedEdit);
        this.mTXVideoEditer.setProfile(this.mProfile);
        if (this.mSplitScreenCanvasWidth > 0) {
            this.mTXVideoEditer.generateVideo(-1, str);
        } else {
            this.mTXVideoEditer.generateVideo(i11, str);
        }
    }

    public static /* synthetic */ void lambda$cancel$9(TXVideoJoiner tXVideoJoiner) {
        tXVideoJoiner.destroyRemuxJoiner();
        tXVideoJoiner.destroyVideoEditer();
    }

    public static /* synthetic */ void lambda$initWithPreview$1(TXVideoJoiner tXVideoJoiner, TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        tXVideoJoiner.mTxPreviewParam = tXPreviewParam;
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.initWithPreview(tXPreviewParam);
        }
    }

    public static /* synthetic */ void lambda$joinVideo$8(TXVideoJoiner tXVideoJoiner, String str, int i11) {
        if (tXVideoJoiner.startQuickJoinVideo(str)) {
            LiteavLog.i(TAG, "quickJoinVideo success");
        } else {
            tXVideoJoiner.joinVideoInternal(i11, str, false);
        }
    }

    public static /* synthetic */ void lambda$notifyJoinComplete$14(TXVideoJoiner tXVideoJoiner) {
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.release();
            tXVideoJoiner.mTXVideoEditer = null;
        }
    }

    public static /* synthetic */ void lambda$pausePlay$4(TXVideoJoiner tXVideoJoiner) {
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.pausePlay();
        }
    }

    public static /* synthetic */ void lambda$resumePlay$5(TXVideoJoiner tXVideoJoiner) {
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.resumePlay();
        }
    }

    public static /* synthetic */ void lambda$setSplitScreenList$10(TXVideoJoiner tXVideoJoiner, SplitScreenParam splitScreenParam) {
        List<TXVideoEditConstants.TXAbsoluteRect> list = splitScreenParam.rects;
        tXVideoJoiner.mSplitScreenRects = list;
        int i11 = splitScreenParam.canvasWidth;
        tXVideoJoiner.mSplitScreenCanvasWidth = i11;
        int i12 = splitScreenParam.canvasHeight;
        tXVideoJoiner.mSplitScreenCanvasHeight = i12;
        tXVideoJoiner.mDurationControlMode = splitScreenParam.durationControlMode;
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.setSplitScreenList(list, i11, i12);
            tXVideoJoiner.mTXVideoEditer.setDurationControlMode(splitScreenParam.durationControlMode);
        }
    }

    public static /* synthetic */ void lambda$setVideoVolumes$11(TXVideoJoiner tXVideoJoiner, List list) {
        tXVideoJoiner.mVideoVolumes = new float[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            tXVideoJoiner.mVideoVolumes[i11] = ((Float) list.get(i11)).floatValue();
        }
        TXVideoEditer tXVideoEditer = tXVideoJoiner.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.setVideoVolumes(tXVideoJoiner.mVideoVolumes);
        }
    }

    public static /* synthetic */ void lambda$startPlay$3(TXVideoJoiner tXVideoJoiner) {
        tXVideoJoiner.stopPlayInternal();
        TXVideoEditer tXVideoEditer = new TXVideoEditer(tXVideoJoiner.mContext, tXVideoJoiner.mSequenceTaskRunner);
        tXVideoJoiner.mTXVideoEditer = tXVideoEditer;
        tXVideoEditer.setMediaSourcePaths(tXVideoJoiner.mVideoSourceList);
        tXVideoJoiner.mTXVideoEditer.initWithPreview(tXVideoJoiner.mTxPreviewParam);
        if (!CollectionUtils.isEmpty((Collection<?>) tXVideoJoiner.mSplitScreenRects)) {
            tXVideoJoiner.mTXVideoEditer.setIsSplitScreen(true);
            tXVideoJoiner.mTXVideoEditer.setDurationControlMode(tXVideoJoiner.mDurationControlMode);
            tXVideoJoiner.mTXVideoEditer.setSplitScreenList(tXVideoJoiner.mSplitScreenRects, tXVideoJoiner.mSplitScreenCanvasWidth, tXVideoJoiner.mSplitScreenCanvasHeight);
            float[] fArr = tXVideoJoiner.mVideoVolumes;
            if (fArr != null) {
                tXVideoJoiner.mTXVideoEditer.setVideoVolumes(fArr);
            }
        }
        tXVideoJoiner.mTXVideoEditer.setTXVideoPreviewListener(tXVideoJoiner.mTXEditerVideoPreviewListener);
        TXVideoEditer tXVideoEditer2 = tXVideoJoiner.mTXVideoEditer;
        tXVideoEditer2.startPlayFromTime(0, tXVideoEditer2.getDuration());
    }

    /* access modifiers changed from: private */
    public void notifyJoinComplete(int i11, String str) {
        this.mSequenceTaskRunner.a(cp.a(this));
        TXVideoEditConstants.TXJoinerResult tXJoinerResult = new TXVideoEditConstants.TXJoinerResult();
        tXJoinerResult.descMsg = str;
        tXJoinerResult.retCode = i11;
        LiteavLog.i(TAG, "TXGenerateResult descMsg = " + str + " retCode = " + i11);
        TXVideoJoinerListener tXVideoJoinerListener = this.mTXVideoJoinerListener;
        if (tXVideoJoinerListener != null) {
            tXVideoJoinerListener.onJoinComplete(tXJoinerResult);
        }
        if (i11 == 0 && !TextUtils.isEmpty(this.mVideoOutputPath) && new File(this.mVideoOutputPath).exists()) {
            UGCDataReport.reportDAU(1032, (int) new File(this.mVideoOutputPath).length(), "");
        }
    }

    /* access modifiers changed from: private */
    public void notifyJoinProgress(float f11) {
        TXVideoJoinerListener tXVideoJoinerListener = this.mTXVideoJoinerListener;
        if (tXVideoJoinerListener != null) {
            tXVideoJoinerListener.onJoinProgress(f11);
        }
    }

    private boolean startQuickJoinVideo(String str) {
        destroyRemuxJoiner();
        List<String> list = this.mVideoSourceList;
        if (list == null || !RemuxJoiner.isConcatableWithoutReencode(list)) {
            return false;
        }
        LiteavLog.i(TAG, "RemuxerJoinerChecker check is ok");
        if (this.mRemuxJoiner == null) {
            RemuxJoiner remuxJoiner = new RemuxJoiner();
            this.mRemuxJoiner = remuxJoiner;
            remuxJoiner.initialize();
        }
        this.mRemuxJoiner.stop();
        if (this.mRemuxJoiner.setSourcePaths(this.mVideoSourceList) || this.mRemuxJoiner.setTargetPath(str)) {
            return false;
        }
        this.mVideoOutputPath = str;
        this.mRemuxJoiner.setVideoJoinerListener(this.mRemuxJoinerListener);
        return this.mRemuxJoiner.start();
    }

    /* access modifiers changed from: private */
    public void stopPlayInternal() {
        LiteavLog.i(TAG, "stopPlayInternal");
        TXVideoEditer tXVideoEditer = this.mTXVideoEditer;
        if (tXVideoEditer != null) {
            tXVideoEditer.stopPlay();
            this.mTXVideoEditer.release();
            this.mTXVideoEditer = null;
        }
    }

    public void cancel() {
        LiteavLog.i(TAG, "cancel");
        this.mSequenceTaskRunner.a(ck.a(this));
    }

    public void initWithPreview(TXVideoEditConstants.TXPreviewParam tXPreviewParam) {
        LiteavLog.i(TAG, "initWithPreview videoView = " + tXPreviewParam.videoView);
        this.mSequenceTaskRunner.a(cq.a(this, tXPreviewParam));
    }

    public void joinVideo(int i11, String str) {
        LiteavLog.i(TAG, "joinVideo videoCompressed " + i11 + " videoOutputPath = " + str);
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "joinVideo is not support on smart version");
            notifyJoinComplete(-5, "licence verify failed");
            return;
        }
        this.mVideoOutputPath = str;
        this.mSequenceTaskRunner.a(cj.a(this, str, i11));
    }

    public void pausePlay() {
        LiteavLog.i(TAG, "pausePlay");
        this.mSequenceTaskRunner.a(ct.a(this));
    }

    public void resumePlay() {
        LiteavLog.i(TAG, "resumePlay");
        this.mSequenceTaskRunner.a(cu.a(this));
    }

    public void setNeedEdit(boolean z11) {
        LiteavLog.i(TAG, "setNeedEdit = ".concat(String.valueOf(z11)));
        this.mSequenceTaskRunner.a(co.a(this, z11));
    }

    public void setProfile(int i11) {
        LiteavLog.i(TAG, "setProfile profile ".concat(String.valueOf(i11)));
        this.mSequenceTaskRunner.a(cx.a(this, i11));
    }

    public void setRecordPath(String str) {
        LiteavLog.i(TAG, "setRecordPath recordPath = ".concat(String.valueOf(str)));
    }

    public void setSplitScreenList(List<TXVideoEditConstants.TXAbsoluteRect> list, int i11, int i12) {
        SplitScreenParam splitScreenParam = new SplitScreenParam();
        splitScreenParam.rects = list;
        splitScreenParam.canvasWidth = i11;
        splitScreenParam.canvasHeight = i12;
        splitScreenParam.durationControlMode = this.mDurationControlMode;
        setSplitScreenList(splitScreenParam);
    }

    public void setTXVideoPreviewListener(TXVideoPreviewListener tXVideoPreviewListener) {
        LiteavLog.i(TAG, "setTXVideoPreviewListener");
        this.mSequenceTaskRunner.a(cr.a(this, tXVideoPreviewListener));
    }

    public void setVideoJoinerListener(TXVideoJoinerListener tXVideoJoinerListener) {
        LiteavLog.i(TAG, "setVideoJoinerListener");
        this.mSequenceTaskRunner.a(cw.a(this, tXVideoJoinerListener));
    }

    public int setVideoPathList(List<String> list) {
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                return -1;
            }
            int isMediaSourceValid = TXVideoEditer.isMediaSourceValid(next);
            if (isMediaSourceValid != 0) {
                LiteavLog.e(TAG, "set video path list " + next + " is illegal. valid code is " + isMediaSourceValid);
                return isMediaSourceValid;
            }
        }
        this.mSequenceTaskRunner.a(ci.a(this, list));
        return 0;
    }

    public void setVideoVolumes(List<Float> list) {
        LiteavLog.i(TAG, "setVideoVolumes");
        this.mSequenceTaskRunner.a(cm.a(this, list));
    }

    public void splitJoinVideo(int i11, String str) {
        LiteavLog.i(TAG, "splitJoinVideo video Compressed = " + i11 + " videoOutputPath = " + str);
        if (!UGCLicenseChecker.isStandardFunctionSupport()) {
            LiteavLog.e(TAG, "splitJoinVideo is not support on smart version");
            notifyJoinComplete(-5, "licence verify failed");
            return;
        }
        this.mVideoOutputPath = str;
        this.mSequenceTaskRunner.a(cn.a(this, i11, str));
        UGCDataReport.reportDAU(1031);
    }

    public void startPlay() {
        LiteavLog.i(TAG, "startPlay");
        this.mSequenceTaskRunner.a(cs.a(this));
    }

    public void stopPlay() {
        LiteavLog.i(TAG, "stopPlay");
        this.mSequenceTaskRunner.a(cv.a(this));
    }

    public void setSplitScreenList(SplitScreenParam splitScreenParam) {
        if (splitScreenParam == null) {
            LiteavLog.w(TAG, "set split screen list. param is null");
            return;
        }
        LiteavLog.i(TAG, "setSplitScreenList canvasWidth: " + splitScreenParam.canvasWidth + " canvasHeight:  " + splitScreenParam.canvasHeight + " durationControlMode: " + splitScreenParam.durationControlMode);
        this.mSequenceTaskRunner.a(cl.a(this, splitScreenParam));
    }
}
