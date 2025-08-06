package h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import v0.a;

public class d extends b implements Menu {

    /* renamed from: d  reason: collision with root package name */
    public final a f15865d;

    public d(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f15865d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public MenuItem add(CharSequence charSequence) {
        return c(this.f15865d.add(charSequence));
    }

    public int addIntentOptions(int i11, int i12, int i13, ComponentName componentName, Intent[] intentArr, Intent intent, int i14, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = this.f15865d.addIntentOptions(i11, i12, i13, componentName, intentArr, intent, i14, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i15 = 0; i15 < length; i15++) {
                menuItemArr2[i15] = c(menuItemArr3[i15]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f15865d.addSubMenu(charSequence));
    }

    public void clear() {
        e();
        this.f15865d.clear();
    }

    public void close() {
        this.f15865d.close();
    }

    public MenuItem findItem(int i11) {
        return c(this.f15865d.findItem(i11));
    }

    public MenuItem getItem(int i11) {
        return c(this.f15865d.getItem(i11));
    }

    public boolean hasVisibleItems() {
        return this.f15865d.hasVisibleItems();
    }

    public boolean isShortcutKey(int i11, KeyEvent keyEvent) {
        return this.f15865d.isShortcutKey(i11, keyEvent);
    }

    public boolean performIdentifierAction(int i11, int i12) {
        return this.f15865d.performIdentifierAction(i11, i12);
    }

    public boolean performShortcut(int i11, KeyEvent keyEvent, int i12) {
        return this.f15865d.performShortcut(i11, keyEvent, i12);
    }

    public void removeGroup(int i11) {
        f(i11);
        this.f15865d.removeGroup(i11);
    }

    public void removeItem(int i11) {
        g(i11);
        this.f15865d.removeItem(i11);
    }

    public void setGroupCheckable(int i11, boolean z11, boolean z12) {
        this.f15865d.setGroupCheckable(i11, z11, z12);
    }

    public void setGroupEnabled(int i11, boolean z11) {
        this.f15865d.setGroupEnabled(i11, z11);
    }

    public void setGroupVisible(int i11, boolean z11) {
        this.f15865d.setGroupVisible(i11, z11);
    }

    public void setQwertyMode(boolean z11) {
        this.f15865d.setQwertyMode(z11);
    }

    public int size() {
        return this.f15865d.size();
    }

    public MenuItem add(int i11) {
        return c(this.f15865d.add(i11));
    }

    public SubMenu addSubMenu(int i11) {
        return d(this.f15865d.addSubMenu(i11));
    }

    public MenuItem add(int i11, int i12, int i13, CharSequence charSequence) {
        return c(this.f15865d.add(i11, i12, i13, charSequence));
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, CharSequence charSequence) {
        return d(this.f15865d.addSubMenu(i11, i12, i13, charSequence));
    }

    public MenuItem add(int i11, int i12, int i13, int i14) {
        return c(this.f15865d.add(i11, i12, i13, i14));
    }

    public SubMenu addSubMenu(int i11, int i12, int i13, int i14) {
        return d(this.f15865d.addSubMenu(i11, i12, i13, i14));
    }
}
