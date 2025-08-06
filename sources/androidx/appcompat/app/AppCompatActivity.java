package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.w;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n0;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.d;
import p0.j;

public class AppCompatActivity extends FragmentActivity implements a, TaskStackBuilder.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public class a implements SavedStateRegistry.c {
        public a() {
        }

        public Bundle saveState() {
            Bundle bundle = new Bundle();
            AppCompatActivity.this.getDelegate().C(bundle);
            return bundle;
        }
    }

    public class b implements OnContextAvailableListener {
        public b() {
        }

        public void a(Context context) {
            AppCompatDelegate delegate = AppCompatActivity.this.getDelegate();
            delegate.t();
            delegate.y(AppCompatActivity.this.getSavedStateRegistry().b(AppCompatActivity.DELEGATE_TAG));
        }
    }

    public AppCompatActivity() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().h(DELEGATE_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private void initViewTreeOwners() {
        r0.a(getWindow().getDecorView(), this);
        s0.a(getWindow().getDecorView(), this);
        d.a(getWindow().getDecorView(), this);
        w.a(getWindow().getDecorView(), this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r0 = getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean performMenuItemShortcut(android.view.KeyEvent r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x003e
            boolean r0 = r3.isCtrlPressed()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getMetaState()
            boolean r0 = android.view.KeyEvent.metaStateHasNoModifiers(r0)
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getRepeatCount()
            if (r0 != 0) goto L_0x003e
            int r0 = r3.getKeyCode()
            boolean r0 = android.view.KeyEvent.isModifierKey(r0)
            if (r0 != 0) goto L_0x003e
            android.view.Window r0 = r2.getWindow()
            if (r0 == 0) goto L_0x003e
            android.view.View r1 = r0.getDecorView()
            if (r1 == 0) goto L_0x003e
            android.view.View r0 = r0.getDecorView()
            boolean r3 = r0.dispatchKeyShortcutEvent(r3)
            if (r3 == 0) goto L_0x003e
            r3 = 1
            return r3
        L_0x003e:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatActivity.performMenuItemShortcut(android.view.KeyEvent):boolean");
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().c(view, layoutParams);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().g(context));
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.onMenuKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i11) {
        return getDelegate().j(i11);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.h(this, this);
        }
        return this.mDelegate;
    }

    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        return getDelegate().n();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().q();
    }

    public Resources getResources() {
        if (this.mResources == null && n0.d()) {
            this.mResources = new n0(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().s();
    }

    public Intent getSupportParentActivityIntent() {
        return j.a(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().u();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().x(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.c(this);
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().z();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onLocalesChanged(LocaleListCompat localeListCompat) {
    }

    public final boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        if (super.onMenuItemSelected(i11, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i11, Menu menu) {
        return super.onMenuOpened(i11, menu);
    }

    public void onNightModeChanged(int i11) {
    }

    public void onPanelClosed(int i11, Menu menu) {
        super.onPanelClosed(i11, menu);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().A(bundle);
    }

    public void onPostResume() {
        super.onPostResume();
        getDelegate().B();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    public void onStart() {
        super.onStart();
        getDelegate().D();
    }

    public void onStop() {
        super.onStop();
        getDelegate().E();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            TaskStackBuilder e11 = TaskStackBuilder.e(this);
            onCreateSupportNavigateUpTaskStack(e11);
            onPrepareSupportNavigateUpTaskStack(e11);
            e11.g();
            try {
                ActivityCompat.finishAffinity(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    public void onTitleChanged(CharSequence charSequence, int i11) {
        super.onTitleChanged(charSequence, i11);
        getDelegate().Q(charSequence);
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i11) {
        initViewTreeOwners();
        getDelegate().J(i11);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().O(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i11) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z11) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z11) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z11) {
    }

    public void setTheme(int i11) {
        super.setTheme(i11);
        getDelegate().P(i11);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return getDelegate().R(callback);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().u();
    }

    public void supportNavigateUpTo(Intent intent) {
        j.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i11) {
        return getDelegate().H(i11);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return j.f(this, intent);
    }

    public AppCompatActivity(int i11) {
        super(i11);
        initDelegate();
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().K(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().L(view, layoutParams);
    }
}
