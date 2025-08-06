package com.tencent.thumbplayer.tcmedia.tplayer.a;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.d.b;
import com.tencent.thumbplayer.tcmedia.tplayer.a.a.a;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.Map;
import org.json.JSONObject;

public class f extends c {

    /* renamed from: i  reason: collision with root package name */
    private b f49517i = new b();

    private void c() {
        a aVar = this.f49495b;
        if (aVar == null) {
            TPLogUtil.e("TPPrepareFailReporter", "fillStreamInfoToCommonParams fail, not set mPlayerInfoGetter");
            return;
        }
        TPGeneralPlayFlowParams a11 = aVar.a();
        this.f49517i.f49353a.a(this.f49498e.f49544i);
        this.f49517i.f49353a.f(this.f49498e.f49542g);
        this.f49517i.f49353a.j(this.f49498e.f49540e);
        this.f49517i.f49353a.l(TPDownloadProxyHelper.getNativeLibVersion());
        b bVar = this.f49517i;
        bVar.f49353a.k(bVar.f49354b);
        b bVar2 = this.f49517i;
        bVar2.f49353a.o(bVar2.f49357e);
        b bVar3 = this.f49517i;
        bVar3.f49353a.m(bVar3.f49356d);
        b bVar4 = this.f49517i;
        bVar4.f49353a.n(bVar4.f49355c);
        this.f49517i.f49353a.l(this.f49498e.f49543h);
        this.f49501h.put("buffermintotaldurationms", Long.valueOf(a11.mPlayerConfigParams.mBufferMinTotalDurationMs));
        this.f49501h.put("buffermaxtotaldurationms", Long.valueOf(a11.mPlayerConfigParams.mBufferMaxTotalDurationMs));
        this.f49501h.put("preloadtotaldurationms", Long.valueOf(a11.mPlayerConfigParams.mPreloadTotalDurationMs));
        this.f49501h.put("minbufferingdurationms", Long.valueOf(a11.mPlayerConfigParams.mMinBufferingDurationMs));
        this.f49501h.put("minbufferingtimems", Long.valueOf(a11.mPlayerConfigParams.mMinBufferingTimeMs));
        this.f49501h.put("maxbufferingtimems", Long.valueOf(a11.mPlayerConfigParams.mMaxBufferingTimeMs));
        this.f49501h.put("reducelatencyaction", Integer.valueOf(a11.mPlayerConfigParams.mReduceLatencyAction));
        this.f49501h.put("reducelatencyspeed", Float.valueOf(a11.mPlayerConfigParams.mReduceLatencyPlaySpeed));
        this.f49501h.put("buffertype", Integer.valueOf(a11.mPlayerConfigParams.mBufferType));
        try {
            this.f49517i.f49353a.p(new JSONObject(this.f49501h).toString());
        } catch (NullPointerException e11) {
            TPLogUtil.e("TPPrepareFailReporter", (Throwable) e11);
        }
    }

    private void c(b.a aVar) {
        if (!(aVar instanceof b.i)) {
            TPLogUtil.e("TPPrepareFailReporter", "onPrepareError fail:params is not match");
            return;
        }
        b.i iVar = (b.i) aVar;
        int d11 = iVar.d();
        int e11 = iVar.e();
        TPLogUtil.i("TPPrepareFailReporter", "onPrepareError errorType:" + d11 + " errorCode:" + e11);
        com.tencent.thumbplayer.tcmedia.tplayer.a.b.b bVar = new com.tencent.thumbplayer.tcmedia.tplayer.a.b.b();
        bVar.o(e11);
        c();
        b(this.f49517i);
        this.f49499f.b(this.f49517i.f49353a);
        bVar.a(this.f49517i.f49353a);
        Map<String, String> b11 = bVar.b();
        a("onPrepareError", b11);
        b("prepare_fail", b11);
        c("prepare_fail", b11);
    }

    private void d(b.a aVar) {
        if (!(aVar instanceof b.e)) {
            TPLogUtil.e("TPPrepareFailReporter", "onDTProcessUpdate fail:params is not match");
            return;
        }
        int d11 = ((b.e) aVar).d();
        TPLogUtil.i("TPPrepareFailReporter", "Vod onDTProcessUpdate speedKbps:".concat(String.valueOf(d11)));
        this.f49517i.f49354b = d11;
    }

    private void e(b.a aVar) {
        if (!(aVar instanceof b.d)) {
            TPLogUtil.e("TPPrepareFailReporter", "onDTCdnUrlUpdate fail:params is not match");
            return;
        }
        b.d dVar = (b.d) aVar;
        String d11 = dVar.d();
        String e11 = dVar.e();
        TPLogUtil.i("TPPrepareFailReporter", "Vod onDTCdnUrlUpdate cdnIp:" + d11 + " uIp:" + e11);
        b bVar = this.f49517i;
        bVar.f49355c = d11;
        bVar.f49356d = e11;
    }

    private void f(b.a aVar) {
        if (!(aVar instanceof b.f)) {
            TPLogUtil.e("TPPrepareFailReporter", "onDTProtocolUpdate fail:params is not match");
            return;
        }
        String d11 = ((b.f) aVar).d();
        TPLogUtil.i("TPPrepareFailReporter", "Vod onDTProtocolUpdate protocolVer:".concat(String.valueOf(d11)));
        this.f49517i.f49357e = d11;
    }

    public void a() {
        super.a();
    }

    public void a(int i11, b.a aVar) {
        if (i11 != 6) {
            switch (i11) {
                case 100:
                    d(aVar);
                    return;
                case 101:
                    e(aVar);
                    return;
                case 102:
                    f(aVar);
                    return;
                default:
                    return;
            }
        } else {
            c(aVar);
        }
    }

    public void a(Context context, l lVar) {
        super.a(context, lVar);
        this.f49499f.a(this.f49517i.f49353a);
    }
}
