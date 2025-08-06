package com.google.android.exoplayer2.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.sumsub.sns.internal.ml.autocapture.b;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.ugc.beauty.decoder.MediaUtils;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, b.f34944a, TXVodDownloadDataSource.QUALITY_540P, TXVodDownloadDataSource.QUALITY_480P};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private int currentHeight;
    private float currentPixelWidthHeightRatio;
    private int currentUnappliedRotationDegrees;
    private int currentWidth;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private DummySurface dummySurface;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private Surface surface;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    public OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;

    public static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i11, int i12, int i13) {
            this.width = i11;
            this.height = i12;
            this.inputSize = i13;
        }
    }

    public final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        private void handleFrameRendered(long j11) {
            MediaCodecVideoRenderer mediaCodecVideoRenderer = MediaCodecVideoRenderer.this;
            if (this == mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener) {
                if (j11 == Long.MAX_VALUE) {
                    mediaCodecVideoRenderer.onProcessedTunneledEndOfStream();
                    return;
                }
                try {
                    mediaCodecVideoRenderer.onProcessedTunneledBuffer(j11);
                } catch (ExoPlaybackException e11) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e11);
                }
            }
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j11, long j12) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j11 >> 32), (int) j11));
                return;
            }
            handleFrameRendered(j11);
        }
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i11) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i11);
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:438:0x07d4, code lost:
        if (r0.equals("NX573J") == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:462:0x0836, code lost:
        if (r0.equals("AFTN") == false) goto L_0x082e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:470:0x0852, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 6
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 28
            r6 = 2
            r7 = -1
            r8 = 0
            r9 = 1
            if (r0 > r5) goto L_0x006d
            java.lang.String r10 = com.google.android.exoplayer2.util.Util.DEVICE
            r10.hashCode()
            int r11 = r10.hashCode()
            switch(r11) {
                case -1339091551: goto L_0x005e;
                case -1220081023: goto L_0x0053;
                case -1220066608: goto L_0x0048;
                case -1012436106: goto L_0x003d;
                case -64886864: goto L_0x0032;
                case 3415681: goto L_0x0027;
                case 825323514: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            r10 = r7
            goto L_0x0068
        L_0x001c:
            java.lang.String r11 = "machuca"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0025
            goto L_0x001a
        L_0x0025:
            r10 = r1
            goto L_0x0068
        L_0x0027:
            java.lang.String r11 = "once"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0030
            goto L_0x001a
        L_0x0030:
            r10 = r2
            goto L_0x0068
        L_0x0032:
            java.lang.String r11 = "magnolia"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x003b
            goto L_0x001a
        L_0x003b:
            r10 = r3
            goto L_0x0068
        L_0x003d:
            java.lang.String r11 = "oneday"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0046
            goto L_0x001a
        L_0x0046:
            r10 = r4
            goto L_0x0068
        L_0x0048:
            java.lang.String r11 = "dangalUHD"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0051
            goto L_0x001a
        L_0x0051:
            r10 = r6
            goto L_0x0068
        L_0x0053:
            java.lang.String r11 = "dangalFHD"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x005c
            goto L_0x001a
        L_0x005c:
            r10 = r9
            goto L_0x0068
        L_0x005e:
            java.lang.String r11 = "dangal"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0067
            goto L_0x001a
        L_0x0067:
            r10 = r8
        L_0x0068:
            switch(r10) {
                case 0: goto L_0x006c;
                case 1: goto L_0x006c;
                case 2: goto L_0x006c;
                case 3: goto L_0x006c;
                case 4: goto L_0x006c;
                case 5: goto L_0x006c;
                case 6: goto L_0x006c;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x006d
        L_0x006c:
            return r9
        L_0x006d:
            r10 = 27
            if (r0 > r10) goto L_0x007c
            java.lang.String r11 = com.google.android.exoplayer2.util.Util.DEVICE
            java.lang.String r12 = "HWEML"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x007c
            return r9
        L_0x007c:
            r11 = 26
            if (r0 > r11) goto L_0x0853
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.DEVICE
            r0.hashCode()
            int r12 = r0.hashCode()
            switch(r12) {
                case -2144781245: goto L_0x0814;
                case -2144781185: goto L_0x0808;
                case -2144781160: goto L_0x07fc;
                case -2097309513: goto L_0x07f0;
                case -2022874474: goto L_0x07e4;
                case -1978993182: goto L_0x07d8;
                case -1978990237: goto L_0x07ce;
                case -1936688988: goto L_0x07c2;
                case -1936688066: goto L_0x07b4;
                case -1936688065: goto L_0x07a6;
                case -1931988508: goto L_0x0798;
                case -1885099851: goto L_0x078a;
                case -1696512866: goto L_0x077c;
                case -1680025915: goto L_0x076e;
                case -1615810839: goto L_0x0760;
                case -1600724499: goto L_0x0752;
                case -1554255044: goto L_0x0743;
                case -1481772737: goto L_0x0735;
                case -1481772730: goto L_0x0727;
                case -1481772729: goto L_0x0719;
                case -1320080169: goto L_0x070b;
                case -1217592143: goto L_0x06fd;
                case -1180384755: goto L_0x06ef;
                case -1139198265: goto L_0x06e1;
                case -1052835013: goto L_0x06d3;
                case -993250464: goto L_0x06c5;
                case -993250458: goto L_0x06b8;
                case -965403638: goto L_0x06ab;
                case -958336948: goto L_0x069e;
                case -879245230: goto L_0x068f;
                case -842500323: goto L_0x0681;
                case -821392978: goto L_0x0673;
                case -797483286: goto L_0x0665;
                case -794946968: goto L_0x0656;
                case -788334647: goto L_0x0647;
                case -782144577: goto L_0x0639;
                case -575125681: goto L_0x062b;
                case -521118391: goto L_0x061d;
                case -430914369: goto L_0x060f;
                case -290434366: goto L_0x0600;
                case -282781963: goto L_0x05f2;
                case -277133239: goto L_0x05e4;
                case -173639913: goto L_0x05d6;
                case -56598463: goto L_0x05c7;
                case 2126: goto L_0x05b9;
                case 2564: goto L_0x05ab;
                case 2715: goto L_0x059d;
                case 2719: goto L_0x058f;
                case 3091: goto L_0x0581;
                case 3483: goto L_0x0573;
                case 73405: goto L_0x0565;
                case 75537: goto L_0x0557;
                case 75739: goto L_0x0549;
                case 76779: goto L_0x053b;
                case 78669: goto L_0x052d;
                case 79305: goto L_0x051f;
                case 80618: goto L_0x0511;
                case 88274: goto L_0x0503;
                case 98846: goto L_0x04f5;
                case 98848: goto L_0x04e7;
                case 99329: goto L_0x04d9;
                case 101481: goto L_0x04cb;
                case 1513190: goto L_0x04bd;
                case 1514184: goto L_0x04af;
                case 1514185: goto L_0x04a1;
                case 2133089: goto L_0x0493;
                case 2133091: goto L_0x0485;
                case 2133120: goto L_0x0477;
                case 2133151: goto L_0x0469;
                case 2133182: goto L_0x045b;
                case 2133184: goto L_0x044d;
                case 2436959: goto L_0x043f;
                case 2463773: goto L_0x0431;
                case 2464648: goto L_0x0423;
                case 2689555: goto L_0x0415;
                case 3154429: goto L_0x0407;
                case 3284551: goto L_0x03f9;
                case 3351335: goto L_0x03eb;
                case 3386211: goto L_0x03dd;
                case 41325051: goto L_0x03cf;
                case 51349633: goto L_0x03c1;
                case 51350594: goto L_0x03b3;
                case 55178625: goto L_0x03a5;
                case 61542055: goto L_0x0397;
                case 65355429: goto L_0x0389;
                case 66214468: goto L_0x037b;
                case 66214470: goto L_0x036d;
                case 66214473: goto L_0x035f;
                case 66215429: goto L_0x0351;
                case 66215431: goto L_0x0343;
                case 66215433: goto L_0x0335;
                case 66216390: goto L_0x0327;
                case 76402249: goto L_0x0319;
                case 76404105: goto L_0x030b;
                case 76404911: goto L_0x02fd;
                case 80963634: goto L_0x02ef;
                case 82882791: goto L_0x02e1;
                case 98715550: goto L_0x02d3;
                case 101370885: goto L_0x02c5;
                case 102844228: goto L_0x02b7;
                case 165221241: goto L_0x02a9;
                case 182191441: goto L_0x029b;
                case 245388979: goto L_0x028d;
                case 287431619: goto L_0x027f;
                case 307593612: goto L_0x0271;
                case 308517133: goto L_0x0263;
                case 316215098: goto L_0x0255;
                case 316215116: goto L_0x0247;
                case 316246811: goto L_0x0239;
                case 316246818: goto L_0x022b;
                case 407160593: goto L_0x021d;
                case 507412548: goto L_0x020f;
                case 793982701: goto L_0x0201;
                case 794038622: goto L_0x01f3;
                case 794040393: goto L_0x01e5;
                case 835649806: goto L_0x01d7;
                case 917340916: goto L_0x01c9;
                case 958008161: goto L_0x01bb;
                case 1060579533: goto L_0x01ad;
                case 1150207623: goto L_0x019f;
                case 1176899427: goto L_0x0191;
                case 1280332038: goto L_0x0183;
                case 1306947716: goto L_0x0175;
                case 1349174697: goto L_0x0167;
                case 1522194893: goto L_0x0158;
                case 1691543273: goto L_0x014a;
                case 1691544261: goto L_0x013c;
                case 1709443163: goto L_0x012e;
                case 1865889110: goto L_0x0120;
                case 1906253259: goto L_0x0112;
                case 1977196784: goto L_0x0104;
                case 2006372676: goto L_0x00f7;
                case 2019281702: goto L_0x00ea;
                case 2029784656: goto L_0x00dd;
                case 2030379515: goto L_0x00d0;
                case 2033393791: goto L_0x00c3;
                case 2047190025: goto L_0x00b6;
                case 2047252157: goto L_0x00a9;
                case 2048319463: goto L_0x009c;
                case 2048855701: goto L_0x008f;
                default: goto L_0x008c;
            }
        L_0x008c:
            r1 = r7
            goto L_0x081f
        L_0x008f:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0098
            goto L_0x008c
        L_0x0098:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x081f
        L_0x009c:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a5
            goto L_0x008c
        L_0x00a5:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x081f
        L_0x00a9:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b2
            goto L_0x008c
        L_0x00b2:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x081f
        L_0x00b6:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00bf
            goto L_0x008c
        L_0x00bf:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x081f
        L_0x00c3:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00cc
            goto L_0x008c
        L_0x00cc:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x081f
        L_0x00d0:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d9
            goto L_0x008c
        L_0x00d9:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x081f
        L_0x00dd:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e6
            goto L_0x008c
        L_0x00e6:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x081f
        L_0x00ea:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f3
            goto L_0x008c
        L_0x00f3:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x081f
        L_0x00f7:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0100
            goto L_0x008c
        L_0x0100:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x081f
        L_0x0104:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x010e
            goto L_0x008c
        L_0x010e:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x081f
        L_0x0112:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x011c
            goto L_0x008c
        L_0x011c:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x081f
        L_0x0120:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012a
            goto L_0x008c
        L_0x012a:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x081f
        L_0x012e:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0138
            goto L_0x008c
        L_0x0138:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x081f
        L_0x013c:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0146
            goto L_0x008c
        L_0x0146:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x081f
        L_0x014a:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0154
            goto L_0x008c
        L_0x0154:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x081f
        L_0x0158:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0163
            goto L_0x008c
        L_0x0163:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x081f
        L_0x0167:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0171
            goto L_0x008c
        L_0x0171:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x081f
        L_0x0175:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x017f
            goto L_0x008c
        L_0x017f:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x081f
        L_0x0183:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x018d
            goto L_0x008c
        L_0x018d:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x081f
        L_0x0191:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x019b
            goto L_0x008c
        L_0x019b:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x081f
        L_0x019f:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a9
            goto L_0x008c
        L_0x01a9:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x081f
        L_0x01ad:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01b7
            goto L_0x008c
        L_0x01b7:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x081f
        L_0x01bb:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01c5
            goto L_0x008c
        L_0x01c5:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x081f
        L_0x01c9:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01d3
            goto L_0x008c
        L_0x01d3:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x081f
        L_0x01d7:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01e1
            goto L_0x008c
        L_0x01e1:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x081f
        L_0x01e5:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01ef
            goto L_0x008c
        L_0x01ef:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x081f
        L_0x01f3:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01fd
            goto L_0x008c
        L_0x01fd:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x081f
        L_0x0201:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x020b
            goto L_0x008c
        L_0x020b:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x081f
        L_0x020f:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0219
            goto L_0x008c
        L_0x0219:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x081f
        L_0x021d:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0227
            goto L_0x008c
        L_0x0227:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x081f
        L_0x022b:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0235
            goto L_0x008c
        L_0x0235:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x081f
        L_0x0239:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0243
            goto L_0x008c
        L_0x0243:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x081f
        L_0x0247:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0251
            goto L_0x008c
        L_0x0251:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x081f
        L_0x0255:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x025f
            goto L_0x008c
        L_0x025f:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x081f
        L_0x0263:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x026d
            goto L_0x008c
        L_0x026d:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x081f
        L_0x0271:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x027b
            goto L_0x008c
        L_0x027b:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x081f
        L_0x027f:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0289
            goto L_0x008c
        L_0x0289:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x081f
        L_0x028d:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0297
            goto L_0x008c
        L_0x0297:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x081f
        L_0x029b:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02a5
            goto L_0x008c
        L_0x02a5:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x081f
        L_0x02a9:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02b3
            goto L_0x008c
        L_0x02b3:
            r1 = 100
            goto L_0x081f
        L_0x02b7:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02c1
            goto L_0x008c
        L_0x02c1:
            r1 = 99
            goto L_0x081f
        L_0x02c5:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02cf
            goto L_0x008c
        L_0x02cf:
            r1 = 98
            goto L_0x081f
        L_0x02d3:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02dd
            goto L_0x008c
        L_0x02dd:
            r1 = 97
            goto L_0x081f
        L_0x02e1:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02eb
            goto L_0x008c
        L_0x02eb:
            r1 = 96
            goto L_0x081f
        L_0x02ef:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f9
            goto L_0x008c
        L_0x02f9:
            r1 = 95
            goto L_0x081f
        L_0x02fd:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0307
            goto L_0x008c
        L_0x0307:
            r1 = 94
            goto L_0x081f
        L_0x030b:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0315
            goto L_0x008c
        L_0x0315:
            r1 = 93
            goto L_0x081f
        L_0x0319:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0323
            goto L_0x008c
        L_0x0323:
            r1 = 92
            goto L_0x081f
        L_0x0327:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0331
            goto L_0x008c
        L_0x0331:
            r1 = 91
            goto L_0x081f
        L_0x0335:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x033f
            goto L_0x008c
        L_0x033f:
            r1 = 90
            goto L_0x081f
        L_0x0343:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x034d
            goto L_0x008c
        L_0x034d:
            r1 = 89
            goto L_0x081f
        L_0x0351:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x035b
            goto L_0x008c
        L_0x035b:
            r1 = 88
            goto L_0x081f
        L_0x035f:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0369
            goto L_0x008c
        L_0x0369:
            r1 = 87
            goto L_0x081f
        L_0x036d:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0377
            goto L_0x008c
        L_0x0377:
            r1 = 86
            goto L_0x081f
        L_0x037b:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0385
            goto L_0x008c
        L_0x0385:
            r1 = 85
            goto L_0x081f
        L_0x0389:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0393
            goto L_0x008c
        L_0x0393:
            r1 = 84
            goto L_0x081f
        L_0x0397:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03a1
            goto L_0x008c
        L_0x03a1:
            r1 = 83
            goto L_0x081f
        L_0x03a5:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03af
            goto L_0x008c
        L_0x03af:
            r1 = 82
            goto L_0x081f
        L_0x03b3:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03bd
            goto L_0x008c
        L_0x03bd:
            r1 = 81
            goto L_0x081f
        L_0x03c1:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03cb
            goto L_0x008c
        L_0x03cb:
            r1 = 80
            goto L_0x081f
        L_0x03cf:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d9
            goto L_0x008c
        L_0x03d9:
            r1 = 79
            goto L_0x081f
        L_0x03dd:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03e7
            goto L_0x008c
        L_0x03e7:
            r1 = 78
            goto L_0x081f
        L_0x03eb:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03f5
            goto L_0x008c
        L_0x03f5:
            r1 = 77
            goto L_0x081f
        L_0x03f9:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0403
            goto L_0x008c
        L_0x0403:
            r1 = 76
            goto L_0x081f
        L_0x0407:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0411
            goto L_0x008c
        L_0x0411:
            r1 = 75
            goto L_0x081f
        L_0x0415:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x041f
            goto L_0x008c
        L_0x041f:
            r1 = 74
            goto L_0x081f
        L_0x0423:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x042d
            goto L_0x008c
        L_0x042d:
            r1 = 73
            goto L_0x081f
        L_0x0431:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x043b
            goto L_0x008c
        L_0x043b:
            r1 = 72
            goto L_0x081f
        L_0x043f:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0449
            goto L_0x008c
        L_0x0449:
            r1 = 71
            goto L_0x081f
        L_0x044d:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0457
            goto L_0x008c
        L_0x0457:
            r1 = 70
            goto L_0x081f
        L_0x045b:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0465
            goto L_0x008c
        L_0x0465:
            r1 = 69
            goto L_0x081f
        L_0x0469:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0473
            goto L_0x008c
        L_0x0473:
            r1 = 68
            goto L_0x081f
        L_0x0477:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0481
            goto L_0x008c
        L_0x0481:
            r1 = 67
            goto L_0x081f
        L_0x0485:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x048f
            goto L_0x008c
        L_0x048f:
            r1 = 66
            goto L_0x081f
        L_0x0493:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x049d
            goto L_0x008c
        L_0x049d:
            r1 = 65
            goto L_0x081f
        L_0x04a1:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ab
            goto L_0x008c
        L_0x04ab:
            r1 = 64
            goto L_0x081f
        L_0x04af:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b9
            goto L_0x008c
        L_0x04b9:
            r1 = 63
            goto L_0x081f
        L_0x04bd:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04c7
            goto L_0x008c
        L_0x04c7:
            r1 = 62
            goto L_0x081f
        L_0x04cb:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04d5
            goto L_0x008c
        L_0x04d5:
            r1 = 61
            goto L_0x081f
        L_0x04d9:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04e3
            goto L_0x008c
        L_0x04e3:
            r1 = 60
            goto L_0x081f
        L_0x04e7:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04f1
            goto L_0x008c
        L_0x04f1:
            r1 = 59
            goto L_0x081f
        L_0x04f5:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ff
            goto L_0x008c
        L_0x04ff:
            r1 = 58
            goto L_0x081f
        L_0x0503:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x050d
            goto L_0x008c
        L_0x050d:
            r1 = 57
            goto L_0x081f
        L_0x0511:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x051b
            goto L_0x008c
        L_0x051b:
            r1 = 56
            goto L_0x081f
        L_0x051f:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0529
            goto L_0x008c
        L_0x0529:
            r1 = 55
            goto L_0x081f
        L_0x052d:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0537
            goto L_0x008c
        L_0x0537:
            r1 = 54
            goto L_0x081f
        L_0x053b:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0545
            goto L_0x008c
        L_0x0545:
            r1 = 53
            goto L_0x081f
        L_0x0549:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0553
            goto L_0x008c
        L_0x0553:
            r1 = 52
            goto L_0x081f
        L_0x0557:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0561
            goto L_0x008c
        L_0x0561:
            r1 = 51
            goto L_0x081f
        L_0x0565:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x056f
            goto L_0x008c
        L_0x056f:
            r1 = 50
            goto L_0x081f
        L_0x0573:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x057d
            goto L_0x008c
        L_0x057d:
            r1 = 49
            goto L_0x081f
        L_0x0581:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x058b
            goto L_0x008c
        L_0x058b:
            r1 = 48
            goto L_0x081f
        L_0x058f:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0599
            goto L_0x008c
        L_0x0599:
            r1 = 47
            goto L_0x081f
        L_0x059d:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05a7
            goto L_0x008c
        L_0x05a7:
            r1 = 46
            goto L_0x081f
        L_0x05ab:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05b5
            goto L_0x008c
        L_0x05b5:
            r1 = 45
            goto L_0x081f
        L_0x05b9:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05c3
            goto L_0x008c
        L_0x05c3:
            r1 = 44
            goto L_0x081f
        L_0x05c7:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05d2
            goto L_0x008c
        L_0x05d2:
            r1 = 43
            goto L_0x081f
        L_0x05d6:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e0
            goto L_0x008c
        L_0x05e0:
            r1 = 42
            goto L_0x081f
        L_0x05e4:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05ee
            goto L_0x008c
        L_0x05ee:
            r1 = 41
            goto L_0x081f
        L_0x05f2:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05fc
            goto L_0x008c
        L_0x05fc:
            r1 = 40
            goto L_0x081f
        L_0x0600:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x060b
            goto L_0x008c
        L_0x060b:
            r1 = 39
            goto L_0x081f
        L_0x060f:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0619
            goto L_0x008c
        L_0x0619:
            r1 = 38
            goto L_0x081f
        L_0x061d:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0627
            goto L_0x008c
        L_0x0627:
            r1 = 37
            goto L_0x081f
        L_0x062b:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0635
            goto L_0x008c
        L_0x0635:
            r1 = 36
            goto L_0x081f
        L_0x0639:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0643
            goto L_0x008c
        L_0x0643:
            r1 = 35
            goto L_0x081f
        L_0x0647:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0652
            goto L_0x008c
        L_0x0652:
            r1 = 34
            goto L_0x081f
        L_0x0656:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0661
            goto L_0x008c
        L_0x0661:
            r1 = 33
            goto L_0x081f
        L_0x0665:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x066f
            goto L_0x008c
        L_0x066f:
            r1 = 32
            goto L_0x081f
        L_0x0673:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x067d
            goto L_0x008c
        L_0x067d:
            r1 = 31
            goto L_0x081f
        L_0x0681:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x068b
            goto L_0x008c
        L_0x068b:
            r1 = 30
            goto L_0x081f
        L_0x068f:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069a
            goto L_0x008c
        L_0x069a:
            r1 = 29
            goto L_0x081f
        L_0x069e:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06a8
            goto L_0x008c
        L_0x06a8:
            r1 = r5
            goto L_0x081f
        L_0x06ab:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06b5
            goto L_0x008c
        L_0x06b5:
            r1 = r10
            goto L_0x081f
        L_0x06b8:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c2
            goto L_0x008c
        L_0x06c2:
            r1 = r11
            goto L_0x081f
        L_0x06c5:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06cf
            goto L_0x008c
        L_0x06cf:
            r1 = 25
            goto L_0x081f
        L_0x06d3:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06dd
            goto L_0x008c
        L_0x06dd:
            r1 = 24
            goto L_0x081f
        L_0x06e1:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06eb
            goto L_0x008c
        L_0x06eb:
            r1 = 23
            goto L_0x081f
        L_0x06ef:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06f9
            goto L_0x008c
        L_0x06f9:
            r1 = 22
            goto L_0x081f
        L_0x06fd:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0707
            goto L_0x008c
        L_0x0707:
            r1 = 21
            goto L_0x081f
        L_0x070b:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0715
            goto L_0x008c
        L_0x0715:
            r1 = 20
            goto L_0x081f
        L_0x0719:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0723
            goto L_0x008c
        L_0x0723:
            r1 = 19
            goto L_0x081f
        L_0x0727:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0731
            goto L_0x008c
        L_0x0731:
            r1 = 18
            goto L_0x081f
        L_0x0735:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x073f
            goto L_0x008c
        L_0x073f:
            r1 = 17
            goto L_0x081f
        L_0x0743:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x074e
            goto L_0x008c
        L_0x074e:
            r1 = 16
            goto L_0x081f
        L_0x0752:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x075c
            goto L_0x008c
        L_0x075c:
            r1 = 15
            goto L_0x081f
        L_0x0760:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x076a
            goto L_0x008c
        L_0x076a:
            r1 = 14
            goto L_0x081f
        L_0x076e:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0778
            goto L_0x008c
        L_0x0778:
            r1 = 13
            goto L_0x081f
        L_0x077c:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0786
            goto L_0x008c
        L_0x0786:
            r1 = 12
            goto L_0x081f
        L_0x078a:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0794
            goto L_0x008c
        L_0x0794:
            r1 = 11
            goto L_0x081f
        L_0x0798:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a2
            goto L_0x008c
        L_0x07a2:
            r1 = 10
            goto L_0x081f
        L_0x07a6:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b0
            goto L_0x008c
        L_0x07b0:
            r1 = 9
            goto L_0x081f
        L_0x07b4:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07be
            goto L_0x008c
        L_0x07be:
            r1 = 8
            goto L_0x081f
        L_0x07c2:
            java.lang.String r1 = "PGN528"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07cc
            goto L_0x008c
        L_0x07cc:
            r1 = 7
            goto L_0x081f
        L_0x07ce:
            java.lang.String r2 = "NX573J"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x081f
            goto L_0x008c
        L_0x07d8:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e2
            goto L_0x008c
        L_0x07e2:
            r1 = r2
            goto L_0x081f
        L_0x07e4:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07ee
            goto L_0x008c
        L_0x07ee:
            r1 = r3
            goto L_0x081f
        L_0x07f0:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07fa
            goto L_0x008c
        L_0x07fa:
            r1 = r4
            goto L_0x081f
        L_0x07fc:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0806
            goto L_0x008c
        L_0x0806:
            r1 = r6
            goto L_0x081f
        L_0x0808:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0812
            goto L_0x008c
        L_0x0812:
            r1 = r9
            goto L_0x081f
        L_0x0814:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x081e
            goto L_0x008c
        L_0x081e:
            r1 = r8
        L_0x081f:
            switch(r1) {
                case 0: goto L_0x0852;
                case 1: goto L_0x0852;
                case 2: goto L_0x0852;
                case 3: goto L_0x0852;
                case 4: goto L_0x0852;
                case 5: goto L_0x0852;
                case 6: goto L_0x0852;
                case 7: goto L_0x0852;
                case 8: goto L_0x0852;
                case 9: goto L_0x0852;
                case 10: goto L_0x0852;
                case 11: goto L_0x0852;
                case 12: goto L_0x0852;
                case 13: goto L_0x0852;
                case 14: goto L_0x0852;
                case 15: goto L_0x0852;
                case 16: goto L_0x0852;
                case 17: goto L_0x0852;
                case 18: goto L_0x0852;
                case 19: goto L_0x0852;
                case 20: goto L_0x0852;
                case 21: goto L_0x0852;
                case 22: goto L_0x0852;
                case 23: goto L_0x0852;
                case 24: goto L_0x0852;
                case 25: goto L_0x0852;
                case 26: goto L_0x0852;
                case 27: goto L_0x0852;
                case 28: goto L_0x0852;
                case 29: goto L_0x0852;
                case 30: goto L_0x0852;
                case 31: goto L_0x0852;
                case 32: goto L_0x0852;
                case 33: goto L_0x0852;
                case 34: goto L_0x0852;
                case 35: goto L_0x0852;
                case 36: goto L_0x0852;
                case 37: goto L_0x0852;
                case 38: goto L_0x0852;
                case 39: goto L_0x0852;
                case 40: goto L_0x0852;
                case 41: goto L_0x0852;
                case 42: goto L_0x0852;
                case 43: goto L_0x0852;
                case 44: goto L_0x0852;
                case 45: goto L_0x0852;
                case 46: goto L_0x0852;
                case 47: goto L_0x0852;
                case 48: goto L_0x0852;
                case 49: goto L_0x0852;
                case 50: goto L_0x0852;
                case 51: goto L_0x0852;
                case 52: goto L_0x0852;
                case 53: goto L_0x0852;
                case 54: goto L_0x0852;
                case 55: goto L_0x0852;
                case 56: goto L_0x0852;
                case 57: goto L_0x0852;
                case 58: goto L_0x0852;
                case 59: goto L_0x0852;
                case 60: goto L_0x0852;
                case 61: goto L_0x0852;
                case 62: goto L_0x0852;
                case 63: goto L_0x0852;
                case 64: goto L_0x0852;
                case 65: goto L_0x0852;
                case 66: goto L_0x0852;
                case 67: goto L_0x0852;
                case 68: goto L_0x0852;
                case 69: goto L_0x0852;
                case 70: goto L_0x0852;
                case 71: goto L_0x0852;
                case 72: goto L_0x0852;
                case 73: goto L_0x0852;
                case 74: goto L_0x0852;
                case 75: goto L_0x0852;
                case 76: goto L_0x0852;
                case 77: goto L_0x0852;
                case 78: goto L_0x0852;
                case 79: goto L_0x0852;
                case 80: goto L_0x0852;
                case 81: goto L_0x0852;
                case 82: goto L_0x0852;
                case 83: goto L_0x0852;
                case 84: goto L_0x0852;
                case 85: goto L_0x0852;
                case 86: goto L_0x0852;
                case 87: goto L_0x0852;
                case 88: goto L_0x0852;
                case 89: goto L_0x0852;
                case 90: goto L_0x0852;
                case 91: goto L_0x0852;
                case 92: goto L_0x0852;
                case 93: goto L_0x0852;
                case 94: goto L_0x0852;
                case 95: goto L_0x0852;
                case 96: goto L_0x0852;
                case 97: goto L_0x0852;
                case 98: goto L_0x0852;
                case 99: goto L_0x0852;
                case 100: goto L_0x0852;
                case 101: goto L_0x0852;
                case 102: goto L_0x0852;
                case 103: goto L_0x0852;
                case 104: goto L_0x0852;
                case 105: goto L_0x0852;
                case 106: goto L_0x0852;
                case 107: goto L_0x0852;
                case 108: goto L_0x0852;
                case 109: goto L_0x0852;
                case 110: goto L_0x0852;
                case 111: goto L_0x0852;
                case 112: goto L_0x0852;
                case 113: goto L_0x0852;
                case 114: goto L_0x0852;
                case 115: goto L_0x0852;
                case 116: goto L_0x0852;
                case 117: goto L_0x0852;
                case 118: goto L_0x0852;
                case 119: goto L_0x0852;
                case 120: goto L_0x0852;
                case 121: goto L_0x0852;
                case 122: goto L_0x0852;
                case 123: goto L_0x0852;
                case 124: goto L_0x0852;
                case 125: goto L_0x0852;
                case 126: goto L_0x0852;
                case 127: goto L_0x0852;
                case 128: goto L_0x0852;
                case 129: goto L_0x0852;
                case 130: goto L_0x0852;
                case 131: goto L_0x0852;
                case 132: goto L_0x0852;
                case 133: goto L_0x0852;
                case 134: goto L_0x0852;
                case 135: goto L_0x0852;
                case 136: goto L_0x0852;
                case 137: goto L_0x0852;
                case 138: goto L_0x0852;
                case 139: goto L_0x0852;
                default: goto L_0x0822;
            }
        L_0x0822:
            java.lang.String r0 = com.google.android.exoplayer2.util.Util.MODEL
            r0.hashCode()
            int r1 = r0.hashCode()
            switch(r1) {
                case -594534941: goto L_0x0844;
                case 2006354: goto L_0x0839;
                case 2006367: goto L_0x0830;
                default: goto L_0x082e;
            }
        L_0x082e:
            r6 = r7
            goto L_0x084e
        L_0x0830:
            java.lang.String r1 = "AFTN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x084e
            goto L_0x082e
        L_0x0839:
            java.lang.String r1 = "AFTA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0842
            goto L_0x082e
        L_0x0842:
            r6 = r9
            goto L_0x084e
        L_0x0844:
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x084d
            goto L_0x082e
        L_0x084d:
            r6 = r8
        L_0x084e:
            switch(r6) {
                case 0: goto L_0x0852;
                case 1: goto L_0x0852;
                case 2: goto L_0x0852;
                default: goto L_0x0851;
            }
        L_0x0851:
            goto L_0x0853
        L_0x0852:
            return r9
        L_0x0853:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0070, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ad, code lost:
        return (r7 * 3) / (r2 * 2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo r5, java.lang.String r6, int r7, int r8) {
        /*
            r0 = -1
            if (r7 == r0) goto L_0x00ae
            if (r8 != r0) goto L_0x0007
            goto L_0x00ae
        L_0x0007:
            r6.hashCode()
            int r1 = r6.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            switch(r1) {
                case -1851077871: goto L_0x005e;
                case -1664118616: goto L_0x0052;
                case -1662541442: goto L_0x0046;
                case 1187890754: goto L_0x003a;
                case 1331836730: goto L_0x002e;
                case 1599127256: goto L_0x0022;
                case 1599127257: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r6 = r0
            goto L_0x0069
        L_0x0016:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0020
            goto L_0x0014
        L_0x0020:
            r6 = 6
            goto L_0x0069
        L_0x0022:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x002c
            goto L_0x0014
        L_0x002c:
            r6 = 5
            goto L_0x0069
        L_0x002e:
            java.lang.String r1 = "video/avc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0038
            goto L_0x0014
        L_0x0038:
            r6 = r2
            goto L_0x0069
        L_0x003a:
            java.lang.String r1 = "video/mp4v-es"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0044
            goto L_0x0014
        L_0x0044:
            r6 = r3
            goto L_0x0069
        L_0x0046:
            java.lang.String r1 = "video/hevc"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0050
            goto L_0x0014
        L_0x0050:
            r6 = r4
            goto L_0x0069
        L_0x0052:
            java.lang.String r1 = "video/3gpp"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x005c
            goto L_0x0014
        L_0x005c:
            r6 = 1
            goto L_0x0069
        L_0x005e:
            java.lang.String r1 = "video/dolby-vision"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L_0x0068
            goto L_0x0014
        L_0x0068:
            r6 = 0
        L_0x0069:
            switch(r6) {
                case 0: goto L_0x0072;
                case 1: goto L_0x006f;
                case 2: goto L_0x006d;
                case 3: goto L_0x006f;
                case 4: goto L_0x0072;
                case 5: goto L_0x006f;
                case 6: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            return r0
        L_0x006d:
            int r7 = r7 * r8
            goto L_0x00aa
        L_0x006f:
            int r7 = r7 * r8
        L_0x0070:
            r2 = r4
            goto L_0x00aa
        L_0x0072:
            java.lang.String r6 = com.google.android.exoplayer2.util.Util.MODEL
            java.lang.String r1 = "BRAVIA 4K 2015"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x00ae
            java.lang.String r1 = com.google.android.exoplayer2.util.Util.MANUFACTURER
            java.lang.String r2 = "Amazon"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x009b
            java.lang.String r1 = "KFSOWI"
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x00ae
            java.lang.String r1 = "AFTS"
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto L_0x009b
            boolean r5 = r5.secure
            if (r5 == 0) goto L_0x009b
            goto L_0x00ae
        L_0x009b:
            r5 = 16
            int r6 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r7, (int) r5)
            int r7 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r8, (int) r5)
            int r6 = r6 * r7
            int r6 = r6 * r5
            int r7 = r6 * 16
            goto L_0x0070
        L_0x00aa:
            int r7 = r7 * r3
            int r2 = r2 * r4
            int r7 = r7 / r2
            return r7
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.getCodecMaxInputSize(com.google.android.exoplayer2.mediacodec.MediaCodecInfo, java.lang.String, int, int):int");
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int i11 = format.height;
        int i12 = format.width;
        boolean z11 = i11 > i12;
        int i13 = z11 ? i11 : i12;
        if (z11) {
            i11 = i12;
        }
        float f11 = ((float) i11) / ((float) i13);
        for (int i14 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i15 = (int) (((float) i14) * f11);
            if (i14 <= i13 || i15 <= i11) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i16 = z11 ? i15 : i14;
                if (!z11) {
                    i14 = i15;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i16, i14);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i14, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i15, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i17 = z11 ? ceilDivide2 : ceilDivide;
                        if (!z11) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i17, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    public static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height);
        }
        int size = format.initializationData.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += format.initializationData.get(i12).length;
        }
        return format.maxInputSize + i11;
    }

    private static boolean isBufferLate(long j11) {
        return j11 < -30000;
    }

    private static boolean isBufferVeryLate(long j11) {
        return j11 < -500000;
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i11 = this.videoFrameProcessingOffsetCount;
        if (i11 != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i11);
            this.totalVideoFrameProcessingOffsetUs = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private void maybeNotifyVideoSizeChanged() {
        int i11 = this.currentWidth;
        if (i11 != -1 || this.currentHeight != -1) {
            VideoSize videoSize = this.reportedVideoSize;
            if (videoSize == null || videoSize.width != i11 || videoSize.height != this.currentHeight || videoSize.unappliedRotationDegrees != this.currentUnappliedRotationDegrees || videoSize.pixelWidthHeightRatio != this.currentPixelWidthHeightRatio) {
                VideoSize videoSize2 = new VideoSize(this.currentWidth, this.currentHeight, this.currentUnappliedRotationDegrees, this.currentPixelWidthHeightRatio);
                this.reportedVideoSize = videoSize2;
                this.eventDispatcher.videoSizeChanged(videoSize2);
            }
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.surface);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void notifyFrameMetadataListener(long j11, long j12, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j11, j12, format, getCodecOutputMediaFormat());
        }
    }

    /* access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setOutput(java.lang.Object r5) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 == 0) goto L_0x0007
            android.view.Surface r5 = (android.view.Surface) r5
            goto L_0x0008
        L_0x0007:
            r5 = 0
        L_0x0008:
            if (r5 != 0) goto L_0x0026
            com.google.android.exoplayer2.video.DummySurface r0 = r4.dummySurface
            if (r0 == 0) goto L_0x0010
            r5 = r0
            goto L_0x0026
        L_0x0010:
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = r4.getCodecInfo()
            if (r0 == 0) goto L_0x0026
            boolean r1 = r4.shouldUseDummySurface(r0)
            if (r1 == 0) goto L_0x0026
            android.content.Context r5 = r4.context
            boolean r0 = r0.secure
            com.google.android.exoplayer2.video.DummySurface r5 = com.google.android.exoplayer2.video.DummySurface.newInstanceV17(r5, r0)
            r4.dummySurface = r5
        L_0x0026:
            android.view.Surface r0 = r4.surface
            if (r0 == r5) goto L_0x006e
            r4.surface = r5
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper r0 = r4.frameReleaseHelper
            r0.onSurfaceChanged(r5)
            r0 = 0
            r4.haveReportedFirstFrameRenderedForCurrentSurface = r0
            int r0 = r4.getState()
            com.google.android.exoplayer2.mediacodec.MediaCodecAdapter r1 = r4.getCodec()
            if (r1 == 0) goto L_0x0054
            int r2 = com.google.android.exoplayer2.util.Util.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x004e
            if (r5 == 0) goto L_0x004e
            boolean r2 = r4.codecNeedsSetOutputSurfaceWorkaround
            if (r2 != 0) goto L_0x004e
            r4.setOutputSurfaceV23(r1, r5)
            goto L_0x0054
        L_0x004e:
            r4.releaseCodec()
            r4.maybeInitCodecOrBypass()
        L_0x0054:
            if (r5 == 0) goto L_0x0067
            com.google.android.exoplayer2.video.DummySurface r1 = r4.dummySurface
            if (r5 == r1) goto L_0x0067
            r4.maybeRenotifyVideoSizeChanged()
            r4.clearRenderedFirstFrame()
            r5 = 2
            if (r0 != r5) goto L_0x007a
            r4.setJoiningDeadlineMs()
            goto L_0x007a
        L_0x0067:
            r4.clearReportedVideoSize()
            r4.clearRenderedFirstFrame()
            goto L_0x007a
        L_0x006e:
            if (r5 == 0) goto L_0x007a
            com.google.android.exoplayer2.video.DummySurface r0 = r4.dummySurface
            if (r5 == r0) goto L_0x007a
            r4.maybeRenotifyVideoSizeChanged()
            r4.maybeRenotifyRenderedFirstFrame()
        L_0x007a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.setOutput(java.lang.Object):void");
    }

    private boolean shouldUseDummySurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || DummySurface.isSecureSupported(this.context));
    }

    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i11;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i12 = canReuseCodec.discardReasons;
        int i13 = format2.width;
        CodecMaxValues codecMaxValues2 = this.codecMaxValues;
        if (i13 > codecMaxValues2.width || format2.height > codecMaxValues2.height) {
            i12 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i12 |= 64;
        }
        int i14 = i12;
        String str = mediaCodecInfo.name;
        if (i14 != 0) {
            i11 = 0;
        } else {
            i11 = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i11, i14);
    }

    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    public MediaCodecDecoderException createDecoderException(Throwable th2, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th2, mediaCodecInfo, this.surface);
    }

    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i11, long j11) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(1);
    }

    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i11 = format.width;
        int i12 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, format.width, format.height)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * 1.5f), codecMaxInputSize);
            }
            return new CodecMaxValues(i11, i12, maxInputSize);
        }
        int length = formatArr.length;
        boolean z11 = false;
        for (int i13 = 0; i13 < length; i13++) {
            Format format2 = formatArr[i13];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                int i14 = format2.width;
                z11 |= i14 == -1 || format2.height == -1;
                i11 = Math.max(i11, i14);
                i12 = Math.max(i12, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z11) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Resolutions unknown. Codec max resolution: ");
            sb2.append(i11);
            sb2.append("x");
            sb2.append(i12);
            Log.w(TAG, sb2.toString());
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i11 = Math.max(i11, codecMaxSize.x);
                i12 = Math.max(i12, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.sampleMimeType, i11, i12));
                StringBuilder sb3 = new StringBuilder(57);
                sb3.append("Codec max resolution adjusted to: ");
                sb3.append(i11);
                sb3.append("x");
                sb3.append(i12);
                Log.w(TAG, sb3.toString());
            }
        }
        return new CodecMaxValues(i11, i12, maxInputSize);
    }

    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    public float getCodecOperatingRateV23(float f11, Format format, Format[] formatArr) {
        float f12 = -1.0f;
        for (Format format2 : formatArr) {
            float f13 = format2.frameRate;
            if (f13 != -1.0f) {
                f12 = Math.max(f12, f13);
            }
        }
        if (f12 == -1.0f) {
            return -1.0f;
        }
        return f12 * f11;
    }

    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z11) throws MediaCodecUtil.DecoderQueryException {
        return getDecoderInfos(mediaCodecSelector, format, z11, this.tunneling);
    }

    @TargetApi(17)
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f11) {
        DummySurface dummySurface2 = this.dummySurface;
        if (!(dummySurface2 == null || dummySurface2.secure == mediaCodecInfo.secure)) {
            dummySurface2.release();
            this.dummySurface = null;
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues2, f11, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.surface == null) {
            if (shouldUseDummySurface(mediaCodecInfo)) {
                if (this.dummySurface == null) {
                    this.dummySurface = DummySurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.surface = this.dummySurface;
            } else {
                throw new IllegalStateException();
            }
        }
        return new MediaCodecAdapter.Configuration(mediaCodecInfo, mediaFormat, format, this.surface, mediaCrypto, 0);
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(21)
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f11, boolean z11, int i11) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, MediaUtils.KEY_ROTATION, format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f11 != -1.0f) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (z11) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i11 != 0) {
            configureTunnelingV21(mediaFormat, i11);
        }
        return mediaFormat;
    }

    public String getName() {
        return TAG;
    }

    public Surface getSurface() {
        return this.surface;
    }

    @TargetApi(29)
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 == -75 && s11 == 60 && s12 == 1 && b12 == 4 && b13 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    public void handleMessage(int i11, Object obj) throws ExoPlaybackException {
        if (i11 == 1) {
            setOutput(obj);
        } else if (i11 == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i11 == 6) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else if (i11 != 102) {
            super.handleMessage(i11, obj);
        } else {
            int intValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                }
            }
        }
    }

    public boolean isReady() {
        DummySurface dummySurface2;
        if (super.isReady() && (this.renderedFirstFrameAfterReset || (((dummySurface2 = this.dummySurface) != null && this.surface == dummySurface2) || getCodec() == null || this.tunneling))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        } else if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = -9223372036854775807L;
            return false;
        }
    }

    public boolean maybeDropBuffersToKeyframe(long j11, boolean z11) throws ExoPlaybackException {
        int skipSource = skipSource(j11);
        if (skipSource == 0) {
            return false;
        }
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedToKeyframeCount++;
        int i11 = this.buffersInCodecCount + skipSource;
        if (z11) {
            decoderCounters.skippedOutputBufferCount += i11;
        } else {
            updateDroppedBufferCounters(i11);
        }
        flushOrReinitializeCodec();
        return true;
    }

    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.surface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    public void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    public void onCodecInitialized(String str, long j11, long j12) {
        this.eventDispatcher.decoderInitialized(str, j11, j12);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
    }

    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.frameReleaseHelper.onDisabled();
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
        }
    }

    public void onEnabled(boolean z11, boolean z12) throws ExoPlaybackException {
        super.onEnabled(z11, z12);
        boolean z13 = getConfiguration().tunneling;
        Assertions.checkState(!z13 || this.tunnelingAudioSessionId != 0);
        if (this.tunneling != z13) {
            this.tunneling = z13;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.frameReleaseHelper.onEnabled();
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z12;
        this.renderedFirstFrameAfterEnable = false;
    }

    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int i11;
        int i12;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        if (this.tunneling) {
            this.currentWidth = format.width;
            this.currentHeight = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z11 = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z11) {
                i11 = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                i11 = mediaFormat.getInteger("width");
            }
            this.currentWidth = i11;
            if (z11) {
                i12 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                i12 = mediaFormat.getInteger("height");
            }
            this.currentHeight = i12;
        }
        float f11 = format.pixelWidthHeightRatio;
        this.currentPixelWidthHeightRatio = f11;
        if (Util.SDK_INT >= 21) {
            int i13 = format.rotationDegrees;
            if (i13 == 90 || i13 == 270) {
                int i14 = this.currentWidth;
                this.currentWidth = this.currentHeight;
                this.currentHeight = i14;
                this.currentPixelWidthHeightRatio = 1.0f / f11;
            }
        } else {
            this.currentUnappliedRotationDegrees = format.rotationDegrees;
        }
        this.frameReleaseHelper.onFormatChanged(format.frameRate);
    }

    public void onPositionReset(long j11, boolean z11) throws ExoPlaybackException {
        super.onPositionReset(j11, z11);
        clearRenderedFirstFrame();
        this.frameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (z11) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    public void onProcessedOutputBuffer(long j11) {
        super.onProcessedOutputBuffer(j11);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    public void onProcessedTunneledBuffer(long j11) throws ExoPlaybackException {
        updateOutputFormatForTime(j11);
        maybeNotifyVideoSizeChanged();
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j11);
    }

    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        boolean z11 = this.tunneling;
        if (!z11) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && z11) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    @TargetApi(17)
    public void onReset() {
        try {
            super.onReset();
            DummySurface dummySurface2 = this.dummySurface;
            if (dummySurface2 != null) {
                if (this.surface == dummySurface2) {
                    this.surface = null;
                }
                dummySurface2.release();
                this.dummySurface = null;
            }
        } catch (Throwable th2) {
            if (this.dummySurface != null) {
                Surface surface2 = this.surface;
                DummySurface dummySurface3 = this.dummySurface;
                if (surface2 == dummySurface3) {
                    this.surface = null;
                }
                dummySurface3.release();
                this.dummySurface = null;
            }
            throw th2;
        }
    }

    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    public boolean processOutputBuffer(long j11, long j12, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, Format format) throws ExoPlaybackException {
        long j14;
        boolean z13;
        long j15 = j11;
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i14 = i11;
        long j16 = j13;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j15;
        }
        if (j16 != this.lastBufferPresentationTimeUs) {
            this.frameReleaseHelper.onNextFrame(j16);
            this.lastBufferPresentationTimeUs = j16;
        }
        long outputStreamOffsetUs = getOutputStreamOffsetUs();
        long j17 = j16 - outputStreamOffsetUs;
        if (!z11 || z12) {
            double playbackSpeed = (double) getPlaybackSpeed();
            boolean z14 = getState() == 2;
            long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            long j18 = (long) (((double) (j16 - j15)) / playbackSpeed);
            if (z14) {
                j18 -= elapsedRealtime - j12;
            }
            if (this.surface != this.dummySurface) {
                long j19 = elapsedRealtime - this.lastRenderRealtimeUs;
                if (this.renderedFirstFrameAfterEnable ? this.renderedFirstFrameAfterReset : !z14 && !this.mayRenderFirstFrameAfterEnableIfNotStarted) {
                    j14 = j19;
                    z13 = false;
                } else {
                    z13 = true;
                    j14 = j19;
                }
                if (this.joiningDeadlineMs == -9223372036854775807L && j15 >= outputStreamOffsetUs && (z13 || (z14 && shouldForceRenderOutputBuffer(j18, j14)))) {
                    long nanoTime = System.nanoTime();
                    notifyFrameMetadataListener(j17, nanoTime, format);
                    if (Util.SDK_INT >= 21) {
                        renderOutputBufferV21(mediaCodecAdapter, i11, j17, nanoTime);
                    } else {
                        renderOutputBuffer(mediaCodecAdapter2, i14, j17);
                    }
                    updateVideoFrameProcessingOffsetCounters(j18);
                    return true;
                }
                if (z14 && j15 != this.initialPositionUs) {
                    long nanoTime2 = System.nanoTime();
                    long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((j18 * 1000) + nanoTime2);
                    long j21 = (adjustReleaseTime - nanoTime2) / 1000;
                    long j22 = j21;
                    boolean z15 = this.joiningDeadlineMs != -9223372036854775807L;
                    if (shouldDropBuffersToKeyframe(j21, j12, z12) && maybeDropBuffersToKeyframe(j15, z15)) {
                        return false;
                    }
                    if (shouldDropOutputBuffer(j22, j12, z12)) {
                        if (z15) {
                            skipOutputBuffer(mediaCodecAdapter2, i14, j17);
                        } else {
                            dropOutputBuffer(mediaCodecAdapter2, i14, j17);
                        }
                        updateVideoFrameProcessingOffsetCounters(j22);
                        return true;
                    }
                    long j23 = j22;
                    if (Util.SDK_INT >= 21) {
                        if (j23 < 50000) {
                            notifyFrameMetadataListener(j17, adjustReleaseTime, format);
                            renderOutputBufferV21(mediaCodecAdapter, i11, j17, adjustReleaseTime);
                            updateVideoFrameProcessingOffsetCounters(j23);
                            return true;
                        }
                    } else if (j23 < 30000) {
                        if (j23 > 11000) {
                            try {
                                Thread.sleep((j23 - 10000) / 1000);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                                return false;
                            }
                        }
                        notifyFrameMetadataListener(j17, adjustReleaseTime, format);
                        renderOutputBuffer(mediaCodecAdapter2, i14, j17);
                        updateVideoFrameProcessingOffsetCounters(j23);
                        return true;
                    }
                }
                return false;
            } else if (!isBufferLate(j18)) {
                return false;
            } else {
                skipOutputBuffer(mediaCodecAdapter2, i14, j17);
                updateVideoFrameProcessingOffsetCounters(j18);
                return true;
            }
        } else {
            skipOutputBuffer(mediaCodecAdapter2, i14, j17);
            return true;
        }
    }

    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i11, long j11) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, true);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i11, long j11, long j12) {
        maybeNotifyVideoSizeChanged();
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, j12);
        TraceUtil.endSection();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        maybeNotifyRenderedFirstFrame();
    }

    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface2) {
        mediaCodecAdapter.setOutputSurface(surface2);
    }

    public void setPlaybackSpeed(float f11, float f12) throws ExoPlaybackException {
        super.setPlaybackSpeed(f11, f12);
        this.frameReleaseHelper.onPlaybackSpeed(f11);
    }

    public boolean shouldDropBuffersToKeyframe(long j11, long j12, boolean z11) {
        return isBufferVeryLate(j11) && !z11;
    }

    public boolean shouldDropOutputBuffer(long j11, long j12, boolean z11) {
        return isBufferLate(j11) && !z11;
    }

    public boolean shouldForceRenderOutputBuffer(long j11, long j12) {
        return isBufferLate(j11) && j12 > IndexSeeker.MIN_TIME_BETWEEN_POINTS_US;
    }

    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.surface != null || shouldUseDummySurface(mediaCodecInfo);
    }

    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i11, long j11) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i11, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i11 = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return s0.a(0);
        }
        boolean z11 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(mediaCodecSelector, format, z11, false);
        if (z11 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return s0.a(1);
        }
        if (!MediaCodecRenderer.supportsFormatDrm(format)) {
            return s0.a(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        int i12 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(mediaCodecSelector, format, z11, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos2.get(0);
                if (mediaCodecInfo2.isFormatSupported(format) && mediaCodecInfo2.isSeamlessAdaptationSupported(format)) {
                    i11 = 32;
                }
            }
        }
        return s0.b(isFormatSupported ? 4 : 3, i12, i11);
    }

    public void updateDroppedBufferCounters(int i11) {
        DecoderCounters decoderCounters = this.decoderCounters;
        decoderCounters.droppedBufferCount += i11;
        this.droppedFrames += i11;
        int i12 = this.consecutiveDroppedFrameCount + i11;
        this.consecutiveDroppedFrameCount = i12;
        decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(i12, decoderCounters.maxConsecutiveDroppedBufferCount);
        int i13 = this.maxDroppedFramesToNotify;
        if (i13 > 0 && this.droppedFrames >= i13) {
            maybeNotifyDroppedFrames();
        }
    }

    public void updateVideoFrameProcessingOffsetCounters(long j11) {
        this.decoderCounters.addVideoFrameProcessingOffset(j11);
        this.totalVideoFrameProcessingOffsetUs += j11;
        this.videoFrameProcessingOffsetCount++;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j11) {
        this(context2, mediaCodecSelector, j11, (Handler) null, (VideoRendererEventListener) null, 0);
    }

    private static List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z11, boolean z12) throws MediaCodecUtil.DecoderQueryException {
        Pair<Integer, Integer> codecProfileAndLevel;
        String str = format.sampleMimeType;
        if (str == null) {
            return Collections.emptyList();
        }
        List<MediaCodecInfo> decoderInfosSortedByFormatSupport = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(mediaCodecSelector.getDecoderInfos(str, z11, z12), format);
        if ("video/dolby-vision".equals(str) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            int intValue = ((Integer) codecProfileAndLevel.first).intValue();
            if (intValue == 16 || intValue == 256) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/hevc", z11, z12));
            } else if (intValue == 512) {
                decoderInfosSortedByFormatSupport.addAll(mediaCodecSelector.getDecoderInfos("video/avc", z11, z12));
            }
        }
        return Collections.unmodifiableList(decoderInfosSortedByFormatSupport);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j11, Handler handler, VideoRendererEventListener videoRendererEventListener, int i11) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j11, false, handler, videoRendererEventListener, i11);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j11, boolean z11, Handler handler, VideoRendererEventListener videoRendererEventListener, int i11) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j11, z11, handler, videoRendererEventListener, i11);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j11, boolean z11, Handler handler, VideoRendererEventListener videoRendererEventListener, int i11) {
        super(2, factory, mediaCodecSelector, z11, 30.0f);
        this.allowedJoiningTimeMs = j11;
        this.maxDroppedFramesToNotify = i11;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.frameReleaseHelper = new VideoFrameReleaseHelper(applicationContext);
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.currentWidth = -1;
        this.currentHeight = -1;
        this.currentPixelWidthHeightRatio = -1.0f;
        this.scalingMode = 1;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
    }
}
