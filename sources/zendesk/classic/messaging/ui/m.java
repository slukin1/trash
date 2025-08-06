package zendesk.classic.messaging.ui;

import dagger.internal.b;
import g30.c;
import g30.f;
import q00.a;
import zendesk.belvedere.ImageStream;
import zendesk.classic.messaging.BelvedereMediaHolder;
import zendesk.classic.messaging.e;

public final class m implements b<l> {

    /* renamed from: a  reason: collision with root package name */
    public final a<f> f62811a;

    /* renamed from: b  reason: collision with root package name */
    public final a<e> f62812b;

    /* renamed from: c  reason: collision with root package name */
    public final a<ImageStream> f62813c;

    /* renamed from: d  reason: collision with root package name */
    public final a<zendesk.belvedere.a> f62814d;

    /* renamed from: e  reason: collision with root package name */
    public final a<BelvedereMediaHolder> f62815e;

    /* renamed from: f  reason: collision with root package name */
    public final a<c> f62816f;

    public m(a<f> aVar, a<e> aVar2, a<ImageStream> aVar3, a<zendesk.belvedere.a> aVar4, a<BelvedereMediaHolder> aVar5, a<c> aVar6) {
        this.f62811a = aVar;
        this.f62812b = aVar2;
        this.f62813c = aVar3;
        this.f62814d = aVar4;
        this.f62815e = aVar5;
        this.f62816f = aVar6;
    }

    public static m a(a<f> aVar, a<e> aVar2, a<ImageStream> aVar3, a<zendesk.belvedere.a> aVar4, a<BelvedereMediaHolder> aVar5, a<c> aVar6) {
        return new m(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static l c(f fVar, e eVar, ImageStream imageStream, zendesk.belvedere.a aVar, BelvedereMediaHolder belvedereMediaHolder, c cVar) {
        return new l(fVar, eVar, imageStream, aVar, belvedereMediaHolder, cVar);
    }

    /* renamed from: b */
    public l get() {
        return c(this.f62811a.get(), this.f62812b.get(), this.f62813c.get(), this.f62814d.get(), this.f62815e.get(), this.f62816f.get());
    }
}
