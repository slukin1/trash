package w;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.core.util.h;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.a0;
import androidx.lifecycle.u;
import com.google.auto.value.AutoValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Object f16709a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final Map<a, b> f16710b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<b, Set<a>> f16711c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final ArrayDeque<LifecycleOwner> f16712d = new ArrayDeque<>();

    /* renamed from: e  reason: collision with root package name */
    public CameraCoordinator f16713e;

    @AutoValue
    public static abstract class a {
        public static a a(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
            return new a(lifecycleOwner, cameraId);
        }

        public abstract CameraUseCaseAdapter.CameraId b();

        public abstract LifecycleOwner c();
    }

    public static class b implements u {

        /* renamed from: b  reason: collision with root package name */
        public final c f16714b;

        /* renamed from: c  reason: collision with root package name */
        public final LifecycleOwner f16715c;

        public b(LifecycleOwner lifecycleOwner, c cVar) {
            this.f16715c = lifecycleOwner;
            this.f16714b = cVar;
        }

        public LifecycleOwner a() {
            return this.f16715c;
        }

        @a0(Lifecycle.Event.ON_DESTROY)
        public void onDestroy(LifecycleOwner lifecycleOwner) {
            this.f16714b.l(lifecycleOwner);
        }

        @a0(Lifecycle.Event.ON_START)
        public void onStart(LifecycleOwner lifecycleOwner) {
            this.f16714b.h(lifecycleOwner);
        }

        @a0(Lifecycle.Event.ON_STOP)
        public void onStop(LifecycleOwner lifecycleOwner) {
            this.f16714b.i(lifecycleOwner);
        }
    }

    public void a(b bVar, ViewPort viewPort, List<CameraEffect> list, Collection<UseCase> collection, CameraCoordinator cameraCoordinator) {
        synchronized (this.f16709a) {
            h.a(!collection.isEmpty());
            this.f16713e = cameraCoordinator;
            LifecycleOwner c11 = bVar.c();
            Set<a> set = this.f16711c.get(d(c11));
            CameraCoordinator cameraCoordinator2 = this.f16713e;
            if (cameraCoordinator2 == null || cameraCoordinator2.getCameraOperatingMode() != 2) {
                for (a aVar : set) {
                    b bVar2 = (b) h.g(this.f16710b.get(aVar));
                    if (!bVar2.equals(bVar)) {
                        if (!bVar2.d().isEmpty()) {
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                        }
                    }
                }
            }
            try {
                bVar.b().setViewPort(viewPort);
                bVar.b().setEffects(list);
                bVar.a(collection);
                if (c11.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED)) {
                    h(c11);
                }
            } catch (CameraUseCaseAdapter.CameraException e11) {
                throw new IllegalArgumentException(e11.getMessage());
            }
        }
    }

    public b b(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        b bVar;
        synchronized (this.f16709a) {
            h.b(this.f16710b.get(a.a(lifecycleOwner, cameraUseCaseAdapter.getCameraId())) == null, "LifecycleCamera already exists for the given LifecycleOwner and set of cameras");
            if (lifecycleOwner.getLifecycle().b() != Lifecycle.State.DESTROYED) {
                bVar = new b(lifecycleOwner, cameraUseCaseAdapter);
                if (cameraUseCaseAdapter.getUseCases().isEmpty()) {
                    bVar.f();
                }
                g(bVar);
            } else {
                throw new IllegalArgumentException("Trying to create LifecycleCamera with destroyed lifecycle.");
            }
        }
        return bVar;
    }

    public b c(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter.CameraId cameraId) {
        b bVar;
        synchronized (this.f16709a) {
            bVar = this.f16710b.get(a.a(lifecycleOwner, cameraId));
        }
        return bVar;
    }

    public final b d(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            for (b next : this.f16711c.keySet()) {
                if (lifecycleOwner.equals(next.a())) {
                    return next;
                }
            }
            return null;
        }
    }

    public Collection<b> e() {
        Collection<b> unmodifiableCollection;
        synchronized (this.f16709a) {
            unmodifiableCollection = Collections.unmodifiableCollection(this.f16710b.values());
        }
        return unmodifiableCollection;
    }

    public final boolean f(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            b d11 = d(lifecycleOwner);
            if (d11 == null) {
                return false;
            }
            for (a aVar : this.f16711c.get(d11)) {
                if (!((b) h.g(this.f16710b.get(aVar))).d().isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void g(b bVar) {
        Set set;
        synchronized (this.f16709a) {
            LifecycleOwner c11 = bVar.c();
            a a11 = a.a(c11, bVar.b().getCameraId());
            b d11 = d(c11);
            if (d11 != null) {
                set = this.f16711c.get(d11);
            } else {
                set = new HashSet();
            }
            set.add(a11);
            this.f16710b.put(a11, bVar);
            if (d11 == null) {
                b bVar2 = new b(c11, this);
                this.f16711c.put(bVar2, set);
                c11.getLifecycle().a(bVar2);
            }
        }
    }

    public void h(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            if (f(lifecycleOwner)) {
                if (this.f16712d.isEmpty()) {
                    this.f16712d.push(lifecycleOwner);
                } else {
                    CameraCoordinator cameraCoordinator = this.f16713e;
                    if (cameraCoordinator == null || cameraCoordinator.getCameraOperatingMode() != 2) {
                        LifecycleOwner peek = this.f16712d.peek();
                        if (!lifecycleOwner.equals(peek)) {
                            j(peek);
                            this.f16712d.remove(lifecycleOwner);
                            this.f16712d.push(lifecycleOwner);
                        }
                    }
                }
                m(lifecycleOwner);
            }
        }
    }

    public void i(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            this.f16712d.remove(lifecycleOwner);
            j(lifecycleOwner);
            if (!this.f16712d.isEmpty()) {
                m(this.f16712d.peek());
            }
        }
    }

    public final void j(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            b d11 = d(lifecycleOwner);
            if (d11 != null) {
                for (a aVar : this.f16711c.get(d11)) {
                    ((b) h.g(this.f16710b.get(aVar))).f();
                }
            }
        }
    }

    public void k() {
        synchronized (this.f16709a) {
            for (a aVar : this.f16710b.keySet()) {
                b bVar = this.f16710b.get(aVar);
                bVar.g();
                i(bVar.c());
            }
        }
    }

    public void l(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            b d11 = d(lifecycleOwner);
            if (d11 != null) {
                i(lifecycleOwner);
                for (a remove : this.f16711c.get(d11)) {
                    this.f16710b.remove(remove);
                }
                this.f16711c.remove(d11);
                d11.a().getLifecycle().d(d11);
            }
        }
    }

    public final void m(LifecycleOwner lifecycleOwner) {
        synchronized (this.f16709a) {
            for (a aVar : this.f16711c.get(d(lifecycleOwner))) {
                b bVar = this.f16710b.get(aVar);
                if (!((b) h.g(bVar)).d().isEmpty()) {
                    bVar.h();
                }
            }
        }
    }
}
