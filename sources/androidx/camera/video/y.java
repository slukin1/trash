package androidx.camera.video;

import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.o;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    public final List<v> f6391a;

    /* renamed from: b  reason: collision with root package name */
    public final o f6392b;

    public y(List<v> list, o oVar) {
        h.b(!list.isEmpty() || oVar != o.f6331a, "No preferred quality and fallback strategy.");
        this.f6391a = Collections.unmodifiableList(new ArrayList(list));
        this.f6392b = oVar;
    }

    public static void b(v vVar) {
        boolean a11 = v.a(vVar);
        h.b(a11, "Invalid quality: " + vVar);
    }

    public static void c(List<v> list) {
        for (v next : list) {
            boolean a11 = v.a(next);
            h.b(a11, "qualities contain invalid quality: " + next);
        }
    }

    public static y d(v vVar, o oVar) {
        h.h(vVar, "quality cannot be null");
        h.h(oVar, "fallbackStrategy cannot be null");
        b(vVar);
        return new y(Collections.singletonList(vVar), oVar);
    }

    public static y e(List<v> list, o oVar) {
        h.h(list, "qualities cannot be null");
        h.h(oVar, "fallbackStrategy cannot be null");
        h.b(!list.isEmpty(), "qualities cannot be empty");
        c(list);
        return new y(list, oVar);
    }

    public static Size g(VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.VideoProfileProxy d11 = videoValidatedEncoderProfilesProxy.d();
        return new Size(d11.getWidth(), d11.getHeight());
    }

    public static Map<v, Size> h(c1 c1Var, DynamicRange dynamicRange) {
        HashMap hashMap = new HashMap();
        for (v next : c1Var.c(dynamicRange)) {
            VideoValidatedEncoderProfilesProxy d11 = c1Var.d(next, dynamicRange);
            Objects.requireNonNull(d11);
            hashMap.put(next, g(d11));
        }
        return hashMap;
    }

    public final void a(List<v> list, Set<v> set) {
        v vVar;
        if (!list.isEmpty() && !set.containsAll(list)) {
            Logger.d("QualitySelector", "Select quality by fallbackStrategy = " + this.f6392b);
            o oVar = this.f6392b;
            if (oVar != o.f6331a) {
                h.j(oVar instanceof o.b, "Currently only support type RuleStrategy");
                o.b bVar = (o.b) this.f6392b;
                List<v> b11 = v.b();
                boolean z11 = false;
                if (bVar.b() == v.f6370f) {
                    vVar = b11.get(0);
                } else if (bVar.b() == v.f6369e) {
                    vVar = b11.get(b11.size() - 1);
                } else {
                    vVar = bVar.b();
                }
                int indexOf = b11.indexOf(vVar);
                if (indexOf != -1) {
                    z11 = true;
                }
                h.i(z11);
                ArrayList arrayList = new ArrayList();
                for (int i11 = indexOf - 1; i11 >= 0; i11--) {
                    v vVar2 = b11.get(i11);
                    if (list.contains(vVar2)) {
                        arrayList.add(vVar2);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i12 = indexOf + 1; i12 < b11.size(); i12++) {
                    v vVar3 = b11.get(i12);
                    if (list.contains(vVar3)) {
                        arrayList2.add(vVar3);
                    }
                }
                Logger.d("QualitySelector", "sizeSortedQualities = " + b11 + ", fallback quality = " + vVar + ", largerQualities = " + arrayList + ", smallerQualities = " + arrayList2);
                int c11 = bVar.c();
                if (c11 == 0) {
                    return;
                }
                if (c11 == 1) {
                    set.addAll(arrayList);
                    set.addAll(arrayList2);
                } else if (c11 == 2) {
                    set.addAll(arrayList);
                } else if (c11 == 3) {
                    set.addAll(arrayList2);
                    set.addAll(arrayList);
                } else if (c11 == 4) {
                    set.addAll(arrayList2);
                } else {
                    throw new AssertionError("Unhandled fallback strategy: " + this.f6392b);
                }
            }
        }
    }

    public List<v> f(List<v> list) {
        if (list.isEmpty()) {
            Logger.w("QualitySelector", "No supported quality on the device.");
            return new ArrayList();
        }
        Logger.d("QualitySelector", "supportedQualities = " + list);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<v> it2 = this.f6391a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            v next = it2.next();
            if (next == v.f6370f) {
                linkedHashSet.addAll(list);
                break;
            } else if (next == v.f6369e) {
                ArrayList arrayList = new ArrayList(list);
                Collections.reverse(arrayList);
                linkedHashSet.addAll(arrayList);
                break;
            } else if (list.contains(next)) {
                linkedHashSet.add(next);
            } else {
                Logger.w("QualitySelector", "quality is not supported and will be ignored: " + next);
            }
        }
        a(list, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    public String toString() {
        return "QualitySelector{preferredQualities=" + this.f6391a + ", fallbackStrategy=" + this.f6392b + "}";
    }
}
