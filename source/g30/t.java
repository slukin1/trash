package g30;

import android.content.Context;
import com.squareup.picasso.Picasso;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class t implements b<Picasso> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Context> f60312a;

    public t(a<Context> aVar) {
        this.f60312a = aVar;
    }

    public static t a(a<Context> aVar) {
        return new t(aVar);
    }

    public static Picasso c(Context context) {
        return (Picasso) d.f(r.b(context));
    }

    /* renamed from: b */
    public Picasso get() {
        return c(this.f60312a.get());
    }
}
