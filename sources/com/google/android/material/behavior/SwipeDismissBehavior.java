package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.h0;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    public float alphaEndSwipeDistance = 0.5f;
    public float alphaStartSwipeDistance = 0.0f;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        private boolean shouldDismiss(View view, float f11) {
            int i11 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
            if (i11 != 0) {
                boolean z11 = h0.F(view) == 1;
                int i12 = SwipeDismissBehavior.this.swipeDirection;
                if (i12 == 2) {
                    return true;
                }
                if (i12 == 0) {
                    if (z11) {
                        if (f11 >= 0.0f) {
                            return false;
                        }
                    } else if (i11 <= 0) {
                        return false;
                    }
                    return true;
                } else if (i12 != 1) {
                    return false;
                } else {
                    if (z11) {
                        if (i11 <= 0) {
                            return false;
                        }
                    } else if (f11 >= 0.0f) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold)) {
                    return true;
                }
                return false;
            }
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            int i13;
            int i14;
            int width;
            boolean z11 = h0.F(view) == 1;
            int i15 = SwipeDismissBehavior.this.swipeDirection;
            if (i15 != 0) {
                if (i15 != 1) {
                    i13 = this.originalCapturedViewLeft - view.getWidth();
                    i14 = view.getWidth() + this.originalCapturedViewLeft;
                } else if (z11) {
                    i13 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                } else {
                    i13 = this.originalCapturedViewLeft - view.getWidth();
                    i14 = this.originalCapturedViewLeft;
                }
                return SwipeDismissBehavior.clamp(i13, i11, i14);
            } else if (z11) {
                i13 = this.originalCapturedViewLeft - view.getWidth();
                i14 = this.originalCapturedViewLeft;
                return SwipeDismissBehavior.clamp(i13, i11, i14);
            } else {
                i13 = this.originalCapturedViewLeft;
                width = view.getWidth();
            }
            i14 = width + i13;
            return SwipeDismissBehavior.clamp(i13, i11, i14);
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            return view.getTop();
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public void onViewCaptured(View view, int i11) {
            this.activePointerId = i11;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        public void onViewDragStateChanged(int i11) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i11);
            }
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            float width = ((float) this.originalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaStartSwipeDistance);
            float width2 = ((float) this.originalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.alphaEndSwipeDistance);
            float f11 = (float) i11;
            if (f11 <= width) {
                view.setAlpha(1.0f);
            } else if (f11 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1.0f - SwipeDismissBehavior.fraction(width, width2, f11), 1.0f));
            }
        }

        public void onViewReleased(View view, float f11, float f12) {
            boolean z11;
            int i11;
            OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f11)) {
                int left = view.getLeft();
                int i12 = this.originalCapturedViewLeft;
                i11 = left < i12 ? i12 - width : i12 + width;
                z11 = true;
            } else {
                i11 = this.originalCapturedViewLeft;
                z11 = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.Q(i11, view.getTop())) {
                h0.p0(view, new SettleRunnable(view, z11));
            } else if (z11 && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(view);
            }
        }

        public boolean tryCaptureView(View view, int i11) {
            int i12 = this.activePointerId;
            return (i12 == -1 || i12 == i11) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    };
    public float dragDismissThreshold = 0.5f;
    private boolean interceptingEvents;
    public OnDismissListener listener;
    private float sensitivity = 0.0f;
    private boolean sensitivitySet;
    public int swipeDirection = 2;
    public ViewDragHelper viewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i11);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        public SettleRunnable(View view2, boolean z11) {
            this.view = view2;
            this.dismiss = z11;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.viewDragHelper;
            if (viewDragHelper != null && viewDragHelper.n(true)) {
                h0.p0(this.view, this);
            } else if (this.dismiss && (onDismissListener = SwipeDismissBehavior.this.listener) != null) {
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f11, float f12, float f13) {
        return Math.min(Math.max(f11, f12), f13);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelper2;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                viewDragHelper2 = ViewDragHelper.o(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                viewDragHelper2 = ViewDragHelper.p(viewGroup, this.dragCallback);
            }
            this.viewDragHelper = viewDragHelper2;
        }
    }

    public static float fraction(float f11, float f12, float f13) {
        return (f13 - f11) / (f12 - f11);
    }

    private void updateAccessibilityActions(View view) {
        h0.r0(view, 1048576);
        if (canSwipeDismissView(view)) {
            h0.t0(view, AccessibilityNodeInfoCompat.a.f8555y, (CharSequence) null, new AccessibilityViewCommand() {
                public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                    boolean z11 = false;
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                        return false;
                    }
                    boolean z12 = h0.F(view) == 1;
                    int i11 = SwipeDismissBehavior.this.swipeDirection;
                    if ((i11 == 0 && z12) || (i11 == 1 && !z12)) {
                        z11 = true;
                    }
                    int width = view.getWidth();
                    if (z11) {
                        width = -width;
                    }
                    h0.g0(view, width);
                    view.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(view);
                    }
                    return true;
                }
            });
        }
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public int getDragState() {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            return viewDragHelper2.C();
        }
        return 0;
    }

    public OnDismissListener getListener() {
        return this.listener;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
        boolean z11 = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z11 = coordinatorLayout.isPointInChildBounds(v11, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z11;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!z11) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.viewDragHelper.R(motionEvent);
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v11, int i11) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v11, i11);
        if (h0.D(v11) == 0) {
            h0.I0(v11, 1);
            updateAccessibilityActions(v11);
        }
        return onLayoutChild;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null) {
            return false;
        }
        viewDragHelper2.H(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f11) {
        this.dragDismissThreshold = clamp(0.0f, f11, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f11) {
        this.alphaEndSwipeDistance = clamp(0.0f, f11, 1.0f);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f11) {
        this.sensitivity = f11;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f11) {
        this.alphaStartSwipeDistance = clamp(0.0f, f11, 1.0f);
    }

    public void setSwipeDirection(int i11) {
        this.swipeDirection = i11;
    }

    public static int clamp(int i11, int i12, int i13) {
        return Math.min(Math.max(i11, i12), i13);
    }
}
