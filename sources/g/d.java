package g;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class d implements Window.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final Window.Callback f15782b;

    public static class a {
        public static boolean a(Window.Callback callback, SearchEvent searchEvent) {
            return callback.onSearchRequested(searchEvent);
        }

        public static ActionMode b(Window.Callback callback, ActionMode.Callback callback2, int i11) {
            return callback.onWindowStartingActionMode(callback2, i11);
        }
    }

    public static class b {
        public static void a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i11) {
            callback.onProvideKeyboardShortcuts(list, menu, i11);
        }
    }

    public static class c {
        public static void a(Window.Callback callback, boolean z11) {
            callback.onPointerCaptureChanged(z11);
        }
    }

    public d(Window.Callback callback) {
        if (callback != null) {
            this.f15782b = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f15782b;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f15782b.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f15782b.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f15782b.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f15782b.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f15782b.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f15782b.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f15782b.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f15782b.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f15782b.onAttachedToWindow();
    }

    public boolean onCreatePanelMenu(int i11, Menu menu) {
        return this.f15782b.onCreatePanelMenu(i11, menu);
    }

    public View onCreatePanelView(int i11) {
        return this.f15782b.onCreatePanelView(i11);
    }

    public void onDetachedFromWindow() {
        this.f15782b.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i11, MenuItem menuItem) {
        return this.f15782b.onMenuItemSelected(i11, menuItem);
    }

    public boolean onMenuOpened(int i11, Menu menu) {
        return this.f15782b.onMenuOpened(i11, menu);
    }

    public void onPanelClosed(int i11, Menu menu) {
        this.f15782b.onPanelClosed(i11, menu);
    }

    public void onPointerCaptureChanged(boolean z11) {
        c.a(this.f15782b, z11);
    }

    public boolean onPreparePanel(int i11, View view, Menu menu) {
        return this.f15782b.onPreparePanel(i11, view, menu);
    }

    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i11) {
        b.a(this.f15782b, list, menu, i11);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return a.a(this.f15782b, searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f15782b.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z11) {
        this.f15782b.onWindowFocusChanged(z11);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f15782b.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.f15782b.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i11) {
        return a.b(this.f15782b, callback, i11);
    }
}
