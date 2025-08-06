package zendesk.classic.messaging.ui;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.b;
import g30.a0;
import q00.a;
import zendesk.belvedere.ImageStream;
import zendesk.classic.messaging.BelvedereMediaHolder;
import zendesk.classic.messaging.l;

public final class u implements b<t> {

    /* renamed from: a  reason: collision with root package name */
    public final a<AppCompatActivity> f62871a;

    /* renamed from: b  reason: collision with root package name */
    public final a<l> f62872b;

    /* renamed from: c  reason: collision with root package name */
    public final a<ImageStream> f62873c;

    /* renamed from: d  reason: collision with root package name */
    public final a<BelvedereMediaHolder> f62874d;

    /* renamed from: e  reason: collision with root package name */
    public final a<l> f62875e;

    /* renamed from: f  reason: collision with root package name */
    public final a<j> f62876f;

    /* renamed from: g  reason: collision with root package name */
    public final a<a0> f62877g;

    public u(a<AppCompatActivity> aVar, a<l> aVar2, a<ImageStream> aVar3, a<BelvedereMediaHolder> aVar4, a<l> aVar5, a<j> aVar6, a<a0> aVar7) {
        this.f62871a = aVar;
        this.f62872b = aVar2;
        this.f62873c = aVar3;
        this.f62874d = aVar4;
        this.f62875e = aVar5;
        this.f62876f = aVar6;
        this.f62877g = aVar7;
    }

    public static u a(a<AppCompatActivity> aVar, a<l> aVar2, a<ImageStream> aVar3, a<BelvedereMediaHolder> aVar4, a<l> aVar5, a<j> aVar6, a<a0> aVar7) {
        return new u(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static t c(AppCompatActivity appCompatActivity, l lVar, ImageStream imageStream, BelvedereMediaHolder belvedereMediaHolder, l lVar2, Object obj, a0 a0Var) {
        return new t(appCompatActivity, lVar, imageStream, belvedereMediaHolder, lVar2, (j) obj, a0Var);
    }

    /* renamed from: b */
    public t get() {
        return c(this.f62871a.get(), this.f62872b.get(), this.f62873c.get(), this.f62874d.get(), this.f62875e.get(), this.f62876f.get(), this.f62877g.get());
    }
}
