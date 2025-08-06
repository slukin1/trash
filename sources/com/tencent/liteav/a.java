package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.datareport.Event4XReporter;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.TimeUtil;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.base.util.t;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;
import com.tencent.liteav.txcplayer.common.VodPlayerControl;
import com.tencent.liteav.txcplayer.e;
import com.tencent.liteav.txcplayer.ext.service.RenderProcessService;
import com.tencent.liteav.txcplayer.model.b;
import com.tencent.liteav.txcvodplayer.TXCVodVideoView;
import com.tencent.liteav.txcvodplayer.b.c;
import com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder;
import com.tencent.liteav.txcvodplayer.renderer.TextureRenderView;
import com.tencent.liteav.txcvodplayer.renderer.c;
import com.tencent.liteav.txcvodplayer.renderer.d;
import com.tencent.liteav.txcvodplayer.renderer.h;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.videobase.TXCCloudVideoViewMethodInvoker;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXPlayInfoParams;
import com.tencent.rtmp.TXTrackInfo;
import com.tencent.rtmp.TXVodConstants;
import com.tencent.rtmp.TXVodDef;
import com.tencent.rtmp.TXVodPlayConfig;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.rtmp.ui.TXSubtitleView;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLContext;

public final class a implements d.a {
    public d A;
    public Object B;
    public TXSubtitleView C;
    /* access modifiers changed from: private */
    public Context D = null;
    private float E = 1.0f;
    private long F;
    private int G;
    private int H;
    /* access modifiers changed from: private */
    public boolean I;
    private C0164a J;
    private boolean K;
    private boolean L;
    /* access modifiers changed from: private */
    public c M;
    private com.tencent.liteav.txcplayer.d N = new com.tencent.liteav.txcplayer.d() {
        public final void a(int i11, Bundle bundle) {
            int i12;
            int i13;
            String str;
            Bundle bundle2 = new Bundle(bundle);
            if (i11 == -6101) {
                a.this.f21275g.a((int) TXVodConstants.VOD_PLAY_ERR_DRM, bundle.getString("description", ""));
            } else if (i11 == -2301) {
                a.this.f21275g.a(-2301, bundle.getString("description", ""));
            } else if (i11 == 2011) {
                bundle2.putInt("EVT_PARAM1", a.this.f21273e.getMetaRotationDegree());
            } else if (!(i11 == 2026 || i11 == 2030 || i11 == 2103)) {
                if (i11 != 2106) {
                    if (i11 != 2013) {
                        int i14 = 0;
                        if (i11 != 2014) {
                            switch (i11) {
                                case TXVodConstants.VOD_PLAY_ERR_DOWNLOAD_FAIL /*-6011*/:
                                case TXVodConstants.VOD_PLAY_ERR_PROCESS_VIDEO_FAIL /*-6010*/:
                                case TXVodConstants.VOD_PLAY_ERR_RENDER_FAIL /*-6009*/:
                                case TXVodConstants.VOD_PLAY_ERR_DECODE_SUBTITLE_FAIL /*-6008*/:
                                case TXVodConstants.VOD_PLAY_ERR_DECODE_AUDIO_FAIL /*-6007*/:
                                case TXVodConstants.VOD_PLAY_ERR_DECODE_VIDEO_FAIL /*-6006*/:
                                case TXVodConstants.VOD_PLAY_ERR_DEMUXER_TIMEOUT /*-6005*/:
                                case TXVodConstants.VOD_PLAY_ERR_SYSTEM_PLAY_FAIL /*-6004*/:
                                case TXVodConstants.VOD_PLAY_ERR_DEMUXER_FAIL /*-6003*/:
                                case TXVodConstants.VOD_PLAY_ERR_GENERAL /*-6002*/:
                                case TXVodConstants.VOD_PLAY_ERR_UNKNOW /*-6001*/:
                                    a.this.f21275g.a(i11, bundle.getString("description", ""));
                                    break;
                                default:
                                    switch (i11) {
                                        case -2305:
                                            a.this.f21275g.a(-2305, "HLS decrypt key error");
                                            break;
                                        case -2304:
                                            a.this.f21275g.a(-2304, "h265 decode failed");
                                            a.this.f21275g.a("support_hevc", "0");
                                            if (!a.this.f21276h) {
                                                boolean unused = a.this.f21279k = false;
                                                a aVar = a.this;
                                                aVar.a(aVar.f21274f);
                                                break;
                                            }
                                            break;
                                        case -2303:
                                            a.this.f21275g.a(-2303, "file not found");
                                            break;
                                        default:
                                            switch (i11) {
                                                case 2002:
                                                case 2008:
                                                    break;
                                                case 2003:
                                                    Bundle bundle3 = bundle2.getBundle("extra");
                                                    if (bundle3 != null) {
                                                        String string = bundle3.getString("support_hevc");
                                                        if (!TextUtils.isEmpty(string)) {
                                                            a.this.f21275g.a("support_hevc", string);
                                                        }
                                                        bundle2.remove("extra");
                                                    }
                                                    com.tencent.liteav.txcvodplayer.a.a j11 = a.this.f21275g;
                                                    int videoWidth = a.this.f21273e.getVideoWidth();
                                                    int videoHeight = a.this.f21273e.getVideoHeight();
                                                    j11.D = videoWidth;
                                                    j11.E = videoHeight;
                                                    LiteavLog.i("TXCVodPlayer", "util onPlayEvent VOD_PLAY_EVT_RCV_FIRST_I_FRAME");
                                                    a.this.f21275g.e();
                                                    if (!a.this.f21276h) {
                                                        boolean unused2 = a.this.f21276h = true;
                                                        a.this.f21275g.d();
                                                        Bundle bundle4 = new Bundle();
                                                        bundle4.putInt(TXVodConstants.EVT_ID, 2008);
                                                        bundle4.putLong("EVT_TIME", TimeUtil.a());
                                                        bundle4.putLong("EVT_UTC_TIME", TimeUtil.b());
                                                        b mediaInfo = a.this.f21273e.getMediaInfo();
                                                        if (mediaInfo == null || (str = mediaInfo.f21760c) == null || !str.toLowerCase().contains("hevc")) {
                                                            bundle4.putCharSequence("description", a.this.f21279k ? "Enables hardware decoding" : "Enables software decoding");
                                                            i12 = 0;
                                                        } else {
                                                            bundle4.putCharSequence("description", a.this.f21279k ? "Enables hardware decoding H265" : "Enables software decoding h265");
                                                            i12 = 1;
                                                        }
                                                        bundle4.putInt("EVT_PARAM1", a.this.f21279k ? 1 : 2);
                                                        bundle4.putInt(TXVodConstants.EVT_CODEC_TYPE, i12);
                                                        if (a.this.f21279k) {
                                                            i13 = i12 == 0 ? 1 : 3;
                                                        } else {
                                                            if (i12 != 0) {
                                                                i14 = 2;
                                                            }
                                                            i13 = i14;
                                                        }
                                                        a.this.f21275g.f21856w = i13;
                                                        a(2008, bundle4);
                                                        i14 = 1;
                                                    }
                                                    if (i14 != 0) {
                                                        bundle2.putInt("EVT_PARAM1", a.this.f21275g.f21845l);
                                                        break;
                                                    } else {
                                                        return;
                                                    }
                                                    break;
                                                case 2004:
                                                    LiteavLog.i("TXCVodPlayer", "util onPlayEvent VOD_PLAY_EVT_PLAY_BEGIN");
                                                    if (a.this.I) {
                                                        a.this.f21275g.d();
                                                    }
                                                    boolean unused3 = a.this.I = false;
                                                    a.this.f21275g.f21851r = false;
                                                    break;
                                                case 2005:
                                                    com.tencent.liteav.txcvodplayer.a.a j12 = a.this.f21275g;
                                                    int i15 = bundle.getInt("EVT_PLAY_DURATION", 0);
                                                    int i16 = bundle.getInt("EVT_PLAY_PROGRESS", 0);
                                                    j12.f21842i = i15;
                                                    int a11 = i16 / com.tencent.liteav.txcvodplayer.a.b.a(j12.f21834a).a(j12.C);
                                                    if (a11 != j12.f21843j) {
                                                        j12.f21843j = a11;
                                                        if (!j12.f21839f) {
                                                            j12.b();
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                case 2006:
                                                    a.this.f21275g.c();
                                                    if (a.this.f21293y) {
                                                        Bundle bundle5 = new Bundle();
                                                        bundle5.putString("EVT_MSG", "loop once playback complete");
                                                        a.this.a(6001, bundle5);
                                                        boolean unused4 = a.this.I = true;
                                                        a.this.f21275g.f21851r = true;
                                                        a.this.f21273e.b(true);
                                                        a.this.f21275g.a(true);
                                                        LiteavLog.d("TXCVodPlayer", "loop play");
                                                        return;
                                                    }
                                                    break;
                                                case 2007:
                                                    com.tencent.liteav.txcvodplayer.a.a j13 = a.this.f21275g;
                                                    if (!j13.f21849p && j13.f21845l != -1 && !j13.f21841h && !j13.f21851r) {
                                                        j13.f21838e = System.currentTimeMillis();
                                                        j13.f21850q = true;
                                                        LiteavLog.i("TXCVodPlayCollection", "setLoadBegin mBeginLoadTS= " + j13.f21838e);
                                                        break;
                                                    }
                                                case 2009:
                                                    if (a.this.A != null) {
                                                        d l11 = a.this.A;
                                                        l11.a(h.a(l11, a.this.f21273e.getVideoWidth(), a.this.f21273e.getVideoHeight()), "setVideoSize");
                                                        break;
                                                    }
                                                    break;
                                                default:
                                                    switch (i11) {
                                                        case TXVodConstants.VOD_PLAY_EVT_TCP_CONNECT_SUCC /*2016*/:
                                                            LiteavLog.i("TXCVodPlayer", "util play tcp connect success");
                                                            com.tencent.liteav.txcvodplayer.a.a j14 = a.this.f21275g;
                                                            if (j14.f21857x == 0) {
                                                                j14.f21857x = (int) (System.currentTimeMillis() - j14.f21836c);
                                                                LiteavLog.i("TXCVodPlayCollection", "mTcpConnectTS = " + j14.f21857x + ", mOriginBeginPlayTS = " + j14.f21836c + ", " + System.currentTimeMillis());
                                                                return;
                                                            }
                                                            return;
                                                        case TXVodConstants.VOD_PLAY_EVT_FIRST_VIDEO_PACKET /*2017*/:
                                                            LiteavLog.i("TXCVodPlayer", "util play first video packet");
                                                            com.tencent.liteav.txcvodplayer.a.a j15 = a.this.f21275g;
                                                            if (j15.f21859z == 0) {
                                                                j15.f21859z = (int) (System.currentTimeMillis() - j15.f21837d);
                                                                return;
                                                            }
                                                            return;
                                                        case TXVodConstants.VOD_PLAY_EVT_DNS_RESOLVED /*2018*/:
                                                            LiteavLog.i("TXCVodPlayer", "util play dns resolved");
                                                            com.tencent.liteav.txcvodplayer.a.a j16 = a.this.f21275g;
                                                            if (j16.f21858y == 0) {
                                                                j16.f21858y = (int) (System.currentTimeMillis() - j16.f21836c);
                                                                return;
                                                            }
                                                            return;
                                                        case TXVodConstants.VOD_PLAY_EVT_SEEK_COMPLETE /*2019*/:
                                                        case TXVodConstants.VOD_PLAY_EVT_SELECT_TRACK_COMPLETE /*2020*/:
                                                            break;
                                                        default:
                                                            LiteavLog.d("TXCVodPlayer", "miss match event ".concat(String.valueOf(i11)));
                                                            return;
                                                    }
                                            }
                                            break;
                                    }
                            }
                        } else {
                            com.tencent.liteav.txcvodplayer.a.a j17 = a.this.f21275g;
                            if (!j17.f21849p && j17.f21845l != -1 && !j17.f21841h && !j17.f21851r) {
                                LiteavLog.i("TXCVodPlayCollection", "setLoadEnd mFirstFrame=" + j17.f21845l + " , mIsLoading = " + j17.f21850q + ",mBeginLoadTS = " + j17.f21838e);
                                if (j17.f21850q) {
                                    int currentTimeMillis = (int) (System.currentTimeMillis() - j17.f21838e);
                                    j17.f21847n += currentTimeMillis;
                                    j17.f21846m++;
                                    if (j17.f21848o < currentTimeMillis) {
                                        j17.f21848o = currentTimeMillis;
                                    }
                                    j17.f21850q = false;
                                }
                            }
                            if (j17.f21849p) {
                                j17.f21849p = false;
                            }
                            a.this.f21275g.e();
                        }
                    } else {
                        LiteavLog.i("TXCVodPlayer", "util onPlayEvent VOD_PLAY_EVT_VOD_PLAY_PREPARED");
                    }
                } else if (!a.this.f21276h) {
                    boolean unused5 = a.this.f21279k = false;
                    a aVar2 = a.this;
                    aVar2.a(aVar2.f21274f);
                }
            }
            bundle2.putString("EVT_MSG", bundle.getString("description", ""));
            a.this.a(i11, bundle2);
        }

        public final void a(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            int[] a11 = t.a();
            bundle2.putCharSequence("CPU_USAGE", a11[0] + "%");
            bundle2.putInt("VIDEO_FPS", (int) bundle.getFloat("fps"));
            bundle2.putInt("VIDEO_DPS", (int) bundle.getFloat("dps"));
            bundle2.putInt("NET_SPEED", ((int) bundle.getLong("tcpSpeed")) / 1000);
            bundle2.putInt("VIDEO_CACHE", ((int) bundle.getLong("cachedBytes")) / 1000);
            bundle2.putInt("VIDEO_WIDTH", a.this.f21273e.getVideoWidth());
            bundle2.putInt("VIDEO_HEIGHT", a.this.f21273e.getVideoHeight());
            bundle2.putString("SERVER_IP", a.this.f21273e.getServerIp());
            bundle2.putInt("VIDEO_BITRATE", (int) bundle.getLong("VIDEO_BITRATE"));
            bundle2.putInt("AUDIO_BITRATE", (int) bundle.getLong("AUDIO_BITRATE"));
            com.tencent.liteav.txcvodplayer.a.a j11 = a.this.f21275g;
            String serverIp = a.this.f21273e.getServerIp();
            j11.A = serverIp;
            if (serverIp == null) {
                j11.A = "";
            }
            a.this.a(15001, bundle2);
        }
    };
    private ITXVCubePlayer.b O = new ITXVCubePlayer.b() {
        public final void a(ITXVCubePlayer iTXVCubePlayer, TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            Bitmap bitmap;
            if (a.this.M == null) {
                c unused = a.this.M = new c();
            }
            c r11 = a.this.M;
            if (tPSubtitleFrameBuffer == null) {
                LiteavLog.i("SubtitleRender", "[renderToBitmap] subtitleFrameBuffer is null");
                bitmap = null;
            } else {
                LiteavLog.i("SubtitleRender", "[renderToBitmap] subtitleFrameBuffer, trackId: " + tPSubtitleFrameBuffer.trackID + " ,width: " + tPSubtitleFrameBuffer.getSrcWidth() + ", height: " + tPSubtitleFrameBuffer.getSrcHeight());
                Bitmap bitmap2 = r11.f22016a;
                if (!(bitmap2 != null && bitmap2.getWidth() == tPSubtitleFrameBuffer.getSrcWidth() && r11.f22016a.getHeight() == tPSubtitleFrameBuffer.getSrcHeight())) {
                    r11.f22016a = Bitmap.createBitmap(tPSubtitleFrameBuffer.getSrcWidth(), tPSubtitleFrameBuffer.getSrcHeight(), Bitmap.Config.ARGB_8888);
                }
                r11.f22016a.copyPixelsFromBuffer(ByteBuffer.wrap(tPSubtitleFrameBuffer.getData()[0]));
                bitmap = r11.f22016a;
            }
            if (a.this.C != null) {
                a.this.C.show(bitmap);
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public TXCloudVideoView f21269a = null;

    /* renamed from: b  reason: collision with root package name */
    public ITXLivePlayListener f21270b;

    /* renamed from: c  reason: collision with root package name */
    public ITXVodPlayListener f21271c;

    /* renamed from: d  reason: collision with root package name */
    public TXVodPlayer f21272d;

    /* renamed from: e  reason: collision with root package name */
    public TXCVodVideoView f21273e;

    /* renamed from: f  reason: collision with root package name */
    public TXVodPlayConfig f21274f;

    /* renamed from: g  reason: collision with root package name */
    public com.tencent.liteav.txcvodplayer.a.a f21275g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21276h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f21277i = true;

    /* renamed from: j  reason: collision with root package name */
    public boolean f21278j = true;

    /* renamed from: k  reason: collision with root package name */
    public boolean f21279k = true;

    /* renamed from: l  reason: collision with root package name */
    public Surface f21280l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f21281m = false;

    /* renamed from: n  reason: collision with root package name */
    public String f21282n;

    /* renamed from: o  reason: collision with root package name */
    public final Map<String, Object> f21283o;

    /* renamed from: p  reason: collision with root package name */
    public int f21284p = -1000;

    /* renamed from: q  reason: collision with root package name */
    public boolean f21285q = false;

    /* renamed from: r  reason: collision with root package name */
    public TXPlayInfoParams f21286r;

    /* renamed from: s  reason: collision with root package name */
    public c.b f21287s;

    /* renamed from: t  reason: collision with root package name */
    public String f21288t = "";

    /* renamed from: u  reason: collision with root package name */
    public boolean f21289u = false;

    /* renamed from: v  reason: collision with root package name */
    public int f21290v = -1;

    /* renamed from: w  reason: collision with root package name */
    public com.tencent.liteav.txcvodplayer.b.d f21291w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f21292x;

    /* renamed from: y  reason: collision with root package name */
    public boolean f21293y;

    /* renamed from: z  reason: collision with root package name */
    public float f21294z;

    /* renamed from: com.tencent.liteav.a$a  reason: collision with other inner class name */
    public static class C0164a {

        /* renamed from: a  reason: collision with root package name */
        public Class f21305a;

        /* renamed from: b  reason: collision with root package name */
        public Class f21306b;

        /* renamed from: c  reason: collision with root package name */
        public Class f21307c;

        /* renamed from: d  reason: collision with root package name */
        public Field f21308d;

        /* renamed from: e  reason: collision with root package name */
        public Field f21309e;

        /* renamed from: f  reason: collision with root package name */
        public Field f21310f;

        /* renamed from: g  reason: collision with root package name */
        public Field f21311g;

        /* renamed from: h  reason: collision with root package name */
        public Field f21312h;

        /* renamed from: i  reason: collision with root package name */
        public Field f21313i;

        /* renamed from: j  reason: collision with root package name */
        public Field f21314j;

        /* renamed from: k  reason: collision with root package name */
        public Field f21315k;

        /* renamed from: l  reason: collision with root package name */
        public Field f21316l;

        public C0164a(Object obj) {
            try {
                this.f21305a = obj.getClass();
                Class<TRTCCloudDef.TRTCTexture> cls = TRTCCloudDef.TRTCTexture.class;
                this.f21306b = cls;
                this.f21307c = TRTCCloudDef.TRTCVideoFrame.class;
                this.f21308d = cls.getDeclaredField("textureId");
                this.f21309e = this.f21306b.getDeclaredField("eglContext10");
                this.f21311g = this.f21307c.getDeclaredField("texture");
                this.f21312h = this.f21307c.getDeclaredField("width");
                this.f21313i = this.f21307c.getDeclaredField("height");
                this.f21314j = this.f21307c.getDeclaredField("pixelFormat");
                this.f21315k = this.f21307c.getDeclaredField("bufferType");
                this.f21316l = this.f21307c.getDeclaredField("timestamp");
                if (LiteavSystemInfo.getSystemOSVersionInt() >= 17) {
                    this.f21310f = this.f21306b.getDeclaredField("eglContext14");
                }
            } catch (Exception e11) {
                LiteavLog.e("TXCVodPlayer", "init TRTCCloudClassInvokeWrapper error ", (Throwable) e11);
            }
        }
    }

    static {
        r.a();
    }

    public a(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.D = applicationContext;
            ContextUtils.initApplicationContext(applicationContext);
            ContextUtils.setDataDirectorySuffix("liteav");
        }
        this.f21283o = new HashMap();
        this.f21270b = null;
        this.f21271c = null;
        RenderProcessService.getInstance().checkInit(context.getApplicationContext());
        TXCVodVideoView tXCVodVideoView = new TXCVodVideoView(context);
        this.f21273e = tXCVodVideoView;
        tXCVodVideoView.setListener(this.N);
        this.f21273e.setTXCOnSubtitleFrameDataListener(this.O);
    }

    public final void b(int i11) {
        this.H = i11;
        this.f21273e.setVideoRotationDegree(i11);
        d dVar = this.A;
        if (dVar != null) {
            dVar.a(k.a(i11));
        }
    }

    public final void c(int i11) {
        TXCVodVideoView tXCVodVideoView = this.f21273e;
        List<Integer> list = tXCVodVideoView.f21799j;
        if (list != null && list.size() > 0 && !tXCVodVideoView.f21800k) {
            for (Integer intValue : tXCVodVideoView.f21799j) {
                if (intValue.intValue() == i11) {
                    return;
                }
            }
        }
        ITXVCubePlayer iTXVCubePlayer = tXCVodVideoView.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.selectTrack(i11);
        }
    }

    public final void d(int i11) {
        com.tencent.liteav.txcvodplayer.a.a aVar;
        this.f21273e.setBitrateIndex(i11);
        this.f21284p = i11;
        if (i11 != -1 && this.f21276h && (aVar = this.f21275g) != null) {
            aVar.c(this.f21274f.isSmoothSwitchBitrate());
        }
    }

    public final void e() {
        this.L = false;
        ITXVCubePlayer iTXVCubePlayer = this.f21273e.f21792c;
        if (iTXVCubePlayer != null) {
            iTXVCubePlayer.unpublishAudioToNetwork();
        }
    }

    public final void f() {
        this.f21280l = null;
        this.f21273e.setRenderSurface((Surface) null);
    }

    public final void g() {
        this.f21283o.put("TXC_DRM_ENABLE", Boolean.FALSE);
    }

    public final void b(float f11) {
        this.f21294z = f11;
        this.f21273e.setStartTime(f11);
    }

    public final void d() {
        this.L = true;
        this.f21273e.c();
    }

    public final void a(TXVodPlayConfig tXVodPlayConfig) {
        this.f21274f = tXVodPlayConfig;
        if (tXVodPlayConfig == null) {
            this.f21274f = new TXVodPlayConfig();
        }
        e eVar = new e();
        float connectRetryCount = (float) this.f21274f.getConnectRetryCount();
        if (connectRetryCount >= 1.0f && connectRetryCount <= 10.0f) {
            eVar.f21727a = (int) connectRetryCount;
        }
        float connectRetryInterval = (float) this.f21274f.getConnectRetryInterval();
        if (connectRetryInterval >= 3.0f && connectRetryInterval <= 30.0f) {
            eVar.f21728b = (int) connectRetryInterval;
        }
        eVar.f21729c = (int) ((float) this.f21274f.getTimeout());
        eVar.f21730d = this.f21279k;
        eVar.f21731e = this.f21274f.getCacheFolderPath();
        eVar.f21732f = this.f21274f.getMaxCacheItems();
        eVar.f21733g = this.f21274f.getPlayerType();
        eVar.f21734h = this.f21274f.getHeaders();
        eVar.f21735i = this.f21274f.isEnableAccurateSeek();
        eVar.f21736j = this.f21274f.isSmoothSwitchBitrate();
        eVar.f21737k = this.f21274f.getCacheMp4ExtName();
        eVar.f21738l = this.f21274f.getProgressInterval();
        eVar.f21739m = this.f21274f.getMaxBufferSize();
        eVar.f21740n = this.f21274f.getMaxPreloadSize();
        if (this.f21286r == null && this.f21287s == null) {
            eVar.f21749w = this.f21274f.getOverlayKey();
            eVar.f21750x = this.f21274f.getOverlayIv();
        } else {
            c.b bVar = this.f21287s;
            if (bVar != null) {
                eVar.f21749w = bVar.f21916a;
                eVar.f21750x = bVar.f21917b;
            } else {
                eVar.f21749w = null;
                eVar.f21750x = null;
            }
        }
        eVar.f21752z = this.f21274f.getExtInfoMap();
        eVar.B = this.f21274f.isEnableRenderProcess();
        eVar.A = this.f21274f.isAutoRotate();
        long j11 = this.F;
        if (j11 > 0) {
            eVar.f21747u = j11;
        } else {
            eVar.f21747u = this.f21274f.getPreferredResolution();
        }
        eVar.C = this.f21274f.getMediaType();
        eVar.f21742p = this.f21278j;
        LiteavLog.i("TXCVodPlayer", "setConfig [connectRetryCount:" + this.f21274f.getConnectRetryCount() + "(default 3 times)][connectRetryInterval:" + this.f21274f.getConnectRetryInterval() + "(default 3s,min:3s max:30s)][vodTimeout:" + this.f21274f.getTimeout() + "(default 10s)][enableHardwareDecoder:" + this.f21279k + "(default false)][cacheFolderPath for mp4/HLS:" + this.f21274f.getCacheFolderPath() + "][maxCacheItems:" + this.f21274f.getMaxCacheItems() + "][enableAccurateSeek:" + this.f21274f.isEnableAccurateSeek() + "(default true)][autoRotate:" + this.f21274f.isAutoRotate() + "(default true)][HLS smoothSwitchBitrate:" + this.f21274f.isSmoothSwitchBitrate() + "(default false)][progressInterval:" + this.f21274f.getProgressInterval() + "(default 0.5s)][maxBufferSize:" + this.f21274f.getMaxBufferSize() + "][maxPreloadSize:" + this.f21274f.getMaxPreloadSize() + "][overlayKey for HLS Encrypt:" + this.f21274f.getOverlayKey() + "][overlayIv for HLS Encrypt:" + this.f21274f.getOverlayIv() + "][mEnableRenderProcess:" + this.f21274f.isEnableRenderProcess() + "][mPreferredResolution:" + this.f21274f.getPreferredResolution() + "][mMediaType:" + this.f21274f.getMediaType() + "]");
        this.f21273e.setConfig(eVar);
        RenderProcessService.getInstance().setEnableRenderProcess(this.f21274f.isEnableRenderProcess());
    }

    public final void c() {
        this.K = false;
        c(false);
    }

    public final void b(boolean z11) {
        this.f21292x = z11;
        TextureView textureViewSetByUser = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(this.f21269a);
        if (textureViewSetByUser != null) {
            float f11 = -1.0f;
            if (!this.f21274f.isAutoRotate() || !(this.f21273e.getMetaRotationDegree() == 90 || this.f21273e.getMetaRotationDegree() == 270)) {
                if (!z11) {
                    f11 = 1.0f;
                }
                textureViewSetByUser.setScaleX(f11);
            } else {
                if (!z11) {
                    f11 = 1.0f;
                }
                textureViewSetByUser.setScaleY(f11);
            }
        }
        com.tencent.liteav.txcvodplayer.a.a aVar = this.f21275g;
        if (aVar != null) {
            aVar.b(z11);
        }
    }

    private void c(boolean z11) {
        try {
            Object obj = this.B;
            if (obj != null) {
                obj.getClass().getDeclaredMethod("enableCustomVideoCapture", new Class[]{Integer.TYPE, Boolean.TYPE}).invoke(obj, new Object[]{2, Boolean.valueOf(z11)});
            }
        } catch (Exception e11) {
            LiteavLog.e("TXCVodPlayer", "setTRTCCustomVideoCapture error ", (Throwable) e11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0243  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String c(java.lang.String r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            java.lang.String r2 = r27.trim()
            java.lang.String r3 = "&oversign="
            boolean r4 = r1.contains(r3)
            java.lang.String r5 = "="
            java.lang.String r6 = "&"
            java.lang.String r7 = ""
            if (r4 == 0) goto L_0x016f
            boolean r2 = r1.contains(r3)
            if (r2 == 0) goto L_0x0169
            int r2 = r1.indexOf(r3)
            int r3 = r1.lastIndexOf(r3)
            int r4 = r2 + 1
            java.lang.String r4 = r1.substring(r4, r3)
            boolean r9 = android.text.TextUtils.isEmpty(r4)
            if (r9 != 0) goto L_0x0146
            java.lang.String[] r4 = r4.split(r6)
            if (r4 == 0) goto L_0x0146
            int r9 = r4.length
            if (r9 <= 0) goto L_0x0146
            r9 = r7
            r12 = r9
            r13 = r12
            r15 = r13
            r20 = r15
            r10 = 0
            r11 = 0
            r14 = 0
            r18 = 0
        L_0x0044:
            int r8 = r4.length
            if (r11 >= r8) goto L_0x00ec
            r8 = r4[r11]
            int r8 = r8.indexOf(r5)
            if (r8 < 0) goto L_0x00dc
            r21 = r7
            r7 = r4[r11]
            r22 = r5
            r5 = 0
            java.lang.String r7 = r7.substring(r5, r8)
            r5 = r4[r11]
            int r8 = r8 + 1
            r23 = r4[r11]
            r24 = r4
            int r4 = r23.length()
            java.lang.String r4 = r5.substring(r8, r4)
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            if (r5 != 0) goto L_0x00e2
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x00e2
            java.lang.String r5 = "oversign"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x0087
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r14 = r4.intValue()
            goto L_0x00e2
        L_0x0087:
            java.lang.String r5 = "o1"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x0091
            r15 = r4
            goto L_0x00e2
        L_0x0091:
            java.lang.String r5 = "o2"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x009b
            r9 = r4
            goto L_0x00e2
        L_0x009b:
            java.lang.String r5 = "o3"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x00ac
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r10 = r4.intValue()
            goto L_0x00e2
        L_0x00ac:
            java.lang.String r5 = "o4"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x00b6
            r12 = r4
            goto L_0x00e2
        L_0x00b6:
            java.lang.String r5 = "o5"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x00c0
            r13 = r4
            goto L_0x00e2
        L_0x00c0:
            java.lang.String r5 = "o6"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x00d1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            long r18 = r4.longValue()
            goto L_0x00e2
        L_0x00d1:
            java.lang.String r5 = "o7"
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x00e2
            r20 = r4
            goto L_0x00e2
        L_0x00dc:
            r24 = r4
            r22 = r5
            r21 = r7
        L_0x00e2:
            int r11 = r11 + 1
            r7 = r21
            r5 = r22
            r4 = r24
            goto L_0x0044
        L_0x00ec:
            r22 = r5
            r21 = r7
            boolean r4 = android.text.TextUtils.isEmpty(r12)
            if (r4 != 0) goto L_0x0113
            boolean r4 = android.text.TextUtils.isEmpty(r13)
            if (r4 != 0) goto L_0x0113
            java.lang.String r4 = com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder.a(r14, r15, r9, r10)
            com.tencent.liteav.txcvodplayer.b.c$b r5 = new com.tencent.liteav.txcvodplayer.b.c$b
            r5.<init>()
            java.lang.String r7 = com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder.b(r4, r12)
            r5.f21916a = r7
            java.lang.String r4 = com.tencent.liteav.txcvodplayer.hlsencoder.TXCHLSEncoder.b(r4, r13)
            r5.f21917b = r4
            r0.f21287s = r5
        L_0x0113:
            r9 = r18
            r4 = 0
            int r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x011d
            r0.F = r9
        L_0x011d:
            boolean r4 = android.text.TextUtils.isEmpty(r20)
            if (r4 != 0) goto L_0x014a
            java.util.Map<java.lang.String, java.lang.Object> r4 = r0.f21283o
            java.lang.String r5 = "TXC_DRM_KEY_URL"
            r7 = r20
            r4.put(r5, r7)
            java.util.Map<java.lang.String, java.lang.Object> r4 = r0.f21283o
            com.tencent.rtmp.TXPlayerDrmBuilder r5 = new com.tencent.rtmp.TXPlayerDrmBuilder
            r5.<init>()
            java.lang.String r5 = r5.getDeviceCertificateUrl()
            java.lang.String r7 = "TXC_DRM_PROVISION_URL"
            r4.put(r7, r5)
            java.util.Map<java.lang.String, java.lang.Object> r4 = r0.f21283o
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.String r7 = "TXC_DRM_ENABLE"
            r4.put(r7, r5)
            goto L_0x014a
        L_0x0146:
            r22 = r5
            r21 = r7
        L_0x014a:
            if (r2 <= 0) goto L_0x016d
            if (r2 >= r3) goto L_0x016d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 0
            java.lang.String r2 = r1.substring(r5, r2)
            r4.append(r2)
            int r3 = r3 + 10
            java.lang.String r1 = r1.substring(r3)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            goto L_0x016d
        L_0x0169:
            r22 = r5
            r21 = r7
        L_0x016d:
            r2 = r1
            goto L_0x0173
        L_0x016f:
            r22 = r5
            r21 = r7
        L_0x0173:
            java.lang.String r1 = "http"
            boolean r1 = r2.startsWith(r1)
            if (r1 == 0) goto L_0x017f
            java.lang.String r2 = com.tencent.liteav.txcplayer.a.a.c(r2)
        L_0x017f:
            java.lang.String r1 = r2.trim()
            java.lang.String r2 = r0.f21282n
            if (r2 == 0) goto L_0x018b
            java.lang.String r1 = com.tencent.liteav.txcplayer.a.a.a(r1, r2)
        L_0x018b:
            android.net.Uri r2 = android.net.Uri.parse(r1)
            java.lang.String r3 = r2.getQuery()
            java.lang.String r4 = "TXCVodPlayer"
            if (r3 == 0) goto L_0x0273
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0273
            java.lang.String[] r3 = r3.split(r6)
            int r5 = r3.length
            java.lang.String r8 = "0"
            if (r5 <= 0) goto L_0x0238
            int r5 = r3.length
            r11 = r21
            r12 = r11
            r13 = r12
            r9 = 0
            r10 = 0
        L_0x01ad:
            if (r9 >= r5) goto L_0x0224
            r14 = r3[r9]
            r15 = r22
            java.lang.String[] r7 = r14.split(r15)
            r16 = r1
            int r1 = r7.length
            r17 = r3
            r3 = 2
            if (r1 != r3) goto L_0x0215
            r1 = 0
            r3 = r7[r1]
            java.lang.String r1 = "spfileid"
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x01d0
            r1 = 1
            r21 = r7[r1]
        L_0x01cd:
            int r10 = r10 + 1
            goto L_0x021b
        L_0x01d0:
            r3 = 0
            r1 = r7[r3]
            java.lang.String r3 = "spdrmtype"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x01df
            r1 = 1
            r12 = r7[r1]
            goto L_0x01cd
        L_0x01df:
            r3 = 0
            r1 = r7[r3]
            java.lang.String r3 = "spappid"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x01ee
            r1 = 1
            r13 = r7[r1]
            goto L_0x01cd
        L_0x01ee:
            r1 = 1
            boolean r3 = r11.isEmpty()
            if (r3 != 0) goto L_0x0204
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r6)
            java.lang.String r11 = r3.toString()
        L_0x0204:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r11)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r11 = r3
            goto L_0x021b
        L_0x0215:
            r1 = 1
            java.lang.String r3 = "fieldIds.length != 2"
            com.tencent.liteav.base.util.LiteavLog.e(r4, r3)
        L_0x021b:
            int r9 = r9 + 1
            r22 = r15
            r1 = r16
            r3 = r17
            goto L_0x01ad
        L_0x0224:
            r16 = r1
            r1 = 1
            r3 = 3
            if (r10 != r3) goto L_0x0234
            java.lang.String r8 = "1"
            r7 = r21
            r25 = r8
            r8 = r1
            r1 = r25
            goto L_0x0241
        L_0x0234:
            r1 = r8
            r7 = r21
            goto L_0x0240
        L_0x0238:
            r16 = r1
            r1 = r8
            r7 = r21
            r11 = r7
            r12 = r11
            r13 = r12
        L_0x0240:
            r8 = 0
        L_0x0241:
            if (r8 == 0) goto L_0x0271
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "spfileid, "
            r3.<init>(r5)
            r3.append(r7)
            java.lang.String r5 = ", spdrmtype= "
            r3.append(r5)
            r3.append(r12)
            java.lang.String r5 = ", spappid="
            r3.append(r5)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            com.tencent.liteav.base.util.LiteavLog.i(r4, r3)
            com.tencent.liteav.txcvodplayer.a.a r3 = r0.f21275g
            r3.f21854u = r7
            r3.B = r12
            r3.a((java.lang.String) r13)
            com.tencent.liteav.txcvodplayer.a.a r3 = r0.f21275g
            r3.f21853t = r1
        L_0x0271:
            r7 = r11
            goto L_0x0278
        L_0x0273:
            r16 = r1
            r7 = r21
            r8 = 0
        L_0x0278:
            if (r8 == 0) goto L_0x02a9
            android.net.Uri$Builder r1 = r2.buildUpon()
            android.net.Uri$Builder r1 = r1.clearQuery()
            android.net.Uri r1 = r1.build()
            java.lang.String r1 = r1.toString()
            boolean r3 = r7.isEmpty()
            if (r3 != 0) goto L_0x02ab
            android.net.Uri$Builder r1 = r2.buildUpon()
            android.net.Uri$Builder r1 = r1.clearQuery()
            android.net.Uri$Builder r1 = r1.query(r7)
            android.net.Uri r1 = r1.build()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = android.net.Uri.decode(r1)
            goto L_0x02ab
        L_0x02a9:
            r1 = r16
        L_0x02ab:
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "parsePlayUrl url: "
            java.lang.String r2 = r3.concat(r2)
            com.tencent.liteav.base.util.LiteavLog.i(r4, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.a.c(java.lang.String):java.lang.String");
    }

    public final void b() {
        this.K = true;
        c(true);
    }

    public static String b(String str) {
        return TXCHLSEncoder.a(str);
    }

    private void a(Map<String, Object> map) {
        com.tencent.liteav.txcvodplayer.a.a aVar;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                Object value = next.getValue();
                if (TXVodConstants.VOD_KEY_CUSTOM_DATA.equals((String) next.getKey()) && (value instanceof HashMap)) {
                    Map map2 = (Map) value;
                    for (Object next2 : map2.keySet()) {
                        Object obj = map2.get(next2);
                        if ((next2 instanceof String) && (obj instanceof String)) {
                            String str = (String) next2;
                            if (!TextUtils.isEmpty(str)) {
                                String str2 = (String) obj;
                                if (!TextUtils.isEmpty(str2) && (aVar = this.f21275g) != null) {
                                    aVar.a(str, str2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final int a(String str) {
        boolean z11;
        c.b bVar;
        TXVodPlayConfig tXVodPlayConfig;
        String str2 = str;
        if (str2 == null || TextUtils.isEmpty(str)) {
            LiteavLog.i("TXCVodPlayer", "startPlay playUrl is empty, player=" + hashCode());
            return -1;
        }
        int i11 = this.f21284p;
        a(false);
        this.f21284p = i11;
        this.f21275g = new com.tencent.liteav.txcvodplayer.a.a(this.D);
        String c11 = c(str);
        com.tencent.liteav.txcvodplayer.a.a aVar = this.f21275g;
        LiteavLog.i("TXCVodPlayCollection", "setUrl: ".concat(String.valueOf(c11)));
        aVar.f21835b = c11;
        this.f21275g.a(this.f21278j);
        VodPlayerControl.nativeIncrementCheckCount();
        LicenseChecker.d dVar = LicenseChecker.d.OK;
        LicenseChecker.d a11 = com.tencent.liteav.txcplayer.common.c.a();
        if (a11 == dVar || VodPlayerControl.getPlayerLicenceControlStrategy() == 0) {
            z11 = true;
        } else {
            String str3 = "(-5," + a11.value + ")";
            LiteavLog.e("TXCVodPlayer", "startPlay error, licence check failed" + str3 + "! click the link to apply trial licence: https://cloud.tencent.com/act/event/License .Official licence requires payment.");
            Bundle bundle = new Bundle();
            bundle.putString("EVT_MSG", "VOD_PLAY_ERR_INVALID_LICENCE".concat(String.valueOf(str3)));
            a(-5, bundle);
            new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1).reportDau(MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED, 0, "");
            this.f21275g.a();
            z11 = false;
        }
        if (!z11) {
            return -5;
        }
        this.f21288t = str2;
        this.f21284p = this.f21284p;
        TXCloudVideoView tXCloudVideoView = this.f21269a;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.clearLog();
            this.f21269a.setVisibility(0);
            if (TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(this.f21269a) == null) {
                TextureRenderView textureRenderView = new TextureRenderView(this.f21269a.getContext());
                this.f21269a.addVideoView(textureRenderView);
                this.f21273e.setTextureRenderView(textureRenderView);
            }
            a(this.f21269a, 0);
        } else {
            Surface surface = this.f21280l;
            if (surface != null) {
                this.f21273e.setRenderSurface(surface);
            }
        }
        d dVar2 = this.A;
        if (dVar2 != null) {
            dVar2.a(com.tencent.liteav.txcvodplayer.renderer.e.a(dVar2), "Start");
        }
        if (TextUtils.isEmpty(com.tencent.liteav.txcplayer.common.b.a()) && (tXVodPlayConfig = this.f21274f) != null) {
            com.tencent.liteav.txcplayer.common.b.a(tXVodPlayConfig.getCacheFolderPath());
        }
        TXVodPlayConfig tXVodPlayConfig2 = this.f21274f;
        if (tXVodPlayConfig2 != null) {
            a(tXVodPlayConfig2.getExtInfoMap());
        }
        a(this.f21274f);
        this.f21273e.setPrivateConfig(this.f21283o);
        this.f21276h = false;
        this.f21273e.setStartTime(this.f21294z);
        this.f21273e.c(this.f21277i);
        d(this.f21284p);
        this.f21273e.setVideoPath(c11);
        this.f21273e.setAutoPlay(this.f21278j);
        this.f21273e.setMute(this.f21289u);
        int i12 = this.f21290v;
        if (i12 >= 0) {
            this.f21273e.setAudioPlayoutVolume(i12);
        }
        a(this.E);
        b(this.H);
        a(this.G);
        b(this.f21292x);
        this.f21273e.b(false);
        this.f21275g.f21852s = this.f21273e.getPlayerType();
        if (this.K) {
            b();
        }
        if (this.L) {
            d();
        }
        LiteavLog.i("TXCVodPlayer", "startPlay url=" + c11 + " sdkVersion=" + CommonUtil.getSDKVersionStr() + " player=" + hashCode());
        if (!(this.f21286r == null || (bVar = this.f21287s) == null || TextUtils.isEmpty(bVar.f21916a))) {
            com.tencent.liteav.txcvodplayer.c.a a12 = com.tencent.liteav.txcvodplayer.c.a.a();
            int appId = this.f21286r.getAppId();
            String fileId = this.f21286r.getFileId();
            c.b bVar2 = this.f21287s;
            if (TextUtils.isEmpty(fileId) || bVar2 == null || TextUtils.isEmpty(bVar2.f21916a) || TextUtils.isEmpty(bVar2.f21917b) || TextUtils.isEmpty(bVar2.f21918c) || TextUtils.isEmpty(bVar2.f21919d) || TextUtils.isEmpty(c11)) {
                LiteavLog.w("PlayInfoProtocolV4Storage", "put params empty fileId: " + fileId + " url:" + c11);
            } else {
                com.tencent.liteav.txcplayer.common.a.a().execute(com.tencent.liteav.txcvodplayer.c.b.a(a12, appId, fileId, c11, bVar2));
            }
        }
        Event4XReporter event4XReporter = new Event4XReporter(UGCDataReportDef.COMMAND_ID_DAU, 1004, "", true, 1);
        event4XReporter.reportDau(MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED, 0, "");
        com.tencent.liteav.txcvodplayer.a.a aVar2 = this.f21275g;
        aVar2.f21855v = this.f21278j ? "autoPlay=1" : "autoPlay=0";
        aVar2.a();
        try {
            Class.forName("com.tencent.liteav.demo.play.SuperPlayerView");
            event4XReporter.reportDau(1556, 0, "");
        } catch (Exception unused) {
        }
        return 0;
    }

    public static void a(TXCloudVideoView tXCloudVideoView, int i11) {
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setVisibility(i11);
            TextureView textureViewSetByUser = TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView);
            if (textureViewSetByUser != null) {
                textureViewSetByUser.setVisibility(i11);
            }
        }
    }

    public final int a(boolean z11) {
        this.f21281m = true;
        this.f21273e.a();
        this.F = -1;
        com.tencent.liteav.txcvodplayer.b.d dVar = this.f21291w;
        if (dVar != null) {
            dVar.a((com.tencent.liteav.txcvodplayer.b.e) null);
            this.f21291w = null;
        }
        d dVar2 = this.A;
        if (dVar2 != null) {
            dVar2.a(true);
        }
        TXCloudVideoView tXCloudVideoView = this.f21269a;
        if (!(tXCloudVideoView == null || TXCCloudVideoViewMethodInvoker.getTextureViewSetByUser(tXCloudVideoView) == null || !z11)) {
            a(this.f21269a, 8);
            this.f21269a.removeVideoView();
        }
        com.tencent.liteav.txcvodplayer.a.a aVar = this.f21275g;
        if (aVar != null) {
            aVar.c();
        }
        this.f21284p = -1000;
        com.tencent.liteav.txcvodplayer.renderer.c cVar = this.M;
        if (cVar != null) {
            cVar.a();
            this.M = null;
        }
        TXSubtitleView tXSubtitleView = this.C;
        if (tXSubtitleView == null) {
            return 0;
        }
        tXSubtitleView.show((Bitmap) null);
        return 0;
    }

    public final void a(float f11, boolean z11) {
        com.tencent.liteav.txcvodplayer.a.a aVar;
        this.f21273e.a((int) (f11 * 1000.0f), z11);
        if (this.f21276h && (aVar = this.f21275g) != null) {
            aVar.f();
        }
    }

    public final void a(int i11) {
        this.G = i11;
        if (i11 == 1) {
            this.f21273e.setRenderMode(0);
        } else {
            this.f21273e.setRenderMode(1);
        }
        d dVar = this.A;
        if (dVar != null) {
            dVar.a(GLConstants.GLScaleType.a(i11));
        }
    }

    public final List<TXTrackInfo> a() {
        TPTrackInfo[] trackInfo = this.f21273e.getTrackInfo();
        if (trackInfo == null || trackInfo.length == 0) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        a((List<TXTrackInfo>) arrayList, trackInfo);
        return arrayList;
    }

    public static List<TXTrackInfo> a(List<TXTrackInfo> list, int i11) {
        ArrayList arrayList = new ArrayList();
        for (TXTrackInfo next : list) {
            if (next.getTrackType() == i11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static void a(List<TXTrackInfo> list, TPTrackInfo[] tPTrackInfoArr) {
        for (int i11 = 0; i11 < tPTrackInfoArr.length; i11++) {
            TPTrackInfo tPTrackInfo = tPTrackInfoArr[i11];
            TXTrackInfo tXTrackInfo = new TXTrackInfo();
            tXTrackInfo.trackIndex = i11;
            tXTrackInfo.trackType = tPTrackInfo.trackType;
            tXTrackInfo.name = tPTrackInfo.name;
            tXTrackInfo.isSelected = tPTrackInfo.isSelected;
            tXTrackInfo.isExclusive = tPTrackInfo.isExclusive;
            tXTrackInfo.isInternal = tPTrackInfo.isInternal;
            list.add(tXTrackInfo);
        }
    }

    public static TXVodDef.TXVodSubtitleData a(TPSubtitleData tPSubtitleData) {
        TXVodDef.TXVodSubtitleData tXVodSubtitleData = new TXVodDef.TXVodSubtitleData();
        tXVodSubtitleData.subtitleData = tPSubtitleData.subtitleData;
        tXVodSubtitleData.durationMs = tPSubtitleData.durationMs;
        tXVodSubtitleData.startPositionMs = tPSubtitleData.startPositionMs;
        tXVodSubtitleData.trackIndex = tPSubtitleData.trackIndex;
        return tXVodSubtitleData;
    }

    public final void a(float f11) {
        this.E = f11;
        this.f21273e.setRate(f11);
        com.tencent.liteav.txcvodplayer.a.a aVar = this.f21275g;
        if (aVar != null) {
            aVar.a(f11);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, Bundle bundle) {
        TXVodPlayer tXVodPlayer;
        TXVodPlayer tXVodPlayer2;
        if (i11 == 15001) {
            ITXLivePlayListener iTXLivePlayListener = this.f21270b;
            if (iTXLivePlayListener != null) {
                iTXLivePlayListener.onNetStatus(bundle);
            }
            ITXVodPlayListener iTXVodPlayListener = this.f21271c;
            if (iTXVodPlayListener != null && (tXVodPlayer2 = this.f21272d) != null) {
                iTXVodPlayListener.onNetStatus(tXVodPlayer2, bundle);
                return;
            }
            return;
        }
        ITXLivePlayListener iTXLivePlayListener2 = this.f21270b;
        if (iTXLivePlayListener2 != null) {
            iTXLivePlayListener2.onPlayEvent(i11, bundle);
        }
        ITXVodPlayListener iTXVodPlayListener2 = this.f21271c;
        if (iTXVodPlayListener2 != null && (tXVodPlayer = this.f21272d) != null) {
            iTXVodPlayListener2.onPlayEvent(tXVodPlayer, i11, bundle);
        }
    }

    public final void a(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        this.f21280l = surface;
        this.f21273e.setRenderSurface(surface);
    }

    public final void a(PixelFrame pixelFrame) {
        Object obj;
        if (this.K) {
            try {
                if (this.J == null && (obj = this.B) != null) {
                    this.J = new C0164a(obj);
                }
                C0164a aVar = this.J;
                if (aVar != null) {
                    Object obj2 = this.B;
                    try {
                        Object newInstance = aVar.f21306b.newInstance();
                        aVar.f21308d.set(newInstance, Integer.valueOf(pixelFrame.getTextureId()));
                        if (pixelFrame.getGLContext() instanceof EGLContext) {
                            aVar.f21309e.set(newInstance, pixelFrame.getGLContext());
                        } else {
                            aVar.f21310f.set(newInstance, pixelFrame.getGLContext());
                        }
                        Object newInstance2 = aVar.f21307c.newInstance();
                        aVar.f21311g.set(newInstance2, newInstance);
                        aVar.f21312h.set(newInstance2, Integer.valueOf(pixelFrame.getWidth()));
                        aVar.f21313i.set(newInstance2, Integer.valueOf(pixelFrame.getHeight()));
                        aVar.f21314j.set(newInstance2, 2);
                        aVar.f21315k.set(newInstance2, 3);
                        aVar.f21316l.set(newInstance2, 0);
                        aVar.f21305a.getDeclaredMethod("sendCustomVideoData", new Class[]{Integer.TYPE, newInstance2.getClass()}).invoke(obj2, new Object[]{2, newInstance2});
                    } catch (Exception e11) {
                        LiteavLog.e("TXCVodPlayer", "sendCustomVideoData method error ", (Throwable) e11);
                    }
                }
            } catch (Exception e12) {
                LiteavLog.e("TXCVodPlayer", "get enableCustomVideoCapture method error ", (Throwable) e12);
            }
        }
    }

    public final int a(String str, String str2, String str3, String str4, c.b bVar) {
        this.f21283o.put("TXC_DRM_KEY_URL", str2);
        this.f21283o.put("TXC_DRM_PROVISION_URL", str3);
        this.f21283o.put("TXC_DRM_SIMPLE_AES_URL", str4);
        this.f21283o.put("TXC_DRM_ENABLE", Boolean.TRUE);
        this.f21287s = bVar;
        return a(str);
    }
}
