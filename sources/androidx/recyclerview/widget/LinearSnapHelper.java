package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class LinearSnapHelper extends SnapHelper {

    /* renamed from: a  reason: collision with root package name */
    public r f10685a;

    /* renamed from: b  reason: collision with root package name */
    public r f10686b;

    public final float a(RecyclerView.LayoutManager layoutManager, r rVar) {
        int max;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        View view = null;
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        View view2 = null;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = layoutManager.getChildAt(i13);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i12) {
                    view = childAt;
                    i12 = position;
                }
                if (position > i11) {
                    view2 = childAt;
                    i11 = position;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(rVar.d(view), rVar.d(view2)) - Math.min(rVar.g(view), rVar.g(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i11 - i12) + 1));
    }

    public final int b(RecyclerView.LayoutManager layoutManager, r rVar, int i11, int i12) {
        int[] calculateScrollDistance = calculateScrollDistance(i11, i12);
        float a11 = a(layoutManager, rVar);
        if (a11 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1])) / a11);
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

    public final int distanceToCenter(View view, r rVar) {
        return (rVar.g(view) + (rVar.e(view) / 2)) - (rVar.m() + (rVar.n() / 2));
    }

    public final View findCenterView(RecyclerView.LayoutManager layoutManager, r rVar) {
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

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findCenterView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i11, int i12) {
        int itemCount;
        View findSnapView;
        int position;
        int i13;
        PointF computeScrollVectorForPosition;
        int i14;
        int i15;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.b) || (itemCount = layoutManager.getItemCount()) == 0 || (findSnapView = findSnapView(layoutManager)) == null || (position = layoutManager.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.b) layoutManager).computeScrollVectorForPosition(i13)) == null) {
            return -1;
        }
        int i16 = 0;
        if (layoutManager.canScrollHorizontally()) {
            i14 = b(layoutManager, getHorizontalHelper(layoutManager), i11, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i14 = -i14;
            }
        } else {
            i14 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i15 = b(layoutManager, getVerticalHelper(layoutManager), 0, i12);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i15 = -i15;
            }
        } else {
            i15 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i14 = i15;
        }
        if (i14 == 0) {
            return -1;
        }
        int i17 = position + i14;
        if (i17 >= 0) {
            i16 = i17;
        }
        return i16 >= itemCount ? itemCount - 1 : i16;
    }

    public final r getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        r rVar = this.f10686b;
        if (rVar == null || rVar.f10914a != layoutManager) {
            this.f10686b = r.a(layoutManager);
        }
        return this.f10686b;
    }

    public final r getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        r rVar = this.f10685a;
        if (rVar == null || rVar.f10914a != layoutManager) {
            this.f10685a = r.c(layoutManager);
        }
        return this.f10685a;
    }
}
