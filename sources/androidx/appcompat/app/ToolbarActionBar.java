package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.SpinnerAdapter;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.q;
import androidx.core.util.h;
import java.util.ArrayList;

class ToolbarActionBar extends ActionBar {
    public final q mDecorToolbar;
    private boolean mLastMenuVisibility;
    public final AppCompatDelegateImpl.i mMenuCallback;
    private boolean mMenuCallbackSet;
    private final Toolbar.g mMenuClicker;
    private final Runnable mMenuInvalidator = new a();
    private ArrayList<ActionBar.a> mMenuVisibilityListeners = new ArrayList<>();
    public boolean mToolbarMenuPrepared;
    public final Window.Callback mWindowCallback;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ToolbarActionBar.this.populateOptionsMenu();
        }
    }

    public class b implements Toolbar.g {
        public b() {
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem);
        }
    }

    public final class c implements i.a {

        /* renamed from: b  reason: collision with root package name */
        public boolean f3905b;

        public c() {
        }

        public boolean a(androidx.appcompat.view.menu.e eVar) {
            ToolbarActionBar.this.mWindowCallback.onMenuOpened(108, eVar);
            return true;
        }

        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z11) {
            if (!this.f3905b) {
                this.f3905b = true;
                ToolbarActionBar.this.mDecorToolbar.s();
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(108, eVar);
                this.f3905b = false;
            }
        }
    }

    public final class d implements e.a {
        public d() {
        }

        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            if (ToolbarActionBar.this.mDecorToolbar.c()) {
                ToolbarActionBar.this.mWindowCallback.onPanelClosed(108, eVar);
            } else if (ToolbarActionBar.this.mWindowCallback.onPreparePanel(0, (View) null, eVar)) {
                ToolbarActionBar.this.mWindowCallback.onMenuOpened(108, eVar);
            }
        }
    }

    public class e implements AppCompatDelegateImpl.i {
        public e() {
        }

        public boolean a(int i11) {
            if (i11 != 0) {
                return false;
            }
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            if (toolbarActionBar.mToolbarMenuPrepared) {
                return false;
            }
            toolbarActionBar.mDecorToolbar.f();
            ToolbarActionBar.this.mToolbarMenuPrepared = true;
            return false;
        }

        public View onCreatePanelView(int i11) {
            if (i11 == 0) {
                return new View(ToolbarActionBar.this.mDecorToolbar.getContext());
            }
            return null;
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.mMenuClicker = bVar;
        h.g(toolbar);
        h0 h0Var = new h0(toolbar, false);
        this.mDecorToolbar = h0Var;
        this.mWindowCallback = (Window.Callback) h.g(callback);
        h0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        h0Var.setWindowTitle(charSequence);
        this.mMenuCallback = new e();
    }

    private Menu getMenu() {
        if (!this.mMenuCallbackSet) {
            this.mDecorToolbar.J(new c(), new d());
            this.mMenuCallbackSet = true;
        }
        return this.mDecorToolbar.B();
    }

    public void addOnMenuVisibilityListener(ActionBar.a aVar) {
        this.mMenuVisibilityListeners.add(aVar);
    }

    public void addTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public boolean closeOptionsMenu() {
        return this.mDecorToolbar.d();
    }

    public boolean collapseActionView() {
        if (!this.mDecorToolbar.h()) {
            return false;
        }
        this.mDecorToolbar.collapseActionView();
        return true;
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

    public View getCustomView() {
        return this.mDecorToolbar.t();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.v();
    }

    public float getElevation() {
        return androidx.core.view.h0.z(this.mDecorToolbar.E());
    }

    public int getHeight() {
        return this.mDecorToolbar.getHeight();
    }

    public int getNavigationItemCount() {
        return 0;
    }

    public int getNavigationMode() {
        return 0;
    }

    public int getSelectedNavigationIndex() {
        return -1;
    }

    public ActionBar.Tab getSelectedTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.M();
    }

    public ActionBar.Tab getTabAt(int i11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public int getTabCount() {
        return 0;
    }

    public Context getThemedContext() {
        return this.mDecorToolbar.getContext();
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public void hide() {
        this.mDecorToolbar.setVisibility(8);
    }

    public boolean invalidateOptionsMenu() {
        this.mDecorToolbar.E().removeCallbacks(this.mMenuInvalidator);
        androidx.core.view.h0.p0(this.mDecorToolbar.E(), this.mMenuInvalidator);
        return true;
    }

    public boolean isShowing() {
        return this.mDecorToolbar.getVisibility() == 0;
    }

    public boolean isTitleTruncated() {
        return super.isTitleTruncated();
    }

    public ActionBar.Tab newTab() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        this.mDecorToolbar.E().removeCallbacks(this.mMenuInvalidator);
    }

    public boolean onKeyShortcut(int i11, KeyEvent keyEvent) {
        Menu menu = getMenu();
        if (menu == null) {
            return false;
        }
        boolean z11 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z11 = false;
        }
        menu.setQwertyMode(z11);
        return menu.performShortcut(i11, keyEvent, 0);
    }

    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    public boolean openOptionsMenu() {
        return this.mDecorToolbar.b();
    }

    public void populateOptionsMenu() {
        Menu menu = getMenu();
        androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
        if (eVar != null) {
            eVar.stopDispatchingItemsChanged();
        }
        try {
            menu.clear();
            if (!this.mWindowCallback.onCreatePanelMenu(0, menu) || !this.mWindowCallback.onPreparePanel(0, (View) null, menu)) {
                menu.clear();
            }
        } finally {
            if (eVar != null) {
                eVar.startDispatchingItemsChanged();
            }
        }
    }

    public void removeAllTabs() {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeOnMenuVisibilityListener(ActionBar.a aVar) {
        this.mMenuVisibilityListeners.remove(aVar);
    }

    public void removeTab(ActionBar.Tab tab) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void removeTabAt(int i11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
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
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mDecorToolbar.setBackgroundDrawable(drawable);
    }

    public void setCustomView(View view) {
        setCustomView(view, new ActionBar.LayoutParams(-2, -2));
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean z11) {
    }

    public void setDisplayHomeAsUpEnabled(boolean z11) {
        setDisplayOptions(z11 ? 4 : 0, 4);
    }

    @SuppressLint({"WrongConstant"})
    public void setDisplayOptions(int i11) {
        setDisplayOptions(i11, -1);
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
        androidx.core.view.h0.F0(this.mDecorToolbar.E(), f11);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.k(charSequence);
    }

    public void setHomeAsUpIndicator(Drawable drawable) {
        this.mDecorToolbar.y(drawable);
    }

    public void setHomeButtonEnabled(boolean z11) {
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
        if (i11 != 2) {
            this.mDecorToolbar.m(i11);
            return;
        }
        throw new IllegalArgumentException("Tabs not supported in this configuration");
    }

    public void setSelectedNavigationItem(int i11) {
        if (this.mDecorToolbar.l() == 1) {
            this.mDecorToolbar.A(i11);
            return;
        }
        throw new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
    }

    public void setShowHideAnimationEnabled(boolean z11) {
    }

    public void setSplitBackgroundDrawable(Drawable drawable) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable) {
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.z(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        this.mDecorToolbar.setVisibility(0);
    }

    public void addTab(ActionBar.Tab tab, boolean z11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(View view, ActionBar.LayoutParams layoutParams) {
        if (view != null) {
            view.setLayoutParams(layoutParams);
        }
        this.mDecorToolbar.w(view);
    }

    public void setDisplayOptions(int i11, int i12) {
        this.mDecorToolbar.j((i11 & i12) | ((~i12) & this.mDecorToolbar.v()));
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

    public void setSubtitle(int i11) {
        q qVar = this.mDecorToolbar;
        qVar.z(i11 != 0 ? qVar.getContext().getText(i11) : null);
    }

    public void setTitle(int i11) {
        q qVar = this.mDecorToolbar;
        qVar.setTitle(i11 != 0 ? qVar.getContext().getText(i11) : null);
    }

    public void addTab(ActionBar.Tab tab, int i11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void addTab(ActionBar.Tab tab, int i11, boolean z11) {
        throw new UnsupportedOperationException("Tabs are not supported in toolbar action bars");
    }

    public void setCustomView(int i11) {
        setCustomView(LayoutInflater.from(this.mDecorToolbar.getContext()).inflate(i11, this.mDecorToolbar.E(), false));
    }
}
