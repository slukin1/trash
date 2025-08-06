package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;
import androidx.recyclerview.widget.r;
import com.google.android.flexbox.FlexboxHelper;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.b {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlexboxLayoutManager";
    private static final Rect TEMP_RECT = new Rect();
    private int mAlignItems;
    private AnchorInfo mAnchorInfo;
    private final Context mContext;
    private int mDirtyPosition;
    /* access modifiers changed from: private */
    public int mFlexDirection;
    /* access modifiers changed from: private */
    public List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    /* access modifiers changed from: private */
    public int mFlexWrap;
    /* access modifiers changed from: private */
    public final FlexboxHelper mFlexboxHelper;
    private boolean mFromBottomToTop;
    /* access modifiers changed from: private */
    public boolean mIsRtl;
    private int mJustifyContent;
    private int mLastHeight;
    private int mLastWidth;
    private LayoutState mLayoutState;
    private int mMaxLine;
    /* access modifiers changed from: private */
    public r mOrientationHelper;
    private View mParent;
    private SavedState mPendingSavedState;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;
    /* access modifiers changed from: private */
    public r mSubOrientationHelper;
    private SparseArray<View> mViewCache;

    public class AnchorInfo {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public boolean mAssignedFromSavedState;
        /* access modifiers changed from: private */
        public int mCoordinate;
        /* access modifiers changed from: private */
        public int mFlexLinePosition;
        /* access modifiers changed from: private */
        public boolean mLayoutFromEnd;
        /* access modifiers changed from: private */
        public int mPerpendicularCoordinate;
        /* access modifiers changed from: private */
        public int mPosition;
        /* access modifiers changed from: private */
        public boolean mValid;

        private AnchorInfo() {
            this.mPerpendicularCoordinate = 0;
        }

        public static /* synthetic */ int access$2412(AnchorInfo anchorInfo, int i11) {
            int i12 = anchorInfo.mPerpendicularCoordinate + i11;
            anchorInfo.mPerpendicularCoordinate = i12;
            return i12;
        }

        /* access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            int i11;
            int i12;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    i11 = FlexboxLayoutManager.this.mOrientationHelper.i();
                } else {
                    i11 = FlexboxLayoutManager.this.mOrientationHelper.m();
                }
                this.mCoordinate = i11;
                return;
            }
            if (this.mLayoutFromEnd) {
                i12 = FlexboxLayoutManager.this.mOrientationHelper.i();
            } else {
                i12 = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.mOrientationHelper.m();
            }
            this.mCoordinate = i12;
        }

        /* access modifiers changed from: private */
        public void assignFromView(View view) {
            r rVar;
            if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                rVar = FlexboxLayoutManager.this.mSubOrientationHelper;
            } else {
                rVar = FlexboxLayoutManager.this.mOrientationHelper;
            }
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = rVar.d(view) + rVar.o();
                } else {
                    this.mCoordinate = rVar.g(view);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = rVar.g(view) + rVar.o();
            } else {
                this.mCoordinate = rVar.d(view);
            }
            this.mPosition = FlexboxLayoutManager.this.getPosition(view);
            int i11 = 0;
            this.mAssignedFromSavedState = false;
            int[] iArr = FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine;
            int i12 = this.mPosition;
            if (i12 == -1) {
                i12 = 0;
            }
            int i13 = iArr[i12];
            if (i13 != -1) {
                i11 = i13;
            }
            this.mFlexLinePosition = i11;
            if (FlexboxLayoutManager.this.mFlexLines.size() > this.mFlexLinePosition) {
                this.mPosition = ((FlexLine) FlexboxLayoutManager.this.mFlexLines.get(this.mFlexLinePosition)).mFirstIndex;
            }
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mFlexLinePosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            boolean z11 = false;
            this.mValid = false;
            this.mAssignedFromSavedState = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                    if (FlexboxLayoutManager.this.mFlexDirection == 1) {
                        z11 = true;
                    }
                    this.mLayoutFromEnd = z11;
                    return;
                }
                if (FlexboxLayoutManager.this.mFlexWrap == 2) {
                    z11 = true;
                }
                this.mLayoutFromEnd = z11;
            } else if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                if (FlexboxLayoutManager.this.mFlexDirection == 3) {
                    z11 = true;
                }
                this.mLayoutFromEnd = z11;
            } else {
                if (FlexboxLayoutManager.this.mFlexWrap == 2) {
                    z11 = true;
                }
                this.mLayoutFromEnd = z11;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mPerpendicularCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mAssignedFromSavedState + '}';
        }
    }

    public static class LayoutState {
        private static final int ITEM_DIRECTION_TAIL = 1;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;
        private static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int mAvailable;
        /* access modifiers changed from: private */
        public int mFlexLinePosition;
        /* access modifiers changed from: private */
        public boolean mInfinite;
        /* access modifiers changed from: private */
        public int mItemDirection;
        /* access modifiers changed from: private */
        public int mLastScrollDelta;
        /* access modifiers changed from: private */
        public int mLayoutDirection;
        /* access modifiers changed from: private */
        public int mOffset;
        /* access modifiers changed from: private */
        public int mPosition;
        /* access modifiers changed from: private */
        public int mScrollingOffset;
        /* access modifiers changed from: private */
        public boolean mShouldRecycle;

        private LayoutState() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        public static /* synthetic */ int access$1012(LayoutState layoutState, int i11) {
            int i12 = layoutState.mOffset + i11;
            layoutState.mOffset = i12;
            return i12;
        }

        public static /* synthetic */ int access$1020(LayoutState layoutState, int i11) {
            int i12 = layoutState.mOffset - i11;
            layoutState.mOffset = i12;
            return i12;
        }

        public static /* synthetic */ int access$1220(LayoutState layoutState, int i11) {
            int i12 = layoutState.mAvailable - i11;
            layoutState.mAvailable = i12;
            return i12;
        }

        public static /* synthetic */ int access$1508(LayoutState layoutState) {
            int i11 = layoutState.mFlexLinePosition;
            layoutState.mFlexLinePosition = i11 + 1;
            return i11;
        }

        public static /* synthetic */ int access$1510(LayoutState layoutState) {
            int i11 = layoutState.mFlexLinePosition;
            layoutState.mFlexLinePosition = i11 - 1;
            return i11;
        }

        public static /* synthetic */ int access$1512(LayoutState layoutState, int i11) {
            int i12 = layoutState.mFlexLinePosition + i11;
            layoutState.mFlexLinePosition = i12;
            return i12;
        }

        public static /* synthetic */ int access$2012(LayoutState layoutState, int i11) {
            int i12 = layoutState.mScrollingOffset + i11;
            layoutState.mScrollingOffset = i12;
            return i12;
        }

        public static /* synthetic */ int access$2212(LayoutState layoutState, int i11) {
            int i12 = layoutState.mPosition + i11;
            layoutState.mPosition = i12;
            return i12;
        }

        public static /* synthetic */ int access$2220(LayoutState layoutState, int i11) {
            int i12 = layoutState.mPosition - i11;
            layoutState.mPosition = i12;
            return i12;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r2 = r1.mFlexLinePosition;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasMore(androidx.recyclerview.widget.RecyclerView.State r2, java.util.List<com.google.android.flexbox.FlexLine> r3) {
            /*
                r1 = this;
                int r0 = r1.mPosition
                if (r0 < 0) goto L_0x0016
                int r2 = r2.b()
                if (r0 >= r2) goto L_0x0016
                int r2 = r1.mFlexLinePosition
                if (r2 < 0) goto L_0x0016
                int r3 = r3.size()
                if (r2 >= r3) goto L_0x0016
                r2 = 1
                goto L_0x0017
            L_0x0016:
                r2 = 0
            L_0x0017:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.LayoutState.hasMore(androidx.recyclerview.widget.RecyclerView$State, java.util.List):boolean");
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private boolean canViewBeRecycledFromEnd(View view, int i11) {
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            if (this.mOrientationHelper.g(view) >= this.mOrientationHelper.h() - i11) {
                return true;
            }
            return false;
        } else if (this.mOrientationHelper.d(view) <= i11) {
            return true;
        } else {
            return false;
        }
    }

    private boolean canViewBeRecycledFromStart(View view, int i11) {
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            if (this.mOrientationHelper.d(view) <= i11) {
                return true;
            }
            return false;
        } else if (this.mOrientationHelper.h() - this.mOrientationHelper.g(view) <= i11) {
            return true;
        } else {
            return false;
        }
    }

    private void clearFlexLines() {
        this.mFlexLines.clear();
        this.mAnchorInfo.reset();
        int unused = this.mAnchorInfo.mPerpendicularCoordinate = 0;
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int b11 = state.b();
        ensureOrientationHelper();
        View findFirstReferenceChild = findFirstReferenceChild(b11);
        View findLastReferenceChild = findLastReferenceChild(b11);
        if (state.b() == 0 || findFirstReferenceChild == null || findLastReferenceChild == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.n(), this.mOrientationHelper.d(findLastReferenceChild) - this.mOrientationHelper.g(findFirstReferenceChild));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int b11 = state.b();
        View findFirstReferenceChild = findFirstReferenceChild(b11);
        View findLastReferenceChild = findLastReferenceChild(b11);
        if (!(state.b() == 0 || findFirstReferenceChild == null || findLastReferenceChild == null)) {
            int position = getPosition(findFirstReferenceChild);
            int position2 = getPosition(findLastReferenceChild);
            int abs = Math.abs(this.mOrientationHelper.d(findLastReferenceChild) - this.mOrientationHelper.g(findFirstReferenceChild));
            int[] iArr = this.mFlexboxHelper.mIndexToFlexLine;
            int i11 = iArr[position];
            if (!(i11 == 0 || i11 == -1)) {
                return Math.round((((float) i11) * (((float) abs) / ((float) ((iArr[position2] - i11) + 1)))) + ((float) (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstReferenceChild))));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int b11 = state.b();
        View findFirstReferenceChild = findFirstReferenceChild(b11);
        View findLastReferenceChild = findLastReferenceChild(b11);
        if (state.b() == 0 || findFirstReferenceChild == null || findLastReferenceChild == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((((float) Math.abs(this.mOrientationHelper.d(findLastReferenceChild) - this.mOrientationHelper.g(findFirstReferenceChild))) / ((float) ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1))) * ((float) state.b()));
    }

    private void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new LayoutState();
        }
    }

    private void ensureOrientationHelper() {
        if (this.mOrientationHelper == null) {
            if (isMainAxisDirectionHorizontal()) {
                if (this.mFlexWrap == 0) {
                    this.mOrientationHelper = r.a(this);
                    this.mSubOrientationHelper = r.c(this);
                    return;
                }
                this.mOrientationHelper = r.c(this);
                this.mSubOrientationHelper = r.a(this);
            } else if (this.mFlexWrap == 0) {
                this.mOrientationHelper = r.c(this);
                this.mSubOrientationHelper = r.a(this);
            } else {
                this.mOrientationHelper = r.a(this);
                this.mSubOrientationHelper = r.c(this);
            }
        }
    }

    private int fill(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState) {
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                LayoutState.access$2012(layoutState, layoutState.mAvailable);
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int access$1200 = layoutState.mAvailable;
        int access$12002 = layoutState.mAvailable;
        int i11 = 0;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        while (true) {
            if ((access$12002 > 0 || this.mLayoutState.mInfinite) && layoutState.hasMore(state, this.mFlexLines)) {
                FlexLine flexLine = this.mFlexLines.get(layoutState.mFlexLinePosition);
                int unused = layoutState.mPosition = flexLine.mFirstIndex;
                i11 += layoutFlexLine(flexLine, layoutState);
                if (isMainAxisDirectionHorizontal || !this.mIsRtl) {
                    LayoutState.access$1012(layoutState, flexLine.getCrossSize() * layoutState.mLayoutDirection);
                } else {
                    LayoutState.access$1020(layoutState, flexLine.getCrossSize() * layoutState.mLayoutDirection);
                }
                access$12002 -= flexLine.getCrossSize();
            }
        }
        LayoutState.access$1220(layoutState, i11);
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            LayoutState.access$2012(layoutState, i11);
            if (layoutState.mAvailable < 0) {
                LayoutState.access$2012(layoutState, layoutState.mAvailable);
            }
            recycleByLayoutState(recycler, layoutState);
        }
        return access$1200 - layoutState.mAvailable;
    }

    private View findFirstReferenceChild(int i11) {
        int i12;
        View findReferenceChild = findReferenceChild(0, getChildCount(), i11);
        if (findReferenceChild == null || (i12 = this.mFlexboxHelper.mIndexToFlexLine[getPosition(findReferenceChild)]) == -1) {
            return null;
        }
        return findFirstReferenceViewInLine(findReferenceChild, this.mFlexLines.get(i12));
    }

    private View findFirstReferenceViewInLine(View view, FlexLine flexLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int i11 = flexLine.mItemCount;
        for (int i12 = 1; i12 < i11; i12++) {
            View childAt = getChildAt(i12);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.mIsRtl || isMainAxisDirectionHorizontal) {
                    if (this.mOrientationHelper.g(view) <= this.mOrientationHelper.g(childAt)) {
                    }
                } else if (this.mOrientationHelper.d(view) >= this.mOrientationHelper.d(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    private View findLastReferenceChild(int i11) {
        View findReferenceChild = findReferenceChild(getChildCount() - 1, -1, i11);
        if (findReferenceChild == null) {
            return null;
        }
        return findLastReferenceViewInLine(findReferenceChild, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[getPosition(findReferenceChild)]));
    }

    private View findLastReferenceViewInLine(View view, FlexLine flexLine) {
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int childCount = (getChildCount() - flexLine.mItemCount) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.mIsRtl || isMainAxisDirectionHorizontal) {
                    if (this.mOrientationHelper.d(view) >= this.mOrientationHelper.d(childAt)) {
                    }
                } else if (this.mOrientationHelper.g(view) <= this.mOrientationHelper.g(childAt)) {
                }
                view = childAt;
            }
        }
        return view;
    }

    private View findOneVisibleChild(int i11, int i12, boolean z11) {
        int i13 = i12 > i11 ? 1 : -1;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (isViewVisible(childAt, z11)) {
                return childAt;
            }
            i11 += i13;
        }
        return null;
    }

    private View findReferenceChild(int i11, int i12, int i13) {
        int position;
        ensureOrientationHelper();
        ensureLayoutState();
        int m11 = this.mOrientationHelper.m();
        int i14 = this.mOrientationHelper.i();
        int i15 = i12 > i11 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt != null && (position = getPosition(childAt)) >= 0 && position < i13) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.g(childAt) >= m11 && this.mOrientationHelper.d(childAt) <= i14) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i11 += i15;
        }
        return view != null ? view : view2;
    }

    private int fixLayoutEndGap(int i11, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int i12;
        int i13;
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            int m11 = i11 - this.mOrientationHelper.m();
            if (m11 <= 0) {
                return 0;
            }
            i12 = handleScrollingMainOrientation(m11, recycler, state);
        } else {
            int i14 = this.mOrientationHelper.i() - i11;
            if (i14 <= 0) {
                return 0;
            }
            i12 = -handleScrollingMainOrientation(-i14, recycler, state);
        }
        int i15 = i11 + i12;
        if (!z11 || (i13 = this.mOrientationHelper.i() - i15) <= 0) {
            return i12;
        }
        this.mOrientationHelper.r(i13);
        return i13 + i12;
    }

    private int fixLayoutStartGap(int i11, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z11) {
        int i12;
        int m11;
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            int m12 = i11 - this.mOrientationHelper.m();
            if (m12 <= 0) {
                return 0;
            }
            i12 = -handleScrollingMainOrientation(m12, recycler, state);
        } else {
            int i13 = this.mOrientationHelper.i() - i11;
            if (i13 <= 0) {
                return 0;
            }
            i12 = handleScrollingMainOrientation(-i13, recycler, state);
        }
        int i14 = i11 + i12;
        if (!z11 || (m11 = i14 - this.mOrientationHelper.m()) <= 0) {
            return i12;
        }
        this.mOrientationHelper.r(-m11);
        return i12 - m11;
    }

    private int getChildBottom(View view) {
        return getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private int getChildLeft(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int getChildRight(View view) {
        return getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    private int getChildTop(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int handleScrollingMainOrientation(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        ensureOrientationHelper();
        int i12 = 1;
        boolean unused = this.mLayoutState.mShouldRecycle = true;
        boolean z11 = !isMainAxisDirectionHorizontal() && this.mIsRtl;
        if (!z11 ? i11 <= 0 : i11 >= 0) {
            i12 = -1;
        }
        int abs = Math.abs(i11);
        updateLayoutState(i12, abs);
        int access$2000 = this.mLayoutState.mScrollingOffset + fill(recycler, state, this.mLayoutState);
        if (access$2000 < 0) {
            return 0;
        }
        if (z11) {
            if (abs > access$2000) {
                i11 = (-i12) * access$2000;
            }
        } else if (abs > access$2000) {
            i11 = i12 * access$2000;
        }
        this.mOrientationHelper.r(-i11);
        int unused2 = this.mLayoutState.mLastScrollDelta = i11;
        return i11;
    }

    private int handleScrollingSubOrientation(int i11) {
        int access$2400;
        boolean z11 = false;
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        ensureOrientationHelper();
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        View view = this.mParent;
        int width = isMainAxisDirectionHorizontal ? view.getWidth() : view.getHeight();
        int width2 = isMainAxisDirectionHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            z11 = true;
        }
        if (z11) {
            int abs = Math.abs(i11);
            if (i11 < 0) {
                access$2400 = Math.min((width2 + this.mAnchorInfo.mPerpendicularCoordinate) - width, abs);
            } else if (this.mAnchorInfo.mPerpendicularCoordinate + i11 <= 0) {
                return i11;
            } else {
                access$2400 = this.mAnchorInfo.mPerpendicularCoordinate;
            }
        } else if (i11 > 0) {
            return Math.min((width2 - this.mAnchorInfo.mPerpendicularCoordinate) - width, i11);
        } else {
            if (this.mAnchorInfo.mPerpendicularCoordinate + i11 >= 0) {
                return i11;
            }
            access$2400 = this.mAnchorInfo.mPerpendicularCoordinate;
        }
        return -access$2400;
    }

    private static boolean isMeasurementUpToDate(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        if (i13 > 0 && i11 != i13) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i11;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i11;
        }
        return true;
    }

    private boolean isViewVisible(View view, boolean z11) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int childLeft = getChildLeft(view);
        int childTop = getChildTop(view);
        int childRight = getChildRight(view);
        int childBottom = getChildBottom(view);
        return z11 ? (paddingLeft <= childLeft && width >= childRight) && (paddingTop <= childTop && height >= childBottom) : (childLeft >= width || childRight >= paddingLeft) && (childTop >= height || childBottom >= paddingTop);
    }

    private int layoutFlexLine(FlexLine flexLine, LayoutState layoutState) {
        if (isMainAxisDirectionHorizontal()) {
            return layoutFlexLineMainAxisHorizontal(flexLine, layoutState);
        }
        return layoutFlexLineMainAxisVertical(flexLine, layoutState);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int layoutFlexLineMainAxisHorizontal(com.google.android.flexbox.FlexLine r22, com.google.android.flexbox.FlexboxLayoutManager.LayoutState r23) {
        /*
            r21 = this;
            r0 = r21
            r8 = r22
            int r1 = r21.getPaddingLeft()
            int r2 = r21.getPaddingRight()
            int r3 = r21.getWidth()
            int r4 = r23.mOffset
            int r5 = r23.mLayoutDirection
            r6 = -1
            if (r5 != r6) goto L_0x001e
            int r5 = r8.mCrossSize
            int r4 = r4 - r5
        L_0x001e:
            r9 = r4
            int r10 = r23.mPosition
            int r4 = r0.mJustifyContent
            r5 = 0
            r11 = 1
            if (r4 == 0) goto L_0x00ac
            if (r4 == r11) goto L_0x009e
            r6 = 2
            r7 = 1073741824(0x40000000, float:2.0)
            if (r4 == r6) goto L_0x008e
            r6 = 3
            if (r4 == r6) goto L_0x007b
            r6 = 4
            if (r4 == r6) goto L_0x0066
            r6 = 5
            if (r4 != r6) goto L_0x004d
            int r4 = r8.mItemCount
            if (r4 == 0) goto L_0x0046
            int r6 = r8.mMainSize
            int r6 = r3 - r6
            float r6 = (float) r6
            int r4 = r4 + r11
            float r4 = (float) r4
            float r6 = r6 / r4
            goto L_0x0047
        L_0x0046:
            r6 = r5
        L_0x0047:
            float r1 = (float) r1
            float r1 = r1 + r6
            int r3 = r3 - r2
            float r2 = (float) r3
            float r2 = r2 - r6
            goto L_0x00b0
        L_0x004d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.append(r3)
            int r3 = r0.mJustifyContent
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0066:
            int r4 = r8.mItemCount
            if (r4 == 0) goto L_0x0072
            int r6 = r8.mMainSize
            int r6 = r3 - r6
            float r6 = (float) r6
            float r4 = (float) r4
            float r6 = r6 / r4
            goto L_0x0073
        L_0x0072:
            r6 = r5
        L_0x0073:
            float r1 = (float) r1
            float r4 = r6 / r7
            float r1 = r1 + r4
            int r3 = r3 - r2
            float r2 = (float) r3
            float r2 = r2 - r4
            goto L_0x00b0
        L_0x007b:
            float r1 = (float) r1
            int r4 = r8.mItemCount
            if (r4 == r11) goto L_0x0083
            int r4 = r4 - r11
            float r4 = (float) r4
            goto L_0x0085
        L_0x0083:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x0085:
            int r6 = r8.mMainSize
            int r6 = r3 - r6
            float r6 = (float) r6
            float r6 = r6 / r4
            int r3 = r3 - r2
            float r2 = (float) r3
            goto L_0x00b0
        L_0x008e:
            float r1 = (float) r1
            int r4 = r8.mMainSize
            int r6 = r3 - r4
            float r6 = (float) r6
            float r6 = r6 / r7
            float r1 = r1 + r6
            int r2 = r3 - r2
            float r2 = (float) r2
            int r3 = r3 - r4
            float r3 = (float) r3
            float r3 = r3 / r7
            float r2 = r2 - r3
            goto L_0x00af
        L_0x009e:
            int r4 = r8.mMainSize
            int r3 = r3 - r4
            int r3 = r3 + r2
            float r2 = (float) r3
            int r4 = r4 - r1
            float r1 = (float) r4
            r6 = r5
            r20 = r2
            r2 = r1
            r1 = r20
            goto L_0x00b0
        L_0x00ac:
            float r1 = (float) r1
            int r3 = r3 - r2
            float r2 = (float) r3
        L_0x00af:
            r6 = r5
        L_0x00b0:
            com.google.android.flexbox.FlexboxLayoutManager$AnchorInfo r3 = r0.mAnchorInfo
            int r3 = r3.mPerpendicularCoordinate
            float r3 = (float) r3
            float r1 = r1 - r3
            com.google.android.flexbox.FlexboxLayoutManager$AnchorInfo r3 = r0.mAnchorInfo
            int r3 = r3.mPerpendicularCoordinate
            float r3 = (float) r3
            float r2 = r2 - r3
            float r12 = java.lang.Math.max(r6, r5)
            r3 = 0
            int r13 = r22.getItemCount()
            r14 = r10
        L_0x00ca:
            int r4 = r10 + r13
            if (r14 >= r4) goto L_0x0197
            android.view.View r15 = r0.getFlexItemAt(r14)
            if (r15 != 0) goto L_0x00d6
            goto L_0x0192
        L_0x00d6:
            int r4 = r23.mLayoutDirection
            if (r4 != r11) goto L_0x00e5
            android.graphics.Rect r4 = TEMP_RECT
            r0.calculateItemDecorationsForChild(r15, r4)
            r0.addView(r15)
            goto L_0x00ef
        L_0x00e5:
            android.graphics.Rect r4 = TEMP_RECT
            r0.calculateItemDecorationsForChild(r15, r4)
            r0.addView(r15, r3)
            int r3 = r3 + 1
        L_0x00ef:
            r16 = r3
            com.google.android.flexbox.FlexboxHelper r3 = r0.mFlexboxHelper
            long[] r4 = r3.mMeasureSpecCache
            r5 = r4[r14]
            int r3 = r3.extractLowerInt(r5)
            com.google.android.flexbox.FlexboxHelper r4 = r0.mFlexboxHelper
            int r4 = r4.extractHigherInt(r5)
            android.view.ViewGroup$LayoutParams r5 = r15.getLayoutParams()
            r7 = r5
            com.google.android.flexbox.FlexboxLayoutManager$LayoutParams r7 = (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) r7
            boolean r5 = r0.shouldMeasureChild(r15, r3, r4, r7)
            if (r5 == 0) goto L_0x0111
            r15.measure(r3, r4)
        L_0x0111:
            int r3 = r7.leftMargin
            int r4 = r0.getLeftDecorationWidth(r15)
            int r3 = r3 + r4
            float r3 = (float) r3
            float r17 = r1 + r3
            int r1 = r7.rightMargin
            int r3 = r0.getRightDecorationWidth(r15)
            int r1 = r1 + r3
            float r1 = (float) r1
            float r18 = r2 - r1
            int r1 = r0.getTopDecorationHeight(r15)
            int r5 = r9 + r1
            boolean r1 = r0.mIsRtl
            if (r1 == 0) goto L_0x014f
            com.google.android.flexbox.FlexboxHelper r1 = r0.mFlexboxHelper
            int r2 = java.lang.Math.round(r18)
            int r3 = r15.getMeasuredWidth()
            int r4 = r2 - r3
            int r6 = java.lang.Math.round(r18)
            int r2 = r15.getMeasuredHeight()
            int r19 = r5 + r2
            r2 = r15
            r3 = r22
            r11 = r7
            r7 = r19
            r1.layoutSingleChildHorizontal(r2, r3, r4, r5, r6, r7)
            goto L_0x016c
        L_0x014f:
            r11 = r7
            com.google.android.flexbox.FlexboxHelper r1 = r0.mFlexboxHelper
            int r4 = java.lang.Math.round(r17)
            int r2 = java.lang.Math.round(r17)
            int r3 = r15.getMeasuredWidth()
            int r6 = r2 + r3
            int r2 = r15.getMeasuredHeight()
            int r7 = r5 + r2
            r2 = r15
            r3 = r22
            r1.layoutSingleChildHorizontal(r2, r3, r4, r5, r6, r7)
        L_0x016c:
            int r1 = r15.getMeasuredWidth()
            int r2 = r11.rightMargin
            int r1 = r1 + r2
            int r2 = r0.getRightDecorationWidth(r15)
            int r1 = r1 + r2
            float r1 = (float) r1
            float r1 = r1 + r12
            float r17 = r17 + r1
            int r1 = r15.getMeasuredWidth()
            int r2 = r11.leftMargin
            int r1 = r1 + r2
            int r2 = r0.getLeftDecorationWidth(r15)
            int r1 = r1 + r2
            float r1 = (float) r1
            float r1 = r1 + r12
            float r18 = r18 - r1
            r3 = r16
            r1 = r17
            r2 = r18
        L_0x0192:
            int r14 = r14 + 1
            r11 = 1
            goto L_0x00ca
        L_0x0197:
            com.google.android.flexbox.FlexboxLayoutManager$LayoutState r1 = r0.mLayoutState
            int r1 = r1.mLayoutDirection
            r2 = r23
            com.google.android.flexbox.FlexboxLayoutManager.LayoutState.access$1512(r2, r1)
            int r1 = r22.getCrossSize()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.layoutFlexLineMainAxisHorizontal(com.google.android.flexbox.FlexLine, com.google.android.flexbox.FlexboxLayoutManager$LayoutState):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int layoutFlexLineMainAxisVertical(com.google.android.flexbox.FlexLine r26, com.google.android.flexbox.FlexboxLayoutManager.LayoutState r27) {
        /*
            r25 = this;
            r0 = r25
            r9 = r26
            int r1 = r25.getPaddingTop()
            int r2 = r25.getPaddingBottom()
            int r3 = r25.getHeight()
            int r4 = r27.mOffset
            int r5 = r27.mOffset
            int r6 = r27.mLayoutDirection
            r7 = -1
            if (r6 != r7) goto L_0x0023
            int r6 = r9.mCrossSize
            int r4 = r4 - r6
            int r5 = r5 + r6
        L_0x0023:
            r10 = r4
            r11 = r5
            int r12 = r27.mPosition
            int r4 = r0.mJustifyContent
            r5 = 0
            r13 = 1
            if (r4 == 0) goto L_0x00b2
            if (r4 == r13) goto L_0x00a4
            r6 = 2
            r7 = 1073741824(0x40000000, float:2.0)
            if (r4 == r6) goto L_0x0094
            r6 = 3
            if (r4 == r6) goto L_0x0081
            r6 = 4
            if (r4 == r6) goto L_0x006c
            r6 = 5
            if (r4 != r6) goto L_0x0053
            int r4 = r9.mItemCount
            if (r4 == 0) goto L_0x004c
            int r6 = r9.mMainSize
            int r6 = r3 - r6
            float r6 = (float) r6
            int r4 = r4 + r13
            float r4 = (float) r4
            float r6 = r6 / r4
            goto L_0x004d
        L_0x004c:
            r6 = r5
        L_0x004d:
            float r1 = (float) r1
            float r1 = r1 + r6
            int r3 = r3 - r2
            float r2 = (float) r3
            float r2 = r2 - r6
            goto L_0x00b6
        L_0x0053:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Invalid justifyContent is set: "
            r2.append(r3)
            int r3 = r0.mJustifyContent
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x006c:
            int r4 = r9.mItemCount
            if (r4 == 0) goto L_0x0078
            int r6 = r9.mMainSize
            int r6 = r3 - r6
            float r6 = (float) r6
            float r4 = (float) r4
            float r6 = r6 / r4
            goto L_0x0079
        L_0x0078:
            r6 = r5
        L_0x0079:
            float r1 = (float) r1
            float r4 = r6 / r7
            float r1 = r1 + r4
            int r3 = r3 - r2
            float r2 = (float) r3
            float r2 = r2 - r4
            goto L_0x00b6
        L_0x0081:
            float r1 = (float) r1
            int r4 = r9.mItemCount
            if (r4 == r13) goto L_0x0089
            int r4 = r4 - r13
            float r4 = (float) r4
            goto L_0x008b
        L_0x0089:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x008b:
            int r6 = r9.mMainSize
            int r6 = r3 - r6
            float r6 = (float) r6
            float r6 = r6 / r4
            int r3 = r3 - r2
            float r2 = (float) r3
            goto L_0x00b6
        L_0x0094:
            float r1 = (float) r1
            int r4 = r9.mMainSize
            int r6 = r3 - r4
            float r6 = (float) r6
            float r6 = r6 / r7
            float r1 = r1 + r6
            int r2 = r3 - r2
            float r2 = (float) r2
            int r3 = r3 - r4
            float r3 = (float) r3
            float r3 = r3 / r7
            float r2 = r2 - r3
            goto L_0x00b5
        L_0x00a4:
            int r4 = r9.mMainSize
            int r3 = r3 - r4
            int r3 = r3 + r2
            float r2 = (float) r3
            int r4 = r4 - r1
            float r1 = (float) r4
            r6 = r5
            r24 = r2
            r2 = r1
            r1 = r24
            goto L_0x00b6
        L_0x00b2:
            float r1 = (float) r1
            int r3 = r3 - r2
            float r2 = (float) r3
        L_0x00b5:
            r6 = r5
        L_0x00b6:
            com.google.android.flexbox.FlexboxLayoutManager$AnchorInfo r3 = r0.mAnchorInfo
            int r3 = r3.mPerpendicularCoordinate
            float r3 = (float) r3
            float r1 = r1 - r3
            com.google.android.flexbox.FlexboxLayoutManager$AnchorInfo r3 = r0.mAnchorInfo
            int r3 = r3.mPerpendicularCoordinate
            float r3 = (float) r3
            float r2 = r2 - r3
            float r14 = java.lang.Math.max(r6, r5)
            r3 = 0
            int r15 = r26.getItemCount()
            r8 = r12
        L_0x00d0:
            int r4 = r12 + r15
            if (r8 >= r4) goto L_0x020d
            android.view.View r7 = r0.getFlexItemAt(r8)
            if (r7 != 0) goto L_0x00e2
            r23 = r8
            r22 = r13
            r17 = r14
            goto L_0x0205
        L_0x00e2:
            com.google.android.flexbox.FlexboxHelper r4 = r0.mFlexboxHelper
            long[] r5 = r4.mMeasureSpecCache
            r17 = r14
            r13 = r5[r8]
            int r4 = r4.extractLowerInt(r13)
            com.google.android.flexbox.FlexboxHelper r5 = r0.mFlexboxHelper
            int r5 = r5.extractHigherInt(r13)
            android.view.ViewGroup$LayoutParams r6 = r7.getLayoutParams()
            r13 = r6
            com.google.android.flexbox.FlexboxLayoutManager$LayoutParams r13 = (com.google.android.flexbox.FlexboxLayoutManager.LayoutParams) r13
            boolean r6 = r0.shouldMeasureChild(r7, r4, r5, r13)
            if (r6 == 0) goto L_0x0104
            r7.measure(r4, r5)
        L_0x0104:
            int r4 = r13.topMargin
            int r5 = r0.getTopDecorationHeight(r7)
            int r4 = r4 + r5
            float r4 = (float) r4
            float r14 = r1 + r4
            int r1 = r13.rightMargin
            int r4 = r0.getBottomDecorationHeight(r7)
            int r1 = r1 + r4
            float r1 = (float) r1
            float r18 = r2 - r1
            int r1 = r27.mLayoutDirection
            r6 = 1
            if (r1 != r6) goto L_0x0128
            android.graphics.Rect r1 = TEMP_RECT
            r0.calculateItemDecorationsForChild(r7, r1)
            r0.addView(r7)
            goto L_0x0132
        L_0x0128:
            android.graphics.Rect r1 = TEMP_RECT
            r0.calculateItemDecorationsForChild(r7, r1)
            r0.addView(r7, r3)
            int r3 = r3 + 1
        L_0x0132:
            r16 = r3
            int r1 = r0.getLeftDecorationWidth(r7)
            int r5 = r10 + r1
            int r1 = r0.getRightDecorationWidth(r7)
            int r19 = r11 - r1
            boolean r4 = r0.mIsRtl
            if (r4 == 0) goto L_0x0198
            boolean r1 = r0.mFromBottomToTop
            if (r1 == 0) goto L_0x0172
            com.google.android.flexbox.FlexboxHelper r1 = r0.mFlexboxHelper
            int r2 = r7.getMeasuredWidth()
            int r5 = r19 - r2
            int r2 = java.lang.Math.round(r18)
            int r3 = r7.getMeasuredHeight()
            int r20 = r2 - r3
            int r21 = java.lang.Math.round(r18)
            r2 = r7
            r3 = r26
            r22 = r6
            r6 = r20
            r20 = r7
            r7 = r19
            r23 = r8
            r8 = r21
            r1.layoutSingleChildVertical(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x01dd
        L_0x0172:
            r22 = r6
            r20 = r7
            r23 = r8
            com.google.android.flexbox.FlexboxHelper r1 = r0.mFlexboxHelper
            int r2 = r20.getMeasuredWidth()
            int r5 = r19 - r2
            int r6 = java.lang.Math.round(r14)
            int r2 = java.lang.Math.round(r14)
            int r3 = r20.getMeasuredHeight()
            int r8 = r2 + r3
            r2 = r20
            r3 = r26
            r7 = r19
            r1.layoutSingleChildVertical(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x01dd
        L_0x0198:
            r22 = r6
            r20 = r7
            r23 = r8
            boolean r1 = r0.mFromBottomToTop
            if (r1 == 0) goto L_0x01c0
            com.google.android.flexbox.FlexboxHelper r1 = r0.mFlexboxHelper
            int r2 = java.lang.Math.round(r18)
            int r3 = r20.getMeasuredHeight()
            int r6 = r2 - r3
            int r2 = r20.getMeasuredWidth()
            int r7 = r5 + r2
            int r8 = java.lang.Math.round(r18)
            r2 = r20
            r3 = r26
            r1.layoutSingleChildVertical(r2, r3, r4, r5, r6, r7, r8)
            goto L_0x01dd
        L_0x01c0:
            com.google.android.flexbox.FlexboxHelper r1 = r0.mFlexboxHelper
            int r6 = java.lang.Math.round(r14)
            int r2 = r20.getMeasuredWidth()
            int r7 = r5 + r2
            int r2 = java.lang.Math.round(r14)
            int r3 = r20.getMeasuredHeight()
            int r8 = r2 + r3
            r2 = r20
            r3 = r26
            r1.layoutSingleChildVertical(r2, r3, r4, r5, r6, r7, r8)
        L_0x01dd:
            int r1 = r20.getMeasuredHeight()
            int r2 = r13.topMargin
            int r1 = r1 + r2
            r2 = r20
            int r3 = r0.getBottomDecorationHeight(r2)
            int r1 = r1 + r3
            float r1 = (float) r1
            float r1 = r1 + r17
            float r14 = r14 + r1
            int r1 = r2.getMeasuredHeight()
            int r3 = r13.bottomMargin
            int r1 = r1 + r3
            int r2 = r0.getTopDecorationHeight(r2)
            int r1 = r1 + r2
            float r1 = (float) r1
            float r1 = r1 + r17
            float r18 = r18 - r1
            r1 = r14
            r3 = r16
            r2 = r18
        L_0x0205:
            int r8 = r23 + 1
            r14 = r17
            r13 = r22
            goto L_0x00d0
        L_0x020d:
            com.google.android.flexbox.FlexboxLayoutManager$LayoutState r1 = r0.mLayoutState
            int r1 = r1.mLayoutDirection
            r2 = r27
            com.google.android.flexbox.FlexboxLayoutManager.LayoutState.access$1512(r2, r1)
            int r1 = r26.getCrossSize()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.layoutFlexLineMainAxisVertical(com.google.android.flexbox.FlexLine, com.google.android.flexbox.FlexboxLayoutManager$LayoutState):int");
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mShouldRecycle) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFlexLinesFromEnd(recycler, layoutState);
            } else {
                recycleFlexLinesFromStart(recycler, layoutState);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i11, int i12) {
        while (i12 >= i11) {
            removeAndRecycleViewAt(i12, recycler);
            i12--;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r1 = r0 - 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void recycleFlexLinesFromEnd(androidx.recyclerview.widget.RecyclerView.Recycler r8, com.google.android.flexbox.FlexboxLayoutManager.LayoutState r9) {
        /*
            r7 = this;
            int r0 = r9.mScrollingOffset
            if (r0 >= 0) goto L_0x0007
            return
        L_0x0007:
            int r0 = r7.getChildCount()
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            int r1 = r0 + -1
            android.view.View r2 = r7.getChildAt(r1)
            if (r2 != 0) goto L_0x0017
            return
        L_0x0017:
            com.google.android.flexbox.FlexboxHelper r3 = r7.mFlexboxHelper
            int[] r3 = r3.mIndexToFlexLine
            int r2 = r7.getPosition(r2)
            r2 = r3[r2]
            r3 = -1
            if (r2 != r3) goto L_0x0025
            return
        L_0x0025:
            java.util.List<com.google.android.flexbox.FlexLine> r3 = r7.mFlexLines
            java.lang.Object r3 = r3.get(r2)
            com.google.android.flexbox.FlexLine r3 = (com.google.android.flexbox.FlexLine) r3
            r4 = r1
        L_0x002e:
            if (r4 < 0) goto L_0x005f
            android.view.View r5 = r7.getChildAt(r4)
            if (r5 != 0) goto L_0x0037
            goto L_0x005c
        L_0x0037:
            int r6 = r9.mScrollingOffset
            boolean r6 = r7.canViewBeRecycledFromEnd(r5, r6)
            if (r6 == 0) goto L_0x005f
            int r6 = r3.mFirstIndex
            int r5 = r7.getPosition(r5)
            if (r6 != r5) goto L_0x005c
            if (r2 > 0) goto L_0x004d
            r0 = r4
            goto L_0x005f
        L_0x004d:
            int r0 = r9.mLayoutDirection
            int r2 = r2 + r0
            java.util.List<com.google.android.flexbox.FlexLine> r0 = r7.mFlexLines
            java.lang.Object r0 = r0.get(r2)
            com.google.android.flexbox.FlexLine r0 = (com.google.android.flexbox.FlexLine) r0
            r3 = r0
            r0 = r4
        L_0x005c:
            int r4 = r4 + -1
            goto L_0x002e
        L_0x005f:
            r7.recycleChildren(r8, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.recycleFlexLinesFromEnd(androidx.recyclerview.widget.RecyclerView$Recycler, com.google.android.flexbox.FlexboxLayoutManager$LayoutState):void");
    }

    private void recycleFlexLinesFromStart(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int childCount;
        View childAt;
        if (layoutState.mScrollingOffset >= 0 && (childCount = getChildCount()) != 0 && (childAt = getChildAt(0)) != null) {
            int i11 = this.mFlexboxHelper.mIndexToFlexLine[getPosition(childAt)];
            int i12 = -1;
            if (i11 != -1) {
                FlexLine flexLine = this.mFlexLines.get(i11);
                int i13 = 0;
                while (true) {
                    if (i13 >= childCount) {
                        break;
                    }
                    View childAt2 = getChildAt(i13);
                    if (childAt2 != null) {
                        if (!canViewBeRecycledFromStart(childAt2, layoutState.mScrollingOffset)) {
                            break;
                        } else if (flexLine.mLastIndex != getPosition(childAt2)) {
                            continue;
                        } else if (i11 >= this.mFlexLines.size() - 1) {
                            i12 = i13;
                            break;
                        } else {
                            i11 += layoutState.mLayoutDirection;
                            flexLine = this.mFlexLines.get(i11);
                            i12 = i13;
                        }
                    }
                    i13++;
                }
                recycleChildren(recycler, 0, i12);
            }
        }
    }

    private void resolveInfiniteAmount() {
        int i11;
        if (isMainAxisDirectionHorizontal()) {
            i11 = getHeightMode();
        } else {
            i11 = getWidthMode();
        }
        boolean unused = this.mLayoutState.mInfinite = i11 == 0 || i11 == Integer.MIN_VALUE;
    }

    private void resolveLayoutDirection() {
        int layoutDirection = getLayoutDirection();
        int i11 = this.mFlexDirection;
        boolean z11 = false;
        if (i11 == 0) {
            this.mIsRtl = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                z11 = true;
            }
            this.mFromBottomToTop = z11;
        } else if (i11 == 1) {
            this.mIsRtl = layoutDirection != 1;
            if (this.mFlexWrap == 2) {
                z11 = true;
            }
            this.mFromBottomToTop = z11;
        } else if (i11 == 2) {
            boolean z12 = layoutDirection == 1;
            this.mIsRtl = z12;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z12;
            }
            this.mFromBottomToTop = false;
        } else if (i11 != 3) {
            this.mIsRtl = false;
            this.mFromBottomToTop = false;
        } else {
            if (layoutDirection == 1) {
                z11 = true;
            }
            this.mIsRtl = z11;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z11;
            }
            this.mFromBottomToTop = true;
        }
    }

    private boolean shouldMeasureChild(View view, int i11, int i12, RecyclerView.LayoutParams layoutParams) {
        return view.isLayoutRequested() || !isMeasurementCacheEnabled() || !isMeasurementUpToDate(view.getWidth(), i11, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i12, layoutParams.height);
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        View view;
        int i11;
        boolean z11 = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (anchorInfo.mLayoutFromEnd) {
            view = findLastReferenceChild(state.b());
        } else {
            view = findFirstReferenceChild(state.b());
        }
        if (view == null) {
            return false;
        }
        anchorInfo.assignFromView(view);
        if (!state.e() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.g(view) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(view) < this.mOrientationHelper.m()) {
                z11 = true;
            }
            if (z11) {
                if (anchorInfo.mLayoutFromEnd) {
                    i11 = this.mOrientationHelper.i();
                } else {
                    i11 = this.mOrientationHelper.m();
                }
                int unused = anchorInfo.mCoordinate = i11;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingState(RecyclerView.State state, AnchorInfo anchorInfo, SavedState savedState) {
        int i11;
        View childAt;
        int i12;
        boolean z11 = false;
        if (!state.e() && (i11 = this.mPendingScrollPosition) != -1) {
            if (i11 < 0 || i11 >= state.b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                int unused = anchorInfo.mPosition = this.mPendingScrollPosition;
                int unused2 = anchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[anchorInfo.mPosition];
                SavedState savedState2 = this.mPendingSavedState;
                if (savedState2 != null && savedState2.hasValidAnchor(state.b())) {
                    int unused3 = anchorInfo.mCoordinate = this.mOrientationHelper.m() + savedState.mAnchorOffset;
                    boolean unused4 = anchorInfo.mAssignedFromSavedState = true;
                    int unused5 = anchorInfo.mFlexLinePosition = -1;
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0 && (childAt = getChildAt(0)) != null) {
                            if (this.mPendingScrollPosition < getPosition(childAt)) {
                                z11 = true;
                            }
                            boolean unused6 = anchorInfo.mLayoutFromEnd = z11;
                        }
                        anchorInfo.assignCoordinateFromPadding();
                    } else if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                        anchorInfo.assignCoordinateFromPadding();
                        return true;
                    } else if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                        int unused7 = anchorInfo.mCoordinate = this.mOrientationHelper.m();
                        boolean unused8 = anchorInfo.mLayoutFromEnd = false;
                        return true;
                    } else if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                        int unused9 = anchorInfo.mCoordinate = this.mOrientationHelper.i();
                        boolean unused10 = anchorInfo.mLayoutFromEnd = true;
                        return true;
                    } else {
                        if (anchorInfo.mLayoutFromEnd) {
                            i12 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o();
                        } else {
                            i12 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        int unused11 = anchorInfo.mCoordinate = i12;
                    }
                    return true;
                } else {
                    if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
                        int unused12 = anchorInfo.mCoordinate = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                    } else {
                        int unused13 = anchorInfo.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.j();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingState(state, anchorInfo, this.mPendingSavedState) && !updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            int unused = anchorInfo.mPosition = 0;
            int unused2 = anchorInfo.mFlexLinePosition = 0;
        }
    }

    private void updateDirtyPosition(int i11) {
        if (i11 < findLastVisibleItemPosition()) {
            int childCount = getChildCount();
            this.mFlexboxHelper.ensureMeasureSpecCache(childCount);
            this.mFlexboxHelper.ensureMeasuredSizeCache(childCount);
            this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
            if (i11 < this.mFlexboxHelper.mIndexToFlexLine.length) {
                this.mDirtyPosition = i11;
                View childClosestToStart = getChildClosestToStart();
                if (childClosestToStart != null) {
                    this.mPendingScrollPosition = getPosition(childClosestToStart);
                    if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
                        this.mPendingScrollPositionOffset = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.m();
                    } else {
                        this.mPendingScrollPositionOffset = this.mOrientationHelper.d(childClosestToStart) + this.mOrientationHelper.j();
                    }
                }
            }
        }
    }

    private void updateFlexLines(int i11) {
        int i12;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z11 = true;
        if (isMainAxisDirectionHorizontal()) {
            int i13 = this.mLastWidth;
            if (i13 == Integer.MIN_VALUE || i13 == width) {
                z11 = false;
            }
            if (this.mLayoutState.mInfinite) {
                i12 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i12 = this.mLayoutState.mAvailable;
            }
        } else {
            int i14 = this.mLastHeight;
            if (i14 == Integer.MIN_VALUE || i14 == height) {
                z11 = false;
            }
            if (this.mLayoutState.mInfinite) {
                i12 = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i12 = this.mLayoutState.mAvailable;
            }
        }
        int i15 = i12;
        this.mLastWidth = width;
        this.mLastHeight = height;
        int i16 = this.mDirtyPosition;
        if (i16 != -1 || (this.mPendingScrollPosition == -1 && !z11)) {
            int min = i16 != -1 ? Math.min(i16, this.mAnchorInfo.mPosition) : this.mAnchorInfo.mPosition;
            this.mFlexLinesResult.reset();
            if (isMainAxisDirectionHorizontal()) {
                if (this.mFlexLines.size() > 0) {
                    this.mFlexboxHelper.clearFlexLines(this.mFlexLines, min);
                    this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i15, min, this.mAnchorInfo.mPosition, this.mFlexLines);
                } else {
                    this.mFlexboxHelper.ensureIndexToFlexLine(i11);
                    this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i15, 0, this.mFlexLines);
                }
            } else if (this.mFlexLines.size() > 0) {
                this.mFlexboxHelper.clearFlexLines(this.mFlexLines, min);
                this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, makeMeasureSpec2, makeMeasureSpec, i15, min, this.mAnchorInfo.mPosition, this.mFlexLines);
            } else {
                this.mFlexboxHelper.ensureIndexToFlexLine(i11);
                this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i15, 0, this.mFlexLines);
            }
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, min);
            this.mFlexboxHelper.stretchViews(min);
        } else if (!this.mAnchorInfo.mLayoutFromEnd) {
            this.mFlexLines.clear();
            this.mFlexLinesResult.reset();
            if (isMainAxisDirectionHorizontal()) {
                this.mFlexboxHelper.calculateHorizontalFlexLinesToIndex(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i15, this.mAnchorInfo.mPosition, this.mFlexLines);
            } else {
                this.mFlexboxHelper.calculateVerticalFlexLinesToIndex(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, i15, this.mAnchorInfo.mPosition, this.mFlexLines);
            }
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2);
            this.mFlexboxHelper.stretchViews();
            AnchorInfo anchorInfo = this.mAnchorInfo;
            int unused = anchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[anchorInfo.mPosition];
            int unused2 = this.mLayoutState.mFlexLinePosition = this.mAnchorInfo.mFlexLinePosition;
        }
    }

    private void updateLayoutState(int i11, int i12) {
        int unused = this.mLayoutState.mLayoutDirection = i11;
        boolean isMainAxisDirectionHorizontal = isMainAxisDirectionHorizontal();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z11 = !isMainAxisDirectionHorizontal && this.mIsRtl;
        if (i11 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null) {
                int unused2 = this.mLayoutState.mOffset = this.mOrientationHelper.d(childAt);
                int position = getPosition(childAt);
                View findLastReferenceViewInLine = findLastReferenceViewInLine(childAt, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[position]));
                int unused3 = this.mLayoutState.mItemDirection = 1;
                LayoutState layoutState = this.mLayoutState;
                int unused4 = layoutState.mPosition = position + layoutState.mItemDirection;
                if (this.mFlexboxHelper.mIndexToFlexLine.length <= this.mLayoutState.mPosition) {
                    int unused5 = this.mLayoutState.mFlexLinePosition = -1;
                } else {
                    LayoutState layoutState2 = this.mLayoutState;
                    int unused6 = layoutState2.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[layoutState2.mPosition];
                }
                if (z11) {
                    int unused7 = this.mLayoutState.mOffset = this.mOrientationHelper.g(findLastReferenceViewInLine);
                    int unused8 = this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.g(findLastReferenceViewInLine)) + this.mOrientationHelper.m();
                    LayoutState layoutState3 = this.mLayoutState;
                    int unused9 = layoutState3.mScrollingOffset = Math.max(layoutState3.mScrollingOffset, 0);
                } else {
                    int unused10 = this.mLayoutState.mOffset = this.mOrientationHelper.d(findLastReferenceViewInLine);
                    int unused11 = this.mLayoutState.mScrollingOffset = this.mOrientationHelper.d(findLastReferenceViewInLine) - this.mOrientationHelper.i();
                }
                if ((this.mLayoutState.mFlexLinePosition == -1 || this.mLayoutState.mFlexLinePosition > this.mFlexLines.size() - 1) && this.mLayoutState.mPosition <= getFlexItemCount()) {
                    int access$2000 = i12 - this.mLayoutState.mScrollingOffset;
                    this.mFlexLinesResult.reset();
                    if (access$2000 > 0) {
                        if (isMainAxisDirectionHorizontal) {
                            this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, access$2000, this.mLayoutState.mPosition, this.mFlexLines);
                        } else {
                            this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, makeMeasureSpec, makeMeasureSpec2, access$2000, this.mLayoutState.mPosition, this.mFlexLines);
                        }
                        this.mFlexboxHelper.determineMainSize(makeMeasureSpec, makeMeasureSpec2, this.mLayoutState.mPosition);
                        this.mFlexboxHelper.stretchViews(this.mLayoutState.mPosition);
                    }
                }
            } else {
                return;
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 != null) {
                int unused12 = this.mLayoutState.mOffset = this.mOrientationHelper.g(childAt2);
                int position2 = getPosition(childAt2);
                View findFirstReferenceViewInLine = findFirstReferenceViewInLine(childAt2, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[position2]));
                int unused13 = this.mLayoutState.mItemDirection = 1;
                int i13 = this.mFlexboxHelper.mIndexToFlexLine[position2];
                if (i13 == -1) {
                    i13 = 0;
                }
                if (i13 > 0) {
                    int unused14 = this.mLayoutState.mPosition = position2 - this.mFlexLines.get(i13 - 1).getItemCount();
                } else {
                    int unused15 = this.mLayoutState.mPosition = -1;
                }
                int unused16 = this.mLayoutState.mFlexLinePosition = i13 > 0 ? i13 - 1 : 0;
                if (z11) {
                    int unused17 = this.mLayoutState.mOffset = this.mOrientationHelper.d(findFirstReferenceViewInLine);
                    int unused18 = this.mLayoutState.mScrollingOffset = this.mOrientationHelper.d(findFirstReferenceViewInLine) - this.mOrientationHelper.i();
                    LayoutState layoutState4 = this.mLayoutState;
                    int unused19 = layoutState4.mScrollingOffset = Math.max(layoutState4.mScrollingOffset, 0);
                } else {
                    int unused20 = this.mLayoutState.mOffset = this.mOrientationHelper.g(findFirstReferenceViewInLine);
                    int unused21 = this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.g(findFirstReferenceViewInLine)) + this.mOrientationHelper.m();
                }
            } else {
                return;
            }
        }
        LayoutState layoutState5 = this.mLayoutState;
        int unused22 = layoutState5.mAvailable = i12 - layoutState5.mScrollingOffset;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo, boolean z11, boolean z12) {
        if (z12) {
            resolveInfiniteAmount();
        } else {
            boolean unused = this.mLayoutState.mInfinite = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            int unused2 = this.mLayoutState.mAvailable = this.mOrientationHelper.i() - anchorInfo.mCoordinate;
        } else {
            int unused3 = this.mLayoutState.mAvailable = anchorInfo.mCoordinate - getPaddingRight();
        }
        int unused4 = this.mLayoutState.mPosition = anchorInfo.mPosition;
        int unused5 = this.mLayoutState.mItemDirection = 1;
        int unused6 = this.mLayoutState.mLayoutDirection = 1;
        int unused7 = this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        int unused8 = this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        int unused9 = this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (z11 && this.mFlexLines.size() > 1 && anchorInfo.mFlexLinePosition >= 0 && anchorInfo.mFlexLinePosition < this.mFlexLines.size() - 1) {
            LayoutState.access$1508(this.mLayoutState);
            LayoutState.access$2212(this.mLayoutState, this.mFlexLines.get(anchorInfo.mFlexLinePosition).getItemCount());
        }
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo, boolean z11, boolean z12) {
        if (z12) {
            resolveInfiniteAmount();
        } else {
            boolean unused = this.mLayoutState.mInfinite = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            int unused2 = this.mLayoutState.mAvailable = anchorInfo.mCoordinate - this.mOrientationHelper.m();
        } else {
            int unused3 = this.mLayoutState.mAvailable = (this.mParent.getWidth() - anchorInfo.mCoordinate) - this.mOrientationHelper.m();
        }
        int unused4 = this.mLayoutState.mPosition = anchorInfo.mPosition;
        int unused5 = this.mLayoutState.mItemDirection = 1;
        int unused6 = this.mLayoutState.mLayoutDirection = -1;
        int unused7 = this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        int unused8 = this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        int unused9 = this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (z11 && anchorInfo.mFlexLinePosition > 0 && this.mFlexLines.size() > anchorInfo.mFlexLinePosition) {
            LayoutState.access$1510(this.mLayoutState);
            LayoutState.access$2220(this.mLayoutState, this.mFlexLines.get(anchorInfo.mFlexLinePosition).getItemCount());
        }
    }

    public boolean canScrollHorizontally() {
        if (this.mFlexWrap == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.mParent;
            return width > (view != null ? view.getWidth() : 0);
        }
    }

    public boolean canScrollVertically() {
        if (this.mFlexWrap == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.mParent;
        if (height > (view != null ? view.getHeight() : 0)) {
            return true;
        }
        return false;
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public PointF computeScrollVectorForPosition(int i11) {
        View childAt;
        if (getChildCount() == 0 || (childAt = getChildAt(0)) == null) {
            return null;
        }
        int i12 = i11 < getPosition(childAt) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, (float) i12);
        }
        return new PointF((float) i12, 0.0f);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public int getAlignContent() {
        return 5;
    }

    public int getAlignItems() {
        return this.mAlignItems;
    }

    public int getChildHeightMeasureSpec(int i11, int i12, int i13) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i12, i13, canScrollVertically());
    }

    public int getChildWidthMeasureSpec(int i11, int i12, int i13) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i12, i13, canScrollHorizontally());
    }

    public int getDecorationLengthCrossAxis(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (isMainAxisDirectionHorizontal()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    public int getDecorationLengthMainAxis(View view, int i11, int i12) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (isMainAxisDirectionHorizontal()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    public View getFlexItemAt(int i11) {
        View view = this.mViewCache.get(i11);
        if (view != null) {
            return view;
        }
        return this.mRecycler.o(i11);
    }

    public int getFlexItemCount() {
        return this.mState.b();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        int size = this.mFlexLines.size();
        for (int i11 = 0; i11 < size; i11++) {
            FlexLine flexLine = this.mFlexLines.get(i11);
            if (flexLine.getItemCount() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    public int getLargestMainSize() {
        if (this.mFlexLines.size() == 0) {
            return 0;
        }
        int i11 = Integer.MIN_VALUE;
        int size = this.mFlexLines.size();
        for (int i12 = 0; i12 < size; i12++) {
            i11 = Math.max(i11, this.mFlexLines.get(i12).mMainSize);
        }
        return i11;
    }

    public int getMaxLine() {
        return this.mMaxLine;
    }

    public int getPositionToFlexLineIndex(int i11) {
        return this.mFlexboxHelper.mIndexToFlexLine[i11];
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public View getReorderedFlexItemAt(int i11) {
        return getFlexItemAt(i11);
    }

    public int getSumOfCrossSize() {
        int size = this.mFlexLines.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += this.mFlexLines.get(i12).mCrossSize;
        }
        return i11;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRtl() {
        return this.mIsRtl;
    }

    public boolean isMainAxisDirectionHorizontal() {
        int i11 = this.mFlexDirection;
        return i11 == 0 || i11 == 1;
    }

    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mParent = (View) recyclerView.getParent();
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.c();
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsAdded(recyclerView, i11, i12);
        updateDirtyPosition(i11);
    }

    public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        super.onItemsMoved(recyclerView, i11, i12, i13);
        updateDirtyPosition(Math.min(i11, i12));
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsRemoved(recyclerView, i11, i12);
        updateDirtyPosition(i11);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
        super.onItemsUpdated(recyclerView, i11, i12, obj);
        updateDirtyPosition(i11);
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i11;
        int i12;
        this.mRecycler = recycler;
        this.mState = state;
        int b11 = state.b();
        if (b11 != 0 || !state.e()) {
            resolveLayoutDirection();
            ensureOrientationHelper();
            ensureLayoutState();
            this.mFlexboxHelper.ensureMeasureSpecCache(b11);
            this.mFlexboxHelper.ensureMeasuredSizeCache(b11);
            this.mFlexboxHelper.ensureIndexToFlexLine(b11);
            boolean unused = this.mLayoutState.mShouldRecycle = false;
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null && savedState.hasValidAnchor(b11)) {
                this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            }
            if (!(this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null)) {
                this.mAnchorInfo.reset();
                updateAnchorInfoForLayout(state, this.mAnchorInfo);
                boolean unused2 = this.mAnchorInfo.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mAnchorInfo.mLayoutFromEnd) {
                updateLayoutStateToFillStart(this.mAnchorInfo, false, true);
            } else {
                updateLayoutStateToFillEnd(this.mAnchorInfo, false, true);
            }
            updateFlexLines(b11);
            fill(recycler, state, this.mLayoutState);
            if (this.mAnchorInfo.mLayoutFromEnd) {
                i12 = this.mLayoutState.mOffset;
                updateLayoutStateToFillEnd(this.mAnchorInfo, true, false);
                fill(recycler, state, this.mLayoutState);
                i11 = this.mLayoutState.mOffset;
            } else {
                i11 = this.mLayoutState.mOffset;
                updateLayoutStateToFillStart(this.mAnchorInfo, true, false);
                fill(recycler, state, this.mLayoutState);
                i12 = this.mLayoutState.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mAnchorInfo.mLayoutFromEnd) {
                fixLayoutStartGap(i12 + fixLayoutEndGap(i11, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i11 + fixLayoutStartGap(i12, recycler, state, true), recycler, state, false);
            }
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mDirtyPosition = -1;
        this.mAnchorInfo.reset();
        this.mViewCache.clear();
    }

    public void onNewFlexItemAdded(View view, int i11, int i12, FlexLine flexLine) {
        calculateItemDecorationsForChild(view, TEMP_RECT);
        if (isMainAxisDirectionHorizontal()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.mMainSize += leftDecorationWidth;
            flexLine.mDividerLengthInMainSize += leftDecorationWidth;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        flexLine.mMainSize += topDecorationHeight;
        flexLine.mDividerLengthInMainSize += topDecorationHeight;
    }

    public void onNewFlexLineAdded(FlexLine flexLine) {
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View childClosestToStart = getChildClosestToStart();
            int unused = savedState.mAnchorPosition = getPosition(childClosestToStart);
            int unused2 = savedState.mAnchorOffset = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.m();
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public int scrollHorizontallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || this.mFlexWrap == 0) {
            int handleScrollingMainOrientation = handleScrollingMainOrientation(i11, recycler, state);
            this.mViewCache.clear();
            return handleScrollingMainOrientation;
        }
        int handleScrollingSubOrientation = handleScrollingSubOrientation(i11);
        AnchorInfo.access$2412(this.mAnchorInfo, handleScrollingSubOrientation);
        this.mSubOrientationHelper.r(-handleScrollingSubOrientation);
        return handleScrollingSubOrientation;
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

    public int scrollVerticallyBy(int i11, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.mFlexWrap == 0 && !isMainAxisDirectionHorizontal())) {
            int handleScrollingMainOrientation = handleScrollingMainOrientation(i11, recycler, state);
            this.mViewCache.clear();
            return handleScrollingMainOrientation;
        }
        int handleScrollingSubOrientation = handleScrollingSubOrientation(i11);
        AnchorInfo.access$2412(this.mAnchorInfo, handleScrollingSubOrientation);
        this.mSubOrientationHelper.r(-handleScrollingSubOrientation);
        return handleScrollingSubOrientation;
    }

    public void setAlignContent(int i11) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    public void setAlignItems(int i11) {
        int i12 = this.mAlignItems;
        if (i12 != i11) {
            if (i12 == 4 || i11 == 4) {
                removeAllViews();
                clearFlexLines();
            }
            this.mAlignItems = i11;
            requestLayout();
        }
    }

    public void setFlexDirection(int i11) {
        if (this.mFlexDirection != i11) {
            removeAllViews();
            this.mFlexDirection = i11;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            clearFlexLines();
            requestLayout();
        }
    }

    public void setFlexLines(List<FlexLine> list) {
        this.mFlexLines = list;
    }

    public void setFlexWrap(int i11) {
        if (i11 != 2) {
            int i12 = this.mFlexWrap;
            if (i12 != i11) {
                if (i12 == 0 || i11 == 0) {
                    removeAllViews();
                    clearFlexLines();
                }
                this.mFlexWrap = i11;
                this.mOrientationHelper = null;
                this.mSubOrientationHelper = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    public void setJustifyContent(int i11) {
        if (this.mJustifyContent != i11) {
            this.mJustifyContent = i11;
            requestLayout();
        }
    }

    public void setMaxLine(int i11) {
        if (this.mMaxLine != i11) {
            this.mMaxLine = i11;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z11) {
        this.mRecycleChildrenOnDetach = z11;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
        n nVar = new n(recyclerView.getContext());
        nVar.setTargetPosition(i11);
        startSmoothScroll(nVar);
    }

    public void updateViewCache(int i11, View view) {
        this.mViewCache.put(i11, view);
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };
        /* access modifiers changed from: private */
        public int mAnchorOffset;
        /* access modifiers changed from: private */
        public int mAnchorPosition;

        /* access modifiers changed from: private */
        public boolean hasValidAnchor(int i11) {
            int i12 = this.mAnchorPosition;
            return i12 >= 0 && i12 < i11;
        }

        /* access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        public SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int i11) {
        this(context, i11, 1);
    }

    public FlexboxLayoutManager(Context context, int i11, int i12) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        setFlexDirection(i11);
        setFlexWrap(i12);
        setAlignItems(4);
        this.mContext = context;
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsUpdated(recyclerView, i11, i12);
        updateDirtyPosition(i11);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            public LayoutParams[] newArray(int i11) {
                return new LayoutParams[i11];
            }
        };
        private int mAlignSelf = -1;
        private float mFlexBasisPercent = -1.0f;
        private float mFlexGrow = 0.0f;
        private float mFlexShrink = 1.0f;
        private int mMaxHeight = FlexItem.MAX_SIZE;
        private int mMaxWidth = FlexItem.MAX_SIZE;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int describeContents() {
            return 0;
        }

        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        public int getHeight() {
            return this.height;
        }

        public int getMarginBottom() {
            return this.bottomMargin;
        }

        public int getMarginLeft() {
            return this.leftMargin;
        }

        public int getMarginRight() {
            return this.rightMargin;
        }

        public int getMarginTop() {
            return this.topMargin;
        }

        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        public int getMinHeight() {
            return this.mMinHeight;
        }

        public int getMinWidth() {
            return this.mMinWidth;
        }

        public int getOrder() {
            return 1;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setAlignSelf(int i11) {
            this.mAlignSelf = i11;
        }

        public void setFlexBasisPercent(float f11) {
            this.mFlexBasisPercent = f11;
        }

        public void setFlexGrow(float f11) {
            this.mFlexGrow = f11;
        }

        public void setFlexShrink(float f11) {
            this.mFlexShrink = f11;
        }

        public void setHeight(int i11) {
            this.height = i11;
        }

        public void setMaxHeight(int i11) {
            this.mMaxHeight = i11;
        }

        public void setMaxWidth(int i11) {
            this.mMaxWidth = i11;
        }

        public void setMinHeight(int i11) {
            this.mMinHeight = i11;
        }

        public void setMinWidth(int i11) {
            this.mMinWidth = i11;
        }

        public void setOrder(int i11) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        public void setWidth(int i11) {
            this.width = i11;
        }

        public void setWrapBefore(boolean z11) {
            this.mWrapBefore = z11;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
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

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i11, i12);
        int i13 = properties.orientation;
        if (i13 != 0) {
            if (i13 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.mContext = context;
    }
}
