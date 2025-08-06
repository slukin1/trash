package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<c> f10575a = new a();

    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i11, int i12);

        public abstract boolean areItemsTheSame(int i11, int i12);

        public Object getChangePayload(int i11, int i12) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static abstract class ItemCallback<T> {
        public abstract boolean a(T t11, T t12);

        public abstract boolean b(T t11, T t12);

        public Object c(T t11, T t12) {
            return null;
        }
    }

    public static class Range {

        /* renamed from: a  reason: collision with root package name */
        public int f10576a;

        /* renamed from: b  reason: collision with root package name */
        public int f10577b;

        /* renamed from: c  reason: collision with root package name */
        public int f10578c;

        /* renamed from: d  reason: collision with root package name */
        public int f10579d;

        public Range() {
        }

        public int a() {
            return this.f10579d - this.f10578c;
        }

        public int b() {
            return this.f10577b - this.f10576a;
        }

        public Range(int i11, int i12, int i13, int i14) {
            this.f10576a = i11;
            this.f10577b = i12;
            this.f10578c = i13;
            this.f10579d = i14;
        }
    }

    public class a implements Comparator<c> {
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return cVar.f10582a - cVar2.f10582a;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f10580a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10581b;

        public b(int i11) {
            int[] iArr = new int[i11];
            this.f10580a = iArr;
            this.f10581b = iArr.length / 2;
        }

        public int[] a() {
            return this.f10580a;
        }

        public int b(int i11) {
            return this.f10580a[i11 + this.f10581b];
        }

        public void c(int i11, int i12) {
            this.f10580a[i11 + this.f10581b] = i12;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f10582a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10583b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10584c;

        public c(int i11, int i12, int i13) {
            this.f10582a = i11;
            this.f10583b = i12;
            this.f10584c = i13;
        }

        public int a() {
            return this.f10582a + this.f10584c;
        }

        public int b() {
            return this.f10583b + this.f10584c;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final List<c> f10585a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f10586b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f10587c;

        /* renamed from: d  reason: collision with root package name */
        public final Callback f10588d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10589e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10590f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f10591g;

        public d(Callback callback, List<c> list, int[] iArr, int[] iArr2, boolean z11) {
            this.f10585a = list;
            this.f10586b = iArr;
            this.f10587c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f10588d = callback;
            this.f10589e = callback.getOldListSize();
            this.f10590f = callback.getNewListSize();
            this.f10591g = z11;
            a();
            e();
        }

        public static e g(Collection<e> collection, int i11, boolean z11) {
            e eVar;
            Iterator<e> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    eVar = null;
                    break;
                }
                eVar = it2.next();
                if (eVar.f10592a == i11 && eVar.f10594c == z11) {
                    it2.remove();
                    break;
                }
            }
            while (it2.hasNext()) {
                e next = it2.next();
                if (z11) {
                    next.f10593b--;
                } else {
                    next.f10593b++;
                }
            }
            return eVar;
        }

        public final void a() {
            c cVar = this.f10585a.isEmpty() ? null : this.f10585a.get(0);
            if (!(cVar != null && cVar.f10582a == 0 && cVar.f10583b == 0)) {
                this.f10585a.add(0, new c(0, 0, 0));
            }
            this.f10585a.add(new c(this.f10589e, this.f10590f, 0));
        }

        public void b(p pVar) {
            e eVar;
            int i11;
            if (pVar instanceof e) {
                eVar = (e) pVar;
            } else {
                eVar = new e(pVar);
            }
            int i12 = this.f10589e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i13 = this.f10589e;
            int i14 = this.f10590f;
            for (int size = this.f10585a.size() - 1; size >= 0; size--) {
                c cVar = this.f10585a.get(size);
                int a11 = cVar.a();
                int b11 = cVar.b();
                while (true) {
                    if (i13 <= a11) {
                        break;
                    }
                    i13--;
                    int i15 = this.f10586b[i13];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        e g11 = g(arrayDeque, i16, false);
                        if (g11 != null) {
                            int i17 = (i12 - g11.f10593b) - 1;
                            eVar.onMoved(i13, i17);
                            if ((i15 & 4) != 0) {
                                eVar.onChanged(i17, 1, this.f10588d.getChangePayload(i13, i16));
                            }
                        } else {
                            arrayDeque.add(new e(i13, (i12 - i13) - 1, true));
                        }
                    } else {
                        eVar.onRemoved(i13, 1);
                        i12--;
                    }
                }
                while (i14 > b11) {
                    i14--;
                    int i18 = this.f10587c[i14];
                    if ((i18 & 12) != 0) {
                        int i19 = i18 >> 4;
                        e g12 = g(arrayDeque, i19, true);
                        if (g12 == null) {
                            arrayDeque.add(new e(i14, i12 - i13, false));
                        } else {
                            eVar.onMoved((i12 - g12.f10593b) - 1, i13);
                            if ((i18 & 4) != 0) {
                                eVar.onChanged(i13, 1, this.f10588d.getChangePayload(i19, i14));
                            }
                        }
                    } else {
                        eVar.onInserted(i13, 1);
                        i12++;
                    }
                }
                int i21 = cVar.f10582a;
                int i22 = cVar.f10583b;
                for (i11 = 0; i11 < cVar.f10584c; i11++) {
                    if ((this.f10586b[i21] & 15) == 2) {
                        eVar.onChanged(i21, 1, this.f10588d.getChangePayload(i21, i22));
                    }
                    i21++;
                    i22++;
                }
                i13 = cVar.f10582a;
                i14 = cVar.f10583b;
            }
            eVar.a();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new b(adapter));
        }

        public final void d(int i11) {
            int size = this.f10585a.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                c cVar = this.f10585a.get(i13);
                while (i12 < cVar.f10583b) {
                    if (this.f10587c[i12] != 0 || !this.f10588d.areItemsTheSame(i11, i12)) {
                        i12++;
                    } else {
                        int i14 = this.f10588d.areContentsTheSame(i11, i12) ? 8 : 4;
                        this.f10586b[i11] = (i12 << 4) | i14;
                        this.f10587c[i12] = (i11 << 4) | i14;
                        return;
                    }
                }
                i12 = cVar.b();
            }
        }

        public final void e() {
            for (c next : this.f10585a) {
                for (int i11 = 0; i11 < next.f10584c; i11++) {
                    int i12 = next.f10582a + i11;
                    int i13 = next.f10583b + i11;
                    int i14 = this.f10588d.areContentsTheSame(i12, i13) ? 1 : 2;
                    this.f10586b[i12] = (i13 << 4) | i14;
                    this.f10587c[i13] = (i12 << 4) | i14;
                }
            }
            if (this.f10591g) {
                f();
            }
        }

        public final void f() {
            int i11 = 0;
            for (c next : this.f10585a) {
                while (i11 < next.f10582a) {
                    if (this.f10586b[i11] == 0) {
                        d(i11);
                    }
                    i11++;
                }
                i11 = next.a();
            }
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f10592a;

        /* renamed from: b  reason: collision with root package name */
        public int f10593b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10594c;

        public e(int i11, int i12, boolean z11) {
            this.f10592a = i11;
            this.f10593b = i12;
            this.f10594c = z11;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f10595a;

        /* renamed from: b  reason: collision with root package name */
        public int f10596b;

        /* renamed from: c  reason: collision with root package name */
        public int f10597c;

        /* renamed from: d  reason: collision with root package name */
        public int f10598d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10599e;

        public int a() {
            return Math.min(this.f10597c - this.f10595a, this.f10598d - this.f10596b);
        }

        public boolean b() {
            return this.f10598d - this.f10596b != this.f10597c - this.f10595a;
        }

        public boolean c() {
            return this.f10598d - this.f10596b > this.f10597c - this.f10595a;
        }

        public c d() {
            if (!b()) {
                int i11 = this.f10595a;
                return new c(i11, this.f10596b, this.f10597c - i11);
            } else if (this.f10599e) {
                return new c(this.f10595a, this.f10596b, a());
            } else {
                if (c()) {
                    return new c(this.f10595a, this.f10596b + 1, a());
                }
                return new c(this.f10595a + 1, this.f10596b, a());
            }
        }
    }

    public static f a(Range range, Callback callback, b bVar, b bVar2, int i11) {
        int i12;
        int i13;
        int i14;
        boolean z11 = (range.b() - range.a()) % 2 == 0;
        int b11 = range.b() - range.a();
        int i15 = -i11;
        int i16 = i15;
        while (i16 <= i11) {
            if (i16 == i15 || (i16 != i11 && bVar2.b(i16 + 1) < bVar2.b(i16 - 1))) {
                i13 = bVar2.b(i16 + 1);
                i12 = i13;
            } else {
                i13 = bVar2.b(i16 - 1);
                i12 = i13 - 1;
            }
            int i17 = range.f10579d - ((range.f10577b - i12) - i16);
            int i18 = (i11 == 0 || i12 != i13) ? i17 : i17 + 1;
            while (i12 > range.f10576a && i17 > range.f10578c && callback.areItemsTheSame(i12 - 1, i17 - 1)) {
                i12--;
                i17--;
            }
            bVar2.c(i16, i12);
            if (!z11 || (i14 = b11 - i16) < i15 || i14 > i11 || bVar.b(i14) < i12) {
                i16 += 2;
            } else {
                f fVar = new f();
                fVar.f10595a = i12;
                fVar.f10596b = i17;
                fVar.f10597c = i13;
                fVar.f10598d = i18;
                fVar.f10599e = true;
                return fVar;
            }
        }
        return null;
    }

    public static d b(Callback callback) {
        return c(callback, true);
    }

    public static d c(Callback callback, boolean z11) {
        Range range;
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int i11 = ((((oldListSize + newListSize) + 1) / 2) * 2) + 1;
        b bVar = new b(i11);
        b bVar2 = new b(i11);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            f e11 = e(range2, callback, bVar, bVar2);
            if (e11 != null) {
                if (e11.a() > 0) {
                    arrayList.add(e11.d());
                }
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.f10576a = range2.f10576a;
                range.f10578c = range2.f10578c;
                range.f10577b = e11.f10595a;
                range.f10579d = e11.f10596b;
                arrayList2.add(range);
                range2.f10577b = range2.f10577b;
                range2.f10579d = range2.f10579d;
                range2.f10576a = e11.f10597c;
                range2.f10578c = e11.f10598d;
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, f10575a);
        return new d(callback, arrayList, bVar.a(), bVar2.a(), z11);
    }

    public static f d(Range range, Callback callback, b bVar, b bVar2, int i11) {
        int i12;
        int i13;
        int i14;
        boolean z11 = true;
        if (Math.abs(range.b() - range.a()) % 2 != 1) {
            z11 = false;
        }
        int b11 = range.b() - range.a();
        int i15 = -i11;
        int i16 = i15;
        while (i16 <= i11) {
            if (i16 == i15 || (i16 != i11 && bVar.b(i16 + 1) > bVar.b(i16 - 1))) {
                i13 = bVar.b(i16 + 1);
                i12 = i13;
            } else {
                i13 = bVar.b(i16 - 1);
                i12 = i13 + 1;
            }
            int i17 = (range.f10578c + (i12 - range.f10576a)) - i16;
            int i18 = (i11 == 0 || i12 != i13) ? i17 : i17 - 1;
            while (i12 < range.f10577b && i17 < range.f10579d && callback.areItemsTheSame(i12, i17)) {
                i12++;
                i17++;
            }
            bVar.c(i16, i12);
            if (!z11 || (i14 = b11 - i16) < i15 + 1 || i14 > i11 - 1 || bVar2.b(i14) > i12) {
                i16 += 2;
            } else {
                f fVar = new f();
                fVar.f10595a = i13;
                fVar.f10596b = i18;
                fVar.f10597c = i12;
                fVar.f10598d = i17;
                fVar.f10599e = false;
                return fVar;
            }
        }
        return null;
    }

    public static f e(Range range, Callback callback, b bVar, b bVar2) {
        if (range.b() >= 1 && range.a() >= 1) {
            int b11 = ((range.b() + range.a()) + 1) / 2;
            bVar.c(1, range.f10576a);
            bVar2.c(1, range.f10577b);
            for (int i11 = 0; i11 < b11; i11++) {
                f d11 = d(range, callback, bVar, bVar2, i11);
                if (d11 != null) {
                    return d11;
                }
                f a11 = a(range, callback, bVar, bVar2, i11);
                if (a11 != null) {
                    return a11;
                }
            }
        }
        return null;
    }
}
