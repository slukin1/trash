package androidx.lifecycle.viewmodel;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class CreationExtras {

    /* renamed from: a  reason: collision with root package name */
    public final Map<b<?>, Object> f10039a = new LinkedHashMap();

    public static final class a extends CreationExtras {

        /* renamed from: b  reason: collision with root package name */
        public static final a f10040b = new a();

        public <T> T a(b<T> bVar) {
            return null;
        }
    }

    public interface b<T> {
    }

    public abstract <T> T a(b<T> bVar);

    public final Map<b<?>, Object> b() {
        return this.f10039a;
    }
}
