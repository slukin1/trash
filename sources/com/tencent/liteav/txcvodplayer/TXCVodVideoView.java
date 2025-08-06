package com.tencent.liteav.txcvodplayer;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.common.c;
import com.tencent.liteav.txcplayer.d;
import com.tencent.liteav.txcplayer.e;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import com.tencent.liteav.txcplayer.f;
import com.tencent.liteav.txcplayer.model.TXSubtitleRenderModel;
import com.tencent.liteav.txcvodplayer.renderer.SurfaceRenderView;
import com.tencent.liteav.txcvodplayer.renderer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.renderer.a;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TXCVodVideoView extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: ab  reason: collision with root package name */
    public static volatile boolean f21776ab = true;

    /* renamed from: ac  reason: collision with root package name */
    private static volatile boolean f21777ac = false;

    /* renamed from: l  reason: collision with root package name */
    public static volatile boolean f21778l = false;
    /* access modifiers changed from: private */
    public long A;
    private int B;
    /* access modifiers changed from: private */
    public boolean C = false;
    private Context D;
    /* access modifiers changed from: private */
    public Map<String, Object> E;
    /* access modifiers changed from: private */
    public com.tencent.liteav.txcvodplayer.renderer.a F;
    /* access modifiers changed from: private */
    public int G;
    /* access modifiers changed from: private */
    public int H;
    /* access modifiers changed from: private */
    public String I;
    /* access modifiers changed from: private */
    public float J = 1.0f;
    /* access modifiers changed from: private */
    public long K;
    /* access modifiers changed from: private */
    public long L;
    /* access modifiers changed from: private */
    public volatile boolean M = false;
    private int N = -1;
    private int O = 100;
    private float P = -100.0f;
    private boolean Q = false;
    private int R = -1000;
    private int S = -1;
    private int T = -1000;
    /* access modifiers changed from: private */
    public boolean U;
    /* access modifiers changed from: private */
    public ITXVCubePlayer.b V;
    private TXSubtitleRenderModel W;

    /* renamed from: a  reason: collision with root package name */
    public int f21779a = 0;
    /* access modifiers changed from: private */

    /* renamed from: aa  reason: collision with root package name */
    public ITXVCubePlayer.i f21780aa;

    /* renamed from: ad  reason: collision with root package name */
    private ITXVCubePlayer.d f21781ad = new ITXVCubePlayer.d() {
        public final void a() {
            int unused = TXCVodVideoView.this.f21779a = 5;
            int unused2 = TXCVodVideoView.this.f21791b = 5;
            TXCVodVideoView.this.a(2006, 0, "Playback completed");
        }
    };

    /* renamed from: ae  reason: collision with root package name */
    private ITXVCubePlayer.f f21782ae = new ITXVCubePlayer.f() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPVideoSeiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.String} */
        /* JADX WARNING: type inference failed for: r0v6 */
        /* JADX WARNING: type inference failed for: r0v20 */
        /* JADX WARNING: type inference failed for: r0v21 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(int r5, int r6, int r7, java.lang.Object r8) {
            /*
                r4 = this;
                r0 = 1006(0x3ee, float:1.41E-42)
                if (r5 == r0) goto L_0x025a
                r0 = 2007(0x7d7, float:2.812E-42)
                java.lang.String r1 = "TXCVodVideoView"
                if (r5 == r0) goto L_0x024d
                r0 = 2011(0x7db, float:2.818E-42)
                if (r5 == r0) goto L_0x01ea
                r0 = 2014(0x7de, float:2.822E-42)
                if (r5 == r0) goto L_0x018f
                r0 = 2020(0x7e4, float:2.83E-42)
                if (r5 == r0) goto L_0x014a
                r0 = 2026(0x7ea, float:2.839E-42)
                if (r5 == r0) goto L_0x013c
                r0 = 0
                r2 = 2030(0x7ee, float:2.845E-42)
                if (r5 == r2) goto L_0x0100
                r2 = 2002(0x7d2, float:2.805E-42)
                if (r5 == r2) goto L_0x00f7
                r2 = 2003(0x7d3, float:2.807E-42)
                if (r5 == r2) goto L_0x009b
                java.lang.String r2 = ",error:"
                switch(r5) {
                    case 2016: goto L_0x0060;
                    case 2017: goto L_0x0057;
                    case 2018: goto L_0x002e;
                    default: goto L_0x002c;
                }
            L_0x002c:
                goto L_0x0285
            L_0x002e:
                if (r8 == 0) goto L_0x0037
                boolean r7 = r8 instanceof java.lang.String
                if (r7 == 0) goto L_0x0037
                r0 = r8
                java.lang.String r0 = (java.lang.String) r0
            L_0x0037:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                java.lang.String r8 = "dns resolved url:"
                r7.<init>(r8)
                r7.append(r0)
                r7.append(r2)
                r7.append(r6)
                java.lang.String r7 = r7.toString()
                com.tencent.liteav.base.util.LiteavLog.i(r1, r7)
                if (r6 != 0) goto L_0x0285
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                r6.a((int) r5, 0, (java.lang.String) r7)
                goto L_0x0285
            L_0x0057:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r7 = "Video data received"
                r6.a((int) r5, 0, (java.lang.String) r7)
                goto L_0x0285
            L_0x0060:
                if (r8 == 0) goto L_0x006d
                boolean r0 = r8 instanceof java.lang.String
                if (r0 == 0) goto L_0x006d
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r0 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r8 = (java.lang.String) r8
                java.lang.String unused = r0.I = r8
            L_0x006d:
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r0 = "TCP Connect ServerIp:"
                r8.<init>(r0)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r0 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r0 = r0.I
                r8.append(r0)
                java.lang.String r0 = ",port:"
                r8.append(r0)
                r8.append(r6)
                r8.append(r2)
                r8.append(r7)
                java.lang.String r6 = r8.toString()
                com.tencent.liteav.base.util.LiteavLog.i(r1, r6)
                if (r7 != 0) goto L_0x0285
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r7 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                r7.a((int) r5, 0, (java.lang.String) r6)
                goto L_0x0285
            L_0x009b:
                java.lang.String r6 = "EVT_RENDER_FIRST_I_FRAME"
                com.tencent.liteav.base.util.LiteavLog.i(r1, r6)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                boolean r6 = r6.f21801m
                java.lang.String r7 = "VOD displayed the first frame"
                if (r6 == 0) goto L_0x00e2
                android.os.Bundle r6 = new android.os.Bundle
                r6.<init>()
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r8 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r8 = r8.f21802n
                boolean r8 = android.text.TextUtils.isEmpty(r8)
                java.lang.String r0 = "support_hevc"
                if (r8 != 0) goto L_0x00d7
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r8 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r8 = r8.f21802n
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r1 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcplayer.e r1 = r1.f21793d
                java.lang.String r1 = r1.f21743q
                boolean r8 = r8.equals(r1)
                if (r8 == 0) goto L_0x00d7
                java.lang.String r8 = "0"
                r6.putString(r0, r8)
                goto L_0x00dc
            L_0x00d7:
                java.lang.String r8 = "1"
                r6.putString(r0, r8)
            L_0x00dc:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r8 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                r8.a((int) r5, 0, (java.lang.String) r7, (android.os.Bundle) r6)
                goto L_0x00e7
            L_0x00e2:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                r6.a((int) r5, 0, (java.lang.String) r7)
            L_0x00e7:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                float r6 = r5.J
                r5.setRate(r6)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                boolean unused = r5.U = true
                goto L_0x0285
            L_0x00f7:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r7 = "hit cache"
                r6.a((int) r5, 0, (java.lang.String) r7)
                goto L_0x0285
            L_0x0100:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                boolean r5 = r5.f21798i
                r6 = 0
                if (r5 != 0) goto L_0x010a
                return r6
            L_0x010a:
                if (r8 == 0) goto L_0x0113
                boolean r5 = r8 instanceof com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg.TPVideoSeiInfo
                if (r5 == 0) goto L_0x0113
                r0 = r8
                com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPVideoSeiInfo r0 = (com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg.TPVideoSeiInfo) r0
            L_0x0113:
                if (r0 != 0) goto L_0x011b
                java.lang.String r5 = "VOD_PLAY_EVT_VIDEO_SEI, seiInfo is null"
                com.tencent.liteav.base.util.LiteavLog.e(r1, r5)
                return r6
            L_0x011b:
                android.os.Bundle r5 = new android.os.Bundle
                r5.<init>()
                int r6 = r0.videoSeiType
                java.lang.String r7 = "EVT_KEY_SEI_TYPE"
                r5.putInt(r7, r6)
                int r6 = r0.seiDataSize
                java.lang.String r7 = "EVT_KEY_SEI_SIZE"
                r5.putInt(r7, r6)
                byte[] r6 = r0.seiData
                java.lang.String r7 = "EVT_KEY_SEI_DATA"
                r5.putByteArray(r7, r6)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcvodplayer.TXCVodVideoView.a((com.tencent.liteav.txcvodplayer.TXCVodVideoView) r6, (int) r2, (android.os.Bundle) r5)
                goto L_0x0285
            L_0x013c:
                java.lang.String r6 = "EVT_AUDIO_JITTER_STATE_FIRST_PLAY"
                com.tencent.liteav.base.util.LiteavLog.i(r1, r6)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r7 = "Audio first play"
                r6.a((int) r5, 0, (java.lang.String) r7)
                goto L_0x0285
            L_0x014a:
                r5 = -1
                if (r8 == 0) goto L_0x0158
                boolean r2 = r8 instanceof java.lang.Long
                if (r2 == 0) goto L_0x0158
                java.lang.Long r8 = (java.lang.Long) r8
                long r5 = r8.longValue()
            L_0x0158:
                android.os.Bundle r8 = new android.os.Bundle
                r8.<init>()
                int r2 = (int) r5
                java.lang.String r3 = "EVT_KEY_SELECT_TRACK_INDEX"
                r8.putInt(r3, r2)
                java.lang.String r2 = "EVT_KEY_SELECT_TRACK_ERROR_CODE"
                r8.putInt(r2, r7)
                java.lang.String r2 = "description"
                java.lang.String r3 = "Select Track Complete"
                r8.putString(r2, r3)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = "VOD_PLAY_EVT_SELECT_TRACK_COMPLETE, trackIndex="
                r2.<init>(r3)
                r2.append(r5)
                java.lang.String r5 = " ,errorCode="
                r2.append(r5)
                r2.append(r7)
                java.lang.String r5 = r2.toString()
                com.tencent.liteav.base.util.LiteavLog.i(r1, r5)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcvodplayer.TXCVodVideoView.a((com.tencent.liteav.txcvodplayer.TXCVodVideoView) r5, (int) r0, (android.os.Bundle) r8)
                goto L_0x0285
            L_0x018f:
                java.lang.String r7 = java.lang.String.valueOf(r6)
                java.lang.String r8 = "EVT_VOD_PLAY_LOADING_END: eof "
                java.lang.String r7 = r8.concat(r7)
                com.tencent.liteav.base.util.LiteavLog.i(r1, r7)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r7 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r8 = "Buffer ended"
                r7.a((int) r5, 0, (java.lang.String) r8)
                if (r6 == 0) goto L_0x01bb
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcplayer.e r5 = r5.f21793d
                java.lang.String r5 = r5.f21743q
                boolean r6 = android.text.TextUtils.isEmpty(r5)
                if (r6 == 0) goto L_0x01bb
                java.lang.String r6 = "m3u8"
                boolean r5 = r5.endsWith(r6)
                if (r5 != 0) goto L_0x0285
            L_0x01bb:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int r5 = r5.f21791b
                r6 = 3
                if (r5 != r6) goto L_0x0285
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                r7 = 2004(0x7d4, float:2.808E-42)
                java.lang.String r8 = "Playback started"
                r5.a((int) r7, 0, (java.lang.String) r8)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int unused = r5.f21779a = r6
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                android.os.Handler r5 = r5.f21806r
                r6 = 100
                r5.sendEmptyMessage(r6)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                android.os.Handler r5 = r5.f21806r
                r6 = 103(0x67, float:1.44E-43)
                r5.sendEmptyMessage(r6)
                goto L_0x0285
            L_0x01ea:
                java.lang.String r5 = java.lang.String.valueOf(r6)
                java.lang.String r7 = "EVT_VIDEO_CHANGE_ROTATION: "
                java.lang.String r5 = r7.concat(r5)
                com.tencent.liteav.base.util.LiteavLog.i(r1, r5)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int unused = r5.f21813y = r6
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcplayer.e r5 = r5.f21793d
                boolean r5 = r5.A
                if (r5 == 0) goto L_0x022e
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int r5 = r5.f21813y
                if (r5 <= 0) goto L_0x022e
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int r6 = r5.f21813y
                int unused = r5.f21812x = r6
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcvodplayer.renderer.a r5 = r5.F
                if (r5 == 0) goto L_0x022e
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                com.tencent.liteav.txcvodplayer.renderer.a r5 = r5.F
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int r6 = r6.f21812x
                r5.setVideoRotation(r6)
            L_0x022e:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Video angle "
                r6.<init>(r7)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r7 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int r7 = r7.f21813y
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r7 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                int unused = r7.f21813y
                r5.a((int) r0, 0, (java.lang.String) r6)
                goto L_0x0285
            L_0x024d:
                java.lang.String r6 = "EVT_VIDEO_PLAY_LOADING"
                com.tencent.liteav.base.util.LiteavLog.i(r1, r6)
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r7 = "Buffer started"
                r6.a((int) r5, 0, (java.lang.String) r7)
                goto L_0x0285
            L_0x025a:
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r5 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this
                java.lang.String r5 = r5.I
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 == 0) goto L_0x0285
                if (r8 == 0) goto L_0x0285
                boolean r5 = r8 instanceof com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg.TPDownLoadProgressInfo
                if (r5 == 0) goto L_0x0285
                com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPDownLoadProgressInfo r8 = (com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg.TPDownLoadProgressInfo) r8
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0281 }
                java.lang.String r6 = r8.extraInfo     // Catch:{ Exception -> 0x0281 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0281 }
                com.tencent.liteav.txcvodplayer.TXCVodVideoView r6 = com.tencent.liteav.txcvodplayer.TXCVodVideoView.this     // Catch:{ Exception -> 0x0281 }
                java.lang.String r7 = "cdnip"
                java.lang.String r5 = r5.optString(r7)     // Catch:{ Exception -> 0x0281 }
                java.lang.String unused = r6.I = r5     // Catch:{ Exception -> 0x0281 }
                goto L_0x0285
            L_0x0281:
                r5 = move-exception
                r5.printStackTrace()
            L_0x0285:
                r5 = 1
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.TXCVodVideoView.AnonymousClass9.a(int, int, int, java.lang.Object):boolean");
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: af  reason: collision with root package name */
    public int f21783af;

    /* renamed from: ag  reason: collision with root package name */
    private ITXVCubePlayer.e f21784ag = new ITXVCubePlayer.e() {
        public final boolean a(int i11, int i12) {
            LiteavLog.e("TXCVodVideoView", "[onError] vodErrorEvent: " + i11 + " ,errorCode: " + i12);
            int unused = TXCVodVideoView.this.f21779a = -1;
            int unused2 = TXCVodVideoView.this.f21791b = -1;
            if (i11 != -6101) {
                if (i11 != -6004) {
                    switch (i11) {
                        case TXVodConstants.VOD_PLAY_ERR_PROCESS_VIDEO_FAIL /*-6010*/:
                        case TXVodConstants.VOD_PLAY_ERR_RENDER_FAIL /*-6009*/:
                        case TXVodConstants.VOD_PLAY_ERR_DECODE_SUBTITLE_FAIL /*-6008*/:
                        case TXVodConstants.VOD_PLAY_ERR_DECODE_AUDIO_FAIL /*-6007*/:
                            break;
                        case TXVodConstants.VOD_PLAY_ERR_DECODE_VIDEO_FAIL /*-6006*/:
                            TXCVodVideoView.A(TXCVodVideoView.this);
                            return true;
                        default:
                            switch (i11) {
                                case -2305:
                                    TXCVodVideoView.B(TXCVodVideoView.this);
                                    return true;
                                case -2304:
                                    TXCVodVideoView.z(TXCVodVideoView.this);
                                    return true;
                                case -2303:
                                    TXCVodVideoView.this.a(-2303, i12, "The file does not exist");
                                    TXCVodVideoView.this.a();
                                    return true;
                                default:
                                    long currentPosition = TXCVodVideoView.this.getCurrentPosition() - TXCVodVideoView.this.L;
                                    if (currentPosition < 0 || currentPosition > 500) {
                                        int unused3 = TXCVodVideoView.this.f21783af = 0;
                                    }
                                    TXCVodVideoView tXCVodVideoView = TXCVodVideoView.this;
                                    long unused4 = tXCVodVideoView.L = tXCVodVideoView.getCurrentPosition();
                                    if (((float) TXCVodVideoView.E(TXCVodVideoView.this)) >= ((float) TXCVodVideoView.this.f21793d.f21727a)) {
                                        TXCVodVideoView.this.a(-2301, i12, "Disconnected from the network. Playback error");
                                        TXCVodVideoView.this.a();
                                    } else if (TXCVodVideoView.this.f21806r != null) {
                                        TXCVodVideoView.this.f21806r.sendEmptyMessageDelayed(102, (long) (((float) TXCVodVideoView.this.f21793d.f21728b) * 1000.0f));
                                    }
                                    return true;
                            }
                    }
                }
                TXCVodVideoView.this.a(i11, i12, TXCVodVideoView.b(i11));
                TXCVodVideoView.this.a();
                return true;
            }
            if (TXCVodVideoView.this.E != null) {
                Object obj = TXCVodVideoView.this.E.get("TXC_DRM_SIMPLE_AES_URL");
                if ((obj instanceof String) && !TextUtils.isEmpty((String) obj)) {
                    TXCVodVideoView.this.E.put("TXC_DRM_KEY_URL", (Object) null);
                    TXCVodVideoView.this.E.put("TXC_DRM_PROVISION_URL", (Object) null);
                    if (!TXCVodVideoView.this.e()) {
                        TXCVodVideoView.this.a(false);
                    }
                    return true;
                }
            }
            TXCVodVideoView tXCVodVideoView2 = TXCVodVideoView.this;
            tXCVodVideoView2.a((int) TXVodConstants.VOD_PLAY_ERR_DRM, i12, "DRM play failed cause by " + i12 + InstructionFileId.DOT);
            return true;
        }
    };

    /* renamed from: ah  reason: collision with root package name */
    private ITXVCubePlayer.h f21785ah = new ITXVCubePlayer.h() {
        public final void a() {
            LiteavLog.v("TXCVodVideoView", "seek complete");
            boolean unused = TXCVodVideoView.this.M = false;
            TXCVodVideoView.this.a((int) TXVodConstants.VOD_PLAY_EVT_SEEK_COMPLETE, 0, "seek complete");
        }
    };

    /* renamed from: ai  reason: collision with root package name */
    private ITXVCubePlayer.i f21786ai = new ITXVCubePlayer.i() {
        public final void a(ITXVCubePlayer iTXVCubePlayer, TPSubtitleData tPSubtitleData) {
            if (TXCVodVideoView.this.f21798i && TXCVodVideoView.this.f21780aa != null) {
                TXCVodVideoView.this.f21780aa.a(iTXVCubePlayer, tPSubtitleData);
            }
        }
    };

    /* renamed from: aj  reason: collision with root package name */
    private ITXVCubePlayer.b f21787aj = new ITXVCubePlayer.b() {
        public final void a(ITXVCubePlayer iTXVCubePlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            if (tPSubtitleFrameBuffer != null && TXCVodVideoView.this.V != null) {
                TXCVodVideoView.this.V.a(iTXVCubePlayer, tPSubtitleFrameBuffer);
            }
        }
    };

    /* renamed from: ak  reason: collision with root package name */
    private int f21788ak = 0;
    /* access modifiers changed from: private */

    /* renamed from: al  reason: collision with root package name */
    public d f21789al;

    /* renamed from: am  reason: collision with root package name */
    private boolean f21790am = false;

    /* renamed from: b  reason: collision with root package name */
    public int f21791b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ITXVCubePlayer f21792c = null;

    /* renamed from: d  reason: collision with root package name */
    public e f21793d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f21794e = true;

    /* renamed from: f  reason: collision with root package name */
    public final int f21795f = 2;

    /* renamed from: g  reason: collision with root package name */
    public Object f21796g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<b> f21797h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21798i = false;

    /* renamed from: j  reason: collision with root package name */
    public List<Integer> f21799j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21800k = false;

    /* renamed from: m  reason: collision with root package name */
    public boolean f21801m = false;

    /* renamed from: n  reason: collision with root package name */
    public String f21802n;

    /* renamed from: o  reason: collision with root package name */
    public ITXVCubePlayer.j f21803o = new ITXVCubePlayer.j() {
        public final void a(ITXVCubePlayer iTXVCubePlayer, int i11, int i12, String str) {
            int i13 = i11;
            int i14 = i12;
            String str2 = str;
            boolean z11 = (TXCVodVideoView.this.f21809u != i14 && Math.abs(TXCVodVideoView.this.f21809u - i14) > 16) || (TXCVodVideoView.this.f21808t != i13 && Math.abs(TXCVodVideoView.this.f21808t - i13) > 16);
            int unused = TXCVodVideoView.this.f21808t = iTXVCubePlayer.getVideoWidth();
            int unused2 = TXCVodVideoView.this.f21809u = iTXVCubePlayer.getVideoHeight();
            int unused3 = TXCVodVideoView.this.G = iTXVCubePlayer.getVideoSarNum();
            int unused4 = TXCVodVideoView.this.H = iTXVCubePlayer.getVideoSarDen();
            long j11 = 2147483647L;
            ArrayList<com.tencent.liteav.txcplayer.model.a> supportedBitrates = TXCVodVideoView.this.getSupportedBitrates();
            if (supportedBitrates != null) {
                Iterator<com.tencent.liteav.txcplayer.model.a> it2 = supportedBitrates.iterator();
                while (it2.hasNext()) {
                    com.tencent.liteav.txcplayer.model.a next = it2.next();
                    long abs = (long) Math.abs((TXCVodVideoView.this.f21808t * TXCVodVideoView.this.f21809u) - (next.f21755b * next.f21756c));
                    if (abs < j11) {
                        long unused5 = TXCVodVideoView.this.K = ((long) next.f21755b) * ((long) next.f21756c);
                        j11 = abs;
                    }
                }
            }
            long propertyLong = TXCVodVideoView.this.f21792c.getPropertyLong(205);
            LiteavLog.i("TXCVodVideoView", "OnVideoSizeChangedListener width:" + TXCVodVideoView.this.f21808t + ":height:" + TXCVodVideoView.this.f21809u + ":SarNum:" + TXCVodVideoView.this.G + ":SarDen:" + TXCVodVideoView.this.H + ":videoRotationDegree:" + propertyLong);
            if (!(TXCVodVideoView.this.f21808t == 0 || TXCVodVideoView.this.f21809u == 0)) {
                if (TXCVodVideoView.this.F != null) {
                    TXCVodVideoView.this.F.a(TXCVodVideoView.this.f21808t, TXCVodVideoView.this.f21809u);
                    TXCVodVideoView.this.F.b(TXCVodVideoView.this.G, TXCVodVideoView.this.H);
                }
                TXCVodVideoView.this.requestLayout();
            }
            long j12 = propertyLong;
            if (z11) {
                Message message = new Message();
                message.what = 101;
                message.arg1 = 2009;
                Bundle bundle = new Bundle();
                Message message2 = message;
                bundle.putInt("EVT_PARAM1", TXCVodVideoView.this.f21808t);
                bundle.putInt("EVT_PARAM2", TXCVodVideoView.this.f21809u);
                if (TXCVodVideoView.this.C || str2 == null) {
                    bundle.putString("description", "Resolution change:" + TXCVodVideoView.this.f21808t + "*" + TXCVodVideoView.this.f21809u);
                } else {
                    String str3 = i13 + Constants.ACCEPT_TIME_SEPARATOR_SP + i14 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
                    bundle.putString("description", "Resolution change:" + TXCVodVideoView.this.f21808t + "*" + TXCVodVideoView.this.f21809u + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str3 + ")");
                    bundle.putString("EVT_PARAM3", str3);
                }
                bundle.putLong(TXVodConstants.EVT_KEY_VIDEO_ROTATION, j12);
                Message message3 = message2;
                message3.setData(bundle);
                if (TXCVodVideoView.this.f21806r != null) {
                    TXCVodVideoView.this.f21806r.sendMessage(message3);
                    return;
                }
                return;
            }
            long j13 = j12;
            String str4 = TXVodConstants.EVT_KEY_VIDEO_ROTATION;
            long j14 = j13;
            if (!TXCVodVideoView.this.C && str2 != null) {
                Message message4 = new Message();
                long j15 = j14;
                message4.what = 101;
                message4.arg1 = 2009;
                Bundle bundle2 = new Bundle();
                String str5 = i13 + Constants.ACCEPT_TIME_SEPARATOR_SP + i14 + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
                bundle2.putString("description", "Resolution change:" + TXCVodVideoView.this.f21808t + "*" + TXCVodVideoView.this.f21809u + " Crop(width,height,crop_left,crop_top,crop_right,crop_bottom):(" + str5 + ")");
                bundle2.putInt("EVT_PARAM1", TXCVodVideoView.this.f21808t);
                bundle2.putInt("EVT_PARAM2", TXCVodVideoView.this.f21809u);
                bundle2.putString("EVT_PARAM3", str5);
                bundle2.putLong(str4, j15);
                message4.setData(bundle2);
                if (TXCVodVideoView.this.f21806r != null) {
                    TXCVodVideoView.this.f21806r.sendMessage(message4);
                }
            }
        }
    };

    /* renamed from: p  reason: collision with root package name */
    public ITXVCubePlayer.g f21804p = new ITXVCubePlayer.g() {
        public final void a(ITXVCubePlayer iTXVCubePlayer) {
            if (RenderProcessService.getInstance().setSurfaceBufferSize(iTXVCubePlayer)) {
                LiteavLog.i("TXCVodVideoView", "setSurfaceBufferSize succeed");
            }
            if (c.a(LicenseChecker.a.PLAYER_PREMIUM)) {
                boolean unused = TXCVodVideoView.this.f21798i = true;
                LiteavLog.i("TXCVodVideoView", "has advanced license!");
            }
            if (TXCVodVideoView.this.f21798i) {
                boolean unused2 = TXCVodVideoView.this.f21800k = true;
            } else if (TXCVodVideoView.this.getInternalSubtitleTrackIndexes().size() > 0) {
                for (Integer intValue : TXCVodVideoView.this.f21799j) {
                    TXCVodVideoView.this.a(intValue.intValue());
                }
                boolean unused3 = TXCVodVideoView.this.f21800k = false;
            }
            if (TXCVodVideoView.this.f21779a == 1) {
                TXCVodVideoView.this.a(2013, 0, "VOD ready");
                if (!TXCVodVideoView.this.f21793d.f21742p) {
                    int unused4 = TXCVodVideoView.this.f21791b = 4;
                } else if (TXCVodVideoView.this.f21791b != 4) {
                    int unused5 = TXCVodVideoView.this.f21791b = 3;
                }
                int unused6 = TXCVodVideoView.this.f21779a = 2;
            }
            long unused7 = TXCVodVideoView.this.A = 0;
            if (TXCVodVideoView.this.f21779a == -1) {
                int unused8 = TXCVodVideoView.this.f21779a = 3;
                int unused9 = TXCVodVideoView.this.f21791b = 3;
            }
            int unused10 = TXCVodVideoView.this.f21808t = iTXVCubePlayer.getVideoWidth();
            int unused11 = TXCVodVideoView.this.f21809u = iTXVCubePlayer.getVideoHeight();
            if (!(TXCVodVideoView.this.f21808t == 0 || TXCVodVideoView.this.f21809u == 0 || TXCVodVideoView.this.F == null)) {
                TXCVodVideoView.this.F.a(TXCVodVideoView.this.f21808t, TXCVodVideoView.this.f21809u);
                TXCVodVideoView.this.F.b(TXCVodVideoView.this.G, TXCVodVideoView.this.H);
            }
            if (TXCVodVideoView.this.f21791b == 3) {
                TXCVodVideoView.this.b(false);
            }
        }
    };

    /* renamed from: q  reason: collision with root package name */
    public a.C0173a f21805q = new a.C0173a() {
        public final void a(a.b bVar, int i11, int i12) {
            if (bVar.a() != TXCVodVideoView.this.F) {
                LiteavLog.e("TXCVodVideoView", "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            LiteavLog.i("TXCVodVideoView", "onSurfaceChanged");
            int unused = TXCVodVideoView.this.f21810v = i11;
            int unused2 = TXCVodVideoView.this.f21811w = i12;
            boolean z11 = true;
            boolean z12 = TXCVodVideoView.this.f21791b == 3;
            if (TXCVodVideoView.this.F.a() && !(TXCVodVideoView.this.f21808t == i11 && TXCVodVideoView.this.f21809u == i12)) {
                z11 = false;
            }
            if (TXCVodVideoView.this.f21792c != null && z12 && z11 && TXCVodVideoView.this.f21791b == 3) {
                TXCVodVideoView.this.b(false);
            }
        }

        public final void b(a.b bVar) {
            if (bVar.a() != TXCVodVideoView.this.F) {
                LiteavLog.e("TXCVodVideoView", "onSurfaceDestroyed: unmatched render callback\n");
                return;
            }
            LiteavLog.i("TXCVodVideoView", "onSurfaceDestroyed");
            boolean unused = TXCVodVideoView.this.C = false;
            a.b unused2 = TXCVodVideoView.this.f21807s = null;
            if (TXCVodVideoView.this.f21792c != null) {
                TXCVodVideoView.this.f21792c.setSurface((Surface) null);
            }
            ITXVCubePlayer iTXVCubePlayer = TXCVodVideoView.this.f21792c;
            if (iTXVCubePlayer != null) {
                iTXVCubePlayer.setDisplay((SurfaceHolder) null);
            }
        }

        public final void a(a.b bVar) {
            if (bVar.a() != TXCVodVideoView.this.F) {
                LiteavLog.e("TXCVodVideoView", "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            LiteavLog.i("TXCVodVideoView", "onSurfaceCreated");
            boolean unused = TXCVodVideoView.this.C = true;
            a.b unused2 = TXCVodVideoView.this.f21807s = bVar;
            if (TXCVodVideoView.this.f21792c != null) {
                TXCVodVideoView.b(TXCVodVideoView.this.f21792c, bVar);
            } else {
                boolean unused3 = TXCVodVideoView.this.e();
            }
        }

        public final boolean a(MotionEvent motionEvent) {
            return RenderProcessService.getInstance().onTouchEvent(TXCVodVideoView.this.f21792c, motionEvent);
        }
    };

    /* renamed from: r  reason: collision with root package name */
    public Handler f21806r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public a.b f21807s = null;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f21808t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f21809u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f21810v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public int f21811w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public int f21812x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f21813y;

    /* renamed from: z  reason: collision with root package name */
    private long f21814z;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TXCVodVideoView> f21828a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21829b = 500;

        /* renamed from: c  reason: collision with root package name */
        private final String f21830c = "TXCVodeVideoView_Eventhandler";

        public a(TXCVodVideoView tXCVodVideoView, Looper looper) {
            super(looper);
            this.f21828a = new WeakReference<>(tXCVodVideoView);
        }

        private void a(TXCVodVideoView tXCVodVideoView, boolean z11) {
            if (tXCVodVideoView != null && tXCVodVideoView.f21789al != null) {
                long currentPosition = tXCVodVideoView.getCurrentPosition();
                Bundle bundle = new Bundle();
                long bufferDuration = tXCVodVideoView.getBufferDuration();
                long duration = (long) tXCVodVideoView.getDuration();
                if (z11) {
                    currentPosition = duration;
                }
                bundle.putInt("EVT_PLAY_PROGRESS", (int) (currentPosition / 1000));
                bundle.putInt("EVT_PLAY_DURATION", (int) (duration / 1000));
                bundle.putInt(TXVodConstants.EVT_PLAYABLE_DURATION, (int) (bufferDuration / 1000));
                bundle.putInt("EVT_PLAY_PROGRESS_MS", (int) currentPosition);
                bundle.putInt("EVT_PLAY_DURATION_MS", (int) duration);
                bundle.putInt("EVT_PLAYABLE_DURATION_MS", (int) bufferDuration);
                if (tXCVodVideoView.f21798i && tXCVodVideoView.f21792c != null) {
                    bundle.putLong(TXVodConstants.EVT_PLAY_PDT_TIME_MS, tXCVodVideoView.f21792c.getPdtTimeMs(currentPosition));
                }
                if (tXCVodVideoView.f21792c != null) {
                    bundle.putFloat("EVT_PLAYABLE_RATE", tXCVodVideoView.f21792c.getRate());
                }
                if (tXCVodVideoView.f21792c != null) {
                    if (tXCVodVideoView.f21793d.f21738l <= 0) {
                        tXCVodVideoView.f21793d.f21738l = 500;
                    }
                    removeMessages(103);
                    if (!z11) {
                        sendEmptyMessageDelayed(103, (long) tXCVodVideoView.f21793d.f21738l);
                    }
                }
                tXCVodVideoView.f21789al.a(2005, bundle);
            }
        }

        public final void handleMessage(Message message) {
            String str;
            Message message2 = message;
            TXCVodVideoView tXCVodVideoView = (TXCVodVideoView) this.f21828a.get();
            if (tXCVodVideoView != null && tXCVodVideoView.f21789al != null) {
                switch (message2.what) {
                    case 100:
                        float f11 = 0.0f;
                        if (tXCVodVideoView.f21792c != null) {
                            try {
                                float propertyLong = (float) tXCVodVideoView.f21792c.getPropertyLong(206);
                                long currentPosition = tXCVodVideoView.f21792c.getCurrentPosition();
                                long propertyLong2 = tXCVodVideoView.f21792c.getPropertyLong(208);
                                if (currentPosition > 0) {
                                    f11 = (float) ((propertyLong2 * 1000) / currentPosition);
                                }
                                long propertyLong3 = tXCVodVideoView.f21792c.getPropertyLong(302);
                                long propertyLong4 = tXCVodVideoView.f21792c.getPropertyLong(301);
                                long propertyLong5 = tXCVodVideoView.f21792c.getPropertyLong(303);
                                Bundle bundle = new Bundle();
                                long propertyLong6 = tXCVodVideoView.f21792c.getPropertyLong(202);
                                str = "TXCVodeVideoView_Eventhandler";
                                try {
                                    long propertyLong7 = tXCVodVideoView.f21792c.getPropertyLong(101);
                                    bundle.putLong("VIDEO_BITRATE", propertyLong6);
                                    bundle.putLong("AUDIO_BITRATE", propertyLong7);
                                    bundle.putFloat("fps", propertyLong);
                                    bundle.putFloat("dps", f11);
                                    bundle.putLong("cachedBytes", propertyLong3);
                                    bundle.putLong("bitRate", propertyLong4);
                                    bundle.putLong("tcpSpeed", propertyLong5);
                                    tXCVodVideoView.f21789al.a(bundle);
                                    removeMessages(100);
                                    sendEmptyMessageDelayed(100, 500);
                                    return;
                                } catch (Exception e11) {
                                    e = e11;
                                    LiteavLog.e(str, "MSG_UPDATE_NET_STATUS exception : " + e.getMessage());
                                    return;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                str = "TXCVodeVideoView_Eventhandler";
                                LiteavLog.e(str, "MSG_UPDATE_NET_STATUS exception : " + e.getMessage());
                                return;
                            }
                        } else {
                            return;
                        }
                    case 101:
                        int i11 = message2.arg1;
                        if (i11 == 2003) {
                            int unused = tXCVodVideoView.f21783af = 0;
                        } else if (i11 == 2006) {
                            a(tXCVodVideoView, true);
                        } else if (i11 == 2013) {
                            LiteavLog.i("TXCVodeVideoView_Eventhandler", "TXCVodVideoView handleMessage:MSG_PLAY_EVENT:EVT_VOD_PLAY_PREPARED");
                        } else if (i11 == 2019 && tXCVodVideoView.f21791b == 3 && tXCVodVideoView.f21779a != 3) {
                            int unused2 = tXCVodVideoView.f21779a = 3;
                            sendEmptyMessage(100);
                            sendEmptyMessage(103);
                        }
                        tXCVodVideoView.f21789al.a(i11, message.getData());
                        RenderProcessService.getInstance().sendPlayerEventToPlugin(tXCVodVideoView.f21792c, i11, message.getData());
                        return;
                    case 102:
                        tXCVodVideoView.d(true);
                        tXCVodVideoView.a(2103, 0, "VOD network reconnected");
                        return;
                    case 103:
                        a(tXCVodVideoView, false);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f21831a;

        /* renamed from: b  reason: collision with root package name */
        public String f21832b;

        /* renamed from: c  reason: collision with root package name */
        public String f21833c;

        public b(String str, String str2, String str3) {
            this.f21831a = str;
            this.f21832b = str2;
            this.f21833c = str3;
        }
    }

    public TXCVodVideoView(Context context) {
        super(context);
        a(context);
    }

    public static /* synthetic */ void A(TXCVodVideoView tXCVodVideoView) {
        LiteavLog.d("TXCVodVideoView", "onError onVideoDecoderError");
        if (tXCVodVideoView.f21779a != 4 && tXCVodVideoView.f21798i && !TextUtils.isEmpty(tXCVodVideoView.f21802n) && !tXCVodVideoView.f21793d.f21743q.equals(tXCVodVideoView.f21802n)) {
            tXCVodVideoView.f21793d.f21743q = tXCVodVideoView.f21802n;
            if (!tXCVodVideoView.e()) {
                tXCVodVideoView.a(false);
            }
        } else if (tXCVodVideoView.U || !tXCVodVideoView.f21793d.f21730d) {
            tXCVodVideoView.a((int) TXVodConstants.VOD_PLAY_ERR_DECODE_VIDEO_FAIL, 0, "VOD decoding failed");
        } else if (Math.min(tXCVodVideoView.f21809u, tXCVodVideoView.f21808t) < 1080) {
            e eVar = tXCVodVideoView.f21793d;
            if (eVar.f21730d) {
                eVar.f21730d = false;
                tXCVodVideoView.d(false);
            }
        }
    }

    public static /* synthetic */ void B(TXCVodVideoView tXCVodVideoView) {
        LiteavLog.e("TXCVodVideoView", "onHLSKeyError");
        tXCVodVideoView.a(-2305, 0, "HLS decypt key get failed");
        ITXVCubePlayer iTXVCubePlayer = tXCVodVideoView.f21792c;
        if (iTXVCubePlayer != null) {
            try {
                iTXVCubePlayer.stop();
            } catch (Exception e11) {
                LiteavLog.e("TXCVodVideoView", "onHLSKeyError stop Exception: " + e11.getMessage());
            }
            tXCVodVideoView.f21792c.release();
            tXCVodVideoView.f21792c = null;
        }
        tXCVodVideoView.f21779a = -1;
        tXCVodVideoView.f21791b = -1;
    }

    public static /* synthetic */ int E(TXCVodVideoView tXCVodVideoView) {
        int i11 = tXCVodVideoView.f21783af;
        tXCVodVideoView.f21783af = i11 + 1;
        return i11;
    }

    public static /* synthetic */ String b(int i11) {
        if (i11 == -6101) {
            return "PLAY_ERR_DRM";
        }
        switch (i11) {
            case TXVodConstants.VOD_PLAY_ERR_DOWNLOAD_FAIL /*-6011*/:
                return "DOWNLOAD_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_PROCESS_VIDEO_FAIL /*-6010*/:
                return "PROCESS_VIDEO_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_RENDER_FAIL /*-6009*/:
                return "RENDER_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_DECODE_SUBTITLE_FAIL /*-6008*/:
                return "DECODE_SUBTITLE_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_DECODE_AUDIO_FAIL /*-6007*/:
                return "DECODE_AUDIO_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_DECODE_VIDEO_FAIL /*-6006*/:
                return "DECODE_VIDEO_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_DEMUXER_TIMEOUT /*-6005*/:
                return "DEMUXER_TIMEOUT";
            case TXVodConstants.VOD_PLAY_ERR_SYSTEM_PLAY_FAIL /*-6004*/:
                return "SYSTEM_PLAY_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_DEMUXER_FAIL /*-6003*/:
                return "DEMUXER_FAIL";
            case TXVodConstants.VOD_PLAY_ERR_GENERAL /*-6002*/:
                return "ERR_GENERAL";
            default:
                return "ERR_UNKNOW";
        }
    }

    /* access modifiers changed from: private */
    public List<Integer> getInternalSubtitleTrackIndexes() {
        this.f21799j = new ArrayList();
        TPTrackInfo[] trackInfo = getTrackInfo();
        if (trackInfo == null) {
            return this.f21799j;
        }
        for (int i11 = 0; i11 < trackInfo.length; i11++) {
            if (trackInfo[i11].trackType == 3 && trackInfo[i11].isInternal) {
                this.f21799j.add(Integer.valueOf(i11));
            }
        }
        return this.f21799j;
    }

    public static /* synthetic */ void z(TXCVodVideoView tXCVodVideoView) {
        LiteavLog.d("TXCVodVideoView", "onHevcVideoDecoderError");
        f21777ac = true;
        if (!tXCVodVideoView.f21798i || TextUtils.isEmpty(tXCVodVideoView.f21802n) || tXCVodVideoView.f21793d.f21743q.equals(tXCVodVideoView.f21802n)) {
            tXCVodVideoView.a(-2304, 0, "Vod H265 decoding failed");
            return;
        }
        tXCVodVideoView.f21793d.f21743q = tXCVodVideoView.f21802n;
        if (!tXCVodVideoView.e()) {
            tXCVodVideoView.a(false);
        }
    }

    public int getBitrateIndex() {
        int i11 = this.R;
        if (i11 == -1) {
            return i11;
        }
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            this.R = iTXVCubePlayer.getBitrateIndex();
        }
        return this.R;
    }

    public long getBufferDuration() {
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer == null) {
            return 0;
        }
        long playableDurationMs = iTXVCubePlayer.getPlayableDurationMs();
        long currentPosition = getCurrentPosition();
        if (this.f21779a == 3) {
            this.f21814z = currentPosition;
        }
        if (playableDurationMs < currentPosition) {
            playableDurationMs = currentPosition;
        }
        return Math.abs(((long) getDuration()) - playableDurationMs) < 1000 ? (long) getDuration() : playableDurationMs;
    }

    public long getCurrentPosition() {
        int i11;
        if (this.M && (i11 = this.N) >= 0) {
            return (long) i11;
        }
        long j11 = this.A;
        if (j11 <= 0) {
            ITXVCubePlayer iTXVCubePlayer = this.f21792c;
            j11 = iTXVCubePlayer != null ? iTXVCubePlayer.getCurrentPosition() : 0;
        }
        if (this.f21793d.f21735i) {
            return j11;
        }
        int i12 = this.N;
        return j11 < ((long) i12) ? (long) i12 : j11;
    }

    public int getDuration() {
        int duration;
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null && (duration = (int) iTXVCubePlayer.getDuration()) > 0) {
            this.B = duration;
        }
        return this.B;
    }

    public com.tencent.liteav.txcplayer.model.b getMediaInfo() {
        try {
            ITXVCubePlayer iTXVCubePlayer = this.f21792c;
            if (iTXVCubePlayer == null) {
                return null;
            }
            return iTXVCubePlayer.getMediaInfo();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public int getMetaRotationDegree() {
        return this.f21813y;
    }

    public int getPlayerType() {
        return 2;
    }

    public String getServerIp() {
        return this.I;
    }

    public ArrayList<com.tencent.liteav.txcplayer.model.a> getSupportedBitrates() {
        try {
            ITXVCubePlayer iTXVCubePlayer = this.f21792c;
            if (iTXVCubePlayer != null) {
                return iTXVCubePlayer.getSupportedBitrates();
            }
            return new ArrayList<>();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return new ArrayList<>();
        }
    }

    public TPTrackInfo[] getTrackInfo() {
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            return iTXVCubePlayer.getTrackInfo();
        }
        return null;
    }

    public String getUrlPathExtention() {
        String str = this.f21793d.f21743q;
        return !TextUtils.isEmpty(str) ? str.substring(str.lastIndexOf(InstructionFileId.DOT) + 1, str.length()) : "";
    }

    public int getVideoHeight() {
        return this.f21809u;
    }

    public int getVideoRotationDegree() {
        return this.f21812x;
    }

    public int getVideoWidth() {
        return this.f21808t;
    }

    public void setAudioNormalization(float f11) {
        if (c.a(LicenseChecker.a.PLAYER_PREMIUM)) {
            float f12 = this.P;
            if (f12 != f11) {
                boolean z11 = false;
                boolean z12 = f12 == 1.0f;
                this.P = f11;
                LiteavLog.i("TXCVodVideoView", "setAudioNormalization ".concat(String.valueOf(f11)));
                ITXVCubePlayer iTXVCubePlayer = this.f21792c;
                if (iTXVCubePlayer != null) {
                    iTXVCubePlayer.setAudioNormalization(f11);
                    if (!z12 && this.A == 0) {
                        long currentPosition = this.f21792c.getCurrentPosition();
                        if (currentPosition > 0) {
                            ITXVCubePlayer iTXVCubePlayer2 = this.f21792c;
                            e eVar = this.f21793d;
                            if (eVar != null) {
                                z11 = eVar.f21735i;
                            }
                            iTXVCubePlayer2.seekTo(currentPosition, z11);
                        }
                    }
                }
            }
        }
    }

    public void setAudioPlayoutVolume(int i11) {
        if (i11 > 0) {
            this.O = i11;
        }
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setAudioVolume(i11);
        }
    }

    public void setAutoPlay(boolean z11) {
        this.f21793d.f21742p = z11;
    }

    public void setBitrateIndex(int i11) {
        LiteavLog.i("TXCVodVideoView", "setBitrateIndex " + i11 + " vod=" + hashCode());
        if (getBitrateIndex() != i11 && i11 != -1000) {
            this.R = i11;
            if (this.f21779a != 5) {
                try {
                    ArrayList<com.tencent.liteav.txcplayer.model.a> supportedBitrates = getSupportedBitrates();
                    if (supportedBitrates != null && supportedBitrates.size() > 0 && i11 != -1) {
                        Iterator<com.tencent.liteav.txcplayer.model.a> it2 = supportedBitrates.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                com.tencent.liteav.txcplayer.model.a next = it2.next();
                                if (next != null && next.f21754a == i11) {
                                    this.S = next.f21757d;
                                    this.T = i11;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    ITXVCubePlayer iTXVCubePlayer = this.f21792c;
                    if (iTXVCubePlayer == null) {
                        return;
                    }
                    if (!this.f21793d.f21736j || i11 == -1 || iTXVCubePlayer.getBitrateIndex() == -1) {
                        d(false);
                    } else {
                        this.f21792c.setBitrateIndex(i11);
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    public void setConfig(e eVar) {
        e eVar2 = this.f21793d;
        String str = eVar2 != null ? eVar2.f21743q : null;
        if (eVar != null) {
            this.f21793d = eVar;
            if (!TextUtils.isEmpty(str)) {
                this.f21793d.f21743q = str;
            }
        }
    }

    public void setListener(d dVar) {
        this.f21789al = dVar;
    }

    public void setMute(boolean z11) {
        this.Q = z11;
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            if (z11) {
                iTXVCubePlayer.setAudioVolume(0);
            } else {
                iTXVCubePlayer.setAudioVolume(this.O);
            }
        }
    }

    public void setPlayerType(int i11) {
    }

    public void setPrivateConfig(Map<String, Object> map) {
        this.E = map;
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setPrivateConfig(map);
        }
    }

    public void setRate(float f11) {
        LiteavLog.i("TXCVodVideoView", "setRate ".concat(String.valueOf(f11)));
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setRate(f11);
        }
        this.J = f11;
    }

    public void setRender(int i11) {
        if (i11 == 0) {
            setRenderView((com.tencent.liteav.txcvodplayer.renderer.a) null);
        } else if (i11 == 1) {
            setRenderView(new SurfaceRenderView(this.D));
        } else if (i11 != 2) {
            LiteavLog.e("TXCVodVideoView", String.format(Locale.getDefault(), "invalid render %d\n", new Object[]{Integer.valueOf(i11)}));
        } else {
            TextureRenderView textureRenderView = new TextureRenderView(this.D);
            if (this.f21792c != null) {
                textureRenderView.getSurfaceHolder().a(this.f21792c);
                textureRenderView.a(this.f21792c.getVideoWidth(), this.f21792c.getVideoHeight());
                textureRenderView.b(this.f21792c.getVideoSarNum(), this.f21792c.getVideoSarDen());
                textureRenderView.setAspectRatio(this.f21788ak);
            }
            setRenderView(textureRenderView);
        }
    }

    public void setRenderMode(int i11) {
        this.f21788ak = i11;
        com.tencent.liteav.txcvodplayer.renderer.a aVar = this.F;
        if (aVar != null) {
            aVar.setAspectRatio(i11);
        }
        com.tencent.liteav.txcvodplayer.renderer.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.setVideoRotation(this.f21812x);
        }
    }

    public void setRenderSurface(final Surface surface) {
        AnonymousClass1 r02 = new a.b() {
            public final void a(ITXVCubePlayer iTXVCubePlayer) {
                iTXVCubePlayer.setSurface(surface);
            }

            public final Surface b() {
                return null;
            }

            public final Surface c() {
                return surface;
            }

            public final com.tencent.liteav.txcvodplayer.renderer.a a() {
                return TXCVodVideoView.this.F;
            }
        };
        this.f21807s = r02;
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            b(iTXVCubePlayer, (a.b) r02);
        }
    }

    public void setRenderView(com.tencent.liteav.txcvodplayer.renderer.a aVar) {
        int i11;
        int i12;
        LiteavLog.i("TXCVodVideoView", "setRenderView ".concat(String.valueOf(aVar)));
        if (this.F != null) {
            ITXVCubePlayer iTXVCubePlayer = this.f21792c;
            if (iTXVCubePlayer != null) {
                iTXVCubePlayer.setDisplay((SurfaceHolder) null);
            }
            View view = this.F.getView();
            this.F.b(this.f21805q);
            this.F = null;
            if (view.getParent() == this) {
                removeView(view);
            }
        }
        if (aVar != null) {
            this.F = aVar;
            aVar.setAspectRatio(this.f21788ak);
            int i13 = this.f21808t;
            if (i13 > 0 && (i12 = this.f21809u) > 0) {
                aVar.a(i13, i12);
            }
            int i14 = this.G;
            if (i14 > 0 && (i11 = this.H) > 0) {
                aVar.b(i14, i11);
            }
            View view2 = this.F.getView();
            view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            if (view2.getParent() == null) {
                addView(view2);
            }
            this.F.a(this.f21805q);
            this.F.setVideoRotation(this.f21812x);
        }
    }

    public void setStartTime(float f11) {
        this.A = (long) (f11 * 1000.0f);
    }

    public void setSubtitleStyle(TXSubtitleRenderModel tXSubtitleRenderModel) {
        this.W = tXSubtitleRenderModel;
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setSubtitleStyle(tXSubtitleRenderModel);
        }
    }

    public void setTXCOnSubtitleDataListener(ITXVCubePlayer.i iVar) {
        this.f21780aa = iVar;
    }

    public void setTXCOnSubtitleFrameDataListener(ITXVCubePlayer.b bVar) {
        this.V = bVar;
    }

    public void setTextureRenderView(TextureRenderView textureRenderView) {
        LiteavLog.i("TXCVodVideoView", "setTextureRenderView ".concat(String.valueOf(textureRenderView)));
        if (this.f21792c != null) {
            textureRenderView.getSurfaceHolder().a(this.f21792c);
            textureRenderView.a(this.f21792c.getVideoWidth(), this.f21792c.getVideoHeight());
            textureRenderView.b(this.f21792c.getVideoSarNum(), this.f21792c.getVideoSarDen());
            textureRenderView.setAspectRatio(this.f21788ak);
        }
        setRenderView(textureRenderView);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoRotationDegree(int i11) {
        if (!(i11 == 0 || i11 == 90 || i11 == 180 || i11 == 270)) {
            if (i11 != 360) {
                LiteavLog.e("TXCVodVideoView", "not support degree ".concat(String.valueOf(i11)));
                return;
            }
            i11 = 0;
        }
        this.f21812x = i11;
        com.tencent.liteav.txcvodplayer.renderer.a aVar = this.F;
        if (aVar != null) {
            aVar.setVideoRotation(i11);
        }
        com.tencent.liteav.txcvodplayer.renderer.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.setAspectRatio(this.f21788ak);
        }
    }

    public void setVideoURI(Uri uri) {
        if (uri != null) {
            this.f21793d.f21743q = uri.toString();
            if (this.f21798i && this.f21801m && !TextUtils.isEmpty(this.f21802n) && !f21776ab && f21777ac) {
                this.f21793d.f21743q = this.f21802n;
            }
        }
        this.B = 0;
        this.N = -1;
        this.f21783af = 0;
        this.I = null;
        LiteavLog.i("TXCVodVideoView", "setVideoURI ".concat(String.valueOf(uri)));
        e();
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: private */
    public boolean e() {
        LiteavLog.i("TXCVodVideoView", "openVideo vod=" + hashCode());
        if (TextUtils.isEmpty(this.f21793d.f21743q)) {
            return false;
        }
        a(false);
        if (this.f21794e) {
            ((AudioManager) this.D.getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 2);
        }
        try {
            ITXVCubePlayer a11 = f.a(this.D);
            this.f21792c = a11;
            Object obj = this.f21796g;
            if (!(obj == null || a11 == null)) {
                a11.attachTRTC(obj);
            }
            e eVar = this.f21793d;
            String str = eVar.f21743q;
            eVar.f21741o = this.A;
            int i11 = this.T;
            if (i11 >= 0) {
                eVar.f21745s = i11;
            }
            int i12 = this.S;
            if (i12 >= 0) {
                eVar.f21744r = i12;
            }
            long j11 = this.K;
            if (j11 > 0) {
                eVar.f21746t = j11;
            }
            int i13 = this.R;
            if (i13 == -1) {
                eVar.f21751y = true;
                this.f21792c.enableAdaptiveBitrate();
            } else {
                eVar.f21751y = false;
                this.f21792c.setBitrateIndex(i13);
            }
            this.f21792c.setPrivateConfig(this.E);
            this.f21792c.setConfig(this.f21793d);
            if (this.f21793d.f21734h != null) {
                this.f21792c.setDataSource(this.D, Uri.parse(str), this.f21793d.f21734h);
            } else {
                this.f21792c.setDataSource(str);
            }
            List<b> list = this.f21797h;
            if (list != null && !list.isEmpty()) {
                for (b next : this.f21797h) {
                    this.f21792c.addSubtitleSource(next.f21831a, next.f21832b, next.f21833c);
                }
            }
            TXSubtitleRenderModel tXSubtitleRenderModel = this.W;
            if (tXSubtitleRenderModel != null) {
                this.f21792c.setSubtitleStyle(tXSubtitleRenderModel);
            }
            this.f21792c.setOnPreparedListener(this.f21804p);
            this.f21792c.setOnVideoSizeChangedListener(this.f21803o);
            this.f21792c.setOnCompletionListener(this.f21781ad);
            this.f21792c.setOnErrorListener(this.f21784ag);
            this.f21792c.setOnInfoListener(this.f21782ae);
            this.f21792c.setOnSeekCompleteListener(this.f21785ah);
            this.f21792c.setOnSubtitleDataListener(this.f21786ai);
            this.f21792c.setOnGetTXCVodVideoViewTargetState(new ITXVCubePlayer.a() {
                public final int a() {
                    return TXCVodVideoView.this.f21791b;
                }
            });
            this.f21792c.setOnSubtitleFrameDataListener(this.f21787aj);
            b(this.f21792c, this.f21807s);
            this.f21792c.setAudioStreamType(3);
            this.f21792c.setScreenOnWhilePlaying(true);
            this.f21792c.prepareAsync();
            this.f21792c.setAudioVolume(this.O);
            float f11 = this.P;
            if (f11 != -100.0f) {
                this.f21792c.setAudioNormalization(f11);
            }
            setMute(this.Q);
            this.f21779a = 1;
        } catch (FileNotFoundException unused) {
            this.f21779a = -1;
            this.f21791b = -1;
            this.f21784ag.a(-2303, -2303);
        } catch (Exception e11) {
            LiteavLog.w("TXCVodVideoView", Log.getStackTraceString(e11));
            this.f21779a = -1;
            this.f21791b = -1;
            this.f21784ag.a(TXVodConstants.VOD_PLAY_ERR_UNKNOW, 0);
        }
        return true;
    }

    private void f() {
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.setOnPreparedListener((ITXVCubePlayer.g) null);
            this.f21792c.setOnVideoSizeChangedListener((ITXVCubePlayer.j) null);
            this.f21792c.setOnCompletionListener((ITXVCubePlayer.d) null);
            this.f21792c.setOnErrorListener((ITXVCubePlayer.e) null);
            this.f21792c.setOnInfoListener((ITXVCubePlayer.f) null);
            this.f21792c.setOnBufferingUpdateListener((ITXVCubePlayer.c) null);
            this.f21792c.setOnSeekCompleteListener((ITXVCubePlayer.h) null);
            this.f21792c.setOnSubtitleDataListener((ITXVCubePlayer.i) null);
            this.f21792c.setOnGetTXCVodVideoViewTargetState((ITXVCubePlayer.a) null);
            this.f21792c.setOnSubtitleFrameDataListener((ITXVCubePlayer.b) null);
        }
    }

    public final boolean c(boolean z11) {
        if (this.f21779a != 0) {
            return false;
        }
        this.f21794e = z11;
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(boolean r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "replay, isFromErrorState = "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r1 = " vod="
            r0.append(r1)
            int r1 = r4.hashCode()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TXCVodVideoView"
            com.tencent.liteav.base.util.LiteavLog.i(r1, r0)
            r0 = 0
            if (r5 == 0) goto L_0x0037
            long r2 = r4.f21814z
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0037
            r4.A = r2
            boolean r5 = r4.M
            if (r5 == 0) goto L_0x0063
            int r5 = r4.N
            if (r5 < 0) goto L_0x0063
            long r0 = (long) r5
            r4.A = r0
            goto L_0x0063
        L_0x0037:
            long r2 = r4.A
            int r5 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0058
            com.tencent.liteav.txcplayer.ITXVCubePlayer r5 = r4.f21792c
            if (r5 == 0) goto L_0x0058
            int r0 = r4.B
            if (r0 <= 0) goto L_0x0063
            long r0 = r5.getCurrentPosition()
            int r5 = (int) r0
            long r0 = (long) r5
            r4.A = r0
            int r5 = r4.N
            long r2 = (long) r5
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0063
            long r0 = (long) r5
            r4.A = r0
            goto L_0x0063
        L_0x0058:
            boolean r5 = r4.M
            if (r5 == 0) goto L_0x0063
            int r5 = r4.N
            if (r5 < 0) goto L_0x0063
            long r0 = (long) r5
            r4.A = r0
        L_0x0063:
            boolean r5 = r4.e()
            if (r5 != 0) goto L_0x006d
            r5 = 0
            r4.a((boolean) r5)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.TXCVodVideoView.d(boolean):void");
    }

    /* access modifiers changed from: private */
    public static void b(ITXVCubePlayer iTXVCubePlayer, a.b bVar) {
        if (iTXVCubePlayer != null) {
            if (bVar == null) {
                iTXVCubePlayer.setDisplay((SurfaceHolder) null);
                return;
            }
            LiteavLog.i("TXCVodVideoView", "bindSurfaceHolder");
            Surface c11 = bVar.c();
            if (c11 == null) {
                c11 = bVar.b();
            }
            if (!RenderProcessService.getInstance().connectPlayer(iTXVCubePlayer, c11)) {
                bVar.a(iTXVCubePlayer);
            }
        }
    }

    public final void c() {
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.publishAudioToNetwork();
        }
    }

    private void a(Context context) {
        this.D = context.getApplicationContext();
        this.f21793d = new e();
        setRender(0);
        this.f21808t = 0;
        this.f21809u = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f21779a = 0;
        this.f21791b = 0;
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.f21806r = new a(this, mainLooper);
        } else {
            this.f21806r = null;
        }
    }

    public final void b(boolean z11) {
        LiteavLog.i("TXCVodVideoView", "start vod=" + hashCode());
        if (b()) {
            try {
                if (this.f21779a != 3 && !this.M) {
                    this.f21779a = 3;
                    if (!z11) {
                        a(2004, 0, "Playback started");
                    }
                    Handler handler = this.f21806r;
                    if (handler != null) {
                        handler.sendEmptyMessage(100);
                        this.f21806r.sendEmptyMessage(103);
                    }
                }
                this.f21792c.start();
            } catch (Exception e11) {
                LiteavLog.e("TXCVodVideoView", "start exception: " + e11.getMessage());
            }
        }
        this.f21791b = 3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.f21779a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b() {
        /*
            r2 = this;
            com.tencent.liteav.txcplayer.ITXVCubePlayer r0 = r2.f21792c
            if (r0 == 0) goto L_0x000f
            int r0 = r2.f21779a
            r1 = -1
            if (r0 == r1) goto L_0x000f
            if (r0 == 0) goto L_0x000f
            r1 = 1
            if (r0 == r1) goto L_0x000f
            return r1
        L_0x000f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.TXCVodVideoView.b():boolean");
    }

    public final void a(boolean z11) {
        if (this.f21792c != null) {
            LiteavLog.i("TXCVodVideoView", "release player " + this.f21792c);
            a(this.f21792c);
            this.f21792c.release();
            f();
            this.f21792c = null;
            this.f21779a = 0;
            this.M = false;
            this.N = -1;
            if (z11) {
                this.f21791b = 0;
                this.f21808t = 0;
                this.f21809u = 0;
                this.J = 1.0f;
                this.U = false;
                this.R = -1000;
                this.S = -1;
                this.T = -1000;
                List<b> list = this.f21797h;
                if (list != null) {
                    list.clear();
                }
                this.f21814z = 0;
            }
            if (this.f21794e && LiteavSystemInfo.getSystemOSVersionInt() >= 8) {
                ((AudioManager) this.D.getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
            this.M = false;
            this.N = -1;
        }
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a() {
        Handler handler = this.f21806r;
        if (handler != null) {
            handler.removeMessages(102);
            this.f21806r.removeMessages(100);
            this.f21806r.removeMessages(103);
        }
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            try {
                iTXVCubePlayer.stop();
                this.f21793d.f21743q = null;
                a(true);
            } catch (Exception e11) {
                LiteavLog.e("TXCVodVideoView", "stop exception: " + e11.getMessage());
            }
        }
        LiteavLog.i("TXCVodVideoView", "stop vod=" + hashCode());
    }

    public final void a(int i11, boolean z11) {
        LiteavLog.i("TXCVodVideoView", "seek to " + i11 + ", isAccurateSeek=" + z11 + ", vod=" + hashCode());
        int min = Math.min(i11, getDuration());
        if (min >= 0 && b()) {
            try {
                this.N = min;
                this.f21792c.seekTo((long) min, z11);
                this.M = true;
                if (this.f21779a == 5) {
                    this.f21791b = 3;
                }
            } catch (Exception e11) {
                LiteavLog.e("TXCVodVideoView", "seekTo Exception : " + e11.getMessage());
            }
        }
    }

    public TXCVodVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, String str, Bundle bundle) {
        if ((i11 != -2304 && i11 != 2106) || !this.f21790am) {
            Message message = new Message();
            message.what = 101;
            Bundle bundle2 = new Bundle();
            message.arg1 = i11;
            String str2 = "(" + i11 + Constants.ACCEPT_TIME_SEPARATOR_SP + i12 + ")-" + str;
            bundle2.putString("description", str2);
            bundle2.putInt(TXVodConstants.EVT_ERROR_CODE, i12);
            if (bundle != null) {
                bundle2.putBundle("extra", bundle);
            }
            message.setData(bundle2);
            Handler handler = this.f21806r;
            if (handler != null) {
                handler.sendMessage(message);
                LiteavLog.i("TXCVodVideoView", "sendSimpleEvent " + str2 + " ,vod=" + hashCode());
            }
            this.f21790am = i11 == -2304 || i11 == 2106;
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, String str) {
        a(i11, i12, str, (Bundle) null);
    }

    private static void a(ITXVCubePlayer iTXVCubePlayer) {
        if (iTXVCubePlayer != null) {
            RenderProcessService.getInstance().stopRenderProcess(iTXVCubePlayer);
        }
    }

    public final void a(int i11) {
        ITXVCubePlayer iTXVCubePlayer = this.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.deselectTrack(i11);
        }
    }

    public static /* synthetic */ void a(TXCVodVideoView tXCVodVideoView, int i11, Bundle bundle) {
        d dVar = tXCVodVideoView.f21789al;
        if (dVar != null) {
            dVar.a(i11, bundle);
        }
    }
}
