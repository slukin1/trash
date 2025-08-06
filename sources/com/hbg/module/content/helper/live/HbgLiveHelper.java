package com.hbg.module.content.helper.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.core.util.PhoneUtils;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.network.hbg.core.bean.LiveStream;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.live2.V2TXLiveDef;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.impl.V2TXLivePlayerImpl;
import com.tencent.rtmp.ITXVodPlayListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXVodPlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

public final class HbgLiveHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final HbgLiveHelper f18227a = new HbgLiveHelper();

    /* renamed from: b  reason: collision with root package name */
    public static TXVodPlayer f18228b;

    /* renamed from: c  reason: collision with root package name */
    public static V2TXLivePlayer f18229c;

    /* renamed from: d  reason: collision with root package name */
    public static TXCloudVideoView f18230d;

    /* renamed from: e  reason: collision with root package name */
    public static V2TXLivePlayerObserver f18231e;

    /* renamed from: f  reason: collision with root package name */
    public static g f18232f;

    /* renamed from: g  reason: collision with root package name */
    public static LiveDetailBean f18233g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f18234h;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f18235i;

    /* renamed from: j  reason: collision with root package name */
    public static Runnable f18236j = d.f18244b;

    /* renamed from: k  reason: collision with root package name */
    public static Runnable f18237k = e.f18245b;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f18238l;

    /* renamed from: m  reason: collision with root package name */
    public static int f18239m = 1;

    /* renamed from: n  reason: collision with root package name */
    public static boolean f18240n;

    /* renamed from: o  reason: collision with root package name */
    public static PhoneUtils.b f18241o;

    public static final class a implements PhoneUtils.b {
        public void a(int i11) {
            HbgLiveHelper.f18227a.i(i11 == 0);
        }
    }

    public static final class b extends V2TXLivePlayerObserver {
        public void onAudioLoading(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
            super.onAudioLoading(v2TXLivePlayer, bundle);
        }

        public void onAudioPlaying(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
            super.onAudioPlaying(v2TXLivePlayer, z11, bundle);
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.Ta(v2TXLivePlayer, z11, bundle);
            }
        }

        public void onConnected(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
            super.onConnected(v2TXLivePlayer, bundle);
        }

        public void onError(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
            super.onError(v2TXLivePlayer, i11, str, bundle);
            HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
            HbgLiveHelper.f18234h = false;
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.ic(v2TXLivePlayer, i11, str, bundle);
            }
        }

        public void onPlayoutVolumeUpdate(V2TXLivePlayer v2TXLivePlayer, int i11) {
            super.onPlayoutVolumeUpdate(v2TXLivePlayer, i11);
        }

        public void onReceiveSeiMessage(V2TXLivePlayer v2TXLivePlayer, int i11, byte[] bArr) {
            super.onReceiveSeiMessage(v2TXLivePlayer, i11, bArr);
        }

        public void onRenderVideoFrame(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLiveVideoFrame v2TXLiveVideoFrame) {
            super.onRenderVideoFrame(v2TXLivePlayer, v2TXLiveVideoFrame);
        }

        public void onSnapshotComplete(V2TXLivePlayer v2TXLivePlayer, Bitmap bitmap) {
            super.onSnapshotComplete(v2TXLivePlayer, bitmap);
        }

        public void onStatisticsUpdate(V2TXLivePlayer v2TXLivePlayer, V2TXLiveDef.V2TXLivePlayerStatistics v2TXLivePlayerStatistics) {
            super.onStatisticsUpdate(v2TXLivePlayer, v2TXLivePlayerStatistics);
        }

        public void onVideoLoading(V2TXLivePlayer v2TXLivePlayer, Bundle bundle) {
            super.onVideoLoading(v2TXLivePlayer, bundle);
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.B7(v2TXLivePlayer, bundle);
            }
        }

        public void onVideoPlaying(V2TXLivePlayer v2TXLivePlayer, boolean z11, Bundle bundle) {
            super.onVideoPlaying(v2TXLivePlayer, z11, bundle);
            HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
            HbgLiveHelper.f18234h = true;
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.Bb(v2TXLivePlayer, z11, bundle);
            }
        }

        public void onVideoResolutionChanged(V2TXLivePlayer v2TXLivePlayer, int i11, int i12) {
            super.onVideoResolutionChanged(v2TXLivePlayer, i11, i12);
        }

        public void onWarning(V2TXLivePlayer v2TXLivePlayer, int i11, String str, Bundle bundle) {
            super.onWarning(v2TXLivePlayer, i11, str, bundle);
            g g11 = HbgLiveHelper.f18232f;
            if (g11 != null) {
                g11.X8(v2TXLivePlayer, i11, str, bundle);
            }
        }
    }

    public static final class c implements ITXVodPlayListener {
        public void onNetStatus(TXVodPlayer tXVodPlayer, Bundle bundle) {
        }

        public void onPlayEvent(TXVodPlayer tXVodPlayer, int i11, Bundle bundle) {
            int i12 = 0;
            switch (i11) {
                case TXLiveConstants.PLAY_ERR_STREAM_SWITCH_FAIL /*-2307*/:
                case -2306:
                case -2305:
                case -2304:
                case -2303:
                case TXLiveConstants.PLAY_ERR_GET_RTMP_ACC_URL_FAIL /*-2302*/:
                case -2301:
                    HbgLiveHelper hbgLiveHelper = HbgLiveHelper.f18227a;
                    HbgLiveHelper.f18234h = false;
                    g g11 = HbgLiveHelper.f18232f;
                    if (g11 != null) {
                        g11.f4();
                        return;
                    }
                    return;
                default:
                    switch (i11) {
                        case 2004:
                            HbgLiveHelper hbgLiveHelper2 = HbgLiveHelper.f18227a;
                            HbgLiveHelper.f18234h = true;
                            g g12 = HbgLiveHelper.f18232f;
                            if (g12 != null) {
                                g12.S7();
                                return;
                            }
                            return;
                        case 2005:
                            int i13 = bundle != null ? bundle.getInt("EVT_PLAY_DURATION") : 0;
                            if (bundle != null) {
                                i12 = bundle.getInt("EVT_PLAY_PROGRESS");
                            }
                            g g13 = HbgLiveHelper.f18232f;
                            if (g13 != null) {
                                g13.V6(i13, i12);
                                return;
                            }
                            return;
                        case 2006:
                            g g14 = HbgLiveHelper.f18232f;
                            if (g14 != null) {
                                g14.onPlayEnd();
                                return;
                            }
                            return;
                        case 2007:
                            g g15 = HbgLiveHelper.f18232f;
                            if (g15 != null) {
                                g15.da();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
            }
        }
    }

    public static final void C() {
        f18227a.v();
    }

    @SensorsDataInstrumented
    public static final void G(View view) {
        g gVar = f18232f;
        if (gVar != null) {
            gVar.bb();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static final void l(View view) {
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void z() {
        f18227a.w();
    }

    public final void A() {
        try {
            H(false);
            f18234h = false;
            TXCloudVideoView tXCloudVideoView = f18230d;
            if (tXCloudVideoView != null) {
                tXCloudVideoView.setKeepScreenOn(false);
            }
            TXCloudVideoView tXCloudVideoView2 = f18230d;
            if (tXCloudVideoView2 != null) {
                tXCloudVideoView2.onDestroy();
            }
            V2TXLivePlayer v2TXLivePlayer = f18229c;
            if (v2TXLivePlayer != null) {
                v2TXLivePlayer.stopPlay();
            }
            TXVodPlayer tXVodPlayer = f18228b;
            if (tXVodPlayer != null) {
                tXVodPlayer.stopPlay(true);
            }
            Handler handler = f18235i;
            if (handler != null) {
                handler.removeCallbacks(f18236j);
            }
            Handler handler2 = f18235i;
            if (handler2 != null) {
                handler2.removeCallbacks(f18237k);
            }
        } catch (Throwable th2) {
            f18232f = null;
            f18230d = null;
            f18229c = null;
            f18228b = null;
            throw th2;
        }
        f18232f = null;
        f18230d = null;
        f18229c = null;
        f18228b = null;
    }

    public final void B() {
        TXVodPlayer tXVodPlayer;
        V2TXLivePlayer v2TXLivePlayer;
        LiveStream liveStream;
        LiveDetailBean liveDetailBean = f18233g;
        boolean z11 = true;
        String str = null;
        if (!(liveDetailBean != null && liveDetailBean.status == 2) || (v2TXLivePlayer = f18229c) == null) {
            if (liveDetailBean == null || liveDetailBean.status != 3) {
                z11 = false;
            }
            if (z11 && (tXVodPlayer = f18228b) != null && tXVodPlayer != null) {
                if (liveDetailBean != null) {
                    str = liveDetailBean.mediaUrl;
                }
                tXVodPlayer.startVodPlay(str);
            }
        } else if (v2TXLivePlayer != null) {
            if (!(liveDetailBean == null || (liveStream = liveDetailBean.downStreamAddr) == null)) {
                str = liveStream.f70257sd;
            }
            v2TXLivePlayer.startLivePlay(str);
        }
    }

    public final void D(int i11) {
        TXVodPlayer tXVodPlayer = f18228b;
        if (tXVodPlayer != null) {
            tXVodPlayer.seek(i11);
        }
    }

    public final void E(g gVar) {
        f18232f = gVar;
    }

    public final void F() {
        TXCloudVideoView tXCloudVideoView = f18230d;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setOnClickListener(c.f18243b);
        }
    }

    public final void H(boolean z11) {
        f18238l = z11;
    }

    public final void I() {
        TXVodPlayer tXVodPlayer = f18228b;
        if (tXVodPlayer != null) {
            LiveDetailBean liveDetailBean = f18233g;
            tXVodPlayer.startVodPlay(liveDetailBean != null ? liveDetailBean.mediaUrl : null);
        }
    }

    public final void J() {
        Handler handler = f18235i;
        if (handler != null) {
            handler.removeCallbacks(f18237k);
        }
    }

    public final void K(long j11) {
        LiveDetailBean liveDetailBean = f18233g;
        if (liveDetailBean != null) {
            liveDetailBean.currentTime = (liveDetailBean != null ? Long.valueOf(liveDetailBean.startTime - j11) : null).longValue();
        }
    }

    public final void L(LiveDetailBean liveDetailBean) {
        if (liveDetailBean != null) {
            f18233g = liveDetailBean;
        }
    }

    public final void i(boolean z11) {
        if (!z11) {
            V2TXLivePlayer v2TXLivePlayer = f18229c;
            if (v2TXLivePlayer != null) {
                v2TXLivePlayer.pauseAudio();
            }
            V2TXLivePlayer v2TXLivePlayer2 = f18229c;
            if (v2TXLivePlayer2 != null) {
                v2TXLivePlayer2.pauseVideo();
            }
            TXVodPlayer tXVodPlayer = f18228b;
            if (tXVodPlayer != null) {
                tXVodPlayer.pause();
            }
        } else if (!f18234h) {
            V2TXLivePlayer v2TXLivePlayer3 = f18229c;
            if (v2TXLivePlayer3 != null) {
                v2TXLivePlayer3.resumeAudio();
            }
            V2TXLivePlayer v2TXLivePlayer4 = f18229c;
            if (v2TXLivePlayer4 != null) {
                v2TXLivePlayer4.resumeVideo();
            }
            TXVodPlayer tXVodPlayer2 = f18228b;
            if (tXVodPlayer2 != null) {
                tXVodPlayer2.resume();
            }
        }
    }

    public final boolean j(int i11, boolean z11) {
        LiveStream liveStream;
        LiveStream liveStream2;
        LiveStream liveStream3;
        LiveStream liveStream4;
        LiveStream liveStream5;
        LiveStream liveStream6;
        if (f18239m == i11) {
            V2TXLivePlayer v2TXLivePlayer = f18229c;
            if ((v2TXLivePlayer != null && v2TXLivePlayer.isPlaying() == 1) && z11 == f18240n) {
                return false;
            }
        }
        f18239m = i11;
        f18240n = z11;
        V2TXLivePlayer v2TXLivePlayer2 = f18229c;
        if (v2TXLivePlayer2 != null) {
            v2TXLivePlayer2.stopPlay();
        }
        V2TXLivePlayer v2TXLivePlayer3 = f18229c;
        if (v2TXLivePlayer3 != null) {
            int i12 = f18239m;
            String str = null;
            if (i12 != 2) {
                if (i12 != 3) {
                    if (z11) {
                        LiveDetailBean liveDetailBean = f18233g;
                        if (!(liveDetailBean == null || (liveStream6 = liveDetailBean.transDownloadStreamAddr) == null)) {
                            str = liveStream6.f70257sd;
                        }
                    } else {
                        LiveDetailBean liveDetailBean2 = f18233g;
                        if (!(liveDetailBean2 == null || (liveStream5 = liveDetailBean2.downStreamAddr) == null)) {
                            str = liveStream5.f70257sd;
                        }
                    }
                } else if (z11) {
                    LiveDetailBean liveDetailBean3 = f18233g;
                    if (!(liveDetailBean3 == null || (liveStream4 = liveDetailBean3.transDownloadStreamAddr) == null)) {
                        str = liveStream4.fhd;
                    }
                } else {
                    LiveDetailBean liveDetailBean4 = f18233g;
                    if (!(liveDetailBean4 == null || (liveStream3 = liveDetailBean4.downStreamAddr) == null)) {
                        str = liveStream3.fhd;
                    }
                }
            } else if (z11) {
                LiveDetailBean liveDetailBean5 = f18233g;
                if (!(liveDetailBean5 == null || (liveStream2 = liveDetailBean5.transDownloadStreamAddr) == null)) {
                    str = liveStream2.hd;
                }
            } else {
                LiveDetailBean liveDetailBean6 = f18233g;
                if (!(liveDetailBean6 == null || (liveStream = liveDetailBean6.downStreamAddr) == null)) {
                    str = liveStream.hd;
                }
            }
            v2TXLivePlayer3.startLivePlay(str);
        }
        return true;
    }

    public final void k() {
        TXCloudVideoView tXCloudVideoView = f18230d;
        if (tXCloudVideoView != null) {
            tXCloudVideoView.setOnClickListener(b.f18242b);
        }
    }

    public final int m() {
        return f18239m;
    }

    public final LiveDetailBean n() {
        return f18233g;
    }

    public final TXCloudVideoView o() {
        return f18230d;
    }

    public final void p(Context context, TXCloudVideoView tXCloudVideoView, LiveDetailBean liveDetailBean, g gVar) {
        LiveStream liveStream;
        LiveStream liveStream2;
        LiveStream liveStream3;
        LiveStream liveStream4;
        LiveStream liveStream5;
        LiveStream liveStream6;
        a aVar = new a();
        f18241o = aVar;
        PhoneUtils.b(aVar);
        f18230d = tXCloudVideoView;
        f18233g = liveDetailBean;
        f18232f = gVar;
        Handler handler = new Handler(context.getMainLooper());
        f18235i = handler;
        handler.postDelayed(f18236j, 5000);
        if (liveDetailBean.status == 2) {
            V2TXLivePlayerImpl v2TXLivePlayerImpl = new V2TXLivePlayerImpl(context);
            f18229c = v2TXLivePlayerImpl;
            v2TXLivePlayerImpl.setRenderView(tXCloudVideoView);
            V2TXLivePlayer v2TXLivePlayer = f18229c;
            if (v2TXLivePlayer != null) {
                v2TXLivePlayer.setRenderFillMode(V2TXLiveDef.V2TXLiveFillMode.V2TXLiveFillModeFit);
            }
            V2TXLivePlayer v2TXLivePlayer2 = f18229c;
            if (v2TXLivePlayer2 != null) {
                int i11 = f18239m;
                String str = null;
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (f18240n) {
                            LiveDetailBean liveDetailBean2 = f18233g;
                            if (!(liveDetailBean2 == null || (liveStream6 = liveDetailBean2.transDownloadStreamAddr) == null)) {
                                str = liveStream6.f70257sd;
                            }
                        } else {
                            LiveDetailBean liveDetailBean3 = f18233g;
                            if (!(liveDetailBean3 == null || (liveStream5 = liveDetailBean3.downStreamAddr) == null)) {
                                str = liveStream5.f70257sd;
                            }
                        }
                    } else if (f18240n) {
                        LiveDetailBean liveDetailBean4 = f18233g;
                        if (!(liveDetailBean4 == null || (liveStream4 = liveDetailBean4.transDownloadStreamAddr) == null)) {
                            str = liveStream4.fhd;
                        }
                    } else {
                        LiveDetailBean liveDetailBean5 = f18233g;
                        if (!(liveDetailBean5 == null || (liveStream3 = liveDetailBean5.downStreamAddr) == null)) {
                            str = liveStream3.fhd;
                        }
                    }
                } else if (f18240n) {
                    LiveDetailBean liveDetailBean6 = f18233g;
                    if (!(liveDetailBean6 == null || (liveStream2 = liveDetailBean6.transDownloadStreamAddr) == null)) {
                        str = liveStream2.hd;
                    }
                } else {
                    LiveDetailBean liveDetailBean7 = f18233g;
                    if (!(liveDetailBean7 == null || (liveStream = liveDetailBean7.downStreamAddr) == null)) {
                        str = liveStream.hd;
                    }
                }
                v2TXLivePlayer2.startLivePlay(str);
            }
            q();
            V2TXLivePlayer v2TXLivePlayer3 = f18229c;
            if (v2TXLivePlayer3 != null) {
                v2TXLivePlayer3.setObserver(f18231e);
            }
        } else {
            r(context);
        }
        tXCloudVideoView.setKeepScreenOn(true);
    }

    public final void q() {
        f18231e = new b();
    }

    public final void r(Context context) {
        TXVodPlayer tXVodPlayer = new TXVodPlayer(context);
        f18228b = tXVodPlayer;
        tXVodPlayer.setPlayerView(f18230d);
        TXVodPlayer tXVodPlayer2 = f18228b;
        if (tXVodPlayer2 != null) {
            tXVodPlayer2.setRenderMode(1);
        }
        TXVodPlayer tXVodPlayer3 = f18228b;
        if (tXVodPlayer3 != null) {
            LiveDetailBean liveDetailBean = f18233g;
            tXVodPlayer3.startVodPlay(liveDetailBean != null ? liveDetailBean.mediaUrl : null);
        }
        TXVodPlayer tXVodPlayer4 = f18228b;
        if (tXVodPlayer4 != null) {
            tXVodPlayer4.setVodListener(new c());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if ((r0 != null && r0.isPlaying() == 1) != false) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean s() {
        /*
            r3 = this;
            com.tencent.rtmp.TXVodPlayer r0 = f18228b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.isPlaying()
            if (r0 != r1) goto L_0x000e
            r0 = r1
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            if (r0 != 0) goto L_0x0020
            com.tencent.live2.V2TXLivePlayer r0 = f18229c
            if (r0 == 0) goto L_0x001d
            int r0 = r0.isPlaying()
            if (r0 != r1) goto L_0x001d
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r0 = r2
        L_0x001e:
            if (r0 == 0) goto L_0x0025
        L_0x0020:
            boolean r0 = f18234h
            if (r0 == 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r1 = r2
        L_0x0026:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.content.helper.live.HbgLiveHelper.s():boolean");
    }

    public final boolean t() {
        return f18238l;
    }

    public final void u() {
        LiveDetailBean liveDetailBean = f18233g;
        if (liveDetailBean != null) {
            liveDetailBean.praiseNum = (liveDetailBean != null ? liveDetailBean.praiseNum : 0) + 1;
        }
        IHbgApi a11 = v7.b.a();
        LiveDetailBean liveDetailBean2 = f18233g;
        RequestExtKt.d(a11.E(liveDetailBean2 != null ? liveDetailBean2.f70249id : null), HbgLiveHelper$livePraise$1.INSTANCE, HbgLiveHelper$livePraise$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }

    public final void v() {
        IHbgApi a11 = v7.b.a();
        LiveDetailBean liveDetailBean = f18233g;
        RequestExtKt.d(a11.getMemberCount(liveDetailBean != null ? liveDetailBean.f70249id : null), HbgLiveHelper$loopMemberCount$1.INSTANCE, HbgLiveHelper$loopMemberCount$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        Handler handler = f18235i;
        if (handler != null) {
            handler.postDelayed(f18236j, 5000);
        }
    }

    public final void w() {
        IHbgApi a11 = v7.b.a();
        LiveDetailBean liveDetailBean = f18233g;
        RequestExtKt.d(a11.getLivePraiseCount(liveDetailBean != null ? liveDetailBean.f70249id : null), HbgLiveHelper$loopPraiseNum$1.INSTANCE, HbgLiveHelper$loopPraiseNum$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
        Handler handler = f18235i;
        if (handler != null) {
            handler.postDelayed(f18237k, 1000);
        }
    }

    public final void x() {
        TXVodPlayer tXVodPlayer = f18228b;
        if (tXVodPlayer != null) {
            tXVodPlayer.pause();
        }
    }

    public final void y() {
        TXVodPlayer tXVodPlayer = f18228b;
        if (tXVodPlayer != null) {
            tXVodPlayer.resume();
        }
    }
}
