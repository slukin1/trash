package com.tencent.thumbplayer.tcmedia.g;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.thumbplayer.tcmedia.g.b;
import com.tencent.thumbplayer.tcmedia.g.b.c;
import com.tencent.thumbplayer.tcmedia.g.b.d;
import com.tencent.thumbplayer.tcmedia.g.b.e;
import com.tencent.thumbplayer.tcmedia.g.b.f;
import com.tencent.thumbplayer.tcmedia.g.b.g;
import com.tencent.thumbplayer.tcmedia.g.f.a;
import com.tencent.thumbplayer.tcmedia.g.f.b;
import java.util.HashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f49199a = new a();

    /* renamed from: e  reason: collision with root package name */
    private static boolean f49200e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f49201f = true;

    /* renamed from: b  reason: collision with root package name */
    private b f49202b = b.f49325e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f49203c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f49204d;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<b, c> f49205g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final com.tencent.thumbplayer.tcmedia.g.e.a f49206h = new com.tencent.thumbplayer.tcmedia.g.e.a();

    /* renamed from: i  reason: collision with root package name */
    private final com.tencent.thumbplayer.tcmedia.g.d.a f49207i = new com.tencent.thumbplayer.tcmedia.g.d.a();

    /* renamed from: j  reason: collision with root package name */
    private final com.tencent.thumbplayer.tcmedia.g.d.a f49208j = new com.tencent.thumbplayer.tcmedia.g.d.a();

    /* renamed from: k  reason: collision with root package name */
    private boolean f49209k = true;

    public static a a() {
        return f49199a;
    }

    private c a(MediaFormat mediaFormat, b bVar) {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "createDirectCodecWrapper mediaFormat:" + mediaFormat + " createBy:" + bVar.a() + " nameOrType:" + bVar.l());
        }
        return bVar.a() == b.C0624b.CreateByName ? new d(MediaCodec.createByCodecName(bVar.l())) : new d(MediaCodec.createDecoderByType(bVar.l()));
    }

    private c a(MediaFormat mediaFormat, b bVar, Surface surface) {
        boolean b11 = bVar.b();
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "getCodec isVideo:" + b11 + " codecFinalReuseEnable:" + bVar.f49210a);
        }
        if (Build.VERSION.SDK_INT < 23 || !bVar.f49210a) {
            bVar.f49211b = false;
            if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "getCodec return DirectCodecWrapper for mediaFormat:" + mediaFormat + " codecFinalReuseEnable:false surface:" + surface);
            }
            return a(mediaFormat, bVar);
        }
        e a11 = e.a(mediaFormat);
        c a12 = a(b11, a11);
        e.a(a11.f49231a);
        if (a12 != null) {
            a.b b12 = a12.b(a11);
            if (b12 == a.b.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION || b12 == a.b.KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION) {
                if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                    com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "getCodec reuse, isVideo:" + b11 + " reuseType:" + b12);
                }
                a12.b();
                a12.c();
                bVar.f49211b = true;
                return a12;
            } else if (b12 == a.b.KEEP_CODEC_RESULT_NO && com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
                com.tencent.thumbplayer.tcmedia.g.h.b.d("TCodecManager", "getCodec not reuse, isVideo:" + b11 + " reuseType:" + b12);
            }
        }
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "getCodec not reuse, for can't find reUseAble CodecWrapper. isVideo:".concat(String.valueOf(b11)));
        }
        bVar.f49211b = false;
        c b13 = b(mediaFormat, bVar);
        b13.b();
        this.f49205g.put(bVar, b13);
        return b13;
    }

    private c a(boolean z11, e eVar) {
        return (z11 ? this.f49207i : this.f49208j).a(eVar);
    }

    private c b(MediaFormat mediaFormat, b bVar) {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "createNewReuseCodecWrapper mediaFormat:" + mediaFormat + " createBy:" + bVar.a() + " nameOrType:" + bVar.l());
        }
        String string = mediaFormat.getString("mime");
        e a11 = e.a(mediaFormat);
        com.tencent.thumbplayer.tcmedia.g.f.a.a(a11, mediaFormat);
        return f.a(bVar.a() == b.C0624b.CreateByName ? MediaCodec.createByCodecName(bVar.l()) : MediaCodec.createDecoderByType(string), string, a11);
    }

    public static void b() {
    }

    private void c(c cVar) {
        if (!e()) {
            return;
        }
        if (cVar instanceof g) {
            this.f49207i.a((f) cVar);
        } else if (cVar instanceof com.tencent.thumbplayer.tcmedia.g.b.a) {
            this.f49208j.a((f) cVar);
        }
    }

    public static boolean c() {
        return f49201f;
    }

    public final c a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i11, b bVar) {
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "configureStart videoPoolInfo:" + this.f49207i.a() + ", audioPoolInfo:" + this.f49208j.a());
        }
        this.f49204d = true;
        this.f49209k = true;
        c a11 = a(mediaFormat, bVar, surface);
        c(a11);
        a11.a(bVar.c());
        a11.a(mediaFormat, surface, mediaCrypto, i11);
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "configureEnd   videoPoolInfo:" + this.f49207i.a() + ", audioPoolInfo:" + this.f49208j.a());
        }
        return a11;
    }

    public final void a(c cVar) {
        if (!e()) {
            return;
        }
        if (cVar instanceof g) {
            this.f49207i.b((f) cVar);
        } else if (cVar instanceof com.tencent.thumbplayer.tcmedia.g.b.a) {
            this.f49208j.b((f) cVar);
        }
    }

    public final void a(com.tencent.thumbplayer.tcmedia.g.h.a aVar) {
        com.tencent.thumbplayer.tcmedia.g.h.b.a(aVar);
    }

    public final void a(boolean z11) {
        com.tencent.thumbplayer.tcmedia.g.h.b.a(z11);
    }

    public final boolean a(b bVar, Surface surface) {
        boolean e11 = e();
        boolean d11 = bVar.d();
        boolean b11 = bVar.b();
        boolean z11 = e11 && d11;
        boolean z12 = Build.VERSION.SDK_INT >= 23 && !com.tencent.thumbplayer.tcmedia.g.h.c.a();
        if (com.tencent.thumbplayer.tcmedia.g.h.b.a()) {
            com.tencent.thumbplayer.tcmedia.g.h.b.b("TCodecManager", "reuseEnable getCodec isVideo:" + b11 + " reuseEnable:" + z11 + ' ' + "globalReuseEnable:" + e11 + " mediaCodecReuseEnable:" + d11 + " canUseSetOutputSurfaceAPI:" + z12 + " ,surface:" + surface);
        }
        return z11 && b11 && z12 && surface != null;
    }

    public final void b(c cVar) {
        if (!e()) {
            return;
        }
        if (cVar instanceof g) {
            this.f49207i.c((f) cVar);
        } else if (cVar instanceof com.tencent.thumbplayer.tcmedia.g.b.a) {
            this.f49208j.c((f) cVar);
        }
    }

    public final com.tencent.thumbplayer.tcmedia.g.f.b d() {
        return this.f49202b;
    }

    public final boolean e() {
        return this.f49203c;
    }

    public final boolean f() {
        return this.f49209k;
    }
}
