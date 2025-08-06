package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.h;
import androidx.core.view.h0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.huawei.secure.android.common.ssl.util.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    public FragmentEventDispatcher mFragmentEventDispatcher;
    public final FragmentManager mFragmentManager;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    public final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    public boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    public final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

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

    public @interface ExperimentalFragmentStateAdapterApi {
    }

    public static class FragmentEventDispatcher {
        private List<FragmentTransactionCallback> mCallbacks = new CopyOnWriteArrayList();

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchMaxLifecyclePreUpdated(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentMaxLifecyclePreUpdated : this.mCallbacks) {
                arrayList.add(onFragmentMaxLifecyclePreUpdated.onFragmentMaxLifecyclePreUpdated(fragment, state));
            }
            return arrayList;
        }

        public void dispatchPostEvents(List<FragmentTransactionCallback.OnPostEventListener> list) {
            for (FragmentTransactionCallback.OnPostEventListener onPost : list) {
                onPost.onPost();
            }
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreAdded(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreAdded : this.mCallbacks) {
                arrayList.add(onFragmentPreAdded.onFragmentPreAdded(fragment));
            }
            return arrayList;
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreRemoved(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreRemoved : this.mCallbacks) {
                arrayList.add(onFragmentPreRemoved.onFragmentPreRemoved(fragment));
            }
            return arrayList;
        }

        public List<FragmentTransactionCallback.OnPostEventListener> dispatchPreSavedInstanceState(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            for (FragmentTransactionCallback onFragmentPreSavedInstanceState : this.mCallbacks) {
                arrayList.add(onFragmentPreSavedInstanceState.onFragmentPreSavedInstanceState(fragment));
            }
            return arrayList;
        }

        public void registerCallback(FragmentTransactionCallback fragmentTransactionCallback) {
            this.mCallbacks.add(fragmentTransactionCallback);
        }

        public void unregisterCallback(FragmentTransactionCallback fragmentTransactionCallback) {
            this.mCallbacks.remove(fragmentTransactionCallback);
        }
    }

    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private r mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        public FragmentMaxLifecycleEnforcer() {
        }

        private ViewPager2 inferViewPager(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void register(RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            AnonymousClass1 r22 = new ViewPager2.OnPageChangeCallback() {
                public void onPageScrollStateChanged(int i11) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }

                public void onPageSelected(int i11) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mPageChangeCallback = r22;
            this.mViewPager.registerOnPageChangeCallback(r22);
            AnonymousClass2 r23 = new DataSetChangeObserver() {
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(true);
                }
            };
            this.mDataObserver = r23;
            FragmentStateAdapter.this.registerAdapterDataObserver(r23);
            AnonymousClass3 r24 = new r() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.updateFragmentMaxLifecycle(false);
                }
            };
            this.mLifecycleObserver = r24;
            FragmentStateAdapter.this.mLifecycle.a(r24);
        }

        public void unregister(RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.mLifecycle.d(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void updateFragmentMaxLifecycle(boolean z11) {
            int currentItem;
            Fragment g11;
            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions() && this.mViewPager.getScrollState() == 0 && !FragmentStateAdapter.this.mFragments.j() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.mViewPager.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.mPrimaryItemId || z11) && (g11 = FragmentStateAdapter.this.mFragments.g(itemId)) != null && g11.isAdded()) {
                    this.mPrimaryItemId = itemId;
                    FragmentTransaction q11 = FragmentStateAdapter.this.mFragmentManager.q();
                    Fragment fragment = null;
                    ArrayList<List> arrayList = new ArrayList<>();
                    for (int i11 = 0; i11 < FragmentStateAdapter.this.mFragments.o(); i11++) {
                        long k11 = FragmentStateAdapter.this.mFragments.k(i11);
                        Fragment p11 = FragmentStateAdapter.this.mFragments.p(i11);
                        if (p11.isAdded()) {
                            if (k11 != this.mPrimaryItemId) {
                                Lifecycle.State state = Lifecycle.State.STARTED;
                                q11.x(p11, state);
                                arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(p11, state));
                            } else {
                                fragment = p11;
                            }
                            p11.setMenuVisibility(k11 == this.mPrimaryItemId);
                        }
                    }
                    if (fragment != null) {
                        Lifecycle.State state2 = Lifecycle.State.RESUMED;
                        q11.x(fragment, state2);
                        arrayList.add(FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchMaxLifecyclePreUpdated(fragment, state2));
                    }
                    if (!q11.r()) {
                        q11.l();
                        Collections.reverse(arrayList);
                        for (List dispatchPostEvents : arrayList) {
                            FragmentStateAdapter.this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPostEvents);
                        }
                    }
                }
            }
        }
    }

    public static abstract class FragmentTransactionCallback {
        private static final OnPostEventListener NO_OP = new OnPostEventListener() {
            public void onPost() {
            }
        };

        public interface OnPostEventListener {
            void onPost();
        }

        public OnPostEventListener onFragmentMaxLifecyclePreUpdated(Fragment fragment, Lifecycle.State state) {
            return NO_OP;
        }

        public OnPostEventListener onFragmentPreAdded(Fragment fragment) {
            return NO_OP;
        }

        public OnPostEventListener onFragmentPreRemoved(Fragment fragment) {
            return NO_OP;
        }

        @ExperimentalFragmentStateAdapterApi
        public OnPostEventListener onFragmentPreSavedInstanceState(Fragment fragment) {
            return NO_OP;
        }
    }

    public FragmentStateAdapter(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    private static String createKey(String str, long j11) {
        return str + j11;
    }

    private void ensureFragment(int i11) {
        long itemId = getItemId(i11);
        if (!this.mFragments.e(itemId)) {
            Fragment createFragment = createFragment(i11);
            createFragment.setInitialSavedState(this.mSavedStates.g(itemId));
            this.mFragments.l(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j11) {
        View view;
        if (this.mItemIdToViewHolder.e(j11)) {
            return true;
        }
        Fragment g11 = this.mFragments.g(j11);
        if (g11 == null || (view = g11.getView()) == null) {
            return false;
        }
        if (view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean isValidKey(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long itemForViewHolder(int i11) {
        Long l11 = null;
        for (int i12 = 0; i12 < this.mItemIdToViewHolder.o(); i12++) {
            if (this.mItemIdToViewHolder.p(i12).intValue() == i11) {
                if (l11 == null) {
                    l11 = Long.valueOf(this.mItemIdToViewHolder.k(i12));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l11;
    }

    private static long parseIdFromKey(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j11) {
        ViewParent parent;
        Fragment g11 = this.mFragments.g(j11);
        if (g11 != null) {
            if (!(g11.getView() == null || (parent = g11.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j11)) {
                this.mSavedStates.m(j11);
            }
            if (!g11.isAdded()) {
                this.mFragments.m(j11);
            } else if (shouldDelayFragmentTransactions()) {
                this.mHasStaleFragments = true;
            } else {
                if (g11.isAdded() && containsItem(j11)) {
                    List<FragmentTransactionCallback.OnPostEventListener> dispatchPreSavedInstanceState = this.mFragmentEventDispatcher.dispatchPreSavedInstanceState(g11);
                    Fragment.SavedState D1 = this.mFragmentManager.D1(g11);
                    this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreSavedInstanceState);
                    this.mSavedStates.l(j11, D1);
                }
                List<FragmentTransactionCallback.OnPostEventListener> dispatchPreRemoved = this.mFragmentEventDispatcher.dispatchPreRemoved(g11);
                try {
                    this.mFragmentManager.q().s(g11).l();
                    this.mFragments.m(j11);
                } finally {
                    this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreRemoved);
                }
            }
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AnonymousClass3 r12 = new Runnable() {
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.mIsInGracePeriod = false;
                fragmentStateAdapter.gcFragments();
            }
        };
        this.mLifecycle.a(new r() {
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(r12);
                    lifecycleOwner.getLifecycle().d(this);
                }
            }
        });
        handler.postDelayed(r12, 10000);
    }

    private void scheduleViewAttach(final Fragment fragment, final FrameLayout frameLayout) {
        this.mFragmentManager.r1(new FragmentManager.FragmentLifecycleCallbacks() {
            public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.O1(this);
                    FragmentStateAdapter.this.addViewToContainer(view, frameLayout);
                }
            }
        }, false);
    }

    public void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean containsItem(long j11) {
        return j11 >= 0 && j11 < ((long) getItemCount());
    }

    public abstract Fragment createFragment(int i11);

    public void gcFragments() {
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i11 = 0; i11 < this.mFragments.o(); i11++) {
                long k11 = this.mFragments.k(i11);
                if (!containsItem(k11)) {
                    arraySet.add(Long.valueOf(k11));
                    this.mItemIdToViewHolder.m(k11);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i12 = 0; i12 < this.mFragments.o(); i12++) {
                    long k12 = this.mFragments.k(i12);
                    if (!isFragmentViewBound(k12)) {
                        arraySet.add(Long.valueOf(k12));
                    }
                }
            }
            for (Long longValue : arraySet) {
                removeFragment(longValue.longValue());
            }
        }
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        h.a(this.mFragmentMaxLifecycleEnforcer == null);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.register(recyclerView);
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.unregister(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public void placeFragmentInViewHolder(final FragmentViewHolder fragmentViewHolder) {
        Fragment g11 = this.mFragments.g(fragmentViewHolder.getItemId());
        if (g11 != null) {
            FrameLayout container = fragmentViewHolder.getContainer();
            View view = g11.getView();
            if (!g11.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (g11.isAdded() && view == null) {
                scheduleViewAttach(g11, container);
            } else if (!g11.isAdded() || view.getParent() == null) {
                if (g11.isAdded()) {
                    addViewToContainer(view, container);
                } else if (!shouldDelayFragmentTransactions()) {
                    scheduleViewAttach(g11, container);
                    List<FragmentTransactionCallback.OnPostEventListener> dispatchPreAdded = this.mFragmentEventDispatcher.dispatchPreAdded(g11);
                    try {
                        g11.setMenuVisibility(false);
                        FragmentTransaction q11 = this.mFragmentManager.q();
                        q11.e(g11, f.f38658a + fragmentViewHolder.getItemId()).x(g11, Lifecycle.State.STARTED).l();
                        this.mFragmentMaxLifecycleEnforcer.updateFragmentMaxLifecycle(false);
                    } finally {
                        this.mFragmentEventDispatcher.dispatchPostEvents(dispatchPreAdded);
                    }
                } else if (!this.mFragmentManager.O0()) {
                    this.mLifecycle.a(new r() {
                        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.shouldDelayFragmentTransactions()) {
                                lifecycleOwner.getLifecycle().d(this);
                                if (h0.Z(fragmentViewHolder.getContainer())) {
                                    FragmentStateAdapter.this.placeFragmentInViewHolder(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != container) {
                addViewToContainer(view, container);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public void registerFragmentTransactionCallback(FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.registerCallback(fragmentTransactionCallback);
    }

    public final void restoreState(Parcelable parcelable) {
        if (!this.mSavedStates.j() || !this.mFragments.j()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (isValidKey(str, KEY_PREFIX_FRAGMENT)) {
                this.mFragments.l(parseIdFromKey(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.x0(bundle, str));
            } else if (isValidKey(str, KEY_PREFIX_STATE)) {
                long parseIdFromKey = parseIdFromKey(str, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.l(parseIdFromKey, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + str);
            }
        }
        if (!this.mFragments.j()) {
            this.mHasStaleFragments = true;
            this.mIsInGracePeriod = true;
            gcFragments();
            scheduleGracePeriodEnd();
        }
    }

    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.o() + this.mSavedStates.o());
        for (int i11 = 0; i11 < this.mFragments.o(); i11++) {
            long k11 = this.mFragments.k(i11);
            Fragment g11 = this.mFragments.g(k11);
            if (g11 != null && g11.isAdded()) {
                this.mFragmentManager.q1(bundle, createKey(KEY_PREFIX_FRAGMENT, k11), g11);
            }
        }
        for (int i12 = 0; i12 < this.mSavedStates.o(); i12++) {
            long k12 = this.mSavedStates.k(i12);
            if (containsItem(k12)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, k12), this.mSavedStates.g(k12));
            }
        }
        return bundle;
    }

    public final void setHasStableIds(boolean z11) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.W0();
    }

    public void unregisterFragmentTransactionCallback(FragmentTransactionCallback fragmentTransactionCallback) {
        this.mFragmentEventDispatcher.unregisterCallback(fragmentTransactionCallback);
    }

    public FragmentStateAdapter(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public final void onBindViewHolder(FragmentViewHolder fragmentViewHolder, int i11) {
        long itemId = fragmentViewHolder.getItemId();
        int id2 = fragmentViewHolder.getContainer().getId();
        Long itemForViewHolder = itemForViewHolder(id2);
        if (!(itemForViewHolder == null || itemForViewHolder.longValue() == itemId)) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.m(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.l(itemId, Integer.valueOf(id2));
        ensureFragment(i11);
        if (h0.Z(fragmentViewHolder.getContainer())) {
            placeFragmentInViewHolder(fragmentViewHolder);
        }
        gcFragments();
    }

    public final FragmentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return FragmentViewHolder.create(viewGroup);
    }

    public final void onViewAttachedToWindow(FragmentViewHolder fragmentViewHolder) {
        placeFragmentInViewHolder(fragmentViewHolder);
        gcFragments();
    }

    public final void onViewRecycled(FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.getContainer().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.m(itemForViewHolder.longValue());
        }
    }

    public FragmentStateAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mFragmentEventDispatcher = new FragmentEventDispatcher();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
