package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.q;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.h0;
import androidx.core.view.n0;
import androidx.core.view.o0;
import androidx.core.view.p0;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.d {
    private static final long FADE_IN_DURATION_MS = 200;
    private static final long FADE_OUT_DURATION_MS = 100;
    private static final int INVALID_POSITION = -1;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator = new AccelerateInterpolator();
    private static final Interpolator sShowInterpolator = new DecelerateInterpolator();
    public d mActionMode;
    private Activity mActivity;
    public ActionBarContainer mContainerView;
    public boolean mContentAnimations = true;
    public View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    private int mCurWindowVisibility = 0;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public q mDecorToolbar;
    public ActionMode mDeferredDestroyActionMode;
    public ActionMode.Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    public boolean mHiddenByApp;
    public boolean mHiddenBySystem;
    public final o0 mHideListener = new a();
    public boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList<ActionBar.a> mMenuVisibilityListeners = new ArrayList<>();
    private boolean mNowShowing = true;
    public ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition = -1;
    private e mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    public final o0 mShowListener = new b();
    private boolean mShowingForMode;
    public ScrollingTabContainerView mTabScrollView;
    private ArrayList<e> mTabs = new ArrayList<>();
    private Context mThemedContext;
    public final p0 mUpdateListener = new c();

    public class a extends ViewPropertyAnimatorListenerAdapter {
        public a() {
        }

        public void b(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mContentAnimations && (view2 = windowDecorActionBar.mContentView) != null) {
                view2.setTranslationY(0.0f);
                WindowDecorActionBar.this.mContainerView.setTranslationY(0.0f);
            }
            WindowDecorActionBar.this.mContainerView.setVisibility(8);
            WindowDecorActionBar.this.mContainerView.setTransitioning(false);
            WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
            windowDecorActionBar2.mCurrentShowAnim = null;
            windowDecorActionBar2.completeDeferredDestroyActionMode();
            ActionBarOverlayLayout actionBarOverlayLayout = WindowDecorActionBar.this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                h0.u0(actionBarOverlayLayout);
            }
        }
    }

    public class b extends ViewPropertyAnimatorListenerAdapter {
        public b() {
        }

        public void b(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.mCurrentShowAnim = null;
            windowDecorActionBar.mContainerView.requestLayout();
        }
    }

    public class c implements p0 {
        public c() {
        }

        public void a(View view) {
            ((View) WindowDecorActionBar.this.mContainerView.getParent()).invalidate();
        }
    }

    public class d extends ActionMode implements e.a {

        /* renamed from: d  reason: collision with root package name */
        public final Context f3912d;

        /* renamed from: e  reason: collision with root package name */
        public final androidx.appcompat.view.menu.e f3913e;

        /* renamed from: f  reason: collision with root package name */
        public ActionMode.Callback f3914f;

        /* renamed from: g  reason: collision with root package name */
        public WeakReference<View> f3915g;

        public d(Context context, ActionMode.Callback callback) {
            this.f3912d = context;
            this.f3914f = callback;
            androidx.appcompat.view.menu.e defaultShowAsAction = new androidx.appcompat.view.menu.e(context).setDefaultShowAsAction(1);
            this.f3913e = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public void a() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode == this) {
                if (!WindowDecorActionBar.checkShowingFlags(windowDecorActionBar.mHiddenByApp, windowDecorActionBar.mHiddenBySystem, false)) {
                    WindowDecorActionBar windowDecorActionBar2 = WindowDecorActionBar.this;
                    windowDecorActionBar2.mDeferredDestroyActionMode = this;
                    windowDecorActionBar2.mDeferredModeDestroyCallback = this.f3914f;
                } else {
                    this.f3914f.d(this);
                }
                this.f3914f = null;
                WindowDecorActionBar.this.animateToMode(false);
                WindowDecorActionBar.this.mContextView.g();
                WindowDecorActionBar windowDecorActionBar3 = WindowDecorActionBar.this;
                windowDecorActionBar3.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar3.mHideOnContentScroll);
                WindowDecorActionBar.this.mActionMode = null;
            }
        }

        public View b() {
            WeakReference<View> weakReference = this.f3915g;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        public Menu c() {
            return this.f3913e;
        }

        public MenuInflater d() {
            return new g.c(this.f3912d);
        }

        public CharSequence e() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        public CharSequence g() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        public void i() {
            if (WindowDecorActionBar.this.mActionMode == this) {
                this.f3913e.stopDispatchingItemsChanged();
                try {
                    this.f3914f.c(this, this.f3913e);
                } finally {
                    this.f3913e.startDispatchingItemsChanged();
                }
            }
        }

        public boolean j() {
            return WindowDecorActionBar.this.mContextView.j();
        }

        public void k(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.f3915g = new WeakReference<>(view);
        }

        public void l(int i11) {
            m(WindowDecorActionBar.this.mContext.getResources().getString(i11));
        }

        public void m(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        public void o(int i11) {
            p(WindowDecorActionBar.this.mContext.getResources().getString(i11));
        }

        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            ActionMode.Callback callback = this.f3914f;
            if (callback != null) {
                return callback.b(this, menuItem);
            }
            return false;
        }

        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            if (this.f3914f != null) {
                i();
                WindowDecorActionBar.this.mContextView.l();
            }
        }

        public void p(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        public void q(boolean z11) {
            super.q(z11);
            WindowDecorActionBar.this.mContextView.setTitleOptional(z11);
        }

        public boolean r() {
            this.f3913e.stopDispatchingItemsChanged();
            try {
                return this.f3914f.a(this, this.f3913e);
            } finally {
                this.f3913e.startDispatchingItemsChanged();
            }
        }
    }

    public class e extends ActionBar.Tab {

        /* renamed from: a  reason: collision with root package name */
        public ActionBar.c f3917a;

        /* renamed from: b  reason: collision with root package name */
        public Drawable f3918b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f3919c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f3920d;

        /* renamed from: e  reason: collision with root package name */
        public int f3921e = -1;

        /* renamed from: f  reason: collision with root package name */
        public View f3922f;

        public e() {
        }

        public CharSequence a() {
            return this.f3920d;
        }

        public View b() {
            return this.f3922f;
        }

        public Drawable c() {
            return this.f3918b;
        }

        public int d() {
            return this.f3921e;
        }

        public CharSequence e() {
            return this.f3919c;
        }

        public void f() {
            WindowDecorActionBar.this.selectTab(this);
        }

        public ActionBar.c g() {
            return this.f3917a;
        }

        public void h(int i11) {
            this.f3921e = i11;
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z11) {
        this.mActivity = activity;
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z11) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    public static boolean checkShowingFlags(boolean z11, boolean z12, boolean z13) {
        if (z13) {
            return true;
        }
        return !z11 && !z12;
    }

    private void cleanupTabs() {
        if (this.mSelectedTab != null) {
            selectTab((ActionBar.Tab) null);
        }
        this.mTabs.clear();
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            scrollingTabContainerView.j();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar.Tab tab, int i11) {
        e eVar = (e) tab;
        if (eVar.g() != null) {
            eVar.h(i11);
            this.mTabs.add(i11, eVar);
            int size = this.mTabs.size();
            while (true) {
                i11++;
                if (i11 < size) {
                    this.mTabs.get(i11).h(i11);
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Action Bar Tab must have a Callback");
        }
    }

    private void ensureTabsExist() {
        if (this.mTabScrollView == null) {
            ScrollingTabContainerView scrollingTabContainerView = new ScrollingTabContainerView(this.mContext);
            if (this.mHasEmbeddedTabs) {
                scrollingTabContainerView.setVisibility(0);
                this.mDecorToolbar.G(scrollingTabContainerView);
            } else {
                if (getNavigationMode() == 2) {
                    scrollingTabContainerView.setVisibility(0);
                    ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        h0.u0(actionBarOverlayLayout);
                    }
                } else {
                    scrollingTabContainerView.setVisibility(8);
                }
                this.mContainerView.setTabContainer(scrollingTabContainerView);
            }
            this.mTabScrollView = scrollingTabContainerView;
        }
    }

    private q getDecorToolbar(View view) {
        if (view instanceof q) {
            return (q) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != null ? view.getClass().getSimpleName() : OptionsBridge.NULL_VALUE);
        throw new IllegalStateException(sb2.toString());
    }

    private void hideForActionMode() {
        if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
    }

    private void init(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.mDecorToolbar = getDecorToolbar(view.findViewById(R$id.action_bar));
        this.mContextView = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.mContainerView = actionBarContainer;
        q qVar = this.mDecorToolbar;
        if (qVar == null || this.mContextView == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.mContext = qVar.getContext();
        boolean z11 = (this.mDecorToolbar.v() & 4) != 0;
        if (z11) {
            this.mDisplayHomeAsUpSet = true;
        }
        g.a b11 = g.a.b(this.mContext);
        setHomeButtonEnabled(b11.a() || z11);
        setHasEmbeddedTabs(b11.g());
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes((AttributeSet) null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void setHasEmbeddedTabs(boolean z11) {
        this.mHasEmbeddedTabs = z11;
        if (!z11) {
            this.mDecorToolbar.G((ScrollingTabContainerView) null);
            this.mContainerView.setTabContainer(this.mTabScrollView);
        } else {
            this.mContainerView.setTabContainer((ScrollingTabContainerView) null);
            this.mDecorToolbar.G(this.mTabScrollView);
        }
        boolean z12 = true;
        boolean z13 = getNavigationMode() == 2;
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            if (z13) {
                scrollingTabContainerView.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    h0.u0(actionBarOverlayLayout);
                }
            } else {
                scrollingTabContainerView.setVisibility(8);
            }
        }
        this.mDecorToolbar.r(!this.mHasEmbeddedTabs && z13);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
        if (this.mHasEmbeddedTabs || !z13) {
            z12 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z12);
    }

    private boolean shouldAnimateContextView() {
        return h0.a0(this.mContainerView);
    }

    private void showForActionMode() {
        if (!this.mShowingForMode) {
            this.mShowingForMode = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            updateVisibility(false);
        }
    }

    private void updateVisibility(boolean z11) {
        if (checkShowingFlags(this.mHiddenByApp, this.mHiddenBySystem, this.mShowingForMode)) {
            if (!this.mNowShowing) {
                this.mNowShowing = true;
                doShow(z11);
            }
        } else if (this.mNowShowing) {
            this.mNowShowing = false;
            doHide(z11);
        }
    }

    public void addOnMenuVisibilityListener(ActionBar.a aVar) {
        this.mMenuVisibilityListeners.add(aVar);
    }

    public void addTab(ActionBar.Tab tab) {
        addTab(tab, this.mTabs.isEmpty());
    }

    public void animateToMode(boolean z11) {
        n0 n0Var;
        n0 n0Var2;
        if (z11) {
            showForActionMode();
        } else {
            hideForActionMode();
        }
        if (shouldAnimateContextView()) {
            if (z11) {
                n0Var = this.mDecorToolbar.C(4, 100);
                n0Var2 = this.mContextView.f(0, 200);
            } else {
                n0Var2 = this.mDecorToolbar.C(0, 200);
                n0Var = this.mContextView.f(8, 100);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.d(n0Var, n0Var2);
            viewPropertyAnimatorCompatSet.h();
        } else if (z11) {
            this.mDecorToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    public boolean collapseActionView() {
        q qVar = this.mDecorToolbar;
        if (qVar == null || !qVar.h()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
    }

    public void completeDeferredDestroyActionMode() {
        ActionMode.Callback callback = this.mDeferredModeDestroyCallback;
        if (callback != null) {
            callback.d(this.mDeferredDestroyActionMode);
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean z11) {
        if (z11 != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z11;
            int size = this.mMenuVisibilityListeners.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.mMenuVisibilityListeners.get(i11).a(z11);
            }
        }
    }

    public void doHide(boolean z11) {
        View view;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z11)) {
            this.mHideListener.b((View) null);
            return;
        }
        this.mContainerView.setAlpha(1.0f);
        this.mContainerView.setTransitioning(true);
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
        float f11 = (float) (-this.mContainerView.getHeight());
        if (z11) {
            int[] iArr = {0, 0};
            this.mContainerView.getLocationInWindow(iArr);
            f11 -= (float) iArr[1];
        }
        n0 o11 = h0.e(this.mContainerView).o(f11);
        o11.m(this.mUpdateListener);
        viewPropertyAnimatorCompatSet2.c(o11);
        if (this.mContentAnimations && (view = this.mContentView) != null) {
            viewPropertyAnimatorCompatSet2.c(h0.e(view).o(f11));
        }
        viewPropertyAnimatorCompatSet2.f(sHideInterpolator);
        viewPropertyAnimatorCompatSet2.e(250);
        viewPropertyAnimatorCompatSet2.g(this.mHideListener);
        this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
        viewPropertyAnimatorCompatSet2.h();
    }

    public void doShow(boolean z11) {
        View view;
        View view2;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
        }
        this.mContainerView.setVisibility(0);
        if (this.mCurWindowVisibility != 0 || (!this.mShowHideAnimationEnabled && !z11)) {
            this.mContainerView.setAlpha(1.0f);
            this.mContainerView.setTranslationY(0.0f);
            if (this.mContentAnimations && (view = this.mContentView) != null) {
                view.setTranslationY(0.0f);
            }
            this.mShowListener.b((View) null);
        } else {
            this.mContainerView.setTranslationY(0.0f);
            float f11 = (float) (-this.mContainerView.getHeight());
            if (z11) {
                int[] iArr = {0, 0};
                this.mContainerView.getLocationInWindow(iArr);
                f11 -= (float) iArr[1];
            }
            this.mContainerView.setTranslationY(f11);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
            n0 o11 = h0.e(this.mContainerView).o(0.0f);
            o11.m(this.mUpdateListener);
            viewPropertyAnimatorCompatSet2.c(o11);
            if (this.mContentAnimations && (view2 = this.mContentView) != null) {
                view2.setTranslationY(f11);
                viewPropertyAnimatorCompatSet2.c(h0.e(this.mContentView).o(0.0f));
            }
            viewPropertyAnimatorCompatSet2.f(sShowInterpolator);
            viewPropertyAnimatorCompatSet2.e(250);
            viewPropertyAnimatorCompatSet2.g(this.mShowListener);
            this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
            viewPropertyAnimatorCompatSet2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
        if (actionBarOverlayLayout != null) {
            h0.u0(actionBarOverlayLayout);
        }
    }

    public void enableContentAnimations(boolean z11) {
        this.mContentAnimations = z11;
    }

    public View getCustomView() {
        return this.mDecorToolbar.t();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.v();
    }

    public float getElevation() {
        return h0.z(this.mContainerView);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int l11 = this.mDecorToolbar.l();
        if (l11 == 1) {
            return this.mDecorToolbar.q();
        }
        if (l11 != 2) {
            return 0;
        }
        return this.mTabs.size();
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.l();
    }

    public int getSelectedNavigationIndex() {
        e eVar;
        int l11 = this.mDecorToolbar.l();
        if (l11 == 1) {
            return this.mDecorToolbar.n();
        }
        if (l11 == 2 && (eVar = this.mSelectedTab) != null) {
            return eVar.d();
        }
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.M();
    }

    public ActionBar.Tab getTabAt(int i11) {
        return this.mTabs.get(i11);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i11 = typedValue.resourceId;
            if (i11 != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i11);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.D();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.L();
    }

    public void hide() {
        if (!this.mHiddenByApp) {
            this.mHiddenByApp = true;
            updateVisibility(false);
        }
    }

    public void hideForSystem() {
        if (!this.mHiddenBySystem) {
            this.mHiddenBySystem = true;
            updateVisibility(true);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.q();
    }

    public boolean isShowing() {
        int height = getHeight();
        return this.mNowShowing && (height == 0 || getHideOffset() < height);
    }

    public boolean isTitleTruncated() {
        q qVar = this.mDecorToolbar;
        return qVar != null && qVar.i();
    }

    public ActionBar.Tab newTab() {
        return new e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        setHasEmbeddedTabs(g.a.b(this.mContext).g());
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.mCurrentShowAnim = null;
        }
    }

    public void onContentScrollStopped() {
    }

    public boolean onKeyShortcut(int i11, KeyEvent keyEvent) {
        Menu c11;
        d dVar = this.mActionMode;
        if (dVar == null || (c11 = dVar.c()) == null) {
            return false;
        }
        boolean z11 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z11 = false;
        }
        c11.setQwertyMode(z11);
        return c11.performShortcut(i11, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int i11) {
        this.mCurWindowVisibility = i11;
    }

    public void removeAllTabs() {
        cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar.a aVar) {
        this.mMenuVisibilityListeners.remove(aVar);
    }

    public void removeTab(ActionBar.Tab tab) {
        removeTabAt(tab.d());
    }

    public void removeTabAt(int i11) {
        if (this.mTabScrollView != null) {
            e eVar = this.mSelectedTab;
            int d11 = eVar != null ? eVar.d() : this.mSavedTabPosition;
            this.mTabScrollView.k(i11);
            e remove = this.mTabs.remove(i11);
            if (remove != null) {
                remove.h(-1);
            }
            int size = this.mTabs.size();
            for (int i12 = i11; i12 < size; i12++) {
                this.mTabs.get(i12).h(i12);
            }
            if (d11 == i11) {
                selectTab(this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i11 - 1)));
            }
        }
    }

    public boolean requestFocus() {
        ViewGroup E = this.mDecorToolbar.E();
        if (E == null || E.hasFocus()) {
            return false;
        }
        E.requestFocus();
        return true;
    }

    public void selectTab(ActionBar.Tab tab) {
        int i11 = -1;
        if (getNavigationMode() != 2) {
            if (tab != null) {
                i11 = tab.d();
            }
            this.mSavedTabPosition = i11;
            return;
        }
        FragmentTransaction o11 = (!(this.mActivity instanceof FragmentActivity) || this.mDecorToolbar.E().isInEditMode()) ? null : ((FragmentActivity) this.mActivity).getSupportFragmentManager().q().o();
        e eVar = this.mSelectedTab;
        if (eVar != tab) {
            ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
            if (tab != null) {
                i11 = tab.d();
            }
            scrollingTabContainerView.setTabSelected(i11);
            e eVar2 = this.mSelectedTab;
            if (eVar2 != null) {
                eVar2.g().c(this.mSelectedTab, o11);
            }
            e eVar3 = (e) tab;
            this.mSelectedTab = eVar3;
            if (eVar3 != null) {
                eVar3.g().a(this.mSelectedTab, o11);
            }
        } else if (eVar != null) {
            eVar.g().b(this.mSelectedTab, o11);
            this.mTabScrollView.c(tab.d());
        }
        if (o11 != null && !o11.r()) {
            o11.j();
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setPrimaryBackground(drawable);
    }

    public void setCustomView(int i11) {
        setCustomView(LayoutInflater.from(getThemedContext()).inflate(i11, this.mDecorToolbar.E(), false));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z11) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z11);
        }
    }

    public void setDisplayHomeAsUpEnabled(boolean z11) {
        setDisplayOptions(z11 ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i11) {
        if ((i11 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.j(i11);
    }

    public void setDisplayShowCustomEnabled(boolean z11) {
        setDisplayOptions(z11 ? 16 : 0, 16);
    }

    public void setDisplayShowHomeEnabled(boolean z11) {
        setDisplayOptions(z11 ? 2 : 0, 2);
    }

    public void setDisplayShowTitleEnabled(boolean z11) {
        setDisplayOptions(z11 ? 8 : 0, 8);
    }

    public void setDisplayUseLogoEnabled(boolean z11) {
        setDisplayOptions(z11 ? 1 : 0, 1);
    }

    public void setElevation(float f11) {
        h0.F0(this.mContainerView, f11);
    }

    public void setHideOffset(int i11) {
        if (i11 == 0 || this.mOverlayLayout.r()) {
            this.mOverlayLayout.setActionBarHideOffset(i11);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
    }

    public void setHideOnContentScrollEnabled(boolean z11) {
        if (!z11 || this.mOverlayLayout.r()) {
            this.mHideOnContentScroll = z11;
            this.mOverlayLayout.setHideOnContentScrollEnabled(z11);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.k(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.y(drawable);
    }

    public void setHomeButtonEnabled(boolean z11) {
        this.mDecorToolbar.F(z11);
    }

    public void setIcon(int i11) {
        this.mDecorToolbar.setIcon(i11);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar.b bVar) {
        this.mDecorToolbar.K(spinnerAdapter, new j(bVar));
    }

    public void setLogo(int i11) {
        this.mDecorToolbar.H(i11);
    }

    public void setNavigationMode(int i11) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        int l11 = this.mDecorToolbar.l();
        if (l11 == 2) {
            this.mSavedTabPosition = getSelectedNavigationIndex();
            selectTab((ActionBar.Tab) null);
            this.mTabScrollView.setVisibility(8);
        }
        if (!(l11 == i11 || this.mHasEmbeddedTabs || (actionBarOverlayLayout = this.mOverlayLayout) == null)) {
            h0.u0(actionBarOverlayLayout);
        }
        this.mDecorToolbar.m(i11);
        boolean z11 = false;
        if (i11 == 2) {
            ensureTabsExist();
            this.mTabScrollView.setVisibility(0);
            int i12 = this.mSavedTabPosition;
            if (i12 != -1) {
                setSelectedNavigationItem(i12);
                this.mSavedTabPosition = -1;
            }
        }
        this.mDecorToolbar.r(i11 == 2 && !this.mHasEmbeddedTabs);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
        if (i11 == 2 && !this.mHasEmbeddedTabs) {
            z11 = true;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z11);
    }

    public void setSelectedNavigationItem(int i11) {
        int l11 = this.mDecorToolbar.l();
        if (l11 == 1) {
            this.mDecorToolbar.A(i11);
        } else if (l11 == 2) {
            selectTab(this.mTabs.get(i11));
        } else {
            throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        }
    }

    public void setShowHideAnimationEnabled(boolean z11) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z11;
        if (!z11 && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.a();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
        this.mContainerView.setStackedBackground(drawable);
    }

    public void setSubtitle(int i11) {
        setSubtitle((CharSequence) this.mContext.getString(i11));
    }

    public void setTitle(int i11) {
        setTitle((CharSequence) this.mContext.getString(i11));
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        if (this.mHiddenByApp) {
            this.mHiddenByApp = false;
            updateVisibility(false);
        }
    }

    public void showForSystem() {
        if (this.mHiddenBySystem) {
            this.mHiddenBySystem = false;
            updateVisibility(true);
        }
    }

    public ActionMode startActionMode(ActionMode.Callback callback) {
        d dVar = this.mActionMode;
        if (dVar != null) {
            dVar.a();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.k();
        d dVar2 = new d(this.mContextView.getContext(), callback);
        if (!dVar2.r()) {
            return null;
        }
        this.mActionMode = dVar2;
        dVar2.i();
        this.mContextView.h(dVar2);
        animateToMode(true);
        return dVar2;
    }

    public void addTab(ActionBar.Tab tab, int i11) {
        addTab(tab, i11, this.mTabs.isEmpty());
    }

    public void setHomeActionContentDescription(int i11) {
        this.mDecorToolbar.o(i11);
    }

    public void setHomeAsUpIndicator(int i11) {
        this.mDecorToolbar.I(i11);
    }

    public void setIcon(Drawable drawable) {
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(Drawable drawable) {
        this.mDecorToolbar.u(drawable);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.z(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void addTab(ActionBar.Tab tab, boolean z11) {
        ensureTabsExist();
        this.mTabScrollView.b(tab, z11);
        configureTab(tab, this.mTabs.size());
        if (z11) {
            selectTab(tab);
        }
    }

    public void setDisplayOptions(int i11, int i12) {
        int v11 = this.mDecorToolbar.v();
        if ((i12 & 4) != 0) {
            this.mDisplayHomeAsUpSet = true;
        }
        this.mDecorToolbar.j((i11 & i12) | ((~i12) & v11));
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.w(view);
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        this.mDecorToolbar.w(view);
    }

    public void addTab(ActionBar.Tab tab, int i11, boolean z11) {
        ensureTabsExist();
        this.mTabScrollView.a(tab, i11, z11);
        configureTab(tab, i11);
        if (z11) {
            selectTab(tab);
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        init(dialog.getWindow().getDecorView());
    }

    public WindowDecorActionBar(View view) {
        init(view);
    }
}
