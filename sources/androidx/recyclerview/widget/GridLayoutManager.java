package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: b  reason: collision with root package name */
    public boolean f10600b = false;

    /* renamed from: c  reason: collision with root package name */
    public int f10601c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int[] f10602d;

    /* renamed from: e  reason: collision with root package name */
    public View[] f10603e;

    /* renamed from: f  reason: collision with root package name */
    public final SparseIntArray f10604f = new SparseIntArray();

    /* renamed from: g  reason: collision with root package name */
    public final SparseIntArray f10605g = new SparseIntArray();

    /* renamed from: h  reason: collision with root package name */
    public SpanSizeLookup f10606h = new DefaultSpanSizeLookup();

    /* renamed from: i  reason: collision with root package name */
    public final Rect f10607i = new Rect();

    /* renamed from: j  reason: collision with root package name */
    public boolean f10608j;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i11, int i12) {
            return i11 % i12;
        }

        public int getSpanSize(int i11) {
            return 1;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        public final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        public final SparseIntArray mSpanIndexCache = new SparseIntArray();

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i11) {
            int size = sparseIntArray.size() - 1;
            int i12 = 0;
            while (i12 <= size) {
                int i13 = (i12 + size) >>> 1;
                if (sparseIntArray.keyAt(i13) < i11) {
                    i12 = i13 + 1;
                } else {
                    size = i13 - 1;
                }
            }
            int i14 = i12 - 1;
            if (i14 < 0 || i14 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i14);
        }

        public int getCachedSpanGroupIndex(int i11, int i12) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i11, i12);
            }
            int i13 = this.mSpanGroupIndexCache.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int spanGroupIndex = getSpanGroupIndex(i11, i12);
            this.mSpanGroupIndexCache.put(i11, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i11, int i12) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i11, i12);
            }
            int i13 = this.mSpanIndexCache.get(i11, -1);
            if (i13 != -1) {
                return i13;
            }
            int spanIndex = getSpanIndex(i11, i12);
            this.mSpanIndexCache.put(i11, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i11)) == -1) {
                i15 = 0;
                i14 = 0;
                i13 = 0;
            } else {
                i15 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i14 = findFirstKeyLessThan + 1;
                i13 = getCachedSpanIndex(findFirstKeyLessThan, i12) + getSpanSize(findFirstKeyLessThan);
                if (i13 == i12) {
                    i15++;
                    i13 = 0;
                }
            }
            int spanSize = getSpanSize(i11);
            while (i14 < i11) {
                int spanSize2 = getSpanSize(i14);
                int i16 = i13 + spanSize2;
                if (i16 == i12) {
                    i15++;
                    i16 = 0;
                } else if (i16 > i12) {
                    i15++;
                    i16 = spanSize2;
                }
                i14++;
            }
            return i13 + spanSize > i12 ? i15 + 1 : i15;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = r1
                r3 = r2
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = r1
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i11);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z11) {
            if (!z11) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z11;
        }

        public void setSpanIndexCacheEnabled(boolean z11) {
            if (!z11) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z11;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        s(RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12).spanCount);
    }

    public static int[] d(int[] iArr, int i11, int i12) {
        int i13;
        if (!(iArr != null && iArr.length == i11 + 1 && iArr[iArr.length - 1] == i12)) {
            iArr = new int[(i11 + 1)];
        }
        int i14 = 0;
        iArr[0] = 0;
        int i15 = i12 / i11;
        int i16 = i12 % i11;
        int i17 = 0;
        for (int i18 = 1; i18 <= i11; i18++) {
            i14 += i16;
            if (i14 <= 0 || i11 - i14 >= i16) {
                i13 = i15;
            } else {
                i13 = i15 + 1;
                i14 -= i11;
            }
            i17 += i13;
            iArr[i18] = i17;
        }
        return iArr;
    }

    public final void a(RecyclerView.Recycler recycler, RecyclerView.State state, int i11, boolean z11) {
        int i12;
        int i13;
        int i14 = 0;
        int i15 = -1;
        if (z11) {
            i12 = 1;
            i15 = i11;
            i13 = 0;
        } else {
            i13 = i11 - 1;
            i12 = -1;
        }
        while (i13 != i15) {
            View view = this.f10603e[i13];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int n11 = n(recycler, state, getPosition(view));
            layoutParams.f10610b = n11;
            layoutParams.f10609a = i14;
            i14 += n11;
            i13 += i12;
        }
    }

    public final void b() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i11).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.f10604f.put(viewLayoutPosition, layoutParams.b());
            this.f10605g.put(viewLayoutPosition, layoutParams.a());
        }
    }

    public final void c(int i11) {
        this.f10602d = d(this.f10602d, this.f10601c, i11);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.c cVar, RecyclerView.LayoutManager.c cVar2) {
        int i11 = this.f10601c;
        for (int i12 = 0; i12 < this.f10601c && cVar.c(state) && i11 > 0; i12++) {
            int i13 = cVar.f10675d;
            cVar2.a(i13, Math.max(0, cVar.f10678g));
            i11 -= this.f10606h.getSpanSize(i13);
            cVar.f10675d += cVar.f10676e;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        if (this.f10608j) {
            return f(state);
        }
        return super.computeHorizontalScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        if (this.f10608j) {
            return g(state);
        }
        return super.computeHorizontalScrollRange(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        if (this.f10608j) {
            return f(state);
        }
        return super.computeVerticalScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        if (this.f10608j) {
            return g(state);
        }
        return super.computeVerticalScrollRange(state);
    }

    public final void e() {
        this.f10604f.clear();
        this.f10605g.clear();
    }

    public final int f(RecyclerView.State state) {
        int i11;
        if (!(getChildCount() == 0 || state.b() == 0)) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                int cachedSpanGroupIndex = this.f10606h.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f10601c);
                int cachedSpanGroupIndex2 = this.f10606h.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f10601c);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.f10606h.getCachedSpanGroupIndex(state.b() - 1, this.f10601c) + 1;
                if (this.mShouldReverseLayout) {
                    i11 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i11 = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return i11;
                }
                return Math.round((((float) i11) * (((float) Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart))) / ((float) ((this.f10606h.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f10601c) - this.f10606h.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f10601c)) + 1)))) + ((float) (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart))));
            }
        }
        return 0;
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11, boolean z12) {
        int i11;
        int childCount = getChildCount();
        int i12 = -1;
        int i13 = 1;
        if (z12) {
            i11 = getChildCount() - 1;
            i13 = -1;
        } else {
            i12 = childCount;
            i11 = 0;
        }
        int b11 = state.b();
        ensureLayoutState();
        int m11 = this.mOrientationHelper.m();
        int i14 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            int position = getPosition(childAt);
            if (position >= 0 && position < b11 && m(recycler, state, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.g(childAt) < i14 && this.mOrientationHelper.d(childAt) >= m11) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i11 += i13;
        }
        return view != null ? view : view2;
    }

    public final int g(RecyclerView.State state) {
        if (!(getChildCount() == 0 || state.b() == 0)) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (!(findFirstVisibleChildClosestToStart == null || findFirstVisibleChildClosestToEnd == null)) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.f10606h.getCachedSpanGroupIndex(state.b() - 1, this.f10601c) + 1;
                }
                int d11 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.f10606h.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.f10601c);
                return (int) ((((float) d11) / ((float) ((this.f10606h.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.f10601c) - cachedSpanGroupIndex) + 1))) * ((float) (this.f10606h.getCachedSpanGroupIndex(state.b() - 1, this.f10601c) + 1)));
            }
        }
        return 0;
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.f10601c;
        }
        if (state.b() < 1) {
            return 0;
        }
        return l(recycler, state, state.b() - 1) + 1;
    }

    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.f10601c;
        }
        if (state.b() < 1) {
            return 0;
        }
        return l(recycler, state, state.b() - 1) + 1;
    }

    public final void h(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i11) {
        boolean z11 = i11 == 1;
        int m11 = m(recycler, state, aVar.f10664b);
        if (z11) {
            while (m11 > 0) {
                int i12 = aVar.f10664b;
                if (i12 > 0) {
                    int i13 = i12 - 1;
                    aVar.f10664b = i13;
                    m11 = m(recycler, state, i13);
                } else {
                    return;
                }
            }
            return;
        }
        int b11 = state.b() - 1;
        int i14 = aVar.f10664b;
        while (i14 < b11) {
            int i15 = i14 + 1;
            int m12 = m(recycler, state, i15);
            if (m12 <= m11) {
                break;
            }
            i14 = i15;
            m11 = m12;
        }
        aVar.f10664b = i14;
    }

    public final void i() {
        View[] viewArr = this.f10603e;
        if (viewArr == null || viewArr.length != this.f10601c) {
            this.f10603e = new View[this.f10601c];
        }
    }

    public int j(int i11, int i12) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f10602d;
            return iArr[i12 + i11] - iArr[i11];
        }
        int[] iArr2 = this.f10602d;
        int i13 = this.f10601c;
        return iArr2[i13 - i11] - iArr2[(i13 - i11) - i12];
    }

    public int k() {
        return this.f10601c;
    }

    public final int l(RecyclerView.Recycler recycler, RecyclerView.State state, int i11) {
        if (!state.e()) {
            return this.f10606h.getCachedSpanGroupIndex(i11, this.f10601c);
        }
        int f11 = recycler.f(i11);
        if (f11 != -1) {
            return this.f10606h.getCachedSpanGroupIndex(f11, this.f10601c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i11);
        return 0;
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        View d11;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int l11 = this.mOrientationHelper.l();
        boolean z11 = false;
        boolean z12 = l11 != 1073741824;
        int i22 = getChildCount() > 0 ? this.f10602d[this.f10601c] : 0;
        if (z12) {
            u();
        }
        boolean z13 = cVar2.f10676e == 1;
        int i23 = this.f10601c;
        if (!z13) {
            i23 = m(recycler2, state2, cVar2.f10675d) + n(recycler2, state2, cVar2.f10675d);
        }
        int i24 = 0;
        while (i24 < this.f10601c && cVar2.c(state2) && i23 > 0) {
            int i25 = cVar2.f10675d;
            int n11 = n(recycler2, state2, i25);
            if (n11 <= this.f10601c) {
                i23 -= n11;
                if (i23 < 0 || (d11 = cVar2.d(recycler2)) == null) {
                    break;
                }
                this.f10603e[i24] = d11;
                i24++;
            } else {
                throw new IllegalArgumentException("Item at position " + i25 + " requires " + n11 + " spans but GridLayoutManager has only " + this.f10601c + " spans.");
            }
        }
        if (i24 == 0) {
            bVar2.f10669b = true;
            return;
        }
        float f11 = 0.0f;
        a(recycler2, state2, i24, z13);
        int i26 = 0;
        int i27 = 0;
        while (i26 < i24) {
            View view = this.f10603e[i26];
            if (cVar2.f10683l == null) {
                if (z13) {
                    addView(view);
                } else {
                    addView(view, z11);
                }
            } else if (z13) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, z11 ? 1 : 0);
            }
            calculateItemDecorationsForChild(view, this.f10607i);
            q(view, l11, z11);
            int e11 = this.mOrientationHelper.e(view);
            if (e11 > i27) {
                i27 = e11;
            }
            float f12 = (((float) this.mOrientationHelper.f(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f10610b);
            if (f12 > f11) {
                f11 = f12;
            }
            i26++;
            z11 = false;
        }
        if (z12) {
            p(f11, i22);
            i27 = 0;
            for (int i28 = 0; i28 < i24; i28++) {
                View view2 = this.f10603e[i28];
                q(view2, 1073741824, true);
                int e12 = this.mOrientationHelper.e(view2);
                if (e12 > i27) {
                    i27 = e12;
                }
            }
        }
        for (int i29 = 0; i29 < i24; i29++) {
            View view3 = this.f10603e[i29];
            if (this.mOrientationHelper.e(view3) != i27) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.mDecorInsets;
                int i30 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i31 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int j11 = j(layoutParams.f10609a, layoutParams.f10610b);
                if (this.mOrientation == 1) {
                    i21 = RecyclerView.LayoutManager.getChildMeasureSpec(j11, 1073741824, i31, layoutParams.width, false);
                    i19 = View.MeasureSpec.makeMeasureSpec(i27 - i30, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i27 - i31, 1073741824);
                    i19 = RecyclerView.LayoutManager.getChildMeasureSpec(j11, 1073741824, i30, layoutParams.height, false);
                    i21 = makeMeasureSpec;
                }
                r(view3, i21, i19, true);
            }
        }
        int i32 = 0;
        bVar2.f10668a = i27;
        if (this.mOrientation == 1) {
            if (cVar2.f10677f == -1) {
                i14 = cVar2.f10673b;
                i11 = i14 - i27;
            } else {
                int i33 = cVar2.f10673b;
                i11 = i33;
                i14 = i27 + i33;
            }
            i13 = 0;
            i12 = 0;
        } else if (cVar2.f10677f == -1) {
            int i34 = cVar2.f10673b;
            i12 = i34 - i27;
            i11 = 0;
            i13 = i34;
            i14 = 0;
        } else {
            int i35 = cVar2.f10673b;
            i13 = i27 + i35;
            i12 = i35;
            i14 = 0;
            i11 = 0;
        }
        while (i32 < i24) {
            View view4 = this.f10603e[i32];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.f10602d[this.f10601c - layoutParams2.f10609a];
                    i18 = i14;
                    i17 = paddingLeft;
                    i16 = paddingLeft - this.mOrientationHelper.f(view4);
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.f10602d[layoutParams2.f10609a];
                    i18 = i14;
                    i16 = paddingLeft2;
                    i17 = this.mOrientationHelper.f(view4) + paddingLeft2;
                }
                i15 = i11;
            } else {
                int paddingTop = getPaddingTop() + this.f10602d[layoutParams2.f10609a];
                i15 = paddingTop;
                i17 = i13;
                i16 = i12;
                i18 = this.mOrientationHelper.f(view4) + paddingTop;
            }
            layoutDecoratedWithMargins(view4, i16, i15, i17, i18);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                bVar2.f10670c = true;
            }
            bVar2.f10671d |= view4.hasFocusable();
            i32++;
            i14 = i18;
            i13 = i17;
            i12 = i16;
            i11 = i15;
        }
        Arrays.fill(this.f10603e, (Object) null);
    }

    public final int m(RecyclerView.Recycler recycler, RecyclerView.State state, int i11) {
        if (!state.e()) {
            return this.f10606h.getCachedSpanIndex(i11, this.f10601c);
        }
        int i12 = this.f10605g.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int f11 = recycler.f(i11);
        if (f11 != -1) {
            return this.f10606h.getCachedSpanIndex(f11, this.f10601c);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 0;
    }

    public final int n(RecyclerView.Recycler recycler, RecyclerView.State state, int i11) {
        if (!state.e()) {
            return this.f10606h.getSpanSize(i11);
        }
        int i12 = this.f10604f.get(i11, -1);
        if (i12 != -1) {
            return i12;
        }
        int f11 = recycler.f(i11);
        if (f11 != -1) {
            return this.f10606h.getSpanSize(f11);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i11);
        return 1;
    }

    public SpanSizeLookup o() {
        return this.f10606h;
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i11) {
        super.onAnchorReady(recycler, state, aVar, i11);
        u();
        if (state.b() > 0 && !state.e()) {
            h(recycler, state, aVar, i11);
        }
        i();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f10609a
            int r5 = r5.f10610b
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            if (r7 == r10) goto L_0x0032
            r7 = r9
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r11 = r10
            r12 = r11
            goto L_0x0045
        L_0x003e:
            int r7 = r23.getChildCount()
            r11 = r7
            r12 = r9
            r7 = 0
        L_0x0045:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x0051
            r13 = r9
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.l(r1, r2, r7)
            r15 = r10
            r16 = r15
            r8 = 0
            r17 = 0
            r10 = r7
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.l(r1, r2, r10)
            android.view.View r1 = r0.getChildAt(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f10609a
            r18 = r3
            int r3 = r9.f10610b
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.f10609a
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.f10609a
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.o0(GridView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int l11 = l(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.r0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(layoutParams2.a(), layoutParams2.b(), l11, 1, false, false));
            return;
        }
        accessibilityNodeInfoCompat.r0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(l11, 1, layoutParams2.a(), layoutParams2.b(), false, false));
    }

    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        this.f10606h.invalidateSpanIndexCache();
        this.f10606h.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.f10606h.invalidateSpanIndexCache();
        this.f10606h.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        this.f10606h.invalidateSpanIndexCache();
        this.f10606h.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        this.f10606h.invalidateSpanIndexCache();
        this.f10606h.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        this.f10606h.invalidateSpanIndexCache();
        this.f10606h.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.e()) {
            b();
        }
        super.onLayoutChildren(recycler, state);
        e();
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f10600b = false;
    }

    public final void p(float f11, int i11) {
        c(Math.max(Math.round(f11 * ((float) this.f10601c)), i11));
    }

    public final void q(View view, int i11, boolean z11) {
        int i12;
        int i13;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i14 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i15 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int j11 = j(layoutParams.f10609a, layoutParams.f10610b);
        if (this.mOrientation == 1) {
            i12 = RecyclerView.LayoutManager.getChildMeasureSpec(j11, i11, i15, layoutParams.width, false);
            i13 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i14, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(j11, i11, i14, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i15, layoutParams.width, true);
            i13 = childMeasureSpec;
            i12 = childMeasureSpec2;
        }
        r(view, i12, i13, z11);
    }

    public final void r(View view, int i11, int i12, boolean z11) {
        boolean z12;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z11) {
            z12 = shouldReMeasureChild(view, i11, i12, layoutParams);
        } else {
            z12 = shouldMeasureChild(view, i11, i12, layoutParams);
        }
        if (z12) {
            view.measure(i11, i12);
        }
    }

    public void s(int i11) {
        if (i11 != this.f10601c) {
            this.f10600b = true;
            if (i11 >= 1) {
                this.f10601c = i11;
                this.f10606h.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i11);
        }
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        u();
        i();
        return super.scrollHorizontallyBy(i11, recycler, state);
    }

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        u();
        i();
        return super.scrollVerticallyBy(i11, recycler, state);
    }

    public void setMeasuredDimension(Rect rect, int i11, int i12) {
        int i13;
        int i14;
        if (this.f10602d == null) {
            super.setMeasuredDimension(rect, i11, i12);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            i14 = RecyclerView.LayoutManager.chooseSize(i12, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.f10602d;
            i13 = RecyclerView.LayoutManager.chooseSize(i11, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            i13 = RecyclerView.LayoutManager.chooseSize(i11, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.f10602d;
            i14 = RecyclerView.LayoutManager.chooseSize(i12, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i13, i14);
    }

    public void setStackFromEnd(boolean z11) {
        if (!z11) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f10600b;
    }

    public void t(SpanSizeLookup spanSizeLookup) {
        this.f10606h = spanSizeLookup;
    }

    public final void u() {
        int i11;
        int i12;
        if (getOrientation() == 1) {
            i12 = getWidth() - getPaddingRight();
            i11 = getPaddingLeft();
        } else {
            i12 = getHeight() - getPaddingBottom();
            i11 = getPaddingTop();
        }
        c(i12 - i11);
    }

    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f10609a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f10610b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f10609a;
        }

        public int b() {
            return this.f10610b;
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i11) {
        super(context);
        s(i11);
    }

    public GridLayoutManager(Context context, int i11, int i12, boolean z11) {
        super(context, i12, z11);
        s(i11);
    }
}
