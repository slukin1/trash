package zendesk.classic.messaging.ui;

import dagger.internal.b;
import g30.f;
import q00.a;
import zendesk.classic.messaging.components.DateProvider;
import zendesk.classic.messaging.e;

public final class q implements b<p> {

    /* renamed from: a  reason: collision with root package name */
    public final a<MessagingCellPropsFactory> f62845a;

    /* renamed from: b  reason: collision with root package name */
    public final a<DateProvider> f62846b;

    /* renamed from: c  reason: collision with root package name */
    public final a<f> f62847c;

    /* renamed from: d  reason: collision with root package name */
    public final a<e> f62848d;

    /* renamed from: e  reason: collision with root package name */
    public final a<c> f62849e;

    /* renamed from: f  reason: collision with root package name */
    public final a<b> f62850f;

    /* renamed from: g  reason: collision with root package name */
    public final a<Boolean> f62851g;

    public q(a<MessagingCellPropsFactory> aVar, a<DateProvider> aVar2, a<f> aVar3, a<e> aVar4, a<c> aVar5, a<b> aVar6, a<Boolean> aVar7) {
        this.f62845a = aVar;
        this.f62846b = aVar2;
        this.f62847c = aVar3;
        this.f62848d = aVar4;
        this.f62849e = aVar5;
        this.f62850f = aVar6;
        this.f62851g = aVar7;
    }

    public static q a(a<MessagingCellPropsFactory> aVar, a<DateProvider> aVar2, a<f> aVar3, a<e> aVar4, a<c> aVar5, a<b> aVar6, a<Boolean> aVar7) {
        return new q(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static p c(MessagingCellPropsFactory messagingCellPropsFactory, DateProvider dateProvider, f fVar, e eVar, Object obj, Object obj2, boolean z11) {
        return new p(messagingCellPropsFactory, dateProvider, fVar, eVar, (c) obj, (b) obj2, z11);
    }

    /* renamed from: b */
    public p get() {
        return c(this.f62845a.get(), this.f62846b.get(), this.f62847c.get(), this.f62848d.get(), this.f62849e.get(), this.f62850f.get(), this.f62851g.get().booleanValue());
    }
}
