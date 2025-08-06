package b00;

import java.util.ArrayList;
import java.util.List;
import rz.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<d20.a> f53447a = new ArrayList(2);

    /* renamed from: b  reason: collision with root package name */
    public boolean f53448b;

    public void a(int i11, char c11, char c12, e eVar) {
        c();
        this.f53447a.add(new b(c11, c12, i11, eVar));
    }

    public List<d20.a> b() {
        c();
        this.f53448b = true;
        return this.f53447a;
    }

    public final void c() {
        if (this.f53448b) {
            throw new IllegalStateException("SimpleExtBuilder is already built, do not mutate SimpleExtPlugin after configuration is finished");
        }
    }
}
