package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.h, RecyclerView.SmoothScroller.b {
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    public int mOrientation;
    public r mOrientationHelper;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorOffset;
        public int mAnchorPosition;

        public class a implements Parcelable.Creator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            this.mAnchorLayoutFromEnd = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public r f10663a;

        /* renamed from: b  reason: collision with root package name */
        public int f10664b;

        /* renamed from: c  reason: collision with root package name */
        public int f10665c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10666d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f10667e;

        public a() {
            e();
        }

        public void a() {
            int i11;
            if (this.f10666d) {
                i11 = this.f10663a.i();
            } else {
                i11 = this.f10663a.m();
            }
            this.f10665c = i11;
        }

        public void b(View view, int i11) {
            if (this.f10666d) {
                this.f10665c = this.f10663a.d(view) + this.f10663a.o();
            } else {
                this.f10665c = this.f10663a.g(view);
            }
            this.f10664b = i11;
        }

        public void c(View view, int i11) {
            int o11 = this.f10663a.o();
            if (o11 >= 0) {
                b(view, i11);
                return;
            }
            this.f10664b = i11;
            if (this.f10666d) {
                int i12 = (this.f10663a.i() - o11) - this.f10663a.d(view);
                this.f10665c = this.f10663a.i() - i12;
                if (i12 > 0) {
                    int e11 = this.f10665c - this.f10663a.e(view);
                    int m11 = this.f10663a.m();
                    int min = e11 - (m11 + Math.min(this.f10663a.g(view) - m11, 0));
                    if (min < 0) {
                        this.f10665c += Math.min(i12, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g11 = this.f10663a.g(view);
            int m12 = g11 - this.f10663a.m();
            this.f10665c = g11;
            if (m12 > 0) {
                int i13 = (this.f10663a.i() - Math.min(0, (this.f10663a.i() - o11) - this.f10663a.d(view))) - (g11 + this.f10663a.e(view));
                if (i13 < 0) {
                    this.f10665c -= Math.min(m12, -i13);
                }
            }
        }

        public boolean d(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.b();
        }

        public void e() {
            this.f10664b = -1;
            this.f10665c = Integer.MIN_VALUE;
            this.f10666d = false;
            this.f10667e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f10664b + ", mCoordinate=" + this.f10665c + ", mLayoutFromEnd=" + this.f10666d + ", mValid=" + this.f10667e + '}';
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f10668a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f10669b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f10670c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10671d;

        public void a() {
            this.f10668a = 0;
            this.f10669b = false;
            this.f10670c = false;
            this.f10671d = false;
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10672a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f10673b;

        /* renamed from: c  reason: collision with root package name */
        public int f10674c;

        /* renamed from: d  reason: collision with root package name */
        public int f10675d;

        /* renamed from: e  reason: collision with root package name */
        public int f10676e;

        /* renamed from: f  reason: collision with root package name */
        public int f10677f;

        /* renamed from: g  reason: collision with root package name */
        public int f10678g;

        /* renamed from: h  reason: collision with root package name */
        public int f10679h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f10680i = 0;

        /* renamed from: j  reason: collision with root package name */
        public boolean f10681j = false;

        /* renamed from: k  reason: collision with root package name */
        public int f10682k;

        /* renamed from: l  reason: collision with root package name */
        public List<RecyclerView.ViewHolder> f10683l = null;

        /* renamed from: m  reason: collision with root package name */
        public boolean f10684m;

        public void a() {
            b((View) null);
        }

        public void b(View view) {
            View f11 = f(view);
            if (f11 == null) {
                this.f10675d = -1;
            } else {
                this.f10675d = ((RecyclerView.LayoutParams) f11.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public boolean c(RecyclerView.State state) {
            int i11 = this.f10675d;
            return i11 >= 0 && i11 < state.b();
        }

        public View d(RecyclerView.Recycler recycler) {
            if (this.f10683l != null) {
                return e();
            }
            View o11 = recycler.o(this.f10675d);
            this.f10675d += this.f10676e;
            return o11;
        }

        public final View e() {
            int size = this.f10683l.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = this.f10683l.get(i11).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.f10675d == layoutParams.getViewLayoutPosition()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public View f(View view) {
            int viewLayoutPosition;
            int size = this.f10683l.size();
            View view2 = null;
            int i11 = Integer.MAX_VALUE;
            for (int i12 = 0; i12 < size; i12++) {
                View view3 = this.f10683l.get(i12).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.isItemRemoved() && (viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.f10675d) * this.f10676e) >= 0 && viewLayoutPosition < i11) {
                    view2 = view3;
                    if (viewLayoutPosition == 0) {
                        break;
                    }
                    i11 = viewLayoutPosition;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        r rVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return t.a(state, rVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        r rVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return t.b(state, rVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        r rVar = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return t.c(state, rVar, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i11, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int i12;
        int i13 = this.mOrientationHelper.i() - i11;
        if (i13 <= 0) {
            return 0;
        }
        int i14 = -scrollBy(-i13, recycler, state);
        int i15 = i11 + i14;
        if (!z11 || (i12 = this.mOrientationHelper.i() - i15) <= 0) {
            return i14;
        }
        this.mOrientationHelper.r(i12);
        return i12 + i14;
    }

    private int fixLayoutStartGap(int i11, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int m11;
        int m12 = i11 - this.mOrientationHelper.m();
        if (m12 <= 0) {
            return 0;
        }
        int i12 = -scrollBy(m12, recycler, state);
        int i13 = i11 + i12;
        if (!z11 || (m11 = i13 - this.mOrientationHelper.m()) <= 0) {
            return i12;
        }
        this.mOrientationHelper.r(-m11);
        return i12 - m11;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i11, int i12) {
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        if (state.g() && getChildCount() != 0 && !state.e() && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> k11 = recycler.k();
            int size = k11.size();
            int position = getPosition(getChildAt(0));
            int i13 = 0;
            int i14 = 0;
            for (int i15 = 0; i15 < size; i15++) {
                RecyclerView.ViewHolder viewHolder = k11.get(i15);
                if (!viewHolder.isRemoved()) {
                    boolean z11 = true;
                    if ((viewHolder.getLayoutPosition() < position) != this.mShouldReverseLayout) {
                        z11 = true;
                    }
                    if (z11) {
                        i13 += this.mOrientationHelper.e(viewHolder.itemView);
                    } else {
                        i14 += this.mOrientationHelper.e(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.f10683l = k11;
            if (i13 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i11);
                c cVar = this.mLayoutState;
                cVar.f10679h = i13;
                cVar.f10674c = 0;
                cVar.a();
                fill(recycler2, this.mLayoutState, state2, false);
            }
            if (i14 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i12);
                c cVar2 = this.mLayoutState;
                cVar2.f10679h = i14;
                cVar2.f10674c = 0;
                cVar2.a();
                fill(recycler2, this.mLayoutState, state2, false);
            }
            this.mLayoutState.f10683l = null;
        }
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f10672a && !cVar.f10684m) {
            int i11 = cVar.f10678g;
            int i12 = cVar.f10680i;
            if (cVar.f10677f == -1) {
                recycleViewsFromEnd(recycler, i11, i12);
            } else {
                recycleViewsFromStart(recycler, i11, i12);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i11, int i12) {
        if (i11 != i12) {
            if (i12 > i11) {
                for (int i13 = i12 - 1; i13 >= i11; i13--) {
                    removeAndRecycleViewAt(i13, recycler);
                }
                return;
            }
            while (i11 > i12) {
                removeAndRecycleViewAt(i11, recycler);
                i11--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i11, int i12) {
        int childCount = getChildCount();
        if (i11 >= 0) {
            int h11 = (this.mOrientationHelper.h() - i11) + i12;
            if (this.mShouldReverseLayout) {
                for (int i13 = 0; i13 < childCount; i13++) {
                    View childAt = getChildAt(i13);
                    if (this.mOrientationHelper.g(childAt) < h11 || this.mOrientationHelper.q(childAt) < h11) {
                        recycleChildren(recycler, 0, i13);
                        return;
                    }
                }
                return;
            }
            int i14 = childCount - 1;
            for (int i15 = i14; i15 >= 0; i15--) {
                View childAt2 = getChildAt(i15);
                if (this.mOrientationHelper.g(childAt2) < h11 || this.mOrientationHelper.q(childAt2) < h11) {
                    recycleChildren(recycler, i14, i15);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i11, int i12) {
        if (i11 >= 0) {
            int i13 = i11 - i12;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i14 = childCount - 1;
                for (int i15 = i14; i15 >= 0; i15--) {
                    View childAt = getChildAt(i15);
                    if (this.mOrientationHelper.d(childAt) > i13 || this.mOrientationHelper.p(childAt) > i13) {
                        recycleChildren(recycler, i14, i15);
                        return;
                    }
                }
                return;
            }
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt2 = getChildAt(i16);
                if (this.mOrientationHelper.d(childAt2) > i13 || this.mOrientationHelper.p(childAt2) > i13) {
                    recycleChildren(recycler, 0, i16);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        View findReferenceChild;
        boolean z11 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild == null || !aVar.d(focusedChild, state)) {
            boolean z12 = this.mLastStackFromEnd;
            boolean z13 = this.mStackFromEnd;
            if (z12 != z13 || (findReferenceChild = findReferenceChild(recycler, state, aVar.f10666d, z13)) == null) {
                return false;
            }
            aVar.b(findReferenceChild, getPosition(findReferenceChild));
            if (!state.e() && supportsPredictiveItemAnimations()) {
                int g11 = this.mOrientationHelper.g(findReferenceChild);
                int d11 = this.mOrientationHelper.d(findReferenceChild);
                int m11 = this.mOrientationHelper.m();
                int i11 = this.mOrientationHelper.i();
                boolean z14 = d11 <= m11 && g11 < m11;
                if (g11 >= i11 && d11 > i11) {
                    z11 = true;
                }
                if (z14 || z11) {
                    if (aVar.f10666d) {
                        m11 = i11;
                    }
                    aVar.f10665c = m11;
                }
            }
            return true;
        }
        aVar.c(focusedChild, getPosition(focusedChild));
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, a aVar) {
        int i11;
        int i12;
        boolean z11 = false;
        if (!state.e() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 < 0 || i11 >= state.b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                aVar.f10664b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.hasValidAnchor()) {
                    boolean z12 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    aVar.f10666d = z12;
                    if (z12) {
                        aVar.f10665c = this.mOrientationHelper.i() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        aVar.f10665c = this.mOrientationHelper.m() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if ((this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout) {
                                z11 = true;
                            }
                            aVar.f10666d = z11;
                        }
                        aVar.a();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        aVar.a();
                        return true;
                    } else if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        aVar.f10665c = this.mOrientationHelper.m();
                        aVar.f10666d = false;
                        return true;
                    } else if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        aVar.f10665c = this.mOrientationHelper.i();
                        aVar.f10666d = true;
                        return true;
                    } else {
                        if (aVar.f10666d) {
                            i12 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o();
                        } else {
                            i12 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        aVar.f10665c = i12;
                    }
                    return true;
                } else {
                    boolean z13 = this.mShouldReverseLayout;
                    aVar.f10666d = z13;
                    if (z13) {
                        aVar.f10665c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                    } else {
                        aVar.f10665c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        if (!updateAnchorFromPendingData(state, aVar) && !updateAnchorFromChildren(recycler, state, aVar)) {
            aVar.a();
            aVar.f10664b = this.mStackFromEnd ? state.b() - 1 : 0;
        }
    }

    private void updateLayoutState(int i11, int i12, boolean z11, RecyclerView.State state) {
        int i13;
        this.mLayoutState.f10684m = resolveIsInfinite();
        this.mLayoutState.f10677f = i11;
        int[] iArr = this.mReusableIntPair;
        boolean z12 = false;
        iArr[0] = 0;
        int i14 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i11 == 1) {
            z12 = true;
        }
        c cVar = this.mLayoutState;
        int i15 = z12 ? max2 : max;
        cVar.f10679h = i15;
        if (!z12) {
            max = max2;
        }
        cVar.f10680i = max;
        if (z12) {
            cVar.f10679h = i15 + this.mOrientationHelper.j();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i14 = -1;
            }
            cVar2.f10676e = i14;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f10675d = position + cVar3.f10676e;
            cVar3.f10673b = this.mOrientationHelper.d(childClosestToEnd);
            i13 = this.mOrientationHelper.d(childClosestToEnd) - this.mOrientationHelper.i();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f10679h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i14 = -1;
            }
            cVar4.f10676e = i14;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f10675d = position2 + cVar5.f10676e;
            cVar5.f10673b = this.mOrientationHelper.g(childClosestToStart);
            i13 = (-this.mOrientationHelper.g(childClosestToStart)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f10674c = i12;
        if (z11) {
            cVar6.f10674c = i12 - i13;
        }
        cVar6.f10678g = i13;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f10664b, aVar.f10665c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f10664b, aVar.f10665c);
    }

    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i11;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.f10677f == -1) {
            i11 = 0;
        } else {
            i11 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i11;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i11, int i12, RecyclerView.State state, RecyclerView.LayoutManager.c cVar) {
        if (this.mOrientation != 0) {
            i11 = i12;
        }
        if (getChildCount() != 0 && i11 != 0) {
            ensureLayoutState();
            updateLayoutState(i11 > 0 ? 1 : -1, Math.abs(i11), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, cVar);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void collectInitialPrefetchPositions(int i11, RecyclerView.LayoutManager.c cVar) {
        boolean z11;
        int i12;
        SavedState savedState = this.mPendingSavedState;
        int i13 = -1;
        if (savedState == null || !savedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z11 = this.mShouldReverseLayout;
            i12 = this.mPendingScrollPosition;
            if (i12 == -1) {
                i12 = z11 ? i11 - 1 : 0;
            }
        } else {
            SavedState savedState2 = this.mPendingSavedState;
            z11 = savedState2.mAnchorLayoutFromEnd;
            i12 = savedState2.mAnchorPosition;
        }
        if (!z11) {
            i13 = 1;
        }
        for (int i14 = 0; i14 < this.mInitialPrefetchItemCount && i12 >= 0 && i12 < i11; i14++) {
            cVar.a(i12, 0);
            i12 += i13;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, c cVar, RecyclerView.LayoutManager.c cVar2) {
        int i11 = cVar.f10675d;
        if (i11 >= 0 && i11 < state.b()) {
            cVar2.a(i11, Math.max(0, cVar.f10678g));
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i11) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z11 = false;
        int i12 = 1;
        if (i11 < getPosition(getChildAt(0))) {
            z11 = true;
        }
        if (z11 != this.mShouldReverseLayout) {
            i12 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i12, 0.0f);
        }
        return new PointF(0.0f, (float) i12);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int convertFocusDirectionToLayoutDirection(int i11) {
        if (i11 == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i11 == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        return Integer.MIN_VALUE;
                    }
                    return this.mOrientation == 1 ? 1 : Integer.MIN_VALUE;
                } else if (this.mOrientation == 0) {
                    return 1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation == 1) {
                return -1;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (this.mOrientation == 0) {
            return -1;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public c createLayoutState() {
        return new c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.Recycler recycler, c cVar, RecyclerView.State state, boolean z11) {
        int i11 = cVar.f10674c;
        int i12 = cVar.f10678g;
        if (i12 != Integer.MIN_VALUE) {
            if (i11 < 0) {
                cVar.f10678g = i12 + i11;
            }
            recycleByLayoutState(recycler, cVar);
        }
        int i13 = cVar.f10674c + cVar.f10679h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.f10684m && i13 <= 0) || !cVar.c(state)) {
                break;
            }
            bVar.a();
            layoutChunk(recycler, state, cVar, bVar);
            if (!bVar.f10669b) {
                cVar.f10673b += bVar.f10668a * cVar.f10677f;
                if (!bVar.f10670c || cVar.f10683l != null || !state.e()) {
                    int i14 = cVar.f10674c;
                    int i15 = bVar.f10668a;
                    cVar.f10674c = i14 - i15;
                    i13 -= i15;
                }
                int i16 = cVar.f10678g;
                if (i16 != Integer.MIN_VALUE) {
                    int i17 = i16 + bVar.f10668a;
                    cVar.f10678g = i17;
                    int i18 = cVar.f10674c;
                    if (i18 < 0) {
                        cVar.f10678g = i17 + i18;
                    }
                    recycleByLayoutState(recycler, cVar);
                }
                if (z11 && bVar.f10671d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i11 - cVar.f10674c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z11, boolean z12) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z11, z12);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z11, z12);
    }

    public View findFirstVisibleChildClosestToStart(boolean z11, boolean z12) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z11, z12);
        }
        return findOneVisibleChild(0, getChildCount(), z11, z12);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i11, int i12) {
        int i13;
        int i14;
        ensureLayoutState();
        if ((i12 > i11 ? 1 : i12 < i11 ? (char) 65535 : 0) == 0) {
            return getChildAt(i11);
        }
        if (this.mOrientationHelper.g(getChildAt(i11)) < this.mOrientationHelper.m()) {
            i14 = 16644;
            i13 = 16388;
        } else {
            i14 = 4161;
            i13 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i11, i12, i14, i13);
        }
        return this.mVerticalBoundCheck.a(i11, i12, i14, i13);
    }

    public View findOneVisibleChild(int i11, int i12, boolean z11, boolean z12) {
        ensureLayoutState();
        int i13 = 320;
        int i14 = z11 ? 24579 : 320;
        if (!z12) {
            i13 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i11, i12, i14, i13);
        }
        return this.mVerticalBoundCheck.a(i11, i12, i14, i13);
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11, boolean z12) {
        int i11;
        int i12;
        ensureLayoutState();
        int childCount = getChildCount();
        int i13 = -1;
        if (z12) {
            i12 = getChildCount() - 1;
            i11 = -1;
        } else {
            i13 = childCount;
            i12 = 0;
            i11 = 1;
        }
        int b11 = state.b();
        int m11 = this.mOrientationHelper.m();
        int i14 = this.mOrientationHelper.i();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i12 != i13) {
            View childAt = getChildAt(i12);
            int position = getPosition(childAt);
            int g11 = this.mOrientationHelper.g(childAt);
            int d11 = this.mOrientationHelper.d(childAt);
            if (position >= 0 && position < b11) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    boolean z13 = d11 <= m11 && g11 < m11;
                    boolean z14 = g11 >= i14 && d11 > i14;
                    if (!z13 && !z14) {
                        return childAt;
                    }
                    if (z11) {
                        if (!z14) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                    } else if (!z13) {
                        if (view != null) {
                        }
                        view = childAt;
                    }
                    view2 = childAt;
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i12 += i11;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i11) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i11 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i11) {
                return childAt;
            }
        }
        return super.findViewByPosition(i11);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar, b bVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        View d11 = cVar.d(recycler);
        if (d11 == null) {
            bVar.f10669b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) d11.getLayoutParams();
        if (cVar.f10683l == null) {
            if (this.mShouldReverseLayout == (cVar.f10677f == -1)) {
                addView(d11);
            } else {
                addView(d11, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f10677f == -1)) {
                addDisappearingView(d11);
            } else {
                addDisappearingView(d11, 0);
            }
        }
        measureChildWithMargins(d11, 0, 0);
        bVar.f10668a = this.mOrientationHelper.e(d11);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i15 = getWidth() - getPaddingRight();
                i14 = i15 - this.mOrientationHelper.f(d11);
            } else {
                i14 = getPaddingLeft();
                i15 = this.mOrientationHelper.f(d11) + i14;
            }
            if (cVar.f10677f == -1) {
                int i16 = cVar.f10673b;
                i11 = i16;
                i12 = i15;
                i13 = i16 - bVar.f10668a;
            } else {
                int i17 = cVar.f10673b;
                i13 = i17;
                i12 = i15;
                i11 = bVar.f10668a + i17;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f11 = this.mOrientationHelper.f(d11) + paddingTop;
            if (cVar.f10677f == -1) {
                int i18 = cVar.f10673b;
                i12 = i18;
                i13 = paddingTop;
                i11 = f11;
                i14 = i18 - bVar.f10668a;
            } else {
                int i19 = cVar.f10673b;
                i13 = paddingTop;
                i12 = bVar.f10668a + i19;
                i11 = f11;
                i14 = i19;
            }
        }
        layoutDecoratedWithMargins(d11, i14, i13, i12, i11);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            bVar.f10670c = true;
        }
        bVar.f10671d = d11.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar, int i11) {
    }

    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.c();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.n()) * MAX_SCROLL_FACTOR), false, state);
        c cVar = this.mLayoutState;
        cVar.f10678g = Integer.MIN_VALUE;
        cVar.f10672a = false;
        fill(recycler, cVar, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View findViewByPosition;
        int i17;
        int i18;
        int i19 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.b() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.f10672a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (!aVar.f10667e || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f10666d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, aVar2);
            this.mAnchorInfo.f10667e = true;
        } else if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
            this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
        }
        c cVar = this.mLayoutState;
        cVar.f10677f = cVar.f10682k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (!(!state.e() || (i16 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i16)) == null)) {
            if (this.mShouldReverseLayout) {
                i17 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                i18 = this.mPendingScrollPositionOffset;
            } else {
                i18 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i17 = this.mPendingScrollPositionOffset;
            }
            int i21 = i17 - i18;
            if (i21 > 0) {
                max += i21;
            } else {
                max2 -= i21;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f10666d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i19 = 1;
        }
        onAnchorReady(recycler, state, aVar3, i19);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.f10684m = resolveIsInfinite();
        this.mLayoutState.f10681j = state.e();
        this.mLayoutState.f10680i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f10666d) {
            updateLayoutStateToFillStart(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f10679h = max;
            fill(recycler, cVar2, state, false);
            c cVar3 = this.mLayoutState;
            i12 = cVar3.f10673b;
            int i22 = cVar3.f10675d;
            int i23 = cVar3.f10674c;
            if (i23 > 0) {
                max2 += i23;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f10679h = max2;
            cVar4.f10675d += cVar4.f10676e;
            fill(recycler, cVar4, state, false);
            c cVar5 = this.mLayoutState;
            i11 = cVar5.f10673b;
            int i24 = cVar5.f10674c;
            if (i24 > 0) {
                updateLayoutStateToFillStart(i22, i12);
                c cVar6 = this.mLayoutState;
                cVar6.f10679h = i24;
                fill(recycler, cVar6, state, false);
                i12 = this.mLayoutState.f10673b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f10679h = max2;
            fill(recycler, cVar7, state, false);
            c cVar8 = this.mLayoutState;
            i11 = cVar8.f10673b;
            int i25 = cVar8.f10675d;
            int i26 = cVar8.f10674c;
            if (i26 > 0) {
                max += i26;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f10679h = max;
            cVar9.f10675d += cVar9.f10676e;
            fill(recycler, cVar9, state, false);
            c cVar10 = this.mLayoutState;
            i12 = cVar10.f10673b;
            int i27 = cVar10.f10674c;
            if (i27 > 0) {
                updateLayoutStateToFillEnd(i25, i11);
                c cVar11 = this.mLayoutState;
                cVar11.f10679h = i27;
                fill(recycler, cVar11, state, false);
                i11 = this.mLayoutState.f10673b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i11, recycler, state, true);
                i14 = i12 + fixLayoutEndGap;
                i13 = i11 + fixLayoutEndGap;
                i15 = fixLayoutStartGap(i14, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i12, recycler, state, true);
                i14 = i12 + fixLayoutStartGap;
                i13 = i11 + fixLayoutStartGap;
                i15 = fixLayoutEndGap(i13, recycler, state, false);
            }
            i12 = i14 + i15;
            i11 = i13 + i15;
        }
        layoutForPredictiveAnimations(recycler, state, i12, i11);
        if (!state.e()) {
            this.mOrientationHelper.s();
        } else {
            this.mAnchorInfo.e();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z11 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z11;
            if (z11) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.mAnchorPosition = getPosition(childClosestToStart);
                savedState.mAnchorOffset = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.m();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i11, int i12) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        boolean z11 = position < position2 ? true : true;
        if (this.mShouldReverseLayout) {
            if (z11) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
            }
        } else if (z11) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0;
    }

    public int scrollBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f10672a = true;
        int i12 = i11 > 0 ? 1 : -1;
        int abs = Math.abs(i11);
        updateLayoutState(i12, abs, true, state);
        c cVar = this.mLayoutState;
        int fill = cVar.f10678g + fill(recycler, cVar, state, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i11 = i12 * fill;
        }
        this.mOrientationHelper.r(-i11);
        this.mLayoutState.f10682k = i11;
        return i11;
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i11, recycler, state);
    }

    public void scrollToPosition(int i11) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i11, int i12) {
        this.mPendingScrollPosition = i11;
        this.mPendingScrollPositionOffset = i12;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i11, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i11) {
        this.mInitialPrefetchItemCount = i11;
    }

    public void setOrientation(int i11) {
        if (i11 == 0 || i11 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i11 != this.mOrientation || this.mOrientationHelper == null) {
                r b11 = r.b(this, i11);
                this.mOrientationHelper = b11;
                this.mAnchorInfo.f10663a = b11;
                this.mOrientation = i11;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i11);
    }

    public void setRecycleChildrenOnDetach(boolean z11) {
        this.mRecycleChildrenOnDetach = z11;
    }

    public void setReverseLayout(boolean z11) {
        assertNotInLayoutOrScroll((String) null);
        if (z11 != this.mReverseLayout) {
            this.mReverseLayout = z11;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z11) {
        this.mSmoothScrollbarEnabled = z11;
    }

    public void setStackFromEnd(boolean z11) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z11) {
            this.mStackFromEnd = z11;
            requestLayout();
        }
    }

    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        n nVar = new n(recyclerView.getContext());
        nVar.setTargetPosition(i11);
        startSmoothScroll(nVar);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        boolean z11 = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int g11 = this.mOrientationHelper.g(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i11 = 1;
                while (i11 < getChildCount()) {
                    View childAt = getChildAt(i11);
                    int position2 = getPosition(childAt);
                    int g12 = this.mOrientationHelper.g(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("detected invalid position. loc invalid? ");
                        if (g12 >= g11) {
                            z11 = false;
                        }
                        sb2.append(z11);
                        throw new RuntimeException(sb2.toString());
                    } else if (g12 <= g11) {
                        i11++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i12 = 1;
            while (i12 < getChildCount()) {
                View childAt2 = getChildAt(i12);
                int position3 = getPosition(childAt2);
                int g13 = this.mOrientationHelper.g(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("detected invalid position. loc invalid? ");
                    if (g13 >= g11) {
                        z11 = false;
                    }
                    sb3.append(z11);
                    throw new RuntimeException(sb3.toString());
                } else if (g13 >= g11) {
                    i12++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i11, boolean z11) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i11);
        setReverseLayout(z11);
    }

    private void updateLayoutStateToFillEnd(int i11, int i12) {
        this.mLayoutState.f10674c = this.mOrientationHelper.i() - i12;
        c cVar = this.mLayoutState;
        cVar.f10676e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f10675d = i11;
        cVar.f10677f = 1;
        cVar.f10673b = i12;
        cVar.f10678g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i11, int i12) {
        this.mLayoutState.f10674c = i12 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.f10675d = i11;
        cVar.f10676e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f10677f = -1;
        cVar.f10673b = i12;
        cVar.f10678g = Integer.MIN_VALUE;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
