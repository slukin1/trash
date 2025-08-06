package g30;

import android.content.res.Resources;
import dagger.internal.b;
import java.util.List;
import q00.a;
import zendesk.classic.messaging.MessagingConfiguration;
import zendesk.classic.messaging.c;
import zendesk.classic.messaging.k;

public final class q implements b<k> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Resources> f60307a;

    /* renamed from: b  reason: collision with root package name */
    public final a<List<c>> f60308b;

    /* renamed from: c  reason: collision with root package name */
    public final a<MessagingConfiguration> f60309c;

    /* renamed from: d  reason: collision with root package name */
    public final a<l> f60310d;

    public q(a<Resources> aVar, a<List<c>> aVar2, a<MessagingConfiguration> aVar3, a<l> aVar4) {
        this.f60307a = aVar;
        this.f60308b = aVar2;
        this.f60309c = aVar3;
        this.f60310d = aVar4;
    }

    public static q a(a<Resources> aVar, a<List<c>> aVar2, a<MessagingConfiguration> aVar3, a<l> aVar4) {
        return new q(aVar, aVar2, aVar3, aVar4);
    }

    public static k c(Resources resources, List<c> list, MessagingConfiguration messagingConfiguration, Object obj) {
        return new k(resources, list, messagingConfiguration, (l) obj);
    }

    /* renamed from: b */
    public k get() {
        return c(this.f60307a.get(), this.f60308b.get(), this.f60309c.get(), this.f60310d.get());
    }
}
