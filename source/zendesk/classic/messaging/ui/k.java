package zendesk.classic.messaging.ui;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.b;
import q00.a;
import zendesk.belvedere.ImageStream;
import zendesk.classic.messaging.BelvedereMediaHolder;

public final class k implements b<j> {

    /* renamed from: a  reason: collision with root package name */
    public final a<AppCompatActivity> f62802a;

    /* renamed from: b  reason: collision with root package name */
    public final a<ImageStream> f62803b;

    /* renamed from: c  reason: collision with root package name */
    public final a<BelvedereMediaHolder> f62804c;

    public k(a<AppCompatActivity> aVar, a<ImageStream> aVar2, a<BelvedereMediaHolder> aVar3) {
        this.f62802a = aVar;
        this.f62803b = aVar2;
        this.f62804c = aVar3;
    }

    public static k a(a<AppCompatActivity> aVar, a<ImageStream> aVar2, a<BelvedereMediaHolder> aVar3) {
        return new k(aVar, aVar2, aVar3);
    }

    public static j c(AppCompatActivity appCompatActivity, ImageStream imageStream, BelvedereMediaHolder belvedereMediaHolder) {
        return new j(appCompatActivity, imageStream, belvedereMediaHolder);
    }

    /* renamed from: b */
    public j get() {
        return c(this.f62802a.get(), this.f62803b.get(), this.f62804c.get());
    }
}
