package com.tencent.thumbplayer.tcmedia.adapter.a.b;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.tencent.thumbplayer.tcmedia.adapter.a.b.c;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.adapter.g;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.api.TPAudioAttributes;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureParams;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPDashFormat;
import com.tencent.thumbplayer.tcmedia.api.TPHlsTag;
import com.tencent.thumbplayer.tcmedia.api.TPJitterBufferConfig;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.core.common.TPAudioFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPDetailInfo;
import com.tencent.thumbplayer.tcmedia.core.common.TPGeneralError;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaTrackHlsTag;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaTrackInfo;
import com.tencent.thumbplayer.tcmedia.core.common.TPPostProcessFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPSubtitleFrame;
import com.tencent.thumbplayer.tcmedia.core.common.TPVideoFrame;
import com.tencent.thumbplayer.tcmedia.core.demuxer.ITPNativeDemuxerCallback;
import com.tencent.thumbplayer.tcmedia.core.demuxer.TPNativeRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.core.imagegenerator.TPImageGeneratorParams;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerAudioFrameCallback;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerEventRecordCallback;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerPostProcessFrameCallback;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerSubtitleFrameCallback;
import com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerVideoFrameCallback;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayer;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerProgramInfo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class b implements com.tencent.thumbplayer.tcmedia.adapter.a.b {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<Integer> f48821a = new HashSet<Integer>() {
        {
            add(503);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private TPNativePlayer f48822b;

    /* renamed from: c  reason: collision with root package name */
    private TPNativePlayerInitConfig f48823c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f48824d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public g f48825e;

    /* renamed from: f  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.adapter.a.a f48826f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TPSubtitleData f48827g = new TPSubtitleData();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public com.tencent.thumbplayer.tcmedia.e.a f48828h;

    /* renamed from: i  reason: collision with root package name */
    private ITPNativePlayerMessageCallback f48829i = new ITPNativePlayerMessageCallback() {
        private void a(int i11, Object obj) {
            if (b.this.f48824d != null) {
                Message.obtain(b.this.f48824d, i11, obj).sendToTarget();
            }
        }

        public void onASyncCallResult(int i11, long j11, int i12, int i13) {
            com.tencent.thumbplayer.tcmedia.e.a a11 = b.this.f48828h;
            a11.c("onASyncCallResult, callType:" + i11 + ", opaque:" + j11 + ", errorType:" + i12 + ", errorCode:" + i13);
            C0613b bVar = new C0613b();
            bVar.f48845a = i11;
            bVar.f48846b = j11;
            bVar.f48847c = i12;
            bVar.f48848d = i13;
            a(1, bVar);
        }

        public void onDetailInfo(TPDetailInfo tPDetailInfo) {
            com.tencent.thumbplayer.tcmedia.e.a a11 = b.this.f48828h;
            a11.c("onDetailInfo, type:" + tPDetailInfo.type + ", time:" + tPDetailInfo.timeSince1970Us);
            a(5, tPDetailInfo);
        }

        public void onError(int i11, int i12) {
            com.tencent.thumbplayer.tcmedia.e.a a11 = b.this.f48828h;
            a11.c("onError, msgType:" + i11 + ", errorCode:" + i12);
            c cVar = new c();
            cVar.f48849a = i11;
            cVar.f48850b = i12;
            a(4, cVar);
        }

        public void onInfoLong(int i11, long j11, long j12) {
            if (i11 == 253) {
                a.b(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapDrmType.class, (int) j11));
                return;
            }
            d dVar = new d();
            dVar.f48851a = i11;
            dVar.f48852b = j11;
            dVar.f48853c = j12;
            a(2, dVar);
        }

        public void onInfoObject(int i11, Object obj) {
            if (!b.this.d(i11)) {
                com.tencent.thumbplayer.tcmedia.e.a a11 = b.this.f48828h;
                a11.c("onInfoObject, infoType:" + i11 + ", objParam:" + obj);
            }
            e eVar = new e();
            eVar.f48854a = i11;
            eVar.f48855b = obj;
            a(3, eVar);
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private ITPNativePlayerAudioFrameCallback f48830j = new ITPNativePlayerAudioFrameCallback() {
        public void onAudioFrame(TPAudioFrame tPAudioFrame, int i11) {
            b.this.f48825e.a(c.a(tPAudioFrame));
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private ITPNativePlayerVideoFrameCallback f48831k = new ITPNativePlayerVideoFrameCallback() {
        public void onVideoFrame(TPVideoFrame tPVideoFrame, int i11) {
            b.this.f48825e.a(c.a(tPVideoFrame));
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private ITPNativePlayerSubtitleFrameCallback f48832l = new ITPNativePlayerSubtitleFrameCallback() {
        public void onSubtitleFrame(TPSubtitleFrame tPSubtitleFrame, int i11) {
            b.this.f48825e.a(c.a(tPSubtitleFrame));
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private ITPNativePlayerPostProcessFrameCallback f48833m = new ITPNativePlayerPostProcessFrameCallback() {
        public TPPostProcessFrame onPostProcessFrame(TPPostProcessFrame tPPostProcessFrame, int i11) {
            TPPostProcessFrameBuffer b11;
            TPPostProcessFrameBuffer a11 = c.a(tPPostProcessFrame);
            a11.eventFlag = i11;
            int i12 = tPPostProcessFrame.mediaType;
            if (i12 == 0) {
                b11 = b.this.f48825e.a(a11);
            } else if (i12 != 1) {
                return null;
            } else {
                b11 = b.this.f48825e.b(a11);
            }
            return c.a(b11);
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private ITPNativeDemuxerCallback f48834n = new ITPNativeDemuxerCallback() {
        public void onDurationUpdated() {
            b.this.f48825e.d();
        }

        public TPNativeRemoteSdpInfo onSdpExchange(String str, int i11) {
            return c.a(b.this.f48825e.a(str, i11));
        }
    };

    /* renamed from: o  reason: collision with root package name */
    private ITPNativePlayerEventRecordCallback f48835o = new ITPNativePlayerEventRecordCallback() {
        public void onDrmInfo(TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            if (tPPlayerDrmParams == null) {
                b.this.f48828h.e("Native DrmInfo is null!");
                return;
            }
            b.this.f48828h.c("onDrmInfo");
            b.this.f48825e.a(c.a(tPPlayerDrmParams));
        }
    };

    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<b> f48844b;

        public a(Looper looper, b bVar) {
            super(looper);
            this.f48844b = new WeakReference<>(bVar);
        }

        private void a(@TPCommonEnum.NativeErrorType int i11, int i12) {
            b.this.f48825e.a(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapErrorType.class, i11), i12, 0, 0);
        }

        private void a(C0613b bVar) {
            int i11 = bVar.f48845a;
            if (i11 == 1) {
                b.this.b();
            } else if (i11 != 2) {
                b.this.a(bVar);
            } else {
                b.this.c();
            }
        }

        private void a(d dVar) {
            int i11 = dVar.f48851a;
            if (i11 == 154) {
                b.this.d();
            } else if (i11 != 250) {
                b.this.a(i11, dVar);
            } else {
                b.this.a(dVar.f48852b, dVar.f48853c);
            }
        }

        private void a(e eVar) {
            int i11 = eVar.f48854a;
            if (i11 != 502) {
                b.this.a(i11, eVar);
            } else if (eVar.f48855b instanceof String) {
                b.this.f48827g.subtitleData = (String) eVar.f48855b;
                b.this.f48825e.a(b.this.f48827g);
            }
        }

        private void a(TPDetailInfo tPDetailInfo) {
            b.this.f48825e.a(c.a(tPDetailInfo));
        }

        public void handleMessage(Message message) {
            if (((b) this.f48844b.get()) == null) {
                b.this.f48828h.e("mWeakRef is null");
                return;
            }
            int i11 = message.what;
            if (i11 == 1) {
                a((C0613b) message.obj);
            } else if (i11 == 2) {
                a((d) message.obj);
            } else if (i11 == 3) {
                a((e) message.obj);
            } else if (i11 == 4) {
                c cVar = (c) message.obj;
                a(cVar.f48849a, cVar.f48850b);
            } else if (i11 != 5) {
                com.tencent.thumbplayer.tcmedia.e.a a11 = b.this.f48828h;
                a11.d("message :" + message.what + "  not recognition");
            } else {
                a((TPDetailInfo) message.obj);
            }
        }
    }

    /* renamed from: com.tencent.thumbplayer.tcmedia.adapter.a.b.b$b  reason: collision with other inner class name */
    public static class C0613b {
        @TPCommonEnum.NativeMsgInfo

        /* renamed from: a  reason: collision with root package name */
        public int f48845a;

        /* renamed from: b  reason: collision with root package name */
        public long f48846b;

        /* renamed from: c  reason: collision with root package name */
        public int f48847c;

        /* renamed from: d  reason: collision with root package name */
        public int f48848d;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f48849a;

        /* renamed from: b  reason: collision with root package name */
        public int f48850b;
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f48851a;

        /* renamed from: b  reason: collision with root package name */
        public long f48852b;

        /* renamed from: c  reason: collision with root package name */
        public long f48853c;
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f48854a;

        /* renamed from: b  reason: collision with root package name */
        public Object f48855b;
    }

    public b(Context context, com.tencent.thumbplayer.tcmedia.e.b bVar) {
        this.f48828h = new com.tencent.thumbplayer.tcmedia.e.a(bVar, "TPThumbPlayer");
        TPNativePlayer tPNativePlayer = new TPNativePlayer(context);
        this.f48822b = tPNativePlayer;
        tPNativePlayer.setMessageCallback(this.f48829i);
        this.f48822b.setAudioFrameCallback(this.f48830j);
        this.f48822b.setVideoFrameCallback(this.f48831k);
        this.f48822b.setSubtitleFrameCallback(this.f48832l);
        this.f48822b.setPostProcessFrameCallback(this.f48833m);
        this.f48822b.setDemuxerCallback(this.f48834n);
        this.f48822b.setEventRecordCallback(this.f48835o);
        this.f48823c = new TPNativePlayerInitConfig();
        this.f48825e = new g(this.f48828h.b());
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.f48824d = new a(myLooper, this);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.f48824d = new a(mainLooper, this);
        } else {
            this.f48824d = null;
        }
    }

    private TPProgramInfo a(TPNativePlayerProgramInfo tPNativePlayerProgramInfo) {
        if (tPNativePlayerProgramInfo == null) {
            return null;
        }
        TPProgramInfo tPProgramInfo = new TPProgramInfo();
        tPProgramInfo.url = tPNativePlayerProgramInfo.url;
        tPProgramInfo.bandwidth = tPNativePlayerProgramInfo.bandwidth;
        tPProgramInfo.resolution = tPNativePlayerProgramInfo.resolution;
        tPProgramInfo.programId = tPNativePlayerProgramInfo.programId;
        tPProgramInfo.actived = tPNativePlayerProgramInfo.actived;
        return tPProgramInfo;
    }

    private TPTrackInfo a(TPMediaTrackInfo tPMediaTrackInfo) {
        TPTrackInfo tPTrackInfo = new TPTrackInfo();
        tPTrackInfo.name = tPMediaTrackInfo.trackName;
        tPTrackInfo.trackType = tPMediaTrackInfo.trackType;
        int i11 = tPMediaTrackInfo.contianerType;
        tPTrackInfo.containerType = i11;
        if (i11 == 1) {
            TPHlsTag tPHlsTag = tPTrackInfo.hlsTag;
            TPMediaTrackHlsTag tPMediaTrackHlsTag = tPMediaTrackInfo.hlsTag;
            tPHlsTag.name = tPMediaTrackHlsTag.name;
            tPHlsTag.bandwidth = tPMediaTrackHlsTag.bandwidth;
            tPHlsTag.resolution = tPMediaTrackHlsTag.resolution;
            tPHlsTag.framerate = tPMediaTrackHlsTag.framerate;
            tPHlsTag.codecs = tPMediaTrackHlsTag.codecs;
            tPHlsTag.groupId = tPMediaTrackHlsTag.groupId;
            String str = tPMediaTrackHlsTag.language;
            tPHlsTag.language = str;
            tPTrackInfo.language = str;
        } else if (i11 == 2) {
            TPDashFormat a11 = c.a(tPMediaTrackInfo.dashFormat);
            tPTrackInfo.dashFormat = a11;
            tPTrackInfo.language = a11.language;
        }
        tPTrackInfo.isExclusive = tPMediaTrackInfo.isExclusive;
        tPTrackInfo.isSelected = tPMediaTrackInfo.isSelected;
        tPTrackInfo.isInternal = tPMediaTrackInfo.isInternal;
        return tPTrackInfo;
    }

    private void a() {
        if (this.f48822b == null) {
            throw new IllegalStateException("player has release");
        }
    }

    /* access modifiers changed from: private */
    public void a(@TPCommonEnum.NativeErrorType int i11, d dVar) {
        long j11;
        Class cls;
        int tPIntValue = TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, i11);
        if (tPIntValue < 0) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.d("msgType:" + i11 + ", cannot convert to thumbPlayer Info");
            return;
        }
        long j12 = dVar.f48852b;
        long j13 = dVar.f48853c;
        if (tPIntValue == 203) {
            cls = TPNativeKeyMap.MapAudioDecoderType.class;
        } else if (tPIntValue != 204) {
            this.f48828h.d("unhandled thumbPlayerInfo=".concat(String.valueOf(tPIntValue)));
            j11 = j12;
            this.f48825e.a(tPIntValue, j11, j13, (Object) null);
        } else {
            cls = TPNativeKeyMap.MapVideoDecoderType.class;
        }
        j11 = (long) TPNativeKeyMapUtil.toTPIntValue(cls, (int) j12);
        this.f48825e.a(tPIntValue, j11, j13, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003f, code lost:
        r7 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0040, code lost:
        r8.f48825e.a(r2, 0, 0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r7 = r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@com.tencent.thumbplayer.tcmedia.api.TPCommonEnum.NativeMsgInfo int r9, com.tencent.thumbplayer.tcmedia.adapter.a.b.b.e r10) {
        /*
            r8 = this;
            java.lang.Class<com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap$MapMsgInfo> r0 = com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMap.MapMsgInfo.class
            int r2 = com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil.toTPIntValue(r0, r9)
            if (r2 < 0) goto L_0x004a
            java.lang.Object r10 = r10.f48855b
            if (r10 != 0) goto L_0x000d
            goto L_0x004a
        L_0x000d:
            switch(r2) {
                case 500: goto L_0x0039;
                case 501: goto L_0x0010;
                case 502: goto L_0x0032;
                case 503: goto L_0x002b;
                case 504: goto L_0x0010;
                case 505: goto L_0x0024;
                case 506: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            r7 = r10
            goto L_0x0040
        L_0x0012:
            java.lang.String r10 = (java.lang.String) r10
            com.tencent.thumbplayer.tcmedia.e.a r9 = r8.f48828h
            java.lang.String r0 = java.lang.String.valueOf(r10)
            java.lang.String r1 = "TP_PLAYER_INFO_OBJECT_SUBTITLE_NOTE:"
            java.lang.String r0 = r1.concat(r0)
            r9.c(r0)
            goto L_0x0010
        L_0x0024:
            com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback$MediaDrmInfo r10 = (com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.MediaDrmInfo) r10
            com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPMediaDrmInfo r9 = com.tencent.thumbplayer.tcmedia.adapter.a.b.c.a((com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.MediaDrmInfo) r10)
            goto L_0x003f
        L_0x002b:
            com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback$VideoSeiInfo r10 = (com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo) r10
            com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPVideoSeiInfo r9 = com.tencent.thumbplayer.tcmedia.adapter.a.b.c.a((com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.VideoSeiInfo) r10)
            goto L_0x003f
        L_0x0032:
            com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback$MediaCodecInfo r10 = (com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo) r10
            com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPMediaCodecInfo r9 = com.tencent.thumbplayer.tcmedia.adapter.a.b.c.a((com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.MediaCodecInfo) r10)
            goto L_0x003f
        L_0x0039:
            com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback$VideoCropInfo r10 = (com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.VideoCropInfo) r10
            com.tencent.thumbplayer.tcmedia.api.TPPlayerMsg$TPVideoCropInfo r9 = com.tencent.thumbplayer.tcmedia.adapter.a.b.c.a((com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.VideoCropInfo) r10)
        L_0x003f:
            r7 = r9
        L_0x0040:
            com.tencent.thumbplayer.tcmedia.adapter.g r1 = r8.f48825e
            r3 = 0
            r5 = 0
            r1.a((int) r2, (long) r3, (long) r5, (java.lang.Object) r7)
            return
        L_0x004a:
            com.tencent.thumbplayer.tcmedia.e.a r10 = r8.f48828h
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "msgType:"
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = ", cannot convert to thumbPlayer Info"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r10.d(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.b.b.a(int, com.tencent.thumbplayer.tcmedia.adapter.a.b.b$e):void");
    }

    private void a(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamBoolean optionalParamBoolean) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping boolean is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.b() != 3) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            this.f48823c.setBool(convertToNativeOptionalId.c(), optionalParamBoolean.value);
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamFloat optionalParamFloat) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping float is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else if (7 != convertToNativeOptionalId.b()) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID:" + convertToNativeOptionalId.c() + " is not float");
        } else {
            this.f48823c.setFloat(convertToNativeOptionalId.c(), optionalParamFloat.value);
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamLong optionalParamLong) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i11)));
            return;
        }
        int b11 = convertToNativeOptionalId.b();
        boolean z11 = true;
        if (b11 == 1) {
            this.f48823c.setLong(convertToNativeOptionalId.c(), optionalParamLong.value);
        } else if (b11 == 3) {
            TPNativePlayerInitConfig tPNativePlayerInitConfig = this.f48823c;
            int c11 = convertToNativeOptionalId.c();
            if (optionalParamLong.value <= 0) {
                z11 = false;
            }
            tPNativePlayerInitConfig.setBool(c11, z11);
        } else if (b11 != 4) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            this.f48823c.setInt(convertToNativeOptionalId.c(), (int) optionalParamLong.value);
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamObject optionalParamObject) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId == null) {
            this.f48828h.e("convertToNativeOptionalId failed, key: ".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping object is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else {
            int c11 = convertToNativeOptionalId.c();
            if (c11 == 126) {
                this.f48823c.setObject(convertToNativeOptionalId.c(), c.a((TPJitterBufferConfig) optionalParamObject.objectValue));
            } else if (c11 != 414) {
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
                aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
            } else {
                this.f48823c.setObject(convertToNativeOptionalId.c(), c.a((TPAudioAttributes) optionalParamObject.objectValue));
            }
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamQueueInt optionalParamQueueInt) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping queue_int is invalid, not found in array, id: ".concat(String.valueOf(i11)));
            return;
        }
        int[] iArr = optionalParamQueueInt.queueValue;
        if (iArr == null || iArr.length == 0) {
            this.f48828h.e("queueint params is empty in".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.b() != 5) {
            this.f48828h.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            for (int addQueueInt : optionalParamQueueInt.queueValue) {
                this.f48823c.addQueueInt(convertToNativeOptionalId.c(), addQueueInt);
            }
        }
    }

    private void a(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamQueueString optionalParamQueueString) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping queue_string is invalid, not found in array, id: ".concat(String.valueOf(i11)));
            return;
        }
        String[] strArr = optionalParamQueueString.queueValue;
        if (strArr == null || strArr.length == 0) {
            this.f48828h.e("queue String params is empty in".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.b() != 6) {
            this.f48828h.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            for (String addQueueString : optionalParamQueueString.queueValue) {
                this.f48823c.addQueueString(convertToNativeOptionalId.c(), addQueueString);
            }
        }
    }

    private void a(int i11, TPOptionalParam.OptionalParamString optionalParamString) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else if (2 != convertToNativeOptionalId.b()) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID:" + convertToNativeOptionalId.c() + " is not string");
        } else {
            this.f48823c.setString(convertToNativeOptionalId.c(), optionalParamString.value);
        }
    }

    /* access modifiers changed from: private */
    public void a(long j11, long j12) {
        this.f48825e.a(j11, j12);
    }

    /* access modifiers changed from: private */
    public void a(C0613b bVar) {
        this.f48825e.a(TPNativeKeyMapUtil.toTPIntValue(TPNativeKeyMap.MapMsgInfo.class, bVar.f48845a), (long) bVar.f48847c, (long) bVar.f48848d, (Object) Long.valueOf(bVar.f48846b));
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f48825e.a();
    }

    private void b(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamBoolean optionalParamBoolean) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.b() != 3) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            this.f48822b.setOptionLong(convertToNativeOptionalId.c(), optionalParamBoolean.value ? 1 : 0, 0);
        }
    }

    private void b(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamLong optionalParamLong) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping long is invalid, not found in array, id: ".concat(String.valueOf(i11)));
            return;
        }
        int b11 = convertToNativeOptionalId.b();
        if (b11 == 1 || b11 == 3 || b11 == 4) {
            this.f48822b.setOptionLong(convertToNativeOptionalId.c(), optionalParamLong.value, optionalParamLong.param1);
            return;
        }
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
    }

    private void b(int i11, TPOptionalParam.OptionalParamObject optionalParamObject) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId == null) {
            this.f48828h.e("player optionaIdMapping object is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.c() != 1001) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            this.f48822b.setOptionObject(convertToNativeOptionalId.c(), c.a((TPSubtitleRenderModel) optionalParamObject.objectValue));
        }
    }

    private void b(@TPCommonEnum.TPOptionalId int i11, TPOptionalParam.OptionalParamString optionalParamString) {
        c.a convertToNativeOptionalId = TPNativeKeyMapUtil.convertToNativeOptionalId(i11);
        if (convertToNativeOptionalId.a()) {
            this.f48828h.e("player optionalIdMapping string is invalid, not found in array, id: ".concat(String.valueOf(i11)));
        } else if (convertToNativeOptionalId.b() != 2) {
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.e("optionID type:" + convertToNativeOptionalId.b() + " is not implement");
        } else {
            this.f48822b.setOptionObject(convertToNativeOptionalId.c(), optionalParamString.value);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f48825e.c();
    }

    /* access modifiers changed from: private */
    public void d() {
        this.f48825e.b();
    }

    /* access modifiers changed from: private */
    public boolean d(int i11) {
        return f48821a.contains(Integer.valueOf(i11));
    }

    public void a(float f11) {
        this.f48828h.c("setAudioGainRatio:".concat(String.valueOf(f11)));
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.setAudioVolume(f11);
        }
    }

    public void a(int i11) {
        this.f48828h.c("seekTo:".concat(String.valueOf(i11)));
        a();
        if (this.f48822b.seekToAsync(i11, 1, 0) != 0) {
            throw new IllegalStateException("seek to position:" + i11 + " failed!!");
        }
    }

    public void a(int i11, @TPCommonEnum.TPSeekMode int i12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        aVar.c("seekTo:" + i11 + " mode:" + i12);
        a();
        if (this.f48822b.seekToAsync(i11, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSeekMode.class, i12), 0) != 0) {
            throw new IllegalStateException("seek to position:" + i11 + " failed!!");
        }
    }

    public void a(int i11, long j11) {
        this.f48828h.c("selectTrack");
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.selectTrackAsync(i11, j11);
        }
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor != null) {
            int detachFd = assetFileDescriptor.getParcelFileDescriptor().detachFd();
            long startOffset = assetFileDescriptor.getStartOffset();
            long length = assetFileDescriptor.getLength();
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(detachFd);
            int detachFd2 = fromFd.detachFd();
            fromFd.close();
            assetFileDescriptor.close();
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.c("setDataSource: " + assetFileDescriptor + ", playFd: " + detachFd + ", offset: " + startOffset + ", length: " + length + ", captureFd: " + detachFd2);
            a();
            if (this.f48822b.setDataSource(detachFd, startOffset, length) == 0) {
                this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(detachFd2, startOffset, length);
                return;
            }
            throw new IllegalStateException("setDataSource url afd failed!!");
        }
        throw new IllegalStateException("setDataSource url afd is null!!");
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            int detachFd = parcelFileDescriptor.detachFd();
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(detachFd);
            int detachFd2 = fromFd.detachFd();
            fromFd.close();
            parcelFileDescriptor.close();
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.c("setDataSource: " + parcelFileDescriptor + ", playFd:" + detachFd + ", captureFd: " + detachFd2);
            a();
            if (this.f48822b.setDataSource(detachFd, 0, 0) == 0) {
                this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(detachFd2);
                return;
            }
            throw new IllegalStateException("setDataSource url pfd failed!!");
        }
        throw new IllegalStateException("setDataSource url pfd is null!!");
    }

    public void a(Surface surface) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        StringBuilder sb2 = new StringBuilder("setSurface, surface is null ? : ");
        sb2.append(surface == null);
        aVar.c(sb2.toString());
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else if (tPNativePlayer.setVideoSurface(surface) != 0) {
            throw new IllegalStateException("setSurface failed!!");
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        StringBuilder sb2 = new StringBuilder("SurfaceHolder, surfaceHolder is null ? : ");
        sb2.append(surfaceHolder == null);
        aVar.c(sb2.toString());
        if (this.f48822b == null) {
            this.f48828h.d("player has released, return");
        } else if (surfaceHolder == null || surfaceHolder.getSurface() != null) {
            if (this.f48822b.setVideoSurface(surfaceHolder == null ? null : surfaceHolder.getSurface()) != 0) {
                throw new IllegalStateException("setSurface failed!!");
            }
        } else {
            this.f48828h.e("SurfaceHolder，err.");
        }
    }

    public void a(c.a aVar) {
        this.f48825e.a(aVar);
    }

    public void a(c.b bVar) {
        this.f48825e.a(bVar);
    }

    public void a(c.C0614c cVar) {
        this.f48825e.a(cVar);
    }

    public void a(c.d dVar) {
        this.f48825e.a(dVar);
    }

    public void a(c.e eVar) {
        this.f48825e.a(eVar);
    }

    public void a(c.f fVar) {
        this.f48825e.a(fVar);
    }

    public void a(c.g gVar) {
        this.f48825e.a(gVar);
    }

    public void a(c.h hVar) {
        this.f48825e.a(hVar);
    }

    public void a(c.i iVar) {
        this.f48825e.a(iVar);
    }

    public void a(c.j jVar) {
        this.f48825e.a(jVar);
    }

    public void a(c.l lVar) {
        this.f48825e.a(lVar);
    }

    public void a(c.m mVar) {
        this.f48825e.a(mVar);
    }

    public void a(c.n nVar) {
        this.f48825e.a(nVar);
    }

    public void a(c.o oVar) {
        this.f48825e.a(oVar);
    }

    public void a(c.p pVar) {
        this.f48825e.a(pVar);
    }

    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        this.f48828h.c("captureVideo, params".concat(String.valueOf(tPCaptureParams)));
        if (this.f48826f != null) {
            TPImageGeneratorParams tPImageGeneratorParams = new TPImageGeneratorParams();
            tPImageGeneratorParams.width = tPCaptureParams.width;
            tPImageGeneratorParams.height = tPCaptureParams.height;
            tPImageGeneratorParams.format = tPCaptureParams.format;
            tPImageGeneratorParams.requestedTimeMsToleranceAfter = tPCaptureParams.requestedTimeMsToleranceAfter;
            tPImageGeneratorParams.requestedTimeMsToleranceBefore = tPCaptureParams.requestedTimeMsToleranceBefore;
            this.f48826f.a(o(), tPImageGeneratorParams, tPCaptureCallBack);
            return;
        }
        tPCaptureCallBack.onCaptureVideoFailed(TPGeneralError.UNMATCHED_STATE);
    }

    public void a(TPOptionalParam tPOptionalParam) {
        this.f48828h.c("setPlayerOptionalParam:".concat(String.valueOf(tPOptionalParam)));
        if (this.f48822b == null) {
            this.f48828h.d("player has released, return");
        } else if (tPOptionalParam.getParamType() == 1) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamBoolean());
            } else {
                b(tPOptionalParam.getKey(), tPOptionalParam.getParamBoolean());
            }
        } else if (tPOptionalParam.getParamType() == 2) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamLong());
            } else {
                b(tPOptionalParam.getKey(), tPOptionalParam.getParamLong());
            }
        } else if (tPOptionalParam.getParamType() == 6) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamFloat());
            }
        } else if (tPOptionalParam.getParamType() == 3) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamString());
            } else {
                b(tPOptionalParam.getKey(), tPOptionalParam.getParamString());
            }
        } else if (tPOptionalParam.getParamType() == 4) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamQueueInt());
            }
        } else if (tPOptionalParam.getParamType() == 5) {
            if (tPOptionalParam.getKey() < 500) {
                a(tPOptionalParam.getKey(), tPOptionalParam.getParamQueueString());
            }
        } else if (tPOptionalParam.getParamType() != 7) {
            this.f48828h.d("optionalParam param type is unknown, return");
        } else if (tPOptionalParam.getKey() < 500) {
            a(tPOptionalParam.getKey(), tPOptionalParam.getParamObject());
        } else {
            b(tPOptionalParam.getKey(), tPOptionalParam.getParamObject());
        }
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        this.f48828h.c("setDataSource: ".concat(String.valueOf(iTPMediaAsset)));
        a();
        if (iTPMediaAsset != null) {
            String url = iTPMediaAsset.getUrl();
            Map<String, String> httpHeader = iTPMediaAsset.getHttpHeader();
            if ((httpHeader == null ? this.f48822b.setDataSource(url) : this.f48822b.setDataSource(url, httpHeader)) == 0) {
                this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(url);
                return;
            }
            throw new IllegalStateException("setDataSource mediaAsset failed!!");
        }
        throw new IllegalStateException("media asset is null!");
    }

    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        aVar.c("switchDefinition mediaAsset:" + iTPMediaAsset + " opaque:" + j11);
        a();
        if (iTPMediaAsset != null) {
            int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, i11);
            Map<String, String> httpHeader = iTPMediaAsset.getHttpHeader();
            if ((httpHeader == null ? this.f48822b.switchDefinitionAsync(iTPMediaAsset.getUrl(), nativeIntValue, j11) : this.f48822b.switchDefinitionAsync(iTPMediaAsset.getUrl(), httpHeader, nativeIntValue, j11)) == 0) {
                this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(iTPMediaAsset.getUrl());
                return;
            }
            throw new IllegalStateException("switchDefinition in invalid state");
        }
    }

    public void a(com.tencent.thumbplayer.tcmedia.e.b bVar) {
        this.f48828h.a(new com.tencent.thumbplayer.tcmedia.e.b(bVar, "TPThumbPlayer"));
        if (bVar != null) {
            this.f48825e.a(this.f48828h.a().a());
        }
    }

    public void a(String str) {
        this.f48828h.c("setAudioNormalizeVolumeParams:".concat(String.valueOf(str)));
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.setAudioNormalizeVolumeParams(str);
        }
    }

    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        aVar.c("switchDefinition url:" + str + " opaque:" + j11);
        a();
        if (this.f48822b.switchDefinitionAsync(str, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, i11), j11) == 0) {
            com.tencent.thumbplayer.tcmedia.adapter.a.a aVar2 = this.f48826f;
            if (aVar2 != null) {
                aVar2.a();
                this.f48826f = null;
            }
            this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(str);
            return;
        }
        throw new IllegalStateException("switchDefinition in invalid state");
    }

    public void a(String str, Map<String, String> map) {
        this.f48828h.c("setDataSource: ".concat(String.valueOf(str)));
        a();
        if (this.f48822b.setDataSource(str, map) == 0) {
            this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(str);
            return;
        }
        throw new IllegalStateException("setDataSource url and header failed!!");
    }

    public void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        aVar.c("switchDefinition url:" + str + "httpHeader:" + map + " opaque:" + j11);
        a();
        if (this.f48822b.switchDefinitionAsync(str, map, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapSwitchDefMode.class, i11), j11) == 0) {
            com.tencent.thumbplayer.tcmedia.adapter.a.a aVar2 = this.f48826f;
            if (aVar2 != null) {
                aVar2.a();
                this.f48826f = null;
            }
            this.f48826f = new com.tencent.thumbplayer.tcmedia.a.d(str);
            return;
        }
        throw new IllegalStateException("switchDefinition in invalid state");
    }

    public void a(String str, Map<String, String> map, String str2, String str3) {
        this.f48828h.c("addSubtitleSource");
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.addSubtitleTrackSource(str, str3, map);
        }
    }

    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        this.f48828h.c("addAudioTrackSource");
        if (this.f48822b == null) {
            this.f48828h.d("player has released, return");
            return;
        }
        TPPlayerMsg.TPAudioTrackInfo tPAudioTrackInfo = new TPPlayerMsg.TPAudioTrackInfo();
        tPAudioTrackInfo.audioTrackUrl = str;
        tPAudioTrackInfo.paramData = list;
        g gVar = this.f48825e;
        if (gVar != null) {
            gVar.a(1012, 0, 0, (Object) tPAudioTrackInfo);
        }
        if (TextUtils.isEmpty(tPAudioTrackInfo.proxyUrl)) {
            this.f48822b.addAudioTrackSource(tPAudioTrackInfo.audioTrackUrl, str2, tPAudioTrackInfo.httpHeader);
        } else {
            this.f48822b.addAudioTrackSource(tPAudioTrackInfo.proxyUrl, str2, tPAudioTrackInfo.httpHeader);
        }
    }

    public void a(boolean z11) {
        this.f48828h.c("setOutputMute:".concat(String.valueOf(z11)));
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.setAudioMute(z11);
        }
    }

    public void a(boolean z11, long j11, long j12) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
        aVar.c("setLoopback:" + z11 + " loopStartPositionMs:" + j11 + " loopEndPositionMs:" + j12);
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else if (tPNativePlayer.setLoopback(z11, j11, j12) != 0) {
            throw new IllegalStateException("set loopback failed!!");
        }
    }

    public long b(int i11) {
        a();
        int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, i11);
        if (nativeIntValue >= 0) {
            return this.f48822b.getPropertyLong(nativeIntValue);
        }
        this.f48828h.d("paramId not found, return -1");
        return -1;
    }

    public void b(float f11) {
        this.f48828h.c("setPlaySpeedRatio:".concat(String.valueOf(f11)));
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.setPlaybackRate(f11);
        }
    }

    public void b(int i11, long j11) {
        this.f48828h.c("selectTrack");
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.deselectTrackAsync(i11, j11);
        }
    }

    public void b(boolean z11) {
        this.f48828h.c("setLoopback:".concat(String.valueOf(z11)));
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.setLoopback(z11, 0, -1);
        }
    }

    public TPDynamicStatisticParams c(boolean z11) {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            return null;
        }
        return tPNativePlayer.getDynamicStatisticParams(z11);
    }

    public String c(int i11) {
        this.f48828h.c("getPropertyString:".concat(String.valueOf(i11)));
        a();
        try {
            int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapPropertyId.class, i11);
            if (nativeIntValue >= 0) {
                return this.f48822b.getPropertyString(nativeIntValue);
            }
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48828h;
            aVar.d("getPropertyString, tpToNativeValue(TPNativeKeyMap.MapPropertyId.class," + i11 + "), return" + nativeIntValue);
            return "";
        } catch (IllegalArgumentException unused) {
            this.f48828h.d("paramId not found, return");
            return "";
        }
    }

    public void c(int i11, long j11) {
        this.f48828h.c("selectProgram, programIndex:".concat(String.valueOf(i11)));
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            this.f48828h.d("player has released, return");
        } else {
            tPNativePlayer.selectProgramAsync(i11, j11);
        }
    }

    public void g() {
        this.f48828h.c(C2CLoanOrderBean.LOAN_ORDER_STATE_PREPARE);
        a();
        this.f48822b.setInitConfig(this.f48823c);
        if (this.f48822b.prepare() != 0) {
            throw new IllegalStateException("prepare failed!!");
        }
    }

    public void h() {
        this.f48828h.c("prepareAsync");
        a();
        this.f48822b.setInitConfig(this.f48823c);
        if (this.f48822b.prepareAsync() != 0) {
            throw new IllegalStateException("prepareAsync failed!!");
        }
    }

    public void i() {
        this.f48828h.c("start");
        a();
        if (this.f48822b.start() != 0) {
            throw new IllegalStateException("start failed!!");
        }
    }

    public void j() {
        this.f48828h.c("pause");
        a();
        if (this.f48822b.pause() != 0) {
            throw new IllegalStateException("pause failed!!");
        }
    }

    public void k() {
        this.f48828h.c("stop");
        a();
        this.f48828h.c("stop before");
        int stop = this.f48822b.stop();
        this.f48828h.c("stop after");
        if (stop != 0) {
            throw new IllegalStateException("stop failed!!");
        }
    }

    public void l() {
        this.f48828h.c("reset");
        if (this.f48822b == null) {
            this.f48828h.d("reset, player has released.");
            return;
        }
        this.f48828h.c("reset before");
        this.f48822b.reset();
        a aVar = this.f48824d;
        if (aVar != null) {
            aVar.removeCallbacksAndMessages((Object) null);
        }
        this.f48828h.c("reset after");
    }

    public void m() {
        this.f48828h.c("release");
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            tPNativePlayer.release();
            this.f48822b = null;
        }
        com.tencent.thumbplayer.tcmedia.adapter.a.a aVar = this.f48826f;
        if (aVar != null) {
            aVar.a();
            this.f48826f = null;
        }
        a aVar2 = this.f48824d;
        if (aVar2 != null) {
            aVar2.removeCallbacksAndMessages((Object) null);
            this.f48824d = null;
        }
    }

    public long n() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            return tPNativePlayer.getDurationMs();
        }
        this.f48828h.c("player has released, return 0");
        return 0;
    }

    public long o() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            return tPNativePlayer.getCurrentPositionMs();
        }
        this.f48828h.c("player has released, return 0");
        return 0;
    }

    public long p() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            return tPNativePlayer.getBufferedDurationMs() + this.f48822b.getCurrentPositionMs();
        }
        this.f48828h.c("player has released, return 0");
        return 0;
    }

    public int q() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            return tPNativePlayer.getVideoWidth();
        }
        this.f48828h.c("player has released, return 0");
        return 0;
    }

    public int r() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            return tPNativePlayer.getVideoHeight();
        }
        this.f48828h.c("player has released, return 0");
        return 0;
    }

    public TPTrackInfo[] s() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        TPTrackInfo[] tPTrackInfoArr = null;
        if (tPNativePlayer == null) {
            this.f48828h.c("player has released, return 0");
            return null;
        }
        TPMediaTrackInfo[] trackInfo = tPNativePlayer.getTrackInfo();
        if (trackInfo != null && trackInfo.length > 0) {
            tPTrackInfoArr = new TPTrackInfo[trackInfo.length];
            for (int i11 = 0; i11 < trackInfo.length; i11++) {
                tPTrackInfoArr[i11] = a(trackInfo[i11]);
            }
        }
        return tPTrackInfoArr;
    }

    public TPProgramInfo[] t() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        TPProgramInfo[] tPProgramInfoArr = null;
        if (tPNativePlayer == null) {
            this.f48828h.c("player has released, return 0");
            return null;
        }
        TPNativePlayerProgramInfo[] programInfo = tPNativePlayer.getProgramInfo();
        if (programInfo != null && programInfo.length > 0) {
            tPProgramInfoArr = new TPProgramInfo[programInfo.length];
            for (int i11 = 0; i11 < programInfo.length; i11++) {
                tPProgramInfoArr[i11] = a(programInfo[i11]);
            }
        }
        return tPProgramInfoArr;
    }

    public long u() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer != null) {
            return tPNativePlayer.getDemuxerOffsetInFile();
        }
        this.f48828h.c("player has released, return -1");
        return -1;
    }

    public TPGeneralPlayFlowParams v() {
        TPNativePlayer tPNativePlayer = this.f48822b;
        if (tPNativePlayer == null) {
            return null;
        }
        return tPNativePlayer.getGeneralPlayFlowParams();
    }
}
