package com.tencent.thumbplayer.tcmedia.tplayer.a;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.thumbplayer.tcmedia.api.TPDrmInfo;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.a;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.c;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.d;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.e;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.f;
import com.tencent.thumbplayer.tcmedia.tplayer.a.m;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.Map;

public class n extends c {

    /* renamed from: i  reason: collision with root package name */
    private boolean f49564i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f49565j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49566k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f49567l = false;

    /* renamed from: m  reason: collision with root package name */
    private m f49568m = new m();

    private void a(long j11, int i11, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        Map<String, String> b11 = b(j11, i11, tPGeneralPlayFlowParams).b();
        a("reportVodEndEvent", b11);
        b("vod_end", b11);
        c("vod_end", b11);
    }

    private void a(long j11, int i11, TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        if (this.f49566k) {
            k(new b.C0619b());
            this.f49566k = false;
        }
        if (this.f49565j) {
            i(new b.q());
            this.f49565j = false;
        }
        if (this.f49567l) {
            m mVar = this.f49568m;
            if (mVar.f49550j > 0) {
                long j12 = mVar.f49551k;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                m mVar2 = this.f49568m;
                mVar.f49551k = j12 + (elapsedRealtime - mVar2.f49550j);
                mVar2.f49550j = 0;
            }
            this.f49567l = false;
        }
        StringBuilder sb2 = new StringBuilder("reportPlayerEndEvent playerStopTimeMs:");
        long j13 = j11;
        sb2.append(j11);
        sb2.append(" errorCode:");
        int i12 = i11;
        sb2.append(i11);
        TPLogUtil.i("TPVodReporter", sb2.toString());
        a(tPGeneralPlayFlowParams, tPDynamicStatisticParams);
        a(j11, i11, tPGeneralPlayFlowParams);
    }

    private void a(long j11, long j12, int i11) {
        if (!this.f49568m.f49560t.containsKey(Long.valueOf(j11))) {
            TPLogUtil.e("TPVodReporter", "reportSelectTrackEndEvent mSelectTrackInfoList is not contain key:".concat(String.valueOf(j11)));
            return;
        }
        m.a aVar = this.f49568m.f49560t.get(Long.valueOf(j11));
        long j13 = j12 - aVar.f49562b;
        TPLogUtil.i("TPVodReporter", "reportSelectTrackEndEvent trackUniqueIndex:" + j11 + " costTimeMs:" + j13 + " trackId:" + aVar.f49561a);
        f fVar = new f();
        fVar.o(i11);
        fVar.c(j13);
        fVar.p(aVar.f49563c.getTrackType());
        fVar.q(aVar.f49563c.isInternal ? 1 : 0);
        this.f49499f.b(this.f49568m.f49353a);
        a aVar2 = this.f49568m.f49353a;
        int i12 = this.f49500g;
        this.f49500g = i12 + 1;
        aVar2.a(i12);
        fVar.a(this.f49568m.f49353a);
        Map<String, String> b11 = fVar.b();
        a("onSelectTrackEnd", b11);
        b("vod_select_track", b11);
        c("vod_select_track", b11);
        this.f49568m.f49560t.remove(Long.valueOf(j11));
    }

    private void a(TPDrmInfo tPDrmInfo) {
        Map<String, String> b11 = b(tPDrmInfo).b();
        a("reportPlayerDrmInfoEvent", b11);
        b("vod_drm_authentication", b11);
        c("vod_drm_authentication", b11);
    }

    private void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        Map<String, String> b11 = b(tPGeneralPlayFlowParams, tPDynamicStatisticParams).b();
        a("reportVodEndFlowEvent", b11);
        b("vod_flow", b11);
        c("vod_flow", b11);
    }

    private void a(c cVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        cVar.t(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoDecoderType);
        cVar.u(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioDecoderType);
        cVar.v(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoRenderType);
        cVar.w(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioRenderType);
        cVar.s(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mDemuxerType);
    }

    private void a(e eVar, TPDynamicStatisticParams tPDynamicStatisticParams) {
        eVar.u(tPDynamicStatisticParams.mMaxVideoStreamBitrate);
        eVar.v(tPDynamicStatisticParams.mAvgVideoStreamBitrate);
        eVar.w(tPDynamicStatisticParams.mMinVideoStreamBitrate);
        eVar.x(tPDynamicStatisticParams.mMaxVideoDecodeCostTimeMs);
        eVar.y(tPDynamicStatisticParams.mAvgVideoDecodeCostTimeMs);
        eVar.z(tPDynamicStatisticParams.mMinVideoDecodeCostTimeMs);
        eVar.o(tPDynamicStatisticParams.mVideoDecodeFrameCount);
        eVar.p(tPDynamicStatisticParams.mVideoRenderFrameCount);
    }

    private void a(e eVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        eVar.f(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        eVar.g(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadPrepareTimeMs);
        eVar.h(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadPrepareTimeMs);
        eVar.i(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerOpenFileSTimeMs);
        eVar.j(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        eVar.k(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mInitFirstClipPositionETimeMs);
        eVar.l(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoPacketReadETimeMs);
        eVar.m(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioPacketReadETimeMs);
        eVar.n(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadOnPreparedTimeMs);
        eVar.o(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadOnPreparedTimeMs);
        eVar.q(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mVideoDecoderOpenedTimeMs);
        eVar.r(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoFrameRenderETimeMs);
        eVar.s(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mAudioDecoderOpenedTimeMs);
        eVar.t(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioFrameRenderETimeMs);
    }

    private com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.b b(TPDrmInfo tPDrmInfo) {
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.b bVar = new com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.b();
        bVar.n(tPDrmInfo.drmAbility);
        bVar.q(tPDrmInfo.drmSupportSecureDecoder);
        bVar.r(tPDrmInfo.drmSupportSecureDecrypt);
        bVar.p(tPDrmInfo.drmSecureLevel);
        bVar.q(tPDrmInfo.drmComponentName);
        bVar.o(tPDrmInfo.drmType);
        bVar.c(tPDrmInfo.drmPrepareStartTimeMs);
        bVar.d(tPDrmInfo.drmPrepareEndTimeMs);
        bVar.e(tPDrmInfo.drmOpenSessionStartTimeMs);
        bVar.f(tPDrmInfo.drmOpenSessionEndTimeMs);
        bVar.g(tPDrmInfo.drmGetProvisionReqStartTimeMs);
        bVar.h(tPDrmInfo.drmGetProvisionReqEndTimeMs);
        bVar.i(tPDrmInfo.drmSendProvisionReqTimeMs);
        bVar.j(tPDrmInfo.drmRecvProvisionRespTimeMs);
        bVar.k(tPDrmInfo.drmProvideProvisionRespStartTimeMs);
        bVar.l(tPDrmInfo.drmProvideProvisionRespEndTimeMs);
        bVar.m(tPDrmInfo.drmGetKeyReqStartTimeMs);
        bVar.n(tPDrmInfo.drmGetKeyReqEndTimeMs);
        bVar.o(tPDrmInfo.drmSendKeyReqTimeMs);
        bVar.p(tPDrmInfo.drmRecvKeyRespTimeMs);
        bVar.q(tPDrmInfo.drmProvideKeyRespStartTimeMs);
        bVar.r(tPDrmInfo.drmProvideKeyRespEndTimeMs);
        this.f49499f.b(this.f49568m.f49353a);
        a aVar = this.f49568m.f49353a;
        int i11 = this.f49500g;
        this.f49500g = i11 + 1;
        aVar.a(i11);
        bVar.a(this.f49568m.f49353a);
        return bVar;
    }

    private c b(long j11, int i11, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        c cVar = new c();
        m mVar = this.f49568m;
        long j12 = j11 - mVar.f49547g;
        mVar.f49549i = j12;
        cVar.c(j12);
        cVar.o(i11);
        cVar.p(this.f49568m.f49553m);
        cVar.q(this.f49568m.f49554n);
        cVar.d((long) this.f49568m.f49555o);
        cVar.r(this.f49568m.f49557q);
        cVar.e((long) this.f49568m.f49558r);
        a(cVar, tPGeneralPlayFlowParams);
        a aVar = this.f49568m.f49353a;
        int i12 = this.f49500g;
        this.f49500g = i12 + 1;
        aVar.a(i12);
        this.f49499f.b(this.f49568m.f49353a);
        cVar.a(this.f49568m.f49353a);
        return cVar;
    }

    private e b(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        e eVar = new e();
        eVar.c(this.f49498e.f49536a);
        eVar.d(this.f49498e.f49537b);
        eVar.e(this.f49498e.f49538c);
        eVar.p(this.f49568m.f49546f);
        a(eVar, tPGeneralPlayFlowParams);
        a(eVar, tPDynamicStatisticParams);
        this.f49499f.b(this.f49568m.f49353a);
        a aVar = this.f49568m.f49353a;
        int i11 = this.f49500g;
        this.f49500g = i11 + 1;
        aVar.a(i11);
        eVar.a(this.f49568m.f49353a);
        return eVar;
    }

    private void c() {
        TPLogUtil.i("TPVodReporter", "onAppForeground");
        a(this.f49568m.f49353a.a());
    }

    private void c(b.a aVar) {
        if (!(aVar instanceof b.o)) {
            TPLogUtil.e("TPVodReporter", "onPrepareDone fail:params is not match");
            return;
        }
        b.o oVar = (b.o) aVar;
        long b11 = oVar.b() - this.f49498e.f49538c;
        this.f49568m.f49546f = oVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onPrepareDone timeMs:".concat(String.valueOf(b11)));
        a((b) this.f49568m);
        a aVar2 = this.f49568m.f49353a;
        int i11 = this.f49500g;
        this.f49500g = i11 + 1;
        aVar2.a(i11);
        this.f49499f.b(this.f49568m.f49353a);
        b((b) this.f49568m);
        d dVar = new d();
        dVar.c(b11);
        dVar.a(this.f49568m.f49353a);
        Map<String, String> b12 = dVar.b();
        a("onPrepareDone", b12);
        b("vod_first_load", b12);
        c("vod_first_load", b12);
    }

    private void d() {
        TPLogUtil.i("TPVodReporter", "onAppBackground");
        if (!this.f49564i) {
            a("vod_flow", (a) b(b(), a(false)));
            a("vod_end", (a) b(SystemClock.elapsedRealtime(), 0, b()));
        }
    }

    private void d(b.a aVar) {
        if (!(aVar instanceof b.m)) {
            TPLogUtil.e("TPVodReporter", "onPlayerStart fail:params is not match");
            return;
        }
        b.m mVar = (b.m) aVar;
        this.f49564i = false;
        this.f49567l = false;
        m mVar2 = this.f49568m;
        if (mVar2.f49547g == 0) {
            mVar2.f49547g = mVar.b();
        }
        this.f49568m.f49548h = mVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onPlayerStart timeMs:" + this.f49568m.f49548h);
        m mVar3 = this.f49568m;
        if (mVar3.f49550j > 0) {
            long j11 = mVar3.f49551k;
            long b11 = mVar.b();
            m mVar4 = this.f49568m;
            mVar3.f49551k = j11 + (b11 - mVar4.f49550j);
            mVar4.f49550j = 0;
        }
    }

    private void e(b.a aVar) {
        if (!(aVar instanceof b.j)) {
            TPLogUtil.e("TPVodReporter", "onPlayerPause fail:params is not match");
            return;
        }
        b.j jVar = (b.j) aVar;
        if (this.f49567l) {
            TPLogUtil.e("TPVodReporter", "onPlayerPause has been called");
            return;
        }
        this.f49567l = true;
        this.f49568m.f49550j = jVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onPlayerPause timeMs:" + this.f49568m.f49550j);
    }

    private void f(b.a aVar) {
        if (this.f49564i) {
            TPLogUtil.e("TPVodReporter", "Player has been called End");
            return;
        }
        this.f49564i = true;
        a(aVar.b(), 0, a(aVar), b(aVar));
        a(this.f49568m.f49353a.a());
    }

    private void g(b.a aVar) {
        if (this.f49564i) {
            TPLogUtil.e("TPVodReporter", "Player has been called End");
            return;
        }
        this.f49564i = true;
        if (!(aVar instanceof b.i)) {
            TPLogUtil.e("TPVodReporter", "onPlayerError fail:params is not match");
            return;
        }
        b.i iVar = (b.i) aVar;
        a(iVar.b(), iVar.e(), a((b.a) iVar), b((b.a) iVar));
        a(this.f49568m.f49353a.a());
    }

    private void h(b.a aVar) {
        if (!(aVar instanceof b.r)) {
            TPLogUtil.e("TPVodReporter", "onSeekStart fail:params is not match");
            return;
        }
        b.r rVar = (b.r) aVar;
        if (this.f49566k) {
            k(new b.C0619b());
        }
        if (this.f49565j) {
            i(new b.q());
        }
        this.f49565j = true;
        this.f49568m.f49552l = rVar.b();
        TPLogUtil.i("TPVodReporter", "Vod onSeekStart timeMs:" + this.f49568m.f49552l);
    }

    private void i(b.a aVar) {
        if (!(aVar instanceof b.q)) {
            TPLogUtil.e("TPVodReporter", "onSeekEnd fail:params is not match");
            return;
        }
        this.f49565j = false;
        long b11 = ((b.q) aVar).b();
        m mVar = this.f49568m;
        long j11 = b11 - mVar.f49552l;
        if (j11 > 1200) {
            mVar.f49554n++;
            mVar.f49555o = (int) (((long) mVar.f49555o) + j11);
        }
        mVar.f49553m++;
        TPLogUtil.i("TPVodReporter", "Vod onSeekEnd seekCostTimeMs:" + j11 + " mSeekTotalCount:" + this.f49568m.f49553m + " mSeekBufferingTotalCount:" + this.f49568m.f49554n + " mSeekBufferingTotalDurationMs:" + this.f49568m.f49555o);
    }

    private void j(b.a aVar) {
        if (!(aVar instanceof b.c)) {
            TPLogUtil.e("TPVodReporter", "onBufferingStart fail:params is not match");
            return;
        }
        b.c cVar = (b.c) aVar;
        this.f49566k = true;
        if (!this.f49565j) {
            this.f49568m.f49556p = cVar.b();
            TPLogUtil.i("TPVodReporter", "Vod onBufferingStart timeMs:" + this.f49568m.f49556p);
        }
    }

    private void k(b.a aVar) {
        if (!(aVar instanceof b.C0619b)) {
            TPLogUtil.e("TPVodReporter", "onBufferingEnd fail:params is not match");
            return;
        }
        b.C0619b bVar = (b.C0619b) aVar;
        this.f49566k = false;
        if (!this.f49565j) {
            long b11 = bVar.b() - this.f49568m.f49556p;
            TPLogUtil.i("TPVodReporter", "Vod onBufferingEnd bufferingCostTimeMs:".concat(String.valueOf(b11)));
            if (b11 > 1200) {
                m mVar = this.f49568m;
                mVar.f49557q++;
                mVar.f49558r = (int) (((long) mVar.f49558r) + b11);
                com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.a aVar2 = new com.tencent.thumbplayer.tcmedia.tplayer.a.b.b.a();
                aVar2.b(this.f49568m.f49559s);
                aVar2.c(b11);
                this.f49499f.b(this.f49568m.f49353a);
                a aVar3 = this.f49568m.f49353a;
                int i11 = this.f49500g;
                this.f49500g = i11 + 1;
                aVar3.a(i11);
                aVar2.a(this.f49568m.f49353a);
                Map<String, String> b12 = aVar2.b();
                a("onBufferingEnd", b12);
                b("vod_second_buffering", b12);
                c("vod_second_buffering", b12);
            }
        }
    }

    private void l(b.a aVar) {
        if (!(aVar instanceof b.v)) {
            TPLogUtil.e("TPVodReporter", "onSetPlaySpeed fail:params is not match");
            return;
        }
        this.f49568m.f49559s = ((b.v) aVar).d();
        TPLogUtil.i("TPVodReporter", "Vod onSetPlaySpeed mPlaySpeed:" + this.f49568m.f49559s);
    }

    private void m(b.a aVar) {
        if (!(aVar instanceof b.t)) {
            TPLogUtil.e("TPVodReporter", "onSelectTrackStart fail:params is not match");
            return;
        }
        b.t tVar = (b.t) aVar;
        int d11 = tVar.d();
        long e11 = tVar.e();
        TPLogUtil.i("TPVodReporter", "Vod onSelectTrackStart trackId:" + d11 + " trackUniqueIndex:" + e11);
        if (!this.f49568m.f49560t.containsKey(Long.valueOf(e11))) {
            m.a aVar2 = new m.a();
            aVar2.f49561a = d11;
            aVar2.f49563c = tVar.f();
            aVar2.f49562b = tVar.b();
            this.f49568m.f49560t.put(Long.valueOf(tVar.e()), aVar2);
        }
    }

    private void n(b.a aVar) {
        if (!(aVar instanceof b.s)) {
            TPLogUtil.e("TPVodReporter", "onSelectTrackEnd fail:params is not match");
            return;
        }
        b.s sVar = (b.s) aVar;
        int d11 = sVar.d();
        long e11 = sVar.e();
        TPLogUtil.i("TPVodReporter", "Vod onSelectTrackEnd errorCode:" + d11 + " trackUniqueIndex:" + e11);
        a(e11, sVar.b(), d11);
    }

    private void o(b.a aVar) {
        if (!(aVar instanceof b.h)) {
            TPLogUtil.e("TPVodReporter", "onDrmInfo fail:params is not match");
        } else {
            a(((b.h) aVar).d());
        }
    }

    private void p(b.a aVar) {
        if (!(aVar instanceof b.e)) {
            TPLogUtil.e("TPVodReporter", "onDTProcessUpdate fail:params is not match");
            return;
        }
        int d11 = ((b.e) aVar).d();
        TPLogUtil.i("TPVodReporter", "Vod onDTProcessUpdate speedKbps:".concat(String.valueOf(d11)));
        this.f49568m.f49354b = d11;
    }

    private void q(b.a aVar) {
        if (!(aVar instanceof b.d)) {
            TPLogUtil.e("TPVodReporter", "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        b.d dVar = (b.d) aVar;
        String d11 = dVar.d();
        String e11 = dVar.e();
        TPLogUtil.i("TPVodReporter", "Vod onDTCdnUrlUpdate cdnIp:" + d11 + " uIp:" + e11);
        m mVar = this.f49568m;
        mVar.f49355c = d11;
        mVar.f49356d = e11;
    }

    private void r(b.a aVar) {
        if (!(aVar instanceof b.f)) {
            TPLogUtil.e("TPVodReporter", "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String d11 = ((b.f) aVar).d();
        TPLogUtil.i("TPVodReporter", "Vod onDTProtocolUpdate protocolVer:".concat(String.valueOf(d11)));
        this.f49568m.f49357e = d11;
    }

    public void a() {
        super.a();
    }

    public void a(int i11, b.a aVar) {
        if (i11 == 1001) {
            c();
        } else if (i11 != 1002) {
            switch (i11) {
                case 2:
                    c(aVar);
                    return;
                case 3:
                    d(aVar);
                    return;
                case 4:
                    e(aVar);
                    return;
                case 5:
                    f(aVar);
                    return;
                case 6:
                    g(aVar);
                    return;
                case 7:
                    h(aVar);
                    return;
                case 8:
                    i(aVar);
                    return;
                case 9:
                    j(aVar);
                    return;
                case 10:
                    k(aVar);
                    return;
                case 11:
                    m(aVar);
                    return;
                case 12:
                    n(aVar);
                    return;
                case 13:
                    l(aVar);
                    return;
                case 14:
                    o(aVar);
                    return;
                default:
                    switch (i11) {
                        case 100:
                            p(aVar);
                            return;
                        case 101:
                            q(aVar);
                            return;
                        case 102:
                            r(aVar);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            d();
        }
    }

    public void a(Context context, l lVar) {
        super.a(context, lVar);
        this.f49499f.a(this.f49568m.f49353a);
    }
}
