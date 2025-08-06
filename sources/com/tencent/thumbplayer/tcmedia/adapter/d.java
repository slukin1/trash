package com.tencent.thumbplayer.tcmedia.adapter;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.thumbplayer.tcmedia.adapter.a.c;
import com.tencent.thumbplayer.tcmedia.adapter.c;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.e;
import com.tencent.thumbplayer.tcmedia.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureCallBack;
import com.tencent.thumbplayer.tcmedia.api.TPCaptureParams;
import com.tencent.thumbplayer.tcmedia.api.TPCommonEnum;
import com.tencent.thumbplayer.tcmedia.api.TPDrmInfo;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalParam;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.tcmedia.api.TPPlayerState;
import com.tencent.thumbplayer.tcmedia.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPProgramInfo;
import com.tencent.thumbplayer.tcmedia.api.TPRemoteSdpInfo;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleData;
import com.tencent.thumbplayer.tcmedia.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPTrackInfo;
import com.tencent.thumbplayer.tcmedia.api.TPVideoFrameBuffer;
import com.tencent.thumbplayer.tcmedia.api.TPVideoInfo;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.tcmedia.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.tcmedia.core.player.TPDynamicStatisticParams;
import com.tencent.thumbplayer.tcmedia.core.player.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.tcmedia.e.b;
import com.tencent.thumbplayer.tcmedia.f.a;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class d implements a, c.k {

    /* renamed from: a  reason: collision with root package name */
    private b f48911a;

    /* renamed from: b  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.e.a f48912b;

    /* renamed from: c  reason: collision with root package name */
    private Context f48913c;

    /* renamed from: d  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.adapter.a.b f48914d;

    /* renamed from: e  reason: collision with root package name */
    private TPPlayerState f48915e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f48916f;

    /* renamed from: g  reason: collision with root package name */
    private int f48917g = 0;

    /* renamed from: h  reason: collision with root package name */
    private g f48918h;

    /* renamed from: i  reason: collision with root package name */
    private a f48919i;

    /* renamed from: j  reason: collision with root package name */
    private c f48920j;

    /* renamed from: k  reason: collision with root package name */
    private i f48921k;

    /* renamed from: l  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.adapter.strategy.a f48922l;

    /* renamed from: m  reason: collision with root package name */
    private b f48923m;

    /* renamed from: n  reason: collision with root package name */
    private int f48924n;

    /* renamed from: o  reason: collision with root package name */
    private com.tencent.thumbplayer.tcmedia.f.a f48925o;

    public class a implements c.a, c.b, c.C0614c, c.d, c.e, c.f, c.g, c.h, c.i, c.j, c.l, c.m, c.n, c.o, c.p {
        private a() {
        }

        public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.a(tPPostProcessFrameBuffer);
        }

        public TPRemoteSdpInfo a(String str, int i11) {
            return d.this.a(str, i11);
        }

        public void a() {
            d.this.w();
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

        public void a(TPDrmInfo tPDrmInfo) {
            d.this.a(tPDrmInfo);
        }

        public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
            d.this.a(tPPlayerDetailInfo);
        }

        public void a(TPSubtitleData tPSubtitleData) {
            d.this.a(tPSubtitleData);
        }

        public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
            d.this.a(tPSubtitleFrameBuffer);
        }

        public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
            d.this.a(tPVideoFrameBuffer);
        }

        public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
            return d.this.b(tPPostProcessFrameBuffer);
        }

        public void b() {
            d.this.y();
        }

        public void c() {
            d.this.z();
        }

        public void d() {
            d.this.A();
        }
    }

    public d(Context context, b bVar) {
        b bVar2 = new b(bVar, "TPPlayerAdapter");
        this.f48911a = bVar2;
        this.f48912b = new com.tencent.thumbplayer.tcmedia.e.a(bVar2);
        this.f48913c = context;
        TPPlayerState tPPlayerState = new TPPlayerState();
        this.f48915e = tPPlayerState;
        tPPlayerState.setOnPlayerStateChangeListener(this);
        this.f48920j = new c();
        this.f48919i = new a();
        this.f48918h = new g(this.f48911a.a());
        this.f48921k = new i(this.f48915e);
        this.f48923m = new b();
    }

    /* access modifiers changed from: private */
    public void A() {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar;
        if (this.f48921k.a(11) && (bVar = this.f48914d) != null) {
            long n11 = bVar.n();
            b bVar2 = this.f48923m;
            if (bVar2 != null) {
                bVar2.h(n11);
            }
        }
    }

    private int B() {
        if (this.f48922l == null) {
            this.f48922l = a(this.f48920j);
        }
        return this.f48922l.a(this.f48923m);
    }

    private boolean C() {
        int i11 = this.f48924n;
        return i11 == 2 || i11 == 3;
    }

    private com.tencent.thumbplayer.tcmedia.adapter.a.b a(int i11, b bVar) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2;
        Context context;
        if (i11 == 1) {
            try {
                this.f48912b.c("to create androidPlayer");
                bVar2 = com.tencent.thumbplayer.tcmedia.adapter.a.d.a(this.f48913c, this.f48920j.p(), bVar);
            } catch (Exception e11) {
                this.f48912b.c("to create Player," + e11.toString());
            }
        } else {
            if (i11 == 2) {
                this.f48912b.c("to create thumbPlayer");
                context = this.f48913c;
            } else if (i11 == 3) {
                this.f48912b.c("to create thumbPlayer software dec");
                context = this.f48913c;
            } else {
                this.f48912b.c("to create no Player");
                bVar2 = null;
            }
            bVar2 = com.tencent.thumbplayer.tcmedia.adapter.a.d.a(context, bVar);
        }
        if (bVar2 == null) {
            this.f48912b.c("play is null!");
            return null;
        }
        this.f48924n = i11;
        b(bVar2);
        return bVar2;
    }

    private com.tencent.thumbplayer.tcmedia.adapter.strategy.a a(c cVar) {
        com.tencent.thumbplayer.tcmedia.adapter.strategy.a.a aVar;
        try {
            aVar = new com.tencent.thumbplayer.tcmedia.adapter.strategy.a.a(cVar);
        } catch (IllegalArgumentException unused) {
            aVar = new com.tencent.thumbplayer.tcmedia.adapter.strategy.a.a((c) null);
        }
        return e.a(aVar);
    }

    /* access modifiers changed from: private */
    public TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (!this.f48921k.b(7)) {
            return null;
        }
        return this.f48918h.a(tPPostProcessFrameBuffer);
    }

    /* access modifiers changed from: private */
    public TPRemoteSdpInfo a(String str, int i11) {
        return this.f48918h.a(str, i11);
    }

    /* access modifiers changed from: private */
    public void a(int i11, int i12, long j11, long j12) {
        if (this.f48921k.b(4)) {
            com.tencent.thumbplayer.tcmedia.adapter.strategy.a aVar = this.f48922l;
            b bVar = this.f48923m;
            int a11 = aVar.a(bVar, new com.tencent.thumbplayer.tcmedia.adapter.strategy.a.b(this.f48924n, i11, i12, bVar.d()));
            if (a11 != 0) {
                try {
                    c(a11, 1);
                    return;
                } catch (IOException | IllegalStateException e11) {
                    this.f48912b.a(e11);
                }
            }
            this.f48915e.changeState(10);
            this.f48918h.a(i11, i12, j11, j12);
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, long j11, long j12, Object obj) {
        b bVar;
        if (this.f48916f) {
            this.f48912b.c("handleOnInfo, mIsReopening");
            return;
        }
        if (i11 == 152 && (bVar = this.f48923m) != null) {
            bVar.f(((int) j11) + 1);
        }
        this.f48918h.a(i11, j11, j12, obj);
    }

    /* access modifiers changed from: private */
    public void a(long j11, long j12) {
        if (!this.f48921k.b(6)) {
            this.f48912b.c("handleOnVideoSizeChange, invalid state");
            return;
        }
        this.f48923m.b(j12);
        this.f48923m.a(j11);
        this.f48918h.a(j11, j12);
    }

    private void a(com.tencent.thumbplayer.tcmedia.adapter.a.b bVar) {
        TPProgramInfo l11;
        TPProgramInfo[] t11 = t();
        if (t11 != null && (l11 = this.f48920j.l()) != null) {
            int i11 = 0;
            while (i11 < t11.length) {
                if (TextUtils.isEmpty(l11.url) || t11[i11] == null || !l11.url.equals(t11[i11].url)) {
                    i11++;
                } else {
                    bVar.c(i11, -1);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(TPAudioFrameBuffer tPAudioFrameBuffer) {
        if (this.f48921k.b(7)) {
            this.f48918h.a(tPAudioFrameBuffer);
        }
    }

    /* access modifiers changed from: private */
    public void a(TPDrmInfo tPDrmInfo) {
        this.f48918h.a(tPDrmInfo);
    }

    /* access modifiers changed from: private */
    public void a(TPPlayerDetailInfo tPPlayerDetailInfo) {
        this.f48918h.a(tPPlayerDetailInfo);
    }

    /* access modifiers changed from: private */
    public void a(TPSubtitleData tPSubtitleData) {
        if (!this.f48921k.b(7)) {
            this.f48912b.c("handleOnSubtitleData, invalid state");
        } else {
            this.f48918h.a(tPSubtitleData);
        }
    }

    /* access modifiers changed from: private */
    public void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer) {
        if (!this.f48921k.b(7)) {
            this.f48912b.c("handleOnSubtitleFrameOut, invalid state");
        } else {
            this.f48918h.a(tPSubtitleFrameBuffer);
        }
    }

    /* access modifiers changed from: private */
    public void a(TPVideoFrameBuffer tPVideoFrameBuffer) {
        if (!this.f48921k.b(7)) {
            this.f48912b.c("handleOnVideoFrameOut, invalid state");
        } else {
            this.f48918h.a(tPVideoFrameBuffer);
        }
    }

    /* access modifiers changed from: private */
    public TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer) {
        if (!this.f48921k.b(7)) {
            return null;
        }
        return this.f48918h.b(tPPostProcessFrameBuffer);
    }

    private void b(com.tencent.thumbplayer.tcmedia.adapter.a.b bVar) {
        String a11;
        bVar.a((c.h) this.f48919i);
        bVar.a((c.i) this.f48919i);
        bVar.a((c.C0614c) this.f48919i);
        bVar.a((c.f) this.f48919i);
        bVar.a((c.j) this.f48919i);
        bVar.a((c.p) this.f48919i);
        bVar.a((c.l) this.f48919i);
        bVar.a((c.m) this.f48919i);
        bVar.a((c.e) this.f48919i);
        bVar.a((c.g) this.f48919i);
        bVar.a((c.d) this.f48919i);
        if (C()) {
            bVar.a((c.n) this.f48919i);
            bVar.a((c.a) this.f48919i);
            bVar.a((c.o) this.f48919i);
            bVar.a((c.b) this.f48919i);
        }
        if (1 == this.f48920j.e().g()) {
            bVar.a(this.f48920j.e().c());
        } else if (4 == this.f48920j.e().g()) {
            bVar.a(this.f48920j.e().d());
        } else if (3 == this.f48920j.e().g()) {
            int i11 = this.f48924n;
            if (i11 == 2) {
                a11 = this.f48920j.e().f().b();
            } else if (i11 == 1) {
                a11 = this.f48920j.e().f().a();
            }
            bVar.a(a11, this.f48920j.e().b());
        } else if (2 == this.f48920j.e().g()) {
            bVar.a(this.f48920j.e().e());
        }
        for (TPOptionalParam a12 : this.f48920j.o()) {
            bVar.a(a12);
        }
        for (int i12 = 0; i12 < this.f48920j.b().size(); i12++) {
            TPTrackInfo tPTrackInfo = this.f48920j.b().get(i12);
            int i13 = tPTrackInfo.trackType;
            if (i13 == 3) {
                Iterator<c.d> it2 = this.f48920j.m().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    c.d next = it2.next();
                    if (!TextUtils.isEmpty(next.f48909c) && next.f48909c.equals(tPTrackInfo.name)) {
                        bVar.a(next.f48907a, next.f48910d, next.f48908b, next.f48909c);
                        break;
                    }
                }
            } else if (i13 == 2) {
                Iterator<c.a> it3 = this.f48920j.n().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    c.a next2 = it3.next();
                    if (!TextUtils.isEmpty(next2.f48898b) && next2.f48898b.equals(tPTrackInfo.name)) {
                        bVar.a(next2.f48897a, next2.f48900d, next2.f48898b, next2.f48899c);
                        break;
                    }
                }
            }
        }
        Iterator<c.C0615c> it4 = this.f48920j.c().iterator();
        while (it4.hasNext()) {
            c.C0615c next3 = it4.next();
            if (next3.f48906c.isSelected) {
                TPTrackInfo[] s11 = bVar.s();
                if (s11 == null) {
                    this.f48912b.e("playerTrackInfoList is null.");
                } else {
                    for (int i14 = 0; i14 < s11.length; i14++) {
                        if (next3.f48906c.name.equals(s11[i14].name)) {
                            bVar.a(i14, next3.f48905b);
                        }
                    }
                }
            }
        }
        if (this.f48920j.k() != null) {
            bVar.a(this.f48920j.k().f48901a, this.f48920j.k().f48902b, this.f48920j.k().f48903c);
        }
        bVar.a(this.f48920j.g());
        if (this.f48920j.h() != 0.0f) {
            bVar.a(this.f48920j.h());
        }
        if (this.f48920j.j() != 0.0f) {
            bVar.b(this.f48920j.j());
        }
        if (!"".equals(this.f48920j.i())) {
            bVar.a(this.f48920j.i());
        }
        if (this.f48920j.d() instanceof SurfaceHolder) {
            bVar.a((SurfaceHolder) this.f48920j.d());
        } else if (this.f48920j.d() instanceof Surface) {
            bVar.a((Surface) this.f48920j.d());
        }
        bVar.a(new TPOptionalParam().buildQueueInt(204, this.f48922l.a()));
    }

    private void c(int i11, int i12) {
        int i13 = i11;
        int i14 = i12;
        if (i14 == 1) {
            this.f48918h.a(1013, (long) i13, 0, (Object) null);
        } else {
            this.f48918h.a(200, 0, 0, (Object) null);
        }
        this.f48917g = i14;
        TPPlayerState tPPlayerState = this.f48915e;
        tPPlayerState.setLastState(tPPlayerState.state());
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            long o11 = bVar.o();
            this.f48912b.c("switchPlayer, current position:".concat(String.valueOf(o11)));
            this.f48923m.f(o11);
            this.f48923m.i(this.f48914d.p());
            this.f48914d.l();
            this.f48914d.m();
        }
        com.tencent.thumbplayer.tcmedia.adapter.a.b a11 = a(i13, this.f48911a);
        this.f48914d = a11;
        if (a11 != null) {
            this.f48916f = true;
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48912b;
            aVar.c("switch player to type:" + this.f48924n);
            if (this.f48923m != null) {
                this.f48914d.a(new TPOptionalParam().buildLong(100, this.f48923m.i()));
            }
            this.f48915e.setInnerPlayStateState(3);
            this.f48914d.h();
            return;
        }
        throw new RuntimeException("error , create player failed");
    }

    private void d(int i11) {
        if (i11 == 5) {
            try {
                this.f48914d.i();
                this.f48915e.changeState(5);
            } catch (IllegalStateException e11) {
                this.f48912b.a((Exception) e11);
            }
        }
    }

    /* access modifiers changed from: private */
    public void w() {
        this.f48918h.a(1000, (long) this.f48924n, 0, (Object) null);
        if (this.f48916f) {
            if (this.f48915e.innerPlayState() != 3) {
                this.f48912b.d("handleOnPrepared, invalid state, mIsRetrying.");
                return;
            }
        } else if (!this.f48921k.b(1)) {
            this.f48912b.c("handleOnPrepared, invalid state");
            return;
        }
        x();
        a(this.f48914d);
        if (this.f48916f) {
            this.f48916f = false;
            com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48912b;
            aVar.c("handleOnPrepared, mIsRetrying, recoverState, state:" + this.f48915e.state());
            int state = this.f48915e.state();
            this.f48915e.changeState(4);
            if (this.f48915e.lastState() == 3) {
                this.f48918h.a();
            }
            if (this.f48917g == 1) {
                this.f48918h.a(1014, 0, 0, (Object) null);
            } else {
                this.f48918h.a(201, 0, 0, (Object) null);
            }
            this.f48917g = 0;
            d(state);
            return;
        }
        this.f48915e.setInnerPlayStateState(4);
        this.f48915e.changeState(4);
        this.f48918h.a();
    }

    private void x() {
        if (C()) {
            b a11 = b.a(c(0));
            this.f48923m = a11;
            a11.e((int) this.f48914d.b(204));
            this.f48923m.a((int) this.f48914d.b(203));
            this.f48923m.c((int) this.f48914d.b(102));
            this.f48923m.g((int) this.f48914d.b(201));
            this.f48923m.b((int) this.f48914d.b(210));
        }
        if (this.f48923m == null) {
            this.f48923m = new b();
        }
        this.f48923m.h(this.f48914d.n());
        TPOptionalParam b11 = this.f48920j.b(100);
        if (b11 != null) {
            this.f48923m.f(b11.getParamLong().value);
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        if (!this.f48921k.b(2)) {
            this.f48912b.c("handleOnComplete, invalid state");
            return;
        }
        this.f48915e.changeState(7);
        this.f48918h.b();
    }

    /* access modifiers changed from: private */
    public void z() {
        if (this.f48921k.b(5)) {
            this.f48918h.c();
        }
    }

    public int a() {
        b bVar = this.f48923m;
        if (bVar != null) {
            return bVar.m();
        }
        return 0;
    }

    public void a(float f11) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(f11);
            } else {
                this.f48912b.c("setAudioGainRatio, mPlayerBase = null!");
            }
            this.f48920j.a(f11);
            return;
        }
        throw new IllegalStateException("error , setAudioGainRatio , state invalid , current state :" + this.f48915e);
    }

    public void a(int i11) {
        if (!this.f48921k.a(9)) {
            throw new IllegalStateException("error , seek to , state invalid , current state :" + this.f48915e);
        } else if (this.f48914d != null) {
            if (this.f48915e.state() == 7) {
                this.f48915e.changeState(5);
            }
            this.f48914d.a(i11);
            com.tencent.thumbplayer.tcmedia.f.a aVar = this.f48925o;
            if (aVar != null) {
                try {
                    aVar.a((long) i11);
                } catch (Exception unused) {
                    this.f48912b.d("seekTo, rich media processor seek err.");
                }
            }
        } else {
            this.f48912b.d("seekTo, mPlayerBase = null!");
        }
    }

    public void a(int i11, @TPCommonEnum.TPSeekMode int i12) {
        if (!this.f48921k.a(9)) {
            throw new IllegalStateException("error , seek to , state invalid , current state :" + this.f48915e);
        } else if (this.f48914d != null) {
            if (this.f48915e.state() == 7) {
                this.f48915e.changeState(5);
            }
            this.f48914d.a(i11, i12);
            com.tencent.thumbplayer.tcmedia.f.a aVar = this.f48925o;
            if (aVar != null) {
                try {
                    aVar.a((long) i11);
                } catch (Exception unused) {
                    this.f48912b.d("seekTo, rich media processor seek err.");
                }
            }
        } else {
            this.f48912b.d("seekTo, mPlayerBase = null!");
        }
    }

    public void a(int i11, long j11) {
        if (this.f48921k.a(3)) {
            TPTrackInfo[] s11 = s();
            if (s11 == null) {
                this.f48912b.e("fatal err, tpTrackInfos is null");
            } else if (i11 < 0 || i11 > s11.length - 1) {
                throw new IllegalArgumentException("error : track not found");
            } else {
                com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
                if (bVar != null) {
                    bVar.a(i11, j11);
                }
                this.f48920j.a(i11, j11, s11[i11]);
            }
        } else {
            throw new IllegalStateException("error : selectTrack , state invalid");
        }
    }

    public void a(AssetFileDescriptor assetFileDescriptor) {
        if (!this.f48921k.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        } else if (assetFileDescriptor != null) {
            this.f48920j.a(assetFileDescriptor);
            this.f48915e.changeState(2);
        } else {
            throw new IllegalArgumentException("error : setDataSource , afd invalid");
        }
    }

    public void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (!this.f48921k.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        } else if (parcelFileDescriptor != null) {
            this.f48920j.a(parcelFileDescriptor);
            this.f48915e.changeState(2);
        } else {
            throw new IllegalArgumentException("error : setDataSource , pfd invalid");
        }
    }

    public void a(Surface surface) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            bVar.a(surface);
        }
        this.f48920j.a(surface);
    }

    public void a(SurfaceHolder surfaceHolder) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            bVar.a(surfaceHolder);
        }
        this.f48920j.a(surfaceHolder);
    }

    public void a(c.a aVar) {
        this.f48918h.a(aVar);
    }

    public void a(c.b bVar) {
        this.f48918h.a(bVar);
    }

    public void a(c.C0614c cVar) {
        this.f48918h.a(cVar);
    }

    public void a(c.d dVar) {
        this.f48918h.a(dVar);
    }

    public void a(c.e eVar) {
        this.f48918h.a(eVar);
    }

    public void a(c.f fVar) {
        this.f48918h.a(fVar);
    }

    public void a(c.g gVar) {
        this.f48918h.a(gVar);
    }

    public void a(c.h hVar) {
        this.f48918h.a(hVar);
    }

    public void a(c.i iVar) {
        this.f48918h.a(iVar);
    }

    public void a(c.j jVar) {
        this.f48918h.a(jVar);
    }

    public void a(c.k kVar) {
        this.f48918h.a(kVar);
    }

    public void a(c.l lVar) {
        this.f48918h.a(lVar);
    }

    public void a(c.m mVar) {
        this.f48918h.a(mVar);
    }

    public void a(c.n nVar) {
        this.f48918h.a(nVar);
    }

    public void a(c.o oVar) {
        this.f48918h.a(oVar);
    }

    public void a(c.p pVar) {
        this.f48918h.a(pVar);
    }

    public void a(com.tencent.thumbplayer.tcmedia.adapter.a.e eVar) {
        a(eVar, (Map<String, String>) null);
    }

    public void a(com.tencent.thumbplayer.tcmedia.adapter.a.e eVar, int i11, long j11) {
        if (this.f48921k.a(17)) {
            this.f48920j.a(eVar, (Map<String, String>) null);
            if (this.f48914d != null) {
                int i12 = this.f48924n;
                this.f48914d.a(i12 == 2 ? eVar.b() : i12 == 1 ? eVar.a() : "", i11, j11);
                return;
            }
            this.f48912b.d("switchDefinition, mPlayerBase = null!");
            return;
        }
        throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.f48915e);
    }

    public void a(com.tencent.thumbplayer.tcmedia.adapter.a.e eVar, Map<String, String> map) {
        if (this.f48921k.a(2)) {
            this.f48920j.a(eVar, map);
            this.f48915e.changeState(2);
            return;
        }
        throw new IllegalStateException("error : setDataSource , state invalid");
    }

    public void a(com.tencent.thumbplayer.tcmedia.adapter.a.e eVar, Map<String, String> map, int i11, long j11) {
        if (this.f48921k.a(17)) {
            this.f48920j.a(eVar, map);
            if (this.f48914d != null) {
                int i12 = this.f48924n;
                this.f48914d.a(i12 == 2 ? eVar.b() : i12 == 1 ? eVar.a() : "", map, i11, j11);
                return;
            }
            this.f48912b.d("switchDefinition, mPlayerBase = null!");
            return;
        }
        throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.f48915e);
    }

    public void a(TPCaptureParams tPCaptureParams, TPCaptureCallBack tPCaptureCallBack) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            bVar.a(tPCaptureParams, tPCaptureCallBack);
            return;
        }
        throw new IllegalStateException("error , no player for capture :" + this.f48915e);
    }

    public void a(TPOptionalParam tPOptionalParam) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(tPOptionalParam);
            }
            this.f48920j.a(tPOptionalParam);
            return;
        }
        throw new IllegalStateException("setPlayerOptionalParam , state invalid");
    }

    public void a(TPVideoInfo tPVideoInfo) {
        if (!this.f48921k.a(2)) {
            this.f48912b.e("setVideoInfo state invalid");
        }
        if (tPVideoInfo != null) {
            this.f48923m.b(tPVideoInfo.getHeight());
            this.f48923m.a(tPVideoInfo.getWidth());
            this.f48923m.c(tPVideoInfo.getDefinition());
            this.f48923m.g(tPVideoInfo.getVideoCodecId());
        }
    }

    public void a(ITPMediaAsset iTPMediaAsset) {
        if (!this.f48921k.a(2)) {
            throw new IllegalStateException("error : setDataSource , state invalid");
        } else if (iTPMediaAsset != null) {
            this.f48920j.a(iTPMediaAsset);
            this.f48915e.changeState(2);
        } else {
            throw new IllegalArgumentException("error : setDataSource , mediaAsset invalid");
        }
    }

    public void a(ITPMediaAsset iTPMediaAsset, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
        if (this.f48921k.a(17)) {
            this.f48920j.a(iTPMediaAsset);
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(iTPMediaAsset, i11, j11);
            } else {
                this.f48912b.d("switchDefinition, mPlayerBase = null!");
            }
        } else {
            throw new IllegalStateException("error , switch definition , state invalid , current state :" + this.f48915e);
        }
    }

    public void a(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        if (iTPRichMediaSynchronizer == null) {
            com.tencent.thumbplayer.tcmedia.f.a aVar = this.f48925o;
            if (aVar != null) {
                aVar.a((a.C0620a) null);
            }
            this.f48925o = null;
        } else if (iTPRichMediaSynchronizer instanceof com.tencent.thumbplayer.tcmedia.f.a) {
            com.tencent.thumbplayer.tcmedia.f.a aVar2 = (com.tencent.thumbplayer.tcmedia.f.a) iTPRichMediaSynchronizer;
            this.f48925o = aVar2;
            aVar2.a((a.C0620a) new a.C0620a() {
                public long a(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
                    return d.this.o();
                }
            });
        }
    }

    public void a(b bVar) {
        this.f48911a.a(bVar, "TPPlayerAdapter");
        this.f48912b.a(this.f48911a);
        this.f48918h.a(this.f48911a.a());
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2 = this.f48914d;
        if (bVar2 != null) {
            bVar2.a(this.f48911a);
        }
    }

    public void a(String str) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(str);
            } else {
                this.f48912b.c("setAudioGainRatio, mPlayerBase = null!");
            }
            this.f48920j.a(str);
            return;
        }
        throw new IllegalStateException("error , setAudioNormalizeVolumeParams , state invalid , current state :" + this.f48915e);
    }

    public void a(String str, @TPCommonEnum.TPSwitchDefMode int i11, long j11) {
    }

    public void a(String str, Map<String, String> map) {
    }

    public void a(String str, Map<String, String> map, int i11, long j11) {
    }

    public void a(String str, Map<String, String> map, String str2, String str3) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(str, map, str2, str3);
            }
            this.f48920j.a(str, map, str2, str3);
            return;
        }
        throw new IllegalStateException("error : addSubtitleSource, state invalid");
    }

    public void a(String str, Map<String, String> map, String str2, List<TPOptionalParam> list) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(str, map, str2, list);
            }
            this.f48920j.a(str, map, str2, list);
            return;
        }
        throw new IllegalStateException("error : addAudioTrackSource, state invalid");
    }

    public void a(boolean z11) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(z11);
            } else {
                this.f48912b.c("setOutputMute, mPlayerBase = null!");
            }
            this.f48920j.a(z11);
            return;
        }
        throw new IllegalStateException("error , setOutputMute , state invalid , current state :" + this.f48915e);
    }

    public void a(boolean z11, long j11, long j12) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.a(z11, j11, j12);
            } else {
                this.f48912b.c("setLoopback, mPlayerBase = null!");
            }
            this.f48920j.a(z11, j11, j12);
            return;
        }
        throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.f48915e);
    }

    public int b() {
        return this.f48915e.state();
    }

    public long b(int i11) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            return bVar.b(i11);
        }
        this.f48912b.d("getPropertyLong, mPlayerBase = null, return !");
        return -1;
    }

    public void b(float f11) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.b(f11);
            } else {
                this.f48912b.c("setPlaySpeedRatio, mPlayerBase = null!");
            }
            this.f48920j.b(f11);
            com.tencent.thumbplayer.tcmedia.f.a aVar = this.f48925o;
            if (aVar != null) {
                try {
                    aVar.a(f11);
                } catch (Exception unused) {
                    this.f48912b.d("setPlaySpeedRatio, rich media processor setPlaySpeedRatio err.");
                }
            }
        } else {
            throw new IllegalStateException("error , setPlaySpeedRatio , state invalid , current state :" + this.f48915e);
        }
    }

    public void b(int i11, int i12) {
        this.f48918h.b(i11, i12);
    }

    public void b(int i11, long j11) {
        if (this.f48921k.a(3)) {
            TPTrackInfo[] s11 = s();
            if (s11 == null) {
                this.f48912b.e("fatal err, tpTrackInfos is null");
            } else if (i11 < 0 || i11 > s11.length - 1) {
                throw new IllegalArgumentException("error : track not found");
            } else {
                com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
                if (bVar != null) {
                    bVar.b(i11, j11);
                }
                this.f48920j.b(i11, j11, s11[i11]);
            }
        } else {
            throw new IllegalStateException("error : deselectTrack , state invalid");
        }
    }

    public void b(TPVideoInfo tPVideoInfo) {
        if (!this.f48921k.a(3)) {
            this.f48912b.e("updateVideoInfo state invalid");
        }
        if (tPVideoInfo != null) {
            this.f48923m.b(tPVideoInfo.getHeight());
            this.f48923m.a(tPVideoInfo.getWidth());
            this.f48923m.c(tPVideoInfo.getDefinition());
            this.f48923m.g(tPVideoInfo.getVideoCodecId());
        }
    }

    public void b(boolean z11) {
        if (this.f48921k.a(3)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.b(z11);
            } else {
                this.f48912b.c("setLoopback, mPlayerBase = null!");
            }
            this.f48920j.b(z11);
            return;
        }
        throw new IllegalStateException("error , setLoopback , state invalid , current state :" + this.f48915e);
    }

    public TPDynamicStatisticParams c(boolean z11) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar == null) {
            return null;
        }
        return bVar.c(z11);
    }

    public String c(int i11) {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            return bVar.c(i11);
        }
        this.f48912b.d("getPropertyString, mPlayerBase = null, return !");
        return "";
    }

    public void c(int i11, long j11) {
        if (this.f48921k.a(18)) {
            TPProgramInfo[] t11 = t();
            if (t11 == null) {
                t11 = new TPProgramInfo[0];
            }
            if (i11 < 0 || i11 > t11.length - 1) {
                throw new IllegalArgumentException("error : program index not found");
            }
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                bVar.c(i11, j11);
            }
            this.f48920j.a(t11[i11]);
            return;
        }
        throw new IllegalStateException("error : selectProgram , state invalid");
    }

    public boolean c() {
        TPPlayerState tPPlayerState = this.f48915e;
        return tPPlayerState != null && tPPlayerState.state() == 5;
    }

    public int d() {
        return this.f48924n;
    }

    public b e() {
        return this.f48923m;
    }

    public void f() {
        c(this.f48924n, 2);
    }

    public void g() {
        if (!this.f48921k.a(1)) {
            throw new IllegalStateException("error , prepare , state invalid , current state :" + this.f48915e);
        } else if (this.f48920j.f()) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b a11 = a(B(), this.f48911a);
            this.f48914d = a11;
            if (a11 != null) {
                this.f48915e.setInnerPlayStateState(3);
                this.f48915e.changeState(3);
                this.f48914d.g();
                return;
            }
            throw new RuntimeException("error , create player failed");
        } else {
            throw new IOException("error , prepare , data source invalid");
        }
    }

    public void h() {
        if (!this.f48921k.a(1)) {
            throw new IllegalStateException("error , prepare , state invalid , current state :" + this.f48915e);
        } else if (this.f48920j.f()) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b a11 = a(B(), this.f48911a);
            this.f48914d = a11;
            if (a11 != null) {
                this.f48915e.setInnerPlayStateState(3);
                this.f48915e.changeState(3);
                this.f48914d.h();
                return;
            }
            throw new RuntimeException("error , create player failed");
        } else {
            throw new IllegalStateException("error , prepare , state invalid , data source invalid");
        }
    }

    public void i() {
        if (this.f48921k.a(5)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar != null) {
                try {
                    bVar.i();
                    this.f48915e.changeState(5);
                } catch (IllegalStateException unused) {
                    throw new IllegalStateException("error , start ,state invalid");
                }
            } else {
                throw new IllegalStateException("error , start , player is null");
            }
        } else {
            throw new IllegalStateException("error , start , state invalid , current state :" + this.f48915e);
        }
    }

    public void j() {
        if (this.f48921k.a(6)) {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
            if (bVar == null) {
                throw new IllegalStateException("error , pause , player is null");
            } else if (this.f48916f) {
                this.f48915e.changeState(6);
            } else {
                try {
                    bVar.j();
                    this.f48915e.changeState(6);
                } catch (IllegalStateException unused) {
                    throw new IllegalStateException("error , pause ,state invalid");
                }
            }
        } else {
            throw new IllegalStateException("error , pause , state invalid , current state :" + this.f48915e);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw new java.lang.IllegalStateException("error , stop ,state invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r3.f48915e.changeState(9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0023 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void k() {
        /*
            r3 = this;
            com.tencent.thumbplayer.tcmedia.adapter.i r0 = r3.f48921k
            r1 = 7
            boolean r0 = r0.a((int) r1)
            if (r0 == 0) goto L_0x0039
            com.tencent.thumbplayer.tcmedia.adapter.a.b r0 = r3.f48914d
            if (r0 == 0) goto L_0x0031
            r0 = 9
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r1 = r3.f48915e     // Catch:{ IllegalStateException -> 0x0023 }
            r2 = 8
            r1.changeState(r2)     // Catch:{ IllegalStateException -> 0x0023 }
            com.tencent.thumbplayer.tcmedia.adapter.a.b r1 = r3.f48914d     // Catch:{ IllegalStateException -> 0x0023 }
            r1.k()     // Catch:{ IllegalStateException -> 0x0023 }
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r1 = r3.f48915e
            r1.changeState(r0)
            return
        L_0x0021:
            r1 = move-exception
            goto L_0x002b
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0021 }
            java.lang.String r2 = "error , stop ,state invalid"
            r1.<init>(r2)     // Catch:{ all -> 0x0021 }
            throw r1     // Catch:{ all -> 0x0021 }
        L_0x002b:
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r2 = r3.f48915e
            r2.changeState(r0)
            throw r1
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "error , stop , player is null"
            r0.<init>(r1)
            throw r0
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "error , stop , state invalid , current state :"
            r1.<init>(r2)
            com.tencent.thumbplayer.tcmedia.api.TPPlayerState r2 = r3.f48915e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.adapter.d.k():void");
    }

    public void l() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48912b;
        aVar.c("reset, current state :" + this.f48915e);
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            bVar.l();
            this.f48914d.m();
            this.f48914d = null;
        }
        this.f48920j.a();
        this.f48923m.o();
        this.f48922l = null;
        this.f48916f = false;
        this.f48915e.changeState(1);
        this.f48915e.setLastState(1);
    }

    public void m() {
        com.tencent.thumbplayer.tcmedia.e.a aVar = this.f48912b;
        aVar.c("release, current state :" + this.f48915e);
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar != null) {
            bVar.m();
            this.f48914d = null;
        }
        this.f48920j.a();
        this.f48918h.e();
        this.f48922l = null;
        this.f48916f = false;
        this.f48915e.changeState(11);
    }

    public long n() {
        b bVar = this.f48923m;
        if (bVar != null && bVar.k() > 0) {
            return this.f48923m.k();
        }
        if (!this.f48921k.a(11)) {
            return 0;
        }
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2 = this.f48914d;
        if (bVar2 == null) {
            this.f48912b.d("getDurationMs, mPlayerBase = null, return 0!");
            return 0;
        }
        long n11 = bVar2.n();
        b bVar3 = this.f48923m;
        if (bVar3 != null) {
            bVar3.h(n11);
        }
        return n11;
    }

    public long o() {
        if (!this.f48921k.a(12)) {
            b bVar = this.f48923m;
            if (bVar != null) {
                return bVar.i();
            }
            return 0;
        }
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2 = this.f48914d;
        if (bVar2 == null) {
            this.f48912b.d("getCurrentPositionMs, mPlayerBase = null, return 0!");
            return 0;
        }
        long o11 = bVar2.o();
        b bVar3 = this.f48923m;
        if (bVar3 != null) {
            bVar3.f(o11);
        }
        return o11;
    }

    public long p() {
        if (!this.f48921k.a(12)) {
            return 0;
        }
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar == null) {
            this.f48912b.d("getBufferedDurationMs, mPlayerBase = null, return 0!");
            return 0;
        }
        long p11 = bVar.p();
        b bVar2 = this.f48923m;
        if (bVar2 != null) {
            bVar2.i(p11);
        }
        return p11;
    }

    public int q() {
        com.tencent.thumbplayer.tcmedia.e.a aVar;
        String str;
        b bVar = this.f48923m;
        if (bVar != null && bVar.a() > 0) {
            return (int) this.f48923m.a();
        }
        if (!this.f48921k.a(13)) {
            aVar = this.f48912b;
            str = "getVideoWidth, state error!";
        } else {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2 = this.f48914d;
            if (bVar2 == null) {
                aVar = this.f48912b;
                str = "getVideoWidth, mPlayerBase = null, return 0!";
            } else {
                int q11 = bVar2.q();
                b bVar3 = this.f48923m;
                if (bVar3 != null) {
                    bVar3.a((long) q11);
                }
                return q11;
            }
        }
        aVar.d(str);
        return 0;
    }

    public int r() {
        com.tencent.thumbplayer.tcmedia.e.a aVar;
        String str;
        b bVar = this.f48923m;
        if (bVar != null && bVar.b() > 0) {
            return (int) this.f48923m.b();
        }
        if (!this.f48921k.a(13)) {
            aVar = this.f48912b;
            str = "getVideoHeight, state error!";
        } else {
            com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2 = this.f48914d;
            if (bVar2 == null) {
                aVar = this.f48912b;
                str = "getVideoHeight, mPlayerBase = null, return 0!";
            } else {
                int r11 = bVar2.r();
                b bVar3 = this.f48923m;
                if (bVar3 != null) {
                    bVar3.b((long) r11);
                }
                return r11;
            }
        }
        aVar.d(str);
        return 0;
    }

    public TPTrackInfo[] s() {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        return bVar != null ? bVar.s() : (TPTrackInfo[]) this.f48920j.b().toArray(new TPTrackInfo[0]);
    }

    public TPProgramInfo[] t() {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        return (bVar == null || bVar.t() == null) ? new TPProgramInfo[0] : this.f48914d.t();
    }

    public long u() {
        if (!this.f48921k.a(19)) {
            b bVar = this.f48923m;
            if (bVar != null) {
                return bVar.j();
            }
            return -1;
        }
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar2 = this.f48914d;
        if (bVar2 == null) {
            this.f48912b.d("getDemuxerOffsetInFile, mPlayerBase = null, return 0!");
            return -1;
        }
        long u11 = bVar2.u();
        b bVar3 = this.f48923m;
        if (bVar3 != null) {
            bVar3.g(u11);
        }
        return u11;
    }

    public TPGeneralPlayFlowParams v() {
        com.tencent.thumbplayer.tcmedia.adapter.a.b bVar = this.f48914d;
        if (bVar == null) {
            return null;
        }
        return bVar.v();
    }
}
