package com.tencent.thumbplayer.tcmedia.adapter;

import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPDrmInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class g implements c.a, c.b, c.C0614c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p {

    /* renamed from: a  reason: collision with root package name */
    private c.i f48935a;

    /* renamed from: b  reason: collision with root package name */
    private c.C0614c f48936b;

    /* renamed from: c  reason: collision with root package name */
    private c.h f48937c;

    /* renamed from: d  reason: collision with root package name */
    private c.f f48938d;

    /* renamed from: e  reason: collision with root package name */
    private c.j f48939e;

    /* renamed from: f  reason: collision with root package name */
    private c.p f48940f;

    /* renamed from: g  reason: collision with root package name */
    private c.l f48941g;

    /* renamed from: h  reason: collision with root package name */
    private c.n f48942h;

    /* renamed from: i  reason: collision with root package name */
    private c.a f48943i;

    /* renamed from: j  reason: collision with root package name */
    private c.m f48944j;

    /* renamed from: k  reason: collision with root package name */
    private c.o f48945k;

    /* renamed from: l  reason: collision with root package name */
    private c.b f48946l;

    /* renamed from: m  reason: collision with root package name */
    private c.k f48947m;

    /* renamed from: n  reason: collision with root package name */
    private c.e f48948n;

    /* renamed from: o  reason: collision with root package name */
    private c.g f48949o;

    /* renamed from: p  reason: collision with root package name */
    private c.d f48950p;

    /* renamed from: q  reason: collision with root package name */
    private a f48951q;

    /* renamed from: r  reason: collision with root package name */
    private String f48952r = "TPPlayerListenerS";

    public static class a implements c.a, c.b, c.C0614c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f48953a;

        public a(String str) {
            this.f48953a = str;
        }

        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onVideoProcessFrameOut");
            return null;
        }

        public TPRemoteSdpInfo a(String str, int i11) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onSdpExchange");
            return null;
        }

        public void a() {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onPrepared");
        }

        public void a(int i11, int i12, long j11, long j12) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onError");
        }

        public void a(int i11, long j11, long j12, Object obj) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onInfo");
        }

        public void a(long j11, long j12) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onVideoSizeChanged");
        }

        public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onAudioFrameOut");
        }

        public void a(TPDrmInfo tPDrmInfo) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onEventRecord");
        }

        public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onDetailInfo");
        }

        public void a(TPSubtitleData tPSubtitleData) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onSubtitleData");
        }

        public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , TPSubtitleFrameBuffer");
        }

        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onVideoFrameOut");
        }

        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onAudioProcessFrameOut");
            return null;
        }

        public void b() {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onCompletion");
        }

        public void b(int i11, int i12) {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onStateChange");
        }

        public void c() {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onSeekComplete");
        }

        public void d() {
            TPLogUtil.i(this.f48953a, " empty base listener , notify , onDurationUpdate");
        }
    }

    public g(String str) {
        a(str);
        a aVar = new a(this.f48952r);
        this.f48951q = aVar;
        this.f48935a = aVar;
        this.f48936b = aVar;
        this.f48937c = aVar;
        this.f48938d = aVar;
        this.f48939e = aVar;
        this.f48940f = aVar;
        this.f48941g = aVar;
        this.f48942h = aVar;
        this.f48943i = aVar;
        this.f48944j = aVar;
        this.f48945k = aVar;
        this.f48946l = aVar;
        this.f48947m = aVar;
        this.f48948n = aVar;
        this.f48949o = aVar;
        this.f48950p = aVar;
    }

    public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.f48945k.a(tPPostProcessFrameBuffer);
    }

    public TPRemoteSdpInfo a(String str, int i11) {
        return this.f48950p.a(str, i11);
    }

    public void a() {
        this.f48935a.a();
    }

    public void a(@TPCommonEnum.TPErrorType int i11, int i12, long j11, long j12) {
        this.f48938d.a(i11, i12, j11, j12);
    }

    public void a(int i11, long j11, long j12, Object obj) {
        this.f48937c.a(i11, j11, j12, obj);
    }

    public void a(long j11, long j12) {
        this.f48940f.a(j11, j12);
    }

    public void a(c.a aVar) {
        if (aVar == null) {
            aVar = this.f48951q;
        }
        this.f48943i = aVar;
    }

    public void a(c.b bVar) {
        if (bVar == null) {
            bVar = this.f48951q;
        }
        this.f48946l = bVar;
    }

    public void a(c.C0614c cVar) {
        if (cVar == null) {
            cVar = this.f48951q;
        }
        this.f48936b = cVar;
    }

    public void a(c.d dVar) {
        if (dVar == null) {
            dVar = this.f48951q;
        }
        this.f48950p = dVar;
    }

    public void a(c.e eVar) {
        if (eVar == null) {
            eVar = this.f48951q;
        }
        this.f48948n = eVar;
    }

    public void a(c.f fVar) {
        if (fVar == null) {
            fVar = this.f48951q;
        }
        this.f48938d = fVar;
    }

    public void a(c.g gVar) {
        if (gVar == null) {
            gVar = this.f48951q;
        }
        this.f48949o = gVar;
    }

    public void a(c.h hVar) {
        if (hVar == null) {
            hVar = this.f48951q;
        }
        this.f48937c = hVar;
    }

    public void a(c.i iVar) {
        if (iVar == null) {
            iVar = this.f48951q;
        }
        this.f48935a = iVar;
    }

    public void a(c.j jVar) {
        if (jVar == null) {
            jVar = this.f48951q;
        }
        this.f48939e = jVar;
    }

    public void a(c.k kVar) {
        if (kVar == null) {
            kVar = this.f48951q;
        }
        this.f48947m = kVar;
    }

    public void a(c.l lVar) {
        if (lVar == null) {
            lVar = this.f48951q;
        }
        this.f48941g = lVar;
    }

    public void a(c.m mVar) {
        if (mVar == null) {
            mVar = this.f48951q;
        }
        this.f48944j = mVar;
    }

    public void a(c.n nVar) {
        if (nVar == null) {
            nVar = this.f48951q;
        }
        this.f48942h = nVar;
    }

    public void a(c.o oVar) {
        if (oVar == null) {
            oVar = this.f48951q;
        }
        this.f48945k = oVar;
    }

    public void a(c.p pVar) {
        if (pVar == null) {
            pVar = this.f48951q;
        }
        this.f48940f = pVar;
    }

    public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        this.f48943i.a(tPAudioFrameBuffer);
    }

    public void a(TPDrmInfo tPDrmInfo) {
        this.f48949o.a(tPDrmInfo);
    }

    public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
        this.f48948n.a(tPPlayerDetailInfo);
    }

    public void a(TPSubtitleData tPSubtitleData) {
        this.f48941g.a(tPSubtitleData);
    }

    public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        this.f48944j.a(tPSubtitleFrameBuffer);
    }

    public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        this.f48942h.a(tPVideoFrameBuffer);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "TPPlayerListenerS";
        }
        this.f48952r = str;
        a aVar = this.f48951q;
        if (aVar != null) {
            String unused = aVar.f48953a = this.f48952r;
        }
    }

    public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        return this.f48946l.b(tPPostProcessFrameBuffer);
    }

    public void b() {
        this.f48936b.b();
    }

    public void b(int i11, int i12) {
        this.f48947m.b(i11, i12);
    }

    public void c() {
        this.f48939e.c();
    }

    public void d() {
        this.f48950p.d();
    }

    public void e() {
        a aVar = this.f48951q;
        this.f48935a = aVar;
        this.f48936b = aVar;
        this.f48937c = aVar;
        this.f48938d = aVar;
        this.f48939e = aVar;
        this.f48940f = aVar;
        this.f48941g = aVar;
        this.f48942h = aVar;
        this.f48943i = aVar;
        this.f48944j = aVar;
        this.f48947m = aVar;
        this.f48945k = aVar;
        this.f48946l = aVar;
        this.f48948n = aVar;
        this.f48949o = aVar;
        this.f48950p = aVar;
    }
}
