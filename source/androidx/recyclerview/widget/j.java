package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.core.os.n;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class j implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public static final ThreadLocal<j> f10885f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    public static Comparator<c> f10886g = new a();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<RecyclerView> f10887b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public long f10888c;

    /* renamed from: d  reason: collision with root package name */
    public long f10889d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c> f10890e = new ArrayList<>();

    public class a implements Comparator<c> {
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f10898d;
            if ((recyclerView == null) != (cVar2.f10898d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z11 = cVar.f10895a;
            if (z11 == cVar2.f10895a) {
                int i11 = cVar2.f10896b - cVar.f10896b;
                if (i11 != 0) {
                    return i11;
                }
                int i12 = cVar.f10897c - cVar2.f10897c;
                if (i12 != 0) {
                    return i12;
                }
                return 0;
            } else if (z11) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.LayoutManager.c {

        /* renamed from: a  reason: collision with root package name */
        public int f10891a;

        /* renamed from: b  reason: collision with root package name */
        public int f10892b;

        /* renamed from: c  reason: collision with root package name */
        public int[] f10893c;

        /* renamed from: d  reason: collision with root package name */
        public int f10894d;

        public void a(int i11, int i12) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i12 >= 0) {
                int i13 = this.f10894d * 2;
                int[] iArr = this.f10893c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f10893c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i13 >= iArr.length) {
                    int[] iArr3 = new int[(i13 * 2)];
                    this.f10893c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f10893c;
                iArr4[i13] = i11;
                iArr4[i13 + 1] = i12;
                this.f10894d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public void b() {
            int[] iArr = this.f10893c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f10894d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z11) {
            this.f10894d = 0;
            int[] iArr = this.f10893c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z11) {
                    if (!recyclerView.mAdapterHelper.p()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.f10891a, this.f10892b, recyclerView.mState, this);
                }
                int i11 = this.f10894d;
                if (i11 > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i11;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z11;
                    recyclerView.mRecycler.P();
                }
            }
        }

        public boolean d(int i11) {
            if (this.f10893c != null) {
                int i12 = this.f10894d * 2;
                for (int i13 = 0; i13 < i12; i13 += 2) {
                    if (this.f10893c[i13] == i11) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i11, int i12) {
            this.f10891a = i11;
            this.f10892b = i12;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10895a;

        /* renamed from: b  reason: collision with root package name */
        public int f10896b;

        /* renamed from: c  reason: collision with root package name */
        public int f10897c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f10898d;

        /* renamed from: e  reason: collision with root package name */
        public int f10899e;

        public void a() {
            this.f10895a = false;
            this.f10896b = 0;
            this.f10897c = 0;
            this.f10898d = null;
            this.f10899e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i11) {
        int j11 = recyclerView.mChildHelper.j();
        for (int i12 = 0; i12 < j11; i12++) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i12));
            if (childViewHolderInt.mPosition == i11 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        if (!RecyclerView.sDebugAssertionsEnabled || !this.f10887b.contains(recyclerView)) {
            this.f10887b.add(recyclerView);
            return;
        }
        throw new IllegalStateException("RecyclerView already present in worker list!");
    }

    public final void b() {
        c cVar;
        int size = this.f10887b.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView recyclerView = this.f10887b.get(i12);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i11 += recyclerView.mPrefetchRegistry.f10894d;
            }
        }
        this.f10890e.ensureCapacity(i11);
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            RecyclerView recyclerView2 = this.f10887b.get(i14);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int abs = Math.abs(bVar.f10891a) + Math.abs(bVar.f10892b);
                for (int i15 = 0; i15 < bVar.f10894d * 2; i15 += 2) {
                    if (i13 >= this.f10890e.size()) {
                        cVar = new c();
                        this.f10890e.add(cVar);
                    } else {
                        cVar = this.f10890e.get(i13);
                    }
                    int[] iArr = bVar.f10893c;
                    int i16 = iArr[i15 + 1];
                    cVar.f10895a = i16 <= abs;
                    cVar.f10896b = abs;
                    cVar.f10897c = i16;
                    cVar.f10898d = recyclerView2;
                    cVar.f10899e = iArr[i15];
                    i13++;
                }
            }
        }
        Collections.sort(this.f10890e, f10886g);
    }

    public final void c(c cVar, long j11) {
        RecyclerView.ViewHolder i11 = i(cVar.f10898d, cVar.f10899e, cVar.f10895a ? Long.MAX_VALUE : j11);
        if (i11 != null && i11.mNestedRecyclerView != null && i11.isBound() && !i11.isInvalid()) {
            h((RecyclerView) i11.mNestedRecyclerView.get(), j11);
        }
    }

    public final void d(long j11) {
        int i11 = 0;
        while (i11 < this.f10890e.size()) {
            c cVar = this.f10890e.get(i11);
            if (cVar.f10898d != null) {
                c(cVar, j11);
                cVar.a();
                i11++;
            } else {
                return;
            }
        }
    }

    public void f(RecyclerView recyclerView, int i11, int i12) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.f10887b.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            } else if (this.f10888c == 0) {
                this.f10888c = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.mPrefetchRegistry.e(i11, i12);
    }

    public void g(long j11) {
        b();
        d(j11);
    }

    public final void h(RecyclerView recyclerView, long j11) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            b bVar = recyclerView.mPrefetchRegistry;
            bVar.c(recyclerView, true);
            if (bVar.f10894d != 0) {
                try {
                    n.a(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                    recyclerView.mState.f(recyclerView.mAdapter);
                    for (int i11 = 0; i11 < bVar.f10894d * 2; i11 += 2) {
                        i(recyclerView, bVar.f10893c[i11], j11);
                    }
                } finally {
                    n.b();
                }
            }
        }
    }

    public final RecyclerView.ViewHolder i(RecyclerView recyclerView, int i11, long j11) {
        if (e(recyclerView, i11)) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder N = recycler.N(i11, false, j11);
            if (N != null) {
                if (!N.isBound() || N.isInvalid()) {
                    recycler.a(N, false);
                } else {
                    recycler.G(N.itemView);
                }
            }
            return N;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void j(RecyclerView recyclerView) {
        boolean remove = this.f10887b.remove(recyclerView);
        if (RecyclerView.sDebugAssertionsEnabled && !remove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    public void run() {
        try {
            n.a(RecyclerView.TRACE_PREFETCH_TAG);
            if (!this.f10887b.isEmpty()) {
                int size = this.f10887b.size();
                long j11 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    RecyclerView recyclerView = this.f10887b.get(i11);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j11 = Math.max(recyclerView.getDrawingTime(), j11);
                    }
                }
                if (j11 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j11) + this.f10889d);
                    this.f10888c = 0;
                    n.b();
                }
            }
        } finally {
            this.f10888c = 0;
            n.b();
        }
    }
}
