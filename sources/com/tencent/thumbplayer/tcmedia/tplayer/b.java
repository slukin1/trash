package com.tencent.thumbplayer.tcmedia.tplayer;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import cn.sharesdk.framework.InnerShareParams;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayer;
import com.tencent.thumbplayer.tcmedia.api.ITPPlayerListener;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureParams;
import com.tencent.thumbplayer.tcmedia.api.TPErrorCode;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaDRMAsset;
import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.tcmedia.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.tcmedia.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.tcmedia.api.report.ITPBusinessReportManager;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPExtendReportController;
import com.tencent.thumbplayer.tcmedia.api.resourceloader.ITPAssetResourceLoaderListener;
import com.tencent.thumbplayer.tcmedia.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyMsg;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.tplayer.a.g;
import com.tencent.thumbplayer.tcmedia.tplayer.e;
import com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.c;
import com.tencent.thumbplayer.tcmedia.utils.j;
import com.tencent.thumbplayer.tcmedia.utils.n;
import com.tencent.thumbplayer.tcmedia.utils.o;
import com.tencent.thumbplayer.tcmedia.utils.r;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements ITPPlayer {
    private static final SparseIntArray E;

    /* renamed from: a  reason: collision with root package name */
    private static String f49569a = "api call:";

    /* renamed from: v  reason: collision with root package name */
    private static AtomicInteger f49570v = new AtomicInteger(1000);
    private long A;
    private int B;
    private int C;
    /* access modifiers changed from: private */
    public TPDLProxyMsg.TPPDTInfo[] D;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final com.tencent.thumbplayer.tcmedia.adapter.a f49571b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f49572c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.c.a f49573d;

    /* renamed from: e  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b f49574e;

    /* renamed from: f  reason: collision with root package name */
    private c f49575f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.c.a.a f49576g;

    /* renamed from: h  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.tplayer.plugins.b f49577h;

    /* renamed from: i  reason: collision with root package name */
    private HandlerThread f49578i;

    /* renamed from: j  reason: collision with root package name */
    private Looper f49579j;

    /* renamed from: k  reason: collision with root package name */
    private a f49580k;

    /* renamed from: l  reason: collision with root package name */
    private a f49581l;

    /* renamed from: m  reason: collision with root package name */
    private String f49582m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f49583n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f49584o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f49585p;

    /* renamed from: q  reason: collision with root package name */
    private ArrayList<String> f49586q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public long f49587r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public long f49588s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public long f49589t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.e.a f49590u;

    /* renamed from: w  reason: collision with root package name */
    private AtomicInteger f49591w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f49592x;

    /* renamed from: y  reason: collision with root package name */
    private g f49593y;

    /* renamed from: z  reason: collision with root package name */
    private Map<Long, Long> f49594z;

    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private b f49596b;

        public a(b bVar) {
            this.f49596b = bVar;
        }

        public a(b bVar, Looper looper) {
            super(looper);
            this.f49596b = bVar;
        }

        public void handleMessage(Message message) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                int i11 = message.what;
                if (i11 == 257) {
                    b.this.f49590u.c("onPrepared");
                    b.this.c(1004);
                    e11.onPrepared(this.f49596b);
                } else if (i11 != 1256) {
                    switch (i11) {
                        case TipsMessageBean.MSG_TYPE_GROUP_QUITE:
                            e11.onCompletion(this.f49596b);
                            return;
                        case TipsMessageBean.MSG_TYPE_GROUP_KICK:
                            b.this.b(message.arg1);
                            e.a aVar = (e.a) message.obj;
                            if (aVar != null && !b.this.f49573d.c()) {
                                e11.onInfo(this.f49596b, message.arg1, aVar.f49619a, aVar.f49620b, aVar.f49621c);
                                return;
                            } else if (aVar != null) {
                                e11.onInfo(this.f49596b, message.arg1, aVar.f49619a, aVar.f49620b, aVar.f49621c);
                                return;
                            } else {
                                return;
                            }
                        case TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME:
                            e.a aVar2 = (e.a) message.obj;
                            if (aVar2 != null) {
                                e11.onError(this.f49596b, message.arg1, message.arg2, aVar2.f49619a, aVar2.f49620b);
                                return;
                            }
                            return;
                        case 263:
                            e11.onSeekComplete(this.f49596b);
                            return;
                        case 264:
                            e.a aVar3 = (e.a) message.obj;
                            if (aVar3 != null) {
                                e11.onVideoSizeChanged(this.f49596b, aVar3.f49619a, aVar3.f49620b);
                                b.this.f49573d.a(aVar3.f49619a, aVar3.f49620b);
                                return;
                            }
                            return;
                        case 265:
                            e11.onSubtitleData(this.f49596b, (TPSubtitleData) message.obj);
                            return;
                        case 266:
                            e11.onVideoFrameOut(this.f49596b, (TPVideoFrameBuffer) message.obj);
                            return;
                        case 267:
                            e11.onAudioFrameOut(this.f49596b, (TPAudioFrameBuffer) message.obj);
                            return;
                        case 268:
                            e11.onError(this.f49596b, message.arg1, message.arg2, 0, 0);
                            return;
                        case 269:
                            e11.onInfo(this.f49596b, 1002, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 270:
                            e11.onInfo(this.f49596b, 1003, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 271:
                            e11.onInfo(this.f49596b, 1001, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 272:
                            e11.onInfo(this.f49596b, 1004, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case TUIMessageBean.MSG_STATUS_READ:
                            e11.onInfo(this.f49596b, 1005, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case TUIMessageBean.MSG_STATUS_DELETE:
                            e11.onInfo(this.f49596b, 1006, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case TUIMessageBean.MSG_STATUS_REVOKE:
                            e11.onInfo(this.f49596b, 1007, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 276:
                            e11.onInfo(this.f49596b, 1008, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 277:
                            e11.onStateChange(message.arg1, message.arg2);
                            return;
                        case 278:
                            if (b.this.f49571b != null) {
                                try {
                                    b.this.f49571b.a(new TPOptionalParam().buildLong(8000, (long) message.arg1));
                                    com.tencent.thumbplayer.tcmedia.e.a c11 = b.this.f49590u;
                                    c11.c("MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION bitrate:" + message.arg1);
                                } catch (IllegalStateException e12) {
                                    b.this.f49590u.a((Exception) e12);
                                }
                            }
                            if (b.this.f49584o) {
                                e11.onInfo(this.f49596b, 1010, (long) message.arg1, (long) message.arg2, message.obj);
                                return;
                            }
                            return;
                        case 279:
                            e11.onSubtitleFrameOut(this.f49596b, (TPSubtitleFrameBuffer) message.obj);
                            return;
                        case 280:
                            e11.onStopAsyncComplete(this.f49596b);
                            return;
                        case 281:
                            e11.onInfo(this.f49596b, 1015, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 282:
                            b.this.c();
                            return;
                        case 283:
                            e11.onInfo(this.f49596b, 1016, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case 284:
                            e11.onInfo(this.f49596b, 1017, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        case MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL /*285*/:
                            e11.onInfo(this.f49596b, 1018, (long) message.arg1, (long) message.arg2, message.obj);
                            return;
                        default:
                            return;
                    }
                } else {
                    b.this.a(message);
                }
            }
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.tplayer.b$b  reason: collision with other inner class name */
    public class C0627b implements c.a, c.b, c.C0614c, c.d, c.e, c.f, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p, ITPPlayListener {
        public C0627b() {
        }

        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                return e11.onVideoProcessFrameOut(b.this, tPPostProcessFrameBuffer);
            }
            return null;
        }

        public TPRemoteSdpInfo a(String str, int i11) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                return e11.onSdpExchange(b.this, str, i11);
            }
            return null;
        }

        public void a() {
            int i11;
            boolean z11 = true;
            b.this.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 1);
            b.this.f49573d.a(0);
            com.tencent.thumbplayer.tcmedia.adapter.b e11 = b.this.f49571b.e();
            b.this.updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_BITRATE_KBPS, Long.valueOf(((e11.g() + e11.f()) / 8) >> 10));
            b bVar = b.this;
            TPDLProxyMsg.TPPDTInfo[] unused = bVar.D = bVar.f49573d.k();
            String str = e11.a() + "*" + e11.b();
            TPTrackInfo[] s11 = b.this.f49571b.s();
            if (s11 != null) {
                i11 = 0;
                for (TPTrackInfo tPTrackInfo : s11) {
                    if (tPTrackInfo.trackType == 2) {
                        i11++;
                    }
                }
            } else {
                i11 = 0;
            }
            b bVar2 = b.this;
            com.tencent.thumbplayer.tcmedia.utils.g a11 = new com.tencent.thumbplayer.tcmedia.utils.g().a("playertype", Integer.valueOf(b.this.f49571b.d())).a("definition", str).a("rate", Long.valueOf(e11.f() / 8000)).a(IBridgeMediaLoader.COLUMN_DURATION, Long.valueOf(e11.k())).a("fmt", e11.c()).a("etime", Long.valueOf(System.currentTimeMillis()));
            if (i11 <= 1) {
                z11 = false;
            }
            bVar2.a(103, 0, 0, (String) null, (Object) a11.a("multitrack", Boolean.valueOf(z11)).a());
            b.this.a(257, 0, 0, (Object) null);
        }

        public void a(int i11, int i12, long j11, long j12) {
            String g11 = b.this.f49573d.g();
            b.this.f49590u.c("onError playerErrorCodeStr=".concat(String.valueOf(g11)));
            if (!TextUtils.isEmpty(g11)) {
                try {
                    i12 = Integer.parseInt(g11);
                    i11 = TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY;
                } catch (Exception e11) {
                    b.this.f49590u.a(e11);
                }
            }
            b.this.a(i11, i12);
            com.tencent.thumbplayer.tcmedia.e.a c11 = b.this.f49590u;
            c11.c("onError errorTypeReal=" + i11 + ", errorCodeReal=" + i12);
            e.a aVar = new e.a();
            aVar.f49619a = j11;
            aVar.f49620b = j12;
            b.this.a((int) TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, i11, i12, (Object) aVar);
        }

        public void a(int i11, long j11, long j12, Object obj) {
            b.this.a(i11, j11, j12, obj);
            if (i11 == 1011) {
                b.this.a(obj);
            } else if (i11 == 1012) {
                b.this.b(obj);
            } else {
                if (i11 == 4) {
                    obj = Long.valueOf(b.this.b(((Long) obj).longValue(), "async call select track"));
                }
                e.a aVar = new e.a();
                aVar.f49619a = j11;
                aVar.f49620b = j12;
                aVar.f49621c = obj;
                b.this.a((int) TipsMessageBean.MSG_TYPE_GROUP_KICK, i11, 0, (Object) aVar);
            }
        }

        public void a(long j11, long j12) {
            e.a aVar = new e.a();
            aVar.f49619a = j11;
            aVar.f49620b = j12;
            b.this.a(264, 0, 0, (Object) aVar);
        }

        public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                e11.onAudioFrameOut(b.this, tPAudioFrameBuffer);
            }
        }

        public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                e11.onDetailInfo(b.this, tPPlayerDetailInfo);
            }
        }

        public void a(TPSubtitleData tPSubtitleData) {
            b.this.a(265, 0, 0, (Object) tPSubtitleData);
        }

        public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            b.this.a(279, 0, 0, (Object) tPSubtitleFrameBuffer);
        }

        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                e11.onVideoFrameOut(b.this, tPVideoFrameBuffer);
            }
        }

        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            c e11 = b.this.f49572c;
            if (e11 != null) {
                return e11.onAudioProcessFrameOut(b.this, tPPostProcessFrameBuffer);
            }
            return null;
        }

        public void b() {
            b.this.a(111, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a(Constants.REASON, 0).a());
            b.this.a((int) TipsMessageBean.MSG_TYPE_GROUP_QUITE, 0, 0, (Object) null);
        }

        public void b(int i11, int i12) {
            b.this.a(277, i11, i12, (Object) null);
        }

        public void c() {
            b.this.f();
            b.this.a(110, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a("petime", Long.valueOf(b.this.getCurrentPositionMs())).a());
            b.this.a(263, 0, 0, (Object) null);
        }

        public void d() {
        }

        public long getAdvRemainTime() {
            ITPPlayerProxyListener j11 = b.this.f49573d.j();
            if (j11 != null) {
                return j11.getAdvRemainTimeMs();
            }
            return -1;
        }

        public String getContentType(int i11, String str) {
            if (b.this.f49576g != null) {
                return b.this.f49576g.c(i11, str);
            }
            b.this.f49590u.e("mAssetResourceLoader not set");
            return "";
        }

        public int getCurrentPlayClipNo() {
            com.tencent.thumbplayer.tcmedia.adapter.a b11 = b.this.f49571b;
            if (b11 != null) {
                return b11.a();
            }
            return 0;
        }

        public long getCurrentPlayOffset() {
            return b.this.f49571b.u();
        }

        public long getCurrentPosition() {
            return b.this.getCurrentPositionMs();
        }

        public String getDataFilePath(int i11, String str) {
            if (b.this.f49576g != null) {
                return b.this.f49576g.b(i11, str);
            }
            b.this.f49590u.e("mAssetResourceLoader not set");
            return "";
        }

        public long getDataTotalSize(int i11, String str) {
            if (b.this.f49576g != null) {
                return b.this.f49576g.a(i11, str);
            }
            b.this.f49590u.e("mAssetResourceLoader not set");
            return -1;
        }

        public Object getPlayInfo(long j11) {
            return null;
        }

        public Object getPlayInfo(String str) {
            return null;
        }

        public long getPlayerBufferLength() {
            com.tencent.thumbplayer.tcmedia.adapter.a b11 = b.this.f49571b;
            if (b11 != null) {
                return b11.p() - b.this.f49571b.o();
            }
            return 0;
        }

        public void onDownloadCdnUrlExpired(Map<String, String> map) {
            b.this.f49590u.c("onDownloadCdnUrlExpired");
            b.this.a((int) TUIMessageBean.MSG_STATUS_REVOKE, 0, 0, (Object) map);
        }

        public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
            com.tencent.thumbplayer.tcmedia.e.a c11 = b.this.f49590u;
            c11.c("onDownloadCdnUrlInfoUpdate, url:" + str + ", cdnIp:" + str2 + ", uip:" + str3 + ", errorCodeStr:" + str4);
            TPPlayerMsg.TPCDNURLInfo tPCDNURLInfo = new TPPlayerMsg.TPCDNURLInfo();
            tPCDNURLInfo.url = str;
            tPCDNURLInfo.cdnIp = str2;
            tPCDNURLInfo.uIp = str3;
            b.this.a(201, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("url", str).a("cdnip", str2).a("cdnuip", str3).a());
            b.this.a(270, 0, 0, (Object) tPCDNURLInfo);
        }

        public void onDownloadCdnUrlUpdate(String str) {
            b.this.f49590u.c("onDownloadCdnUrlUpdate, url:".concat(String.valueOf(str)));
            b.this.a(269, 0, 0, (Object) str);
        }

        public void onDownloadError(int i11, int i12, String str) {
            com.tencent.thumbplayer.tcmedia.e.a c11 = b.this.f49590u;
            c11.c("onDownloadError, moduleID:" + i11 + ", errorCode:" + i12 + ", extInfo:" + str);
            b.this.a(i11, i12);
            b.this.a(268, i11, i12, (Object) str);
        }

        public void onDownloadFinish() {
            b.this.f49590u.c("onDownloadFinish");
            b.this.a(271, 0, 0, (Object) 0);
        }

        public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
            long j13 = (long) i11;
            long unused = b.this.f49587r = j13;
            long unused2 = b.this.f49588s = j11;
            long unused3 = b.this.f49589t = j12;
            TPPlayerMsg.TPDownLoadProgressInfo tPDownLoadProgressInfo = new TPPlayerMsg.TPDownLoadProgressInfo();
            tPDownLoadProgressInfo.playableDurationMS = j13;
            tPDownLoadProgressInfo.downloadSpeedKBps = i12;
            tPDownLoadProgressInfo.currentDownloadSize = j11;
            tPDownLoadProgressInfo.totalFileSize = j12;
            tPDownLoadProgressInfo.extraInfo = str;
            b.this.a(200, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("speed", Integer.valueOf(i12)).a("spanId", str).a());
            b.this.a((int) TUIMessageBean.MSG_STATUS_DELETE, 0, 0, (Object) tPDownLoadProgressInfo);
        }

        public void onDownloadProtocolUpdate(String str, String str2) {
            com.tencent.thumbplayer.tcmedia.e.a c11 = b.this.f49590u;
            c11.c("onDownloadProtocolUpdate, protocol:" + str + ", protocolVer:" + str2);
            TPPlayerMsg.TPProtocolInfo tPProtocolInfo = new TPPlayerMsg.TPProtocolInfo();
            tPProtocolInfo.protocolVersion = str2;
            tPProtocolInfo.protocolName = str;
            b.this.a(202, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("proto", str).a("protover", str2).a());
            b.this.a((int) TUIMessageBean.MSG_STATUS_READ, 0, 0, (Object) tPProtocolInfo);
        }

        public void onDownloadStatusUpdate(int i11) {
            if (i11 != b.this.f49585p) {
                b.this.f49590u.c("onDownloadStatusUpdate, status:".concat(String.valueOf(i11)));
                int unused = b.this.f49585p = i11;
            }
            b.this.a(272, i11, 0, (Object) null);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0057, code lost:
            com.tencent.thumbplayer.tcmedia.tplayer.b.a(r3, r4, 0, 0, (java.lang.Object) null);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object onPlayCallback(int r3, java.lang.Object r4, java.lang.Object r5, java.lang.Object r6, java.lang.Object r7) {
            /*
                r2 = this;
                r7 = 1
                r0 = 0
                r1 = 0
                if (r3 == r7) goto L_0x00d4
                r7 = 2
                if (r3 == r7) goto L_0x0093
                switch(r3) {
                    case 8: goto L_0x005c;
                    case 9: goto L_0x0048;
                    case 10: goto L_0x0038;
                    case 11: goto L_0x001d;
                    case 12: goto L_0x000d;
                    default: goto L_0x000b;
                }
            L_0x000b:
                goto L_0x00e6
            L_0x000d:
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r4 = "onDownload proxy hit cache"
                r3.c(r4)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r4 = 285(0x11d, float:4.0E-43)
                goto L_0x0057
            L_0x001d:
                java.lang.String r4 = (java.lang.String) r4
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r5 = java.lang.String.valueOf(r4)
                java.lang.String r6 = "onDownload multi network use status change"
                java.lang.String r5 = r6.concat(r5)
                r3.c(r5)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r5 = 284(0x11c, float:3.98E-43)
                goto L_0x00e3
            L_0x0038:
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r4 = "onDownload multi network card not open, current low speed"
                r3.c(r4)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r4 = 283(0x11b, float:3.97E-43)
                goto L_0x0057
            L_0x0048:
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r4 = "onDownload Refresh M3U8"
                r3.c(r4)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r4 = 282(0x11a, float:3.95E-43)
            L_0x0057:
                r3.a((int) r4, (int) r1, (int) r1, (java.lang.Object) r0)
                goto L_0x00e6
            L_0x005c:
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "AB test info from download proxy received, key: "
                r6.<init>(r7)
                r6.append(r4)
                java.lang.String r7 = ", value: "
                r6.append(r7)
                r6.append(r5)
                java.lang.String r6 = r6.toString()
                r3.c(r6)
                java.util.HashMap r3 = new java.util.HashMap
                r3.<init>()
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                r3.put(r4, r5)
                com.tencent.thumbplayer.tcmedia.tplayer.b r4 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r5 = 281(0x119, float:3.94E-43)
                r4.a((int) r5, (int) r1, (int) r1, (java.lang.Object) r3)
                goto L_0x00e6
            L_0x0093:
                boolean r3 = r6 instanceof java.lang.Integer
                if (r3 != 0) goto L_0x00a0
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r4 = "MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION, err ext3."
                goto L_0x00d0
            L_0x00a0:
                java.lang.Integer r6 = (java.lang.Integer) r6
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r4 = java.lang.String.valueOf(r6)
                java.lang.String r5 = "onDownload suggest bitrate(bps):"
                java.lang.String r4 = r5.concat(r4)
                r3.c(r4)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r4 = 278(0x116, float:3.9E-43)
                int r5 = r6.intValue()
                r3.a((int) r4, (int) r5, (int) r1, (java.lang.Object) r0)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r4 = java.lang.String.valueOf(r6)
                java.lang.String r5 = "MESSAGE_NOTIFY_PLAYER_SWITCH_DEFINITION bitrate"
                java.lang.String r4 = r5.concat(r4)
            L_0x00d0:
                r3.c(r4)
                goto L_0x00e6
            L_0x00d4:
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                com.tencent.thumbplayer.tcmedia.e.a r3 = r3.f49590u
                java.lang.String r5 = "onDownloadNoMoreData"
                r3.c(r5)
                com.tencent.thumbplayer.tcmedia.tplayer.b r3 = com.tencent.thumbplayer.tcmedia.tplayer.b.this
                r5 = 276(0x114, float:3.87E-43)
            L_0x00e3:
                r3.a((int) r5, (int) r1, (int) r1, (java.lang.Object) r4)
            L_0x00e6:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.b.C0627b.onPlayCallback(int, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public int onReadData(int i11, String str, long j11, long j12) {
            if (b.this.f49576g != null) {
                return b.this.f49576g.b(i11, str, j11, j12);
            }
            b.this.f49590u.e("mAssetResourceLoader not set");
            return -1;
        }

        public int onStartReadData(int i11, String str, long j11, long j12) {
            if (b.this.f49576g != null) {
                return b.this.f49576g.a(i11, str, j11, j12);
            }
            b.this.f49590u.e("mAssetResourceLoader not set");
            return -1;
        }

        public int onStopReadData(int i11, String str, int i12) {
            if (b.this.f49576g != null) {
                return b.this.f49576g.a(i11, str, i12);
            }
            b.this.f49590u.e("mAssetResourceLoader not set");
            return -1;
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        E = sparseIntArray;
        sparseIntArray.put(106, 1005);
        sparseIntArray.put(105, 1006);
    }

    public b(Context context) {
        this(context, (Looper) null);
    }

    public b(Context context, Looper looper) {
        this(context, looper, (Looper) null);
    }

    public b(Context context, Looper looper, Looper looper2) {
        this(context, looper, looper2, (com.tencent.thumbplayer.tcmedia.e.b) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(android.content.Context r10, android.os.Looper r11, android.os.Looper r12, com.tencent.thumbplayer.tcmedia.e.b r13) {
        /*
            r9 = this;
            r9.<init>()
            r0 = 0
            r9.f49582m = r0
            r1 = 1
            r9.f49583n = r1
            r2 = 0
            r9.f49584o = r2
            r3 = -1
            r9.f49585p = r3
            java.util.concurrent.atomic.AtomicInteger r3 = new java.util.concurrent.atomic.AtomicInteger
            r4 = 1000(0x3e8, float:1.401E-42)
            r3.<init>(r4)
            r9.f49591w = r3
            r9.f49592x = r2
            r9.f49593y = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r9.f49594z = r0
            r2 = 0
            r9.A = r2
            java.lang.String r0 = "TPPlayer"
            if (r13 == 0) goto L_0x0031
            com.tencent.thumbplayer.tcmedia.e.b r1 = new com.tencent.thumbplayer.tcmedia.e.b
            r1.<init>(r13, r0)
            goto L_0x004f
        L_0x0031:
            com.tencent.thumbplayer.tcmedia.e.b r13 = new com.tencent.thumbplayer.tcmedia.e.b
            java.util.concurrent.atomic.AtomicInteger r2 = f49570v
            int r2 = r2.incrementAndGet()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.util.concurrent.atomic.AtomicInteger r3 = r9.f49591w
            int r3 = r3.incrementAndGet()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = "ThumbPlayer"
            r13.<init>(r4, r2, r3, r0)
            r9.f49592x = r1
            r1 = r13
        L_0x004f:
            com.tencent.thumbplayer.tcmedia.e.a r13 = new com.tencent.thumbplayer.tcmedia.e.a
            r13.<init>(r1)
            r9.f49590u = r13
            java.lang.String r0 = "create TPPlayer"
            r13.c(r0)
            com.tencent.thumbplayer.tcmedia.tplayer.a r13 = new com.tencent.thumbplayer.tcmedia.tplayer.a
            android.content.Context r10 = r10.getApplicationContext()
            r13.<init>(r10)
            r9.f49581l = r13
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.c r10 = new com.tencent.thumbplayer.tcmedia.tplayer.plugins.c
            r10.<init>()
            r9.f49577h = r10
            boolean r10 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.isDataReportEnable()
            if (r10 == 0) goto L_0x0087
            boolean r10 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.isPlayerReportEnable()
            if (r10 == 0) goto L_0x0087
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b r10 = new com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b
            com.tencent.thumbplayer.tcmedia.tplayer.a r13 = r9.f49581l
            android.content.Context r13 = r13.a()
            r10.<init>(r13)
            r9.f49574e = r10
            goto L_0x008e
        L_0x0087:
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.c r10 = new com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.c
            r10.<init>()
            r9.f49575f = r10
        L_0x008e:
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.b r13 = r9.f49577h
            r13.a(r10)
            r3 = 100
            r4 = 0
            r5 = 0
            r6 = 0
            com.tencent.thumbplayer.tcmedia.utils.g r10 = new com.tencent.thumbplayer.tcmedia.utils.g
            r10.<init>()
            long r7 = java.lang.System.currentTimeMillis()
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            java.lang.String r0 = "stime"
            com.tencent.thumbplayer.tcmedia.utils.g r10 = r10.a(r0, r13)
            java.util.Map r7 = r10.a()
            r2 = r9
            r2.a((int) r3, (int) r4, (int) r5, (java.lang.String) r6, (java.lang.Object) r7)
            com.tencent.thumbplayer.tcmedia.tplayer.b$b r10 = new com.tencent.thumbplayer.tcmedia.tplayer.b$b
            r10.<init>()
            com.tencent.thumbplayer.tcmedia.tplayer.c r13 = new com.tencent.thumbplayer.tcmedia.tplayer.c
            com.tencent.thumbplayer.tcmedia.e.a r0 = r9.f49590u
            java.lang.String r0 = r0.b()
            r13.<init>(r0)
            r9.f49572c = r13
            com.tencent.thumbplayer.tcmedia.tplayer.a r13 = r9.f49581l
            com.tencent.thumbplayer.tcmedia.adapter.a r13 = com.tencent.thumbplayer.tcmedia.adapter.e.a(r1, r13)
            r9.f49571b = r13
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.i) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.C0614c) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.h) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.p) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.f) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.j) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.p) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.l) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.m) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.a) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.n) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.o) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.b) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.k) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.e) r10)
            r13.a((com.tencent.thumbplayer.tcmedia.adapter.a.c.d) r10)
            if (r11 == 0) goto L_0x0105
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            if (r11 != r0) goto L_0x0115
        L_0x0105:
            com.tencent.thumbplayer.tcmedia.utils.o r11 = com.tencent.thumbplayer.tcmedia.utils.o.a()
            java.lang.String r0 = "TP-workthread"
            android.os.HandlerThread r11 = r11.a(r0)
            r9.f49578i = r11
            android.os.Looper r11 = r11.getLooper()
        L_0x0115:
            r9.f49579j = r11
            if (r12 != 0) goto L_0x012d
            android.os.Looper r11 = android.os.Looper.myLooper()
            if (r11 != 0) goto L_0x0127
            com.tencent.thumbplayer.tcmedia.tplayer.b$a r11 = new com.tencent.thumbplayer.tcmedia.tplayer.b$a
            android.os.Looper r12 = r9.f49579j
            r11.<init>(r9, r12)
            goto L_0x0132
        L_0x0127:
            com.tencent.thumbplayer.tcmedia.tplayer.b$a r11 = new com.tencent.thumbplayer.tcmedia.tplayer.b$a
            r11.<init>(r9)
            goto L_0x0132
        L_0x012d:
            com.tencent.thumbplayer.tcmedia.tplayer.b$a r11 = new com.tencent.thumbplayer.tcmedia.tplayer.b$a
            r11.<init>(r9, r12)
        L_0x0132:
            r9.f49580k = r11
            r1 = 101(0x65, float:1.42E-43)
            r2 = 0
            r3 = 0
            r4 = 0
            com.tencent.thumbplayer.tcmedia.utils.g r11 = new com.tencent.thumbplayer.tcmedia.utils.g
            r11.<init>()
            long r5 = java.lang.System.currentTimeMillis()
            java.lang.Long r12 = java.lang.Long.valueOf(r5)
            java.lang.String r0 = "etime"
            com.tencent.thumbplayer.tcmedia.utils.g r11 = r11.a(r0, r12)
            java.util.Map r5 = r11.a()
            r0 = r9
            r0.a((int) r1, (int) r2, (int) r3, (java.lang.String) r4, (java.lang.Object) r5)
            android.os.Looper r11 = r9.f49579j
            com.tencent.thumbplayer.tcmedia.tplayer.a r12 = r9.f49581l
            com.tencent.thumbplayer.tcmedia.c.a r11 = com.tencent.thumbplayer.tcmedia.c.c.a(r11, r12)
            r9.f49573d = r11
            r11.a((com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener) r10)
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.b r10 = r9.f49577h
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.a r11 = new com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.a
            r11.<init>()
            r10.a(r11)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r9.f49586q = r10
            boolean r10 = com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig.getNewReportEnable()
            if (r10 == 0) goto L_0x019d
            com.tencent.thumbplayer.tcmedia.tplayer.a.g r10 = new com.tencent.thumbplayer.tcmedia.tplayer.a.g
            com.tencent.thumbplayer.tcmedia.tplayer.a r11 = r9.f49581l
            android.content.Context r11 = r11.a()
            r10.<init>(r11)
            r9.f49593y = r10
            com.tencent.thumbplayer.tcmedia.common.a r11 = new com.tencent.thumbplayer.tcmedia.common.a
            r11.<init>(r13)
            r10.a((com.tencent.thumbplayer.tcmedia.tplayer.a.a.a) r11)
            com.tencent.thumbplayer.tcmedia.tplayer.a.g r10 = r9.f49593y
            r10.a()
            com.tencent.thumbplayer.tcmedia.tplayer.a r10 = r9.f49581l
            com.tencent.thumbplayer.tcmedia.d.c r10 = r10.b()
            com.tencent.thumbplayer.tcmedia.tplayer.a.g r11 = r9.f49593y
            r10.a((com.tencent.thumbplayer.tcmedia.d.a) r11)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.tplayer.b.<init>(android.content.Context, android.os.Looper, android.os.Looper, com.tencent.thumbplayer.tcmedia.e.b):void");
    }

    private int a(String str) {
        if (this.f49573d.a()) {
            return 5;
        }
        return r.a(str);
    }

    private long a(long j11, String str) {
        this.f49594z.put(Long.valueOf(this.A), Long.valueOf(j11));
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(str + ", convert opaque(" + j11 + ") => uniqueId(" + this.A + ")");
        long j12 = this.A;
        this.A = 1 + j12;
        return j12;
    }

    private TPVideoInfo a(TPVideoInfo tPVideoInfo, int i11, int i12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c("updateStartAndSkipEndTimeMsForDownloadParam, startTimeMs:" + i11 + ", skipEndTimeMs:" + i12);
        if (tPVideoInfo == null) {
            return new TPVideoInfo.Builder().downloadParam(b(i11, i12)).build();
        }
        ArrayList<TPDownloadParamData> downloadPraramList = tPVideoInfo.getDownloadPraramList();
        if (downloadPraramList == null || downloadPraramList.isEmpty()) {
            tPVideoInfo.getBuilder().downloadParam(b(i11, i12)).build();
            return tPVideoInfo;
        }
        Iterator<TPDownloadParamData> it2 = downloadPraramList.iterator();
        while (it2.hasNext()) {
            TPDownloadParamData next = it2.next();
            next.setStarTimeMS(i11);
            next.setEndTimeMS(i12);
        }
        return tPVideoInfo;
    }

    private void a(@TPPlayerDetailInfo.TPPlayerDetailInfoType int i11) {
        a aVar = this.f49580k;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = 1256;
            obtainMessage.obj = new TPPlayerDetailInfo(i11);
            this.f49580k.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12) {
        com.tencent.thumbplayer.tcmedia.utils.g a11 = new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a(Constants.REASON, 3);
        a(108, i11, i12, "", (Object) a11.a("code", i11 + InstructionFileId.DOT + i12).a());
        this.f49573d.a(3);
        this.f49573d.h();
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, int i13, Object obj) {
        a aVar = this.f49580k;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = i11;
            obtainMessage.arg1 = i12;
            obtainMessage.arg2 = i13;
            obtainMessage.obj = obj;
            this.f49580k.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, int i13, String str, Object obj) {
        try {
            com.tencent.thumbplayer.tcmedia.tplayer.plugins.b bVar = this.f49577h;
            if (bVar != null) {
                bVar.a(i11, i12, i13, str, obj);
            }
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, long j11, long j12, Object obj) {
        if (i11 == 200) {
            this.f49573d.a(4);
            a(114, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, 0).a("ptime", Long.valueOf(getCurrentPositionMs())).a("url", this.f49582m).a());
        } else if (i11 == 201) {
            f();
            a(115, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i11 == 3) {
            long j13 = -1;
            if (obj instanceof Long) {
                j13 = ((Long) obj).longValue();
            }
            this.f49590u.c("switch definition finish defId:".concat(String.valueOf(j13)));
            if (j13 > 0) {
                this.f49573d.a(j13);
            }
            a(121, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("switch", String.valueOf(j13)).a());
        } else if (i11 == 106) {
            a(105, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i11 == 501) {
            a(117, 0, 0, (String) null, obj);
        } else if (i11 == 107) {
            a(119, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i11 == 4) {
            a(123, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("opaque", obj).a("etime", Long.valueOf(System.currentTimeMillis())).a("code", String.valueOf(j12)).a());
        } else if (i11 == 101) {
            a(124, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
        } else if (i11 == 505 && (obj instanceof TPPlayerMsg.TPMediaDrmInfo)) {
            TPPlayerMsg.TPMediaDrmInfo tPMediaDrmInfo = (TPPlayerMsg.TPMediaDrmInfo) obj;
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c("TPMediaDrmInfo secureDecoder:" + tPMediaDrmInfo.supportSecureDecoder + " secureDecrypt:" + tPMediaDrmInfo.supportSecureDecrypt + " componentName:" + tPMediaDrmInfo.componentName + " drmType:" + tPMediaDrmInfo.drmType);
        }
    }

    /* access modifiers changed from: private */
    public void a(Message message) {
        Object obj = message.obj;
        if (obj instanceof TPPlayerDetailInfo) {
            a((TPPlayerDetailInfo) obj);
        }
    }

    private void a(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam != null) {
            if (tPOptionalParam.getKey() == 205) {
                this.f49583n = tPOptionalParam.getParamBoolean().value;
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
                aVar.c("setPlayerOptionalParam, use p2p proxy, OPTION_ID_BEFORE_BOOLEAN_USE_PROXY=" + this.f49583n);
            } else if (tPOptionalParam.getKey() == 508) {
                this.f49584o = tPOptionalParam.getParamBoolean().value;
            } else if (tPOptionalParam.getKey() == 100) {
                this.B = (int) tPOptionalParam.getParamLong().value;
            } else if (tPOptionalParam.getKey() == 500) {
                this.C = (int) tPOptionalParam.getParamLong().value;
            }
        }
    }

    private void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.onDetailInfo(this, tPPlayerDetailInfo);
        }
    }

    /* access modifiers changed from: private */
    public void a(Object obj) {
        if (obj instanceof TPPlayerMsg.TPAudioTrackInfo) {
            if (!e()) {
                this.f49590u.e("handleSelectAudioTrack, proxy is not enable");
                return;
            }
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = (TPPlayerMsg.TPAudioTrackInfo) obj;
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c("handleSelectAudioTrack, audioTrack url:" + tPAudioTrackInfo.audioTrackUrl);
            if (!TextUtils.isEmpty(tPAudioTrackInfo.audioTrackUrl)) {
                TPDownloadParamData tPDownloadParamData = null;
                Iterator<TPOptionalParam> it2 = tPAudioTrackInfo.paramData.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    TPOptionalParam next = it2.next();
                    if (next.getKey() == 0) {
                        tPDownloadParamData = (TPDownloadParamData) next.getParamObject().objectValue;
                        break;
                    }
                }
                this.f49573d.a(tPAudioTrackInfo.audioTrackUrl, tPDownloadParamData != null ? tPDownloadParamData.getAudioTrackKeyId() : "");
                return;
            }
            try {
                this.f49573d.b();
            } catch (Exception e11) {
                this.f49590u.a(e11);
            }
        }
    }

    private void a(String str, int i11, boolean z11) {
        b.u uVar = new b.u();
        uVar.a(str);
        uVar.b(i11);
        uVar.a(z11);
        this.f49581l.b().a((b.a) uVar);
    }

    private byte[] a(String str, String str2, String str3) {
        com.tencent.thumbplayer.tcmedia.c.a aVar = this.f49573d;
        if (aVar != null) {
            return aVar.a(str, str2, str3);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public long b(long j11, String str) {
        if (!this.f49594z.containsKey(Long.valueOf(j11))) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.e(str + ", invalid uniqueId");
            return -1;
        }
        long longValue = this.f49594z.get(Long.valueOf(j11)).longValue();
        com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
        aVar2.c(str + ", convert uniqueId(" + j11 + ") => opaque(" + longValue + ")");
        return longValue;
    }

    private TPDownloadParamData b(int i11, int i12) {
        TPDownloadParamData tPDownloadParamData = new TPDownloadParamData(0);
        tPDownloadParamData.setStarTimeMS(i11);
        tPDownloadParamData.setEndTimeMS(i12);
        return tPDownloadParamData;
    }

    /* access modifiers changed from: private */
    public void b(int i11) {
        int i12 = E.get(i11, -1);
        if (i12 != -1) {
            c(i12);
        }
    }

    /* access modifiers changed from: private */
    public void b(Object obj) {
        if (obj instanceof TPPlayerMsg.TPAudioTrackInfo) {
            if (!e()) {
                this.f49590u.c("handleAudioTrackProxy, proxy not enable and use orinal url");
                return;
            }
            TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = (TPPlayerMsg.TPAudioTrackInfo) obj;
            TPDownloadParamData tPDownloadParamData = null;
            Iterator<TPOptionalParam> it2 = tPAudioTrackInfo.paramData.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                TPOptionalParam next = it2.next();
                if (next.getKey() == 0) {
                    tPDownloadParamData = (TPDownloadParamData) next.getParamObject().objectValue;
                    break;
                }
            }
            String a11 = this.f49573d.a(2, tPAudioTrackInfo.audioTrackUrl, tPDownloadParamData);
            this.f49586q.add(a11);
            tPAudioTrackInfo.proxyUrl = a11;
        }
    }

    private void b(String str) {
        b.p pVar = new b.p();
        pVar.a(str);
        this.f49581l.b().a((b.a) pVar);
    }

    /* access modifiers changed from: private */
    public void c() {
        try {
            com.tencent.thumbplayer.tcmedia.adapter.a aVar = this.f49571b;
            if (aVar != null) {
                aVar.f();
            }
        } catch (Exception e11) {
            com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
            aVar2.e("reopenPlayer has exception:" + e11.toString());
        }
    }

    /* access modifiers changed from: private */
    public void c(@TPPlayerDetailInfo.TPPlayerDetailInfoType int i11) {
        a(new TPPlayerDetailInfo(i11));
    }

    private void d() {
        this.f49571b.k();
        a(107, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a(Constants.REASON, 1).a());
        this.f49573d.a(5);
        this.f49573d.h();
        this.f49587r = -1;
        this.f49588s = -1;
        this.f49589t = -1;
    }

    private boolean e() {
        return this.f49573d.f() && TPPlayerConfig.isUseP2P() && this.f49583n;
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f49573d.a(this.f49571b.c() ? 0 : 5);
    }

    private void g() {
        e.a aVar = new e.a();
        aVar.f49619a = e() ? 1 : 0;
        a((int) TipsMessageBean.MSG_TYPE_GROUP_KICK, 1009, 0, (Object) aVar);
    }

    private boolean h() {
        int b11 = this.f49571b.b();
        return b11 == 4 || b11 == 5 || b11 == 6 || b11 == 7;
    }

    public Looper a() {
        return this.f49579j;
    }

    @n.b
    public void addAudioTrackSource(String str, String str2) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "addAudioTrackSource, url:" + str + ", name:" + str2);
        addAudioTrackSource(str, str2, (TPDownloadParamData) null);
    }

    @n.b
    public void addAudioTrackSource(String str, String str2, TPDownloadParamData tPDownloadParamData) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "addAudioTrackSource, url:" + str + ", name:" + str2 + ", downloadParamData:" + tPDownloadParamData);
        if (TextUtils.isEmpty(str2) || !com.tencent.thumbplayer.tcmedia.utils.b.b(str)) {
            this.f49590u.e("handleAddAudioSource, illegal argument.");
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            TPOptionalParam tPOptionalParam = new TPOptionalParam();
            if (tPDownloadParamData != null) {
                tPOptionalParam.buildObject(0, tPDownloadParamData);
            }
            arrayList.add(tPOptionalParam);
            Map map = null;
            if (!(tPDownloadParamData == null || tPDownloadParamData.getUrlCdnidHttpHeaderList() == null || tPDownloadParamData.getUrlCdnidHttpHeaderList().isEmpty())) {
                map = tPDownloadParamData.getUrlCdnidHttpHeaderList().get(0);
            }
            this.f49571b.a(str, (Map<String, String>) map, str2, (List<TPOptionalParam>) arrayList);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(c = true)
    public void addSubtitleSource(String str, String str2, String str3) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "addSubtitleSource, url:" + str + ", mimeType:" + str2 + ", name:" + str3);
        addSubtitleSource(str, str2, str3, (TPDownloadParamData) null);
    }

    @n.b(c = true)
    public void addSubtitleSource(String str, String str2, String str3, TPDownloadParamData tPDownloadParamData) {
        String str4;
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "addSubtitleSource, url:" + str + ", name:" + str3 + ", downloadParamData:" + tPDownloadParamData);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!e() || !com.tencent.thumbplayer.tcmedia.utils.b.b(str)) {
                str4 = str;
            } else {
                str4 = this.f49573d.a(3, str, tPDownloadParamData);
                this.f49586q.add(str4);
            }
            Map map = null;
            if (!(tPDownloadParamData == null || tPDownloadParamData.getUrlCdnidHttpHeaderList() == null || tPDownloadParamData.getUrlCdnidHttpHeaderList().isEmpty())) {
                map = tPDownloadParamData.getUrlCdnidHttpHeaderList().get(0);
            }
            this.f49571b.a(str4, (Map<String, String>) map, str2, str3);
            a(118, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(currentTimeMillis)).a("etime", Long.valueOf(System.currentTimeMillis())).a("url", str).a("name", str3).a());
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    public String b() {
        return this.f49590u.b();
    }

    @n.b(a = true)
    public void captureVideo(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "captureVideo, params:" + tPCaptureParams + ", captureCallBack:" + tPCaptureCallBack);
        try {
            this.f49571b.a(tPCaptureParams, tPCaptureCallBack);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void deselectTrack(int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "deselectTrack, trackIndex:" + i11 + ", opaque:" + j11);
        try {
            this.f49571b.b(i11, j11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void enableTPAssetResourceLoader(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener, Looper looper) {
        if (iTPAssetResourceLoaderListener != null) {
            this.f49573d.a(true);
            com.tencent.thumbplayer.tcmedia.c.a.a aVar = this.f49576g;
            if (aVar != null) {
                aVar.c();
                this.f49576g = null;
            }
            com.tencent.thumbplayer.tcmedia.c.a.b bVar = new com.tencent.thumbplayer.tcmedia.c.a.b(this.f49581l.a(), looper);
            this.f49576g = bVar;
            bVar.a(iTPAssetResourceLoaderListener);
            this.f49576g.a();
            return;
        }
        this.f49573d.a(false);
    }

    public int getBufferPercent() {
        if (this.f49571b.n() == 0) {
            return 0;
        }
        return (int) ((((float) (this.f49571b.p() - this.f49571b.o())) * 100.0f) / ((float) this.f49571b.n()));
    }

    public long getCurrentPositionMs() {
        return this.f49571b.o();
    }

    public int getCurrentState() {
        return this.f49571b.b();
    }

    public long getDurationMs() {
        return this.f49571b.n();
    }

    public ITPExtendReportController getExtendReportController() {
        return this.f49593y;
    }

    public long getPdtTimeMs(long j11) {
        TPDLProxyMsg.TPPDTInfo[] tPPDTInfoArr = this.D;
        if (!(tPPDTInfoArr == null || tPPDTInfoArr.length == 0)) {
            if (j11 >= getDurationMs()) {
                TPDLProxyMsg.TPPDTInfo[] tPPDTInfoArr2 = this.D;
                return tPPDTInfoArr2[tPPDTInfoArr2.length - 1].pdtTimeEndMS;
            }
            if (j11 <= 0) {
                return this.D[0].pdtTimeStartMS;
            }
            for (TPDLProxyMsg.TPPDTInfo tPPDTInfo : this.D) {
                float f11 = tPPDTInfo.durationStart;
                if (j11 >= ((long) (f11 * 1000.0f)) && j11 <= ((long) (tPPDTInfo.durationEnd * 1000.0f))) {
                    return Math.min(tPPDTInfo.pdtTimeStartMS + (j11 - ((long) (f11 * 1000.0f))), tPPDTInfo.pdtTimeEndMS);
                }
            }
        }
        return -1;
    }

    public long getPlayableDurationMs() {
        if (!e()) {
            return this.f49571b.p();
        }
        long j11 = this.f49588s;
        if (j11 > 0) {
            long j12 = this.f49589t;
            if (j12 > 0) {
                return (long) (((((double) j11) * 1.0d) / ((double) j12)) * ((double) this.f49571b.n()));
            }
        }
        return this.f49587r;
    }

    public ITPPlayerProxy getPlayerProxy() {
        return this.f49573d;
    }

    public int getPlayerType() {
        return this.f49571b.d();
    }

    public long getPositionMs(long j11) {
        TPDLProxyMsg.TPPDTInfo[] tPPDTInfoArr = this.D;
        if (!(tPPDTInfoArr == null || tPPDTInfoArr.length == 0)) {
            if (j11 >= tPPDTInfoArr[tPPDTInfoArr.length - 1].pdtTimeEndMS) {
                return getDurationMs();
            }
            if (j11 <= tPPDTInfoArr[0].pdtTimeStartMS) {
                return 0;
            }
            for (TPDLProxyMsg.TPPDTInfo tPPDTInfo : tPPDTInfoArr) {
                long j12 = tPPDTInfo.pdtTimeStartMS;
                if (j11 >= j12 && j11 <= tPPDTInfo.pdtTimeEndMS) {
                    return Math.min(((long) (tPPDTInfo.durationStart * 1000.0f)) + (j11 - j12), getDurationMs());
                }
            }
        }
        return -1;
    }

    public TPProgramInfo[] getProgramInfo() {
        return this.f49571b.t();
    }

    public long getPropertyLong(int i11) {
        return this.f49571b.b(i11);
    }

    public String getPropertyString(int i11) {
        return this.f49571b.c(i11);
    }

    public ITPBusinessReportManager getReportManager() {
        com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b bVar = this.f49574e;
        return bVar == null ? this.f49575f : bVar;
    }

    public TPTrackInfo[] getTrackInfo() {
        return this.f49571b.s();
    }

    public int getVideoHeight() {
        return this.f49571b.r();
    }

    public int getVideoWidth() {
        return this.f49571b.q();
    }

    @n.b
    public void pause() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "pause");
        this.f49571b.j();
        try {
            a(106, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
            this.f49573d.a(5);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void pauseDownload() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "pauseDownload");
        try {
            this.f49571b.a(new TPOptionalParam().buildLong(502, 0));
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
        this.f49573d.h();
    }

    @n.b
    public void prepareAsync() {
        String str = UUID.randomUUID().toString() + System.nanoTime() + "_" + TPPlayerConfig.getPlatform();
        a(1003);
        this.f49590u.c(f49569a + "prepareAsync");
        com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.b bVar = this.f49574e;
        boolean c11 = bVar != null ? bVar.c() : true;
        g gVar = this.f49593y;
        if (gVar != null) {
            gVar.a(c11);
        }
        try {
            this.f49573d.i();
            this.f49571b.h();
        } catch (RuntimeException e11) {
            this.f49590u.a((Exception) e11);
        }
        b(str);
        try {
            a(102, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a("url", this.f49582m).a("p2p", Boolean.valueOf(e())).a("flowid", str).a());
            g();
        } catch (Exception e12) {
            this.f49590u.a(e12);
        }
    }

    @n.b(a = true)
    public void release() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "release");
        this.f49571b.m();
        a(112, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a(Constants.REASON, 1).a());
        this.f49572c.a();
        this.f49573d.e();
        this.f49586q.clear();
        com.tencent.thumbplayer.tcmedia.c.a.a aVar2 = this.f49576g;
        if (aVar2 != null) {
            aVar2.c();
            this.f49576g = null;
        }
        this.f49587r = -1;
        this.f49588s = -1;
        this.f49589t = -1;
        o.a().a(this.f49578i, (Handler) this.f49580k);
        this.f49578i = null;
        this.f49580k = null;
        this.f49577h.c();
        g gVar = this.f49593y;
        if (gVar != null) {
            gVar.b();
        }
    }

    @n.b(a = true)
    public void reset() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "reset");
        if (this.f49592x) {
            this.f49590u.a(String.valueOf(this.f49591w.incrementAndGet()));
            this.f49571b.a(this.f49590u.a());
            this.f49572c.a(this.f49590u.a().a());
        }
        this.f49571b.l();
        a(113, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("etime", Long.valueOf(System.currentTimeMillis())).a(Constants.REASON, 1).a());
        this.f49573d.d();
        this.f49585p = -1;
        this.f49586q.clear();
        com.tencent.thumbplayer.tcmedia.c.a.a aVar2 = this.f49576g;
        if (aVar2 != null) {
            aVar2.b();
        }
        a aVar3 = this.f49580k;
        if (aVar3 != null) {
            aVar3.removeCallbacksAndMessages((Object) null);
        }
        this.f49587r = -1;
        this.f49588s = -1;
        this.f49589t = -1;
        this.f49583n = true;
        this.f49584o = false;
        this.B = 0;
        this.C = 0;
        this.f49594z.clear();
        this.A = 0;
    }

    @n.b
    public void resumeDownload() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "resumeDownload");
        this.f49573d.i();
        try {
            this.f49571b.a(new TPOptionalParam().buildLong(502, 1));
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void seekTo(int i11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "seekTo, positionMs:" + i11);
        this.f49571b.a(i11);
        this.f49573d.a(1);
        a(109, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, 0).a("pstime", Long.valueOf(getCurrentPositionMs())).a());
    }

    @n.b
    public void seekTo(int i11, int i12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "seekTo, positionMs:" + i11 + ", mode:" + i12);
        if (i12 > 0) {
            this.f49571b.a(i11, i12);
        } else {
            this.f49571b.a(i11);
        }
        this.f49573d.a(1);
        a(109, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, 0).a("pstime", Long.valueOf(getCurrentPositionMs())).a());
    }

    @n.b
    public void selectProgram(int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "selectProgram, programIndex:" + i11 + ", opaque:" + j11);
        try {
            this.f49571b.c(i11, j11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void selectTrack(int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "selectTrack, trackIndex:" + i11 + ", opaque:" + j11);
        try {
            long a11 = a(j11, "selectTrack");
            TPTrackInfo[] s11 = this.f49571b.s();
            if (s11 != null && s11.length > i11) {
                a(122, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("opaque", Long.valueOf(a11)).a("tracktype", Integer.valueOf(s11[i11].getTrackType())).a("name", s11[i11].getName()).a("stime", Long.valueOf(System.currentTimeMillis())).a());
            }
            this.f49571b.a(i11, a11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(b = true)
    public void setAudioGainRatio(float f11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setAudioGainRatio, gainRatio:" + f11);
        try {
            this.f49571b.a(f11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(b = true)
    public void setAudioNormalizeVolumeParams(String str) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setAudioNormalizeVolumeParams, audioNormalizeVolumeParams:" + str);
        try {
            this.f49571b.a(str);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void setDataSource(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            throw new IllegalArgumentException("error : setDataSource , param is null");
        } else if (this.f49571b.b() == 1) {
            a("", 4, false);
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "setDataSource, AssetFileDescriptor");
            try {
                this.f49571b.a(assetFileDescriptor);
            } catch (IOException | SecurityException e11) {
                this.f49590u.a(e11);
            }
        } else {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.f49571b.b());
        }
    }

    @n.b
    public void setDataSource(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            throw new IllegalArgumentException("error : setDataSource , param is null");
        } else if (this.f49571b.b() == 1) {
            a("", 4, false);
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "setDataSource, ParcelFileDescriptor");
            try {
                this.f49571b.a(parcelFileDescriptor);
            } catch (IOException | SecurityException e11) {
                this.f49590u.a(e11);
            }
        } else {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.f49571b.b());
        }
    }

    @n.b
    public void setDataSource(ITPMediaAsset iTPMediaAsset) {
        byte[] a11;
        if (iTPMediaAsset != null) {
            if (iTPMediaAsset instanceof ITPMediaDRMAsset) {
                ITPMediaDRMAsset iTPMediaDRMAsset = (ITPMediaDRMAsset) iTPMediaAsset;
                if (iTPMediaDRMAsset.getDrmAllProperties() == null || iTPMediaDRMAsset.getDrmAllProperties().isEmpty()) {
                    throw new IllegalArgumentException("error : setDataSource , drm property is null");
                }
                if (iTPMediaDRMAsset.getDrmType() == 0 && e() && (a11 = a(TPPlayerConfig.getProxyDataDir(), iTPMediaDRMAsset.getDrmPlayUrl(), iTPMediaDRMAsset.getDrmProperty(ITPMediaDRMAsset.TP_PLAYER_DRM_PROPERTY_LICENSE_URL, ""))) != null && a11.length > 0) {
                    try {
                        iTPMediaDRMAsset.setOfflineKeySetId(Base64.encodeToString(a11, 2));
                    } catch (Exception e11) {
                        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
                        aVar.c("setOfflineKeySetId exception" + e11.getMessage());
                    }
                }
                if (TextUtils.isEmpty(iTPMediaDRMAsset.getUrl())) {
                    throw new IllegalArgumentException("error : setDataSource , drm asset url is null");
                }
            }
            if (this.f49571b.b() == 1) {
                a(iTPMediaAsset.getUrl(), a(iTPMediaAsset.getUrl()), e());
                a(1000);
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
                aVar2.c(f49569a + "setDataSource, ITPMediaAsset");
                this.f49582m = iTPMediaAsset.getUrl();
                if (e()) {
                    iTPMediaAsset = this.f49573d.a(iTPMediaAsset);
                    updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 0);
                }
                com.tencent.thumbplayer.tcmedia.e.a aVar3 = this.f49590u;
                aVar3.c("handleSetDataSource mediaAsset=" + iTPMediaAsset.getUrl());
                try {
                    this.f49571b.a(iTPMediaAsset);
                } catch (IOException | SecurityException e12) {
                    this.f49590u.a(e12);
                }
                a(1001);
                return;
            }
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.f49571b.b());
        }
        throw new IllegalArgumentException("error : setDataSource , param is null");
    }

    @n.b
    public void setDataSource(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("error : setDataSource , param is invalid");
        } else if (this.f49571b.b() == 1) {
            a(str, a(str), e());
            a(1000);
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "setDataSource, url:" + str);
            this.f49582m = str;
            com.tencent.thumbplayer.tcmedia.adapter.a.e eVar = new com.tencent.thumbplayer.tcmedia.adapter.a.e(str);
            this.f49590u.c("handleSetDataSource originalUrl=".concat(String.valueOf(str)));
            if (e()) {
                eVar = this.f49573d.a(str, (Map<String, String>) null);
                updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 0);
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
                aVar2.c("handleSetDataSource selfPlayerUrl=" + eVar.b());
                com.tencent.thumbplayer.tcmedia.e.a aVar3 = this.f49590u;
                aVar3.c("handleSetDataSource systemPlayerUrl=" + eVar.a());
            }
            this.f49571b.a(eVar);
            a(1001);
        } else {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.f49571b.b());
        }
    }

    @n.b
    public void setDataSource(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("error : setDataSource , param is invalid");
        } else if (this.f49571b.b() == 1) {
            a(str, a(str), e());
            a(1000);
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "setDataSource, url:" + str + ", httpHeader:" + map);
            this.f49582m = str;
            com.tencent.thumbplayer.tcmedia.adapter.a.e eVar = new com.tencent.thumbplayer.tcmedia.adapter.a.e(str);
            this.f49590u.c("handleSetDataSource originalUrl=".concat(String.valueOf(str)));
            if (e()) {
                eVar = this.f49573d.a(str, map);
                updateTaskInfo(TPDownloadProxyEnum.TASKINFO_GET_METADATA_PLAY_OFFSET, 0);
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
                aVar2.c("handleSetDataSource selfPlayerUrl=" + eVar.b());
                com.tencent.thumbplayer.tcmedia.e.a aVar3 = this.f49590u;
                aVar3.c("handleSetDataSource systemPlayerUrl=" + eVar.a());
            }
            this.f49571b.a(eVar, map);
            a(1001);
        } else {
            throw new IllegalStateException("error : setDataSource , state invalid. current state:" + this.f49571b.b());
        }
    }

    @n.b(b = true, c = true)
    public void setLoopback(boolean z11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setLoopback, isLoopback:" + z11);
        try {
            this.f49571b.b(z11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(b = true, c = true)
    public void setLoopback(boolean z11, long j11, long j12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setLoopback, isLoopback:" + z11 + ", loopStartPositionMs:" + j11 + ", loopEndPositionMs:" + j12);
        try {
            this.f49571b.a(z11, j11, j12);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    public void setOnAudioFrameOutputListener(ITPPlayerListener.IOnAudioFrameOutputListener iOnAudioFrameOutputListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnAudioFrameOutputListener);
        }
    }

    public void setOnAudioProcessFrameOutputListener(ITPPlayerListener.IOnAudioProcessFrameOutputListener iOnAudioProcessFrameOutputListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnAudioProcessFrameOutputListener);
        }
    }

    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnCompletionListener);
        }
    }

    public void setOnDemuxerListener(ITPPlayerListener.IOnDemuxerListener iOnDemuxerListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnDemuxerListener);
        }
    }

    public void setOnDetailInfoListener(ITPPlayerListener.IOnDetailInfoListener iOnDetailInfoListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnDetailInfoListener);
        }
    }

    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnErrorListener);
        }
    }

    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnInfoListener);
        }
    }

    public void setOnPlayerStateChangeListener(ITPPlayerListener.IOnStateChangeListener iOnStateChangeListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnStateChangeListener);
        }
    }

    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnPreparedListener);
        }
    }

    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnSeekCompleteListener);
        }
    }

    public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnStopAsyncCompleteListener);
        }
    }

    public void setOnSubtitleDataListener(ITPPlayerListener.IOnSubtitleDataListener iOnSubtitleDataListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnSubtitleDataListener);
        }
    }

    public void setOnSubtitleFrameOutListener(ITPPlayerListener.IOnSubtitleFrameOutListener iOnSubtitleFrameOutListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnSubtitleFrameOutListener);
        }
    }

    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnVideoFrameOutListener);
        }
    }

    public void setOnVideoProcessFrameOutputListener(ITPPlayerListener.IOnVideoProcessFrameOutputListener iOnVideoProcessFrameOutputListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnVideoProcessFrameOutputListener);
        }
    }

    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        c cVar = this.f49572c;
        if (cVar != null) {
            cVar.a(iOnVideoSizeChangedListener);
        }
    }

    @n.b(b = true)
    public void setOutputMute(boolean z11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setOutputMute, isOutputMute:" + z11);
        try {
            this.f49571b.a(z11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(b = true)
    public void setPlaySpeedRatio(float f11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setPlaySpeedRatio, speedRatio:" + f11);
        try {
            this.f49573d.a(f11);
            this.f49571b.b(f11);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
        a(116, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a(InnerShareParams.SCENCE, Float.valueOf(f11)).a());
    }

    @n.b(c = true)
    public void setPlayerOptionalParam(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam.getParamType() != 7 || j.a(tPOptionalParam.getKey(), tPOptionalParam.getParamObject().objectValue)) {
            a(tPOptionalParam);
            this.f49573d.a(tPOptionalParam);
            try {
                this.f49571b.a(tPOptionalParam);
            } catch (Exception e11) {
                this.f49590u.a(e11);
            }
        } else {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.d("set object param failed, optional id:" + tPOptionalParam.getKey());
        }
    }

    @n.b
    public void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        this.f49571b.a(iTPRichMediaSynchronizer);
    }

    @n.b
    public void setSurface(Surface surface) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setSurface, surface:" + surface);
        try {
            this.f49571b.a(surface);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "setSurfaceHolder, SurfaceHolder:" + surfaceHolder);
        try {
            this.f49571b.a(surfaceHolder);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(c = true)
    public void setVideoInfo(TPVideoInfo tPVideoInfo) {
        if (tPVideoInfo != null) {
            try {
                a(tPVideoInfo, this.B, this.C);
                this.f49573d.a(tPVideoInfo);
                this.f49571b.a(tPVideoInfo);
            } catch (Exception e11) {
                this.f49590u.a(e11);
            }
        }
    }

    @n.b
    public void start() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "start");
        this.f49571b.i();
        try {
            a(104, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("stime", Long.valueOf(System.currentTimeMillis())).a());
            this.f49573d.a(0);
        } catch (Exception e11) {
            this.f49590u.a(e11);
        }
    }

    @n.b(a = true)
    public void stop() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "stop");
        d();
    }

    @n.b
    public void stopAsync() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "stopAsync");
        d();
        a(280, 0, 0, (Object) null);
    }

    @n.b(b = true, c = true)
    public void switchDefinition(ITPMediaAsset iTPMediaAsset, long j11, TPVideoInfo tPVideoInfo) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "switchDefinition, mediaAsset:" + iTPMediaAsset + ", defID:" + j11 + ", videoInfo:" + tPVideoInfo);
        switchDefinition(iTPMediaAsset, j11, tPVideoInfo, 0);
    }

    @n.b(b = true, c = true)
    public void switchDefinition(ITPMediaAsset iTPMediaAsset, long j11, TPVideoInfo tPVideoInfo, int i11) {
        if (h()) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "switchDefinition, mediaAsset:" + iTPMediaAsset + ", defID:" + j11 + ", videoInfo:" + tPVideoInfo + ", mode:" + i11);
            TPVideoInfo a11 = a(tPVideoInfo, (int) getCurrentPositionMs(), this.C);
            if (e()) {
                iTPMediaAsset = this.f49573d.a(iTPMediaAsset, j11, a11);
            }
            if (iTPMediaAsset != null) {
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
                aVar2.c("handleSwitchDef, proxyMediaAsset:" + iTPMediaAsset + ", defID:" + j11);
                this.f49571b.b(a11);
                this.f49571b.a(iTPMediaAsset, 0, j11);
                a(120, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("switch", String.valueOf(j11)).a());
                return;
            }
            return;
        }
        throw new IllegalStateException("error : switchDefinition , state invalid");
    }

    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j11, TPVideoInfo tPVideoInfo) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "switchDefinition, defUrl:" + str + ", defID:" + j11);
        switchDefinition(str, j11, tPVideoInfo, 0);
    }

    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j11, TPVideoInfo tPVideoInfo, int i11) {
        if (h()) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "switchDefinition, defUrl:" + str + ", defID:" + j11 + ", mode:" + i11);
            TPVideoInfo a11 = a(tPVideoInfo, (int) getCurrentPositionMs(), this.C);
            com.tencent.thumbplayer.tcmedia.adapter.a.e eVar = new com.tencent.thumbplayer.tcmedia.adapter.a.e(str);
            if (e()) {
                eVar = this.f49573d.a(j11, str, a11, (Map<String, String>) null);
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
                aVar2.c("switchDefinition selfPlayerUrl=" + eVar.b());
                com.tencent.thumbplayer.tcmedia.e.a aVar3 = this.f49590u;
                aVar3.c("switchDefinition systemPlayerUrl=" + eVar.a());
            }
            com.tencent.thumbplayer.tcmedia.e.a aVar4 = this.f49590u;
            aVar4.c("switchDefinition, proxyUrl:" + str + ", defID:" + j11);
            this.f49571b.b(a11);
            this.f49571b.a(eVar, i11, j11);
            a(120, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("switch", String.valueOf(j11)).a());
            return;
        }
        throw new IllegalStateException("error : switchDefinition , state invalid");
    }

    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j11, TPVideoInfo tPVideoInfo, Map<String, String> map) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
        aVar.c(f49569a + "switchDefinition, defUrl:" + str + ", defID:" + j11 + ", videoInfo:" + tPVideoInfo + ", httpHeader:" + map);
        switchDefinition(str, j11, tPVideoInfo, map, 0);
    }

    @n.b(b = true, c = true)
    public void switchDefinition(String str, long j11, TPVideoInfo tPVideoInfo, Map<String, String> map, int i11) {
        String str2 = str;
        long j12 = j11;
        Map<String, String> map2 = map;
        if (h()) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f49590u;
            aVar.c(f49569a + "switchDefinition, defUrl:" + str2 + ", defID:" + j12 + ", httpHeader:" + map2 + ", mode:" + i11);
            TPVideoInfo a11 = a(tPVideoInfo, (int) getCurrentPositionMs(), this.C);
            com.tencent.thumbplayer.tcmedia.adapter.a.e eVar = new com.tencent.thumbplayer.tcmedia.adapter.a.e(str2);
            if (e()) {
                eVar = this.f49573d.a(j11, str, a11, map);
                com.tencent.thumbplayer.tcmedia.e.a aVar2 = this.f49590u;
                aVar2.c("switchDefinition selfPlayerUrl=" + eVar.b());
                com.tencent.thumbplayer.tcmedia.e.a aVar3 = this.f49590u;
                aVar3.c("switchDefinition systemPlayerUrl=" + eVar.a());
            }
            com.tencent.thumbplayer.tcmedia.adapter.a.e eVar2 = eVar;
            com.tencent.thumbplayer.tcmedia.e.a aVar4 = this.f49590u;
            aVar4.c("switchDefinition, proxyUrl:" + str2 + ", defID:" + j12 + ", httpHeader:" + map2);
            this.f49571b.b(a11);
            this.f49571b.a(eVar2, map, i11, j11);
            a(120, 0, 0, (String) null, (Object) new com.tencent.thumbplayer.tcmedia.utils.g().a("switch", String.valueOf(j11)).a());
            return;
        }
        throw new IllegalStateException("error : switchDefinition , state invalid");
    }

    public void updateLoggerContext(com.tencent.thumbplayer.tcmedia.e.b bVar) {
        if (bVar != null) {
            this.f49592x = false;
            this.f49590u.a(new com.tencent.thumbplayer.tcmedia.e.b(bVar, "TPPlayer"));
            this.f49571b.a(this.f49590u.a());
            this.f49572c.a(this.f49590u.a().a());
        }
    }

    @n.b
    public void updateTaskInfo(String str, Object obj) {
        com.tencent.thumbplayer.tcmedia.c.a aVar = this.f49573d;
        if (aVar != null) {
            aVar.a(str, obj);
        }
    }
}
