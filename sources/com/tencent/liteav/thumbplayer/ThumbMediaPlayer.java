package com.tencent.liteav.thumbplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.appsflyer.AppsFlyerProperties;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huochat.community.base.CommunityConstants;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.a;
import com.tencent.liteav.txcplayer.b;
import com.tencent.liteav.txcplayer.c;
import com.tencent.liteav.txcplayer.e;
import com.tencent.liteav.txcplayer.model.TXSubtitleRenderModel;
import com.tencent.liteav.txcplayer.model.c;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.thumbplayer.tcmedia.api.ITPModuleLoader;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayer;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayerListener;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerFactory;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMgr;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaUrlAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.TPMediaCompositionFactory;
import com.tencent.thumbplayer.tcmedia.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.tcmedia.api.report.TPDefaultReportInfo;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.trtc.TRTCCloudDef;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ThumbMediaPlayer extends a implements b {
    private static int MODE_PHONE = 0;
    private static int MODE_TV = 1;
    private static final String THUMB_PLAYER_GUID = "liteav_tbplayer_android_";
    private static final int THUMB_PLAYER_PLATFORM_ID = 2330303;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f21673a = 0;
    private static volatile boolean mSDKInited = false;
    private final String TAG;
    private long mBitrate = 0;
    private int mBitrateIndex = -1000;
    private long mCachedBytes = 0;
    private e mConfig;
    private Context mContext;
    private String mDataSource;
    private boolean mEnableAccurateSeek = false;
    private boolean mHasReceiveFirstVideoRenderEvent = false;
    private boolean mIsLooping;
    private boolean mIsPlayerReleased;
    private boolean mIsSetDefaultBufferSize = false;
    private Map<String, Object> mPrivateConfig;
    private float mRate;
    private boolean mReuseSurfaceTexture;
    private boolean mScreenOnWhilePlaying;
    private Surface mSurface;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceTexture mSurfaceTexture;
    private c mSurfaceTextureHost;
    /* access modifiers changed from: private */
    public volatile ITPPlayer mTPPPlayer;
    private long mTcpSpeed = 0;
    private long mTotalFileSize = 0;
    /* access modifiers changed from: private */
    public Object mTrtcCloud = null;
    private PowerManager.WakeLock mWakeLock = null;

    public static class TRTCCloudClassInvokeHelper {
        private static final String TAG = "com.tencent.liteav.thumbplayer.ThumbMediaPlayer$TRTCCloudClassInvokeHelper";
        /* access modifiers changed from: private */
        public static TRTCCloudClassInvokeHelper mInstance;
        private Class mClazzTRTCAudioFrame;
        private Class mClazzTRTCCloud;
        private Field mFieldChannel;
        private Field mFieldData;
        private Field mFieldSampleRate;
        private Method mMethodMixExternalAudioFrame;

        private TRTCCloudClassInvokeHelper(Object obj) {
            if (obj != null) {
                try {
                    this.mClazzTRTCCloud = obj.getClass();
                    Class<TRTCCloudDef.TRTCAudioFrame> cls = TRTCCloudDef.TRTCAudioFrame.class;
                    this.mClazzTRTCAudioFrame = cls;
                    this.mFieldData = cls.getDeclaredField("data");
                    this.mFieldSampleRate = this.mClazzTRTCAudioFrame.getDeclaredField("sampleRate");
                    this.mFieldChannel = this.mClazzTRTCAudioFrame.getDeclaredField(AppsFlyerProperties.CHANNEL);
                    this.mMethodMixExternalAudioFrame = this.mClazzTRTCCloud.getDeclaredMethod("mixExternalAudioFrame", new Class[]{this.mClazzTRTCAudioFrame});
                } catch (Exception e11) {
                    String str = TAG;
                    LiteavLog.e(str, "init TRTCCloudClassInvokeWrapper error: " + e11.getMessage());
                }
            }
        }

        /* access modifiers changed from: private */
        public static TRTCCloudClassInvokeHelper getInstance(Object obj) {
            if (mInstance == null) {
                mInstance = new TRTCCloudClassInvokeHelper(obj);
            }
            return mInstance;
        }

        /* access modifiers changed from: private */
        public void mixExternalAudioFrame(Object obj, TPAudioFrameBuffer tPAudioFrameBuffer) {
            if (obj != null) {
                try {
                    Object newInstance = this.mClazzTRTCAudioFrame.newInstance();
                    this.mFieldData.set(newInstance, tPAudioFrameBuffer.data[0]);
                    this.mFieldSampleRate.set(newInstance, Integer.valueOf(tPAudioFrameBuffer.sampleRate));
                    this.mFieldChannel.set(newInstance, Integer.valueOf(tPAudioFrameBuffer.channels));
                    this.mMethodMixExternalAudioFrame.invoke(obj, new Object[]{newInstance});
                } catch (Exception e11) {
                    LiteavLog.e(TAG, "mixExternalAudioFrame method error ", (Throwable) e11);
                }
            }
        }
    }

    public static class TXCDLProxyLogListener implements ITPDLProxyLogListener {
        public int logLevel;

        private TXCDLProxyLogListener() {
            this.logLevel = LiteavLog.getLogLevel();
        }

        public int d(String str, int i11, String str2, String str3) {
            if (this.logLevel > LiteavLog.b.kAll.mNativeValue) {
                return 0;
            }
            LiteavLog.d(str2, "[" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + i11 + "] " + str3);
            return 0;
        }

        public int e(String str, int i11, String str2, String str3) {
            if (this.logLevel > LiteavLog.b.kError.mNativeValue) {
                return 0;
            }
            LiteavLog.e(str2, "[" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + i11 + "] " + str3);
            return 0;
        }

        public int i(String str, int i11, String str2, String str3) {
            if (this.logLevel > LiteavLog.b.kInfo.mNativeValue) {
                return 0;
            }
            LiteavLog.i(str2, "[" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + i11 + "] " + str3);
            return 0;
        }

        public int w(String str, int i11, String str2, String str3) {
            if (this.logLevel > LiteavLog.b.kWarning.mNativeValue) {
                return 0;
            }
            LiteavLog.w(str2, "[" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + i11 + "] " + str3);
            return 0;
        }
    }

    public static class TXCTPPlayerOnLogListener implements TPPlayerMgr.OnLogListener {
        public int logLevel;

        private TXCTPPlayerOnLogListener() {
            this.logLevel = LiteavLog.getLogLevel();
        }

        public int d(String str, String str2) {
            if (this.logLevel > LiteavLog.b.kAll.mNativeValue) {
                return 0;
            }
            LiteavLog.d(str, str2);
            return 0;
        }

        public int e(String str, String str2) {
            if (this.logLevel > LiteavLog.b.kError.mNativeValue) {
                return 0;
            }
            LiteavLog.e(str, str2);
            return 0;
        }

        public int i(String str, String str2) {
            if (this.logLevel > LiteavLog.b.kInfo.mNativeValue) {
                return 0;
            }
            LiteavLog.i(str, str2);
            return 0;
        }

        public int v(String str, String str2) {
            if (this.logLevel > LiteavLog.b.kAll.mNativeValue) {
                return 0;
            }
            LiteavLog.v(str, str2);
            return 0;
        }

        public int w(String str, String str2) {
            if (this.logLevel > LiteavLog.b.kWarning.mNativeValue) {
                return 0;
            }
            LiteavLog.w(str, str2);
            return 0;
        }
    }

    public ThumbMediaPlayer(Context context) {
        Class<ThumbMediaPlayer> cls = ThumbMediaPlayer.class;
        this.TAG = cls.getName();
        synchronized (cls) {
            if (!mSDKInited) {
                setTPSystemInfo();
                setTPPLibCustomLoader();
                TPPlayerMgr.initSdk(context, THUMB_PLAYER_GUID + context.getPackageName(), THUMB_PLAYER_PLATFORM_ID);
                TPPlayerMgr.setDebugEnable(false);
                TPPlayerMgr.setOnLogListener(new TXCTPPlayerOnLogListener());
                mSDKInited = true;
            }
        }
        if (this.mTPPPlayer == null) {
            TPPlayerMgr.setDebugEnable(false);
            this.mTPPPlayer = TPPlayerFactory.createTPPlayer(context);
            new ThumbMediaPlayerListener(this).attachToPlayer();
        }
        this.mContext = context;
        setCustomReportData();
    }

    private int checkDlType() {
        e eVar = this.mConfig;
        if (eVar == null) {
            return 0;
        }
        int i11 = eVar.C;
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 2) {
            return 5;
        }
        if (i11 == 3) {
            return 10;
        }
        if (i11 != 4) {
            return 0;
        }
        return 19;
    }

    public static boolean clearAllOnlineCache(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(THUMB_PLAYER_PLATFORM_ID);
        tPDownloadProxy.init(context, new TPDLProxyInitParam(THUMB_PLAYER_PLATFORM_ID, CommunityConstants.COMMUNITY_SDK_VERSION, THUMB_PLAYER_GUID + context.getPackageName(), str));
        if (tPDownloadProxy.clearCache(str, "", 8, -1) == 0) {
            return true;
        }
        return false;
    }

    private TPSubtitleRenderModel convertToTPSubtitleRenderModel(TXSubtitleRenderModel tXSubtitleRenderModel) {
        int i11;
        TPSubtitleRenderModel tPSubtitleRenderModel = new TPSubtitleRenderModel();
        int i12 = tXSubtitleRenderModel.canvasHeight;
        if (!(i12 == 0 || (i11 = tXSubtitleRenderModel.canvasWidth) == 0)) {
            tPSubtitleRenderModel.canvasWidth = i11;
            tPSubtitleRenderModel.canvasHeight = i12;
            long j11 = tPSubtitleRenderModel.paramFlags | 1;
            tPSubtitleRenderModel.paramFlags = j11;
            long j12 = j11 | 2;
            tPSubtitleRenderModel.paramFlags = j12;
            float f11 = tXSubtitleRenderModel.fontSize;
            if (f11 != 0.0f) {
                tPSubtitleRenderModel.fontSize = f11;
                tPSubtitleRenderModel.paramFlags = j12 | 4;
            }
            float f12 = tXSubtitleRenderModel.outlineWidth;
            if (f12 != 0.0f) {
                tPSubtitleRenderModel.outlineWidth = f12;
                tPSubtitleRenderModel.paramFlags |= 16;
            }
            float f13 = tXSubtitleRenderModel.lineSpace;
            if (f13 != 0.0f) {
                tPSubtitleRenderModel.lineSpace = f13;
                tPSubtitleRenderModel.paramFlags |= 64;
            }
        }
        float f14 = tXSubtitleRenderModel.fontScale;
        if (f14 != 0.0f) {
            tPSubtitleRenderModel.fontScale = f14;
            tPSubtitleRenderModel.paramFlags |= 2048;
        }
        String str = tXSubtitleRenderModel.familyName;
        if (str != null) {
            tPSubtitleRenderModel.familyName = str;
        }
        int i13 = tXSubtitleRenderModel.fontColor;
        if (i13 != 0) {
            tPSubtitleRenderModel.fontColor = i13;
            tPSubtitleRenderModel.paramFlags |= 8;
        }
        if (tXSubtitleRenderModel.isBondFontStyle) {
            tPSubtitleRenderModel.fontStyleFlags |= 1;
            tPSubtitleRenderModel.paramFlags |= 1024;
        }
        int i14 = tXSubtitleRenderModel.outlineColor;
        if (i14 != 0) {
            tPSubtitleRenderModel.outlineColor = i14;
            tPSubtitleRenderModel.paramFlags |= 32;
        }
        float f15 = tXSubtitleRenderModel.startMargin;
        if (f15 != 0.0f) {
            tPSubtitleRenderModel.lineSpace = f15;
            tPSubtitleRenderModel.paramFlags |= 128;
        }
        float f16 = tXSubtitleRenderModel.endMargin;
        if (f16 != 0.0f) {
            tPSubtitleRenderModel.endMargin = f16;
            tPSubtitleRenderModel.paramFlags |= 256;
        }
        float f17 = tXSubtitleRenderModel.verticalMargin;
        if (f17 != 0.0f) {
            tPSubtitleRenderModel.verticalMargin = f17;
            tPSubtitleRenderModel.paramFlags |= 512;
        }
        return tPSubtitleRenderModel;
    }

    private ITPMediaAsset handleDRMAsset(String str) {
        Map<String, Object> map = this.mPrivateConfig;
        if (map == null) {
            return null;
        }
        Object obj = map.get("TXC_DRM_ENABLE");
        if (!(obj instanceof Boolean) || !((Boolean) obj).booleanValue()) {
            return null;
        }
        Object obj2 = this.mPrivateConfig.get("TXC_DRM_KEY_URL");
        Object obj3 = this.mPrivateConfig.get("TXC_DRM_PROVISION_URL");
        if ((obj2 instanceof String) && (obj3 instanceof String)) {
            String str2 = (String) obj2;
            if (!TextUtils.isEmpty(str2)) {
                String str3 = (String) obj3;
                if (!TextUtils.isEmpty(str3)) {
                    ITPMediaDRMAsset createMediaDRMAsset = TPMediaCompositionFactory.createMediaDRMAsset(0, str);
                    createMediaDRMAsset.setDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_PROVISION_URL, str3);
                    createMediaDRMAsset.setDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_URL, str2);
                    createMediaDRMAsset.setDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_STANDARDIZATION, "1");
                    return createMediaDRMAsset;
                }
            }
        }
        Object obj4 = this.mPrivateConfig.get("TXC_DRM_SIMPLE_AES_URL");
        if (!(obj4 instanceof String)) {
            return null;
        }
        String str4 = (String) obj4;
        if (!TextUtils.isEmpty(str4)) {
            return TPMediaCompositionFactory.createMediaUrlAsset(str4);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaUrlAsset handleUrlAsset(java.lang.String r11) {
        /*
            r10 = this;
            com.tencent.liteav.txcplayer.e r0 = r10.mConfig
            if (r0 == 0) goto L_0x0080
            int r1 = r0.f21733g
            r2 = 1
            if (r1 != r2) goto L_0x0080
            int r1 = r0.f21744r
            long r3 = r0.f21747u
            long r3 = r10.resolveAdaptivePreferredResolution(r3)
            if (r1 > 0) goto L_0x0019
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
        L_0x0019:
            com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaUrlAsset r0 = com.tencent.thumbplayer.tcmedia.api.composition.TPMediaCompositionFactory.createMediaUrlAsset(r11)
            com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetExtraParam r5 = com.tencent.thumbplayer.tcmedia.api.composition.TPMediaCompositionFactory.createMediaAssetExtraParam()
            com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAssetOrderedMap r6 = com.tencent.thumbplayer.tcmedia.api.composition.TPMediaCompositionFactory.createMediaAssetOrderedMap()
            java.lang.String r11 = com.tencent.liteav.txcplayer.a.a.a(r11)
            r7 = 0
            boolean r8 = android.text.TextUtils.isEmpty(r11)
            if (r8 != 0) goto L_0x0074
            java.lang.String r8 = r11.toLowerCase()
            java.lang.String r9 = "m3u8"
            boolean r8 = r8.endsWith(r9)
            if (r8 == 0) goto L_0x0052
            if (r1 <= 0) goto L_0x0048
            java.lang.String r11 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "hls_track_bandwidth"
            r6.addKeyValue(r1, r11)
            goto L_0x0075
        L_0x0048:
            java.lang.String r11 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "hls_track_luma_samples"
            r6.addKeyValue(r1, r11)
            goto L_0x0075
        L_0x0052:
            java.lang.String r11 = r11.toLowerCase()
            java.lang.String r8 = "mpd"
            boolean r11 = r11.endsWith(r8)
            if (r11 == 0) goto L_0x0074
            if (r1 <= 0) goto L_0x006a
            java.lang.String r11 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "dash_track_bandwidth"
            r6.addKeyValue(r1, r11)
            goto L_0x0075
        L_0x006a:
            java.lang.String r11 = java.lang.String.valueOf(r3)
            java.lang.String r1 = "dash_track_luma_samples"
            r6.addKeyValue(r1, r11)
            goto L_0x0075
        L_0x0074:
            r2 = r7
        L_0x0075:
            if (r2 == 0) goto L_0x0080
            java.lang.String r11 = "preferred_video"
            r5.setExtraObject(r11, r6)
            r0.setExtraParam(r5)
            return r0
        L_0x0080:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.handleUrlAsset(java.lang.String):com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaUrlAsset");
    }

    private boolean isAssetFile(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("asset://");
    }

    private boolean isContentUri(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().startsWith("content://");
    }

    private boolean isOfflinePlay(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("?") && !str.startsWith("http")) {
            String d11 = com.tencent.liteav.txcplayer.a.a.d(str.substring(str.indexOf("?") + 1));
            if (!TextUtils.isEmpty(d11)) {
                if (str.contains(d11 + "?")) {
                    return true;
                }
            }
        }
        return false;
    }

    private void parseExtraConfig(Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            for (String next : map.keySet()) {
                Object obj = map.get(next);
                if (!next.equals(TXVodConstants.VOD_USE_DOWNLOADER) || !(obj instanceof Boolean)) {
                    try {
                        int parseInt = Integer.parseInt(next);
                        if (obj instanceof Boolean) {
                            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(parseInt, ((Boolean) obj).booleanValue()));
                        } else {
                            if (!(obj instanceof Long)) {
                                if (!(obj instanceof Integer)) {
                                    if (!(obj instanceof Float)) {
                                        if (!(obj instanceof Double)) {
                                            if (obj instanceof String) {
                                                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildString(parseInt, (String) obj));
                                            } else {
                                                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildObject(parseInt, obj));
                                            }
                                        }
                                    }
                                    this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildFloat(parseInt, obj instanceof Float ? ((Float) obj).floatValue() : ((Double) obj).floatValue()));
                                }
                            }
                            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(parseInt, obj instanceof Long ? ((Long) obj).longValue() : ((Integer) obj).longValue()));
                        }
                    } catch (Exception unused) {
                        String str = this.TAG;
                        LiteavLog.e(str, "key " + next + " is not id!");
                    }
                } else {
                    TPPlayerConfig.setP2PEnable(((Boolean) obj).booleanValue());
                }
            }
        }
    }

    private long resolveAdaptivePreferredResolution(long j11) {
        if (this.mBitrateIndex == -1 && j11 <= 0) {
            long j12 = this.mConfig.f21746t;
            if (j12 > 0) {
                return j12;
            }
        }
        return j11;
    }

    private void setCustomReportData() {
        ITPBusinessReportManager reportManager = this.mTPPPlayer.getReportManager();
        AnonymousClass2 r12 = new TPDefaultReportInfo() {
            public int getPlayType() {
                return 0;
            }
        };
        if (!TextUtils.isEmpty((CharSequence) null)) {
            try {
                r12.scenesId = Integer.parseInt((String) null);
            } catch (Exception e11) {
                String str = this.TAG;
                LiteavLog.w(str, "set scenesId fail for parse appid:" + null + " ,error=" + e11.getMessage());
            }
            reportManager.setReportInfoGetter(r12);
        }
    }

    private void setEnableMixExternalAudioFrame() {
        LiteavLog.i(this.TAG, "setEnableMixExternalAudioFrame");
        this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(404, -1));
        this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(120, true));
        this.mTPPPlayer.setOnAudioFrameOutputListener(new ITPPlayerListener.IOnAudioFrameOutputListener() {
            public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
                if (ThumbMediaPlayer.this.mTrtcCloud != null) {
                    TRTCCloudClassInvokeHelper.getInstance(ThumbMediaPlayer.this.mTrtcCloud).mixExternalAudioFrame(ThumbMediaPlayer.this.mTrtcCloud, tPAudioFrameBuffer);
                }
            }
        });
    }

    private void setSurfaceToPlayer(Surface surface) {
        this.mSurfaceHolder = null;
        this.mSurface = surface;
        this.mTPPPlayer.setSurface(surface);
        String str = this.TAG;
        LiteavLog.i(str, "setSurface mSurface:" + this.mSurface);
    }

    private void setTPPLibCustomLoader() {
        try {
            if (!TextUtils.isEmpty(r.b())) {
                TPPlayerMgr.setLibLoader(new ITPModuleLoader() {
                    public void loadLibrary(String str, String str2) {
                        r.a(str);
                    }
                });
            }
        } catch (Throwable th2) {
            String str = this.TAG;
            LiteavLog.e(str, "setTPPLibCustomLoader, ex = " + th2.getMessage());
        }
    }

    private void setTPSystemInfo() {
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_MODEL, LiteavSystemInfo.getModel());
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_MANUFACTURER, LiteavSystemInfo.getManufacturer());
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE, LiteavSystemInfo.getSystemOSVersion());
        TPSystemInfo.setProperty(TPSystemInfo.KEY_PROPERTY_BOARD, LiteavSystemInfo.getBoard());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        if (r3 > 0.0f) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setVideoInfo(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.tencent.thumbplayer.tcmedia.api.ITPPlayer r0 = r11.mTPPPlayer
            if (r0 == 0) goto L_0x0103
            com.tencent.thumbplayer.tcmedia.api.TPVideoInfo$Builder r0 = new com.tencent.thumbplayer.tcmedia.api.TPVideoInfo$Builder
            r0.<init>()
            int r1 = r11.checkDlType()
            com.tencent.thumbplayer.tcmedia.api.proxy.TPDownloadParamData r2 = new com.tencent.thumbplayer.tcmedia.api.proxy.TPDownloadParamData
            r2.<init>((int) r1)
            boolean r3 = r11.isOfflinePlay(r12)
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0035
            java.lang.String r12 = com.tencent.liteav.txcplayer.a.a.d(r12)
            if (r1 != 0) goto L_0x0060
            java.lang.String r3 = ".mp4"
            boolean r3 = r12.endsWith(r3)
            if (r3 == 0) goto L_0x0060
            r3 = 10
            r2.setDlType(r3)
            goto L_0x0060
        L_0x0035:
            java.lang.String r3 = "?"
            int r3 = r12.indexOf(r3)
            java.lang.String r12 = r12.substring(r5, r3)
            r3 = 47
            int r6 = r12.lastIndexOf(r3)
            int r6 = r6 + r4
            java.lang.String r6 = r12.substring(r6)
            r7 = 2330303(0x238ebf, float:3.26545E-39)
            com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy r7 = com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyFactory.getTPDownloadProxy(r7)
            int r3 = r12.lastIndexOf(r3)
            java.lang.String r12 = r12.substring(r5, r3)
            r7.updateStoragePath(r12)
            r2.setOffline(r4)
            r12 = r6
        L_0x0060:
            r0.fileId(r12)
            if (r1 != 0) goto L_0x0079
            com.tencent.liteav.txcplayer.e r1 = r11.mConfig
            if (r1 == 0) goto L_0x0079
            boolean r1 = r1.f21751y
            if (r1 == 0) goto L_0x0079
            java.lang.String r1 = ".hls"
            boolean r12 = r12.endsWith(r1)
            if (r12 == 0) goto L_0x0079
            r12 = 3
            r2.setDlType(r12)
        L_0x0079:
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            r6 = -1
            com.tencent.liteav.txcplayer.e r1 = r11.mConfig
            float r3 = r1.f21740n
            r8 = 0
            int r9 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            r10 = 1149239296(0x44800000, float:1024.0)
            if (r9 <= 0) goto L_0x0090
            boolean r9 = r1.f21742p
            if (r9 != 0) goto L_0x0090
            goto L_0x0096
        L_0x0090:
            float r3 = r1.f21739m
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0099
        L_0x0096:
            float r3 = r3 * r10
            float r3 = r3 * r10
            long r6 = (long) r3
        L_0x0099:
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            java.lang.String r10 = "dl_param_buffer_size"
            if (r3 < 0) goto L_0x00a9
            java.lang.Long r1 = java.lang.Long.valueOf(r6)
            r12.put(r10, r1)
            goto L_0x00c0
        L_0x00a9:
            boolean r1 = r1.f21742p
            if (r1 != 0) goto L_0x00b9
            r1 = 5242880(0x500000, float:7.34684E-39)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.put(r10, r1)
            r11.mIsSetDefaultBufferSize = r4
            goto L_0x00c0
        L_0x00b9:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r12.put(r10, r1)
        L_0x00c0:
            com.tencent.liteav.txcplayer.e r1 = r11.mConfig
            int r1 = r1.f21745s
            java.lang.String r3 = "dl_param_preferred_bitrate_index"
            r4 = -1000(0xfffffffffffffc18, float:NaN)
            if (r1 == r4) goto L_0x00d2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.put(r3, r1)
            goto L_0x00dd
        L_0x00d2:
            int r1 = r11.mBitrateIndex
            if (r1 == r4) goto L_0x00dd
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.put(r3, r1)
        L_0x00dd:
            com.tencent.liteav.txcplayer.e r1 = r11.mConfig
            long r3 = r1.f21747u
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ee
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "dl_param_preferred_resolution"
            r12.put(r3, r1)
        L_0x00ee:
            int r1 = r12.size()
            if (r1 <= 0) goto L_0x00f7
            r2.setExtInfoMap(r12)
        L_0x00f7:
            r0.downloadParam(r2)
            com.tencent.thumbplayer.tcmedia.api.ITPPlayer r12 = r11.mTPPPlayer
            com.tencent.thumbplayer.tcmedia.api.TPVideoInfo r0 = r0.build()
            r12.setVideoInfo(r0)
        L_0x0103:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.thumbplayer.ThumbMediaPlayer.setVideoInfo(java.lang.String):void");
    }

    public void addSubtitleSource(String str, String str2, String str3) {
        this.mTPPPlayer.addSubtitleSource(str, str3, str2);
    }

    public void attachTRTC(Object obj) {
        this.mTrtcCloud = obj;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                Class cls2 = Boolean.TYPE;
                cls.getDeclaredMethod("enableMixExternalAudioFrame", new Class[]{cls2, cls2}).invoke(this.mTrtcCloud, new Object[]{Boolean.FALSE, Boolean.TRUE});
                LiteavLog.i(this.TAG, "attachTRTC enableMixExternalAudioFrame");
                setEnableMixExternalAudioFrame();
            } catch (Exception e11) {
                String str = this.TAG;
                LiteavLog.e(str, "attachTRTC exception : " + e11.toString());
            }
        }
    }

    public void deselectTrack(int i11) {
        this.mTPPPlayer.deselectTrack(i11, (long) i11);
    }

    public void detachTRTC() {
        LiteavLog.i(this.TAG, "detachTRTC");
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("enableMixExternalAudioFrame", new Class[]{cls2, cls2});
                Object obj2 = this.mTrtcCloud;
                Boolean bool = Boolean.FALSE;
                declaredMethod.invoke(obj2, new Object[]{bool, bool});
            } catch (Exception e11) {
                String str = this.TAG;
                LiteavLog.e(str, "detachTRTC exception : " + e11.toString());
            }
            this.mTrtcCloud = null;
            TRTCCloudClassInvokeHelper unused = TRTCCloudClassInvokeHelper.mInstance = null;
        }
    }

    public void enableAdaptiveBitrate() {
        this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, 1));
        this.mBitrateIndex = -1;
    }

    public int getBitrateIndex() {
        int i11 = this.mBitrateIndex;
        if (i11 == -1) {
            return i11;
        }
        TPProgramInfo[] programInfo = this.mTPPPlayer.getProgramInfo();
        if (programInfo != null && programInfo.length > 0) {
            int length = programInfo.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                TPProgramInfo tPProgramInfo = programInfo[i12];
                if (tPProgramInfo.actived && !TextUtils.isEmpty(tPProgramInfo.resolution)) {
                    this.mBitrateIndex = tPProgramInfo.programId;
                    break;
                }
                i12++;
            }
        }
        String str = this.TAG;
        LiteavLog.i(str, "getBitrateIndex ：" + this.mBitrateIndex);
        return this.mBitrateIndex;
    }

    public e getConfig() {
        return this.mConfig;
    }

    public long getCurrentPosition() {
        return this.mTPPPlayer.getCurrentPositionMs();
    }

    public long getDuration() {
        ITPPlayer iTPPlayer = this.mTPPPlayer;
        if (this.mIsPlayerReleased || iTPPlayer == null) {
            return 0;
        }
        return iTPPlayer.getDurationMs();
    }

    public com.tencent.liteav.txcplayer.model.b getMediaInfo() {
        String[] split;
        LiteavLog.i(this.TAG, "getMediaInfo");
        com.tencent.liteav.txcplayer.model.b bVar = new com.tencent.liteav.txcplayer.model.b();
        bVar.f21758a = "thumbplayer";
        bVar.f21763f = new com.tencent.liteav.txcplayer.model.c();
        String propertyString = this.mTPPPlayer.getPropertyString(0);
        if (propertyString != null && propertyString.length() > 0 && (split = propertyString.split("\\n")) != null && split.length > 0) {
            bVar.f21763f.f21765b = getSupportedBitrates();
            int i11 = this.mBitrateIndex;
            if (i11 == -1000) {
                i11 = 0;
            }
            bVar.f21763f.f21768e = new c.a(i11);
            bVar.f21763f.f21767d = new c.a(i11);
            com.tencent.liteav.txcplayer.model.c cVar = bVar.f21763f;
            cVar.f21766c.add(cVar.f21768e);
            com.tencent.liteav.txcplayer.model.c cVar2 = bVar.f21763f;
            cVar2.f21766c.add(cVar2.f21767d);
            for (String str : split) {
                if (str != null) {
                    String trim = str.substring(str.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1, str.length()).trim();
                    if (str.contains("ContainerFormat=")) {
                        bVar.f21763f.f21764a = trim;
                    } else if (str.contains("VideoCodec=")) {
                        bVar.f21759b = "avcodec";
                        bVar.f21760c = trim;
                        bVar.f21763f.f21767d.f21770b = trim;
                    } else if (str.contains("VideoProfile=")) {
                        bVar.f21763f.f21767d.f21771c = trim;
                    } else if (str.contains("Width=")) {
                        bVar.f21763f.f21767d.f21773e = Integer.valueOf(trim).intValue();
                    } else if (str.contains("Height=")) {
                        bVar.f21763f.f21767d.f21774f = Integer.valueOf(trim).intValue();
                    } else if (str.contains("VideoBitRate=")) {
                        bVar.f21763f.f21767d.f21772d = (long) Integer.valueOf(trim).intValue();
                    } else if (str.contains("AudioCodec=")) {
                        bVar.f21761d = "avcodec";
                        bVar.f21762e = trim;
                        bVar.f21763f.f21768e.f21770b = trim;
                    } else if (str.contains("AudioProfile=")) {
                        bVar.f21763f.f21768e.f21771c = trim;
                    } else if (str.contains("AudioBitRate=")) {
                        bVar.f21763f.f21768e.f21772d = (long) Integer.valueOf(trim).intValue();
                    } else if (str.contains("SampleRate=")) {
                        bVar.f21763f.f21768e.f21775g = Integer.valueOf(trim).intValue();
                    }
                }
            }
        }
        return bVar;
    }

    public long getPdtTimeMs(long j11) {
        return this.mTPPPlayer.getPdtTimeMs(j11);
    }

    public long getPlayableDurationMs() {
        return this.mTPPPlayer.getPlayableDurationMs();
    }

    public long getPositionMs(long j11) {
        return this.mTPPPlayer.getPositionMs(j11);
    }

    public long getPropertyLong(int i11) throws IllegalStateException {
        if (i11 == 208) {
            i11 = 208;
        } else if (i11 != 209) {
            switch (i11) {
                case 100:
                    i11 = 100;
                    break;
                case 101:
                    i11 = 101;
                    break;
                case 102:
                    i11 = 102;
                    break;
                case 103:
                    i11 = 103;
                    break;
                default:
                    switch (i11) {
                        case 201:
                            i11 = 201;
                            break;
                        case 202:
                            i11 = 202;
                            break;
                        case 203:
                            i11 = 203;
                            break;
                        case 204:
                            i11 = 204;
                            break;
                        case 205:
                            i11 = 205;
                            break;
                        case 206:
                            i11 = 206;
                            break;
                        default:
                            switch (i11) {
                                case 301:
                                    return this.mBitrate;
                                case 302:
                                    long playableDurationMs = ((this.mBitrate * (this.mTPPPlayer.getPlayableDurationMs() - this.mTPPPlayer.getCurrentPositionMs())) / 1000) / 8;
                                    if (playableDurationMs < 0) {
                                        return 0;
                                    }
                                    return playableDurationMs;
                                case 303:
                                    return this.mTcpSpeed;
                            }
                    }
            }
        } else {
            i11 = 209;
        }
        return this.mTPPPlayer.getPropertyLong(i11);
    }

    public float getRate() {
        return this.mRate;
    }

    public ArrayList<com.tencent.liteav.txcplayer.model.a> getSupportedBitrates() {
        ArrayList<com.tencent.liteav.txcplayer.model.a> arrayList;
        TPProgramInfo[] programInfo = this.mTPPPlayer.getProgramInfo();
        if (programInfo == null || programInfo.length <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>(programInfo.length);
            for (TPProgramInfo tPProgramInfo : programInfo) {
                if (tPProgramInfo != null) {
                    com.tencent.liteav.txcplayer.model.a aVar = new com.tencent.liteav.txcplayer.model.a();
                    String[] split = tPProgramInfo.resolution.split("x");
                    if (split != null && split.length == 2) {
                        aVar.f21755b = Integer.valueOf(split[0]).intValue();
                        aVar.f21756c = Integer.valueOf(split[1]).intValue();
                    }
                    int i11 = (int) tPProgramInfo.bandwidth;
                    aVar.f21757d = i11;
                    aVar.f21754a = tPProgramInfo.programId;
                    if (tPProgramInfo.actived) {
                        this.mBitrate = (long) i11;
                    }
                    if ((aVar.f21755b != 0 && aVar.f21756c != 0) || i11 != 0) {
                        arrayList.add(aVar);
                        LiteavLog.i(this.TAG, "getSupportedBitrates item index：" + aVar.f21754a + ":width:" + aVar.f21755b + ":height:" + aVar.f21756c + ":bitrate:" + aVar.f21757d);
                    }
                }
            }
        }
        LiteavLog.i(this.TAG, "mBitrateIndex:" + this.mBitrateIndex + ":mBitrate:" + this.mBitrate);
        return arrayList;
    }

    public Surface getSurface() {
        String str = this.TAG;
        LiteavLog.i(str, "getSurface ：" + this.mSurface);
        return this.mSurface;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public ITPPlayer getTPPPlayer() {
        return this.mTPPPlayer;
    }

    public TPTrackInfo[] getTrackInfo() {
        return this.mTPPPlayer.getTrackInfo();
    }

    public int getVideoHeight() {
        try {
            return this.mTPPPlayer.getVideoHeight();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getVideoSarDen() {
        return 0;
    }

    public int getVideoSarNum() {
        return 0;
    }

    public int getVideoWidth() {
        try {
            return this.mTPPPlayer.getVideoWidth();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public boolean isLooping() {
        String str = this.TAG;
        LiteavLog.i(str, "isLooping ：" + this.mIsLooping);
        return this.mIsLooping;
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        try {
            return this.mTPPPlayer.getCurrentState() == 5;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public void onReceiveFirstVideoRenderEvent() {
        if (getTXCVodVideoViewTargetState() == 4 || (!getConfig().f21742p && this.mTPPPlayer.getCurrentState() != 5)) {
            this.mHasReceiveFirstVideoRenderEvent = true;
            return;
        }
        notifyOnInfo(TXVodConstants.VOD_PLAY_EVT_FIRST_VIDEO_PACKET, 0, 0, (Object) null);
        notifyOnInfo(2026, 0, 0, (Object) null);
        notifyOnInfo(2003, 0, 0, (Object) null);
        this.mHasReceiveFirstVideoRenderEvent = false;
    }

    public void pause() throws IllegalStateException {
        this.mTPPPlayer.pause();
    }

    public void prepareAsync() throws IllegalStateException {
        try {
            LiteavLog.i(this.TAG, "prepareAsync");
            this.mTPPPlayer.prepareAsync();
        } catch (Throwable th2) {
            th2.printStackTrace();
            throw new IllegalStateException(th2);
        }
    }

    public void publishAudioToNetwork() {
        LiteavLog.i(this.TAG, "publishAudioToNetwork");
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("enableMixExternalAudioFrame", new Class[]{cls2, cls2});
                Object obj2 = this.mTrtcCloud;
                Boolean bool = Boolean.TRUE;
                declaredMethod.invoke(obj2, new Object[]{bool, bool});
            } catch (Exception e11) {
                String str = this.TAG;
                LiteavLog.e(str, "publishAudioToNetwork exception : " + e11.toString());
            }
        }
    }

    public void release() {
        this.mIsPlayerReleased = true;
        releaseSurfaceTexture();
        this.mTPPPlayer.setSurface((Surface) null);
        detachTRTC();
        com.tencent.liteav.txcplayer.common.a.a().execute(new Runnable() {
            public void run() {
                ThumbMediaPlayer.this.mTPPPlayer.release();
            }
        });
    }

    public void releaseSurfaceTexture() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null && !this.mReuseSurfaceTexture) {
            com.tencent.liteav.txcplayer.c cVar = this.mSurfaceTextureHost;
            if (cVar != null) {
                cVar.a(surfaceTexture);
            } else {
                surfaceTexture.release();
            }
            this.mSurfaceTexture = null;
        }
    }

    public void reset() {
        releaseSurfaceTexture();
        this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_PLAYER_START, Boolean.FALSE);
        if (this.mTPPPlayer != null) {
            this.mTPPPlayer.reset();
        }
    }

    public void seekTo(long j11, boolean z11) throws IllegalStateException {
        String str = this.TAG;
        LiteavLog.i(str, "seekTo msec: " + j11 + "：isAccurateSeek：" + z11);
        if (z11) {
            this.mTPPPlayer.seekTo((int) j11, 3);
        } else {
            this.mTPPPlayer.seekTo((int) j11, 1);
        }
    }

    public void selectTrack(int i11) {
        this.mTPPPlayer.selectTrack(i11, (long) i11);
    }

    public void setAudioNormalization(float f11) {
        if (f11 >= -70.0f && f11 <= 0.0f) {
            ITPPlayer iTPPlayer = this.mTPPPlayer;
            iTPPlayer.setAudioNormalizeVolumeParams("enable,loudnorm=I=" + f11 + ":TP=-1.5:LRA=5.4:linear=1");
        } else if (f11 == 1.0f) {
            this.mTPPPlayer.setAudioNormalizeVolumeParams("disable");
        }
    }

    public void setAudioStreamType(int i11) {
        LiteavLog.i(this.TAG, "setAudioStreamType：".concat(String.valueOf(i11)));
    }

    public void setAudioVolume(int i11) {
        LiteavLog.i(this.TAG, "setAudioVolume： ".concat(String.valueOf(i11)));
        if (i11 == 0) {
            this.mTPPPlayer.setOutputMute(true);
        } else {
            this.mTPPPlayer.setOutputMute(false);
            this.mTPPPlayer.setAudioGainRatio(((float) i11) / 100.0f);
        }
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                Class cls2 = Integer.TYPE;
                cls.getDeclaredMethod("setMixExternalAudioVolume", new Class[]{cls2, cls2}).invoke(this.mTrtcCloud, new Object[]{Integer.valueOf(i11), Integer.valueOf(i11)});
            } catch (Exception e11) {
                String str = this.TAG;
                LiteavLog.e(str, "setAudioVolume exception : " + e11.toString());
            }
        }
    }

    public void setBitrateIndex(int i11) {
        TPProgramInfo[] programInfo;
        LiteavLog.i(this.TAG, "setBitrateIndex ：".concat(String.valueOf(i11)));
        if (this.mBitrateIndex == -1) {
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, 0));
        }
        if (i11 != -1 && (programInfo = this.mTPPPlayer.getProgramInfo()) != null && i11 >= 0 && i11 < programInfo.length) {
            this.mTPPPlayer.selectProgram(i11, 0);
        }
        this.mBitrateIndex = i11;
    }

    public void setConfig(e eVar) {
        int i11;
        if (eVar != null) {
            this.mConfig = eVar;
            String a11 = com.tencent.liteav.txcplayer.common.b.a();
            TPPlayerConfig.setProxyDataDir(a11);
            if (com.tencent.liteav.txcplayer.common.b.b() >= 0) {
                i11 = com.tencent.liteav.txcplayer.common.b.b();
            } else {
                i11 = this.mConfig.f21732f * 100;
            }
            if (i11 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("VodCacheReserveSizeMB", i11);
                    TPPlayerConfig.parseHostConfig(new JSONObject().put(TPPlayerMgr.PROXY_HOST_KEY, jSONObject).toString());
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
            setEnableAccurateSeek(eVar.f21735i);
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(100, eVar.f21741o));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(101, eVar.f21735i));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(102, 1000));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(117, 80000));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(103, 200));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(105, 1000));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(106, 8000));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(107, 30000));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(108, (long) (((float) eVar.f21729c) * 1000.0f)));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(109, (long) ((float) eVar.f21727a)));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(504, eVar.f21751y ? 1 : 0));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildString(180, eVar.f21749w));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildString(181, eVar.f21750x));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(200, 80));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(201, true));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(401, true));
            long j11 = 4;
            if (this.mConfig.f21733g == 0) {
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(202, 4));
            } else {
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(202, 2));
            }
            ITPPlayer iTPPlayer = this.mTPPPlayer;
            TPOptionalParam tPOptionalParam = new TPOptionalParam();
            if (eVar.f21730d) {
                j11 = 2;
            }
            iTPPlayer.setPlayerOptionalParam(tPOptionalParam.buildLong(203, j11));
            int i12 = this.mConfig.f21745s;
            if (i12 == -1000 && (i12 = this.mBitrateIndex) == -1000) {
                i12 = -1000;
            }
            if (i12 != -1000) {
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(132, (long) i12));
            }
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(133, resolveAdaptivePreferredResolution(eVar.f21747u)));
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildLong(450, 1));
            if (com.tencent.liteav.txcplayer.common.c.a(LicenseChecker.a.PLAYER_PREMIUM)) {
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(182, true));
            } else {
                this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildBoolean(182, false));
            }
            TPPlayerConfig.setP2PEnable(true);
            ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(THUMB_PLAYER_PLATFORM_ID);
            if (tPDownloadProxy != null) {
                tPDownloadProxy.updateStoragePath(a11);
                tPDownloadProxy.setMaxStorageSizeMB((long) i11);
                tPDownloadProxy.setLogListener(new TXCDLProxyLogListener());
            }
            Map<String, Object> map = this.mConfig.f21752z;
            if (map != null) {
                parseExtraConfig(map);
            }
            setVideoInfo(eVar.f21743q);
        }
    }

    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        if (isContentUri(uri.toString())) {
            this.mTPPPlayer.setDataSource(this.mContext.getContentResolver().openAssetFileDescriptor(uri, "r"));
        } else if (isAssetFile(uri.toString())) {
            this.mTPPPlayer.setDataSource(this.mContext.getAssets().openFd(uri.toString().substring(uri.toString().indexOf("://") + 3)));
        } else {
            setDataSource(context, uri, (Map<String, String>) null);
        }
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        if (this.mSurfaceTexture == null) {
            if (surfaceHolder != null) {
                this.mSurface = surfaceHolder.getSurface();
            }
            this.mSurfaceHolder = surfaceHolder;
            this.mTPPPlayer.setSurfaceHolder(surfaceHolder);
        }
    }

    public void setEnableAccurateSeek(boolean z11) {
        this.mEnableAccurateSeek = z11;
    }

    public void setKeepInBackground(boolean z11) {
        LiteavLog.i(this.TAG, "setKeepInBackground none：".concat(String.valueOf(z11)));
    }

    public void setLogEnabled(boolean z11) {
        TPLogUtil.setDebugEnable(z11);
    }

    public void setLooping(boolean z11) {
        LiteavLog.i(this.TAG, "setLooping ：".concat(String.valueOf(z11)));
        this.mIsLooping = z11;
        this.mTPPPlayer.setLoopback(z11);
    }

    public void setMaxCacheSize(int i11) {
        TPPlayerMgr.setProxyMaxStorageSizeMB((long) i11);
    }

    public void setPrivateConfig(Map<String, Object> map) {
        this.mPrivateConfig = map;
    }

    public void setRate(float f11) {
        String str = this.TAG;
        LiteavLog.i(str, "setRate " + this.mRate);
        this.mRate = f11;
        this.mTPPPlayer.setPlaySpeedRatio(f11);
    }

    public void setScreenOnWhilePlaying(boolean z11) {
        LiteavLog.i(this.TAG, "setScreenOnWhilePlaying(true) screenOn:".concat(String.valueOf(z11)));
        if (this.mScreenOnWhilePlaying != z11) {
            if (z11 && this.mSurfaceHolder == null) {
                LiteavLog.w(this.TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z11;
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.setKeepScreenOn(z11);
            }
        }
    }

    public void setSubtitleStyle(TXSubtitleRenderModel tXSubtitleRenderModel) {
        if (this.mTPPPlayer != null) {
            this.mTPPPlayer.setPlayerOptionalParam(new TPOptionalParam().buildObject(TPOptionalID.OPTION_ID_GLOBAL_OBJECT_SUBTITLE_RENDER_PARAMS, convertToTPSubtitleRenderModel(tXSubtitleRenderModel)));
        }
    }

    public void setSurface(Surface surface) {
        if (this.mSurfaceTexture == null) {
            setSurfaceToPlayer(surface);
        }
        String str = this.TAG;
        LiteavLog.i(str, "setSurface mSurface:" + this.mSurface);
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        if (this.mSurfaceTexture != surfaceTexture) {
            releaseSurfaceTexture();
            this.mSurfaceTexture = surfaceTexture;
            if (surfaceTexture == null) {
                this.mSurface = null;
                setSurfaceToPlayer((Surface) null);
                return;
            }
            if (this.mSurface == null) {
                this.mSurface = new Surface(surfaceTexture);
            }
            setSurfaceToPlayer(this.mSurface);
        }
    }

    public void setSurfaceTextureHost(com.tencent.liteav.txcplayer.c cVar) {
        this.mSurfaceTextureHost = cVar;
    }

    public void setWakeMode(Context context, int i11) {
        boolean z11;
        LiteavLog.i(this.TAG, "setWakeMode ：".concat(String.valueOf(i11)));
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z11 = true;
                this.mWakeLock.release();
            } else {
                z11 = false;
            }
            this.mWakeLock = null;
        } else {
            z11 = false;
        }
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i11 | 536870912, ThumbMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z11) {
            this.mWakeLock.acquire();
        }
    }

    public void start() throws IllegalStateException {
        LiteavLog.i(this.TAG, "TPPlayer start");
        if (this.mHasReceiveFirstVideoRenderEvent) {
            notifyOnInfo(TXVodConstants.VOD_PLAY_EVT_FIRST_VIDEO_PACKET, 0, 0, (Object) null);
            notifyOnInfo(2026, 0, 0, (Object) null);
            notifyOnInfo(2003, 0, 0, (Object) null);
            this.mHasReceiveFirstVideoRenderEvent = false;
        }
        if (this.mConfig.f21739m >= 0.0f) {
            this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_BUFFER_SIZE_BYTE, Long.valueOf((long) (this.mConfig.f21739m * 1024.0f * 1024.0f)));
        } else if (this.mIsSetDefaultBufferSize) {
            this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_BUFFER_SIZE_BYTE, 0);
            this.mIsSetDefaultBufferSize = false;
        }
        this.mTPPPlayer.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_PLAYER_START, Boolean.TRUE);
        this.mTPPPlayer.start();
    }

    public void stop() throws IllegalStateException {
        try {
            this.mTPPPlayer.stopAsync();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void unpublishAudioToNetwork() {
        LiteavLog.i(this.TAG, "unpublishAudioToNetwork ：none");
        Object obj = this.mTrtcCloud;
        if (obj != null) {
            try {
                Class<?> cls = obj.getClass();
                Class cls2 = Boolean.TYPE;
                cls.getDeclaredMethod("enableMixExternalAudioFrame", new Class[]{cls2, cls2}).invoke(this.mTrtcCloud, new Object[]{Boolean.FALSE, Boolean.TRUE});
            } catch (Exception e11) {
                String str = this.TAG;
                LiteavLog.e(str, "unpublishAudioToNetwork exception : " + e11.toString());
            }
        }
    }

    public void updateBitrate(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 <= 0) {
            return;
        }
        if (this.mTotalFileSize != j11 || this.mBitrate == 0) {
            this.mTotalFileSize = j11;
            long duration = getDuration();
            if (duration > 0 && i11 > 0) {
                this.mBitrate = ((j11 * 1000) * 8) / duration;
            }
        }
    }

    public void updateTcpSpeed(long j11) {
        this.mTcpSpeed = j11;
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String uri2 = uri.toString();
        this.mDataSource = uri2;
        if (isOfflinePlay(uri2)) {
            uri2 = uri2.substring(uri2.indexOf("?") + 1);
        }
        ITPMediaAsset handleDRMAsset = handleDRMAsset(uri2);
        if (handleDRMAsset != null) {
            ITPMediaUrlAsset handleUrlAsset = handleUrlAsset(uri2);
            if (handleUrlAsset != null) {
                handleDRMAsset.setExtraParam(handleUrlAsset.getExtraParam());
            }
            if (map != null && map.size() > 0) {
                handleDRMAsset.setHttpHeader(map);
            }
            this.mTPPPlayer.setDataSource(handleDRMAsset);
            return;
        }
        ITPMediaUrlAsset handleUrlAsset2 = handleUrlAsset(uri2);
        if (handleUrlAsset2 != null) {
            if (map != null && map.size() > 0) {
                handleUrlAsset2.setHttpHeader(map);
            }
            this.mTPPPlayer.setDataSource((ITPMediaAsset) handleUrlAsset2);
            return;
        }
        this.mTPPPlayer.setDataSource(uri2, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException, IllegalArgumentException, IllegalStateException {
        this.mTPPPlayer.setDataSource(ParcelFileDescriptor.dup(fileDescriptor));
    }

    public void setDataSource(String str) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource((Context) null, Uri.parse(str));
    }
}
