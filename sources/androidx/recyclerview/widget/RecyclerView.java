package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.a0;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import androidx.core.view.j0;
import androidx.core.view.q;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.v;
import androidx.recyclerview.widget.w;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huobi.woodpecker.aop.WoodPeckerScrollAspect;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.aspectj.lang.JoinPoint;

public class RecyclerView extends ViewGroup implements a0, androidx.core.view.o {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    public static final boolean ALLOW_THREAD_GAP_WORK;
    private static final float DECELERATION_RATE = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final boolean POST_UPDATES_ON_ANIMATION;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static boolean sDebugAssertionsEnabled = false;
    public static final n sDefaultEdgeEffectFactory = new n();
    public static final Interpolator sQuinticInterpolator = new c();
    public static boolean sVerboseLoggingEnabled = false;
    public s mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    public Adapter mAdapter;
    public a mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private h mChildDrawingOrderCallback;
    public f mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public j mGapWorker;
    public boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private k mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public ItemAnimator mItemAnimator;
    private ItemAnimator.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    public final ArrayList<ItemDecoration> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    public LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final m mObserver;
    private List<j> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<k> mOnItemTouchListeners;
    public final List<ViewHolder> mPendingAccessibilityImportanceChange;
    public SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    public boolean mPostedAnimatorRunner;
    public j.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    public final Recycler mRecycler;
    public l mRecyclerListener;
    public final List<l> mRecyclerListeners;
    public final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private q mScrollingChildHelper;
    public final State mState;
    public final Rect mTempRect;
    private final Rect mTempRect2;
    public final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    public final o mViewFlinger;
    private final w.b mViewInfoProcessCallback;
    public final w mViewInfoStore;

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds = false;
        private final AdapterDataObservable mObservable = new AdapterDataObservable();
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh2, int i11) {
            boolean z11 = vh2.mBindingAdapter == null;
            if (z11) {
                vh2.mPosition = i11;
                if (hasStableIds()) {
                    vh2.mItemId = getItemId(i11);
                }
                vh2.setFlags(1, 519);
                androidx.core.os.n.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh2.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (vh2.itemView.getParent() == null && h0.Z(vh2.itemView) != vh2.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + vh2.isTmpDetached() + ", attached to window: " + h0.Z(vh2.itemView) + ", holder: " + vh2);
                } else if (vh2.itemView.getParent() == null && h0.Z(vh2.itemView)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + vh2);
                }
            }
            onBindViewHolder(vh2, i11, vh2.getUnmodifiedPayloads());
            if (z11) {
                vh2.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh2.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                androidx.core.os.n.b();
            }
        }

        public boolean canRestoreState() {
            int i11 = g.f10739a[this.mStateRestorationPolicy.ordinal()];
            if (i11 == 1) {
                return false;
            }
            if (i11 != 2) {
                return true;
            }
            if (getItemCount() > 0) {
                return true;
            }
            return false;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i11) {
            try {
                androidx.core.os.n.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i11);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i11;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.os.n.b();
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> adapter, ViewHolder viewHolder, int i11) {
            if (adapter == this) {
                return i11;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i11) {
            return -1;
        }

        public int getItemViewType(int i11) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i11) {
            this.mObservable.d(i11, 1);
        }

        public final void notifyItemInserted(int i11) {
            this.mObservable.f(i11, 1);
        }

        public final void notifyItemMoved(int i11, int i12) {
            this.mObservable.c(i11, i12);
        }

        public final void notifyItemRangeChanged(int i11, int i12) {
            this.mObservable.d(i11, i12);
        }

        public final void notifyItemRangeInserted(int i11, int i12) {
            this.mObservable.f(i11, i12);
        }

        public final void notifyItemRangeRemoved(int i11, int i12) {
            this.mObservable.g(i11, i12);
        }

        public final void notifyItemRemoved(int i11) {
            this.mObservable.g(i11, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh2, int i11);

        public void onBindViewHolder(VH vh2, int i11, List<Object> list) {
            onBindViewHolder(vh2, i11);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i11);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh2) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh2) {
        }

        public void onViewDetachedFromWindow(VH vh2) {
        }

        public void onViewRecycled(VH vh2) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z11) {
            if (!hasObservers()) {
                this.mHasStableIds = z11;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i11, Object obj) {
            this.mObservable.e(i11, 1, obj);
        }

        public final void notifyItemRangeChanged(int i11, int i12, Object obj) {
            this.mObservable.e(i11, i12, obj);
        }
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }

        public void c(int i11, int i12) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeMoved(i11, i12, 1);
            }
        }

        public void d(int i11, int i12) {
            e(i11, i12, (Object) null);
        }

        public void e(int i11, int i12, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeChanged(i11, i12, obj);
            }
        }

        public void f(int i11, int i12) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeInserted(i11, i12);
            }
        }

        public void g(int i11, int i12) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onItemRangeRemoved(i11, i12);
            }
        }

        public void h() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) this.mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i11, int i12) {
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            onItemRangeChanged(i11, i12);
        }

        public void onItemRangeInserted(int i11, int i12) {
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
        }

        public void onItemRangeRemoved(int i11, int i12) {
        }

        public void onStateRestorationPolicyChanged() {
        }
    }

    public static class EdgeEffectFactory {
        public EdgeEffect a(RecyclerView recyclerView, int i11) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration = 120;
        private long mChangeDuration = 250;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private b mListener = null;
        private long mMoveDuration = 250;
        private long mRemoveDuration = 120;

        public static class ItemHolderInfo {

            /* renamed from: a  reason: collision with root package name */
            public int f10688a;

            /* renamed from: b  reason: collision with root package name */
            public int f10689b;

            /* renamed from: c  reason: collision with root package name */
            public int f10690c;

            /* renamed from: d  reason: collision with root package name */
            public int f10691d;

            public ItemHolderInfo a(ViewHolder viewHolder) {
                return b(viewHolder, 0);
            }

            public ItemHolderInfo b(ViewHolder viewHolder, int i11) {
                View view = viewHolder.itemView;
                this.f10688a = view.getLeft();
                this.f10689b = view.getTop();
                this.f10690c = view.getRight();
                this.f10691d = view.getBottom();
                return this;
            }
        }

        public interface a {
            void a();
        }

        public interface b {
            void a(ViewHolder viewHolder);
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i11 = viewHolder.mFlags & 14;
            if (viewHolder.isInvalid()) {
                return 4;
            }
            if ((i11 & 4) != 0) {
                return i11;
            }
            int oldPosition = viewHolder.getOldPosition();
            int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i11 : i11 | 2048;
        }

        public abstract boolean animateAppearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animateDisappearance(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public abstract boolean animatePersistence(ViewHolder viewHolder, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
            return true;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder, List<Object> list) {
            return canReuseUpdatedViewHolder(viewHolder);
        }

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            onAnimationFinished(viewHolder);
            b bVar = this.mListener;
            if (bVar != null) {
                bVar.a(viewHolder);
            }
        }

        public final void dispatchAnimationStarted(ViewHolder viewHolder) {
            onAnimationStarted(viewHolder);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mFinishedListeners.get(i11).a();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (!isRunning) {
                    aVar.a();
                } else {
                    this.mFinishedListeners.add(aVar);
                }
            }
            return isRunning;
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public void onAnimationFinished(ViewHolder viewHolder) {
        }

        public void onAnimationStarted(ViewHolder viewHolder) {
        }

        public ItemHolderInfo recordPostLayoutInformation(State state, ViewHolder viewHolder) {
            return obtainHolderInfo().a(viewHolder);
        }

        public ItemHolderInfo recordPreLayoutInformation(State state, ViewHolder viewHolder, int i11, List<Object> list) {
            return obtainHolderInfo().a(viewHolder);
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j11) {
            this.mAddDuration = j11;
        }

        public void setChangeDuration(long j11) {
            this.mChangeDuration = j11;
        }

        public void setListener(b bVar) {
            this.mListener = bVar;
        }

        public void setMoveDuration(long j11) {
            this.mMoveDuration = j11;
        }

        public void setRemoveDuration(long j11) {
            this.mRemoveDuration = j11;
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void getItemOffsets(Rect rect, int i11, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, State state) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, State state) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition(), recyclerView);
        }
    }

    public static abstract class LayoutManager {
        public boolean mAutoMeasure = false;
        public f mChildHelper;
        private int mHeight;
        private int mHeightMode;
        public v mHorizontalBoundCheck;
        private final v.b mHorizontalBoundCheckCallback;
        public boolean mIsAttachedToWindow = false;
        private boolean mItemPrefetchEnabled = true;
        private boolean mMeasurementCacheEnabled = true;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations = false;
        public SmoothScroller mSmoothScroller;
        public v mVerticalBoundCheck;
        private final v.b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public class a implements v.b {
            public a() {
            }

            public View a(int i11) {
                return LayoutManager.this.getChildAt(i11);
            }

            public int b() {
                return LayoutManager.this.getPaddingLeft();
            }

            public int c() {
                return LayoutManager.this.getWidth() - LayoutManager.this.getPaddingRight();
            }

            public int d(View view) {
                return LayoutManager.this.getDecoratedLeft(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int e(View view) {
                return LayoutManager.this.getDecoratedRight(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
            }
        }

        public class b implements v.b {
            public b() {
            }

            public View a(int i11) {
                return LayoutManager.this.getChildAt(i11);
            }

            public int b() {
                return LayoutManager.this.getPaddingTop();
            }

            public int c() {
                return LayoutManager.this.getHeight() - LayoutManager.this.getPaddingBottom();
            }

            public int d(View view) {
                return LayoutManager.this.getDecoratedTop(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int e(View view) {
                return LayoutManager.this.getDecoratedBottom(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
            }
        }

        public interface c {
            void a(int i11, int i12);
        }

        public LayoutManager() {
            a aVar = new a();
            this.mHorizontalBoundCheckCallback = aVar;
            b bVar = new b();
            this.mVerticalBoundCheckCallback = bVar;
            this.mHorizontalBoundCheck = new v(aVar);
            this.mVerticalBoundCheck = new v(bVar);
        }

        private void addViewInt(View view, int i11, boolean z11) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z11 || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.c(view, i11, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int m11 = this.mChildHelper.m(view);
                if (i11 == -1) {
                    i11 = this.mChildHelper.g();
                }
                if (m11 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                } else if (m11 != i11) {
                    this.mRecyclerView.mLayout.moveView(m11, i11);
                }
            } else {
                this.mChildHelper.a(view, i11, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.mPendingInvalidate) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + layoutParams.mViewHolder);
                }
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public static int chooseSize(int i11, int i12, int i13) {
            int mode = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i12, i13) : size;
            }
            return Math.min(size, Math.max(i12, i13));
        }

        private void detachViewInternal(int i11, View view) {
            this.mChildHelper.d(i11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @java.lang.Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L_0x000f
                if (r3 < 0) goto L_0x000d
                goto L_0x0011
            L_0x000d:
                r3 = r2
                goto L_0x001e
            L_0x000f:
                if (r3 < 0) goto L_0x0013
            L_0x0011:
                r2 = r0
                goto L_0x001e
            L_0x0013:
                r4 = -1
                if (r3 != r4) goto L_0x0018
                r3 = r1
                goto L_0x0011
            L_0x0018:
                r4 = -2
                if (r3 != r4) goto L_0x000d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1
            L_0x001e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i11 = left - paddingLeft;
            int min = Math.min(0, i11);
            int i12 = top - paddingTop;
            int min2 = Math.min(0, i12);
            int i13 = width2 - width;
            int max = Math.max(0, i13);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i11, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i13);
            }
            if (min2 == 0) {
                min2 = Math.min(i12, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static Properties getProperties(Context context, AttributeSet attributeSet, int i11, int i12) {
            Properties properties = new Properties();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i11, i12);
            properties.orientation = obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
            properties.spanCount = obtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
            properties.reverseLayout = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            properties.stackFromEnd = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return properties;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i11, int i12) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i11 >= width || rect.right - i11 <= paddingLeft || rect.top - i12 >= height || rect.bottom - i12 <= paddingTop) {
                return false;
            }
            return true;
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

        private void scrapOrRecycleView(Recycler recycler, int i11, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "ignoring view " + childViewHolderInt);
                }
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                detachViewAt(i11);
                recycler.I(view);
                this.mRecyclerView.mViewInfoStore.k(childViewHolderInt);
            } else {
                removeViewAt(i11);
                recycler.H(childViewHolderInt);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i11, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.b(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.p(childViewHolderInt);
            }
            this.mChildHelper.c(view, i11, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int i11, int i12, State state, c cVar) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int i11, c cVar) {
        }

        public int computeHorizontalScrollExtent(State state) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State state) {
            return 0;
        }

        public int computeHorizontalScrollRange(State state) {
            return 0;
        }

        public int computeVerticalScrollExtent(State state) {
            return 0;
        }

        public int computeVerticalScrollOffset(State state) {
            return 0;
        }

        public int computeVerticalScrollRange(State state) {
            return 0;
        }

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.m(view), view);
        }

        public void detachAndScrapViewAt(int i11, Recycler recycler) {
            scrapOrRecycleView(recycler, i11, getChildAt(i11));
        }

        public void detachView(View view) {
            int m11 = this.mChildHelper.m(view);
            if (m11 >= 0) {
                detachViewInternal(m11, view);
            }
        }

        public void detachViewAt(int i11) {
            detachViewInternal(i11, getChildAt(i11));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.n(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i11) {
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i11 && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.e() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int i11) {
            f fVar = this.mChildHelper;
            if (fVar != null) {
                return fVar.f(i11);
            }
            return null;
        }

        public int getChildCount() {
            f fVar = this.mChildHelper;
            if (fVar != null) {
                return fVar.g();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.n(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return h0.F(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            return h0.G(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return h0.H(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return h0.K(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return h0.L(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(View view, boolean z11, Rect rect) {
            Matrix matrix;
            if (z11) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i11).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.q(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            return smoothScroller != null && smoothScroller.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z11, boolean z12) {
            boolean z13 = this.mHorizontalBoundCheck.b(view, 24579) && this.mVerticalBoundCheck.b(view, 24579);
            return z11 ? z13 : !z13;
        }

        public void layoutDecorated(View view, int i11, int i12, int i13, int i14) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i11 + rect.left, i12 + rect.top, i13 - rect.right, i14 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i11, int i12, int i13, int i14) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i11 + rect.left + layoutParams.leftMargin, i12 + rect.top + layoutParams.topMargin, (i13 - rect.right) - layoutParams.rightMargin, (i14 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void measureChild(View view, int i11, int i12) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i13 = i11 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i14 = i12 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i13, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i14, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i11, int i12) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i13 = i11 + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i14 = i12 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin + i13, layoutParams.width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + layoutParams.topMargin + layoutParams.bottomMargin + i14, layoutParams.height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i11, int i12) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                detachViewAt(i11);
                attachView(childAt, i12);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i11 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i11) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i11);
            }
        }

        public void offsetChildrenVertical(int i11) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i11);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i11, int i12) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i11, Recycler recycler, State state) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.n(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public View onInterceptFocusSearch(View view, int i11) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i11, int i12, int i13) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i11, int i12, Object obj) {
            onItemsUpdated(recyclerView, i11, i12);
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler recycler, State state) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State state) {
        }

        public void onMeasure(Recycler recycler, State state, int i11, int i12) {
            this.mRecyclerView.defaultOnMeasure(i11, i12);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i11) {
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i11, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i11, bundle);
        }

        public boolean performAccessibilityActionForItem(View view, int i11, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i11, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i11, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                h0.p0(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.q(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            int j11 = recycler.j();
            for (int i11 = j11 - 1; i11 >= 0; i11--) {
                View n11 = recycler.n(i11);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(n11);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(n11, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    recycler.D(n11);
                }
            }
            recycler.e();
            if (j11 > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.G(view);
        }

        public void removeAndRecycleViewAt(int i11, Recycler recycler) {
            View childAt = getChildAt(i11);
            removeViewAt(i11);
            recycler.G(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            this.mChildHelper.p(view);
        }

        public void removeViewAt(int i11) {
            if (getChildAt(i11) != null) {
                this.mChildHelper.q(i11);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z11) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z11, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int i11, Recycler recycler, State state) {
            return 0;
        }

        public void scrollToPosition(int i11) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            }
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int i11, Recycler recycler, State state) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z11) {
            this.mAutoMeasure = z11;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z11) {
            if (z11 != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z11;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.P();
                }
            }
        }

        public void setMeasureSpecs(int i11, int i12) {
            this.mWidth = View.MeasureSpec.getSize(i11);
            int mode = View.MeasureSpec.getMode(i11);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i12);
            int mode2 = View.MeasureSpec.getMode(i12);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i11, int i12) {
            setMeasuredDimension(chooseSize(i11, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i12, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i11, int i12) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i11, i12);
                return;
            }
            int i13 = Integer.MIN_VALUE;
            int i14 = Integer.MAX_VALUE;
            int i15 = Integer.MAX_VALUE;
            int i16 = Integer.MIN_VALUE;
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt = getChildAt(i17);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i18 = rect.left;
                if (i18 < i14) {
                    i14 = i18;
                }
                int i19 = rect.right;
                if (i19 > i13) {
                    i13 = i19;
                }
                int i21 = rect.top;
                if (i21 < i15) {
                    i15 = i21;
                }
                int i22 = rect.bottom;
                if (i22 > i16) {
                    i16 = i22;
                }
            }
            this.mRecyclerView.mTempRect.set(i14, i15, i13, i16);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i11, i12);
        }

        public void setMeasurementCacheEnabled(boolean z11) {
            this.mMeasurementCacheEnabled = z11;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i11, int i12, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i11, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i12, layoutParams.height);
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i11, int i12, LayoutParams layoutParams) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i11, layoutParams.width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i12, layoutParams.height);
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i11) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.isRunning())) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = smoothScroller;
            smoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i11) {
            addViewInt(view, i11, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i11) {
            addViewInt(view, i11, false);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z11 = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z11 = false;
                }
                accessibilityEvent.setScrollable(z11);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(8192);
                accessibilityNodeInfoCompat.K0(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
                accessibilityNodeInfoCompat.K0(true);
            }
            accessibilityNodeInfoCompat.q0(AccessibilityNodeInfoCompat.f.b(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), isLayoutHierarchical(recycler, state), getSelectionModeForAccessibility(recycler, state)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0093 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, int r11, android.os.Bundle r12) {
            /*
                r8 = this;
                androidx.recyclerview.widget.RecyclerView r9 = r8.mRecyclerView
                r10 = 0
                if (r9 != 0) goto L_0x0006
                return r10
            L_0x0006:
                int r9 = r8.getHeight()
                int r12 = r8.getWidth()
                android.graphics.Rect r0 = new android.graphics.Rect
                r0.<init>()
                androidx.recyclerview.widget.RecyclerView r1 = r8.mRecyclerView
                android.graphics.Matrix r1 = r1.getMatrix()
                boolean r1 = r1.isIdentity()
                if (r1 == 0) goto L_0x002f
                androidx.recyclerview.widget.RecyclerView r1 = r8.mRecyclerView
                boolean r1 = r1.getGlobalVisibleRect(r0)
                if (r1 == 0) goto L_0x002f
                int r9 = r0.height()
                int r12 = r0.width()
            L_0x002f:
                r0 = 4096(0x1000, float:5.74E-42)
                r1 = 1
                if (r11 == r0) goto L_0x0065
                r0 = 8192(0x2000, float:1.14794E-41)
                if (r11 == r0) goto L_0x003b
                r3 = r10
                r4 = r3
                goto L_0x0091
            L_0x003b:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                r0 = -1
                boolean r11 = r11.canScrollVertically(r0)
                if (r11 == 0) goto L_0x0050
                int r11 = r8.getPaddingTop()
                int r9 = r9 - r11
                int r11 = r8.getPaddingBottom()
                int r9 = r9 - r11
                int r9 = -r9
                goto L_0x0051
            L_0x0050:
                r9 = r10
            L_0x0051:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollHorizontally(r0)
                if (r11 == 0) goto L_0x008f
                int r11 = r8.getPaddingLeft()
                int r12 = r12 - r11
                int r11 = r8.getPaddingRight()
                int r12 = r12 - r11
                int r11 = -r12
                goto L_0x008c
            L_0x0065:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollVertically(r1)
                if (r11 == 0) goto L_0x0078
                int r11 = r8.getPaddingTop()
                int r9 = r9 - r11
                int r11 = r8.getPaddingBottom()
                int r9 = r9 - r11
                goto L_0x0079
            L_0x0078:
                r9 = r10
            L_0x0079:
                androidx.recyclerview.widget.RecyclerView r11 = r8.mRecyclerView
                boolean r11 = r11.canScrollHorizontally(r1)
                if (r11 == 0) goto L_0x008f
                int r11 = r8.getPaddingLeft()
                int r12 = r12 - r11
                int r11 = r8.getPaddingRight()
                int r11 = r12 - r11
            L_0x008c:
                r4 = r9
                r3 = r11
                goto L_0x0091
            L_0x008f:
                r4 = r9
                r3 = r10
            L_0x0091:
                if (r4 != 0) goto L_0x0096
                if (r3 != 0) goto L_0x0096
                return r10
            L_0x0096:
                androidx.recyclerview.widget.RecyclerView r2 = r8.mRecyclerView
                r5 = 0
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                r7 = 1
                r2.smoothScrollBy(r3, r4, r5, r6, r7)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z11, boolean z12) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i11 = childRectangleOnScreenScrollAmount[0];
            int i12 = childRectangleOnScreenScrollAmount[1];
            if ((z12 && !isFocusedChildVisibleAfterScrolling(recyclerView, i11, i12)) || (i11 == 0 && i12 == 0)) {
                return false;
            }
            if (z11) {
                recyclerView.scrollBy(i11, i12);
            } else {
                recyclerView.smoothScrollBy(i11, i12);
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0020
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0020
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001e
            L_0x001c:
                r5 = r3
                goto L_0x0031
            L_0x001e:
                if (r7 != r1) goto L_0x0022
            L_0x0020:
                r7 = r4
                goto L_0x0031
            L_0x0022:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x0029
                goto L_0x002c
            L_0x0029:
                r7 = r4
                r5 = r6
                goto L_0x0031
            L_0x002c:
                r7 = r4
                r5 = r2
                goto L_0x0031
            L_0x002f:
                r5 = r6
                r7 = r5
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void attachView(View view, int i11) {
            attachView(view, i11, (LayoutParams) view.getLayoutParams());
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i11, int i12) {
            this.mRecyclerView.setMeasuredDimension(i11, i12);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    public static abstract class OnFlingListener {
        public abstract boolean onFling(int i11, int i12);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        }

        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        }
    }

    public static class RecycledViewPool {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<a> f10694a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        public int f10695b = 0;

        /* renamed from: c  reason: collision with root package name */
        public Set<Adapter<?>> f10696c = Collections.newSetFromMap(new IdentityHashMap());

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ArrayList<ViewHolder> f10697a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            public int f10698b = 5;

            /* renamed from: c  reason: collision with root package name */
            public long f10699c = 0;

            /* renamed from: d  reason: collision with root package name */
            public long f10700d = 0;
        }

        public void a() {
            this.f10695b++;
        }

        public void b(Adapter<?> adapter) {
            this.f10696c.add(adapter);
        }

        public void c() {
            for (int i11 = 0; i11 < this.f10694a.size(); i11++) {
                a valueAt = this.f10694a.valueAt(i11);
                Iterator<ViewHolder> it2 = valueAt.f10697a.iterator();
                while (it2.hasNext()) {
                    androidx.customview.poolingcontainer.a.a(it2.next().itemView);
                }
                valueAt.f10697a.clear();
            }
        }

        public void d() {
            this.f10695b--;
        }

        public void e(Adapter<?> adapter, boolean z11) {
            this.f10696c.remove(adapter);
            if (this.f10696c.size() == 0 && !z11) {
                for (int i11 = 0; i11 < this.f10694a.size(); i11++) {
                    SparseArray<a> sparseArray = this.f10694a;
                    ArrayList<ViewHolder> arrayList = sparseArray.get(sparseArray.keyAt(i11)).f10697a;
                    for (int i12 = 0; i12 < arrayList.size(); i12++) {
                        androidx.customview.poolingcontainer.a.a(arrayList.get(i12).itemView);
                    }
                }
            }
        }

        public void f(int i11, long j11) {
            a i12 = i(i11);
            i12.f10700d = l(i12.f10700d, j11);
        }

        public void g(int i11, long j11) {
            a i12 = i(i11);
            i12.f10699c = l(i12.f10699c, j11);
        }

        public ViewHolder h(int i11) {
            a aVar = this.f10694a.get(i11);
            if (aVar == null || aVar.f10697a.isEmpty()) {
                return null;
            }
            ArrayList<ViewHolder> arrayList = aVar.f10697a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final a i(int i11) {
            a aVar = this.f10694a.get(i11);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f10694a.put(i11, aVar2);
            return aVar2;
        }

        public void j(Adapter<?> adapter, Adapter<?> adapter2, boolean z11) {
            if (adapter != null) {
                d();
            }
            if (!z11 && this.f10695b == 0) {
                c();
            }
            if (adapter2 != null) {
                a();
            }
        }

        public void k(ViewHolder viewHolder) {
            int itemViewType = viewHolder.getItemViewType();
            ArrayList<ViewHolder> arrayList = i(itemViewType).f10697a;
            if (this.f10694a.get(itemViewType).f10698b <= arrayList.size()) {
                androidx.customview.poolingcontainer.a.a(viewHolder.itemView);
            } else if (!RecyclerView.sDebugAssertionsEnabled || !arrayList.contains(viewHolder)) {
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            } else {
                throw new IllegalArgumentException("this scrap item already exists");
            }
        }

        public long l(long j11, long j12) {
            return j11 == 0 ? j12 : ((j11 / 4) * 3) + (j12 / 4);
        }

        public void m(int i11, int i12) {
            a i13 = i(i11);
            i13.f10698b = i12;
            ArrayList<ViewHolder> arrayList = i13.f10697a;
            while (arrayList.size() > i12) {
                arrayList.remove(arrayList.size() - 1);
            }
        }

        public boolean n(int i11, long j11, long j12) {
            long j13 = i(i11).f10700d;
            return j13 == 0 || j11 + j13 < j12;
        }

        public boolean o(int i11, long j11, long j12) {
            long j13 = i(i11).f10699c;
            return j13 == 0 || j11 + j13 < j12;
        }
    }

    public final class Recycler {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<ViewHolder> f10701a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<ViewHolder> f10702b = null;

        /* renamed from: c  reason: collision with root package name */
        public final ArrayList<ViewHolder> f10703c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        public final List<ViewHolder> f10704d;

        /* renamed from: e  reason: collision with root package name */
        public int f10705e;

        /* renamed from: f  reason: collision with root package name */
        public int f10706f;

        /* renamed from: g  reason: collision with root package name */
        public RecycledViewPool f10707g;

        /* renamed from: h  reason: collision with root package name */
        public ViewCacheExtension f10708h;

        public Recycler() {
            ArrayList<ViewHolder> arrayList = new ArrayList<>();
            this.f10701a = arrayList;
            this.f10704d = Collections.unmodifiableList(arrayList);
            this.f10705e = 2;
            this.f10706f = 2;
        }

        public void A() {
            for (int i11 = 0; i11 < this.f10703c.size(); i11++) {
                androidx.customview.poolingcontainer.a.a(this.f10703c.get(i11).itemView);
            }
            B(RecyclerView.this.mAdapter);
        }

        public final void B(Adapter<?> adapter) {
            C(adapter, false);
        }

        public final void C(Adapter<?> adapter, boolean z11) {
            RecycledViewPool recycledViewPool = this.f10707g;
            if (recycledViewPool != null) {
                recycledViewPool.e(adapter, z11);
            }
        }

        public void D(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            H(childViewHolderInt);
        }

        public void E() {
            for (int size = this.f10703c.size() - 1; size >= 0; size--) {
                F(size);
            }
            this.f10703c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.b();
            }
        }

        public void F(int i11) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "Recycling cached view at index " + i11);
            }
            ViewHolder viewHolder = this.f10703c.get(i11);
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + viewHolder);
            }
            a(viewHolder, true);
            this.f10703c.remove(i11);
        }

        public void G(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            H(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        public void H(ViewHolder viewHolder) {
            boolean z11;
            boolean z12 = false;
            boolean z13 = true;
            if (viewHolder.isScrap() || viewHolder.itemView.getParent() != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Scrapped or attached views may not be recycled. isScrap:");
                sb2.append(viewHolder.isScrap());
                sb2.append(" isAttached:");
                if (viewHolder.itemView.getParent() != null) {
                    z12 = true;
                }
                sb2.append(z12);
                sb2.append(RecyclerView.this.exceptionLabel());
                throw new IllegalArgumentException(sb2.toString());
            } else if (viewHolder.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + viewHolder + RecyclerView.this.exceptionLabel());
            } else if (!viewHolder.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = viewHolder.doesTransientStatePreventRecycling();
                Adapter adapter = RecyclerView.this.mAdapter;
                boolean z14 = adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(viewHolder);
                if (!RecyclerView.sDebugAssertionsEnabled || !this.f10703c.contains(viewHolder)) {
                    if (z14 || viewHolder.isRecyclable()) {
                        if (this.f10706f <= 0 || viewHolder.hasAnyOfTheFlags(526)) {
                            z11 = false;
                        } else {
                            int size = this.f10703c.size();
                            if (size >= this.f10706f && size > 0) {
                                F(0);
                                size--;
                            }
                            if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.d(viewHolder.mPosition)) {
                                int i11 = size - 1;
                                while (i11 >= 0) {
                                    if (!RecyclerView.this.mPrefetchRegistry.d(this.f10703c.get(i11).mPosition)) {
                                        break;
                                    }
                                    i11--;
                                }
                                size = i11 + 1;
                            }
                            this.f10703c.add(size, viewHolder);
                            z11 = true;
                        }
                        if (!z11) {
                            a(viewHolder, true);
                        } else {
                            z13 = false;
                        }
                        z12 = z11;
                    } else {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + RecyclerView.this.exceptionLabel());
                        }
                        z13 = false;
                    }
                    RecyclerView.this.mViewInfoStore.q(viewHolder);
                    if (!z12 && !z13 && doesTransientStatePreventRecycling) {
                        androidx.customview.poolingcontainer.a.a(viewHolder.itemView);
                        viewHolder.mBindingAdapter = null;
                        viewHolder.mOwnerRecyclerView = null;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("cached view received recycle internal? " + viewHolder + RecyclerView.this.exceptionLabel());
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
            }
        }

        public void I(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f10702b == null) {
                    this.f10702b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f10702b.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f10701a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        public void J(RecycledViewPool recycledViewPool) {
            B(RecyclerView.this.mAdapter);
            RecycledViewPool recycledViewPool2 = this.f10707g;
            if (recycledViewPool2 != null) {
                recycledViewPool2.d();
            }
            this.f10707g = recycledViewPool;
            if (!(recycledViewPool == null || RecyclerView.this.getAdapter() == null)) {
                this.f10707g.a();
            }
            u();
        }

        public void K(ViewCacheExtension viewCacheExtension) {
            this.f10708h = viewCacheExtension;
        }

        public void L(int i11) {
            this.f10705e = i11;
            P();
        }

        public final boolean M(ViewHolder viewHolder, int i11, int i12, long j11) {
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = viewHolder.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            boolean z11 = false;
            if (j11 != Long.MAX_VALUE && !this.f10707g.n(itemViewType, nanoTime, j11)) {
                return false;
            }
            if (viewHolder.isTmpDetached()) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.attachViewToParent(viewHolder.itemView, recyclerView.getChildCount(), viewHolder.itemView.getLayoutParams());
                z11 = true;
            }
            RecyclerView.this.mAdapter.bindViewHolder(viewHolder, i11);
            if (z11) {
                RecyclerView.this.detachViewFromParent(viewHolder.itemView);
            }
            this.f10707g.f(viewHolder.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            b(viewHolder);
            if (RecyclerView.this.mState.e()) {
                viewHolder.mPreLayoutPosition = i12;
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:105:0x0251  */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x025f  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x01ca  */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01f3  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x01f6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.ViewHolder N(int r19, boolean r20, long r21) {
            /*
                r18 = this;
                r6 = r18
                r3 = r19
                r0 = r20
                if (r3 < 0) goto L_0x0282
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                int r1 = r1.b()
                if (r3 >= r1) goto L_0x0282
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                boolean r1 = r1.e()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r18.h(r19)
                if (r1 == 0) goto L_0x0028
                r4 = r7
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = r8
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r18.m(r19, r20)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.Q(r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.H(r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = r7
            L_0x005d:
                if (r1 != 0) goto L_0x01a9
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.mAdapterHelper
                int r5 = r5.m(r3)
                if (r5 < 0) goto L_0x0171
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x0171
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.mAdapter
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.mAdapter
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.mAdapter
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r6.l(r10, r9, r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = r7
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$ViewCacheExtension r0 = r6.f10708h
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.getChildViewHolder(r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                java.lang.String r0 = "RecyclerView"
                if (r1 != 0) goto L_0x0120
                boolean r1 = androidx.recyclerview.widget.RecyclerView.sVerboseLoggingEnabled
                if (r1 == 0) goto L_0x010c
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r5 = "tryGetViewHolderForPositionByDeadline("
                r1.append(r5)
                r1.append(r3)
                java.lang.String r5 = ") fetching from shared pool"
                r1.append(r5)
                java.lang.String r1 = r1.toString()
                android.util.Log.d(r0, r1)
            L_0x010c:
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r1 = r18.i()
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r1.h(r9)
                if (r1 == 0) goto L_0x0120
                r1.resetInternal()
                boolean r5 = androidx.recyclerview.widget.RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST
                if (r5 == 0) goto L_0x0120
                r6.r(r1)
            L_0x0120:
                if (r1 != 0) goto L_0x01a9
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                long r16 = r1.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r1 = (r21 > r10 ? 1 : (r21 == r10 ? 0 : -1))
                if (r1 == 0) goto L_0x013f
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r10 = r6.f10707g
                r11 = r9
                r12 = r16
                r14 = r21
                boolean r1 = r10.o(r11, r12, r14)
                if (r1 != 0) goto L_0x013f
                return r2
            L_0x013f:
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r1.mAdapter
                androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r2.createViewHolder(r1, r9)
                boolean r2 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
                if (r2 == 0) goto L_0x015a
                android.view.View r2 = r1.itemView
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.findNestedRecyclerView(r2)
                if (r2 == 0) goto L_0x015a
                java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
                r5.<init>(r2)
                r1.mNestedRecyclerView = r5
            L_0x015a:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r2.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$RecycledViewPool r2 = r6.f10707g
                long r10 = r10 - r16
                r2.g(r9, r10)
                boolean r2 = androidx.recyclerview.widget.RecyclerView.sVerboseLoggingEnabled
                if (r2 == 0) goto L_0x01a9
                java.lang.String r2 = "tryGetViewHolderForPositionByDeadline created new ViewHolder"
                android.util.Log.d(r0, r2)
                goto L_0x01a9
            L_0x0171:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x01a9:
                r9 = r1
                r10 = r4
                if (r10 == 0) goto L_0x01e3
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.e()
                if (r0 != 0) goto L_0x01e3
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01e3
                r9.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.f10727k
                if (r0 == 0) goto L_0x01e3
                int r0 = androidx.recyclerview.widget.RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$ItemAnimator r2 = r1.mItemAnimator
                androidx.recyclerview.widget.RecyclerView$State r1 = r1.mState
                java.util.List r4 = r9.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo r0 = r2.recordPreLayoutInformation(r1, r9, r0, r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.recordAnimationInfoIfBouncedHiddenView(r9, r0)
            L_0x01e3:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r0 = r0.mState
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x01f6
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01f6
                r9.mPreLayoutPosition = r3
                goto L_0x0209
            L_0x01f6:
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x020b
                boolean r0 = r9.needsUpdate()
                if (r0 != 0) goto L_0x020b
                boolean r0 = r9.isInvalid()
                if (r0 == 0) goto L_0x0209
                goto L_0x020b
            L_0x0209:
                r0 = r8
                goto L_0x0249
            L_0x020b:
                boolean r0 = androidx.recyclerview.widget.RecyclerView.sDebugAssertionsEnabled
                if (r0 == 0) goto L_0x0236
                boolean r0 = r9.isRemoved()
                if (r0 != 0) goto L_0x0216
                goto L_0x0236
            L_0x0216:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Removed holder should be bound and it should come here only in pre-layout. Holder: "
                r1.append(r2)
                r1.append(r9)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0236:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.mAdapterHelper
                int r2 = r0.m(r3)
                r0 = r18
                r1 = r9
                r3 = r19
                r4 = r21
                boolean r0 = r0.M(r1, r2, r3, r4)
            L_0x0249:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x025f
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0277
            L_0x025f:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x0275
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0277
            L_0x0275:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0277:
                r1.mViewHolder = r9
                if (r10 == 0) goto L_0x027e
                if (r0 == 0) goto L_0x027e
                goto L_0x027f
            L_0x027e:
                r7 = r8
            L_0x027f:
                r1.mPendingInvalidate = r7
                return r9
            L_0x0282:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$State r2 = r2.mState
                int r2 = r2.b()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.exceptionLabel()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.N(int, boolean, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        public void O(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.f10702b.remove(viewHolder);
            } else {
                this.f10701a.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        public void P() {
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            this.f10706f = this.f10705e + (layoutManager != null ? layoutManager.mPrefetchMaxCountObserved : 0);
            for (int size = this.f10703c.size() - 1; size >= 0 && this.f10703c.size() > this.f10706f; size--) {
                F(size);
            }
        }

        public boolean Q(ViewHolder viewHolder) {
            if (!viewHolder.isRemoved()) {
                int i11 = viewHolder.mPosition;
                if (i11 < 0 || i11 >= RecyclerView.this.mAdapter.getItemCount()) {
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + viewHolder + RecyclerView.this.exceptionLabel());
                } else if (!RecyclerView.this.mState.e() && RecyclerView.this.mAdapter.getItemViewType(viewHolder.mPosition) != viewHolder.getItemViewType()) {
                    return false;
                } else {
                    if (!RecyclerView.this.mAdapter.hasStableIds()) {
                        return true;
                    }
                    if (viewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(viewHolder.mPosition)) {
                        return true;
                    }
                    return false;
                }
            } else if (!RecyclerView.sDebugAssertionsEnabled || RecyclerView.this.mState.e()) {
                return RecyclerView.this.mState.e();
            } else {
                throw new IllegalStateException("should not receive a removed view unless it is pre layout" + RecyclerView.this.exceptionLabel());
            }
        }

        public void R(int i11, int i12) {
            int i13;
            int i14 = i12 + i11;
            for (int size = this.f10703c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f10703c.get(size);
                if (viewHolder != null && (i13 = viewHolder.mPosition) >= i11 && i13 < i14) {
                    viewHolder.addFlags(2);
                    F(size);
                }
            }
        }

        public void a(ViewHolder viewHolder, boolean z11) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            s sVar = RecyclerView.this.mAccessibilityDelegate;
            if (sVar != null) {
                AccessibilityDelegateCompat itemDelegate = sVar.getItemDelegate();
                h0.x0(view, itemDelegate instanceof s.a ? ((s.a) itemDelegate).a(view) : null);
            }
            if (z11) {
                g(viewHolder);
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            i().k(viewHolder);
        }

        public final void b(ViewHolder viewHolder) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = viewHolder.itemView;
                if (h0.D(view) == 0) {
                    h0.I0(view, 1);
                }
                s sVar = RecyclerView.this.mAccessibilityDelegate;
                if (sVar != null) {
                    AccessibilityDelegateCompat itemDelegate = sVar.getItemDelegate();
                    if (itemDelegate instanceof s.a) {
                        ((s.a) itemDelegate).b(view);
                    }
                    h0.x0(view, itemDelegate);
                }
            }
        }

        public void c() {
            this.f10701a.clear();
            E();
        }

        public void d() {
            int size = this.f10703c.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.f10703c.get(i11).clearOldPosition();
            }
            int size2 = this.f10701a.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.f10701a.get(i12).clearOldPosition();
            }
            ArrayList<ViewHolder> arrayList = this.f10702b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    this.f10702b.get(i13).clearOldPosition();
                }
            }
        }

        public void e() {
            this.f10701a.clear();
            ArrayList<ViewHolder> arrayList = this.f10702b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public int f(int i11) {
            if (i11 < 0 || i11 >= RecyclerView.this.mState.b()) {
                throw new IndexOutOfBoundsException("invalid position " + i11 + ". State item count is " + RecyclerView.this.mState.b() + RecyclerView.this.exceptionLabel());
            } else if (!RecyclerView.this.mState.e()) {
                return i11;
            } else {
                return RecyclerView.this.mAdapterHelper.m(i11);
            }
        }

        public void g(ViewHolder viewHolder) {
            l lVar = RecyclerView.this.mRecyclerListener;
            if (lVar != null) {
                lVar.a(viewHolder);
            }
            int size = RecyclerView.this.mRecyclerListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                RecyclerView.this.mRecyclerListeners.get(i11).a(viewHolder);
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter != null) {
                adapter.onViewRecycled(viewHolder);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.q(viewHolder);
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + viewHolder);
            }
        }

        public ViewHolder h(int i11) {
            int size;
            int m11;
            ArrayList<ViewHolder> arrayList = this.f10702b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i12 = 0;
                int i13 = 0;
                while (i13 < size) {
                    ViewHolder viewHolder = this.f10702b.get(i13);
                    if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i11) {
                        i13++;
                    } else {
                        viewHolder.addFlags(32);
                        return viewHolder;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (m11 = RecyclerView.this.mAdapterHelper.m(i11)) > 0 && m11 < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(m11);
                    while (i12 < size) {
                        ViewHolder viewHolder2 = this.f10702b.get(i12);
                        if (viewHolder2.wasReturnedFromScrap() || viewHolder2.getItemId() != itemId) {
                            i12++;
                        } else {
                            viewHolder2.addFlags(32);
                            return viewHolder2;
                        }
                    }
                }
            }
            return null;
        }

        public RecycledViewPool i() {
            if (this.f10707g == null) {
                this.f10707g = new RecycledViewPool();
                u();
            }
            return this.f10707g;
        }

        public int j() {
            return this.f10701a.size();
        }

        public List<ViewHolder> k() {
            return this.f10704d;
        }

        public ViewHolder l(long j11, int i11, boolean z11) {
            for (int size = this.f10701a.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f10701a.get(size);
                if (viewHolder.getItemId() == j11 && !viewHolder.wasReturnedFromScrap()) {
                    if (i11 == viewHolder.getItemViewType()) {
                        viewHolder.addFlags(32);
                        if (viewHolder.isRemoved() && !RecyclerView.this.mState.e()) {
                            viewHolder.setFlags(2, 14);
                        }
                        return viewHolder;
                    } else if (!z11) {
                        this.f10701a.remove(size);
                        RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
                        D(viewHolder.itemView);
                    }
                }
            }
            int size2 = this.f10703c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                ViewHolder viewHolder2 = this.f10703c.get(size2);
                if (viewHolder2.getItemId() == j11 && !viewHolder2.isAttachedToTransitionOverlay()) {
                    if (i11 == viewHolder2.getItemViewType()) {
                        if (!z11) {
                            this.f10703c.remove(size2);
                        }
                        return viewHolder2;
                    } else if (!z11) {
                        F(size2);
                        return null;
                    }
                }
            }
        }

        public ViewHolder m(int i11, boolean z11) {
            View e11;
            int size = this.f10701a.size();
            int i12 = 0;
            int i13 = 0;
            while (i13 < size) {
                ViewHolder viewHolder = this.f10701a.get(i13);
                if (viewHolder.wasReturnedFromScrap() || viewHolder.getLayoutPosition() != i11 || viewHolder.isInvalid() || (!RecyclerView.this.mState.f10724h && viewHolder.isRemoved())) {
                    i13++;
                } else {
                    viewHolder.addFlags(32);
                    return viewHolder;
                }
            }
            if (z11 || (e11 = RecyclerView.this.mChildHelper.e(i11)) == null) {
                int size2 = this.f10703c.size();
                while (i12 < size2) {
                    ViewHolder viewHolder2 = this.f10703c.get(i12);
                    if (viewHolder2.isInvalid() || viewHolder2.getLayoutPosition() != i11 || viewHolder2.isAttachedToTransitionOverlay()) {
                        i12++;
                    } else {
                        if (!z11) {
                            this.f10703c.remove(i12);
                        }
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + i11 + ") found match in cache: " + viewHolder2);
                        }
                        return viewHolder2;
                    }
                }
                return null;
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(e11);
            RecyclerView.this.mChildHelper.s(e11);
            int m11 = RecyclerView.this.mChildHelper.m(e11);
            if (m11 != -1) {
                RecyclerView.this.mChildHelper.d(m11);
                I(e11);
                childViewHolderInt.addFlags(8224);
                return childViewHolderInt;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
        }

        public View n(int i11) {
            return this.f10701a.get(i11).itemView;
        }

        public View o(int i11) {
            return p(i11, false);
        }

        public View p(int i11, boolean z11) {
            return N(i11, z11, Long.MAX_VALUE).itemView;
        }

        public final void q(ViewGroup viewGroup, boolean z11) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    q((ViewGroup) childAt, true);
                }
            }
            if (z11) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void r(ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            if (view instanceof ViewGroup) {
                q((ViewGroup) view, false);
            }
        }

        public void s() {
            int size = this.f10703c.size();
            for (int i11 = 0; i11 < size; i11++) {
                LayoutParams layoutParams = (LayoutParams) this.f10703c.get(i11).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.mInsetsDirty = true;
                }
            }
        }

        public void t() {
            int size = this.f10703c.size();
            for (int i11 = 0; i11 < size; i11++) {
                ViewHolder viewHolder = this.f10703c.get(i11);
                if (viewHolder != null) {
                    viewHolder.addFlags(6);
                    viewHolder.addChangePayload((Object) null);
                }
            }
            Adapter adapter = RecyclerView.this.mAdapter;
            if (adapter == null || !adapter.hasStableIds()) {
                E();
            }
        }

        public final void u() {
            if (this.f10707g != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter != null && recyclerView.isAttachedToWindow()) {
                    this.f10707g.b(RecyclerView.this.mAdapter);
                }
            }
        }

        public void v(int i11, int i12) {
            int size = this.f10703c.size();
            for (int i13 = 0; i13 < size; i13++) {
                ViewHolder viewHolder = this.f10703c.get(i13);
                if (viewHolder != null && viewHolder.mPosition >= i11) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + i13 + " holder " + viewHolder + " now at position " + (viewHolder.mPosition + i12));
                    }
                    viewHolder.offsetPosition(i12, false);
                }
            }
        }

        public void w(int i11, int i12) {
            int i13;
            int i14;
            int i15;
            int i16;
            if (i11 < i12) {
                i15 = -1;
                i14 = i11;
                i13 = i12;
            } else {
                i15 = 1;
                i13 = i11;
                i14 = i12;
            }
            int size = this.f10703c.size();
            for (int i17 = 0; i17 < size; i17++) {
                ViewHolder viewHolder = this.f10703c.get(i17);
                if (viewHolder != null && (i16 = viewHolder.mPosition) >= i14 && i16 <= i13) {
                    if (i16 == i11) {
                        viewHolder.offsetPosition(i12 - i11, false);
                    } else {
                        viewHolder.offsetPosition(i15, false);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + i17 + " holder " + viewHolder);
                    }
                }
            }
        }

        public void x(int i11, int i12, boolean z11) {
            int i13 = i11 + i12;
            for (int size = this.f10703c.size() - 1; size >= 0; size--) {
                ViewHolder viewHolder = this.f10703c.get(size);
                if (viewHolder != null) {
                    int i14 = viewHolder.mPosition;
                    if (i14 >= i13) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.mPosition - i12));
                        }
                        viewHolder.offsetPosition(-i12, z11);
                    } else if (i14 >= i11) {
                        viewHolder.addFlags(8);
                        F(size);
                    }
                }
            }
        }

        public void y(Adapter<?> adapter, Adapter<?> adapter2, boolean z11) {
            c();
            C(adapter, true);
            i().j(adapter, adapter2, z11);
            u();
        }

        public void z() {
            u();
        }
    }

    public static class SimpleOnItemTouchListener implements k {
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z11) {
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final a mRecyclingAction = new a(0, 0);
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition = -1;
        private View mTargetView;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f10710a;

            /* renamed from: b  reason: collision with root package name */
            public int f10711b;

            /* renamed from: c  reason: collision with root package name */
            public int f10712c;

            /* renamed from: d  reason: collision with root package name */
            public int f10713d;

            /* renamed from: e  reason: collision with root package name */
            public Interpolator f10714e;

            /* renamed from: f  reason: collision with root package name */
            public boolean f10715f;

            /* renamed from: g  reason: collision with root package name */
            public int f10716g;

            public a(int i11, int i12) {
                this(i11, i12, Integer.MIN_VALUE, (Interpolator) null);
            }

            public boolean a() {
                return this.f10713d >= 0;
            }

            public void b(int i11) {
                this.f10713d = i11;
            }

            public void c(RecyclerView recyclerView) {
                int i11 = this.f10713d;
                if (i11 >= 0) {
                    this.f10713d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i11);
                    this.f10715f = false;
                } else if (this.f10715f) {
                    e();
                    recyclerView.mViewFlinger.e(this.f10710a, this.f10711b, this.f10712c, this.f10714e);
                    int i12 = this.f10716g + 1;
                    this.f10716g = i12;
                    if (i12 > 10) {
                        Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f10715f = false;
                } else {
                    this.f10716g = 0;
                }
            }

            public void d(int i11, int i12, int i13, Interpolator interpolator) {
                this.f10710a = i11;
                this.f10711b = i12;
                this.f10712c = i13;
                this.f10714e = interpolator;
                this.f10715f = true;
            }

            public final void e() {
                if (this.f10714e != null && this.f10712c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f10712c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public a(int i11, int i12, int i13, Interpolator interpolator) {
                this.f10713d = -1;
                this.f10715f = false;
                this.f10716g = 0;
                this.f10710a = i11;
                this.f10711b = i12;
                this.f10712c = i13;
                this.f10714e = interpolator;
            }
        }

        public interface b {
            PointF computeScrollVectorForPosition(int i11);
        }

        public PointF computeScrollVectorForPosition(int i11) {
            LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i11);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i11) {
            return this.mRecyclerView.mLayout.findViewByPosition(i11);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i11) {
            this.mRecyclerView.scrollToPosition(i11);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f11 = pointF.x;
            float f12 = pointF.y;
            float sqrt = (float) Math.sqrt((double) ((f11 * f11) + (f12 * f12)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onAnimation(int i11, int i12) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f11 = computeScrollVectorForPosition.x;
                if (!(f11 == 0.0f && computeScrollVectorForPosition.y == 0.0f)) {
                    recyclerView.scrollStep((int) Math.signum(f11), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.c(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i11, i12, recyclerView.mState, this.mRecyclingAction);
                boolean a11 = this.mRecyclingAction.a();
                this.mRecyclingAction.c(recyclerView);
                if (a11 && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.d();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
                }
            }
        }

        public abstract void onSeekTargetStep(int i11, int i12, State state, a aVar);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, State state, a aVar);

        public void setTargetPosition(int i11) {
            this.mTargetPosition = i11;
        }

        public void start(RecyclerView recyclerView, LayoutManager layoutManager) {
            recyclerView.mViewFlinger.f();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = layoutManager;
            int i11 = this.mTargetPosition;
            if (i11 != -1) {
                recyclerView.mState.f10717a = i11;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.d();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f10717a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static class State {

        /* renamed from: a  reason: collision with root package name */
        public int f10717a = -1;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<Object> f10718b;

        /* renamed from: c  reason: collision with root package name */
        public int f10719c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f10720d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f10721e = 1;

        /* renamed from: f  reason: collision with root package name */
        public int f10722f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f10723g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f10724h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f10725i = false;

        /* renamed from: j  reason: collision with root package name */
        public boolean f10726j = false;

        /* renamed from: k  reason: collision with root package name */
        public boolean f10727k = false;

        /* renamed from: l  reason: collision with root package name */
        public boolean f10728l = false;

        /* renamed from: m  reason: collision with root package name */
        public int f10729m;

        /* renamed from: n  reason: collision with root package name */
        public long f10730n;

        /* renamed from: o  reason: collision with root package name */
        public int f10731o;

        /* renamed from: p  reason: collision with root package name */
        public int f10732p;

        /* renamed from: q  reason: collision with root package name */
        public int f10733q;

        public void a(int i11) {
            if ((this.f10721e & i11) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i11) + " but it is " + Integer.toBinaryString(this.f10721e));
            }
        }

        public int b() {
            if (this.f10724h) {
                return this.f10719c - this.f10720d;
            }
            return this.f10722f;
        }

        public int c() {
            return this.f10717a;
        }

        public boolean d() {
            return this.f10717a != -1;
        }

        public boolean e() {
            return this.f10724h;
        }

        public void f(Adapter adapter) {
            this.f10721e = 1;
            this.f10722f = adapter.getItemCount();
            this.f10724h = false;
            this.f10725i = false;
            this.f10726j = false;
        }

        public boolean g() {
            return this.f10728l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f10717a + ", mData=" + this.f10718b + ", mItemCount=" + this.f10722f + ", mIsMeasuring=" + this.f10726j + ", mPreviousLayoutItemCount=" + this.f10719c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f10720d + ", mStructureChanged=" + this.f10723g + ", mInPreLayout=" + this.f10724h + ", mRunSimpleAnimations=" + this.f10727k + ", mRunPredictiveAnimations=" + this.f10728l + '}';
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View a(Recycler recycler, int i11, int i12);
    }

    public static abstract class ViewHolder {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        public Adapter<? extends ViewHolder> mBindingAdapter;
        public int mFlags;
        public boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public int mOldPosition = -1;
        public RecyclerView mOwnerRecyclerView;
        public List<Object> mPayloads = null;
        public int mPendingAccessibilityState = -1;
        public int mPosition = -1;
        public int mPreLayoutPosition = -1;
        public Recycler mScrapContainer = null;
        public ViewHolder mShadowedHolder = null;
        public ViewHolder mShadowingHolder = null;
        public List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i11) {
            this.mFlags = i11 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && h0.X(this.itemView);
        }

        public void flagRemovedAndOffsetPosition(int i11, int i12, boolean z11) {
            addFlags(8);
            offsetPosition(i12, z11);
            this.mPosition = i11;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i11 = this.mPreLayoutPosition;
            return i11 == -1 ? this.mPosition : i11;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i11 = this.mPreLayoutPosition;
            return i11 == -1 ? this.mPosition : i11;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i11) {
            return (i11 & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !h0.X(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i11, boolean z11) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z11) {
                this.mPreLayoutPosition += i11;
            }
            this.mPosition += i11;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i11 = this.mPendingAccessibilityState;
            if (i11 != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i11;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = h0.D(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            if (!RecyclerView.sDebugAssertionsEnabled || !isTmpDetached()) {
                this.mFlags = 0;
                this.mPosition = -1;
                this.mOldPosition = -1;
                this.mItemId = -1;
                this.mPreLayoutPosition = -1;
                this.mIsRecyclableCount = 0;
                this.mShadowedHolder = null;
                this.mShadowingHolder = null;
                clearPayload();
                this.mWasImportantForAccessibilityBeforeHidden = 0;
                this.mPendingAccessibilityState = -1;
                RecyclerView.clearNestedRecyclerViewIfNotNested(this);
                return;
            }
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i11, int i12) {
            this.mFlags = (i11 & i12) | (this.mFlags & (~i12));
        }

        public final void setIsRecyclable(boolean z11) {
            int i11 = this.mIsRecyclableCount;
            int i12 = z11 ? i11 - 1 : i11 + 1;
            this.mIsRecyclableCount = i12;
            if (i12 < 0) {
                this.mIsRecyclableCount = 0;
                if (!RecyclerView.sDebugAssertionsEnabled) {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                } else {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else if (!z11 && i12 == 1) {
                this.mFlags |= 16;
            } else if (z11 && i12 == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "setIsRecyclable val:" + z11 + ":" + this);
            }
        }

        public void setScrapContainer(Recycler recycler, boolean z11) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z11;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb2 = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb2.append(" scrap ");
                sb2.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb2.append(" invalid");
            }
            if (!isBound()) {
                sb2.append(" unbound");
            }
            if (needsUpdate()) {
                sb2.append(" update");
            }
            if (isRemoved()) {
                sb2.append(" removed");
            }
            if (shouldIgnore()) {
                sb2.append(" ignored");
            }
            if (isTmpDetached()) {
                sb2.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb2.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb2.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb2.append(" no parent");
            }
            sb2.append("}");
            return sb2.toString();
        }

        public void unScrap() {
            this.mScrapContainer.O(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.mIsAttached) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.mLayoutSuppressed) {
                    recyclerView2.mLayoutWasDefered = true;
                } else {
                    recyclerView2.consumePendingUpdateOperations();
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ItemAnimator itemAnimator = RecyclerView.this.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.runPendingAnimations();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    public class c implements Interpolator {
        public float getInterpolation(float f11) {
            float f12 = f11 - 1.0f;
            return (f12 * f12 * f12 * f12 * f12) + 1.0f;
        }
    }

    public class d implements w.b {
        public d() {
        }

        public void a(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            RecyclerView.this.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2);
        }

        public void b(ViewHolder viewHolder) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mLayout.removeAndRecycleView(viewHolder.itemView, recyclerView.mRecycler);
        }

        public void c(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            RecyclerView.this.mRecycler.O(viewHolder);
            RecyclerView.this.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2);
        }

        public void d(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
            viewHolder.setIsRecyclable(false);
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mDataSetHasChangedAfterLayout) {
                if (recyclerView.mItemAnimator.animateChange(viewHolder, viewHolder, itemHolderInfo, itemHolderInfo2)) {
                    RecyclerView.this.postAnimationRunner();
                }
            } else if (recyclerView.mItemAnimator.animatePersistence(viewHolder, itemHolderInfo, itemHolderInfo2)) {
                RecyclerView.this.postAnimationRunner();
            }
        }
    }

    public class e implements f.b {
        public e() {
        }

        public View a(int i11) {
            return RecyclerView.this.getChildAt(i11);
        }

        public void addView(View view, int i11) {
            RecyclerView.this.addView(view, i11);
            RecyclerView.this.dispatchChildAttached(view);
        }

        public void b(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
            }
        }

        public int c() {
            return RecyclerView.this.getChildCount();
        }

        public ViewHolder d(View view) {
            return RecyclerView.getChildViewHolderInt(view);
        }

        public void e(View view, int i11, ViewGroup.LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "reAttach " + childViewHolderInt);
                    }
                    childViewHolderInt.clearTmpDetachFlag();
                } else {
                    throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                }
            } else if (RecyclerView.sDebugAssertionsEnabled) {
                throw new IllegalArgumentException("No ViewHolder found for child: " + view + ", index: " + i11 + RecyclerView.this.exceptionLabel());
            }
            RecyclerView.this.attachViewToParent(view, i11, layoutParams);
        }

        public void f(int i11) {
            View a11 = a(i11);
            if (a11 != null) {
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(a11);
                if (childViewHolderInt != null) {
                    if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                        if (RecyclerView.sVerboseLoggingEnabled) {
                            Log.d(RecyclerView.TAG, "tmpDetach " + childViewHolderInt);
                        }
                        childViewHolderInt.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + RecyclerView.this.exceptionLabel());
                    }
                }
            } else if (RecyclerView.sDebugAssertionsEnabled) {
                throw new IllegalArgumentException("No view at offset " + i11 + RecyclerView.this.exceptionLabel());
            }
            RecyclerView.this.detachViewFromParent(i11);
        }

        public int g(View view) {
            return RecyclerView.this.indexOfChild(view);
        }

        public void h(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }

        public void removeAllViews() {
            int c11 = c();
            for (int i11 = 0; i11 < c11; i11++) {
                View a11 = a(i11);
                RecyclerView.this.dispatchChildDetached(a11);
                a11.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
        }

        public void removeViewAt(int i11) {
            View childAt = RecyclerView.this.getChildAt(i11);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i11);
        }
    }

    public class f implements a.C0054a {
        public f() {
        }

        public void a(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForMove(i11, i12);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        public void b(a.b bVar) {
            i(bVar);
        }

        public void c(a.b bVar) {
            i(bVar);
        }

        public ViewHolder d(int i11) {
            ViewHolder findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i11, true);
            if (findViewHolderForPosition == null) {
                return null;
            }
            if (!RecyclerView.this.mChildHelper.n(findViewHolderForPosition.itemView)) {
                return findViewHolderForPosition;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "assuming view holder cannot be find because it is hidden");
            }
            return null;
        }

        public void e(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForInsert(i11, i12);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        public void f(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForRemove(i11, i12, true);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.f10720d += i12;
        }

        public void g(int i11, int i12) {
            RecyclerView.this.offsetPositionRecordsForRemove(i11, i12, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        }

        public void h(int i11, int i12, Object obj) {
            RecyclerView.this.viewRangeUpdate(i11, i12, obj);
            RecyclerView.this.mItemsChanged = true;
        }

        public void i(a.b bVar) {
            int i11 = bVar.f10810a;
            if (i11 == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, bVar.f10811b, bVar.f10813d);
            } else if (i11 == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, bVar.f10811b, bVar.f10813d);
            } else if (i11 == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, bVar.f10811b, bVar.f10813d, bVar.f10812c);
            } else if (i11 == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, bVar.f10811b, bVar.f10813d, 1);
            }
        }
    }

    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f10739a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy[] r0 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f10739a = r0
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f10739a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g.<clinit>():void");
        }
    }

    public interface h {
        int a(int i11, int i12);
    }

    public class i implements ItemAnimator.b {
        public i() {
        }

        public void a(ViewHolder viewHolder) {
            viewHolder.setIsRecyclable(true);
            if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                viewHolder.mShadowedHolder = null;
            }
            viewHolder.mShadowingHolder = null;
            if (!viewHolder.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(viewHolder.itemView, false);
            }
        }
    }

    public interface j {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    public interface k {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z11);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface l {
        void a(ViewHolder viewHolder);
    }

    public class m extends AdapterDataObserver {
        public m() {
        }

        public void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    h0.p0(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f10723g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.p()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void onItemRangeChanged(int i11, int i12, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.r(i11, i12, obj)) {
                a();
            }
        }

        public void onItemRangeInserted(int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.s(i11, i12)) {
                a();
            }
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.t(i11, i12, i13)) {
                a();
            }
        }

        public void onItemRangeRemoved(int i11, int i12) {
            RecyclerView.this.assertNotInLayoutOrScroll((String) null);
            if (RecyclerView.this.mAdapterHelper.u(i11, i12)) {
                a();
            }
        }

        public void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (adapter = recyclerView.mAdapter) != null && adapter.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }
    }

    public static class n extends EdgeEffectFactory {
        public EdgeEffect a(RecyclerView recyclerView, int i11) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public class o implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f10742b;

        /* renamed from: c  reason: collision with root package name */
        public int f10743c;

        /* renamed from: d  reason: collision with root package name */
        public OverScroller f10744d;

        /* renamed from: e  reason: collision with root package name */
        public Interpolator f10745e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f10746f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f10747g = false;

        public o() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f10745e = interpolator;
            this.f10744d = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final int a(int i11, int i12) {
            int abs = Math.abs(i11);
            int abs2 = Math.abs(i12);
            boolean z11 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z11 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z11) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), 2000);
        }

        public void b(int i11, int i12) {
            RecyclerView.this.setScrollState(2);
            this.f10743c = 0;
            this.f10742b = 0;
            Interpolator interpolator = this.f10745e;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f10745e = interpolator2;
                this.f10744d = new OverScroller(RecyclerView.this.getContext(), interpolator2);
            }
            this.f10744d.fling(0, 0, i11, i12, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            d();
        }

        public final void c() {
            RecyclerView.this.removeCallbacks(this);
            h0.p0(RecyclerView.this, this);
        }

        public void d() {
            if (this.f10746f) {
                this.f10747g = true;
            } else {
                c();
            }
        }

        public void e(int i11, int i12, int i13, Interpolator interpolator) {
            if (i13 == Integer.MIN_VALUE) {
                i13 = a(i11, i12);
            }
            int i14 = i13;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f10745e != interpolator) {
                this.f10745e = interpolator;
                this.f10744d = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f10743c = 0;
            this.f10742b = 0;
            RecyclerView.this.setScrollState(2);
            this.f10744d.startScroll(0, 0, i11, i12, i14);
            if (Build.VERSION.SDK_INT < 23) {
                this.f10744d.computeScrollOffset();
            }
            d();
        }

        public void f() {
            RecyclerView.this.removeCallbacks(this);
            this.f10744d.abortAnimation();
        }

        public void run() {
            int i11;
            int i12;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                f();
                return;
            }
            this.f10747g = false;
            this.f10746f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f10744d;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i13 = currX - this.f10742b;
                int i14 = currY - this.f10743c;
                this.f10742b = currX;
                this.f10743c = currY;
                int consumeFlingInHorizontalStretch = RecyclerView.this.consumeFlingInHorizontalStretch(i13);
                int consumeFlingInVerticalStretch = RecyclerView.this.consumeFlingInVerticalStretch(i14);
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, (int[]) null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    consumeFlingInHorizontalStretch -= iArr2[0];
                    consumeFlingInVerticalStretch -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i11 = iArr4[0];
                    i12 = iArr4[1];
                    consumeFlingInHorizontalStretch -= i11;
                    consumeFlingInVerticalStretch -= i12;
                    SmoothScroller smoothScroller = recyclerView4.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.isPendingInitialRun() && smoothScroller.isRunning()) {
                        int b11 = RecyclerView.this.mState.b();
                        if (b11 == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.getTargetPosition() >= b11) {
                            smoothScroller.setTargetPosition(b11 - 1);
                            smoothScroller.onAnimation(i11, i12);
                        } else {
                            smoothScroller.onAnimation(i11, i12);
                        }
                    }
                } else {
                    i12 = 0;
                    i11 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i11, i12, consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, (int[]) null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i15 = consumeFlingInHorizontalStretch - iArr6[0];
                int i16 = consumeFlingInVerticalStretch - iArr6[1];
                if (!(i11 == 0 && i12 == 0)) {
                    recyclerView6.dispatchOnScrolled(i11, i12);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z11 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i15 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i16 != 0));
                SmoothScroller smoothScroller2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((smoothScroller2 != null && smoothScroller2.isPendingInitialRun()) || !z11) {
                    d();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    j jVar = recyclerView7.mGapWorker;
                    if (jVar != null) {
                        jVar.f(recyclerView7, i11, i12);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i17 = i15 < 0 ? -currVelocity : i15 > 0 ? currVelocity : 0;
                        if (i16 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i16 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i17, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.b();
                    }
                }
            }
            SmoothScroller smoothScroller3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.isPendingInitialRun()) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.f10746f = false;
            if (this.f10747g) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            ajc$preClinit()
            r0 = 0
            sDebugAssertionsEnabled = r0
            sVerboseLoggingEnabled = r0
            r1 = 1
            int[] r2 = new int[r1]
            r3 = 16843830(0x1010436, float:2.369658E-38)
            r2[r0] = r3
            NESTED_SCROLLING_ATTRS = r2
            r2 = 4605200834963974390(0x3fe8f5c28f5c28f6, double:0.78)
            double r2 = java.lang.Math.log(r2)
            r4 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r4 = java.lang.Math.log(r4)
            double r2 = r2 / r4
            float r2 = (float) r2
            DECELERATION_RATE = r2
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 18
            if (r2 == r3) goto L_0x0039
            r3 = 19
            if (r2 == r3) goto L_0x0039
            r3 = 20
            if (r2 != r3) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r3 = r0
            goto L_0x003a
        L_0x0039:
            r3 = r1
        L_0x003a:
            FORCE_INVALIDATE_DISPLAY_LIST = r3
            r3 = 23
            if (r2 < r3) goto L_0x0042
            r3 = r1
            goto L_0x0043
        L_0x0042:
            r3 = r0
        L_0x0043:
            ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r3
            r3 = 16
            if (r2 < r3) goto L_0x004b
            r3 = r1
            goto L_0x004c
        L_0x004b:
            r3 = r0
        L_0x004c:
            POST_UPDATES_ON_ANIMATION = r3
            r3 = 21
            if (r2 < r3) goto L_0x0054
            r3 = r1
            goto L_0x0055
        L_0x0054:
            r3 = r0
        L_0x0055:
            ALLOW_THREAD_GAP_WORK = r3
            r3 = 15
            if (r2 > r3) goto L_0x005d
            r4 = r1
            goto L_0x005e
        L_0x005d:
            r4 = r0
        L_0x005e:
            FORCE_ABS_FOCUS_SEARCH_DIRECTION = r4
            if (r2 > r3) goto L_0x0064
            r2 = r1
            goto L_0x0065
        L_0x0064:
            r2 = r0
        L_0x0065:
            IGNORE_DETACHED_FOCUSED_CHILD = r2
            r2 = 4
            java.lang.Class[] r2 = new java.lang.Class[r2]
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r0] = r3
            java.lang.Class<android.util.AttributeSet> r0 = android.util.AttributeSet.class
            r2[r1] = r0
            r0 = 2
            java.lang.Class r1 = java.lang.Integer.TYPE
            r2[r0] = r1
            r0 = 3
            r2[r0] = r1
            LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = r2
            androidx.recyclerview.widget.RecyclerView$c r0 = new androidx.recyclerview.widget.RecyclerView$c
            r0.<init>()
            sQuinticInterpolator = r0
            androidx.recyclerview.widget.RecyclerView$n r0 = new androidx.recyclerview.widget.RecyclerView$n
            r0.<init>()
            sDefaultEdgeEffectFactory = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.<clinit>():void");
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void addAnimatingView(ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        boolean z11 = view.getParent() == this;
        this.mRecycler.O(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.c(view, -1, view.getLayoutParams(), true);
        } else if (!z11) {
            this.mChildHelper.b(view, true);
        } else {
            this.mChildHelper.k(view);
        }
    }

    private static /* synthetic */ void ajc$preClinit() {
        org.aspectj.runtime.reflect.c cVar = new org.aspectj.runtime.reflect.c("RecyclerView.java", RecyclerView.class);
        ajc$tjp_0 = cVar.h("method-execution", cVar.g("0", "dispatchOnScrollStateChanged", "androidx.recyclerview.widget.RecyclerView", "int", "state", "", "void"), 5725);
    }

    private void animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2, boolean z11, boolean z12) {
        viewHolder.setIsRecyclable(false);
        if (z11) {
            addAnimatingView(viewHolder);
        }
        if (viewHolder != viewHolder2) {
            if (z12) {
                addAnimatingView(viewHolder2);
            }
            viewHolder.mShadowedHolder = viewHolder2;
            addAnimatingView(viewHolder);
            this.mRecycler.O(viewHolder);
            viewHolder2.setIsRecyclable(false);
            viewHolder2.mShadowingHolder = viewHolder;
        }
        if (this.mItemAnimator.animateChange(viewHolder, viewHolder2, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view != viewHolder.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    private int consumeFlingInStretch(int i11, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i12) {
        if (i11 > 0 && edgeEffect != null && androidx.core.widget.g.d(edgeEffect) != 0.0f) {
            int round = Math.round((((float) (-i12)) / FLING_DESTRETCH_FACTOR) * androidx.core.widget.g.h(edgeEffect, (((float) (-i11)) * FLING_DESTRETCH_FACTOR) / ((float) i12), 0.5f));
            if (round != i11) {
                edgeEffect.finish();
            }
            return i11 - round;
        } else if (i11 >= 0 || edgeEffect2 == null || androidx.core.widget.g.d(edgeEffect2) == 0.0f) {
            return i11;
        } else {
            float f11 = (float) i12;
            int round2 = Math.round((f11 / FLING_DESTRETCH_FACTOR) * androidx.core.widget.g.h(edgeEffect2, (((float) i11) * FLING_DESTRETCH_FACTOR) / f11, 0.5f));
            if (round2 != i11) {
                edgeEffect2.finish();
            }
            return i11 - round2;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i11, int i12) {
        ClassLoader classLoader;
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(LayoutManager.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i11), Integer.valueOf(i12)};
                    } catch (NoSuchMethodException e11) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e12) {
                    e12.initCause(e11);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e12);
                } catch (ClassNotFoundException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e13);
                } catch (InvocationTargetException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e14);
                } catch (InstantiationException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e15);
                } catch (IllegalAccessException e16) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e16);
                } catch (ClassCastException e17) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e17);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i11, int i12) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i11 && iArr[1] == i12) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i11 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i11 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            b1.b.b(obtain, i11);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        boolean z11 = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f10726j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State state = this.mState;
        if (!state.f10727k || !this.mItemsChanged) {
            z11 = false;
        }
        state.f10725i = z11;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state.f10724h = state.f10728l;
        state.f10722f = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f10727k) {
            int g11 = this.mChildHelper.g();
            for (int i11 = 0; i11 < g11; i11++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.e(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.f10725i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.c(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f10728l) {
            saveOldPositions();
            State state2 = this.mState;
            boolean z12 = state2.f10723g;
            state2.f10723g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state2);
            this.mState.f10723g = z12;
            for (int i12 = 0; i12 < this.mChildHelper.g(); i12++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.f(i12));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.i(childViewHolderInt2)) {
                    int buildAdapterChangeFlagsForAnimations = ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        buildAdapterChangeFlagsForAnimations |= 4096;
                    }
                    ItemAnimator.ItemHolderInfo recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, recordPreLayoutInformation);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f10721e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.j();
        this.mState.f10722f = this.mAdapter.getItemCount();
        this.mState.f10720d = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.f10724h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.f10723g = false;
        state2.f10727k = state2.f10727k && this.mItemAnimator != null;
        state2.f10721e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State state = this.mState;
        state.f10721e = 1;
        if (state.f10727k) {
            for (int g11 = this.mChildHelper.g() - 1; g11 >= 0; g11--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(g11));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    ItemAnimator.ItemHolderInfo recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    ViewHolder g12 = this.mViewInfoStore.g(changedHolderKey);
                    if (g12 == null || g12.shouldIgnore()) {
                        this.mViewInfoStore.d(childViewHolderInt, recordPostLayoutInformation);
                    } else {
                        boolean h11 = this.mViewInfoStore.h(g12);
                        boolean h12 = this.mViewInfoStore.h(childViewHolderInt);
                        if (!h11 || g12 != childViewHolderInt) {
                            ItemAnimator.ItemHolderInfo n11 = this.mViewInfoStore.n(g12);
                            this.mViewInfoStore.d(childViewHolderInt, recordPostLayoutInformation);
                            ItemAnimator.ItemHolderInfo m11 = this.mViewInfoStore.m(childViewHolderInt);
                            if (n11 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, g12);
                            } else {
                                animateChange(g12, childViewHolderInt, n11, m11, h11, h12);
                            }
                        } else {
                            this.mViewInfoStore.d(childViewHolderInt, recordPostLayoutInformation);
                        }
                    }
                }
            }
            this.mViewInfoStore.o(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State state2 = this.mState;
        state2.f10719c = state2.f10722f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        state2.f10727k = false;
        state2.f10728l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> arrayList = this.mRecycler.f10702b;
        if (arrayList != null) {
            arrayList.clear();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager.mPrefetchMaxObservedInInitialPrefetch) {
            layoutManager.mPrefetchMaxCountObserved = 0;
            layoutManager.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.P();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        k kVar = this.mInterceptingOnItemTouchListener;
        if (kVar != null) {
            kVar.onTouchEvent(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        int i11 = 0;
        while (i11 < size) {
            k kVar = this.mOnItemTouchListeners.get(i11);
            if (!kVar.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i11++;
            } else {
                this.mInterceptingOnItemTouchListener = kVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int g11 = this.mChildHelper.g();
        if (g11 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i11 = Integer.MAX_VALUE;
        int i12 = Integer.MIN_VALUE;
        for (int i13 = 0; i13 < g11; i13++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i13));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i11) {
                    i11 = layoutPosition;
                }
                if (layoutPosition > i12) {
                    i12 = layoutPosition;
                }
            }
        }
        iArr[0] = i11;
        iArr[1] = i12;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i11));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        ViewHolder findViewHolderForAdapterPosition;
        State state = this.mState;
        int i11 = state.f10729m;
        if (i11 == -1) {
            i11 = 0;
        }
        int b11 = state.b();
        int i12 = i11;
        while (i12 < b11) {
            ViewHolder findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i12);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            } else {
                i12++;
            }
        }
        int min = Math.min(b11, i11);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id2 = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id2 = view.getId();
            }
        }
        return id2;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(InstructionFileId.DOT)) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private q getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new q(this);
        }
        return this.mScrollingChildHelper;
    }

    private float getSplineFlingDistance(int i11) {
        double log = Math.log((double) ((((float) Math.abs(i11)) * 0.35f) / (this.mPhysicalCoef * SCROLL_FRICTION)));
        float f11 = DECELERATION_RATE;
        return (float) (((double) (this.mPhysicalCoef * SCROLL_FRICTION)) * Math.exp((((double) f11) / (((double) f11) - 1.0d)) * log));
    }

    private void handleMissingPreInfoForChangeError(long j11, ViewHolder viewHolder, ViewHolder viewHolder2) {
        int g11 = this.mChildHelper.g();
        for (int i11 = 0; i11 < g11; i11++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
            if (childViewHolderInt != viewHolder && getChangedHolderKey(childViewHolderInt) == j11) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + viewHolder + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + viewHolder2 + " cannot be found but it is necessary for " + viewHolder + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int g11 = this.mChildHelper.g();
        for (int i11 = 0; i11 < g11; i11++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.f(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (h0.E(this) == 0) {
            h0.K0(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new f(new e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i11) {
        int i12;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c11 = 65535;
        int i13 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i14 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i15 = rect2.left;
        if ((i14 < i15 || rect.right <= i15) && rect.right < rect2.right) {
            i12 = 1;
        } else {
            int i16 = rect.right;
            int i17 = rect2.right;
            i12 = ((i16 > i17 || i14 >= i17) && i14 > i15) ? -1 : 0;
        }
        int i18 = rect.top;
        int i19 = rect2.top;
        if ((i18 < i19 || rect.bottom <= i19) && rect.bottom < rect2.bottom) {
            c11 = 1;
        } else {
            int i21 = rect.bottom;
            int i22 = rect2.bottom;
            if ((i21 <= i22 && i18 < i22) || i18 <= i19) {
                c11 = 0;
            }
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 17) {
                    if (i11 != 33) {
                        if (i11 != 66) {
                            if (i11 != 130) {
                                throw new IllegalArgumentException("Invalid direction: " + i11 + exceptionLabel());
                            } else if (c11 > 0) {
                                return true;
                            } else {
                                return false;
                            }
                        } else if (i12 > 0) {
                            return true;
                        } else {
                            return false;
                        }
                    } else if (c11 < 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (i12 < 0) {
                    return true;
                } else {
                    return false;
                }
            } else if (c11 > 0 || (c11 == 0 && i12 * i13 > 0)) {
                return true;
            } else {
                return false;
            }
        } else if (c11 < 0 || (c11 == 0 && i12 * i13 < 0)) {
            return true;
        } else {
            return false;
        }
    }

    private void nestedScrollByInternal(int i11, int i12, MotionEvent motionEvent, int i13) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int[] iArr = this.mReusableIntPair;
            int i14 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            boolean z11 = canScrollVertically ? canScrollHorizontally | true : canScrollHorizontally;
            float height = motionEvent == null ? ((float) getHeight()) / 2.0f : motionEvent.getY();
            float width = motionEvent == null ? ((float) getWidth()) / 2.0f : motionEvent.getX();
            int releaseHorizontalGlow = i11 - releaseHorizontalGlow(i11, height);
            int releaseVerticalGlow = i12 - releaseVerticalGlow(i12, width);
            startNestedScroll(z11 ? 1 : 0, i13);
            if (dispatchNestedPreScroll(canScrollHorizontally ? releaseHorizontalGlow : 0, canScrollVertically ? releaseVerticalGlow : 0, this.mReusableIntPair, this.mScrollOffset, i13)) {
                int[] iArr2 = this.mReusableIntPair;
                releaseHorizontalGlow -= iArr2[0];
                releaseVerticalGlow -= iArr2[1];
            }
            int i15 = canScrollHorizontally ? releaseHorizontalGlow : 0;
            if (canScrollVertically) {
                i14 = releaseVerticalGlow;
            }
            scrollByInternal(i15, i14, motionEvent, i13);
            j jVar = this.mGapWorker;
            if (!(jVar == null || (releaseHorizontalGlow == 0 && releaseVerticalGlow == 0))) {
                jVar.f(this, releaseHorizontalGlow, releaseVerticalGlow);
            }
            stopNestedScroll(i13);
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i11 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i11);
            int x11 = (int) (motionEvent.getX(i11) + 0.5f);
            this.mLastTouchX = x11;
            this.mInitialTouchX = x11;
            int y11 = (int) (motionEvent.getY(i11) + 0.5f);
            this.mLastTouchY = y11;
            this.mInitialTouchY = y11;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z11;
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.y();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.w();
        } else {
            this.mAdapterHelper.j();
        }
        boolean z12 = false;
        boolean z13 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f10727k = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z11 = this.mDataSetHasChangedAfterLayout) || z13 || this.mLayout.mRequestedSimpleAnimations) && (!z11 || this.mAdapter.hasStableIds());
        State state = this.mState;
        if (state.f10727k && z13 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z12 = true;
        }
        state.f10728l = z12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 >= 0) goto L_0x0021
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r1 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r2 - r9
            androidx.core.widget.g.h(r1, r4, r9)
        L_0x001f:
            r9 = r3
            goto L_0x003c
        L_0x0021:
            int r1 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x003b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r1 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.g.h(r1, r4, r9)
            goto L_0x001f
        L_0x003b:
            r9 = 0
        L_0x003c:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0056
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r1 = -r10
            int r2 = r6.getHeight()
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r6.getWidth()
            float r2 = (float) r2
            float r7 = r7 / r2
            androidx.core.widget.g.h(r9, r1, r7)
            goto L_0x0072
        L_0x0056:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0071
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r1 = r6.getHeight()
            float r1 = (float) r1
            float r1 = r10 / r1
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r2 = r2 - r7
            androidx.core.widget.g.h(r9, r1, r2)
            goto L_0x0072
        L_0x0071:
            r3 = r9
        L_0x0072:
            if (r3 != 0) goto L_0x007c
            int r7 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r7 != 0) goto L_0x007c
            int r7 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r7 == 0) goto L_0x007f
        L_0x007c:
            androidx.core.view.h0.n0(r6)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.n(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.g() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                ViewHolder findViewHolderForItemId = (this.mState.f10730n == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f10730n);
                if (findViewHolderForItemId != null && !this.mChildHelper.n(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.g() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i11 = this.mState.f10731o;
                    if (!(((long) i11) == -1 || (findViewById = view.findViewById(i11)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z11;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z11 = this.mLeftGlow.isFinished();
        } else {
            z11 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z11 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z11 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z11 |= this.mBottomGlow.isFinished();
        }
        if (z11) {
            h0.n0(this);
        }
    }

    private int releaseHorizontalGlow(int i11, float f11) {
        float height = f11 / ((float) getHeight());
        float width = ((float) i11) / ((float) getWidth());
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f12 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.g.d(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (!(edgeEffect2 == null || androidx.core.widget.g.d(edgeEffect2) == 0.0f)) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float h11 = androidx.core.widget.g.h(this.mRightGlow, width, height);
                    if (androidx.core.widget.g.d(this.mRightGlow) == 0.0f) {
                        this.mRightGlow.onRelease();
                    }
                    f12 = h11;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f13 = -androidx.core.widget.g.h(this.mLeftGlow, -width, 1.0f - height);
                if (androidx.core.widget.g.d(this.mLeftGlow) == 0.0f) {
                    this.mLeftGlow.onRelease();
                }
                f12 = f13;
            }
            invalidate();
        }
        return Math.round(f12 * ((float) getWidth()));
    }

    private int releaseVerticalGlow(int i11, float f11) {
        float width = f11 / ((float) getWidth());
        float height = ((float) i11) / ((float) getHeight());
        EdgeEffect edgeEffect = this.mTopGlow;
        float f12 = 0.0f;
        if (edgeEffect == null || androidx.core.widget.g.d(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (!(edgeEffect2 == null || androidx.core.widget.g.d(edgeEffect2) == 0.0f)) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float h11 = androidx.core.widget.g.h(this.mBottomGlow, height, 1.0f - width);
                    if (androidx.core.widget.g.d(this.mBottomGlow) == 0.0f) {
                        this.mBottomGlow.onRelease();
                    }
                    f12 = h11;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f13 = -androidx.core.widget.g.h(this.mTopGlow, -height, width);
                if (androidx.core.widget.g.d(this.mTopGlow) == 0.0f) {
                    this.mTopGlow.onRelease();
                }
                f12 = f13;
            }
            invalidate();
        }
        return Math.round(f12 * ((float) getHeight()));
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        State state = this.mState;
        state.f10730n = -1;
        state.f10729m = -1;
        state.f10731o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int i11;
        ViewHolder viewHolder = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            viewHolder = findContainingViewHolder(focusedChild);
        }
        if (viewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f10730n = this.mAdapter.hasStableIds() ? viewHolder.getItemId() : -1;
        State state = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i11 = -1;
        } else if (viewHolder.isRemoved()) {
            i11 = viewHolder.mOldPosition;
        } else {
            i11 = viewHolder.getAbsoluteAdapterPosition();
        }
        state.f10729m = i11;
        this.mState.f10731o = getDeepestFocusedViewWithId(viewHolder.itemView);
    }

    private void setAdapterInternal(Adapter<?> adapter, boolean z11, boolean z12) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z11 || z12) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.y();
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        this.mRecycler.y(adapter3, this.mAdapter, z11);
        this.mState.f10723g = true;
    }

    public static void setDebugAssertionsEnabled(boolean z11) {
        sDebugAssertionsEnabled = z11;
    }

    public static void setVerboseLoggingEnabled(boolean z11) {
        sVerboseLoggingEnabled = z11;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int i11, int i12) {
        if (i11 > 0) {
            return true;
        }
        if (getSplineFlingDistance(-i11) < androidx.core.widget.g.d(edgeEffect) * ((float) i12)) {
            return true;
        }
        return false;
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z11;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || androidx.core.widget.g.d(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
            z11 = false;
        } else {
            androidx.core.widget.g.h(this.mLeftGlow, 0.0f, 1.0f - (motionEvent.getY() / ((float) getHeight())));
            z11 = true;
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (!(edgeEffect2 == null || androidx.core.widget.g.d(edgeEffect2) == 0.0f || canScrollHorizontally(1))) {
            androidx.core.widget.g.h(this.mRightGlow, 0.0f, motionEvent.getY() / ((float) getHeight()));
            z11 = true;
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (!(edgeEffect3 == null || androidx.core.widget.g.d(edgeEffect3) == 0.0f || canScrollVertically(-1))) {
            androidx.core.widget.g.h(this.mTopGlow, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z11 = true;
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 == null || androidx.core.widget.g.d(edgeEffect4) == 0.0f || canScrollVertically(1)) {
            return z11;
        }
        androidx.core.widget.g.h(this.mBottomGlow, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.f();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    public void absorbGlows(int i11, int i12) {
        if (i11 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i11);
            }
        } else if (i11 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i11);
            }
        }
        if (i12 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i12);
            }
        } else if (i12 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i12);
            }
        }
        if (i11 != 0 || i12 != 0) {
            h0.n0(this);
        }
    }

    public void addFocusables(ArrayList<View> arrayList, int i11, int i12) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i11, i12)) {
            super.addFocusables(arrayList, i11, i12);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i11) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i11 < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i11, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(j jVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(jVar);
    }

    public void addOnItemTouchListener(k kVar) {
        this.mOnItemTouchListeners.add(kVar);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(l lVar) {
        androidx.core.util.h.b(lVar != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(lVar);
    }

    public void animateAppearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(viewHolder, itemHolderInfo, itemHolderInfo2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator == null || itemAnimator.canReuseUpdatedViewHolder(viewHolder, viewHolder.getUnmodifiedPayloads());
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i11, int i12) {
        boolean z11;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i11 <= 0) {
            z11 = false;
        } else {
            this.mLeftGlow.onRelease();
            z11 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i11 < 0) {
            this.mRightGlow.onRelease();
            z11 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i12 > 0) {
            this.mTopGlow.onRelease();
            z11 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i12 < 0) {
            this.mBottomGlow.onRelease();
            z11 |= this.mBottomGlow.isFinished();
        }
        if (z11) {
            h0.n0(this);
        }
    }

    public int consumeFlingInHorizontalStretch(int i11) {
        return consumeFlingInStretch(i11, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    /* access modifiers changed from: package-private */
    public int consumeFlingInVerticalStretch(int i11) {
        return consumeFlingInStretch(i11, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.n.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.os.n.b();
        } else if (this.mAdapterHelper.p()) {
            if (this.mAdapterHelper.o(4) && !this.mAdapterHelper.o(11)) {
                androidx.core.os.n.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.w();
                if (!this.mLayoutWasDefered) {
                    if (hasUpdatedView()) {
                        dispatchLayout();
                    } else {
                        this.mAdapterHelper.i();
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                androidx.core.os.n.b();
            } else if (this.mAdapterHelper.p()) {
                androidx.core.os.n.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                androidx.core.os.n.b();
            }
        }
    }

    public void defaultOnMeasure(int i11, int i12) {
        setMeasuredDimension(LayoutManager.chooseSize(i11, getPaddingLeft() + getPaddingRight(), h0.H(this)), LayoutManager.chooseSize(i12, getPaddingTop() + getPaddingBottom(), h0.G(this)));
    }

    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewAttachedToWindow(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).onChildViewDetachedFromWindow(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            this.mState.f10726j = false;
            boolean z11 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
            this.mLastAutoMeasureNonExactMeasuredWidth = 0;
            this.mLastAutoMeasureNonExactMeasuredHeight = 0;
            this.mLastAutoMeasureSkippedDueToExact = false;
            if (this.mState.f10721e == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else if (this.mAdapterHelper.q() || z11 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                this.mLayout.setExactMeasureSpecsFrom(this);
            }
            dispatchLayoutStep3();
        }
    }

    public boolean dispatchNestedFling(float f11, float f12, boolean z11) {
        return getScrollingChildHelper().a(f11, f12, z11);
    }

    public boolean dispatchNestedPreFling(float f11, float f12) {
        return getScrollingChildHelper().b(f11, f12);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i11, i12, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr) {
        return getScrollingChildHelper().f(i11, i12, i13, i14, iArr);
    }

    public void dispatchOnScrollStateChanged(int i11) {
        WoodPeckerScrollAspect.b().c(org.aspectj.runtime.reflect.c.c(ajc$tjp_0, this, this, x10.a.a(i11)));
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i11);
        }
        onScrollStateChanged(i11);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i11);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i11);
            }
        }
    }

    public void dispatchOnScrolled(int i11, int i12) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i11, scrollY - i12);
        onScrolled(i11, i12);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i11, i12);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i11, i12);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i11;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i11 = viewHolder.mPendingAccessibilityState) != -1) {
                h0.I0(viewHolder.itemView, i11);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z11;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z12 = false;
        for (int i11 = 0; i11 < size; i11++) {
            this.mItemDecorations.get(i11).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z13 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z11 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z11 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z11 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z11 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z12 = true;
            }
            z11 |= z12;
            canvas.restoreToCount(save4);
        }
        if (z11 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z13 = z11;
        }
        if (z13) {
            h0.n0(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j11) {
        return super.drawChild(canvas, view, j11);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 3);
            this.mBottomGlow = a11;
            if (this.mClipToPadding) {
                a11.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a11.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 0);
            this.mLeftGlow = a11;
            if (this.mClipToPadding) {
                a11.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a11.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 2);
            this.mRightGlow = a11;
            if (this.mClipToPadding) {
                a11.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a11.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect a11 = this.mEdgeEffectFactory.a(this, 1);
            this.mTopGlow = a11;
            if (this.mClipToPadding) {
                a11.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a11.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f10744d;
            state.f10732p = overScroller.getFinalX() - overScroller.getCurrX();
            state.f10733q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        state.f10732p = 0;
        state.f10733q = 0;
    }

    public View findChildViewUnder(float f11, float f12) {
        for (int g11 = this.mChildHelper.g() - 1; g11 >= 0; g11--) {
            View f13 = this.mChildHelper.f(g11);
            float translationX = f13.getTranslationX();
            float translationY = f13.getTranslationY();
            if (f11 >= ((float) f13.getLeft()) + translationX && f11 <= ((float) f13.getRight()) + translationX && f12 >= ((float) f13.getTop()) + translationY && f12 <= ((float) f13.getBottom()) + translationY) {
                return f13;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public ViewHolder findViewHolderForAdapterPosition(int i11) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int j11 = this.mChildHelper.j();
        for (int i12 = 0; i12 < j11; i12++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i12));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i11) {
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j11) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int j12 = this.mChildHelper.j();
            for (int i11 = 0; i11 < j12; i11++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j11) {
                    if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i11) {
        return findViewHolderForPosition(i11, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i11) {
        return findViewHolderForPosition(i11, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean fling(int r8, int r9) {
        /*
            r7 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r7.mLayout
            r1 = 0
            if (r0 != 0) goto L_0x000d
            java.lang.String r8 = "RecyclerView"
            java.lang.String r9 = "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument."
            android.util.Log.e(r8, r9)
            return r1
        L_0x000d:
            boolean r2 = r7.mLayoutSuppressed
            if (r2 == 0) goto L_0x0012
            return r1
        L_0x0012:
            boolean r0 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = r7.mLayout
            boolean r2 = r2.canScrollVertically()
            if (r0 == 0) goto L_0x0026
            int r3 = java.lang.Math.abs(r8)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0027
        L_0x0026:
            r8 = r1
        L_0x0027:
            if (r2 == 0) goto L_0x0031
            int r3 = java.lang.Math.abs(r9)
            int r4 = r7.mMinFlingVelocity
            if (r3 >= r4) goto L_0x0032
        L_0x0031:
            r9 = r1
        L_0x0032:
            if (r8 != 0) goto L_0x0037
            if (r9 != 0) goto L_0x0037
            return r1
        L_0x0037:
            r3 = 0
            if (r8 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            if (r4 == 0) goto L_0x005c
            float r4 = androidx.core.widget.g.d(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x005c
            android.widget.EdgeEffect r4 = r7.mLeftGlow
            int r5 = -r8
            int r6 = r7.getWidth()
            boolean r4 = r7.shouldAbsorb(r4, r5, r6)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r8 = r7.mLeftGlow
            r8.onAbsorb(r5)
        L_0x0058:
            r8 = r1
        L_0x0059:
            r4 = r8
            r8 = r1
            goto L_0x007b
        L_0x005c:
            android.widget.EdgeEffect r4 = r7.mRightGlow
            if (r4 == 0) goto L_0x007a
            float r4 = androidx.core.widget.g.d(r4)
            int r4 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x007a
            android.widget.EdgeEffect r4 = r7.mRightGlow
            int r5 = r7.getWidth()
            boolean r4 = r7.shouldAbsorb(r4, r8, r5)
            if (r4 == 0) goto L_0x0059
            android.widget.EdgeEffect r4 = r7.mRightGlow
            r4.onAbsorb(r8)
            goto L_0x0058
        L_0x007a:
            r4 = r1
        L_0x007b:
            if (r9 == 0) goto L_0x00bc
            android.widget.EdgeEffect r5 = r7.mTopGlow
            if (r5 == 0) goto L_0x009e
            float r5 = androidx.core.widget.g.d(r5)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x009e
            android.widget.EdgeEffect r3 = r7.mTopGlow
            int r5 = -r9
            int r6 = r7.getHeight()
            boolean r3 = r7.shouldAbsorb(r3, r5, r6)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r9 = r7.mTopGlow
            r9.onAbsorb(r5)
        L_0x009b:
            r9 = r1
        L_0x009c:
            r3 = r1
            goto L_0x00be
        L_0x009e:
            android.widget.EdgeEffect r5 = r7.mBottomGlow
            if (r5 == 0) goto L_0x00bc
            float r5 = androidx.core.widget.g.d(r5)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            int r5 = r7.getHeight()
            boolean r3 = r7.shouldAbsorb(r3, r9, r5)
            if (r3 == 0) goto L_0x009c
            android.widget.EdgeEffect r3 = r7.mBottomGlow
            r3.onAbsorb(r9)
            goto L_0x009b
        L_0x00bc:
            r3 = r9
            r9 = r1
        L_0x00be:
            if (r4 != 0) goto L_0x00c2
            if (r9 == 0) goto L_0x00dd
        L_0x00c2:
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r4 = java.lang.Math.min(r4, r5)
            int r4 = java.lang.Math.max(r6, r4)
            int r5 = r7.mMaxFlingVelocity
            int r6 = -r5
            int r9 = java.lang.Math.min(r9, r5)
            int r9 = java.lang.Math.max(r6, r9)
            androidx.recyclerview.widget.RecyclerView$o r5 = r7.mViewFlinger
            r5.b(r4, r9)
        L_0x00dd:
            r5 = 1
            if (r8 != 0) goto L_0x00e8
            if (r3 != 0) goto L_0x00e8
            if (r4 != 0) goto L_0x00e6
            if (r9 == 0) goto L_0x00e7
        L_0x00e6:
            r1 = r5
        L_0x00e7:
            return r1
        L_0x00e8:
            float r9 = (float) r8
            float r4 = (float) r3
            boolean r6 = r7.dispatchNestedPreFling(r9, r4)
            if (r6 != 0) goto L_0x012b
            if (r0 != 0) goto L_0x00f7
            if (r2 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r6 = r1
            goto L_0x00f8
        L_0x00f7:
            r6 = r5
        L_0x00f8:
            r7.dispatchNestedFling(r9, r4, r6)
            androidx.recyclerview.widget.RecyclerView$OnFlingListener r9 = r7.mOnFlingListener
            if (r9 == 0) goto L_0x0106
            boolean r9 = r9.onFling(r8, r3)
            if (r9 == 0) goto L_0x0106
            return r5
        L_0x0106:
            if (r6 == 0) goto L_0x012b
            if (r2 == 0) goto L_0x010c
            r0 = r0 | 2
        L_0x010c:
            r7.startNestedScroll(r0, r5)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r8 = java.lang.Math.min(r8, r9)
            int r8 = java.lang.Math.max(r0, r8)
            int r9 = r7.mMaxFlingVelocity
            int r0 = -r9
            int r9 = java.lang.Math.min(r3, r9)
            int r9 = java.lang.Math.max(r0, r9)
            androidx.recyclerview.widget.RecyclerView$o r0 = r7.mViewFlinger
            r0.b(r8, r9)
            return r5
        L_0x012b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    public View focusSearch(View view, int i11) {
        View view2;
        boolean z11;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i11);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z12 = true;
        boolean z13 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z13 || !(i11 == 2 || i11 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i11);
            if (findNextFocus != null || !z13) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i11, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                int i12 = i11 == 2 ? 130 : 33;
                z11 = instance.findNextFocus(this, view, i12) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i11 = i12;
                }
            } else {
                z11 = false;
            }
            if (!z11 && this.mLayout.canScrollHorizontally()) {
                int i13 = (this.mLayout.getLayoutDirection() == 1) ^ (i11 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i13) != null) {
                    z12 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i11 = i13;
                }
                z11 = z12;
            }
            if (z11) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i11, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i11);
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i11) ? view2 : super.focusSearch(view, i11);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i11);
        }
        requestChildOnScreen(view2, (View) null);
        return view;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.e(viewHolder.mPosition);
    }

    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        return this.mAdapter.hasStableIds() ? viewHolder.getItemId() : (long) viewHolder.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public int getChildDrawingOrder(int i11, int i12) {
        h hVar = this.mChildDrawingOrderCallback;
        if (hVar == null) {
            return super.getChildDrawingOrder(i11, i12);
        }
        return hVar.a(i11, i12);
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public s getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mInsetsDirty) {
            return layoutParams.mDecorInsets;
        }
        if (this.mState.e() && (layoutParams.isItemChanged() || layoutParams.isViewInvalid())) {
            return layoutParams.mDecorInsets;
        }
        Rect rect = layoutParams.mDecorInsets;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i11).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i12 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i12 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    public ItemDecoration getItemDecorationAt(int i11) {
        int itemDecorationCount = getItemDecorationCount();
        if (i11 >= 0 && i11 < itemDecorationCount) {
            return this.mItemDecorations.get(i11);
        }
        throw new IndexOutOfBoundsException(i11 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.p();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new a(new f());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
        Resources resources = getContext().getResources();
        new i(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R$dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        return itemAnimator != null && itemAnimator.isRunning();
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public void jumpToPositionForSmoothScroller(int i11) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i11);
            awakenScrollBars();
        }
    }

    public void markItemDecorInsetsDirty() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            ((LayoutParams) this.mChildHelper.i(i11).getLayoutParams()).mInsetsDirty = true;
        }
        this.mRecycler.s();
    }

    public void markKnownViewsInvalid() {
        int j11 = this.mChildHelper.j();
        for (int i11 = 0; i11 < j11; i11++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public void nestedScrollBy(int i11, int i12) {
        nestedScrollByInternal(i11, i12, (MotionEvent) null, 1);
    }

    public void offsetChildrenHorizontal(int i11) {
        int g11 = this.mChildHelper.g();
        for (int i12 = 0; i12 < g11; i12++) {
            this.mChildHelper.f(i12).offsetLeftAndRight(i11);
        }
    }

    public void offsetChildrenVertical(int i11) {
        int g11 = this.mChildHelper.g();
        for (int i12 = 0; i12 < g11; i12++) {
            this.mChildHelper.f(i12).offsetTopAndBottom(i11);
        }
    }

    public void offsetPositionRecordsForInsert(int i11, int i12) {
        int j11 = this.mChildHelper.j();
        for (int i13 = 0; i13 < j11; i13++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i13));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i11) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert attached child " + i13 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition + i12));
                }
                childViewHolderInt.offsetPosition(i12, false);
                this.mState.f10723g = true;
            }
        }
        this.mRecycler.v(i11, i12);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        int j11 = this.mChildHelper.j();
        if (i11 < i12) {
            i15 = -1;
            i14 = i11;
            i13 = i12;
        } else {
            i13 = i11;
            i14 = i12;
            i15 = 1;
        }
        for (int i17 = 0; i17 < j11; i17++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i17));
            if (childViewHolderInt != null && (i16 = childViewHolderInt.mPosition) >= i14 && i16 <= i13) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove attached child " + i17 + " holder " + childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i11) {
                    childViewHolderInt.offsetPosition(i12 - i11, false);
                } else {
                    childViewHolderInt.offsetPosition(i15, false);
                }
                this.mState.f10723g = true;
            }
        }
        this.mRecycler.w(i11, i12);
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i11, int i12, boolean z11) {
        int i13 = i11 + i12;
        int j11 = this.mChildHelper.j();
        for (int i14 = 0; i14 < j11; i14++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i14));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i15 = childViewHolderInt.mPosition;
                if (i15 >= i13) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i14 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition - i12));
                    }
                    childViewHolderInt.offsetPosition(-i12, z11);
                    this.mState.f10723g = true;
                } else if (i15 >= i11) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i14 + " holder " + childViewHolderInt + " now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i11 - 1, -i12, z11);
                    this.mState.f10723g = true;
                }
            }
        }
        this.mRecycler.x(i11, i12, z11);
        requestLayout();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z11 = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z11 = false;
        }
        this.mFirstLayoutComplete = z11;
        this.mRecycler.z();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<j> threadLocal = j.f10885f;
            j jVar = threadLocal.get();
            this.mGapWorker = jVar;
            if (jVar == null) {
                this.mGapWorker = new j();
                Display y11 = h0.y(this);
                float f11 = 60.0f;
                if (!isInEditMode() && y11 != null) {
                    float refreshRate = y11.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f11 = refreshRate;
                    }
                }
                j jVar2 = this.mGapWorker;
                jVar2.f10889d = (long) (1.0E9f / f11);
                threadLocal.set(jVar2);
            }
            this.mGapWorker.a(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    public void onDetachedFromWindow() {
        j jVar;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        this.mRecycler.A();
        androidx.customview.poolingcontainer.a.b(this);
        if (ALLOW_THREAD_GAP_WORK && (jVar = this.mGapWorker) != null) {
            jVar.j(this);
            this.mGapWorker = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mItemDecorations.get(i11).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f11;
        float f12;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f12 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f11 = motionEvent.getAxisValue(10);
                    if (!(f12 == 0.0f && f11 == 0.0f)) {
                        nestedScrollByInternal((int) (f11 * this.mScaledHorizontalScrollFactor), (int) (f12 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f12 = -axisValue;
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f11 = axisValue;
                        f12 = 0.0f;
                        nestedScrollByInternal((int) (f11 * this.mScaledHorizontalScrollFactor), (int) (f12 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
                f12 = 0.0f;
                f11 = 0.0f;
                nestedScrollByInternal((int) (f11 * this.mScaledHorizontalScrollFactor), (int) (f12 * this.mScaledVerticalScrollFactor), motionEvent, 1);
            }
            f11 = 0.0f;
            nestedScrollByInternal((int) (f11 * this.mScaledHorizontalScrollFactor), (int) (f12 * this.mScaledVerticalScrollFactor), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            return false;
        }
        boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x11 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x11;
            this.mInitialTouchX = x11;
            int y11 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y11;
            this.mInitialTouchY = y11;
            if (stopGlowAnimations(motionEvent) || this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                canScrollHorizontally |= true;
            }
            startNestedScroll(canScrollHorizontally ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x12 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y12 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i11 = x12 - this.mInitialTouchX;
                int i12 = y12 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i11) <= this.mTouchSlop) {
                    z11 = false;
                } else {
                    this.mLastTouchX = x12;
                    z11 = true;
                }
                if (canScrollVertically && Math.abs(i12) > this.mTouchSlop) {
                    this.mLastTouchY = y12;
                    z11 = true;
                }
                if (z11) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x13 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x13;
            this.mInitialTouchX = x13;
            int y13 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y13;
            this.mInitialTouchY = y13;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        androidx.core.os.n.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.n.b();
        this.mFirstLayoutComplete = true;
    }

    public void onMeasure(int i11, int i12) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i11, i12);
            return;
        }
        boolean z11 = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z11 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z11;
            if (!z11 && this.mAdapter != null) {
                if (this.mState.f10721e == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i11, i12);
                this.mState.f10726j = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i11, i12);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.f10726j = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i11, i12);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                State state = this.mState;
                if (state.f10728l) {
                    state.f10724h = true;
                } else {
                    this.mAdapterHelper.j();
                    this.mState.f10724h = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f10728l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.f10722f = adapter.getItemCount();
            } else {
                this.mState.f10722f = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i11, i12);
            stopInterceptRequestLayout(false);
            this.mState.f10724h = false;
        }
    }

    public boolean onRequestFocusInDescendants(int i11, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i11, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.copyFrom(savedState2);
        } else {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                savedState.mLayoutState = layoutManager.onSaveInstanceState();
            } else {
                savedState.mLayoutState = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i11) {
    }

    public void onScrolled(int i11, int i12) {
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        if (i11 != i13 || i12 != i14) {
            invalidateGlows();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.mLayoutSuppressed
            r8 = 0
            if (r0 != 0) goto L_0x01f2
            boolean r0 = r6.mIgnoreMotionEventTillDown
            if (r0 == 0) goto L_0x000f
            goto L_0x01f2
        L_0x000f:
            boolean r0 = r17.dispatchToOnItemTouchListeners(r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.cancelScroll()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.canScrollHorizontally()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.mLayout
            boolean r11 = r0.canScrollVertically()
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.mVelocityTracker = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.mNestedOffsets
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.mNestedOffsets
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01c6
            if (r0 == r9) goto L_0x0184
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01e7
        L_0x0066:
            r17.onPointerUp(r18)
            goto L_0x01e7
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.mScrollPointerId = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            goto L_0x01e7
        L_0x0087:
            r17.cancelScroll()
            goto L_0x01e7
        L_0x008c:
            int r0 = r6.mScrollPointerId
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.mScrollPointerId
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.mLastTouchX
            int r0 = r0 - r13
            int r1 = r6.mLastTouchY
            int r1 = r1 - r14
            int r2 = r6.mScrollState
            if (r2 == r9) goto L_0x00fb
            if (r10 == 0) goto L_0x00df
            if (r0 <= 0) goto L_0x00d4
            int r2 = r6.mTouchSlop
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00db
        L_0x00d4:
            int r2 = r6.mTouchSlop
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00db:
            if (r0 == 0) goto L_0x00df
            r2 = r9
            goto L_0x00e0
        L_0x00df:
            r2 = r8
        L_0x00e0:
            if (r11 == 0) goto L_0x00f6
            if (r1 <= 0) goto L_0x00ec
            int r3 = r6.mTouchSlop
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00f3
        L_0x00ec:
            int r3 = r6.mTouchSlop
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00f3:
            if (r1 == 0) goto L_0x00f6
            r2 = r9
        L_0x00f6:
            if (r2 == 0) goto L_0x00fb
            r6.setScrollState(r9)
        L_0x00fb:
            int r2 = r6.mScrollState
            if (r2 != r9) goto L_0x01e7
            int[] r2 = r6.mReusableIntPair
            r2[r8] = r8
            r2[r9] = r8
            float r2 = r18.getY()
            int r2 = r6.releaseHorizontalGlow(r0, r2)
            int r15 = r0 - r2
            float r0 = r18.getX()
            int r0 = r6.releaseVerticalGlow(r1, r0)
            int r16 = r1 - r0
            if (r10 == 0) goto L_0x011d
            r1 = r15
            goto L_0x011e
        L_0x011d:
            r1 = r8
        L_0x011e:
            if (r11 == 0) goto L_0x0123
            r2 = r16
            goto L_0x0124
        L_0x0123:
            r2 = r8
        L_0x0124:
            int[] r3 = r6.mReusableIntPair
            int[] r4 = r6.mScrollOffset
            r5 = 0
            r0 = r17
            boolean r0 = r0.dispatchNestedPreScroll(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0153
            int[] r0 = r6.mReusableIntPair
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.mNestedOffsets
            r1 = r0[r8]
            int[] r2 = r6.mScrollOffset
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x0153:
            r0 = r16
            int[] r1 = r6.mScrollOffset
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.mLastTouchX = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.mLastTouchY = r14
            if (r10 == 0) goto L_0x0165
            r1 = r15
            goto L_0x0166
        L_0x0165:
            r1 = r8
        L_0x0166:
            if (r11 == 0) goto L_0x016a
            r2 = r0
            goto L_0x016b
        L_0x016a:
            r2 = r8
        L_0x016b:
            boolean r1 = r6.scrollByInternal(r1, r2, r7, r8)
            if (r1 == 0) goto L_0x0178
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0178:
            androidx.recyclerview.widget.j r1 = r6.mGapWorker
            if (r1 == 0) goto L_0x01e7
            if (r15 != 0) goto L_0x0180
            if (r0 == 0) goto L_0x01e7
        L_0x0180:
            r1.f(r6, r15, r0)
            goto L_0x01e7
        L_0x0184:
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.mMaxFlingVelocity
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x01a0
            android.view.VelocityTracker r1 = r6.mVelocityTracker
            int r2 = r6.mScrollPointerId
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x01a1
        L_0x01a0:
            r1 = r0
        L_0x01a1:
            if (r11 == 0) goto L_0x01ad
            android.view.VelocityTracker r2 = r6.mVelocityTracker
            int r3 = r6.mScrollPointerId
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x01ae
        L_0x01ad:
            r2 = r0
        L_0x01ae:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x01b6
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01be
        L_0x01b6:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.fling(r0, r1)
            if (r0 != 0) goto L_0x01c1
        L_0x01be:
            r6.setScrollState(r8)
        L_0x01c1:
            r17.resetScroll()
            r8 = r9
            goto L_0x01e7
        L_0x01c6:
            int r0 = r7.getPointerId(r8)
            r6.mScrollPointerId = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchX = r0
            r6.mInitialTouchX = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.mLastTouchY = r0
            r6.mInitialTouchY = r0
            if (r11 == 0) goto L_0x01e4
            r10 = r10 | 2
        L_0x01e4:
            r6.startNestedScroll(r10, r8)
        L_0x01e7:
            if (r8 != 0) goto L_0x01ee
            android.view.VelocityTracker r0 = r6.mVelocityTracker
            r0.addMovement(r12)
        L_0x01ee:
            r12.recycle()
            return r9
        L_0x01f2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            h0.p0(this, this.mItemAnimatorRunner);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z11) {
        this.mDispatchItemsChangedEvent = z11 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, 8192);
        if (this.mState.f10725i && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.c(getChangedHolderKey(viewHolder), viewHolder);
        }
        this.mViewInfoStore.e(viewHolder, itemHolderInfo);
    }

    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.c();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean r11 = this.mChildHelper.r(view);
        if (r11) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.O(childViewHolderInt);
            this.mRecycler.H(childViewHolderInt);
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "after removing animated view: " + view + ", " + this);
            }
        }
        stopInterceptRequestLayout(!r11);
        return r11;
    }

    public void removeDetachedView(View view, boolean z11) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        } else if (sDebugAssertionsEnabled) {
            throw new IllegalArgumentException("No ViewHolder found for child: " + view + exceptionLabel());
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z11);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i11) {
        int itemDecorationCount = getItemDecorationCount();
        if (i11 < 0 || i11 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i11 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i11));
    }

    public void removeOnChildAttachStateChangeListener(j jVar) {
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(jVar);
        }
    }

    public void removeOnItemTouchListener(k kVar) {
        this.mOnItemTouchListeners.remove(kVar);
        if (this.mInterceptingOnItemTouchListener == kVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(l lVar) {
        this.mRecyclerListeners.remove(lVar);
    }

    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int g11 = this.mChildHelper.g();
        for (int i11 = 0; i11 < g11; i11++) {
            View f11 = this.mChildHelper.f(i11);
            ViewHolder childViewHolder = getChildViewHolder(f11);
            if (!(childViewHolder == null || (viewHolder = childViewHolder.mShadowingHolder) == null)) {
                View view = viewHolder.itemView;
                int left = f11.getLeft();
                int top = f11.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z11) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z11);
    }

    public void requestDisallowInterceptTouchEvent(boolean z11) {
        int size = this.mOnItemTouchListeners.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.mOnItemTouchListeners.get(i11).onRequestDisallowInterceptTouchEvent(z11);
        }
        super.requestDisallowInterceptTouchEvent(z11);
    }

    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int j11 = this.mChildHelper.j();
        int i11 = 0;
        while (i11 < j11) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i11));
            if (!sDebugAssertionsEnabled || childViewHolderInt.mPosition != -1 || childViewHolderInt.isRemoved()) {
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.saveOldPosition();
                }
                i11++;
            } else {
                throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
            }
        }
    }

    public void scrollBy(int i11, int i12) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i11 = 0;
                }
                if (!canScrollVertically) {
                    i12 = 0;
                }
                scrollByInternal(i11, i12, (MotionEvent) null, 0);
            }
        }
    }

    public boolean scrollByInternal(int i11, int i12, MotionEvent motionEvent, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        int i19 = i12;
        MotionEvent motionEvent2 = motionEvent;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i18, i19, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i21 = iArr2[0];
            int i22 = iArr2[1];
            i17 = i22;
            i16 = i21;
            i15 = i18 - i21;
            i14 = i19 - i22;
        } else {
            i17 = 0;
            i16 = 0;
            i15 = 0;
            i14 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i16, i17, i15, i14, this.mScrollOffset, i13, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i23 = i15 - iArr4[0];
        int i24 = i14 - iArr4[1];
        boolean z11 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i25 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i25 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !androidx.core.view.n.g(motionEvent2, 8194)) {
                pullGlows(motionEvent.getX(), (float) i23, motionEvent.getY(), (float) i24);
            }
            considerReleasingGlowsOnScroll(i11, i12);
        }
        if (!(i16 == 0 && i17 == 0)) {
            dispatchOnScrolled(i16, i17);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        if (!z11 && i16 == 0 && i17 == 0) {
            return false;
        }
        return true;
    }

    public void scrollStep(int i11, int i12, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.n.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i11 != 0 ? this.mLayout.scrollHorizontallyBy(i11, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i12 != 0 ? this.mLayout.scrollVerticallyBy(i12, this.mRecycler, this.mState) : 0;
        androidx.core.os.n.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    public void scrollTo(int i11, int i12) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i11) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i11);
            awakenScrollBars();
        }
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(s sVar) {
        this.mAccessibilityDelegate = sVar;
        h0.x0(this, sVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(h hVar) {
        if (hVar != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = hVar;
            setChildrenDrawingOrderEnabled(hVar != null);
        }
    }

    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i11) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i11;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        h0.I0(viewHolder.itemView, i11);
        return true;
    }

    public void setClipToPadding(boolean z11) {
        if (z11 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z11;
        super.setClipToPadding(z11);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        androidx.core.util.h.g(edgeEffectFactory);
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z11) {
        this.mHasFixedSize = z11;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.setListener((ItemAnimator.b) null);
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i11) {
        this.mRecycler.L(i11);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z11) {
        suppressLayout(z11);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                ItemAnimator itemAnimator = this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.c();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView((RecyclerView) null);
                this.mLayout = null;
            } else {
                this.mRecycler.c();
            }
            this.mChildHelper.o();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    layoutManager.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.mRecyclerView.exceptionLabel());
                }
            }
            this.mRecycler.P();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z11) {
        getScrollingChildHelper().n(z11);
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z11) {
        this.mPreserveFocusAfterLayout = z11;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        this.mRecycler.J(recycledViewPool);
    }

    @Deprecated
    public void setRecyclerListener(l lVar) {
        this.mRecyclerListener = lVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i11) {
        if (i11 != this.mScrollState) {
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "setting scroll state to " + i11 + " from " + this.mScrollState, new Exception());
            }
            this.mScrollState = i11;
            if (i11 != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i11);
        }
    }

    public void setScrollingTouchSlop(int i11) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i11 != 0) {
            if (i11 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i11 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.K(viewCacheExtension);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i11 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        int a11 = accessibilityEvent != null ? b1.b.a(accessibilityEvent) : 0;
        if (a11 != 0) {
            i11 = a11;
        }
        this.mEatenAccessibilityChangeFlags |= i11;
        return true;
    }

    public void smoothScrollBy(int i11, int i12) {
        smoothScrollBy(i11, i12, (Interpolator) null);
    }

    public void smoothScrollToPosition(int i11) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.mState, i11);
            }
        }
    }

    public void startInterceptRequestLayout() {
        int i11 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i11;
        if (i11 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    public boolean startNestedScroll(int i11) {
        return getScrollingChildHelper().p(i11);
    }

    public void stopInterceptRequestLayout(boolean z11) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (!sDebugAssertionsEnabled) {
                this.mInterceptRequestLayoutDepth = 1;
            } else {
                throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
            }
        }
        if (!z11 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z11 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    public final void suppressLayout(boolean z11) {
        if (z11 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z11) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(Adapter adapter, boolean z11) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z11);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i11, int i12, Object obj) {
        int i13;
        int j11 = this.mChildHelper.j();
        int i14 = i11 + i12;
        for (int i15 = 0; i15 < j11; i15++) {
            View i16 = this.mChildHelper.i(i15);
            ViewHolder childViewHolderInt = getChildViewHolderInt(i16);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i13 = childViewHolderInt.mPosition) >= i11 && i13 < i14) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) i16.getLayoutParams()).mInsetsDirty = true;
            }
        }
        this.mRecycler.R(i11, i12);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i11, int i12, int[] iArr, int[] iArr2, int i13) {
        return getScrollingChildHelper().d(i11, i12, iArr, iArr2, i13);
    }

    public boolean dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15) {
        return getScrollingChildHelper().g(i11, i12, i13, i14, iArr, i15);
    }

    public ViewHolder findViewHolderForPosition(int i11, boolean z11) {
        int j11 = this.mChildHelper.j();
        ViewHolder viewHolder = null;
        for (int i12 = 0; i12 < j11; i12++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.i(i12));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z11) {
                    if (childViewHolderInt.mPosition != i11) {
                        continue;
                    }
                } else if (childViewHolderInt.getLayoutPosition() != i11) {
                    continue;
                }
                if (!this.mChildHelper.n(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public boolean hasNestedScrollingParent(int i11) {
        return getScrollingChildHelper().l(i11);
    }

    public void onExitLayoutOrScroll(boolean z11) {
        int i11 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i11;
        if (i11 >= 1) {
            return;
        }
        if (!sDebugAssertionsEnabled || i11 >= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z11) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
                return;
            }
            return;
        }
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
    }

    public void smoothScrollBy(int i11, int i12, Interpolator interpolator) {
        smoothScrollBy(i11, i12, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i11, int i12) {
        return getScrollingChildHelper().q(i11, i12);
    }

    public void stopNestedScroll(int i11) {
        getScrollingChildHelper().s(i11);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Parcelable mLayoutState;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        public void copyFrom(SavedState savedState) {
            this.mLayoutState = savedState.mLayoutState;
        }

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        boolean z11;
        this.mObserver = new m();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new w();
        this.mUpdateChildViewsRunnable = new a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new o();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new j.b() : null;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new i();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = j0.c(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = j0.f(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (h0.D(this) == 0) {
            h0.I0(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new s(this));
        int[] iArr = R$styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        h0.v0(this, context, iArr, attributeSet, obtainStyledAttributes, i11, 0);
        String string = obtainStyledAttributes.getString(R$styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z12;
        if (z12) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i11, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr2 = NESTED_SCROLLING_ATTRS;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i11, 0);
            h0.v0(this, context, iArr2, attributeSet, obtainStyledAttributes2, i11, 0);
            z11 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        } else {
            z11 = true;
        }
        setNestedScrollingEnabled(z11);
        androidx.customview.poolingcontainer.a.d(this, true);
    }

    public final void dispatchNestedScroll(int i11, int i12, int i13, int i14, int[] iArr, int i15, int[] iArr2) {
        getScrollingChildHelper().e(i11, i12, i13, i14, iArr, i15, iArr2);
    }

    public void smoothScrollBy(int i11, int i12, Interpolator interpolator, int i13) {
        smoothScrollBy(i11, i12, interpolator, i13, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final Rect mDecorInsets = new Rect();
        public boolean mInsetsDirty = true;
        public boolean mPendingInvalidate = false;
        public ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
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

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public void smoothScrollBy(int i11, int i12, Interpolator interpolator, int i13, boolean z11) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i14 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i11 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i12 = 0;
            }
            if (i11 != 0 || i12 != 0) {
                if (i13 == Integer.MIN_VALUE || i13 > 0) {
                    if (z11) {
                        if (i11 != 0) {
                            i14 = 1;
                        }
                        if (i12 != 0) {
                            i14 |= 2;
                        }
                        startNestedScroll(i14, 1);
                    }
                    this.mViewFlinger.e(i11, i12, i13, interpolator);
                    return;
                }
                scrollBy(i11, i12);
            }
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }
}
