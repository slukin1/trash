package com.tencent.thumbplayer.tcmedia.adapter.a.a;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.tcmedia.adapter.a.b;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.adapter.c;
import com.tencent.thumbplayer.tcmedia.adapter.g;
import com.tencent.thumbplayer.tcmedia.adapter.i;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureParams;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerState;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.tcmedia.b.e;
import com.tencent.thumbplayer.tcmedia.b.h;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.e.a f48731a;

    /* renamed from: b  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.e.b f48732b;

    /* renamed from: c  reason: collision with root package name */
    private Context f48733c;

    /* renamed from: d  reason: collision with root package name */
    private b f48734d;

    /* renamed from: e  reason: collision with root package name */
    private TPPlayerState f48735e;

    /* renamed from: f  reason: collision with root package name */
    private g f48736f;

    /* renamed from: g  reason: collision with root package name */
    private a f48737g;

    /* renamed from: h  reason: collision with root package name */
    private c f48738h;

    /* renamed from: i  reason: collision with root package name */
    private i f48739i;

    /* renamed from: j  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.adapter.b f48740j;

    /* renamed from: k  reason: collision with root package name */
    private List<ITPMediaTrackClip> f48741k;

    /* renamed from: l  reason: collision with root package name */
    private int f48742l = 0;

    /* renamed from: m  reason: collision with root package name */
    private boolean f48743m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f48744n;

    /* renamed from: o  reason: collision with root package name */
    private LinkedList<Long> f48745o;

    public class a implements c.a, c.b, c.C0614c, c.f, c.h, c.i, c.j, c.l, c.n, c.o, c.p {
        private a() {
        }

        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.a(tPPostProcessFrameBuffer);
        }

        public void a() {
            d.this.a();
        }

        public void a(int i11, int i12, long j11, long j12) {
            d.this.a(i11, i12, j11, j12);
        }

        public void a(int i11, long j11, long j12, Object obj) {
            d.this.a(i11, j11, j12, obj);
        }

        public void a(long j11, long j12) {
            d.this.a(j11, j12);
        }

        public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
            d.this.a(tPAudioFrameBuffer);
        }

        public void a(TPSubtitleData tPSubtitleData) {
            d.this.a(tPSubtitleData);
        }

        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            d.this.a(tPVideoFrameBuffer);
        }

        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.b(tPPostProcessFrameBuffer);
        }

        public void b() {
            d.this.b();
        }

        public void c() {
            d.this.d();
        }
    }

    public d(Context context, com.tencent.thumbplayer.tcmedia.e.b bVar) {
        com.tencent.thumbplayer.tcmedia.e.b bVar2 = new com.tencent.thumbplayer.tcmedia.e.b(bVar, "TPSystemClipPlayer");
        this.f48732b = bVar2;
        this.f48731a = new com.tencent.thumbplayer.tcmedia.e.a(bVar2);
        this.f48733c = context;
        this.f48735e = new TPPlayerState();
        this.f48738h = new com.tencent.thumbplayer.tcmedia.adapter.c();
        this.f48737g = new a();
        this.f48736f = new g(this.f48731a.b());
        this.f48739i = new i(this.f48735e);
        this.f48741k = new ArrayList();
    }

    /* access modifiers changed from: private */
    public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (!this.f48739i.b(7)) {
            return null;
        }
        return this.f48736f.a(tPPostProcessFrameBuffer);
    }

    /* access modifiers changed from: private */
    public void a() {
        g gVar = this.f48736f;
        if (gVar != null) {
            gVar.a(152, (long) this.f48742l, 0, (Object) null);
        }
        if (this.f48743m) {
            i();
            if (this.f48744n && this.f48736f != null && !com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f48745o)) {
                Long poll = this.f48745o.poll();
                if (poll != null) {
                    this.f48736f.a(3, poll.longValue(), 0, (Object) null);
                }
                this.f48744n = false;
            }
        } else if (this.f48739i.b(1)) {
            this.f48735e.changeState(4);
            g gVar2 = this.f48736f;
            if (gVar2 != null) {
                gVar2.a();
            }
            b(this.f48734d);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, long j11, long j12) {
        if (this.f48739i.b(4)) {
            this.f48736f.a(i11, i12, j11, j12);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, long j11, long j12, Object obj) {
        if (this.f48739i.b(3)) {
            this.f48736f.a(i11, j11, j12, obj);
        }
    }

    /* access modifiers changed from: private */
    public void a(long j11, long j12) {
        if (this.f48739i.b(6)) {
            this.f48740j.b(j12);
            this.f48740j.a(j11);
            this.f48736f.a(j11, j12);
        }
    }

    private void a(b bVar) {
        if (1 == this.f48738h.e().g()) {
            bVar.a(this.f48738h.e().c());
        } else if (4 == this.f48738h.e().g()) {
            bVar.a(this.f48738h.e().d());
        }
        if (this.f48738h.e().g() == 0) {
            bVar.a(this.f48738h.e().a(), this.f48738h.e().b());
        }
        for (TPOptionalParam a11 : this.f48738h.o()) {
            bVar.a(a11);
        }
        for (c.d next : this.f48738h.m()) {
            bVar.a(next.f48907a, next.f48910d, next.f48908b, next.f48909c);
        }
        for (c.a next2 : this.f48738h.n()) {
            bVar.a(next2.f48897a, next2.f48900d, next2.f48898b, next2.f48899c);
        }
        if (this.f48738h.k() != null) {
            bVar.a(this.f48738h.k().f48901a, this.f48738h.k().f48902b, this.f48738h.k().f48903c);
        }
        bVar.a(this.f48738h.g());
        if (this.f48738h.h() != 0.0f) {
            bVar.a(this.f48738h.h());
        }
        if (this.f48738h.j() != 0.0f) {
            bVar.b(this.f48738h.j());
        }
        if (this.f48738h.d() instanceof SurfaceHolder) {
            bVar.a((SurfaceHolder) this.f48738h.d());
        } else if (this.f48738h.d() instanceof Surface) {
            bVar.a((Surface) this.f48738h.d());
        }
        bVar.a((c.h) this.f48737g);
        bVar.a((c.i) this.f48737g);
        bVar.a((c.C0614c) this.f48737g);
        bVar.a((c.f) this.f48737g);
        bVar.a((c.j) this.f48737g);
        bVar.a((c.p) this.f48737g);
        bVar.a((c.l) this.f48737g);
    }

    /* access modifiers changed from: private */
    public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        if (this.f48739i.b(7)) {
            this.f48736f.a(tPAudioFrameBuffer);
        }
    }

    /* access modifiers changed from: private */
    public void a(TPSubtitleData tPSubtitleData) {
        if (this.f48739i.b(7)) {
            this.f48736f.a(tPSubtitleData);
        }
    }

    /* access modifiers changed from: private */
    public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        if (this.f48739i.b(7)) {
            this.f48736f.a(tPVideoFrameBuffer);
        }
    }

    /* access modifiers changed from: private */
    public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (!this.f48739i.b(7)) {
            return null;
        }
        return this.f48736f.b(tPPostProcessFrameBuffer);
    }

    private List<ITPMediaTrackClip> b(ITPMediaAsset iTPMediaAsset) {
        boolean z11 = iTPMediaAsset instanceof e;
        if (z11 || (iTPMediaAsset instanceof com.tencent.thumbplayer.tcmedia.b.g) || (iTPMediaAsset instanceof h)) {
            List<ITPMediaTrackClip> arrayList = new ArrayList<>();
            if (z11) {
                List<ITPMediaTrack> allAVTracks = ((e) iTPMediaAsset).getAllAVTracks();
                if (com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) allAVTracks) || allAVTracks.get(0) == null) {
                    throw new IllegalStateException("empty av tracks when set data source!");
                }
                arrayList = allAVTracks.get(0).getAllTrackClips();
            } else if (iTPMediaAsset instanceof com.tencent.thumbplayer.tcmedia.b.g) {
                arrayList = ((com.tencent.thumbplayer.tcmedia.b.g) iTPMediaAsset).getAllTrackClips();
            } else {
                arrayList.add((ITPMediaTrackClip) iTPMediaAsset);
            }
            long j11 = 0;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                arrayList.get(i11).setStartPositionMs(j11);
                j11 += arrayList.get(i11).getOriginalDurationMs();
            }
            return arrayList;
        }
        throw new IllegalStateException("system mediaPlayer : media asset is illegal source!");
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f48739i.b(2)) {
            if (this.f48742l >= this.f48741k.size() - 1) {
                this.f48735e.changeState(7);
                this.f48736f.b();
                return;
            }
            try {
                d(this.f48742l + 1, 0);
            } catch (IOException e11) {
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
                aVar.c("handleOnComplete:" + e11.toString());
            }
        }
    }

    private void b(b bVar) {
        TPTrackInfo[] s11 = s();
        if (s11 != null) {
            for (int i11 = 0; i11 < s11.length; i11++) {
                if (s11[i11].equals(this.f48738h.a(s11[i11].getTrackType()))) {
                    bVar.a(i11, -1);
                }
            }
        }
    }

    private ITPMediaTrackClip c() {
        return this.f48741k.get(this.f48742l);
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f48739i.b(5)) {
            if (this.f48735e.is(7)) {
                i();
            }
            this.f48736f.c();
        }
    }

    private void d(int i11) {
        for (int i12 = 0; i12 < this.f48741k.size(); i12++) {
            long j11 = (long) i11;
            if (this.f48741k.get(i12).getStartPositionMs() <= j11 && j11 <= this.f48741k.get(i12).getStartPositionMs() + this.f48741k.get(i12).getOriginalDurationMs()) {
                try {
                    d(i12, j11 - this.f48741k.get(i12).getStartPositionMs());
                } catch (IOException e11) {
                    com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
                    aVar.c("selectClipPlayer:" + e11.toString());
                }
            }
        }
    }

    private void d(int i11, long j11) {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
        aVar.b("switchPlayer: clipNo:" + i11 + "   startPostion:" + j11);
        b bVar = this.f48734d;
        if (bVar != null) {
            bVar.m();
        }
        this.f48743m = true;
        this.f48742l = i11;
        this.f48738h.a(this.f48741k.get(i11).getFilePath(), this.f48741k.get(this.f48742l).getHttpHeader());
        b e11 = e();
        this.f48734d = e11;
        if (e11 != null) {
            this.f48734d.a(new TPOptionalParam().buildLong(100, j11));
            this.f48734d.g();
            return;
        }
        throw new RuntimeException("error , create player failed");
    }

    private b e() {
        e eVar = new e(this.f48733c, this.f48732b);
        if (this.f48740j == null) {
            this.f48740j = new com.tencent.thumbplayer.tcmedia.adapter.b();
        }
        a((b) eVar);
        return eVar;
    }

    public void a(float f11) {
        if (this.f48739i.a(3)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.a(f11);
            }
            this.f48738h.a(f11);
        }
    }

    public void a(int i11) {
        if (this.f48739i.a(9)) {
            long j11 = (long) i11;
            if (j11 < c().getStartPositionMs() || j11 > c().getStartPositionMs() + c().getOriginalDurationMs()) {
                d(i11);
            } else if (this.f48734d != null) {
                this.f48731a.b("seek to:".concat(String.valueOf(i11)));
                this.f48734d.a((int) (j11 - c().getStartPositionMs()));
            }
        }
    }

    public void a(int i11, @TPCommonEnum.TPSeekMode int i12) {
        if (this.f48739i.a(9)) {
            long j11 = (long) i11;
            if (j11 < c().getStartPositionMs() || j11 > c().getStartPositionMs() + c().getOriginalDurationMs()) {
                d(i11);
            } else if (this.f48734d != null) {
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
                aVar.b("seek to:" + i11 + "/mode=" + i12);
                this.f48734d.a((int) (j11 - c().getStartPositionMs()), i12);
            }
        }
    }

    public void a(int i11, long j11) {
        this.f48731a.e("selectTrack not supported.");
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        this.f48738h.a(assetFileDescriptor);
        this.f48735e.changeState(2);
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        this.f48738h.a(parcelFileDescriptor);
        this.f48735e.changeState(2);
    }

    public void a(Surface surface) {
        if (this.f48739i.a(4)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.a(surface);
            }
            this.f48738h.a(surface);
            return;
        }
        throw new IllegalStateException("setSurface , state invalid");
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (this.f48739i.a(4)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.a(surfaceHolder);
            }
            this.f48738h.a(surfaceHolder);
            return;
        }
        throw new IllegalStateException("setSurfaceHolder , state invalid");
    }

    public void a(c.a aVar) {
        throw new IllegalStateException("system Mediaplayer cannot support audio frame out");
    }

    public void a(c.b bVar) {
        throw new IllegalStateException("system Mediaplayer cannot support audio postprocess frame out");
    }

    public void a(c.C0614c cVar) {
        this.f48736f.a(cVar);
    }

    public void a(c.d dVar) {
    }

    public void a(c.e eVar) {
    }

    public void a(c.f fVar) {
        this.f48736f.a(fVar);
    }

    public void a(c.g gVar) {
    }

    public void a(c.h hVar) {
        this.f48736f.a(hVar);
    }

    public void a(c.i iVar) {
        this.f48736f.a(iVar);
    }

    public void a(c.j jVar) {
        this.f48736f.a(jVar);
    }

    public void a(c.l lVar) {
        this.f48736f.a(lVar);
    }

    public void a(c.m mVar) {
    }

    public void a(c.n nVar) {
        throw new IllegalStateException("system Mediaplayer cannot support video frame out");
    }

    public void a(c.o oVar) {
        throw new IllegalStateException("system Mediaplayer cannot support video postprocess frame out");
    }

    public void a(c.p pVar) {
        this.f48736f.a(pVar);
    }

    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        b bVar = this.f48734d;
        if (bVar != null) {
            bVar.a(tPCaptureParams, tPCaptureCallBack);
        }
    }

    public void a(TPOptionalParam tPOptionalParam) {
        if (tPOptionalParam.getKey() == 100) {
            int i11 = (int) tPOptionalParam.getParamLong().value;
            this.f48731a.b("start position:".concat(String.valueOf(i11)));
            for (int i12 = 0; i12 < this.f48741k.size(); i12++) {
                long j11 = (long) i11;
                if (this.f48741k.get(i12).getStartPositionMs() <= j11 && j11 <= this.f48741k.get(i12).getStartPositionMs() + this.f48741k.get(i12).getOriginalDurationMs()) {
                    this.f48742l = i12;
                    this.f48738h.b(this.f48741k.get(i12).getFilePath());
                    tPOptionalParam.getParamLong().value = j11 - this.f48741k.get(i12).getStartPositionMs();
                }
            }
        }
        b bVar = this.f48734d;
        if (bVar != null) {
            bVar.a(tPOptionalParam);
        }
        this.f48738h.a(tPOptionalParam);
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        List<ITPMediaTrackClip> b11 = b(iTPMediaAsset);
        try {
            this.f48741k = b11;
            this.f48738h.a(b11.get(this.f48742l).getFilePath(), this.f48741k.get(this.f48742l).getHttpHeader());
            this.f48735e.changeState(2);
        } catch (Exception e11) {
            this.f48731a.a(e11);
            throw new IllegalStateException("exception when system clip player set data source!");
        }
    }

    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        List<ITPMediaTrackClip> b11 = b(iTPMediaAsset);
        if (!com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) b11)) {
            long o11 = o();
            try {
                this.f48741k = b11;
                this.f48744n = true;
                if (com.tencent.thumbplayer.tcmedia.utils.b.a((Collection<? extends Object>) this.f48745o)) {
                    this.f48745o = new LinkedList<>();
                }
                this.f48745o.offer(Long.valueOf(j11));
                com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
                aVar.c("try to switch definition with system clip player, current clipNo:" + this.f48742l);
                d((int) o11);
            } catch (Exception e11) {
                this.f48731a.a(e11);
                throw new IllegalStateException("exception when system clip player switch definition!");
            }
        } else {
            throw new IllegalStateException("exception when switch Definition with clip mediaAsset empty source!");
        }
    }

    public void a(com.tencent.thumbplayer.tcmedia.e.b bVar) {
        this.f48731a.a(new com.tencent.thumbplayer.tcmedia.e.b(bVar, "TPSystemClipPlayer"));
        g gVar = this.f48736f;
        if (gVar != null && bVar != null) {
            gVar.a(this.f48731a.a().a());
        }
    }

    public void a(String str) {
    }

    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
    }

    public void a(String str, Map<String, String> map) {
        this.f48738h.a(str, map);
        this.f48735e.changeState(2);
    }

    public void a(String str, Map<String, String> map, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
    }

    public void a(String str, Map<String, String> map, String str2, String str3) {
        this.f48731a.e("addSubtitleSource not supported.");
    }

    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        this.f48731a.e("addAudioTrackSource not supported.");
    }

    public void a(boolean z11) {
        if (this.f48739i.a(3)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.a(z11);
            }
            this.f48738h.a(z11);
        }
    }

    public void a(boolean z11, long j11, long j12) {
        if (this.f48739i.a(3)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.a(z11, j11, j12);
            }
            this.f48738h.a(z11, j11, j12);
        }
    }

    public long b(int i11) {
        b bVar = this.f48734d;
        if (bVar != null) {
            return bVar.b(i11);
        }
        return -1;
    }

    public void b(float f11) {
        if (this.f48739i.a(3)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.b(f11);
            }
            this.f48738h.b(f11);
        }
    }

    public void b(int i11, long j11) {
        this.f48731a.e("deselectTrack not supported.");
    }

    public void b(boolean z11) {
        if (this.f48739i.a(3)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                bVar.b(z11);
            }
            this.f48738h.b(z11);
        }
    }

    public TPDynamicStatisticParams c(boolean z11) {
        return null;
    }

    public String c(int i11) {
        b bVar = this.f48734d;
        return bVar != null ? bVar.c(i11) : "";
    }

    public void c(int i11, long j11) {
        this.f48731a.e("selectProgram not supported.");
    }

    public void g() {
        if (this.f48739i.a(1)) {
            if (this.f48738h.f()) {
                b e11 = e();
                this.f48734d = e11;
                if (e11 != null) {
                    this.f48735e.changeState(3);
                    this.f48734d.g();
                    return;
                }
                throw new RuntimeException("error , create player failed");
            }
            throw new IOException("error , prepare , data source invalid");
        }
    }

    public void h() {
        if (this.f48739i.a(1)) {
            if (this.f48738h.f()) {
                b e11 = e();
                this.f48734d = e11;
                if (e11 != null) {
                    this.f48735e.changeState(3);
                    this.f48734d.h();
                    return;
                }
                throw new RuntimeException("error , create player failed");
            }
            throw new IllegalStateException("error , prepare , state invalid , data source invalid");
        }
    }

    public void i() {
        if (this.f48739i.a(5)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                try {
                    bVar.i();
                    this.f48735e.changeState(5);
                } catch (IllegalStateException unused) {
                    throw new IllegalStateException("error , start ,state invalid");
                }
            } else {
                throw new IllegalStateException("error , start , player is null");
            }
        }
    }

    public void j() {
        if (this.f48739i.a(6)) {
            b bVar = this.f48734d;
            if (bVar != null) {
                try {
                    bVar.j();
                    this.f48735e.changeState(6);
                } catch (IllegalStateException unused) {
                    throw new IllegalStateException("error , pause ,state invalid");
                }
            } else {
                throw new IllegalStateException("error , pause , player is null");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        throw new java.lang.IllegalStateException("error , pause ,state invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r3.f48735e.changeState(9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r3 = this;
            com.tencent.thumbplayer.tcmedia.adapter.i r0 = r3.f48739i
            r1 = 7
            boolean r0 = r0.a((int) r1)
            if (r0 != 0) goto L_0x000a
            return
        L_0x000a:
            com.tencent.thumbplayer.tcmedia.adapter.a.b r0 = r3.f48734d
            if (r0 == 0) goto L_0x0032
            r0 = 9
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r1 = r3.f48735e     // Catch:{ IllegalStateException -> 0x0024 }
            r2 = 8
            r1.changeState(r2)     // Catch:{ IllegalStateException -> 0x0024 }
            com.tencent.thumbplayer.tcmedia.adapter.a.b r1 = r3.f48734d     // Catch:{ IllegalStateException -> 0x0024 }
            r1.k()     // Catch:{ IllegalStateException -> 0x0024 }
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r1 = r3.f48735e
            r1.changeState(r0)
            return
        L_0x0022:
            r1 = move-exception
            goto L_0x002c
        L_0x0024:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = "error , pause ,state invalid"
            r1.<init>(r2)     // Catch:{ all -> 0x0022 }
            throw r1     // Catch:{ all -> 0x0022 }
        L_0x002c:
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r2 = r3.f48735e
            r2.changeState(r0)
            throw r1
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "error , stop , player is null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.a.a.d.k():void");
    }

    public void l() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
        aVar.c("reset, current state:" + this.f48735e);
        b bVar = this.f48734d;
        if (bVar != null) {
            bVar.l();
        }
        this.f48738h.a();
        this.f48736f.e();
        this.f48735e.changeState(1);
    }

    public void m() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48731a;
        aVar.c("release, current state:" + this.f48735e);
        b bVar = this.f48734d;
        if (bVar != null) {
            bVar.m();
            this.f48734d = null;
        }
        this.f48738h.a();
        this.f48736f.e();
        this.f48735e.changeState(11);
    }

    public long n() {
        long j11 = 0;
        for (ITPMediaTrackClip originalDurationMs : this.f48741k) {
            j11 += originalDurationMs.getOriginalDurationMs();
        }
        return j11;
    }

    public long o() {
        long j11 = 0;
        int i11 = 0;
        while (i11 < this.f48741k.size() && i11 < this.f48742l) {
            j11 += this.f48741k.get(i11).getOriginalDurationMs();
            i11++;
        }
        return !this.f48739i.a(12) ? j11 : j11 + this.f48734d.o();
    }

    public long p() {
        if (this.f48739i.a(15)) {
            return this.f48734d.p();
        }
        com.tencent.thumbplayer.tcmedia.adapter.b bVar = this.f48740j;
        if (bVar != null) {
            return bVar.l();
        }
        return 0;
    }

    public int q() {
        com.tencent.thumbplayer.tcmedia.adapter.b bVar = this.f48740j;
        if (bVar == null) {
            return 0;
        }
        if (bVar.a() <= 0) {
            if (!this.f48739i.a(13)) {
                return 0;
            }
            this.f48740j.a((long) this.f48734d.q());
        }
        return (int) this.f48740j.a();
    }

    public int r() {
        com.tencent.thumbplayer.tcmedia.adapter.b bVar = this.f48740j;
        if (bVar == null) {
            return 0;
        }
        if (bVar.b() <= 0) {
            if (!this.f48739i.a(13)) {
                return 0;
            }
            this.f48740j.b((long) this.f48734d.r());
        }
        return (int) this.f48740j.b();
    }

    public TPTrackInfo[] s() {
        this.f48731a.e("getTrackInfo not supported.");
        return new TPTrackInfo[0];
    }

    public TPProgramInfo[] t() {
        this.f48731a.e("getProgramInfo not supported.");
        return new TPProgramInfo[0];
    }

    public long u() {
        return -1;
    }

    public TPGeneralPlayFlowParams v() {
        return null;
    }
}
