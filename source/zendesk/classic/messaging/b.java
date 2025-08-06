package zendesk.classic.messaging;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.Picasso;
import dagger.internal.d;
import g30.l;
import g30.m;
import g30.p;
import g30.q;
import g30.s;
import g30.t;
import g30.u;
import g30.v;
import g30.x;
import g30.y;
import java.util.List;
import zendesk.classic.messaging.h;

public final class b {

    /* renamed from: zendesk.classic.messaging.b$b  reason: collision with other inner class name */
    public static final class C0689b implements h.a {

        /* renamed from: a  reason: collision with root package name */
        public Context f62442a;

        /* renamed from: b  reason: collision with root package name */
        public List<c> f62443b;

        /* renamed from: c  reason: collision with root package name */
        public MessagingConfiguration f62444c;

        public C0689b() {
        }

        public h build() {
            d.a(this.f62442a, Context.class);
            d.a(this.f62443b, List.class);
            d.a(this.f62444c, MessagingConfiguration.class);
            return new c(this.f62442a, this.f62443b, this.f62444c);
        }

        /* renamed from: d */
        public C0689b c(Context context) {
            this.f62442a = (Context) d.b(context);
            return this;
        }

        /* renamed from: e */
        public C0689b a(List<c> list) {
            this.f62443b = (List) d.b(list);
            return this;
        }

        /* renamed from: f */
        public C0689b b(MessagingConfiguration messagingConfiguration) {
            this.f62444c = (MessagingConfiguration) d.b(messagingConfiguration);
            return this;
        }
    }

    public static final class c implements h {

        /* renamed from: a  reason: collision with root package name */
        public final MessagingConfiguration f62445a;

        /* renamed from: b  reason: collision with root package name */
        public final c f62446b;

        /* renamed from: c  reason: collision with root package name */
        public q00.a<Context> f62447c;

        /* renamed from: d  reason: collision with root package name */
        public q00.a<Picasso> f62448d;

        /* renamed from: e  reason: collision with root package name */
        public q00.a<Resources> f62449e;

        /* renamed from: f  reason: collision with root package name */
        public q00.a<List<c>> f62450f;

        /* renamed from: g  reason: collision with root package name */
        public q00.a<MessagingConfiguration> f62451g;

        /* renamed from: h  reason: collision with root package name */
        public q00.a<x> f62452h;

        /* renamed from: i  reason: collision with root package name */
        public q00.a<j> f62453i;

        /* renamed from: j  reason: collision with root package name */
        public q00.a<l> f62454j;

        /* renamed from: k  reason: collision with root package name */
        public q00.a<k> f62455k;

        /* renamed from: l  reason: collision with root package name */
        public q00.a<l> f62456l;

        /* renamed from: m  reason: collision with root package name */
        public q00.a<zendesk.belvedere.a> f62457m;

        /* renamed from: n  reason: collision with root package name */
        public q00.a<BelvedereMediaHolder> f62458n;

        public BelvedereMediaHolder a() {
            return this.f62458n.get();
        }

        public Resources b() {
            return this.f62449e.get();
        }

        public zendesk.belvedere.a c() {
            return this.f62457m.get();
        }

        public l d() {
            return this.f62456l.get();
        }

        public Picasso e() {
            return this.f62448d.get();
        }

        public MessagingConfiguration f() {
            return this.f62445a;
        }

        public final void g(Context context, List<c> list, MessagingConfiguration messagingConfiguration) {
            dagger.internal.b a11 = dagger.internal.c.a(context);
            this.f62447c = a11;
            this.f62448d = dagger.internal.a.a(t.a(a11));
            this.f62449e = dagger.internal.a.a(u.a(this.f62447c));
            this.f62450f = dagger.internal.c.a(list);
            this.f62451g = dagger.internal.c.a(messagingConfiguration);
            y a12 = y.a(this.f62447c);
            this.f62452h = a12;
            q00.a<j> a13 = dagger.internal.a.a(p.a(this.f62447c, a12));
            this.f62453i = a13;
            q00.a<l> a14 = dagger.internal.a.a(m.a(a13));
            this.f62454j = a14;
            q00.a<k> a15 = dagger.internal.a.a(q.a(this.f62449e, this.f62450f, this.f62451g, a14));
            this.f62455k = a15;
            this.f62456l = dagger.internal.a.a(v.a(a15));
            this.f62457m = dagger.internal.a.a(s.b(this.f62447c));
            this.f62458n = dagger.internal.a.a(BelvedereMediaHolder_Factory.a());
        }

        public c(Context context, List<c> list, MessagingConfiguration messagingConfiguration) {
            this.f62446b = this;
            this.f62445a = messagingConfiguration;
            g(context, list, messagingConfiguration);
        }
    }

    public static h.a a() {
        return new C0689b();
    }
}
