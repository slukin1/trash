package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class x {

    /* renamed from: b  reason: collision with root package name */
    public static final Map<v, Range<Integer>> f6386b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Integer, Rational> f6387c;

    /* renamed from: a  reason: collision with root package name */
    public final Map<a, List<Size>> f6388a = new HashMap();

    @AutoValue
    public static abstract class a {
        public static a c(v vVar, int i11) {
            return new i(vVar, i11);
        }

        public abstract int a();

        public abstract v b();
    }

    static {
        HashMap hashMap = new HashMap();
        f6386b = hashMap;
        hashMap.put(v.f6368d, Range.create(2160, 4319));
        hashMap.put(v.f6367c, Range.create(1080, 1439));
        hashMap.put(v.f6366b, Range.create(720, 1079));
        hashMap.put(v.f6365a, Range.create(241, 719));
        HashMap hashMap2 = new HashMap();
        f6387c = hashMap2;
        hashMap2.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        hashMap2.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    public x(List<Size> list, Map<v, Size> map) {
        for (v next : f6386b.keySet()) {
            this.f6388a.put(a.c(next, -1), new ArrayList());
            for (Integer intValue : f6387c.keySet()) {
                this.f6388a.put(a.c(next, intValue.intValue()), new ArrayList());
            }
        }
        b(map);
        c(list);
        i(map);
    }

    public static Integer d(Size size) {
        for (Map.Entry next : f6387c.entrySet()) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) next.getValue(), SizeUtil.RESOLUTION_QVGA)) {
                return (Integer) next.getKey();
            }
        }
        return null;
    }

    public static v e(Size size) {
        for (Map.Entry next : f6386b.entrySet()) {
            if (((Range) next.getValue()).contains(Integer.valueOf(size.getHeight()))) {
                return (v) next.getKey();
            }
        }
        return null;
    }

    public static /* synthetic */ int h(int i11, Size size, Size size2) {
        return Math.abs(SizeUtil.getArea(size) - i11) - Math.abs(SizeUtil.getArea(size2) - i11);
    }

    public final void b(Map<v, Size> map) {
        for (Map.Entry next : map.entrySet()) {
            List<Size> f11 = f((v) next.getKey(), -1);
            Objects.requireNonNull(f11);
            f11.add((Size) next.getValue());
        }
    }

    public final void c(List<Size> list) {
        Integer d11;
        for (Size next : list) {
            v e11 = e(next);
            if (!(e11 == null || (d11 = d(next)) == null)) {
                List<Size> f11 = f(e11, d11.intValue());
                Objects.requireNonNull(f11);
                f11.add(next);
            }
        }
    }

    public final List<Size> f(v vVar, int i11) {
        return this.f6388a.get(a.c(vVar, i11));
    }

    public List<Size> g(v vVar, int i11) {
        ArrayList arrayList;
        List<Size> f11 = f(vVar, i11);
        if (f11 == null) {
            arrayList = new ArrayList(0);
        }
        return arrayList;
    }

    public final void i(Map<v, Size> map) {
        for (Map.Entry next : this.f6388a.entrySet()) {
            Size size = map.get(((a) next.getKey()).b());
            if (size != null) {
                Collections.sort((List) next.getValue(), new w(SizeUtil.getArea(size)));
            }
        }
    }
}
