package com.tencent.qcloud.tuikit.timcommon.component.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import androidx.core.view.f;
import androidx.core.view.h0;
import androidx.customview.widget.ViewDragHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SwipeLayout extends FrameLayout {
    private static final int DRAG_BOTTOM = 8;
    private static final int DRAG_LEFT = 1;
    private static final int DRAG_RIGHT = 2;
    private static final int DRAG_TOP = 4;
    private static final DragEdge DefaultDragEdge = DragEdge.Right;
    @Deprecated
    public static final int EMPTY_LAYOUT = -1;
    public View.OnClickListener clickListener;
    private GestureDetector gestureDetector;
    private Rect hitSurfaceRect;
    public View.OnLongClickListener longClickListener;
    /* access modifiers changed from: private */
    public boolean mClickToClose;
    /* access modifiers changed from: private */
    public DragEdge mCurrentDragEdge;
    /* access modifiers changed from: private */
    public DoubleClickListener mDoubleClickListener;
    /* access modifiers changed from: private */
    public int mDragDistance;
    private LinkedHashMap<DragEdge, View> mDragEdges;
    private ViewDragHelper mDragHelper;
    private ViewDragHelper.Callback mDragHelperCallback;
    private float[] mEdgeSwipesOffset;
    private int mEventCounter;
    private boolean mIsBeingDragged;
    private List<OnLayout> mOnLayoutListeners;
    private Map<View, ArrayList<OnRevealListener>> mRevealListeners;
    private Map<View, Boolean> mShowEntirely;
    /* access modifiers changed from: private */
    public ShowMode mShowMode;
    private List<SwipeDenier> mSwipeDeniers;
    private boolean mSwipeEnabled;
    /* access modifiers changed from: private */
    public List<SwipeListener> mSwipeListeners;
    private boolean[] mSwipesEnabled;
    private int mTouchSlop;
    private Map<View, Rect> mViewBoundCache;
    private float mWillOpenPercentAfterClose;
    private float mWillOpenPercentAfterOpen;
    private float sX;
    private float sY;

    /* renamed from: com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge[] r0 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge = r0
                com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r1 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Top     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge     // Catch:{ NoSuchFieldError -> 0x001d }
                com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r1 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Bottom     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r1 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Left     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r1 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Right     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.AnonymousClass4.<clinit>():void");
        }
    }

    public interface DoubleClickListener {
        void onClick();

        void onDoubleClick(SwipeLayout swipeLayout, boolean z11);
    }

    public enum DragEdge {
        Left,
        Top,
        Right,
        Bottom
    }

    public interface OnLayout {
        void onLayout(SwipeLayout swipeLayout);
    }

    public interface OnRevealListener {
        void onReveal(View view, DragEdge dragEdge, float f11, int i11);
    }

    public enum ShowMode {
        LayDown,
        PullOut
    }

    public enum Status {
        Middle,
        Open,
        Close
    }

    public interface SwipeDenier {
        boolean shouldDenySwipe(MotionEvent motionEvent);
    }

    public class SwipeDetector extends GestureDetector.SimpleOnGestureListener {
        public SwipeDetector() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (SwipeLayout.this.mDoubleClickListener != null) {
                View currentBottomView = SwipeLayout.this.getCurrentBottomView();
                View surfaceView = SwipeLayout.this.getSurfaceView();
                if (currentBottomView == null || motionEvent.getX() <= ((float) currentBottomView.getLeft()) || motionEvent.getX() >= ((float) currentBottomView.getRight()) || motionEvent.getY() <= ((float) currentBottomView.getTop()) || motionEvent.getY() >= ((float) currentBottomView.getBottom())) {
                    currentBottomView = surfaceView;
                }
                SwipeLayout.this.mDoubleClickListener.onDoubleClick(SwipeLayout.this, currentBottomView == surfaceView);
            }
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (SwipeLayout.this.isTouchOnSurface(motionEvent)) {
                if (SwipeLayout.this.mClickToClose) {
                    SwipeLayout.this.close();
                } else if (SwipeLayout.this.mDoubleClickListener != null) {
                    SwipeLayout.this.mDoubleClickListener.onClick();
                }
            }
            return super.onSingleTapUp(motionEvent);
        }
    }

    public interface SwipeListener {
        void onClose(SwipeLayout swipeLayout);

        void onHandRelease(SwipeLayout swipeLayout, float f11, float f12);

        void onOpen(SwipeLayout swipeLayout);

        void onStartClose(SwipeLayout swipeLayout);

        void onStartOpen(SwipeLayout swipeLayout);

        void onUpdate(SwipeLayout swipeLayout, int i11, int i12);
    }

    public SwipeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void captureChildrenBound() {
        View currentBottomView = getCurrentBottomView();
        if (getOpenStatus() == Status.Close) {
            this.mViewBoundCache.remove(currentBottomView);
            return;
        }
        View[] viewArr = {getSurfaceView(), currentBottomView};
        for (int i11 = 0; i11 < 2; i11++) {
            View view = viewArr[i11];
            Rect rect = this.mViewBoundCache.get(view);
            if (rect == null) {
                rect = new Rect();
                this.mViewBoundCache.put(view, rect);
            }
            rect.left = view.getLeft();
            rect.top = view.getTop();
            rect.right = view.getRight();
            rect.bottom = view.getBottom();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkCanDrag(android.view.MotionEvent r12) {
        /*
            r11 = this;
            boolean r0 = r11.mIsBeingDragged
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r0 = r11.getOpenStatus()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r1 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Middle
            r2 = 1
            if (r0 != r1) goto L_0x0011
            r11.mIsBeingDragged = r2
            return
        L_0x0011:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r0 = r11.getOpenStatus()
            float r3 = r12.getRawX()
            float r4 = r11.sX
            float r3 = r3 - r4
            float r12 = r12.getRawY()
            float r4 = r11.sY
            float r12 = r12 - r4
            float r4 = r12 / r3
            float r4 = java.lang.Math.abs(r4)
            double r4 = (double) r4
            double r4 = java.lang.Math.atan(r4)
            double r4 = java.lang.Math.toDegrees(r4)
            float r4 = (float) r4
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r5 = r11.getOpenStatus()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r6 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Close
            if (r5 != r6) goto L_0x007b
            r5 = 1110704128(0x42340000, float:45.0)
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            r7 = 0
            if (r5 >= 0) goto L_0x005d
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x004f
            boolean r5 = r11.isLeftSwipeEnabled()
            if (r5 == 0) goto L_0x004f
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r5 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Left
            goto L_0x0076
        L_0x004f:
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x005c
            boolean r5 = r11.isRightSwipeEnabled()
            if (r5 == 0) goto L_0x005c
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r5 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Right
            goto L_0x0076
        L_0x005c:
            return
        L_0x005d:
            int r5 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x006a
            boolean r5 = r11.isTopSwipeEnabled()
            if (r5 == 0) goto L_0x006a
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r5 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Top
            goto L_0x0076
        L_0x006a:
            int r5 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r5 >= 0) goto L_0x007a
            boolean r5 = r11.isBottomSwipeEnabled()
            if (r5 == 0) goto L_0x007a
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r5 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Bottom
        L_0x0076:
            r11.setCurrentDragEdge(r5)
            goto L_0x007b
        L_0x007a:
            return
        L_0x007b:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r5 = r11.mCurrentDragEdge
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r7 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Right
            r8 = 1106247680(0x41f00000, float:30.0)
            r9 = 0
            if (r5 != r7) goto L_0x00ac
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r7 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Open
            if (r0 != r7) goto L_0x008f
            int r7 = r11.mTouchSlop
            float r7 = (float) r7
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0099
        L_0x008f:
            if (r0 != r6) goto L_0x009b
            int r7 = r11.mTouchSlop
            int r7 = -r7
            float r7 = (float) r7
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x009b
        L_0x0099:
            r7 = r2
            goto L_0x009c
        L_0x009b:
            r7 = r9
        L_0x009c:
            if (r7 != 0) goto L_0x00a3
            if (r0 != r1) goto L_0x00a1
            goto L_0x00a3
        L_0x00a1:
            r7 = r9
            goto L_0x00a4
        L_0x00a3:
            r7 = r2
        L_0x00a4:
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 > 0) goto L_0x00aa
            if (r7 != 0) goto L_0x00ac
        L_0x00aa:
            r7 = r2
            goto L_0x00ad
        L_0x00ac:
            r7 = r9
        L_0x00ad:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r10 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Left
            if (r5 != r10) goto L_0x00d8
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r10 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Open
            if (r0 != r10) goto L_0x00bd
            int r10 = r11.mTouchSlop
            int r10 = -r10
            float r10 = (float) r10
            int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x00c6
        L_0x00bd:
            if (r0 != r6) goto L_0x00c8
            int r10 = r11.mTouchSlop
            float r10 = (float) r10
            int r3 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c8
        L_0x00c6:
            r3 = r2
            goto L_0x00c9
        L_0x00c8:
            r3 = r9
        L_0x00c9:
            if (r3 != 0) goto L_0x00d0
            if (r0 != r1) goto L_0x00ce
            goto L_0x00d0
        L_0x00ce:
            r3 = r9
            goto L_0x00d1
        L_0x00d0:
            r3 = r2
        L_0x00d1:
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 > 0) goto L_0x00d7
            if (r3 != 0) goto L_0x00d8
        L_0x00d7:
            r7 = r2
        L_0x00d8:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Top
            r8 = 1114636288(0x42700000, float:60.0)
            if (r5 != r3) goto L_0x0105
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Open
            if (r0 != r3) goto L_0x00ea
            int r3 = r11.mTouchSlop
            int r3 = -r3
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x00f3
        L_0x00ea:
            if (r0 != r6) goto L_0x00f5
            int r3 = r11.mTouchSlop
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00f5
        L_0x00f3:
            r3 = r2
            goto L_0x00f6
        L_0x00f5:
            r3 = r9
        L_0x00f6:
            if (r3 != 0) goto L_0x00fd
            if (r0 != r1) goto L_0x00fb
            goto L_0x00fd
        L_0x00fb:
            r3 = r9
            goto L_0x00fe
        L_0x00fd:
            r3 = r2
        L_0x00fe:
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0104
            if (r3 != 0) goto L_0x0105
        L_0x0104:
            r7 = r2
        L_0x0105:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Bottom
            if (r5 != r3) goto L_0x012d
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Open
            if (r0 != r3) goto L_0x0114
            int r3 = r11.mTouchSlop
            float r3 = (float) r3
            int r3 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x011e
        L_0x0114:
            if (r0 != r6) goto L_0x0120
            int r3 = r11.mTouchSlop
            int r3 = -r3
            float r3 = (float) r3
            int r12 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0120
        L_0x011e:
            r12 = r2
            goto L_0x0121
        L_0x0120:
            r12 = r9
        L_0x0121:
            if (r12 != 0) goto L_0x0125
            if (r0 != r1) goto L_0x0126
        L_0x0125:
            r9 = r2
        L_0x0126:
            int r12 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r12 < 0) goto L_0x012c
            if (r9 != 0) goto L_0x012d
        L_0x012c:
            r7 = r2
        L_0x012d:
            r12 = r7 ^ 1
            r11.mIsBeingDragged = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.checkCanDrag(android.view.MotionEvent):void");
    }

    /* access modifiers changed from: private */
    public Rect computeBottomLayDown(DragEdge dragEdge) {
        int i11;
        int i12;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        DragEdge dragEdge2 = DragEdge.Right;
        if (dragEdge == dragEdge2) {
            paddingLeft = getMeasuredWidth() - this.mDragDistance;
        } else if (dragEdge == DragEdge.Bottom) {
            paddingTop = getMeasuredHeight() - this.mDragDistance;
        }
        if (dragEdge == DragEdge.Left || dragEdge == dragEdge2) {
            i11 = this.mDragDistance + paddingLeft;
            i12 = getMeasuredHeight();
        } else {
            i11 = getMeasuredWidth() + paddingLeft;
            i12 = this.mDragDistance;
        }
        return new Rect(paddingLeft, paddingTop, i11, i12 + paddingTop);
    }

    private Rect computeBottomLayoutAreaViaSurface(ShowMode showMode, Rect rect) {
        View currentBottomView = getCurrentBottomView();
        int i11 = rect.left;
        int i12 = rect.top;
        int i13 = rect.right;
        int i14 = rect.bottom;
        if (showMode == ShowMode.PullOut) {
            DragEdge dragEdge = this.mCurrentDragEdge;
            DragEdge dragEdge2 = DragEdge.Left;
            if (dragEdge == dragEdge2) {
                i11 -= this.mDragDistance;
            } else if (dragEdge == DragEdge.Right) {
                i11 = i13;
            } else {
                i12 = dragEdge == DragEdge.Top ? i12 - this.mDragDistance : i14;
            }
            int i15 = 0;
            if (dragEdge == dragEdge2 || dragEdge == DragEdge.Right) {
                if (currentBottomView != null) {
                    i15 = currentBottomView.getMeasuredWidth();
                }
                i13 = i15 + i11;
            } else {
                if (currentBottomView != null) {
                    i15 = currentBottomView.getMeasuredHeight();
                }
                i14 = i12 + i15;
                i13 = rect.right;
            }
        } else if (showMode == ShowMode.LayDown) {
            DragEdge dragEdge3 = this.mCurrentDragEdge;
            if (dragEdge3 == DragEdge.Left) {
                i13 = i11 + this.mDragDistance;
            } else if (dragEdge3 == DragEdge.Right) {
                i11 = i13 - this.mDragDistance;
            } else if (dragEdge3 == DragEdge.Top) {
                i14 = i12 + this.mDragDistance;
            } else {
                i12 = i14 - this.mDragDistance;
            }
        }
        return new Rect(i11, i12, i13, i14);
    }

    private Rect computeSurfaceLayoutArea(boolean z11) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (z11) {
            DragEdge dragEdge = this.mCurrentDragEdge;
            if (dragEdge == DragEdge.Left) {
                paddingLeft = this.mDragDistance + getPaddingLeft();
            } else if (dragEdge == DragEdge.Right) {
                paddingLeft = getPaddingLeft() - this.mDragDistance;
            } else if (dragEdge == DragEdge.Top) {
                paddingTop = this.mDragDistance + getPaddingTop();
            } else {
                paddingTop = getPaddingTop() - this.mDragDistance;
            }
        }
        return new Rect(paddingLeft, paddingTop, getMeasuredWidth() + paddingLeft, getMeasuredHeight() + paddingTop);
    }

    private int dp2px(float f11) {
        return (int) ((f11 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private AdapterView getAdapterView() {
        ViewParent parent = getParent();
        if (parent instanceof AdapterView) {
            return (AdapterView) parent;
        }
        return null;
    }

    private float getCurrentOffset() {
        DragEdge dragEdge = this.mCurrentDragEdge;
        if (dragEdge == null) {
            return 0.0f;
        }
        return this.mEdgeSwipesOffset[dragEdge.ordinal()];
    }

    private boolean insideAdapterView() {
        return getAdapterView() != null;
    }

    /* access modifiers changed from: private */
    public boolean isTouchOnSurface(MotionEvent motionEvent) {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return false;
        }
        if (this.hitSurfaceRect == null) {
            this.hitSurfaceRect = new Rect();
        }
        surfaceView.getHitRect(this.hitSurfaceRect);
        return this.hitSurfaceRect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* access modifiers changed from: private */
    public boolean performAdapterViewItemLongClick() {
        AdapterView adapterView;
        int positionForView;
        if (getOpenStatus() != Status.Close) {
            return false;
        }
        ViewParent parent = getParent();
        if (!(parent instanceof AdapterView) || (positionForView = adapterView.getPositionForView(this)) == -1) {
            return false;
        }
        long itemIdAtPosition = (adapterView = (AdapterView) parent).getItemIdAtPosition(positionForView);
        try {
            Method declaredMethod = AbsListView.class.getDeclaredMethod("performLongPress", new Class[]{View.class, Integer.TYPE, Long.TYPE});
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(adapterView, new Object[]{this, Integer.valueOf(positionForView), Long.valueOf(itemIdAtPosition)})).booleanValue();
        } catch (Exception e11) {
            e11.printStackTrace();
            boolean onItemLongClick = adapterView.getOnItemLongClickListener() != null ? adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition) : false;
            if (onItemLongClick) {
                adapterView.performHapticFeedback(0);
            }
            return onItemLongClick;
        }
    }

    private void safeBottomView() {
        Status openStatus = getOpenStatus();
        List<View> bottomViews = getBottomViews();
        if (openStatus == Status.Close) {
            for (View next : bottomViews) {
                if (!(next == null || next.getVisibility() == 4)) {
                    next.setVisibility(4);
                }
            }
            return;
        }
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null && currentBottomView.getVisibility() != 0) {
            currentBottomView.setVisibility(0);
        }
    }

    private void setCurrentDragEdge(DragEdge dragEdge) {
        this.mCurrentDragEdge = dragEdge;
        updateBottomViews();
    }

    private void updateBottomViews() {
        View currentBottomView = getCurrentBottomView();
        if (currentBottomView != null) {
            DragEdge dragEdge = this.mCurrentDragEdge;
            if (dragEdge == DragEdge.Left || dragEdge == DragEdge.Right) {
                this.mDragDistance = currentBottomView.getMeasuredWidth() - dp2px(getCurrentOffset());
            } else {
                this.mDragDistance = currentBottomView.getMeasuredHeight() - dp2px(getCurrentOffset());
            }
        }
        ShowMode showMode = this.mShowMode;
        if (showMode == ShowMode.PullOut) {
            layoutPullOut();
        } else if (showMode == ShowMode.LayDown) {
            layoutLayDown();
        }
        safeBottomView();
    }

    public void addDrag(DragEdge dragEdge, int i11) {
        addDrag(dragEdge, findViewById(i11), (ViewGroup.LayoutParams) null);
    }

    public void addOnLayoutListener(OnLayout onLayout) {
        if (this.mOnLayoutListeners == null) {
            this.mOnLayoutListeners = new ArrayList();
        }
        this.mOnLayoutListeners.add(onLayout);
    }

    public void addRevealListener(int i11, OnRevealListener onRevealListener) {
        View findViewById = findViewById(i11);
        if (findViewById != null) {
            if (!this.mShowEntirely.containsKey(findViewById)) {
                this.mShowEntirely.put(findViewById, Boolean.FALSE);
            }
            if (this.mRevealListeners.get(findViewById) == null) {
                this.mRevealListeners.put(findViewById, new ArrayList());
            }
            this.mRevealListeners.get(findViewById).add(onRevealListener);
            return;
        }
        throw new IllegalArgumentException("Child does not belong to SwipeListener.");
    }

    public void addSwipeDenier(SwipeDenier swipeDenier) {
        this.mSwipeDeniers.add(swipeDenier);
    }

    public void addSwipeListener(SwipeListener swipeListener) {
        this.mSwipeListeners.add(swipeListener);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            int i12 = 0;
            try {
                i12 = ((Integer) layoutParams.getClass().getField("gravity").get(layoutParams)).intValue();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (i12 <= 0) {
                Iterator<Map.Entry<DragEdge, View>> it2 = this.mDragEdges.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry next = it2.next();
                    if (next.getValue() == null) {
                        this.mDragEdges.put((DragEdge) next.getKey(), view);
                        break;
                    }
                }
            } else {
                int b11 = f.b(i12, h0.F(this));
                if ((b11 & 3) == 3) {
                    this.mDragEdges.put(DragEdge.Left, view);
                }
                if ((b11 & 5) == 5) {
                    this.mDragEdges.put(DragEdge.Right, view);
                }
                if ((b11 & 48) == 48) {
                    this.mDragEdges.put(DragEdge.Top, view);
                }
                if ((b11 & 80) == 80) {
                    this.mDragEdges.put(DragEdge.Bottom, view);
                }
            }
            if (view.getParent() != this) {
                super.addView(view, i11, layoutParams);
            }
        }
    }

    public void clearDragEdge() {
        this.mDragEdges.clear();
    }

    public void close() {
        close(true, true);
    }

    public void computeScroll() {
        super.computeScroll();
        if (this.mDragHelper.n(true)) {
            h0.n0(this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchRevealEvent(int r15, int r16, int r17, int r18) {
        /*
            r14 = this;
            r8 = r14
            java.util.Map<android.view.View, java.util.ArrayList<com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$OnRevealListener>> r0 = r8.mRevealListeners
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x000a
            return
        L_0x000a:
            java.util.Map<android.view.View, java.util.ArrayList<com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$OnRevealListener>> r0 = r8.mRevealListeners
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r9 = r0.iterator()
        L_0x0014:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x015a
            java.lang.Object r0 = r9.next()
            r10 = r0
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r0 = r10.getKey()
            r11 = r0
            android.view.View r11 = (android.view.View) r11
            android.graphics.Rect r12 = r14.getRelativePosition(r11)
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = r8.mCurrentDragEdge
            r0 = r14
            r1 = r11
            r2 = r12
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            boolean r0 = r0.isViewShowing(r1, r2, r3, r4, r5, r6, r7)
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x0110
            java.util.Map<android.view.View, java.lang.Boolean> r0 = r8.mShowEntirely
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            r0.put(r11, r1)
            r0 = 0
            r1 = 0
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$ShowMode r2 = r14.getShowMode()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$ShowMode r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.ShowMode.LayDown
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 != r3) goto L_0x0091
            int[] r2 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = r8.mCurrentDragEdge
            int r3 = r3.ordinal()
            r2 = r2[r3]
            if (r2 == r7) goto L_0x0087
            if (r2 == r6) goto L_0x007d
            if (r2 == r5) goto L_0x0074
            if (r2 == r4) goto L_0x0069
            goto L_0x00e1
        L_0x0069:
            int r0 = r12.right
            int r0 = r0 - r17
            float r1 = (float) r0
            int r2 = r11.getWidth()
            goto L_0x00df
        L_0x0074:
            int r0 = r12.left
            int r0 = r0 - r15
            float r1 = (float) r0
            int r2 = r11.getWidth()
            goto L_0x00df
        L_0x007d:
            int r0 = r12.bottom
            int r0 = r0 - r18
            float r1 = (float) r0
            int r2 = r11.getHeight()
            goto L_0x00df
        L_0x0087:
            int r0 = r12.top
            int r0 = r0 - r16
            float r1 = (float) r0
            int r2 = r11.getHeight()
            goto L_0x00df
        L_0x0091:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$ShowMode r2 = r14.getShowMode()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$ShowMode r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.ShowMode.PullOut
            if (r2 != r3) goto L_0x00e1
            int[] r2 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = r8.mCurrentDragEdge
            int r3 = r3.ordinal()
            r2 = r2[r3]
            if (r2 == r7) goto L_0x00d3
            if (r2 == r6) goto L_0x00c6
            if (r2 == r5) goto L_0x00b9
            if (r2 == r4) goto L_0x00ac
            goto L_0x00e1
        L_0x00ac:
            int r0 = r12.left
            int r1 = r14.getWidth()
            int r0 = r0 - r1
            float r1 = (float) r0
            int r2 = r11.getWidth()
            goto L_0x00df
        L_0x00b9:
            int r0 = r12.right
            int r1 = r14.getPaddingLeft()
            int r0 = r0 - r1
            float r1 = (float) r0
            int r2 = r11.getWidth()
            goto L_0x00df
        L_0x00c6:
            int r0 = r12.top
            int r1 = r14.getHeight()
            int r0 = r0 - r1
            float r1 = (float) r0
            int r2 = r11.getHeight()
            goto L_0x00df
        L_0x00d3:
            int r0 = r12.bottom
            int r1 = r14.getPaddingTop()
            int r0 = r0 - r1
            float r1 = (float) r0
            int r2 = r11.getHeight()
        L_0x00df:
            float r2 = (float) r2
            float r1 = r1 / r2
        L_0x00e1:
            java.lang.Object r2 = r10.getValue()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x00eb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0110
            java.lang.Object r3 = r2.next()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$OnRevealListener r3 = (com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.OnRevealListener) r3
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r4 = r8.mCurrentDragEdge
            float r5 = java.lang.Math.abs(r1)
            r3.onReveal(r11, r4, r5, r0)
            float r3 = java.lang.Math.abs(r1)
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x00eb
            java.util.Map<android.view.View, java.lang.Boolean> r3 = r8.mShowEntirely
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            r3.put(r11, r4)
            goto L_0x00eb
        L_0x0110:
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = r8.mCurrentDragEdge
            r0 = r14
            r1 = r11
            r2 = r12
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            boolean r0 = r0.isViewTotallyFirstShowed(r1, r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x0014
            java.util.Map<android.view.View, java.lang.Boolean> r0 = r8.mShowEntirely
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.put(r11, r1)
            java.lang.Object r0 = r10.getValue()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0133:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0014
            java.lang.Object r1 = r0.next()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$OnRevealListener r1 = (com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.OnRevealListener) r1
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r2 = r8.mCurrentDragEdge
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Left
            if (r2 == r3) goto L_0x0152
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$DragEdge r3 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.DragEdge.Right
            if (r2 != r3) goto L_0x014a
            goto L_0x0152
        L_0x014a:
            int r3 = r11.getHeight()
            r1.onReveal(r11, r2, r13, r3)
            goto L_0x0133
        L_0x0152:
            int r3 = r11.getWidth()
            r1.onReveal(r11, r2, r13, r3)
            goto L_0x0133
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.dispatchRevealEvent(int, int, int, int):void");
    }

    public void dispatchSwipeEvent(int i11, int i12, int i13, int i14) {
        DragEdge dragEdge = getDragEdge();
        boolean z11 = false;
        if (dragEdge != DragEdge.Left ? dragEdge != DragEdge.Right ? dragEdge != DragEdge.Top ? dragEdge != DragEdge.Bottom || i14 <= 0 : i14 >= 0 : i13 <= 0 : i13 >= 0) {
            z11 = true;
        }
        dispatchSwipeEvent(i11, i12, z11);
    }

    public List<View> getBottomViews() {
        ArrayList arrayList = new ArrayList();
        for (DragEdge dragEdge : DragEdge.values()) {
            arrayList.add(this.mDragEdges.get(dragEdge));
        }
        return arrayList;
    }

    public View getCurrentBottomView() {
        List<View> bottomViews = getBottomViews();
        if (this.mCurrentDragEdge.ordinal() < bottomViews.size()) {
            return bottomViews.get(this.mCurrentDragEdge.ordinal());
        }
        return null;
    }

    public int getDragDistance() {
        return this.mDragDistance;
    }

    public DragEdge getDragEdge() {
        return this.mCurrentDragEdge;
    }

    public Map<DragEdge, View> getDragEdgeMap() {
        return this.mDragEdges;
    }

    @Deprecated
    public List<DragEdge> getDragEdges() {
        return new ArrayList(this.mDragEdges.keySet());
    }

    public Status getOpenStatus() {
        View surfaceView = getSurfaceView();
        if (surfaceView == null) {
            return Status.Close;
        }
        int left = surfaceView.getLeft();
        int top = surfaceView.getTop();
        if (left == getPaddingLeft() && top == getPaddingTop()) {
            return Status.Close;
        }
        if (left == getPaddingLeft() - this.mDragDistance || left == getPaddingLeft() + this.mDragDistance || top == getPaddingTop() - this.mDragDistance || top == getPaddingTop() + this.mDragDistance) {
            return Status.Open;
        }
        return Status.Middle;
    }

    public Rect getRelativePosition(View view) {
        Rect rect = new Rect(view.getLeft(), view.getTop(), 0, 0);
        View view2 = view;
        while (view2.getParent() != null && view2 != getRootView() && (view2 = (View) view2.getParent()) != this) {
            rect.left += view2.getLeft();
            rect.top += view2.getTop();
        }
        rect.right = rect.left + view.getMeasuredWidth();
        rect.bottom = rect.top + view.getMeasuredHeight();
        return rect;
    }

    public ShowMode getShowMode() {
        return this.mShowMode;
    }

    public View getSurfaceView() {
        if (getChildCount() == 0) {
            return null;
        }
        return getChildAt(getChildCount() - 1);
    }

    public float getWillOpenPercentAfterClose() {
        return this.mWillOpenPercentAfterClose;
    }

    public float getWillOpenPercentAfterOpen() {
        return this.mWillOpenPercentAfterOpen;
    }

    public boolean isBottomSwipeEnabled() {
        LinkedHashMap<DragEdge, View> linkedHashMap = this.mDragEdges;
        DragEdge dragEdge = DragEdge.Bottom;
        View view = linkedHashMap.get(dragEdge);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[dragEdge.ordinal()];
    }

    public boolean isClickToClose() {
        return this.mClickToClose;
    }

    public boolean isLeftSwipeEnabled() {
        LinkedHashMap<DragEdge, View> linkedHashMap = this.mDragEdges;
        DragEdge dragEdge = DragEdge.Left;
        View view = linkedHashMap.get(dragEdge);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[dragEdge.ordinal()];
    }

    public boolean isRightSwipeEnabled() {
        LinkedHashMap<DragEdge, View> linkedHashMap = this.mDragEdges;
        DragEdge dragEdge = DragEdge.Right;
        View view = linkedHashMap.get(dragEdge);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[dragEdge.ordinal()];
    }

    public boolean isSwipeEnabled() {
        return this.mSwipeEnabled;
    }

    public boolean isTopSwipeEnabled() {
        LinkedHashMap<DragEdge, View> linkedHashMap = this.mDragEdges;
        DragEdge dragEdge = DragEdge.Top;
        View view = linkedHashMap.get(dragEdge);
        return view != null && view.getParent() == this && view != getSurfaceView() && this.mSwipesEnabled[dragEdge.ordinal()];
    }

    public boolean isViewShowing(View view, Rect rect, DragEdge dragEdge, int i11, int i12, int i13, int i14) {
        int i15 = rect.left;
        int i16 = rect.right;
        int i17 = rect.top;
        int i18 = rect.bottom;
        if (getShowMode() == ShowMode.LayDown) {
            int i19 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[dragEdge.ordinal()];
            if (i19 != 1) {
                if (i19 != 2) {
                    if (i19 != 3) {
                        if (i19 == 4 && i13 > i15 && i13 <= i16) {
                            return true;
                        }
                        return false;
                    } else if (i11 >= i16 || i11 < i15) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (i14 <= i17 || i14 > i18) {
                    return false;
                } else {
                    return true;
                }
            } else if (i12 < i17 || i12 >= i18) {
                return false;
            } else {
                return true;
            }
        } else if (getShowMode() != ShowMode.PullOut) {
            return false;
        } else {
            int i21 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[dragEdge.ordinal()];
            if (i21 != 1) {
                if (i21 != 2) {
                    if (i21 != 3) {
                        if (i21 == 4 && i15 <= getWidth() && i16 > getWidth()) {
                            return true;
                        }
                        return false;
                    } else if (i16 < getPaddingLeft() || i15 >= getPaddingLeft()) {
                        return false;
                    } else {
                        return true;
                    }
                } else if (i17 >= getHeight() || i17 < getPaddingTop()) {
                    return false;
                } else {
                    return true;
                }
            } else if (i17 >= getPaddingTop() || i18 < getPaddingTop()) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean isViewTotallyFirstShowed(View view, Rect rect, DragEdge dragEdge, int i11, int i12, int i13, int i14) {
        if (this.mShowEntirely.get(view).booleanValue()) {
            return false;
        }
        int i15 = rect.left;
        int i16 = rect.right;
        int i17 = rect.top;
        int i18 = rect.bottom;
        if (getShowMode() == ShowMode.LayDown) {
            if ((dragEdge != DragEdge.Right || i13 > i15) && ((dragEdge != DragEdge.Left || i11 < i16) && ((dragEdge != DragEdge.Top || i12 < i18) && (dragEdge != DragEdge.Bottom || i14 > i17)))) {
                return false;
            }
        } else if (getShowMode() != ShowMode.PullOut) {
            return false;
        } else {
            if ((dragEdge != DragEdge.Right || i16 > getWidth()) && ((dragEdge != DragEdge.Left || i15 < getPaddingLeft()) && ((dragEdge != DragEdge.Top || i17 < getPaddingTop()) && (dragEdge != DragEdge.Bottom || i18 > getHeight())))) {
                return false;
            }
        }
        return true;
    }

    public void layoutLayDown() {
        View surfaceView = getSurfaceView();
        Rect rect = this.mViewBoundCache.get(surfaceView);
        if (rect == null) {
            rect = computeSurfaceLayoutArea(false);
        }
        if (surfaceView != null) {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
            bringChildToFront(surfaceView);
        }
        View currentBottomView = getCurrentBottomView();
        Rect rect2 = this.mViewBoundCache.get(currentBottomView);
        if (rect2 == null) {
            rect2 = computeBottomLayoutAreaViaSurface(ShowMode.LayDown, rect);
        }
        if (currentBottomView != null) {
            currentBottomView.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void layoutPullOut() {
        View surfaceView = getSurfaceView();
        Rect rect = this.mViewBoundCache.get(surfaceView);
        if (rect == null) {
            rect = computeSurfaceLayoutArea(false);
        }
        if (surfaceView != null) {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
            bringChildToFront(surfaceView);
        }
        View currentBottomView = getCurrentBottomView();
        Rect rect2 = this.mViewBoundCache.get(currentBottomView);
        if (rect2 == null) {
            rect2 = computeBottomLayoutAreaViaSurface(ShowMode.PullOut, rect);
        }
        if (currentBottomView != null) {
            currentBottomView.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (insideAdapterView()) {
            if (this.clickListener == null) {
                setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        SwipeLayout.this.performAdapterViewItemClick();
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
            }
            if (this.longClickListener == null) {
                setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        boolean unused = SwipeLayout.this.performAdapterViewItemLongClick();
                        return true;
                    }
                });
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        if (!isSwipeEnabled()) {
            return false;
        }
        if (this.mClickToClose && getOpenStatus() == Status.Open && isTouchOnSurface(motionEvent)) {
            return true;
        }
        for (SwipeDenier next : this.mSwipeDeniers) {
            if (next != null && next.shouldDenySwipe(motionEvent)) {
                return false;
            }
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    boolean z11 = this.mIsBeingDragged;
                    checkCanDrag(motionEvent);
                    if (this.mIsBeingDragged && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    if (!z11 && this.mIsBeingDragged) {
                        return false;
                    }
                } else if (action != 3) {
                    this.mDragHelper.H(motionEvent);
                }
            }
            this.mIsBeingDragged = false;
            this.mDragHelper.H(motionEvent);
        } else {
            this.mDragHelper.H(motionEvent);
            this.mIsBeingDragged = false;
            this.sX = motionEvent.getRawX();
            this.sY = motionEvent.getRawY();
            if (getOpenStatus() == Status.Middle) {
                this.mIsBeingDragged = true;
            }
        }
        return this.mIsBeingDragged;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        updateBottomViews();
        if (this.mOnLayoutListeners != null) {
            for (int i15 = 0; i15 < this.mOnLayoutListeners.size(); i15++) {
                this.mOnLayoutListeners.get(i15).onLayout(this);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isSwipeEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        this.gestureDetector.onTouchEvent(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        this.mDragHelper.H(motionEvent);
                        if (!super.onTouchEvent(motionEvent) || !this.mIsBeingDragged || actionMasked == 0) {
                            return true;
                        }
                        return false;
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mDragHelper.H(motionEvent);
            if (!super.onTouchEvent(motionEvent) && !this.mIsBeingDragged) {
            }
            return true;
        }
        this.mDragHelper.H(motionEvent);
        this.sX = motionEvent.getRawX();
        this.sY = motionEvent.getRawY();
        checkCanDrag(motionEvent);
        if (this.mIsBeingDragged) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.mDragHelper.H(motionEvent);
        }
        return true;
    }

    public void onViewRemoved(View view) {
        for (Map.Entry entry : new HashMap(this.mDragEdges).entrySet()) {
            if (entry.getValue() == view) {
                this.mDragEdges.remove(entry.getKey());
            }
        }
    }

    public void open() {
        open(true, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r0 = (android.widget.AdapterView) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void performAdapterViewItemClick() {
        /*
            r5 = this;
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r0 = r5.getOpenStatus()
            com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout$Status r1 = com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.Status.Close
            if (r0 == r1) goto L_0x0009
            return
        L_0x0009:
            android.view.ViewParent r0 = r5.getParent()
            boolean r1 = r0 instanceof android.widget.AdapterView
            if (r1 == 0) goto L_0x002f
            android.widget.AdapterView r0 = (android.widget.AdapterView) r0
            int r1 = r0.getPositionForView(r5)
            r2 = -1
            if (r1 == r2) goto L_0x002f
            int r2 = r0.getFirstVisiblePosition()
            int r2 = r1 - r2
            android.view.View r2 = r0.getChildAt(r2)
            android.widget.Adapter r3 = r0.getAdapter()
            long r3 = r3.getItemId(r1)
            r0.performItemClick(r2, r1, r3)
        L_0x002f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.qcloud.tuikit.timcommon.component.swipe.SwipeLayout.performAdapterViewItemClick():void");
    }

    public void processHandRelease(float f11, float f12, boolean z11) {
        float A = this.mDragHelper.A();
        View surfaceView = getSurfaceView();
        DragEdge dragEdge = this.mCurrentDragEdge;
        if (dragEdge != null && surfaceView != null) {
            float f13 = z11 ? this.mWillOpenPercentAfterClose : this.mWillOpenPercentAfterOpen;
            if (dragEdge == DragEdge.Left) {
                if (f11 > A) {
                    open();
                } else if (f11 < (-A)) {
                    close();
                } else if ((((float) getSurfaceView().getLeft()) * 1.0f) / ((float) this.mDragDistance) > f13) {
                    open();
                } else {
                    close();
                }
            } else if (dragEdge == DragEdge.Right) {
                if (f11 > A) {
                    close();
                } else if (f11 < (-A)) {
                    open();
                } else if ((((float) (-getSurfaceView().getLeft())) * 1.0f) / ((float) this.mDragDistance) > f13) {
                    open();
                } else {
                    close();
                }
            } else if (dragEdge == DragEdge.Top) {
                if (f12 > A) {
                    open();
                } else if (f12 < (-A)) {
                    close();
                } else if ((((float) getSurfaceView().getTop()) * 1.0f) / ((float) this.mDragDistance) > f13) {
                    open();
                } else {
                    close();
                }
            } else if (dragEdge != DragEdge.Bottom) {
            } else {
                if (f12 > A) {
                    close();
                } else if (f12 < (-A)) {
                    open();
                } else if ((((float) (-getSurfaceView().getTop())) * 1.0f) / ((float) this.mDragDistance) > f13) {
                    open();
                } else {
                    close();
                }
            }
        }
    }

    public void removeAllRevealListeners(int i11) {
        View findViewById = findViewById(i11);
        if (findViewById != null) {
            this.mRevealListeners.remove(findViewById);
            this.mShowEntirely.remove(findViewById);
        }
    }

    public void removeAllSwipeDeniers() {
        this.mSwipeDeniers.clear();
    }

    public void removeAllSwipeListener() {
        this.mSwipeListeners.clear();
    }

    public void removeOnLayoutListener(OnLayout onLayout) {
        List<OnLayout> list = this.mOnLayoutListeners;
        if (list != null) {
            list.remove(onLayout);
        }
    }

    public void removeRevealListener(int i11, OnRevealListener onRevealListener) {
        View findViewById = findViewById(i11);
        if (findViewById != null) {
            this.mShowEntirely.remove(findViewById);
            if (this.mRevealListeners.containsKey(findViewById)) {
                this.mRevealListeners.get(findViewById).remove(onRevealListener);
            }
        }
    }

    public void removeSwipeDenier(SwipeDenier swipeDenier) {
        this.mSwipeDeniers.remove(swipeDenier);
    }

    public void removeSwipeListener(SwipeListener swipeListener) {
        this.mSwipeListeners.remove(swipeListener);
    }

    public void setBottomSwipeEnabled(boolean z11) {
        this.mSwipesEnabled[DragEdge.Bottom.ordinal()] = z11;
    }

    @Deprecated
    public void setBottomViewIds(int i11, int i12, int i13, int i14) {
        addDrag(DragEdge.Left, findViewById(i11));
        addDrag(DragEdge.Right, findViewById(i12));
        addDrag(DragEdge.Top, findViewById(i13));
        addDrag(DragEdge.Bottom, findViewById(i14));
    }

    public void setClickToClose(boolean z11) {
        this.mClickToClose = z11;
    }

    public void setDrag(DragEdge dragEdge, int i11) {
        clearDragEdge();
        addDrag(dragEdge, i11);
    }

    public void setDragDistance(int i11) {
        if (i11 < 0) {
            i11 = 0;
        }
        this.mDragDistance = dp2px((float) i11);
        requestLayout();
    }

    @Deprecated
    public void setDragEdge(DragEdge dragEdge) {
        clearDragEdge();
        if (getChildCount() >= 2) {
            this.mDragEdges.put(dragEdge, getChildAt(getChildCount() - 2));
        }
        setCurrentDragEdge(dragEdge);
    }

    @Deprecated
    public void setDragEdges(List<DragEdge> list) {
        clearDragEdge();
        int min = Math.min(list.size(), getChildCount() - 1);
        for (int i11 = 0; i11 < min; i11++) {
            this.mDragEdges.put(list.get(i11), getChildAt(i11));
        }
        if (list.size() == 0 || list.contains(DefaultDragEdge)) {
            setCurrentDragEdge(DefaultDragEdge);
        } else {
            setCurrentDragEdge(list.get(0));
        }
    }

    public void setLeftSwipeEnabled(boolean z11) {
        this.mSwipesEnabled[DragEdge.Left.ordinal()] = z11;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.clickListener = onClickListener;
    }

    public void setOnDoubleClickListener(DoubleClickListener doubleClickListener) {
        this.mDoubleClickListener = doubleClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.longClickListener = onLongClickListener;
    }

    public void setRightSwipeEnabled(boolean z11) {
        this.mSwipesEnabled[DragEdge.Right.ordinal()] = z11;
    }

    public void setShowMode(ShowMode showMode) {
        this.mShowMode = showMode;
        requestLayout();
    }

    public void setSwipeEnabled(boolean z11) {
        this.mSwipeEnabled = z11;
    }

    public void setTopSwipeEnabled(boolean z11) {
        this.mSwipesEnabled[DragEdge.Top.ordinal()] = z11;
    }

    public void setWillOpenPercentAfterClose(float f11) {
        this.mWillOpenPercentAfterClose = f11;
    }

    public void setWillOpenPercentAfterOpen(float f11) {
        this.mWillOpenPercentAfterOpen = f11;
    }

    public void toggle() {
        toggle(true);
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addDrag(DragEdge dragEdge, View view) {
        addDrag(dragEdge, view, (ViewGroup.LayoutParams) null);
    }

    public void close(boolean z11) {
        close(z11, true);
    }

    public void open(boolean z11) {
        open(z11, true);
    }

    public void toggle(boolean z11) {
        if (getOpenStatus() == Status.Open) {
            close(z11);
        } else if (getOpenStatus() == Status.Close) {
            open(z11);
        }
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mCurrentDragEdge = DefaultDragEdge;
        this.mDragDistance = 0;
        this.mDragEdges = new LinkedHashMap<>();
        this.mEdgeSwipesOffset = new float[4];
        this.mSwipeListeners = new ArrayList();
        this.mSwipeDeniers = new ArrayList();
        this.mRevealListeners = new HashMap();
        this.mShowEntirely = new HashMap();
        this.mViewBoundCache = new HashMap();
        this.mSwipeEnabled = true;
        this.mSwipesEnabled = new boolean[]{true, true, true, true};
        this.mClickToClose = false;
        this.mWillOpenPercentAfterOpen = 0.75f;
        this.mWillOpenPercentAfterClose = 0.25f;
        this.mDragHelperCallback = new ViewDragHelper.Callback() {
            public boolean isCloseBeforeDrag = true;

            public int clampViewPositionHorizontal(View view, int i11, int i12) {
                if (view == SwipeLayout.this.getSurfaceView()) {
                    int i13 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i13 == 1 || i13 == 2) {
                        return SwipeLayout.this.getPaddingLeft();
                    }
                    if (i13 != 3) {
                        if (i13 == 4) {
                            if (i11 > SwipeLayout.this.getPaddingLeft()) {
                                return SwipeLayout.this.getPaddingLeft();
                            }
                            if (i11 < SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.mDragDistance) {
                                return SwipeLayout.this.getPaddingLeft() - SwipeLayout.this.mDragDistance;
                            }
                        }
                    } else if (i11 < SwipeLayout.this.getPaddingLeft()) {
                        return SwipeLayout.this.getPaddingLeft();
                    } else {
                        if (i11 > SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingLeft() + SwipeLayout.this.mDragDistance;
                        }
                    }
                } else if (SwipeLayout.this.getCurrentBottomView() == view) {
                    int i14 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i14 == 1 || i14 == 2) {
                        return SwipeLayout.this.getPaddingLeft();
                    }
                    if (i14 != 3) {
                        if (i14 == 4 && SwipeLayout.this.mShowMode == ShowMode.PullOut && i11 < SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getMeasuredWidth() - SwipeLayout.this.mDragDistance;
                        }
                    } else if (SwipeLayout.this.mShowMode == ShowMode.PullOut && i11 > SwipeLayout.this.getPaddingLeft()) {
                        return SwipeLayout.this.getPaddingLeft();
                    }
                }
                return i11;
            }

            public int clampViewPositionVertical(View view, int i11, int i12) {
                int i13;
                if (view == SwipeLayout.this.getSurfaceView()) {
                    int i14 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i14 != 1) {
                        if (i14 != 2) {
                            if (i14 == 3 || i14 == 4) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                        } else if (i11 < SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance;
                        } else {
                            if (i11 > SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                        }
                    } else if (i11 < SwipeLayout.this.getPaddingTop()) {
                        return SwipeLayout.this.getPaddingTop();
                    } else {
                        if (i11 > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance;
                        }
                    }
                } else {
                    View surfaceView = SwipeLayout.this.getSurfaceView();
                    if (surfaceView == null) {
                        i13 = 0;
                    } else {
                        i13 = surfaceView.getTop();
                    }
                    int i15 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[SwipeLayout.this.mCurrentDragEdge.ordinal()];
                    if (i15 != 1) {
                        if (i15 != 2) {
                            if (i15 == 3 || i15 == 4) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                        } else if (SwipeLayout.this.mShowMode != ShowMode.PullOut) {
                            int i16 = i13 + i12;
                            if (i16 >= SwipeLayout.this.getPaddingTop()) {
                                return SwipeLayout.this.getPaddingTop();
                            }
                            if (i16 <= SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance) {
                                return SwipeLayout.this.getPaddingTop() - SwipeLayout.this.mDragDistance;
                            }
                        } else if (i11 < SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getMeasuredHeight() - SwipeLayout.this.mDragDistance;
                        }
                    } else if (SwipeLayout.this.mShowMode != ShowMode.PullOut) {
                        int i17 = i13 + i12;
                        if (i17 < SwipeLayout.this.getPaddingTop()) {
                            return SwipeLayout.this.getPaddingTop();
                        }
                        if (i17 > SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance) {
                            return SwipeLayout.this.getPaddingTop() + SwipeLayout.this.mDragDistance;
                        }
                    } else if (i11 > SwipeLayout.this.getPaddingTop()) {
                        return SwipeLayout.this.getPaddingTop();
                    }
                }
                return i11;
            }

            public int getViewHorizontalDragRange(View view) {
                return SwipeLayout.this.mDragDistance;
            }

            public int getViewVerticalDragRange(View view) {
                return SwipeLayout.this.mDragDistance;
            }

            public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
                View surfaceView = SwipeLayout.this.getSurfaceView();
                if (surfaceView != null) {
                    View currentBottomView = SwipeLayout.this.getCurrentBottomView();
                    int left = surfaceView.getLeft();
                    int right = surfaceView.getRight();
                    int top = surfaceView.getTop();
                    int bottom = surfaceView.getBottom();
                    if (view == surfaceView) {
                        if (SwipeLayout.this.mShowMode == ShowMode.PullOut && currentBottomView != null) {
                            if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Left || SwipeLayout.this.mCurrentDragEdge == DragEdge.Right) {
                                currentBottomView.offsetLeftAndRight(i13);
                            } else {
                                currentBottomView.offsetTopAndBottom(i14);
                            }
                        }
                    } else if (SwipeLayout.this.getBottomViews().contains(view)) {
                        if (SwipeLayout.this.mShowMode == ShowMode.PullOut) {
                            surfaceView.offsetLeftAndRight(i13);
                            surfaceView.offsetTopAndBottom(i14);
                        } else {
                            SwipeLayout swipeLayout = SwipeLayout.this;
                            Rect access$400 = swipeLayout.computeBottomLayDown(swipeLayout.mCurrentDragEdge);
                            if (currentBottomView != null) {
                                currentBottomView.layout(access$400.left, access$400.top, access$400.right, access$400.bottom);
                            }
                            int left2 = surfaceView.getLeft() + i13;
                            int top2 = surfaceView.getTop() + i14;
                            if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Left && left2 < SwipeLayout.this.getPaddingLeft()) {
                                left2 = SwipeLayout.this.getPaddingLeft();
                            } else if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Right && left2 > SwipeLayout.this.getPaddingLeft()) {
                                left2 = SwipeLayout.this.getPaddingLeft();
                            } else if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Top && top2 < SwipeLayout.this.getPaddingTop()) {
                                top2 = SwipeLayout.this.getPaddingTop();
                            } else if (SwipeLayout.this.mCurrentDragEdge == DragEdge.Bottom && top2 > SwipeLayout.this.getPaddingTop()) {
                                top2 = SwipeLayout.this.getPaddingTop();
                            }
                            surfaceView.layout(left2, top2, SwipeLayout.this.getMeasuredWidth() + left2, SwipeLayout.this.getMeasuredHeight() + top2);
                        }
                    }
                    SwipeLayout.this.dispatchRevealEvent(left, top, right, bottom);
                    SwipeLayout.this.dispatchSwipeEvent(left, top, i13, i14);
                    SwipeLayout.this.invalidate();
                    SwipeLayout.this.captureChildrenBound();
                }
            }

            public void onViewReleased(View view, float f11, float f12) {
                super.onViewReleased(view, f11, f12);
                SwipeLayout.this.processHandRelease(f11, f12, this.isCloseBeforeDrag);
                for (SwipeListener onHandRelease : SwipeLayout.this.mSwipeListeners) {
                    onHandRelease.onHandRelease(SwipeLayout.this, f11, f12);
                }
                SwipeLayout.this.invalidate();
            }

            public boolean tryCaptureView(View view, int i11) {
                boolean z11 = false;
                boolean z12 = view == SwipeLayout.this.getSurfaceView() || SwipeLayout.this.getBottomViews().contains(view);
                if (z12) {
                    if (SwipeLayout.this.getOpenStatus() == Status.Close) {
                        z11 = true;
                    }
                    this.isCloseBeforeDrag = z11;
                }
                return z12;
            }
        };
        this.mEventCounter = 0;
        this.sX = -1.0f;
        this.sY = -1.0f;
        this.gestureDetector = new GestureDetector(getContext(), new SwipeDetector());
        this.mDragHelper = ViewDragHelper.p(this, this.mDragHelperCallback);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwipeLayout);
        int i12 = obtainStyledAttributes.getInt(R.styleable.SwipeLayout_drag_edge, 2);
        float[] fArr = this.mEdgeSwipesOffset;
        DragEdge dragEdge = DragEdge.Left;
        fArr[dragEdge.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_leftEdgeSwipeOffset, 0.0f);
        float[] fArr2 = this.mEdgeSwipesOffset;
        DragEdge dragEdge2 = DragEdge.Right;
        fArr2[dragEdge2.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_rightEdgeSwipeOffset, 0.0f);
        float[] fArr3 = this.mEdgeSwipesOffset;
        DragEdge dragEdge3 = DragEdge.Top;
        fArr3[dragEdge3.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_topEdgeSwipeOffset, 0.0f);
        float[] fArr4 = this.mEdgeSwipesOffset;
        DragEdge dragEdge4 = DragEdge.Bottom;
        fArr4[dragEdge4.ordinal()] = obtainStyledAttributes.getDimension(R.styleable.SwipeLayout_bottomEdgeSwipeOffset, 0.0f);
        setClickToClose(obtainStyledAttributes.getBoolean(R.styleable.SwipeLayout_clickToClose, this.mClickToClose));
        if ((i12 & 1) == 1) {
            this.mDragEdges.put(dragEdge, (Object) null);
        }
        if ((i12 & 4) == 4) {
            this.mDragEdges.put(dragEdge3, (Object) null);
        }
        if ((i12 & 2) == 2) {
            this.mDragEdges.put(dragEdge2, (Object) null);
        }
        if ((i12 & 8) == 8) {
            this.mDragEdges.put(dragEdge4, (Object) null);
        }
        this.mShowMode = ShowMode.values()[obtainStyledAttributes.getInt(R.styleable.SwipeLayout_show_mode, ShowMode.PullOut.ordinal())];
        obtainStyledAttributes.recycle();
    }

    public void addDrag(DragEdge dragEdge, View view, ViewGroup.LayoutParams layoutParams) {
        if (view != null) {
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            if (!checkLayoutParams(layoutParams)) {
                layoutParams = generateLayoutParams(layoutParams);
            }
            int i11 = -1;
            int i12 = AnonymousClass4.$SwitchMap$com$tencent$qcloud$tuikit$timcommon$component$swipe$SwipeLayout$DragEdge[dragEdge.ordinal()];
            if (i12 == 1) {
                i11 = 48;
            } else if (i12 == 2) {
                i11 = 80;
            } else if (i12 == 3) {
                i11 = 3;
            } else if (i12 == 4) {
                i11 = 5;
            }
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = i11;
            }
            addView(view, 0, layoutParams);
        }
    }

    public void close(boolean z11, boolean z12) {
        View surfaceView = getSurfaceView();
        if (surfaceView != null) {
            if (z11) {
                this.mDragHelper.S(getSurfaceView(), getPaddingLeft(), getPaddingTop());
            } else {
                Rect computeSurfaceLayoutArea = computeSurfaceLayoutArea(false);
                int left = computeSurfaceLayoutArea.left - surfaceView.getLeft();
                int top = computeSurfaceLayoutArea.top - surfaceView.getTop();
                surfaceView.layout(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
                if (z12) {
                    dispatchRevealEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
                    dispatchSwipeEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, left, top);
                } else {
                    safeBottomView();
                }
            }
            invalidate();
        }
    }

    public void open(boolean z11, boolean z12) {
        View surfaceView = getSurfaceView();
        View currentBottomView = getCurrentBottomView();
        if (surfaceView != null) {
            Rect computeSurfaceLayoutArea = computeSurfaceLayoutArea(true);
            if (z11) {
                this.mDragHelper.S(surfaceView, computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top);
            } else {
                int left = computeSurfaceLayoutArea.left - surfaceView.getLeft();
                int top = computeSurfaceLayoutArea.top - surfaceView.getTop();
                surfaceView.layout(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
                ShowMode showMode = getShowMode();
                ShowMode showMode2 = ShowMode.PullOut;
                if (showMode == showMode2) {
                    Rect computeBottomLayoutAreaViaSurface = computeBottomLayoutAreaViaSurface(showMode2, computeSurfaceLayoutArea);
                    if (currentBottomView != null) {
                        currentBottomView.layout(computeBottomLayoutAreaViaSurface.left, computeBottomLayoutAreaViaSurface.top, computeBottomLayoutAreaViaSurface.right, computeBottomLayoutAreaViaSurface.bottom);
                    }
                }
                if (z12) {
                    dispatchRevealEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, computeSurfaceLayoutArea.right, computeSurfaceLayoutArea.bottom);
                    dispatchSwipeEvent(computeSurfaceLayoutArea.left, computeSurfaceLayoutArea.top, left, top);
                } else {
                    safeBottomView();
                }
            }
            invalidate();
        }
    }

    public void setDrag(DragEdge dragEdge, View view) {
        clearDragEdge();
        addDrag(dragEdge, view);
    }

    public void dispatchSwipeEvent(int i11, int i12, boolean z11) {
        safeBottomView();
        Status openStatus = getOpenStatus();
        if (!this.mSwipeListeners.isEmpty()) {
            this.mEventCounter++;
            for (SwipeListener next : this.mSwipeListeners) {
                if (this.mEventCounter == 1) {
                    if (z11) {
                        next.onStartOpen(this);
                    } else {
                        next.onStartClose(this);
                    }
                }
                next.onUpdate(this, i11 - getPaddingLeft(), i12 - getPaddingTop());
            }
            if (openStatus == Status.Close) {
                for (SwipeListener onClose : this.mSwipeListeners) {
                    onClose.onClose(this);
                }
                this.mEventCounter = 0;
                this.mClickToClose = false;
            }
            if (openStatus == Status.Open) {
                View currentBottomView = getCurrentBottomView();
                if (currentBottomView != null) {
                    currentBottomView.setEnabled(true);
                }
                for (SwipeListener onOpen : this.mSwipeListeners) {
                    onOpen.onOpen(this);
                }
                this.mEventCounter = 0;
                this.mClickToClose = true;
            }
        }
    }

    public void addRevealListener(int[] iArr, OnRevealListener onRevealListener) {
        for (int addRevealListener : iArr) {
            addRevealListener(addRevealListener, onRevealListener);
        }
    }

    @Deprecated
    public void setDragEdges(DragEdge... dragEdgeArr) {
        clearDragEdge();
        setDragEdges((List<DragEdge>) Arrays.asList(dragEdgeArr));
    }

    public void open(DragEdge dragEdge) {
        setCurrentDragEdge(dragEdge);
        open(true, true);
    }

    public void open(boolean z11, DragEdge dragEdge) {
        setCurrentDragEdge(dragEdge);
        open(z11, true);
    }

    public void open(boolean z11, boolean z12, DragEdge dragEdge) {
        setCurrentDragEdge(dragEdge);
        open(z11, z12);
    }
}
