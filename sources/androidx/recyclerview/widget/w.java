package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.e;
import androidx.core.util.f;
import androidx.recyclerview.widget.RecyclerView;

public class w {

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<RecyclerView.ViewHolder, a> f10926a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final LongSparseArray<RecyclerView.ViewHolder> f10927b = new LongSparseArray<>();

    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static e<a> f10928d = new f(20);

        /* renamed from: a  reason: collision with root package name */
        public int f10929a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f10930b;

        /* renamed from: c  reason: collision with root package name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f10931c;

        public static void a() {
            do {
            } while (f10928d.acquire() != null);
        }

        public static a b() {
            a acquire = f10928d.acquire();
            return acquire == null ? new a() : acquire;
        }

        public static void c(a aVar) {
            aVar.f10929a = 0;
            aVar.f10930b = null;
            aVar.f10931c = null;
            f10928d.release(aVar);
        }
    }

    public interface b {
        void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void b(RecyclerView.ViewHolder viewHolder);

        void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);
    }

    public void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.f10926a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f10926a.put(viewHolder, aVar);
        }
        aVar.f10929a |= 2;
        aVar.f10930b = itemHolderInfo;
    }

    public void b(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.f10926a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f10926a.put(viewHolder, aVar);
        }
        aVar.f10929a |= 1;
    }

    public void c(long j11, RecyclerView.ViewHolder viewHolder) {
        this.f10927b.l(j11, viewHolder);
    }

    public void d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.f10926a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f10926a.put(viewHolder, aVar);
        }
        aVar.f10931c = itemHolderInfo;
        aVar.f10929a |= 8;
    }

    public void e(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        a aVar = this.f10926a.get(viewHolder);
        if (aVar == null) {
            aVar = a.b();
            this.f10926a.put(viewHolder, aVar);
        }
        aVar.f10930b = itemHolderInfo;
        aVar.f10929a |= 4;
    }

    public void f() {
        this.f10926a.clear();
        this.f10927b.c();
    }

    public RecyclerView.ViewHolder g(long j11) {
        return this.f10927b.g(j11);
    }

    public boolean h(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.f10926a.get(viewHolder);
        if (aVar == null || (aVar.f10929a & 1) == 0) {
            return false;
        }
        return true;
    }

    public boolean i(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.f10926a.get(viewHolder);
        return (aVar == null || (aVar.f10929a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.ViewHolder viewHolder) {
        p(viewHolder);
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo l(RecyclerView.ViewHolder viewHolder, int i11) {
        a p11;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        int i12 = this.f10926a.i(viewHolder);
        if (i12 >= 0 && (p11 = this.f10926a.p(i12)) != null) {
            int i13 = p11.f10929a;
            if ((i13 & i11) != 0) {
                int i14 = (~i11) & i13;
                p11.f10929a = i14;
                if (i11 == 4) {
                    itemHolderInfo = p11.f10930b;
                } else if (i11 == 8) {
                    itemHolderInfo = p11.f10931c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i14 & 12) == 0) {
                    this.f10926a.n(i12);
                    a.c(p11);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo m(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 8);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo n(RecyclerView.ViewHolder viewHolder) {
        return l(viewHolder, 4);
    }

    public void o(b bVar) {
        for (int size = this.f10926a.size() - 1; size >= 0; size--) {
            RecyclerView.ViewHolder l11 = this.f10926a.l(size);
            a n11 = this.f10926a.n(size);
            int i11 = n11.f10929a;
            if ((i11 & 3) == 3) {
                bVar.b(l11);
            } else if ((i11 & 1) != 0) {
                RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo = n11.f10930b;
                if (itemHolderInfo == null) {
                    bVar.b(l11);
                } else {
                    bVar.c(l11, itemHolderInfo, n11.f10931c);
                }
            } else if ((i11 & 14) == 14) {
                bVar.a(l11, n11.f10930b, n11.f10931c);
            } else if ((i11 & 12) == 12) {
                bVar.d(l11, n11.f10930b, n11.f10931c);
            } else if ((i11 & 4) != 0) {
                bVar.c(l11, n11.f10930b, (RecyclerView.ItemAnimator.ItemHolderInfo) null);
            } else if ((i11 & 8) != 0) {
                bVar.a(l11, n11.f10930b, n11.f10931c);
            }
            a.c(n11);
        }
    }

    public void p(RecyclerView.ViewHolder viewHolder) {
        a aVar = this.f10926a.get(viewHolder);
        if (aVar != null) {
            aVar.f10929a &= -2;
        }
    }

    public void q(RecyclerView.ViewHolder viewHolder) {
        int o11 = this.f10927b.o() - 1;
        while (true) {
            if (o11 < 0) {
                break;
            } else if (viewHolder == this.f10927b.p(o11)) {
                this.f10927b.n(o11);
                break;
            } else {
                o11--;
            }
        }
        a remove = this.f10926a.remove(viewHolder);
        if (remove != null) {
            a.c(remove);
        }
    }
}
