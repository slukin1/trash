package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private r mHorizontalHelper;
    private r mVerticalHelper;

    public class a extends n {
        public a(Context context) {
            super(context);
        }

        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        public int calculateTimeForScrolling(int i11) {
            return Math.min(100, super.calculateTimeForScrolling(i11));
        }

        public void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.a aVar) {
            PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
            int[] calculateDistanceToFinalSnap = pagerSnapHelper.calculateDistanceToFinalSnap(pagerSnapHelper.mRecyclerView.getLayoutManager(), view);
            int i11 = calculateDistanceToFinalSnap[0];
            int i12 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i11), Math.abs(i12)));
            if (calculateTimeForDeceleration > 0) {
                aVar.d(i11, i12, calculateTimeForDeceleration, this.mDecelerateInterpolator);
            }
        }
    }

    private int distanceToCenter(View view, r rVar) {
        return (rVar.g(view) + (rVar.e(view) / 2)) - (rVar.m() + (rVar.n() / 2));
    }

    private View findCenterView(RecyclerView.LayoutManager layoutManager, r rVar) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int m11 = rVar.m() + (rVar.n() / 2);
        int i11 = Integer.MAX_VALUE;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = layoutManager.getChildAt(i12);
            int abs = Math.abs((rVar.g(childAt) + (rVar.e(childAt) / 2)) - m11);
            if (abs < i11) {
                view = childAt;
                i11 = abs;
            }
        }
        return view;
    }

    private r getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        r rVar = this.mHorizontalHelper;
        if (rVar == null || rVar.f10914a != layoutManager) {
            this.mHorizontalHelper = r.a(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    private r getOrientationHelper(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return getVerticalHelper(layoutManager);
        }
        if (layoutManager.canScrollHorizontally()) {
            return getHorizontalHelper(layoutManager);
        }
        return null;
    }

    private r getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        r rVar = this.mVerticalHelper;
        if (rVar == null || rVar.f10914a != layoutManager) {
            this.mVerticalHelper = r.c(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int i11, int i12) {
        return layoutManager.canScrollHorizontally() ? i11 > 0 : i12 > 0;
    }

    private boolean isReverseLayout(RecyclerView.LayoutManager layoutManager) {
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.b) || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.b) layoutManager).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return false;
        }
        if (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f) {
            return true;
        }
        return false;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.b)) {
            return null;
        }
        return new a(this.mRecyclerView.getContext());
    }

    @SuppressLint({"UnknownNullness"})
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i11, int i12) {
        r orientationHelper;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0 || (orientationHelper = getOrientationHelper(layoutManager)) == null) {
            return -1;
        }
        int i13 = Integer.MIN_VALUE;
        int i14 = Integer.MAX_VALUE;
        int childCount = layoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = layoutManager.getChildAt(i15);
            if (childAt != null) {
                int distanceToCenter = distanceToCenter(childAt, orientationHelper);
                if (distanceToCenter <= 0 && distanceToCenter > i13) {
                    view2 = childAt;
                    i13 = distanceToCenter;
                }
                if (distanceToCenter >= 0 && distanceToCenter < i14) {
                    view = childAt;
                    i14 = distanceToCenter;
                }
            }
        }
        boolean isForwardFling = isForwardFling(layoutManager, i11, i12);
        if (isForwardFling && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!isForwardFling && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (isForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view) + (isReverseLayout(layoutManager) == isForwardFling ? -1 : 1);
        if (position < 0 || position >= itemCount) {
            return -1;
        }
        return position;
    }
}
