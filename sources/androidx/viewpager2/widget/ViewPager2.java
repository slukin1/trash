package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.h0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R;
import androidx.viewpager2.adapter.StatefulAdapter;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static boolean sFeatureEnhancedA11yEnabled = true;
    public AccessibilityProvider mAccessibilityProvider;
    public int mCurrentItem;
    private RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() {
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.mCurrentItemDirty = true;
            viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
        }
    };
    public boolean mCurrentItemDirty = false;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
    private FakeDrag mFakeDragger;
    public LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit = -1;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private PageTransformerAdapter mPageTransformerAdapter;
    private PagerSnapHelper mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem = -1;
    public RecyclerView mRecyclerView;
    private RecyclerView.ItemAnimator mSavedItemAnimator = null;
    private boolean mSavedItemAnimatorPresent = false;
    public ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect = new Rect();
    private final Rect mTmpContainerRect = new Rect();
    private boolean mUserInputEnabled = true;

    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public boolean handlesGetAccessibilityClassName() {
            return false;
        }

        public boolean handlesLmPerformAccessibilityAction(int i11) {
            return false;
        }

        public boolean handlesPerformAccessibilityAction(int i11, Bundle bundle) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onAttachAdapter(RecyclerView.Adapter<?> adapter) {
        }

        public void onDetachAdapter(RecyclerView.Adapter<?> adapter) {
        }

        public String onGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public void onLmInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i11) {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean onPerformAccessibilityAction(int i11, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        public void onRestorePendingState() {
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        }

        public void onSetLayoutDirection() {
        }

        public void onSetNewCurrentItem() {
        }

        public void onSetOrientation() {
        }

        public void onSetUserInputEnabled() {
        }
    }

    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        public boolean handlesLmPerformAccessibilityAction(int i11) {
            return (i11 == 8192 || i11 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        public void onLmInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!ViewPager2.this.isUserInputEnabled()) {
                accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.a.f8548r);
                accessibilityNodeInfoCompat.f0(AccessibilityNodeInfoCompat.a.f8547q);
                accessibilityNodeInfoCompat.K0(false);
            }
        }

        public boolean onLmPerformAccessibilityAction(int i11) {
            if (handlesLmPerformAccessibilityAction(i11)) {
                return false;
            }
            throw new IllegalStateException();
        }

        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeInserted(int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeMoved(int i11, int i12, int i13) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeChanged(int i11, int i12, Object obj) {
            onChanged();
        }
    }

    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewPager2.this.mAccessibilityProvider.onLmInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
        }

        public boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i11, Bundle bundle) {
            if (ViewPager2.this.mAccessibilityProvider.handlesLmPerformAccessibilityAction(i11)) {
                return ViewPager2.this.mAccessibilityProvider.onLmPerformAccessibilityAction(i11);
            }
            return super.performAccessibilityAction(recycler, state, i11, bundle);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z11, boolean z12) {
            return false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface OffscreenPageLimit {
    }

    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i11) {
        }

        public void onPageScrolled(int i11, float f11, int i12) {
        }

        public void onPageSelected(int i11) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public class PageAwareAccessibilityProvider extends AccessibilityProvider {
        private final AccessibilityViewCommand mActionPageBackward = new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() - 1);
                return true;
            }
        };
        private final AccessibilityViewCommand mActionPageForward = new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                PageAwareAccessibilityProvider.this.setCurrentItemFromAccessibilityCommand(((ViewPager2) view).getCurrentItem() + 1);
                return true;
            }
        };
        private RecyclerView.AdapterDataObserver mAdapterDataObserver;

        public PageAwareAccessibilityProvider() {
            super();
        }

        private void addCollectionInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i11;
            int i12 = 1;
            if (ViewPager2.this.getAdapter() == null) {
                i11 = 0;
                i12 = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                i12 = ViewPager2.this.getAdapter().getItemCount();
                i11 = 1;
            } else {
                i11 = ViewPager2.this.getAdapter().getItemCount();
            }
            accessibilityNodeInfoCompat.q0(AccessibilityNodeInfoCompat.f.b(i12, i11, false, 0));
        }

        private void addCollectionItemInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i11 = 0;
            int position = ViewPager2.this.getOrientation() == 1 ? ViewPager2.this.mLayoutManager.getPosition(view) : 0;
            if (ViewPager2.this.getOrientation() == 0) {
                i11 = ViewPager2.this.mLayoutManager.getPosition(view);
            }
            accessibilityNodeInfoCompat.r0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(position, 1, i11, 1, false, false));
        }

        private void addScrollActions(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int itemCount;
            RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
            if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && ViewPager2.this.isUserInputEnabled()) {
                if (ViewPager2.this.mCurrentItem > 0) {
                    accessibilityNodeInfoCompat.a(8192);
                }
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    accessibilityNodeInfoCompat.a(4096);
                }
                accessibilityNodeInfoCompat.K0(true);
            }
        }

        public boolean handlesGetAccessibilityClassName() {
            return true;
        }

        public boolean handlesPerformAccessibilityAction(int i11, Bundle bundle) {
            return i11 == 8192 || i11 == 4096;
        }

        public void onAttachAdapter(RecyclerView.Adapter<?> adapter) {
            updatePageAccessibilityActions();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        public void onDetachAdapter(RecyclerView.Adapter<?> adapter) {
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
            }
        }

        public String onGetAccessibilityClassName() {
            if (handlesGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        public void onInitialize(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            h0.I0(recyclerView, 2);
            this.mAdapterDataObserver = new DataSetChangeObserver() {
                public void onChanged() {
                    PageAwareAccessibilityProvider.this.updatePageAccessibilityActions();
                }
            };
            if (h0.D(ViewPager2.this) == 0) {
                h0.I0(ViewPager2.this, 1);
            }
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat U0 = AccessibilityNodeInfoCompat.U0(accessibilityNodeInfo);
            addCollectionInfo(U0);
            if (Build.VERSION.SDK_INT >= 16) {
                addScrollActions(U0);
            }
        }

        public void onLmInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            addCollectionItemInfo(view, accessibilityNodeInfoCompat);
        }

        public boolean onPerformAccessibilityAction(int i11, Bundle bundle) {
            int i12;
            if (handlesPerformAccessibilityAction(i11, bundle)) {
                if (i11 == 8192) {
                    i12 = ViewPager2.this.getCurrentItem() - 1;
                } else {
                    i12 = ViewPager2.this.getCurrentItem() + 1;
                }
                setCurrentItemFromAccessibilityCommand(i12);
                return true;
            }
            throw new IllegalStateException();
        }

        public void onRestorePendingState() {
            updatePageAccessibilityActions();
        }

        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(onGetAccessibilityClassName());
        }

        public void onSetLayoutDirection() {
            updatePageAccessibilityActions();
        }

        public void onSetNewCurrentItem() {
            updatePageAccessibilityActions();
        }

        public void onSetOrientation() {
            updatePageAccessibilityActions();
        }

        public void onSetUserInputEnabled() {
            updatePageAccessibilityActions();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(2048);
            }
        }

        public void setCurrentItemFromAccessibilityCommand(int i11) {
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.setCurrentItemInternal(i11, true);
            }
        }

        public void updatePageAccessibilityActions() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i11 = 16908360;
            h0.r0(viewPager2, 16908360);
            h0.r0(viewPager2, 16908361);
            h0.r0(viewPager2, 16908358);
            h0.r0(viewPager2, 16908359);
            if (ViewPager2.this.getAdapter() != null && (itemCount = ViewPager2.this.getAdapter().getItemCount()) != 0 && ViewPager2.this.isUserInputEnabled()) {
                if (ViewPager2.this.getOrientation() == 0) {
                    boolean isRtl = ViewPager2.this.isRtl();
                    int i12 = isRtl ? 16908360 : 16908361;
                    if (isRtl) {
                        i11 = 16908361;
                    }
                    if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                        h0.t0(viewPager2, new AccessibilityNodeInfoCompat.a(i12, (CharSequence) null), (CharSequence) null, this.mActionPageForward);
                    }
                    if (ViewPager2.this.mCurrentItem > 0) {
                        h0.t0(viewPager2, new AccessibilityNodeInfoCompat.a(i11, (CharSequence) null), (CharSequence) null, this.mActionPageBackward);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    h0.t0(viewPager2, new AccessibilityNodeInfoCompat.a(16908359, (CharSequence) null), (CharSequence) null, this.mActionPageForward);
                }
                if (ViewPager2.this.mCurrentItem > 0) {
                    h0.t0(viewPager2, new AccessibilityNodeInfoCompat.a(16908358, (CharSequence) null), (CharSequence) null, this.mActionPageBackward);
                }
            }
        }
    }

    public interface PageTransformer {
        void transformPage(View view, float f11);
    }

    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.mAccessibilityProvider.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.mAccessibilityProvider.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollState {
    }

    public static class SmoothScrollToPosition implements Runnable {
        private final int mPosition;
        private final RecyclerView mRecyclerView;

        public SmoothScrollToPosition(int i11, RecyclerView recyclerView) {
            this.mPosition = i11;
            this.mRecyclerView = recyclerView;
        }

        public void run() {
            this.mRecyclerView.smoothScrollToPosition(this.mPosition);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        initialize(context, (AttributeSet) null);
    }

    private RecyclerView.j enforceChildFillListener() {
        return new RecyclerView.j() {
            public void onChildViewAttachedToWindow(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (layoutParams.width != -1 || layoutParams.height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            public void onChildViewDetachedFromWindow(View view) {
            }
        };
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        AccessibilityProvider accessibilityProvider;
        if (sFeatureEnhancedA11yEnabled) {
            accessibilityProvider = new PageAwareAccessibilityProvider();
        } else {
            accessibilityProvider = new BasicAccessibilityProvider();
        }
        this.mAccessibilityProvider = accessibilityProvider;
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        recyclerViewImpl.setId(h0.n());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.mLayoutManager = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mFakeDragger = new FakeDrag(this, scrollEventAdapter, this.mRecyclerView);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.mPagerSnapHelper = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.mPageChangeEventDispatcher = compositeOnPageChangeCallback;
        this.mScrollEventAdapter.setOnPageChangeCallback(compositeOnPageChangeCallback);
        AnonymousClass2 r32 = new OnPageChangeCallback() {
            public void onPageScrollStateChanged(int i11) {
                if (i11 == 0) {
                    ViewPager2.this.updateCurrentItem();
                }
            }

            public void onPageSelected(int i11) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.mCurrentItem != i11) {
                    viewPager2.mCurrentItem = i11;
                    viewPager2.mAccessibilityProvider.onSetNewCurrentItem();
                }
            }
        };
        AnonymousClass3 r42 = new OnPageChangeCallback() {
            public void onPageSelected(int i11) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.mRecyclerView.requestFocus(2);
                }
            }
        };
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r32);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(r42);
        this.mAccessibilityProvider.onInitialize(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.mLayoutManager);
        this.mPageTransformerAdapter = pageTransformerAdapter;
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(pageTransformerAdapter);
        RecyclerView recyclerView = this.mRecyclerView;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    private void restorePendingState() {
        RecyclerView.Adapter adapter;
        if (this.mPendingCurrentItem != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.mPendingAdapterState;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    ((StatefulAdapter) adapter).restoreState(parcelable);
                }
                this.mPendingAdapterState = null;
            }
            int max = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
            this.mCurrentItem = max;
            this.mPendingCurrentItem = -1;
            this.mRecyclerView.scrollToPosition(max);
            this.mAccessibilityProvider.onRestorePendingState();
        }
    }

    private void setOrientation(Context context, AttributeSet attributeSet) {
        int[] iArr = R.styleable.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        h0.v0(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.beginFakeDrag();
    }

    public boolean canScrollHorizontally(int i11) {
        return this.mRecyclerView.canScrollHorizontally(i11);
    }

    public boolean canScrollVertically(int i11) {
        return this.mRecyclerView.canScrollVertically(i11);
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i11 = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i11));
            sparseArray.remove(i11);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.endFakeDrag();
    }

    public boolean fakeDragBy(@SuppressLint({"SupportAnnotationUsage"}) float f11) {
        return this.mFakeDragger.fakeDragBy(f11);
    }

    public CharSequence getAccessibilityClassName() {
        if (this.mAccessibilityProvider.handlesGetAccessibilityClassName()) {
            return this.mAccessibilityProvider.onGetAccessibilityClassName();
        }
        return super.getAccessibilityClassName();
    }

    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public RecyclerView.ItemDecoration getItemDecorationAt(int i11) {
        return this.mRecyclerView.getItemDecorationAt(i11);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation() == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int i11;
        int i12;
        RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            i11 = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            i12 = recyclerView.getPaddingRight();
        } else {
            i11 = recyclerView.getHeight() - recyclerView.getPaddingTop();
            i12 = recyclerView.getPaddingBottom();
        }
        return i11 - i12;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.getScrollState();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.isFakeDragging();
    }

    public boolean isRtl() {
        return this.mLayoutManager.getLayoutDirection() == 1;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i13 - i11) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i14 - i12) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTmpChildRect;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    public void onMeasure(int i11, int i12) {
        measureChild(this.mRecyclerView, i11, i12);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i11, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i12, measuredState << 16));
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.mCurrentItem;
        this.mPendingAdapterState = savedState.mAdapterState;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mRecyclerViewId = this.mRecyclerView.getId();
        int i11 = this.mPendingCurrentItem;
        if (i11 == -1) {
            i11 = this.mCurrentItem;
        }
        savedState.mCurrentItem = i11;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            savedState.mAdapterState = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.mAdapterState = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    public boolean performAccessibilityAction(int i11, Bundle bundle) {
        if (this.mAccessibilityProvider.handlesPerformAccessibilityAction(i11, bundle)) {
            return this.mAccessibilityProvider.onPerformAccessibilityAction(i11, bundle);
        }
        return super.performAccessibilityAction(i11, bundle);
    }

    public void registerOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(onPageChangeCallback);
    }

    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        this.mRecyclerView.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i11) {
        this.mRecyclerView.removeItemDecorationAt(i11);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.getPageTransformer() != null) {
            double relativeScrollPosition = this.mScrollEventAdapter.getRelativeScrollPosition();
            int i11 = (int) relativeScrollPosition;
            float f11 = (float) (relativeScrollPosition - ((double) i11));
            this.mPageTransformerAdapter.onPageScrolled(i11, f11, Math.round(((float) getPageSize()) * f11));
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.onDetachAdapter(adapter2);
        unregisterCurrentItemDataSetTracker(adapter2);
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.onAttachAdapter(adapter);
        registerCurrentItemDataSetTracker(adapter);
    }

    public void setCurrentItem(int i11) {
        setCurrentItem(i11, true);
    }

    public void setCurrentItemInternal(int i11, boolean z11) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i11, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i11, 0), adapter.getItemCount() - 1);
            if (min != this.mCurrentItem || !this.mScrollEventAdapter.isIdle()) {
                int i12 = this.mCurrentItem;
                if (min != i12 || !z11) {
                    double d11 = (double) i12;
                    this.mCurrentItem = min;
                    this.mAccessibilityProvider.onSetNewCurrentItem();
                    if (!this.mScrollEventAdapter.isIdle()) {
                        d11 = this.mScrollEventAdapter.getRelativeScrollPosition();
                    }
                    this.mScrollEventAdapter.notifyProgrammaticScroll(min, z11);
                    if (!z11) {
                        this.mRecyclerView.scrollToPosition(min);
                        return;
                    }
                    double d12 = (double) min;
                    if (Math.abs(d12 - d11) > 3.0d) {
                        this.mRecyclerView.scrollToPosition(d12 > d11 ? min - 3 : min + 3);
                        RecyclerView recyclerView = this.mRecyclerView;
                        recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                        return;
                    }
                    this.mRecyclerView.smoothScrollToPosition(min);
                }
            }
        }
    }

    public void setLayoutDirection(int i11) {
        super.setLayoutDirection(i11);
        this.mAccessibilityProvider.onSetLayoutDirection();
    }

    public void setOffscreenPageLimit(int i11) {
        if (i11 >= 1 || i11 == -1) {
            this.mOffscreenPageLimit = i11;
            this.mRecyclerView.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        if (pageTransformer != this.mPageTransformerAdapter.getPageTransformer()) {
            this.mPageTransformerAdapter.setPageTransformer(pageTransformer);
            requestTransform();
        }
    }

    public void setUserInputEnabled(boolean z11) {
        this.mUserInputEnabled = z11;
        this.mAccessibilityProvider.onSetUserInputEnabled();
    }

    public void snapToPage() {
        View findSnapView = this.mPagerSnapHelper.findSnapView(this.mLayoutManager);
        if (findSnapView != null) {
            int[] calculateDistanceToFinalSnap = this.mPagerSnapHelper.calculateDistanceToFinalSnap(this.mLayoutManager, findSnapView);
            if (calculateDistanceToFinalSnap[0] != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.mRecyclerView.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
            }
        }
    }

    public void unregisterOnPageChangeCallback(OnPageChangeCallback onPageChangeCallback) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(onPageChangeCallback);
    }

    public void updateCurrentItem() {
        PagerSnapHelper pagerSnapHelper = this.mPagerSnapHelper;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.mLayoutManager);
            if (findSnapView != null) {
                int position = this.mLayoutManager.getPosition(findSnapView);
                if (position != this.mCurrentItem && getScrollState() == 0) {
                    this.mPageChangeEventDispatcher.onPageSelected(position);
                }
                this.mCurrentItemDirty = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                if (Build.VERSION.SDK_INT >= 24) {
                    return new SavedState(parcel, classLoader);
                }
                return new SavedState(parcel);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };
        public Parcelable mAdapterState;
        public int mCurrentItem;
        public int mRecyclerViewId;

        @SuppressLint({"ClassVerificationFailure"})
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            readValues(parcel, classLoader);
        }

        private void readValues(Parcel parcel, ClassLoader classLoader) {
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i11);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            readValues(parcel, (ClassLoader) null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration, int i11) {
        this.mRecyclerView.addItemDecoration(itemDecoration, i11);
    }

    public void setCurrentItem(int i11, boolean z11) {
        if (!isFakeDragging()) {
            setCurrentItemInternal(i11, z11);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public void setOrientation(int i11) {
        this.mLayoutManager.setOrientation(i11);
        this.mAccessibilityProvider.onSetOrientation();
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initialize(context, attributeSet);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public ViewPager2(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initialize(context, attributeSet);
    }
}
