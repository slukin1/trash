package zendesk.classic.messaging.ui;

import android.content.res.Resources;
import dagger.internal.b;
import q00.a;

public final class s implements b<MessagingCellPropsFactory> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Resources> f62855a;

    public s(a<Resources> aVar) {
        this.f62855a = aVar;
    }

    public static s a(a<Resources> aVar) {
        return new s(aVar);
    }

    public static MessagingCellPropsFactory c(Resources resources) {
        return new MessagingCellPropsFactory(resources);
    }

    /* renamed from: b */
    public MessagingCellPropsFactory get() {
        return c(this.f62855a.get());
    }
}
