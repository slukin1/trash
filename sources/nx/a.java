package nx;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class a implements mx.a {

    /* renamed from: a  reason: collision with root package name */
    public final mx.a f29156a;

    /* renamed from: b  reason: collision with root package name */
    public final Comparator<String> f29157b;

    public a(mx.a aVar, Comparator<String> comparator) {
        this.f29156a = aVar;
        this.f29157b = comparator;
    }

    public boolean a(String str, Bitmap bitmap) {
        synchronized (this.f29156a) {
            String str2 = null;
            Iterator<String> it2 = this.f29156a.keys().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (this.f29157b.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f29156a.remove(str2);
            }
        }
        return this.f29156a.a(str, bitmap);
    }

    public Bitmap get(String str) {
        return this.f29156a.get(str);
    }

    public Collection<String> keys() {
        return this.f29156a.keys();
    }

    public Bitmap remove(String str) {
        return this.f29156a.remove(str);
    }
}
