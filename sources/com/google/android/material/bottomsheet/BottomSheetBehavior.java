package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.h0;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import x0.a;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int CORNER_ANIMATION_DURATION = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_WIDTH = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    private static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    public int activePointerId;
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    private int childHeight;
    public int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private boolean releasedLow(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.parentHeight + bottomSheetBehavior.getExpandedOffset()) / 2;
        }

        public int clampViewPositionHorizontal(View view, int i11, int i12) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i11, int i12) {
            int expandedOffset = BottomSheetBehavior.this.getExpandedOffset();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return a.c(i11, expandedOffset, bottomSheetBehavior.hideable ? bottomSheetBehavior.parentHeight : bottomSheetBehavior.collapsedOffset);
        }

        public int getViewVerticalDragRange(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.hideable) {
                return bottomSheetBehavior.parentHeight;
            }
            return bottomSheetBehavior.collapsedOffset;
        }

        public void onViewDragStateChanged(int i11) {
            if (i11 == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View view, int i11, int i12, int i13, int i14) {
            BottomSheetBehavior.this.dispatchOnSlide(i12);
        }

        public void onViewReleased(View view, float f11, float f12) {
            int i11;
            int i12;
            int i13 = 4;
            if (f12 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.hideable || !bottomSheetBehavior.shouldHide(view, f12)) {
                    if (f12 == 0.0f || Math.abs(f11) > Math.abs(f12)) {
                        int top = view.getTop();
                        if (!BottomSheetBehavior.this.fitToContents) {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i14 = bottomSheetBehavior2.halfExpandedOffset;
                            if (top < i14) {
                                if (top < Math.abs(top - bottomSheetBehavior2.collapsedOffset)) {
                                    i11 = BottomSheetBehavior.this.getExpandedOffset();
                                } else {
                                    i12 = BottomSheetBehavior.this.halfExpandedOffset;
                                }
                            } else if (Math.abs(top - i14) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                                i12 = BottomSheetBehavior.this.halfExpandedOffset;
                            } else {
                                i11 = BottomSheetBehavior.this.collapsedOffset;
                                BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                            }
                            i13 = 6;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                        } else if (Math.abs(top - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top - BottomSheetBehavior.this.collapsedOffset)) {
                            i11 = BottomSheetBehavior.this.fitToContentsOffset;
                        } else {
                            i11 = BottomSheetBehavior.this.collapsedOffset;
                            BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                        }
                    } else {
                        if (BottomSheetBehavior.this.fitToContents) {
                            i11 = BottomSheetBehavior.this.collapsedOffset;
                        } else {
                            int top2 = view.getTop();
                            if (Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset)) {
                                i12 = BottomSheetBehavior.this.halfExpandedOffset;
                                i13 = 6;
                            } else {
                                i11 = BottomSheetBehavior.this.collapsedOffset;
                            }
                        }
                        BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                    }
                } else if ((Math.abs(f11) < Math.abs(f12) && f12 > 500.0f) || releasedLow(view)) {
                    i11 = BottomSheetBehavior.this.parentHeight;
                    i13 = 5;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                } else if (BottomSheetBehavior.this.fitToContents) {
                    i11 = BottomSheetBehavior.this.fitToContentsOffset;
                } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset)) {
                    i11 = BottomSheetBehavior.this.getExpandedOffset();
                } else {
                    i12 = BottomSheetBehavior.this.halfExpandedOffset;
                    i13 = 6;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                }
            } else if (BottomSheetBehavior.this.fitToContents) {
                i11 = BottomSheetBehavior.this.fitToContentsOffset;
            } else {
                int top3 = view.getTop();
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                int i15 = bottomSheetBehavior3.halfExpandedOffset;
                if (top3 > i15) {
                    i12 = i15;
                    i13 = 6;
                    BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
                }
                i11 = bottomSheetBehavior3.getExpandedOffset();
            }
            i13 = 3;
            BottomSheetBehavior.this.startSettlingAnimation(view, i13, i11, true);
        }

        public boolean tryCaptureView(View view, int i11) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i12 = bottomSheetBehavior.state;
            if (i12 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i12 == 3 && bottomSheetBehavior.activePointerId == i11) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public boolean draggable = true;
    public float elevation = -1.0f;
    private int expandHalfwayActionId = -1;
    public int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    public int fitToContentsOffset;
    /* access modifiers changed from: private */
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    public int halfExpandedOffset;
    public float halfExpandedRatio = 0.5f;
    public boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    /* access modifiers changed from: private */
    public int insetBottom;
    /* access modifiers changed from: private */
    public int insetTop;
    private ValueAnimator interpolatorAnimator;
    private boolean isShapeExpanded;
    private int lastNestedScrollDy;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable materialShapeDrawable;
    private int maxWidth = -1;
    private float maximumVelocity;
    private boolean nestedScrolled;
    public WeakReference<View> nestedScrollingChildRef;
    /* access modifiers changed from: private */
    public boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    public int parentHeight;
    public int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags = 0;
    private BottomSheetBehavior<V>.SettleRunnable settleRunnable = null;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shapeThemingEnabled;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    public int state = 4;
    public boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    private VelocityTracker velocityTracker;
    public ViewDragHelper viewDragHelper;
    public WeakReference<V> viewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f11);

        public abstract void onStateChanged(View view, int i11);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        public boolean fitToContents;
        public boolean hideable;
        public int peekHeight;
        public boolean skipCollapsed;
        public final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z11 = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z11;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i11) {
            super(parcelable);
            this.state = i11;
        }
    }

    public class SettleRunnable implements Runnable {
        /* access modifiers changed from: private */
        public boolean isPosted;
        public int targetState;
        private final View view;

        public SettleRunnable(View view2, int i11) {
            this.view = view2;
            this.targetState = i11;
        }

        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
            if (viewDragHelper == null || !viewDragHelper.n(true)) {
                BottomSheetBehavior.this.setStateInternal(this.targetState);
            } else {
                h0.p0(this.view, this);
            }
            this.isPosted = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior() {
    }

    private int addAccessibilityActionForState(V v11, int i11, int i12) {
        return h0.c(v11, v11.getResources().getString(i11), createAccessibilityViewCommandForState(i12));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (((float) this.parentHeight) * (1.0f - this.halfExpandedRatio));
    }

    private int calculatePeekHeight() {
        int i11;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i11 = this.gestureInsetBottom) <= 0) {
            return this.peekHeight + this.insetBottom;
        }
        return Math.max(this.peekHeight, i11 + this.peekHeightGestureInsetBuffer);
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i11) {
        return new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i11);
                return true;
            }
        };
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z11) {
        createMaterialShapeDrawable(context, attributeSet, z11, (ColorStateList) null);
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v11) {
        ViewGroup.LayoutParams layoutParams = v11.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior f11 = ((CoordinatorLayout.LayoutParams) layoutParams).f();
            if (f11 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f11;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private void replaceAccessibilityActionForState(V v11, AccessibilityNodeInfoCompat.a aVar, int i11) {
        h0.t0(v11, aVar, (CharSequence) null, createAccessibilityViewCommandForState(i11));
    }

    private void reset() {
        this.activePointerId = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i11 = this.saveFlags;
        if (i11 != 0) {
            if (i11 == -1 || (i11 & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i11 == -1 || (i11 & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i11 == -1 || (i11 & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i11 == -1 || (i11 & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    private void setWindowInsetsListener(View view) {
        final boolean z11 = Build.VERSION.SDK_INT >= 29 && !isGestureInsetBottomIgnored() && !this.peekHeightAuto;
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || z11) {
            ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                    int unused = BottomSheetBehavior.this.insetTop = windowInsetsCompat.m();
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                        int unused2 = BottomSheetBehavior.this.insetBottom = windowInsetsCompat.j();
                        paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                    }
                    if (BottomSheetBehavior.this.paddingLeftSystemWindowInsets) {
                        paddingLeft = (isLayoutRtl ? relativePadding.end : relativePadding.start) + windowInsetsCompat.k();
                    }
                    if (BottomSheetBehavior.this.paddingRightSystemWindowInsets) {
                        paddingRight = (isLayoutRtl ? relativePadding.start : relativePadding.end) + windowInsetsCompat.l();
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (z11) {
                        int unused3 = BottomSheetBehavior.this.gestureInsetBottom = windowInsetsCompat.g().f16515d;
                    }
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets || z11) {
                        BottomSheetBehavior.this.updatePeekHeight(false);
                    }
                    return windowInsetsCompat;
                }
            });
        }
    }

    private void settleToStatePendingLayout(final int i11) {
        final View view = (View) this.viewRef.get();
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null || !parent.isLayoutRequested() || !h0.Z(view)) {
                settleToState(view, i11);
            } else {
                view.post(new Runnable() {
                    public void run() {
                        BottomSheetBehavior.this.settleToState(view, i11);
                    }
                });
            }
        }
    }

    private void updateAccessibilityActions() {
        View view;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            h0.r0(view, 524288);
            h0.r0(view, 262144);
            h0.r0(view, 1048576);
            int i11 = this.expandHalfwayActionId;
            if (i11 != -1) {
                h0.r0(view, i11);
            }
            int i12 = 6;
            if (!this.fitToContents && this.state != 6) {
                this.expandHalfwayActionId = addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6);
            }
            if (this.hideable && this.state != 5) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.a.f8555y, 5);
            }
            int i13 = this.state;
            if (i13 == 3) {
                if (this.fitToContents) {
                    i12 = 4;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.a.f8554x, i12);
            } else if (i13 == 4) {
                if (this.fitToContents) {
                    i12 = 3;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.a.f8553w, i12);
            } else if (i13 == 6) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.a.f8554x, 4);
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.a.f8553w, 3);
            }
        }
    }

    private void updateDrawableForTargetState(int i11) {
        ValueAnimator valueAnimator;
        if (i11 != 2) {
            boolean z11 = i11 == 3;
            if (this.isShapeExpanded != z11) {
                this.isShapeExpanded = z11;
                if (this.materialShapeDrawable != null && (valueAnimator = this.interpolatorAnimator) != null) {
                    if (valueAnimator.isRunning()) {
                        this.interpolatorAnimator.reverse();
                        return;
                    }
                    float f11 = z11 ? 0.0f : 1.0f;
                    this.interpolatorAnimator.setFloatValues(new float[]{1.0f - f11, f11});
                    this.interpolatorAnimator.start();
                }
            }
        }
    }

    private void updateImportantForAccessibility(boolean z11) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z11) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = coordinatorLayout.getChildAt(i11);
                    if (childAt != this.viewRef.get()) {
                        if (z11) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                h0.I0(childAt, 4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            h0.I0(childAt, this.importantForAccessibilityMap.get(childAt).intValue());
                        }
                    }
                }
                if (!z11) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePeekHeight(boolean z11) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z11) {
                    settleToStatePendingLayout(this.state);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i11) {
        float f11;
        float f12;
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            int i12 = this.collapsedOffset;
            if (i11 > i12 || i12 == getExpandedOffset()) {
                int i13 = this.collapsedOffset;
                f11 = (float) (i13 - i11);
                f12 = (float) (this.parentHeight - i13);
            } else {
                int i14 = this.collapsedOffset;
                f11 = (float) (i14 - i11);
                f12 = (float) (i14 - getExpandedOffset());
            }
            float f13 = f11 / f12;
            for (int i15 = 0; i15 < this.callbacks.size(); i15++) {
                this.callbacks.get(i15).onSlide(view, f13);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (h0.b0(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i11));
            if (findScrollingChild != null) {
                return findScrollingChild;
            }
        }
        return null;
    }

    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout r10, V r11, android.view.MotionEvent r12) {
        /*
            r9 = this;
            boolean r0 = r11.isShown()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00d2
            boolean r0 = r9.draggable
            if (r0 != 0) goto L_0x000e
            goto L_0x00d2
        L_0x000e:
            int r0 = r12.getActionMasked()
            if (r0 != 0) goto L_0x0017
            r9.reset()
        L_0x0017:
            android.view.VelocityTracker r3 = r9.velocityTracker
            if (r3 != 0) goto L_0x0021
            android.view.VelocityTracker r3 = android.view.VelocityTracker.obtain()
            r9.velocityTracker = r3
        L_0x0021:
            android.view.VelocityTracker r3 = r9.velocityTracker
            r3.addMovement(r12)
            r3 = 0
            r4 = -1
            r5 = 2
            if (r0 == 0) goto L_0x003c
            if (r0 == r2) goto L_0x0031
            r11 = 3
            if (r0 == r11) goto L_0x0031
            goto L_0x007f
        L_0x0031:
            r9.touchingScrollingChild = r1
            r9.activePointerId = r4
            boolean r11 = r9.ignoreEvents
            if (r11 == 0) goto L_0x007f
            r9.ignoreEvents = r1
            return r1
        L_0x003c:
            float r6 = r12.getX()
            int r6 = (int) r6
            float r7 = r12.getY()
            int r7 = (int) r7
            r9.initialY = r7
            int r7 = r9.state
            if (r7 == r5) goto L_0x006e
            java.lang.ref.WeakReference<android.view.View> r7 = r9.nestedScrollingChildRef
            if (r7 == 0) goto L_0x0057
            java.lang.Object r7 = r7.get()
            android.view.View r7 = (android.view.View) r7
            goto L_0x0058
        L_0x0057:
            r7 = r3
        L_0x0058:
            if (r7 == 0) goto L_0x006e
            int r8 = r9.initialY
            boolean r7 = r10.isPointInChildBounds(r7, r6, r8)
            if (r7 == 0) goto L_0x006e
            int r7 = r12.getActionIndex()
            int r7 = r12.getPointerId(r7)
            r9.activePointerId = r7
            r9.touchingScrollingChild = r2
        L_0x006e:
            int r7 = r9.activePointerId
            if (r7 != r4) goto L_0x007c
            int r4 = r9.initialY
            boolean r11 = r10.isPointInChildBounds(r11, r6, r4)
            if (r11 != 0) goto L_0x007c
            r11 = r2
            goto L_0x007d
        L_0x007c:
            r11 = r1
        L_0x007d:
            r9.ignoreEvents = r11
        L_0x007f:
            boolean r11 = r9.ignoreEvents
            if (r11 != 0) goto L_0x008e
            androidx.customview.widget.ViewDragHelper r11 = r9.viewDragHelper
            if (r11 == 0) goto L_0x008e
            boolean r11 = r11.R(r12)
            if (r11 == 0) goto L_0x008e
            return r2
        L_0x008e:
            java.lang.ref.WeakReference<android.view.View> r11 = r9.nestedScrollingChildRef
            if (r11 == 0) goto L_0x0099
            java.lang.Object r11 = r11.get()
            r3 = r11
            android.view.View r3 = (android.view.View) r3
        L_0x0099:
            if (r0 != r5) goto L_0x00d1
            if (r3 == 0) goto L_0x00d1
            boolean r11 = r9.ignoreEvents
            if (r11 != 0) goto L_0x00d1
            int r11 = r9.state
            if (r11 == r2) goto L_0x00d1
            float r11 = r12.getX()
            int r11 = (int) r11
            float r0 = r12.getY()
            int r0 = (int) r0
            boolean r10 = r10.isPointInChildBounds(r3, r11, r0)
            if (r10 != 0) goto L_0x00d1
            androidx.customview.widget.ViewDragHelper r10 = r9.viewDragHelper
            if (r10 == 0) goto L_0x00d1
            int r10 = r9.initialY
            float r10 = (float) r10
            float r11 = r12.getY()
            float r10 = r10 - r11
            float r10 = java.lang.Math.abs(r10)
            androidx.customview.widget.ViewDragHelper r11 = r9.viewDragHelper
            int r11 = r11.B()
            float r11 = (float) r11
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x00d1
            r1 = r2
        L_0x00d1:
            return r1
        L_0x00d2:
            r9.ignoreEvents = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onInterceptTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, final V v11, int i11) {
        MaterialShapeDrawable materialShapeDrawable2;
        if (h0.C(coordinatorLayout) && !h0.C(v11)) {
            v11.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v11);
            this.viewRef = new WeakReference<>(v11);
            if (this.shapeThemingEnabled && (materialShapeDrawable2 = this.materialShapeDrawable) != null) {
                h0.B0(v11, materialShapeDrawable2);
            }
            MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
            if (materialShapeDrawable3 != null) {
                float f11 = this.elevation;
                if (f11 == -1.0f) {
                    f11 = h0.z(v11);
                }
                materialShapeDrawable3.setElevation(f11);
                boolean z11 = this.state == 3;
                this.isShapeExpanded = z11;
                this.materialShapeDrawable.setInterpolation(z11 ? 0.0f : 1.0f);
            }
            updateAccessibilityActions();
            if (h0.D(v11) == 0) {
                h0.I0(v11, 1);
            }
            int measuredWidth = v11.getMeasuredWidth();
            int i12 = this.maxWidth;
            if (measuredWidth > i12 && i12 != -1) {
                final ViewGroup.LayoutParams layoutParams = v11.getLayoutParams();
                layoutParams.width = this.maxWidth;
                v11.post(new Runnable() {
                    public void run() {
                        v11.setLayoutParams(layoutParams);
                    }
                });
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.p(coordinatorLayout, this.dragCallback);
        }
        int top = v11.getTop();
        coordinatorLayout.onLayoutChild(v11, i11);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v11.getHeight();
        this.childHeight = height;
        int i13 = this.parentHeight;
        int i14 = i13 - height;
        int i15 = this.insetTop;
        if (i14 < i15) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = i13;
            } else {
                this.childHeight = i13 - i15;
            }
        }
        this.fitToContentsOffset = Math.max(0, i13 - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i16 = this.state;
        if (i16 == 3) {
            h0.h0(v11, getExpandedOffset());
        } else if (i16 == 6) {
            h0.h0(v11, this.halfExpandedOffset);
        } else if (this.hideable && i16 == 5) {
            h0.h0(v11, this.parentHeight);
        } else if (i16 == 4) {
            h0.h0(v11, this.collapsedOffset);
        } else if (i16 == 1 || i16 == 2) {
            h0.h0(v11, top - v11.getTop());
        }
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v11));
        return true;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v11, View view, float f11, float f12) {
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        if (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v11, view, f11, f12)) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int[] iArr, int i13) {
        if (i13 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (view == (weakReference != null ? (View) weakReference.get() : null)) {
                int top = v11.getTop();
                int i14 = top - i12;
                if (i12 > 0) {
                    if (i14 < getExpandedOffset()) {
                        iArr[1] = top - getExpandedOffset();
                        h0.h0(v11, -iArr[1]);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i12;
                        h0.h0(v11, -i12);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i12 < 0 && !view.canScrollVertically(-1)) {
                    int i15 = this.collapsedOffset;
                    if (i14 > i15 && !this.hideable) {
                        iArr[1] = top - i15;
                        h0.h0(v11, -iArr[1]);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i12;
                        h0.h0(v11, -i12);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v11.getTop());
                this.lastNestedScrollDy = i12;
                this.nestedScrolled = true;
            }
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v11, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v11, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i11 = savedState.state;
        if (i11 == 1 || i11 == 2) {
            this.state = 4;
        } else {
            this.state = i11;
        }
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v11) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v11), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, View view2, int i11, int i12) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i11 & 2) != 0) {
            return true;
        }
        return false;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v11, View view, int i11) {
        int i12;
        int i13;
        int i14 = 3;
        if (v11.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        WeakReference<View> weakReference = this.nestedScrollingChildRef;
        if (weakReference != null && view == weakReference.get() && this.nestedScrolled) {
            if (this.lastNestedScrollDy > 0) {
                if (this.fitToContents) {
                    i12 = this.fitToContentsOffset;
                } else {
                    int top = v11.getTop();
                    int i15 = this.halfExpandedOffset;
                    if (top > i15) {
                        i12 = i15;
                    } else {
                        i12 = getExpandedOffset();
                    }
                }
                startSettlingAnimation(v11, i14, i12, false);
                this.nestedScrolled = false;
            } else if (!this.hideable || !shouldHide(v11, getYVelocity())) {
                if (this.lastNestedScrollDy == 0) {
                    int top2 = v11.getTop();
                    if (!this.fitToContents) {
                        int i16 = this.halfExpandedOffset;
                        if (top2 < i16) {
                            if (top2 < Math.abs(top2 - this.collapsedOffset)) {
                                i12 = getExpandedOffset();
                                startSettlingAnimation(v11, i14, i12, false);
                                this.nestedScrolled = false;
                            }
                            i12 = this.halfExpandedOffset;
                        } else if (Math.abs(top2 - i16) < Math.abs(top2 - this.collapsedOffset)) {
                            i12 = this.halfExpandedOffset;
                        } else {
                            i13 = this.collapsedOffset;
                        }
                    } else if (Math.abs(top2 - this.fitToContentsOffset) < Math.abs(top2 - this.collapsedOffset)) {
                        i12 = this.fitToContentsOffset;
                        startSettlingAnimation(v11, i14, i12, false);
                        this.nestedScrolled = false;
                    } else {
                        i13 = this.collapsedOffset;
                    }
                } else if (this.fitToContents) {
                    i13 = this.collapsedOffset;
                } else {
                    int top3 = v11.getTop();
                    if (Math.abs(top3 - this.halfExpandedOffset) < Math.abs(top3 - this.collapsedOffset)) {
                        i12 = this.halfExpandedOffset;
                    } else {
                        i13 = this.collapsedOffset;
                    }
                }
                i14 = 4;
                startSettlingAnimation(v11, i14, i12, false);
                this.nestedScrolled = false;
            } else {
                i12 = this.parentHeight;
                i14 = 5;
                startSettlingAnimation(v11, i14, i12, false);
                this.nestedScrolled = false;
            }
            i14 = 6;
            startSettlingAnimation(v11, i14, i12, false);
            this.nestedScrolled = false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v11, MotionEvent motionEvent) {
        if (!v11.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null) {
            viewDragHelper2.H(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (this.viewDragHelper != null && actionMasked == 2 && !this.ignoreEvents && Math.abs(((float) this.initialY) - motionEvent.getY()) > ((float) this.viewDragHelper.B())) {
            this.viewDragHelper.c(v11, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z11) {
        this.draggable = z11;
    }

    public void setExpandedOffset(int i11) {
        if (i11 >= 0) {
            this.expandedOffset = i11;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z11) {
        if (this.fitToContents != z11) {
            this.fitToContents = z11;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            setStateInternal((!this.fitToContents || this.state != 6) ? this.state : 3);
            updateAccessibilityActions();
        }
    }

    public void setGestureInsetBottomIgnored(boolean z11) {
        this.gestureInsetBottomIgnored = z11;
    }

    public void setHalfExpandedRatio(float f11) {
        if (f11 <= 0.0f || f11 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f11;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideable(boolean z11) {
        if (this.hideable != z11) {
            this.hideable = z11;
            if (!z11 && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setMaxWidth(int i11) {
        this.maxWidth = i11;
    }

    public void setPeekHeight(int i11) {
        setPeekHeight(i11, false);
    }

    public void setSaveFlags(int i11) {
        this.saveFlags = i11;
    }

    public void setSkipCollapsed(boolean z11) {
        this.skipCollapsed = z11;
    }

    public void setState(int i11) {
        if (i11 != this.state) {
            if (this.viewRef != null) {
                settleToStatePendingLayout(i11);
            } else if (i11 == 4 || i11 == 3 || i11 == 6 || (this.hideable && i11 == 5)) {
                this.state = i11;
            }
        }
    }

    public void setStateInternal(int i11) {
        View view;
        if (this.state != i11) {
            this.state = i11;
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i11 == 3) {
                    updateImportantForAccessibility(true);
                } else if (i11 == 6 || i11 == 5 || i11 == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i11);
                for (int i12 = 0; i12 < this.callbacks.size(); i12++) {
                    this.callbacks.get(i12).onStateChanged(view, i11);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z11) {
        this.updateImportantForAccessibilityOnSiblings = z11;
    }

    public void settleToState(View view, int i11) {
        int i12;
        int i13;
        if (i11 == 4) {
            i12 = this.collapsedOffset;
        } else if (i11 == 6) {
            int i14 = this.halfExpandedOffset;
            if (!this.fitToContents || i14 > (i13 = this.fitToContentsOffset)) {
                i12 = i14;
            } else {
                i11 = 3;
                i12 = i13;
            }
        } else if (i11 == 3) {
            i12 = getExpandedOffset();
        } else if (!this.hideable || i11 != 5) {
            throw new IllegalArgumentException("Illegal state argument: " + i11);
        } else {
            i12 = this.parentHeight;
        }
        startSettlingAnimation(view, i11, i12, false);
    }

    public boolean shouldHide(View view, float f11) {
        if (this.skipCollapsed) {
            return true;
        }
        if (view.getTop() < this.collapsedOffset) {
            return false;
        }
        if (Math.abs((((float) view.getTop()) + (f11 * 0.1f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f) {
            return true;
        }
        return false;
    }

    public void startSettlingAnimation(View view, int i11, int i12, boolean z11) {
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 != null && (!z11 ? viewDragHelper2.S(view, view.getLeft(), i12) : viewDragHelper2.Q(view.getLeft(), i12))) {
            setStateInternal(2);
            updateDrawableForTargetState(i11);
            if (this.settleRunnable == null) {
                this.settleRunnable = new SettleRunnable(view, i11);
            }
            if (!this.settleRunnable.isPosted) {
                BottomSheetBehavior<V>.SettleRunnable settleRunnable2 = this.settleRunnable;
                settleRunnable2.targetState = i11;
                h0.p0(view, settleRunnable2);
                boolean unused = this.settleRunnable.isPosted = true;
                return;
            }
            this.settleRunnable.targetState = i11;
            return;
        }
        setStateInternal(i11);
    }

    private void createMaterialShapeDrawable(Context context, AttributeSet attributeSet, boolean z11, ColorStateList colorStateList) {
        if (this.shapeThemingEnabled) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            if (!z11 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
                return;
            }
            this.materialShapeDrawable.setFillColor(colorStateList);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r0
            goto L_0x001f
        L_0x000c:
            boolean r2 = r3.peekHeightAuto
            if (r2 != 0) goto L_0x0017
            int r2 = r3.peekHeight
            if (r2 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = r1
            goto L_0x001f
        L_0x0017:
            r3.peekHeightAuto = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.peekHeight = r4
        L_0x001f:
            if (r0 == 0) goto L_0x0024
            r3.updatePeekHeight(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i11;
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.shapeThemingEnabled = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i12 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i12);
        if (hasValue) {
            createMaterialShapeDrawable(context, attributeSet, hasValue, MaterialResources.getColorStateList(context, obtainStyledAttributes, i12));
        } else {
            createMaterialShapeDrawable(context, attributeSet, hasValue);
        }
        createShapeValueAnimator();
        if (Build.VERSION.SDK_INT >= 21) {
            this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i13 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i13)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i14);
        if (peekValue == null || (i11 = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i14, -1));
        } else {
            setPeekHeight(i11);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i15 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i15);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
