package com.tencent.ugc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.f;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import com.tencent.ugc.TXUGCRecord;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

@JNINamespace("liteav::ugc")
public class UGCRecorderJni {
    private static final String OUTPUT_DIR_NAME = "TXUGC";
    private static final String OUTPUT_TEMP_DIR_NAME = "TXUGCParts";
    private static final String OUTPUT_VIDEO_COVER_NAME = "TXUGCCover.jpg";
    private static final String OUTPUT_VIDEO_NAME = "TXUGCRecord.mp4";
    private static final String TAG = "UGCRecorderJni";
    private TXRecordCommon.ITXBGMNotify mBGMListener;
    private TXBeautyManager mBeautyManager;
    private Context mContext;
    private String mCoverPath;
    private TXUGCRecord.VideoCustomProcessListener mCustomProcessListener;
    private long mNativeUGCRecorderJni = 0;
    private TXCloudVideoView mPreviewView;
    private RecordParams mRecorderParams = new RecordParams();
    private TXRecordCommon.ITXSnapshotListener mSnapshotListener;
    private TXUGCPartsManager mTXUGCPartsManager;
    private String mVideoFilePath;
    private String mVideoPartFolder;
    private TXRecordCommon.ITXVideoRecordListener mVideoRecordListener;

    public static class RecordParams {

        /* renamed from: a  reason: collision with root package name */
        public int f50093a = TXVodDownloadDataSource.QUALITY_540P;

        /* renamed from: b  reason: collision with root package name */
        public int f50094b = 960;

        /* renamed from: c  reason: collision with root package name */
        public int f50095c = 20;

        /* renamed from: d  reason: collision with root package name */
        public int f50096d = 1800;

        /* renamed from: e  reason: collision with root package name */
        public int f50097e = 3;

        /* renamed from: f  reason: collision with root package name */
        public boolean f50098f = true;

        /* renamed from: g  reason: collision with root package name */
        public boolean f50099g = false;

        /* renamed from: h  reason: collision with root package name */
        public int f50100h = 5000;

        /* renamed from: i  reason: collision with root package name */
        public int f50101i = 60000;

        /* renamed from: j  reason: collision with root package name */
        public int f50102j = 48000;

        /* renamed from: k  reason: collision with root package name */
        public boolean f50103k = true;

        /* renamed from: l  reason: collision with root package name */
        public int f50104l = 0;

        /* renamed from: m  reason: collision with root package name */
        public boolean f50105m = true;

        /* renamed from: n  reason: collision with root package name */
        public boolean f50106n = true;

        /* renamed from: o  reason: collision with root package name */
        public boolean f50107o = true;

        public boolean enableAEC() {
            return this.f50105m;
        }

        public boolean enableAGC() {
            return this.f50106n;
        }

        public boolean enableANS() {
            return this.f50107o;
        }

        public int getAudioSampleRate() {
            return this.f50102j;
        }

        public int getMaxDuration() {
            return this.f50101i;
        }

        public int getMinDuration() {
            return this.f50100h;
        }

        public int getVideoBitrate() {
            return this.f50096d;
        }

        public int getVideoFps() {
            return this.f50095c;
        }

        public int getVideoGop() {
            return this.f50097e;
        }

        public int getVideoHeight() {
            return this.f50094b;
        }

        public int getVideoProfile() {
            return this.f50104l;
        }

        public int getVideoWidth() {
            return this.f50093a;
        }

        public boolean isFullIFrame() {
            return this.f50103k;
        }
    }

    static {
        r.a();
    }

    public UGCRecorderJni(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        ContextUtils.initApplicationContext(applicationContext);
        ContextUtils.setDataDirectorySuffix("liteav");
        UGCInitializer.initialize();
        long nativeCreate = nativeCreate(this);
        this.mNativeUGCRecorderJni = nativeCreate;
        this.mBeautyManager = new UGCBeautyManager(nativeCreateBeautyManager(nativeCreate));
        this.mTXUGCPartsManager = new TXUGCPartsManagerImpl(nativeCreatePartsManager(this.mNativeUGCRecorderJni));
        initFileAndFolder();
    }

    private int checkRecordPath(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            LiteavLog.e(TAG, "startRecord: init videoRecord failed, videoFilePath is empty");
            return -2;
        }
        this.mVideoFilePath = str;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        if (!TextUtils.isEmpty(str3)) {
            this.mCoverPath = str3;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.mVideoPartFolder = str2;
        }
        File file2 = new File(this.mVideoPartFolder);
        if (file2.exists()) {
            return 0;
        }
        file2.mkdirs();
        return 0;
    }

    private void createThumbFile(String str, String str2) {
        Bitmap sampleImage;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (sampleImage = TXVideoInfoReader.getInstance(this.mContext).getSampleImage(0, str)) != null) {
            FileOutputStream fileOutputStream = null;
            try {
                File file = new File(str2);
                if (file.exists()) {
                    file.delete();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    sampleImage.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    fileOutputStream2.flush();
                    f.a((Closeable) fileOutputStream2);
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                    f.a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    f.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                f.a((Closeable) fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                f.a((Closeable) fileOutputStream);
                throw th;
            }
        }
    }

    private String getDefaultDir() {
        File a11 = f.a(this.mContext, OUTPUT_DIR_NAME);
        if (a11 == null) {
            a11 = this.mContext.getFilesDir();
        }
        return a11 != null ? a11.getPath() : "";
    }

    private int getEditBitrateWithSize(int i11, int i12) {
        if (i11 <= 640 && i12 <= 640) {
            return 2000;
        }
        if (i11 > 960 || i12 > 960) {
            return (i11 > 1280 || i12 > 1280) ? 12000 : 7200;
        }
        return 5200;
    }

    private Size getVideoSize(int i11) {
        Size size = new Size();
        if (i11 == 0) {
            size.width = 360;
            size.height = b.f34944a;
        } else if (i11 == 1) {
            size.width = TXVodDownloadDataSource.QUALITY_480P;
            size.height = b.f34944a;
        } else if (i11 == 3) {
            size.width = 720;
            size.height = 1280;
        } else if (i11 != 4) {
            size.width = TXVodDownloadDataSource.QUALITY_540P;
            size.height = 960;
        } else {
            size.width = 1080;
            size.height = 1920;
        }
        return size;
    }

    private void initFileAndFolder() {
        String defaultDir = getDefaultDir();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(defaultDir);
        String str = File.separator;
        sb2.append(str);
        sb2.append(OUTPUT_VIDEO_NAME);
        this.mVideoFilePath = sb2.toString();
        this.mCoverPath = defaultDir + str + OUTPUT_VIDEO_COVER_NAME;
        this.mVideoPartFolder = defaultDir + str + OUTPUT_TEMP_DIR_NAME;
        File file = new File(this.mVideoPartFolder);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(this.mVideoFilePath);
        if (file2.exists()) {
            file2.delete();
        }
    }

    private void initRecorderParams(TXRecordCommon.TXUGCSimpleConfig tXUGCSimpleConfig) {
        int i11 = tXUGCSimpleConfig.videoQuality;
        if (i11 == 0) {
            RecordParams recordParams = this.mRecorderParams;
            recordParams.f50093a = 360;
            recordParams.f50094b = b.f34944a;
            recordParams.f50096d = 2000;
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_BD);
        } else if (i11 == 1) {
            RecordParams recordParams2 = this.mRecorderParams;
            recordParams2.f50093a = TXVodDownloadDataSource.QUALITY_480P;
            recordParams2.f50094b = b.f34944a;
            recordParams2.f50096d = 3200;
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_HD);
        } else if (i11 != 3) {
            RecordParams recordParams3 = this.mRecorderParams;
            recordParams3.f50093a = TXVodDownloadDataSource.QUALITY_540P;
            recordParams3.f50094b = 960;
            recordParams3.f50096d = 5200;
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_HD);
        } else {
            RecordParams recordParams4 = this.mRecorderParams;
            recordParams4.f50093a = 720;
            recordParams4.f50094b = 1280;
            recordParams4.f50096d = 7200;
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_FHD);
        }
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_VIDEO_BITRATE, this.mRecorderParams.f50096d, "");
        RecordParams recordParams5 = this.mRecorderParams;
        recordParams5.f50095c = 30;
        boolean z11 = tXUGCSimpleConfig.needEdit;
        recordParams5.f50103k = z11;
        recordParams5.f50098f = tXUGCSimpleConfig.isFront;
        recordParams5.f50099g = tXUGCSimpleConfig.touchFocus;
        recordParams5.f50104l = tXUGCSimpleConfig.profile;
        recordParams5.f50100h = tXUGCSimpleConfig.minDuration;
        recordParams5.f50101i = tXUGCSimpleConfig.maxDuration;
        recordParams5.f50105m = true;
        recordParams5.f50106n = true;
        recordParams5.f50107o = true;
        if (z11) {
            recordParams5.f50097e = 1;
            recordParams5.f50096d = getEditBitrateWithSize(recordParams5.f50093a, recordParams5.f50094b);
        }
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_FPS, this.mRecorderParams.f50095c, "");
    }

    public static /* synthetic */ void lambda$onRecordComplete$1(int i11, String str, String str2, String str3, TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
        tXRecordResult.retCode = i11;
        tXRecordResult.descMsg = str;
        tXRecordResult.videoPath = str2;
        tXRecordResult.coverPath = str3;
        iTXVideoRecordListener.onRecordComplete(tXRecordResult);
    }

    public static /* synthetic */ void lambda$setFocusPosition$0(UGCRecorderJni uGCRecorderJni, float f11, float f12) {
        Class<TXCloudVideoView> cls = TXCloudVideoView.class;
        try {
            Class cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("showIndicatorView", new Class[]{cls2, cls2, cls2, cls2});
            declaredMethod.setAccessible(true);
            TXCloudVideoView tXCloudVideoView = uGCRecorderJni.mPreviewView;
            if (tXCloudVideoView != null) {
                declaredMethod.invoke(tXCloudVideoView, new Object[]{Integer.valueOf((int) f11), Integer.valueOf((int) f12), Integer.valueOf(tXCloudVideoView.getWidth()), Integer.valueOf(tXCloudVideoView.getHeight())});
            }
        } catch (Exception e11) {
            LiteavLog.w(TAG, " showIndicatorView ".concat(String.valueOf(e11)));
        }
    }

    private static native long nativeCreate(UGCRecorderJni uGCRecorderJni);

    private static native long nativeCreateBeautyManager(long j11);

    private static native long nativeCreatePartsManager(long j11);

    private static native void nativeDestroy(long j11);

    private static native void nativeEnableBGMNotify(long j11, boolean z11);

    private static native void nativeEnableCameraAutoFocus(long j11, boolean z11);

    private static native void nativeEnableVideoCustomPreprocess(long j11, boolean z11);

    private static native int nativeGetMusicDuration(long j11, String str);

    private static native int nativeGetZoomLevel(long j11);

    private static native boolean nativePauseBGM(long j11);

    private static native int nativePauseRecord(long j11);

    private static native boolean nativePlayBGM(long j11, int i11, int i12);

    private static native boolean nativeResumeBGM(long j11);

    private static native int nativeResumeRecord(long j11);

    private static native void nativeSetAspectRatio(long j11, int i11);

    private static native void nativeSetBGMLoop(long j11, boolean z11);

    private static native int nativeSetBGMPath(long j11, String str);

    private static native boolean nativeSetBGMVolume(long j11, int i11);

    private static native void nativeSetFilter(long j11, Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13);

    private static native void nativeSetFocusPosition(long j11, float f11, float f12);

    private static native void nativeSetHomeOrientation(long j11, int i11);

    private static native void nativeSetMicVolume(long j11, int i11);

    public static native void nativeSetMute(long j11, boolean z11);

    private static native void nativeSetRecordParams(long j11, RecordParams recordParams);

    private static native void nativeSetRecordSpeed(long j11, int i11);

    private static native void nativeSetRenderMirrorType(long j11, int i11);

    private static native void nativeSetRenderMode(long j11, int i11);

    private static native void nativeSetRenderRotation(long j11, int i11);

    private static native void nativeSetReverbType(long j11, int i11);

    private static native void nativeSetVideoEncoderMirror(long j11, boolean z11);

    private static native void nativeSetView(long j11, DisplayTarget displayTarget);

    private static native void nativeSetVoiceChangerType(long j11, int i11);

    private static native void nativeSetWatermark(long j11, Bitmap bitmap, float f11, float f12, float f13);

    private static native boolean nativeSetZoomLevel(long j11, int i11);

    private static native void nativeSnapshot(long j11);

    private static native void nativeStartCamera(long j11, boolean z11);

    private static native int nativeStartRecord(long j11, String str, String str2, String str3);

    private static native boolean nativeStopBGM(long j11);

    private static native void nativeStopCamera(long j11);

    private static native int nativeStopRecord(long j11);

    private static native boolean nativeSwitchCamera(long j11, boolean z11);

    private static native boolean nativeTurnOnTorch(long j11, boolean z11);

    public void finalize() throws Throwable {
        super.finalize();
        long j11 = this.mNativeUGCRecorderJni;
        if (j11 != 0) {
            nativeDestroy(j11);
            this.mNativeUGCRecorderJni = 0;
        }
        UGCInitializer.uninitialize();
    }

    public TXBeautyManager getBeautyManager() {
        return this.mBeautyManager;
    }

    public int getMaxZoom() {
        return nativeGetZoomLevel(this.mNativeUGCRecorderJni);
    }

    public int getMusicDuration(String str) {
        long j11 = this.mNativeUGCRecorderJni;
        if (str == null) {
            str = "";
        }
        return nativeGetMusicDuration(j11, str);
    }

    public TXUGCPartsManager getPartsManager() {
        return this.mTXUGCPartsManager;
    }

    public void onBGMComplete(int i11) {
        TXRecordCommon.ITXBGMNotify iTXBGMNotify = this.mBGMListener;
        if (iTXBGMNotify != null) {
            iTXBGMNotify.onBGMComplete(i11);
        }
    }

    public void onBGMProgress(long j11, long j12) {
        TXRecordCommon.ITXBGMNotify iTXBGMNotify = this.mBGMListener;
        if (iTXBGMNotify != null) {
            iTXBGMNotify.onBGMProgress(j11, j12);
        }
    }

    public void onBGMStart() {
        TXRecordCommon.ITXBGMNotify iTXBGMNotify = this.mBGMListener;
        if (iTXBGMNotify != null) {
            iTXBGMNotify.onBGMStart();
        }
    }

    public void onGLContextDestroy() {
        TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener = this.mCustomProcessListener;
        if (videoCustomProcessListener != null) {
            videoCustomProcessListener.onTextureDestroyed();
        }
    }

    public int onPreprocessVideoFrame(int i11, int i12, int i13) {
        TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener = this.mCustomProcessListener;
        if (videoCustomProcessListener != null) {
            return videoCustomProcessListener.onTextureCustomProcess(i11, i12, i13);
        }
        return -1;
    }

    public void onRecordComplete(int i11, String str, String str2, String str3) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            createThumbFile(str2, str3);
            ThreadUtils.getUiThreadHandler().post(fa.a(i11, str, str2, str3, iTXVideoRecordListener));
        }
    }

    public void onRecordEvent(int i11) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordEvent(i11, new Bundle());
        }
    }

    public void onRecordProgress(long j11) {
        TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener = this.mVideoRecordListener;
        if (iTXVideoRecordListener != null) {
            iTXVideoRecordListener.onRecordProgress(j11);
        }
    }

    public void onSnapshot(Bitmap bitmap) {
        TXRecordCommon.ITXSnapshotListener iTXSnapshotListener = this.mSnapshotListener;
        if (iTXSnapshotListener != null) {
            iTXSnapshotListener.onSnapshot(bitmap);
        }
    }

    public boolean pauseBGM() {
        return nativePauseBGM(this.mNativeUGCRecorderJni);
    }

    public int pauseRecord() {
        return nativePauseRecord(this.mNativeUGCRecorderJni);
    }

    public boolean playBGMFromTime(int i11, int i12) {
        UGCDataReport.reportDAU(1008);
        return nativePlayBGM(this.mNativeUGCRecorderJni, i11, i12);
    }

    public void release() {
        setVoiceChangerType(0);
        setReverb(0);
        setRecordSpeed(2);
        stopBGM();
        stopCameraPreview();
        stopRecord();
    }

    public boolean resumeBGM() {
        return nativeResumeBGM(this.mNativeUGCRecorderJni);
    }

    public int resumeRecord() {
        return nativeResumeRecord(this.mNativeUGCRecorderJni);
    }

    public boolean seekBGM(int i11, int i12) {
        return nativePlayBGM(this.mNativeUGCRecorderJni, i11, i12);
    }

    public void setAspectRatio(int i11) {
        nativeSetAspectRatio(this.mNativeUGCRecorderJni, i11);
        if (i11 == 0) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RATIO_9_16);
        } else if (i11 == 1) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RATIO_3_4);
        } else if (i11 == 2) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RATIO_1_1);
        } else if (i11 == 3) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RATIO_16_9);
        } else if (i11 == 4) {
            UGCDataReport.reportDAU(1056);
        }
    }

    public int setBGM(String str) {
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_BGM);
        long j11 = this.mNativeUGCRecorderJni;
        if (str == null) {
            str = "";
        }
        return nativeSetBGMPath(j11, str);
    }

    public void setBGMLoop(boolean z11) {
        nativeSetBGMLoop(this.mNativeUGCRecorderJni, z11);
    }

    public void setBGMNotify(TXRecordCommon.ITXBGMNotify iTXBGMNotify) {
        this.mBGMListener = iTXBGMNotify;
        nativeEnableBGMNotify(this.mNativeUGCRecorderJni, iTXBGMNotify != null);
    }

    public boolean setBGMVolume(float f11) {
        return nativeSetBGMVolume(this.mNativeUGCRecorderJni, (int) (f11 * 100.0f));
    }

    public void setBeautyDepth(int i11, int i12, int i13, int i14) {
        this.mBeautyManager.setBeautyStyle(i11);
        this.mBeautyManager.setBeautyLevel((float) i12);
        this.mBeautyManager.setWhitenessLevel((float) i13);
        this.mBeautyManager.setRuddyLevel((float) i14);
    }

    public void setBeautyStyle(int i11) {
        this.mBeautyManager.setBeautyStyle(i11);
    }

    public void setChinLevel(int i11) {
        this.mBeautyManager.setChinLevel((float) i11);
    }

    public void setEyeScaleLevel(float f11) {
        this.mBeautyManager.setEyeScaleLevel(f11);
    }

    public void setFaceScaleLevel(float f11) {
        this.mBeautyManager.setFaceSlimLevel(f11);
    }

    public void setFaceShortLevel(int i11) {
        this.mBeautyManager.setFaceShortLevel((float) i11);
    }

    public void setFaceVLevel(int i11) {
        this.mBeautyManager.setFaceVLevel((float) i11);
    }

    public void setFilter(Bitmap bitmap) {
        this.mBeautyManager.setFilter(bitmap);
    }

    public void setFocusPosition(float f11, float f12) {
        if (this.mRecorderParams.f50099g) {
            nativeSetFocusPosition(this.mNativeUGCRecorderJni, f11, f12);
            ThreadUtils.getUiThreadHandler().postDelayed(ez.a(this, f11, f12), 100);
        }
    }

    public void setGreenScreenFile(String str, boolean z11) {
        TXBeautyManager tXBeautyManager = this.mBeautyManager;
        if (str == null) {
            str = "";
        }
        tXBeautyManager.setGreenScreenFile(str);
    }

    public void setHomeOrientation(int i11) {
        nativeSetHomeOrientation(this.mNativeUGCRecorderJni, i11);
    }

    public boolean setMicVolume(float f11) {
        nativeSetMicVolume(this.mNativeUGCRecorderJni, (int) (f11 * 100.0f));
        return true;
    }

    public void setMotionMute(boolean z11) {
        this.mBeautyManager.setMotionMute(z11);
    }

    public void setMotionTmpl(String str) {
        TXBeautyManager tXBeautyManager = this.mBeautyManager;
        if (str == null) {
            str = "";
        }
        tXBeautyManager.setMotionTmpl(str);
    }

    public void setMute(boolean z11) {
        nativeSetMute(this.mNativeUGCRecorderJni, z11);
    }

    public void setNoseSlimLevel(int i11) {
        this.mBeautyManager.setNoseSlimLevel((float) i11);
    }

    public void setRecordSpeed(int i11) {
        nativeSetRecordSpeed(this.mNativeUGCRecorderJni, i11);
        if (i11 == 0) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_SPEED, i11, "SLOWEST");
        } else if (i11 == 1) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_SPEED, i11, "SLOW");
        } else if (i11 == 2) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_SPEED, i11, "NORMAL");
        } else if (i11 == 3) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_SPEED, i11, "FAST");
        } else if (i11 == 4) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_SPEED, i11, "FASTEST");
        }
    }

    public void setRenderRotation(int i11) {
        nativeSetRenderRotation(this.mNativeUGCRecorderJni, i11);
    }

    public void setReverb(int i11) {
        nativeSetReverbType(this.mNativeUGCRecorderJni, i11);
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_REVERB, i11, "");
        UGCDataReport.reportDAU(1007);
    }

    public void setSpecialRatio(float f11) {
        this.mBeautyManager.setFilterStrength(f11);
    }

    public void setVideoBitrate(int i11) {
        RecordParams recordParams = this.mRecorderParams;
        recordParams.f50096d = i11;
        nativeSetRecordParams(this.mNativeUGCRecorderJni, recordParams);
    }

    public void setVideoEncoderMirror(boolean z11) {
        nativeSetVideoEncoderMirror(this.mNativeUGCRecorderJni, z11);
    }

    public void setVideoProcessListener(TXUGCRecord.VideoCustomProcessListener videoCustomProcessListener) {
        this.mCustomProcessListener = videoCustomProcessListener;
        nativeEnableVideoCustomPreprocess(this.mNativeUGCRecorderJni, videoCustomProcessListener != null);
    }

    public void setVideoRecordListener(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        this.mVideoRecordListener = iTXVideoRecordListener;
    }

    public void setVideoRenderMirrorType(int i11) {
        nativeSetRenderMirrorType(this.mNativeUGCRecorderJni, i11);
    }

    public void setVideoRenderMode(int i11) {
        nativeSetRenderMode(this.mNativeUGCRecorderJni, i11);
    }

    public void setVideoResolution(int i11) {
        Size videoSize = getVideoSize(i11);
        RecordParams recordParams = this.mRecorderParams;
        recordParams.f50093a = videoSize.width;
        recordParams.f50094b = videoSize.height;
        nativeSetRecordParams(this.mNativeUGCRecorderJni, recordParams);
    }

    public void setVoiceChangerType(int i11) {
        nativeSetVoiceChangerType(this.mNativeUGCRecorderJni, i11);
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_CHANGER, i11, "");
    }

    public void setWatermark(Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        nativeSetWatermark(this.mNativeUGCRecorderJni, bitmap, tXRect.f50070x, tXRect.f50071y, tXRect.width);
    }

    public boolean setZoom(int i11) {
        return nativeSetZoomLevel(this.mNativeUGCRecorderJni, i11);
    }

    public void snapshot(TXRecordCommon.ITXSnapshotListener iTXSnapshotListener) {
        this.mSnapshotListener = iTXSnapshotListener;
        nativeSnapshot(this.mNativeUGCRecorderJni);
    }

    public int startCameraCustomPreview(TXRecordCommon.TXUGCCustomConfig tXUGCCustomConfig, TXCloudVideoView tXCloudVideoView) {
        initRecorderParams(tXUGCCustomConfig);
        nativeSetRecordParams(this.mNativeUGCRecorderJni, this.mRecorderParams);
        nativeSetView(this.mNativeUGCRecorderJni, new DisplayTarget(tXCloudVideoView));
        boolean z11 = true;
        nativeEnableCameraAutoFocus(this.mNativeUGCRecorderJni, !this.mRecorderParams.f50099g);
        nativeStartCamera(this.mNativeUGCRecorderJni, this.mRecorderParams.f50098f);
        long j11 = this.mNativeUGCRecorderJni;
        if (this.mCustomProcessListener == null) {
            z11 = false;
        }
        nativeEnableVideoCustomPreprocess(j11, z11);
        Bitmap bitmap = tXUGCCustomConfig.watermark;
        if (bitmap != null) {
            nativeSetWatermark(this.mNativeUGCRecorderJni, bitmap, (float) tXUGCCustomConfig.watermarkX, (float) tXUGCCustomConfig.watermarkY, (float) bitmap.getWidth());
        }
        this.mPreviewView = tXCloudVideoView;
        return 0;
    }

    public int startCameraSimplePreview(TXRecordCommon.TXUGCSimpleConfig tXUGCSimpleConfig, TXCloudVideoView tXCloudVideoView) {
        initRecorderParams(tXUGCSimpleConfig);
        nativeSetRecordParams(this.mNativeUGCRecorderJni, this.mRecorderParams);
        nativeSetView(this.mNativeUGCRecorderJni, new DisplayTarget(tXCloudVideoView));
        boolean z11 = true;
        nativeEnableCameraAutoFocus(this.mNativeUGCRecorderJni, !this.mRecorderParams.f50099g);
        nativeStartCamera(this.mNativeUGCRecorderJni, this.mRecorderParams.f50098f);
        long j11 = this.mNativeUGCRecorderJni;
        if (this.mCustomProcessListener == null) {
            z11 = false;
        }
        nativeEnableVideoCustomPreprocess(j11, z11);
        Bitmap bitmap = tXUGCSimpleConfig.watermark;
        if (bitmap != null) {
            nativeSetWatermark(this.mNativeUGCRecorderJni, bitmap, (float) tXUGCSimpleConfig.watermarkX, (float) tXUGCSimpleConfig.watermarkY, (float) bitmap.getWidth());
        }
        this.mPreviewView = tXCloudVideoView;
        return 0;
    }

    public int startRecord() {
        UGCDataReport.reportDAU(1002);
        return nativeStartRecord(this.mNativeUGCRecorderJni, this.mVideoFilePath, this.mVideoPartFolder, this.mCoverPath);
    }

    public boolean stopBGM() {
        return nativeStopBGM(this.mNativeUGCRecorderJni);
    }

    public void stopCameraPreview() {
        nativeEnableVideoCustomPreprocess(this.mNativeUGCRecorderJni, false);
        nativeStopCamera(this.mNativeUGCRecorderJni);
        this.mPreviewView = null;
    }

    public int stopRecord() {
        return nativeStopRecord(this.mNativeUGCRecorderJni);
    }

    public boolean switchCamera(boolean z11) {
        return nativeSwitchCamera(this.mNativeUGCRecorderJni, z11);
    }

    public boolean toggleTorch(boolean z11) {
        return nativeTurnOnTorch(this.mNativeUGCRecorderJni, z11);
    }

    public void setFilter(Bitmap bitmap, float f11, Bitmap bitmap2, float f12, float f13) {
        nativeSetFilter(this.mNativeUGCRecorderJni, bitmap, f11, bitmap2, f12, f13);
    }

    public int startRecord(String str, String str2) {
        int checkRecordPath = checkRecordPath(str, this.mVideoPartFolder, str2);
        if (checkRecordPath != 0) {
            return checkRecordPath;
        }
        return nativeStartRecord(this.mNativeUGCRecorderJni, this.mVideoFilePath, this.mVideoPartFolder, this.mCoverPath);
    }

    public int startRecord(String str, String str2, String str3) {
        int checkRecordPath = checkRecordPath(str, str2, str3);
        if (checkRecordPath != 0) {
            return checkRecordPath;
        }
        return nativeStartRecord(this.mNativeUGCRecorderJni, this.mVideoFilePath, this.mVideoPartFolder, this.mCoverPath);
    }

    private void initRecorderParams(TXRecordCommon.TXUGCCustomConfig tXUGCCustomConfig) {
        Size videoSize = getVideoSize(tXUGCCustomConfig.videoResolution);
        if (tXUGCCustomConfig.enableHighResolutionCapture) {
            videoSize.width = 1080;
            videoSize.height = 1920;
        }
        RecordParams recordParams = this.mRecorderParams;
        int i11 = videoSize.width;
        recordParams.f50093a = i11;
        int i12 = videoSize.height;
        recordParams.f50094b = i12;
        recordParams.f50096d = tXUGCCustomConfig.videoBitrate;
        recordParams.f50095c = tXUGCCustomConfig.videoFps;
        recordParams.f50097e = tXUGCCustomConfig.videoGop;
        boolean z11 = tXUGCCustomConfig.needEdit;
        recordParams.f50103k = z11;
        recordParams.f50098f = tXUGCCustomConfig.isFront;
        recordParams.f50099g = tXUGCCustomConfig.touchFocus;
        recordParams.f50104l = tXUGCCustomConfig.profile;
        recordParams.f50100h = tXUGCCustomConfig.minDuration;
        recordParams.f50101i = tXUGCCustomConfig.maxDuration;
        recordParams.f50102j = tXUGCCustomConfig.audioSampleRate;
        recordParams.f50105m = tXUGCCustomConfig.enableAEC;
        recordParams.f50106n = tXUGCCustomConfig.enableAGC;
        recordParams.f50107o = tXUGCCustomConfig.enableANS;
        if (z11) {
            recordParams.f50097e = 1;
            recordParams.f50096d = getEditBitrateWithSize(i11, i12);
        }
        int i13 = tXUGCCustomConfig.videoResolution;
        if (i13 == 0) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_BD, 360, "360x640");
        } else if (i13 == 1) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_HD, TXVodDownloadDataSource.QUALITY_480P, "480x640");
        } else if (i13 == 3) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_FHD, 720, "720x1280");
        } else if (i13 != 4) {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_HD, TXVodDownloadDataSource.QUALITY_540P, "540x960");
        } else {
            UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_RESOLUTION_1080P, 1080, "1080x1920");
        }
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_FPS, tXUGCCustomConfig.videoFps, "");
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_GOP, tXUGCCustomConfig.videoGop, "");
    }
}
