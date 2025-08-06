package com.tencent.qcloud.tuikit.tuicallengine;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMSDKConfig;
import com.tencent.imsdk.v2.V2TIMSDKListener;
import com.tencent.imsdk.v2.V2TIMSignalingListener;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;
import com.tencent.imsdk.v2.V2TIMUserStatus;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.device.TXDeviceManager;
import com.tencent.live2.impl.V2TXLiveDefInner;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.TUICommonDefine;
import com.tencent.qcloud.tuikit.TUIVideoView;
import com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine;
import com.tencent.qcloud.tuikit.tuicallengine.f.k;
import com.tencent.qcloud.tuikit.tuicallengine.f.n;
import com.tencent.qcloud.tuikit.tuicallengine.i.a;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.LiveData;
import com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog;
import com.tencent.qcloud.tuikit.tuicallengine.k.a;
import com.tencent.qcloud.tuikit.tuicallengine.k.b;
import com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import com.youth.banner.config.BannerConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends TUICallEngine {

    /* renamed from: a  reason: collision with root package name */
    public static a f48173a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f48174b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Context f48175c;

    /* renamed from: d  reason: collision with root package name */
    public com.tencent.qcloud.tuikit.tuicallengine.i.a f48176d;

    /* renamed from: e  reason: collision with root package name */
    public com.tencent.qcloud.tuikit.tuicallengine.e.b f48177e;

    /* renamed from: f  reason: collision with root package name */
    public final com.tencent.qcloud.tuikit.tuicallengine.f.j f48178f;

    /* renamed from: g  reason: collision with root package name */
    public final com.tencent.qcloud.tuikit.tuicallengine.f.a f48179g = new com.tencent.qcloud.tuikit.tuicallengine.f.a();

    /* renamed from: h  reason: collision with root package name */
    public Runnable f48180h;

    /* renamed from: i  reason: collision with root package name */
    public final Map<String, com.tencent.qcloud.tuikit.tuicallengine.f.a> f48181i = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    public boolean f48182j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f48183k;

    /* renamed from: l  reason: collision with root package name */
    public TUICommonDefine.Callback f48184l;

    /* renamed from: m  reason: collision with root package name */
    public TUICommonDefine.Callback f48185m;

    /* renamed from: n  reason: collision with root package name */
    public TUICommonDefine.Callback f48186n;

    /* renamed from: o  reason: collision with root package name */
    public final HashSet<com.tencent.qcloud.tuikit.tuicallengine.k.b> f48187o = new HashSet<>();

    /* renamed from: p  reason: collision with root package name */
    public final Map<String, com.tencent.qcloud.tuikit.tuicallengine.k.b> f48188p = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    public TRTCCloudDef.TRTCVideoEncParam f48189q;

    /* renamed from: r  reason: collision with root package name */
    public com.tencent.qcloud.tuikit.tuicallengine.h.g f48190r;

    /* renamed from: s  reason: collision with root package name */
    public float f48191s = 4.0f;

    /* renamed from: t  reason: collision with root package name */
    public final V2TIMSignalingListener f48192t;

    /* renamed from: u  reason: collision with root package name */
    public final TRTCCloudListener f48193u;

    /* renamed from: v  reason: collision with root package name */
    public final V2TIMSDKListener f48194v;

    /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$a  reason: collision with other inner class name */
    public class C0589a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.MediaType f48195a;

        public C0589a(TUICallDefine.MediaType mediaType) {
            this.f48195a = mediaType;
        }

        public void run() {
            a aVar = a.this;
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = aVar.f48176d;
            if (aVar2 != null) {
                aVar.f48179g.f48378h = true;
                aVar2.a(this.f48195a);
            }
        }
    }

    public class a0 implements a.C0604a {
        public a0() {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Status r0 = com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine.Status.None
                com.tencent.qcloud.tuikit.tuicallengine.a r1 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                com.tencent.qcloud.tuikit.tuicallengine.f.a r1 = r1.f48179g
                com.tencent.qcloud.tuikit.tuicallengine.TUICallDefine$Status r1 = r1.f48376f
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L_0x009f
                com.tencent.qcloud.tuikit.tuicallengine.a r0 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                java.util.Map<java.lang.String, com.tencent.qcloud.tuikit.tuicallengine.f.a> r0 = r0.f48181i
                int r0 = r0.size()
                if (r0 != 0) goto L_0x001a
                goto L_0x009f
            L_0x001a:
                com.tencent.qcloud.tuikit.tuicallengine.a r0 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                android.content.Context r0 = r0.f48175c
                boolean r0 = com.tencent.qcloud.tuikit.tuicallengine.utils.PermissionUtils.hasPermission(r0)
                if (r0 == 0) goto L_0x0025
                return
            L_0x0025:
                r0 = 0
                com.tencent.qcloud.tuikit.tuicallengine.a r1 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                java.util.Map<java.lang.String, com.tencent.qcloud.tuikit.tuicallengine.f.a> r1 = r1.f48181i
                java.util.Set r1 = r1.entrySet()
                java.util.Iterator r1 = r1.iterator()
                java.lang.String r2 = ""
                r3 = r2
            L_0x0035:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x004f
                java.lang.Object r0 = r1.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r2 = r0.getKey()
                r3 = r2
                java.lang.String r3 = (java.lang.String) r3
                java.lang.Object r0 = r0.getValue()
                com.tencent.qcloud.tuikit.tuicallengine.f.a r0 = (com.tencent.qcloud.tuikit.tuicallengine.f.a) r0
                goto L_0x0035
            L_0x004f:
                if (r0 == 0) goto L_0x009f
                boolean r1 = android.text.TextUtils.isEmpty(r3)
                if (r1 == 0) goto L_0x0058
                goto L_0x009f
            L_0x0058:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "queryOfflineCall, inviteId: "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = " ,callState: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r2 = " ,callScene: "
                r1.append(r2)
                com.tencent.qcloud.tuikit.tuicallengine.a r2 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                com.tencent.qcloud.tuikit.tuicallengine.i.a r2 = r2.f48176d
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "TUICallEngine"
                com.tencent.qcloud.tuikit.tuicallengine.impl.base.TUILog.i(r2, r1)
                com.tencent.qcloud.tuikit.tuicallengine.a r1 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                com.tencent.qcloud.tuikit.tuicallengine.i.a r2 = r1.f48176d
                if (r2 == 0) goto L_0x009f
                java.util.Map<java.lang.String, com.tencent.qcloud.tuikit.tuicallengine.f.a> r1 = r1.f48181i
                boolean r1 = r1.containsKey(r3)
                if (r1 == 0) goto L_0x009f
                com.tencent.qcloud.tuikit.tuicallengine.a r1 = com.tencent.qcloud.tuikit.tuicallengine.a.this
                com.tencent.qcloud.tuikit.tuicallengine.i.a r2 = r1.f48176d
                java.lang.String r4 = r0.f48373c
                java.lang.String r5 = r0.f48372b
                java.util.List<java.lang.String> r6 = r0.f48374d
                com.tencent.qcloud.tuikit.tuicallengine.signaling.SignalingData r7 = r0.f48379i
                r2.b(r3, r4, r5, r6, r7)
            L_0x009f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.tuicallengine.a.b.run():void");
        }
    }

    public class b0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48199a;

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$b0$a  reason: collision with other inner class name */
        public class C0590a implements TUICommonDefine.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48201a;

            public C0590a(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
                this.f48201a = bVar;
            }

            public void onError(int i11, String str) {
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48201a;
                bVar.f48536d.post(new b.c(i11, str));
                a.this.f48179g.f48385o.set(a.C0607a.Fail);
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar2 = a.this.f48177e;
                if (bVar2 != null) {
                    bVar2.a((long) i11, str);
                }
            }

            public void onSuccess() {
                this.f48201a.a();
            }
        }

        public b0(TUICommonDefine.Callback callback) {
            this.f48199a = callback;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48199a);
            a aVar = a.this;
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = aVar.f48176d;
            if (aVar2 != null) {
                aVar.f48179g.f48378h = true;
                aVar2.a((TUICommonDefine.Callback) new C0590a(bVar));
                return;
            }
            bVar.a(TUICallDefine.ERROR_REQUEST_REFUSED, "The current status is not waiting, Can't use this function");
            a.a(a.this);
        }
    }

    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48203a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48204b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.VideoRenderParams f48205c;

        public c(TUICommonDefine.Callback callback, String str, TUICommonDefine.VideoRenderParams videoRenderParams) {
            this.f48203a = callback;
            this.f48204b = str;
            this.f48205c = videoRenderParams;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48203a);
            if (TextUtils.isEmpty(this.f48204b)) {
                TUILog.e("TUICallEngine", "setVideoRenderParams failed, userId param doesn't exist");
                bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "userId param doesn't exist");
            } else if (this.f48205c == null) {
                TUILog.e("TUICallEngine", "setVideoRenderParams failed, renderParams doesn't exist");
                bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "renderParams doesn't exist");
            } else {
                TRTCCloudDef.TRTCRenderParams tRTCRenderParams = new TRTCCloudDef.TRTCRenderParams();
                TUICommonDefine.VideoRenderParams.FillMode fillMode = this.f48205c.fillMode;
                if (fillMode != null) {
                    tRTCRenderParams.fillMode = fillMode.ordinal();
                }
                TUICommonDefine.VideoRenderParams.Rotation rotation = this.f48205c.rotation;
                if (rotation != null) {
                    tRTCRenderParams.rotation = rotation.ordinal();
                }
                if (this.f48204b.equals(V2TIMManager.getInstance().getLoginUser())) {
                    TRTCCloud.sharedInstance(a.this.f48175c).setLocalRenderParams(tRTCRenderParams);
                } else {
                    TRTCCloud.sharedInstance(a.this.f48175c).setRemoteRenderParams(this.f48204b, 0, tRTCRenderParams);
                }
                bVar.a();
            }
        }
    }

    public class c0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48207a;

        public c0(TUICommonDefine.Callback callback) {
            this.f48207a = callback;
        }

        public void run() {
            a aVar = a.this;
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = aVar.f48176d;
            if (aVar2 != null) {
                aVar.f48179g.f48378h = true;
                aVar2.e(this.f48207a);
                return;
            }
            new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48207a).a();
            a.a(a.this);
        }
    }

    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48209a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.VideoEncoderParams f48210b;

        public d(TUICommonDefine.Callback callback, TUICommonDefine.VideoEncoderParams videoEncoderParams) {
            this.f48209a = callback;
            this.f48210b = videoEncoderParams;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48209a);
            if (this.f48210b == null) {
                TUILog.e("TUICallEngine", "setVideoEncoderParams failed, encoderParams doesn't exist");
                bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "encoderParams doesn't exist");
                return;
            }
            a aVar = a.this;
            if (aVar.f48189q == null) {
                aVar.f48189q = new TRTCCloudDef.TRTCVideoEncParam();
            }
            TUICommonDefine.VideoEncoderParams.Resolution resolution = this.f48210b.resolution;
            if (resolution != null) {
                a.this.f48189q.videoResolution = resolution.getValue();
                TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = a.this.f48189q;
                int ordinal = this.f48210b.resolution.ordinal();
                int i11 = BannerConfig.SCROLL_TIME;
                if (!(ordinal == 0 || ordinal == 1)) {
                    if (ordinal == 2) {
                        i11 = 850;
                    } else if (ordinal == 3) {
                        i11 = 1000;
                    } else if (ordinal == 4) {
                        i11 = 1200;
                    } else if (ordinal == 5) {
                        i11 = 2000;
                    }
                }
                tRTCVideoEncParam.videoBitrate = i11;
            }
            TUICommonDefine.VideoEncoderParams.ResolutionMode resolutionMode = this.f48210b.resolutionMode;
            if (resolutionMode != null) {
                a.this.f48189q.videoResolutionMode = resolutionMode.ordinal();
            }
            TRTCCloud.sharedInstance(a.this.f48175c).setVideoEncoderParam(a.this.f48189q);
            bVar.a();
        }
    }

    public class d0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48212a;

        public d0(TUICommonDefine.Callback callback) {
            this.f48212a = callback;
        }

        public void run() {
            a aVar = a.this;
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = aVar.f48176d;
            if (aVar2 != null) {
                aVar.f48179g.f48378h = true;
                aVar2.c(this.f48212a);
                return;
            }
            new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48212a).a();
            a.a(a.this);
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f48214a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48215b;

        public e(float f11, TUICommonDefine.Callback callback) {
            this.f48214a = f11;
            this.f48215b = callback;
        }

        public void run() {
            TUILog.i("TUICallEngine", "setBeautyLevel, level: " + this.f48214a);
            TXBeautyManager beautyManager = TRTCCloud.sharedInstance(a.this.f48175c).getBeautyManager();
            beautyManager.setBeautyStyle(1);
            beautyManager.setBeautyLevel(this.f48214a);
            a.this.f48191s = this.f48214a;
            new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48215b).a();
        }
    }

    public class e0 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48217a;

        public e0(TUICommonDefine.Callback callback) {
            this.f48217a = callback;
        }

        public void run() {
            a aVar = a.this;
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = aVar.f48176d;
            if (aVar2 != null) {
                aVar.f48179g.f48378h = true;
                aVar2.d(this.f48217a);
                return;
            }
            new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48217a).a();
            a.a(a.this);
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.PlayCallback f48219a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48220b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUIVideoView f48221c;

        public f(TUICommonDefine.PlayCallback playCallback, String str, TUIVideoView tUIVideoView) {
            this.f48219a = playCallback;
            this.f48220b = str;
            this.f48221c = tUIVideoView;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48219a);
            if (TextUtils.isEmpty(this.f48220b)) {
                TUILog.e("TUICallEngine", "startRemoteView failed, userId param doesn't exist");
                bVar.f48536d.post(new com.tencent.qcloud.tuikit.tuicallengine.k.e(bVar, this.f48220b, TUICallDefine.ERROR_PARAM_INVALID, "userId param doesn't exist"));
            } else if (this.f48221c == null) {
                TUILog.e("TUICallEngine", "startRemoteView failed, videoView param doesn't exist");
                bVar.f48536d.post(new com.tencent.qcloud.tuikit.tuicallengine.k.e(bVar, this.f48220b, TUICallDefine.ERROR_PARAM_INVALID, "videoView param doesn't exist"));
            } else {
                a.this.f48188p.put(this.f48220b, bVar);
                TRTCCloud.sharedInstance(a.this.f48175c).startRemoteView(this.f48220b, 0, this.f48221c);
            }
        }
    }

    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48223a;

        public g(String str) {
            this.f48223a = str;
        }

        public void run() {
            if (TextUtils.isEmpty(this.f48223a)) {
                TUILog.i("TUICallEngine", "stopRemoteView, userId is empty: " + this.f48223a);
                return;
            }
            a.this.f48188p.remove(this.f48223a);
            TRTCCloud.sharedInstance(a.this.f48175c).stopRemoteView(this.f48223a, 0);
        }
    }

    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48225a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUIVideoView f48226b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Camera f48227c;

        public h(TUICommonDefine.Callback callback, TUIVideoView tUIVideoView, TUICommonDefine.Camera camera) {
            this.f48225a = callback;
            this.f48226b = tUIVideoView;
            this.f48227c = camera;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48225a);
            if (this.f48226b == null) {
                TUILog.e("TUICallEngine", "openCamera failed, videoView param doesn't exist");
                bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "videoView param doesn't exist");
                return;
            }
            a.this.f48187o.add(bVar);
            boolean equals = TUICommonDefine.Camera.Front.equals(this.f48227c);
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
            com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
            TUIVideoView tUIVideoView = this.f48226b;
            kVar.getClass();
            TRTCCloud.sharedInstance(com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a).startLocalPreview(equals, tUIVideoView);
            kVar.f48442d = true;
        }
    }

    public class i implements Runnable {
        public i() {
        }

        public void run() {
            a.this.f48187o.clear();
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
            com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
            if (kVar.f48442d) {
                TRTCCloud.sharedInstance(com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a).stopLocalPreview();
            }
            kVar.f48442d = false;
        }
    }

    public class j implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Camera f48230a;

        public j(TUICommonDefine.Camera camera) {
            this.f48230a = camera;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
            com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
            TUICommonDefine.Camera camera = this.f48230a;
            kVar.getClass();
            TXDeviceManager deviceManager = TRTCCloud.sharedInstance(com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a).getDeviceManager();
            boolean isFrontCamera = deviceManager.isFrontCamera();
            TUICommonDefine.Camera camera2 = TUICommonDefine.Camera.Front;
            if (isFrontCamera != camera2.equals(camera)) {
                deviceManager.switchCamera(camera2.equals(camera));
            }
        }
    }

    public class k implements TUICommonDefine.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48232a;

        public k(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
            this.f48232a = bVar;
        }

        public void onError(int i11, String str) {
            TUILog.e("TUICallEngine", "init failed, errCode: " + i11 + " ,errMsg: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48232a;
            bVar.f48536d.post(new b.c(i11, str));
        }

        public void onSuccess() {
            boolean unused = a.this.f48183k = false;
            a.a(a.this, TUICallDefine.Status.None);
            this.f48232a.a();
        }
    }

    public class l implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.ValueCallback f48234a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f48235b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.CallParams f48236c;

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$l$a  reason: collision with other inner class name */
        public class C0591a implements TUICommonDefine.ValueCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48238a;

            /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$l$a$a  reason: collision with other inner class name */
            public class C0592a implements TUICommonDefine.ValueCallback {
                public C0592a() {
                }

                public void onError(int i11, String str) {
                    com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = C0591a.this.f48238a;
                    bVar.f48536d.post(new b.c(i11, str));
                }

                public void onSuccess(Object obj) {
                    C0591a.this.f48238a.a((List) obj);
                    l lVar = l.this;
                    com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = a.this.f48177e;
                    if (bVar != null) {
                        List list = lVar.f48235b;
                        if (bVar.f48325e == null) {
                            bVar.f48325e = new com.tencent.qcloud.tuikit.tuicallengine.e.l(bVar.f48321a);
                        }
                        bVar.f48325e.a(bVar.f48325e.a(com.tencent.qcloud.tuikit.tuicallengine.e.m.InviteUser, (List<String>) list), true);
                    }
                }
            }

            public C0591a(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
                this.f48238a = bVar;
            }

            public void onError(int i11, String str) {
                TUILog.e("TUICallEngine", "inviteUser failed, code: " + i11 + " ,errorMsg: " + str);
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48238a;
                bVar.f48536d.post(new b.c(i11, str));
            }

            public void onSuccess(Object obj) {
                if (obj instanceof Boolean) {
                    if (!((Boolean) obj).booleanValue()) {
                        TUILog.e("TUICallEngine", "inviteUser failed, errorCode: " + TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED + ", " + a.c(a.this));
                        this.f48238a.a(TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED, a.c(a.this));
                        return;
                    }
                    l lVar = l.this;
                    com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
                    if (aVar != null) {
                        aVar.a((List<String>) lVar.f48235b, lVar.f48236c, (TUICommonDefine.ValueCallback) new C0592a());
                        return;
                    }
                    TUILog.e("TUICallEngine", "inviteUser failed, The current status can't use this function");
                    this.f48238a.a(TUICallDefine.ERROR_REQUEST_REFUSED, "The current status can't use this function");
                }
            }
        }

        public l(TUICommonDefine.ValueCallback valueCallback, List list, TUICallDefine.CallParams callParams) {
            this.f48234a = valueCallback;
            this.f48235b = list;
            this.f48236c = callParams;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48234a);
            List list = this.f48235b;
            if (list == null || list.isEmpty()) {
                TUILog.e("TUICallEngine", "inviteUser failed, userIdList param doesn't exist");
                bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "userIdList param doesn't exist");
            } else if (!TUICallDefine.Role.Called.equals(a.this.f48179g.f48375e) || TUICallDefine.Status.Accept.equals(a.this.f48179g.f48376f)) {
                com.tencent.qcloud.tuikit.tuicallengine.e.o.a(131072, (TUICommonDefine.ValueCallback) new C0591a(bVar));
            } else {
                TUILog.e("TUICallEngine", "inviteUser failed, The current status is not accept, Can't use this function");
                bVar.a(TUICallDefine.ERROR_REQUEST_REFUSED, "The current status is not accept, Can't use this function");
            }
        }
    }

    public class m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48241a;

        public m(TUICommonDefine.Callback callback) {
            this.f48241a = callback;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
            k.b.f48445a.c();
            new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48241a).a();
        }
    }

    public class n implements Runnable {
        public n() {
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
            com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
            if (kVar.f48441c) {
                TRTCCloud.sharedInstance(com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a).stopLocalAudio();
            }
            kVar.f48441c = false;
        }
    }

    public class o implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48244a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48245b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48246c;

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$o$a  reason: collision with other inner class name */
        public class C0593a implements V2TIMCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48247a;

            public C0593a(o oVar, com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
                this.f48247a = bVar;
            }

            public void onError(int i11, String str) {
                TUILog.e("TUICallEngine", "setSelfInfo failed code:" + i11 + " msg:" + str);
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48247a;
                bVar.f48536d.post(new b.c(i11, str));
            }

            public void onSuccess() {
                TUILog.i("TUICallEngine", "setSelfInfo success.");
                this.f48247a.a();
            }
        }

        public o(a aVar, TUICommonDefine.Callback callback, String str, String str2) {
            this.f48244a = callback;
            this.f48245b = str;
            this.f48246c = str2;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48244a);
            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
            v2TIMUserFullInfo.setNickname(this.f48245b);
            v2TIMUserFullInfo.setFaceUrl(this.f48246c);
            V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, new C0593a(this, bVar));
        }
    }

    public class p implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48248a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f48249b;

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$p$a  reason: collision with other inner class name */
        public class C0594a implements TUICommonDefine.ValueCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48251a;

            public C0594a(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
                this.f48251a = bVar;
            }

            public void onError(int i11, String str) {
                boolean unused = a.this.f48182j = false;
                TUILog.e("TUICallEngine", "enableMultiDeviceAbility failed, errCode: " + i11 + ", " + str);
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48251a;
                bVar.f48536d.post(new b.c(i11, str));
            }

            public void onSuccess(Object obj) {
                if (!(obj instanceof Boolean)) {
                    TUILog.e("TUICallEngine", "enableMultiDeviceAbility, internal error");
                    return;
                }
                boolean unused = a.this.f48182j = ((Boolean) obj).booleanValue();
                if (a.this.f48182j) {
                    this.f48251a.a();
                    return;
                }
                TUILog.e("TUICallEngine", "enableMultiDeviceAbility failed, errorCode: " + TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED + " ," + a.c(a.this));
                this.f48251a.a(TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED, a.c(a.this));
            }
        }

        public p(TUICommonDefine.Callback callback, boolean z11) {
            this.f48248a = callback;
            this.f48249b = z11;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48248a);
            if (!this.f48249b) {
                boolean unused = a.this.f48182j = false;
                bVar.a();
                return;
            }
            com.tencent.qcloud.tuikit.tuicallengine.e.o.a((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE, (TUICommonDefine.ValueCallback) new C0594a(bVar));
        }
    }

    public class q implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.AudioPlaybackDevice f48253a;

        public q(TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice) {
            this.f48253a = audioPlaybackDevice;
        }

        public void run() {
            TRTCCloud.sharedInstance(a.this.f48175c).setAudioRoute(TUICommonDefine.AudioPlaybackDevice.Speakerphone.equals(this.f48253a) ^ true ? 1 : 0);
        }
    }

    public class r extends V2TIMSignalingListener {

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$r$a  reason: collision with other inner class name */
        public class C0595a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48256a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48257b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f48258c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ List f48259d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48260e;

            public C0595a(String str, String str2, String str3, List list, String str4) {
                this.f48256a = str;
                this.f48257b = str2;
                this.f48258c = str3;
                this.f48259d = list;
                this.f48260e = str4;
            }

            public void run() {
                com.tencent.qcloud.tuikit.tuicallengine.i.a aVar;
                String str;
                TUILog.i("TUICallEngine", "onReceiveNewInvitation, TUICallEngine VERSION:" + TUICallDefine.VERSION + ";\n IM Version: " + V2TIMManager.getInstance().getVersion() + ";\n TRTC Version: " + TRTCCloud.getSDKVersion());
                TUILog.i("TUICallEngine", "onReceiveNewInvitation, inviteID:" + this.f48256a + ", inviter:" + this.f48257b + ", groupID:" + this.f48258c + ", inviteeList:" + this.f48259d + " ,data:" + this.f48260e + " mCallState:" + a.this.f48179g + " ,baseCalling: " + a.this.f48176d);
                SignalingData a11 = com.tencent.qcloud.tuikit.tuicallengine.e.o.a(this.f48260e);
                SignalingData.DataInfo data = a11.getData();
                if (com.tencent.qcloud.tuikit.tuicallengine.e.o.b(a11) && data != null) {
                    List list = this.f48259d;
                    if (list == null || list.contains(V2TIMManager.getInstance().getLoginUser()) || "hangup".equals(data.getCmd())) {
                        a aVar2 = a.this;
                        if (aVar2.f48182j) {
                            com.tencent.qcloud.tuikit.tuicallengine.e.o.a((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE, (TUICommonDefine.ValueCallback) new b(aVar2));
                        }
                        if ("hangup".equals(data.getCmd()) || "lineBusy".equals(data.getCmd())) {
                            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar3 = a.this.f48176d;
                            if (aVar3 != null) {
                                aVar3.b(this.f48256a, this.f48257b, this.f48258c, this.f48259d, a11);
                                return;
                            }
                            return;
                        }
                        int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
                        if ("switch_to_audio_call".equals(a11.getSwitchToAudioCall()) || "switchToAudio".equals(data.getCmd())) {
                            if (!TUICallDefine.Status.None.equals(a.this.f48179g.f48376f) && (aVar = a.this.f48176d) != null) {
                                aVar.b(this.f48256a, this.f48257b, this.f48258c, this.f48259d, a11);
                            }
                        } else if (!a.a(a.this, this.f48257b)) {
                            if (!TUICallDefine.Status.None.equals(a.this.f48179g.f48376f)) {
                                a aVar4 = a.this;
                                if (aVar4.f48176d != null) {
                                    com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = aVar4.f48177e;
                                    if (bVar != null) {
                                        String str2 = this.f48256a;
                                        String str3 = this.f48258c;
                                        if (bVar.f48325e == null) {
                                            bVar.f48325e = new com.tencent.qcloud.tuikit.tuicallengine.e.l(bVar.f48321a);
                                        }
                                        com.tencent.qcloud.tuikit.tuicallengine.e.l lVar = bVar.f48325e;
                                        lVar.getClass();
                                        if (!TextUtils.isEmpty(data.getInitialCallId())) {
                                            str2 = data.getInitialCallId();
                                        }
                                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                                        linkedHashMap.put("command", "event_report");
                                        linkedHashMap.put("seq", Integer.valueOf(lVar.f48341b));
                                        linkedHashMap.putAll(lVar.b());
                                        linkedHashMap.put("user_id", V2TIMManager.getInstance().getLoginUser());
                                        int roomID = data.getRoomID();
                                        String strRoomId = data.getStrRoomId();
                                        if (roomID > 0) {
                                            strRoomId = String.valueOf(roomID);
                                        }
                                        if (TextUtils.isEmpty(strRoomId)) {
                                            strRoomId = "";
                                        }
                                        linkedHashMap.put("room_id", strRoomId);
                                        linkedHashMap.put("room_id_type", Integer.valueOf(data.getRoomID() > 0 ? 1 : 2));
                                        if (TextUtils.isEmpty(str3)) {
                                            str = "";
                                        } else {
                                            str = str3;
                                        }
                                        linkedHashMap.put("group_id", str);
                                        if (TextUtils.isEmpty(str2)) {
                                            str2 = "";
                                        }
                                        linkedHashMap.put(AnalyticsEvents.PARAMETER_CALL_ID, str2);
                                        linkedHashMap.put(TUIConstants.Message.CALLING_TYPE_KEY, com.tencent.qcloud.tuikit.tuicallengine.e.o.a(str3, data.getUserIDs()));
                                        String cmd = data.getCmd();
                                        TUICallDefine.MediaType mediaType = TUICallDefine.MediaType.Audio;
                                        if ("videoCall".equals(cmd)) {
                                            mediaType = TUICallDefine.MediaType.Video;
                                        }
                                        linkedHashMap.put(MessengerShareContentUtility.MEDIA_TYPE, String.valueOf(mediaType).toLowerCase());
                                        TUICallDefine.Role role = TUICallDefine.Role.Called;
                                        String str4 = role.equals(role) ? "callee" : "caller";
                                        linkedHashMap.put("role", str4);
                                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                        if ("callee".equals(str4)) {
                                            linkedHashMap2.put("event_type", lVar.a(com.tencent.qcloud.tuikit.tuicallengine.e.m.IgnoreCall));
                                        } else {
                                            linkedHashMap2.put("event_type", lVar.a(com.tencent.qcloud.tuikit.tuicallengine.e.m.CallBusy));
                                        }
                                        JSONObject jSONObject = new JSONObject();
                                        try {
                                            JSONObject jSONObject2 = new JSONObject(linkedHashMap);
                                            JSONObject jSONObject3 = new JSONObject(linkedHashMap2);
                                            jSONObject.put(TtmlNode.TAG_HEAD, jSONObject2);
                                            jSONObject.put(TtmlNode.TAG_BODY, jSONObject3);
                                        } catch (JSONException e11) {
                                            e11.printStackTrace();
                                        }
                                        bVar.f48325e.a(jSONObject.toString(), true);
                                    }
                                    a.this.f48176d.a(this.f48256a, this.f48257b, this.f48258c, this.f48259d, a11);
                                    return;
                                }
                                return;
                            }
                            a.this.f48179g.f48382l.set(this.f48256a);
                            a.this.f48179g.f48383m.set(data.getInitialCallId());
                            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar5 = a.this.f48179g;
                            aVar5.f48373c = this.f48257b;
                            aVar5.f48372b = this.f48258c;
                            aVar5.f48375e = TUICallDefine.Role.Called;
                            aVar5.f48371a = new TUICommonDefine.RoomId();
                            a.this.f48179g.f48371a.intRoomId = data.getRoomID();
                            a.this.f48179g.f48371a.strRoomId = data.getStrRoomId();
                            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar6 = a.this.f48179g;
                            aVar6.f48379i = a11;
                            aVar6.f48376f = TUICallDefine.Status.Waiting;
                            aVar6.f48374d = this.f48259d;
                            LiveData<TUICallDefine.MediaType> liveData = aVar6.f48384n;
                            String cmd2 = data.getCmd();
                            TUICallDefine.MediaType mediaType2 = TUICallDefine.MediaType.Audio;
                            if ("videoCall".equals(cmd2)) {
                                mediaType2 = TUICallDefine.MediaType.Video;
                            }
                            liveData.set(mediaType2);
                            a.this.f48179g.f48381k.f48387a.set(Boolean.TRUE);
                            a.this.f48179g.f48381k.f48389c.set(Long.valueOf(com.tencent.qcloud.tuikit.tuicallengine.e.o.b()));
                            ArrayList arrayList = new ArrayList(this.f48259d);
                            if (data.getInCallUserIDs() != null && !data.getInCallUserIDs().isEmpty()) {
                                arrayList.addAll(data.getInCallUserIDs());
                            }
                            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
                            k.b.f48445a.a();
                            a aVar7 = a.this;
                            aVar7.f48176d = aVar7.a(this.f48258c, (List<String>) arrayList);
                            a aVar8 = a.this;
                            aVar8.f48181i.put(this.f48256a, aVar8.f48179g);
                            a aVar9 = a.this;
                            String str5 = this.f48256a;
                            String str6 = this.f48257b;
                            String str7 = this.f48258c;
                            List list2 = this.f48259d;
                            aVar9.getClass();
                            c cVar = new c(aVar9, System.currentTimeMillis(), str5, str6, str7, list2, a11);
                            aVar9.f48180h = cVar;
                            a.f48174b.post(cVar);
                        }
                    }
                }
            }
        }

        public class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48262a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48263b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f48264c;

            public b(String str, String str2, String str3) {
                this.f48262a = str;
                this.f48263b = str2;
                this.f48264c = str3;
            }

            public void run() {
                if (TUICallDefine.Status.None.equals(a.this.f48179g.f48376f)) {
                    TUILog.w("TUICallEngine", "onInviteeAccepted idle state");
                    return;
                }
                SignalingData a11 = com.tencent.qcloud.tuikit.tuicallengine.e.o.a(this.f48262a);
                if (com.tencent.qcloud.tuikit.tuicallengine.e.o.b(a11)) {
                    com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
                    if (aVar != null) {
                        aVar.b(this.f48263b, this.f48264c, a11);
                    }
                    if (V2TIMManager.getInstance().getLoginUser().equals(this.f48264c)) {
                        a.this.f48181i.remove(this.f48263b);
                    }
                }
            }
        }

        public class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48266a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48267b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f48268c;

            public c(String str, String str2, String str3) {
                this.f48266a = str;
                this.f48267b = str2;
                this.f48268c = str3;
            }

            public void run() {
                if (TUICallDefine.Status.None.equals(a.this.f48179g.f48376f)) {
                    TUILog.w("TUICallEngine", "onInviteeRejected idle state");
                    return;
                }
                SignalingData a11 = com.tencent.qcloud.tuikit.tuicallengine.e.o.a(this.f48266a);
                if (com.tencent.qcloud.tuikit.tuicallengine.e.o.b(a11)) {
                    com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
                    if (aVar != null) {
                        aVar.c(this.f48267b, this.f48268c, a11);
                    }
                    if (V2TIMManager.getInstance().getLoginUser().equals(this.f48268c)) {
                        a.this.f48181i.remove(this.f48267b);
                    }
                }
            }
        }

        public class d implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48270a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f48271b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f48272c;

            public d(String str, String str2, String str3) {
                this.f48270a = str;
                this.f48271b = str2;
                this.f48272c = str3;
            }

            public void run() {
                if (TextUtils.isEmpty(this.f48270a) || !this.f48270a.equals(V2TIMManager.getInstance().getLoginUser())) {
                    SignalingData a11 = com.tencent.qcloud.tuikit.tuicallengine.e.o.a(this.f48271b);
                    if (com.tencent.qcloud.tuikit.tuicallengine.e.o.b(a11)) {
                        com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
                        if (aVar != null) {
                            aVar.a(this.f48272c, this.f48270a, a11);
                        }
                        a.this.f48181i.remove(this.f48272c);
                        return;
                    }
                    return;
                }
                TUILog.w("TUICallEngine", "onInvitationCancelled, ignore, inviter: " + this.f48270a);
            }
        }

        public class e implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f48274a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ List f48275b;

            public e(String str, List list) {
                this.f48274a = str;
                this.f48275b = list;
            }

            public void run() {
                if (TUICallDefine.Status.None.equals(a.this.f48179g.f48376f)) {
                    TUILog.w("TUICallEngine", "onInvitationTimeout idle state");
                    return;
                }
                com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
                if (aVar != null) {
                    aVar.a(this.f48274a, (List<String>) this.f48275b);
                }
                a.this.f48181i.remove(this.f48274a);
            }
        }

        public r() {
        }

        public void onInvitationCancelled(String str, String str2, String str3) {
            a.a((Runnable) new d(str2, str3, str));
        }

        public void onInvitationTimeout(String str, List<String> list) {
            a.a((Runnable) new e(str, list));
        }

        public void onInviteeAccepted(String str, String str2, String str3) {
            a.a((Runnable) new b(str3, str, str2));
        }

        public void onInviteeRejected(String str, String str2, String str3) {
            a.a((Runnable) new c(str3, str, str2));
        }

        public void onReceiveNewInvitation(String str, String str2, String str3, List<String> list, String str4) {
            a.a((Runnable) new C0595a(str, str2, str3, list, str4));
        }
    }

    public class s extends TRTCCloudListener {

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$s$a  reason: collision with other inner class name */
        public class C0596a implements TUICommonDefine.Callback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48278a;

            public C0596a(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
                this.f48278a = bVar;
            }

            public void onError(int i11, String str) {
                a.this.f48179g.f48385o.set(a.C0607a.Fail);
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = a.this.f48177e;
                if (bVar != null) {
                    bVar.a((long) i11, str);
                }
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar2 = this.f48278a;
                bVar2.f48536d.post(new b.c(i11, str));
            }

            public void onSuccess() {
                a.this.f48179g.f48381k.f48388b.set(Long.valueOf(com.tencent.qcloud.tuikit.tuicallengine.e.o.b()));
                a.this.f48179g.f48386p.set(com.tencent.qcloud.tuikit.tuicallengine.e.m.StartCall);
                this.f48278a.a();
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = a.this.f48177e;
                if (bVar.f48325e == null) {
                    bVar.f48325e = new com.tencent.qcloud.tuikit.tuicallengine.e.l(bVar.f48321a);
                }
                bVar.f48325e.a("waiting");
            }
        }

        public s() {
        }

        public void onCameraDidReady() {
            super.onCameraDidReady();
            if (!a.this.f48187o.isEmpty()) {
                Iterator it2 = new HashSet(a.this.f48187o).iterator();
                while (it2.hasNext()) {
                    com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = (com.tencent.qcloud.tuikit.tuicallengine.k.b) it2.next();
                    if (bVar != null) {
                        bVar.a();
                    }
                    a.this.f48187o.remove(bVar);
                }
            }
        }

        public void onEnterRoom(long j11) {
            TUILog.i("TUICallEngine", "onEnterRoom, result: " + j11 + " ,mCallState: " + a.this.f48179g);
            if (j11 < 0) {
                com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
                if (jVar != null) {
                    jVar.a(V2TIMManager.getInstance().getLoginUser());
                }
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = a.this.f48177e;
                if (bVar != null) {
                    bVar.a(j11, "enter room failed");
                }
                a.a(a.this);
                return;
            }
            com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = a.this.f48179g;
            aVar.f48377g = true;
            if (TUICallDefine.Role.Called.equals(aVar.f48375e)) {
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar2 = new com.tencent.qcloud.tuikit.tuicallengine.k.b(a.this.f48185m);
                com.tencent.qcloud.tuikit.tuicallengine.i.a aVar2 = a.this.f48176d;
                if (aVar2 != null) {
                    aVar2.a(j11);
                    bVar2.a();
                    return;
                }
                bVar2.a(TUICallDefine.ERROR_SCENE_NOT_SUPPORTED, "joinInGroupCall failed");
                return;
            }
            if (TUICallDefine.Role.Caller.equals(a.this.f48179g.f48375e)) {
                a aVar3 = a.this;
                if (aVar3.f48176d != null) {
                    TRTCCloud.sharedInstance(aVar3.f48175c).muteLocalVideo(0, true);
                    a.this.f48176d.b((TUICommonDefine.Callback) new C0596a(new com.tencent.qcloud.tuikit.tuicallengine.k.b(a.this.f48184l)));
                    return;
                }
            }
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
            k.b.f48445a.b();
            TUILog.w("TUICallEngine", "onEnterRoom, callingScene is null");
            a.a(a.this);
        }

        public void onError(int i11, String str, Bundle bundle) {
            TUILog.e("TUICallEngine", "onError: " + i11 + " " + str);
            com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
            if (jVar != null) {
                jVar.a(i11, str);
            }
        }

        public void onExitRoom(int i11) {
            TUILog.i("TUICallEngine", "onExitRoom, reason: " + i11);
            int i12 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
            if (i11 == 1 || i11 == 2) {
                a aVar = a.this;
                aVar.getClass();
                TUILog.i("TUICallEngine", "hangup, mBaseCalling: " + aVar.f48176d);
                a.a((Runnable) new d0((TUICommonDefine.Callback) null));
            }
        }

        public void onNetworkQuality(TRTCCloudDef.TRTCQuality tRTCQuality, ArrayList<TRTCCloudDef.TRTCQuality> arrayList) {
            TUICallObserver tUICallObserver;
            if (a.this.f48178f != null) {
                tRTCQuality.userId = V2TIMManager.getInstance().getLoginUser();
                com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
                for (WeakReference next : jVar.f48412a) {
                    if (!(next == null || (tUICallObserver = (TUICallObserver) next.get()) == null)) {
                        ArrayList arrayList2 = new ArrayList();
                        jVar.a(tRTCQuality, (List<TUICommonDefine.NetworkQualityInfo>) arrayList2);
                        if (arrayList != null && !arrayList.isEmpty()) {
                            Iterator<TRTCCloudDef.TRTCQuality> it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                jVar.a(it2.next(), (List<TUICommonDefine.NetworkQualityInfo>) arrayList2);
                            }
                        }
                        jVar.f48413b.post(new com.tencent.qcloud.tuikit.tuicallengine.f.f(jVar, tUICallObserver, arrayList2));
                    }
                }
            }
        }

        public void onRemoteUserEnterRoom(String str) {
            TUILog.i("TUICallEngine", "onRemoteUserEnterRoom userId:" + str);
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
            if (aVar != null) {
                aVar.c(str);
            }
        }

        public void onRemoteUserLeaveRoom(String str, int i11) {
            TUILog.i("TUICallEngine", "onRemoteUserLeaveRoom userId:" + str + ", reason:" + i11);
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
            if (aVar != null) {
                aVar.a(str, i11);
            }
        }

        public void onRemoteVideoStatusUpdated(String str, int i11, int i12, int i13, Bundle bundle) {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = a.this.f48188p.get(str);
            if (bVar == null) {
                return;
            }
            if (i12 == 1) {
                bVar.f48536d.post(new com.tencent.qcloud.tuikit.tuicallengine.k.c(bVar, str));
            } else if (i12 == 2) {
                bVar.f48536d.post(new com.tencent.qcloud.tuikit.tuicallengine.k.d(bVar, str));
            }
        }

        public void onUserAudioAvailable(String str, boolean z11) {
            TUILog.i("TUICallEngine", "onUserAudioAvailable userId:" + str + ", available:" + z11);
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
            if (aVar != null) {
                aVar.a(str, z11);
            }
            com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
            if (jVar != null) {
                TUILog.i("CallingObserverManager", "onUserAudioAvailable userId:" + str + ", isAudioAvailable:" + z11);
                for (WeakReference next : jVar.f48412a) {
                    if (next != null) {
                        jVar.f48413b.post(new com.tencent.qcloud.tuikit.tuicallengine.f.d(jVar, (TUICallObserver) next.get(), str, z11));
                    }
                }
            }
        }

        public void onUserVideoAvailable(String str, boolean z11) {
            TUILog.i("TUICallEngine", "onUserVideoAvailable userId:" + str + ", available:" + z11);
            com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = a.this.f48176d;
            if (aVar != null) {
                aVar.b(str, z11);
            }
            com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
            if (jVar != null) {
                TUILog.i("CallingObserverManager", "onUserVideoAvailable userId:" + str + ", isVideoAvailable:" + z11);
                for (WeakReference next : jVar.f48412a) {
                    if (next != null) {
                        jVar.f48413b.post(new com.tencent.qcloud.tuikit.tuicallengine.f.c(jVar, (TUICallObserver) next.get(), str, z11));
                    }
                }
            }
        }

        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i11) {
            HashMap hashMap = new HashMap();
            Iterator<TRTCCloudDef.TRTCVolumeInfo> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                TRTCCloudDef.TRTCVolumeInfo next = it2.next();
                String str = next.userId;
                if (str == null) {
                    str = V2TIMManager.getInstance().getLoginUser();
                }
                hashMap.put(str, Integer.valueOf(next.volume));
            }
            com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
            if (jVar != null) {
                for (WeakReference next2 : jVar.f48412a) {
                    if (next2 != null) {
                        jVar.f48413b.post(new com.tencent.qcloud.tuikit.tuicallengine.f.e(jVar, (TUICallObserver) next2.get(), hashMap));
                    }
                }
            }
        }

        public void onWarning(int i11, String str, Bundle bundle) {
            if (com.tencent.qcloud.tuikit.tuicallengine.k.a.f48523e.contains(Integer.valueOf(i11))) {
                TUILog.w("TUICallEngine", "VirtualBackground, errorCode: " + i11 + " ,errorMsg: " + str);
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(a.this.f48186n);
                bVar.f48536d.post(new b.c(i11, str));
            }
        }
    }

    public class t extends V2TIMSDKListener {

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$t$a  reason: collision with other inner class name */
        public class C0597a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f48281a;

            public C0597a(List list) {
                this.f48281a = list;
            }

            public void run() {
                for (int i11 = 0; i11 < this.f48281a.size(); i11++) {
                    V2TIMUserStatus v2TIMUserStatus = (V2TIMUserStatus) this.f48281a.get(i11);
                    String userID = v2TIMUserStatus.getUserID();
                    String customStatus = v2TIMUserStatus.getCustomStatus();
                    if (Objects.equals(userID, V2TIMManager.getInstance().getLoginUser()) && !"call_accept".equals(customStatus) && !"call_wait".equals(customStatus) && !TUICallDefine.Status.None.equals(a.this.f48179g.f48376f)) {
                        a aVar = a.this;
                        a.a(aVar, aVar.f48179g.f48376f);
                    }
                }
            }
        }

        public t() {
        }

        public void onKickedOffline() {
            super.onKickedOffline();
            TUILog.i("TUICallEngine", "onKickedOffline");
            com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
            if (jVar != null) {
                TUILog.i("CallingObserverManager", "onKickedOffline");
                for (WeakReference next : jVar.f48412a) {
                    if (next != null) {
                        jVar.f48413b.post(new com.tencent.qcloud.tuikit.tuicallengine.f.h(jVar, (TUICallObserver) next.get()));
                    }
                }
            }
        }

        public void onUserSigExpired() {
            super.onUserSigExpired();
            boolean unused = a.this.f48183k = true;
            TUILog.i("TUICallEngine", "onUserSigExpired");
            com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = a.this.f48178f;
            if (jVar != null) {
                TUILog.i("CallingObserverManager", "onUserSigExpired");
                for (WeakReference next : jVar.f48412a) {
                    if (next != null) {
                        jVar.f48413b.post(new com.tencent.qcloud.tuikit.tuicallengine.f.i(jVar, (TUICallObserver) next.get()));
                    }
                }
            }
        }

        public void onUserStatusChanged(List<V2TIMUserStatus> list) {
            super.onUserStatusChanged(list);
            a.a((Runnable) new C0597a(list));
        }
    }

    public class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48283a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.MediaType f48284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.RoomId f48285c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f48286d;

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$u$a  reason: collision with other inner class name */
        public class C0598a implements TUICommonDefine.ValueCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48288a;

            /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$u$a$a  reason: collision with other inner class name */
            public class C0599a implements TUICommonDefine.ValueCallback {
                public C0599a() {
                }

                public void onError(int i11, String str) {
                    TUILog.e("TUICallEngine", "joinInGroupCall failed, errorCode: " + i11 + " , errorMsg: " + str);
                    com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = C0598a.this.f48288a;
                    bVar.f48536d.post(new b.c(i11, str));
                    a aVar = a.this;
                    a aVar2 = a.f48173a;
                    aVar.c();
                }

                public void onSuccess(Object obj) {
                    if (TUICallDefine.Status.None != ((TUICallDefine.Status) obj)) {
                        TUILog.e("TUICallEngine", "joinInGroupCall failed, The current status is waiting/accept,Don't call it repeatedly");
                        C0598a.this.f48288a.a(TUICallDefine.ERROR_REQUEST_REPEATED, "The current status is waiting/accept, Don't call it repeatedly");
                        return;
                    }
                    a.this.f48179g.f48386p.set(com.tencent.qcloud.tuikit.tuicallengine.e.m.JoinInGroupCall);
                    u uVar = u.this;
                    com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = a.this.f48175c;
                    k.b.f48445a.a(uVar.f48285c, uVar.f48284b);
                    a.a(a.this, TUICallDefine.Status.Accept);
                }
            }

            public C0598a(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
                this.f48288a = bVar;
            }

            public void onError(int i11, String str) {
                TUILog.e("TUICallEngine", "joinInGroupCall failed, errCode: " + i11 + " ,errMsg: " + str);
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48288a;
                bVar.f48536d.post(new b.c(i11, str));
                a aVar = a.this;
                a aVar2 = a.f48173a;
                aVar.c();
            }

            public void onSuccess(Object obj) {
                if (!(obj instanceof Boolean)) {
                    a aVar = a.this;
                    a aVar2 = a.f48173a;
                    aVar.c();
                } else if (!((Boolean) obj).booleanValue()) {
                    TUILog.e("TUICallEngine", "joinInGroupCall failed, errorCode: " + TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED + ", " + a.c(a.this));
                    this.f48288a.a(TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED, a.c(a.this));
                    a.this.c();
                } else {
                    a.a(a.this, (TUICommonDefine.ValueCallback) new C0599a());
                }
            }
        }

        public u(TUICommonDefine.Callback callback, TUICallDefine.MediaType mediaType, TUICommonDefine.RoomId roomId, String str) {
            this.f48283a = callback;
            this.f48284b = mediaType;
            this.f48285c = roomId;
            this.f48286d = str;
        }

        public void run() {
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(this.f48283a);
            if (TextUtils.isEmpty(V2TIMManager.getInstance().getLoginUser()) || !com.tencent.qcloud.tuikit.tuicallengine.f.n.b()) {
                TUILog.e("TUICallEngine", "Invalid login, please login again");
                bVar.a(TUICallDefine.ERROR_INIT_FAIL, "Invalid login, please login again");
            } else if (!TUICallDefine.Status.None.equals(a.this.f48179g.f48376f)) {
                TUILog.e("TUICallEngine", "The current status is waiting/accept, please do not call it repeatedly");
                bVar.a(TUICallDefine.ERROR_REQUEST_REPEATED, "The current status is waiting/accept, please do not call it repeatedly");
            } else if (TUICallDefine.MediaType.Unknown.equals(this.f48284b)) {
                TUILog.e("TUICallEngine", "joinInGroupCall failed, mediaType param error");
                bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "mediaType param error");
            } else {
                TUICommonDefine.RoomId roomId = this.f48285c;
                int i11 = roomId != null ? roomId.intRoomId : 0;
                String str = roomId != null ? roomId.strRoomId : "";
                if (i11 <= 0 && TextUtils.isEmpty(str)) {
                    TUILog.e("TUICallEngine", "joinInGroupCall failed, roomId param error, roomId: " + this.f48285c);
                    bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "roomId param error");
                } else if (TextUtils.isEmpty(this.f48286d)) {
                    TUILog.e("TUICallEngine", "joinInGroupCall failed, groupId param doesn't exist");
                    bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "groupId param doesn't exist");
                } else {
                    com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = a.this.f48179g;
                    aVar.f48371a = this.f48285c;
                    aVar.f48372b = this.f48286d;
                    aVar.f48384n.set(this.f48284b);
                    a aVar2 = a.this;
                    com.tencent.qcloud.tuikit.tuicallengine.f.a aVar3 = aVar2.f48179g;
                    aVar3.f48375e = TUICallDefine.Role.Called;
                    aVar3.f48378h = true;
                    aVar3.f48376f = TUICallDefine.Status.Accept;
                    com.tencent.qcloud.tuikit.tuicallengine.e.b bVar2 = aVar2.f48177e;
                    if (bVar2 != null) {
                        bVar2.a(aVar3);
                    }
                    TUILog.i("TUICallEngine", "joinInGroupCall, mCallState: " + a.this.f48179g);
                    a aVar4 = a.this;
                    aVar4.f48185m = this.f48283a;
                    com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = aVar4.f48175c;
                    k.b.f48445a.a();
                    a aVar5 = a.this;
                    aVar5.f48176d = aVar5.a(this.f48286d, aVar5.f48179g.f48374d);
                    com.tencent.qcloud.tuikit.tuicallengine.e.o.a(131072, (TUICommonDefine.ValueCallback) new C0598a(bVar));
                }
            }
        }
    }

    public class v implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TUICallDefine.RecentCallsFilter f48291a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.ValueCallback f48292b;

        public v(TUICallDefine.RecentCallsFilter recentCallsFilter, TUICommonDefine.ValueCallback valueCallback) {
            this.f48291a = recentCallsFilter;
            this.f48292b = valueCallback;
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f48190r == null) {
                aVar.f48190r = new com.tencent.qcloud.tuikit.tuicallengine.h.g(aVar.f48175c);
            }
            com.tencent.qcloud.tuikit.tuicallengine.h.g gVar = aVar.f48190r;
            TUICallDefine.RecentCallsFilter recentCallsFilter = this.f48291a;
            TUICommonDefine.ValueCallback valueCallback = this.f48292b;
            gVar.getClass();
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(valueCallback);
            com.tencent.qcloud.tuikit.tuicallengine.h.d a11 = com.tencent.qcloud.tuikit.tuicallengine.h.d.a(gVar.f48468a);
            a11.a((Runnable) new com.tencent.qcloud.tuikit.tuicallengine.h.b(a11, recentCallsFilter, new com.tencent.qcloud.tuikit.tuicallengine.h.f(gVar, bVar)));
        }
    }

    public class w implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f48294a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.ValueCallback f48295b;

        public w(List list, TUICommonDefine.ValueCallback valueCallback) {
            this.f48294a = list;
            this.f48295b = valueCallback;
        }

        public void run() {
            a aVar = a.this;
            if (aVar.f48190r == null) {
                aVar.f48190r = new com.tencent.qcloud.tuikit.tuicallengine.h.g(aVar.f48175c);
            }
            com.tencent.qcloud.tuikit.tuicallengine.h.g gVar = aVar.f48190r;
            List list = this.f48294a;
            TUICommonDefine.ValueCallback valueCallback = this.f48295b;
            com.tencent.qcloud.tuikit.tuicallengine.h.d a11 = com.tencent.qcloud.tuikit.tuicallengine.h.d.a(gVar.f48468a);
            a11.getClass();
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(valueCallback);
            if (list == null || list.isEmpty()) {
                bVar.a(-2, "The delete list is empty");
            } else {
                a11.a((Runnable) new com.tencent.qcloud.tuikit.tuicallengine.h.c(a11, list, bVar, valueCallback));
            }
        }
    }

    public class x implements TUICommonDefine.ValueCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48297a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48298b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f48299c;

        public x(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar, TUICommonDefine.Callback callback, int i11) {
            this.f48297a = bVar;
            this.f48298b = callback;
            this.f48299c = i11;
        }

        public void onError(int i11, String str) {
            TUILog.e("TUICallEngine", "setBlurBackground failed, errCode: " + i11 + " ,errMsg: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48297a;
            bVar.f48536d.post(new b.c(i11, str));
        }

        public void onSuccess(Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                TUILog.e("TUICallEngine", "setBlurBackground failed, errorCode: " + TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED + " ,getUpgradePackageHint()");
                this.f48297a.a(TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED, "  getUpgradePackageHint()");
                return;
            }
            a.this.f48186n = this.f48298b;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("api", "enableVirtualBackground");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("enable", true);
                int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
                jSONObject2.put("backgroundType", 3);
                jSONObject2.put(FirebaseAnalytics.Param.LEVEL, this.f48299c);
                jSONObject.put("params", jSONObject2);
                TRTCCloud.sharedInstance(a.this.f48175c).callExperimentalAPI(jSONObject.toString());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }

    public class y implements TUICommonDefine.ValueCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48301a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TUICommonDefine.Callback f48302b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48303c;

        public y(com.tencent.qcloud.tuikit.tuicallengine.k.b bVar, TUICommonDefine.Callback callback, String str) {
            this.f48301a = bVar;
            this.f48302b = callback;
            this.f48303c = str;
        }

        public void onError(int i11, String str) {
            TUILog.e("TUICallEngine", "setVirtualBackground failed, errCode: " + i11 + " ,errMsg: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48301a;
            bVar.f48536d.post(new b.c(i11, str));
        }

        public void onSuccess(Object obj) {
            if (!((Boolean) obj).booleanValue()) {
                TUILog.e("TUICallEngine", "setVirtualBackground failed, errorCode: " + TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED + " ," + a.c(a.this));
                this.f48301a.a(TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED, a.c(a.this));
                return;
            }
            a.this.f48186n = this.f48302b;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("api", "enableVirtualBackground");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("enable", true);
                int i11 = com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a;
                jSONObject2.put("backgroundType", 2);
                jSONObject2.put(InnerShareParams.IMAGE_PATH, this.f48303c);
                jSONObject.put("params", jSONObject2);
                TRTCCloud.sharedInstance(a.this.f48175c).callExperimentalAPI(jSONObject.toString());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }

    public class z implements TUICommonDefine.ValueCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48305a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f48306b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.tencent.qcloud.tuikit.tuicallengine.k.b f48307c;

        /* renamed from: com.tencent.qcloud.tuikit.tuicallengine.a$z$a  reason: collision with other inner class name */
        public class C0600a implements TUICommonDefine.ValueCallback {
            public C0600a() {
            }

            public void onError(int i11, String str) {
                TUILog.e("TUICallEngine", "call failed, errorCode: " + i11 + " , errMsg: " + str);
                com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = z.this.f48307c;
                bVar.f48536d.post(new b.c(i11, str));
                a.this.f48179g.f48385o.set(a.C0607a.Fail);
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar2 = a.this.f48177e;
                if (bVar2 != null) {
                    bVar2.a((long) i11, str);
                }
                a.a(a.this);
            }

            public void onSuccess(Object obj) {
                if (TUICallDefine.Status.None != obj) {
                    int i11 = TUICallDefine.ERROR_REQUEST_REPEATED;
                    TUILog.e("TUICallEngine", "call failed, errorCode: " + i11 + " ,errorMsg: " + "The current status is waiting/accept, please do not call it repeatedly");
                    z.this.f48307c.a(i11, "The current status is waiting/accept, please do not call it repeatedly");
                    a.this.f48179g.f48385o.set(a.C0607a.Fail);
                    com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = a.this.f48177e;
                    if (bVar != null) {
                        bVar.a((long) i11, "The current status is waiting/accept, please do not call it repeatedly");
                    }
                    a.this.c();
                    return;
                }
                a aVar = a.this;
                com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = aVar.f48175c;
                com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = aVar.f48179g;
                kVar.a(aVar2.f48371a, aVar2.f48384n.get());
                a.a(a.this, TUICallDefine.Status.Waiting);
            }
        }

        public z(String str, List list, com.tencent.qcloud.tuikit.tuicallengine.k.b bVar) {
            this.f48305a = str;
            this.f48306b = list;
            this.f48307c = bVar;
        }

        public void onError(int i11, String str) {
            TUILog.e("TUICallEngine", "call failed, errCode: " + i11 + " , message: " + str);
            com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = this.f48307c;
            bVar.f48536d.post(new b.c(i11, str));
            a.this.f48179g.f48381k.f48387a.set(Boolean.FALSE);
            a.this.f48179g.f48385o.set(a.C0607a.Fail);
            com.tencent.qcloud.tuikit.tuicallengine.e.b bVar2 = a.this.f48177e;
            if (bVar2 != null) {
                bVar2.a((long) i11, str);
            }
            a.this.c();
        }

        public void onSuccess(Object obj) {
            int i11;
            String str;
            boolean booleanValue = ((Boolean) obj).booleanValue();
            a.this.f48179g.f48381k.f48387a.set(Boolean.valueOf(booleanValue));
            if (!booleanValue) {
                if (!TextUtils.isEmpty(this.f48305a) || this.f48306b.size() > 1) {
                    i11 = TUICallDefine.ERROR_PACKAGE_NOT_SUPPORTED;
                    str = a.c(a.this);
                } else {
                    i11 = TUICallDefine.ERROR_PACKAGE_NOT_PURCHASED;
                    a aVar = a.this;
                    aVar.getClass();
                    str = aVar.f48175c.getString(R.string.tuicallengine_package_not_purchase, new Object[]{com.tencent.qcloud.tuikit.tuicallengine.e.o.d() ? "https://console.cloud.tencent.com/im/detail" : "https://console.intl.cloud.tencent.com/im/detail", com.tencent.qcloud.tuikit.tuicallengine.e.o.c()});
                }
                TUILog.e("TUICallEngine", "call failed, errorCode: " + i11 + ", errorMsg: " + str);
                this.f48307c.a(i11, str);
                a.this.f48179g.f48385o.set(a.C0607a.Fail);
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = a.this.f48177e;
                if (bVar != null) {
                    bVar.a((long) i11, str);
                }
                a.this.c();
                return;
            }
            a aVar2 = a.this;
            if (aVar2.f48182j) {
                com.tencent.qcloud.tuikit.tuicallengine.e.o.a((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE, (TUICommonDefine.ValueCallback) new b(aVar2));
            }
            V2TIMManager.getInstance().subscribeUserStatus(this.f48306b, new com.tencent.qcloud.tuikit.tuicallengine.k.h((TUICommonDefine.Callback) null));
            a.a(a.this, (TUICommonDefine.ValueCallback) new C0600a());
        }
    }

    public a(Context context) {
        r rVar = new r();
        this.f48192t = rVar;
        s sVar = new s();
        this.f48193u = sVar;
        t tVar = new t();
        this.f48194v = tVar;
        Context applicationContext = context.getApplicationContext();
        this.f48175c = applicationContext;
        TRTCCloud.sharedInstance(applicationContext).setListenerHandler(f48174b);
        TRTCCloud.setLogLevel(1);
        this.f48178f = new com.tencent.qcloud.tuikit.tuicallengine.f.j();
        com.tencent.qcloud.tuikit.tuicallengine.f.k.a(applicationContext).a((TRTCCloudListener) sVar);
        V2TIMManager.getSignalingManager().addSignalingListener(rVar);
        V2TIMManager.getInstance().addIMSDKListener(tVar);
        TXLiveBase.updateNetworkTime();
        this.f48177e = new com.tencent.qcloud.tuikit.tuicallengine.e.b(applicationContext);
    }

    public static boolean a(a aVar, String str) {
        aVar.getClass();
        if (TextUtils.isEmpty(str) || !str.equals(V2TIMManager.getInstance().getLoginUser())) {
            return false;
        }
        TUILog.i("TUICallEngine", "this is MultiTerminal invitation ,ignore");
        return true;
    }

    public static String c(a aVar) {
        return aVar.f48175c.getString(R.string.tuicallengine_package_not_support, new Object[]{com.tencent.qcloud.tuikit.tuicallengine.e.o.c()});
    }

    public void accept(TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "accept, mBaseCalling: " + this.f48176d);
        a((Runnable) new b0(callback));
    }

    public void addObserver(TUICallObserver tUICallObserver) {
        com.tencent.qcloud.tuikit.tuicallengine.f.j jVar = this.f48178f;
        jVar.getClass();
        if (tUICallObserver != null) {
            for (WeakReference next : jVar.f48412a) {
                if (next != null && tUICallObserver.equals(next.get())) {
                    return;
                }
            }
            WeakReference weakReference = new WeakReference(tUICallObserver);
            TUILog.i("CallingObserverManager", "addObserver, observer: " + tUICallObserver + " [" + weakReference + "]");
            jVar.f48412a.add(weakReference);
        }
    }

    public void call(TUICommonDefine.RoomId roomId, String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "call, roomId: " + roomId + " ,userId: " + str + " ,mediaType: " + mediaType + " ,params: " + callParams);
        if (callParams == null) {
            callParams = new TUICallDefine.CallParams();
        }
        if (roomId != null) {
            callParams.roomId = roomId;
        }
        call(str, mediaType, callParams, callback);
    }

    public void callExperimentalAPI(String str) {
        if (TextUtils.isEmpty(str)) {
            TUILog.e("TUICallEngine", "callExperimentalAPI, jsonStr is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("api")) {
                TUILog.e("TUICallEngine", "callExperimentalAPI[lack api or illegal type]: " + str);
            } else if (!jSONObject.has("params")) {
                TUILog.e("TUICallEngine", "callExperimentalAPI[lack params or illegal type]: " + str);
            } else {
                String string = jSONObject.getString("api");
                JSONObject jSONObject2 = jSONObject.getJSONObject("params");
                if (string.equals(V2TXLiveDefInner.TXLivePropertyKey.kV2SetFramework)) {
                    if (jSONObject2.has("framework")) {
                        com.tencent.qcloud.tuikit.tuicallengine.k.a.f48519a = jSONObject2.getInt("framework");
                    }
                    if (jSONObject2.has("component")) {
                        com.tencent.qcloud.tuikit.tuicallengine.k.a.f48520b = jSONObject2.getInt("component");
                    }
                    if (jSONObject2.has("language")) {
                        com.tencent.qcloud.tuikit.tuicallengine.k.a.f48521c = jSONObject2.getInt("language");
                    }
                }
                if (string.equals("setExcludeFromHistoryMessage") && jSONObject2.has("excludeFromHistoryMessage")) {
                    com.tencent.qcloud.tuikit.tuicallengine.k.a.f48522d = jSONObject2.getBoolean("excludeFromHistoryMessage");
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void closeCamera() {
        TUILog.i("TUICallEngine", "closeCamera");
        a((Runnable) new i());
    }

    public void closeMicrophone() {
        TUILog.i("TUICallEngine", "closeMicrophone");
        a((Runnable) new n());
    }

    public void deleteRecordCalls(List<String> list, TUICommonDefine.ValueCallback valueCallback) {
        a((Runnable) new w(list, valueCallback));
    }

    public void enableMultiDeviceAbility(boolean z11, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "enableMultiDeviceAbility, enable: " + z11);
        a((Runnable) new p(callback, z11));
    }

    public TRTCCloud getTRTCCloudInstance() {
        return TRTCCloud.sharedInstance(this.f48175c);
    }

    public void groupCall(TUICommonDefine.RoomId roomId, String str, List<String> list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "groupCall, roomId: " + roomId + " ,groupId: " + str + " ,userIdList: " + list + " ,mediaType: " + mediaType + " ,params: " + callParams);
        if (callParams == null) {
            callParams = new TUICallDefine.CallParams();
        }
        TUICallDefine.CallParams callParams2 = callParams;
        if (roomId != null) {
            callParams2.roomId = roomId;
        }
        groupCall(str, list, mediaType, callParams2, callback);
    }

    public void hangup(TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "hangup, mBaseCalling: " + this.f48176d);
        a((Runnable) new d0(callback));
    }

    public void ignore(TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "ignore, mBaseCalling: " + this.f48176d);
        a((Runnable) new e0(callback));
    }

    public void init(int i11, String str, String str2, TUICommonDefine.Callback callback) {
        com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback);
        if (i11 <= 0) {
            TUILog.e("TUICallEngine", "init failed, sdkAppId param error");
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "init failed, sdkAppId param error");
        } else if (TextUtils.isEmpty(str)) {
            TUILog.e("TUICallEngine", "init failed, userId param doesn't exist");
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "init failed, userId param doesn't exist");
        } else if (TextUtils.isEmpty(str2)) {
            TUILog.e("TUICallEngine", "init failed, userSig param error");
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "init failed, userSig param error");
        } else {
            TUILog.i("TUICallEngine", "init, sdkAppId: " + i11 + " ,userId: " + str);
            Context context = this.f48175c;
            boolean z11 = this.f48183k;
            k kVar = new k(bVar);
            com.tencent.qcloud.tuikit.tuicallengine.f.n nVar = n.a.f48451a;
            int i12 = nVar.f48449a;
            if (!(i12 == 0 || i12 == i11)) {
                V2TIMManager.getInstance().logout(new com.tencent.qcloud.tuikit.tuicallengine.f.m(nVar, (TUICommonDefine.Callback) null));
                V2TIMManager.getInstance().unInitSDK();
            }
            nVar.f48449a = i11;
            nVar.f48450b = str2;
            if (V2TIMManager.getInstance().getLoginStatus() == 3 || z11) {
                V2TIMSDKConfig v2TIMSDKConfig = new V2TIMSDKConfig();
                v2TIMSDKConfig.setLogLevel(4);
                if (V2TIMManager.getInstance().initSDK(context, i11, v2TIMSDKConfig)) {
                    V2TIMManager.getInstance().login(str, str2, new com.tencent.qcloud.tuikit.tuicallengine.f.l(nVar, kVar));
                } else {
                    kVar.onError(TUICallDefine.ERROR_INIT_FAIL, "init failed");
                }
            } else {
                kVar.onSuccess();
            }
            if (this.f48189q == null) {
                TRTCCloudDef.TRTCVideoEncParam tRTCVideoEncParam = new TRTCCloudDef.TRTCVideoEncParam();
                this.f48189q = tRTCVideoEncParam;
                tRTCVideoEncParam.videoResolution = 108;
                tRTCVideoEncParam.videoBitrate = BannerConfig.SCROLL_TIME;
                tRTCVideoEncParam.videoResolutionMode = 1;
                TRTCCloud.sharedInstance(this.f48175c).setVideoEncoderParam(this.f48189q);
            }
            TRTCCloud.sharedInstance(this.f48175c).setGSensorMode(0);
            a((Runnable) new e(this.f48191s, (TUICommonDefine.Callback) null));
        }
    }

    public void inviteUser(List<String> list, TUICallDefine.CallParams callParams, TUICommonDefine.ValueCallback valueCallback) {
        TUILog.i("TUICallEngine", "inviteUser, userIdList: " + list + " ,params: " + callParams);
        a((Runnable) new l(valueCallback, list, callParams));
    }

    public void joinInGroupCall(TUICommonDefine.RoomId roomId, String str, TUICallDefine.MediaType mediaType, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "joinInGroupCall, roomId: " + roomId + " ,groupId: " + str + " ,mediaType: " + mediaType);
        a((Runnable) new u(callback, mediaType, roomId, str));
    }

    public void openCamera(TUICommonDefine.Camera camera, TUIVideoView tUIVideoView, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "openCamera, camera: " + camera + " ,videoView: " + tUIVideoView);
        a((Runnable) new h(callback, tUIVideoView, camera));
    }

    public void openMicrophone(TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "openMicrophone");
        a((Runnable) new m(callback));
    }

    public void queryOfflineCall() {
        a((Runnable) new b());
    }

    public void queryRecentCalls(TUICallDefine.RecentCallsFilter recentCallsFilter, TUICommonDefine.ValueCallback valueCallback) {
        a((Runnable) new v(recentCallsFilter, valueCallback));
    }

    public void reject(TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "reject, mBaseCalling: " + this.f48176d);
        a((Runnable) new c0(callback));
    }

    public void removeObserver(TUICallObserver tUICallObserver) {
        Iterator<WeakReference<TUICallObserver>> it2 = this.f48178f.f48412a.iterator();
        while (it2.hasNext()) {
            WeakReference next = it2.next();
            if (next.get() == null) {
                it2.remove();
            } else {
                TUILog.i("CallingObserverManager", "removeObserver, observer: " + tUICallObserver + " [" + next + "]");
                if (next.get() == tUICallObserver) {
                    it2.remove();
                }
            }
        }
    }

    public void selectAudioPlaybackDevice(TUICommonDefine.AudioPlaybackDevice audioPlaybackDevice) {
        TUILog.i("TUICallEngine", "selectAudioPlaybackDevice, device: " + audioPlaybackDevice);
        a((Runnable) new q(audioPlaybackDevice));
    }

    public void setBeautyLevel(float f11, TUICommonDefine.Callback callback) {
        a((Runnable) new e(f11, callback));
    }

    public void setBlurBackground(int i11, TUICommonDefine.Callback callback) {
        a((Runnable) new az.a(this, i11, callback));
    }

    public void setSelfInfo(String str, String str2, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "setSelfInfo, nickname: " + str + " ,avatar: " + str2);
        a((Runnable) new o(this, callback, str, str2));
    }

    public void setVideoEncoderParams(TUICommonDefine.VideoEncoderParams videoEncoderParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "setVideoEncoderParams, params: " + videoEncoderParams);
        a((Runnable) new d(callback, videoEncoderParams));
    }

    public void setVideoRenderParams(String str, TUICommonDefine.VideoRenderParams videoRenderParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "setVideoRenderParams, userId: " + str + " ,params: " + videoRenderParams);
        a((Runnable) new c(callback, str, videoRenderParams));
    }

    public void setVirtualBackground(String str, TUICommonDefine.Callback callback) {
        a((Runnable) new az.c(this, str, callback));
    }

    public void startRemoteView(String str, TUIVideoView tUIVideoView, TUICommonDefine.PlayCallback playCallback) {
        TUILog.i("TUICallEngine", "startRemoteView, userId: " + str + " ,videoView: " + tUIVideoView);
        a((Runnable) new f(playCallback, str, tUIVideoView));
    }

    public void stopRemoteView(String str) {
        TUILog.i("TUICallEngine", "stopRemoteView, userId: " + str);
        a((Runnable) new g(str));
    }

    public void switchCallMediaType(TUICallDefine.MediaType mediaType) {
        TUILog.i("TUICallEngine", "switchCallMediaType, callMediaType: " + mediaType + " ,mBaseCalling: " + this.f48176d);
        a((Runnable) new C0589a(mediaType));
    }

    public void switchCamera(TUICommonDefine.Camera camera) {
        TUILog.i("TUICallEngine", "switchCamera, camera: " + camera);
        a((Runnable) new j(camera));
    }

    public final void b() {
        TUILog.i("TUICallEngine", "destroyInstance");
        V2TIMManager.getSignalingManager().removeSignalingListener(this.f48192t);
        V2TIMManager.getInstance().removeIMSDKListener(this.f48194v);
        com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = this.f48175c;
        com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
        kVar.b(this.f48193u);
        TRTCCloud.sharedInstance(this.f48175c).stopLocalPreview();
        TRTCCloud.sharedInstance(this.f48175c).stopLocalAudio();
        TRTCCloud.sharedInstance(this.f48175c).exitRoom();
        com.tencent.qcloud.tuikit.tuicallengine.e.b bVar = this.f48177e;
        if (bVar != null) {
            TUICallEngine.createInstance(bVar.f48321a).removeObserver(bVar.f48326f);
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = bVar.f48321a;
            kVar.b(bVar.f48327g);
            Handler handler = bVar.f48323c;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            bVar.f48322b.a();
        }
    }

    public final void c() {
        TUILog.i("TUICallEngine", "stopCall");
        TUILog.i("TUICallEngine", "closeMicrophone");
        a((Runnable) new n());
        TUILog.i("TUICallEngine", "closeCamera");
        a((Runnable) new i());
        if (!this.f48179g.f48377g) {
            com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = this.f48175c;
            com.tencent.qcloud.tuikit.tuicallengine.f.k kVar = k.b.f48445a;
            kVar.getClass();
            TRTCCloud.sharedInstance(com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a).removeListener(kVar.f48443e);
        }
        this.f48176d = null;
        this.f48179g.a();
        this.f48181i.clear();
        this.f48184l = null;
        this.f48185m = null;
        this.f48187o.clear();
        this.f48188p.clear();
        Handler handler = f48174b;
        if (handler != null) {
            handler.removeCallbacks(this.f48180h);
        }
    }

    public void call(String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "call, userId: " + str + " ,mediaType: " + mediaType + " ,params: " + callParams);
        a((Runnable) new az.d(this, str, mediaType, callParams, callback));
    }

    public void groupCall(String str, List<String> list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "groupCall, groupId: " + str + " ,userIdList: " + list + " ,mediaType: " + mediaType + " ,params: " + callParams);
        a((Runnable) new az.b(this, callback, str, list, mediaType, callParams));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        a(65536, arrayList, mediaType, "", callParams, callback);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(TUICommonDefine.Callback callback, String str, List list, TUICallDefine.MediaType mediaType, TUICallDefine.CallParams callParams) {
        com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback);
        if (TextUtils.isEmpty(str)) {
            TUILog.i("TUICallEngine", "groupCall failed, groupId param doesn't exist");
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "groupId param doesn't exist");
            return;
        }
        a(196608, new ArrayList(list), mediaType, str, callParams, callback);
    }

    public final void a(long j11, List<String> list, TUICallDefine.MediaType mediaType, String str, TUICallDefine.CallParams callParams, TUICommonDefine.Callback callback) {
        TUICommonDefine.RoomId roomId;
        com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback);
        if (!TUICallDefine.Status.None.equals(this.f48179g.f48376f)) {
            TUILog.w("TUICallEngine", "call failed, The current status is waiting/accept, please do not call it repeatedly");
            bVar.a(TUICallDefine.ERROR_REQUEST_REPEATED, "The current status is waiting/accept, please do not call it repeatedly");
        } else if (TextUtils.isEmpty(V2TIMManager.getInstance().getLoginUser()) || !com.tencent.qcloud.tuikit.tuicallengine.f.n.b()) {
            TUILog.e("TUICallEngine", "Invalid login, please login again");
            bVar.a(TUICallDefine.ERROR_INIT_FAIL, "Invalid login, please login again");
        } else if (TUICallDefine.MediaType.Unknown.equals(mediaType)) {
            TUILog.e("TUICallEngine", "call failed, callMediaType param error");
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "callMediaType param error");
        } else {
            TUICommonDefine.RoomId roomId2 = new TUICommonDefine.RoomId();
            roomId2.intRoomId = new Random().nextInt(Integer.MAX_VALUE) + 1;
            if (!(callParams == null || (roomId = callParams.roomId) == null)) {
                roomId2 = roomId;
            }
            if (roomId2.intRoomId > 0 || !TextUtils.isEmpty(roomId2.strRoomId)) {
                list.remove(V2TIMManager.getInstance().getLoginUser());
                list.removeAll(Collections.singleton((Object) null));
                if (list.isEmpty()) {
                    TUILog.e("TUICallEngine", "call failed, userIdList param error");
                    bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "userIdList param error");
                    return;
                }
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar = this.f48179g;
                aVar.f48376f = TUICallDefine.Status.Waiting;
                aVar.f48373c = V2TIMManager.getInstance().getLoginUser();
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar2 = this.f48179g;
                aVar2.f48371a = roomId2;
                aVar2.f48372b = str;
                aVar2.f48384n.set(mediaType);
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar3 = this.f48179g;
                aVar3.f48375e = TUICallDefine.Role.Caller;
                aVar3.f48378h = true;
                aVar3.f48374d = list;
                aVar3.f48380j = callParams;
                com.tencent.qcloud.tuikit.tuicallengine.e.b bVar2 = this.f48177e;
                if (bVar2 != null) {
                    bVar2.a(aVar3);
                }
                TUILog.i("TUICallEngine", "start call, TUICallEngine VERSION: " + TUICallDefine.VERSION + ";\n IM Version: " + V2TIMManager.getInstance().getVersion() + ";\n TRTC Version: " + TRTCCloud.getSDKVersion() + ";\n callState: " + this.f48179g);
                com.tencent.qcloud.tuikit.tuicallengine.f.k.f48439a = this.f48175c;
                k.b.f48445a.a();
                com.tencent.qcloud.tuikit.tuicallengine.f.a aVar4 = this.f48179g;
                this.f48176d = a(aVar4.f48372b, aVar4.f48374d);
                this.f48184l = callback;
                com.tencent.qcloud.tuikit.tuicallengine.e.o.a(j11, (TUICommonDefine.ValueCallback) new z(str, list, bVar));
                return;
            }
            TUILog.e("TUICallEngine", "call failed, roomId param error, roomId: " + roomId2);
            bVar.a(TUICallDefine.ERROR_PARAM_INVALID, "roomId param error");
        }
    }

    public static boolean b(a aVar) {
        return !aVar.f48181i.isEmpty() && !TextUtils.isEmpty(aVar.f48179g.f48382l.get()) && aVar.f48181i.get(aVar.f48179g.f48382l.get()) != null;
    }

    public final com.tencent.qcloud.tuikit.tuicallengine.i.a a(String str, List<String> list) {
        if (!TextUtils.isEmpty(str)) {
            this.f48176d = new com.tencent.qcloud.tuikit.tuicallengine.i.b(this.f48175c);
        } else if (list == null || list.size() <= 1) {
            this.f48176d = new com.tencent.qcloud.tuikit.tuicallengine.i.h(this.f48175c);
        } else {
            this.f48176d = new com.tencent.qcloud.tuikit.tuicallengine.i.c(this.f48175c);
        }
        com.tencent.qcloud.tuikit.tuicallengine.i.a aVar = this.f48176d;
        aVar.f48470b = this.f48178f;
        aVar.f48471c = this.f48179g;
        aVar.f48475g = this.f48182j;
        aVar.f48473e = new a0();
        return aVar;
    }

    public static void a(a aVar) {
        aVar.c();
        if (com.tencent.qcloud.tuikit.tuicallengine.f.n.b() && !aVar.f48183k) {
            TUICallDefine.Status status = TUICallDefine.Status.None;
            if (aVar.f48182j) {
                com.tencent.qcloud.tuikit.tuicallengine.e.o.a(status, (TUICommonDefine.Callback) null);
            }
        }
    }

    public static void a(a aVar, TUICommonDefine.ValueCallback valueCallback) {
        if (!aVar.f48182j) {
            valueCallback.onSuccess(TUICallDefine.Status.None);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(V2TIMManager.getInstance().getLoginUser());
        com.tencent.qcloud.tuikit.tuicallengine.e.o.a((List<String>) arrayList, (TUICommonDefine.ValueCallback) new d(aVar, valueCallback));
    }

    public static void a(a aVar, TUICallDefine.Status status) {
        if (aVar.f48182j) {
            com.tencent.qcloud.tuikit.tuicallengine.e.o.a(status, (TUICommonDefine.Callback) null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i11, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "setBlurBackground, level: " + i11);
        com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback);
        if (i11 <= 0) {
            a();
        } else {
            com.tencent.qcloud.tuikit.tuicallengine.e.o.a((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE, (TUICommonDefine.ValueCallback) new x(bVar, callback, i11));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, TUICommonDefine.Callback callback) {
        TUILog.i("TUICallEngine", "setVirtualBackground, imagePath: " + str);
        com.tencent.qcloud.tuikit.tuicallengine.k.b bVar = new com.tencent.qcloud.tuikit.tuicallengine.k.b(callback);
        if (TextUtils.isEmpty(str)) {
            a();
        } else {
            com.tencent.qcloud.tuikit.tuicallengine.e.o.a((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE, (TUICommonDefine.ValueCallback) new y(bVar, callback, str));
        }
    }

    public final void a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("api", "enableVirtualBackground");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("enable", false);
            jSONObject.put("params", jSONObject2);
            TRTCCloud.sharedInstance(this.f48175c).callExperimentalAPI(jSONObject.toString());
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = f48174b;
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
