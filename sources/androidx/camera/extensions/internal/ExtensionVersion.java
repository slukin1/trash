package androidx.camera.extensions.internal;

import androidx.camera.core.Logger;
import androidx.camera.extensions.impl.ExtensionVersionImpl;
import u.c;

public abstract class ExtensionVersion {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ExtensionVersion f5758a;

    public static class a extends ExtensionVersion {
        public c c() {
            return null;
        }
    }

    public static class b extends ExtensionVersion {

        /* renamed from: c  reason: collision with root package name */
        public static ExtensionVersionImpl f5759c;

        /* renamed from: b  reason: collision with root package name */
        public c f5760b;

        public b() {
            if (f5759c == null) {
                f5759c = new ExtensionVersionImpl();
            }
            c j11 = c.j(f5759c.checkApiVersion(u.b.a().d()));
            if (j11 != null && u.b.a().b().g() == j11.g()) {
                this.f5760b = j11;
            }
            Logger.d("ExtenderVersion", "Selected vendor runtime: " + this.f5760b);
        }

        public c c() {
            return this.f5760b;
        }
    }

    public static ExtensionVersion a() {
        if (f5758a != null) {
            return f5758a;
        }
        synchronized (ExtensionVersion.class) {
            if (f5758a == null) {
                try {
                    f5758a = new b();
                } catch (NoClassDefFoundError unused) {
                    Logger.d("ExtenderVersion", "No versioning extender found. Falling back to default.");
                    f5758a = new a();
                }
            }
        }
        return f5758a;
    }

    public static c b() {
        return a().c();
    }

    public static boolean d(c cVar) {
        return b().a(cVar.g(), cVar.h()) >= 0;
    }

    public abstract c c();
}
