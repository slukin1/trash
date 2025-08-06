package g30;

import androidx.appcompat.app.AppCompatActivity;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.belvedere.ImageStream;

public final class i implements b<ImageStream> {

    /* renamed from: a  reason: collision with root package name */
    public final a<AppCompatActivity> f60295a;

    public i(a<AppCompatActivity> aVar) {
        this.f60295a = aVar;
    }

    public static ImageStream a(AppCompatActivity appCompatActivity) {
        return (ImageStream) d.f(h.a(appCompatActivity));
    }

    public static i b(a<AppCompatActivity> aVar) {
        return new i(aVar);
    }

    /* renamed from: c */
    public ImageStream get() {
        return a(this.f60295a.get());
    }
}
