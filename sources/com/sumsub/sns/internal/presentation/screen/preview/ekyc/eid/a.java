package com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid;

import d10.l;
import de.authada.library.api.Can;
import de.authada.library.api.authentication.Pin;
import de.authada.library.api.authentication.StartCallback;
import de.authada.library.api.pinChanger.TPin;
import de.authada.library.api.unblock.Puk;
import de.authada.library.api.unblock.UnblockerCallback;
import java.net.URL;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class a {

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.a$a  reason: collision with other inner class name */
    public static final class C0435a extends a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0435a f35560a = new C0435a();

        public C0435a() {
            super((r) null);
        }
    }

    public static final class b extends a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f35561a = new b();

        public b() {
            super((r) null);
        }
    }

    public static final class c extends a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f35562a = new c();

        public c() {
            super((r) null);
        }
    }

    public static final class d extends a {

        /* renamed from: a  reason: collision with root package name */
        public final Pin f35563a;

        /* renamed from: b  reason: collision with root package name */
        public final Can f35564b;

        /* renamed from: c  reason: collision with root package name */
        public final b f35565c;

        /* renamed from: d  reason: collision with root package name */
        public final l<Throwable, Unit> f35566d;

        public d(Pin pin, Can can, b bVar, l<? super Throwable, Unit> lVar) {
            super((r) null);
            this.f35563a = pin;
            this.f35564b = can;
            this.f35565c = bVar;
            this.f35566d = lVar;
        }

        public final Pin a() {
            return this.f35563a;
        }

        public final Can b() {
            return this.f35564b;
        }

        public final b c() {
            return this.f35565c;
        }

        public final l<Throwable, Unit> d() {
            return this.f35566d;
        }

        public final b e() {
            return this.f35565c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return x.b(this.f35563a, dVar.f35563a) && x.b(this.f35564b, dVar.f35564b) && x.b(this.f35565c, dVar.f35565c) && x.b(this.f35566d, dVar.f35566d);
        }

        public final Can f() {
            return this.f35564b;
        }

        public final l<Throwable, Unit> g() {
            return this.f35566d;
        }

        public final Pin h() {
            return this.f35563a;
        }

        public int hashCode() {
            int hashCode = this.f35563a.hashCode() * 31;
            Can can = this.f35564b;
            return ((((hashCode + (can == null ? 0 : can.hashCode())) * 31) + this.f35565c.hashCode()) * 31) + this.f35566d.hashCode();
        }

        public String toString() {
            return "PinAuthentication(pin=" + this.f35563a + ", can=" + this.f35564b + ", callback=" + this.f35565c + ", errorCallback=" + this.f35566d + ')';
        }

        public final d a(Pin pin, Can can, b bVar, l<? super Throwable, Unit> lVar) {
            return new d(pin, can, bVar, lVar);
        }

        public static /* synthetic */ d a(d dVar, Pin pin, Can can, b bVar, l<Throwable, Unit> lVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                pin = dVar.f35563a;
            }
            if ((i11 & 2) != 0) {
                can = dVar.f35564b;
            }
            if ((i11 & 4) != 0) {
                bVar = dVar.f35565c;
            }
            if ((i11 & 8) != 0) {
                lVar = dVar.f35566d;
            }
            return dVar.a(pin, can, bVar, lVar);
        }
    }

    public static final class e extends a {

        /* renamed from: a  reason: collision with root package name */
        public final TPin f35567a;

        /* renamed from: b  reason: collision with root package name */
        public final Pin f35568b;

        /* renamed from: c  reason: collision with root package name */
        public final Can f35569c;

        /* renamed from: d  reason: collision with root package name */
        public final Integer f35570d;

        /* renamed from: e  reason: collision with root package name */
        public final c f35571e;

        /* renamed from: f  reason: collision with root package name */
        public final l<Throwable, Unit> f35572f;

        public e(TPin tPin, Pin pin, Can can, Integer num, c cVar, l<? super Throwable, Unit> lVar) {
            super((r) null);
            this.f35567a = tPin;
            this.f35568b = pin;
            this.f35569c = can;
            this.f35570d = num;
            this.f35571e = cVar;
            this.f35572f = lVar;
        }

        public final TPin a() {
            return this.f35567a;
        }

        public final Pin b() {
            return this.f35568b;
        }

        public final Can c() {
            return this.f35569c;
        }

        public final Integer d() {
            return this.f35570d;
        }

        public final c e() {
            return this.f35571e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return x.b(this.f35567a, eVar.f35567a) && x.b(this.f35568b, eVar.f35568b) && x.b(this.f35569c, eVar.f35569c) && x.b(this.f35570d, eVar.f35570d) && x.b(this.f35571e, eVar.f35571e) && x.b(this.f35572f, eVar.f35572f);
        }

        public final l<Throwable, Unit> f() {
            return this.f35572f;
        }

        public final c g() {
            return this.f35571e;
        }

        public final Can h() {
            return this.f35569c;
        }

        public int hashCode() {
            int hashCode = ((this.f35567a.hashCode() * 31) + this.f35568b.hashCode()) * 31;
            Can can = this.f35569c;
            int i11 = 0;
            int hashCode2 = (hashCode + (can == null ? 0 : can.hashCode())) * 31;
            Integer num = this.f35570d;
            if (num != null) {
                i11 = num.hashCode();
            }
            return ((((hashCode2 + i11) * 31) + this.f35571e.hashCode()) * 31) + this.f35572f.hashCode();
        }

        public final l<Throwable, Unit> i() {
            return this.f35572f;
        }

        public final Integer j() {
            return this.f35570d;
        }

        public final Pin k() {
            return this.f35568b;
        }

        public final TPin l() {
            return this.f35567a;
        }

        public String toString() {
            return "PinChange(oldPin=" + this.f35567a + ", newPin=" + this.f35568b + ", can=" + this.f35569c + ", lastPinDigit=" + this.f35570d + ", callback=" + this.f35571e + ", errorCallback=" + this.f35572f + ')';
        }

        public final e a(TPin tPin, Pin pin, Can can, Integer num, c cVar, l<? super Throwable, Unit> lVar) {
            return new e(tPin, pin, can, num, cVar, lVar);
        }

        public static /* synthetic */ e a(e eVar, TPin tPin, Pin pin, Can can, Integer num, c cVar, l<Throwable, Unit> lVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                tPin = eVar.f35567a;
            }
            if ((i11 & 2) != 0) {
                pin = eVar.f35568b;
            }
            Pin pin2 = pin;
            if ((i11 & 4) != 0) {
                can = eVar.f35569c;
            }
            Can can2 = can;
            if ((i11 & 8) != 0) {
                num = eVar.f35570d;
            }
            Integer num2 = num;
            if ((i11 & 16) != 0) {
                cVar = eVar.f35571e;
            }
            c cVar2 = cVar;
            if ((i11 & 32) != 0) {
                lVar = eVar.f35572f;
            }
            return eVar.a(tPin, pin2, can2, num2, cVar2, lVar);
        }
    }

    public static final class f extends a {

        /* renamed from: a  reason: collision with root package name */
        public final Puk f35573a;

        /* renamed from: b  reason: collision with root package name */
        public final UnblockerCallback f35574b;

        /* renamed from: c  reason: collision with root package name */
        public final l<Throwable, Unit> f35575c;

        public f(Puk puk, UnblockerCallback unblockerCallback, l<? super Throwable, Unit> lVar) {
            super((r) null);
            this.f35573a = puk;
            this.f35574b = unblockerCallback;
            this.f35575c = lVar;
        }

        public final Puk a() {
            return this.f35573a;
        }

        public final UnblockerCallback b() {
            return this.f35574b;
        }

        public final l<Throwable, Unit> c() {
            return this.f35575c;
        }

        public final UnblockerCallback d() {
            return this.f35574b;
        }

        public final l<Throwable, Unit> e() {
            return this.f35575c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return x.b(this.f35573a, fVar.f35573a) && x.b(this.f35574b, fVar.f35574b) && x.b(this.f35575c, fVar.f35575c);
        }

        public final Puk f() {
            return this.f35573a;
        }

        public int hashCode() {
            return (((this.f35573a.hashCode() * 31) + this.f35574b.hashCode()) * 31) + this.f35575c.hashCode();
        }

        public String toString() {
            return "PinUnblock(puk=" + this.f35573a + ", callback=" + this.f35574b + ", errorCallback=" + this.f35575c + ')';
        }

        public final f a(Puk puk, UnblockerCallback unblockerCallback, l<? super Throwable, Unit> lVar) {
            return new f(puk, unblockerCallback, lVar);
        }

        public static /* synthetic */ f a(f fVar, Puk puk, UnblockerCallback unblockerCallback, l<Throwable, Unit> lVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                puk = fVar.f35573a;
            }
            if ((i11 & 2) != 0) {
                unblockerCallback = fVar.f35574b;
            }
            if ((i11 & 4) != 0) {
                lVar = fVar.f35575c;
            }
            return fVar.a(puk, unblockerCallback, lVar);
        }
    }

    public static final class g extends a {

        /* renamed from: a  reason: collision with root package name */
        public final String f35576a;

        /* renamed from: b  reason: collision with root package name */
        public final URL f35577b;

        /* renamed from: c  reason: collision with root package name */
        public final String f35578c;

        /* renamed from: d  reason: collision with root package name */
        public final StartCallback f35579d;

        /* renamed from: e  reason: collision with root package name */
        public final l<Throwable, Unit> f35580e;

        public g(String str, URL url, String str2, StartCallback startCallback, l<? super Throwable, Unit> lVar) {
            super((r) null);
            this.f35576a = str;
            this.f35577b = url;
            this.f35578c = str2;
            this.f35579d = startCallback;
            this.f35580e = lVar;
        }

        public final String a() {
            return this.f35576a;
        }

        public final URL b() {
            return this.f35577b;
        }

        public final String c() {
            return this.f35578c;
        }

        public final StartCallback d() {
            return this.f35579d;
        }

        public final l<Throwable, Unit> e() {
            return this.f35580e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return x.b(this.f35576a, gVar.f35576a) && x.b(this.f35577b, gVar.f35577b) && x.b(this.f35578c, gVar.f35578c) && x.b(this.f35579d, gVar.f35579d) && x.b(this.f35580e, gVar.f35580e);
        }

        public final StartCallback f() {
            return this.f35579d;
        }

        public final l<Throwable, Unit> g() {
            return this.f35580e;
        }

        public final String h() {
            return this.f35578c;
        }

        public int hashCode() {
            return (((((((this.f35576a.hashCode() * 31) + this.f35577b.hashCode()) * 31) + this.f35578c.hashCode()) * 31) + this.f35579d.hashCode()) * 31) + this.f35580e.hashCode();
        }

        public final String i() {
            return this.f35576a;
        }

        public final URL j() {
            return this.f35577b;
        }

        public String toString() {
            return "Start(mobileToken=" + this.f35576a + ", url=" + this.f35577b + ", hash=" + this.f35578c + ", callback=" + this.f35579d + ", errorCallback=" + this.f35580e + ')';
        }

        public final g a(String str, URL url, String str2, StartCallback startCallback, l<? super Throwable, Unit> lVar) {
            return new g(str, url, str2, startCallback, lVar);
        }

        public static /* synthetic */ g a(g gVar, String str, URL url, String str2, StartCallback startCallback, l<Throwable, Unit> lVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = gVar.f35576a;
            }
            if ((i11 & 2) != 0) {
                url = gVar.f35577b;
            }
            URL url2 = url;
            if ((i11 & 4) != 0) {
                str2 = gVar.f35578c;
            }
            String str3 = str2;
            if ((i11 & 8) != 0) {
                startCallback = gVar.f35579d;
            }
            StartCallback startCallback2 = startCallback;
            if ((i11 & 16) != 0) {
                lVar = gVar.f35580e;
            }
            return gVar.a(str, url2, str3, startCallback2, lVar);
        }
    }

    public /* synthetic */ a(r rVar) {
        this();
    }

    public a() {
    }
}
