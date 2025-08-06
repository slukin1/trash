package androidx.window.layout;

import android.annotation.SuppressLint;
import androidx.window.core.SpecificationComputer;
import androidx.window.core.b;
import androidx.window.core.e;
import androidx.window.layout.j;
import androidx.window.layout.k;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0011B\u0011\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0005J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0012\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ!\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0016\u001a\u00020\u00102\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u001c\u0010\u0017\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019¨\u0006\u001d"}, d2 = {"Landroidx/window/layout/SidecarAdapter;", "", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "sidecarDisplayFeatures", "Landroidx/window/sidecar/SidecarDeviceState;", "deviceState", "Landroidx/window/layout/e;", "f", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "extensionInfo", "state", "Landroidx/window/layout/s;", "e", "first", "second", "", "a", "d", "feature", "g", "(Landroidx/window/sidecar/SidecarDisplayFeature;Landroidx/window/sidecar/SidecarDeviceState;)Landroidx/window/layout/e;", "c", "b", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "Landroidx/window/core/SpecificationComputer$VerificationMode;", "verificationMode", "<init>", "(Landroidx/window/core/SpecificationComputer$VerificationMode;)V", "window_release"}, k = 1, mv = {1, 6, 0})
public final class SidecarAdapter {

    /* renamed from: b  reason: collision with root package name */
    public static final a f12080b = new a((r) null);

    /* renamed from: c  reason: collision with root package name */
    public static final String f12081c = SidecarAdapter.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f12082a;

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0007R\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarAdapter$a;", "", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "info", "", "Landroidx/window/sidecar/SidecarDisplayFeature;", "c", "Landroidx/window/sidecar/SidecarDeviceState;", "sidecarDeviceState", "", "b", "(Landroidx/window/sidecar/SidecarDeviceState;)I", "a", "posture", "", "d", "", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "<init>", "()V", "window_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final int a(SidecarDeviceState sidecarDeviceState) {
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                Object invoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                if (invoke != null) {
                    return ((Integer) invoke).intValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return 0;
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            int a11 = a(sidecarDeviceState);
            if (a11 < 0 || a11 > 4) {
                return 0;
            }
            return a11;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final List<SidecarDisplayFeature> c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            try {
                List<SidecarDisplayFeature> list = sidecarWindowLayoutInfo.displayFeatures;
                return list == null ? CollectionsKt__CollectionsKt.k() : list;
            } catch (NoSuchFieldError unused) {
                Object invoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                if (invoke != null) {
                    return (List) invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return CollectionsKt__CollectionsKt.k();
            }
        }

        @SuppressLint({"BanUncheckedReflection"})
        public final void d(SidecarDeviceState sidecarDeviceState, int i11) {
            try {
                sidecarDeviceState.posture = i11;
            } catch (NoSuchFieldError unused) {
                Class<SidecarDeviceState> cls = SidecarDeviceState.class;
                try {
                    cls.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(sidecarDeviceState, new Object[]{Integer.valueOf(i11)});
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
        }
    }

    public SidecarAdapter() {
        this((SpecificationComputer.VerificationMode) null, 1, (r) null);
    }

    public SidecarAdapter(SpecificationComputer.VerificationMode verificationMode) {
        this.f12082a = verificationMode;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (x.b(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        a aVar = f12080b;
        if (aVar.b(sidecarDeviceState) == aVar.b(sidecarDeviceState2)) {
            return true;
        }
        return false;
    }

    public final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (x.b(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return x.b(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    public final boolean c(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            int i12 = i11 + 1;
            if (!b(list.get(i11), list2.get(i11))) {
                return false;
            }
            i11 = i12;
        }
        return true;
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (x.b(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        a aVar = f12080b;
        return c(aVar.c(sidecarWindowLayoutInfo), aVar.c(sidecarWindowLayoutInfo2));
    }

    public final s e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        if (sidecarWindowLayoutInfo == null) {
            return new s(CollectionsKt__CollectionsKt.k());
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        a aVar = f12080b;
        aVar.d(sidecarDeviceState2, aVar.b(sidecarDeviceState));
        return new s(f(aVar.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final List<e> f(List<SidecarDisplayFeature> list, SidecarDeviceState sidecarDeviceState) {
        ArrayList arrayList = new ArrayList();
        for (SidecarDisplayFeature g11 : list) {
            e g12 = g(g11, sidecarDeviceState);
            if (g12 != null) {
                arrayList.add(g12);
            }
        }
        return arrayList;
    }

    public final e g(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
        k.b bVar;
        j.c cVar;
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) SpecificationComputer.a.b(SpecificationComputer.f12042a, sidecarDisplayFeature, f12081c, this.f12082a, (e) null, 4, (Object) null).c("Type must be either TYPE_FOLD or TYPE_HINGE", SidecarAdapter$translate$checkedFeature$1.INSTANCE).c("Feature bounds must not be 0", SidecarAdapter$translate$checkedFeature$2.INSTANCE).c("TYPE_FOLD must have 0 area", SidecarAdapter$translate$checkedFeature$3.INSTANCE).c("Feature be pinned to either left or top", SidecarAdapter$translate$checkedFeature$4.INSTANCE).a();
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type = sidecarDisplayFeature2.getType();
        if (type == 1) {
            bVar = k.b.f12135b.a();
        } else if (type != 2) {
            return null;
        } else {
            bVar = k.b.f12135b.b();
        }
        int b11 = f12080b.b(sidecarDeviceState);
        if (b11 == 0 || b11 == 1) {
            return null;
        }
        if (b11 == 2) {
            cVar = j.c.f12129d;
        } else if (b11 == 3) {
            cVar = j.c.f12128c;
        } else if (b11 == 4) {
            return null;
        } else {
            cVar = j.c.f12128c;
        }
        return new k(new b(sidecarDisplayFeature.getRect()), bVar, cVar);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SidecarAdapter(SpecificationComputer.VerificationMode verificationMode, int i11, r rVar) {
        this((i11 & 1) != 0 ? SpecificationComputer.VerificationMode.QUIET : verificationMode);
    }
}
