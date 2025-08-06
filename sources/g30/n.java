package g30;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.components.DateProvider;
import zendesk.classic.messaging.i;
import zendesk.classic.messaging.l;

public final class n implements b<i> {

    /* renamed from: a  reason: collision with root package name */
    public final a<AppCompatActivity> f60302a;

    /* renamed from: b  reason: collision with root package name */
    public final a<l> f60303b;

    /* renamed from: c  reason: collision with root package name */
    public final a<DateProvider> f60304c;

    public n(a<AppCompatActivity> aVar, a<l> aVar2, a<DateProvider> aVar3) {
        this.f60302a = aVar;
        this.f60303b = aVar2;
        this.f60304c = aVar3;
    }

    public static n a(a<AppCompatActivity> aVar, a<l> aVar2, a<DateProvider> aVar3) {
        return new n(aVar, aVar2, aVar3);
    }

    public static i c(AppCompatActivity appCompatActivity, l lVar, DateProvider dateProvider) {
        return new i(appCompatActivity, lVar, dateProvider);
    }

    /* renamed from: b */
    public i get() {
        return c(this.f60302a.get(), this.f60303b.get(), this.f60304c.get());
    }
}
