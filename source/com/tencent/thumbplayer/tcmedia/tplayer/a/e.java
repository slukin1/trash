package com.tencent.thumbplayer.tcmedia.tplayer.a;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.thumbplayer.tcmedia.api.reportv2.ITPReportInfoGetter;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.a.a;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.a.c;
import com.tencent.thumbplayer.tcmedia.tplayer.a.b.a.d;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class e extends c {
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f49510i = true;

    /* renamed from: j  reason: collision with root package name */
    private boolean f49511j = false;

    /* renamed from: k  reason: collision with root package name */
    private d f49512k = new d();

    /* renamed from: l  reason: collision with root package name */
    private final Object f49513l = new Object();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public Future<?> f49514m = null;

    /* renamed from: n  reason: collision with root package name */
    private Runnable f49515n = new Runnable() {
        public void run() {
            if (e.this.f49510i) {
                TPLogUtil.i("TPLiveReporter", "Period Timer Exit because play done.");
                e.this.f49514m.cancel(true);
                Future unused = e.this.f49514m = null;
                return;
            }
            e.this.g();
        }
    };

    private void a(long j11, int i11, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        Map<String, String> b11 = b(j11, i11, tPGeneralPlayFlowParams).b();
        a("reportLiveEndEvent", b11);
        b("live_end", b11);
        c("live_end", b11);
    }

    private void a(long j11, int i11, TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        if (this.f49511j) {
            h(new b.C0619b());
            this.f49511j = false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d dVar = this.f49512k;
        dVar.f49509m += elapsedRealtime - dVar.f49504h;
        d();
        TPLogUtil.i("TPLiveReporter", "reportPlayerEndEvent playerStopTimeMs:" + j11 + " errorCode:" + i11);
        a(tPGeneralPlayFlowParams, tPDynamicStatisticParams);
        a(j11, i11, tPGeneralPlayFlowParams);
    }

    private void a(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        Map<String, String> b11 = b(tPGeneralPlayFlowParams, tPDynamicStatisticParams).b();
        a("reportLiveEndFlowEvent", b11);
        b("live_flow", b11);
        c("live_flow", b11);
    }

    private void a(a aVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        aVar.q(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoDecoderType);
        aVar.r(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioDecoderType);
        aVar.s(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mVideoRenderType);
        aVar.t(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mAudioRenderType);
        aVar.p(tPGeneralPlayFlowParams.mPlayerBaseMediaParams.mDemuxerType);
    }

    private void a(d dVar, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        dVar.f(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        dVar.g(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadPrepareTimeMs);
        dVar.h(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadPrepareTimeMs);
        dVar.i(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerOpenFileSTimeMs);
        dVar.j(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreApiPrepareTimeMs);
        dVar.k(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mInitFirstClipPositionETimeMs);
        dVar.l(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoPacketReadETimeMs);
        dVar.m(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioPacketReadETimeMs);
        dVar.n(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mDemuxerThreadOnPreparedTimeMs);
        dVar.o(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mCoreSchedulingThreadOnPreparedTimeMs);
        dVar.q(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mVideoDecoderOpenedTimeMs);
        dVar.r(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstVideoFrameRenderETimeMs);
        dVar.s(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mAudioDecoderOpenedTimeMs);
        dVar.t(tPGeneralPlayFlowParams.mPlayerGeneralTrackingParams.mFirstAudioFrameRenderETimeMs);
    }

    private a b(long j11, int i11, TPGeneralPlayFlowParams tPGeneralPlayFlowParams) {
        a aVar = new a();
        d dVar = this.f49512k;
        long j12 = dVar.f49505i + (j11 - dVar.f49503g);
        dVar.f49505i = j12;
        aVar.c(j12);
        aVar.o(i11);
        a(aVar, tPGeneralPlayFlowParams);
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.a aVar2 = this.f49512k.f49353a;
        int i12 = this.f49500g;
        this.f49500g = i12 + 1;
        aVar2.a(i12);
        this.f49499f.b(this.f49512k.f49353a);
        aVar.a(this.f49512k.f49353a);
        return aVar;
    }

    private d b(TPGeneralPlayFlowParams tPGeneralPlayFlowParams, TPDynamicStatisticParams tPDynamicStatisticParams) {
        d dVar = new d();
        dVar.c(this.f49498e.f49536a);
        dVar.d(this.f49498e.f49537b);
        dVar.e(this.f49498e.f49538c);
        dVar.p(this.f49512k.f49502f);
        a(dVar, tPGeneralPlayFlowParams);
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.a aVar = this.f49512k.f49353a;
        int i11 = this.f49500g;
        this.f49500g = i11 + 1;
        aVar.a(i11);
        this.f49499f.b(this.f49512k.f49353a);
        dVar.a(this.f49512k.f49353a);
        return dVar;
    }

    private void c() {
        TPLogUtil.i("TPLiveReporter", "startPeriodReportTimer");
        synchronized (this.f49513l) {
            if (this.f49514m == null) {
                this.f49514m = o.a().e().scheduleAtFixedRate(this.f49515n, 0, 60000, TimeUnit.MILLISECONDS);
            }
        }
    }

    private void c(b.a aVar) {
        if (!(aVar instanceof b.o)) {
            TPLogUtil.e("TPLiveReporter", "onPrepareDone fail:params is not match");
            return;
        }
        b.o oVar = (b.o) aVar;
        long b11 = oVar.b() - this.f49498e.f49538c;
        this.f49512k.f49502f = oVar.b();
        TPLogUtil.i("TPLiveReporter", "Live onPrepareDone timeMs:".concat(String.valueOf(b11)));
        a((b) this.f49512k);
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.a aVar2 = this.f49512k.f49353a;
        int i11 = this.f49500g;
        this.f49500g = i11 + 1;
        aVar2.a(i11);
        this.f49499f.b(this.f49512k.f49353a);
        b((b) this.f49512k);
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.a.b bVar = new com.tencent.thumbplayer.tcmedia.tplayer.a.b.a.b();
        bVar.c(b11);
        bVar.a(this.f49512k.f49353a);
        Map<String, String> b12 = bVar.b();
        a("onPrepareDone", b12);
        b("live_first_load", b12);
        c("live_first_load", b12);
    }

    private void c(b bVar) {
        ITPReportInfoGetter iTPReportInfoGetter = this.f49494a;
        if (iTPReportInfoGetter != null) {
            Map<String, String> periodExtendReportInfo = iTPReportInfoGetter.getPeriodExtendReportInfo();
            if (periodExtendReportInfo == null) {
                TPLogUtil.e("TPLiveReporter", "fillPeriodExtReportInfoToCommonParams fail, period ExtendReportInfo is null");
                return;
            }
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            c.a(periodExtendReportInfo, hashMap, hashMap2);
            bVar.f49353a.c((Map<String, String>) hashMap);
            bVar.f49353a.d((Map<String, String>) hashMap2);
        }
    }

    private synchronized void d() {
        TPLogUtil.i("TPLiveReporter", "destroyPeriodReportTimer");
        synchronized (this.f49513l) {
            Future<?> future = this.f49514m;
            if (future != null) {
                future.cancel(true);
                this.f49514m = null;
            }
        }
    }

    private void d(b.a aVar) {
        if (!(aVar instanceof b.m)) {
            TPLogUtil.e("TPLiveReporter", "onPlayerStart fail:params is not match");
            return;
        }
        b.m mVar = (b.m) aVar;
        this.f49510i = false;
        d dVar = this.f49512k;
        if (dVar.f49503g == 0) {
            dVar.f49503g = mVar.b();
        }
        this.f49512k.f49504h = mVar.b();
        TPLogUtil.i("TPLiveReporter", "Live onPlayerStart FirstStartTimeMs:" + this.f49512k.f49503g + " mPlayerStartOccurElapsedTimeMs:" + this.f49512k.f49504h);
        c();
    }

    private void e() {
        TPLogUtil.i("TPLiveReporter", "onAppForeground");
        a(this.f49512k.f49353a.a());
    }

    private void e(b.a aVar) {
        if (this.f49510i) {
            TPLogUtil.e("TPLiveReporter", "Player has been called End");
            return;
        }
        this.f49510i = true;
        a(aVar.b(), 0, a(aVar), b(aVar));
        a(this.f49512k.f49353a.a());
    }

    private void f() {
        TPLogUtil.i("TPLiveReporter", "onAppBackground");
        if (!this.f49510i) {
            a("live_flow", (com.tencent.thumbplayer.tcmedia.tplayer.a.b.a) b(b(), a(false)));
            a("live_end", (com.tencent.thumbplayer.tcmedia.tplayer.a.b.a) b(SystemClock.elapsedRealtime(), 0, b()));
        }
    }

    private void f(b.a aVar) {
        if (this.f49510i) {
            TPLogUtil.e("TPLiveReporter", "Player has been called End");
            return;
        }
        this.f49510i = true;
        if (!(aVar instanceof b.i)) {
            TPLogUtil.e("TPLiveReporter", "onPlayerError fail:params is not match");
            return;
        }
        b.i iVar = (b.i) aVar;
        a(iVar.b(), iVar.e(), a((b.a) iVar), b((b.a) iVar));
        a(this.f49512k.f49353a.a());
    }

    /* access modifiers changed from: private */
    public void g() {
        TPLogUtil.i("TPLiveReporter", "periodReportEvent enter.");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        d dVar = this.f49512k;
        dVar.f49509m += elapsedRealtime - dVar.f49504h;
        dVar.f49504h = SystemClock.elapsedRealtime();
        c cVar = new c();
        cVar.o(this.f49512k.f49508l);
        cVar.c(this.f49512k.f49507k);
        cVar.d(this.f49512k.f49509m);
        TPDynamicStatisticParams a11 = this.f49495b.a(true);
        cVar.e(a11.mMaxVideoStreamBitrate);
        cVar.f(a11.mAvgVideoStreamBitrate);
        cVar.g(a11.mMinVideoStreamBitrate);
        cVar.h(a11.mMaxVideoDecodeCostTimeMs);
        cVar.i(a11.mAvgVideoDecodeCostTimeMs);
        cVar.j(a11.mMinVideoDecodeCostTimeMs);
        cVar.r(a11.mMaxVideoGopSize);
        cVar.q(a11.mAvgVideoGopSize);
        cVar.p(a11.mMinVideoGopSize);
        cVar.s(a11.mVideoDecodeFrameCount);
        cVar.t(a11.mVideoRenderFrameCount);
        cVar.k(a11.mVideoBufferedDurationMs);
        cVar.l(a11.mAudioBufferedDurationMs);
        c((b) this.f49512k);
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.a aVar = this.f49512k.f49353a;
        int i11 = this.f49500g;
        this.f49500g = i11 + 1;
        aVar.a(i11);
        this.f49499f.b(this.f49512k.f49353a);
        cVar.a(this.f49512k.f49353a);
        Map<String, String> b11 = cVar.b();
        a("periodReportEvent", b11);
        b("live_period_report", b11);
        c("live_period_report", b11);
        d dVar2 = this.f49512k;
        dVar2.f49508l = 0;
        dVar2.f49507k = 0;
        dVar2.f49509m = 0;
        dVar2.f49353a.c((Map<String, String>) null);
        this.f49512k.f49353a.d((Map<String, String>) null);
    }

    private void g(b.a aVar) {
        if (!(aVar instanceof b.c)) {
            TPLogUtil.e("TPLiveReporter", "onBufferingStart fail:params is not match");
            return;
        }
        this.f49511j = true;
        this.f49512k.f49506j = ((b.c) aVar).b();
        TPLogUtil.i("TPLiveReporter", "Live onBufferingStart timeMs:" + this.f49512k.f49506j);
        d dVar = this.f49512k;
        dVar.f49509m = dVar.f49509m + (dVar.f49506j - dVar.f49504h);
    }

    private void h(b.a aVar) {
        if (!(aVar instanceof b.C0619b)) {
            TPLogUtil.e("TPLiveReporter", "onBufferingEnd fail:params is not match");
            return;
        }
        this.f49511j = false;
        long b11 = ((b.C0619b) aVar).b();
        d dVar = this.f49512k;
        long j11 = b11 - dVar.f49506j;
        dVar.f49504h = SystemClock.elapsedRealtime();
        TPLogUtil.i("TPLiveReporter", "Live onBufferingEnd bufferingCostTimeMs:".concat(String.valueOf(j11)));
        if (j11 > 1200) {
            d dVar2 = this.f49512k;
            dVar2.f49508l++;
            dVar2.f49507k += j11;
            dVar2.f49506j = 0;
        }
    }

    private void i(b.a aVar) {
        if (!(aVar instanceof b.e)) {
            TPLogUtil.e("TPLiveReporter", "onDTProcessUpdate fail:params is not match");
            return;
        }
        int d11 = ((b.e) aVar).d();
        TPLogUtil.i("TPLiveReporter", "Vod onDTProcessUpdate speedKbps:".concat(String.valueOf(d11)));
        this.f49512k.f49354b = d11;
    }

    private void j(b.a aVar) {
        if (!(aVar instanceof b.d)) {
            TPLogUtil.e("TPLiveReporter", "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        b.d dVar = (b.d) aVar;
        String d11 = dVar.d();
        String e11 = dVar.e();
        TPLogUtil.i("TPLiveReporter", "Vod onDTCdnUrlUpdate cdnIp:" + d11 + " uIp:" + e11);
        d dVar2 = this.f49512k;
        dVar2.f49355c = d11;
        dVar2.f49356d = e11;
    }

    private void k(b.a aVar) {
        if (!(aVar instanceof b.f)) {
            TPLogUtil.e("TPLiveReporter", "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String d11 = ((b.f) aVar).d();
        TPLogUtil.i("TPLiveReporter", "Vod onDTProtocolUpdate protocolVer:".concat(String.valueOf(d11)));
        this.f49512k.f49357e = d11;
    }

    public void a() {
        super.a();
        d();
    }

    public void a(int i11, b.a aVar) {
        if (i11 == 2) {
            c(aVar);
        } else if (i11 == 3) {
            d(aVar);
        } else if (i11 == 5) {
            e(aVar);
        } else if (i11 == 6) {
            f(aVar);
        } else if (i11 == 9) {
            g(aVar);
        } else if (i11 == 10) {
            h(aVar);
        } else if (i11 == 1001) {
            e();
        } else if (i11 != 1002) {
            switch (i11) {
                case 100:
                    i(aVar);
                    return;
                case 101:
                    j(aVar);
                    return;
                case 102:
                    k(aVar);
                    return;
                default:
                    return;
            }
        } else {
            f();
        }
    }

    public void a(Context context, l lVar) {
        super.a(context, lVar);
        this.f49499f.a(this.f49512k.f49353a);
    }
}
