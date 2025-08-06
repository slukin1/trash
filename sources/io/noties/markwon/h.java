package io.noties.markwon;

import io.noties.markwon.g;
import rz.d;

public abstract class h {

    public class a extends h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.b f55303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f55304b;

        public a(g.b bVar, b bVar2) {
            this.f55303a = bVar;
            this.f55304b = bVar2;
        }

        public g a() {
            return this.f55303a.b(this.f55304b, new d());
        }
    }

    public static h b(g.b bVar, b bVar2) {
        return new a(bVar, bVar2);
    }

    public abstract g a();
}
