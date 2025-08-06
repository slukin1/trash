package zendesk.classic.messaging;

import android.content.res.Resources;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;
import dagger.internal.d;
import g30.a0;
import g30.b0;
import g30.i;
import g30.j;
import g30.n;
import zendesk.belvedere.ImageStream;
import zendesk.classic.messaging.components.DateProvider;
import zendesk.classic.messaging.f;
import zendesk.classic.messaging.ui.AvatarStateFactory_Factory;
import zendesk.classic.messaging.ui.MessagingCellPropsFactory;
import zendesk.classic.messaging.ui.k;
import zendesk.classic.messaging.ui.l;
import zendesk.classic.messaging.ui.m;
import zendesk.classic.messaging.ui.p;
import zendesk.classic.messaging.ui.q;
import zendesk.classic.messaging.ui.s;
import zendesk.classic.messaging.ui.t;
import zendesk.classic.messaging.ui.u;

public final class a {

    public static final class b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        public AppCompatActivity f62412a;

        /* renamed from: b  reason: collision with root package name */
        public h f62413b;

        public b() {
        }

        public f build() {
            d.a(this.f62412a, AppCompatActivity.class);
            d.a(this.f62413b, h.class);
            return new c(this.f62413b, this.f62412a);
        }

        /* renamed from: c */
        public b b(AppCompatActivity appCompatActivity) {
            this.f62412a = (AppCompatActivity) d.b(appCompatActivity);
            return this;
        }

        /* renamed from: d */
        public b a(h hVar) {
            this.f62413b = (h) d.b(hVar);
            return this;
        }
    }

    public static final class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final h f62414a;

        /* renamed from: b  reason: collision with root package name */
        public final c f62415b;

        /* renamed from: c  reason: collision with root package name */
        public q00.a<Resources> f62416c;

        /* renamed from: d  reason: collision with root package name */
        public q00.a<MessagingCellPropsFactory> f62417d;

        /* renamed from: e  reason: collision with root package name */
        public q00.a<DateProvider> f62418e;

        /* renamed from: f  reason: collision with root package name */
        public q00.a<l> f62419f;

        /* renamed from: g  reason: collision with root package name */
        public q00.a<e> f62420g;

        /* renamed from: h  reason: collision with root package name */
        public q00.a<Picasso> f62421h;

        /* renamed from: i  reason: collision with root package name */
        public q00.a f62422i;

        /* renamed from: j  reason: collision with root package name */
        public q00.a<h> f62423j;

        /* renamed from: k  reason: collision with root package name */
        public q00.a<Boolean> f62424k;

        /* renamed from: l  reason: collision with root package name */
        public q00.a<p> f62425l;

        /* renamed from: m  reason: collision with root package name */
        public q00.a<AppCompatActivity> f62426m;

        /* renamed from: n  reason: collision with root package name */
        public q00.a<ImageStream> f62427n;

        /* renamed from: o  reason: collision with root package name */
        public q00.a<BelvedereMediaHolder> f62428o;

        /* renamed from: p  reason: collision with root package name */
        public q00.a<zendesk.belvedere.a> f62429p;

        /* renamed from: q  reason: collision with root package name */
        public q00.a<g30.c> f62430q;

        /* renamed from: r  reason: collision with root package name */
        public q00.a<l> f62431r;

        /* renamed from: s  reason: collision with root package name */
        public q00.a f62432s;

        /* renamed from: t  reason: collision with root package name */
        public q00.a<Handler> f62433t;

        /* renamed from: u  reason: collision with root package name */
        public q00.a<a0> f62434u;

        /* renamed from: v  reason: collision with root package name */
        public q00.a<t> f62435v;

        /* renamed from: w  reason: collision with root package name */
        public q00.a<i> f62436w;

        /* renamed from: zendesk.classic.messaging.a$c$a  reason: collision with other inner class name */
        public static final class C0687a implements q00.a<BelvedereMediaHolder> {

            /* renamed from: a  reason: collision with root package name */
            public final h f62437a;

            public C0687a(h hVar) {
                this.f62437a = hVar;
            }

            /* renamed from: a */
            public BelvedereMediaHolder get() {
                return (BelvedereMediaHolder) dagger.internal.d.e(this.f62437a.a());
            }
        }

        public static final class b implements q00.a<zendesk.belvedere.a> {

            /* renamed from: a  reason: collision with root package name */
            public final h f62438a;

            public b(h hVar) {
                this.f62438a = hVar;
            }

            /* renamed from: a */
            public zendesk.belvedere.a get() {
                return (zendesk.belvedere.a) dagger.internal.d.e(this.f62438a.c());
            }
        }

        /* renamed from: zendesk.classic.messaging.a$c$c  reason: collision with other inner class name */
        public static final class C0688c implements q00.a<l> {

            /* renamed from: a  reason: collision with root package name */
            public final h f62439a;

            public C0688c(h hVar) {
                this.f62439a = hVar;
            }

            /* renamed from: a */
            public l get() {
                return (l) dagger.internal.d.e(this.f62439a.d());
            }
        }

        public static final class d implements q00.a<Picasso> {

            /* renamed from: a  reason: collision with root package name */
            public final h f62440a;

            public d(h hVar) {
                this.f62440a = hVar;
            }

            /* renamed from: a */
            public Picasso get() {
                return (Picasso) dagger.internal.d.e(this.f62440a.e());
            }
        }

        public static final class e implements q00.a<Resources> {

            /* renamed from: a  reason: collision with root package name */
            public final h f62441a;

            public e(h hVar) {
                this.f62441a = hVar;
            }

            /* renamed from: a */
            public Resources get() {
                return (Resources) dagger.internal.d.e(this.f62441a.b());
            }
        }

        public void a(MessagingActivity messagingActivity) {
            c(messagingActivity);
        }

        public final void b(h hVar, AppCompatActivity appCompatActivity) {
            e eVar = new e(hVar);
            this.f62416c = eVar;
            this.f62417d = dagger.internal.a.a(s.a(eVar));
            this.f62418e = dagger.internal.a.a(MessagingActivityModule_DateProviderFactory.a());
            this.f62419f = new C0688c(hVar);
            this.f62420g = dagger.internal.a.a(g30.e.a(this.f62418e));
            d dVar = new d(hVar);
            this.f62421h = dVar;
            this.f62422i = dagger.internal.a.a(zendesk.classic.messaging.ui.d.a(dVar));
            dagger.internal.b a11 = dagger.internal.c.a(hVar);
            this.f62423j = a11;
            this.f62424k = dagger.internal.a.a(j.a(a11));
            this.f62425l = dagger.internal.a.a(q.a(this.f62417d, this.f62418e, this.f62419f, this.f62420g, this.f62422i, AvatarStateFactory_Factory.a(), this.f62424k));
            dagger.internal.b a12 = dagger.internal.c.a(appCompatActivity);
            this.f62426m = a12;
            this.f62427n = dagger.internal.a.a(i.b(a12));
            this.f62428o = new C0687a(hVar);
            this.f62429p = new b(hVar);
            q00.a<g30.c> a13 = dagger.internal.a.a(g30.d.a(this.f62419f, this.f62420g));
            this.f62430q = a13;
            this.f62431r = dagger.internal.a.a(m.a(this.f62419f, this.f62420g, this.f62427n, this.f62429p, this.f62428o, a13));
            this.f62432s = k.a(this.f62426m, this.f62427n, this.f62428o);
            q00.a<Handler> a14 = dagger.internal.a.a(MessagingActivityModule_HandlerFactory.a());
            this.f62433t = a14;
            q00.a<a0> a15 = dagger.internal.a.a(b0.a(this.f62419f, a14, this.f62420g));
            this.f62434u = a15;
            this.f62435v = dagger.internal.a.a(u.a(this.f62426m, this.f62419f, this.f62427n, this.f62428o, this.f62431r, this.f62432s, a15));
            this.f62436w = dagger.internal.a.a(n.a(this.f62426m, this.f62419f, this.f62418e));
        }

        public final MessagingActivity c(MessagingActivity messagingActivity) {
            g30.k.f(messagingActivity, (l) dagger.internal.d.e(this.f62414a.d()));
            g30.k.b(messagingActivity, this.f62425l.get());
            g30.k.e(messagingActivity, (Picasso) dagger.internal.d.e(this.f62414a.e()));
            g30.k.a(messagingActivity, this.f62420g.get());
            g30.k.c(messagingActivity, this.f62435v.get());
            g30.k.d(messagingActivity, this.f62436w.get());
            return messagingActivity;
        }

        public c(h hVar, AppCompatActivity appCompatActivity) {
            this.f62415b = this;
            this.f62414a = hVar;
            b(hVar, appCompatActivity);
        }
    }

    public static f.a a() {
        return new b();
    }
}
