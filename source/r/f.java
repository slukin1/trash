package r;

import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final CaptureSessionOnClosedNotCalledQuirk f16420a;

    @FunctionalInterface
    public interface a {
        void a(SynchronizedCaptureSession synchronizedCaptureSession);
    }

    public f(Quirks quirks) {
        this.f16420a = (CaptureSessionOnClosedNotCalledQuirk) quirks.get(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    public final void a(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.b().n(next);
        }
    }

    public final void b(Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.b().o(next);
        }
    }

    public void c(SynchronizedCaptureSession synchronizedCaptureSession, List<SynchronizedCaptureSession> list, List<SynchronizedCaptureSession> list2, a aVar) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        if (d()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = list.iterator();
            while (it2.hasNext() && (next2 = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            b(linkedHashSet);
        }
        aVar.a(synchronizedCaptureSession);
        if (d()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it3 = list2.iterator();
            while (it3.hasNext() && (next = it3.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            a(linkedHashSet2);
        }
    }

    public boolean d() {
        return this.f16420a != null;
    }
}
