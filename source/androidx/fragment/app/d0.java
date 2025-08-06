package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.h0;
import androidx.fragment.R$id;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.q0;
import com.facebook.internal.AnalyticsEvents;
import com.huobi.finance.bean.LoanOrderItem;

public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public final r f9704a;

    /* renamed from: b  reason: collision with root package name */
    public final f0 f9705b;

    /* renamed from: c  reason: collision with root package name */
    public final Fragment f9706c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9707d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f9708e = -1;

    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f9709b;

        public a(View view) {
            this.f9709b = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f9709b.removeOnAttachStateChangeListener(this);
            h0.u0(this.f9709b);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f9711a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.lifecycle.Lifecycle$State[] r0 = androidx.lifecycle.Lifecycle.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f9711a = r0
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f9711a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f9711a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f9711a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.d0.b.<clinit>():void");
        }
    }

    public d0(r rVar, f0 f0Var, Fragment fragment) {
        this.f9704a = rVar;
        this.f9705b = f0Var;
        this.f9706c = fragment;
    }

    public void a() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f9706c);
        }
        Bundle bundle = null;
        Bundle bundle2 = this.f9706c.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        }
        this.f9706c.performActivityCreated(bundle);
        this.f9704a.a(this.f9706c, bundle, false);
    }

    public void b() {
        Fragment p02 = FragmentManager.p0(this.f9706c.mContainer);
        Fragment parentFragment = this.f9706c.getParentFragment();
        if (p02 != null && !p02.equals(parentFragment)) {
            Fragment fragment = this.f9706c;
            FragmentStrictMode.q(fragment, p02, fragment.mContainerId);
        }
        int j11 = this.f9705b.j(this.f9706c);
        Fragment fragment2 = this.f9706c;
        fragment2.mContainer.addView(fragment2.mView, j11);
    }

    public void c() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f9706c);
        }
        Fragment fragment = this.f9706c;
        Fragment fragment2 = fragment.mTarget;
        d0 d0Var = null;
        if (fragment2 != null) {
            d0 n11 = this.f9705b.n(fragment2.mWho);
            if (n11 != null) {
                Fragment fragment3 = this.f9706c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                d0Var = n11;
            } else {
                throw new IllegalStateException("Fragment " + this.f9706c + " declared target fragment " + this.f9706c.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (d0Var = this.f9705b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f9706c + " declared target fragment " + this.f9706c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (d0Var != null) {
            d0Var.m();
        }
        Fragment fragment4 = this.f9706c;
        fragment4.mHost = fragment4.mFragmentManager.C0();
        Fragment fragment5 = this.f9706c;
        fragment5.mParentFragment = fragment5.mFragmentManager.F0();
        this.f9704a.g(this.f9706c, false);
        this.f9706c.performAttach();
        this.f9704a.b(this.f9706c, false);
    }

    public int d() {
        Fragment fragment = this.f9706c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i11 = this.f9708e;
        int i12 = b.f9711a[fragment.mMaxState.ordinal()];
        if (i12 != 1) {
            if (i12 == 2) {
                i11 = Math.min(i11, 5);
            } else if (i12 == 3) {
                i11 = Math.min(i11, 1);
            } else if (i12 != 4) {
                i11 = Math.min(i11, -1);
            } else {
                i11 = Math.min(i11, 0);
            }
        }
        Fragment fragment2 = this.f9706c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i11 = Math.max(this.f9708e, 2);
                View view = this.f9706c.mView;
                if (view != null && view.getParent() == null) {
                    i11 = Math.min(i11, 2);
                }
            } else {
                i11 = this.f9708e < 4 ? Math.min(i11, fragment2.mState) : Math.min(i11, 1);
            }
        }
        if (!this.f9706c.mAdded) {
            i11 = Math.min(i11, 1);
        }
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact = null;
        Fragment fragment3 = this.f9706c;
        ViewGroup viewGroup = fragment3.mContainer;
        if (viewGroup != null) {
            lifecycleImpact = SpecialEffectsController.r(viewGroup, fragment3.getParentFragmentManager()).p(this);
        }
        if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            i11 = Math.min(i11, 6);
        } else if (lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            i11 = Math.max(i11, 3);
        } else {
            Fragment fragment4 = this.f9706c;
            if (fragment4.mRemoving) {
                if (fragment4.isInBackStack()) {
                    i11 = Math.min(i11, 1);
                } else {
                    i11 = Math.min(i11, -1);
                }
            }
        }
        Fragment fragment5 = this.f9706c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            i11 = Math.min(i11, 4);
        }
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i11 + " for " + this.f9706c);
        }
        return i11;
    }

    public void e() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f9706c);
        }
        Bundle bundle = null;
        Bundle bundle2 = this.f9706c.mSavedFragmentState;
        if (bundle2 != null) {
            bundle = bundle2.getBundle("savedInstanceState");
        }
        Fragment fragment = this.f9706c;
        if (!fragment.mIsCreated) {
            this.f9704a.h(fragment, bundle, false);
            this.f9706c.performCreate(bundle);
            this.f9704a.c(this.f9706c, bundle, false);
            return;
        }
        fragment.mState = 1;
        fragment.restoreChildFragmentState();
    }

    public void f() {
        String str;
        if (!this.f9706c.mFromLayout) {
            if (FragmentManager.P0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f9706c);
            }
            Bundle bundle = this.f9706c.mSavedFragmentState;
            ViewGroup viewGroup = null;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            LayoutInflater performGetLayoutInflater = this.f9706c.performGetLayoutInflater(bundle2);
            Fragment fragment = this.f9706c;
            ViewGroup viewGroup2 = fragment.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i11 = fragment.mContainerId;
                if (i11 != 0) {
                    if (i11 != -1) {
                        viewGroup = (ViewGroup) fragment.mFragmentManager.w0().c(this.f9706c.mContainerId);
                        if (viewGroup == null) {
                            Fragment fragment2 = this.f9706c;
                            if (!fragment2.mRestored) {
                                try {
                                    str = fragment2.getResources().getResourceName(this.f9706c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f9706c.mContainerId) + " (" + str + ") for fragment " + this.f9706c);
                            }
                        } else if (!(viewGroup instanceof FragmentContainerView)) {
                            FragmentStrictMode.p(this.f9706c, viewGroup);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create fragment " + this.f9706c + " for a container view with no id");
                    }
                }
            }
            Fragment fragment3 = this.f9706c;
            fragment3.mContainer = viewGroup;
            fragment3.performCreateView(performGetLayoutInflater, viewGroup, bundle2);
            if (this.f9706c.mView != null) {
                if (FragmentManager.P0(3)) {
                    Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f9706c);
                }
                this.f9706c.mView.setSaveFromParentEnabled(false);
                Fragment fragment4 = this.f9706c;
                fragment4.mView.setTag(R$id.fragment_container_view_tag, fragment4);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment5 = this.f9706c;
                if (fragment5.mHidden) {
                    fragment5.mView.setVisibility(8);
                }
                if (h0.Z(this.f9706c.mView)) {
                    h0.u0(this.f9706c.mView);
                } else {
                    View view = this.f9706c.mView;
                    view.addOnAttachStateChangeListener(new a(view));
                }
                this.f9706c.performViewCreated();
                r rVar = this.f9704a;
                Fragment fragment6 = this.f9706c;
                rVar.m(fragment6, fragment6.mView, bundle2, false);
                int visibility = this.f9706c.mView.getVisibility();
                this.f9706c.setPostOnViewCreatedAlpha(this.f9706c.mView.getAlpha());
                Fragment fragment7 = this.f9706c;
                if (fragment7.mContainer != null && visibility == 0) {
                    View findFocus = fragment7.mView.findFocus();
                    if (findFocus != null) {
                        this.f9706c.setFocusedView(findFocus);
                        if (FragmentManager.P0(2)) {
                            Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f9706c);
                        }
                    }
                    this.f9706c.mView.setAlpha(0.0f);
                }
            }
            this.f9706c.mState = 2;
        }
    }

    public void g() {
        Fragment f11;
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f9706c);
        }
        Fragment fragment = this.f9706c;
        boolean z11 = true;
        boolean z12 = fragment.mRemoving && !fragment.isInBackStack();
        if (z12) {
            Fragment fragment2 = this.f9706c;
            if (!fragment2.mBeingSaved) {
                this.f9705b.B(fragment2.mWho, (Bundle) null);
            }
        }
        if (z12 || this.f9705b.p().m0(this.f9706c)) {
            FragmentHostCallback<?> fragmentHostCallback = this.f9706c.mHost;
            if (fragmentHostCallback instanceof q0) {
                z11 = this.f9705b.p().j0();
            } else if (fragmentHostCallback.f() instanceof Activity) {
                z11 = true ^ ((Activity) fragmentHostCallback.f()).isChangingConfigurations();
            }
            if ((z12 && !this.f9706c.mBeingSaved) || z11) {
                this.f9705b.p().c(this.f9706c, false);
            }
            this.f9706c.performDestroy();
            this.f9704a.d(this.f9706c, false);
            for (d0 next : this.f9705b.k()) {
                if (next != null) {
                    Fragment k11 = next.k();
                    if (this.f9706c.mWho.equals(k11.mTargetWho)) {
                        k11.mTarget = this.f9706c;
                        k11.mTargetWho = null;
                    }
                }
            }
            Fragment fragment3 = this.f9706c;
            String str = fragment3.mTargetWho;
            if (str != null) {
                fragment3.mTarget = this.f9705b.f(str);
            }
            this.f9705b.s(this);
            return;
        }
        String str2 = this.f9706c.mTargetWho;
        if (!(str2 == null || (f11 = this.f9705b.f(str2)) == null || !f11.mRetainInstance)) {
            this.f9706c.mTarget = f11;
        }
        this.f9706c.mState = 0;
    }

    public void h() {
        View view;
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f9706c);
        }
        Fragment fragment = this.f9706c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.f9706c.performDestroyView();
        this.f9704a.n(this.f9706c, false);
        Fragment fragment2 = this.f9706c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.setValue(null);
        this.f9706c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f9706c);
        }
        this.f9706c.performDetach();
        boolean z11 = false;
        this.f9704a.e(this.f9706c, false);
        Fragment fragment = this.f9706c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z11 = true;
        }
        if (z11 || this.f9705b.p().m0(this.f9706c)) {
            if (FragmentManager.P0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f9706c);
            }
            this.f9706c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.f9706c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.P0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f9706c);
            }
            Bundle bundle = this.f9706c.mSavedFragmentState;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            Fragment fragment2 = this.f9706c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(bundle2), (ViewGroup) null, bundle2);
            View view = this.f9706c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f9706c;
                fragment3.mView.setTag(R$id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f9706c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f9706c.performViewCreated();
                r rVar = this.f9704a;
                Fragment fragment5 = this.f9706c;
                rVar.m(fragment5, fragment5.mView, bundle2, false);
                this.f9706c.mState = 2;
            }
        }
    }

    public Fragment k() {
        return this.f9706c;
    }

    public final boolean l(View view) {
        if (view == this.f9706c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f9706c.mView) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.f9707d) {
            try {
                this.f9707d = true;
                boolean z11 = false;
                while (true) {
                    int d11 = d();
                    Fragment fragment = this.f9706c;
                    int i11 = fragment.mState;
                    if (d11 != i11) {
                        if (d11 <= i11) {
                            switch (i11 - 1) {
                                case -1:
                                    i();
                                    break;
                                case 0:
                                    if (fragment.mBeingSaved && this.f9705b.q(fragment.mWho) == null) {
                                        this.f9705b.B(this.f9706c.mWho, r());
                                    }
                                    g();
                                    break;
                                case 1:
                                    h();
                                    this.f9706c.mState = 1;
                                    break;
                                case 2:
                                    fragment.mInLayout = false;
                                    fragment.mState = 2;
                                    break;
                                case 3:
                                    if (FragmentManager.P0(3)) {
                                        Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f9706c);
                                    }
                                    Fragment fragment2 = this.f9706c;
                                    if (fragment2.mBeingSaved) {
                                        this.f9705b.B(fragment2.mWho, r());
                                    } else if (fragment2.mView != null && fragment2.mSavedViewState == null) {
                                        s();
                                    }
                                    Fragment fragment3 = this.f9706c;
                                    if (!(fragment3.mView == null || (viewGroup2 = fragment3.mContainer) == null)) {
                                        SpecialEffectsController.r(viewGroup2, fragment3.getParentFragmentManager()).h(this);
                                    }
                                    this.f9706c.mState = 3;
                                    break;
                                case 4:
                                    v();
                                    break;
                                case 5:
                                    fragment.mState = 5;
                                    break;
                                case 6:
                                    n();
                                    break;
                            }
                        } else {
                            switch (i11 + 1) {
                                case 0:
                                    c();
                                    break;
                                case 1:
                                    e();
                                    break;
                                case 2:
                                    j();
                                    f();
                                    break;
                                case 3:
                                    a();
                                    break;
                                case 4:
                                    if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                        SpecialEffectsController.r(viewGroup3, fragment.getParentFragmentManager()).f(SpecialEffectsController.Operation.State.from(this.f9706c.mView.getVisibility()), this);
                                    }
                                    this.f9706c.mState = 4;
                                    break;
                                case 5:
                                    u();
                                    break;
                                case 6:
                                    fragment.mState = 6;
                                    break;
                                case 7:
                                    p();
                                    break;
                            }
                        }
                        z11 = true;
                    } else {
                        if (!z11 && i11 == -1 && fragment.mRemoving && !fragment.isInBackStack() && !this.f9706c.mBeingSaved) {
                            if (FragmentManager.P0(3)) {
                                Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f9706c);
                            }
                            this.f9705b.p().c(this.f9706c, true);
                            this.f9705b.s(this);
                            if (FragmentManager.P0(3)) {
                                Log.d("FragmentManager", "initState called for fragment: " + this.f9706c);
                            }
                            this.f9706c.initState();
                        }
                        Fragment fragment4 = this.f9706c;
                        if (fragment4.mHiddenChanged) {
                            if (!(fragment4.mView == null || (viewGroup = fragment4.mContainer) == null)) {
                                SpecialEffectsController r11 = SpecialEffectsController.r(viewGroup, fragment4.getParentFragmentManager());
                                if (this.f9706c.mHidden) {
                                    r11.g(this);
                                } else {
                                    r11.i(this);
                                }
                            }
                            Fragment fragment5 = this.f9706c;
                            FragmentManager fragmentManager = fragment5.mFragmentManager;
                            if (fragmentManager != null) {
                                fragmentManager.N0(fragment5);
                            }
                            Fragment fragment6 = this.f9706c;
                            fragment6.mHiddenChanged = false;
                            fragment6.onHiddenChanged(fragment6.mHidden);
                            this.f9706c.mChildFragmentManager.M();
                        }
                        this.f9707d = false;
                        return;
                    }
                }
            } catch (Throwable th2) {
                this.f9707d = false;
                throw th2;
            }
        } else if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
        }
    }

    public void n() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f9706c);
        }
        this.f9706c.performPause();
        this.f9704a.f(this.f9706c, false);
    }

    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f9706c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            if (this.f9706c.mSavedFragmentState.getBundle("savedInstanceState") == null) {
                this.f9706c.mSavedFragmentState.putBundle("savedInstanceState", new Bundle());
            }
            Fragment fragment = this.f9706c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("viewState");
            Fragment fragment2 = this.f9706c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("viewRegistryState");
            FragmentState fragmentState = (FragmentState) this.f9706c.mSavedFragmentState.getParcelable("state");
            if (fragmentState != null) {
                Fragment fragment3 = this.f9706c;
                fragment3.mTargetWho = fragmentState.mTargetWho;
                fragment3.mTargetRequestCode = fragmentState.mTargetRequestCode;
                Boolean bool = fragment3.mSavedUserVisibleHint;
                if (bool != null) {
                    fragment3.mUserVisibleHint = bool.booleanValue();
                    this.f9706c.mSavedUserVisibleHint = null;
                } else {
                    fragment3.mUserVisibleHint = fragmentState.mUserVisibleHint;
                }
            }
            Fragment fragment4 = this.f9706c;
            if (!fragment4.mUserVisibleHint) {
                fragment4.mDeferStart = true;
            }
        }
    }

    public void p() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f9706c);
        }
        View focusedView = this.f9706c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean requestFocus = focusedView.requestFocus();
            if (FragmentManager.P0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : LoanOrderItem.FAILED);
                sb2.append(" on Fragment ");
                sb2.append(this.f9706c);
                sb2.append(" resulting in focused view ");
                sb2.append(this.f9706c.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        this.f9706c.setFocusedView((View) null);
        this.f9706c.performResume();
        this.f9704a.i(this.f9706c, false);
        this.f9705b.B(this.f9706c.mWho, (Bundle) null);
        Fragment fragment = this.f9706c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public Fragment.SavedState q() {
        if (this.f9706c.mState > -1) {
            return new Fragment.SavedState(r());
        }
        return null;
    }

    public Bundle r() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        Fragment fragment = this.f9706c;
        if (fragment.mState == -1 && (bundle = fragment.mSavedFragmentState) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new FragmentState(this.f9706c));
        if (this.f9706c.mState > -1) {
            Bundle bundle3 = new Bundle();
            this.f9706c.performSaveInstanceState(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f9704a.j(this.f9706c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f9706c.mSavedStateRegistryController.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle A1 = this.f9706c.mChildFragmentManager.X0();
            if (!A1.isEmpty()) {
                bundle2.putBundle("childFragmentManager", A1);
            }
            if (this.f9706c.mView != null) {
                s();
            }
            SparseArray<Parcelable> sparseArray = this.f9706c.mSavedViewState;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f9706c.mSavedViewRegistryState;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f9706c.mArguments;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    public void s() {
        if (this.f9706c.mView != null) {
            if (FragmentManager.P0(2)) {
                Log.v("FragmentManager", "Saving view state for fragment " + this.f9706c + " with view " + this.f9706c.mView);
            }
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f9706c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.f9706c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.f9706c.mViewLifecycleOwner.e(bundle);
            if (!bundle.isEmpty()) {
                this.f9706c.mSavedViewRegistryState = bundle;
            }
        }
    }

    public void t(int i11) {
        this.f9708e = i11;
    }

    public void u() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f9706c);
        }
        this.f9706c.performStart();
        this.f9704a.k(this.f9706c, false);
    }

    public void v() {
        if (FragmentManager.P0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f9706c);
        }
        this.f9706c.performStop();
        this.f9704a.l(this.f9706c, false);
    }

    public d0(r rVar, f0 f0Var, ClassLoader classLoader, FragmentFactory fragmentFactory, Bundle bundle) {
        this.f9704a = rVar;
        this.f9705b = f0Var;
        Fragment instantiate = ((FragmentState) bundle.getParcelable("state")).instantiate(fragmentFactory, classLoader);
        this.f9706c = instantiate;
        instantiate.mSavedFragmentState = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle2);
        if (FragmentManager.P0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public d0(r rVar, f0 f0Var, Fragment fragment, Bundle bundle) {
        this.f9704a = rVar;
        this.f9705b = f0Var;
        this.f9706c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        fragment.mSavedFragmentState = bundle;
        fragment.mArguments = bundle.getBundle("arguments");
    }
}
