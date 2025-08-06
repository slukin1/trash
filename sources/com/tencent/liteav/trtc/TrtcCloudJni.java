package com.tencent.liteav.trtc;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.base.ThreadUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.b;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.tencent.trtc.TRTCStatistics;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONArray;
import org.json.JSONObject;

@JNINamespace("liteav::trtc")
public class TrtcCloudJni {
    private static final Object INIT_LOCK = new Object();
    private static final String TAG = "TrtcCloudJni";
    private static boolean mHasInited = false;
    private TRTCCloudListener.TRTCAudioFrameListener mAudioFrameListener;
    private TRTCCloudListener.TRTCVideoFrameListener mCalledGLCreatedFrameListener;
    private final HashSet<View> mFloatingWindowSet;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private TRTCCloudListener mListener;
    private Handler mListenerHandler;
    private List<TRTCCloudListener> mListenerList;
    private String mLocalUserId;
    private final a<TRTCCloudListener.TRTCVideoRenderListener> mLocalVideoRenderListenerWrapper;
    private long mNativeTrtcCloudJni;
    private final ReentrantReadWriteLock mReadWriteLock;
    private final Map<String, a<TRTCCloudListener.TRTCVideoRenderListener>> mRemoteVideoRenderListenerMap;
    private final a<TRTCCloudListener.TRTCVideoFrameListener> mVideoFrameListenerWrapper;

    /* renamed from: com.tencent.liteav.trtc.TrtcCloudJni$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21691a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.tencent.liteav.base.util.k[] r0 = com.tencent.liteav.base.util.k.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21691a = r0
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21691a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21691a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.liteav.base.util.k r1 = com.tencent.liteav.base.util.k.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.TrtcCloudJni.AnonymousClass3.<clinit>():void");
        }
    }

    public static class AudioFrame {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f21692a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f21692a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.f21692a.channel;
        }

        public byte[] getData() {
            return this.f21692a.data;
        }

        public int getSampleRate() {
            return this.f21692a.sampleRate;
        }

        public long getTimestamp() {
            return this.f21692a.timestamp;
        }
    }

    public static class AudioParallelParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioParallelParams f21693a;

        public AudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
            this.f21693a = tRTCAudioParallelParams;
        }

        public String[] getIncludeUsers() {
            ArrayList<String> arrayList = this.f21693a.includeUsers;
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public int getMaxCount() {
            return this.f21693a.maxCount;
        }
    }

    public static class AudioRecordingParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCAudioRecordingParams f21694a;

        public AudioRecordingParams(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
            this.f21694a = tRTCAudioRecordingParams;
        }

        public int getContent() {
            return this.f21694a.recordingContent;
        }

        public String getFilePath() {
            return this.f21694a.filePath;
        }

        public int getMaxDurationPerFile() {
            return this.f21694a.maxDurationPerFile;
        }
    }

    public static class EnterRoomParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCParams f21695a;

        public EnterRoomParams(TRTCCloudDef.TRTCParams tRTCParams) {
            this.f21695a = tRTCParams;
        }

        public String getBusinessInfo() {
            return this.f21695a.businessInfo;
        }

        public String getPrivateMapKey() {
            return this.f21695a.privateMapKey;
        }

        public String getRecordId() {
            return this.f21695a.userDefineRecordId;
        }

        public int getRole() {
            return this.f21695a.role;
        }

        public int getRoomId() {
            return this.f21695a.roomId;
        }

        public int getSdkAppId() {
            return this.f21695a.sdkAppId;
        }

        public String getStrRoomId() {
            return this.f21695a.strRoomId;
        }

        public String getStreamId() {
            return this.f21695a.streamId;
        }

        public String getUserId() {
            return this.f21695a.userId;
        }

        public String getUserSig() {
            return this.f21695a.userSig;
        }
    }

    public static class LocalRecordingParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCLocalRecordingParams f21696a;

        public LocalRecordingParams(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
            this.f21696a = tRTCLocalRecordingParams;
        }

        public String getFilePath() {
            return this.f21696a.filePath;
        }

        public int getInterval() {
            return this.f21696a.interval;
        }

        public int getMaxDurationPerFile() {
            return this.f21696a.maxDurationPerFile;
        }

        public int getRecordType() {
            return this.f21696a.recordType;
        }
    }

    public static class LocalStatistics {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public TRTCStatistics.TRTCLocalStatistics f21697a = new TRTCStatistics.TRTCLocalStatistics();

        public static void addLocalStatistics(LocalStatistics localStatistics, ArrayList<LocalStatistics> arrayList) {
            arrayList.add(localStatistics);
        }

        public static LocalStatistics createLocalStatistics(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            LocalStatistics localStatistics = new LocalStatistics();
            TRTCStatistics.TRTCLocalStatistics tRTCLocalStatistics = localStatistics.f21697a;
            tRTCLocalStatistics.streamType = i11;
            tRTCLocalStatistics.width = i12;
            tRTCLocalStatistics.height = i13;
            tRTCLocalStatistics.frameRate = i14;
            tRTCLocalStatistics.videoBitrate = i15;
            tRTCLocalStatistics.audioBitrate = i17;
            tRTCLocalStatistics.audioSampleRate = i16;
            tRTCLocalStatistics.audioCaptureState = i18;
            return localStatistics;
        }

        public static ArrayList<LocalStatistics> createLocalStatisticsArray() {
            return new ArrayList<>();
        }
    }

    public static class MixUser {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCMixUser f21698a;

        public /* synthetic */ MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser, byte b11) {
            this(tRTCMixUser);
        }

        public int getHeight() {
            return this.f21698a.height;
        }

        public String getImage() {
            return TextUtils.isEmpty(this.f21698a.image) ? "" : this.f21698a.image;
        }

        public int getInputType() {
            return this.f21698a.inputType;
        }

        public boolean getPureAudio() {
            return this.f21698a.pureAudio;
        }

        public int getRenderMode() {
            return this.f21698a.renderMode;
        }

        public String getRoomId() {
            return TextUtils.isEmpty(this.f21698a.roomId) ? "" : this.f21698a.roomId;
        }

        public int getSoundLevel() {
            return this.f21698a.soundLevel;
        }

        public int getStreamType() {
            return this.f21698a.streamType;
        }

        public String getUserId() {
            return TextUtils.isEmpty(this.f21698a.userId) ? "" : this.f21698a.userId;
        }

        public int getWidth() {
            return this.f21698a.width;
        }

        public int getX() {
            return this.f21698a.f50061x;
        }

        public int getY() {
            return this.f21698a.f50062y;
        }

        public int getZOrder() {
            return this.f21698a.zOrder;
        }

        private MixUser(TRTCCloudDef.TRTCMixUser tRTCMixUser) {
            this.f21698a = tRTCMixUser;
        }
    }

    public static class PayloadPrivateEncryptionConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig f21699a;

        public PayloadPrivateEncryptionConfig(TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
            this.f21699a = tRTCPayloadPrivateEncryptionConfig;
        }

        public int getEncryptionAlgorithm() {
            return this.f21699a.encryptionAlgorithm;
        }

        public String getEncryptionKey() {
            String str = this.f21699a.encryptionKey;
            return str != null ? str : "";
        }

        public byte[] getEncryptionSalt() {
            return this.f21699a.encryptionSalt;
        }
    }

    public static class PublishCDNParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCDNParam f21700a;

        public PublishCDNParams(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
            this.f21700a = tRTCPublishCDNParam;
        }

        public int getAppId() {
            return this.f21700a.appId;
        }

        public int getBizId() {
            return this.f21700a.bizId;
        }

        public String getStreamId() {
            return TextUtils.isEmpty(this.f21700a.streamId) ? "" : this.f21700a.streamId;
        }

        public String getUrl() {
            return TextUtils.isEmpty(this.f21700a.url) ? "" : this.f21700a.url;
        }
    }

    public static class PublishCdnUrl {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishCdnUrl f21701a;

        public PublishCdnUrl(TRTCCloudDef.TRTCPublishCdnUrl tRTCPublishCdnUrl) {
            this.f21701a = tRTCPublishCdnUrl;
        }

        public boolean getIsInternalLine() {
            return this.f21701a.isInternalLine;
        }

        public String getRtmpUrl() {
            String str = this.f21701a.rtmpUrl;
            return str != null ? str : "";
        }
    }

    public static class PublishTarget {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCPublishTarget f21702a;

        public PublishTarget(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget) {
            this.f21702a = tRTCPublishTarget;
        }

        public int getMode() {
            return this.f21702a.mode;
        }

        public PublishCdnUrl[] getPublishCdnUrls() {
            ArrayList<TRTCCloudDef.TRTCPublishCdnUrl> arrayList = this.f21702a.cdnUrlList;
            if (arrayList == null) {
                return null;
            }
            PublishCdnUrl[] publishCdnUrlArr = new PublishCdnUrl[arrayList.size()];
            for (int i11 = 0; i11 < this.f21702a.cdnUrlList.size(); i11++) {
                publishCdnUrlArr[i11] = new PublishCdnUrl(this.f21702a.cdnUrlList.get(i11));
            }
            return publishCdnUrlArr;
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f21702a.mixStreamIdentity);
        }
    }

    public static class RemoteStatistics {

        /* renamed from: a  reason: collision with root package name */
        public TRTCStatistics.TRTCRemoteStatistics f21703a = new TRTCStatistics.TRTCRemoteStatistics();

        public static void addRemoteStatistics(RemoteStatistics remoteStatistics, ArrayList<RemoteStatistics> arrayList) {
            arrayList.add(remoteStatistics);
        }

        public static RemoteStatistics createRemoteStatistics(String str, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29) {
            RemoteStatistics remoteStatistics = new RemoteStatistics();
            TRTCStatistics.TRTCRemoteStatistics tRTCRemoteStatistics = remoteStatistics.f21703a;
            tRTCRemoteStatistics.userId = str;
            tRTCRemoteStatistics.streamType = i11;
            tRTCRemoteStatistics.width = i12;
            tRTCRemoteStatistics.height = i13;
            tRTCRemoteStatistics.frameRate = i14;
            tRTCRemoteStatistics.audioPacketLoss = i22;
            tRTCRemoteStatistics.videoPacketLoss = i15;
            tRTCRemoteStatistics.videoBlockRate = i18;
            tRTCRemoteStatistics.videoTotalBlockTime = i17;
            tRTCRemoteStatistics.videoBitrate = i16;
            tRTCRemoteStatistics.audioBitrate = i21;
            tRTCRemoteStatistics.audioSampleRate = i19;
            tRTCRemoteStatistics.audioTotalBlockTime = i23;
            tRTCRemoteStatistics.audioBlockRate = i24;
            tRTCRemoteStatistics.jitterBufferDelay = i25;
            tRTCRemoteStatistics.point2PointDelay = i26;
            tRTCRemoteStatistics.finalLoss = i27;
            tRTCRemoteStatistics.remoteNetworkUplinkLoss = i28;
            tRTCRemoteStatistics.remoteNetworkRTT = i29;
            return remoteStatistics;
        }

        public static ArrayList<RemoteStatistics> createRemoteStatisticsArray() {
            return new ArrayList<>();
        }
    }

    public static class ScreenShareParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCScreenShareParams f21704a;

        public ScreenShareParams(TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
            this.f21704a = tRTCScreenShareParams;
        }

        public Object getMediaProjection() {
            return this.f21704a.mediaProjection;
        }
    }

    public static class SpeedTestResult {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public TRTCCloudDef.TRTCSpeedTestResult f21707a = new TRTCCloudDef.TRTCSpeedTestResult();

        public static SpeedTestResult createSpeedTestResult(boolean z11, String str, String str2, int i11, float f11, float f12, int i12, int i13, int i14, int i15, int i16) {
            SpeedTestResult speedTestResult = new SpeedTestResult();
            TRTCCloudDef.TRTCSpeedTestResult tRTCSpeedTestResult = speedTestResult.f21707a;
            tRTCSpeedTestResult.success = z11;
            tRTCSpeedTestResult.errMsg = str;
            tRTCSpeedTestResult.f50063ip = str2;
            tRTCSpeedTestResult.quality = i11;
            tRTCSpeedTestResult.upLostRate = f11;
            tRTCSpeedTestResult.downLostRate = f12;
            tRTCSpeedTestResult.rtt = i12;
            tRTCSpeedTestResult.availableUpBandwidth = i13;
            tRTCSpeedTestResult.availableDownBandwidth = i14;
            tRTCSpeedTestResult.upJitter = i15;
            tRTCSpeedTestResult.downJitter = i16;
            return speedTestResult;
        }
    }

    public static class Statistics {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public TRTCStatistics f21708a = new TRTCStatistics();

        public static Statistics createStatistics(int i11, int i12, int i13, int i14, int i15, int i16, long j11, long j12, ArrayList<LocalStatistics> arrayList, ArrayList<RemoteStatistics> arrayList2) {
            Statistics statistics = new Statistics();
            TRTCStatistics tRTCStatistics = statistics.f21708a;
            tRTCStatistics.appCpu = i11;
            tRTCStatistics.systemCpu = i12;
            tRTCStatistics.upLoss = i13;
            tRTCStatistics.downLoss = i14;
            tRTCStatistics.rtt = i15;
            tRTCStatistics.gatewayRtt = i16;
            tRTCStatistics.sendBytes = j11;
            tRTCStatistics.receiveBytes = j12;
            tRTCStatistics.localArray = new ArrayList<>();
            statistics.f21708a.remoteArray = new ArrayList<>();
            if (arrayList != null) {
                Iterator<LocalStatistics> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    statistics.f21708a.localArray.add(it2.next().f21697a);
                }
            }
            if (arrayList2 != null) {
                Iterator<RemoteStatistics> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    statistics.f21708a.remoteArray.add(it3.next().f21703a);
                }
            }
            return statistics;
        }
    }

    public static class StreamEncoderParam {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamEncoderParam f21709a;

        public StreamEncoderParam(TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam) {
            this.f21709a = tRTCStreamEncoderParam;
        }

        public int getAudioEncodedChannelNum() {
            return this.f21709a.audioEncodedChannelNum;
        }

        public int getAudioEncodedCodecType() {
            return this.f21709a.audioEncodedCodecType;
        }

        public int getAudioEncodedKbps() {
            return this.f21709a.audioEncodedKbps;
        }

        public int getAudioEncodedSampleRate() {
            return this.f21709a.audioEncodedSampleRate;
        }

        public int getVideoEncodedCodecType() {
            return this.f21709a.videoEncodedCodecType;
        }

        public int getVideoEncodedFPS() {
            return this.f21709a.videoEncodedFPS;
        }

        public int getVideoEncodedGOP() {
            return this.f21709a.videoEncodedGOP;
        }

        public int getVideoEncodedHeight() {
            return this.f21709a.videoEncodedHeight;
        }

        public int getVideoEncodedKbps() {
            return this.f21709a.videoEncodedKbps;
        }

        public int getVideoEncodedWidth() {
            return this.f21709a.videoEncodedWidth;
        }

        public String getVideoSeiParams() {
            return TextUtils.isEmpty(this.f21709a.videoSeiParams) ? "" : this.f21709a.videoSeiParams;
        }
    }

    public static class StreamMixingConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCStreamMixingConfig f21710a;

        public StreamMixingConfig(TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
            this.f21710a = tRTCStreamMixingConfig;
        }

        public TRTCUser[] getAudioMixUserList() {
            ArrayList<TRTCCloudDef.TRTCUser> arrayList = this.f21710a.audioMixUserList;
            if (arrayList == null) {
                return null;
            }
            TRTCUser[] tRTCUserArr = new TRTCUser[arrayList.size()];
            for (int i11 = 0; i11 < this.f21710a.audioMixUserList.size(); i11++) {
                tRTCUserArr[i11] = new TRTCUser(this.f21710a.audioMixUserList.get(i11));
            }
            return tRTCUserArr;
        }

        public int getBackgroundColor() {
            return this.f21710a.backgroundColor;
        }

        public String getBackgroundImage() {
            String str = this.f21710a.backgroundImage;
            return str != null ? str : "";
        }

        public VideoLayout[] getVideoLayoutList() {
            ArrayList<TRTCCloudDef.TRTCVideoLayout> arrayList = this.f21710a.videoLayoutList;
            if (arrayList == null) {
                return null;
            }
            VideoLayout[] videoLayoutArr = new VideoLayout[arrayList.size()];
            for (int i11 = 0; i11 < this.f21710a.videoLayoutList.size(); i11++) {
                videoLayoutArr[i11] = new VideoLayout(this.f21710a.videoLayoutList.get(i11));
            }
            return videoLayoutArr;
        }

        public Watermark[] getWatermarkList() {
            ArrayList<TRTCCloudDef.TRTCWatermark> arrayList = this.f21710a.watermarkList;
            if (arrayList == null) {
                return null;
            }
            Watermark[] watermarkArr = new Watermark[arrayList.size()];
            for (int i11 = 0; i11 < this.f21710a.watermarkList.size(); i11++) {
                watermarkArr[i11] = new Watermark(this.f21710a.watermarkList.get(i11));
            }
            return watermarkArr;
        }
    }

    public static class SwitchRoomConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCSwitchRoomConfig f21711a;

        public SwitchRoomConfig(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
            this.f21711a = tRTCSwitchRoomConfig;
        }

        public String getPrivateMapKey() {
            String str = this.f21711a.privateMapKey;
            return str != null ? str : "";
        }

        public int getRoomId() {
            return this.f21711a.roomId;
        }

        public String getStringRoomId() {
            String str = this.f21711a.strRoomId;
            return str != null ? str : "";
        }

        public String getUserSig() {
            String str = this.f21711a.userSig;
            return str != null ? str : "";
        }
    }

    public static class TRTCUser {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCUser f21712a;

        public TRTCUser(TRTCCloudDef.TRTCUser tRTCUser) {
            this.f21712a = tRTCUser;
        }

        public int getIntRoomId() {
            return this.f21712a.intRoomId;
        }

        public String getStrRoomId() {
            String str = this.f21712a.strRoomId;
            return str != null ? str : "";
        }

        public String getUserId() {
            String str = this.f21712a.userId;
            return str != null ? str : "";
        }
    }

    public static class TranscodingConfig {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCTranscodingConfig f21713a;

        public TranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
            this.f21713a = tRTCTranscodingConfig;
        }

        public int getAppId() {
            return this.f21713a.appId;
        }

        public int getAudioBitrate() {
            return this.f21713a.audioBitrate;
        }

        public int getAudioChannels() {
            return this.f21713a.audioChannels;
        }

        public int getAudioSampleRate() {
            return this.f21713a.audioSampleRate;
        }

        public int getBackgroundColor() {
            return this.f21713a.backgroundColor;
        }

        public String getBackgroundImage() {
            return TextUtils.isEmpty(this.f21713a.backgroundImage) ? "" : this.f21713a.backgroundImage;
        }

        public int getBizId() {
            return this.f21713a.bizId;
        }

        public MixUser[] getMixUsers() {
            ArrayList<TRTCCloudDef.TRTCMixUser> arrayList = this.f21713a.mixUsers;
            if (arrayList == null) {
                return null;
            }
            MixUser[] mixUserArr = new MixUser[arrayList.size()];
            for (int i11 = 0; i11 < this.f21713a.mixUsers.size(); i11++) {
                mixUserArr[i11] = new MixUser(this.f21713a.mixUsers.get(i11), (byte) 0);
            }
            return mixUserArr;
        }

        public int getMode() {
            return this.f21713a.mode;
        }

        public String getStreamId() {
            return TextUtils.isEmpty(this.f21713a.streamId) ? "" : this.f21713a.streamId;
        }

        public int getVideoBitrate() {
            return this.f21713a.videoBitrate;
        }

        public int getVideoFramerate() {
            return this.f21713a.videoFramerate;
        }

        public int getVideoGOP() {
            return this.f21713a.videoGOP;
        }

        public int getVideoHeight() {
            return this.f21713a.videoHeight;
        }

        public String getVideoSeiParams() {
            return TextUtils.isEmpty(this.f21713a.videoSeiParams) ? "" : this.f21713a.videoSeiParams;
        }

        public int getVideoWidth() {
            return this.f21713a.videoWidth;
        }
    }

    public static class VideoEncParams {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoEncParam f21714a;

        public VideoEncParams(TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
            this.f21714a = tRTCVideoEncParam;
        }

        public int getMinVideoBitrate() {
            return this.f21714a.minVideoBitrate;
        }

        public int getVideoBitrate() {
            return this.f21714a.videoBitrate;
        }

        public int getVideoFps() {
            return this.f21714a.videoFps;
        }

        public int getVideoResolution() {
            return this.f21714a.videoResolution;
        }

        public int getVideoResolutionMode() {
            return this.f21714a.videoResolutionMode;
        }

        public boolean isEnableAdjustRes() {
            return this.f21714a.enableAdjustRes;
        }
    }

    public static class VideoLayout {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCVideoLayout f21715a;

        public VideoLayout(TRTCCloudDef.TRTCVideoLayout tRTCVideoLayout) {
            this.f21715a = tRTCVideoLayout;
        }

        public int getBackgroundColor() {
            return this.f21715a.backgroundColor;
        }

        public int getFillMode() {
            return this.f21715a.fillMode;
        }

        public int getHeight() {
            return this.f21715a.height;
        }

        public String getPlaceHolderImage() {
            String str = this.f21715a.placeHolderImage;
            return str != null ? str : "";
        }

        public TRTCUser getTRTCUser() {
            return new TRTCUser(this.f21715a.fixedVideoUser);
        }

        public int getVideoStreamType() {
            return this.f21715a.fixedVideoStreamType;
        }

        public int getWidth() {
            return this.f21715a.width;
        }

        public int getX() {
            return this.f21715a.f50064x;
        }

        public int getY() {
            return this.f21715a.f50065y;
        }

        public int getZOrder() {
            return this.f21715a.zOrder;
        }
    }

    public static class Watermark {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCWatermark f21716a;

        public Watermark(TRTCCloudDef.TRTCWatermark tRTCWatermark) {
            this.f21716a = tRTCWatermark;
        }

        public int getHeight() {
            return this.f21716a.height;
        }

        public String getWatermarkUrl() {
            String str = this.f21716a.watermarkUrl;
            return str != null ? str : "";
        }

        public int getWidth() {
            return this.f21716a.width;
        }

        public int getX() {
            return this.f21716a.f50066x;
        }

        public int getY() {
            return this.f21716a.f50067y;
        }

        public int getZOrder() {
            return this.f21716a.zOrder;
        }
    }

    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public int f21717a;

        /* renamed from: b  reason: collision with root package name */
        public GLConstants.PixelFormatType f21718b;

        /* renamed from: c  reason: collision with root package name */
        public GLConstants.a f21719c;

        /* renamed from: d  reason: collision with root package name */
        public T f21720d;

        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    static {
        r.a();
    }

    public TrtcCloudJni(boolean z11) {
        this(0, z11);
    }

    private List<TRTCCloudListener> CopyOnReadListeners() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(this.mListenerList);
        TRTCCloudListener tRTCCloudListener = this.mListener;
        if (tRTCCloudListener != null && !copyOnWriteArrayList.contains(tRTCCloudListener)) {
            copyOnWriteArrayList.add(tRTCCloudListener);
        }
        return copyOnWriteArrayList;
    }

    private static int convertPixelBufferTypeToTRTCBufferType(GLConstants.a aVar) {
        if (aVar == GLConstants.a.BYTE_BUFFER) {
            return 1;
        }
        if (aVar == GLConstants.a.BYTE_ARRAY) {
            return 2;
        }
        return aVar == GLConstants.a.TEXTURE_2D ? 3 : 0;
    }

    private static int convertPixelFormatTypeToTRTCFormatType(GLConstants.PixelFormatType pixelFormatType) {
        if (pixelFormatType == GLConstants.PixelFormatType.I420) {
            return 1;
        }
        if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
            return 4;
        }
        return pixelFormatType == GLConstants.PixelFormatType.RGBA ? 5 : 0;
    }

    private static int convertPixelFrameRotationToTRTCVideoRotation(k kVar) {
        int i11 = AnonymousClass3.f21691a[kVar.ordinal()];
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (i11 != 2) {
                i12 = 3;
                if (i11 != 3) {
                    return 0;
                }
            }
        }
        return i12;
    }

    private static GLConstants.a convertTRTCBufferTypeToPixelBufferType(int i11, int i12) {
        if (i11 == 1) {
            return GLConstants.a.BYTE_BUFFER;
        }
        if (i11 == 2) {
            return GLConstants.a.BYTE_ARRAY;
        }
        if (3 == i12) {
            return GLConstants.a.TEXTURE_OES;
        }
        return GLConstants.a.TEXTURE_2D;
    }

    private static GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType(int i11) {
        if (i11 != 2) {
            if (i11 == 4) {
                return GLConstants.PixelFormatType.NV21;
            }
            if (i11 != 5) {
                return GLConstants.PixelFormatType.I420;
            }
        }
        return GLConstants.PixelFormatType.RGBA;
    }

    private static k covertTRTCVideoRotationToPixelFrameRotation(int i11) {
        if (i11 == 1) {
            return k.ROTATION_90;
        }
        if (i11 == 2) {
            return k.ROTATION_180;
        }
        if (i11 != 3) {
            return k.NORMAL;
        }
        return k.ROTATION_270;
    }

    public static Bundle createExtraInfoBundle(String str, int i11) {
        Bundle bundle = new Bundle();
        bundle.putInt(str, i11);
        return bundle;
    }

    private Bundle extraToBundle(String str) {
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    String[] strArr = new String[jSONArray.length()];
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        strArr[i11] = jSONArray.getString(i11);
                    }
                    bundle.putStringArray(next, strArr);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return bundle;
    }

    public static long getGLContextNativeHandle(Object obj) {
        return OpenGlUtils.getGLContextNativeHandle(obj);
    }

    /* access modifiers changed from: private */
    public void hideFloatingWindow() {
        WindowManager windowManager;
        if (!this.mFloatingWindowSet.isEmpty()) {
            Iterator<View> it2 = this.mFloatingWindowSet.iterator();
            while (it2.hasNext()) {
                View next = it2.next();
                if (!(next == null || (windowManager = (WindowManager) next.getContext().getSystemService("window")) == null)) {
                    windowManager.removeViewImmediate(next);
                }
            }
            this.mFloatingWindowSet.clear();
        }
    }

    public static void init(int i11) {
        synchronized (INIT_LOCK) {
            if (!mHasInited) {
                mHasInited = true;
                nativeGlobalInit(i11);
            }
        }
    }

    private static boolean isCustomPreprocessSupportedBufferType(GLConstants.a aVar) {
        return aVar == GLConstants.a.BYTE_BUFFER || aVar == GLConstants.a.BYTE_ARRAY || aVar == GLConstants.a.TEXTURE_2D;
    }

    private static boolean isCustomPreprocessSupportedFormatType(GLConstants.PixelFormatType pixelFormatType) {
        return pixelFormatType == GLConstants.PixelFormatType.I420 || pixelFormatType == GLConstants.PixelFormatType.NV21 || pixelFormatType == GLConstants.PixelFormatType.RGBA;
    }

    private static boolean isCustomRenderSupportedBufferType(GLConstants.a aVar) {
        return aVar == GLConstants.a.BYTE_BUFFER || aVar == GLConstants.a.BYTE_ARRAY || aVar == GLConstants.a.TEXTURE_2D;
    }

    private static boolean isCustomRenderSupportedFormatType(GLConstants.PixelFormatType pixelFormatType) {
        return pixelFormatType == GLConstants.PixelFormatType.I420 || pixelFormatType == GLConstants.PixelFormatType.NV21 || pixelFormatType == GLConstants.PixelFormatType.RGBA;
    }

    public static boolean isInUIThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static /* synthetic */ void lambda$enterRoom$0(TrtcCloudJni trtcCloudJni) {
        trtcCloudJni.onEnterRoom(-3316);
        trtcCloudJni.onError(-3316, "enter room param null");
    }

    public static /* synthetic */ void lambda$onSnapshotComplete$1(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        if (tRTCSnapshotListener != null) {
            tRTCSnapshotListener.onSnapshotComplete(bitmap);
        }
    }

    private static native String nativeCallExperimentalAPI(long j11, String str);

    private static native void nativeConnectOtherRoom(long j11, String str);

    private static native long nativeCreateAudioEffectManager(long j11);

    private static native long nativeCreateBeautyManager(long j11);

    private static native long nativeCreateDeviceManager(long j11);

    private static native long nativeCreatePipeline(TrtcCloudJni trtcCloudJni, boolean z11);

    private static native long nativeCreateSubCloud(TrtcCloudJni trtcCloudJni, long j11);

    private static native void nativeDestroyPipeline(long j11);

    private static native void nativeDisconnectOtherRoom(long j11);

    private static native void nativeEnable3DSpatialAudioEffect(long j11, boolean z11);

    private static native void nativeEnableAudioFrameNotification(long j11, boolean z11);

    private static native void nativeEnableAudioVolumeEvaluation(long j11, boolean z11, int i11, boolean z12, boolean z13, boolean z14);

    private static native void nativeEnableCustomAudioCapture(long j11, boolean z11);

    private static native void nativeEnableCustomAudioRendering(long j11, boolean z11);

    private static native void nativeEnableCustomVideoCapture(long j11, int i11, boolean z11);

    private static native void nativeEnableEncSmallVideoStream(long j11, boolean z11, VideoEncParams videoEncParams);

    private static native void nativeEnableMixExternalAudioFrame(long j11, boolean z11, boolean z12);

    private static native int nativeEnablePayloadPrivateEncryption(long j11, boolean z11, PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig);

    private static native void nativeEnableVideoCustomPreprocess(long j11, boolean z11, int i11, int i12, int i13);

    private static native void nativeEnableVideoCustomRender(long j11, boolean z11, String str, int i11, int i12, int i13);

    private static native void nativeEnterRoom(long j11, EnterRoomParams enterRoomParams, int i11);

    private static native void nativeExitRoom(long j11);

    private static native int nativeGetAudioCaptureVolume(long j11);

    private static native int nativeGetAudioPlayoutVolume(long j11);

    private static native void nativeGetCustomAudioRenderingFrame(long j11, byte[] bArr, int i11, int i12);

    private static native void nativeGlobalInit(int i11);

    private static native void nativeGlobalUninit();

    private static native int nativeMixExternalAudioFrame(long j11, AudioFrame audioFrame);

    private static native void nativeMuteAllRemoteAudio(long j11, boolean z11);

    private static native void nativeMuteAllRemoteVideoStreams(long j11, boolean z11);

    private static native void nativeMuteLocalAudio(long j11, boolean z11);

    private static native void nativeMuteLocalVideo(long j11, int i11, boolean z11);

    private static native void nativeMuteRemoteAudio(long j11, String str, boolean z11);

    private static native void nativeMuteRemoteVideoStream(long j11, String str, int i11, boolean z11);

    private static native void nativePauseScreenCapture(long j11, int i11);

    private static native void nativeResumeScreenCapture(long j11, int i11);

    private static native void nativeSendCustomAudioData(long j11, AudioFrame audioFrame);

    private static native boolean nativeSendCustomCmdMsg(long j11, int i11, byte[] bArr, boolean z11, boolean z12);

    private static native void nativeSendCustomVideoData(long j11, int i11, int i12, int i13, Object obj, int i14, int i15, int i16, int i17, long j12, byte[] bArr, ByteBuffer byteBuffer);

    private static native boolean nativeSendSEIMsg(long j11, byte[] bArr, int i11);

    private static native void nativeSet3DSpatialReceivingRange(long j11, String str, int i11);

    private static native void nativeSetAudioCaptureVolume(long j11, int i11);

    private static native void nativeSetAudioPlayoutVolume(long j11, int i11);

    private static native void nativeSetAudioQuality(long j11, int i11);

    private static native int nativeSetCapturedAudioFrameCallbackFormat(long j11, int i11, int i12, int i13, int i14);

    private static native void nativeSetConsoleEnabled(boolean z11);

    private static native void nativeSetDefaultStreamRecvMode(long j11, boolean z11, boolean z12);

    private static native void nativeSetGSensorMode(long j11, int i11, int i12);

    private static native void nativeSetGravitySensorAdaptiveMode(long j11, int i11);

    private static native void nativeSetListenerHandler(long j11, Handler handler);

    private static native int nativeSetLocalProcessedAudioFrameCallbackFormat(long j11, int i11, int i12, int i13, int i14);

    private static native void nativeSetLocalViewFillMode(long j11, int i11);

    private static native void nativeSetLocalViewMirror(long j11, int i11);

    private static native void nativeSetLocalViewRotation(long j11, int i11);

    private static native void nativeSetLogCompressEnabled(boolean z11);

    private static native void nativeSetLogLevel(int i11);

    private static native void nativeSetLogPath(String str);

    private static native void nativeSetMixExternalAudioVolume(long j11, int i11, int i12);

    private static native void nativeSetMixTranscodingConfig(long j11, TranscodingConfig transcodingConfig);

    private static native int nativeSetMixedPlayAudioFrameCallbackFormat(long j11, int i11, int i12, int i13, int i14);

    private static native void nativeSetNetworkQosParam(long j11, int i11, int i12);

    private static native void nativeSetPerspectiveCorrectionPoints(long j11, String str, float[] fArr, float[] fArr2);

    private static native void nativeSetPriorRemoteVideoStreamType(long j11, int i11);

    private static native void nativeSetRemoteAudioParallelParams(long j11, AudioParallelParams audioParallelParams);

    private static native void nativeSetRemoteAudioVolume(long j11, String str, int i11);

    private static native void nativeSetRemoteVideoStreamType(long j11, String str, int i11);

    private static native void nativeSetRemoteViewFillMode(long j11, String str, int i11, int i12);

    private static native void nativeSetRemoteViewMirror(long j11, String str, int i11, int i12);

    private static native void nativeSetRemoteViewRotation(long j11, String str, int i11, int i12);

    private static native void nativeSetVideoEncoderMirror(long j11, boolean z11);

    private static native void nativeSetVideoEncoderParams(long j11, int i11, VideoEncParams videoEncParams);

    private static native void nativeSetVideoEncoderRotation(long j11, int i11);

    private static native void nativeSetVideoMuteImage(long j11, Bitmap bitmap, int i11);

    private static native void nativeSetWatermark(long j11, Bitmap bitmap, int i11, float f11, float f12, float f13);

    private static native void nativeShowDashboardManager(long j11, int i11);

    private static native void nativeSnapshotVideo(long j11, String str, int i11, int i12, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener);

    private static native int nativeStartAudioRecording(long j11, AudioRecordingParams audioRecordingParams);

    private static native void nativeStartLocalAudio(long j11);

    private static native void nativeStartLocalAudioWithQuality(long j11, int i11);

    private static native void nativeStartLocalPreview(long j11, boolean z11, DisplayTarget displayTarget);

    private static native void nativeStartLocalRecording(long j11, LocalRecordingParams localRecordingParams);

    private static native void nativeStartPublishCDNStream(long j11, PublishCDNParams publishCDNParams);

    private static native void nativeStartPublishMediaStream(long j11, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeStartPublishing(long j11, String str, int i11);

    private static native void nativeStartRemoteView(long j11, String str, int i11, DisplayTarget displayTarget);

    private static native void nativeStartRemoteViewWithoutStreamType(long j11, String str, DisplayTarget displayTarget);

    private static native void nativeStartScreenCapture(long j11, int i11, VideoEncParams videoEncParams, ScreenShareParams screenShareParams);

    private static native void nativeStartSpeedTest(long j11, SpeedTestParams speedTestParams);

    private static native void nativeStartSystemAudioLoopback(long j11);

    private static native void nativeStopAllRemoteView(long j11);

    private static native void nativeStopAudioRecording(long j11);

    private static native void nativeStopLocalAudio(long j11);

    private static native void nativeStopLocalPreview(long j11);

    private static native void nativeStopLocalRecording(long j11);

    private static native void nativeStopPublishCDNStream(long j11);

    private static native void nativeStopPublishMediaStream(long j11, String str);

    private static native void nativeStopPublishing(long j11);

    private static native void nativeStopRemoteView(long j11, String str, int i11);

    private static native void nativeStopRemoteViewWithoutStreamType(long j11, String str);

    private static native void nativeStopScreenCapture(long j11, int i11);

    private static native void nativeStopSpeedTest(long j11);

    private static native void nativeStopSystemAudioLoopback(long j11);

    private static native void nativeSwitchRole(long j11, int i11);

    private static native void nativeSwitchRoleWithPrivateMapKey(long j11, int i11, String str);

    private static native void nativeSwitchRoom(long j11, SwitchRoomConfig switchRoomConfig);

    private static native void nativeUpdateLocalView(long j11, DisplayTarget displayTarget);

    private static native void nativeUpdateOtherRoomForwardMode(long j11, String str);

    private static native void nativeUpdatePublishMediaStream(long j11, String str, PublishTarget publishTarget, StreamEncoderParam streamEncoderParam, StreamMixingConfig streamMixingConfig);

    private static native void nativeUpdateRemote3DSpatialPosition(long j11, String str, int[] iArr);

    private static native void nativeUpdateRemoteView(long j11, String str, int i11, DisplayTarget displayTarget);

    private static native void nativeUpdateSelf3DSpatialPosition(long j11, int[] iArr, float[] fArr, float[] fArr2, float[] fArr3);

    private void runOnListenerThread(Runnable runnable) {
        Handler handler = this.mListenerHandler;
        if (Looper.myLooper() != handler.getLooper()) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void setConsoleEnabled(boolean z11) {
        nativeSetConsoleEnabled(z11);
    }

    public static void setLogCompressEnabled(boolean z11) {
        nativeSetLogCompressEnabled(z11);
    }

    public static void setLogDirPath(String str) {
        nativeSetLogPath(str);
    }

    public static void setLogLevel(int i11) {
        nativeSetLogLevel(i11);
    }

    private static void shadowCopy(PixelFrame pixelFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        tRTCVideoFrame.pixelFormat = convertPixelFormatTypeToTRTCFormatType(pixelFrame.getPixelFormatType());
        tRTCVideoFrame.bufferType = convertPixelBufferTypeToTRTCBufferType(pixelFrame.getPixelBufferType());
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = pixelFrame.getTextureId();
        if (pixelFrame.getGLContext() instanceof EGLContext) {
            tRTCVideoFrame.texture.eglContext10 = (EGLContext) pixelFrame.getGLContext();
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (pixelFrame.getGLContext() instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) pixelFrame.getGLContext();
        }
        tRTCVideoFrame.data = pixelFrame.getData();
        tRTCVideoFrame.buffer = pixelFrame.getBuffer();
        tRTCVideoFrame.width = pixelFrame.getWidth();
        tRTCVideoFrame.height = pixelFrame.getHeight();
        tRTCVideoFrame.timestamp = pixelFrame.getTimestamp();
        tRTCVideoFrame.rotation = convertPixelFrameRotationToTRTCVideoRotation(pixelFrame.getRotation());
    }

    /* access modifiers changed from: private */
    public void showFloatingWindow(View view) {
        if (view != null) {
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 23 && !Settings.canDrawOverlays(view.getContext())) {
                LiteavLog.e(TAG, "can't show floating window for no drawing overlay permission");
            } else if (this.mFloatingWindowSet.contains(view)) {
                LiteavLog.i(TAG, "the window has been added");
            } else {
                WindowManager windowManager = (WindowManager) view.getContext().getSystemService("window");
                if (windowManager == null) {
                    LiteavLog.e(TAG, "get windowManager error");
                    return;
                }
                this.mFloatingWindowSet.add(view);
                int i11 = 2005;
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
                    i11 = 2038;
                } else if (LiteavSystemInfo.getSystemOSVersionInt() > 24) {
                    i11 = 2002;
                }
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(i11);
                layoutParams.flags = 8;
                layoutParams.flags = 8 | 262144;
                layoutParams.width = -2;
                layoutParams.height = -2;
                layoutParams.format = -3;
                windowManager.addView(view, layoutParams);
            }
        }
    }

    public static void uninit() {
        synchronized (INIT_LOCK) {
            if (mHasInited) {
                mHasInited = false;
                nativeGlobalUninit();
            }
        }
    }

    public void addListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null && !this.mListenerList.contains(tRTCCloudListener)) {
            this.mListenerList.add(tRTCCloudListener);
        }
    }

    public String callExperimentalAPI(String str) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                return nativeCallExperimentalAPI(j11, str);
            }
            this.mJniReadLock.unlock();
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void connectOtherRoom(String str) {
        long j11 = this.mNativeTrtcCloudJni;
        if (j11 != 0) {
            nativeConnectOtherRoom(j11, str);
        }
    }

    public long createAudioEffectManager() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            long j12 = 0;
            if (j11 != 0) {
                j12 = nativeCreateAudioEffectManager(j11);
            }
            return j12;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public long createBeautyManager() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            long j12 = 0;
            if (j11 != 0) {
                j12 = nativeCreateBeautyManager(j11);
            }
            return j12;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public ByteBuffer createByteBuffer(int i11) {
        return ByteBuffer.allocateDirect(i11);
    }

    public long createDeviceManager() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            long j12 = 0;
            if (j11 != 0) {
                j12 = nativeCreateDeviceManager(j11);
            }
            return j12;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TRTCCloudDef.TRTCVideoFrame createTRTCVideoFrame(int i11, int i12, Object obj, int i13, int i14, int i15, int i16, long j11, byte[] bArr, ByteBuffer byteBuffer) {
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame = new TRTCCloudDef.TRTCVideoFrame();
        GLConstants.a a11 = GLConstants.a.a(i12);
        tRTCVideoFrame.pixelFormat = convertPixelFormatTypeToTRTCFormatType(GLConstants.PixelFormatType.a(i11));
        tRTCVideoFrame.bufferType = convertPixelBufferTypeToTRTCBufferType(a11);
        TRTCCloudDef.TRTCTexture tRTCTexture = new TRTCCloudDef.TRTCTexture();
        tRTCVideoFrame.texture = tRTCTexture;
        tRTCTexture.textureId = i13;
        if (obj instanceof EGLContext) {
            tRTCTexture.eglContext10 = (EGLContext) obj;
        } else if (LiteavSystemInfo.getSystemOSVersionInt() >= 17 && (obj instanceof android.opengl.EGLContext)) {
            tRTCVideoFrame.texture.eglContext14 = (android.opengl.EGLContext) obj;
        }
        tRTCVideoFrame.data = bArr;
        tRTCVideoFrame.buffer = byteBuffer;
        tRTCVideoFrame.width = i14;
        tRTCVideoFrame.height = i15;
        tRTCVideoFrame.timestamp = j11;
        tRTCVideoFrame.rotation = convertPixelFrameRotationToTRTCVideoRotation(k.a(i16));
        return tRTCVideoFrame;
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeDestroyPipeline(j11);
                this.mNativeTrtcCloudJni = 0;
            }
            this.mListenerList.clear();
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    public void disconnectOtherRoom() {
        long j11 = this.mNativeTrtcCloudJni;
        if (j11 != 0) {
            nativeDisconnectOtherRoom(j11);
        }
    }

    public void enable3DSpatialAudioEffect(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnable3DSpatialAudioEffect(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableAudioVolumeEvaluation(boolean z11, TRTCCloudDef.TRTCAudioVolumeEvaluateParams tRTCAudioVolumeEvaluateParams) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnableAudioVolumeEvaluation(j11, z11, tRTCAudioVolumeEvaluateParams.interval, tRTCAudioVolumeEvaluateParams.enableVadDetection, tRTCAudioVolumeEvaluateParams.enablePitchCalculation, tRTCAudioVolumeEvaluateParams.enableSpectrumCalculation);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioCapture(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnableCustomAudioCapture(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomAudioRendering(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnableCustomAudioRendering(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enableCustomVideoCapture(int i11, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnableCustomVideoCapture(j11, i11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public int enableEncSmallVideoStream(boolean z11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        VideoEncParams videoEncParams;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                if (tRTCVideoEncParam == null) {
                    videoEncParams = null;
                } else {
                    videoEncParams = new VideoEncParams(tRTCVideoEncParam);
                }
                nativeEnableEncSmallVideoStream(j11, z11, videoEncParams);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th2) {
            this.mJniReadLock.unlock();
            throw th2;
        }
    }

    public void enableMixExternalAudioFrame(boolean z11, boolean z12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnableMixExternalAudioFrame(j11, z11, z12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int enablePayloadPrivateEncryption(boolean z11, TRTCCloudDef.TRTCPayloadPrivateEncryptionConfig tRTCPayloadPrivateEncryptionConfig) {
        int i11;
        PayloadPrivateEncryptionConfig payloadPrivateEncryptionConfig;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                if (tRTCPayloadPrivateEncryptionConfig == null) {
                    payloadPrivateEncryptionConfig = null;
                } else {
                    payloadPrivateEncryptionConfig = new PayloadPrivateEncryptionConfig(tRTCPayloadPrivateEncryptionConfig);
                }
                i11 = nativeEnablePayloadPrivateEncryption(j11, z11, payloadPrivateEncryptionConfig);
            } else {
                i11 = -1;
            }
            return i11;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i11) {
        if (tRTCParams == null) {
            LiteavLog.e(TAG, "enterRoom param is null");
            runOnListenerThread(a.a(this));
            return;
        }
        this.mJniReadLock.lock();
        try {
            this.mLocalUserId = tRTCParams.userId;
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeEnterRoom(j11, new EnterRoomParams(tRTCParams), i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void exitRoom() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeExitRoom(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioCaptureVolume() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            return j11 != 0 ? nativeGetAudioCaptureVolume(j11) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getAudioPlayoutVolume() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            return j11 != 0 ? nativeGetAudioPlayoutVolume(j11) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void getCustomAudioRenderingFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeGetCustomAudioRenderingFrame(j11, tRTCAudioFrame.data, tRTCAudioFrame.sampleRate, tRTCAudioFrame.channel);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int getFrameBufferType(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame.bufferType, tRTCVideoFrame.pixelFormat).mValue;
    }

    public byte[] getFrameByteArray(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.data;
    }

    public ByteBuffer getFrameByteBuffer(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.buffer;
    }

    public Object getFrameEglContext(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
            return tRTCVideoFrame.texture.eglContext14;
        }
        return tRTCVideoFrame.texture.eglContext10;
    }

    public int getFrameHeight(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.height;
    }

    public int getFramePixelFormat(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame.pixelFormat).getValue();
    }

    public long getFramePts(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.timestamp;
    }

    public int getFrameRotation(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation).mValue;
    }

    public int getFrameTextureId(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.texture.textureId;
    }

    public int getFrameWidth(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        return tRTCVideoFrame.width;
    }

    public long getTrtcCloudJni() {
        this.mJniReadLock.lock();
        try {
            return this.mNativeTrtcCloudJni;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int mixExternalAudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                return nativeMixExternalAudioFrame(j11, new AudioFrame(tRTCAudioFrame));
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteAudio(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeMuteAllRemoteAudio(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteAllRemoteVideoStreams(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeMuteAllRemoteVideoStreams(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalAudio(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeMuteLocalAudio(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteLocalVideo(int i11, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeMuteLocalVideo(j11, i11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteAudio(String str, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeMuteRemoteAudio(j11, str, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void muteRemoteVideoStream(String str, int i11, boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeMuteRemoteVideoStream(j11, str, i11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void onAudioCaptureProcessedData(byte[] bArr, long j11, int i11, int i12) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = j11;
            tRTCAudioFrame.sampleRate = i11;
            tRTCAudioFrame.channel = i12;
            tRTCAudioFrameListener.onCapturedAudioFrame(tRTCAudioFrame);
        }
    }

    public void onAudioMixedAllData(byte[] bArr, int i11, int i12) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = 0;
            tRTCAudioFrame.sampleRate = i11;
            tRTCAudioFrame.channel = i12;
            tRTCAudioFrameListener.onMixedAllAudioFrame(tRTCAudioFrame);
        }
    }

    public void onAudioPlayoutData(byte[] bArr, long j11, int i11, int i12) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = j11;
            tRTCAudioFrame.sampleRate = i11;
            tRTCAudioFrame.channel = i12;
            tRTCAudioFrameListener.onMixedPlayAudioFrame(tRTCAudioFrame);
        }
    }

    public void onAudioRemoteStreamData(String str, byte[] bArr, long j11, int i11, int i12, byte[] bArr2) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = j11;
            tRTCAudioFrame.sampleRate = i11;
            tRTCAudioFrame.channel = i12;
            tRTCAudioFrame.extraData = bArr2;
            tRTCAudioFrameListener.onRemoteUserAudioFrame(tRTCAudioFrame, str);
        }
    }

    public void onAudioRouteChanged(int i11, int i12) {
        for (TRTCCloudListener onAudioRouteChanged : CopyOnReadListeners()) {
            onAudioRouteChanged.onAudioRouteChanged(i11, i12);
        }
    }

    public void onCameraDidReady() {
        for (TRTCCloudListener onCameraDidReady : CopyOnReadListeners()) {
            onCameraDidReady.onCameraDidReady();
        }
    }

    public void onCdnStreamStateChanged(String str, int i11, int i12, String str2, String str3) {
        for (TRTCCloudListener onCdnStreamStateChanged : CopyOnReadListeners()) {
            onCdnStreamStateChanged.onCdnStreamStateChanged(str, i11, i12, str2, (Bundle) null);
        }
    }

    public void onConnectOtherRoom(String str, int i11, String str2) {
        for (TRTCCloudListener onConnectOtherRoom : CopyOnReadListeners()) {
            onConnectOtherRoom.onConnectOtherRoom(str, i11, str2);
        }
    }

    public void onConnectionLost() {
        for (TRTCCloudListener onConnectionLost : CopyOnReadListeners()) {
            onConnectionLost.onConnectionLost();
        }
    }

    public void onConnectionRecovery() {
        for (TRTCCloudListener onConnectionRecovery : CopyOnReadListeners()) {
            onConnectionRecovery.onConnectionRecovery();
        }
    }

    public void onDisConnectOtherRoom(int i11, String str) {
        for (TRTCCloudListener onDisConnectOtherRoom : CopyOnReadListeners()) {
            onDisConnectOtherRoom.onDisConnectOtherRoom(i11, str);
        }
    }

    public void onEarMonitoringData(byte[] bArr, int i11, int i12) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener != null) {
            TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
            tRTCAudioFrame.data = bArr;
            tRTCAudioFrame.timestamp = 0;
            tRTCAudioFrame.sampleRate = i11;
            tRTCAudioFrame.channel = i12;
            tRTCAudioFrameListener.onVoiceEarMonitorAudioFrame(tRTCAudioFrame);
        }
    }

    public void onEnterRoom(int i11) {
        for (TRTCCloudListener onEnterRoom : CopyOnReadListeners()) {
            onEnterRoom.onEnterRoom((long) i11);
        }
    }

    public void onError(int i11, String str) {
        for (TRTCCloudListener onError : CopyOnReadListeners()) {
            onError.onError(i11, str, (Bundle) null);
        }
    }

    public void onExitRoom(int i11) {
        for (TRTCCloudListener onExitRoom : CopyOnReadListeners()) {
            onExitRoom.onExitRoom(i11);
        }
        synchronized (this.mLocalVideoRenderListenerWrapper) {
            this.mLocalVideoRenderListenerWrapper.f21720d = null;
        }
        synchronized (this.mRemoteVideoRenderListenerMap) {
            this.mRemoteVideoRenderListenerMap.clear();
        }
    }

    public void onFirstAudioFrame(String str) {
        for (TRTCCloudListener onFirstAudioFrame : CopyOnReadListeners()) {
            onFirstAudioFrame.onFirstAudioFrame(str);
        }
    }

    public void onFirstVideoFrame(String str, int i11, int i12, int i13) {
        for (TRTCCloudListener onFirstVideoFrame : CopyOnReadListeners()) {
            onFirstVideoFrame.onFirstVideoFrame(str, i11, i12, i13);
        }
    }

    public void onGLContextCreated() {
        synchronized (this.mVideoFrameListenerWrapper) {
            this.mCalledGLCreatedFrameListener = (TRTCCloudListener.TRTCVideoFrameListener) this.mVideoFrameListenerWrapper.f21720d;
        }
        LiteavLog.i(TAG, "onGLContextCreated " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextCreated();
        }
    }

    public void onGLContextDestroy() {
        LiteavLog.i(TAG, "onGLContextDestroy " + this.mCalledGLCreatedFrameListener);
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onGLContextDestory();
            this.mCalledGLCreatedFrameListener = null;
        }
    }

    public byte[] onLocalAudioStreamData(byte[] bArr, long j11, int i11, int i12) {
        TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener = this.mAudioFrameListener;
        if (tRTCAudioFrameListener == null) {
            return null;
        }
        TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame = new TRTCCloudDef.TRTCAudioFrame();
        tRTCAudioFrame.data = bArr;
        tRTCAudioFrame.timestamp = j11;
        tRTCAudioFrame.sampleRate = i11;
        tRTCAudioFrame.channel = i12;
        tRTCAudioFrameListener.onLocalProcessedAudioFrame(tRTCAudioFrame);
        byte[] bArr2 = tRTCAudioFrame.extraData;
        if (bArr2 == null) {
            return null;
        }
        if (bArr2.length <= 100) {
            return bArr2;
        }
        LiteavLog.w(TAG, "Audioframe.extraData length need to be under 100!");
        return null;
    }

    public void onLocalRecordBegin(int i11, String str) {
        for (TRTCCloudListener onLocalRecordBegin : CopyOnReadListeners()) {
            onLocalRecordBegin.onLocalRecordBegin(i11, str);
        }
    }

    public void onLocalRecordComplete(int i11, String str) {
        for (TRTCCloudListener onLocalRecordComplete : CopyOnReadListeners()) {
            onLocalRecordComplete.onLocalRecordComplete(i11, str);
        }
    }

    public void onLocalRecordFragment(String str) {
        for (TRTCCloudListener onLocalRecordFragment : CopyOnReadListeners()) {
            onLocalRecordFragment.onLocalRecordFragment(str);
        }
    }

    public void onLocalRecording(long j11, String str) {
        for (TRTCCloudListener onLocalRecording : CopyOnReadListeners()) {
            onLocalRecording.onLocalRecording(j11, str);
        }
    }

    public void onMicDidReady() {
        for (TRTCCloudListener onMicDidReady : CopyOnReadListeners()) {
            onMicDidReady.onMicDidReady();
        }
    }

    public void onMissCustomCmdMsg(String str, int i11, int i12, int i13) {
        for (TRTCCloudListener onMissCustomCmdMsg : CopyOnReadListeners()) {
            onMissCustomCmdMsg.onMissCustomCmdMsg(str, i11, i12, i13);
        }
    }

    public void onNetworkQuality(int i11, String[] strArr, int[] iArr) {
        if (CopyOnReadListeners().size() != 0) {
            TRTCCloudDef.TRTCQuality tRTCQuality = new TRTCCloudDef.TRTCQuality();
            tRTCQuality.userId = "";
            tRTCQuality.quality = i11;
            ArrayList arrayList = new ArrayList();
            if (!(strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0 || iArr.length != strArr.length)) {
                for (int i12 = 0; i12 < strArr.length; i12++) {
                    TRTCCloudDef.TRTCQuality tRTCQuality2 = new TRTCCloudDef.TRTCQuality();
                    tRTCQuality2.userId = strArr[i12];
                    tRTCQuality2.quality = iArr[i12];
                    arrayList.add(tRTCQuality2);
                }
            }
            for (TRTCCloudListener onNetworkQuality : CopyOnReadListeners()) {
                onNetworkQuality.onNetworkQuality(tRTCQuality, arrayList);
            }
        }
    }

    public void onPreprocessVideoFrame(int i11, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2) {
        TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener = this.mCalledGLCreatedFrameListener;
        if (tRTCVideoFrameListener != null && tRTCVideoFrameListener != null) {
            tRTCVideoFrameListener.onProcessVideoFrame(tRTCVideoFrame, tRTCVideoFrame2);
        }
    }

    public void onRecvCustomCmdMsg(String str, int i11, int i12, byte[] bArr) {
        for (TRTCCloudListener onRecvCustomCmdMsg : CopyOnReadListeners()) {
            onRecvCustomCmdMsg.onRecvCustomCmdMsg(str, i11, i12, bArr);
        }
    }

    public void onRemoteAudioStatusUpdated(String str, int i11, int i12) {
        for (TRTCCloudListener onRemoteAudioStatusUpdated : CopyOnReadListeners()) {
            onRemoteAudioStatusUpdated.onRemoteAudioStatusUpdated(str, i11, i12, (Bundle) null);
        }
    }

    public void onRemoteVideoStatusUpdated(String str, int i11, int i12, int i13) {
        for (TRTCCloudListener onRemoteVideoStatusUpdated : CopyOnReadListeners()) {
            onRemoteVideoStatusUpdated.onRemoteVideoStatusUpdated(str, i11, i12, i13, (Bundle) null);
        }
    }

    public void onRenderVideoFrame(String str, int i11, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        TRTCCloudListener.TRTCVideoRenderListener tRTCVideoRenderListener;
        if (TextUtils.isEmpty(str)) {
            str = this.mLocalUserId;
            tRTCVideoRenderListener = (TRTCCloudListener.TRTCVideoRenderListener) this.mLocalVideoRenderListenerWrapper.f21720d;
        } else {
            a aVar = this.mRemoteVideoRenderListenerMap.get(str);
            if (aVar == null) {
                tRTCVideoRenderListener = null;
            } else {
                tRTCVideoRenderListener = (TRTCCloudListener.TRTCVideoRenderListener) aVar.f21720d;
            }
        }
        if (tRTCVideoRenderListener != null) {
            tRTCVideoRenderListener.onRenderVideoFrame(str, i11, tRTCVideoFrame);
        }
    }

    public void onSEIMessageReceived(byte[] bArr, String str) {
        for (TRTCCloudListener onRecvSEIMsg : CopyOnReadListeners()) {
            onRecvSEIMsg.onRecvSEIMsg(str, bArr);
        }
    }

    public void onScreenCapturePaused() {
        for (TRTCCloudListener onScreenCapturePaused : CopyOnReadListeners()) {
            onScreenCapturePaused.onScreenCapturePaused();
        }
    }

    public void onScreenCaptureResumed() {
        for (TRTCCloudListener onScreenCaptureResumed : CopyOnReadListeners()) {
            onScreenCaptureResumed.onScreenCaptureResumed();
        }
    }

    public void onScreenCaptureStarted() {
        for (TRTCCloudListener onScreenCaptureStarted : CopyOnReadListeners()) {
            onScreenCaptureStarted.onScreenCaptureStarted();
        }
    }

    public void onScreenCaptureStopped(int i11) {
        for (TRTCCloudListener onScreenCaptureStopped : CopyOnReadListeners()) {
            onScreenCaptureStopped.onScreenCaptureStopped(i11);
        }
    }

    public void onSendFirstLocalAudioFrame() {
        for (TRTCCloudListener onSendFirstLocalAudioFrame : CopyOnReadListeners()) {
            onSendFirstLocalAudioFrame.onSendFirstLocalAudioFrame();
        }
    }

    public void onSendFirstLocalVideoFrame(int i11) {
        for (TRTCCloudListener onSendFirstLocalVideoFrame : CopyOnReadListeners()) {
            onSendFirstLocalVideoFrame.onSendFirstLocalVideoFrame(i11);
        }
    }

    public void onSetMixTranscodingConfig(int i11, String str) {
        for (TRTCCloudListener onSetMixTranscodingConfig : CopyOnReadListeners()) {
            onSetMixTranscodingConfig.onSetMixTranscodingConfig(i11, str);
        }
    }

    public void onSnapshotComplete(TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener, Bitmap bitmap) {
        runOnListenerThread(b.a(tRTCSnapshotListener, bitmap));
    }

    public void onSpeedTest(SpeedTestResult speedTestResult, int i11, int i12) {
        for (TRTCCloudListener onSpeedTest : CopyOnReadListeners()) {
            onSpeedTest.onSpeedTest(speedTestResult.f21707a, i11, i12);
        }
    }

    public void onSpeedTestResult(SpeedTestResult speedTestResult) {
        for (TRTCCloudListener onSpeedTestResult : CopyOnReadListeners()) {
            onSpeedTestResult.onSpeedTestResult(speedTestResult.f21707a);
        }
    }

    public void onStartPublishCDNStream(int i11, String str) {
        for (TRTCCloudListener onStartPublishCDNStream : CopyOnReadListeners()) {
            onStartPublishCDNStream.onStartPublishCDNStream(i11, str);
        }
    }

    public void onStartPublishMediaStream(String str, int i11, String str2, String str3) {
        for (TRTCCloudListener onStartPublishMediaStream : CopyOnReadListeners()) {
            onStartPublishMediaStream.onStartPublishMediaStream(str, i11, str2, extraToBundle(str3));
        }
    }

    public void onStartPublishing(int i11, String str) {
        for (TRTCCloudListener onStartPublishing : CopyOnReadListeners()) {
            onStartPublishing.onStartPublishing(i11, str);
        }
    }

    public void onStatistics(Statistics statistics) {
        for (TRTCCloudListener onStatistics : CopyOnReadListeners()) {
            onStatistics.onStatistics(statistics.f21708a);
        }
    }

    public void onStopPublishCDNStream(int i11, String str) {
        for (TRTCCloudListener onStopPublishCDNStream : CopyOnReadListeners()) {
            onStopPublishCDNStream.onStopPublishCDNStream(i11, str);
        }
    }

    public void onStopPublishMediaStream(String str, int i11, String str2, String str3) {
        for (TRTCCloudListener onStopPublishMediaStream : CopyOnReadListeners()) {
            onStopPublishMediaStream.onStopPublishMediaStream(str, i11, str2, extraToBundle(str3));
        }
    }

    public void onStopPublishing(int i11, String str) {
        for (TRTCCloudListener onStopPublishing : CopyOnReadListeners()) {
            onStopPublishing.onStopPublishing(i11, str);
        }
    }

    public void onSwitchRole(int i11, String str) {
        for (TRTCCloudListener onSwitchRole : CopyOnReadListeners()) {
            onSwitchRole.onSwitchRole(i11, str);
        }
    }

    public void onSwitchRoom(int i11, String str) {
        for (TRTCCloudListener onSwitchRoom : CopyOnReadListeners()) {
            onSwitchRoom.onSwitchRoom(i11, str);
        }
    }

    public void onTryToReconnect() {
        for (TRTCCloudListener onTryToReconnect : CopyOnReadListeners()) {
            onTryToReconnect.onTryToReconnect();
        }
    }

    public void onUpdateOtherRoomForwardMode(int i11, String str) {
        for (TRTCCloudListener onUpdateOtherRoomForwardMode : CopyOnReadListeners()) {
            onUpdateOtherRoomForwardMode.onUpdateOtherRoomForwardMode(i11, str);
        }
    }

    public void onUpdatePublishMediaStream(String str, int i11, String str2, String str3) {
        for (TRTCCloudListener onUpdatePublishMediaStream : CopyOnReadListeners()) {
            onUpdatePublishMediaStream.onUpdatePublishMediaStream(str, i11, str2, extraToBundle(str3));
        }
    }

    public void onUserAudioAvailable(String str, boolean z11) {
        for (TRTCCloudListener onUserAudioAvailable : CopyOnReadListeners()) {
            onUserAudioAvailable.onUserAudioAvailable(str, z11);
        }
    }

    public void onUserEnter(String str) {
        for (TRTCCloudListener onUserEnter : CopyOnReadListeners()) {
            onUserEnter.onUserEnter(str);
        }
    }

    public void onUserExit(String str) {
        for (TRTCCloudListener onUserExit : CopyOnReadListeners()) {
            onUserExit.onUserExit(str, 0);
        }
    }

    public void onUserOffline(String str, int i11) {
        for (TRTCCloudListener onRemoteUserLeaveRoom : CopyOnReadListeners()) {
            onRemoteUserLeaveRoom.onRemoteUserLeaveRoom(str, i11);
        }
    }

    public void onUserOnline(String str) {
        for (TRTCCloudListener onRemoteUserEnterRoom : CopyOnReadListeners()) {
            onRemoteUserEnterRoom.onRemoteUserEnterRoom(str);
        }
    }

    public void onUserSubStreamAvailable(String str, boolean z11) {
        for (TRTCCloudListener onUserSubStreamAvailable : CopyOnReadListeners()) {
            onUserSubStreamAvailable.onUserSubStreamAvailable(str, z11);
        }
    }

    public void onUserVideoAvailable(String str, boolean z11) {
        for (TRTCCloudListener onUserVideoAvailable : CopyOnReadListeners()) {
            onUserVideoAvailable.onUserVideoAvailable(str, z11);
        }
    }

    public void onUserVideoSizeChanged(String str, int i11, int i12, int i13) {
        for (TRTCCloudListener onUserVideoSizeChanged : CopyOnReadListeners()) {
            onUserVideoSizeChanged.onUserVideoSizeChanged(str, i11, i12, i13);
        }
    }

    public void onUserVoiceVolume(String[] strArr, int[] iArr, int[] iArr2, float[] fArr, float[][] fArr2, int i11) {
        String str;
        if (strArr != null && iArr != null) {
            if (strArr.length == iArr.length) {
                ArrayList arrayList = new ArrayList();
                for (int i12 = 0; i12 < strArr.length; i12++) {
                    TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = new TRTCCloudDef.TRTCVolumeInfo();
                    if (!strArr[i12].isEmpty() || (str = this.mLocalUserId) == null || str.isEmpty()) {
                        tRTCVolumeInfo.userId = strArr[i12];
                    } else {
                        tRTCVolumeInfo.userId = this.mLocalUserId;
                    }
                    tRTCVolumeInfo.volume = iArr[i12];
                    tRTCVolumeInfo.vad = iArr2[i12];
                    tRTCVolumeInfo.pitch = fArr[i12];
                    tRTCVolumeInfo.spectrumData = fArr2[i12];
                    arrayList.add(tRTCVolumeInfo);
                }
                for (TRTCCloudListener onUserVoiceVolume : CopyOnReadListeners()) {
                    onUserVoiceVolume.onUserVoiceVolume(arrayList, i11);
                }
                return;
            }
            throw new IllegalArgumentException("Invalid parameter, userIds and volumes do not match.");
        }
    }

    public void onWarning(int i11, String str, Bundle bundle) {
        for (TRTCCloudListener onWarning : CopyOnReadListeners()) {
            onWarning.onWarning(i11, str, bundle);
        }
    }

    public void pauseScreenCapture(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativePauseScreenCapture(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void removeListener(TRTCCloudListener tRTCCloudListener) {
        if (tRTCCloudListener != null && this.mListenerList.contains(tRTCCloudListener)) {
            this.mListenerList.remove(tRTCCloudListener);
        }
    }

    public void resumeScreenCapture(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeResumeScreenCapture(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomAudioData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSendCustomAudioData(j11, new AudioFrame(tRTCAudioFrame));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendCustomCmdMsg(int i11, byte[] bArr, boolean z11, boolean z12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                return nativeSendCustomCmdMsg(j11, i11, bArr, z11, z12);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void sendCustomVideoData(int i11, TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame) {
        TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame2 = tRTCVideoFrame;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame2.texture;
                int i12 = -1;
                Object obj = null;
                if (tRTCTexture != null) {
                    i12 = tRTCTexture.textureId;
                    obj = tRTCTexture.eglContext10;
                    if (obj == null) {
                        obj = tRTCTexture.eglContext14;
                    }
                }
                int i13 = i12;
                int i14 = i11;
                nativeSendCustomVideoData(j11, i14, convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame2.pixelFormat).getValue(), convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame2.bufferType, tRTCVideoFrame2.pixelFormat).mValue, obj, i13, tRTCVideoFrame2.width, tRTCVideoFrame2.height, covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame2.rotation).mValue, tRTCVideoFrame2.timestamp, tRTCVideoFrame2.data, tRTCVideoFrame2.buffer);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public boolean sendSEIMsg(byte[] bArr, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                return nativeSendSEIMsg(j11, bArr, i11);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void set3DSpatialReceivingRange(String str, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSet3DSpatialReceivingRange(j11, str, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioCaptureVolume(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetAudioCaptureVolume(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioFrameListener(TRTCCloudListener.TRTCAudioFrameListener tRTCAudioFrameListener) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                this.mAudioFrameListener = tRTCAudioFrameListener;
                nativeEnableAudioFrameNotification(j11, tRTCAudioFrameListener != null);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioPlayoutVolume(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetAudioPlayoutVolume(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setAudioQuality(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetAudioQuality(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setCapturedAudioFrameCallbackFormat(int i11, int i12, int i13, int i14) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            return j11 != 0 ? nativeSetCapturedAudioFrameCallbackFormat(j11, i11, i12, i13, i14) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setDefaultStreamRecvMode(boolean z11, boolean z12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetDefaultStreamRecvMode(j11, z11, z12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGSensorMode(int i11, int i12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetGSensorMode(j11, i11, i12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setGravitySensorAdaptiveMode(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetGravitySensorAdaptiveMode(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setListener(TRTCCloudListener tRTCCloudListener) {
        this.mListener = tRTCCloudListener;
    }

    public void setListenerHandler(Handler handler) {
        this.mJniReadLock.lock();
        if (handler == null) {
            this.mListenerHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mListenerHandler = handler;
        }
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetListenerHandler(j11, handler);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setLocalProcessedAudioFrameCallbackFormat(int i11, int i12, int i13, int i14) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            return j11 != 0 ? nativeSetLocalProcessedAudioFrameCallbackFormat(j11, i11, i12, i13, i14) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setLocalVideoProcessListener(int i11, int i12, int i13, TRTCCloudListener.TRTCVideoFrameListener tRTCVideoFrameListener) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                GLConstants.PixelFormatType convertTRTCFormatTypeToPixelFormatType = convertTRTCFormatTypeToPixelFormatType(i12);
                GLConstants.a convertTRTCBufferTypeToPixelBufferType = convertTRTCBufferTypeToPixelBufferType(i13, i12);
                if (!isCustomPreprocessSupportedFormatType(convertTRTCFormatTypeToPixelFormatType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_PIXEL_FORMAT_UNSUPPORTED;
                } else if (!isCustomPreprocessSupportedBufferType(convertTRTCBufferTypeToPixelBufferType)) {
                    this.mJniReadLock.unlock();
                    return TXLiteAVCode.ERR_BUFFER_TYPE_UNSUPPORTED;
                } else {
                    synchronized (this.mVideoFrameListenerWrapper) {
                        a<TRTCCloudListener.TRTCVideoFrameListener> aVar = this.mVideoFrameListenerWrapper;
                        if (aVar.f21720d != null) {
                            nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, false, aVar.f21717a, aVar.f21718b.getValue(), this.mVideoFrameListenerWrapper.f21719c.mValue);
                        }
                        a<TRTCCloudListener.TRTCVideoFrameListener> aVar2 = this.mVideoFrameListenerWrapper;
                        aVar2.f21720d = tRTCVideoFrameListener;
                        aVar2.f21717a = i11;
                        aVar2.f21718b = convertTRTCFormatTypeToPixelFormatType;
                        aVar2.f21719c = convertTRTCBufferTypeToPixelBufferType;
                        if (tRTCVideoFrameListener != null) {
                            nativeEnableVideoCustomPreprocess(this.mNativeTrtcCloudJni, true, i11, convertTRTCFormatTypeToPixelFormatType.getValue(), this.mVideoFrameListenerWrapper.f21719c.mValue);
                        }
                    }
                }
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th2) {
            this.mJniReadLock.unlock();
            throw th2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0057 A[Catch:{ all -> 0x00d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setLocalVideoRenderListener(int r23, int r24, com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener r25) {
        /*
            r22 = this;
            r1 = r22
            r0 = r25
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.mJniReadLock
            r2.lock()
            long r2 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00d1 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x0018
        L_0x0012:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            return r3
        L_0x0018:
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r2 = convertTRTCFormatTypeToPixelFormatType(r23)     // Catch:{ all -> 0x00d1 }
            r4 = r23
            r5 = r24
            com.tencent.liteav.videobase.base.GLConstants$a r4 = convertTRTCBufferTypeToPixelBufferType(r5, r4)     // Catch:{ all -> 0x00d1 }
            boolean r5 = isCustomRenderSupportedFormatType(r2)     // Catch:{ all -> 0x00d1 }
            if (r5 != 0) goto L_0x0032
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            r0 = -1327(0xfffffffffffffad1, float:NaN)
            return r0
        L_0x0032:
            boolean r5 = isCustomRenderSupportedBufferType(r4)     // Catch:{ all -> 0x00d1 }
            if (r5 != 0) goto L_0x0040
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            r0 = -1328(0xfffffffffffffad0, float:NaN)
            return r0
        L_0x0040:
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r5 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00d1 }
            monitor-enter(r5)     // Catch:{ all -> 0x00d1 }
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r6 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            T r7 = r6.f21720d     // Catch:{ all -> 0x00ce }
            if (r7 == 0) goto L_0x0093
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r7 = r6.f21718b     // Catch:{ all -> 0x00ce }
            if (r7 != r2) goto L_0x0054
            com.tencent.liteav.videobase.base.GLConstants$a r8 = r6.f21719c     // Catch:{ all -> 0x00ce }
            if (r8 == r4) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            r8 = r3
            goto L_0x0055
        L_0x0054:
            r8 = 1
        L_0x0055:
            if (r8 != 0) goto L_0x005e
            if (r0 != 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            r6.f21720d = r0     // Catch:{ all -> 0x00ce }
            monitor-exit(r5)     // Catch:{ all -> 0x00ce }
            goto L_0x0012
        L_0x005e:
            long r8 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00ce }
            r10 = 0
            java.lang.String r11 = ""
            r12 = 0
            int r13 = r7.getValue()     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r6 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.videobase.base.GLConstants$a r6 = r6.f21719c     // Catch:{ all -> 0x00ce }
            int r14 = r6.mValue     // Catch:{ all -> 0x00ce }
            r6 = r8
            r8 = r10
            r9 = r11
            r10 = r12
            r11 = r13
            r12 = r14
            nativeEnableVideoCustomRender(r6, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00ce }
            long r6 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00ce }
            r17 = 0
            java.lang.String r18 = ""
            r19 = 2
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r8 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r8 = r8.f21718b     // Catch:{ all -> 0x00ce }
            int r20 = r8.getValue()     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r8 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.videobase.base.GLConstants$a r8 = r8.f21719c     // Catch:{ all -> 0x00ce }
            int r8 = r8.mValue     // Catch:{ all -> 0x00ce }
            r15 = r6
            r21 = r8
            nativeEnableVideoCustomRender(r15, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x00ce }
        L_0x0093:
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r6 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            r6.f21720d = r0     // Catch:{ all -> 0x00ce }
            r6.f21718b = r2     // Catch:{ all -> 0x00ce }
            r6.f21719c = r4     // Catch:{ all -> 0x00ce }
            if (r0 == 0) goto L_0x00cb
            long r7 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00ce }
            r9 = 1
            java.lang.String r10 = ""
            r11 = 0
            int r12 = r2.getValue()     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r0 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.videobase.base.GLConstants$a r0 = r0.f21719c     // Catch:{ all -> 0x00ce }
            int r13 = r0.mValue     // Catch:{ all -> 0x00ce }
            nativeEnableVideoCustomRender(r7, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x00ce }
            long r14 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00ce }
            r16 = 1
            java.lang.String r17 = ""
            r18 = 2
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r0 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r0 = r0.f21718b     // Catch:{ all -> 0x00ce }
            int r19 = r0.getValue()     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener> r0 = r1.mLocalVideoRenderListenerWrapper     // Catch:{ all -> 0x00ce }
            com.tencent.liteav.videobase.base.GLConstants$a r0 = r0.f21719c     // Catch:{ all -> 0x00ce }
            int r0 = r0.mValue     // Catch:{ all -> 0x00ce }
            r20 = r0
            nativeEnableVideoCustomRender(r14, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x00ce }
        L_0x00cb:
            monitor-exit(r5)     // Catch:{ all -> 0x00ce }
            goto L_0x0012
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x00ce }
            throw r0     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.mJniReadLock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.TrtcCloudJni.setLocalVideoRenderListener(int, int, com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener):int");
    }

    public void setLocalViewFillMode(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetLocalViewFillMode(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewMirror(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetLocalViewMirror(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setLocalViewRotation(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetLocalViewRotation(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixExternalAudioVolume(int i11, int i12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetMixExternalAudioVolume(j11, i11, i12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setMixTranscodingConfig(TRTCCloudDef.TRTCTranscodingConfig tRTCTranscodingConfig) {
        TranscodingConfig transcodingConfig;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                if (tRTCTranscodingConfig == null) {
                    transcodingConfig = null;
                } else {
                    transcodingConfig = new TranscodingConfig(tRTCTranscodingConfig);
                }
                nativeSetMixTranscodingConfig(j11, transcodingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setMixedPlayAudioFrameCallbackFormat(int i11, int i12, int i13, int i14) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            return j11 != 0 ? nativeSetMixedPlayAudioFrameCallbackFormat(j11, i11, i12, i13, i14) : 0;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setNetworkQosParam(TRTCCloudDef.TRTCNetworkQosParam tRTCNetworkQosParam) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetNetworkQosParam(j11, tRTCNetworkQosParam.preference, tRTCNetworkQosParam.controlMode);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setPerspectiveCorrectionPoints(String str, PointF[] pointFArr, PointF[] pointFArr2) {
        List list;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                List list2 = null;
                if (pointFArr == null) {
                    list = null;
                } else {
                    list = Arrays.asList(pointFArr);
                }
                float[] a11 = b.a(list);
                if (pointFArr2 != null) {
                    list2 = Arrays.asList(pointFArr2);
                }
                nativeSetPerspectiveCorrectionPoints(j11, str, a11, b.a(list2));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public int setPriorRemoteVideoStreamType(int i11) {
        long j11 = this.mNativeTrtcCloudJni;
        if (j11 == 0) {
            return 0;
        }
        nativeSetPriorRemoteVideoStreamType(j11, i11);
        return 0;
    }

    public void setRemoteAudioParallelParams(TRTCCloudDef.TRTCAudioParallelParams tRTCAudioParallelParams) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetRemoteAudioParallelParams(j11, new AudioParallelParams(tRTCAudioParallelParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteAudioVolume(String str, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetRemoteAudioVolume(j11, str, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x006b A[Catch:{ all -> 0x00de }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setRemoteVideoRenderListener(java.lang.String r16, int r17, int r18, com.tencent.trtc.TRTCCloudListener.TRTCVideoRenderListener r19) {
        /*
            r15 = this;
            r1 = r15
            r0 = r16
            r9 = r19
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.mJniReadLock
            r2.lock()
            long r2 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00de }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r10 = 0
            if (r2 != 0) goto L_0x0019
        L_0x0013:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            return r10
        L_0x0019:
            boolean r2 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x00de }
            if (r2 == 0) goto L_0x0027
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            r0 = -3319(0xfffffffffffff309, float:NaN)
            return r0
        L_0x0027:
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r11 = convertTRTCFormatTypeToPixelFormatType(r17)     // Catch:{ all -> 0x00de }
            r2 = r17
            r3 = r18
            com.tencent.liteav.videobase.base.GLConstants$a r12 = convertTRTCBufferTypeToPixelBufferType(r3, r2)     // Catch:{ all -> 0x00de }
            boolean r2 = isCustomRenderSupportedFormatType(r11)     // Catch:{ all -> 0x00de }
            if (r2 != 0) goto L_0x0041
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            r0 = -1327(0xfffffffffffffad1, float:NaN)
            return r0
        L_0x0041:
            boolean r2 = isCustomRenderSupportedBufferType(r12)     // Catch:{ all -> 0x00de }
            if (r2 != 0) goto L_0x004f
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r1.mJniReadLock
            r0.unlock()
            r0 = -1328(0xfffffffffffffad0, float:NaN)
            return r0
        L_0x004f:
            java.util.Map<java.lang.String, com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener>> r13 = r1.mRemoteVideoRenderListenerMap     // Catch:{ all -> 0x00de }
            monitor-enter(r13)     // Catch:{ all -> 0x00de }
            java.util.Map<java.lang.String, com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener>> r2 = r1.mRemoteVideoRenderListenerMap     // Catch:{ all -> 0x00db }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00db }
            r14 = r2
            com.tencent.liteav.trtc.TrtcCloudJni$a r14 = (com.tencent.liteav.trtc.TrtcCloudJni.a) r14     // Catch:{ all -> 0x00db }
            if (r14 == 0) goto L_0x009c
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r2 = r14.f21718b     // Catch:{ all -> 0x00db }
            if (r2 != r11) goto L_0x0068
            com.tencent.liteav.videobase.base.GLConstants$a r3 = r14.f21719c     // Catch:{ all -> 0x00db }
            if (r3 == r12) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r3 = r10
            goto L_0x0069
        L_0x0068:
            r3 = 1
        L_0x0069:
            if (r3 != 0) goto L_0x0076
            if (r9 != 0) goto L_0x006e
            goto L_0x0076
        L_0x006e:
            r14.f21720d = r9     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener>> r2 = r1.mRemoteVideoRenderListenerMap     // Catch:{ all -> 0x00db }
            r2.put(r0, r14)     // Catch:{ all -> 0x00db }
            goto L_0x009c
        L_0x0076:
            long r3 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00db }
            r5 = 0
            r6 = 0
            int r7 = r2.getValue()     // Catch:{ all -> 0x00db }
            com.tencent.liteav.videobase.base.GLConstants$a r2 = r14.f21719c     // Catch:{ all -> 0x00db }
            int r8 = r2.mValue     // Catch:{ all -> 0x00db }
            r2 = r3
            r4 = r5
            r5 = r16
            nativeEnableVideoCustomRender(r2, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00db }
            long r2 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00db }
            r4 = 0
            r6 = 2
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r5 = r14.f21718b     // Catch:{ all -> 0x00db }
            int r7 = r5.getValue()     // Catch:{ all -> 0x00db }
            com.tencent.liteav.videobase.base.GLConstants$a r5 = r14.f21719c     // Catch:{ all -> 0x00db }
            int r8 = r5.mValue     // Catch:{ all -> 0x00db }
            r5 = r16
            nativeEnableVideoCustomRender(r2, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00db }
        L_0x009c:
            if (r9 == 0) goto L_0x00d3
            com.tencent.liteav.trtc.TrtcCloudJni$a r14 = new com.tencent.liteav.trtc.TrtcCloudJni$a     // Catch:{ all -> 0x00db }
            r14.<init>(r10)     // Catch:{ all -> 0x00db }
            r14.f21720d = r9     // Catch:{ all -> 0x00db }
            r14.f21718b = r11     // Catch:{ all -> 0x00db }
            r14.f21719c = r12     // Catch:{ all -> 0x00db }
            long r2 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00db }
            r4 = 1
            r6 = 0
            int r7 = r11.getValue()     // Catch:{ all -> 0x00db }
            com.tencent.liteav.videobase.base.GLConstants$a r5 = r14.f21719c     // Catch:{ all -> 0x00db }
            int r8 = r5.mValue     // Catch:{ all -> 0x00db }
            r5 = r16
            nativeEnableVideoCustomRender(r2, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00db }
            long r2 = r1.mNativeTrtcCloudJni     // Catch:{ all -> 0x00db }
            r4 = 1
            r6 = 2
            com.tencent.liteav.videobase.base.GLConstants$PixelFormatType r5 = r14.f21718b     // Catch:{ all -> 0x00db }
            int r7 = r5.getValue()     // Catch:{ all -> 0x00db }
            com.tencent.liteav.videobase.base.GLConstants$a r5 = r14.f21719c     // Catch:{ all -> 0x00db }
            int r8 = r5.mValue     // Catch:{ all -> 0x00db }
            r5 = r16
            nativeEnableVideoCustomRender(r2, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00db }
            java.util.Map<java.lang.String, com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener>> r2 = r1.mRemoteVideoRenderListenerMap     // Catch:{ all -> 0x00db }
            r2.put(r0, r14)     // Catch:{ all -> 0x00db }
            goto L_0x00d8
        L_0x00d3:
            java.util.Map<java.lang.String, com.tencent.liteav.trtc.TrtcCloudJni$a<com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener>> r2 = r1.mRemoteVideoRenderListenerMap     // Catch:{ all -> 0x00db }
            r2.remove(r0)     // Catch:{ all -> 0x00db }
        L_0x00d8:
            monitor-exit(r13)     // Catch:{ all -> 0x00db }
            goto L_0x0013
        L_0x00db:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00db }
            throw r0     // Catch:{ all -> 0x00de }
        L_0x00de:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r1.mJniReadLock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.trtc.TrtcCloudJni.setRemoteVideoRenderListener(java.lang.String, int, int, com.tencent.trtc.TRTCCloudListener$TRTCVideoRenderListener):int");
    }

    /* JADX INFO: finally extract failed */
    public int setRemoteVideoStreamType(String str, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetRemoteVideoStreamType(j11, str, i11);
            }
            this.mJniReadLock.unlock();
            return 0;
        } catch (Throwable th2) {
            this.mJniReadLock.unlock();
            throw th2;
        }
    }

    public void setRemoteViewFillMode(String str, int i11, int i12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetRemoteViewFillMode(j11, str, i11, i12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewMirror(String str, int i11, int i12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetRemoteViewMirror(j11, str, i11, i12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setRemoteViewRotation(String str, int i11, int i12) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetRemoteViewRotation(j11, str, i11, i12);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderMirror(boolean z11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetVideoEncoderMirror(j11, z11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderParams(int i11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetVideoEncoderParams(j11, i11, new VideoEncParams(tRTCVideoEncParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoEncoderRotation(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetVideoEncoderRotation(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setVideoMuteImage(Bitmap bitmap, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetVideoMuteImage(j11, bitmap, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void setWatermark(Bitmap bitmap, int i11, float f11, float f12, float f13) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSetWatermark(j11, bitmap, i11, f11, f12, f13);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void showDashboardManager(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeShowDashboardManager(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void snapshotVideo(String str, int i11, int i12, TRTCCloudListener.TRTCSnapshotListener tRTCSnapshotListener) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSnapshotVideo(j11, str, i11, i12, tRTCSnapshotListener);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public int startAudioRecording(TRTCCloudDef.TRTCAudioRecordingParams tRTCAudioRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 == 0) {
                this.mJniReadLock.unlock();
                return 0;
            }
            int nativeStartAudioRecording = nativeStartAudioRecording(j11, new AudioRecordingParams(tRTCAudioRecordingParams));
            this.mJniReadLock.unlock();
            return nativeStartAudioRecording;
        } catch (Throwable th2) {
            this.mJniReadLock.unlock();
            throw th2;
        }
    }

    public void startLocalAudio(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartLocalAudioWithQuality(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalPreview(boolean z11, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartLocalPreview(j11, z11, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startLocalRecording(TRTCCloudDef.TRTCLocalRecordingParams tRTCLocalRecordingParams) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartLocalRecording(j11, new LocalRecordingParams(tRTCLocalRecordingParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishCDNStream(TRTCCloudDef.TRTCPublishCDNParam tRTCPublishCDNParam) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartPublishCDNStream(j11, new PublishCDNParams(tRTCPublishCDNParam));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishMediaStream(TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        PublishTarget publishTarget;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                StreamMixingConfig streamMixingConfig = null;
                if (tRTCPublishTarget == null) {
                    publishTarget = null;
                } else {
                    publishTarget = new PublishTarget(tRTCPublishTarget);
                }
                StreamEncoderParam streamEncoderParam = tRTCStreamEncoderParam == null ? null : new StreamEncoderParam(tRTCStreamEncoderParam);
                if (tRTCStreamMixingConfig != null) {
                    streamMixingConfig = new StreamMixingConfig(tRTCStreamMixingConfig);
                }
                nativeStartPublishMediaStream(j11, publishTarget, streamEncoderParam, streamMixingConfig);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startPublishing(String str, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartPublishing(j11, str, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, int i11, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartRemoteView(j11, str, i11, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startScreenCapture(int i11, TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam, final TRTCCloudDef.TRTCScreenShareParams tRTCScreenShareParams) {
        this.mJniReadLock.lock();
        try {
            if (this.mNativeTrtcCloudJni != 0) {
                ScreenShareParams screenShareParams = tRTCScreenShareParams != null ? new ScreenShareParams(tRTCScreenShareParams) : null;
                if (tRTCVideoEncParam == null) {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i11, (VideoEncParams) null, screenShareParams);
                    LiteavLog.w(TAG, "startScreenCapture encParams is null");
                } else {
                    nativeStartScreenCapture(this.mNativeTrtcCloudJni, i11, new VideoEncParams(tRTCVideoEncParam), screenShareParams);
                }
            }
            if (tRTCScreenShareParams != null) {
                ThreadUtils.runOnUiThread((Runnable) new Runnable() {
                    public final void run() {
                        TrtcCloudJni.this.showFloatingWindow(tRTCScreenShareParams.floatingView);
                    }
                });
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartSpeedTest(j11, new SpeedTestParams(tRTCSpeedTestParams));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartSystemAudioLoopback(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAllRemoteView() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopAllRemoteView(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopAudioRecording() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopAudioRecording(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopLocalAudio(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalPreview() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopLocalPreview(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopLocalRecording() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopLocalRecording(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishCDNStream() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopPublishCDNStream(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishMediaStream(String str) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopPublishMediaStream(j11, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopPublishing() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopPublishing(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str, int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopRemoteView(j11, str, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public void stopScreenCapture(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopScreenCapture(j11, i11);
            }
            this.mJniReadLock.unlock();
            ThreadUtils.runOnUiThread((Runnable) new Runnable() {
                public final void run() {
                    TrtcCloudJni.this.hideFloatingWindow();
                }
            });
        } catch (Throwable th2) {
            this.mJniReadLock.unlock();
            throw th2;
        }
    }

    public void stopSpeedTest() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopSpeedTest(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopSystemAudioLoopback() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopSystemAudioLoopback(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i11) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSwitchRole(j11, i11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRoom(TRTCCloudDef.TRTCSwitchRoomConfig tRTCSwitchRoomConfig) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSwitchRoom(j11, new SwitchRoomConfig(tRTCSwitchRoomConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateLocalView(TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeUpdateLocalView(j11, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateOtherRoomForwardMode(String str) {
        long j11 = this.mNativeTrtcCloudJni;
        if (j11 != 0) {
            nativeUpdateOtherRoomForwardMode(j11, str);
        }
    }

    public void updatePublishMediaStream(String str, TRTCCloudDef.TRTCPublishTarget tRTCPublishTarget, TRTCCloudDef.TRTCStreamEncoderParam tRTCStreamEncoderParam, TRTCCloudDef.TRTCStreamMixingConfig tRTCStreamMixingConfig) {
        PublishTarget publishTarget;
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                if (tRTCPublishTarget == null) {
                    publishTarget = null;
                } else {
                    publishTarget = new PublishTarget(tRTCPublishTarget);
                }
                nativeUpdatePublishMediaStream(j11, str, publishTarget, tRTCStreamEncoderParam == null ? null : new StreamEncoderParam(tRTCStreamEncoderParam), tRTCStreamMixingConfig == null ? null : new StreamMixingConfig(tRTCStreamMixingConfig));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemote3DSpatialPosition(String str, int[] iArr) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeUpdateRemote3DSpatialPosition(j11, str, iArr);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateRemoteView(String str, int i11, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeUpdateRemoteView(j11, str, i11, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void updateSelf3DSpatialPosition(int[] iArr, float[] fArr, float[] fArr2, float[] fArr3) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeUpdateSelf3DSpatialPosition(j11, iArr, fArr, fArr2, fArr3);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public TrtcCloudJni(long j11, boolean z11) {
        this.mNativeTrtcCloudJni = 0;
        this.mLocalUserId = "";
        this.mListenerList = new CopyOnWriteArrayList();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mFloatingWindowSet = new HashSet<>();
        if (j11 == 0) {
            this.mNativeTrtcCloudJni = nativeCreatePipeline(this, z11);
        } else {
            this.mNativeTrtcCloudJni = nativeCreateSubCloud(this, j11);
        }
        this.mVideoFrameListenerWrapper = new a<>((byte) 0);
        this.mLocalVideoRenderListenerWrapper = new a<>((byte) 0);
        this.mRemoteVideoRenderListenerMap = new HashMap();
        this.mListenerHandler = new Handler(Looper.getMainLooper());
    }

    public static class SpeedTestParams {

        /* renamed from: a  reason: collision with root package name */
        private final TRTCCloudDef.TRTCSpeedTestParams f21705a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f21706b = true;

        public SpeedTestParams(TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams) {
            this.f21705a = tRTCSpeedTestParams;
        }

        public int getExpectedDownBandwidth() {
            return this.f21705a.expectedDownBandwidth;
        }

        public int getExpectedUpBandwidth() {
            return this.f21705a.expectedUpBandwidth;
        }

        public boolean getIsCalledFromDeprecatedApi() {
            return this.f21706b;
        }

        public int getSDKAppId() {
            return this.f21705a.sdkAppId;
        }

        public int getScene() {
            return this.f21705a.scene;
        }

        public String getUserId() {
            return this.f21705a.userId;
        }

        public String getUserSig() {
            return this.f21705a.userSig;
        }

        public SpeedTestParams(int i11, String str, String str2) {
            TRTCCloudDef.TRTCSpeedTestParams tRTCSpeedTestParams = new TRTCCloudDef.TRTCSpeedTestParams();
            this.f21705a = tRTCSpeedTestParams;
            tRTCSpeedTestParams.sdkAppId = i11;
            tRTCSpeedTestParams.userId = str;
            tRTCSpeedTestParams.userSig = str2;
            tRTCSpeedTestParams.scene = 1;
        }
    }

    public void startLocalAudio() {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartLocalAudio(j11);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startRemoteView(String str, TXCloudVideoView tXCloudVideoView) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartRemoteViewWithoutStreamType(j11, str, new DisplayTarget(tXCloudVideoView));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void startSpeedTest(int i11, String str, String str2) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStartSpeedTest(j11, new SpeedTestParams(i11, str, str2));
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void stopRemoteView(String str) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeStopRemoteViewWithoutStreamType(j11, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void switchRole(int i11, String str) {
        this.mJniReadLock.lock();
        try {
            long j11 = this.mNativeTrtcCloudJni;
            if (j11 != 0) {
                nativeSwitchRoleWithPrivateMapKey(j11, i11, str);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    private static void shadowCopy(TRTCCloudDef.TRTCVideoFrame tRTCVideoFrame, PixelFrame pixelFrame) {
        Object obj;
        int i11;
        TRTCCloudDef.TRTCTexture tRTCTexture = tRTCVideoFrame.texture;
        pixelFrame.setPixelFormatType(convertTRTCFormatTypeToPixelFormatType(tRTCVideoFrame.pixelFormat));
        pixelFrame.setPixelBufferType(convertTRTCBufferTypeToPixelBufferType(tRTCVideoFrame.bufferType, tRTCVideoFrame.pixelFormat));
        if (tRTCTexture != null) {
            i11 = tRTCTexture.textureId;
            obj = tRTCTexture.eglContext10;
            if (obj == null) {
                obj = tRTCTexture.eglContext14;
            }
        } else {
            i11 = -1;
            obj = null;
        }
        pixelFrame.setTextureId(i11);
        pixelFrame.setGLContext(obj);
        pixelFrame.setData(tRTCVideoFrame.data);
        pixelFrame.setBuffer(tRTCVideoFrame.buffer);
        pixelFrame.setWidth(tRTCVideoFrame.width);
        pixelFrame.setHeight(tRTCVideoFrame.height);
        pixelFrame.setTimestamp(tRTCVideoFrame.timestamp);
        pixelFrame.setRotation(covertTRTCVideoRotationToPixelFrameRotation(tRTCVideoFrame.rotation));
    }
}
